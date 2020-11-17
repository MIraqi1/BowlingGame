package BowlingGameMI;

public class Game {

    private int score = 0;
    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int firstInFrame = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rolls[firstInFrame])) {

                score += 10 + nextTwoBallsStrike(firstInFrame);
                firstInFrame += 1;
            } else if (isSpare(firstInFrame)) {
                score += 10 + addNextBallForSpare(rolls[firstInFrame + 2]);
                firstInFrame += 2;

            } else {
                score += twoBallsInFrame(firstInFrame);
                firstInFrame += 2;
            }
        }
        return score;

    }

    private int twoBallsInFrame(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1];
    }

    private int addNextBallForSpare(int firstInFrame) {
        return rolls[firstInFrame + 2];
    }

    private boolean isSpare(int firstInFrame) {
        return twoBallsInFrame(firstInFrame) == 10;
    }

    private int nextTwoBallsStrike(int firstInFrame) {
        return rolls[firstInFrame + 1] + rolls[firstInFrame + 2];
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }
}
package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame1(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.playerOneName))
            playerOneScore += 1;
        if(playerName.equals(this.playerTwoName))
            playerTwoScore += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        if (playerOneScore == playerTwoScore) {
            score = getEqualScore();
        } else if (playerOneScore >= 4 || playerTwoScore >= 4) {
            score = getThanFourStore();
        } else {
            score = getOtherScore(score);
        }
        return score.toString();
    }

    private StringBuilder getOtherScore(StringBuilder score) {
        StringBuilder stringBuilder = new StringBuilder(score);
        for (int i = 1; i < 3; i++) {
            int tempScore;
            if (i == 1) tempScore = playerOneScore;
            else {
                stringBuilder.append("-");
                tempScore = playerTwoScore;
            }
            switch (tempScore) {
                case 0:
                    stringBuilder.append("Love");
                    break;
                case 1:
                    stringBuilder.append("Fifteen");
                    break;
                case 2:
                    stringBuilder.append("Thirty");
                    break;
                case 3:
                    stringBuilder.append("Forty");
                    break;
            }
        }
        return stringBuilder;
    }

    private StringBuilder getThanFourStore() {
        StringBuilder score;
        int minusResult = playerOneScore - playerTwoScore;
        if (minusResult == 1) score = new StringBuilder("Advantage player1");
        else if (minusResult == -1) score = new StringBuilder("Advantage player2");
        else if (minusResult >= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score;
    }

    private StringBuilder getEqualScore() {
        StringBuilder score;
        switch (playerOneScore) {
            case 0:
                score = new StringBuilder("Love-All");
                break;
            case 1:
                score = new StringBuilder("Fifteen-All");
                break;
            case 2:
                score = new StringBuilder("Thirty-All");
                break;
            default:
                score = new StringBuilder("Deuce");
                break;

        }
        return score;
    }
}

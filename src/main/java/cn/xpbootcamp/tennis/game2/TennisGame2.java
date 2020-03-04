package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 implements TennisGame {
    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    private String P1res = "";
    private String P2res = "";
    private String playerOneName;
    private String playerTwoName;

    public TennisGame2(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getScore() {
        String score = "";
        if (playerOneScore == playerTwoScore && playerOneScore < 4) {
            if (playerOneScore == 0)
                score = "Love";
            if (playerOneScore == 1)
                score = "Fifteen";
            if (playerOneScore == 2)
                score = "Thirty";
            score += "-All";
        }
        if (playerOneScore == playerTwoScore && playerOneScore >= 3)
            score = "Deuce";

        if (playerOneScore > 0 && playerTwoScore == 0) {
            if (playerOneScore == 1)
                P1res = "Fifteen";
            if (playerOneScore == 2)
                P1res = "Thirty";
            if (playerOneScore == 3)
                P1res = "Forty";

            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (playerTwoScore > 0 && playerOneScore == 0) {
            if (playerTwoScore == 1)
                P2res = "Fifteen";
            if (playerTwoScore == 2)
                P2res = "Thirty";
            if (playerTwoScore == 3)
                P2res = "Forty";

            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (playerOneScore > playerTwoScore && playerOneScore < 4) {
            if (playerOneScore == 2)
                P1res = "Thirty";
            if (playerOneScore == 3)
                P1res = "Forty";
            if (playerTwoScore == 1)
                P2res = "Fifteen";
            if (playerTwoScore == 2)
                P2res = "Thirty";
            score = P1res + "-" + P2res;
        }
        if (playerTwoScore > playerOneScore && playerTwoScore < 4) {
            if (playerTwoScore == 2)
                P2res = "Thirty";
            if (playerTwoScore == 3)
                P2res = "Forty";
            if (playerOneScore == 1)
                P1res = "Fifteen";
            if (playerOneScore == 2)
                P1res = "Thirty";
            score = P1res + "-" + P2res;
        }

        if (playerOneScore > playerTwoScore && playerTwoScore >= 3) {
            score = "Advantage player1";
        }

        if (playerTwoScore > playerOneScore && playerOneScore >= 3) {
            score = "Advantage player2";
        }

        if (playerOneScore >= 4 && playerTwoScore >= 0 && (playerOneScore - playerTwoScore) >= 2) {
            score = "Win for player1";
        }
        if (playerTwoScore >= 4 && playerOneScore >= 0 && (playerTwoScore - playerOneScore) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private void P1Score() {
        playerOneScore++;
    }

    private void P2Score() {
        playerTwoScore++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            P1Score();
        else
            P2Score();
    }
}

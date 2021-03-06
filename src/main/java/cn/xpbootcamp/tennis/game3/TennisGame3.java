package cn.xpbootcamp.tennis.game3;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame3 implements TennisGame {

    private int playerTwoScore;
    private int playerOneScore;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame3(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getScore() {
        String s;
        if (playerOneScore < 4 && playerTwoScore < 4 && !(playerOneScore + playerTwoScore == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[playerOneScore];
            return (playerOneScore == playerTwoScore) ? s + "-All" : s + "-" + p[playerTwoScore];
        } else {
            if (playerOneScore == playerTwoScore)
                return "Deuce";
            s = playerOneScore > playerTwoScore ? playerOneName : playerTwoName;
            return ((playerOneScore - playerTwoScore)*(playerOneScore - playerTwoScore) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.playerOneScore += 1;
        else
            this.playerTwoScore += 1;

    }

}

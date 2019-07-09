/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toptengamersmain;

/**
 *
 * @author newbo
 */
class HighScorer 
{
    private String nickName;
    private int playerScore;
            
        HighScorer(String string, int score)
        {
            nickName = string;
            playerScore = score;
        }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the playerScore
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * @param playerScore the playerScore to set
     */
    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
}

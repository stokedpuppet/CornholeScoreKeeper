package com.example.android.cornholescorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Tracks score for  Home Team
    int homeTeamScore = 0;
    // Tracks score for Away Team
    int awayTeamScore = 0;
    // Tracks In the Hole points for Home Team
    int homeTeamHolePoints = 0;
    // Tracks In the Hole points for Away Team
    int awayTeamHolePoints = 0;
    // Tracks On the Board points for Home Team
    int homeTeamBoardPoints = 0;
    // Tracks On the Board points for Away Team
    int awayTeamBoardPoints = 0;
    // Tracks the current round
    int roundIndicator = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * When button is pressed add 1 to In the Hole count for Home Team.
     */
    public void inTheHoleHomeTeam(View view) {
        homeTeamHolePoints = homeTeamHolePoints + 1;
        displayForHomeTeamHoleScore(homeTeamHolePoints);
    }

    /**
     * When button is pressed add 1 to On the Board count for Home Team.
     */
    public void onTheBoardHomeTeam(View view) {
        homeTeamBoardPoints = homeTeamBoardPoints + 1;
        displayForHomeTeamBoardScore(homeTeamBoardPoints);
    }

    /**
     * When button is pressed add 1 to In the Hole count for Away Team.
     */
    public void inTheHoleAwayTeam(View view) {
        awayTeamHolePoints = awayTeamHolePoints + 1;
        displayForAwayTeamHoleScore(awayTeamHolePoints);
    }

    /**
     * When button is pressed add 1 to On the Board count for Away Team.
     */
    public void onTheBoardAwayTeam(View view) {
        awayTeamBoardPoints = awayTeamBoardPoints + 1;
        displayForAwayTeamBoardScore(awayTeamBoardPoints);
    }

    /**
     * When button is pressed round is submitted and reset for next round.
     */

    public void submitRound(View view) {
        // Tracks round score for Home Team
        int homeTeamRoundScore = homeTeamHolePoints * 3 + homeTeamBoardPoints;
        // Tracks round score for Away Team
        int awayTeamRoundScore = awayTeamHolePoints * 3 + awayTeamBoardPoints;
        // Holds current round score.
        int roundScore;
        roundScore = homeTeamRoundScore > awayTeamRoundScore ?
                homeTeamRoundScore - awayTeamRoundScore : awayTeamRoundScore - homeTeamRoundScore;
        /**
         * The points for the round are added to the winner of the rounds score.
         */
        if (homeTeamRoundScore > awayTeamRoundScore)
            homeTeamScore = homeTeamScore + roundScore;
        else awayTeamScore = awayTeamScore + roundScore;
        displayForHomeTeamScore(homeTeamScore);
        displayForAwayTeamScore(awayTeamScore);
        /**
         * Resets round points.
         */
        homeTeamHolePoints = 0;
        homeTeamBoardPoints = 0;
        awayTeamHolePoints = 0;
        awayTeamBoardPoints = 0;
        displayForHomeTeamHoleScore(homeTeamHolePoints);
        displayForHomeTeamBoardScore(homeTeamBoardPoints);
        displayForAwayTeamHoleScore(awayTeamHolePoints);
        displayForAwayTeamBoardScore(awayTeamBoardPoints);
        /**
         * Updates round indicator.
         */
        roundIndicator = roundIndicator + 1;
        displayForRoundIndicator(roundIndicator);
    }

    /**
     * When button is pressed round points are reset.
     */
    public void resetRound(View view) {
        homeTeamHolePoints = 0;
        homeTeamBoardPoints = 0;
        awayTeamHolePoints = 0;
        awayTeamBoardPoints = 0;
        displayForHomeTeamHoleScore(homeTeamHolePoints);
        displayForHomeTeamBoardScore(homeTeamBoardPoints);
        displayForAwayTeamHoleScore(awayTeamHolePoints);
        displayForAwayTeamBoardScore(awayTeamBoardPoints);
    }

    /**
     * When button is pressed game is reset.
     */
    public void newGame(View view) {
        homeTeamHolePoints = 0;
        homeTeamBoardPoints = 0;
        awayTeamHolePoints = 0;
        awayTeamBoardPoints = 0;
        homeTeamScore = 0;
        awayTeamScore = 0;
        roundIndicator = 1;
        displayForHomeTeamHoleScore(homeTeamHolePoints);
        displayForHomeTeamBoardScore(homeTeamBoardPoints);
        displayForAwayTeamHoleScore(awayTeamHolePoints);
        displayForAwayTeamBoardScore(awayTeamBoardPoints);
        displayForHomeTeamScore(homeTeamScore);
        displayForAwayTeamScore(awayTeamScore);
        displayForRoundIndicator(roundIndicator);
    }


    /**
     * Displays the score for Home Team.
     */
    public void displayForHomeTeamScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_team_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the score for Away Team.
     */
    public void displayForAwayTeamScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.away_team_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the In the Hole score for Home Team.
     */
    public void displayForHomeTeamHoleScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_team_hole_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the In the Hole score for Away Team.
     */
    public void displayForAwayTeamHoleScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.away_team_hole_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the On the Board score for Home Team.
     */
    public void displayForHomeTeamBoardScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_team_board_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the On the Board score for Away Team.
     */
    public void displayForAwayTeamBoardScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.away_team_board_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the Round Indicator.
     */
    public void displayForRoundIndicator(int score) {
        TextView scoreView = (TextView) findViewById(R.id.round_indicator);
        scoreView.setText(String.valueOf(score));
    }


}

package com.mystery.bookofra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class RaaaaaActivity extends AppCompatActivity {

    Button b_rock, b_scissors, b_paper;
    TextView tv_Score;
    ImageView iv_Computerchoice, iv_Humanchoise;

    int Humanscore, Computerscore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raaaaa);

        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);
        b_rock = (Button) findViewById(R.id.b_rock);

        iv_Computerchoice = (ImageView) findViewById(R.id.iv_Computerchoice);
        iv_Humanchoise = (ImageView) findViewById(R.id.iv_Humanchoice);

        tv_Score = (TextView) findViewById(R.id.tv_Score);

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_Humanchoise.setImageResource(R.drawable.paper);
                String message = play_turn("paper");
                Toast.makeText(RaaaaaActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_Score.setText("Score Human: " + Integer.toString(Humanscore) + " Computer: " + Integer.toString(Computerscore));



            }
        });

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_Humanchoise.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(RaaaaaActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_Score.setText("Score Human: " + Integer.toString(Humanscore) + " Computer: " + Integer.toString(Computerscore));

            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_Humanchoise.setImageResource(R.drawable.scissors);
                String message = play_turn("scissors");
                Toast.makeText(RaaaaaActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_Score.setText("Score Human: " + Integer.toString(Humanscore) + " Computer: " + Integer.toString(Computerscore));

            }
        });


    }

    public String play_turn( String player_choice) {

        String computer_choice = "";
        Random r = new Random();

        int computer_choice_number = r.nextInt(3) + 1;

        if (computer_choice_number == 1 ) {
            computer_choice = "rock";
        } else
        if (computer_choice_number == 2 ) {
            computer_choice = "scissors";
        } else
        if (computer_choice_number == 3 ) {
            computer_choice = "paper";
        } else
        if (computer_choice == "rock") {
            iv_Computerchoice.setImageResource(R.drawable.rock);
        } else
        if (computer_choice == "scissors") {
            iv_Computerchoice.setImageResource(R.drawable.scissors);
        } else
        if (computer_choice == "paper") {
            iv_Computerchoice.setImageResource(R.drawable.paper);
        }


        if (computer_choice == player_choice) {
            return "Draw. Nobody won.";
        }
        else if (player_choice == "rock" && computer_choice == "scissors") {
            Humanscore++;
            return "Rock crashes scissors. You win!";
        }

        else if (player_choice == "rock" && computer_choice == "paper") {
            Computerscore++;
            return "Paper covers rock. Computer wins!";
        }

        else if (player_choice == "scissors" && computer_choice == "rock") {
            Computerscore++;
            return "Rock crashes scissors. Computer wins!";
        }

        else if (player_choice == "scissors" && computer_choice == "paper") {
            Humanscore++;
            return "Scissors cut the paper. You win!";
        }

        else if (player_choice == "paper" && computer_choice == "rock") {
            Humanscore++;
            return "Paper covers rock. You win!";
        }

        else if (player_choice == "paper" && computer_choice == "scissors") {
            Computerscore++;
            return "Scissors cut the paper. Computer wins!";
        }
        else return "Not sure";
    }
}

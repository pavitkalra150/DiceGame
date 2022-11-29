package com.example.dicegame;

import static java.lang.Math.random;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public TextView cScore;
    public ImageView dice1;
    public Button throwDice;
    public ImageView dice2;
    public TextView pScore;

    int computer = 0;
    int you = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cScore = findViewById(R.id.cScore);
        dice1 = findViewById(R.id.dice1);
        throwDice = findViewById(R.id.throwDice);
        dice2 = findViewById(R.id.dice2);
        pScore = findViewById(R.id.pScore);
        throwDice.setOnClickListener(view -> {
            diceGame();
        });
        cScore.setText("Score = " + computer);
        pScore.setText("Score = " + you);
    }

    public void diceGame(){
        int[] images1 = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
        Random rand1 = new Random();
        int diceNum1 = rand1.nextInt(images1.length);
        dice1.setImageResource(images1[diceNum1++]);
        System.out.println(diceNum1);

        int[] images2 = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
        Random rand2 = new Random();
        int diceNum2 = rand2.nextInt(images2.length);
        dice2.setImageResource(images1[diceNum2++]);
        System.out.println(diceNum2);

        if(diceNum1 > diceNum2){
            computer++;
            cScore.setText("Score = " + computer);
            if(computer == 5){
                Toast.makeText(this, "Computer won", Toast.LENGTH_SHORT).show();
                computer = 0;
                you = 0;
                cScore.setText("Score = " + 0);
                pScore.setText("Score = " + 0);
            }
        }
        else if(diceNum1 < diceNum2){
            you++;
            pScore.setText("Score = " + you);
            if(you == 5){
                Toast.makeText(this, "You won", Toast.LENGTH_SHORT).show();
                computer = 0;
                you = 0;
                pScore.setText("Score = " +  computer);
                cScore.setText("Score = " + you);
            }
        }
        else if(diceNum1 == diceNum2){
            computer++;
            you++;
            cScore.setText("Score = " + computer);
            pScore.setText("Score = " + you);
        }

    }

}
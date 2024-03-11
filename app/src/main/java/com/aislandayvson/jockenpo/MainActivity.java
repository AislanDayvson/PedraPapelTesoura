package com.aislandayvson.jockenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectStone(View view){
        verifyWinner("pedra");
    }

    public void selectPaper(View view){
        verifyWinner("papel");
    }

    public void selectScissors(View view){
        verifyWinner("tesoura");
    }

    private String generateRandomChoice() {

        String[] options = {
                "pedra",
                "papel",
                "tesoura"
        };

        int randomNumber = new Random().nextInt(3);

        String appChoice = options[randomNumber];
        ImageView imageApp = findViewById(R.id.image_app);
        switch (appChoice){
            case "pedra":
                imageApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageApp.setImageResource(R.drawable.tesoura);
                break;
            }

        return appChoice;

        }

    private void verifyWinner(String userChoice){

        String appChoice = generateRandomChoice();

        TextView text_result = findViewById(R.id.text_result);
        if(
            (appChoice == "pedra" && userChoice == "tesoura") ||
            (appChoice == "papel" && userChoice == "pedra") ||
            (appChoice == "tesoura" && userChoice == "papel")
         ){
            text_result.setText("Você perdeu D:");
        } else if (
            (userChoice == "pedra" && appChoice == "tesoura") ||
            (userChoice == "papel" && appChoice == "pedra") ||
            (userChoice == "tesoura" && appChoice == "papel")
        ) {
            text_result.setText("VOCÊ GANHOU!!!!!!! :D ");
        }else{
            text_result.setText("Empate.");
        }
    }



}
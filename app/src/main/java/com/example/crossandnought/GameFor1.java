package com.example.crossandnought;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameFor1 extends AppCompatActivity {
    int activePlayer =0;
    int win1=0, win2=0, max_tap=9;
    boolean gameActive = true;
    int[] gameState = {2, 2 , 2, 2, 2, 2, 2, 2, 2};
    //    State meanings: 0 - X, 1 - 0, 2 - Null
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    String name1 , name2, text, winnerStr;
    TextView playerName, play1, play2;
    ArrayList<String> states = new ArrayList<>();

    public void computerTurn(View view){
        if(gameActive){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int select = states.size();
            int selected = new Random().nextInt(select);
            String selectedState = states.get(selected);
            switch (selectedState) {
                case "0":
                    ImageView img0 = findViewById(R.id.imageView0);
                    img0.setTranslationY(-1000f);
                    img0.setImageResource(R.drawable.o);
                    activePlayer = 0;
                    --max_tap;
                    playerName.setText(name1 + "'s turn");
                    states.remove(selectedState);
                    gameState[Integer.parseInt(selectedState)] = activePlayer;
                    img0.animate().translationYBy(1000f).setDuration(300);
                    break;
                case "1":
                    ImageView img1 = findViewById(R.id.imageView1);
                    img1.setTranslationY(-1000f);
                    img1.setImageResource(R.drawable.o);
                    activePlayer = 0;
                    --max_tap;
                    playerName.setText(name1 + "'s turn");
                    states.remove(selectedState);
                    gameState[Integer.parseInt(selectedState)] = activePlayer;
                    img1.animate().translationYBy(1000f).setDuration(300);
                    break;
                case "2":
                    ImageView img2 = findViewById(R.id.imageView2);
                    img2.setTranslationY(-1000f);
                    img2.setImageResource(R.drawable.o);
                    activePlayer = 0;
                    --max_tap;
                    playerName.setText(name1 + "'s turn");
                    states.remove(selectedState);
                    gameState[Integer.parseInt(selectedState)] = activePlayer;
                    img2.animate().translationYBy(1000f).setDuration(300);
                    break;
                case "3":
                    ImageView img3 = findViewById(R.id.imageView3);
                    img3.setTranslationY(-1000f);
                    img3.setImageResource(R.drawable.o);
                    activePlayer = 0;
                    --max_tap;
                    playerName.setText(name1 + "'s turn");
                    states.remove(selectedState);
                    gameState[Integer.parseInt(selectedState)] = activePlayer;
                    img3.animate().translationYBy(1000f).setDuration(300);
                    break;
                case "4":
                    ImageView img4 = findViewById(R.id.imageView4);
                    img4.setTranslationY(-1000f);
                    img4.setImageResource(R.drawable.o);
                    activePlayer = 0;
                    --max_tap;
                    playerName.setText(name1 + "'s turn");
                    states.remove(selectedState);
                    gameState[Integer.parseInt(selectedState)] = activePlayer;
                    img4.animate().translationYBy(1000f).setDuration(300);
                    break;
                case "5":
                    ImageView img5 = findViewById(R.id.imageView5);
                    img5.setTranslationY(-1000f);
                    img5.setImageResource(R.drawable.o);
                    activePlayer = 0;
                    --max_tap;
                    playerName.setText(name1 + "'s turn");
                    states.remove(selectedState);
                    gameState[Integer.parseInt(selectedState)] = activePlayer;
                    img5.animate().translationYBy(1000f).setDuration(300);
                    break;
                case "6":
                    ImageView img6 = findViewById(R.id.imageView6);
                    img6.setTranslationY(-1000f);
                    img6.setImageResource(R.drawable.o);
                    activePlayer = 0;
                    --max_tap;
                    playerName.setText(name1 + "'s turn");
                    states.remove(selectedState);
                    gameState[Integer.parseInt(selectedState)] = activePlayer;
                    img6.animate().translationYBy(1000f).setDuration(300);
                    break;
                case "7":
                    ImageView img7 = findViewById(R.id.imageView7);
                    img7.setTranslationY(-1000f);
                    img7.setImageResource(R.drawable.o);
                    activePlayer = 0;
                    --max_tap;
                    playerName.setText(name1 + "'s turn");
                    states.remove(selectedState);
                    gameState[Integer.parseInt(selectedState)] = activePlayer;
                    img7.animate().translationYBy(1000f).setDuration(300);
                    break;
                case "8":
                    ImageView img8 = findViewById(R.id.imageView8);
                    img8.setTranslationY(-1000f);
                    if(activePlayer== 1){
                    img8.setImageResource(R.drawable.o);
                    activePlayer = 0;
                    --max_tap;
                    playerName.setText(name1 + "'s turn");
                    states.remove(selectedState);
                    }
                    gameState[Integer.parseInt(selectedState)] = activePlayer;
                    img8.animate().translationYBy(1000f).setDuration(300);
                    break;
            }
            for (int[] winPosition : winPositions) {
                if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] ==
                        gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {

                    gameActive = false;

                    if (gameState[winPosition[0]] == 0) {
                        winnerStr = name1 + " has won";
                        win1++;
                    } else if (gameState[winPosition[0]] == 1) {
                        winnerStr = name2 + " has won";
                        win2++;
                    }
                    playerName = findViewById(R.id.playerName);
                    playerName.setText(winnerStr + "\nTap on grid to Re-Start");
                }
                play1.setText(name1 + " : " + win1);
                play2.setText(name2 + " : " + win2);
            }
        }
        else {
            gameReset(view);
        }
    }

    public void playerTap(View view) {
        if(gameActive){
            ImageView img = (ImageView) view;
            playerName = findViewById(R.id.playerName);
            text = playerName.getText().toString();
            int tappedImage = Integer.parseInt(img.getTag().toString());
            if (!text.equals(winnerStr + "\nTap to Re-Start")) {
                if (gameState[tappedImage] == 2) {
                    gameState[tappedImage] = activePlayer;
                    img.setTranslationY(-1000f);
                    if (activePlayer == 0) {
                        img.setImageResource(R.drawable.x);
                        activePlayer = 1;
                        --max_tap;
                        playerName.setText(name2 + "'s turn");
                        states.remove(Integer.toString(tappedImage));
                    }
                    img.animate().translationYBy(1000f).setDuration(300);

                    computerTurn(view);
                }


                if (max_tap == 0) {
                    playerName.setText("No one win\nClick here for next match");
                    playerName.setOnClickListener(view1 -> {
                        gameReset(view);
                    });
                }

            }

            else {
                gameReset(view);
            }

            for (int[] winPosition : winPositions) {
                if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] ==
                        gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {

                    gameActive = false;

                    if (gameState[winPosition[0]] == 0) {
                        winnerStr = name1 + " has won";
                        win1++;
                    }
                    else if (gameState[winPosition[0]] == 1) {
                        winnerStr = name2 + " has won";
                        win2++;
                    }
                    playerName = findViewById(R.id.playerName);
                    playerName.setText(winnerStr + "\nTap on grid to Re-Start");
                }
                play1.setText(name1 + " : " + win1);
                play2.setText(name2 + " : " + win2);
            }
        }

        else {
            gameReset(view);
        }

    }

    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        max_tap=9;
        for(int i=0; i<gameState.length; i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        playerName = findViewById(R.id.playerName);
        playerName.setText(name1+"'s turn");

    }

    ImageView home_btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_for2);
        Toast.makeText(GameFor1.this, "This is not\nworking properly.\nSo, application may crash..", Toast.LENGTH_LONG).show();
        Intent intent = getIntent();
        name1 = intent.getStringExtra("play1");
        name2 = intent.getStringExtra("play2");

        play1 = findViewById(R.id.play1);
        play1.setText(name1+" : "+win1);
        play2 = findViewById(R.id.play2);
        play2.setText(name2+" : "+win2);

        playerName = findViewById(R.id.playerName);
        playerName.setText(name1+" got X and "+name2+" got O \n\n"+name1+"'s turn");
        home_btn = findViewById(R.id.home_btn);
        home_btn.setOnClickListener(view -> {
            Intent intent1 = new Intent(GameFor1.this, MainActivity.class);
            startActivity(intent1);
            finish();
        });

        states.add("0");
        states.add("1");
        states.add("2");
        states.add("3");
        states.add("4");
        states.add("5");
        states.add("6");
        states.add("7");
        states.add("8");
    }

    public void onBackPressed(){
        Intent intent = new Intent(GameFor1.this, name_singles.class);
        startActivity(intent);
        finish();
    }
}
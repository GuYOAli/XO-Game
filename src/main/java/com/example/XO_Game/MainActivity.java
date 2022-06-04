package com.example.XO_Game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1: black 0: Red
    int activePlayer = 0;
    boolean gameActive=true, button = true ;
    int [] gamestate = {2,2,2,2,2,2,2,2,2};
    int [][]winning ={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{0,3,6},{1,4,7},{2,5,8},{2,4,6}};

    public void drop(View view){
        ImageView counter = (ImageView) view;

        int tappedCounter =Integer.parseInt(counter.getTag().toString());

        if(gamestate[tappedCounter] == 2 && gameActive) {

            gamestate[tappedCounter] = activePlayer;
            counter.setTranslationY(-1500);

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.red);
                activePlayer = 1;
            }
            else {
                counter.setImageResource(R.drawable.black);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1500).setDuration(300);

            for (int[] possition : winning) {
                String winner = "";
                if (gamestate[possition[0]] == gamestate[possition[1]] && gamestate[possition[1]] == gamestate[possition[2]] && gamestate[possition[0]] != 2) {

                    gameActive=false;

                    if (activePlayer == 1) {
                        winner = "Red ";
                    } else {
                        winner = "Black ";
                    }

                    TextView txt = (TextView) findViewById(R.id.text);
                    Button bb = (Button) findViewById(R.id.btn);
                    txt.setText(winner +" Has Won");
                    txt.setVisibility(View.VISIBLE);
                    bb.setVisibility(View.VISIBLE);
                }

            }
        }
    }
//    public void draw(View view){
//        String win = " Draw ";
//        TextView txt = (TextView) findViewById(R.id.text);
//        Button bb = (Button) findViewById(R.id.btn);
//        txt.setText(win);
//        txt.setVisibility(View.VISIBLE);
//        bb.setVisibility(View.VISIBLE);
//    }
    public void PalyAgain(View view){

        TextView txt = (TextView) findViewById(R.id.text);
        Button bb = (Button) findViewById(R.id.btn);
        txt.setVisibility(View.INVISIBLE);
        bb.setVisibility(View.INVISIBLE);
        GridLayout gridLayout = (GridLayout)findViewById(R.id.gg);
        for (int i =0 ;i < gridLayout.getChildCount(); i++){

            ImageView count = (ImageView)gridLayout.getChildAt(i);
            count.setImageDrawable(null);

        }
        for(int i =0;i<gamestate.length;i++){
            gamestate[i]=2;
        }

        activePlayer = 0;
        gameActive = true;

  }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(this, Info.class);
                startActivity(intent);
                Toast.makeText(this,"About Developer",Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:
                Toast.makeText(this,"Already in Home Page",Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

}

package com.example.XO_Game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Info extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ImageView wollo = (ImageView)findViewById(R.id.kiot);
        TextView txt = (TextView)findViewById(R.id.textView);
        txt.setY(1550);
        wollo.setY(1500);
        wollo.animate().translationYBy(-3000).setDuration(30000);
        txt.animate().translationYBy(-3000).setDuration(30000);
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
                Toast.makeText(this,"Already in Info Page",Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:
                Intent intent1 = new Intent(this,MainActivity.class);
                startActivity(intent1);
        }
        return true;
    }
}

package com.example.mauriciofloresjr.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private static final String TOTAL_COUNT = "total_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        showRandomNumber();
    }

    public void showRandomNumber(){
        TextView randomView = (TextView)
                findViewById(R.id.textview_random);

        TextView headingView = (TextView)
                findViewById(R.id.textview_label);

        int count = getIntent().getIntExtra(TOTAL_COUNT, 0);

        Random random = new Random();
        int randomInt = 0;
        if (count > 0) {
            randomInt = random.nextInt(count);
        }

        randomView.setText(Integer.toString(randomInt));

        headingView.setText(getString(R.string.random_heading, count));
    }

    public void backBtn(View view){
        Intent mainIntent = new Intent(this, MainActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(mainIntent);
    }
}

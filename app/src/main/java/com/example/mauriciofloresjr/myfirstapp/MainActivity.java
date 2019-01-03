package com.example.mauriciofloresjr.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TOTAL_COUNT = "total_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void countUp(View view){
        TextView showCountTextView = findViewById(R.id.startNum);

        String countString = showCountTextView.getText().toString();

        Integer count = Integer.parseInt(countString);

        count++;

        showCountTextView.setText(count.toString());
    }

    public void countDown(View view){
        TextView showCountTextView = findViewById(R.id.startNum);

        String countString = showCountTextView.getText().toString();

        Integer count = Integer.parseInt(countString);

        count--;

        if (count < 0) {
            count = 0;
            Toast countError = Toast.makeText(this, "Count can't be lower than 0!", Toast.LENGTH_SHORT);
            countError.show();
        }

        showCountTextView.setText(count.toString());
    }


    public void randomMe(View view){
        Intent randomIntent = new Intent(this, SecondActivity.class);

        TextView showCountTextView = findViewById(R.id.startNum);

        String countString = showCountTextView.getText().toString();

        int count = Integer.parseInt(countString);

        randomIntent.putExtra(TOTAL_COUNT, count);

        startActivity(randomIntent);
    }

    public void resetCount(View view){
        TextView showCountTextView = findViewById(R.id.startNum);

        String countString = showCountTextView.getText().toString();

        Integer count = Integer.parseInt(countString);

        count = 0;

        showCountTextView.setText(count.toString());

        Toast countReset = Toast.makeText(this, "Successfully reset count!", Toast.LENGTH_SHORT);
        countReset.show();
    }
}

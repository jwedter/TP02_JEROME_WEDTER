package com.google.jerome.wedter.tp02_jerome_wedter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.jerome.wedter.tp02_jerome_wedter.R;

public class ComputeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);
        setUpViews();
    }


    @SuppressLint("SetTextI18n")
    private void setUpViews() {
        TextView textViewNb1 = findViewById(R.id.textNb1);
        TextView textViewNb2 = findViewById(R.id.textNb2);
        Intent intent = getIntent();
        String nb1 = intent.getStringExtra("nb1");
        String nb2 = intent.getStringExtra("nb2");

       textViewNb1.setText("Nombre 1 : " + nb1);
       textViewNb2.setText("Nombre 2 : " + nb2);
       initViews();
    }

    private void initViews(){

        String nb1 = getIntent().getStringExtra("nb1");
        String nb2 = getIntent().getStringExtra("nb2");

        Intent intent = new Intent();

        Button buttonSum = findViewById(R.id.sum);
        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer result = Integer.parseInt(nb1) + Integer.parseInt(nb2);
                intent.putExtra("result", result);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button buttonMinus = findViewById(R.id.minus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer result = Integer.parseInt(nb1)  - Integer.parseInt(nb2);
                intent.putExtra("result", result);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button buttonMultiply = findViewById(R.id.multiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer result = Integer.parseInt(nb1) * Integer.parseInt(nb2);
                intent.putExtra("result", result);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button buttonDivide = findViewById(R.id.divide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(nb2)!=0) {
                    int result = Integer.parseInt(nb1) /Integer.parseInt(nb2);
                    intent.putExtra("result", result);
                    setResult(RESULT_OK, intent);
                    finish();
                } else finish();

            }
        });
    }

}

package com.google.jerome.wedter.tp02_jerome_wedter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int COMPUTE_CODE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        EditText editTextNb1 = findViewById(R.id.nb1);
        EditText editTextNb2 = findViewById(R.id.nb2);
        Button buttonCompute = findViewById(R.id.compute);
        buttonCompute.setEnabled(false);

        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textNb1 = editTextNb1.getText().toString();
                String textNb2 = editTextNb2.getText().toString();

                Intent intent = new Intent(MainActivity.this, ComputeActivity.class);
                intent.putExtra("nb1", textNb1);
                intent.putExtra("nb2", textNb2);
                startActivityForResult(intent, COMPUTE_CODE);
                //Toast.makeText(MainActivity.this, "Tu veux calculer la somme de " + textNb1 + " et " + textNb2 + "  ->  " + textNb1 + " et "
                   //     + textNb2 + " sont les valeurs des deux champs nb1 et nb2 respectivement", Toast.LENGTH_SHORT).show();
            }
        });

        editTextNb1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (editTextNb1.getText().length() > 0 && editTextNb2.getText().length() > 0) {
                        buttonCompute.setEnabled(true);
                    } else {
                        buttonCompute.setEnabled(false);
                    }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTextNb2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editTextNb1.getText().length() > 0 && editTextNb2.getText().length() > 0) {
                    buttonCompute.setEnabled(true);
                } else {
                    buttonCompute.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == COMPUTE_CODE && data != null) {
                int result = data.getIntExtra("result", -1);
                Toast.makeText(this, "Result is " + result, Toast.LENGTH_SHORT).show();
            }
        } else Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();

    }


}
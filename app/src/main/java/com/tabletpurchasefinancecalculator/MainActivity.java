package com.tabletpurchasefinancecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText name, message, choice;
    Button btnCalculate;
    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        message = findViewById(R.id.message);
        choice = findViewById(R.id.choice);
        btnCalculate = findViewById(R.id.btnCalculate);
        results = findViewById(R.id.results);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBtnCalculate();
            }
        });
    }

    public void getBtnCalculate() {

        double originalPrice = 0;
        char choiceChar = choice.getText().charAt(0);
        try {
            if (choiceChar == 'S'){
                originalPrice = 2500;
            }
            else if(choiceChar == 'M'){
                originalPrice = 3500;
            }
            else if(choiceChar == 'L'){
                originalPrice = 4500;
            }
            else {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            results.setText("Something went wrong!");
            return;
        }


        double installment = originalPrice + (85.4/100 * originalPrice);
        double credit = installment * 24;

        results.setText("Hello " + name.getText().toString());
        results.setText(message.getText().toString());
        results.setText("Monthly Installment: " + installment);
        results.setText("Total Credit Price: " + credit);

    }
}
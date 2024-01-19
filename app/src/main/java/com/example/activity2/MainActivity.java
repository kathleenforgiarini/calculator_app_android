package com.example.activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2;
    Button equal, clr;

    String operation, num1, num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);

        equal = findViewById(R.id.equal);
        clr = findViewById(R.id.clr);

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");
                edt2.setText("");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    num2 = edt2.getText().toString();
                    int n1 = Integer.parseInt(num1);
                    int n2 = Integer.parseInt(num2);
                    int result = 0;
                    switch (operation) {
                        case "+": {
                            result = n1 + n2;
                            break;
                        }
                        case "-": {
                            result = n1 - n2;
                            break;
                        }
                        case "*": {
                            result = n1 * n2;
                            break;
                        }
                        case "/": {
                            result = n1 / n2;
                            break;
                        }
                    }
                    StringBuilder calc = new StringBuilder();
                    calc.append(n1);
                    calc.append(" ");
                    calc.append(operation);
                    calc.append(" ");
                    calc.append(n2);
                    calc.append(" = ");
                    calc.append(result);
                    edt1.setText(calc);
                    edt2.setText("");
                }
                catch (Exception ex){
                    edt1.setText("An error occurred, try again!");
                    edt2.setText("");
                }

            }
        });
    }

    public void click(View v){
        Button button = (Button)v;
        String buttonText = button.getText().toString();
        Toast.makeText(getApplicationContext(), buttonText, Toast.LENGTH_SHORT).show();

        if (edt2.getText().toString().equals("")){
            edt2.setText(buttonText);
        }
        else {
            if (buttonText.equals("/") || buttonText.equals("*") || buttonText.equals("-") || buttonText.equals("+")){
                operation = buttonText;
                num1 = edt2.getText().toString();
                edt2.setText("");
                StringBuilder txt1 = new StringBuilder();
                txt1.append(num1);
                txt1.append(" ");
                txt1.append(operation);
                edt1.setText(txt1);
            }
            else {
                StringBuilder result = new StringBuilder();
                result.append(edt2.getText().toString());
                result.append(buttonText);
                edt2.setText(result);
            }
        }
    }
}
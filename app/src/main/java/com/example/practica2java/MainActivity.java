package com.example.practica2java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight;
    private EditText editTextHeight;
    private Button buttonCalculate,btnLimpiar,btnCerrar;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLimpiar = findViewById(R.id.btnLimpiar);
        Button btnCerrar = findViewById(R.id.btnCerrar);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        // Agrega un OnClickListener al botón
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Limpiar();
            }
        });

        // Agrega un OnClickListener al botón
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad actual y finaliza la aplicación
            }
        });
    }

    private void calculateBMI() {
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            textViewResult.setText("Por favor inserte Peso y Altura");
            return;
        }

        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr);

        float bmi = weight / (height * height);

        String result;
        if (bmi < 18.5) {
            result = "Bajo de Peso";
        } else if (bmi < 25) {
            result = "Peso Normal";
        } else if (bmi < 30) {
            result = "Sobrepeso";
        } else {
            result = "Obesidad";
        }

        String bmiResult = "IMC: " + String.format("%.2f", bmi) + "\n" + result;
        textViewResult.setText(bmiResult);
    }
    private void Limpiar() {
        editTextWeight.setText("");
        editTextHeight.setText("");
        textViewResult.setText("");
    }


}
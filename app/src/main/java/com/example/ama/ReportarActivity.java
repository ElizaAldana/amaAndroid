package com.example.ama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ReportarActivity extends AppCompatActivity {

    private Button reportarBtn1;
    private EditText tituloTxt, descTxt, ubiTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportar);
    }
}
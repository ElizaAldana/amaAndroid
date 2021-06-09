package com.example.ama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button consBtn, repBtn, mapBtn, pBtn;
    //Para separar la barra de busqueda
    private Button perfilBtn, reportBtn, homeBtn, puntosBtn, consejosBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
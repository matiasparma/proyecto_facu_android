package com.example.proyecto_facu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.proyecto_facu.Controller.ManejadorActivity;
import com.example.proyecto_facu.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void volver(View v){
        ManejadorActivity.abrirCliente(this);
    }
}
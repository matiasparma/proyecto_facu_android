package com.example.proyecto_facu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.proyecto_facu.Controller.ManejadorActivity;
import com.example.proyecto_facu.Controller.ManejadorArchivoTxT;
import com.example.proyecto_facu.R;

public class ClienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
    }

    public void borrarRuta(View v) {
        ManejadorArchivoTxT.resetearTXT(this);
        ManejadorActivity.abrirHome(this);
    }
}

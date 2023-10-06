package com.example.proyecto_facu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_facu.Controller.LoginController;
import com.example.proyecto_facu.R;

public class LoginActivity extends AppCompatActivity {
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.editTextUsuario);
       // getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    public void guardarDatos(View v){
        LoginController.guardarDatosTxt(username,this);
    }

}
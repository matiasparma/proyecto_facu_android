package com.example.proyecto_facu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.proyecto_facu.Controller.ManejadorActivity;
import com.example.proyecto_facu.R;
import com.example.proyecto_facu.VariableGlobales;
import com.example.proyecto_facu.Controller.ManejadorArchivoTxT;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    boolean valorArchivo;
    boolean valorTXT;
    private static final int TIEMPO_ESPERA=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // getSupportActionBar().setDisplayShowTitleEnabled(false);
        String archivos[] = fileList();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // Crea un intent para abrir SegundoActivity
                valorArchivo= ManejadorArchivoTxT.archivoExistente(archivos, VariableGlobales.rutaUsuario);
                valorTXT=ManejadorArchivoTxT.verificarTXT(MainActivity.this," ");
                ManejadorActivity.abrirActivity(MainActivity.this,valorArchivo,valorTXT,"matias",VariableGlobales.administrador);
                 //Cierra MainActivity para que no pueda volver atrás con el botón "Atrás"
                finish();
            }
        }, TIEMPO_ESPERA);
    }


    private boolean archivoExistente(String archivo[], String nombreArchivo) {
        boolean validacion=false;
        for (int i = 0; i < archivo.length; i++) {
            if (archivo[i].equals(nombreArchivo)) {
                Toast.makeText(this,archivo[i].toString(),Toast.LENGTH_SHORT).show();
                validacion=true;
            }
        }
        return validacion;
    }

    private boolean verificarTXT(){
        boolean valorTxt=true;
        try {
            InputStreamReader archivo=new InputStreamReader(openFileInput(VariableGlobales.rutaUsuario));
            BufferedReader br=new BufferedReader(archivo);
            String valorLinea=br.readLine().toString();
            if(valorLinea.equals(" ")) valorTxt=false;
            Toast.makeText(this,valorLinea,Toast.LENGTH_SHORT).show();
            archivo.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return valorTxt;
    }
}
package com.example.proyecto_facu.Controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.proyecto_facu.Controller.ManejadorActivity;
import com.example.proyecto_facu.VariableGlobales;
import com.example.proyecto_facu.activity.ClienteActivity;
import com.example.proyecto_facu.activity.LoginActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ManejadorArchivoTxT {
    public static boolean archivoExistente(String archivo[], String nombreArchivo) {
        boolean validacion=false;
        for (int i = 0; i < archivo.length; i++) {
            if (archivo[i].equals(nombreArchivo)) {
                validacion=true;
            }
        }
        return validacion;
    }

    public static boolean verificarTXT(Context context,String valorStringTXT){
        boolean valorTxt=true;
        try {
            InputStreamReader archivo=new InputStreamReader(context.openFileInput(VariableGlobales.rutaUsuario));
            BufferedReader br=new BufferedReader(archivo);
            String valorLinea=br.readLine().toString();
            if(valorLinea.equals(valorStringTXT)) valorTxt=false;
            archivo.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return valorTxt;
    }

    public static void resetearTXT(Context context){
        try {
            OutputStreamWriter datoUsuario=new OutputStreamWriter(context.openFileOutput(VariableGlobales.rutaUsuario, Activity.MODE_PRIVATE));
            datoUsuario.write(" ");
            datoUsuario.flush();
            datoUsuario.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

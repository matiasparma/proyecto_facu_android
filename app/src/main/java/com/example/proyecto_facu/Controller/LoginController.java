package com.example.proyecto_facu.Controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_facu.VariableGlobales;
import com.example.proyecto_facu.activity.ClienteActivity;
import com.example.proyecto_facu.activity.LoginActivity;
import com.example.proyecto_facu.activity.MainActivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class LoginController {
    public static boolean verificarCampo(TextView t, Context context){
        boolean validacion=true;
        if (t.getText().length()==0)validacion=false;
        return validacion;
    }
    public static void guardarDatosTxt(TextView username,Context context){
        boolean valor=verificarCampo(username,context);
        String nombre=username.getText().toString();
       if (valor){
           try {
               OutputStreamWriter datoUsuario=new OutputStreamWriter(context.openFileOutput(VariableGlobales.rutaUsuario, Activity.MODE_PRIVATE));
               datoUsuario.write(username.getText().toString());
               datoUsuario.flush();
               datoUsuario.close();
               abrirClienteOHome(nombre,context);
           } catch (FileNotFoundException e) {
               throw new RuntimeException(e);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       } else Toast.makeText(context,"campo vacio",Toast.LENGTH_SHORT).show();

    }
    public static void abrirClienteOHome(String username, Context context){
        ManejadorActivity.abrirClienteOHome(username,"matias",context);
    }

}

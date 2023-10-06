package com.example.proyecto_facu.Controller;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.example.proyecto_facu.activity.HomeActivity;
import com.example.proyecto_facu.activity.ClienteActivity;
import com.example.proyecto_facu.activity.LoginActivity;

public class ManejadorActivity {
    public static void abrirCliente(Context context){
        Intent abreCliente=new Intent(context, ClienteActivity.class);
        abreCliente.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(abreCliente);
    }
    public static void abrirLogin(Context context){
        Intent abreLogin = new Intent(context, LoginActivity.class);
        abreLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(abreLogin);
    }
    public static void abrirHome(Context context){
        Intent abreHome = new Intent(context, HomeActivity.class);
        abreHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(abreHome);
    }
    public static void abrirActivity(Context context, boolean validacionArchivo,boolean validacionTXT,String username,String administrador){
        if(!validacionArchivo || validacionTXT){
            abrirClienteOHome(username,administrador,context);
        }
        else{
            ManejadorActivity.abrirLogin(context);
        }
    }
    public static void abrirClienteOHome(String username,String nombreAcomparar, Context context){
        if (username.equals(nombreAcomparar)) ManejadorActivity.abrirHome(context);
        else ManejadorActivity.abrirCliente(context);
    }


}

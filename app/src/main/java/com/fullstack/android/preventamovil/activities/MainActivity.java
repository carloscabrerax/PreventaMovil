package com.fullstack.android.preventamovil.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.fullstack.android.preventamovil.R;


public class MainActivity extends AppCompatActivity {

    Button geolocalizarClienteButton;
    Button verUbicacionClienteButton;
    Button fotografiarClienteButton;
    Button verFotografiaClienteButton;
    Button cargarVentaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        geolocalizarClienteButton = (Button) findViewById(R.id.button_geolocalizar_cliente);
        geolocalizarClienteButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
//                startActivity(new Intent(MainActivity.this,
//                        GeolocalizarClienteActivity.class));
            }
        });

        verUbicacionClienteButton = (Button) findViewById(R.id.button_ver_ubicacion_cliente);
        verUbicacionClienteButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
//                startActivity(new Intent(MainActivity.this,
//                        VerUbicacionClienteActivity.class));
            }
        });

        fotografiarClienteButton = (Button) findViewById(R.id.button_fotografiar_cliente);
        fotografiarClienteButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
//                startActivity(new Intent(MainActivity.this,
//                        FotografiarClienteActivity.class));
            }
        });

        verFotografiaClienteButton = (Button) findViewById(R.id.button_ver_fotografia_cliente);
        verFotografiaClienteButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
//                startActivity(new Intent(MainActivity.this,
//                        VerFotografiaClienteActivity.class));
            }
        });

        cargarVentaButton = (Button) findViewById(R.id.button_nueva_venta);
        cargarVentaButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
//                startActivity(new Intent(MainActivity.this,
//                        CargarVentaActivity.class));
            }
        });
    }
}

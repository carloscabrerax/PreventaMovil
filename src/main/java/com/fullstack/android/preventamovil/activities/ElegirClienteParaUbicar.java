package com.fullstack.android.preventamovil.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


import com.fullstack.android.preventamovil.R;

public class ElegirClienteParaUbicar extends AppCompatActivity {
    private ListView listView;
    //Elementos que se mostraran en el listview
    private String clientes[]=new String[]{"Cliente1","Cliente2","Cliente3","Cliente4","Cliente5"};
    private String clientescoincidencia[]=new String[1000000];
    private double longitud[] = new double[] {32,12,-98,78-45};
    private double latitud[] = new double[] {-32,120,-9,8-45};
    private EditText coincidencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_cliente_para_ubicar);
        listView = (ListView) findViewById(R.id.cliente_miLista);
        coincidencia = (EditText) findViewById( R.id.cliente_nombre );
        String auxEdiNombre=coincidencia.getText().toString();

        /*buscar coincidencias y cargar en el vector de clientes coincidencia*/
        int k;
        int m = 0;
        for (k = 0; k< 5; k++)
        {
            if (auxEdiNombre.equals(clientes[k]))
            {
                clientescoincidencia[m] = clientes[k];
                m++;
            }
        }


        //Declaramos el Array Adactes,le pasamos el contexto, le indicamos para que tenga
        // una simple_expandable_list_item_1 y le damos nuestro Array de String
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, clientescoincidencia);

        //Le asignamos el adacter al listView
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {




            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // La posición donde se hace clic en el elemento de lista se obtiene de la
                // la posición de parámetro de la vista de lista de Android
                int posicion = position;

                //obtengo el valor del string del elemento donde se hizo clic
                String itemValue = (String) listView.getItemAtPosition(position);

                //Con el fin de empezar a mostrar una nueva actividad lo que necesitamos es una intención
                Intent intent = new Intent(getApplicationContext(),activity_verubicacion.class);

                // Poner el Id de la imagen como extra en la intención
                intent.putExtra("nombre",clientes[position]);
                intent.putExtra("latitud", latitud[position]);
                intent.putExtra("longitu", longitud[position]);

                // Aquí pasaremos el parámetro de la intención creada previamente
                startActivity(intent);
            }
        });

    }


}
package com.camilo.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmarDatos extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        final TextView editarTvNombre = (TextView)findViewById(R.id.editarNombre);
        final TextView editarFecha = (TextView)findViewById(R.id.editarFecha);
        final TextView editarTelefono = (TextView)findViewById(R.id.editarTelefono);
        final TextView editarMail = (TextView)findViewById(R.id.editarMail);
        final TextView editarDescripcion = (TextView)findViewById(R.id.editarDescripcion);
        Button botonEditar = (Button)findViewById(R.id.atras);


        Intent intent = getIntent();
        editarTvNombre.setText(intent.getStringExtra("Nombre"));
        editarFecha.setText(intent.getStringExtra("Fechanacimiento"));
        editarTelefono.setText(intent.getStringExtra("Telefono"));
        editarMail.setText(intent.getStringExtra("Mail"));
        editarDescripcion.setText(intent.getStringExtra("Descripcion"));

        botonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });






    }


}
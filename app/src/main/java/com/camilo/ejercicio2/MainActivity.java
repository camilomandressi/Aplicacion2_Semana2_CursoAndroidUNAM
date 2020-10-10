package com.camilo.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePickerDialog datepicker;
    EditText eText;
    Button btn;
    TextView tvw; // es el dato a enviar a la proxima vista

    private EditText tvNombre;
    private Button boton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText tvNombre = (EditText)findViewById(R.id.tvNombre);
        final EditText tvTelefono = (EditText)findViewById(R.id.tvTelefono);
        final EditText tvMail = (EditText)findViewById(R.id.tvMail);
        final EditText tvDescripcion = (EditText)findViewById(R.id.tvDescripcion);
        boton=(Button)findViewById(R.id.boton);


        tvw=(TextView)findViewById(R.id.textView1);
        eText=(EditText) findViewById(R.id.editText1);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                datepicker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                datepicker.show();
            }
        });
        btn=(Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("Fecha de nacimiento: "+ eText.getText());
            }
        });


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, confirmarDatos.class);
                intent.putExtra("Nombre", tvNombre.getText().toString());
                intent.putExtra("Fechanacimiento", tvw.getText().toString());
                intent.putExtra("Telefono", tvTelefono.getText().toString());
                intent.putExtra("Mail", tvMail.getText().toString());
                intent.putExtra("Descripcion", tvDescripcion.getText().toString());

                startActivity(intent);



            }
        });

    }
}
package itsco.edu.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    private TextView txtnombre;
    private TextView txttelefono;
    private TextView txtcorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        txtnombre = (TextView)
                findViewById(R.id.txt_nombre);
        txttelefono = (TextView)
                findViewById(R.id.txt_tel);
        txtcorreo = (TextView)
                findViewById(R.id.txt_correo);

        Intent data = getIntent();
        txtnombre.setText(data.getStringExtra("NOMBRE"));
        txttelefono.setText(data.getStringExtra("TELEFONO"));
        txtcorreo.setText(data.getStringExtra("CORREO"));
    }
}

package itsco.edu.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NuevaActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_add;
    private Button btn_cancelar;

    private EditText txt_nombre;
    private EditText txt_tel;
    private EditText txt_correo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva);

        btn_cancelar = (Button)
                findViewById(R.id.btn_cancelar);
        btn_add = (Button)
                findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        btn_cancelar.setOnClickListener(this);

        txt_nombre = (EditText)
                findViewById(R.id.txt_nombre);
        txt_tel = (EditText)
                findViewById(R.id.txt_tel);
        txt_correo = (EditText)
                findViewById(R.id.txt_correo);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==btn_add.getId()){
            Intent data = getIntent();

            tarea t = new tarea();
            t.setNombre(txt_nombre.getText().toString());
            data.putExtra("NOMBRE",
                    txt_nombre.getText().toString());
            //aunque se devuelva en el main no se
            //utiliza ya que la lista solo muestra un
            //valor
            data.putExtra("TELEFONO",
                    txt_tel.getText());
            data.putExtra("CORREO",
                    txt_correo.getText().toString());

            setResult(RESULT_OK,data);
        }
        if(v.getId()==btn_cancelar.getId()){
            setResult(RESULT_CANCELED);

        }
        finish();


    }
}

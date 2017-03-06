package itsco.edu.agenda;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, AdapterView.OnItemClickListener {

    public static final int NUEVA_TAREA = 10;

    private Button btnnuevo;
    private ListView lista_contactos;

    private ArrayList<tarea> data;
    private ArrayAdapter<tarea> adapter;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnnuevo = (Button) findViewById(R.id.btn_nuevo);
        btnnuevo.setOnClickListener(this);


        lista_contactos = (ListView) findViewById(R.id.lista_contactos);
        data = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, data);
        //agrego el adapter a la lista
        lista_contactos.setAdapter(adapter);
        lista_contactos.setOnItemClickListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, NuevaActivity.class);
        startActivityForResult(i, NUEVA_TAREA);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        tarea t = data.get(position);

        Intent intent = new Intent(this,
                DetalleActivity.class);

        intent.putExtra("NOMBRE", t.getNombre());
        intent.putExtra("TELEFONO", t.getTelefono());
        intent.putExtra("CORREO", t.getCorreo());

        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK) if (requestCode == NUEVA_TAREA) {
            String nombre = data.getStringExtra("NOMBRE");
            String telefono = data.getStringExtra("TELEFONO");
            String correo = data.getStringExtra("CORREO");
            tarea t = new tarea();
            t.setNombre(nombre);
            t.setTelefono(telefono);
            t.setCorreo(correo);

            this.data.add(t);

            //Cuando un datasource se actualiza
            //el adapter debe notificar cambios
            //con el metodo notifyDataSetChanged
            adapter.notifyDataSetChanged();
        }
    }
}

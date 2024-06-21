package debari.roberto.appandroid;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import debari.roberto.adapter.ListAdapter;
import debari.roberto.db.repository.DBRepository;
import debari.roberto.entity.Lista;

public class ActivityShop extends AppCompatActivity {
    EditText oggetto, numero;
    Button aggiungi;
    ListView spesa;
    private DBRepository dbRepository;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Context ctx = this;
        dbRepository = new DBRepository(ctx);
        aggiungi = findViewById(R.id.btn_add);
        oggetto = findViewById(R.id.txt_aggiungi_shop);
        numero = findViewById(R.id.txtnumber);
        spesa = findViewById(R.id.lstview_db);
        adapter = new ListAdapter(ctx, R.layout.layout_list, new ArrayList<>());
        spesa.setAdapter(adapter);
        aggiungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oggetto1 = oggetto.getText().toString();
                String numero1 = numero.getText().toString();
                if (!oggetto1.isEmpty() && !numero1.isEmpty()) {
                    Lista lista = new Lista(oggetto1, numero1);
                    try {
                        dbRepository.insertLista(lista);
                        Toast.makeText(ctx, R.string.txt_mess_inserito, Toast.LENGTH_SHORT).show();
                        refreshList();
                    } catch (Exception e) {
                        Toast.makeText(ctx, R.string.txt_error_mess, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        spesa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lista lista = (Lista) spesa.getItemAtPosition(position);
                Intent intent = new Intent(ctx, ActivityUpdateList.class);
                intent.putExtra("Oggetto Selezionato", lista);
                startActivity(intent);
            }
        });
    }
    private void refreshList() {
        dbRepository.selectAllLista().observe(this, new Observer<List<Lista>>() {
            @Override
            public void onChanged(List<Lista> lista) {
                adapter.updateList(lista);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        refreshList();
    }
}

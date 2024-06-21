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
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.example.myapplication.R;
import java.util.ArrayList;
import java.util.List;
import debari.roberto.adapter.NoteAdapter;
import debari.roberto.db.repository.DBRepository;
import debari.roberto.entity.Nota;

public class ActivityNotes extends AppCompatActivity {
    private DBRepository dbRepository;
    private ListView listView;
    private EditText editTextNota;
    private Button btnAggiungi;
    private NoteAdapter noteAdapter;
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        ctx = this;
        dbRepository = new DBRepository(ctx);
        listView = findViewById(R.id.listView_notes);
        editTextNota = findViewById(R.id.editText_nota);
        btnAggiungi = findViewById(R.id.btn_aggiungi);
        noteAdapter = new NoteAdapter(this, R.layout.nota_adapter, new ArrayList<>());
        listView.setAdapter(noteAdapter);
        btnAggiungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notaText = editTextNota.getText().toString().trim();
                if (!notaText.isEmpty()) {
                    Nota newNota = new Nota();
                    newNota.setContenuto(notaText);
                    dbRepository.insertNota(newNota);
                    editTextNota.setText("");
                    refreshNotesList();
                } else {
                    Toast.makeText(ActivityNotes.this, R.string.txt_error_nota, Toast.LENGTH_SHORT).show();
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Nota nota = (Nota) listView.getItemAtPosition(position);
                Intent intent = new Intent(ctx, ActivityUpdateAppunti.class);
                intent.putExtra("Oggetto Selezionato", nota);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        refreshNotesList();
    }
    public void refreshNotesList() {
        LiveData<List<Nota>> allNotesLiveData = dbRepository.selectAllNota();
        allNotesLiveData.observe(this, new Observer<List<Nota>>() {
            @Override
            public void onChanged(List<Nota> allNotes) {
                noteAdapter.clear();
                noteAdapter.addAll(allNotes);
                noteAdapter.notifyDataSetChanged();
            }
        });
    }
}

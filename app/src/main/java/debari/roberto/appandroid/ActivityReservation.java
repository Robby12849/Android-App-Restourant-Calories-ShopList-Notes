package debari.roberto.appandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import debari.roberto.db.repository.DBRepository;
import debari.roberto.entity.Prenotazione;

public class ActivityReservation extends AppCompatActivity {
    private ListView listView;
    private DBRepository dbRepository;
    private List<Prenotazione> prenotazioni = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        dbRepository = new DBRepository(this);
        listView = findViewById(R.id.listViewreservation);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0 && position < prenotazioni.size()) {
                    Prenotazione prenotazione = prenotazioni.get(position);
                    if (prenotazione != null) {
                        Intent intent = new Intent(getApplicationContext(), ActivityUpdatePrenotazione.class);
                        intent.putExtra("Prenotazione Selezionata", prenotazione);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ActivityReservation.this, R.string.txt_error_reservation, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        dbRepository.selectAllPrenotazione().observe(this, new Observer<List<Prenotazione>>() {
            @Override
            public void onChanged(List<Prenotazione> nuovePrenotazioni) {
                if (nuovePrenotazioni != null) {
                    prenotazioni = nuovePrenotazioni;
                    updateListView(prenotazioni);
                }
            }
        });
    }
    private void updateListView(List<Prenotazione> prenotazioni) {
        ArrayList<String> prenotazioniList = new ArrayList<>();
        for (Prenotazione prenotazione : prenotazioni) {
            String infoPrenotazione = "Paese: " + prenotazione.getPaese() +
                    ", Ristorante: " + prenotazione.getNomeristorante() +
                    ", Data: " + prenotazione.getData() +
                    ", Ora: " + prenotazione.getOra() +
                    ", Seggiolino: " + prenotazione.getSeggiolino() +
                    ", Tavoli: " + prenotazione.getTavoli() +
                    ", Persone: " + prenotazione.getNpersone();
            prenotazioniList.add(infoPrenotazione);
        }
        adapter.clear();
        adapter.addAll(prenotazioniList);
    }
}

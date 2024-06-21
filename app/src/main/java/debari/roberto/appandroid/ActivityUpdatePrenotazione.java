package debari.roberto.appandroid;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import debari.roberto.db.repository.DBRepository;
import debari.roberto.entity.Prenotazione;

public class ActivityUpdatePrenotazione extends AppCompatActivity {
    EditText paese, ristorante, data, ora, tavoli, persone, seggiolini;
    Button modifica, cancella;
    private DBRepository dbRepository;
    private Context ctx;
    private Prenotazione prenotazione;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_prenotazione);
        ctx = this;
        dbRepository = new DBRepository(ctx);
        paese = findViewById(R.id.txt_update_paese);
        ristorante = findViewById(R.id.txt_update_ristorante);
        data = findViewById(R.id.txt_update_data);
        ora = findViewById(R.id.txt_update_ora);
        tavoli = findViewById(R.id.txt_update_tavoli);
        persone = findViewById(R.id.txt_update_persone);
        seggiolini = findViewById(R.id.txt_update_seggiolini);
        modifica = findViewById(R.id.btn_modifica);
        cancella = findViewById(R.id.btn_cancella);

        prenotazione = (Prenotazione) getIntent().getExtras().getSerializable("Prenotazione Selezionata");
        if (prenotazione != null) {
            paese.setText(prenotazione.getPaese());
            ristorante.setText(prenotazione.getNomeristorante());
            data.setText(prenotazione.getData());
            ora.setText(prenotazione.getOra());
            tavoli.setText(String.valueOf(prenotazione.getTavoli()));
            persone.setText(String.valueOf(prenotazione.getNpersone()));
            seggiolini.setText(String.valueOf(prenotazione.getSeggiolino()));
        }
        modifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nuovoPaese = paese.getText().toString();
                String nuovoRistorante = ristorante.getText().toString();
                String nuovaData = data.getText().toString();
                String nuovaOra = ora.getText().toString();
                int nuoviTavoli = Integer.parseInt(tavoli.getText().toString());
                int nuovePersone = Integer.parseInt(persone.getText().toString());
                int nuoviSeggiolini = Integer.parseInt(seggiolini.getText().toString());
                prenotazione.setPaese(nuovoPaese);
                prenotazione.setNomeristorante(nuovoRistorante);
                prenotazione.setData(nuovaData);
                prenotazione.setOra(nuovaOra);
                prenotazione.setTavoli(nuoviTavoli);
                prenotazione.setNpersone(nuovePersone);
                prenotazione.setSeggiolino(nuoviSeggiolini);

                try {
                    dbRepository.updatePrenotazione(prenotazione);
                    Toast.makeText(ctx, getResources().getString(R.string.msg_driver_updated_successful), Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    Toast.makeText(ctx, getResources().getString(R.string.msg_driver_updated_error), Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dbRepository.deletePrenotazione(prenotazione);
                    Toast.makeText(ctx, getResources().getString(R.string.msg_driver_deleted_successful), Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    Toast.makeText(ctx, getResources().getString(R.string.msg_driver_deleted_error), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updatePrenotazione() {
        String nuovoPaese = paese.getText().toString();
        String nuovoRistorante = ristorante.getText().toString();
        String nuovaData = data.getText().toString();
        String nuovaOra = ora.getText().toString();
        int nuoviTavoli = Integer.parseInt(tavoli.getText().toString());
        int nuovePersone = Integer.parseInt(persone.getText().toString());
        int nuoviSeggiolini = Integer.parseInt(seggiolini.getText().toString());
        prenotazione.setPaese(nuovoPaese);
        prenotazione.setNomeristorante(nuovoRistorante);
        prenotazione.setData(nuovaData);
        prenotazione.setOra(nuovaOra);
        prenotazione.setTavoli(nuoviTavoli);
        prenotazione.setNpersone(nuovePersone);
        prenotazione.setSeggiolino(nuoviSeggiolini);

        try {
            dbRepository.updatePrenotazione(prenotazione);
            Toast.makeText(ctx, getResources().getString(R.string.msg_driver_updated_successful), Toast.LENGTH_SHORT).show();
            finish();
        } catch (Exception e) {
            Toast.makeText(ctx, getResources().getString(R.string.msg_driver_updated_error), Toast.LENGTH_SHORT).show();
        }
    }
    private void deletePrenotazione() {
        try {
            dbRepository.deletePrenotazione(prenotazione);
            Toast.makeText(ctx, getResources().getString(R.string.msg_driver_deleted_successful), Toast.LENGTH_SHORT).show();
            finish();
        } catch (Exception e) {
            Toast.makeText(ctx, getResources().getString(R.string.msg_driver_deleted_error), Toast.LENGTH_SHORT).show();
        }
    }
}

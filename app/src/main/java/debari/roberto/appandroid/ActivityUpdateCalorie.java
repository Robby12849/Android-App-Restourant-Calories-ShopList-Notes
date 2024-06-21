package debari.roberto.appandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import debari.roberto.db.repository.DBRepository;
import debari.roberto.entity.Calorie;

public class ActivityUpdateCalorie extends AppCompatActivity {
    Spinner spinnerpasti;
    EditText ncaloriep, datap, nomep;
    Button modifica, cancella;
    private DBRepository dbRepository;
    private Calorie selectedPasto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_calorie);
        dbRepository = new DBRepository(this);
        spinnerpasti = findViewById(R.id.spinner_meal);
        ncaloriep = findViewById(R.id.edt_upd_calorie);
        datap = findViewById(R.id.edt_upd_data);
        nomep = findViewById(R.id.edt_upd_nomepasto);
        modifica = findViewById(R.id.btn_modifica);
        cancella = findViewById(R.id.btn_cancella);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pasti, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerpasti.setAdapter(adapter);
        selectedPasto = (Calorie) getIntent().getSerializableExtra("Pasto Selezionato");
        if (selectedPasto != null) {
            nomep.setText(selectedPasto.getNomepasto());
            ncaloriep.setText(String.valueOf(selectedPasto.getNcalorie()));
            datap.setText(selectedPasto.getData());
            int spinnerPosition = adapter.getPosition(selectedPasto.getPasto());
            spinnerpasti.setSelection(spinnerPosition);
        }
        modifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePasto();
            }
        });
        cancella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePasto();
            }
        });
    }

    private void updatePasto() {
        String nome = nomep.getText().toString().trim();
        String calorieStr = ncaloriep.getText().toString().trim();
        String data = datap.getText().toString().trim();
        String pasto = spinnerpasti.getSelectedItem().toString();
        if (nome.isEmpty() || calorieStr.isEmpty() || data.isEmpty()) {
            Toast.makeText(ActivityUpdateCalorie.this, R.string.txt_completa_campi, Toast.LENGTH_SHORT).show();
            return;
        }
        int calorie = Integer.parseInt(calorieStr);
        if (selectedPasto != null) {
            selectedPasto.setNomepasto(nome);
            selectedPasto.setNcalorie(calorie);
            selectedPasto.setData(data);
            selectedPasto.setPasto(pasto);
            try {
                dbRepository.updateCaloria(selectedPasto);
                Toast.makeText(ActivityUpdateCalorie.this, R.string.txt_pasto_aggiornato, Toast.LENGTH_SHORT).show();
                finish();
            } catch (Exception e) {
                Toast.makeText(ActivityUpdateCalorie.this, R.string.txt_pasto_error, Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void deletePasto() {
        if (selectedPasto != null) {
            try {
                dbRepository.deleteCaloria(selectedPasto);
                Toast.makeText(ActivityUpdateCalorie.this, R.string.txt_pasto_eliminato, Toast.LENGTH_SHORT).show();
                finish();
            } catch (Exception e) {
                Toast.makeText(ActivityUpdateCalorie.this, R.string.txt_error_eliminazione_pasto, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(ActivityUpdateCalorie.this, R.string.txt_pasto_nonvalido, Toast.LENGTH_SHORT).show();
        }
    }
}

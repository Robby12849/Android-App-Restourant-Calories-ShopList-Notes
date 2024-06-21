package debari.roberto.appandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import debari.roberto.db.repository.DBRepository;
import debari.roberto.entity.Prenotazione;

public class ActivityDoReservation extends AppCompatActivity {
    LinearLayout mylayout;
    CheckBox seggsi;
    EditText numerotavoli, data, ora;
    Button prenota;
    RadioGroup personeRadioGroup;
    CheckBox si;

    private DBRepository dbRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_reservation);
        dbRepository = new DBRepository(this);
        String città = getIntent().getStringExtra("selectedCity");
        String ristorante = getIntent().getStringExtra("Ristorante");
        mylayout = findViewById(R.id.layout_invisible);
        seggsi = findViewById(R.id.chk_seggsi);
        numerotavoli = findViewById(R.id.edt_tavoli);
        data = findViewById(R.id.edt_data);
        ora = findViewById(R.id.edt_ora);
        prenota = findViewById(R.id.btn_prenota);
        personeRadioGroup = findViewById(R.id.radio_persone);
        si = findViewById(R.id.chk_seggsi);
        seggsi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mylayout.setVisibility(View.VISIBLE);
                } else {
                    mylayout.setVisibility(View.GONE);
                }
            }
        });
        prenota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String paese = città;
                String nomeristorante = ristorante;
                String dataValue = data.getText().toString();
                String oraValue = ora.getText().toString();
                Integer seggiolinoValue = si.isChecked() ? 1 : 0;
                Integer tavoliValue = 0;
                Integer npersoneValue = 0;
                String tavoliText = numerotavoli.getText().toString();
                if (!tavoliText.isEmpty()) {
                    tavoliValue = Integer.parseInt(tavoliText);
                    int selectedId = personeRadioGroup.getCheckedRadioButtonId();
                    if (selectedId != -1) {
                        RadioButton selectedRadioButton = findViewById(selectedId);
                        String personeText = selectedRadioButton.getText().toString();
                        if (personeText.contains("1")) {
                            npersoneValue = 1;
                        } else if (personeText.contains("2")) {
                            npersoneValue = 2;
                        } else if (personeText.contains("3")) {
                            npersoneValue = 3;
                        } else if (personeText.contains("4")) {
                            npersoneValue = 4;
                        }
                    } else {
                        Toast.makeText(ActivityDoReservation.this, R.string.txt_tavolo, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ActivityDoReservation.this, R.string.txt_error_tavoli, Toast.LENGTH_SHORT).show();
                }
                int npersoneTotale = tavoliValue * npersoneValue;
                Prenotazione prenotazione = new Prenotazione(paese, nomeristorante, dataValue, oraValue, seggiolinoValue, tavoliValue, npersoneTotale);
                dbRepository.insertPrenotazione(prenotazione);
                Intent intent = new Intent(ActivityDoReservation.this, ActivityReservation.class);
                startActivity(intent);
            }
        });

    }
}

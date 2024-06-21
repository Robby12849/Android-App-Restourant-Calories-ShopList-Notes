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
import debari.roberto.entity.Lista;

public class ActivityUpdateList extends AppCompatActivity {
    private Button btnModifica, btnCancella;
    private EditText edtqta, edtoggetto;
    private DBRepository dbRepository;
    private Context ctx;
    private Lista selectedoggetto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_list);
        selectedoggetto = (Lista) getIntent().getExtras().getSerializable("Oggetto Selezionato");
        ctx = this;
        dbRepository = new DBRepository(ctx);
        edtqta = findViewById(R.id.edt_numero);
        edtoggetto = findViewById(R.id.edt_oggetto);
        if (selectedoggetto != null) {
            edtqta.setText(selectedoggetto.getNumero());
            edtoggetto.setText(selectedoggetto.getOggetto());
        }
        btnModifica = findViewById(R.id.btn_modifica);
        btnModifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qta = edtqta.getText().toString();
                String oggetto = edtoggetto.getText().toString();
                if (!qta.isEmpty() && !oggetto.isEmpty()) {
                    Lista lista = new Lista(qta, oggetto);
                    lista.setId(selectedoggetto.getId());
                    try {
                        dbRepository.updateLista(lista);
                        Toast.makeText(ctx, getResources().getString(R.string.msg_driver_updated_successful), Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (Exception e) {
                        Toast.makeText(ctx, getResources().getString(R.string.msg_driver_updated_error), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ctx, R.string.txt_dati_incorretti, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnCancella = findViewById(R.id.btn_cancella);
        btnCancella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dbRepository.deleteLista(selectedoggetto);
                    Toast.makeText(ctx, getResources().getString(R.string.msg_driver_deleted_successful), Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    Toast.makeText(ctx, getResources().getString(R.string.msg_driver_deleted_error), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

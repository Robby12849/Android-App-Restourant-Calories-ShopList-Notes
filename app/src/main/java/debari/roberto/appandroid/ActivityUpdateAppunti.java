package debari.roberto.appandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import debari.roberto.db.repository.DBRepository;
import debari.roberto.entity.Lista;
import debari.roberto.entity.Nota;

public class ActivityUpdateAppunti extends AppCompatActivity {
    private Button btnModifica, btnCancella;
    private EditText edtnota;
    private DBRepository dbRepository;
    private Context ctx;
    private Nota selectednota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_appunti);

        ctx = this;
        dbRepository = new DBRepository(ctx);
        selectednota = (Nota) getIntent().getSerializableExtra("Oggetto Selezionato");

        edtnota = findViewById(R.id.edt_nota_2);
        if (selectednota != null) {
            edtnota.setText(selectednota.getContenuto());
        }

        btnCancella = findViewById(R.id.btn_cancella_2);
        btnModifica = findViewById(R.id.btn_modifica_2);

        btnModifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nota_sel = edtnota.getText().toString();
                if (!nota_sel.isEmpty() && selectednota != null) {
                    selectednota.setContenuto(nota_sel);
                    try {
                        dbRepository.updateNota(selectednota);
                        Toast.makeText(ctx, getResources().getString(R.string.msg_driver_updated_successful), Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (Exception e) {
                        Toast.makeText(ctx, getResources().getString(R.string.msg_driver_updated_error), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ctx, R.string.txt_error_dati, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnCancella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectednota != null) {
                    try {
                        dbRepository.deleteNota(selectednota);
                        Toast.makeText(ctx, getResources().getString(R.string.msg_driver_deleted_successful), Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (Exception e) {
                        Toast.makeText(ctx, getResources().getString(R.string.msg_driver_deleted_error), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ctx, R.string.txt_nota_non_valida, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

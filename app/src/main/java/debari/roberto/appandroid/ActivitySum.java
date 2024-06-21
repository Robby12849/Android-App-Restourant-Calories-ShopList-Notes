package debari.roberto.appandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.myapplication.R;

import debari.roberto.db.repository.DBRepository;

public class ActivitySum extends AppCompatActivity {
    EditText data;
    Button calcola;
    private DBRepository dbRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);
        dbRepository = new DBRepository(this);
        data = findViewById(R.id.edt_data_imput);
        calcola = findViewById(R.id.btn_calcola);
        calcola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedDate = data.getText().toString().trim();
                if (selectedDate.isEmpty()) {
                    Toast.makeText(ActivitySum.this, R.string.txt_data_imput, Toast.LENGTH_SHORT).show();
                    return;
                }
                dbRepository.sumCalorie(selectedDate).observe(ActivitySum.this, new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer sommacalorie) {
                        Toast.makeText(ActivitySum.this, "Somma delle calorie per la data selezionata: " + sommacalorie, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}

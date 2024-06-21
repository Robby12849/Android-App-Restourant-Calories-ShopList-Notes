package debari.roberto.appandroid;

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

import java.util.List;

import debari.roberto.adapter.CaloriAdapter;
import debari.roberto.db.repository.DBRepository;
import debari.roberto.entity.Calorie;

public class ActivityAdd extends AppCompatActivity {
    EditText ncalorie, data, nomecibo;
    Button aggiungi, somma, limite;
    private DBRepository dbRepository;
    private ListView listViewCalories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        dbRepository = new DBRepository(this);
        ncalorie = findViewById(R.id.editTextCalories);
        data = findViewById(R.id.editTextConsumptionDate);
        nomecibo = findViewById(R.id.editTextMealName);
        listViewCalories = findViewById(R.id.listViewCalories);
        aggiungi = findViewById(R.id.btn_aggiungi_2);
        somma = findViewById(R.id.btn_sum);
        limite = findViewById(R.id.btn_limit);
        aggiungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String calorieText = ncalorie.getText().toString().trim();
                String dataText = data.getText().toString().trim();
                String nomeCiboText = nomecibo.getText().toString().trim();
                if (calorieText.isEmpty() || dataText.isEmpty() || nomeCiboText.isEmpty()) {
                    Toast.makeText(ActivityAdd.this, R.string.string_txt_error_dati, Toast.LENGTH_SHORT).show();
                }
                int calorieValue = Integer.parseInt(calorieText);
                Calorie calorie = new Calorie();
                calorie.setPasto("Pasto");
                calorie.setNcalorie(calorieValue);
                calorie.setData(dataText);
                calorie.setNomepasto(nomeCiboText);
                dbRepository.insertCaloria(calorie);
                ncalorie.setText("");
                data.setText("");
                nomecibo.setText("");
            }
        });
        somma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivitySum.class);
                startActivity(intent);
            }
        });
        limite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityLimite.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        dbRepository.selectAllCalorie().observe(this, new Observer<List<Calorie>>() {
            @Override
            public void onChanged(List<Calorie> calorieList) {
                CaloriAdapter adapter = new CaloriAdapter(ActivityAdd.this, R.layout.calorie_adapter, calorieList);
                listViewCalories.setAdapter(adapter);
            }
        });
        listViewCalories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Calorie caloria = (Calorie) listViewCalories.getItemAtPosition(position);
                Intent intent = new Intent(ActivityAdd.this, ActivityUpdateCalorie.class);
                intent.putExtra("Pasto Selezionato", caloria);
                startActivity(intent);
            }
        });
    }
}

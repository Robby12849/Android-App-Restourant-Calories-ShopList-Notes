package debari.roberto.appandroid;

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
import androidx.lifecycle.Observer;

import com.example.myapplication.R;

import java.util.List;

import debari.roberto.db.repository.DBRepository;

public class ActivityLimite extends AppCompatActivity {
    EditText edt_limite;
    Button btn_limite;
    private DBRepository dbRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limite);
        dbRepository = new DBRepository(this);

        edt_limite = findViewById(R.id.edt_limite);
        btn_limite = findViewById(R.id.btn_limite);

        btn_limite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String limit = edt_limite.getText().toString().trim();
                if (limit.isEmpty()) {
                    Toast.makeText(ActivityLimite.this, R.string.txt_limite_insert, Toast.LENGTH_SHORT).show();
                    return;
                }
                int limite = Integer.parseInt(limit);
                dbRepository.LimitCalorie(limite).observe(ActivityLimite.this, new Observer<List<String>>() {
                    @Override
                    public void onChanged(List<String> dates) {
                        StringBuilder message = new StringBuilder("Date in cui il limite è stato superato:\n");
                        for (String date : dates) {
                            message.append(date).append("\n");
                        }
                        Toast.makeText(ActivityLimite.this, message.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
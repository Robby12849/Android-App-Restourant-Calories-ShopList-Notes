package debari.roberto.appandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.myapplication.R;

public class BariActivity extends AppCompatActivity {
    CardView opera, carducci, piccinni, santalucia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bari);
        String città = getIntent().getStringExtra("selectedCity");
        opera = findViewById(R.id.card_opera);
        carducci = findViewById(R.id.card_carducci);
        piccinni = findViewById(R.id.card_piccinni28);
        santalucia = findViewById(R.id.card_santa_lucia);
        opera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "Opera");
                startActivity(intent);
            }
        });
        carducci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "Carducci");
                startActivity(intent);
            }
        });
        piccinni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "Piccinni28");
                startActivity(intent);
            }
        });
        santalucia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "Santa Lucia");
                startActivity(intent);
            }
        });

    }
}

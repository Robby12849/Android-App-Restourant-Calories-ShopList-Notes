package debari.roberto.appandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.myapplication.R;

public class RomaActivity extends AppCompatActivity {
    CardView piccolomondo, saporisardi, famiglia, mazze;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roma);
        String città = getIntent().getStringExtra("selectedCity");
        piccolomondo = findViewById(R.id.card_piccolomondo);
        saporisardi = findViewById(R.id.card_saporisardi);
        famiglia = findViewById(R.id.card_lafamiglia);
        mazze = findViewById(R.id.card_mazze);
        piccolomondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "Piccolo Mondo");
                startActivity(intent);
            }
        });
        saporisardi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "Sapori Sardi");
                startActivity(intent);
            }
        });
        famiglia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "La Famiglia");
                startActivity(intent);
            }
        });
        mazze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "Mazze");
                startActivity(intent);
            }
        });
    }
}

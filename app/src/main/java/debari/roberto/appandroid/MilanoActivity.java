package debari.roberto.appandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.myapplication.R;

public class MilanoActivity extends AppCompatActivity {
    CardView acanto, pepenero, replay, le5terre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milano);
        String città = getIntent().getStringExtra("selectedCity");
        acanto = findViewById(R.id.card_acanto);
        pepenero = findViewById(R.id.card_pepenero);
        replay = findViewById(R.id.card_replay);
        le5terre = findViewById(R.id.card_le5terre);
        acanto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "Acanto");
                startActivity(intent);
            }
        });
        pepenero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "Pepe Nero");
                startActivity(intent);
            }
        });
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "Replay");
                startActivity(intent);
            }
        });
        le5terre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "Le 5 terre");
                startActivity(intent);
            }
        });

    }
}

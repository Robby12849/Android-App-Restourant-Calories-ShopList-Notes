package debari.roberto.appandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.myapplication.R;

public class NapoliActivity extends AppCompatActivity {
    CardView labufalina, nennella, poldopub, erricoporzio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_napoli);
        String città = getIntent().getStringExtra("selectedCity");
        labufalina = findViewById(R.id.card_labufalina);
        nennella = findViewById(R.id.card_nennella);
        poldopub = findViewById(R.id.card_poldopub);
        erricoporzio = findViewById(R.id.card_enricoporzio);
        labufalina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "La Bufalina");
                startActivity(intent);
            }
        });
        nennella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "Nennella");
                startActivity(intent);
            }
        });
        poldopub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "Poldo Pub");
                startActivity(intent);
            }
        });
        erricoporzio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDoReservation.class);
                intent.putExtra("selectedCity", città);
                intent.putExtra("Ristorante", "Errico Porzio");
                startActivity(intent);
            }
        });

    }
}

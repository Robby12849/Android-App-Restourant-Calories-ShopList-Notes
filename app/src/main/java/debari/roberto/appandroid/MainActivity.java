package debari.roberto.appandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.myapplication.R;

import debari.roberto.appandroid.ActivityFood;
import debari.roberto.appandroid.ActivityHealth;
import debari.roberto.appandroid.ActivityNotes;
import debari.roberto.appandroid.ActivityShop;

public class MainActivity extends AppCompatActivity {
    private CardView cardAggiungiLista, cardAggiungiAppunto, cardCalcolaCalorie, cardCercaRistorante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardAggiungiLista = findViewById(R.id.card_aggiungi_lista);
        cardAggiungiAppunto = findViewById(R.id.card_aggiungi_appunto);
        cardCalcolaCalorie = findViewById(R.id.card_calcola_calorie);
        cardCercaRistorante = findViewById(R.id.card_cerca_ristorante);
        cardAggiungiLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), ActivityShop.class);
                startActivity(myIntent);
            }
        });
        cardAggiungiAppunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), ActivityNotes.class);
                startActivity(myIntent);
            }
        });
        cardCalcolaCalorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), ActivityHealth.class);
                startActivity(myIntent);
            }
        });
        cardCercaRistorante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), ActivityFood.class);
                startActivity(myIntent);
            }
        });
    }
}

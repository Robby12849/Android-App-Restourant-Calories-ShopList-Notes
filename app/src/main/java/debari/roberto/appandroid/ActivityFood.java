package debari.roberto.appandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import debari.roberto.adapter.Città;
import debari.roberto.adapter.CustomListAdapter;

public class ActivityFood extends AppCompatActivity {
    Button prenotazioni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Città[] items = {
                new Città(R.drawable.img_bari, "BARI"),
                new Città(R.drawable.img_napoli, "NAPOLI"),
                new Città(R.drawable.img_roma, "ROMA"),
                new Città(R.drawable.img_milano, "MILANO")
        };
        ListView listView = findViewById(R.id.listviewfood);
        CustomListAdapter adapter = new CustomListAdapter(this, items);
        listView.setAdapter(adapter);
        prenotazioni=findViewById(R.id.btn_visualizza);
        prenotazioni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ActivityReservation.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Città selectedCity = items[position];
                Intent intent=new Intent();
                switch (selectedCity.getText()) {
                    case "BARI":
                        intent = new Intent(ActivityFood.this, BariActivity.class);
                        break;
                    case "NAPOLI":
                        intent = new Intent(ActivityFood.this, NapoliActivity.class);
                        break;
                    case "ROMA":
                        intent = new Intent(ActivityFood.this, RomaActivity.class);
                        break;
                    case "MILANO":
                        intent = new Intent(ActivityFood.this, MilanoActivity.class);
                        break;
                }
                intent.putExtra("selectedCity", selectedCity.getText());
                startActivity(intent);
            }
        });


    }
}

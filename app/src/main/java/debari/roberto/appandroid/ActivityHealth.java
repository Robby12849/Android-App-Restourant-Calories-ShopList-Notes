package debari.roberto.appandroid;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

import debari.roberto.entity.Calorie;

public class ActivityHealth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        String[] pasti = getResources().getStringArray(R.array.list_view_meal);
        ListView pastiListView = findViewById(R.id.list_view_meal);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pasti);
        pastiListView.setAdapter(adapter);
        pastiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedMeal = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), ActivityAdd.class);
                intent.putExtra("selectedMeal", selectedMeal);
                startActivity(intent);
            }
        });

    }
}

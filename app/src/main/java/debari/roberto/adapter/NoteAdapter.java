package debari.roberto.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.myapplication.R;
import java.util.ArrayList;
import java.util.List;
import debari.roberto.entity.Nota;
public class NoteAdapter extends ArrayAdapter<Nota> {
    private Context context;
    private int layout;
    private List<Nota> nota;
    static class ViewHolder {
        TextView txtId;
        TextView txtContenuto;
    }
    public NoteAdapter(@NonNull Context context, int layout, @NonNull List<Nota> nota) {
        super(context, layout, nota);
        this.context = context;
        this.layout = layout;
        this.nota = nota != null ? nota : new ArrayList<>();
    }
    public void updateNota(List<Nota> newList) {
        if (newList != null) {
            nota.clear();
            nota.addAll(newList);
            notifyDataSetChanged();
        }
    }
    @Override
    public int getCount() {
        return nota.size();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txtId = convertView.findViewById(R.id.txt_id); // Assuming txt_id is the ID of TextView for ID
            viewHolder.txtContenuto = convertView.findViewById(R.id.txt_contenuto); // Assuming txt_contenuto is the ID of TextView for Content
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Nota currentNota = nota.get(position);
        viewHolder.txtId.setText(String.valueOf(currentNota.getId()));
        viewHolder.txtContenuto.setText(currentNota.getContenuto());
        return convertView;
    }
}
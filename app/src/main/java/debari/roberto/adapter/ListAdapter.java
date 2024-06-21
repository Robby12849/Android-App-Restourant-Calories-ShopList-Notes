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
import debari.roberto.entity.Lista;
public class ListAdapter extends ArrayAdapter<Lista> {
    private Context context;
    private int layout;
    private List<Lista> lista;
    static class ViewHolder {
        TextView txtId;
        TextView txtoggetto;
        TextView txtnumero;
    }
    public ListAdapter(@NonNull Context context, int layout, @NonNull List<Lista> lista) {
        super(context, layout, lista);
        this.context = context;
        this.layout = layout;
        this.lista = lista;
    }
    @Override
    public int getCount() {
        return lista.size();
    }
    public void updateList(List<Lista> newList) {
        if (newList != null) {
            lista.clear();
            lista.addAll(newList);
            notifyDataSetChanged();
        }
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txtId = convertView.findViewById(R.id.txt_id);
            viewHolder.txtoggetto = convertView.findViewById(R.id.txt_oggetto);
            viewHolder.txtnumero = convertView.findViewById(R.id.txt_numero);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Lista currentLista = lista.get(position);
        viewHolder.txtId.setText(String.valueOf(currentLista.getId()));
        viewHolder.txtoggetto.setText(currentLista.getOggetto());
        viewHolder.txtnumero.setText(currentLista.getNumero());
        return convertView;
    }
}
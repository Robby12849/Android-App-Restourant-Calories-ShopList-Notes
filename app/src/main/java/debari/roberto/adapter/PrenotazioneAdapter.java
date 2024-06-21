package debari.roberto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

import debari.roberto.entity.Prenotazione;

public class PrenotazioneAdapter extends ArrayAdapter<Prenotazione> {
    private Context context;
    private int layout;
    private List<Prenotazione> prenotazioneList;

    static class ViewHolder {
        TextView textViewPaese;
        TextView textViewNomeristorante;
        TextView textViewData;
        TextView textViewOra;
        TextView textViewSeggiolino;
        TextView textViewTavoli;
        TextView textViewNpersone;
    }

    public PrenotazioneAdapter(Context context, int layout, List<Prenotazione> prenotazioneList) {
        super(context, layout, prenotazioneList);
        this.context = context;
        this.layout = layout;
        this.prenotazioneList = prenotazioneList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textViewPaese = convertView.findViewById(R.id.textViewPaese);
            viewHolder.textViewNomeristorante = convertView.findViewById(R.id.textViewNomeristorante);
            viewHolder.textViewData = convertView.findViewById(R.id.textViewData);
            viewHolder.textViewOra = convertView.findViewById(R.id.textViewOra);
            viewHolder.textViewSeggiolino = convertView.findViewById(R.id.textViewSeggiolino);
            viewHolder.textViewTavoli = convertView.findViewById(R.id.textViewTavoli);
            viewHolder.textViewNpersone = convertView.findViewById(R.id.textViewNpersone);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Prenotazione currentPrenotazione = prenotazioneList.get(position);
        viewHolder.textViewPaese.setText(currentPrenotazione.getPaese());
        viewHolder.textViewNomeristorante.setText(currentPrenotazione.getNomeristorante());
        viewHolder.textViewData.setText(currentPrenotazione.getData());
        viewHolder.textViewOra.setText(currentPrenotazione.getOra());
        viewHolder.textViewSeggiolino.setText(String.valueOf(currentPrenotazione.getSeggiolino()));
        viewHolder.textViewTavoli.setText(String.valueOf(currentPrenotazione.getTavoli()));
        viewHolder.textViewNpersone.setText(String.valueOf(currentPrenotazione.getNpersone()));

        return convertView;
    }
}

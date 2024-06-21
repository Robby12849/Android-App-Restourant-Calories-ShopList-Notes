package debari.roberto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

import debari.roberto.entity.Calorie;

public class CaloriAdapter extends ArrayAdapter<Calorie> {
    private Context context;
    private int layout;
    private List<Calorie> calorieList;

    static class ViewHolder {
        TextView textViewID;
        TextView textViewData;
        TextView textViewNCalorie;
        TextView textViewPasto;
        TextView textViewNomePasto;
    }

    public CaloriAdapter(Context context, int layout, List<Calorie> calorieList) {
        super(context, layout, calorieList);
        this.context = context;
        this.layout = layout;
        this.calorieList = calorieList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textViewID = convertView.findViewById(R.id.textViewid);
            viewHolder.textViewData = convertView.findViewById(R.id.textViewdata);
            viewHolder.textViewNCalorie = convertView.findViewById(R.id.textViewCalorie);
            viewHolder.textViewPasto = convertView.findViewById(R.id.textViewpasto);
            viewHolder.textViewNomePasto = convertView.findViewById(R.id.textViewnomepasto);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Calorie currentCalorie = calorieList.get(position);
        viewHolder.textViewID.setText(String.valueOf(currentCalorie.getId()));
        viewHolder.textViewData.setText(currentCalorie.getData());
        viewHolder.textViewNCalorie.setText(String.valueOf(currentCalorie.getNcalorie()));
        viewHolder.textViewPasto.setText(currentCalorie.getPasto());
        viewHolder.textViewNomePasto.setText(currentCalorie.getNomepasto());

        return convertView;
    }
}

package debari.roberto.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.R;
public class CustomListAdapter extends ArrayAdapter<Città> {
    private final Context context;
    private final Città[] items;
    public CustomListAdapter(Context context, Città[] items) {
        super(context, R.layout.list_item, items);
        this.context = context;
        this.items = items;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        TextView textView = (TextView) rowView.findViewById(R.id.textView);
        imageView.setImageResource(items[position].getImageResource());
        textView.setText(items[position].getText());
        return rowView;
    }
}

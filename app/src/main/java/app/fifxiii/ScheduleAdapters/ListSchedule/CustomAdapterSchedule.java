package app.fifxiii.ScheduleAdapters.ListSchedule;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import app.fifxiii.R;

public class CustomAdapterSchedule extends ArrayAdapter<ItemRowSchedule> {

    private Context context;

    public CustomAdapterSchedule(Context context, int id, List<ItemRowSchedule> itens){
        super(context, id, itens);
        this.context = context;
    }

    private class ViewHolder{
        TextView type, hour, place;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        ItemRowSchedule item = getItem(position);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_list_group, parent, false);
            holder = new ViewHolder();

            holder.type = (TextView) convertView.findViewById(R.id.typeSchedule);
            holder.hour = (TextView) convertView.findViewById(R.id.hourSchedule);
            holder.place = (TextView) convertView.findViewById(R.id.placeSchedule);

            convertView.setTag(holder);

        } else  holder = (ViewHolder) convertView.getTag();

        holder.type.setText(item.getType());
        holder.hour.setText(item.getHour());
        holder.place.setText(item.getLocal());

        return convertView;
    }

}

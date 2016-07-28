package app.fifxiii.ListGroup;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.fifxiii.R;

public class AdapterListGroup extends ArrayAdapter<ItemRowGroup> {

    private Context context;

    public AdapterListGroup(Context context, int id, List<ItemRowGroup> itens){
        super(context, id, itens);
        this.context = context;
    }

    private class ViewHolder{
        ImageView img;
        TextView name, country;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        ItemRowGroup item = getItem(position);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_list_group, parent, false);
            holder = new ViewHolder();

            // prepara
            holder.name = (TextView) convertView.findViewById(R.id.nameGroupList);
            holder.country = (TextView) convertView.findViewById(R.id.countryGroupList);
            holder.img = (ImageView) convertView.findViewById(R.id.imageGroupList);

            convertView.setTag(holder);

        } else  holder = (ViewHolder) convertView.getTag();

        // Popula
        holder.name.setText(item.getNameListGroup());
        holder.country.setText(item.getContrGroupy());
        holder.img.setImageDrawable(item.getImgListGroup());

        // View Group Layout
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.fade_in);
        convertView.findViewById(R.id.rootLayoutList).startAnimation(animation);

        return convertView;
    }
}

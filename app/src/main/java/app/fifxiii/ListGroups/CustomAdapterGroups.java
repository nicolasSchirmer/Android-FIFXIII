package app.fifxiii.ListGroups;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.fifxiii.AnimationAdapter;
import app.fifxiii.R;

public class CustomAdapterGroups extends ArrayAdapter<ItemRowGroups> {

    private Context context;

    public CustomAdapterGroups(Context context, int id, List<ItemRowGroups> itens){
        super(context, id, itens);
        this.context = context;
    }

    private class ViewHolder{
        ImageView img;
        TextView name, country;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        ItemRowGroups item = getItem(position);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_list_group, parent, false);
            holder = new ViewHolder();

            holder.name = (TextView) convertView.findViewById(R.id.nameGroupList);
            holder.country = (TextView) convertView.findViewById(R.id.countryGroupList);
            holder.img = (ImageView) convertView.findViewById(R.id.imageGroupList);

            convertView.setTag(holder);

        } else  holder = (ViewHolder) convertView.getTag();

        holder.name.setText(item.getNameListGroup());
        holder.country.setText(item.getContrGroupy());
        holder.img.setImageDrawable(item.getImgListGroup());

        AnimationAdapter anim = new AnimationAdapter(null);
        anim.fadeInFast(context, convertView.findViewById(R.id.rootLayoutList));

        return convertView;
    }

}

package app.fifxiii.ScheduleAdapters.PageViewSchedule;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import app.fifxiii.R;
import app.fifxiii.ScheduleAdapters.ListSchedule.CustomAdapterSchedule;
import app.fifxiii.ScheduleAdapters.ListSchedule.ItemRowSchedule;
import app.fifxiii.mFireData;

public class PageAdapterSchedule extends PagerAdapter {

    Context context;
    LayoutInflater mLayoutInflater;

    List<ItemRowSchedule> itemRowSchedule;

    FirebaseDatabase database;
    DatabaseReference myRef;

    public PageAdapterSchedule(Context context) {
        this.context = context;
        mLayoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        database =  mFireData.getDatabase();
    }

    @Override
    public int getCount(){
        return 9;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        myRef = database.getReference("agenda-pt/day" + position + "/");

        View itemView = mLayoutInflater.inflate(R.layout.list_schedule_item, container, false);

        final ListView listView = (ListView) itemView.findViewById(R.id.listSchedule);
        itemRowSchedule = new ArrayList<>();

/**
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(int i = 0; i < dataSnapshot.getChildrenCount(); i++){
                    ItemRowSchedule itemRowScheduleAux = new ItemRowSchedule();

                    itemRowScheduleAux.setType((String) dataSnapshot.child(String.valueOf(i)+ "/type").getValue());
                    itemRowScheduleAux.setHour((String) dataSnapshot.child(String.valueOf(i)+ "/hour").getValue());
                    itemRowScheduleAux.setLocal((String) dataSnapshot.child(String.valueOf(i)+ "/local").getValue());

                    itemRowSchedule.add(itemRowScheduleAux);

                }

                listView.setAdapter(new CustomAdapterSchedule(context, R.layout.list_schedule_item, itemRowSchedule));

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                        // do things
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });**/

        for(int i = 0; i < 3; i++){
            ItemRowSchedule itemRowScheduleAux = new ItemRowSchedule();

            itemRowScheduleAux.setType("oi");
            itemRowScheduleAux.setHour("12:12");
            itemRowScheduleAux.setLocal("bla");

            itemRowSchedule.add(itemRowScheduleAux);

        }


        //TODO app explodindo aqui
        //listView.setAdapter(new CustomAdapterSchedule(context, R.layout.list_schedule_item, itemRowSchedule));
/**
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                // do things
            }
        });**/

        // page view stuff
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
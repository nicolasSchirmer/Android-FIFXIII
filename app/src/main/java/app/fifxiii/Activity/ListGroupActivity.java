package app.fifxiii.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.fifxiii.ListGroup.CustomAdapterGroup;
import app.fifxiii.ListGroup.GroupLib;
import app.fifxiii.ListGroup.ItemRowGroup;
import app.fifxiii.Menu;
import app.fifxiii.R;

public class ListGroupActivity extends AppCompatActivity {

    Menu menu;
    List<ItemRowGroup> itemRowGroup;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_group);
        menu = new Menu(this);

        setGroupList();
    }

    private void setGroupList(){
        listView = (ListView) findViewById(R.id.listView);
        itemRowGroup = new ArrayList<>();

        for(int i = 0; i < GroupLib.groupCountry.length; i++){
            ItemRowGroup itemRowGroupsAux = new ItemRowGroup();

            itemRowGroupsAux.setContryGroup(this.getString(GroupLib.groupCountry[i]));
            itemRowGroupsAux.setNameListGroup(this.getString(GroupLib.groupName[i]));
            itemRowGroupsAux.setImglListGroup(GroupLib.groupFlag[i]);

            itemRowGroup.add(itemRowGroupsAux);
        }

        listView.setAdapter(new CustomAdapterGroup(this, R.layout.item_list_group, itemRowGroup));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                changeActivity(GroupActivity.class, pos);
            }
        });
    }


    public void hmbClick(View view){
        menu.showMenu();
    }

    public void homeClick(View view){
        prepareChangeActivity(MainActivity.class);
    }

    public void scheduleClick(View view){
        prepareChangeActivity(ScheduleActivity.class);
    }

    /** chance close for each activity **/
    public void groupClick(View view){
        menu.close();
    }

    public void infoClick(View view){
        prepareChangeActivity(InfoActivity.class);
    }

    public void aofClick(View view){
        prepareChangeActivity(AofActivity.class);
    }

    public void devClick(View view){
        prepareChangeActivity(DevActivity.class);
    }

    private void prepareChangeActivity(final Class mClass){
        menu.close();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                changeActivity(mClass);
            }
        }, 350);
    }

    public void changeActivity(Class mClass) {
        startActivity(new Intent(this, mClass));
        onPause();
    }

    public void changeActivity(Class mClass, int pos) {
        startActivity(new Intent(this, mClass).putExtra("Extra", pos));
        onPause();
    }

    @Override
    public void onBackPressed(){
        if(menu.isOpen()) menu.close();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 350);
    }
}

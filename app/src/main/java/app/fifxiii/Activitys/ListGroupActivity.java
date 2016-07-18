package app.fifxiii.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.fifxiii.AnimationAdapter;
import app.fifxiii.ListGroups.CustomAdapterGroups;
import app.fifxiii.ListGroups.GroupsLib;
import app.fifxiii.ListGroups.ItemRowGroups;
import app.fifxiii.Menu.MenuAdapter;
import app.fifxiii.R;
import mehdi.sakout.fancybuttons.FancyButton;

public class ListGroupActivity extends AppCompatActivity {

    private List<ItemRowGroups> itemRowGroups;
    ListView listView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_group);

        setViewMenu();
        setGroupList();
    }

    private void setGroupList(){
        listView = (ListView) findViewById(R.id.listView);
        itemRowGroups = new ArrayList<>();

        for(int i = 0; i < GroupsLib.getTotalGroups(); i++){
            ItemRowGroups itemRowGroupsAux = new ItemRowGroups();

            itemRowGroupsAux.setImgListGroup(GroupsLib.getDrwb(i, this));
            itemRowGroupsAux.setNameListGroup(this.getString(GroupsLib.groupName[i]));
            itemRowGroupsAux.setContryGroup(this.getString(GroupsLib.groupCountry[i]));

            itemRowGroups.add(itemRowGroupsAux);
        }

        setListAdapter();
    }

    private void setListAdapter(){
        listView.setAdapter(new CustomAdapterGroups(this, R.layout.item_list_group, itemRowGroups));

        setListAnimation();
    }

    private void setListAnimation(){
        AnimationAdapter anim = new AnimationAdapter(null);
        anim.fadeIn(this, listView);

        setListClick();
    }

    private void setListClick(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
            }
        });

        //setToolbarScrollAnim();
    }


    private void setToolbarScrollAnim(){
        final ImageView hamb = (ImageView) findViewById(R.id.hamButton);
        toolbar = (Toolbar) findViewById(R.id.toolbar_info);

    }


    private void setViewMenu(){
        final MenuAdapter menuAdapter = new MenuAdapter(this, ListGroupActivity.this);
        ImageButton hamBtn = (ImageButton) findViewById(R.id.hamButton);
        if(hamBtn != null) {
            hamBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    menuAdapter.showMenu();
                }
            });
        }

        setBts();
    }


    //TODO make this method global
    private void setBts(){
        final FancyButton home, schedule, info;

        home = (FancyButton) findViewById(R.id.homeBtn);
        if(home != null) {
            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeActivity(MainActivity.class);
                }
            });
        }

        schedule = (FancyButton) findViewById(R.id.scheduleBtn);
        if(schedule != null) {
            schedule.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeActivity(AgendaActivity1.class);
                }
            });
        }

        info = (FancyButton) findViewById(R.id.infoBtn);
        if(info != null) {
            info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeActivity(InfoActivity.class);
                }
            });
        }
    }

    private void changeActivity(Class mClass){
        Intent intent = new Intent(this, mClass);
        startActivity(intent);

        onPause();
    }

    @Override
    public void onPause(){
        super.onPause();

        finish();
    }
}

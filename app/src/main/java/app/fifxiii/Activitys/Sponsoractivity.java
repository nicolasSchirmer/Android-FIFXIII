package app.fifxiii.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import app.fifxiii.Menu.MenuAdapter;
import app.fifxiii.R;
import mehdi.sakout.fancybuttons.FancyButton;

public class Sponsoractivity extends AppCompatActivity {

    MenuAdapter menuAdapter;
    ImageButton hamBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);

        setViewMenu();
    }


    private void setViewMenu(){
        menuAdapter = new MenuAdapter(this, Sponsoractivity.this);
        hamBtn = (ImageButton) findViewById(R.id.hamButton);
        hamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuAdapter.showMenu();
            }
        });

        setBts();
    }


    //TODO make this method global
    private void setBts(){
        final FancyButton home, schedule, groups, info, dev;

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
                    changeActivity(MainActivity.class);
                }
            });
        }

        groups = (FancyButton) findViewById(R.id.groupsBtn);
        if(groups != null) {
            groups.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeActivity(MainActivity.class);
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

        dev = (FancyButton) findViewById(R.id.devBtn);
        if(dev != null) {
            dev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeActivity(MainActivity.class);
                }
            });
        }
    }

    private void changeActivity(Class mClass){
        Intent intent = new Intent(this, mClass);
        startActivity(intent);
    }
}

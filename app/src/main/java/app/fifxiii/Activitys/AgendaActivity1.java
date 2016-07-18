package app.fifxiii.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageButton;

import app.fifxiii.AnimationAdapter;
import app.fifxiii.Menu.MenuAdapter;
import app.fifxiii.R;
import mehdi.sakout.fancybuttons.FancyButton;

public class AgendaActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        setViewMenu();
        AnimationAdapter anim1 = new AnimationAdapter(null);
        anim1.slideFromLeft(this, findViewById(R.id.lay_agenda_card));
    }

    private void setViewMenu(){
        final MenuAdapter menuAdapter = new MenuAdapter(this, AgendaActivity1.this);
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
        final FancyButton home, info, groups;

        home = (FancyButton) findViewById(R.id.homeBtn);
        if(home != null) {
            home.setOnClickListener(new View.OnClickListener() {
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

        groups = (FancyButton) findViewById(R.id.groupsBtn);
        if(groups != null) {
            groups.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeActivity(ListGroupActivity.class);
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

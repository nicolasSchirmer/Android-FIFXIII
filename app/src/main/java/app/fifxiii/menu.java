package app.fifxiii;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.fifxiii.Activitys.ActivityControl;
import mehdi.sakout.fancybuttons.FancyButton;

public class menu extends AppCompatActivity {

    FancyButton home, schedule, groups, info, sponsor, dev;
    ActivityControl activityControl;

    FancyButton lastButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        activityControl = new ActivityControl();

        setButtons();
        checkWhatActIs();
    }

    private void setButtons(){
        home = (FancyButton) findViewById(R.id.homeBtn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(home ,1);
            }});

        schedule = (FancyButton) findViewById(R.id.scheduleBtn);
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(schedule ,2);
            }});

        groups = (FancyButton) findViewById(R.id.groupsBtn);
        groups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(groups, 3);
            }});

        info = (FancyButton) findViewById(R.id.infoBtn);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(info, 4);
            }});

        sponsor = (FancyButton) findViewById(R.id.sponserBtn);
        sponsor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(sponsor, 5);
            }});

        dev = (FancyButton) findViewById(R.id.devBtn);
        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(dev, 6);
            }});


    }

    private void checkWhatActIs(){

    }

    private void changeActivity(FancyButton button, int ind){
        //changeButtonColor(button);
        activityControl.setLast(ind);
    }

    private void changeButtonColor(FancyButton button){
        if(lastButton != null){
            lastButton.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        } else lastButton = button;

        button.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));

        lastButton = button;
    }
}

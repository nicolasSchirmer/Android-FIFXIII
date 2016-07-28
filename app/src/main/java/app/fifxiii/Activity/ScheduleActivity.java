package app.fifxiii.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import app.fifxiii.Menu;
import app.fifxiii.R;

public class ScheduleActivity extends AppCompatActivity {

    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        menu = new Menu(this);

        // TODO page view navigation
    }

    public void hmbClick(View view){
        menu.showMenu();
    }

    public void homeClick(View view){
        prepareChangeActivity(MainActivity.class);
    }

    public void scheduleClick(View view){
        menu.close();
    }

    public void groupClick(View view){
        prepareChangeActivity(ListGroupActivity.class);
    }

    public void infoClick(View view){
        prepareChangeActivity(InfoActivity.class);
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

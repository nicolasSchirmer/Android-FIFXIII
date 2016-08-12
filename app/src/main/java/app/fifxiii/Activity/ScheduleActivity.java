package app.fifxiii.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import app.fifxiii.Menu;
import app.fifxiii.PageViewGroup.PageAdapterGroup;
import app.fifxiii.R;
import app.fifxiii.ScheduleAdapters.PageViewSchedule.PageAdapterSchedule;
import me.relex.circleindicator.CircleIndicator;

public class ScheduleActivity extends AppCompatActivity {

    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        /** -- COPY THIS -- **/
        menu = new Menu(this);
        /** -- AND DOWN THERE -- **/

        // page viewr
        ViewPager pageView = (ViewPager) findViewById(R.id.viewpagerSchedule);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicatorSchedule);
        pageView.setAdapter(new PageAdapterSchedule(this));
        indicator.setViewPager(pageView);
    }

    /** ----  COPY IT ALL! ---- **/
    public void hmbClick(View view){
        menu.showMenu();
    }

    public void homeClick(View view){
        prepareChangeActivity(MainActivity.class);
    }

    /** chance close for each activity **/
    public void scheduleClick(View view){
        menu.close();
    }

    public void groupClick(View view){
        prepareChangeActivity(ListGroupActivity.class);
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

    @Override
    public void onBackPressed(){
        if(menu.isOpen()) menu.close();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 350);
    }

    /** ---- ENOUGH OF COPY PASTE ---- **/

}

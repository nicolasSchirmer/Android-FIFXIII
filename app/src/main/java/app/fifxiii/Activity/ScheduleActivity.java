package app.fifxiii.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import app.fifxiii.CustomPagerAdapter;
import app.fifxiii.Menu;
import app.fifxiii.R;

public class ScheduleActivity extends AppCompatActivity {

    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        /** -- COPY THIS -- **/
        //menu = new Menu(this);
        /** -- AND DOWN THERE -- **/

        // TODO page view navigation

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));
    }

    /** ----  COPY IT ALL! ---- **/
    public void hmbClick(View view){
        //menu.showMenu();
        onBackPressed();
    }

}

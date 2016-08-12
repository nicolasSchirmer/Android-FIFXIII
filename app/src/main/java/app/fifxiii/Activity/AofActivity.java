package app.fifxiii.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.util.Locale;

import app.fifxiii.Menu;
import app.fifxiii.R;

public class AofActivity extends AppCompatActivity {

    Menu menu;
    int scrollY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aof);

        /** -- COPY THIS -- **/
        setScrollAnimation();
        menu = new Menu(this);
        /** -- AND DOWN THERE -- **/
    }

    public void placeAofClick(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(
                String.format(Locale.ENGLISH, "geo:%f,%f?q=Av.+Gen.+Neto,+145", -28.2642531,-52.4063309)
        )));
    }

    /** ----  COPY IT ALL! ---- **/
    private void setScrollAnimation(){
        /** -- CHANGE THE RESOURCE SCROLLVIEW ID -- **/
        final ImageView hmb = (ImageView) findViewById(R.id.hamButtonAoffers);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarAoffers);
        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollViewAoffers);

        if(scrollView != null){
            scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    scrollY = scrollView.getScrollY() / 2;

                    // setAplha with int deprecated
                    if (scrollY > 0) {
                        if(scrollY < 255){
                            toolbar.setBackgroundColor(Color.argb(scrollY, 207, 173, 22));
                            hmb.setColorFilter(Color.argb(255 - scrollY, 207, 173, 22));
                        }
                        else {
                            toolbar.setBackgroundColor(Color.argb(255, 207, 173, 22));
                            hmb.setColorFilter(Color.argb(0, 207, 173, 22));
                        }
                    } else{
                        toolbar.setBackgroundColor(Color.argb(0, 207, 173, 22));
                        hmb.setColorFilter(Color.argb(255, 207, 173, 22));
                    }
                }});}
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

    public void groupClick(View view){
        prepareChangeActivity(ListGroupActivity.class);
    }

    public void devClick(View view){
        prepareChangeActivity(DevActivity.class);
    }

    public void infoClick(View view){
        prepareChangeActivity(InfoActivity.class);
    }

    /** chance close for each activity **/
    public void aofClick(View view){
        menu.close();
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


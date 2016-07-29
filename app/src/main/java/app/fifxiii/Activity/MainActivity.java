package app.fifxiii.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ScrollView;

import app.fifxiii.Menu;
import app.fifxiii.R;

public class MainActivity extends AppCompatActivity {

    int scrollY;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** -- COPY THIS -- **/
        menu = new Menu(this);
        /** -- AND DOWN THERE -- **/

        setScrollAnimation();
    }

    private void setScrollAnimation(){
        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        final ImageView mainImage = (ImageView) findViewById(R.id.mainImage);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if(scrollView != null){
            scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    scrollY = scrollView.getScrollY() / 3;

                    // setAplha com int deprecated
                    if (scrollY > 0) {
                        if(scrollY < 255){
                            toolbar.setBackgroundColor(Color.argb(scrollY, 207, 173, 22));
                            mainImage.setAlpha(255 - scrollY);
                        }
                        else {
                            toolbar.setBackgroundColor(Color.argb(255, 207, 173, 22));
                            mainImage.setAlpha(255);
                        }
                    } else{
                        toolbar.setBackgroundColor(Color.argb(0, 207, 173, 22));
                        mainImage.setAlpha(255);
                    }
                }});}
    }

    /** ----  COPY IT ALL! ---- **/

    public void hmbClick(View view){
        menu.showMenu();
    }

    public void homeClick(View view){
        menu.close();
    }

    public void scheduleClick(View view){
        prepareChangeActivity(ScheduleActivity.class);
    }

    public void groupClick(View view){
        prepareChangeActivity(ListGroupActivity.class);
    }

    public void infoClick(View view){
        prepareChangeActivity(InfoActivity.class);
    }

    private void prepareChangeActivity(final Class mClass){
        menu.close();

        // time for the close animation
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

        // time for the close animation
        new Handler().postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 350);
    }

    /** ---- OK! ENOUGH OF COPY PASTE ---- **/

}
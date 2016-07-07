package app.fifxiii.Activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import app.fifxiii.AnimationSet;
import app.fifxiii.MenuAdapter;
import app.fifxiii.R;
import mehdi.sakout.fancybuttons.FancyButton;

public class InfoActivity extends AppCompatActivity {

    Toolbar toolbar;
    int screenWidth, screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        setViewMenu();
        setAnimView();
        setScroll();
    }

    private void setAnimView(){
        final Context context = getBaseContext();
        AnimationSet anim1 = new AnimationSet(new AnimationSet.ListenerAnim() {
            @Override
            public void animationIsOver(boolean over) {
                AnimationSet anim = new AnimationSet(new AnimationSet.ListenerAnim() {
                    @Override
                    public void animationIsOver(boolean over) {
                        AnimationSet anim = new AnimationSet(new AnimationSet.ListenerAnim() {
                            @Override
                            public void animationIsOver(boolean over) {
                                AnimationSet anim = new AnimationSet(null);
                                anim.growFromBotton(context, findViewById(R.id.place_card));
                            }});
                        anim.slideFromRight(context, findViewById(R.id.email_card));
                    }});
                anim.slideFromLeft(context, findViewById(R.id.phone_card));
            }});
        anim1.fadeIn(this, findViewById(R.id.ticket_card));
    }

    private void getScreenSize(){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenWidth = displaymetrics.widthPixels;
        screenHeight = displaymetrics.heightPixels;
    }

    private void setScroll(){
        final ScrollView scrollView = (ScrollView) findViewById(R.id.scroll_info);
        final ImageView hamb = (ImageView) findViewById(R.id.hamButton);
        toolbar = (Toolbar) findViewById(R.id.toolbar_info);
        getScreenSize();

        if(scrollView != null){
            scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    int scrollY = scrollView.getScrollY();

                    // tentativa falha de melhorar performance, deixou s5 mais lento
                    //if(scrollY > oldScrollY +8 || scrollY < oldScrollY -8) {
                    if (scrollY > 0) {
                        if(scrollY < 255){
                            toolbar.setBackgroundColor(Color.argb(scrollY, 200, 160, 50));
                            hamb.setColorFilter(Color.argb(scrollY, 255, 255, 255));
                        }
                        else {
                            hamb.setColorFilter(Color.argb(255, 255, 255, 255));
                            toolbar.setBackgroundColor(Color.argb(255, 200, 160, 50));
                        }
                    } else {
                        toolbar.setBackgroundColor(Color.argb(0, 200, 160, 50));
                        hamb.setColorFilter(Color.argb(0, 255, 255, 255));
                    }
                    //} oldScrollY = scrollY;
                }});
        }
    }

    private void setViewMenu(){
        final MenuAdapter menuAdapter = new MenuAdapter(this, InfoActivity.this);
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
        final FancyButton home, schedule, groups, sponsor, dev;

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

        sponsor = (FancyButton) findViewById(R.id.sponserBtn);
        if(sponsor != null) {
            sponsor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeActivity(MainActivity.class);
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

        finish();
    }
}

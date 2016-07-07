package app.fifxiii.Activitys;

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
import android.widget.ScrollView;

import app.fifxiii.AnimationSet;
import app.fifxiii.MenuAdapter;
import app.fifxiii.R;
import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity {

    ImageButton hamBtn;
    ScrollView scrollView;
    ImageView glassView;
    Toolbar toolbar;
    int screenWidth, screenHeight, scrollY;
    MenuAdapter menuAdapter;
    //int oldScrollY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getScreenSize();
        setViews();
    }

    private void getScreenSize(){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenWidth = displaymetrics.widthPixels;
        screenHeight = displaymetrics.heightPixels;
    }


    //TODO make the performance better, now it's clunky and slow
    private void setViews(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        glassView = (ImageView) findViewById(R.id.imageGlass);

        setAnimView();

        setViewMenu();

        scrollView = (ScrollView) findViewById(R.id.scroll);
        if(scrollView != null){
            scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    scrollY = scrollView.getScrollY();

                    // tentativa falha de melhorar performance, deixou s5 mais lento
                    //if(scrollY > oldScrollY +8 || scrollY < oldScrollY -8) {
                        if (scrollY > 0) {
                            glassView.setAlpha((float) scrollY / (screenHeight + 250));
                            int alpha = scrollY / ((screenHeight) / 402);
                            if (alpha < 255)
                                toolbar.setBackgroundColor(Color.argb(alpha, 200, 160, 50));
                            else toolbar.setBackgroundColor(Color.argb(255, 200, 160, 50));
                        } else {
                            glassView.setAlpha(0f);
                            toolbar.setBackgroundColor(Color.argb(0, 200, 160, 50));
                        }
                    //} oldScrollY = scrollY;
                }});
        }
    }

    private void setAnimView(){
        final Context context = getBaseContext();
        AnimationSet anim1 = new AnimationSet(new AnimationSet.ListenerAnim() {
            @Override
            public void animationIsOver(boolean over) {
                AnimationSet anim = new AnimationSet(new AnimationSet.ListenerAnim() {
                    @Override
                    public void animationIsOver(boolean over) {
                        AnimationSet anim = new AnimationSet(null);
                        anim.growFromTop(context, findViewById(R.id.text_init));
                    }
                });
                anim.slideFromLeft(context, findViewById(R.id.title_init_screen));
            }
        });
        anim1.fadeIn(this, findViewById(R.id.imageViewMain));
    }

    private void setViewMenu(){
        menuAdapter = new MenuAdapter(this, MainActivity.this);
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
        final FancyButton schedule, groups, info, sponsor, dev;


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

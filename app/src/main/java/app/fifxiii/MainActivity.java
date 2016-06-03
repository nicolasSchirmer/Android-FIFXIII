package app.fifxiii;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity {

    ImageButton hamBtn;
    SlidingMenu menu;
    ScrollView scrollView;
    ImageView glassView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lateralMenu();

        setViews();
    }

    private void lateralMenu(){
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.menu);
    }

    private void setViews(){
        hamBtn = (ImageButton) findViewById(R.id.hamButton);
        hamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.showMenu();
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        glassView = (ImageView) findViewById(R.id.imageGlass);

        scrollView = (ScrollView) findViewById(R.id.scroll);
        if(scrollView != null){
            scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    int scrollY = scrollView.getScrollY();
                    if(scrollY > 0){
                        glassView.setAlpha(scrollY/2000f);
                        if(scrollY/4 < 255) toolbar.setBackgroundColor(Color.argb(scrollY/4, 200, 160, 50));
                        else toolbar.setBackgroundColor(Color.argb(255, 200, 160, 50));
                    } else {
                        glassView.setAlpha(0f);
                        toolbar.setBackgroundColor(Color.argb(0, 200, 160, 50));
                    }
                }});
        }

    }
}

package app.fifxiii;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    SlidingMenu menu;

    public Menu(){menu = null;}

    public Menu(Activity activity){
        menu = new SlidingMenu(activity);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(activity, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.activity_menu);
    }

    public void showMenu(){
        menu.showMenu();
    }

    public boolean isOpen() {
        return menu.isMenuShowing();
    }

    public void lock(boolean b){
        menu.setSlidingEnabled(b);
    }

    public void close() {
        menu.toggle();
    }
}

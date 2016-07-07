package app.fifxiii;


import android.app.Activity;
import android.content.Context;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MenuAdapter {

    SlidingMenu menu;

    public MenuAdapter(Context context, Activity activity){
        menu = new SlidingMenu(context);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(activity, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.menu);
    }

    public void showMenu(){
        menu.showMenu();
    }


}

package app.fifxiii.Activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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

import com.afollestad.materialdialogs.MaterialDialog;

import java.net.URISyntaxException;
import java.util.Locale;

import app.fifxiii.Menu;
import app.fifxiii.R;

public class InfoActivity extends AppCompatActivity {

    int scrollY;
    Menu menu;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        context = this;

        /** -- COPY THIS -- **/
        setScrollAnimation();
        menu = new Menu(this);
        /** -- AND DOWN THERE -- **/
    }

    public void phoneClick(View view){
        new MaterialDialog.Builder(this)
                .title(R.string.call)
                .items(R.array.phones)
                .itemsCallbackSingleChoice(2, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        // which is the position
                        // text is the string

                        Intent intent;
                        // verifica se tem permissão pra ligar
                        if(context.checkCallingOrSelfPermission("android.permission.CALL_PHONE")
                                == PackageManager.PERMISSION_GRANTED){
                            // se tem permissao liga direto
                            intent = new Intent(Intent.ACTION_CALL);
                        } else {
                            // se não der apenas disca o numero
                            intent = new Intent(Intent.ACTION_DIAL);
                        }
                        intent.setData(Uri.parse("tel:" + text));
                        context.startActivity(intent);

                        return true;
                    }
                })
                .positiveText(R.string.call_confirm)
                .negativeText(R.string.call_deny)
                .show();
    }

    public void emailClick(View view){
        try {
            startActivity(Intent.parseUri("mailto:cioffrs@annex.com.br", Intent.URI_INTENT_SCHEME));
        } catch (URISyntaxException e){ e.printStackTrace(); }
    }

    public void placeClick(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(
                String.format(Locale.ENGLISH, "geo:%f,%f?q=Parque+da+Gare", -28.2667053, -52.405291)
        )));
    }

    public void siteClick(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.festivalpf.com.br/")));
    }

    public void facebookClick(View view){
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/755389934554832")));
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/festivalpf")));
        }
    }

    public void youtubeClick(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=vBpWDKqQs94")));
    }

    public void twitterClick(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Festival_PF")));
    }

    public void instagramClick(View view){
        Intent likeIng = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_u/festivalpf"));
        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/festivalpf")));
        }
    }


    /** ----  COPY IT ALL! ---- **/
    private void setScrollAnimation(){
        /** -- CHANGE THE RESOURCE SCROLLVIEW ID -- **/
        final ImageView hmb = (ImageView) findViewById(R.id.hamButtonInfo);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarInfo);
        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollViewInfo);

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

    /** chance close for each activity **/
    public void infoClick(View view){
        menu.close();
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

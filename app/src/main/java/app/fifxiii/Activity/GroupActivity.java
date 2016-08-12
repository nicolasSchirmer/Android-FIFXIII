package app.fifxiii.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import app.fifxiii.ListGroup.GroupLib;
import app.fifxiii.PageViewGroup.PageAdapterGroup;
import app.fifxiii.R;
import app.fifxiii.mFireData;
import me.relex.circleindicator.CircleIndicator;

public class GroupActivity extends AppCompatActivity {

    Intent intent;
    Context context;
    int scrollY, group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        intent = getIntent();
        Bundle bundle = intent.getExtras();
        group = bundle.getInt("Extra");

        context = getBaseContext();

        setScrollAnimation();

        setContent();
    }

    private void setContent() {
        TextView name = (TextView) findViewById(R.id.nameGroup);
        name.setText(GroupLib.groupName[group]);

        TextView country = (TextView) findViewById(R.id.countryGroup);
        country.setText(GroupLib.groupCountry[group]);

        TextView desc = (TextView) findViewById(R.id.descGroup);
        desc.setText(GroupLib.groupDesc[group]);

        ImageView imageView = (ImageView) findViewById(R.id.flagGroup);
        imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), GroupLib.groupFlag[group], null));

        ViewPager pageView = (ViewPager) findViewById(R.id.pageViewGroup);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicatorGroup);
        pageView.setAdapter(new PageAdapterGroup(context, group));
        indicator.setViewPager(pageView);
    }

    private void setScrollAnimation(){
        /** -- CHANGE THE RESOURCE SCROLLVIEW ID -- **/
        final ImageView back = (ImageView) findViewById(R.id.backButtonGroup);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarGroup);
        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollViewGroup);

        back.setColorFilter(Color.argb(255, 207, 173, 22));

        if(scrollView != null){
            scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    scrollY = scrollView.getScrollY() / 2;

                    // setAplha with int deprecated
                    if (scrollY > 0) {
                        if(scrollY < 255){
                            toolbar.setBackgroundColor(Color.argb(scrollY, 207, 173, 22));
                            back.setColorFilter(Color.argb(255 - scrollY, 207, 173, 22));
                        }
                        else {
                            toolbar.setBackgroundColor(Color.argb(255, 207, 173, 22));
                            back.setColorFilter(Color.argb(0, 207, 173, 22));
                        }
                    } else{
                        toolbar.setBackgroundColor(Color.argb(0, 207, 173, 22));
                        back.setColorFilter(Color.argb(255, 207, 173, 22));
                    }
                }});}
    }

    public void backClick(View view){
        onBackPressed();
    }
}

package app.fifxiii.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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

import app.fifxiii.PageViewGroup.PageAdapterGroup;
import app.fifxiii.R;
import app.fifxiii.mFireData;
import me.relex.circleindicator.CircleIndicator;

public class GroupActivity extends AppCompatActivity {

    Intent intent;
    String group;
    Context context;
    int scrollY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        intent = getIntent();
        Bundle bundle = intent.getExtras();
        group = bundle.getString("Extra");

        context = getBaseContext();

        setScrollAnimation();

        setContent();
    }

    private void setContent() {
        FirebaseDatabase database = mFireData.getDatabase();

        if (database != null) {
            // TODO language suport ...+ Locale.getDefault().getLanguage()...  en, es, pt, fr, de
            DatabaseReference myRef = database.getReference("grupos-en/");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {

                    TextView name = (TextView) findViewById(R.id.nameGroup);
                    name.setText((String) snapshot.child(group + "/name").getValue());

                    TextView country = (TextView) findViewById(R.id.countryGroup);
                    country.setText((String) snapshot.child(group + "/country").getValue());

                    TextView desc = (TextView) findViewById(R.id.descGroup);
                    desc.setText((String) snapshot.child(group + "/description").getValue());

                    Picasso.with(context)
                            .load((String) snapshot.child(group + "/flag").getValue())
                            .fit().centerInside()
                            .into((ImageView) findViewById(R.id.flagGroup));

                    ViewPager pageView = (ViewPager) findViewById(R.id.pageViewGroup);
                    CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicatorGroup);
                    pageView.setAdapter(new PageAdapterGroup(context, group));
                    indicator.setViewPager(pageView);
                }

                @Override
                public void onCancelled(DatabaseError firebaseError) {
                }
            });
        }
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

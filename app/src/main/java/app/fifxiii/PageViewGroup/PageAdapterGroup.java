package app.fifxiii.PageViewGroup;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import app.fifxiii.R;
import app.fifxiii.mFireData;

// http://codetheory.in/android-image-slideshow-using-viewpager-pageradapter/

public class PageAdapterGroup extends PagerAdapter {

    Context context;
    LayoutInflater mLayoutInflater;
    String group;

    public PageAdapterGroup(Context context, String group) {
        this.context = context;
        this.group = group;
        mLayoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = mLayoutInflater.inflate(R.layout.page_group_item, container, false);
        final ImageView imageView = (ImageView) itemView.findViewById(R.id.mainImageGroup);

        FirebaseDatabase database = mFireData.getDatabase();
        if(database != null) {
            DatabaseReference myRef = database.getReference("grupos-en/");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    Picasso.with(context)
                            .load((String) snapshot.child(group + "/photo"+ String.valueOf(position)).getValue())
                            .fit().centerCrop()
                            .into(imageView);
                }

                @Override
                public void onCancelled(DatabaseError firebaseError) {
                }
            });
        }

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
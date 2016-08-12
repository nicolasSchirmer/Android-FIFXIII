package app.fifxiii.PageViewGroup;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import app.fifxiii.ListGroup.GroupLib;
import app.fifxiii.R;
import app.fifxiii.mFireData;

// http://codetheory.in/android-image-slideshow-using-viewpager-pageradapter/

public class PageAdapterGroup extends PagerAdapter {

    Context context;
    LayoutInflater mLayoutInflater;
    int group;

    public PageAdapterGroup(Context context, int group) {
        this.context = context;
        this.group = group;
        mLayoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return GroupLib.groupPics[group].length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = mLayoutInflater.inflate(R.layout.page_group_item, container, false);
        final ImageView imageView = (ImageView) itemView.findViewById(R.id.mainImageGroup);

        imageView.setImageResource(GroupLib.groupPics[group][position]);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
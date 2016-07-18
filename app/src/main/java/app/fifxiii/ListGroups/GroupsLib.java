package app.fifxiii.ListGroups;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;

import app.fifxiii.R;

public class GroupsLib {

    final static public int[] groupName = {
            R.string.g0name, R.string.g1name, R.string.g2name, R.string.g3name,
            R.string.g4name, R.string.g5name, R.string.g6name, R.string.g7name,
            R.string.g8name, R.string.g9name, R.string.g10name, R.string.g11name,
            R.string.g12name, R.string.g13name
    };

    final static public int[] groupCountry = {
            R.string.g0country, R.string.g1country, R.string.g2country, R.string.g3country,
            R.string.g4country, R.string.g5country, R.string.g6country, R.string.g7country,
            R.string.g8country, R.string.g9country, R.string.g10country, R.string.g11country,
            R.string.g12country, R.string.g13country
    };

    static public Drawable getDrwb(int i, Context context){
        int r = R.drawable.argentina;
        switch (i){
            case 0: r = R.drawable.argentina; break;
            case 1: r = R.drawable.belgica; break;
            case 2: r = R.drawable.bolivia; break;
            case 3: r = R.drawable.chile; break;
            case 4: r = R.drawable.colombia; break;
            case 5: r = R.drawable.eua; break;
            case 6: r = R.drawable.goias; break;
            case 7: r = R.drawable.guam; break;
            case 8: r = R.drawable.letonia; break;
            case 9: r = R.drawable.matogrosso; break;
            case 10: r = R.drawable.mexico; break;
            case 11: r = R.drawable.peru; break;
            case 12: r = R.drawable.senegal; break;
            case 13: r = R.drawable.uruguai; break;

        }
        return ResourcesCompat.getDrawable(context.getResources(), r, null);
    }

    static public int getTotalGroups(){
        return groupName.length;
    }

}

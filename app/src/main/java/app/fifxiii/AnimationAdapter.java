package app.fifxiii;


import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class AnimationAdapter {

    private boolean hasListener;

    /**===========================**/
    public interface ListenerAnim{
        void animationIsOver(boolean over);
    }
    ListenerAnim listenerAnim = null;
    /**==========================**/

    public AnimationAdapter(ListenerAnim listener){
        if(listener != null) {
            hasListener = true;
            listenerAnim = listener;

        } else hasListener = false;
    }

    public void fadeIn(Context context, View view){ animate(context, view, R.anim.fade_in); }

    public void fadeInFast(Context context, View view){ animate(context, view, R.anim.fade_in_fast); }

    public void growFromBotton(Context context, View view){
        animate(context, view, R.anim.cres_gradual_baixocima);
    }

    public void growFromTop(Context context, View view){
        animate(context, view, R.anim.cres_gradual_cimabaixo);
    }

    public void slideFromLeft(Context context, View view){
        animate(context, view, R.anim.slide_esqdir);
    }

    public void slideFromRight(Context context, View view){
        animate(context, view, R.anim.slide_diresq);
    }

    private void animate(Context context, final View view, int resource){
        Animation animation = AnimationUtils.loadAnimation(context, resource);
        view.clearAnimation();
        view.startAnimation(animation);

        if(hasListener){
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {}

                @Override
                public void onAnimationEnd(Animation animation) {
                    view.setVisibility(View.VISIBLE);
                    listenerAnim.animationIsOver(true);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {}});

        } else view.setVisibility(View.VISIBLE);
    }
}

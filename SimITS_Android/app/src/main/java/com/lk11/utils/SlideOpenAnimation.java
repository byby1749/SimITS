package com.lk11.utils;

import android.view.Gravity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class SlideOpenAnimation extends TranslateAnimation implements Animation.AnimationListener {

    private RelativeLayout mainLayout;
    int panelWidth;

    public SlideOpenAnimation(RelativeLayout layout, int width, int fromXType,
                                 float fromXValue, int toXType, float toXValue, int fromYType,
                                 float fromYValue, int toYType, float toYValue) {

        super(fromXType, fromXValue, toXType, toXValue, fromYType, fromYValue,
                toYType, toYValue);

        // init
        mainLayout = layout;
        panelWidth = width;
        setDuration(250);
        setFillAfter(false);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
        mainLayout.startAnimation(this);
    }

    public void onAnimationEnd(Animation arg0) {

        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mainLayout.getLayoutParams();
        params.leftMargin = panelWidth;
        params.gravity = Gravity.LEFT;
        mainLayout.clearAnimation();
        mainLayout.setLayoutParams(params);
        mainLayout.requestLayout();

    }

    public void onAnimationRepeat(Animation arg0) {

    }

    public void onAnimationStart(Animation arg0) {

    }


}

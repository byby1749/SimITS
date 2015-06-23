package com.lk11.fragment_views;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lk11.simits.R;
import com.lk11.utils.SlideCloseAnimation;
import com.lk11.utils.SlideOpenAnimation;

public class StartupActivity extends Fragment implements View.OnClickListener {

    private DisplayMetrics dpMetrics;
    private LinearLayout slideMenu_Layout;
    private RelativeLayout slideMain_Layout;
    private FrameLayout.LayoutParams slideMenu_LayoutParams;
    private int slideMenuWidth;
    private static boolean isSlideExpanded;

    private Button btn_left;

    private View rootView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootview = inflater.inflate(R.layout.activity_startup,container, false);
        rootView = rootview;
        initSlideMenu();
        return rootview;
    }

    private void initSlideMenu(){
        dpMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager)rootView.getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dpMetrics);
        slideMenuWidth = (int) ((dpMetrics.widthPixels) * 0.20);

        slideMain_Layout = (RelativeLayout)rootView.findViewById(R.id.slideMain_RelativeLayout_StartupActivity);

        slideMenu_Layout = (LinearLayout)rootView.findViewById(R.id.slideMenu_LinearLayout_StartupActivity);
        slideMenu_LayoutParams = (FrameLayout.LayoutParams)slideMenu_Layout.getLayoutParams();
        slideMenu_LayoutParams.width = slideMenuWidth;
        slideMenu_Layout.setLayoutParams(slideMenu_LayoutParams);


        btn_left = (Button)rootView.findViewById(R.id.slideAction_Button_StartupActivity);
        btn_left.setOnClickListener(this);
    }

    private void menuLeftSlideAnimationToggle() {

        if (!isSlideExpanded) {

            isSlideExpanded = true;

            // Expand
            new SlideOpenAnimation(slideMain_Layout, slideMenuWidth,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.20f, 0, 0.0f, 0, 0.0f);

            // disable all of main view
            FrameLayout viewGroup = (FrameLayout)rootView.findViewById(R.id.slideMainView_RelativeLayout_StartupActivity)
                    .getParent();
            enableDisableViewGroup(viewGroup, true);

            // enable empty view
//            ((LinearLayout) rootView.findViewById(R.id.ll_empty))
//                    .setVisibility(View.VISIBLE);

            //특정 Touch 패턴으로 창을 닫을수 있어야 한다.
//            rootView.findViewById(R.id.ll_empty).setEnabled(true);
//            rootView.findViewById(R.id.ll_empty).setOnTouchListener(
//                    new View.OnTouchListener() {
//
//                        @Override
//                        public boolean onTouch(View arg0, MotionEvent arg1) {
//                            menuLeftSlideAnimationToggle();
//                            return true;
//                        }
//                    });

        } else {
            isSlideExpanded = false;

            // close
            new SlideCloseAnimation(slideMain_Layout, slideMenuWidth,
                    TranslateAnimation.RELATIVE_TO_SELF, 0.20f,
                    TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f);

            // enable all of main view
            FrameLayout viewGroup = (FrameLayout)rootView.findViewById(R.id.slideMainView_RelativeLayout_StartupActivity)
                    .getParent();
            enableDisableViewGroup(viewGroup, true);

            // disable empty view
//            ((LinearLayout) rootView.findViewById(R.id.ll_empty))
//                    .setVisibility(View.GONE);
//            rootView.findViewById(R.id.ll_empty).setEnabled(false);

        }
    }

    public static void enableDisableViewGroup(ViewGroup viewGroup, boolean enabled) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = viewGroup.getChildAt(i);
            if (view.getId() != R.id.slideAction_Button_StartupActivity) {
                view.setEnabled(enabled);
                if (view instanceof ViewGroup) {
                    enableDisableViewGroup((ViewGroup) view, enabled);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.slideAction_Button_StartupActivity:
                menuLeftSlideAnimationToggle();
                break;
        }
    }
}

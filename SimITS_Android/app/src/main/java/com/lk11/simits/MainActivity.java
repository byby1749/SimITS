package com.lk11.simits;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.lk11.fragment_views.DailyplanActivity;
import com.lk11.fragment_views.SignalmapActivity;
import com.lk11.fragment_views.SpecialcmdActivity;
import com.lk11.fragment_views.StartupActivity;
import com.lk11.fragment_views.TrafficledStateActivity;
import com.lk11.fragment_views.TrafficledStateGraphicActivity;

import java.util.ArrayList;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener{

    ViewSectionsPagerAdapter mViewSectionsPagerAdapter;
    ViewPager mViewPager;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onInitMainView();
    }


    private void onInitMainView(){
        mViewSectionsPagerAdapter = new ViewSectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager)findViewById(R.id.viewPager_MainActivity);
        mViewPager.setAdapter(mViewSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(simpleOnPageChangeListener);

        actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for (int i=0; i<mViewSectionsPagerAdapter.getCount(); i++){
            actionBar.addTab(actionBar.newTab()
                                .setText(mViewSectionsPagerAdapter.getPageTitle(i))
                                .setTabListener(this));

        }

    }

    private ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener = new ViewPager.SimpleOnPageChangeListener(){
        @Override
        public void onPageSelected(int position){
            //To-Do : Swipe Page Changed Actions
            actionBar.setSelectedNavigationItem(position);
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == android.R.id.home) {

            Toast toast = Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction){
        //TO-Do: TabUnselected
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction){
        //TO-DO : TabReselected
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction){
        //To-Do : TabSelected
        mViewPager.setCurrentItem(tab.getPosition());
    }




    //-----
    public class ViewSectionsPagerAdapter extends FragmentPagerAdapter {

        private String[] titles = {"신호등 상태(Graphic)","신호등 상태(Text)","Startup Code","Signal Map","Daily Plan","Special Command"};
        private ArrayList<Fragment> frgList;

        public ViewSectionsPagerAdapter(FragmentManager fm){
            super(fm);
            setFragmentList();
        }

        private void setFragmentList(){
            frgList = new ArrayList<Fragment>();
            frgList.add(new TrafficledStateGraphicActivity());
            frgList.add(new TrafficledStateActivity());
            frgList.add(new StartupActivity());
            frgList.add(new SignalmapActivity());
            frgList.add(new DailyplanActivity());
            frgList.add(new SpecialcmdActivity());
        }

        @Override
        public Fragment getItem(int position){
            //TO-DO : Fragment class Create & Return
            Fragment fragment = frgList.get(position);

            // To-Do : 전달하고자 하는 인자를 args에 넣어서 Fragment에 넘겨 준다.
            // Object 가 넘어갈수 있는지 확인...
            Bundle args = new Bundle();

            return fragment;
        }

        @Override
        public int getCount(){
            //TO-DO : Create Fragment List :: Count;
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position){
            return titles[position];
        }
    }
}

package com.lk11.simits;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.Notification;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener{

    ViewSectionsPagerAdapter mViewSectionsPagerAdapter;
    ViewPager mViewPager;

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

        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

    }

    private ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener = new ViewPager.SimpleOnPageChangeListener(){
        @Override
        public void onPageSelected(int position){
            //To-Do : Swipe Page Changed Actions
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
        public ViewSectionsPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position){
            Fragment fragment = null;
            //TO-DO : Fragment class Create & Return
            return fragment;
        }

        @Override
        public int getCount(){
            //TO-DO : Create Fragment List :: Count;
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position){
            return "Section" + (position+1);
        }
    }
}

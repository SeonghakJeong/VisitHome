package com.example.visithome;

import java.util.HashMap;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TextView;

public class HomeActivity  extends FragmentActivity implements TabHost.OnTabChangeListener {
 
    public TabHost mTabHost;
    public HashMap mapTabInfo = new HashMap();
    public TabInfo mLastTab = null;
 
    private class TabInfo {
         private String tag;
         private Class clss;
         private Bundle args;
         private Fragment fragment;
         TabInfo(String tag, Class clazz, Bundle args) {
             this.tag = tag;
             this.clss = clazz;
             this.args = args;
             
         }
 
    }
 
    class TabFactory implements TabContentFactory {
 
        private final Context mContext;
 
        /**
         * @param context
         */
        public TabFactory(Context context) {
            mContext = context;
        }
 
        /** (non-Javadoc)
         * @see android.widget.TabHost.TabContentFactory#createTabContent(java.lang.String)
         */
        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }
 
    }
    /** (non-Javadoc)
     * @see android.support.v4.app.FragmentActivity#onCreate(android.os.Bundle)
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Step 1: Inflate layout
        setContentView(R.layout.homelayout);
        // Step 2: Setup TabHost
        //mTabHost.getTabWidget().setDividerDrawable(R.drawable.tab_divider);
        
        initialiseTabHost(savedInstanceState);
        if (savedInstanceState != null) {
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab")); //set the tab as per the saved state
        }
    }
 
    /** (non-Javadoc)
     * @see android.support.v4.app.FragmentActivity#onSaveInstanceState(android.os.Bundle)
     */
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("tab", mTabHost.getCurrentTabTag()); //save the tab selected
        super.onSaveInstanceState(outState);
    }
 
    /**
     * Step 2: Setup TabHost
     */
    private void initialiseTabHost(Bundle args) {
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        TabInfo tabInfo = null;
        HomeActivity.addTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab1").setIndicator("홈"), ( tabInfo = new TabInfo("Tab1", HomeFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        HomeActivity.addTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab2").setIndicator("놀러가기"), ( tabInfo = new TabInfo("Tab2", VisitFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        HomeActivity.addTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab3").setIndicator("설정"), ( tabInfo = new TabInfo("Tab3", SettingFragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        // Default to first tab
        this.onTabChanged("Tab1");
        //mTabHost.getTabWidget().setDividerDrawable(R.drawable.tab_divider);
        mTabHost.setOnTabChangedListener(this);
    }
 
    /**
     * @param activity
     * @param tabHost
     * @param tabSpec
     * @param clss
     * @param args
     */
    private static void addTab(HomeActivity activity, TabHost tabHost, TabHost.TabSpec tabSpec, TabInfo tabInfo) {
        // Attach a Tab view factory to the spec
        tabSpec.setContent(activity.new TabFactory(activity));
        String tag = tabSpec.getTag();
 
        // Check to see if we already have a fragment for this tab, probably
        // from a previously saved state.  If so, deactivate it, because our
        // initial state is that a tab isn't shown.
        tabInfo.fragment = activity.getSupportFragmentManager().findFragmentByTag(tag);
        if (tabInfo.fragment != null && !tabInfo.fragment.isDetached()) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
            ft.detach(tabInfo.fragment);
            ft.commit();
            activity.getSupportFragmentManager().executePendingTransactions();
        }
 
        tabHost.addTab(tabSpec);
    }
 
    /** (non-Javadoc)
     * @see android.widget.TabHost.OnTabChangeListener#onTabChanged(java.lang.String)
     */
    public void onTabChanged(String tag) {
        TabInfo newTab = (TabInfo) this.mapTabInfo.get(tag);
        if (mLastTab != newTab) {
            FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
            if (mLastTab != null) {
                if (mLastTab.fragment != null) {
                    ft.detach(mLastTab.fragment);
                }
            }
            if (newTab != null) {
                if (newTab.fragment == null) {
                    newTab.fragment = Fragment.instantiate(this,
                            newTab.clss.getName(), newTab.args);
                    ft.add(R.id.realtabcontent, newTab.fragment, newTab.tag);
                } else {
                    ft.attach(newTab.fragment);
                }
            }
 
            mLastTab = newTab;
            ft.commit();
            this.getSupportFragmentManager().executePendingTransactions();
            setTabColor(mTabHost);
            
        }
    }
    public static void setTabColor(TabHost tabhost) {
    	String strColor = "#bffc8d";
    	String strColor1 = "#FFFFFF";
    	for(int i=0;i<tabhost.getTabWidget().getChildCount();i++)
        {
            tabhost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#039E79")); //unselected
            RelativeLayout relLayout = (RelativeLayout)tabhost.getTabWidget().getChildAt(i); 
            TextView tv = (TextView)relLayout.getChildAt(1); 
            tv.setTextSize(30);
            tv.setTextColor(Color.parseColor(strColor));
        }
        tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab()).setBackgroundColor(Color.parseColor("#538477")); // selected
        RelativeLayout relLayout = (RelativeLayout)tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab()); 
        TextView tv1 = (TextView)relLayout.getChildAt(1); 
        tv1.setTextSize(30);
        tv1.setTextColor(Color.parseColor(strColor1));
    }
}
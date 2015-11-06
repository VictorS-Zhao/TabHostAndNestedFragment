package com.longlong.ex.tabhostandnestedfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    private FragmentTabHost mTabHost;

    private static final String TAB_COMMUNITY_TAG = "tab_community";
    private static final String TAB_USER_TAG = "tab_user";

    private String[] tabTags = {TAB_COMMUNITY_TAG, TAB_USER_TAG};

    private Class<?> tabContainerFragments[] = {
            CommunityContainerFragment.class,
            UserContainerFragment.class};

    private String tabLabels[] = {"community", "user"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.getTabWidget().setDividerDrawable(null);
        mTabHost.getTabWidget().setStripEnabled(false);

        for (int i = 0; i < tabContainerFragments.length; i++) {
            mTabHost.addTab(mTabHost.newTabSpec(tabTags[i]).setIndicator(tabLabels[i]),
                    tabContainerFragments[i], null);
        }
    }

    @Override
    public void onBackPressed() {
        boolean isPopFragment = false;
        String currentTabTag = mTabHost.getCurrentTabTag();
        Log.e(TAG, "onBackPressed, currentTabTag: " + currentTabTag);

        isPopFragment = ((BaseContainerFragment) getSupportFragmentManager().findFragmentByTag(currentTabTag)).popFragment();
        if (!isPopFragment) {
//            finish();
            super.onBackPressed();
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
//        super.onActivityResult(requestCode, resultCode, intent);
//
////        getSupportFragmentManager().findFragmentByTag(TAB_USER_TAG).onActivityResult(requestCode, resultCode, intent);
//    }

    //    @Override
    //    public void onWindowFocusChanged(boolean hasFocus) {
    //        super.onWindowFocusChanged(hasFocus);
    //        Log.e(TAG, "hasFocus: " + hasFocus);
    //        if (hasFocus) {
    //            getWindow().getDecorView().setSystemUiVisibility(
    //                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    //                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    //                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    //                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    //                            | View.SYSTEM_UI_FLAG_FULLSCREEN
    //                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    //    }
}

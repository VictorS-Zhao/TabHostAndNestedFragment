package com.longlong.ex.tabhostandnestedfragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import java.util.List;

public abstract class BaseActivity extends FragmentActivity {

    private static final String TAG = "BaseActivity";

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
//        super.onActivityResult(requestCode, resultCode, intent);
//
//        FragmentManager fm = getSupportFragmentManager();
//
//        Log.e(TAG, "getBackStackEntryCount: " + fm.getBackStackEntryCount());
//
//        int index = requestCode >> 16;
//        if (index != 0) {
//            index--;
//            if (fm.getFragments() == null || index < 0
//                    || index >= fm.getFragments().size()) {
//                Log.w(TAG, "Activity result fragment index out of range: 0x"
//                        + Integer.toHexString(requestCode));
//                return;
//            }
//            Fragment frag = fm.getFragments().get(index);
//            if (frag == null) {
//                Log.w(TAG, "Activity result no fragment exists for index: 0x"
//                        + Integer.toHexString(requestCode));
//            } else {
//                handleResult(frag, requestCode, resultCode, intent);
//            }
//            return;
//        }
//    }

    /**
     *
     * @param frag
     * @param requestCode
     * @param resultCode
     * @param data
     */
    private void handleResult(Fragment frag, int requestCode, int resultCode,
                              Intent data) {
        frag.onActivityResult(requestCode & 0xffff, resultCode, data);
        List<Fragment> frags = frag.getChildFragmentManager().getFragments();
        if (frags != null) {
            for (Fragment f : frags) {
                if (f != null)
                    handleResult(f, requestCode, resultCode, data);
            }
        }
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        // notifying nested fragments (support library bug fix)
//        final FragmentManager childFragmentManager = getChildFragmentManager();
//
//        if (childFragmentManager != null) {
//            final List<Fragment> nestedFragments = childFragmentManager.getFragments();
//
//            if (nestedFragments == null || nestedFragments.size() == 0) return;
//
//            for (Fragment childFragment : nestedFragments) {
//                if (childFragment != null && !childFragment.isDetached() && !childFragment.isRemoving()) {
//                    childFragment.onActivityResult(requestCode, resultCode, data);
//                }
//            }
//        }
//    }
}

package com.longlong.ex.tabhostandnestedfragment;

import android.support.v4.app.Fragment;

public class CommunityContainerFragment extends BaseContainerFragment {

	@Override
	protected Fragment getFirstFragment() {
		return CommunityFragment.newInstance();
	}
	
}

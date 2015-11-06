package com.longlong.ex.tabhostandnestedfragment;

import android.support.v4.app.Fragment;

public class UserContainerFragment extends BaseContainerFragment {

	@Override
	protected Fragment getFirstFragment() {
		return UserFragment.newInstance();
	}
	
}

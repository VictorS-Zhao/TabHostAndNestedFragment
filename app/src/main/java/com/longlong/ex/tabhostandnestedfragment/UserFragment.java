package com.longlong.ex.tabhostandnestedfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserFragment extends Fragment {

    private static final String TAG = "UserFragment";

    public static Fragment newInstance(){
        Fragment fragment = new UserFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_page, container, false);
        NestedScrollView scrollView = (NestedScrollView) view;
        TextView tv = (TextView)scrollView.findViewById(R.id.tvInfo);
        tv.setText("Fragment #" + getParentFragment().getTag());

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragment().startActivityForResult(new Intent(getActivity(), ScrollingActivity.class), 1001);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.e(TAG, "onActivityResult");
    }
}

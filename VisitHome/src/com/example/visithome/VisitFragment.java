package com.example.visithome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class VisitFragment extends Fragment {
    /** (non-Javadoc)
     * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
	ImageButton VisitFriendButton;
	ImageButton myHomeButton;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        if (container == null) {
            // We have different layouts, and in one of them this
            // fragment's containing frame doesn't exist.  The fragment
            // may still be created from its saved state, but there is
            // no reason to try to create its view hierarchy because it
            // won't be displayed.  Note this is not needed -- we could
            // just run the code below, where we would create and return
            // the view hierarchy; it would just never be used.
            return null;
        }
        View v = inflater
				.inflate(R.layout.visitfragmentlayout, container, false);

		VisitFriendButton = (ImageButton) v.findViewById(R.id.imageButton2);
		VisitFriendButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getActivity(), ShopActivity.class);
				getActivity().startActivity(intent);

			}
		});
		myHomeButton = (ImageButton) v.findViewById(R.id.imageButton1);
		myHomeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getActivity(), ShopActivity.class);
				getActivity().startActivity(intent);

			}
		});
		return v;
     }
    
    
    // 눌렀을때 FriendFragment로 이동
}

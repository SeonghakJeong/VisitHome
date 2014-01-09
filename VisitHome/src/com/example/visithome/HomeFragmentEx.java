package com.example.visithome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class HomeFragmentEx extends Fragment {
	/**
	 * (non-Javadoc)
	 * 
	 * 
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
	 *      android.view.ViewGroup, android.os.Bundle)
	 */

	ImageButton GotoShopButton;
	ImageButton myAlbumButton;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			// We have different layouts, and in one of them this
			// fragment's containing frame doesn't exist. The fragment
			// may still be created from its saved state, but there is
			// no reason to try to create its view hierarchy because it
			// won't be displayed. Note this is not needed -- we could
			// just run the code below, where we would create and return
			// the view hierarchy; it would just never be used.
			return null;
		}

		View v = inflater
				.inflate(R.layout.homefragmentlayout, container, false);
		SoundManager.getInstance();
        SoundManager.initSounds(getActivity());             //<--- SoundMamager.java 를 불러올 것입니다.
        SoundManager.loadSounds();


        

		GotoShopButton = (ImageButton) v.findViewById(R.id.imageButton1);
		myAlbumButton = (ImageButton) v.findViewById(R.id.imageButton2);
		GotoShopButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				//setbackgroundResource(R.drawable.~);
				
				Intent intent = new Intent(getActivity(), ShopActivity.class);
				getActivity().startActivity(intent);
				



			}
		});
		myAlbumButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				//setbackgroundResource(R.drawable.~);
				
				Intent intent = new Intent(getActivity(), ShopActivity.class);
				getActivity().startActivity(intent);
				SoundManager.playSound(2, 1);



			}
		});

		return v;
	}

}
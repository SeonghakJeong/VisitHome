package com.example.visithome;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class HomeFragment extends Fragment {
	
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

		View v = inflater.inflate(R.layout.homefragmentlayout, container, false);
		SoundManager.getInstance();
		SoundManager.initSounds(getActivity()); // <--- SoundMamager.java 를 불러올
		SoundManager.loadSounds();

		final ImageButton ibAndroid = (ImageButton) v.findViewById(R.id.ImageButton01);
		final ImageButton home = (ImageButton) v.findViewById(R.id.ImageButton2);
		final ImageView flower = (ImageView) v.findViewById(R.id.flowerImage);
		
		home.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				//setbackgroundResource(R.drawable.~);
				
				Intent intent = new Intent(getActivity(), MainActivity.class);
				getActivity().startActivity(intent);
				SoundManager.playSound(2, 1);



			}
		});
		ibAndroid.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				LayoutInflater layoutInflater = (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				View popupView = layoutInflater.inflate(R.layout.popup, null);
				final PopupWindow popupWindow = new PopupWindow(popupView,
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				popupWindow.setWindowLayoutMode(LayoutParams.WRAP_CONTENT,
						LayoutParams.WRAP_CONTENT);
				// 팝업 뷰 터치 되도록
				popupWindow.setTouchable(true);
				// 팝업 뷰 포커스도 주고
				popupWindow.setFocusable(true);
				// 팝업 뷰 이외에도 터치되게 (터치시 팝업 닫기 위한 코드)

				popupWindow.setOutsideTouchable(true);
				popupWindow.setBackgroundDrawable(new BitmapDrawable());
				// 인자로 넘겨준 v 아래로 보여주기
				popupWindow.showAsDropDown(v);

				final ImageButton house0 = (ImageButton) popupView
						.findViewById(R.id.house00);
				final ImageButton house1 = (ImageButton) popupView
						.findViewById(R.id.house01);
				final ImageButton house2 = (ImageButton) popupView
						.findViewById(R.id.house02);
				final ImageButton house3 = (ImageButton) popupView
						.findViewById(R.id.house03);
				final ImageButton house4 = (ImageButton) popupView
						.findViewById(R.id.house04);
				final ImageButton house5 = (ImageButton) popupView
						.findViewById(R.id.house05);

				final ImageButton brick1 = (ImageButton) popupView
						.findViewById(R.id.brick01);
				final ImageButton brick2 = (ImageButton) popupView
						.findViewById(R.id.brick02);
				final ImageButton brick3 = (ImageButton) popupView
						.findViewById(R.id.brick03);

				final ImageButton flower1 = (ImageButton) popupView
						.findViewById(R.id.flower01);
				final ImageButton flower2 = (ImageButton) popupView
						.findViewById(R.id.flower02);
				final ImageButton flower3 = (ImageButton) popupView
						.findViewById(R.id.flower03);
				final ImageButton flower4 = (ImageButton) popupView
						.findViewById(R.id.flower04);
				final ImageButton flower5 = (ImageButton) popupView
						.findViewById(R.id.flower05);
				final ImageButton flower6 = (ImageButton) popupView
						.findViewById(R.id.flower06);
				final ImageButton flower7 = (ImageButton) popupView
						.findViewById(R.id.flower07);

				house0.setBackgroundResource(R.drawable.house0_check);
				flower1.setBackgroundResource(R.drawable.flower1_check);

				house0.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						home.setImageResource(R.drawable.myhomebutton_style);
						house0.setBackgroundResource(R.drawable.house0_check);
						house1.setBackgroundResource(R.drawable.house1);
						house2.setBackgroundResource(R.drawable.house2);
						house3.setBackgroundResource(R.drawable.house3);
						house4.setBackgroundResource(R.drawable.house4);
						house5.setBackgroundResource(R.drawable.house5);

					}
				});

				house1.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {

						home.setImageResource(R.drawable.home3);
						house0.setBackgroundResource(R.drawable.house0);
						house1.setBackgroundResource(R.drawable.house1_check);
						house2.setBackgroundResource(R.drawable.house2);
						house3.setBackgroundResource(R.drawable.house3);
						house4.setBackgroundResource(R.drawable.house4);
						house5.setBackgroundResource(R.drawable.house5);

					}
				});
				house2.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						home.setImageResource(R.drawable.home4);

						house0.setBackgroundResource(R.drawable.house0);
						house1.setBackgroundResource(R.drawable.house1);
						house2.setBackgroundResource(R.drawable.house2_check);
						house3.setBackgroundResource(R.drawable.house3);
						house4.setBackgroundResource(R.drawable.house4);
						house5.setBackgroundResource(R.drawable.house5);
					}
				});
				house3.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						home.setImageResource(R.drawable.home5);

						house0.setBackgroundResource(R.drawable.house0);
						house1.setBackgroundResource(R.drawable.house1);
						house2.setBackgroundResource(R.drawable.house2);
						house3.setBackgroundResource(R.drawable.house3_check);
						house4.setBackgroundResource(R.drawable.house4);
						house5.setBackgroundResource(R.drawable.house5);
					}
				});
				house4.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						house0.setBackgroundResource(R.drawable.house0);
						house1.setBackgroundResource(R.drawable.house1);
						house2.setBackgroundResource(R.drawable.house2);
						house3.setBackgroundResource(R.drawable.house3);
						house4.setBackgroundResource(R.drawable.house4_check);
						house5.setBackgroundResource(R.drawable.house5);
					}
				});
				house5.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						house0.setBackgroundResource(R.drawable.house0);
						house1.setBackgroundResource(R.drawable.house1);
						house2.setBackgroundResource(R.drawable.house2);
						house3.setBackgroundResource(R.drawable.house3);
						house4.setBackgroundResource(R.drawable.house4);
						house5.setBackgroundResource(R.drawable.house5_check);
					}
				});

				brick1.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						brick1.setBackgroundResource(R.drawable.brick1_check);
						brick2.setBackgroundResource(R.drawable.brick2);
						brick3.setBackgroundResource(R.drawable.brick3);

						home.setImageResource(R.drawable.home2);
					}
				});

				brick2.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						brick1.setBackgroundResource(R.drawable.brick1);
						brick2.setBackgroundResource(R.drawable.brick2_check);
						brick3.setBackgroundResource(R.drawable.brick3);

						home.setImageResource(R.drawable.home2);
					}
				});

				brick3.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						brick1.setBackgroundResource(R.drawable.brick1);
						brick2.setBackgroundResource(R.drawable.brick2);
						brick3.setBackgroundResource(R.drawable.brick3_check);

					}
				});

				flower1.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						flower.setImageResource(R.drawable.flower01);
						flower1.setBackgroundResource(R.drawable.flower1_check);
						flower2.setBackgroundResource(R.drawable.flower2);
						flower3.setBackgroundResource(R.drawable.flower3);
						flower4.setBackgroundResource(R.drawable.flower4);
						flower5.setBackgroundResource(R.drawable.flower5);
						flower6.setBackgroundResource(R.drawable.flower6);
						flower7.setBackgroundResource(R.drawable.flower7);

					}
				});

				flower2.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						flower.setImageResource(R.drawable.flower02);
						flower1.setBackgroundResource(R.drawable.flower1);
						flower2.setBackgroundResource(R.drawable.flower2_check);
						flower3.setBackgroundResource(R.drawable.flower3);
						flower4.setBackgroundResource(R.drawable.flower4);
						flower5.setBackgroundResource(R.drawable.flower5);
						flower6.setBackgroundResource(R.drawable.flower6);
						flower7.setBackgroundResource(R.drawable.flower7);
					}
				});
				flower3.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						flower.setImageResource(R.drawable.flower03);

						flower1.setBackgroundResource(R.drawable.flower1);
						flower2.setBackgroundResource(R.drawable.flower2);
						flower3.setBackgroundResource(R.drawable.flower3_check);
						flower4.setBackgroundResource(R.drawable.flower4);
						flower5.setBackgroundResource(R.drawable.flower5);
						flower6.setBackgroundResource(R.drawable.flower6);
						flower7.setBackgroundResource(R.drawable.flower7);
					}
				});
				flower4.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						flower.setImageResource(R.drawable.flower04);
						flower1.setBackgroundResource(R.drawable.flower1);
						flower2.setBackgroundResource(R.drawable.flower2);
						flower3.setBackgroundResource(R.drawable.flower3);
						flower4.setBackgroundResource(R.drawable.flower4_check);
						flower5.setBackgroundResource(R.drawable.flower5);
						flower6.setBackgroundResource(R.drawable.flower6);
						flower7.setBackgroundResource(R.drawable.flower7);
					}
				});
				flower5.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						flower.setImageResource(R.drawable.flower05);
						flower1.setBackgroundResource(R.drawable.flower1);
						flower2.setBackgroundResource(R.drawable.flower2);
						flower3.setBackgroundResource(R.drawable.flower3);
						flower4.setBackgroundResource(R.drawable.flower4);
						flower5.setBackgroundResource(R.drawable.flower5_check);
						flower6.setBackgroundResource(R.drawable.flower6);
						flower7.setBackgroundResource(R.drawable.flower7);
					}
				});
				flower6.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						flower.setImageResource(R.drawable.flower06);
						flower1.setBackgroundResource(R.drawable.flower1);
						flower2.setBackgroundResource(R.drawable.flower2);
						flower3.setBackgroundResource(R.drawable.flower3);
						flower4.setBackgroundResource(R.drawable.flower4);
						flower5.setBackgroundResource(R.drawable.flower5);
						flower6.setBackgroundResource(R.drawable.flower6_check);
						flower7.setBackgroundResource(R.drawable.flower7);
					}
				});
				flower7.setOnClickListener(new ImageButton.OnClickListener() {
					public void onClick(View v) {
						flower.setImageResource(R.drawable.flower07);
						flower1.setBackgroundResource(R.drawable.flower1);
						flower2.setBackgroundResource(R.drawable.flower2);
						flower3.setBackgroundResource(R.drawable.flower3);
						flower4.setBackgroundResource(R.drawable.flower4);
						flower5.setBackgroundResource(R.drawable.flower5);
						flower6.setBackgroundResource(R.drawable.flower6);
						flower7.setBackgroundResource(R.drawable.flower7_check);
					}
				});

			}
		});
		return v;
	}

}

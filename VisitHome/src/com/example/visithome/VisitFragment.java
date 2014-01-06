package com.example.visithome;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class VisitFragment extends Fragment{
	
	Context mContext;
	TextView textview;
	
	public VisitFragment(Context context) {
		mContext = context;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
			ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.visitlayout, null);
		
		textview = (TextView)view.findViewById(R.id.textView1);
		textview.setText("³î·¯°¡±â Fragment");
		
		
    	return view;
	}
	
}

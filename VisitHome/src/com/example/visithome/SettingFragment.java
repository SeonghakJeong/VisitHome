package com.example.visithome;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SettingFragment extends Fragment {
	/**
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
	 *      android.view.ViewGroup, android.os.Bundle)
	 */
	ListView listview;

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
		View v = inflater.inflate(R.layout.settingfragmentlayout, container,
				false);
		listview = (ListView) v.findViewById(R.id.listView1);
		//String[] list = { "기본정보", "가족관리", "꾸미기관리", "알림설정", "계정관리" };
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("기본정보");
		list.add("가족관리");
		list.add("꾸미기관리");
		list.add("알림설정");
		list.add("계정관리");
		ListviewAdapter adapter = new ListviewAdapter(getActivity().getApplicationContext(), R.layout.listview_row,list);
		listview.setAdapter(adapter);

		OnItemClickListener listViewExampleClickListener = new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parentView,
					View clickedView, int position, long id) {
				switch (position) {
				case 0:
					break;
				case 1:
					Intent intent1 = new Intent(getActivity(), FamilySettingActivity.class);
					getActivity().startActivity(intent1);
					break;
				case 2:
					Intent intent = new Intent(getActivity(), ShopActivity.class);
					getActivity().startActivity(intent);
					break;
				case 3:
					
					break;
				case 4:
					break;

				}

			}
		};
		listview.setOnItemClickListener(listViewExampleClickListener);
		return v;
	}
	   private class ListviewAdapter extends ArrayAdapter<String> {

	        private ArrayList<String> items;

	        public ListviewAdapter(Context context, int textViewResourceId, ArrayList<String> items) {
	                super(context, textViewResourceId, items);
	                this.items = items;
	        }
	        @Override
	        public View getView(int position, View convertView, ViewGroup parent) {
	                View v = convertView;
	                if (v == null) {
	                    LayoutInflater vi = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	                    v = vi.inflate(R.layout.listview_row, null);
	                }
	                String p = items.get(position);
	                if (p != null) {
	                        TextView tt = (TextView) v.findViewById(R.id.listtext);
	                        tt.setText(p);
	                }
	                return v;
	        }
	}
}

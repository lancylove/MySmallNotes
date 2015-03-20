package com.lancy.mysmallnotes.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lancy.mysmallnotes.R;
import com.lancy.mysmallnotes.bean.NoteBean;
import com.lancy.mysmallnotes.presenter.MainPresenter;
import com.lancy.mysmallnotes.view.impl.IMainView;
import com.lancy.mysmallnotes.view.utils.OnClick;
import com.lancy.mysmallnotes.view.utils.ViewRes;
import com.lancy.mysmallnotes.view.utils.ViewUtil;

public class MainActivity extends Activity implements IMainView,
		OnClickListener {
	@ViewRes(R.id.main_listview)
	private ListView listView;
	@ViewRes(R.id.iv_left)
	@OnClick
	private ImageView imgMore;

	@ViewRes(R.id.tv_center)
	private TextView tvTitle;

	@ViewRes(R.id.tv_right)
	@OnClick
	private TextView tvAdd;

	private MainPresenter mainPresenter;
	private Context context;
	List<NoteBean> list = new ArrayList<NoteBean>();
	private BaseAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewUtil.initView(this);
		ViewUtil.setOnclickListener(this, this);
		context = this;
		mainPresenter = new MainPresenter(this, context);
		adapter = new MyListAdapter(context, list);
		listView.setAdapter(adapter);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

//		mainPresenter.setNotes();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mainPresenter.setNotes();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_left:
			

			break;
		case R.id.tv_right:
			Intent intent = new Intent(context, AddActivity.class);
			startActivity(intent);
			
			break;
		default:
			break;
		}

	}

	@Override
	public void deleteNote(boolean deleteSuccess) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeNote(boolean changeNoteSuccess) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNoteComplete(boolean isCompleted) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNotes(List<NoteBean> list) {
		if (list != null) {
			this.list.addAll(list);
			adapter.notifyDataSetChanged();
			
		}

	}
	
	@Override
	public void AddNotes(boolean isOK) {
		// TODO Auto-generated method stub
		
	}
	
	

	class MyListAdapter extends BaseAdapter {
		Context context;
		List<NoteBean> list;
		LayoutInflater inflater ;
		public MyListAdapter(Context context,List<NoteBean> list) {
			this.context = context;
			this.list = list;
			inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			if (list != null)
				return list.size();

			return 0;
		}

		@Override
		public Object getItem(int position) {
			if (list != null)
				return list.get(position);
			
			return null;
		}

		@Override
		public long getItemId(int position) {
			if (list != null)
				return position;
			return -1;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if(convertView ==null){
				convertView = inflater.inflate(R.layout.item,null);
				holder = new ViewHolder();
				holder.tv = (TextView) convertView.findViewById(R.id.item_tv);
				convertView.setTag(holder);
				
			}else{
				holder = (ViewHolder) convertView.getTag();
			}
			holder.tv.setText(list.get(position).getContent());
			
			
			
			return convertView;
		}
		
		
		class ViewHolder{
			TextView tv;
		}
		

	}

	

}

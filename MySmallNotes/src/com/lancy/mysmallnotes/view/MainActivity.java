package com.lancy.mysmallnotes.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lancy.mysmallnotes.R;
import com.lancy.mysmallnotes.bean.NoteBean;
import com.lancy.mysmallnotes.presenter.MainPresenter;
import com.lancy.mysmallnotes.view.impl.IMainView;
import com.lancy.mysmallnotes.view.utils.OnClick;
import com.lancy.mysmallnotes.view.utils.ViewRes;
import com.lancy.mysmallnotes.view.utils.ViewUtil;
import com.lancy.mysmallnotes.view.widget.ItemMenu;
import com.lancy.mysmallnotes.view.widget.ItemMenu.OnSlideListener;

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
			this.list.clear();
			this.list.addAll(list);
			adapter.notifyDataSetChanged();
			
		}

	}
	
	@Override
	public void AddNotes(boolean isOK) {
		// TODO Auto-generated method stub
		
	}
	
	

	class MyListAdapter extends BaseAdapter implements OnSlideListener{
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
			final ViewHolder holder;
			if(convertView ==null){
				convertView = inflater.inflate(R.layout.itemcontent,null);
				
				holder = new ViewHolder();
				holder.itemMenu =  (ItemMenu) convertView.findViewById(R.id.itemmenu);
				holder.itemMenu.shrink();
				holder.itemMenu.setOnTouchListener(new OnTouchListener() {
			            
			            @Override
			            public boolean onTouch(View v, MotionEvent event) {
			             
			             holder.itemMenu.onRequireTouchEvent(event);
			                
			                
			                return true;
			            }
			        });
				convertView.setTag(holder);
				
			}else{
				holder = (ViewHolder) convertView.getTag();
			}
//			holder.tv.setText(list.get(position).getContent());
			holder.itemMenu.setTVContent(list.get(position).getContent());
			holder.itemMenu.setOnClick(new OnClickListener() {
                
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    switch (v.getId()) {
                    case R.id.delete:
                        Toast.makeText(context, "delete", 0).show();
                        break;
                    case R.id.done:
                        Toast.makeText(context, "done", 0).show();
                        break;
                        
                    case R.id.edit:
                        Toast.makeText(context, "edit", 0).show();
                        break;
                    default:
                        break;
                    }
                    
                    
                }
            });
			
			return convertView;
		}
		
		
		class ViewHolder{
			private ItemMenu itemMenu;
			
		}


        @Override
        public void onSlide(View view, int status) {
            // TODO Auto-generated method stub
            
        }
		

	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		listView.setSelection(savedInstanceState.getInt("id"));
		
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt("id", (int)listView.getSelectedItemId());
		
		
	
	}
}

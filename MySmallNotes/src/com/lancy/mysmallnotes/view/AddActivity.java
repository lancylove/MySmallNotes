package com.lancy.mysmallnotes.view;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lancy.mysmallnotes.R;
import com.lancy.mysmallnotes.bean.NoteBean;
import com.lancy.mysmallnotes.presenter.MainPresenter;
import com.lancy.mysmallnotes.util.UIUtil;
import com.lancy.mysmallnotes.view.impl.IMainView;
import com.lancy.mysmallnotes.view.utils.OnClick;
import com.lancy.mysmallnotes.view.utils.ViewRes;
import com.lancy.mysmallnotes.view.utils.ViewUtil;

public class AddActivity extends Activity implements IMainView,OnClickListener{
	@ViewRes(R.id.iv_left)
	@OnClick
	private ImageView imgBack;
	
	@ViewRes(R.id.tv_right)
	@OnClick
	private TextView tvOK;
	@ViewRes(R.id.add_edit)
	private EditText editText;
	
	private MainPresenter mainPresenter;
	NoteBean noteBean;
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		ViewUtil.initView(this);
		ViewUtil.setOnclickListener(this, this);
		mainPresenter = new MainPresenter(this, this);
		context = this;
		
	}
	
	
	

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_left:
			finish();
			break;
		case R.id.tv_right:
			String content  = editText.getText().toString();
			noteBean = new NoteBean(content, System.currentTimeMillis()+"");
			mainPresenter.addNotes(noteBean);
			break;
		default:
			break;
		}
		
	}




	@Override
	public void AddNotes(boolean isOK) {
		// TODO Auto-generated method stub
		if(isOK){
			UIUtil.ToastMsgTop(context, getResources().getString(R.string.addok));
			
		}else{
			UIUtil.ToastMsgTop(context,getResources().getString(R.string.adderror));
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
		// TODO Auto-generated method stub
		
	}
	


}

package com.lancy.mysmallnotes.presenter;

import android.content.Context;

import com.lancy.mysmallnotes.bean.NoteBean;
import com.lancy.mysmallnotes.model.MainModel;
import com.lancy.mysmallnotes.model.impl.IMainModel;
import com.lancy.mysmallnotes.view.impl.IMainView;

public class MainPresenter {

	private Context context;
	IMainView mainView;
	IMainModel mainModel;

	public MainPresenter(IMainView mainView,Context context) {
		// TODO Auto-generated constructor stub
		this.mainView = mainView;
		this.mainModel = new MainModel(context);
		this.context = context;
	}

	
	public void addNotes(NoteBean noteBean){
		mainView.AddNotes(mainModel.addNote(noteBean));
		
	}
	
	
	public void setNotes(){
		mainView.setNotes(mainModel.getNotes());
	}
	
	
	/**
	 * 根据周期取数据
	 * @param date
	 */
	public void setNotes(int date) {
		mainView.setNotes(mainModel.getNotes(date));
	}

	/**
	 * 删除任务
	 * @param id
	 */
	public void deleteNote(int id) {
		mainView.deleteNote(mainModel.deleteNote(id));
		
	}

	/**
	 * 修改任务
	 * @param noteBean
	 */
	public void changeNote(NoteBean noteBean) {
		mainView.changeNote(mainModel.changeNote(noteBean));
		
	}

	/**
	 * 设置是否完成
	 * @param id
	 * @param isCompleted
	 */
	public void setNoteCompleted(int id, boolean isCompleted) {
		if(mainModel.changeNote(id, isCompleted))
			mainView.setNoteComplete(isCompleted);
		

	}

}

package com.lancy.mysmallnotes.view.impl;

import java.util.List;

import com.lancy.mysmallnotes.bean.NoteBean;


public interface IMainView {
	
	
	//功能  增删改
	
	/**
	 * 添加数据结果处理
	 * @param deleteSuccess
	 */
	void AddNotes(boolean isOK);
	
	/**
	 * 删除数据结果处理
	 * @param deleteSuccess
	 */
	void deleteNote(boolean deleteSuccess);
	/**
	 * 修改数据结构处理
	 * @param changeNoteSuccess
	 */
	void changeNote(boolean changeNoteSuccess);
	
	/**
	 * 设置是否完成任务
	 * @param isCompleted
	 */
	void setNoteComplete(boolean isCompleted);
	
	/**
	 * 获取并展示当天任务数据
	 * @param list
	 */
	void setNotes(List<NoteBean> list);
	
	
	
	
	
	

}

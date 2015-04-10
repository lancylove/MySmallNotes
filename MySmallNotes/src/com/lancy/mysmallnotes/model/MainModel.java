package com.lancy.mysmallnotes.model;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.location.Criteria;

import com.lancy.mysmallnotes.bean.NoteBean;
import com.lancy.mysmallnotes.db.DBUtil;
import com.lancy.mysmallnotes.model.impl.IMainModel;

public class MainModel implements IMainModel {
	private static int Today = 0;
	public static int Monday = 1;
	public static int Tuesday = 2;
	public static int Wednesday = 3;
	public static int Thursday = 4;
	public static int Friday = 5;
	public static int Saturday = 6;
	public static int Sunday = 7;
	Context context;
DBUtil dbUtil ;

	public MainModel(Context context) {
		this.context = context;
		dbUtil = new DBUtil(context);
	}

	/**
	 * 获取当天的任务，date=0;
	 * 
	 * @throws DbException
	 */
	@Override
	public List<NoteBean> getNotes() {
		// TODO Auto-generated method stub
		return getNotes(Today);
	}

	/**
	 * 列表
	 * 
	 * @throws DbException
	 */
	@Override
	public List<NoteBean> getNotes(int date) {
		// TODO Auto-generated method stub
	    return dbUtil.getNotes(date);
		
	}

	@Override
	public boolean addNote(NoteBean noteBean) {
		// TODO Auto-generated method stub
		return dbUtil.addNote(noteBean);

	}

	@Override
	public boolean deleteNote(int id) {
		// TODO Auto-generated method stub
	    return dbUtil.deleteNote(id);
	}

	@Override
	public boolean changeNote(NoteBean noteBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeNote(int id, boolean isCompleted) {
		// TODO Auto-generated method stub
		return false;
	}

}

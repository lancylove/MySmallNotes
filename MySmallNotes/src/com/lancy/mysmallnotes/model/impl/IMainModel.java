package com.lancy.mysmallnotes.model.impl;

import java.util.List;

import com.lancy.mysmallnotes.bean.NoteBean;

public interface IMainModel {

	List<NoteBean> getNotes(int date);
	boolean addNote(NoteBean noteBean);
	boolean deleteNote(int id);
	boolean changeNote(NoteBean noteBean);
	
}

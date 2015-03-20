package com.lancy.mysmallnotes.bean;

import com.justsy.android.core.db.BaseModel;
import com.justsy.android.core.db.annotation.Column;
import com.justsy.android.core.db.annotation.ColumnType;
import com.justsy.android.core.db.annotation.Table;
import com.lancy.mysmallnotes.db.ItemTable;

/**
 * 任务数据
 * 
 * @author Lancy
 *
 */

@Table("note_table")
public class NoteBean extends BaseModel {
	public static final String NOTE_ID = "_id";
	public static final String NOTE_CONTENT = "content";
	public static final String NOTE_ADDTIME = "addtime";
	public static final String NOTE_REMINDTIME = "remindtime";
	public static final String NOTE_MODEL = "model";
	/**
	 * 内容
	 */
	@Column(columnName = ItemTable.NOTE_CONTENT, type = ColumnType.VARCHAR, length = 280,allowNull=false)
	private String content;
	/**
	 * 写入时间
	 */
	@Column(columnName = ItemTable.NOTE_ADDTIME, type = ColumnType.VARCHAR)
	private String addtime;

	/**
	 * 闹钟提醒时间
	 */
	@Column(columnName = ItemTable.NOTE_REMINDTIME, type = ColumnType.VARCHAR)
	private String remindTime;
	/**
	 * 任务周期性,0表示一次性任务
	 */
	@Column(columnName = ItemTable.NOTE_MODEL, type = ColumnType.VARCHAR, length = 100)
	private String model = "0";

	public NoteBean() {
		super();
	}

	public NoteBean( String content, String addtime, String remindTime,
			String model) {
		super();

		this.content = content;
		this.addtime = addtime;
		this.remindTime = remindTime;
		this.model = model;
	}
	
	public NoteBean( String content, String addtime) {
		super();

		this.content = content;
		this.addtime = addtime;
	}
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getRemindTime() {
		return remindTime;
	}

	public void setRemindTime(String remindTime) {
		this.remindTime = remindTime;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}

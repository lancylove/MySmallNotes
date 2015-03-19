package com.lancy.mysmallnotes.bean;

public class NoteBean {
	
	private int id;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 写入时间
	 */
	private long addtime;
	/**
	 * 任务所属日期
	 */
	private int date;
	/**
	 * 闹钟提醒时间
	 */
	private long remindTime;
	/**
	 * 任务周期性
	 */
	private String model;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getAddtime() {
		return addtime;
	}
	public void setAddtime(long addtime) {
		this.addtime = addtime;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public long getRemindTime() {
		return remindTime;
	}
	public void setRemindTime(long remindTime) {
		this.remindTime = remindTime;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
	
	
}

package com.lancy.mysmallnotes.bean;

/**
 * 任务数据
 * 
 * @author Lancy
 *
 */

public class NoteBean {
    private int id;

    /**
     * 内容
     */

    private String content;
    /**
     * 写入时间
     */

    private String addtime;

    /**
     * 闹钟提醒时间
     */

    private String remindTime;
    /**
     * 任务周期性,0表示一次性任务
     */

    private String model = "0";

    public NoteBean() {
        super();
    }

    public NoteBean(String content, String addtime, String remindTime, String model) {
        super();

        this.content = content;
        this.addtime = addtime;
        this.remindTime = remindTime;
        this.model = model;
    }

    public NoteBean(int id, String content, String addtime) {
        super();
        this.setId(id);
        this.content = content;
        this.addtime = addtime;
    }

    public NoteBean(String content, String addtime) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

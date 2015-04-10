package com.lancy.mysmallnotes.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	public static final String DBNAME = "samllNotes.db";
	public static final int VERSION = 1;
	
    public static final String NOTE_TABLENAME = "notes";
    public static final String NOTE_ID = "_id";
    public static final String NOTE_CONTENT = "content";
    public static final String NOTE_ADDTIME = "addtime";
    public static final String NOTE_REMINDTIME = "remindtime";
    public static final String NOTE_MODEL = "model";
	
	public DBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	
	public DBHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		StringBuilder sql = new StringBuilder();
		 sql.append("create table if not exists ")
		 .append(NOTE_TABLENAME).append("(")
		 .append(NOTE_ID)
		 .append(" Integer primary key autoincrement,")
		 .append(NOTE_ADDTIME)
		 .append(" TEXT,")   // 包含了 年、月、日、时、分、秒、千分之一秒。
		 .append(NOTE_REMINDTIME)
		 .append(" TEXT,")    //time  包含了 小时、分钟、秒。
		 .append(NOTE_CONTENT)
		 .append(" TEXT ,")
		 .append(NOTE_MODEL)
		 .append(" TEXT")
		 .append(")");
		
		 db.execSQL(sql.toString());

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "drop table if exists"+NOTE_TABLENAME;
		db.execSQL(sql);
		this.onCreate(db);

	}

}

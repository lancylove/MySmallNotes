package com.lancy.mysmallnotes.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lancy.mysmallnotes.bean.NoteBean;

public class DBUtil {

    private DBHelper dbHelper;
    Context context;

    public DBUtil(Context context) {
        this.context = context;

    }

    public DBHelper getDBHelper(Context context) {

        if (dbHelper == null)
            dbHelper = new DBHelper(context);
        return dbHelper;

    }

    public List<NoteBean> getNotes(int date) {
        return getNotes();
    }

    public List<NoteBean> getNotes() {
        List<NoteBean> list = new ArrayList<NoteBean>();
        SQLiteDatabase db = getDBHelper(context).getReadableDatabase();
        String sql = "select * from " + DBHelper.NOTE_TABLENAME;
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String content = cursor.getString(cursor.getColumnIndex(DBHelper.NOTE_CONTENT));
            String addtime = cursor.getString(cursor.getColumnIndex(DBHelper.NOTE_ADDTIME));
            int id = cursor.getInt(cursor.getColumnIndex(DBHelper.NOTE_ID));
            list.add(new NoteBean(id, content, addtime));
        }
        cursor.close();
        db.close();
        return list;
    }

    public boolean addNote(NoteBean noteBean) {
        SQLiteDatabase db = getDBHelper(context).getWritableDatabase();
        //insert into table1(field1,field2) values(value1,value2)
        String sql = "insert into " + DBHelper.NOTE_TABLENAME + "(" + DBHelper.NOTE_CONTENT + ","
                + DBHelper.NOTE_ADDTIME + "," + DBHelper.NOTE_MODEL + ") values(?,?,?)";

        db.execSQL(sql, new Object[] { noteBean.getContent(), noteBean.getAddtime(), noteBean.getModel() });
        db.close();

        return true;
    }

    public boolean deleteNote(int id) {
        SQLiteDatabase db = getDBHelper(context).getWritableDatabase();
        String sql = "delete ";
        db.delete(DBHelper.NOTE_TABLENAME, DBHelper.NOTE_ID + "=?", new String[] { id + "" });
        db.close();
        return true;
    }

}

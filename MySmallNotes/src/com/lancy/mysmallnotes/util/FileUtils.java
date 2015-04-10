package com.lancy.mysmallnotes.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class FileUtils {

	public static boolean savefileFromAssetToSD(String toPath, String name,
			Context context) {
		boolean result = false;
		InputStream in = null;
		FileOutputStream out = null;
		try {
			in = context.getResources().getAssets().open(name);
			out = new FileOutputStream(toPath);
			byte[] b = new byte[1024];
			int length = 0;
			while ((length = in.read(b)) > 0) {
				out.write(b, 0, length);
			}
			result = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (out != null) {
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		}
		
		// 下面测试 /data/data/com.test.db/databases/ 下的数据库是否能正常工作
				SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(toPath+"/" + name, null);
				Cursor cursor = database.rawQuery("select * from test", null);

				if (cursor.getCount() > 0) {
					cursor.moveToFirst();
					try {
						// 解决中文乱码问题
						byte test[] = cursor.getBlob(0);
						String strtest = new String(test, "utf-8").trim();

						// 看输出的信息是否正确
						System.out.println(strtest);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				cursor.close();
			

		return result;
	}

}

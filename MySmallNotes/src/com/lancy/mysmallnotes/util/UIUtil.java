package com.lancy.mysmallnotes.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class UIUtil {
	
	
	public static void ToastMsgTop(Context context,String msg){
		
		Toast toast = new Toast(context);
		toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.makeText(context, msg, 1).show();
		
	}
	
	
	

}

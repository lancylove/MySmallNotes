package com.lancy.mysmallnotes.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.lancy.mysmallnotes.R;
import com.lancy.mysmallnotes.util.ScreenUtils;

public class ItemMenu extends HorizontalScrollView {
//	LogUtil.makeLog(ItemMenu.class);
	
	/**
	 * 屏幕宽度
	 */
	private int mScreenWidth;
	/**
	 * dp
	 */
	private int mMenuWidth;
	
	/**
	 * 菜单的宽度
	 */

	private int mMenuWidth1;
	private int mMenuWidth2;
	private int mMenuWidth3;
	

	private int mHalfMenuWidth1;
	private int mHalfMenuWidth2;
	private int mHalfMenuWidth3;
	
	private boolean isOpen;
	private boolean once;

	private ViewGroup mMenu;
	private ViewGroup mContent;
	
	
	
	public ItemMenu(Context context, AttributeSet attrs) {
		this(context, attrs,0);
		// TODO Auto-generated constructor stub
	}

	public ItemMenu(Context context) {
		this(context,null);
		// TODO Auto-generated constructor stub
	}
	public ItemMenu(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mScreenWidth = ScreenUtils.getScreenWidth(context);

		TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.ItemMenu, defStyle, 0);
		mMenuWidth = (int) a.getDimension(R.styleable.ItemMenu_menuwidth, 10);
		a.recycle();
		
	}
	
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		if(once){
			LinearLayout wrapper = (LinearLayout) getChildAt(0);
			mContent = (ViewGroup) wrapper.getChildAt(0);
			mMenu = (ViewGroup) wrapper.getChildAt(1);
			
			
		}
		
		
		
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		super.onLayout(changed, l, t, r, b);
		
		
		
		
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return super.onTouchEvent(ev);
	}
	
	
	
	

	
	
	
	
}

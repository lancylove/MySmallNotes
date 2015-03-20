package com.lancy.mysmallnotes.view.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.app.Activity;
import android.view.View;

public abstract class ViewUtil {
    public static void initView(Activity activity) {
        initView(activity, new ViewFinder(activity));
    }

    public static void initView(View view) {
        initView(view, new ViewFinder(view));
    }

    public static void initView(Object viewHolder, View view) {
        initView(viewHolder, new ViewFinder(view));
    }

    public static void setOnclickListener(Object viewHolder, View.OnClickListener listener) {
        Field[] fields = viewHolder.getClass().getDeclaredFields();
        if (fields != null) {
            for (Field f : fields) {
                try {
                    f.setAccessible(true);
                    OnClick click = f.getAnnotation(OnClick.class);
                    if (click != null && f.get(viewHolder) != null) {
                        Method m = f.get(viewHolder).getClass()
                                .getMethod("setOnClickListener", View.OnClickListener.class);
                        if (m != null) {
                            m.invoke(f.get(viewHolder), listener);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void initView(Object obj, ViewFinder viewFinder) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            if (fields != null) {
                for (Field f : fields) {
                    ViewRes res = f.getAnnotation(ViewRes.class);
                    if (res != null && res.value() != 0) {
                        int id = res.value();
                        f.setAccessible(true);
                        f.set(obj, viewFinder.findViewById(id));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.example.yang.testexample;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yang on 18-2-5.
 */

public class CustomScrollView extends ScrollView {

    private List<View> mChildViews = new ArrayList<>();

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        travelTree1(this);
//        for (View view : mChildViews) {
//            if (view != null && view instanceof ListView) {
//                int x = (int) ev.getRawX();
//                int y = (int) ev.getRawY();
////            Log.d("my-log", "touch point   x is  " + x +"  and y is : " + y);
////            Log.d("my-log", "childView width is  " + childView.getWidth() +"  and height is : " + childView.getHeight());
//                if (isTouchPointInView(view, x, y)) {
//                    Log.d("my-log", "CustomScrollView dispatchTouchEvent  touch on listview   not intercept");
//                }else {
//                    Log.d("my-log", "CustomScrollView  touch out of listview  intercept ");
//                    return super.dispatchTouchEvent(ev);
//                }
//            }
//        }
        return super.dispatchTouchEvent(ev);
    }

    private List<View> travelTree1(View rootView) {
        mChildViews.add(rootView);
        if (rootView instanceof ViewGroup) {
            int childCount = ((ViewGroup) rootView).getChildCount();
            for (int i = 0; i < childCount; i++) {
                travelTree1(((ViewGroup) rootView).getChildAt(i));
            }
        }
        return mChildViews;
    }

    //(x,y)是否在view的区域内
    private boolean isTouchPointInView(View view, int x, int y) {
        if (view == null) {
            return false;
        }
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int left = location[0];
        int top = location[1];
        int right = left + view.getMeasuredWidth();
        int bottom = top + view.getMeasuredHeight();
        //view.isClickable() &&
        if (y >= top && y <= bottom && x >= left
                && x <= right) {
            return true;
        }
        return false;
    }
}

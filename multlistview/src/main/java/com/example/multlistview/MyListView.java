package com.example.multlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * <p>  <p/>
 * Created by zw on 17/3/24 12:53.
 */

public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


//    @Override
//    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
//        parentHeightMeasureSpec = MeasureSpec.makeMeasureSpec(480,
//                MeasureSpec.EXACTLY);
//        super.measureChild(child, parentWidthMeasureSpec, parentHeightMeasureSpec);
//    }
}

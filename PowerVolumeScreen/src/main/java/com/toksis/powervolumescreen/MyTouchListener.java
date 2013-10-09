package com.toksis.powervolumescreen;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by god-gavedmework on 26/09/13.
 */
public class MyTouchListener implements View.OnTouchListener {
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return false;
        } else {
            return false;
        }
    }
}

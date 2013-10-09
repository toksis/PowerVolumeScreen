package com.toksis.powervolumescreen;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by god-gavedmework on 19/09/13.
 */
public class DragDrop implements View.OnTouchListener {

    int prevX, prevY;

    @Override
    public boolean onTouch(final View v, final MotionEvent event) {
        final FrameLayout.LayoutParams par = (FrameLayout.LayoutParams) v.getLayoutParams();
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE: {
                par.topMargin += (int) event.getRawY() - prevY;
                prevY = (int) event.getRawY();
                par.leftMargin += (int) event.getRawX() - prevX;
                prevX = (int) event.getRawX();
                v.setLayoutParams(par);
                return true;
            }
            case MotionEvent.ACTION_UP: {
                par.topMargin += (int) event.getRawY() - prevY;
                par.leftMargin += (int) event.getRawX() - prevX;
                v.setLayoutParams(par);
                return true;
            }
            case MotionEvent.ACTION_DOWN: {
                prevX = (int) event.getRawX();
                prevY = (int) event.getRawY();
                par.bottomMargin = -2 * v.getHeight();
                par.rightMargin = -2 * v.getWidth();
                v.setLayoutParams(par);
                return true;
            }
        }
        return false;
    }
}

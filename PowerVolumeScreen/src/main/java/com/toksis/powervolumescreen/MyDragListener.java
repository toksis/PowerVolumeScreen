package com.toksis.powervolumescreen;

import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;

/**
 * Created by god-gavedmework on 26/09/13.
 */
public class MyDragListener implements View.OnDragListener {


    @Override
    public boolean onDrag(View v, DragEvent event) {
        String containerName = null;
        int ID = 0;
        int Dragaction = event.getAction();


        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:

                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                break;
            case DragEvent.ACTION_DROP:

                View view = (View) event.getLocalState();
                ViewGroup owner = (ViewGroup) view.getParent();
                owner.removeView(view);

                FrameLayout container = (FrameLayout) v;
                container.addView(view);
                ImageButton radioButton1 = (ImageButton) v.findViewById(R.id.MainButton);


                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.FILL_PARENT);

                //params.height = 100;
                containerName = (String) v.getTag();

                switch (v.getId()) {
                    case R.id.topLeft:


                        params.gravity = Gravity.LEFT | Gravity.TOP;

                        break;
                    //        case R.id.topRight:

                    //            params.gravity = Gravity.RIGHT | Gravity.TOP;
                    //           break;

                    //         case R.id.bottomLeft:
                    //              params.gravity= Gravity.BOTTOM | Gravity.LEFT;
                    //             break;

                    //          case R.id.bottomRight:
                    //                params.gravity = Gravity.RIGHT | Gravity.BOTTOM;
                    //               break;

                    default:
                        throw new RuntimeException("Unknown ID");
                }

                radioButton1.setLayoutParams(params);


                break;
            case DragEvent.ACTION_DRAG_ENDED:
                View view1 = (View) event.getLocalState();
                //FrameLayout container1 = (FrameLayout) v;
                //container1.addView(view1);
                view1.getTag();
                view1.setVisibility(View.VISIBLE);

                return false;

            default:


                break;
        }
        return false;
    }
}



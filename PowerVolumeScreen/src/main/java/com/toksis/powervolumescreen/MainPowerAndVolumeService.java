package com.toksis.powervolumescreen;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by god-gavedmework on 17/09/13.
 */
public class MainPowerAndVolumeService extends Service {


    private ViewGroup mView;
    private LayoutInflater inflater;
    private ImageButton mainButton;
    private Button testButton;
    private FrameLayout frameLayout;

    @Override
    public IBinder
    onBind(Intent intent) {
        return null;
    }


    public void onCreate() {
        super.onCreate();


        /*This will make your window or layout to be overlay and of course you can click the buttons*/

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
                        | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
        );
        Log.d("tok", " Window Manager activated");

        /*This will load the main.xml view through inflate*/
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Log.d("tok", " Window Manager systemservice");

        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mView = (ViewGroup) inflater.inflate(R.layout.main, null);

        mainButton = (ImageButton) mView.findViewById(R.id.MainButton);
        //mainButton.setOnTouchListener(new MyTouchListener());


        /*Preference for the button position*/

        SharedPreferences prefs =
                PreferenceManager.getDefaultSharedPreferences(this);

        Boolean topleft = prefs.getBoolean("topLeft", false);


        if (topleft == true) {
            params.gravity = Gravity.LEFT | Gravity.TOP;
        }


        Boolean topRight = prefs.getBoolean("topRigt", false);


        if (topRight == true) {
            params.gravity = Gravity.RIGHT | Gravity.TOP;
        }


        Boolean bottomLeft = prefs.getBoolean("bottomLeft", false);


        if (bottomLeft == true) {
            params.gravity = Gravity.LEFT | Gravity.BOTTOM;
        }


        Boolean bottomRight = prefs.getBoolean("bottomRight", false);


        if (bottomRight == true) {
            params.gravity = Gravity.RIGHT | Gravity.BOTTOM;
        }


        wm.addView(mView, params);
        Log.d("tok", "add mview");

        //buttonListener();


    }


    public void buttonListener() {

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(MainPowerAndVolumeService.this,
                        "ImageButton (selector) is clicked!",
                        Toast.LENGTH_SHORT).show();


            }
        });

        mainButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                //        v.findViewById(R.id.topRight).setOnDragListener(new MyDragListener());
                          v.findViewById(R.id.topLeft).setOnDragListener(new MyDragListener());
                //        v.findViewById(R.id.bottomRight).setOnDragListener(new MyDragListener());
                //        v.findViewById(R.id.bottomLeft).setOnDragListener(new MyDragListener());
                v.setOnTouchListener(new MyTouchListener());

                return true;
            }
        });

    }


    public void onDestroy() {
        super.onDestroy();
        ((WindowManager) getSystemService(WINDOW_SERVICE)).removeView(mView);

    }


}

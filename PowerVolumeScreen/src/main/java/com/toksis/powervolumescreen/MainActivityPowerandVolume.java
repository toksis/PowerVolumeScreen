package com.toksis.powervolumescreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivityPowerandVolume extends Activity {
    private Button settings;
    private Button launch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);

        Log.d("tok", "Program Started launched");


        settings = (Button) findViewById(R.id.settings);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch to our preferences screen.
                Intent intent = new Intent(MainActivityPowerandVolume.this, PreferencePowerVolume.class);
                startActivity(intent);

            }
        });

        launch = (Button) findViewById(R.id.launch);
        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainService = new Intent(MainActivityPowerandVolume.this, MainPowerAndVolumeService.class);

                startService(mainService);

                Log.d("tok", "activity launched");
                finish();
                v.setVisibility(View.GONE);

            }
        });

    }


}

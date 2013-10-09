package com.toksis.powervolumescreen;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;

/**
 * Created by god-gavedmework on 4/10/13.
 */
public class PreferencePowerVolume extends PreferenceActivity {


    CheckBoxPreference topLeft;
    CheckBoxPreference topRight;
    CheckBoxPreference bottomLeft;
    CheckBoxPreference bottomRight;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preference);


        topLeft = (CheckBoxPreference) findPreference("topLeft");
        topRight = (CheckBoxPreference) findPreference("topRight");
        bottomRight = (CheckBoxPreference) findPreference("bottomRight");
        bottomLeft = (CheckBoxPreference) findPreference("bottomLeft");


        topLeft.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                topLeft.setChecked(true);
                topRight.setChecked(false);
                bottomLeft.setChecked(false);
                bottomRight.setChecked(false);

                return true;
            }
        });


        topRight.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                topLeft.setChecked(false);
                topRight.setChecked(true);
                bottomLeft.setChecked(false);
                bottomRight.setChecked(false);

                return true;
            }
        });


        bottomLeft.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                topLeft.setChecked(false);
                topRight.setChecked(false);
                bottomLeft.setChecked(true);
                bottomRight.setChecked(false);

                return true;
            }
        });


        bottomRight.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                topLeft.setChecked(false);
                topRight.setChecked(false);
                bottomLeft.setChecked(false);
                bottomRight.setChecked(true);

                return true;
            }
        });



    }

}

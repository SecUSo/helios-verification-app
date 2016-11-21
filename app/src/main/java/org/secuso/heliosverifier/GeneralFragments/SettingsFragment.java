package org.secuso.heliosverifier.GeneralFragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import org.secuso.heliosverifier.R;

public class SettingsFragment extends PreferenceFragment {
    public SettingsFragment() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

    }

}

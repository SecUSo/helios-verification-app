package org.secuso.heliosverifier.GeneralFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.secuso.heliosverifier.R;

/**
 * Basis taken from https://github.com/SecUSo/privacy-friendly-qr-scanner
 */
public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        ((TextView)rootView.findViewById(R.id.githubURL)).setMovementMethod(LinkMovementMethod.getInstance());

        return rootView;
    }
}

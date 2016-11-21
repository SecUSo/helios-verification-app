package org.secuso.heliosverifier.ResultFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.secuso.heliosverifier.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class TextFragment extends ResultFragment {

    public TextFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_text, container, false);

        rootView = super.setResult(rootView);

        TextView resultText = (TextView) rootView.findViewById(R.id.result_field_text);
        resultText.setText(this.result);

        return rootView;
    }
}
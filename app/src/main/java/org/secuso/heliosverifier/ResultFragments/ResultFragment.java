package org.secuso.heliosverifier.ResultFragments;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.secuso.heliosverifier.R;

/**
 * Basis taken from https://github.com/SecUSo/privacy-friendly-qr-scanner
 */

public class ResultFragment extends Fragment {
    protected String result;
    protected Bitmap bitmap;
    protected String toast = "erfolgreich";
    protected boolean fromHistory = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_text, container, false);

        rootView = setResult(rootView);

        TextView resultText = (TextView) rootView.findViewById(R.id.result_field_text);
        resultText.setText(this.result);

        return rootView;
    }

    /*
        To be implemented
     */
    protected void createBitmap(){}

    protected View setResult(View view) {
        result  = getArguments().getString("result_content");
        return view;
    }

    protected void displayToast() {
        if(getActivity() != null && toast != null) {
            Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
        }
    }
}

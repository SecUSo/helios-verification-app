package org.secuso.heliosverifier.ResultFragments;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_text, container, false);

        rootView = setResult(rootView);

        TextView resultText = (TextView) rootView.findViewById(R.id.result_field_text);

        String display = processResult(result);

        resultText.setText(display);

        return rootView;
    }

    protected View setResult(View view) {
        result  = getArguments().getString("result_content");
        return view;
    }

    protected String processResult(String result) {

        String temp = "Empty Vote";

        if (result.length() > 43) {

            String candidateCode = result.substring(49, 51);

            Log.d("Code", candidateCode);
            Log.d("Vote", result);

            switch(candidateCode) {
                case "00":
                    temp = "Empty Vote";
                case "01":
                    temp = "Candidate 1";
                case "02":
                    temp = "Candidate 2";
                case "03":
                    temp = "Candidate 3";
                case "04":
                    temp = "Candidate 4";
                case "05":
                    temp = "Candidate 5";
                case "06":
                    temp = "Candidate 6";
                case "07":
                    temp = "Candidate 7";
                case "08":
                    temp = "Candidate 8";
                case "09":
                    temp = "Candidate 9";
                case "10":
                    temp = "Candidate 10";
            }
        } else {
            Log.d("HASH", result);
            }

        return temp;
    }


}

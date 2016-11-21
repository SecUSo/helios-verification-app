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

        Log.d("Result from QR", result);

        switch(result) {
            case "1": return "Candidate 1";
            case "2": return "Candidate 2";
            case "3": return "Candidate 3";
            case "4": return "Candidate 4";
            case "5": return "Candidate 5";
            case "6": return "Candidate 6";
            case "7": return "Candidate 7";
            case "8": return "Candidate 8";
            case "9": return "Candidate 9";
            case "10": return "Candidate 10";
        }
        return "Not voted";
    }


}

package org.secuso.heliosverifier;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ResultFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_result, container, false);
        container.removeAllViews();

        Bundle extras = this.getArguments();
        String candidate = extras.getString("code");

        TextView candidateTextView = (TextView) rootView.findViewById(R.id.resultTextView);
        candidateTextView.setText(processResult(candidate));

        Button alarmButton = (Button) rootView.findViewById(R.id.alarmButton);
        Button successButton = (Button) rootView.findViewById(R.id.successButton);

        successButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                SuccessFragment successFragment = new SuccessFragment();

                fragmentTransaction.replace(R.id.activity_main, successFragment, "successFragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                AlarmFragment alarmFragment = new AlarmFragment();

                fragmentTransaction.replace(R.id.activity_main, alarmFragment, "alarmFragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return rootView;
    }

    protected String processResult(String result) {

        switch (result) {
            case "01":
                return "Candidate 1";
            case "02":
                return "Candidate 2";
            case "03":
                return "Candidate 3";
            case "04":
                return "Candidate 4";
            case "05":
                return "Candidate 5";
            case "06":
                return "Candidate 6";
            case "07":
                return "Candidate 7";
            case "08":
                return "Candidate 8";
            case "09":
                return "Candidate 9";
            case "10":
                return "Candidate 10";
            default:
                return "Empty Vote";
        }
    }


}

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
                return getString(R.string.candidate_one);
            case "02":
                return getString(R.string.candidate_two);
            case "03":
                return getString(R.string.candidate_three);
            case "04":
                return getString(R.string.candidate_four);
            case "05":
                return getString(R.string.candidate_five);
            case "06":
                return getString(R.string.candidate_six);
            case "07":
                return getString(R.string.candidate_seven);
            case "08":
                return getString(R.string.candidate_eight);
            case "09":
                return getString(R.string.candidate_nine);
            case "10":
                return getString(R.string.candidate_ten);
            case "11":
                return getString(R.string.candidate_11);
            case "12":
                return getString(R.string.candidate_12);
            case "13":
                return getString(R.string.candidate_13);
            case "14":
                return getString(R.string.candidate_14);
            case "15":
                return getString(R.string.candidate_15);
            case "16":
                return getString(R.string.candidate_16);
            case "17":
                return getString(R.string.candidate_17);
            case "18":
                return getString(R.string.candidate_18);
            case "19":
                return getString(R.string.candidate_19);
            case "20":
                return getString(R.string.candidate_20);
            default:
                return getString(R.string.empty_vote);
        }
    }


}

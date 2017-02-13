package org.secuso.heliosverifier;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * Created by yonjuni on 13.02.17.
 */

public class SecondInstructionFragment extends Fragment{
    private IntentIntegrator qrScan;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        container.removeAllViews();

        qrScan = new IntentIntegrator(getActivity());

        Button buttonScan = (Button) rootView.findViewById(R.id.buttonScan);

        buttonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrScan.initiateScan();
            }
        });

        return rootView;
    }

    //Getting the scan results
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(getActivity(), "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                if (result.getContents().length() < 43) {
                    final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.activity_main, new FirstInstructionFragment(), "EnterPinFragment");
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}


package org.secuso.heliosverifier;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class SecondInstructionFragment extends Fragment {
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(getActivity(), "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                Bundle bundle = new Bundle();
                //Trim "encrypted" vote here
                bundle.putString("code", result.getContents().substring(50, 52));

                Log.d("Code", result.getContents().substring(50, 52));

                final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                ResultFragment resultFragment = new ResultFragment();
                resultFragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.activity_main, resultFragment, "ResultFragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}


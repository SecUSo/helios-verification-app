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

public class SecondInstructionFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_second, container, false);

        Button buttonScan = (Button) rootView.findViewById(R.id.buttonScan);

        buttonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanFromFragment();
            }
        });

        return rootView;
    }

    public void scanFromFragment() {
        IntentIntegrator.forSupportFragment(this).initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(getActivity(), getString(R.string.second_empty_qr_code), Toast.LENGTH_LONG).show();
            } else {
                if (result.getContents().length() < 44) {
                    Toast.makeText(getActivity(), getString(R.string.second_wrong_qr_code), Toast.LENGTH_LONG).show();
                } else {
                    Bundle bundle = new Bundle();
                    //Trim "encrypted" vote here
                    bundle.putString("code", result.getContents().substring(100, 102));

                    Log.d("Code", result.getContents().substring(100, 102));

                    final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    ResultFragment resultFragment = new ResultFragment();
                    resultFragment.setArguments(bundle);

                    fragmentTransaction.replace(R.id.activity_main, resultFragment, "ResultFragment");
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}


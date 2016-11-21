package org.secuso.heliosverifier.ResultFragments;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Toast;

import org.secuso.heliosverifier.Utility.History;

public abstract class ResultFragment extends Fragment {
    protected String result;
    protected Bitmap bitmap;
    protected String toast = "erfolgreich";
    protected boolean fromHistory = false;

    public ResultFragment (){}

    /*
        To be implemented
     */
    protected void createBitmap(){}

    protected View setResult(View view) {
        result  = getArguments().getString("result_content");
        return view;
    }

    protected void saveScanned(boolean trust) {
        if(!fromHistory)
            History.saveScan(result, trust, getActivity());
    }

    protected void displayToast() {
        if(getActivity() != null && toast != null) {
            Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
        }
    }
}

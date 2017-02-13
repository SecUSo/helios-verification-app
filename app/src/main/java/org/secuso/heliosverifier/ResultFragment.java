package org.secuso.heliosverifier;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yonjuni on 13.02.17.
 */

public class ResultFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_result, container, false);
        container.removeAllViews();

        return rootView;
    }

}

package org.secuso.heliosverifier;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SuccessFragment extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_success, container, false);
        container.removeAllViews();

        Button newButton = (Button) rootView.findViewById(R.id.newButton);
        Button closeButton = (Button) rootView.findViewById(R.id.closeButton);


        return rootView;
    }


}

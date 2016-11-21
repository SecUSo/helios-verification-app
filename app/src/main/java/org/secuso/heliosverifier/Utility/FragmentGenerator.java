package org.secuso.heliosverifier.Utility;

import android.app.Fragment;
import android.os.Bundle;

import com.google.zxing.integration.android.IntentResult;

import org.secuso.heliosverifier.ResultFragments.ResultFragment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Philipp on 14/09/2015.
 */
public class FragmentGenerator {
    public static Fragment getFragment(IntentResult result) {
        Fragment fragment = new ResultFragment();

        Bundle bundle = new Bundle();
        bundle.putString("result_content", result.getContents());
        fragment.setArguments(bundle);

        return fragment;
    }

    public static Fragment getFragmentFromContent(String content) {
        Fragment fragment;

        Pattern r = Pattern.compile("^[0-9]\\*\\$");
        Matcher m = r.matcher(content);

            fragment = new ResultFragment();

        Bundle bundle = new Bundle();
        bundle.putString("result_content", content);
        fragment.setArguments(bundle);

        return fragment;
    }
}

package org.secuso.heliosverifier;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.secuso.heliosverifier.GeneralFragments.AboutFragment;
import org.secuso.heliosverifier.GeneralFragments.ScanFragment;
import org.secuso.heliosverifier.GeneralFragments.SettingsFragment;

import java.util.LinkedList;

/**
 * Basis taken from https://github.com/SecUSo/privacy-friendly-qr-scanner
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // delay to launch nav drawer item, to allow close animation to play
    static final int NAVDRAWER_LAUNCH_DELAY = 250;
    // fade in and fade out durations for the main content when switching between
    // different Activities of the app through the Nav Drawer
    static final int MAIN_CONTENT_FADEOUT_DURATION = 150;
    static final int MAIN_CONTENT_FADEIN_DURATION = 250;

    // Navigation drawer:
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    // Helper
    private Handler mHandler;

    private LinkedList<Integer> backStack = new LinkedList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler = new Handler();

        overridePendingTransition(0, 0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void switchToFragment(Fragment frag, boolean back) {
        Fragment temp = getFragmentManager().findFragmentById(R.id.container);
        if (!back)
            if (temp instanceof ScanFragment)
                backStack.push(0);
            else if (temp instanceof SettingsFragment)
                backStack.push(2);
            else if (temp instanceof AboutFragment)
                backStack.push(3);

        getFragmentManager().beginTransaction().replace(R.id.container, frag).addToBackStack("").commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        if (backStack.size() < 1)
            finish();
        else {
            int back = backStack.pop();
            selectItem(back, true);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (getSupportActionBar() == null) {
            setSupportActionBar(toolbar);
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        selectNavigationItem(getNavigationDrawerID());
        selectNavigationItem(R.id.nav_scan);

        View mainContent = findViewById(R.id.main_content);
        if (mainContent != null) {
            mainContent.setAlpha(0);
            mainContent.animate().alpha(1).setDuration(MAIN_CONTENT_FADEIN_DURATION);
        }
    }

    // set active navigation item
    private void selectNavigationItem(int itemId) {
        for (int i = 0; i < mNavigationView.getMenu().size(); i++) {
            boolean b = itemId == mNavigationView.getMenu().getItem(i).getItemId();
            mNavigationView.getMenu().getItem(i).setChecked(b);
        }
    }

    protected int getNavigationDrawerID() {
        Fragment temp = getFragmentManager().findFragmentById(R.id.container);

        if (temp instanceof ScanFragment)
            return R.id.nav_scan;
        else if (temp instanceof SettingsFragment)
            return R.id.nav_settings;
        else if (temp instanceof AboutFragment)
            return R.id.nav_about;
        else
            return R.id.nav_scan;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        final int itemId = item.getItemId();

        return goToNavigationItem(itemId);
    }

    protected boolean goToNavigationItem(final int itemId) {

        /*if(itemId == getNavigationDrawerID()) {
            // just close drawer because we are already in this activity
            mDrawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }*/

        // delay transition so the drawer can close
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callDrawerItem(itemId);
            }
        }, NAVDRAWER_LAUNCH_DELAY);

        mDrawerLayout.closeDrawer(GravityCompat.START);

        selectNavigationItem(itemId);

        // fade out the active activity
        /*View mainContent = findViewById(R.id.main_content);
        if (mainContent != null) {
            mainContent.animate().alpha(0).setDuration(MAIN_CONTENT_FADEOUT_DURATION);
        }*/
        return true;
    }

    private void callDrawerItem(final int itemId) {
        selectItem(0, false);

        switch (itemId) {
            case R.id.nav_scan:
                selectItem(0, false);
                break;
            case R.id.nav_about:
                selectItem(3, false);
                break;
            case R.id.nav_settings:
                selectItem(2, false);
                break;
            default:
                selectItem(0, false);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        //mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public void selectItem(int position, boolean back) {
        // update the main content by replacing fragments
        TextView drawer_header = (TextView) findViewById(R.id.drawer_header);

        if (position == 0) {
            switchToFragment(new ScanFragment(), back);
            this.setTitle(R.string.app_name);
        } else if (position == 2) {
            switchToFragment(new SettingsFragment(), back);
            this.setTitle(R.string.title_activity_settings);
        } else if (position == 3) {
            switchToFragment(new AboutFragment(), back);
            this.setTitle(R.string.action_about);
        }
    }
}

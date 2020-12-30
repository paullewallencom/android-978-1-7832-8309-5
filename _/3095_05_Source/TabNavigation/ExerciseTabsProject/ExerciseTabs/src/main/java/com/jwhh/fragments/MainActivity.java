package com.jwhh.fragments;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Put ActionBar in Tab mode
    ActionBar actionBar = getActionBar();
    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

    // Create the first tab
    Fragment firstFragment = new FirstFragment();
    ActionBar.TabListener firstListener =
        new SimpleTabListener(firstFragment);
    ActionBar.Tab firstTab = actionBar.newTab()
        .setText("First")
        .setTabListener(firstListener);
    actionBar.addTab(firstTab);

    // Create the second tab
    Fragment secondFragment = new SecondFragment();
    ActionBar.TabListener secondListener =
        new SimpleTabListener(secondFragment);
    ActionBar.Tab secondTab = actionBar.newTab()
        .setText("Second")
        .setTabListener(secondListener);
    actionBar.addTab(secondTab);
  }

}

package com.jwhh.fragments;

import android.app.ActionBar;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ActionBar actionBar = getActionBar();
    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

    String[] screenNames = getResources().getStringArray(R.array.screen_names);
    ArrayAdapter<String> screenNamesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, screenNames);
    ActionBar.OnNavigationListener listener = new SimpleNavigationListener(getFragmentManager());
    actionBar.setListNavigationCallbacks(screenNamesAdapter, listener);

    actionBar.setDisplayShowTitleEnabled(false);
  }


}

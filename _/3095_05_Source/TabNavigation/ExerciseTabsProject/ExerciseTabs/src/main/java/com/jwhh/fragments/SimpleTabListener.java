package com.jwhh.fragments;

import android.R;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by Jim on 7/22/13.
 */
public class SimpleTabListener implements ActionBar.TabListener {
  Boolean mFirstSelect = true;
  Fragment mFragment;

  public SimpleTabListener(Fragment fragment) {
    mFragment = fragment;
  }

  @Override
  public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    if (mFirstSelect) {
      fragmentTransaction.add(R.id.content, mFragment);
      mFirstSelect = false;
    }
    else
      fragmentTransaction.attach(mFragment);
  }

  @Override
  public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    fragmentTransaction.detach(mFragment);
  }

  @Override
  public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

  }
}

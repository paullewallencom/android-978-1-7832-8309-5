package com.jwhh.fragments;

import android.R;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Created by Jim on 7/23/13.
 */
public class SimpleNavigationListener implements ActionBar.OnNavigationListener {
  FragmentManager mFragmentManager;

  public SimpleNavigationListener(FragmentManager fragmentManager) {
    mFragmentManager = fragmentManager;
  }

  @Override
  public boolean onNavigationItemSelected(int itemPosition, long itemId) {
    Fragment fragment = null;

    switch (itemPosition) {
      case 0:
        fragment = new FirstFragment();
        break;
      case 1:
        fragment = new SecondFragment();
        break;
      case 2:
        fragment = new ThirdFragment();
        break;
    }

    if (fragment != null) {
      FragmentTransaction ft = mFragmentManager.beginTransaction();
      ft.replace(R.id.content, fragment);
      ft.commit();
    }

    return true;
  }


}

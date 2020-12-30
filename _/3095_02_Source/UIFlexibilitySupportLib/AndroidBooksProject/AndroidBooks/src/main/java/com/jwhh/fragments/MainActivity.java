package com.jwhh.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

public class MainActivity extends FragmentActivity
    implements OnSelectedBookChangeListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }


  @Override
  public void onSelectedBookChanged(int bookIndex) {
    // Access the FragmentManager
    FragmentManager fragmentManager = getSupportFragmentManager();
    // Get the book description fragment
    BookDescFragment bookDescFragment = (BookDescFragment)
        fragmentManager.findFragmentById(R.id.fragmentDescription);
    // Display the book title
    if (bookDescFragment != null)
      bookDescFragment.setBook(bookIndex);
  }
}

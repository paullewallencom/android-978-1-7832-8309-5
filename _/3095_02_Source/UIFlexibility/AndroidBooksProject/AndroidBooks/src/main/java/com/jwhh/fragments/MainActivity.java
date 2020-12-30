package com.jwhh.fragments;

import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity
    implements OnSelectedBookChangeListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // load the activity_main layout resource
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
    FragmentManager fragmentManager = getFragmentManager();
    // Get the book description fragment
    BookDescFragment bookDescFragment = (BookDescFragment)
        fragmentManager.findFragmentById(R.id.fragmentDescription);
    // Display the book title
    if(bookDescFragment != null)
      bookDescFragment.setBook(bookIndex);
  }
}

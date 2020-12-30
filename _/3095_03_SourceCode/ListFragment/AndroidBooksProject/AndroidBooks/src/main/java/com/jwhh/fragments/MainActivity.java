package com.jwhh.fragments;

import android.app.FragmentManager;
import android.content.Intent;
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

    // Check validity of fragment reference
    if (bookDescFragment == null || !bookDescFragment.isVisible()) {
      // Use activity to display description
      Intent intent = new Intent(this, BookDescActivity.class);

      intent.putExtra("bookIndex", bookIndex);
      startActivity(intent);
    } else {
      // Use contained fragment to display description
      bookDescFragment.setBook(bookIndex);
    }
  }
}

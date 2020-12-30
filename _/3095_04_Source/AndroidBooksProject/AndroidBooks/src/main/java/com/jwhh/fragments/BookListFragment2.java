package com.jwhh.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Jim on 8/14/13.
 */
public class BookListFragment2 extends ListFragment {
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    String[] bookTitles =
        getResources().getStringArray(R.array.bookTitles);
    ArrayAdapter<String> bookTitlesAdapter;
    bookTitlesAdapter = new ArrayAdapter<String>(getActivity(),
        android.R.layout.simple_list_item_1, bookTitles);

    setListAdapter(bookTitlesAdapter);
  }

  @Override
  public void onListItemClick(ListView l, View v,
                              int position, long id) {
    // Access the Activity and cast to the inteface
    OnSelectedBookChangeListener listener =
        (OnSelectedBookChangeListener)
            getActivity();

    // Notify the Activity of the selection
    listener.onSelectedBookChanged(position);
  }
}

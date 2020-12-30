package com.pluralsight.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class BookFragment extends Fragment {
  public final static String BOOK_TITLE = "book title";
  public final static String BOOK_DESCRIPTIONS = "book description";
  public final static String TOP_IMAGE = "top image";

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View theView = inflater.inflate(R.layout.fragment_book_info, container, false);

    Bundle arguments = getArguments();
    if (arguments != null) {
      String bookTitle = arguments.getString(BOOK_TITLE);
      String bookDescription = arguments.getString(BOOK_DESCRIPTIONS);
      int topCardResourceId = arguments.getInt(TOP_IMAGE);

      displayValues(theView, bookTitle, bookDescription,
          topCardResourceId);

    }
    return theView;
  }

  private void displayValues(View theView, String bookTitle,
                             String bookDescription, int topCardResourceId) {
    TextView bookTitleTextView = (TextView) theView.findViewById(R.id.bookTitle);
    TextView bookDescriptionTextView = (TextView) theView.findViewById(R.id.bookDescription);
    ImageView topImageView = (ImageView) theView.findViewById(R.id.topImage);

    bookTitleTextView.setText(bookTitle);
    bookDescriptionTextView.setText(bookDescription);

    topImageView.setImageResource(topCardResourceId);
  }
}

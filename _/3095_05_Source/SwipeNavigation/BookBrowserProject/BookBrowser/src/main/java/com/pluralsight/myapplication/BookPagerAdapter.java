package com.pluralsight.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Jim on 7/6/13.
 */
public class BookPagerAdapter extends FragmentPagerAdapter {
  final String[] mBookTitles;
  final String[] mBookTitlesShort;
  final String[] mBookDescriptions;

  // Creating an array of drawable resources as a resource adds some complications
  // that are outside the scope of our discussion so just loading the array here
  // in code. If you'd like to learn more about working with an array of resources
  // that is defined as a resource, checkout the Typed Array documentation on
  // the Android developer site:
  // http://developer.android.com/guide/topics/resources/more-resources.html#TypedArray
  final int[] mTopImageResourceIds =
      {
          R.drawable.db_programming_top_card,
          R.drawable.android_4_top_card,
          R.drawable.sys_dev_top_card,
          R.drawable.and_engine_top_card
      };

  public BookPagerAdapter(FragmentManager fm, Context context) {
    super(fm);

    Resources resources = context.getResources();
    mBookTitles = resources.getStringArray(R.array.book_titles);
    mBookTitlesShort = resources.getStringArray(R.array.book_titles_short);
    mBookDescriptions = resources.getStringArray(R.array.book_descriptions);
;

  }

  @Override
  public Fragment getItem(int i) {

    Bundle arguments = new Bundle();
    arguments.putString(BookFragment.BOOK_TITLE, mBookTitles[i]);
    arguments.putString(BookFragment.BOOK_DESCRIPTIONS, mBookDescriptions[i]);
    arguments.putInt(BookFragment.TOP_IMAGE, mTopImageResourceIds[i]);

    BookFragment bookFragment = new BookFragment();
    bookFragment.setArguments(arguments);
    return bookFragment;
  }


  @Override
  public CharSequence getPageTitle(int position) {
    return mBookTitlesShort[position];
  }

  @Override
  public int getCount() {
    return mBookTitlesShort.length;
  }
}

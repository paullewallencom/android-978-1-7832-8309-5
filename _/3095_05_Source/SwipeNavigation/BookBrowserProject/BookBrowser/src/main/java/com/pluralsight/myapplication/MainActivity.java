package com.pluralsight.myapplication;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
//import android.view.Menu;

public class MainActivity extends FragmentActivity {

  BookPagerAdapter mBookPagerAdapter;
  ViewPager mViewPager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    mBookPagerAdapter = new BookPagerAdapter(getSupportFragmentManager(), this);

    mViewPager = (ViewPager) findViewById(R.id.pager);
    mViewPager.setAdapter(mBookPagerAdapter);

  }

}

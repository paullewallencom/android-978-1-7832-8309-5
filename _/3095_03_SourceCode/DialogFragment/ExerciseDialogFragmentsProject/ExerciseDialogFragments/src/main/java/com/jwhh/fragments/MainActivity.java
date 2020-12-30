package com.jwhh.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity
    implements MyDialogFragment.OnButtonClickListener{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button button;

    button = (Button) findViewById(R.id.btnRegularDialogFragment);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        handleRegularDialogFragment((Button)view);
      }
    });

    button = (Button) findViewById(R.id.btnAlertDialogAsFragment);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        handleAlertDialogAsFragment((Button) view);
      }
    });

  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  void handleRegularDialogFragment(Button button) {
    MyDialogFragment theDialog = new MyDialogFragment();
    theDialog.show(getFragmentManager(), null);
  }

  void handleAlertDialogAsFragment(Button button) {
    AlertDialogFragment theDialog = new AlertDialogFragment();
    theDialog.show(getFragmentManager(), null);
  }

  @Override
  public void onButtonClick(int buttonId) {
    String message = "Unknown selection";

    switch (buttonId) {
      case R.id.btnYes:
        message = "On the regular dialog Fragment you selected: " + getString(R.string.text_yes);
        break;
      case R.id.btnNo:
        message = "On the regular dialog Fragment you selected: " + getString(R.string.text_no);
        break;
      case DialogInterface.BUTTON_POSITIVE:
        message = "On the Alert dialog Fragment you selected: " + getString(R.string.text_yes);
        break;
      case DialogInterface.BUTTON_NEGATIVE:
        message = "On the Alert dialog Fragment you selected: " + getString(R.string.text_no);
        break;
    }

    Toast.makeText(this, message, Toast.LENGTH_LONG).show();

  }
}

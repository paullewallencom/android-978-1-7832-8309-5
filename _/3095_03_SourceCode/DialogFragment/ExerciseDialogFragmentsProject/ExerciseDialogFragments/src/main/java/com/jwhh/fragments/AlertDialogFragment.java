package com.jwhh.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Jim on 8/15/13.
 */
public class AlertDialogFragment extends DialogFragment
  implements DialogInterface.OnClickListener {

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    // Create the Builder for the AlertDialog
    AlertDialog.Builder builder =
        new AlertDialog.Builder(getActivity());

    // Set the AlertDialog options
    builder.setTitle(R.string.alert_dialog_title)
        .setMessage(R.string.alert_dialog_message)
        .setIcon(R.drawable.ic_launcher)
        .setCancelable(false)
        .setPositiveButton(R.string.text_yes, this)
        .setNegativeButton(R.string.text_no, this);

    // Create and return the AlertDialog
    AlertDialog alertDialog = builder.create();
    return alertDialog;
  }

  @Override
  public void onClick(DialogInterface dialogInterface, int buttonId) {
    // Notify the Activity of the button selection
    MyDialogFragment.OnButtonClickListener parentActivity =
        (MyDialogFragment.OnButtonClickListener) getActivity();
    parentActivity.onButtonClick(buttonId);

    dialogInterface.dismiss();
  }
}

package com.jwhh.fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jim on 8/15/13.
 */
public class MyDialogFragment extends DialogFragment
    implements View.OnClickListener{

  // Interface Activity implements for notification
  public interface OnButtonClickListener {
    void onButtonClick(int buttonId);
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

//    setStyle(DialogFragment.STYLE_NO_TITLE, 0);
    setStyle(DialogFragment.STYLE_NORMAL, 0);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View theView = inflater.inflate(R.layout.fragment_my_dialog, container, false);

    // Connect the Yes button click event and request focus
    View yesButton = theView.findViewById(R.id.btnYes);
    yesButton.setOnClickListener(this);
    yesButton.requestFocus();

    // Connect the No button click event
    View noButton = theView.findViewById(R.id.btnNo);
    noButton.setOnClickListener(this);

    Dialog dialog = getDialog();
    dialog.setTitle(getString(R.string.myDialogFragmentTitle));
    dialog.setCanceledOnTouchOutside(false);

    return theView;
  }

  @Override
  public void onClick(View view) {
    int buttonId = view.getId();

    // Notify the Activity of the button selection
    OnButtonClickListener parentActivity =
        (OnButtonClickListener) getActivity();
    parentActivity.onButtonClick(buttonId);

    // Close the dialog fragment
    dismiss();
  }
}

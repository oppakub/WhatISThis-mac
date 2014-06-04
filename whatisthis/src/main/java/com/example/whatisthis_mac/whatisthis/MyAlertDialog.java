package com.example.whatisthis_mac.whatisthis;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by oppakub on 6/4/14 AD.
 */
public class MyAlertDialog {
    private AlertDialog.Builder objAlert;
    public void NoChooseEveryThing(Context context) {
        objAlert = new AlertDialog.Builder(context);
        objAlert.setIcon(R.drawable.danger);
        objAlert.setTitle("Please select the answer!");
        objAlert.setMessage("Please Choose Answer on Radio Buttom");
        objAlert.setCancelable(false);
        objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        objAlert.show();
    }
}

package com.example.apple.modernartui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.content.DialogInterface;
import android.widget.TextView;

import static android.app.PendingIntent.getActivity;

public class ColoredBox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colored_box);
    }


    // Create an action menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_option_menu, menu);
        //MenuItem moreInfo = menu.findItem(R.id.more);
        //moreInfo.setEnabled(true);
        return super.onCreateOptionsMenu(menu);
        //return true;
    }


    // Called whenever an item is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.more:
                showDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Called when the more_information item is called, and
    // a dialog is showing up with text and two buttons
    private void showDialog() {
        // Pop up a dailog window
        TextView titleMsg = new TextView(this);
        titleMsg.setText("Inspired by the works of Modern Art masters such as Piet Mondrian and Ben Nickolson.\n\n" +
                "Click here to learn more!");
        titleMsg.setGravity(Gravity.CENTER_HORIZONTAL);
        AlertDialog.Builder alertbox = new AlertDialog.Builder(this)
                .setView(titleMsg)
                        /*
                        .setTitle("")
                        .setMessage("Click here to learn more!")*/
                .setNegativeButton("Visit MOMA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Open the website here
                        openWebsite();
                    }
                })
                .setPositiveButton("Not Now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Do nothing
                    }
                });
        // show it
        alertbox.show();
    }


    // Called when the learn more button is pressed in the dialog
    private void openWebsite() {
        Uri website = Uri.parse("https://www.moma.org/");
        Intent baseIntent = new Intent(Intent.ACTION_VIEW, website);


        // TODO - Create a chooser intent, for choosing which Activity
        // will carry out the baseIntent
        // (HINT: Use the Intent class' createChooser() method)
        //Intent chooserIntent = null;
        Intent chooserIntent = Intent.createChooser(baseIntent, "Choose an app to open the URL.");

        // TODO - Start the chooser Activity, using the chooser intent
        if (baseIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooserIntent);
        }
    }
}

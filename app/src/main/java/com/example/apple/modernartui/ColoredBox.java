package com.example.apple.modernartui;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.net.sip.SipAudioCall;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.content.DialogInterface;
import android.widget.GridView;
import android.widget.SeekBar;
import android.widget.TextView;


public class ColoredBox extends AppCompatActivity {
    SeekBar colorSeekBar;
    GridView gridView1;
    GridView gridView2;
    GridView gridView3;
    GridView gridView4;
    GridView gridView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colored_box);

        // Set the view form the main resource
        colorSeekBar = (SeekBar) findViewById(R.id.SlideBar);
        gridView1 = (GridView) findViewById(R.id.gridView1);
        gridView2 = (GridView) findViewById(R.id.gridView2);
        gridView3 = (GridView) findViewById(R.id.gridView3);
        gridView4 = (GridView) findViewById(R.id.gridView4);
        gridView5 = (GridView) findViewById(R.id.gridView5);

        // Assign this class as a listener for the SeekBar events
        SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                gridView1.setBackgroundColor(Color.rgb(107 + (148 / 100) * progress
                        , 120 + (134 / 100) * progress
                        , 181 + (6 / 100) * progress));
                gridView2.setBackgroundColor(Color.rgb(212 + (42 / 100) * progress
                        , 82 + (146 / 100) * progress
                        , 150 + (6 / 100) * progress));
                gridView3.setBackgroundColor((Color.rgb(161 + (92 / 100) * progress
                        , 31 + (147 / 100) * progress
                        , 38 + (17 / 100) * progress)));
                gridView5.setBackgroundColor(Color.rgb(41 + (148 / 100) * progress
                        , 61 + (146 / 100) * progress
                        , 149 + (4 / 100) * progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
        colorSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);

    }


    // Create an action menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_option_menu, menu);
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

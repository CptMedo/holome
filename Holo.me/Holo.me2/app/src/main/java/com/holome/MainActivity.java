/**
 *
 * MainActivity.java
 * by Médéric Hénin on 12/02/2016
 *
 * THIS SOFTWARE IS UNDER CC-BY-NC LICENSE :
 * The licensor permits others to copy, distribute, display, and perform the work.
 * In return, licenses must give the original author credit.
 * The licensor permits others to copy, distribute, display, and perform the work.
 * In return, licenses may not use the work for commercial purposes -- unless they get the licensor's permission.
 *
 */

package com.holome;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton button;
    EditText editText;
    TextView textView;
    AlertDialog dialog;
    final String VIDEO_ID = "video_id";
    private static final String TAG = "Main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (ImageButton) findViewById(R.id.imageButton);
        button.setOnClickListener(this);

        editText = (EditText) findViewById(R.id.editText);

        textView = (TextView) findViewById(R.id.textView);

        //setting custom font to texts
        Typeface tf = Typeface.createFromAsset(getAssets(),
                "fonts/avenirheavy.otf");
        textView.setTypeface(tf);
        editText.setTypeface(tf);

        // create AlertDialog in case of blank id
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Vous devez entrer l'id d'une vidéo")
                .setTitle("ID MANQUANT");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                dialog.dismiss();
            }
        });
        dialog = builder.create();

    }

    @Override
    public void onClick(View v) {
        if (v==button) {
            if (!editText.getText().toString().trim().equals("")) {
                // if text isn't blan, show the ViedoActivity
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                intent.putExtra(VIDEO_ID, editText.getText().toString());
                startActivity(intent);
            }
            else {
                // else show the AlertDialog
                dialog.show();
            }

        }
    }
}

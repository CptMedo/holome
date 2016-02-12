package com.holome;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;
import java.lang.reflect.Field;

public class VideoActivity extends AppCompatActivity {

    final String VIDEO_ID = "video_id";

    String videoId;
    String videoName;
    VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        Intent intent = getIntent();

        if (intent != null) {

            videoId = intent.getStringExtra(VIDEO_ID);
            Log.i("video :", videoId);
        }

        videoName = getVideoName(videoId);

        mVideoView = (VideoView)findViewById(R.id.videoView);
        int resId = getResources().getIdentifier(videoName , "raw", getPackageName());

        String uriPath = "android.resource://com.holome/" + resId;
        Log.i("video :", videoName);

        Uri uri = Uri.parse(uriPath);
        mVideoView.setVideoURI(uri);

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {

                mVideoView.start();

            }
        });

//        mVideoView.setMediaController(new MediaController(this));
//
        mVideoView.start();
        mVideoView.requestFocus();
    }

    String getVideoName(String videoId) {
        switch (videoId) {
            case "aJX9ak" : return "adrien";
            case "eNDdTvd" : return "celadri";
            case "xcpsub" : return  "celine";
            case "pWJaWS" : return "coralie";
            case "gpWT6M" : return "ludo";
            case "f3FFW7" : return "medo";
            case "chanel" : return "channel";
            default:break;
        }
        return null;
    }

    public int getResId(String variableName, Class<?> с) {

        Field field = null;
        int resId = 0;
        try {
            field = с.getField(variableName);
            try {
                resId = field.getInt(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resId;

    }
}

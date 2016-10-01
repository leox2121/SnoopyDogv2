package com.records.irving.snoopydog;

/**
 * Created by Guerreri Majo on 13/01/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;


public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, login.class);
                startActivity(intent);
                System.exit(0);
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 5000);
    }



}


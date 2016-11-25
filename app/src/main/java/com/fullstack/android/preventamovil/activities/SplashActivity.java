package com.fullstack.android.preventamovil.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fullstack.android.preventamovil.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread loginThread = new Thread() {

            private static final int waitTo = 2000;
            int wait = 0;

            @Override
            public void run() {
                try {
                    while (wait < waitTo) {
                        sleep(1000);
                        wait += 1000;
                    }

                } catch (Exception e) {

                } finally {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };

        loginThread.start();
    }
}


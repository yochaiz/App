package com.anyonecan.tal.drawgame;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class HomeScreenActivity extends ImmersiveActivity {

    Class nextPage = MenuActivity.class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean inflateSuccess = false;
        while (!inflateSuccess) {
            try {
                setContentView(R.layout.activity_home_screen);
                inflateSuccess = true;
            } catch (Exception e) {
            }
        }

//        Button btn = (Button) findViewById(R.id.btn_home_screen);
//        btn.setOnClickListener(btnClick);

        if (!OcrManager.isInit) {
            OcrManager.init(this);
        }

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(
                        getBaseContext(), nextPage);
                startActivity(intent);
            }
        };
        long delay = 1500;
        timer.schedule(task, delay);
    }

//    private View.OnClickListener btnClick = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent intent = new Intent(
//                    getBaseContext(), nextPage);
//            startActivity(intent);
//            finish();
//        }
//    };
}

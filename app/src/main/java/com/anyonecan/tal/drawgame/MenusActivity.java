package com.anyonecan.tal.drawgame;

import android.content.Intent;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class MenusActivity extends ImmersiveActivity {

    Rect rect;

    protected View.OnTouchListener listener(final Class dstClass) {
        View.OnTouchListener listener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int x = 0;
                int y = 0;
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        view.setScaleX(0.8f);
                        view.setScaleY(0.8f);
                        x = view.getLeft();
                        y = view.getTop();
                        rect = new Rect(x, y, x + view.getWidth(), y + view.getHeight());
                        return false;

                    case MotionEvent.ACTION_UP:
                        view.setScaleX(1f);
                        view.setScaleY(1f);
                        if (rect.contains(x + (int) event.getX(), y + (int) event.getY())) {
                            Intent intent = new Intent(getBaseContext(), dstClass);
                            startActivity(intent);
                            finish();
                            break;
                        }
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        if (!rect.contains(x + (int) event.getX(), y + (int) event.getY())) {
                            view.setScaleX(1f);
                            view.setScaleY(1f);
                            return true;
                        }

                    case MotionEvent.ACTION_CANCEL:
                        if (!rect.contains(x + (int) event.getX(), y + (int) event.getY())) {
                            view.setScaleX(1f);
                            view.setScaleY(1f);
                            return true;
                        }
                }
                return false;
            }
        };
        return listener;
    }

}

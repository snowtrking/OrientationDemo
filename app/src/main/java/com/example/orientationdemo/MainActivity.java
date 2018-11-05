package com.example.orientationdemo;

import android.graphics.Canvas;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    OrientationEventListener mOrientationListener;
    TextView textView;
    private RectView mRectview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        mRectview=new RectView(this);
        addContentView(mRectview,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        mOrientationListener = new OrientationEventListener(this,
                SensorManager.SENSOR_DELAY_NORMAL) {

            @Override
            public void onOrientationChanged(int orientation) {
                if (orientation == OrientationEventListener.ORIENTATION_UNKNOWN) {
                    return;  //手机平放时，检测不到有效的角度
                }
                textView.setText(orientation+"");
                //可以根据不同角度检测处理，这里只检测四个角度的改变
//                if (orientation > 350 || orientation < 10) { //0度
//                    orientation = 0;
//                } else if (orientation > 80 && orientation < 100) { //90度
//                    orientation = 90;
//                } else if (orientation > 170 && orientation < 190) { //180度
//
//                    orientation = 180;
//                } else if (orientation > 260 && orientation < 280) { //270度
//                    orientation = 270;
//                } else {
//                    return;
//                }
               final int o=orientation;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mRectview.drawRect(o);
//                        mRectview.invalidate();
                    }
                });

            }
        };
        if (mOrientationListener.canDetectOrientation()) {
            mOrientationListener.enable();
        } else {
            mOrientationListener.disable();
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mOrientationListener.disable();
    }
}

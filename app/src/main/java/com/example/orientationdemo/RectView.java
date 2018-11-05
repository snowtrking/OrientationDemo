package com.example.orientationdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

public class RectView extends View {
    private Paint mPaint;
    private float mCenterPointX;
    private float mCenterPointY;
    private float width;
    private float height;
    private float mathWidth;
    private float mathHeight;
    private int mOrientation;


    public RectView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int stroke = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, metrics);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(stroke);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    public void drawRect(int orientation) {
        this.mOrientation = 360 - orientation;
        double ratio;
        if (width != 0 && height != 0) {

            if (360 > orientation && orientation > 270) {
                if (orientation > 351) {
                    ratio = ((double) orientation / 360);

                } else if (351 > orientation && orientation > 342) {
                    ratio = ((double) orientation / 360) - 0.05;

                } else if (342 > orientation && orientation > 333) {
                    ratio = ((double) orientation / 360) - 0.1;

                } else if (333 > orientation && orientation > 324) {
                    ratio = ((float) orientation / 360) - 0.15;

                } else if (324 > orientation && orientation > 315) {
                    ratio = ((float) orientation / 360) - 0.2;
                } else {
                    ratio = ((float) orientation / 360) - 0.25;
                }

                mathHeight = Math.abs((float) (height * ratio));
                mathWidth = Math.abs((float) (width * ratio));

            } else if (270 > orientation && orientation > 180) {
                if (9 > orientation && orientation > 0) {
                    ratio = ((double) (360 - (orientation - 180)) / 360);

                } else if (18 > orientation && orientation > 9) {
                    ratio = ((double) (360 - (orientation - 180)) / 360) - 0.05;

                } else if (27 > orientation && orientation > 18) {
                    ratio = ((double) (360 - (orientation - 180)) / 360) - 0.1;

                } else if (36 > orientation && orientation > 27) {
                    ratio = ((float) (360 - (orientation - 180)) / 360) - 0.15;

                } else if (45 > orientation && orientation > 36) {
                    ratio = ((float) (360 - (orientation - 180)) / 360) - 0.2;
                } else {
                    ratio = ((float) (360 - (orientation - 180)) / 360) - 0.25;
                }

                mathHeight = Math.abs((float) (height * ratio));
                mathWidth = Math.abs((float) (width * ratio));

            } else if (180 > orientation && orientation > 90) {
                if (9 > orientation && orientation > 0) {
                    ratio = ((double) (360 - (orientation - 90)) / 360);

                } else if (18 > orientation && orientation > 9) {
                    ratio = ((double) (360 - (orientation - 90)) / 360) - 0.05;

                } else if (27 > orientation && orientation > 18) {
                    ratio = ((double) (360 - (orientation - 90)) / 360) - 0.1;

                } else if (36 > orientation && orientation > 27) {
                    ratio = ((float) (360 - (orientation - 90)) / 360) - 0.15;

                } else if (45 > orientation && orientation > 36) {
                    ratio = ((float) (360 - (orientation - 90)) / 360) - 0.2;
                } else {
                    ratio = ((float) (360 - (orientation - 90)) / 360) - 0.25;
                }

                mathHeight = Math.abs((float) (height * ratio));
                mathWidth = Math.abs((float) (width * ratio));

            } else if (90 > orientation) {
                if (9 > orientation && orientation > 0) {
                    ratio = ((double) (360 - orientation) / 360);

                } else if (18 > orientation && orientation > 9) {
                    ratio = ((double) (360 - orientation) / 360) - 0.05;

                } else if (27 > orientation && orientation > 18) {
                    ratio = ((double) (360 - orientation) / 360) - 0.1;

                } else if (36 > orientation && orientation > 27) {
                    ratio = ((float) (360 - orientation) / 360) - 0.15;

                } else if (45 > orientation && orientation > 36) {
                    ratio = ((float) (360 - orientation) / 360) - 0.2;
                } else {
                    ratio = ((float) (360 - orientation) / 360) - 0.25;
                }

                mathHeight = Math.abs((float) (height * ratio));
                mathWidth = Math.abs((float) (width * ratio));

            }

            init();
        }
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        mCenterPointX = getWidth() / 2;
        mCenterPointY = getHeight() / 2;
        width = getWidth();
        height = getHeight();
        float startX = mCenterPointX - mathWidth / 2;
        float startY = mCenterPointY - mathHeight / 2;
        float stopX = mCenterPointX + mathWidth / 2;
        float stopY = mCenterPointY + mathHeight / 2;
        canvas.rotate(mOrientation, mCenterPointX, mCenterPointY);
        canvas.drawRect(startX, startY, stopX, stopY, mPaint);

    }
}

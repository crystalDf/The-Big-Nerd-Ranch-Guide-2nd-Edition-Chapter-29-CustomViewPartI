package com.star.customviewparti;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class CounterView extends View {

    private Paint mPaint;
    private Rect mRect;

    private int mCount;

    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint((Paint.ANTI_ALIAS_FLAG));
        mRect = new Rect();

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                invalidate();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);

        String text = mCount + "";

        mPaint.setColor(Color.YELLOW);
        mPaint.setTextSize(30);
        mPaint.getTextBounds(text, 0, text.length(), mRect);

        float textWidth = mRect.width();
        float textHeight = mRect.height();

        canvas.drawText(text, (getWidth() - textWidth) / 2,
                (getHeight() - textHeight) / 2, mPaint);
    }

}

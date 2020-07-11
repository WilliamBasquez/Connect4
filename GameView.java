package edu.utep.cs.cs4381.connectfour;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewTreeObserver;

public class GameView extends View {

    private int width, height; // width and height of this view in pixels

    public GameView(Context context) {
        super(context);
        calculateWidthAndHeight();
    }

    private void calculateWidthAndHeight() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    width = Math.min(getWidth(), getHeight());
                    height = Math.max(getWidth(), getHeight());
                }
            });
        }
    }

    private Paint brush1 = new Paint();
    private Paint brush2 = new Paint();

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        brush1.setColor(Color.BLACK);
        brush2.setColor(Color.RED);

        /**Vertical Lines**/
        float startX = width/9;
        float startY = height/2;

        float endX = width/9;
        float endY = (height/16)*14;

        for(int line = 0; line < 8; line++){
            canvas.drawLine(startX, startY, endX, endY, brush1);
            startX += width/9;
            endX += width/9;
        }

        /**Horizontal Lines**/
        startX = width/9;
        startY = height/2;
        endX = (width/9)*8;
        endY = height/2;

        for(int line = 0; line < 7; line++){
            canvas.drawLine(startX, startY, endX, endY, brush1);
            startY += (height/16);
            endY += height/16;
        }
    }
}

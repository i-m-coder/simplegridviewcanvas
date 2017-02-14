package customgrid.sumanth.com.customgrid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by SumanthMadala on 2/13/2017.
 */

public class CustomGridView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float gridWidth =0,gridHeight=0;
    Context context;
    int[] data;
    public CustomGridView(Context context,int[] data) {
        super(context);
        this.context = context;
        int length = data.length;
        this.data = data;
        if(length%2 != 0){
            length++;
        }


        paint.setColor(Color.RED);
    }


    public CustomGridView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public CustomGridView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomGridView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2f);
        float height = getHeight();
        float width = getWidth();
        gridWidth = width/2;
        gridHeight = height/2;
        canvas.drawRect(0f,0f,width , height,paint);
        paint.setColor(Color.WHITE);
        canvas.drawRect(2f,2f,width-2f , height-2f,paint);
        paint.setColor(Color.BLACK);
        canvas.drawLine(0f,height/2,width,height/2,paint);
        canvas.drawLine(width/2,0f,width/2,height,paint);
        paint.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.text_size));
        canvas.drawText("Section 1",width/8,height/4,paint);
        canvas.drawText("Section 2",3*width/4,height/4,paint);
        canvas.drawText("Section 3",width/8,3*height/4,paint);
        canvas.drawText("Section 4",3*width/4,3*height/4,paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int column = (int)(event.getX() / gridWidth);
            int row = (int)(event.getY() / gridHeight);
            switch(row){
                case 0:
                    if(column ==0){
                        showToastMessage(data[0]);
                    }else if(column ==1){
                        showToastMessage(data[1]);
                    }
                    break;
                case 1:
                    if(column == 0){
                        showToastMessage(data[2]);
                    }else if(column == 1){
                        showToastMessage(data[3]);
                    }
                    break;

            }

            invalidate();
        }
        return super.onTouchEvent(event);
    }

    private void showToastMessage(int data){
        Toast.makeText(context.getApplicationContext(), "selected data "+data,
                Toast.LENGTH_SHORT).show();
    }
}

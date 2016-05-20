package mini.miniarvin.customview.demo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

/**
 * Created by Administrator on 2016/5/18.
 */
public class OvalButton extends Button{

    int color;
    int size;
    int src;
    private Paint paint=new Paint();
    public OvalButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array= context.obtainStyledAttributes(attrs,R.styleable.OvalButton);
        //获得边框颜色属性的值(int最好)
        color=array.getInt(R.styleable.OvalButton_borderColor, Color.BLACK);
        Log.e("color","color"+color);
        //获得边框粗细属性的值
        size=array.getInt(R.styleable.OvalButton_borderSize,0);
        Log.e("size","size"+size);

        src=array.getInt(R.styleable.OvalButton_Src,0);
        //一定要回收数组
        array.recycle();

        //设置画笔的粗细
        paint.setStrokeWidth(size);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(color);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制按钮的边框
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),paint);
    }
}

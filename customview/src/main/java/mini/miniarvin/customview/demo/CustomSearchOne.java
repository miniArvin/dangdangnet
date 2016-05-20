package mini.miniarvin.customview.demo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/5/19.
 */
public class CustomSearchOne extends LinearLayout {


    private ImageView imageView;
    private EditText editText;

    public CustomSearchOne(Context context) {
        super(context);
    }

    public CustomSearchOne(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyAttributes(context,attrs);
    }

    public CustomSearchOne(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyAttributes(context,attrs);
    }

    public void applyAttributes(Context context,AttributeSet attrs){

        View v=LayoutInflater.from(context).inflate(R.layout.custom_search_one,this);
        imageView= (ImageView) v.findViewById(R.id.main_search_iv);
        editText= (EditText) v.findViewById(R.id.main_search_et);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

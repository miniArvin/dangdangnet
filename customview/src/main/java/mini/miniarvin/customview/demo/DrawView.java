package mini.miniarvin.customview.demo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2016/5/18.
 */
public class DrawView extends View {
    ArrayList<HashMap<String,Integer>> data=new ArrayList<>();
    int[] arrs=new int[]{10,20,30,40,50,60,70,80,90,100};
    Paint paint=new Paint();
    int startX=100;//第一个柱子的起始坐标
    int size=50;//柱子间的距离
    int padding=30;//柱子宽度
    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Activity ac= (Activity) context;
        Display display=ac.getWindowManager().getDefaultDisplay();
        int width=display.getWidth();
    }

    public void setData(ArrayList<HashMap<String,Integer>> data){
        this.data=data;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);

        canvas.drawLine(50, 5, 50, this.getHeight() - 50, paint);
        canvas.drawLine(50,this.getHeight()-50,this.getWidth(),this.getHeight()-50,paint);

        for(int i=0;i<arrs.length;i++){
            paint.setColor(Color.BLUE);
            canvas.drawText(arrs[i]+"",10,this.getHeight()-50-50*(i+1),paint);
        }
        for(int i=0;i<data.size();i++){
            HashMap<String,Integer>map=data.get(i);
            Iterator<String> iter=map.keySet().iterator();
            String s=iter.next();
            int num=map.get(s);

            canvas.drawText(s,startX+(padding+size)*i,this.getHeight()-30,paint);

            canvas.drawRect(startX+(padding+size)*i,this.getHeight()-50-num*5,startX+(padding+size)*i+size,this.getHeight()-50,paint);
        }
    }
}

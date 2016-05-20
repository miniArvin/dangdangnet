package mini.miniarvin.customview.demo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/5/18.
 */
public class AutoInput extends LinearLayout implements View.OnClickListener {

    EditText numText;

    public AutoInput(Context context,AttributeSet attrs) {
        super(context,attrs);
        View v = LayoutInflater.from(context).inflate(R.layout.custom_layout,this);
        Button addBtn = (Button) v.findViewById(R.id.reduceBtn);
        Button reduceBtn = (Button) v.findViewById(R.id.addBtn);
        numText = (EditText) v.findViewById(R.id.numText);

        addBtn.setOnClickListener(this);
        reduceBtn.setOnClickListener(this);
    }

    public int getNum(){
        String s = numText.getText().toString().trim();
        int t = Integer.parseInt(s);
        return t;
    }


    @Override
    public void onClick(View v) {
        String s = numText.getText().toString().trim();
        int t = Integer.parseInt(s);
        switch (v.getId()) {
            case R.id.reduceBtn:
                if (t > 0) {
                    t--;
                }
                break;
            case R.id.addBtn:
                if (t < 100) {
                    t++;
                }
                break;
        }
        numText.setText(t+"");

    }
}

package mini.miniarvin.dangdangnet.demo.adapter;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mini.miniarvin.dangdangnet.demo.R;


/**
 * Created by Administrator on 2016/5/11.
 */
public class CategoryLeftAdapter extends BaseAdapter {

    Context context = null;
    List<String> categoryNames = new ArrayList<String>();
    LayoutInflater categoryInflater = null;

    public CategoryLeftAdapter(Context context, List<String> categoryNames) {
        this.context = context;
        this.categoryNames = categoryNames;
        categoryInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return categoryNames.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = categoryInflater.inflate(R.layout.category_left_list, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

            for (int i = 0; i < categoryNames.size(); i++) {
                viewHolder.categoryTv.setText(categoryNames.get(position).toString());
            }


        return convertView;
    }

    static class ViewHolder {
        TextView categoryTv;

        public ViewHolder(View convertView) {
            categoryTv = (TextView) convertView.findViewById(R.id.category_left_tv);
        }

    }


}

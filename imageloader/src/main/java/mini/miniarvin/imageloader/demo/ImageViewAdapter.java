package mini.miniarvin.imageloader.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/16.
 */
public class ImageViewAdapter extends BaseAdapter {
    String httpUrl="http://192.168.13.104:8080/ImageLoader/";

    ArrayList<ImageBean>imageBeans=new ArrayList<>();
    Context context=null;
    RequestQueue queue;

    public ImageViewAdapter(ArrayList<ImageBean> imageBeans, Context context,RequestQueue queue) {
        this.imageBeans = imageBeans;
        this.context = context;
        this.queue=queue;
    }

    @Override
    public int getCount() {
        return imageBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return imageBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView= LayoutInflater.from(context).inflate(R.layout.image_loader_list,null);
            ViewHolder viewHolder=new ViewHolder();
            viewHolder.textView= (TextView) convertView.findViewById(R.id.list_tv);
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.list_iv);
            convertView.setTag(viewHolder);
        }
        ViewHolder viewHolder= (ViewHolder) convertView.getTag();
        viewHolder.textView.setText(imageBeans.get(position).getName());
        loadImage(queue,imageBeans.get(position).getUrl(),viewHolder.imageView);
        return convertView;
    }

    class ViewHolder{
        TextView textView;
        ImageView imageView;
    }

    public void loadImage (RequestQueue queue,String url,ImageView imageView){
        ImageLoader imageLoader=new ImageLoader(
                queue,
                new ImageLoader.ImageCache() {
                    LruCache<String,Bitmap>lruCache=new LruCache<>(10*1024*1024);
                    @Override
                    public Bitmap getBitmap(String s) {

                        return lruCache.get(s);
                    }

                    @Override
                    public void putBitmap(String s, Bitmap bitmap) {
                        lruCache.put(s,bitmap);
                    }
                });
        ImageLoader.ImageListener imageListener=ImageLoader.getImageListener(imageView,android.R.drawable.btn_default,android.R.drawable.stat_notify_error);
        imageLoader.get(httpUrl+url,imageListener,270,280);
    }
}

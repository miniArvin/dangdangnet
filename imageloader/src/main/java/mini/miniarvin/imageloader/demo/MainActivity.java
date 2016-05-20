package mini.miniarvin.imageloader.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String httpUrl="http://192.168.13.104:8080/ImageLoader/aaa";

    ListView listView=null;

    ArrayList<ImageBean> imageBeans=new ArrayList<>();

    RequestQueue queue=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue= Volley.newRequestQueue(this);
        listView= (ListView) findViewById(R.id.list_view);
        final ImageViewAdapter imageViewAdapter=new ImageViewAdapter(imageBeans,this,queue);
        listView.setAdapter(imageViewAdapter);

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                httpUrl,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {

                        try {
                            JSONArray array= jsonObject.getJSONArray("images");
                            for (int i=0;i<array.length();i++){
                                JSONObject obj= (JSONObject) array.get(i);
                                String name=obj.getString("name");
                                String url=obj.getString("url");
                                Log.e("1111111111",url);
                                imageBeans.add(new ImageBean(name,url));
                            }
                            imageViewAdapter.notifyDataSetChanged();

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }
        );
        queue.add(jsonObjectRequest);
    }


}

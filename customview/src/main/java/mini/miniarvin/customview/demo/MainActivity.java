package mini.miniarvin.customview.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ArrayList<HashMap<String, Integer>> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HashMap<String, Integer> map = new HashMap<>();
        map.put("zhangsan", 50);
        data.add(map);

        map = new HashMap<String, Integer>();
        map.put("lisi", 80);
        data.add(map);

        map = new HashMap<String, Integer>();
        map.put("zhangwu", 30);
        data.add(map);

        map = new HashMap<String, Integer>();
        map.put("zhaoliu", 90);
        data.add(map);

        map = new HashMap<String, Integer>();
        map.put("liqi", 60);
        data.add(map);

        CustomSearchOne customSearchOne= (CustomSearchOne) this.findViewById(R.id.search_one);

        DrawView autoInput = (DrawView) this.findViewById(R.id.draw_view);
        autoInput.setData(data);

    }
}

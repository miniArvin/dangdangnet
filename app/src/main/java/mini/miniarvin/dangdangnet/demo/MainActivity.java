package mini.miniarvin.dangdangnet.demo;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import mini.miniarvin.dangdangnet.demo.fragment.CartFragment;
import mini.miniarvin.dangdangnet.demo.fragment.CategoryFragment;
import mini.miniarvin.dangdangnet.demo.fragment.HomeFragment;
import mini.miniarvin.dangdangnet.demo.fragment.MyDangFragment;
import mini.miniarvin.dangdangnet.demo.fragment.SearchFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton homeBtn = null;
    ImageButton categoryBtn = null;
    ImageButton searchBtn = null;
    ImageButton cartBtn = null;
    ImageButton mydangBtn = null;

    HomeFragment homeFragment = null;
    CategoryFragment categoryFragment = null;
    SearchFragment searchFragment = null;
    CartFragment cartFragment = null;
    MyDangFragment myDangFragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeBtn = (ImageButton) findViewById(R.id.menu_home_rb);
        categoryBtn = (ImageButton) findViewById(R.id.menu_category_rb);
        searchBtn = (ImageButton) findViewById(R.id.menu_search_rb);
        cartBtn = (ImageButton) findViewById(R.id.menu_cart_rb);
        mydangBtn = (ImageButton) findViewById(R.id.menu_mydang_rb);


//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        lp.setMargins(-45, -45, -30, -30);
//        homeBtn.setLayoutParams(lp);
        setDefaultFragment();

        homeBtn.setOnClickListener(this);
        categoryBtn.setOnClickListener(this);
        searchBtn.setOnClickListener(this);
        cartBtn.setOnClickListener(this);
        mydangBtn.setOnClickListener(this);



    }

    public void setDefaultFragment() {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        homeFragment = new HomeFragment();
        fragmentTransaction.replace(R.id.id_content, homeFragment);
        fragmentTransaction.commit();
        homeBtn.setBackgroundResource(R.drawable.menu_home_down);
    }

    public void changeBg(){
        homeBtn.setBackgroundResource(R.drawable.menu_home_up);
        categoryBtn.setBackgroundResource(R.drawable.menu_category_up);
        cartBtn.setBackgroundResource(R.drawable.menu_cart_up);
        searchBtn.setBackgroundResource(R.drawable.menu_search_up);
        mydangBtn.setBackgroundResource(R.drawable.menu_mydang_up);
    }




    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.menu_home_rb:
                if(homeFragment==null){
                    homeFragment=new HomeFragment();
                }
                fragmentTransaction.replace(R.id.id_content, homeFragment);
                changeBg();
                homeBtn.setBackgroundResource(R.drawable.menu_home_down);
                break;
            case R.id.menu_category_rb:
                if(categoryFragment==null){
                    categoryFragment=new CategoryFragment();
                }
                Log.e("1111111111111","111111111111111111");
                fragmentTransaction.replace(R.id.id_content,categoryFragment);
                changeBg();
                categoryBtn.setBackgroundResource(R.drawable.menu_category_down);
                break;
            case R.id.menu_search_rb:
                if(searchFragment==null){
                    searchFragment=new SearchFragment();
                }
                fragmentTransaction.replace(R.id.id_content,searchFragment);
                changeBg();
                searchBtn.setBackgroundResource(R.drawable.menu_search_down);
                break;
            case R.id.menu_cart_rb:
                if(cartFragment==null){
                    cartFragment=new CartFragment();
                }
                fragmentTransaction.replace(R.id.id_content,cartFragment);
                changeBg();
                cartBtn.setBackgroundResource(R.drawable.menu_cart_down);
                break;
            case R.id.menu_mydang_rb:
                if(myDangFragment==null){
                    myDangFragment=new MyDangFragment();
                }
                fragmentTransaction.replace(R.id.id_content,myDangFragment);
                changeBg();
                mydangBtn.setBackgroundResource(R.drawable.menu_mydang_down);
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }
}

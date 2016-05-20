package mini.miniarvin.dangdangnet.demo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import mini.miniarvin.dangdangnet.demo.MainActivity;
import mini.miniarvin.dangdangnet.demo.R;
import mini.miniarvin.dangdangnet.demo.adapter.CategoryLeftAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    View categoryView=null;
    ListView categoryListView=null;
    List<String> categoryNames=new ArrayList<String>();


    FragmentManager fragmentManager = null;
    FragmentTransaction fragmentTransaction=null;
    BooksFragment booksFragment=null;
    ChildsBooksFragment childsBooksFragment=null;

    public CategoryFragment() {
        // Required empty public constructor
        categoryNames.add("图书");
        categoryNames.add("童书");
        categoryNames.add("电子书");
        categoryNames.add("女装");
        categoryNames.add("男装");
        categoryNames.add("男女鞋靴");
        categoryNames.add("运动户外");
        categoryNames.add("箱包皮具");
        categoryNames.add("内衣配饰");
        categoryNames.add("童装童鞋");
        categoryNames.add("孕婴童");
        categoryNames.add("腕表眼镜");
        categoryNames.add("珠宝饰品");

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        categoryView = inflater.inflate(R.layout.fragment_category, container, false);
        categoryListView= (ListView) categoryView.findViewById(R.id.category_lv);

        //setDefaultFragment();
        categoryListView.setAdapter(new CategoryLeftAdapter(getActivity(), categoryNames));
        categoryListView.setOnItemClickListener(new OnListItemClickListener());

        return categoryView;
    }


    public void setDefaultFragment(){

        FragmentManager manager=getActivity().getSupportFragmentManager();

        FragmentTransaction transaction=manager.beginTransaction();

        if(booksFragment==null){
            booksFragment=new BooksFragment();
        }
        transaction.replace(R.id.category_fl,booksFragment );

        transaction.commit();

    }

    public class OnListItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            fragmentManager = getActivity().getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            switch (position){
                case 0:
                    if (getTargetFragment()!=null){

                    }

                    break;
                case 1:
                    if(childsBooksFragment==null){
                        childsBooksFragment=new ChildsBooksFragment();
                    }
                    fragmentTransaction.replace(R.id.category_fl, childsBooksFragment);
                    break;
            }
            fragmentTransaction.commit();
        }
    }

}

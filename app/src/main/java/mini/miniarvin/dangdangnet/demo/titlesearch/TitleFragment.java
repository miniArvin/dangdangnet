package mini.miniarvin.dangdangnet.demo.titlesearch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import mini.miniarvin.dangdangnet.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitleFragment extends Fragment {

    View titleView = null;
    ImageButton titleIb,searchIb;
    EditText searchET;
    ImageView deleteIv;

    TitleSearchFragment titleSearchFragment=null;

    public TitleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        titleView = inflater.inflate(R.layout.fragment_title, container, false);
        titleIb= (ImageButton) titleView.findViewById(R.id.title_ib);
        searchIb= (ImageButton) titleView.findViewById(R.id.ib_search);
        searchET= (EditText) titleView.findViewById(R.id.et_search);
        deleteIv= (ImageView) titleView.findViewById(R.id.iv_delete_search);
//        searchET.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                if(titleSearchFragment==null){
//                    titleSearchFragment=new TitleSearchFragment();
//                }
//                fragmentTransaction.add(R.id.id_content,titleSearchFragment);
//                fragmentTransaction.commit();
//            }
//        });
        return titleView;
    }

}

package mini.miniarvin.dangdangnet.demo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mini.miniarvin.dangdangnet.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BooksFragment extends Fragment {

    View booksView=null;

    public BooksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        booksView=inflater.inflate(R.layout.fragment_books, container, false);

        return booksView;
    }

}

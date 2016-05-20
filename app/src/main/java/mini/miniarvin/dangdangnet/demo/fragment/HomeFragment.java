package mini.miniarvin.dangdangnet.demo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import mini.miniarvin.dangdangnet.demo.R;
import mini.miniarvin.dangdangnet.demo.rollviewpager.RollPagerView;
import mini.miniarvin.dangdangnet.demo.rollviewpager.adapter.LoopPagerAdapter;
import mini.miniarvin.dangdangnet.demo.rollviewpager.adapter.StaticPagerAdapter;
import mini.miniarvin.dangdangnet.demo.rollviewpager.hintview.IconHintView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment  {

    private RollPagerView mRollViewPager;
    private View homeView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homeView = inflater.inflate(R.layout.fragment_home, container, false);
        mRollViewPager= (RollPagerView) homeView.findViewById(R.id.roll_view_pager);
        mRollViewPager.setPlayDelay(1000);
        mRollViewPager.setAnimationDurtion(500);
        mRollViewPager.setAdapter(new TestLoopAdapter(mRollViewPager));
        mRollViewPager.setHintView(new IconHintView(getActivity(), R.drawable.point_focus, R.drawable.point_normal));
        return homeView;
    }



    private class TestLoopAdapter extends LoopPagerAdapter {
        private int[] imgs = {
                R.drawable.dd_scroll_1,
                R.drawable.dd_scroll_2,
                R.drawable.dd_scroll_3,
                R.drawable.dd_scroll_4,
                R.drawable.dd_scroll_5,
        };

        public TestLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getRealCount() {
            return imgs.length;
        }

    }

    private class TestNomalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.dd_scroll_1,
                R.drawable.dd_scroll_2,
                R.drawable.dd_scroll_3,
                R.drawable.dd_scroll_4,
        };


        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }



}

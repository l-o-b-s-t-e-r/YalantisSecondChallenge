package yalantis.loboda.yalantissecondchallenge;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ListView;


public class ListViewFragment extends Fragment implements Animation.AnimationListener {

    private Animation mAnimationHide;
    private Animation mAnimationShow;
    private FloatingActionButton mFab;

    public ListViewFragment() {

    }

    static public Fragment newInstance(String title) {
        ListViewFragment f = new ListViewFragment();

        Bundle args = new Bundle();
        args.putString(MainActivity.TITLE, title);
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        mAnimationHide = AnimationUtils.loadAnimation(view.getContext(), R.anim.fab_anim_hide);
        mAnimationShow = AnimationUtils.loadAnimation(view.getContext(), R.anim.fab_anim_show);

        mAnimationHide.setAnimationListener(this);
        mAnimationShow.setAnimationListener(this);

        ListView listView = (ListView) view.findViewById(R.id.list_view);
        mFab = (FloatingActionButton) view.findViewById(R.id.fab);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_TOUCH_SCROLL) {
                    mFab.startAnimation(mAnimationShow);
                } else {
                    mFab.startAnimation(mAnimationHide);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        ListViewAdapter listViewAdapter = new ListViewAdapter(getContext(), R.layout.fragment_list, MainActivity.contents);
        listView.setAdapter(listViewAdapter);
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (mFab.getVisibility() == View.VISIBLE) {
            mFab.setVisibility(View.INVISIBLE);
        } else {
            mFab.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}

package yalantis.loboda.yalantissecondchallenge;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RecyclerViewFragment extends Fragment {

    public RecyclerViewFragment() {

    }

    static public Fragment newInstance(String title, TabLayout tabLayout) {
        RecyclerViewFragment f = new RecyclerViewFragment();
        tabLayout.addTab(tabLayout.newTab());

        Bundle args = new Bundle();
        args.putString(MainActivity.TITLE, title);
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.contents, getContext());
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }
}

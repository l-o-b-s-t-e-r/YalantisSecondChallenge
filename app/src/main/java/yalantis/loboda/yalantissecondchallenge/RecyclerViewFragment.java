package yalantis.loboda.yalantissecondchallenge;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class RecyclerViewFragment extends Fragment {

    private int mNum;

    public RecyclerViewFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        if (recyclerView==null){
            Log.i("WTF?","WTF?");
        }
        recyclerView.setLayoutManager(linearLayoutManager);

        List<CardContent> contents = Arrays.asList(
                CardContent.getInstance()
                        .setAddress(getString(R.string.address))
                        .setDate(new Date())
                        .setDays(7)
                        .setLikesCount(4)
                        .setOrganization(Organization.MUNICIPAL),

                CardContent.getInstance()
                        .setAddress(getString(R.string.address))
                        .setDate(new Date())
                        .setDays(7)
                        .setLikesCount(4)
                        .setOrganization(Organization.BUILDING));

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(contents, getContext());
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

    static public Fragment newInstance(int num) {
        RecyclerViewFragment f = new RecyclerViewFragment();

        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }
}

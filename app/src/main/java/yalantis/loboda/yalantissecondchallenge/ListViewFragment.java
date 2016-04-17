package yalantis.loboda.yalantissecondchallenge;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class ListViewFragment extends Fragment {

    private int mNum;

    public ListViewFragment() {

    }

    static public Fragment newInstance() {
        return new ListViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list_view);

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

        ListViewAdapter listViewAdapter = new ListViewAdapter(getContext(), R.layout.fragment_list, contents);
        listView.setAdapter(listViewAdapter);
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i("START","START");
    }

}

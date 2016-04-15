package yalantis.loboda.yalantissecondchallenge;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ListViewFragment extends Fragment {

    private int mNum;

    public ListViewFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    static public Fragment newInstance(){
        return new ListViewFragment();
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i("START","START");
    }

}

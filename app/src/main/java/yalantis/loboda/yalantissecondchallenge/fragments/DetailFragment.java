package yalantis.loboda.yalantissecondchallenge.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import yalantis.loboda.yalantissecondchallenge.R;
import yalantis.loboda.yalantissecondchallenge.activities.MainActivity;
import yalantis.loboda.yalantissecondchallenge.models.CardContent;


public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView title = (TextView) view.findViewById(R.id.title);
        ImageView topIcon = (ImageView) view.findViewById(R.id.top_icon);
        TextView likeCount = (TextView) view.findViewById(R.id.likes_count);
        TextView address = (TextView) view.findViewById(R.id.address);
        TextView date = (TextView) view.findViewById(R.id.date);
        TextView days = (TextView) view.findViewById(R.id.days);

        CardContent cardContent = MainActivity.contents.get(getActivity().getIntent().getIntExtra(MainActivity.DETAIL_INFO, 0));

        topIcon.setImageResource(cardContent.getOrganisation().getIconId());
        title.setText(getContext().getString(cardContent.getOrganisation().getNameId()));
        likeCount.setText(String.valueOf(cardContent.getLikesCount()));
        address.setText(cardContent.getAddress());
        date.setText(getFormattedDate(cardContent.getDate()));
        days.setText(getFormattedDays(cardContent.getDays()));

        return view;
    }

    public String getFormattedDays(int days) {
        return String.valueOf(days) + " " + getString(R.string.days);
    }

    public String getFormattedDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        String month = getResources().getStringArray(R.array.month)[calendar.get(Calendar.MONTH)];
        String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String year = String.valueOf(calendar.get(Calendar.YEAR));

        return month + " " + day + ", " + year;
    }
}

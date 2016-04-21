package yalantis.loboda.yalantissecondchallenge;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Lobster on 17.04.16.
 */
public class ListViewAdapter extends ArrayAdapter<CardContent> {

    private List<CardContent> mContents;

    public ListViewAdapter(Context context, int layoutId, List<CardContent> contents) {
        super(context, layoutId, contents);
        mContents = contents;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        ViewHolder viewHolder = new ViewHolder(cardView);
        viewHolder.setContent(mContents.get(position));
        cardView.setTag(viewHolder);

        return cardView;
    }

    public class ViewHolder {

        private ImageView mOrganizationIcon;
        private TextView mOrganizationName;
        private TextView mLikeCount;
        private TextView mAddress;
        private TextView mDate;
        private TextView mDays;

        public ViewHolder(CardView cardView) {
            mOrganizationIcon = (ImageView) cardView.findViewById(R.id.top_icon);
            mOrganizationName = (TextView) cardView.findViewById(R.id.title);
            mLikeCount = (TextView) cardView.findViewById(R.id.likes_count);
            mAddress = (TextView) cardView.findViewById(R.id.address);
            mDate = (TextView) cardView.findViewById(R.id.date);
            mDays = (TextView) cardView.findViewById(R.id.days);
        }

        public void setContent(CardContent cardContent) {
            mOrganizationIcon.setImageResource(cardContent.getOrganisation().getIconId());
            mOrganizationName.setText(getContext().getString(cardContent.getOrganisation().getNameId()));
            mLikeCount.setText(String.valueOf(cardContent.getLikesCount()));
            mAddress.setText(cardContent.getAddress());
            mDate.setText(getFormattedDate(cardContent.getDate()));
            mDays.setText(getFormattedDays(cardContent.getDays()));
        }

        public String getFormattedDays(int days) {
            return String.valueOf(days) + " " + getContext().getString(R.string.days);
        }

        public String getFormattedDate(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            String month = getContext().getResources().getStringArray(R.array.month)[calendar.get(Calendar.MONTH)];
            String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            String year = String.valueOf(calendar.get(Calendar.YEAR));

            return month + " " + day + ", " + year;
        }
    }
}

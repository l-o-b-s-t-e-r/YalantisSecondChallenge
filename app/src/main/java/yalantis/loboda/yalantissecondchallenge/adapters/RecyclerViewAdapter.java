package yalantis.loboda.yalantissecondchallenge.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import yalantis.loboda.yalantissecondchallenge.R;
import yalantis.loboda.yalantissecondchallenge.activities.DetailActivity;
import yalantis.loboda.yalantissecondchallenge.activities.MainActivity;
import yalantis.loboda.yalantissecondchallenge.models.CardContent;

/**
 * Created by Lobster on 15.04.16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<CardContent> mCardContents;
    private Context mContext;

    public RecyclerViewAdapter(List<CardContent> cardContents, Context context){
        mCardContents = cardContents;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setContent(mCardContents.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mCardContents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView mCardView;
        private ImageView mOrganizationIcon;
        private TextView mOrganizationName;
        private TextView mLikeCount;
        private TextView mAddress;
        private TextView mDate;
        private TextView mDays;

        public ViewHolder(CardView cardView) {
            super(cardView);

            mCardView = cardView;

            mOrganizationIcon = (ImageView)cardView.findViewById(R.id.top_icon);
            mOrganizationName = (TextView)cardView.findViewById(R.id.title);
            mLikeCount = (TextView)cardView.findViewById(R.id.likes_count);
            mAddress = (TextView)cardView.findViewById(R.id.address);
            mDate = (TextView)cardView.findViewById(R.id.date);
            mDays = (TextView)cardView.findViewById(R.id.days);
        }

        public void setContent(CardContent cardContent, final int position) {
            mOrganizationIcon.setImageResource(cardContent.getOrganisation().getIconId());
            mOrganizationName.setText(mContext.getString(cardContent.getOrganisation().getNameId()));
            mLikeCount.setText(String.valueOf(cardContent.getLikesCount()));
            mAddress.setText(cardContent.getAddress());
            mDate.setText(getFormattedDate(cardContent.getDate()));
            mDays.setText(getFormattedDays(cardContent.getDays()));

            mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra(MainActivity.DETAIL_INFO, position);
                    mContext.startActivity(intent);
                }
            });
        }

        public String getFormattedDays(int days) {
            return String.valueOf(days) + " " + mContext.getString(R.string.days);
        }

        public String getFormattedDate(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            String month = mContext.getResources().getStringArray(R.array.month)[calendar.get(Calendar.MONTH)];
            String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            String year = String.valueOf(calendar.get(Calendar.YEAR));

            return month + " " + day + ", " + year;
        }
    }
}

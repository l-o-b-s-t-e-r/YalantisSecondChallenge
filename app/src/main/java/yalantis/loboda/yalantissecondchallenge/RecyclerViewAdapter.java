package yalantis.loboda.yalantissecondchallenge;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

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
        holder.setContent(mCardContents.get(position));
    }

    @Override
    public int getItemCount() {
        return mCardContents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mOrganizationIcon;
        private TextView mOrganizationName;
        private TextView mLikeCount;
        private TextView mAddress;
        private TextView mDate;
        private TextView mDays;

        public ViewHolder(CardView cardView) {
            super(cardView);

            mOrganizationIcon = (ImageView)cardView.findViewById(R.id.top_icon);
            mOrganizationName = (TextView)cardView.findViewById(R.id.title);
            mLikeCount = (TextView)cardView.findViewById(R.id.likes_count);
            mAddress = (TextView)cardView.findViewById(R.id.address);
            mDate = (TextView)cardView.findViewById(R.id.date);
            mDays = (TextView)cardView.findViewById(R.id.days);
        }

        public void setContent(CardContent cardContent){
            mOrganizationIcon.setImageResource(cardContent.getOrganisation().getIconId());
            mOrganizationName.setText(mContext.getString(cardContent.getOrganisation().getNameId()));
            mLikeCount.setText(String.valueOf(cardContent.getLikesCount()));
            mAddress.setText(cardContent.getAddress());
            mDate.setText(cardContent.getDate().toString());
            mDays.setText(String.valueOf(cardContent.getDays()));
        }
    }
}

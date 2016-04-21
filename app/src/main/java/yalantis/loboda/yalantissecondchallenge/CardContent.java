package yalantis.loboda.yalantissecondchallenge;

import java.util.Date;

/**
 * Created by Lobster on 15.04.16.
 */

public class CardContent {

    private Organization mOrganisation;
    private String mAddress;
    private Date mDate;
    private int mDays;
    private int mLikesCount;

    private CardContent(){

    }

    public static CardContent getInstance() {
        return new CardContent();
    }

    public CardContent setOrganization(Organization organization){
        mOrganisation = organization;
        return this;
    }

    public Organization getOrganisation() {
        return mOrganisation;
    }

    public String getAddress() {
        return mAddress;
    }

    public CardContent setAddress(String address) {
        mAddress = address;
        return this;
    }

    public Date getDate() {
        return mDate;
    }

    public CardContent setDate(Date date) {
        mDate = date;
        return this;
    }

    public int getDays() {
        return mDays;
    }

    public CardContent setDays(int days) {
        mDays = days;
        return this;
    }

    public int getLikesCount() {
        return mLikesCount;
    }

    public CardContent setLikesCount(int likesCount) {
        mLikesCount = likesCount;
        return this;
    }
}

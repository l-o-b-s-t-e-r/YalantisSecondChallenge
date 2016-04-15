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

    public static CardContent getInstance(){
        return new CardContent();
    }

    private CardContent(){

    }

    public CardContent setOrganization(Organization organization){
        mOrganisation = organization;
        return this;
    }

    public CardContent setAddress(String address){
        mAddress = address;
        return this;
    }

    public CardContent setDate(Date date){
        mDate = date;
        return this;
    }

    public CardContent setDays(int days){
        mDays = days;
        return this;
    }

    public CardContent setLikesCount(int likesCount){
        mLikesCount = likesCount;
        return this;
    }

    public Organization getOrganisation() {
        return mOrganisation;
    }

    public String getAddress() {
        return mAddress;
    }

    public Date getDate() {
        return mDate;
    }

    public int getDays() {
        return mDays;
    }

    public int getLikesCount() {
        return mLikesCount;
    }
}

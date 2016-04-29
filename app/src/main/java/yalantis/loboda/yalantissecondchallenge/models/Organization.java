package yalantis.loboda.yalantissecondchallenge.models;

import yalantis.loboda.yalantissecondchallenge.R;

/**
 * Created by Lobster on 15.04.16.
 */

public enum  Organization {
    MUNICIPAL(R.string.municipal, R.drawable.ic_trash),
    BUILDING(R.string.building, R.drawable.ic_description_black_24dp),
    MALL(R.string.mall, R.drawable.ic_free_breakfast_black_24dp);

    private int mNameId;
    private int mIconId;
    Organization(int nameId, int iconId){
        mNameId = nameId;
        mIconId = iconId;
    }

    public int getNameId(){
        return mNameId;
    }

    public int getIconId() {
        return mIconId;
    }
}

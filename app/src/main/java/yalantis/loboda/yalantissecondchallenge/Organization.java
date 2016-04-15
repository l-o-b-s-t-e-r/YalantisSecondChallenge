package yalantis.loboda.yalantissecondchallenge;

import android.content.Context;

/**
 * Created by Lobster on 15.04.16.
 */

public enum  Organization {
    MUNICIPAL(R.string.municipal, R.drawable.ic_fitness_center_black_24dp),
    BUILDING(R.string.building, R.drawable.ic_free_breakfast_black_24dp);

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

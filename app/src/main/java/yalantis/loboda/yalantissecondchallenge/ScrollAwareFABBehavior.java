package yalantis.loboda.yalantissecondchallenge;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by Lobster on 20.04.16.
 */

public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior implements Animation.AnimationListener {

    private Animation mAnimationHide;
    private Animation mAnimationShow;
    private FloatingActionButton mFab;

    public ScrollAwareFABBehavior(Context context, AttributeSet attrs) {
        super();
        mAnimationHide = AnimationUtils.loadAnimation(context, R.anim.fab_anim_hide);
        mAnimationShow = AnimationUtils.loadAnimation(context, R.anim.fab_anim_show);

        mAnimationHide.setAnimationListener(this);
        mAnimationShow.setAnimationListener(this);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, final FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        mFab = child;

        if (child.getVisibility() == View.VISIBLE && dyConsumed > 0) {
            child.startAnimation(mAnimationHide);
        } else if (child.getVisibility() == View.INVISIBLE && dyConsumed < 0) {
            child.startAnimation(mAnimationShow);
        }
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout,
                                       FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (mFab.getVisibility() == View.VISIBLE) {
            mFab.setVisibility(View.INVISIBLE);
        } else {
            mFab.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}

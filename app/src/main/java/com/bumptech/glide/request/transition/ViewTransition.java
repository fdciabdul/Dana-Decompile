package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes7.dex */
public class ViewTransition<R> implements Transition<R> {
    private final ViewTransitionAnimationFactory KClassImpl$Data$declaredNonStaticMembers$2;

    /* loaded from: classes7.dex */
    interface ViewTransitionAnimationFactory {
        Animation MyBillsEntityDataFactory(Context context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTransition(ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewTransitionAnimationFactory;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public final boolean MyBillsEntityDataFactory(R r, Transition.ViewAdapter viewAdapter) {
        View PlaceComponentResult = viewAdapter.PlaceComponentResult();
        if (PlaceComponentResult != null) {
            PlaceComponentResult.clearAnimation();
            PlaceComponentResult.startAnimation(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(PlaceComponentResult.getContext()));
            return false;
        }
        return false;
    }
}

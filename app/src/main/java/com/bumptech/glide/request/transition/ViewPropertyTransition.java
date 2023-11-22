package com.bumptech.glide.request.transition;

import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes7.dex */
public class ViewPropertyTransition<R> implements Transition<R> {
    private final Animator KClassImpl$Data$declaredNonStaticMembers$2;

    /* loaded from: classes7.dex */
    public interface Animator {
    }

    public ViewPropertyTransition(Animator animator) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = animator;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public final boolean MyBillsEntityDataFactory(R r, Transition.ViewAdapter viewAdapter) {
        if (viewAdapter.PlaceComponentResult() != null) {
            viewAdapter.PlaceComponentResult();
            return false;
        }
        return false;
    }
}

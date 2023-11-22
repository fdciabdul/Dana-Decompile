package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

/* loaded from: classes7.dex */
public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {
    private final ViewPropertyTransition.Animator KClassImpl$Data$declaredNonStaticMembers$2;
    private ViewPropertyTransition<R> MyBillsEntityDataFactory;

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public final Transition<R> KClassImpl$Data$declaredNonStaticMembers$2(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.getAuthRequestContext();
        }
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new ViewPropertyTransition<>(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return this.MyBillsEntityDataFactory;
    }
}

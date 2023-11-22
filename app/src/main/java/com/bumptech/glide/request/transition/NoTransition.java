package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes3.dex */
public class NoTransition<R> implements Transition<R> {
    static final NoTransition<?> MyBillsEntityDataFactory = new NoTransition<>();
    private static final TransitionFactory<?> KClassImpl$Data$declaredNonStaticMembers$2 = new NoAnimationFactory();

    @Override // com.bumptech.glide.request.transition.Transition
    public final boolean MyBillsEntityDataFactory(Object obj, Transition.ViewAdapter viewAdapter) {
        return false;
    }

    /* loaded from: classes3.dex */
    public static class NoAnimationFactory<R> implements TransitionFactory<R> {
        @Override // com.bumptech.glide.request.transition.TransitionFactory
        public final Transition<R> KClassImpl$Data$declaredNonStaticMembers$2(DataSource dataSource, boolean z) {
            return NoTransition.MyBillsEntityDataFactory;
        }
    }

    public static <R> TransitionFactory<R> KClassImpl$Data$declaredNonStaticMembers$2() {
        return (TransitionFactory<R>) KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static <R> Transition<R> getAuthRequestContext() {
        return MyBillsEntityDataFactory;
    }
}

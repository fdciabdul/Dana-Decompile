package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewTransition;

/* loaded from: classes7.dex */
public class ViewAnimationFactory<R> implements TransitionFactory<R> {
    private final ViewTransition.ViewTransitionAnimationFactory MyBillsEntityDataFactory;
    private Transition<R> getAuthRequestContext;

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public final Transition<R> KClassImpl$Data$declaredNonStaticMembers$2(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.getAuthRequestContext();
        }
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = new ViewTransition(this.MyBillsEntityDataFactory);
        }
        return this.getAuthRequestContext;
    }

    /* loaded from: classes7.dex */
    static class ConcreteViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
        private final Animation getAuthRequestContext;

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public final Animation MyBillsEntityDataFactory(Context context) {
            return this.getAuthRequestContext;
        }
    }

    /* loaded from: classes7.dex */
    static class ResourceViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
        private final int BuiltInFictitiousFunctionClassFactory;

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public final Animation MyBillsEntityDataFactory(Context context) {
            return AnimationUtils.loadAnimation(context, this.BuiltInFictitiousFunctionClassFactory);
        }
    }
}

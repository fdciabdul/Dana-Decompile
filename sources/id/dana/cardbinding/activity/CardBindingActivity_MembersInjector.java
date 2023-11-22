package id.dana.cardbinding.activity;

import dagger.MembersInjector;
import id.dana.cardbinding.di.module.ViewModelFactory;
import id.dana.cardbinding.tracker.CardBindingAnalyticTracker;

/* loaded from: classes4.dex */
public final class CardBindingActivity_MembersInjector implements MembersInjector<CardBindingActivity> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(CardBindingActivity cardBindingActivity, ViewModelFactory viewModelFactory) {
        cardBindingActivity.viewModelFactory = viewModelFactory;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(CardBindingActivity cardBindingActivity, CardBindingAnalyticTracker cardBindingAnalyticTracker) {
        cardBindingActivity.cardBindingAnalyticTracker = cardBindingAnalyticTracker;
    }
}

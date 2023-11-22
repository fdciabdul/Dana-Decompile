package id.dana.cardbinding.activity;

import dagger.MembersInjector;
import id.dana.cardbinding.di.module.ViewModelFactory;
import id.dana.cardbinding.tracker.CardBindingAnalyticTracker;

/* loaded from: classes8.dex */
public final class CardBindingCameraActivity_MembersInjector implements MembersInjector<CardBindingCameraActivity> {
    public static void MyBillsEntityDataFactory(CardBindingCameraActivity cardBindingCameraActivity, ViewModelFactory viewModelFactory) {
        cardBindingCameraActivity.viewModelFactory = viewModelFactory;
    }

    public static void PlaceComponentResult(CardBindingCameraActivity cardBindingCameraActivity, CardBindingAnalyticTracker cardBindingAnalyticTracker) {
        cardBindingCameraActivity.cardBindingAnalyticTracker = cardBindingAnalyticTracker;
    }
}

package id.dana.social.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SocialWidgetModule_ProvideFriendshipAnalyticTrackerFactory implements Factory<FriendshipAnalyticTracker> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final SocialWidgetModule MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FriendshipAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

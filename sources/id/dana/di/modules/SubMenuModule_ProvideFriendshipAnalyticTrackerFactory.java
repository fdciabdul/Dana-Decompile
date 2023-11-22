package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SubMenuModule_ProvideFriendshipAnalyticTrackerFactory implements Factory<FriendshipAnalyticTracker> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final SubMenuModule MyBillsEntityDataFactory;

    public static FriendshipAnalyticTracker BuiltInFictitiousFunctionClassFactory(SubMenuModule subMenuModule, Context context) {
        return (FriendshipAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(subMenuModule.PlaceComponentResult(context));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FriendshipAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

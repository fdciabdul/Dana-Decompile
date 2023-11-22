package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.notification.FeedNotificationContract;

/* loaded from: classes5.dex */
public final class FeedNotificationModule_ProvideFeedNotificationViewFactory implements Factory<FeedNotificationContract.View> {
    private final FeedNotificationModule getAuthRequestContext;

    private FeedNotificationModule_ProvideFeedNotificationViewFactory(FeedNotificationModule feedNotificationModule) {
        this.getAuthRequestContext = feedNotificationModule;
    }

    public static FeedNotificationModule_ProvideFeedNotificationViewFactory MyBillsEntityDataFactory(FeedNotificationModule feedNotificationModule) {
        return new FeedNotificationModule_ProvideFeedNotificationViewFactory(feedNotificationModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedNotificationContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}

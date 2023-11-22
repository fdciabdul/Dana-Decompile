package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.notification.FeedNotificationContract;
import id.dana.social.contract.notification.FeedNotificationPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FeedNotificationModule_ProvideFeedNotificationPresenterFactory implements Factory<FeedNotificationContract.Presenter> {
    private final Provider<FeedNotificationPresenter> BuiltInFictitiousFunctionClassFactory;
    private final FeedNotificationModule getAuthRequestContext;

    private FeedNotificationModule_ProvideFeedNotificationPresenterFactory(FeedNotificationModule feedNotificationModule, Provider<FeedNotificationPresenter> provider) {
        this.getAuthRequestContext = feedNotificationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static FeedNotificationModule_ProvideFeedNotificationPresenterFactory getAuthRequestContext(FeedNotificationModule feedNotificationModule, Provider<FeedNotificationPresenter> provider) {
        return new FeedNotificationModule_ProvideFeedNotificationPresenterFactory(feedNotificationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedNotificationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

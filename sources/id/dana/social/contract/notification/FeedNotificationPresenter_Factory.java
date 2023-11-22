package id.dana.social.contract.notification;

import dagger.internal.Factory;
import id.dana.feeds.domain.notification.interactor.GetFeedNotification;
import id.dana.feeds.domain.notification.interactor.MarkAsReadNotification;
import id.dana.social.contract.notification.FeedNotificationContract;
import id.dana.social.model.mapper.FeedNotificationMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FeedNotificationPresenter_Factory implements Factory<FeedNotificationPresenter> {
    private final Provider<FeedNotificationMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedNotificationContract.View> MyBillsEntityDataFactory;
    private final Provider<MarkAsReadNotification> PlaceComponentResult;
    private final Provider<GetFeedNotification> getAuthRequestContext;

    private FeedNotificationPresenter_Factory(Provider<FeedNotificationContract.View> provider, Provider<GetFeedNotification> provider2, Provider<MarkAsReadNotification> provider3, Provider<FeedNotificationMapper> provider4) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
    }

    public static FeedNotificationPresenter_Factory getAuthRequestContext(Provider<FeedNotificationContract.View> provider, Provider<GetFeedNotification> provider2, Provider<MarkAsReadNotification> provider3, Provider<FeedNotificationMapper> provider4) {
        return new FeedNotificationPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedNotificationPresenter(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

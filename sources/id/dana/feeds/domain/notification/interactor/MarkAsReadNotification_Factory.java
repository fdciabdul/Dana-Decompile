package id.dana.feeds.domain.notification.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.notification.FeedsNotificationRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MarkAsReadNotification_Factory implements Factory<MarkAsReadNotification> {
    private final Provider<MixpanelRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsNotificationRepository> getAuthRequestContext;

    private MarkAsReadNotification_Factory(Provider<FeedsNotificationRepository> provider, Provider<MixpanelRepository> provider2) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static MarkAsReadNotification_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<FeedsNotificationRepository> provider, Provider<MixpanelRepository> provider2) {
        return new MarkAsReadNotification_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MarkAsReadNotification(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

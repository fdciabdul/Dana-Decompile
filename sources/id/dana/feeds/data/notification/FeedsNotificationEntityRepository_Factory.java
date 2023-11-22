package id.dana.feeds.data.notification;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.feeds.data.notification.source.FeedsNotificationDataFactory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FeedsNotificationEntityRepository_Factory implements Factory<FeedsNotificationEntityRepository> {
    private final Provider<FeedsNotificationDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<HoldLoginV1EntityRepository> MyBillsEntityDataFactory;

    private FeedsNotificationEntityRepository_Factory(Provider<FeedsNotificationDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static FeedsNotificationEntityRepository_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<FeedsNotificationDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        return new FeedsNotificationEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsNotificationEntityRepository(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}

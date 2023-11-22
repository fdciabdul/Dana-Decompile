package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SubscriptionQueryById_Factory implements Factory<SubscriptionQueryById> {
    private final Provider<MyBillsRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private SubscriptionQueryById_Factory(Provider<MyBillsRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static SubscriptionQueryById_Factory PlaceComponentResult(Provider<MyBillsRepository> provider) {
        return new SubscriptionQueryById_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SubscriptionQueryById(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

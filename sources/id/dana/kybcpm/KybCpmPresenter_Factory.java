package id.dana.kybcpm;

import dagger.internal.Factory;
import id.dana.kyb.domain.interactor.CreatePaymentOrderCpm;
import id.dana.kybcpm.KybCpmContract;
import id.dana.kybcpm.tracker.KybCpmTracker;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class KybCpmPresenter_Factory implements Factory<KybCpmPresenter> {
    private final Provider<KybCpmContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CreatePaymentOrderCpm> MyBillsEntityDataFactory;
    private final Provider<KybCpmTracker> getAuthRequestContext;

    private KybCpmPresenter_Factory(Provider<KybCpmContract.View> provider, Provider<CreatePaymentOrderCpm> provider2, Provider<KybCpmTracker> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static KybCpmPresenter_Factory MyBillsEntityDataFactory(Provider<KybCpmContract.View> provider, Provider<CreatePaymentOrderCpm> provider2, Provider<KybCpmTracker> provider3) {
        return new KybCpmPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KybCpmPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}

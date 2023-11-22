package id.dana.contract.payqr;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OfflinePayPresenter_Factory implements Factory<OfflinePayPresenter> {
    private final Provider<OfflinePayContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<IsOfflineF2FPay> KClassImpl$Data$declaredNonStaticMembers$2;

    private OfflinePayPresenter_Factory(Provider<IsOfflineF2FPay> provider, Provider<OfflinePayContract.View> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static OfflinePayPresenter_Factory getAuthRequestContext(Provider<IsOfflineF2FPay> provider, Provider<OfflinePayContract.View> provider2) {
        return new OfflinePayPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OfflinePayPresenter(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

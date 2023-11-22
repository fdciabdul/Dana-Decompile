package id.dana.contract.payasset;

import dagger.internal.Factory;
import id.dana.contract.payasset.ChangePayMethodContract;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.payasset.interactor.ChangePayMethod;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ChangePayMethodPresenter_Factory implements Factory<ChangePayMethodPresenter> {
    private final Provider<IsOfflineF2FPay> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ChangePayMethodContract.View> MyBillsEntityDataFactory;
    private final Provider<ChangePayMethod> getAuthRequestContext;

    private ChangePayMethodPresenter_Factory(Provider<ChangePayMethodContract.View> provider, Provider<ChangePayMethod> provider2, Provider<IsOfflineF2FPay> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static ChangePayMethodPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<ChangePayMethodContract.View> provider, Provider<ChangePayMethod> provider2, Provider<IsOfflineF2FPay> provider3) {
        return new ChangePayMethodPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ChangePayMethodPresenter(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

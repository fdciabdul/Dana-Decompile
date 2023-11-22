package id.dana.contract.sendmoney;

import dagger.internal.Factory;
import id.dana.contract.sendmoney.ExpiryContract;
import id.dana.domain.featureconfig.interactor.GetExpiryChoices;
import id.dana.sendmoney.mapper.ExpiryInfoMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ExpiryPresenter_Factory implements Factory<ExpiryPresenter> {
    private final Provider<ExpiryInfoMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ExpiryContract.View> MyBillsEntityDataFactory;
    private final Provider<GetExpiryChoices> PlaceComponentResult;

    private ExpiryPresenter_Factory(Provider<ExpiryContract.View> provider, Provider<GetExpiryChoices> provider2, Provider<ExpiryInfoMapper> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static ExpiryPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<ExpiryContract.View> provider, Provider<GetExpiryChoices> provider2, Provider<ExpiryInfoMapper> provider3) {
        return new ExpiryPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ExpiryPresenter(this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

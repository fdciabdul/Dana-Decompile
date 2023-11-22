package id.dana.contract.payasset;

import dagger.internal.Factory;
import id.dana.contract.payasset.AddNewCardContract;
import id.dana.domain.featureconfig.interactor.CheckEnableExpressPayFeature;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class AddNewCardPresenter_Factory implements Factory<AddNewCardPresenter> {
    private final Provider<AddNewCardContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CheckEnableExpressPayFeature> PlaceComponentResult;

    private AddNewCardPresenter_Factory(Provider<AddNewCardContract.View> provider, Provider<CheckEnableExpressPayFeature> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.PlaceComponentResult = provider2;
    }

    public static AddNewCardPresenter_Factory PlaceComponentResult(Provider<AddNewCardContract.View> provider, Provider<CheckEnableExpressPayFeature> provider2) {
        return new AddNewCardPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new AddNewCardPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}

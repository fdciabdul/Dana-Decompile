package id.dana.contract.account;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.account.FirstTimeContract;
import id.dana.domain.account.interactor.FinishFirstTime;
import id.dana.domain.account.interactor.IsFirstTime;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FirstTimePresenter_Factory implements Factory<FirstTimePresenter> {
    private final Provider<FinishFirstTime> BuiltInFictitiousFunctionClassFactory;
    private final Provider<IsFirstTime> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FirstTimeContract.View> PlaceComponentResult;

    private FirstTimePresenter_Factory(Provider<FirstTimeContract.View> provider, Provider<IsFirstTime> provider2, Provider<FinishFirstTime> provider3) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static FirstTimePresenter_Factory MyBillsEntityDataFactory(Provider<FirstTimeContract.View> provider, Provider<IsFirstTime> provider2, Provider<FinishFirstTime> provider3) {
        return new FirstTimePresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FirstTimePresenter(DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
    }
}

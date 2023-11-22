package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.contract.sendmoney.v2.BillerX2BPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class BillerX2BModule_ProvidePresenterFactory implements Factory<BillerX2BContract.Presenter> {
    private final Provider<BillerX2BPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final BillerX2BModule MyBillsEntityDataFactory;

    private BillerX2BModule_ProvidePresenterFactory(BillerX2BModule billerX2BModule, Provider<BillerX2BPresenter> provider) {
        this.MyBillsEntityDataFactory = billerX2BModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static BillerX2BModule_ProvidePresenterFactory PlaceComponentResult(BillerX2BModule billerX2BModule, Provider<BillerX2BPresenter> provider) {
        return new BillerX2BModule_ProvidePresenterFactory(billerX2BModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BillerX2BContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}

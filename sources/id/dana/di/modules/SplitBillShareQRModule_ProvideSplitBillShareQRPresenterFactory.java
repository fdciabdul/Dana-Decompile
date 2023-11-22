package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.splitbill.SplitBillShareQRContract;
import id.dana.splitbill.SplitBillShareQRPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SplitBillShareQRModule_ProvideSplitBillShareQRPresenterFactory implements Factory<SplitBillShareQRContract.Presenter> {
    private final SplitBillShareQRModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SplitBillShareQRPresenter> getAuthRequestContext;

    private SplitBillShareQRModule_ProvideSplitBillShareQRPresenterFactory(SplitBillShareQRModule splitBillShareQRModule, Provider<SplitBillShareQRPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = splitBillShareQRModule;
        this.getAuthRequestContext = provider;
    }

    public static SplitBillShareQRModule_ProvideSplitBillShareQRPresenterFactory BuiltInFictitiousFunctionClassFactory(SplitBillShareQRModule splitBillShareQRModule, Provider<SplitBillShareQRPresenter> provider) {
        return new SplitBillShareQRModule_ProvideSplitBillShareQRPresenterFactory(splitBillShareQRModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SplitBillShareQRContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}

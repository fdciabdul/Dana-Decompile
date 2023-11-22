package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.splitbill.SplitBillContract;
import id.dana.splitbill.SplitBillPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SplitBillModule_ProvideSplitBillPresenterFactory implements Factory<SplitBillContract.Presenter> {
    private final SplitBillModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SplitBillPresenter> getAuthRequestContext;

    private SplitBillModule_ProvideSplitBillPresenterFactory(SplitBillModule splitBillModule, Provider<SplitBillPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = splitBillModule;
        this.getAuthRequestContext = provider;
    }

    public static SplitBillModule_ProvideSplitBillPresenterFactory PlaceComponentResult(SplitBillModule splitBillModule, Provider<SplitBillPresenter> provider) {
        return new SplitBillModule_ProvideSplitBillPresenterFactory(splitBillModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SplitBillContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.getAuthRequestContext.get()));
    }
}

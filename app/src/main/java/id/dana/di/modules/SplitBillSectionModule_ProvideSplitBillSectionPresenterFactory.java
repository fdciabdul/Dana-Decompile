package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.splitbill.SplitBillSectionContract;
import id.dana.splitbill.SplitBillSectionPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SplitBillSectionModule_ProvideSplitBillSectionPresenterFactory implements Factory<SplitBillSectionContract.Presenter> {
    private final Provider<SplitBillSectionPresenter> PlaceComponentResult;
    private final SplitBillSectionModule getAuthRequestContext;

    private SplitBillSectionModule_ProvideSplitBillSectionPresenterFactory(SplitBillSectionModule splitBillSectionModule, Provider<SplitBillSectionPresenter> provider) {
        this.getAuthRequestContext = splitBillSectionModule;
        this.PlaceComponentResult = provider;
    }

    public static SplitBillSectionModule_ProvideSplitBillSectionPresenterFactory BuiltInFictitiousFunctionClassFactory(SplitBillSectionModule splitBillSectionModule, Provider<SplitBillSectionPresenter> provider) {
        return new SplitBillSectionModule_ProvideSplitBillSectionPresenterFactory(splitBillSectionModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SplitBillSectionContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}

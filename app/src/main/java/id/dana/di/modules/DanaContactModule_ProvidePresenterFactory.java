package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.contact.DanaContactContract;
import id.dana.contract.contact.DanaContactPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanaContactModule_ProvidePresenterFactory implements Factory<DanaContactContract.Presenter> {
    private final Provider<DanaContactPresenter> MyBillsEntityDataFactory;
    private final DanaContactModule PlaceComponentResult;

    private DanaContactModule_ProvidePresenterFactory(DanaContactModule danaContactModule, Provider<DanaContactPresenter> provider) {
        this.PlaceComponentResult = danaContactModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static DanaContactModule_ProvidePresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(DanaContactModule danaContactModule, Provider<DanaContactPresenter> provider) {
        return new DanaContactModule_ProvidePresenterFactory(danaContactModule, provider);
    }

    public static DanaContactContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(DanaContactModule danaContactModule, DanaContactPresenter danaContactPresenter) {
        return (DanaContactContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(danaContactModule.MyBillsEntityDataFactory(danaContactPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DanaContactContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.get()));
    }
}

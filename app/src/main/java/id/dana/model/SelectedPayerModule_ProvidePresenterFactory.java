package id.dana.model;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.splitbill.SelectedPayerContract;
import id.dana.richview.splitbill.SelectedPayerPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SelectedPayerModule_ProvidePresenterFactory implements Factory<SelectedPayerContract.Presenter> {
    private final SelectedPayerModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<SelectedPayerPresenter> PlaceComponentResult;

    private SelectedPayerModule_ProvidePresenterFactory(SelectedPayerModule selectedPayerModule, Provider<SelectedPayerPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = selectedPayerModule;
        this.PlaceComponentResult = provider;
    }

    public static SelectedPayerModule_ProvidePresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(SelectedPayerModule selectedPayerModule, Provider<SelectedPayerPresenter> provider) {
        return new SelectedPayerModule_ProvidePresenterFactory(selectedPayerModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SelectedPayerContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}

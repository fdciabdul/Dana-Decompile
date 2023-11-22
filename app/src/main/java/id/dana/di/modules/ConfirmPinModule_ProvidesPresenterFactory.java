package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.confirmpin.ConfirmPinContract;
import id.dana.onboarding.confirmpin.ConfirmPinPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ConfirmPinModule_ProvidesPresenterFactory implements Factory<ConfirmPinContract.Presenter> {
    private final ConfirmPinModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<ConfirmPinPresenter> PlaceComponentResult;

    private ConfirmPinModule_ProvidesPresenterFactory(ConfirmPinModule confirmPinModule, Provider<ConfirmPinPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = confirmPinModule;
        this.PlaceComponentResult = provider;
    }

    public static ConfirmPinModule_ProvidesPresenterFactory getAuthRequestContext(ConfirmPinModule confirmPinModule, Provider<ConfirmPinPresenter> provider) {
        return new ConfirmPinModule_ProvidesPresenterFactory(confirmPinModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ConfirmPinContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}

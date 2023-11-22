package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promocenter.promo.PromoCenterContract;
import id.dana.contract.promocenter.promo.PromoCenterPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PromoCenterModule_ProvidePromoCenterPresenterFactory implements Factory<PromoCenterContract.Presenter> {
    private final Provider<PromoCenterPresenter> BuiltInFictitiousFunctionClassFactory;
    private final PromoCenterModule getAuthRequestContext;

    public static PromoCenterContract.Presenter getAuthRequestContext(PromoCenterModule promoCenterModule, PromoCenterPresenter promoCenterPresenter) {
        return (PromoCenterContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(promoCenterModule.PlaceComponentResult(promoCenterPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromoCenterContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

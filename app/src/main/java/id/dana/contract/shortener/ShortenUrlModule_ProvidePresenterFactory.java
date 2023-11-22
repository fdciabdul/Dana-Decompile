package id.dana.contract.shortener;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.shortener.ShortenUrlContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ShortenUrlModule_ProvidePresenterFactory implements Factory<ShortenUrlContract.Presenter> {
    private final ShortenUrlModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<ShortenUrlPresenter> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ShortenUrlContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}

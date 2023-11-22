package id.dana.danapoly.ui.splash.viewmodel;

import dagger.internal.Factory;
import id.dana.danapoly.domain.config.interactor.GetPlayBoard;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanapolyConfigViewModel_Factory implements Factory<DanapolyConfigViewModel> {
    private final Provider<GetPlayBoard> PlaceComponentResult;

    private DanapolyConfigViewModel_Factory(Provider<GetPlayBoard> provider) {
        this.PlaceComponentResult = provider;
    }

    public static DanapolyConfigViewModel_Factory BuiltInFictitiousFunctionClassFactory(Provider<GetPlayBoard> provider) {
        return new DanapolyConfigViewModel_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanapolyConfigViewModel(this.PlaceComponentResult.get());
    }
}

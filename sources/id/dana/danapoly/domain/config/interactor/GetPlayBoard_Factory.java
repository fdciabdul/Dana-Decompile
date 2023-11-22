package id.dana.danapoly.domain.config.interactor;

import dagger.internal.Factory;
import id.dana.danapoly.domain.config.DanapolyConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPlayBoard_Factory implements Factory<GetPlayBoard> {
    private final Provider<DanapolyConfigRepository> BuiltInFictitiousFunctionClassFactory;

    private GetPlayBoard_Factory(Provider<DanapolyConfigRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetPlayBoard_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<DanapolyConfigRepository> provider) {
        return new GetPlayBoard_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetPlayBoard(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

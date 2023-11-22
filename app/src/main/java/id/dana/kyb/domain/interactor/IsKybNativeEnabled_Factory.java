package id.dana.kyb.domain.interactor;

import dagger.internal.Factory;
import id.dana.kyb.domain.KybRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class IsKybNativeEnabled_Factory implements Factory<IsKybNativeEnabled> {
    private final Provider<KybRepository> BuiltInFictitiousFunctionClassFactory;

    private IsKybNativeEnabled_Factory(Provider<KybRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static IsKybNativeEnabled_Factory BuiltInFictitiousFunctionClassFactory(Provider<KybRepository> provider) {
        return new IsKybNativeEnabled_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new IsKybNativeEnabled(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

package id.dana.mybills.ui.mapper;

import dagger.internal.Factory;
import id.dana.mybills.ui.model.service.CategoryServiceMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ServiceItemMapper_Factory implements Factory<ServiceItemMapper> {
    private final Provider<CategoryServiceMapper> BuiltInFictitiousFunctionClassFactory;

    private ServiceItemMapper_Factory(Provider<CategoryServiceMapper> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ServiceItemMapper_Factory BuiltInFictitiousFunctionClassFactory(Provider<CategoryServiceMapper> provider) {
        return new ServiceItemMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ServiceItemMapper(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

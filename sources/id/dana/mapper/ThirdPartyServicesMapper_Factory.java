package id.dana.mapper;

import dagger.internal.Factory;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ThirdPartyServicesMapper_Factory implements Factory<ThirdPartyServicesMapper> {
    private final Provider<ServiceCategoryMapper> getAuthRequestContext;

    private ThirdPartyServicesMapper_Factory(Provider<ServiceCategoryMapper> provider) {
        this.getAuthRequestContext = provider;
    }

    public static ThirdPartyServicesMapper_Factory BuiltInFictitiousFunctionClassFactory(Provider<ServiceCategoryMapper> provider) {
        return new ThirdPartyServicesMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ThirdPartyServicesMapper(this.getAuthRequestContext.get());
    }
}

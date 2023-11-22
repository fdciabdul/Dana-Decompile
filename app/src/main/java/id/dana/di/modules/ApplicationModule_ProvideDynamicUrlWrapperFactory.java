package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideDynamicUrlWrapperFactory implements Factory<DynamicUrlWrapper> {
    private final Provider<ConfigEntityDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideDynamicUrlWrapperFactory(ApplicationModule applicationModule, Provider<ConfigEntityDataFactory> provider) {
        this.PlaceComponentResult = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideDynamicUrlWrapperFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<ConfigEntityDataFactory> provider) {
        return new ApplicationModule_ProvideDynamicUrlWrapperFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DynamicUrlWrapper) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

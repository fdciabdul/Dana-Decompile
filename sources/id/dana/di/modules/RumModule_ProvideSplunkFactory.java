package id.dana.di.modules;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import id.dana.rum.Rum;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RumModule_ProvideSplunkFactory implements Factory<Rum> {
    private final Provider<Application> BuiltInFictitiousFunctionClassFactory;
    private final RumModule MyBillsEntityDataFactory;
    private final Provider<SharedPrefStartupConfig> getAuthRequestContext;

    private RumModule_ProvideSplunkFactory(RumModule rumModule, Provider<Application> provider, Provider<SharedPrefStartupConfig> provider2) {
        this.MyBillsEntityDataFactory = rumModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
    }

    public static RumModule_ProvideSplunkFactory MyBillsEntityDataFactory(RumModule rumModule, Provider<Application> provider, Provider<SharedPrefStartupConfig> provider2) {
        return new RumModule_ProvideSplunkFactory(rumModule, provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (Rum) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get()));
    }
}

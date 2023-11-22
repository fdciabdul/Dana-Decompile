package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideStartupPreferenceFacadeFactory implements Factory<PreferenceFacade> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideStartupPreferenceFacadeFactory(ApplicationModule applicationModule, Provider<Context> provider) {
        this.getAuthRequestContext = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideStartupPreferenceFacadeFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<Context> provider) {
        return new ApplicationModule_ProvideStartupPreferenceFacadeFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PreferenceFacade) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.lookAheadTest(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}

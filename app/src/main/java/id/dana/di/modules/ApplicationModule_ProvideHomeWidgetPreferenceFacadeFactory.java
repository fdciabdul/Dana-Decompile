package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideHomeWidgetPreferenceFacadeFactory implements Factory<PreferenceFacade> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> getAuthRequestContext;

    private ApplicationModule_ProvideHomeWidgetPreferenceFacadeFactory(ApplicationModule applicationModule, Provider<Context> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideHomeWidgetPreferenceFacadeFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<Context> provider) {
        return new ApplicationModule_ProvideHomeWidgetPreferenceFacadeFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PreferenceFacade) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}

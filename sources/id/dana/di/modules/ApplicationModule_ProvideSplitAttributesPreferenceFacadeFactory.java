package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideSplitAttributesPreferenceFacadeFactory implements Factory<PreferenceFacade> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvideSplitAttributesPreferenceFacadeFactory(ApplicationModule applicationModule, Provider<Context> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideSplitAttributesPreferenceFacadeFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<Context> provider) {
        return new ApplicationModule_ProvideSplitAttributesPreferenceFacadeFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PreferenceFacade) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.scheduleImpl(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}

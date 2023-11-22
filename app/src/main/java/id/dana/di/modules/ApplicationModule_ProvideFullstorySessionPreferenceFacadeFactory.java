package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFullstorySessionPreferenceFacadeFactory implements Factory<PreferenceFacade> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> PlaceComponentResult;

    private ApplicationModule_ProvideFullstorySessionPreferenceFacadeFactory(ApplicationModule applicationModule, Provider<Context> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideFullstorySessionPreferenceFacadeFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<Context> provider) {
        return new ApplicationModule_ProvideFullstorySessionPreferenceFacadeFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PreferenceFacade) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}

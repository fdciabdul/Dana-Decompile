package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideCashierConfigPreferenceFacadeFactory implements Factory<PreferenceFacade> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideCashierConfigPreferenceFacadeFactory(ApplicationModule applicationModule, Provider<Context> provider) {
        this.PlaceComponentResult = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideCashierConfigPreferenceFacadeFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<Context> provider) {
        return new ApplicationModule_ProvideCashierConfigPreferenceFacadeFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PreferenceFacade) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

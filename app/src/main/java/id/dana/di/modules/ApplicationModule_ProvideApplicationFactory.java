package id.dana.di.modules;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideApplicationFactory implements Factory<Application> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvideApplicationFactory(ApplicationModule applicationModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
    }

    public static ApplicationModule_ProvideApplicationFactory getAuthRequestContext(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideApplicationFactory(applicationModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (Application) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult());
    }
}

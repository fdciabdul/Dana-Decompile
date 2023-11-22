package id.dana.di.modules;

import android.app.Application;
import android.content.ContentResolver;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideContentResolverFactory implements Factory<ContentResolver> {
    private final Provider<Application> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideContentResolverFactory(ApplicationModule applicationModule, Provider<Application> provider) {
        this.PlaceComponentResult = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideContentResolverFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<Application> provider) {
        return new ApplicationModule_ProvideContentResolverFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ContentResolver) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}

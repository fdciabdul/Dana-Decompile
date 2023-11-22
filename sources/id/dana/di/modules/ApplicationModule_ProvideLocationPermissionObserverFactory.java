package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.toggle.locationpermission.LocationPermissionObserver;
import id.dana.toggle.locationpermission.LocationPermissionSubject;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideLocationPermissionObserverFactory implements Factory<LocationPermissionObserver> {
    private final Provider<LocationPermissionSubject> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideLocationPermissionObserverFactory(ApplicationModule applicationModule, Provider<LocationPermissionSubject> provider) {
        this.PlaceComponentResult = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideLocationPermissionObserverFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<LocationPermissionSubject> provider) {
        return new ApplicationModule_ProvideLocationPermissionObserverFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LocationPermissionObserver) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}

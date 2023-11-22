package id.dana.di.modules;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import id.dana.toggle.locationpermission.LocationPermissionSubject;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideAppLifeCycleObserverFactory implements Factory<AppLifeCycleObserver> {
    private final Provider<LocationPermissionSubject> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule PlaceComponentResult;
    private final Provider<PreferenceAccountEntityData> getAuthRequestContext;

    private ApplicationModule_ProvideAppLifeCycleObserverFactory(ApplicationModule applicationModule, Provider<PreferenceAccountEntityData> provider, Provider<LocationPermissionSubject> provider2) {
        this.PlaceComponentResult = applicationModule;
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static ApplicationModule_ProvideAppLifeCycleObserverFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<PreferenceAccountEntityData> provider, Provider<LocationPermissionSubject> provider2) {
        return new ApplicationModule_ProvideAppLifeCycleObserverFactory(applicationModule, provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AppLifeCycleObserver) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}

package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.config.source.SecuredPrefHomeWidgetData;
import id.dana.domain.homeinfo.HomeWidgetClearable;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideHomeWidgetClearableFactory implements Factory<HomeWidgetClearable> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SecuredPrefHomeWidgetData> PlaceComponentResult;

    private ApplicationModule_ProvideHomeWidgetClearableFactory(ApplicationModule applicationModule, Provider<SecuredPrefHomeWidgetData> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideHomeWidgetClearableFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<SecuredPrefHomeWidgetData> provider) {
        return new ApplicationModule_ProvideHomeWidgetClearableFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomeWidgetClearable) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}

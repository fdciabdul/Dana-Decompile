package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.config.source.HomeWidgetEntityData;
import id.dana.data.config.source.SecuredPrefHomeWidgetData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideHomeWidgetEntityDataFactory implements Factory<HomeWidgetEntityData> {
    private final Provider<SecuredPrefHomeWidgetData> MyBillsEntityDataFactory;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideHomeWidgetEntityDataFactory(ApplicationModule applicationModule, Provider<SecuredPrefHomeWidgetData> provider) {
        this.PlaceComponentResult = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideHomeWidgetEntityDataFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<SecuredPrefHomeWidgetData> provider) {
        return new ApplicationModule_ProvideHomeWidgetEntityDataFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomeWidgetEntityData) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}

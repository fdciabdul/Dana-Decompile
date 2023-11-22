package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.data.toggle.traffictype.LazyTrafficTypeFactory;
import id.dana.toggle.userloginlogout.LoginLogoutObserver;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitModule_ProvideTrafficTypeUserProxy$app_productionReleaseFactory implements Factory<LazyTrafficTypeFactory> {
    private final Provider<LoginLogoutObserver> BuiltInFictitiousFunctionClassFactory;
    private final SplitModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<BaseTrafficType> MyBillsEntityDataFactory;
    private final Provider<LoginLogoutSubject> PlaceComponentResult;
    private final Provider<PreferenceAccountEntityData> getAuthRequestContext;

    private SplitModule_ProvideTrafficTypeUserProxy$app_productionReleaseFactory(SplitModule splitModule, Provider<LoginLogoutObserver> provider, Provider<LoginLogoutSubject> provider2, Provider<PreferenceAccountEntityData> provider3, Provider<BaseTrafficType> provider4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = splitModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
        this.getAuthRequestContext = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static SplitModule_ProvideTrafficTypeUserProxy$app_productionReleaseFactory MyBillsEntityDataFactory(SplitModule splitModule, Provider<LoginLogoutObserver> provider, Provider<LoginLogoutSubject> provider2, Provider<PreferenceAccountEntityData> provider3, Provider<BaseTrafficType> provider4) {
        return new SplitModule_ProvideTrafficTypeUserProxy$app_productionReleaseFactory(splitModule, provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LazyTrafficTypeFactory) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get()));
    }
}

package id.dana.data.home.repository;

import dagger.internal.Factory;
import id.dana.data.danaprotection.repository.source.local.DanaProtectionInfoPreference;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.home.repository.source.local.DanaProtectionHomeWidgetPreference;
import id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HomeWidgetEntityRepository_Factory implements Factory<HomeWidgetEntityRepository> {
    private final Provider<PersistenceHomeWidgetEntityData> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<DanaProtectionHomeWidgetPreference> MyBillsEntityDataFactory;
    private final Provider<SecurityGuardFacade> PlaceComponentResult;
    private final Provider<DanaProtectionInfoPreference> getAuthRequestContext;

    private HomeWidgetEntityRepository_Factory(Provider<PersistenceHomeWidgetEntityData> provider, Provider<DanaProtectionHomeWidgetPreference> provider2, Provider<DanaProtectionInfoPreference> provider3, Provider<SecurityGuardFacade> provider4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static HomeWidgetEntityRepository_Factory PlaceComponentResult(Provider<PersistenceHomeWidgetEntityData> provider, Provider<DanaProtectionHomeWidgetPreference> provider2, Provider<DanaProtectionInfoPreference> provider3, Provider<SecurityGuardFacade> provider4) {
        return new HomeWidgetEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HomeWidgetEntityRepository(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}

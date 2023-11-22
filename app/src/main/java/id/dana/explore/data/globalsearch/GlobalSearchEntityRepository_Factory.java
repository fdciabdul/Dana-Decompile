package id.dana.explore.data.globalsearch;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.content.mapper.ContentsMapper;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.services.repository.ServicesEntityRepository;
import id.dana.explore.data.globalsearch.source.GlobalSearchCacheEntityDataFactory;
import id.dana.explore.data.globalsearch.source.GlobalSearchEntityDataFactory;
import id.dana.explore.data.globalsearch.source.local.PreferenceLocationPermissionSuggestionEntityData;
import id.dana.explore.data.toggle.source.ExploreConfigEntityDataFactory;
import id.dana.explore.data.tracker.GlobalSearchMixpanelTracker;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GlobalSearchEntityRepository_Factory implements Factory<GlobalSearchEntityRepository> {
    private final Provider<ContentsMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ContentDeliveryEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GlobalSearchCacheEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<HoldLoginV1EntityRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<ExploreConfigEntityDataFactory> getAuthRequestContext;
    private final Provider<GlobalSearchEntityDataFactory> getErrorConfigVersion;
    private final Provider<PreferenceLocationPermissionSuggestionEntityData> lookAheadTest;
    private final Provider<GlobalSearchMixpanelTracker> moveToNextValue;
    private final Provider<ServicesEntityRepository> scheduleImpl;

    private GlobalSearchEntityRepository_Factory(Provider<Context> provider, Provider<GlobalSearchEntityDataFactory> provider2, Provider<ExploreConfigEntityDataFactory> provider3, Provider<GlobalSearchCacheEntityDataFactory> provider4, Provider<ServicesEntityRepository> provider5, Provider<PreferenceLocationPermissionSuggestionEntityData> provider6, Provider<ContentDeliveryEntityDataFactory> provider7, Provider<ContentsMapper> provider8, Provider<GlobalSearchMixpanelTracker> provider9, Provider<HoldLoginV1EntityRepository> provider10) {
        this.PlaceComponentResult = provider;
        this.getErrorConfigVersion = provider2;
        this.getAuthRequestContext = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.scheduleImpl = provider5;
        this.lookAheadTest = provider6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider7;
        this.BuiltInFictitiousFunctionClassFactory = provider8;
        this.moveToNextValue = provider9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider10;
    }

    public static GlobalSearchEntityRepository_Factory PlaceComponentResult(Provider<Context> provider, Provider<GlobalSearchEntityDataFactory> provider2, Provider<ExploreConfigEntityDataFactory> provider3, Provider<GlobalSearchCacheEntityDataFactory> provider4, Provider<ServicesEntityRepository> provider5, Provider<PreferenceLocationPermissionSuggestionEntityData> provider6, Provider<ContentDeliveryEntityDataFactory> provider7, Provider<ContentsMapper> provider8, Provider<GlobalSearchMixpanelTracker> provider9, Provider<HoldLoginV1EntityRepository> provider10) {
        return new GlobalSearchEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalSearchEntityRepository(this.PlaceComponentResult.get(), this.getErrorConfigVersion.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.scheduleImpl.get(), this.lookAheadTest.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.moveToNextValue.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get());
    }
}

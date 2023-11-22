package id.dana.contract.nearbyme;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.nearbyme.NewNearbyMeContract;
import id.dana.domain.featureconfig.interactor.CheckNearbyMeMapFeature;
import id.dana.domain.nearbyme.interactor.GetAutoSearchConfig;
import id.dana.domain.nearbyme.interactor.GetDistrictNameByLocation;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyRankingConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsFromCache;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithPagination;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithRadius;
import id.dana.domain.nearbyme.interactor.GetNearbyWidgetVisibility;
import id.dana.domain.nearbyme.interactor.IsNeedToShowOnboardingToolTip;
import id.dana.domain.nearbyme.interactor.SaveShowOnboardingTooltip;
import id.dana.drawable.ShopRankingCalculator;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NewNearbyPresenter_Factory implements Factory<NewNearbyPresenter> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SaveShowOnboardingTooltip> DatabaseTableConfigUtil;
    private final Provider<GetNearbyWidgetVisibility> GetContactSyncConfig;
    private final Provider<CheckNearbyMeMapFeature> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetDistrictNameByLocation> MyBillsEntityDataFactory;
    private final Provider<GetNearbyShopsPromo> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<NearbyPromoModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<IsNeedToShowOnboardingToolTip> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<ShopRankingCalculator> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<GetAutoSearchConfig> PlaceComponentResult;
    private final Provider<NewNearbyMeContract.View> PrepareContext;
    private final Provider<GetNearbyConfig> getAuthRequestContext;
    private final Provider<GetNearbyShopsWithRadius> getErrorConfigVersion;
    private final Provider<NearbyShopsModelMapper> initRecordTimeStamp;
    private final Provider<GetNearbyShopsFromCache> lookAheadTest;
    private final Provider<GetNearbyRankingConfig> moveToNextValue;
    private final Provider<GetNearbyShopsWithPagination> scheduleImpl;

    private NewNearbyPresenter_Factory(Provider<Context> provider, Provider<NewNearbyMeContract.View> provider2, Provider<GetNearbyWidgetVisibility> provider3, Provider<CheckNearbyMeMapFeature> provider4, Provider<GetNearbyRankingConfig> provider5, Provider<GetNearbyShopsWithPagination> provider6, Provider<NearbyShopsModelMapper> provider7, Provider<GetNearbyShopsWithRadius> provider8, Provider<GetNearbyShopsPromo> provider9, Provider<NearbyPromoModelMapper> provider10, Provider<IsNeedToShowOnboardingToolTip> provider11, Provider<GetDistrictNameByLocation> provider12, Provider<SaveShowOnboardingTooltip> provider13, Provider<GetAutoSearchConfig> provider14, Provider<GetNearbyConfig> provider15, Provider<ShopRankingCalculator> provider16, Provider<GetNearbyShopsFromCache> provider17) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PrepareContext = provider2;
        this.GetContactSyncConfig = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.moveToNextValue = provider5;
        this.scheduleImpl = provider6;
        this.initRecordTimeStamp = provider7;
        this.getErrorConfigVersion = provider8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider11;
        this.MyBillsEntityDataFactory = provider12;
        this.DatabaseTableConfigUtil = provider13;
        this.PlaceComponentResult = provider14;
        this.getAuthRequestContext = provider15;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provider16;
        this.lookAheadTest = provider17;
    }

    public static NewNearbyPresenter_Factory PlaceComponentResult(Provider<Context> provider, Provider<NewNearbyMeContract.View> provider2, Provider<GetNearbyWidgetVisibility> provider3, Provider<CheckNearbyMeMapFeature> provider4, Provider<GetNearbyRankingConfig> provider5, Provider<GetNearbyShopsWithPagination> provider6, Provider<NearbyShopsModelMapper> provider7, Provider<GetNearbyShopsWithRadius> provider8, Provider<GetNearbyShopsPromo> provider9, Provider<NearbyPromoModelMapper> provider10, Provider<IsNeedToShowOnboardingToolTip> provider11, Provider<GetDistrictNameByLocation> provider12, Provider<SaveShowOnboardingTooltip> provider13, Provider<GetAutoSearchConfig> provider14, Provider<GetNearbyConfig> provider15, Provider<ShopRankingCalculator> provider16, Provider<GetNearbyShopsFromCache> provider17) {
        return new NewNearbyPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NewNearbyPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.PrepareContext.get(), DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest));
    }
}

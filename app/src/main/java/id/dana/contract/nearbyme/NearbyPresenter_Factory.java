package id.dana.contract.nearbyme;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.contract.nearbyme.NearbyMeContract;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.domain.featureconfig.interactor.CheckNearbyMeFeature;
import id.dana.domain.nearbyme.interactor.GetAutoSearchConfig;
import id.dana.domain.nearbyme.interactor.GetDistrictNameByLocation;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyRankingConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithPagination;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithRadius;
import id.dana.domain.nearbyme.interactor.IsNearbyReviewPageEnabled;
import id.dana.domain.nearbyme.interactor.IsNeedToShowOnboardingToolTip;
import id.dana.domain.nearbyme.interactor.SaveShowOnboardingTooltip;
import id.dana.domain.nearbyme.interactor.merchantreview.ConsultMerchantReview;
import id.dana.drawable.ShopRankingCalculator;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NearbyPresenter_Factory implements Factory<NearbyPresenter> {
    private final Provider<GetAutoSearchConfig> BuiltInFictitiousFunctionClassFactory;
    private final Provider<IsNeedToShowOnboardingToolTip> DatabaseTableConfigUtil;
    private final Provider<IsNearbyReviewPageEnabled> GetContactSyncConfig;
    private final Provider<ConsultMerchantReview> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<GetNearbyRankingConfig> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<NearbyPromoModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<GetNearbyShopsWithRadius> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<NearbyMeContract.View> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<ShopRankingCalculator> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final Provider<GetAccount> PlaceComponentResult;
    private final Provider<CheckNearbyMeFeature> getAuthRequestContext;
    private final Provider<GetNearbyShopsWithPagination> getErrorConfigVersion;
    private final Provider<NearbyShopsModelMapper> initRecordTimeStamp;
    private final Provider<GetNearbyConfig> lookAheadTest;
    private final Provider<GetNearbyShopsPromo> moveToNextValue;
    private final Provider<SaveShowOnboardingTooltip> newProxyInstance;
    private final Provider<GetDistrictNameByLocation> scheduleImpl;

    private NearbyPresenter_Factory(Provider<Context> provider, Provider<CheckNearbyMeFeature> provider2, Provider<GetNearbyRankingConfig> provider3, Provider<GetNearbyShopsWithPagination> provider4, Provider<NearbyMeContract.View> provider5, Provider<NearbyShopsModelMapper> provider6, Provider<GetNearbyShopsWithRadius> provider7, Provider<GetNearbyShopsPromo> provider8, Provider<NearbyPromoModelMapper> provider9, Provider<IsNeedToShowOnboardingToolTip> provider10, Provider<GetDistrictNameByLocation> provider11, Provider<SaveShowOnboardingTooltip> provider12, Provider<GetAutoSearchConfig> provider13, Provider<GetAccount> provider14, Provider<GetNearbyConfig> provider15, Provider<ShopRankingCalculator> provider16, Provider<IsNearbyReviewPageEnabled> provider17, Provider<ConsultMerchantReview> provider18) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider3;
        this.getErrorConfigVersion = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provider5;
        this.initRecordTimeStamp = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider7;
        this.moveToNextValue = provider8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider9;
        this.DatabaseTableConfigUtil = provider10;
        this.scheduleImpl = provider11;
        this.newProxyInstance = provider12;
        this.BuiltInFictitiousFunctionClassFactory = provider13;
        this.PlaceComponentResult = provider14;
        this.lookAheadTest = provider15;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = provider16;
        this.GetContactSyncConfig = provider17;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider18;
    }

    public static NearbyPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<CheckNearbyMeFeature> provider2, Provider<GetNearbyRankingConfig> provider3, Provider<GetNearbyShopsWithPagination> provider4, Provider<NearbyMeContract.View> provider5, Provider<NearbyShopsModelMapper> provider6, Provider<GetNearbyShopsWithRadius> provider7, Provider<GetNearbyShopsPromo> provider8, Provider<NearbyPromoModelMapper> provider9, Provider<IsNeedToShowOnboardingToolTip> provider10, Provider<GetDistrictNameByLocation> provider11, Provider<SaveShowOnboardingTooltip> provider12, Provider<GetAutoSearchConfig> provider13, Provider<GetAccount> provider14, Provider<GetNearbyConfig> provider15, Provider<ShopRankingCalculator> provider16, Provider<IsNearbyReviewPageEnabled> provider17, Provider<ConsultMerchantReview> provider18) {
        return new NearbyPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NearbyPresenter(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.getErrorConfigVersion.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.get(), this.initRecordTimeStamp.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), this.moveToNextValue.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.DatabaseTableConfigUtil.get(), this.scheduleImpl.get(), this.newProxyInstance.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.lookAheadTest.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda8.get(), this.GetContactSyncConfig.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

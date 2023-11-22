package id.dana.nearbyme.merchantdetail.viewcomponent;

import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.domain.nearbyme.interactor.GetMerchantReviewSummary;
import id.dana.domain.nearbyme.interactor.GetReviewCoachmark;
import id.dana.domain.nearbyme.interactor.SetReviewCoachmark;
import id.dana.domain.nearbyme.interactor.merchantreview.ConsultMerchantReview;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm;
import id.dana.nearbyme.mapper.MerchantConsultReviewMapper;
import id.dana.nearbyme.merchantdetail.mapper.MerchantAverageRatingMapper;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MerchantAverageRatingPresenter_Factory implements Factory<MerchantAverageRatingPresenter> {
    private final Provider<ConsultMerchantReview> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetMerchantReviewSummary> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetAccount> MyBillsEntityDataFactory;
    private final Provider<MerchantAverageRatingMapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetReviewCoachmark> PlaceComponentResult;
    private final Provider<GetReviewableMerchantForm> getAuthRequestContext;
    private final Provider<MerchantConsultReviewMapper> getErrorConfigVersion;
    private final Provider<SetReviewCoachmark> lookAheadTest;
    private final Provider<MerchantAverageRatingContract.View> moveToNextValue;

    private MerchantAverageRatingPresenter_Factory(Provider<MerchantAverageRatingContract.View> provider, Provider<GetAccount> provider2, Provider<GetReviewableMerchantForm> provider3, Provider<GetMerchantReviewSummary> provider4, Provider<GetReviewCoachmark> provider5, Provider<SetReviewCoachmark> provider6, Provider<MerchantAverageRatingMapper> provider7, Provider<MerchantConsultReviewMapper> provider8, Provider<ConsultMerchantReview> provider9) {
        this.moveToNextValue = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.PlaceComponentResult = provider5;
        this.lookAheadTest = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider7;
        this.getErrorConfigVersion = provider8;
        this.BuiltInFictitiousFunctionClassFactory = provider9;
    }

    public static MerchantAverageRatingPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<MerchantAverageRatingContract.View> provider, Provider<GetAccount> provider2, Provider<GetReviewableMerchantForm> provider3, Provider<GetMerchantReviewSummary> provider4, Provider<GetReviewCoachmark> provider5, Provider<SetReviewCoachmark> provider6, Provider<MerchantAverageRatingMapper> provider7, Provider<MerchantConsultReviewMapper> provider8, Provider<ConsultMerchantReview> provider9) {
        return new MerchantAverageRatingPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantAverageRatingPresenter(this.moveToNextValue.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.lookAheadTest.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.getErrorConfigVersion.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

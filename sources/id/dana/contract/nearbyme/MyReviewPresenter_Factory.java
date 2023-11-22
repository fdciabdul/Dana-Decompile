package id.dana.contract.nearbyme;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.nearbyme.MyReviewContract;
import id.dana.domain.nearbyme.interactor.merchantreview.ConsultMerchantReview;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewedMerchantsList;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MyReviewPresenter_Factory implements Factory<MyReviewPresenter> {
    private final Provider<MyReviewContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ConsultMerchantReview> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<NearbyShopsModelMapper> MyBillsEntityDataFactory;
    private final Provider<GetReviewedMerchantsList> PlaceComponentResult;

    private MyReviewPresenter_Factory(Provider<MyReviewContract.View> provider, Provider<ConsultMerchantReview> provider2, Provider<GetReviewedMerchantsList> provider3, Provider<NearbyShopsModelMapper> provider4) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.PlaceComponentResult = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static MyReviewPresenter_Factory getAuthRequestContext(Provider<MyReviewContract.View> provider, Provider<ConsultMerchantReview> provider2, Provider<GetReviewedMerchantsList> provider3, Provider<NearbyShopsModelMapper> provider4) {
        return new MyReviewPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MyReviewPresenter(DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}

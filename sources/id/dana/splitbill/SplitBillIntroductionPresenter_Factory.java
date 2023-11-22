package id.dana.splitbill;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper;
import id.dana.splitbill.SplitBillIntroductionContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SplitBillIntroductionPresenter_Factory implements Factory<SplitBillIntroductionPresenter> {
    private final Provider<GetSplitBillConfig> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetRequestMoneyInfoFeature> MyBillsEntityDataFactory;
    private final Provider<RequestMoneyInfoModelMapper> PlaceComponentResult;
    private final Provider<SplitBillIntroductionContract.View> getAuthRequestContext;

    private SplitBillIntroductionPresenter_Factory(Provider<SplitBillIntroductionContract.View> provider, Provider<GetSplitBillConfig> provider2, Provider<GetRequestMoneyInfoFeature> provider3, Provider<RequestMoneyInfoModelMapper> provider4) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static SplitBillIntroductionPresenter_Factory getAuthRequestContext(Provider<SplitBillIntroductionContract.View> provider, Provider<GetSplitBillConfig> provider2, Provider<GetRequestMoneyInfoFeature> provider3, Provider<RequestMoneyInfoModelMapper> provider4) {
        return new SplitBillIntroductionPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitBillIntroductionPresenter(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}

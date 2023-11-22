package id.dana.contract.deeplink.path;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FeatureSplitBill_Factory implements Factory<FeatureSplitBill> {
    private final Provider<GetRequestMoneyInfoFeature> BuiltInFictitiousFunctionClassFactory;
    private final Provider<RequestMoneyInfoModelMapper> MyBillsEntityDataFactory;
    private final Provider<GetSplitBillConfig> getAuthRequestContext;

    private FeatureSplitBill_Factory(Provider<GetSplitBillConfig> provider, Provider<GetRequestMoneyInfoFeature> provider2, Provider<RequestMoneyInfoModelMapper> provider3) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static FeatureSplitBill_Factory MyBillsEntityDataFactory(Provider<GetSplitBillConfig> provider, Provider<GetRequestMoneyInfoFeature> provider2, Provider<RequestMoneyInfoModelMapper> provider3) {
        return new FeatureSplitBill_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeatureSplitBill(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}

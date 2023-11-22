package id.dana.contract.deeplink.path;

import dagger.internal.Factory;
import id.dana.domain.splitbill.interactor.GetPayerSplitBillDetail;
import id.dana.splitbill.mapper.SplitBillHistoryToSplitBillModelMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FeatureSplitBillPay_Factory implements Factory<FeatureSplitBillPay> {
    private final Provider<SplitBillHistoryToSplitBillModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetPayerSplitBillDetail> PlaceComponentResult;

    private FeatureSplitBillPay_Factory(Provider<GetPayerSplitBillDetail> provider, Provider<SplitBillHistoryToSplitBillModelMapper> provider2) {
        this.PlaceComponentResult = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static FeatureSplitBillPay_Factory BuiltInFictitiousFunctionClassFactory(Provider<GetPayerSplitBillDetail> provider, Provider<SplitBillHistoryToSplitBillModelMapper> provider2) {
        return new FeatureSplitBillPay_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeatureSplitBillPay(this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

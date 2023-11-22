package id.dana.richview.splitbill;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.interactor.GetRecentRecipient;
import id.dana.requestmoney.splitbill.mapper.SplitBillRecentPayerMapper;
import id.dana.richview.splitbill.SelectedPayerContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SelectedPayerPresenter_Factory implements Factory<SelectedPayerPresenter> {
    private final Provider<SplitBillRecentPayerMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetRecentRecipient> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SelectedPayerContract.View> PlaceComponentResult;

    private SelectedPayerPresenter_Factory(Provider<SelectedPayerContract.View> provider, Provider<GetRecentRecipient> provider2, Provider<SplitBillRecentPayerMapper> provider3) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static SelectedPayerPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<SelectedPayerContract.View> provider, Provider<GetRecentRecipient> provider2, Provider<SplitBillRecentPayerMapper> provider3) {
        return new SelectedPayerPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SelectedPayerPresenter(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

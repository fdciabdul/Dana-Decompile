package id.dana.splitbill.mapper;

import dagger.internal.Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SplitBillHistoryToSplitBillModelMapper_Factory implements Factory<SplitBillHistoryToSplitBillModelMapper> {
    private final Provider<PayerModelListMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CurrencyAmountModelMapper> MyBillsEntityDataFactory;

    private SplitBillHistoryToSplitBillModelMapper_Factory(Provider<CurrencyAmountModelMapper> provider, Provider<PayerModelListMapper> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static SplitBillHistoryToSplitBillModelMapper_Factory PlaceComponentResult(Provider<CurrencyAmountModelMapper> provider, Provider<PayerModelListMapper> provider2) {
        return new SplitBillHistoryToSplitBillModelMapper_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitBillHistoryToSplitBillModelMapper(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

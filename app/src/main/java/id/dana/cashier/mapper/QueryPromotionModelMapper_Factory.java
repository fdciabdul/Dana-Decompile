package id.dana.cashier.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class QueryPromotionModelMapper_Factory implements Factory<QueryPromotionModelMapper> {
    private final Provider<VoucherCashierModelsMapper> KClassImpl$Data$declaredNonStaticMembers$2;

    private QueryPromotionModelMapper_Factory(Provider<VoucherCashierModelsMapper> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static QueryPromotionModelMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<VoucherCashierModelsMapper> provider) {
        return new QueryPromotionModelMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new QueryPromotionModelMapper(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

package id.dana.cashier.data.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class QueryPromotionInfoResultMapper_Factory implements Factory<QueryPromotionInfoResultMapper> {
    private final Provider<VoucherInfoResultsMapper> voucherInfoResultsMapperProvider;

    public QueryPromotionInfoResultMapper_Factory(Provider<VoucherInfoResultsMapper> provider) {
        this.voucherInfoResultsMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final QueryPromotionInfoResultMapper get() {
        return newInstance(this.voucherInfoResultsMapperProvider.get());
    }

    public static QueryPromotionInfoResultMapper_Factory create(Provider<VoucherInfoResultsMapper> provider) {
        return new QueryPromotionInfoResultMapper_Factory(provider);
    }

    public static QueryPromotionInfoResultMapper newInstance(VoucherInfoResultsMapper voucherInfoResultsMapper) {
        return new QueryPromotionInfoResultMapper(voucherInfoResultsMapper);
    }
}

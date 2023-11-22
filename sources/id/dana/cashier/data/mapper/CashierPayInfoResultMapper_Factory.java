package id.dana.cashier.data.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CashierPayInfoResultMapper_Factory implements Factory<CashierPayInfoResultMapper> {
    private final Provider<AttributesResultMapper> attributesResultMapperProvider;

    public CashierPayInfoResultMapper_Factory(Provider<AttributesResultMapper> provider) {
        this.attributesResultMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CashierPayInfoResultMapper get() {
        return newInstance(this.attributesResultMapperProvider.get());
    }

    public static CashierPayInfoResultMapper_Factory create(Provider<AttributesResultMapper> provider) {
        return new CashierPayInfoResultMapper_Factory(provider);
    }

    public static CashierPayInfoResultMapper newInstance(AttributesResultMapper attributesResultMapper) {
        return new CashierPayInfoResultMapper(attributesResultMapper);
    }
}

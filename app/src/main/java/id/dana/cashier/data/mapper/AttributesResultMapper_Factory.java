package id.dana.cashier.data.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AttributesResultMapper_Factory implements Factory<AttributesResultMapper> {
    private final Provider<PayChannelsInfoResultMapper> payChannelsInfoResultMapperProvider;

    public AttributesResultMapper_Factory(Provider<PayChannelsInfoResultMapper> provider) {
        this.payChannelsInfoResultMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final AttributesResultMapper get() {
        return newInstance(this.payChannelsInfoResultMapperProvider.get());
    }

    public static AttributesResultMapper_Factory create(Provider<PayChannelsInfoResultMapper> provider) {
        return new AttributesResultMapper_Factory(provider);
    }

    public static AttributesResultMapper newInstance(PayChannelsInfoResultMapper payChannelsInfoResultMapper) {
        return new AttributesResultMapper(payChannelsInfoResultMapper);
    }
}

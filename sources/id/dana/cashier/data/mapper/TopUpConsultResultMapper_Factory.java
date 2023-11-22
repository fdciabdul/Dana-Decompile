package id.dana.cashier.data.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TopUpConsultResultMapper_Factory implements Factory<TopUpConsultResultMapper> {
    private final Provider<PayChannelsInfoResultMapper> payChannelsInfoResultMapperProvider;

    public TopUpConsultResultMapper_Factory(Provider<PayChannelsInfoResultMapper> provider) {
        this.payChannelsInfoResultMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final TopUpConsultResultMapper get() {
        return newInstance(this.payChannelsInfoResultMapperProvider.get());
    }

    public static TopUpConsultResultMapper_Factory create(Provider<PayChannelsInfoResultMapper> provider) {
        return new TopUpConsultResultMapper_Factory(provider);
    }

    public static TopUpConsultResultMapper newInstance(PayChannelsInfoResultMapper payChannelsInfoResultMapper) {
        return new TopUpConsultResultMapper(payChannelsInfoResultMapper);
    }
}

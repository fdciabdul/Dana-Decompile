package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PayMethodViewResultMapper_Factory implements Factory<PayMethodViewResultMapper> {
    private final Provider<PayChannelResultMapper> payChannelResultMapperProvider;
    private final Provider<PayOptionsResultMapper> payOptionsResultMapperProvider;

    public PayMethodViewResultMapper_Factory(Provider<PayOptionsResultMapper> provider, Provider<PayChannelResultMapper> provider2) {
        this.payOptionsResultMapperProvider = provider;
        this.payChannelResultMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PayMethodViewResultMapper get() {
        return newInstance(this.payOptionsResultMapperProvider.get(), this.payChannelResultMapperProvider.get());
    }

    public static PayMethodViewResultMapper_Factory create(Provider<PayOptionsResultMapper> provider, Provider<PayChannelResultMapper> provider2) {
        return new PayMethodViewResultMapper_Factory(provider, provider2);
    }

    public static PayMethodViewResultMapper newInstance(PayOptionsResultMapper payOptionsResultMapper, PayChannelResultMapper payChannelResultMapper) {
        return new PayMethodViewResultMapper(payOptionsResultMapper, payChannelResultMapper);
    }
}

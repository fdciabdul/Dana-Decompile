package id.dana.cashier.data.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class TopUpSubmitResultMapper_Factory implements Factory<TopUpSubmitResultMapper> {
    private final Provider<AttributesResultMapper> attributesResultMapperProvider;

    public TopUpSubmitResultMapper_Factory(Provider<AttributesResultMapper> provider) {
        this.attributesResultMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final TopUpSubmitResultMapper get() {
        return newInstance(this.attributesResultMapperProvider.get());
    }

    public static TopUpSubmitResultMapper_Factory create(Provider<AttributesResultMapper> provider) {
        return new TopUpSubmitResultMapper_Factory(provider);
    }

    public static TopUpSubmitResultMapper newInstance(AttributesResultMapper attributesResultMapper) {
        return new TopUpSubmitResultMapper(attributesResultMapper);
    }
}

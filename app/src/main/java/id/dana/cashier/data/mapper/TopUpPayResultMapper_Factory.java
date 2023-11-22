package id.dana.cashier.data.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TopUpPayResultMapper_Factory implements Factory<TopUpPayResultMapper> {
    private final Provider<AttributesResultMapper> attributesResultMapperProvider;

    public TopUpPayResultMapper_Factory(Provider<AttributesResultMapper> provider) {
        this.attributesResultMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final TopUpPayResultMapper get() {
        return newInstance(this.attributesResultMapperProvider.get());
    }

    public static TopUpPayResultMapper_Factory create(Provider<AttributesResultMapper> provider) {
        return new TopUpPayResultMapper_Factory(provider);
    }

    public static TopUpPayResultMapper newInstance(AttributesResultMapper attributesResultMapper) {
        return new TopUpPayResultMapper(attributesResultMapper);
    }
}

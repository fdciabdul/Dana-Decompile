package id.dana.data.splitbill.mapper;

import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitBillHistoriesResultMapper_Factory implements Factory<SplitBillHistoriesResultMapper> {
    private final Provider<Serializer> serializerProvider;

    public SplitBillHistoriesResultMapper_Factory(Provider<Serializer> provider) {
        this.serializerProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitBillHistoriesResultMapper get() {
        return newInstance(this.serializerProvider.get());
    }

    public static SplitBillHistoriesResultMapper_Factory create(Provider<Serializer> provider) {
        return new SplitBillHistoriesResultMapper_Factory(provider);
    }

    public static SplitBillHistoriesResultMapper newInstance(Serializer serializer) {
        return new SplitBillHistoriesResultMapper(serializer);
    }
}

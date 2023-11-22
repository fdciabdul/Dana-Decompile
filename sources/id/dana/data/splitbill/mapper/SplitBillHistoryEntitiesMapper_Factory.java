package id.dana.data.splitbill.mapper;

import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitBillHistoryEntitiesMapper_Factory implements Factory<SplitBillHistoryEntitiesMapper> {
    private final Provider<Serializer> serializerProvider;

    public SplitBillHistoryEntitiesMapper_Factory(Provider<Serializer> provider) {
        this.serializerProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitBillHistoryEntitiesMapper get() {
        return newInstance(this.serializerProvider.get());
    }

    public static SplitBillHistoryEntitiesMapper_Factory create(Provider<Serializer> provider) {
        return new SplitBillHistoryEntitiesMapper_Factory(provider);
    }

    public static SplitBillHistoryEntitiesMapper newInstance(Serializer serializer) {
        return new SplitBillHistoryEntitiesMapper(serializer);
    }
}

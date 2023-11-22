package id.dana.data.splitbill.mapper;

import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitBillToSplitBillEntityMapper_Factory implements Factory<SplitBillToSplitBillEntityMapper> {
    private final Provider<Serializer> serializerProvider;

    public SplitBillToSplitBillEntityMapper_Factory(Provider<Serializer> provider) {
        this.serializerProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitBillToSplitBillEntityMapper get() {
        return newInstance(this.serializerProvider.get());
    }

    public static SplitBillToSplitBillEntityMapper_Factory create(Provider<Serializer> provider) {
        return new SplitBillToSplitBillEntityMapper_Factory(provider);
    }

    public static SplitBillToSplitBillEntityMapper newInstance(Serializer serializer) {
        return new SplitBillToSplitBillEntityMapper(serializer);
    }
}

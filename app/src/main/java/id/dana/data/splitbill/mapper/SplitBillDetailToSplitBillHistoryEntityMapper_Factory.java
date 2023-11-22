package id.dana.data.splitbill.mapper;

import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitBillDetailToSplitBillHistoryEntityMapper_Factory implements Factory<SplitBillDetailToSplitBillHistoryEntityMapper> {
    private final Provider<Serializer> serializerProvider;

    public SplitBillDetailToSplitBillHistoryEntityMapper_Factory(Provider<Serializer> provider) {
        this.serializerProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitBillDetailToSplitBillHistoryEntityMapper get() {
        return newInstance(this.serializerProvider.get());
    }

    public static SplitBillDetailToSplitBillHistoryEntityMapper_Factory create(Provider<Serializer> provider) {
        return new SplitBillDetailToSplitBillHistoryEntityMapper_Factory(provider);
    }

    public static SplitBillDetailToSplitBillHistoryEntityMapper newInstance(Serializer serializer) {
        return new SplitBillDetailToSplitBillHistoryEntityMapper(serializer);
    }
}

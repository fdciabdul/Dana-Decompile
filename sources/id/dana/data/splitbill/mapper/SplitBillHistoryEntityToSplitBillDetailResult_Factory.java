package id.dana.data.splitbill.mapper;

import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitBillHistoryEntityToSplitBillDetailResult_Factory implements Factory<SplitBillHistoryEntityToSplitBillDetailResult> {
    private final Provider<Serializer> serializerProvider;

    public SplitBillHistoryEntityToSplitBillDetailResult_Factory(Provider<Serializer> provider) {
        this.serializerProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitBillHistoryEntityToSplitBillDetailResult get() {
        return newInstance(this.serializerProvider.get());
    }

    public static SplitBillHistoryEntityToSplitBillDetailResult_Factory create(Provider<Serializer> provider) {
        return new SplitBillHistoryEntityToSplitBillDetailResult_Factory(provider);
    }

    public static SplitBillHistoryEntityToSplitBillDetailResult newInstance(Serializer serializer) {
        return new SplitBillHistoryEntityToSplitBillDetailResult(serializer);
    }
}

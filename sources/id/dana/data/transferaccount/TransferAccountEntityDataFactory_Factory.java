package id.dana.data.transferaccount;

import dagger.internal.Factory;
import id.dana.data.transferaccount.source.network.NetworkTransferAccountEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TransferAccountEntityDataFactory_Factory implements Factory<TransferAccountEntityDataFactory> {
    private final Provider<NetworkTransferAccountEntityData> getAuthRequestContext;

    private TransferAccountEntityDataFactory_Factory(Provider<NetworkTransferAccountEntityData> provider) {
        this.getAuthRequestContext = provider;
    }

    public static TransferAccountEntityDataFactory_Factory MyBillsEntityDataFactory(Provider<NetworkTransferAccountEntityData> provider) {
        return new TransferAccountEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TransferAccountEntityDataFactory(this.getAuthRequestContext.get());
    }
}

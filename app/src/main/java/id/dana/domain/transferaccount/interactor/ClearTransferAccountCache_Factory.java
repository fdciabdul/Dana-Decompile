package id.dana.domain.transferaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.transferaccount.TransferAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ClearTransferAccountCache_Factory implements Factory<ClearTransferAccountCache> {
    private final Provider<TransferAccountRepository> repositoryProvider;

    public ClearTransferAccountCache_Factory(Provider<TransferAccountRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ClearTransferAccountCache get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static ClearTransferAccountCache_Factory create(Provider<TransferAccountRepository> provider) {
        return new ClearTransferAccountCache_Factory(provider);
    }

    public static ClearTransferAccountCache newInstance(TransferAccountRepository transferAccountRepository) {
        return new ClearTransferAccountCache(transferAccountRepository);
    }
}

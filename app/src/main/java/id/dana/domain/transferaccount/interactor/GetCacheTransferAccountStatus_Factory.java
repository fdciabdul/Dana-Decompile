package id.dana.domain.transferaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.transferaccount.TransferAccountRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GetCacheTransferAccountStatus_Factory implements Factory<GetCacheTransferAccountStatus> {
    private final Provider<TransferAccountRepository> repositoryProvider;

    public GetCacheTransferAccountStatus_Factory(Provider<TransferAccountRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCacheTransferAccountStatus get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetCacheTransferAccountStatus_Factory create(Provider<TransferAccountRepository> provider) {
        return new GetCacheTransferAccountStatus_Factory(provider);
    }

    public static GetCacheTransferAccountStatus newInstance(TransferAccountRepository transferAccountRepository) {
        return new GetCacheTransferAccountStatus(transferAccountRepository);
    }
}

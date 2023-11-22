package id.dana.domain.transferaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.transferaccount.TransferAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetTransferAccountStatus_Factory implements Factory<GetTransferAccountStatus> {
    private final Provider<TransferAccountRepository> repositoryProvider;

    public GetTransferAccountStatus_Factory(Provider<TransferAccountRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTransferAccountStatus get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetTransferAccountStatus_Factory create(Provider<TransferAccountRepository> provider) {
        return new GetTransferAccountStatus_Factory(provider);
    }

    public static GetTransferAccountStatus newInstance(TransferAccountRepository transferAccountRepository) {
        return new GetTransferAccountStatus(transferAccountRepository);
    }
}

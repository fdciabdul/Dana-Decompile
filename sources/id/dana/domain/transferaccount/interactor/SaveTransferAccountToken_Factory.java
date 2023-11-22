package id.dana.domain.transferaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.transferaccount.TransferAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveTransferAccountToken_Factory implements Factory<SaveTransferAccountToken> {
    private final Provider<TransferAccountRepository> repositoryProvider;

    public SaveTransferAccountToken_Factory(Provider<TransferAccountRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveTransferAccountToken get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static SaveTransferAccountToken_Factory create(Provider<TransferAccountRepository> provider) {
        return new SaveTransferAccountToken_Factory(provider);
    }

    public static SaveTransferAccountToken newInstance(TransferAccountRepository transferAccountRepository) {
        return new SaveTransferAccountToken(transferAccountRepository);
    }
}

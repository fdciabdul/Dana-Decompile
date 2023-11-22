package id.dana.domain.transferaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.transferaccount.TransferAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DeletionChangeNumber_Factory implements Factory<DeletionChangeNumber> {
    private final Provider<TransferAccountRepository> transferAccountRepositoryProvider;

    public DeletionChangeNumber_Factory(Provider<TransferAccountRepository> provider) {
        this.transferAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DeletionChangeNumber get() {
        return newInstance(this.transferAccountRepositoryProvider.get());
    }

    public static DeletionChangeNumber_Factory create(Provider<TransferAccountRepository> provider) {
        return new DeletionChangeNumber_Factory(provider);
    }

    public static DeletionChangeNumber newInstance(TransferAccountRepository transferAccountRepository) {
        return new DeletionChangeNumber(transferAccountRepository);
    }
}

package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UpdateTotalSectionQuery_Factory implements Factory<UpdateTotalSectionQuery> {
    private final Provider<WalletV3Repository> walletV3RepositoryProvider;

    public UpdateTotalSectionQuery_Factory(Provider<WalletV3Repository> provider) {
        this.walletV3RepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final UpdateTotalSectionQuery get() {
        return newInstance(this.walletV3RepositoryProvider.get());
    }

    public static UpdateTotalSectionQuery_Factory create(Provider<WalletV3Repository> provider) {
        return new UpdateTotalSectionQuery_Factory(provider);
    }

    public static UpdateTotalSectionQuery newInstance(WalletV3Repository walletV3Repository) {
        return new UpdateTotalSectionQuery(walletV3Repository);
    }
}

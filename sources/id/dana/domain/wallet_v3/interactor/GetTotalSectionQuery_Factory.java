package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetTotalSectionQuery_Factory implements Factory<GetTotalSectionQuery> {
    private final Provider<WalletV3Repository> walletV3RepositoryProvider;

    public GetTotalSectionQuery_Factory(Provider<WalletV3Repository> provider) {
        this.walletV3RepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTotalSectionQuery get() {
        return newInstance(this.walletV3RepositoryProvider.get());
    }

    public static GetTotalSectionQuery_Factory create(Provider<WalletV3Repository> provider) {
        return new GetTotalSectionQuery_Factory(provider);
    }

    public static GetTotalSectionQuery newInstance(WalletV3Repository walletV3Repository) {
        return new GetTotalSectionQuery(walletV3Repository);
    }
}

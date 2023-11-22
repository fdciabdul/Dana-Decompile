package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SetPocketUpdate_Factory implements Factory<SetPocketUpdate> {
    private final Provider<WalletV3Repository> walletV3RepositoryProvider;

    public SetPocketUpdate_Factory(Provider<WalletV3Repository> provider) {
        this.walletV3RepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SetPocketUpdate get() {
        return newInstance(this.walletV3RepositoryProvider.get());
    }

    public static SetPocketUpdate_Factory create(Provider<WalletV3Repository> provider) {
        return new SetPocketUpdate_Factory(provider);
    }

    public static SetPocketUpdate newInstance(WalletV3Repository walletV3Repository) {
        return new SetPocketUpdate(walletV3Repository);
    }
}

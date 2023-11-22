package id.dana.data.wallet_v3.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalWalletConfigEntityData_Factory implements Factory<LocalWalletConfigEntityData> {
    private final Provider<WalletConfigPreference> walletConfigPreferenceProvider;

    public LocalWalletConfigEntityData_Factory(Provider<WalletConfigPreference> provider) {
        this.walletConfigPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LocalWalletConfigEntityData get() {
        return newInstance(this.walletConfigPreferenceProvider.get());
    }

    public static LocalWalletConfigEntityData_Factory create(Provider<WalletConfigPreference> provider) {
        return new LocalWalletConfigEntityData_Factory(provider);
    }

    public static LocalWalletConfigEntityData newInstance(WalletConfigPreference walletConfigPreference) {
        return new LocalWalletConfigEntityData(walletConfigPreference);
    }
}

package id.dana.data.recentrecipient;

import dagger.internal.Factory;
import id.dana.data.recentrecipient.source.network.NetworkBankCardConversionEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BankCardConversionFactory_Factory implements Factory<BankCardConversionFactory> {
    private final Provider<NetworkBankCardConversionEntityData> networkBankCardConversionEntityDataProvider;

    public BankCardConversionFactory_Factory(Provider<NetworkBankCardConversionEntityData> provider) {
        this.networkBankCardConversionEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final BankCardConversionFactory get() {
        return newInstance(this.networkBankCardConversionEntityDataProvider.get());
    }

    public static BankCardConversionFactory_Factory create(Provider<NetworkBankCardConversionEntityData> provider) {
        return new BankCardConversionFactory_Factory(provider);
    }

    public static BankCardConversionFactory newInstance(NetworkBankCardConversionEntityData networkBankCardConversionEntityData) {
        return new BankCardConversionFactory(networkBankCardConversionEntityData);
    }
}

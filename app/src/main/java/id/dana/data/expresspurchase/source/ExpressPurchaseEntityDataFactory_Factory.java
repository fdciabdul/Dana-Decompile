package id.dana.data.expresspurchase.source;

import dagger.internal.Factory;
import id.dana.data.expresspurchase.source.config.split.SplitExpressPurchaseConfigEntityData;
import id.dana.data.expresspurchase.source.local.LocalExpressPurchaseEntityData;
import id.dana.data.expresspurchase.source.network.NetworkExpressPurchaseEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ExpressPurchaseEntityDataFactory_Factory implements Factory<ExpressPurchaseEntityDataFactory> {
    private final Provider<LocalExpressPurchaseEntityData> localExpressPurchaseEntityDataProvider;
    private final Provider<NetworkExpressPurchaseEntityData> networkExpressPurchaseEntityDataProvider;
    private final Provider<SplitExpressPurchaseConfigEntityData> splitExpressPurchaseConfigEntityDataProvider;

    public ExpressPurchaseEntityDataFactory_Factory(Provider<NetworkExpressPurchaseEntityData> provider, Provider<LocalExpressPurchaseEntityData> provider2, Provider<SplitExpressPurchaseConfigEntityData> provider3) {
        this.networkExpressPurchaseEntityDataProvider = provider;
        this.localExpressPurchaseEntityDataProvider = provider2;
        this.splitExpressPurchaseConfigEntityDataProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final ExpressPurchaseEntityDataFactory get() {
        return newInstance(this.networkExpressPurchaseEntityDataProvider.get(), this.localExpressPurchaseEntityDataProvider.get(), this.splitExpressPurchaseConfigEntityDataProvider.get());
    }

    public static ExpressPurchaseEntityDataFactory_Factory create(Provider<NetworkExpressPurchaseEntityData> provider, Provider<LocalExpressPurchaseEntityData> provider2, Provider<SplitExpressPurchaseConfigEntityData> provider3) {
        return new ExpressPurchaseEntityDataFactory_Factory(provider, provider2, provider3);
    }

    public static ExpressPurchaseEntityDataFactory newInstance(NetworkExpressPurchaseEntityData networkExpressPurchaseEntityData, LocalExpressPurchaseEntityData localExpressPurchaseEntityData, SplitExpressPurchaseConfigEntityData splitExpressPurchaseConfigEntityData) {
        return new ExpressPurchaseEntityDataFactory(networkExpressPurchaseEntityData, localExpressPurchaseEntityData, splitExpressPurchaseConfigEntityData);
    }
}

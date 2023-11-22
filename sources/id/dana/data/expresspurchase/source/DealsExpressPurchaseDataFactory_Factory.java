package id.dana.data.expresspurchase.source;

import dagger.internal.Factory;
import id.dana.data.expresspurchase.source.network.NetworkDealsExpressPurchaseEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DealsExpressPurchaseDataFactory_Factory implements Factory<DealsExpressPurchaseDataFactory> {
    private final Provider<NetworkDealsExpressPurchaseEntityData> networkExpressPurchaseEntityDataProvider;

    public DealsExpressPurchaseDataFactory_Factory(Provider<NetworkDealsExpressPurchaseEntityData> provider) {
        this.networkExpressPurchaseEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DealsExpressPurchaseDataFactory get() {
        return newInstance(this.networkExpressPurchaseEntityDataProvider.get());
    }

    public static DealsExpressPurchaseDataFactory_Factory create(Provider<NetworkDealsExpressPurchaseEntityData> provider) {
        return new DealsExpressPurchaseDataFactory_Factory(provider);
    }

    public static DealsExpressPurchaseDataFactory newInstance(NetworkDealsExpressPurchaseEntityData networkDealsExpressPurchaseEntityData) {
        return new DealsExpressPurchaseDataFactory(networkDealsExpressPurchaseEntityData);
    }
}

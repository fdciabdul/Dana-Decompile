package id.dana.data.expresspurchase.source;

import dagger.internal.Factory;
import id.dana.data.expresspurchase.source.network.NetworkExpressPurchaseOfferEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ExpressPurchaseOfferEntityDataFactory_Factory implements Factory<ExpressPurchaseOfferEntityDataFactory> {
    private final Provider<NetworkExpressPurchaseOfferEntityData> networkExpressPurchaseOfferEntityDataProvider;

    public ExpressPurchaseOfferEntityDataFactory_Factory(Provider<NetworkExpressPurchaseOfferEntityData> provider) {
        this.networkExpressPurchaseOfferEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ExpressPurchaseOfferEntityDataFactory get() {
        return newInstance(this.networkExpressPurchaseOfferEntityDataProvider.get());
    }

    public static ExpressPurchaseOfferEntityDataFactory_Factory create(Provider<NetworkExpressPurchaseOfferEntityData> provider) {
        return new ExpressPurchaseOfferEntityDataFactory_Factory(provider);
    }

    public static ExpressPurchaseOfferEntityDataFactory newInstance(NetworkExpressPurchaseOfferEntityData networkExpressPurchaseOfferEntityData) {
        return new ExpressPurchaseOfferEntityDataFactory(networkExpressPurchaseOfferEntityData);
    }
}

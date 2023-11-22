package id.dana.data.carrieridentification.source;

import dagger.internal.Factory;
import id.dana.data.carrieridentification.source.network.NetworkCarrierIdentificationEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CarrierIdentificationDataFactory_Factory implements Factory<CarrierIdentificationDataFactory> {
    private final Provider<NetworkCarrierIdentificationEntityData> MyBillsEntityDataFactory;

    private CarrierIdentificationDataFactory_Factory(Provider<NetworkCarrierIdentificationEntityData> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static CarrierIdentificationDataFactory_Factory getAuthRequestContext(Provider<NetworkCarrierIdentificationEntityData> provider) {
        return new CarrierIdentificationDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CarrierIdentificationDataFactory(this.MyBillsEntityDataFactory.get());
    }
}

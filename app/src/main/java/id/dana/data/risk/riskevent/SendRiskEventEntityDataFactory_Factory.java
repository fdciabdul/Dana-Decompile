package id.dana.data.risk.riskevent;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SendRiskEventEntityDataFactory_Factory implements Factory<SendRiskEventEntityDataFactory> {
    private final Provider<NetworkSendRiskEventEntityData> networkSendRiskEventEntityDataProvider;

    public SendRiskEventEntityDataFactory_Factory(Provider<NetworkSendRiskEventEntityData> provider) {
        this.networkSendRiskEventEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SendRiskEventEntityDataFactory get() {
        return newInstance(this.networkSendRiskEventEntityDataProvider.get());
    }

    public static SendRiskEventEntityDataFactory_Factory create(Provider<NetworkSendRiskEventEntityData> provider) {
        return new SendRiskEventEntityDataFactory_Factory(provider);
    }

    public static SendRiskEventEntityDataFactory newInstance(NetworkSendRiskEventEntityData networkSendRiskEventEntityData) {
        return new SendRiskEventEntityDataFactory(networkSendRiskEventEntityData);
    }
}

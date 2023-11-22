package id.dana.data.sendmoney.repository.source;

import dagger.internal.Factory;
import id.dana.data.sendmoney.repository.source.network.NetworkSendMoneyEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SendMoneyDataFactory_Factory implements Factory<SendMoneyDataFactory> {
    private final Provider<NetworkSendMoneyEntityData> networkSendMoneyEntityDataProvider;

    public SendMoneyDataFactory_Factory(Provider<NetworkSendMoneyEntityData> provider) {
        this.networkSendMoneyEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SendMoneyDataFactory get() {
        return newInstance(this.networkSendMoneyEntityDataProvider.get());
    }

    public static SendMoneyDataFactory_Factory create(Provider<NetworkSendMoneyEntityData> provider) {
        return new SendMoneyDataFactory_Factory(provider);
    }

    public static SendMoneyDataFactory newInstance(NetworkSendMoneyEntityData networkSendMoneyEntityData) {
        return new SendMoneyDataFactory(networkSendMoneyEntityData);
    }
}

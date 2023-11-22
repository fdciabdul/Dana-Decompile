package id.dana.domain.qriscrossborder.interactor;

import dagger.internal.Factory;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SendRiskEventWithParams_Factory implements Factory<SendRiskEventWithParams> {
    private final Provider<GlobalNetworkRepository> globalNetworkRepositoryProvider;

    public SendRiskEventWithParams_Factory(Provider<GlobalNetworkRepository> provider) {
        this.globalNetworkRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SendRiskEventWithParams get() {
        return newInstance(this.globalNetworkRepositoryProvider.get());
    }

    public static SendRiskEventWithParams_Factory create(Provider<GlobalNetworkRepository> provider) {
        return new SendRiskEventWithParams_Factory(provider);
    }

    public static SendRiskEventWithParams newInstance(GlobalNetworkRepository globalNetworkRepository) {
        return new SendRiskEventWithParams(globalNetworkRepository);
    }
}

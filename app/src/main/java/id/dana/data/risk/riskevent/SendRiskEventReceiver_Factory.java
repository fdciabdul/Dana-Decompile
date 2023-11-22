package id.dana.data.risk.riskevent;

import dagger.internal.Factory;
import id.dana.data.risk.riskevent.repository.SendRiskEventEntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SendRiskEventReceiver_Factory implements Factory<SendRiskEventReceiver> {
    private final Provider<SendRiskEventEntityRepository> sendRiskEventEntityRepositoryProvider;

    public SendRiskEventReceiver_Factory(Provider<SendRiskEventEntityRepository> provider) {
        this.sendRiskEventEntityRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SendRiskEventReceiver get() {
        return newInstance(this.sendRiskEventEntityRepositoryProvider.get());
    }

    public static SendRiskEventReceiver_Factory create(Provider<SendRiskEventEntityRepository> provider) {
        return new SendRiskEventReceiver_Factory(provider);
    }

    public static SendRiskEventReceiver newInstance(SendRiskEventEntityRepository sendRiskEventEntityRepository) {
        return new SendRiskEventReceiver(sendRiskEventEntityRepository);
    }
}

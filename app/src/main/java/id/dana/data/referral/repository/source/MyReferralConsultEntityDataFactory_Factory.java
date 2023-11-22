package id.dana.data.referral.repository.source;

import dagger.internal.Factory;
import id.dana.data.referral.repository.source.local.LocalMyReferralConsultEntityData;
import id.dana.data.referral.repository.source.network.NetworkMyReferralConsultEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MyReferralConsultEntityDataFactory_Factory implements Factory<MyReferralConsultEntityDataFactory> {
    private final Provider<LocalMyReferralConsultEntityData> localMyReferralConsultEntityDataProvider;
    private final Provider<NetworkMyReferralConsultEntityData> networkMyReferralConsultEntityDataProvider;

    public MyReferralConsultEntityDataFactory_Factory(Provider<NetworkMyReferralConsultEntityData> provider, Provider<LocalMyReferralConsultEntityData> provider2) {
        this.networkMyReferralConsultEntityDataProvider = provider;
        this.localMyReferralConsultEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final MyReferralConsultEntityDataFactory get() {
        return newInstance(this.networkMyReferralConsultEntityDataProvider.get(), this.localMyReferralConsultEntityDataProvider.get());
    }

    public static MyReferralConsultEntityDataFactory_Factory create(Provider<NetworkMyReferralConsultEntityData> provider, Provider<LocalMyReferralConsultEntityData> provider2) {
        return new MyReferralConsultEntityDataFactory_Factory(provider, provider2);
    }

    public static MyReferralConsultEntityDataFactory newInstance(NetworkMyReferralConsultEntityData networkMyReferralConsultEntityData, LocalMyReferralConsultEntityData localMyReferralConsultEntityData) {
        return new MyReferralConsultEntityDataFactory(networkMyReferralConsultEntityData, localMyReferralConsultEntityData);
    }
}

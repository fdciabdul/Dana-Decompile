package id.dana.data.qrpay.source.remote;

import android.app.Application;
import dagger.internal.Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.repository.FeatureConfigEntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RemoteQrPayEntityData_Factory implements Factory<RemoteQrPayEntityData> {
    private final Provider<Application> applicationProvider;
    private final Provider<DeviceInformationProvider> deviceInformationProvider;
    private final Provider<FeatureConfigEntityRepository> featureConfigEntityRepositoryProvider;

    public RemoteQrPayEntityData_Factory(Provider<Application> provider, Provider<DeviceInformationProvider> provider2, Provider<FeatureConfigEntityRepository> provider3) {
        this.applicationProvider = provider;
        this.deviceInformationProvider = provider2;
        this.featureConfigEntityRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final RemoteQrPayEntityData get() {
        return newInstance(this.applicationProvider.get(), this.deviceInformationProvider.get(), this.featureConfigEntityRepositoryProvider.get());
    }

    public static RemoteQrPayEntityData_Factory create(Provider<Application> provider, Provider<DeviceInformationProvider> provider2, Provider<FeatureConfigEntityRepository> provider3) {
        return new RemoteQrPayEntityData_Factory(provider, provider2, provider3);
    }

    public static RemoteQrPayEntityData newInstance(Application application, DeviceInformationProvider deviceInformationProvider, FeatureConfigEntityRepository featureConfigEntityRepository) {
        return new RemoteQrPayEntityData(application, deviceInformationProvider, featureConfigEntityRepository);
    }
}

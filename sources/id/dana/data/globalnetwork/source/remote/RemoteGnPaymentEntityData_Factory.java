package id.dana.data.globalnetwork.source.remote;

import android.app.Application;
import dagger.internal.Factory;
import id.dana.data.miniprogram.source.network.NetworkMiniPrograms;
import id.dana.data.user.UserEntityRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class RemoteGnPaymentEntityData_Factory implements Factory<RemoteGnPaymentEntityData> {
    private final Provider<Application> applicationProvider;
    private final Provider<NetworkMiniPrograms> networkMiniProgramsProvider;
    private final Provider<UserEntityRepository> userEntityRepositoryProvider;

    public RemoteGnPaymentEntityData_Factory(Provider<Application> provider, Provider<UserEntityRepository> provider2, Provider<NetworkMiniPrograms> provider3) {
        this.applicationProvider = provider;
        this.userEntityRepositoryProvider = provider2;
        this.networkMiniProgramsProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final RemoteGnPaymentEntityData get() {
        return newInstance(this.applicationProvider.get(), this.userEntityRepositoryProvider.get(), this.networkMiniProgramsProvider.get());
    }

    public static RemoteGnPaymentEntityData_Factory create(Provider<Application> provider, Provider<UserEntityRepository> provider2, Provider<NetworkMiniPrograms> provider3) {
        return new RemoteGnPaymentEntityData_Factory(provider, provider2, provider3);
    }

    public static RemoteGnPaymentEntityData newInstance(Application application, UserEntityRepository userEntityRepository, NetworkMiniPrograms networkMiniPrograms) {
        return new RemoteGnPaymentEntityData(application, userEntityRepository, networkMiniPrograms);
    }
}

package id.dana.data.registration;

import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import id.dana.data.sslpinning.SSLQuakeInterceptor;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RegistrationEntityRepository_MembersInjector implements MembersInjector<RegistrationEntityRepository> {
    private final Provider<SSLQuakeInterceptor> sslQuakeInterceptorProvider;

    public RegistrationEntityRepository_MembersInjector(Provider<SSLQuakeInterceptor> provider) {
        this.sslQuakeInterceptorProvider = provider;
    }

    public static MembersInjector<RegistrationEntityRepository> create(Provider<SSLQuakeInterceptor> provider) {
        return new RegistrationEntityRepository_MembersInjector(provider);
    }

    public final void injectMembers(RegistrationEntityRepository registrationEntityRepository) {
        injectInjectSslDependencies(registrationEntityRepository, DoubleCheck.MyBillsEntityDataFactory(this.sslQuakeInterceptorProvider));
    }

    public static void injectInjectSslDependencies(RegistrationEntityRepository registrationEntityRepository, Lazy<SSLQuakeInterceptor> lazy) {
        registrationEntityRepository.injectSslDependencies(lazy);
    }
}

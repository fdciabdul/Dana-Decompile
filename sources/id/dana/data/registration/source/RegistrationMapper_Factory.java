package id.dana.data.registration.source;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RegistrationMapper_Factory implements Factory<RegistrationMapper> {
    private final Provider<LoginAuthenticationMapper> loginAuthenticationMapperProvider;

    public RegistrationMapper_Factory(Provider<LoginAuthenticationMapper> provider) {
        this.loginAuthenticationMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RegistrationMapper get() {
        return newInstance(this.loginAuthenticationMapperProvider.get());
    }

    public static RegistrationMapper_Factory create(Provider<LoginAuthenticationMapper> provider) {
        return new RegistrationMapper_Factory(provider);
    }

    public static RegistrationMapper newInstance(LoginAuthenticationMapper loginAuthenticationMapper) {
        return new RegistrationMapper(loginAuthenticationMapper);
    }
}

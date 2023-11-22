package id.dana.domain.usercredential.interactor;

import dagger.internal.Factory;
import id.dana.domain.usercredential.CredentialRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPasswordLastModifiedWithConfigChecking_Factory implements Factory<GetPasswordLastModifiedWithConfigChecking> {
    private final Provider<CredentialRepository> credentialRepositoryProvider;

    public GetPasswordLastModifiedWithConfigChecking_Factory(Provider<CredentialRepository> provider) {
        this.credentialRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPasswordLastModifiedWithConfigChecking get() {
        return newInstance(this.credentialRepositoryProvider.get());
    }

    public static GetPasswordLastModifiedWithConfigChecking_Factory create(Provider<CredentialRepository> provider) {
        return new GetPasswordLastModifiedWithConfigChecking_Factory(provider);
    }

    public static GetPasswordLastModifiedWithConfigChecking newInstance(CredentialRepository credentialRepository) {
        return new GetPasswordLastModifiedWithConfigChecking(credentialRepository);
    }
}

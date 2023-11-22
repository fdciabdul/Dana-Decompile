package id.dana.domain.usereducation.interactor;

import dagger.internal.Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class IsNeedToShowDialog_Factory implements Factory<IsNeedToShowDialog> {
    private final Provider<UserEducationRepository> userEducationRepositoryProvider;

    public IsNeedToShowDialog_Factory(Provider<UserEducationRepository> provider) {
        this.userEducationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsNeedToShowDialog get() {
        return newInstance(this.userEducationRepositoryProvider.get());
    }

    public static IsNeedToShowDialog_Factory create(Provider<UserEducationRepository> provider) {
        return new IsNeedToShowDialog_Factory(provider);
    }

    public static IsNeedToShowDialog newInstance(UserEducationRepository userEducationRepository) {
        return new IsNeedToShowDialog(userEducationRepository);
    }
}

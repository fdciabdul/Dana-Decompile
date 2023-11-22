package id.dana.domain.usereducation.interactor;

import dagger.internal.Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveShowDialog_Factory implements Factory<SaveShowDialog> {
    private final Provider<UserEducationRepository> userEducationRepositoryProvider;

    public SaveShowDialog_Factory(Provider<UserEducationRepository> provider) {
        this.userEducationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveShowDialog get() {
        return newInstance(this.userEducationRepositoryProvider.get());
    }

    public static SaveShowDialog_Factory create(Provider<UserEducationRepository> provider) {
        return new SaveShowDialog_Factory(provider);
    }

    public static SaveShowDialog newInstance(UserEducationRepository userEducationRepository) {
        return new SaveShowDialog(userEducationRepository);
    }
}

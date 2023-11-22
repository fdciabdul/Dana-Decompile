package id.dana.domain.pushverify.interactor;

import dagger.internal.Factory;
import id.dana.domain.pushverify.repository.PushVerifyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveDisabledNotificationPromptPreference_Factory implements Factory<SaveDisabledNotificationPromptPreference> {
    private final Provider<PushVerifyRepository> pushVerifyRepositoryProvider;

    public SaveDisabledNotificationPromptPreference_Factory(Provider<PushVerifyRepository> provider) {
        this.pushVerifyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveDisabledNotificationPromptPreference get() {
        return newInstance(this.pushVerifyRepositoryProvider.get());
    }

    public static SaveDisabledNotificationPromptPreference_Factory create(Provider<PushVerifyRepository> provider) {
        return new SaveDisabledNotificationPromptPreference_Factory(provider);
    }

    public static SaveDisabledNotificationPromptPreference newInstance(PushVerifyRepository pushVerifyRepository) {
        return new SaveDisabledNotificationPromptPreference(pushVerifyRepository);
    }
}

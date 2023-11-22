package id.dana.domain.pushverify.interactor;

import dagger.internal.Factory;
import id.dana.domain.pushverify.repository.PushVerifyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsNotificationPromptDisabled_Factory implements Factory<IsNotificationPromptDisabled> {
    private final Provider<PushVerifyRepository> pushVerifyRepositoryProvider;

    public IsNotificationPromptDisabled_Factory(Provider<PushVerifyRepository> provider) {
        this.pushVerifyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsNotificationPromptDisabled get() {
        return newInstance(this.pushVerifyRepositoryProvider.get());
    }

    public static IsNotificationPromptDisabled_Factory create(Provider<PushVerifyRepository> provider) {
        return new IsNotificationPromptDisabled_Factory(provider);
    }

    public static IsNotificationPromptDisabled newInstance(PushVerifyRepository pushVerifyRepository) {
        return new IsNotificationPromptDisabled(pushVerifyRepository);
    }
}

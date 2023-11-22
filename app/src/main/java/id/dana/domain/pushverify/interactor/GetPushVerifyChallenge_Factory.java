package id.dana.domain.pushverify.interactor;

import dagger.internal.Factory;
import id.dana.domain.pushverify.repository.PushVerifyRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GetPushVerifyChallenge_Factory implements Factory<GetPushVerifyChallenge> {
    private final Provider<PushVerifyRepository> pushVerifyRepositoryProvider;

    public GetPushVerifyChallenge_Factory(Provider<PushVerifyRepository> provider) {
        this.pushVerifyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPushVerifyChallenge get() {
        return newInstance(this.pushVerifyRepositoryProvider.get());
    }

    public static GetPushVerifyChallenge_Factory create(Provider<PushVerifyRepository> provider) {
        return new GetPushVerifyChallenge_Factory(provider);
    }

    public static GetPushVerifyChallenge newInstance(PushVerifyRepository pushVerifyRepository) {
        return new GetPushVerifyChallenge(pushVerifyRepository);
    }
}

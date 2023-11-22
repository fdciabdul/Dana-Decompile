package id.dana.domain.pushverify.interactor;

import dagger.internal.Factory;
import id.dana.domain.pushverify.repository.PushVerifyRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GetVerifyPushChallenge_Factory implements Factory<GetVerifyPushChallenge> {
    private final Provider<PushVerifyRepository> pushVerifyRepositoryProvider;

    public GetVerifyPushChallenge_Factory(Provider<PushVerifyRepository> provider) {
        this.pushVerifyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetVerifyPushChallenge get() {
        return newInstance(this.pushVerifyRepositoryProvider.get());
    }

    public static GetVerifyPushChallenge_Factory create(Provider<PushVerifyRepository> provider) {
        return new GetVerifyPushChallenge_Factory(provider);
    }

    public static GetVerifyPushChallenge newInstance(PushVerifyRepository pushVerifyRepository) {
        return new GetVerifyPushChallenge(pushVerifyRepository);
    }
}

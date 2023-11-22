package id.dana.domain.pushverify.interactor;

import dagger.internal.Factory;
import id.dana.domain.pushverify.repository.PushVerifyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetActivePushVerificationList_Factory implements Factory<GetActivePushVerificationList> {
    private final Provider<PushVerifyRepository> pushVerifyRepositoryProvider;

    public GetActivePushVerificationList_Factory(Provider<PushVerifyRepository> provider) {
        this.pushVerifyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetActivePushVerificationList get() {
        return newInstance(this.pushVerifyRepositoryProvider.get());
    }

    public static GetActivePushVerificationList_Factory create(Provider<PushVerifyRepository> provider) {
        return new GetActivePushVerificationList_Factory(provider);
    }

    public static GetActivePushVerificationList newInstance(PushVerifyRepository pushVerifyRepository) {
        return new GetActivePushVerificationList(pushVerifyRepository);
    }
}

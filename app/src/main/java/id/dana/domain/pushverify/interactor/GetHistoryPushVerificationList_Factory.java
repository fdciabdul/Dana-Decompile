package id.dana.domain.pushverify.interactor;

import dagger.internal.Factory;
import id.dana.domain.pushverify.repository.PushVerifyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetHistoryPushVerificationList_Factory implements Factory<GetHistoryPushVerificationList> {
    private final Provider<PushVerifyRepository> pushVerifyRepositoryProvider;

    public GetHistoryPushVerificationList_Factory(Provider<PushVerifyRepository> provider) {
        this.pushVerifyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetHistoryPushVerificationList get() {
        return newInstance(this.pushVerifyRepositoryProvider.get());
    }

    public static GetHistoryPushVerificationList_Factory create(Provider<PushVerifyRepository> provider) {
        return new GetHistoryPushVerificationList_Factory(provider);
    }

    public static GetHistoryPushVerificationList newInstance(PushVerifyRepository pushVerifyRepository) {
        return new GetHistoryPushVerificationList(pushVerifyRepository);
    }
}

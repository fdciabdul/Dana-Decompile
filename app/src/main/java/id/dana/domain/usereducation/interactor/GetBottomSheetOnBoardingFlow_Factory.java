package id.dana.domain.usereducation.interactor;

import dagger.internal.Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetBottomSheetOnBoardingFlow_Factory implements Factory<GetBottomSheetOnBoardingFlow> {
    private final Provider<UserEducationRepository> userEducationRepositoryProvider;

    public GetBottomSheetOnBoardingFlow_Factory(Provider<UserEducationRepository> provider) {
        this.userEducationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetBottomSheetOnBoardingFlow get() {
        return newInstance(this.userEducationRepositoryProvider.get());
    }

    public static GetBottomSheetOnBoardingFlow_Factory create(Provider<UserEducationRepository> provider) {
        return new GetBottomSheetOnBoardingFlow_Factory(provider);
    }

    public static GetBottomSheetOnBoardingFlow newInstance(UserEducationRepository userEducationRepository) {
        return new GetBottomSheetOnBoardingFlow(userEducationRepository);
    }
}

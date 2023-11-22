package id.dana.domain.usereducation.interactor;

import dagger.internal.Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveDisplayBottomSheetOnBoardingFlow_Factory implements Factory<SaveDisplayBottomSheetOnBoardingFlow> {
    private final Provider<UserEducationRepository> userEducationRepositoryProvider;

    public SaveDisplayBottomSheetOnBoardingFlow_Factory(Provider<UserEducationRepository> provider) {
        this.userEducationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveDisplayBottomSheetOnBoardingFlow get() {
        return newInstance(this.userEducationRepositoryProvider.get());
    }

    public static SaveDisplayBottomSheetOnBoardingFlow_Factory create(Provider<UserEducationRepository> provider) {
        return new SaveDisplayBottomSheetOnBoardingFlow_Factory(provider);
    }

    public static SaveDisplayBottomSheetOnBoardingFlow newInstance(UserEducationRepository userEducationRepository) {
        return new SaveDisplayBottomSheetOnBoardingFlow(userEducationRepository);
    }
}

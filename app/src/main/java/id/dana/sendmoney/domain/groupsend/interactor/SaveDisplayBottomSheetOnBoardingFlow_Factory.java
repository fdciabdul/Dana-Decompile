package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SaveDisplayBottomSheetOnBoardingFlow_Factory implements Factory<SaveDisplayBottomSheetOnBoardingFlow> {
    private final Provider<UserEducationRepository> PlaceComponentResult;

    private SaveDisplayBottomSheetOnBoardingFlow_Factory(Provider<UserEducationRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SaveDisplayBottomSheetOnBoardingFlow_Factory MyBillsEntityDataFactory(Provider<UserEducationRepository> provider) {
        return new SaveDisplayBottomSheetOnBoardingFlow_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveDisplayBottomSheetOnBoardingFlow(this.PlaceComponentResult.get());
    }
}

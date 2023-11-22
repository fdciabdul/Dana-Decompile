package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetBottomSheetOnBoardingFlow_Factory implements Factory<GetBottomSheetOnBoardingFlow> {
    private final Provider<UserEducationRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private GetBottomSheetOnBoardingFlow_Factory(Provider<UserEducationRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static GetBottomSheetOnBoardingFlow_Factory BuiltInFictitiousFunctionClassFactory(Provider<UserEducationRepository> provider) {
        return new GetBottomSheetOnBoardingFlow_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetBottomSheetOnBoardingFlow(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

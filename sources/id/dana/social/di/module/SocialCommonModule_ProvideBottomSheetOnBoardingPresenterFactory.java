package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SocialCommonModule_ProvideBottomSheetOnBoardingPresenterFactory implements Factory<BottomSheetOnBoardingContract.Presenter> {
    private final Provider<BottomSheetOnBoardingPresenter> BuiltInFictitiousFunctionClassFactory;
    private final SocialCommonModule KClassImpl$Data$declaredNonStaticMembers$2;

    private SocialCommonModule_ProvideBottomSheetOnBoardingPresenterFactory(SocialCommonModule socialCommonModule, Provider<BottomSheetOnBoardingPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = socialCommonModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static SocialCommonModule_ProvideBottomSheetOnBoardingPresenterFactory BuiltInFictitiousFunctionClassFactory(SocialCommonModule socialCommonModule, Provider<BottomSheetOnBoardingPresenter> provider) {
        return new SocialCommonModule_ProvideBottomSheetOnBoardingPresenterFactory(socialCommonModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BottomSheetOnBoardingContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

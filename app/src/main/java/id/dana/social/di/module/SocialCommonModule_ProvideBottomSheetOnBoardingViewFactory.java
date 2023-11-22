package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes5.dex */
public final class SocialCommonModule_ProvideBottomSheetOnBoardingViewFactory implements Factory<BottomSheetOnBoardingContract.View> {
    private final SocialCommonModule MyBillsEntityDataFactory;

    private SocialCommonModule_ProvideBottomSheetOnBoardingViewFactory(SocialCommonModule socialCommonModule) {
        this.MyBillsEntityDataFactory = socialCommonModule;
    }

    public static SocialCommonModule_ProvideBottomSheetOnBoardingViewFactory MyBillsEntityDataFactory(SocialCommonModule socialCommonModule) {
        return new SocialCommonModule_ProvideBottomSheetOnBoardingViewFactory(socialCommonModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BottomSheetOnBoardingContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getPlaceComponentResult());
    }
}

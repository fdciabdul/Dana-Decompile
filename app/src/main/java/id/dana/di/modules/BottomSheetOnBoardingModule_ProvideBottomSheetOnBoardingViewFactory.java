package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes4.dex */
public final class BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory implements Factory<BottomSheetOnBoardingContract.View> {
    private final BottomSheetOnBoardingModule PlaceComponentResult;

    private BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory(BottomSheetOnBoardingModule bottomSheetOnBoardingModule) {
        this.PlaceComponentResult = bottomSheetOnBoardingModule;
    }

    public static BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory getAuthRequestContext(BottomSheetOnBoardingModule bottomSheetOnBoardingModule) {
        return new BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingViewFactory(bottomSheetOnBoardingModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BottomSheetOnBoardingContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext());
    }
}

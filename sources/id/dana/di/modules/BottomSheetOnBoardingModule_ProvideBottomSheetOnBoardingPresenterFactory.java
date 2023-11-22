package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory implements Factory<BottomSheetOnBoardingContract.Presenter> {
    private final BottomSheetOnBoardingModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<BottomSheetOnBoardingPresenter> MyBillsEntityDataFactory;

    private BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory(BottomSheetOnBoardingModule bottomSheetOnBoardingModule, Provider<BottomSheetOnBoardingPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bottomSheetOnBoardingModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory PlaceComponentResult(BottomSheetOnBoardingModule bottomSheetOnBoardingModule, Provider<BottomSheetOnBoardingPresenter> provider) {
        return new BottomSheetOnBoardingModule_ProvideBottomSheetOnBoardingPresenterFactory(bottomSheetOnBoardingModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BottomSheetOnBoardingContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}

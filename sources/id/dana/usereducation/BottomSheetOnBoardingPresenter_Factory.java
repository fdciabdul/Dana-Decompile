package id.dana.usereducation;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class BottomSheetOnBoardingPresenter_Factory implements Factory<BottomSheetOnBoardingPresenter> {
    private final Provider<BottomSheetOnBoardingContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SaveDisplayBottomSheetOnBoarding> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetBottomSheetOnBoarding> MyBillsEntityDataFactory;

    private BottomSheetOnBoardingPresenter_Factory(Provider<BottomSheetOnBoardingContract.View> provider, Provider<GetBottomSheetOnBoarding> provider2, Provider<SaveDisplayBottomSheetOnBoarding> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
    }

    public static BottomSheetOnBoardingPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<BottomSheetOnBoardingContract.View> provider, Provider<GetBottomSheetOnBoarding> provider2, Provider<SaveDisplayBottomSheetOnBoarding> provider3) {
        return new BottomSheetOnBoardingPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BottomSheetOnBoardingPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}

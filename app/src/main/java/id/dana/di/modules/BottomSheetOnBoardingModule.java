package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.BottomSheetOnBoardingPresenter;

@Module
/* loaded from: classes2.dex */
public class BottomSheetOnBoardingModule {
    private BottomSheetOnBoardingContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public BottomSheetOnBoardingContract.Presenter BuiltInFictitiousFunctionClassFactory(BottomSheetOnBoardingPresenter bottomSheetOnBoardingPresenter) {
        return bottomSheetOnBoardingPresenter;
    }

    public BottomSheetOnBoardingModule(BottomSheetOnBoardingContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public BottomSheetOnBoardingContract.View getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }
}

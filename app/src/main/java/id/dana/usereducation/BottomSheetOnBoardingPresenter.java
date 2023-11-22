package id.dana.usereducation;

import dagger.Lazy;
import id.dana.domain.DefaultObserver;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoarding;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoarding;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class BottomSheetOnBoardingPresenter implements BottomSheetOnBoardingContract.Presenter {
    private final BottomSheetOnBoardingContract.View BuiltInFictitiousFunctionClassFactory;
    private final Lazy<SaveDisplayBottomSheetOnBoarding> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy<GetBottomSheetOnBoarding> MyBillsEntityDataFactory;

    @Inject
    public BottomSheetOnBoardingPresenter(BottomSheetOnBoardingContract.View view, Lazy<GetBottomSheetOnBoarding> lazy, Lazy<SaveDisplayBottomSheetOnBoarding> lazy2) {
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.MyBillsEntityDataFactory = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
    }

    @Override // id.dana.usereducation.BottomSheetOnBoardingContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        PlaceComponentResult(str, "");
    }

    @Override // id.dana.usereducation.BottomSheetOnBoardingContract.Presenter
    public final void MyBillsEntityDataFactory(String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.usereducation.BottomSheetOnBoardingPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.SAVE_ON_BOARDING_PREFIX);
                sb.append(getClass().getName());
                sb.append("on Error");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString(), th);
            }
        }, SaveDisplayBottomSheetOnBoarding.Params.forDisplayBottomSheetOnBoarding(str));
    }

    @Override // id.dana.usereducation.BottomSheetOnBoardingContract.Presenter
    public final void PlaceComponentResult(final String str, final String str2) {
        this.MyBillsEntityDataFactory.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.usereducation.BottomSheetOnBoardingPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                BottomSheetOnBoardingPresenter.this.BuiltInFictitiousFunctionClassFactory.onGetBottomSheetOnBoardingAvailability(bool.booleanValue(), str2);
                BottomSheetOnBoardingPresenter.this.BuiltInFictitiousFunctionClassFactory.onGetBottomSheetOnBoardingAvailability(bool.booleanValue(), str2, str);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.GET_ON_BOARDING_PREFIX);
                sb.append(getClass().getName());
                sb.append("on Error");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString(), th);
            }
        }, GetBottomSheetOnBoarding.Params.forBottomSheetOnBoarding(str));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
    }
}

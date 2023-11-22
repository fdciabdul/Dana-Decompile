package id.dana.requestmoney;

import dagger.MembersInjector;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.requestmoney.bank.UserBankContract;
import id.dana.usereducation.BottomSheetOnBoardingContract;

/* loaded from: classes5.dex */
public final class RequestMoneyActivity_MembersInjector implements MembersInjector<RequestMoneyActivity> {
    public static void getAuthRequestContext(RequestMoneyActivity requestMoneyActivity, UserBankContract.Presenter presenter) {
        requestMoneyActivity.userBankPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(RequestMoneyActivity requestMoneyActivity, BottomSheetOnBoardingContract.Presenter presenter) {
        requestMoneyActivity.onBoardingPresenter = presenter;
    }

    public static void getAuthRequestContext(RequestMoneyActivity requestMoneyActivity, FeatureContract.Presenter presenter) {
        requestMoneyActivity.featurePresenter = presenter;
    }
}

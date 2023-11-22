package id.dana.requestmoney.bank;

import dagger.MembersInjector;
import id.dana.requestmoney.bank.UserBankContract;
import id.dana.requestmoney.bank.UserBankQrContract;

/* loaded from: classes5.dex */
public final class RequestMoneyBankQrCardFragment_MembersInjector implements MembersInjector<RequestMoneyBankQrCardFragment> {
    public static void MyBillsEntityDataFactory(RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment, UserBankContract.Presenter presenter) {
        requestMoneyBankQrCardFragment.userBankPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(RequestMoneyBankQrCardFragment requestMoneyBankQrCardFragment, UserBankQrContract.Presenter presenter) {
        requestMoneyBankQrCardFragment.userBankQrPresenter = presenter;
    }
}

package id.dana.requestmoney.balance;

import dagger.MembersInjector;
import id.dana.contract.staticqr.GetStaticQrContract;

/* loaded from: classes5.dex */
public final class RequestMoneyBalanceQrCardFragment_MembersInjector implements MembersInjector<RequestMoneyBalanceQrCardFragment> {
    public static void getAuthRequestContext(RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment, GetStaticQrContract.Presenter presenter) {
        requestMoneyBalanceQrCardFragment.staticQrPresenter = presenter;
    }
}

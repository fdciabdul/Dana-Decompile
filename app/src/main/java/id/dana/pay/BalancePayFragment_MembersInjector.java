package id.dana.pay;

import dagger.MembersInjector;
import id.dana.contract.payasset.ChangePayMethodContract;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.contract.payqr.PayQrContract;
import id.dana.contract.user.GetUserInfoContract;
import id.dana.data.dynamicurl.DynamicUrlWrapper;

/* loaded from: classes5.dex */
public final class BalancePayFragment_MembersInjector implements MembersInjector<BalancePayFragment> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(BalancePayFragment balancePayFragment, ChangePayMethodContract.Presenter presenter) {
        balancePayFragment.changePayMethodPresenter = presenter;
    }

    public static void getAuthRequestContext(BalancePayFragment balancePayFragment, GetUserInfoContract.Presenter presenter) {
        balancePayFragment.getUserInfoPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(BalancePayFragment balancePayFragment, DynamicUrlWrapper dynamicUrlWrapper) {
        balancePayFragment.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void BuiltInFictitiousFunctionClassFactory(BalancePayFragment balancePayFragment, OfflinePayContract.Presenter presenter) {
        balancePayFragment.offlinePayPresenter = presenter;
    }

    public static void getAuthRequestContext(BalancePayFragment balancePayFragment, PayQrContract.Presenter presenter) {
        balancePayFragment.payQrPresenter = presenter;
    }
}

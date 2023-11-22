package id.dana.pay;

import dagger.MembersInjector;
import id.dana.contract.payasset.ChangePayMethodContract;
import id.dana.contract.payqr.GetPaymentResultContract;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.contract.payqr.PayQrContract;
import id.dana.contract.user.GetUserInfoContract;
import id.dana.data.dynamicurl.DynamicUrlWrapper;

/* loaded from: classes5.dex */
public final class BalanceQrisPayFragment_MembersInjector implements MembersInjector<BalanceQrisPayFragment> {
    public static void BuiltInFictitiousFunctionClassFactory(BalanceQrisPayFragment balanceQrisPayFragment, ChangePayMethodContract.Presenter presenter) {
        balanceQrisPayFragment.changePayMethodPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(BalanceQrisPayFragment balanceQrisPayFragment, DynamicUrlWrapper dynamicUrlWrapper) {
        balanceQrisPayFragment.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void getAuthRequestContext(BalanceQrisPayFragment balanceQrisPayFragment, GetUserInfoContract.Presenter presenter) {
        balanceQrisPayFragment.getUserInfoPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(BalanceQrisPayFragment balanceQrisPayFragment, OfflinePayContract.Presenter presenter) {
        balanceQrisPayFragment.offlinePayPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(BalanceQrisPayFragment balanceQrisPayFragment, PayQrContract.Presenter presenter) {
        balanceQrisPayFragment.payQrPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(BalanceQrisPayFragment balanceQrisPayFragment, GetPaymentResultContract.Presenter presenter) {
        balanceQrisPayFragment.getPaymentResultPresenter = presenter;
    }
}

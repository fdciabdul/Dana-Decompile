package id.dana.pay;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.cashier.CashierContract;

/* loaded from: classes5.dex */
public final class PayActivity_MembersInjector implements MembersInjector<PayActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(PayActivity payActivity, Lazy<CashierContract.Presenter> lazy) {
        payActivity.cashierPresenter = lazy;
    }
}

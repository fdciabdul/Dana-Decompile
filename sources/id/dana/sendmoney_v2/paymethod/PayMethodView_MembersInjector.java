package id.dana.sendmoney_v2.paymethod;

import dagger.MembersInjector;
import id.dana.contract.sendmoney.PayMethodContract;
import id.dana.sendmoney.paymethod.PayMethodAdapter;

/* loaded from: classes5.dex */
public final class PayMethodView_MembersInjector implements MembersInjector<PayMethodView> {
    public static void PlaceComponentResult(PayMethodView payMethodView, PayMethodContract.Presenter presenter) {
        payMethodView.presenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(PayMethodView payMethodView, PayMethodAdapter payMethodAdapter) {
        payMethodView.payMethodAdapter = payMethodAdapter;
    }
}

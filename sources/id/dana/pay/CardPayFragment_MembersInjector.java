package id.dana.pay;

import dagger.MembersInjector;
import id.dana.contract.payasset.ChangePayMethodContract;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.contract.payqr.PayQrContract;

/* loaded from: classes5.dex */
public final class CardPayFragment_MembersInjector implements MembersInjector<CardPayFragment> {
    public static void BuiltInFictitiousFunctionClassFactory(CardPayFragment cardPayFragment, ChangePayMethodContract.Presenter presenter) {
        cardPayFragment.changePayMethodPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(CardPayFragment cardPayFragment, OfflinePayContract.Presenter presenter) {
        cardPayFragment.offlinePayPresenter = presenter;
    }

    public static void PlaceComponentResult(CardPayFragment cardPayFragment, PayQrContract.Presenter presenter) {
        cardPayFragment.payQrPresenter = presenter;
    }
}

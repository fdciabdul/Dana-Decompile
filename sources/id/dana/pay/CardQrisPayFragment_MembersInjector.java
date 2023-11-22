package id.dana.pay;

import dagger.MembersInjector;
import id.dana.contract.payasset.ChangePayMethodContract;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.contract.payqr.PayQrContract;

/* loaded from: classes5.dex */
public final class CardQrisPayFragment_MembersInjector implements MembersInjector<CardQrisPayFragment> {
    public static void PlaceComponentResult(CardQrisPayFragment cardQrisPayFragment, ChangePayMethodContract.Presenter presenter) {
        cardQrisPayFragment.changePayMethodPresenter = presenter;
    }

    public static void getAuthRequestContext(CardQrisPayFragment cardQrisPayFragment, OfflinePayContract.Presenter presenter) {
        cardQrisPayFragment.offlinePayPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(CardQrisPayFragment cardQrisPayFragment, PayQrContract.Presenter presenter) {
        cardQrisPayFragment.payQrPresenter = presenter;
    }
}

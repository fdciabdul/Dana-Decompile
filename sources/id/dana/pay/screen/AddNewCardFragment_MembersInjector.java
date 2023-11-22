package id.dana.pay.screen;

import dagger.MembersInjector;
import id.dana.contract.payasset.AddNewCardContract;
import id.dana.contract.payqr.OfflinePayContract;

/* loaded from: classes5.dex */
public final class AddNewCardFragment_MembersInjector implements MembersInjector<AddNewCardFragment> {
    public static void getAuthRequestContext(AddNewCardFragment addNewCardFragment, AddNewCardContract.Presenter presenter) {
        addNewCardFragment.addNewCardPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(AddNewCardFragment addNewCardFragment, OfflinePayContract.Presenter presenter) {
        addNewCardFragment.offlinePayPresenter = presenter;
    }
}

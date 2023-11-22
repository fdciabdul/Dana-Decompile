package id.dana.richview.contactselector;

import dagger.MembersInjector;
import id.dana.contract.contact.DanaContactContract;

/* loaded from: classes5.dex */
public final class ContactSelectorView_MembersInjector implements MembersInjector<ContactSelectorView> {
    public static void MyBillsEntityDataFactory(ContactSelectorView contactSelectorView, DanaContactContract.Presenter presenter) {
        contactSelectorView.danaContactPresenter = presenter;
    }
}

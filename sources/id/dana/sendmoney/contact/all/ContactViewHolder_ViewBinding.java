package id.dana.sendmoney.contact.all;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.sendmoney.recipient.view.ContactRichView;

/* loaded from: classes9.dex */
public class ContactViewHolder_ViewBinding implements Unbinder {
    private ContactViewHolder KClassImpl$Data$declaredNonStaticMembers$2;

    public ContactViewHolder_ViewBinding(ContactViewHolder contactViewHolder, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = contactViewHolder;
        contactViewHolder.contactRichView = (ContactRichView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.crv_contact, "field 'contactRichView'", ContactRichView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ContactViewHolder contactViewHolder = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (contactViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        contactViewHolder.contactRichView = null;
    }
}

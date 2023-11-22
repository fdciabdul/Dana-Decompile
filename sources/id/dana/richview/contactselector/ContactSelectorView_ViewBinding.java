package id.dana.richview.contactselector;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.LogoProgressView;

/* loaded from: classes9.dex */
public class ContactSelectorView_ViewBinding implements Unbinder {
    private ContactSelectorView BuiltInFictitiousFunctionClassFactory;

    public ContactSelectorView_ViewBinding(ContactSelectorView contactSelectorView, View view) {
        this.BuiltInFictitiousFunctionClassFactory = contactSelectorView;
        contactSelectorView.rvContactList = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rv_contact_list, "field 'rvContactList'", RecyclerView.class);
        contactSelectorView.llLoadingContact = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_loading_contact, "field 'llLoadingContact'", LinearLayout.class);
        contactSelectorView.lpvContact = (LogoProgressView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.lpv_contact, "field 'lpvContact'", LogoProgressView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ContactSelectorView contactSelectorView = this.BuiltInFictitiousFunctionClassFactory;
        if (contactSelectorView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        contactSelectorView.rvContactList = null;
        contactSelectorView.llLoadingContact = null;
        contactSelectorView.lpvContact = null;
    }
}

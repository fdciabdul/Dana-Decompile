package id.dana.sendmoney.contact.all;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.EmptyState;

/* loaded from: classes9.dex */
public class NoContactPermissionViewHolder_ViewBinding implements Unbinder {
    private NoContactPermissionViewHolder MyBillsEntityDataFactory;

    public NoContactPermissionViewHolder_ViewBinding(NoContactPermissionViewHolder noContactPermissionViewHolder, View view) {
        this.MyBillsEntityDataFactory = noContactPermissionViewHolder;
        noContactPermissionViewHolder.esContact = (EmptyState) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.es_contact, "field 'esContact'", EmptyState.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        NoContactPermissionViewHolder noContactPermissionViewHolder = this.MyBillsEntityDataFactory;
        if (noContactPermissionViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        noContactPermissionViewHolder.esContact = null;
    }
}

package id.dana.sendmoney.bank.all;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class CollapsibleSavedBankViewHolder_ViewBinding implements Unbinder {
    private CollapsibleSavedBankViewHolder MyBillsEntityDataFactory;

    public CollapsibleSavedBankViewHolder_ViewBinding(CollapsibleSavedBankViewHolder collapsibleSavedBankViewHolder, View view) {
        this.MyBillsEntityDataFactory = collapsibleSavedBankViewHolder;
        collapsibleSavedBankViewHolder.tvCollapsibleBank = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_collapsible_bank, "field 'tvCollapsibleBank'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        CollapsibleSavedBankViewHolder collapsibleSavedBankViewHolder = this.MyBillsEntityDataFactory;
        if (collapsibleSavedBankViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        collapsibleSavedBankViewHolder.tvCollapsibleBank = null;
    }
}

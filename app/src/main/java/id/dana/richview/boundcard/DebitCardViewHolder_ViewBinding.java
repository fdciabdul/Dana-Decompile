package id.dana.richview.boundcard;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class DebitCardViewHolder_ViewBinding implements Unbinder {
    private DebitCardViewHolder MyBillsEntityDataFactory;

    public DebitCardViewHolder_ViewBinding(DebitCardViewHolder debitCardViewHolder, View view) {
        this.MyBillsEntityDataFactory = debitCardViewHolder;
        debitCardViewHolder.debitCard = (DebitCardView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.debit_card, "field 'debitCard'", DebitCardView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        DebitCardViewHolder debitCardViewHolder = this.MyBillsEntityDataFactory;
        if (debitCardViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        debitCardViewHolder.debitCard = null;
    }
}

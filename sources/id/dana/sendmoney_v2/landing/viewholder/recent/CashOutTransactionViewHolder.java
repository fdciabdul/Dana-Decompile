package id.dana.sendmoney_v2.landing.viewholder.recent;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.sendmoney.model.RecentRecipientModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/sendmoney_v2/landing/viewholder/recent/CashOutTransactionViewHolder;", "Lid/dana/sendmoney_v2/landing/viewholder/recent/TransactionViewHolder;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CashOutTransactionViewHolder extends TransactionViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashOutTransactionViewHolder(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(RecentRecipientModel recentRecipientModel) {
        if (recentRecipientModel != null) {
            String string = getContext().getString(R.string.cashier);
            if (string == null) {
                string = "";
            }
            getAuthRequestContext(string);
            TransactionViewHolder.MyBillsEntityDataFactory(this, null, Integer.valueOf((int) R.drawable.ic_p2c), 1);
        }
    }
}

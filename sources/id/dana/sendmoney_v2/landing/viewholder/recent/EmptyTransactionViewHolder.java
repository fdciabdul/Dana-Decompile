package id.dana.sendmoney_v2.landing.viewholder.recent;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.sendmoney.model.RecentRecipientModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney_v2/landing/viewholder/recent/EmptyTransactionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/sendmoney/model/RecentRecipientModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmptyTransactionViewHolder extends BaseRecyclerViewHolder<RecentRecipientModel> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyTransactionViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_recent_transaction_empty, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}

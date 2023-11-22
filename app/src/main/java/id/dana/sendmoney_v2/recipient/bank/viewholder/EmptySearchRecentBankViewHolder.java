package id.dana.sendmoney_v2.recipient.bank.viewholder;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.sendmoney.model.RecipientViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney_v2/recipient/bank/viewholder/EmptySearchRecentBankViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/sendmoney/model/RecipientViewModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmptySearchRecentBankViewHolder extends BaseRecyclerViewHolder<RecipientViewModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ViewGroup BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(RecipientViewModel recipientViewModel) {
        Intrinsics.checkNotNullParameter(recipientViewModel, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptySearchRecentBankViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_empty_search_recent_bank, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.BuiltInFictitiousFunctionClassFactory = viewGroup;
    }
}

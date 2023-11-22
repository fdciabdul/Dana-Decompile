package id.dana.sendmoney_v2.landing.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney_v2.landing.view.RecipientHoldClickActionListener;
import id.dana.sendmoney_v2.landing.viewholder.MoreTransactionViewHolder;
import id.dana.sendmoney_v2.landing.viewholder.recent.BankTransactionViewHolder;
import id.dana.sendmoney_v2.landing.viewholder.recent.CashOutTransactionViewHolder;
import id.dana.sendmoney_v2.landing.viewholder.recent.ContactTransactionViewHolder;
import id.dana.sendmoney_v2.landing.viewholder.recent.EmptyTransactionViewHolder;
import id.dana.sendmoney_v2.landing.viewholder.recent.GroupTransactionViewHolder;
import id.dana.sendmoney_v2.landing.viewholder.recent.LinkTransactionViewHolder;
import id.dana.sendmoney_v2.landing.viewholder.recent.ScannerTransactionViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney_v2/landing/adapter/RecentTransactionAdapter;", "Lid/dana/sendmoney_v2/landing/adapter/ExpandableAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/sendmoney/model/RecentRecipientModel;", "", "p0", "getItemViewType", "(I)I", "Lid/dana/sendmoney_v2/landing/view/RecipientHoldClickActionListener;", "getAuthRequestContext", "Lid/dana/sendmoney_v2/landing/view/RecipientHoldClickActionListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "p1", "<init>", "(IZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecentTransactionAdapter extends ExpandableAdapter<BaseRecyclerViewHolder<RecentRecipientModel>, RecentRecipientModel> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public RecipientHoldClickActionListener KClassImpl$Data$declaredNonStaticMembers$2;

    public /* synthetic */ RecentTransactionAdapter(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? false : z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        EmptyTransactionViewHolder emptyTransactionViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        switch (i) {
            case -1:
            case 1:
                emptyTransactionViewHolder = new EmptyTransactionViewHolder(viewGroup);
                break;
            case 0:
                emptyTransactionViewHolder = new ScannerTransactionViewHolder(viewGroup);
                break;
            case 2:
                emptyTransactionViewHolder = new ContactTransactionViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2);
                break;
            case 3:
                emptyTransactionViewHolder = new LinkTransactionViewHolder(viewGroup);
                break;
            case 4:
                emptyTransactionViewHolder = new BankTransactionViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2);
                break;
            case 5:
                emptyTransactionViewHolder = new CashOutTransactionViewHolder(viewGroup);
                break;
            case 6:
            case 7:
                emptyTransactionViewHolder = new GroupTransactionViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2);
                break;
            default:
                emptyTransactionViewHolder = new MoreTransactionViewHolder(viewGroup);
                break;
        }
        return emptyTransactionViewHolder;
    }

    private RecentTransactionAdapter(int i, boolean z) {
        super(2, i, z, false, 8, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        RecentRecipientModel item;
        if (MyBillsEntityDataFactory()) {
            return -1;
        }
        if (getAuthRequestContext(p0) || (item = getItem(p0)) == null) {
            return -2;
        }
        return item.isLayoutRequested;
    }
}

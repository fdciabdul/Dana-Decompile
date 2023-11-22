package id.dana.sendmoney_v2.landing.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.sendmoney_v2.landing.adapter.ExpandableAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney_v2/landing/viewholder/MoreTransactionViewHolder;", "T", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "PlaceComponentResult", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MoreTransactionViewHolder<T> extends BaseRecyclerViewHolder<T> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ViewGroup PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreTransactionViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_recent_transaction_more, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.PlaceComponentResult = viewGroup;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.landing.viewholder.MoreTransactionViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoreTransactionViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(MoreTransactionViewHolder.this);
            }
        });
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MoreTransactionViewHolder moreTransactionViewHolder) {
        Intrinsics.checkNotNullParameter(moreTransactionViewHolder, "");
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> bindingAdapter = moreTransactionViewHolder.getBindingAdapter();
        ExpandableAdapter expandableAdapter = bindingAdapter instanceof ExpandableAdapter ? (ExpandableAdapter) bindingAdapter : null;
        if (expandableAdapter != null) {
            expandableAdapter.getAuthRequestContext();
        }
        ViewParent parent = moreTransactionViewHolder.PlaceComponentResult.getParent();
        ViewParent parent2 = parent != null ? parent.getParent() : null;
        ViewGroup viewGroup = parent2 instanceof ViewGroup ? parent2 : null;
        if (viewGroup != null) {
            AutoTransition autoTransition = new AutoTransition();
            autoTransition.setInterpolator(new DecelerateInterpolator());
            TransitionManager.getAuthRequestContext(viewGroup, autoTransition);
        }
    }
}

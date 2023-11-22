package id.dana.mybills.viewholder;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.common.ProfileDividerItemDecoration;
import id.dana.mybills.adapter.BillsPaymentAdapter;
import id.dana.mybills.listener.GroupedBillPaymentsListener;
import id.dana.mybills.model.BillPaymentAdapterModel;
import id.dana.utils.CustomLinearLayoutManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\r"}, d2 = {"Lid/dana/mybills/viewholder/BillPaymentStatusGroupViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/mybills/model/BillPaymentAdapterModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Lid/dana/mybills/adapter/BillsPaymentAdapter;", "getAuthRequestContext", "Lid/dana/mybills/adapter/BillsPaymentAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/listener/GroupedBillPaymentsListener;", "Lid/dana/mybills/listener/GroupedBillPaymentsListener;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BillPaymentStatusGroupViewHolder extends BaseRecyclerViewHolder<BillPaymentAdapterModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private GroupedBillPaymentsListener MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private BillsPaymentAdapter BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(BillPaymentAdapterModel billPaymentAdapterModel) {
        final BillPaymentAdapterModel billPaymentAdapterModel2 = billPaymentAdapterModel;
        if (billPaymentAdapterModel2 != null) {
            List<BillPaymentAdapterModel> list = billPaymentAdapterModel2.MyBillsEntityDataFactory;
            if (list == null || list.isEmpty()) {
                return;
            }
            BillsPaymentAdapter billsPaymentAdapter = new BillsPaymentAdapter();
            this.BuiltInFictitiousFunctionClassFactory = billsPaymentAdapter;
            billsPaymentAdapter.setOnItemClickListener(new GroupedBillPaymentsListener() { // from class: id.dana.mybills.viewholder.BillPaymentStatusGroupViewHolder$bindData$1
                @Override // id.dana.mybills.listener.GroupedBillPaymentsListener, id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
                public final void onItemClick(int p0) {
                    GroupedBillPaymentsListener groupedBillPaymentsListener;
                    BillPaymentAdapterModel billPaymentAdapterModel3 = BillPaymentAdapterModel.this.MyBillsEntityDataFactory.get(p0);
                    groupedBillPaymentsListener = this.MyBillsEntityDataFactory;
                    if (groupedBillPaymentsListener != null) {
                        groupedBillPaymentsListener.PlaceComponentResult(billPaymentAdapterModel3);
                    }
                }

                @Override // id.dana.mybills.listener.GroupedBillPaymentsListener
                public final void PlaceComponentResult(BillPaymentAdapterModel p0) {
                    GroupedBillPaymentsListener groupedBillPaymentsListener;
                    groupedBillPaymentsListener = this.MyBillsEntityDataFactory;
                    if (groupedBillPaymentsListener != null) {
                        groupedBillPaymentsListener.PlaceComponentResult(p0);
                    }
                }

                @Override // id.dana.mybills.listener.GroupedBillPaymentsListener
                public final void PlaceComponentResult(int p0, boolean p1) {
                    GroupedBillPaymentsListener groupedBillPaymentsListener;
                    BillPaymentAdapterModel billPaymentAdapterModel3 = BillPaymentAdapterModel.this.MyBillsEntityDataFactory.get(p0);
                    groupedBillPaymentsListener = this.MyBillsEntityDataFactory;
                    if (groupedBillPaymentsListener != null) {
                        groupedBillPaymentsListener.PlaceComponentResult(billPaymentAdapterModel3, p1);
                    }
                }

                @Override // id.dana.mybills.listener.GroupedBillPaymentsListener
                public final void PlaceComponentResult(BillPaymentAdapterModel p0, boolean p1) {
                    GroupedBillPaymentsListener groupedBillPaymentsListener;
                    groupedBillPaymentsListener = this.MyBillsEntityDataFactory;
                    if (groupedBillPaymentsListener != null) {
                        groupedBillPaymentsListener.PlaceComponentResult(p0, p1);
                    }
                }

                @Override // id.dana.mybills.listener.GroupedBillPaymentsListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
                    GroupedBillPaymentsListener groupedBillPaymentsListener;
                    BillPaymentAdapterModel billPaymentAdapterModel3 = BillPaymentAdapterModel.this.MyBillsEntityDataFactory.get(p0);
                    RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((RecyclerView) this.itemView.findViewById(R.id.rvBillPaymentGroup)).findViewHolderForLayoutPosition(p0);
                    groupedBillPaymentsListener = this.MyBillsEntityDataFactory;
                    if (groupedBillPaymentsListener != null) {
                        groupedBillPaymentsListener.PlaceComponentResult(billPaymentAdapterModel3, findViewHolderForLayoutPosition);
                    }
                }

                @Override // id.dana.mybills.listener.GroupedBillPaymentsListener
                public final void PlaceComponentResult(BillPaymentAdapterModel p0, RecyclerView.ViewHolder p1) {
                    GroupedBillPaymentsListener groupedBillPaymentsListener;
                    groupedBillPaymentsListener = this.MyBillsEntityDataFactory;
                    if (groupedBillPaymentsListener != null) {
                        groupedBillPaymentsListener.PlaceComponentResult(p0, p1);
                    }
                }

                @Override // id.dana.mybills.listener.GroupedBillPaymentsListener
                public final void MyBillsEntityDataFactory(int p0) {
                    GroupedBillPaymentsListener groupedBillPaymentsListener;
                    BillPaymentAdapterModel billPaymentAdapterModel3 = BillPaymentAdapterModel.this.MyBillsEntityDataFactory.get(p0);
                    RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((RecyclerView) this.itemView.findViewById(R.id.rvBillPaymentGroup)).findViewHolderForLayoutPosition(p0);
                    groupedBillPaymentsListener = this.MyBillsEntityDataFactory;
                    if (groupedBillPaymentsListener != null) {
                        groupedBillPaymentsListener.KClassImpl$Data$declaredNonStaticMembers$2(billPaymentAdapterModel3, findViewHolderForLayoutPosition);
                    }
                }

                @Override // id.dana.mybills.listener.GroupedBillPaymentsListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(BillPaymentAdapterModel p0, RecyclerView.ViewHolder p1) {
                    GroupedBillPaymentsListener groupedBillPaymentsListener;
                    groupedBillPaymentsListener = this.MyBillsEntityDataFactory;
                    if (groupedBillPaymentsListener != null) {
                        groupedBillPaymentsListener.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
                    }
                }
            });
            RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R.id.rvBillPaymentGroup);
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(this.BuiltInFictitiousFunctionClassFactory);
                ProfileDividerItemDecoration profileDividerItemDecoration = new ProfileDividerItemDecoration(recyclerView.getContext());
                Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(recyclerView.getContext(), (int) R.drawable.divider_drawable);
                if (PlaceComponentResult == null) {
                    return;
                }
                if (PlaceComponentResult == null) {
                    throw new IllegalArgumentException("Drawable cannot be null.");
                }
                profileDividerItemDecoration.MyBillsEntityDataFactory = PlaceComponentResult;
                recyclerView.addItemDecoration(profileDividerItemDecoration);
            }
            BillsPaymentAdapter billsPaymentAdapter2 = this.BuiltInFictitiousFunctionClassFactory;
            if (billsPaymentAdapter2 != null) {
                billsPaymentAdapter2.setItems(billPaymentAdapterModel2.MyBillsEntityDataFactory);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillPaymentStatusGroupViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_bill_payment_group, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
        this.MyBillsEntityDataFactory = p0 instanceof GroupedBillPaymentsListener ? (GroupedBillPaymentsListener) p0 : null;
    }
}

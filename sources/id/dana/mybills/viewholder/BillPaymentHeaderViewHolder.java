package id.dana.mybills.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.mybills.model.BillPaymentAdapterModel;
import id.dana.mybills.model.BillsPaymentHeaderModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/mybills/viewholder/BillPaymentHeaderViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/mybills/model/BillPaymentAdapterModel;", "Landroid/view/ViewGroup;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "getAuthRequestContext", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BillPaymentHeaderViewHolder extends BaseRecyclerViewHolder<BillPaymentAdapterModel> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final ViewGroup getAuthRequestContext;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(BillPaymentAdapterModel billPaymentAdapterModel) {
        BillsPaymentHeaderModel billsPaymentHeaderModel;
        BillPaymentAdapterModel billPaymentAdapterModel2 = billPaymentAdapterModel;
        View view = this.itemView;
        if (billPaymentAdapterModel2 == null || (billsPaymentHeaderModel = billPaymentAdapterModel2.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.tvBillHeaderTitle);
        if (textView != null) {
            textView.setText(billsPaymentHeaderModel.PlaceComponentResult);
        }
        if (billsPaymentHeaderModel.BuiltInFictitiousFunctionClassFactory > 0) {
            Group group = (Group) view.findViewById(R.id.groupBillsAmount);
            if (group != null) {
                group.setVisibility(0);
            }
            TextView textView2 = (TextView) view.findViewById(R.id.tvBillsAmount);
            if (textView2 != null) {
                textView2.setText(String.valueOf(billsPaymentHeaderModel.BuiltInFictitiousFunctionClassFactory));
            }
        } else {
            Group group2 = (Group) view.findViewById(R.id.groupBillsAmount);
            if (group2 != null) {
                group2.setVisibility(8);
            }
        }
        TextView textView3 = (TextView) view.findViewById(R.id.res_0x7f0a13a3_newsocialfeedsadapter_oncreateviewholder_1);
        if (textView3 != null) {
            textView3.setVisibility(billsPaymentHeaderModel.getGetAuthRequestContext() ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillPaymentHeaderViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_bill_payment_view, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.getAuthRequestContext = viewGroup;
    }
}

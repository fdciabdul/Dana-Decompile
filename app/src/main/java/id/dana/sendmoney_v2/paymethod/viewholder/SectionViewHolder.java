package id.dana.sendmoney_v2.paymethod.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.model.PayMethodModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney_v2/paymethod/viewholder/SectionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/model/PayMethodModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SectionViewHolder extends BaseRecyclerViewHolder<PayMethodModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(PayMethodModel payMethodModel) {
        PayMethodModel payMethodModel2 = payMethodModel;
        if (payMethodModel2 != null) {
            String str = payMethodModel2.NetworkUserEntityData$$ExternalSyntheticLambda8;
            Intrinsics.checkNotNullExpressionValue(str, "");
            ((TextView) this.itemView.findViewById(R.id.setDrawValueAboveBar)).setText(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SectionViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_paymethod_section_v2, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}

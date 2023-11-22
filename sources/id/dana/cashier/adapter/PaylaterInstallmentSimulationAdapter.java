package id.dana.cashier.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.cashier.model.RepaymentInfoModel;
import id.dana.cashier.viewholder.PaylaterInstallmentSimulationViewHolder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/cashier/adapter/PaylaterInstallmentSimulationAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/cashier/viewholder/PaylaterInstallmentSimulationViewHolder;", "Lid/dana/cashier/model/RepaymentInfoModel;", "", "p0", "", "PlaceComponentResult", "(I)Ljava/lang/String;", "p1", "", "MyBillsEntityDataFactory", "(Lid/dana/cashier/viewholder/PaylaterInstallmentSimulationViewHolder;I)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterInstallmentSimulationAdapter extends BaseRecyclerViewAdapter<PaylaterInstallmentSimulationViewHolder, RepaymentInfoModel> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        return new PaylaterInstallmentSimulationViewHolder(context, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // id.dana.base.BaseRecyclerViewAdapter
    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(PaylaterInstallmentSimulationViewHolder p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        AppCompatTextView appCompatTextView = (AppCompatTextView) p0.itemView.findViewById(R.id.tv_period);
        if (appCompatTextView != null) {
            String string = p0.getContext().getString(R.string.installment_simulation_period);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{PlaceComponentResult(p1 + 1)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            appCompatTextView.setText(format);
        }
        super.onBindViewHolder((PaylaterInstallmentSimulationAdapter) p0, p1);
    }

    private static String PlaceComponentResult(int p0) {
        if (p0 < 10) {
            StringBuilder sb = new StringBuilder();
            sb.append('0');
            sb.append(p0);
            return sb.toString();
        }
        return String.valueOf(p0);
    }
}

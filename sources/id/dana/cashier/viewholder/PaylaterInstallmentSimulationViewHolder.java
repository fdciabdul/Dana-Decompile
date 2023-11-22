package id.dana.cashier.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.RepaymentInfoModel;
import id.dana.databinding.ItemInstallmentSimulationBinding;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/cashier/viewholder/PaylaterInstallmentSimulationViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/RepaymentInfoModel;", "Lid/dana/databinding/ItemInstallmentSimulationBinding;", "Landroid/content/Context;", "p0", "", "p1", "Landroid/view/ViewGroup;", "p2", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterInstallmentSimulationViewHolder extends ViewBindingRecyclerViewHolder<RepaymentInfoModel, ItemInstallmentSimulationBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        String str;
        String format;
        RepaymentInfoModel repaymentInfoModel = (RepaymentInfoModel) obj;
        if (repaymentInfoModel != null) {
            getBinding().MyBillsEntityDataFactory.setText(DateTimeUtil.MyBillsEntityDataFactory("yyyy-MM-dd", "dd MMM yyyy", LocaleUtil.getAuthRequestContext(), repaymentInfoModel.scheduleImpl));
            AppCompatTextView appCompatTextView = getBinding().BuiltInFictitiousFunctionClassFactory;
            MoneyViewModel moneyViewModel = repaymentInfoModel.KClassImpl$Data$declaredNonStaticMembers$2;
            if (moneyViewModel != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                format = NumberFormat.getNumberInstance(id.dana.core.ui.util.LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
                if (format == null) {
                    format = "";
                }
                sb.append(format);
                str = sb.toString();
            } else {
                str = null;
            }
            appCompatTextView.setText(str);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemInstallmentSimulationBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemInstallmentSimulationBinding PlaceComponentResult = ItemInstallmentSimulationBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaylaterInstallmentSimulationViewHolder(Context context, ViewGroup viewGroup) {
        super(context, R.layout.item_installment_simulation, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}

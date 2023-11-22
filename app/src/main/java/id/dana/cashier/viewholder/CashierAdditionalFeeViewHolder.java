package id.dana.cashier.viewholder;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.AdditionalFeeModel;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.databinding.ItemAdditionalFeeConfirmationBinding;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cashier/viewholder/CashierAdditionalFeeViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/AdditionalFeeModel;", "Lid/dana/databinding/ItemAdditionalFeeConfirmationBinding;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierAdditionalFeeViewHolder extends ViewBindingRecyclerViewHolder<AdditionalFeeModel, ItemAdditionalFeeConfirmationBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        String string;
        String format;
        AdditionalFeeModel additionalFeeModel = (AdditionalFeeModel) obj;
        if (additionalFeeModel != null) {
            getBinding().MyBillsEntityDataFactory.setText(additionalFeeModel.MyBillsEntityDataFactory);
            AppCompatTextView appCompatTextView = getBinding().BuiltInFictitiousFunctionClassFactory;
            if (additionalFeeModel.BuiltInFictitiousFunctionClassFactory == null) {
                string = getContext().getString(R.string.sendmoney_confirmation_free);
            } else {
                MoneyViewModel moneyViewModel = additionalFeeModel.BuiltInFictitiousFunctionClassFactory;
                StringBuilder sb = new StringBuilder();
                sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
                if (format == null) {
                    format = "";
                }
                sb.append(format);
                string = sb.toString();
            }
            appCompatTextView.setText(string);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemAdditionalFeeConfirmationBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemAdditionalFeeConfirmationBinding PlaceComponentResult = ItemAdditionalFeeConfirmationBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CashierAdditionalFeeViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559035(0x7f0d027b, float:1.8743403E38)
            r2.<init>(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.CashierAdditionalFeeViewHolder.<init>(android.view.ViewGroup):void");
    }
}

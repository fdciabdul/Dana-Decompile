package id.dana.cashier.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.PaylaterBillDetailModel;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.databinding.ItemBillDetailPaylaterBinding;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/cashier/viewholder/PaylaterBillDetailViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/PaylaterBillDetailModel;", "Lid/dana/databinding/ItemBillDetailPaylaterBinding;", "Landroid/content/Context;", "p0", "", "p1", "Landroid/view/ViewGroup;", "p2", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterBillDetailViewHolder extends ViewBindingRecyclerViewHolder<PaylaterBillDetailModel, ItemBillDetailPaylaterBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        String str;
        String format;
        PaylaterBillDetailModel paylaterBillDetailModel = (PaylaterBillDetailModel) obj;
        if (paylaterBillDetailModel != null) {
            ItemBillDetailPaylaterBinding binding = getBinding();
            binding.BuiltInFictitiousFunctionClassFactory.initLine(paylaterBillDetailModel.KClassImpl$Data$declaredNonStaticMembers$2);
            binding.lookAheadTest.setText(paylaterBillDetailModel.PlaceComponentResult);
            binding.PlaceComponentResult.setText(paylaterBillDetailModel.BuiltInFictitiousFunctionClassFactory);
            AppCompatTextView appCompatTextView = binding.KClassImpl$Data$declaredNonStaticMembers$2;
            MoneyViewModel moneyViewModel = paylaterBillDetailModel.getAuthRequestContext;
            if (moneyViewModel != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
                if (format == null) {
                    format = "";
                }
                sb.append(format);
                str = sb.toString();
            } else {
                str = null;
            }
            appCompatTextView.setText(str);
            AppCompatTextView appCompatTextView2 = binding.lookAheadTest;
            Context context = getContext();
            String string = context != null ? context.getString(R.string.sdet_lbl_bill, String.valueOf(getAbsoluteAdapterPosition())) : null;
            if (string == null) {
                string = "";
            }
            appCompatTextView2.setContentDescription(string);
            AppCompatTextView appCompatTextView3 = binding.PlaceComponentResult;
            Context context2 = getContext();
            String string2 = context2 != null ? context2.getString(R.string.sdet_lbl_due_date_bill, String.valueOf(getAbsoluteAdapterPosition())) : null;
            if (string2 == null) {
                string2 = "";
            }
            appCompatTextView3.setContentDescription(string2);
            AppCompatTextView appCompatTextView4 = binding.KClassImpl$Data$declaredNonStaticMembers$2;
            Context context3 = getContext();
            String string3 = context3 != null ? context3.getString(R.string.sdet_lbl_amount_bill, String.valueOf(getAbsoluteAdapterPosition())) : null;
            appCompatTextView4.setContentDescription(string3 != null ? string3 : "");
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemBillDetailPaylaterBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemBillDetailPaylaterBinding authRequestContext = ItemBillDetailPaylaterBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaylaterBillDetailViewHolder(Context context, ViewGroup viewGroup) {
        super(context, R.layout.item_bill_detail_paylater, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}

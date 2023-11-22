package id.dana.cashier.viewholder;

import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.AddOnChannelSupportInfo;
import id.dana.cashier.model.CashierOrderGoodModel;
import id.dana.cashier.model.CashierOrderGoodModelKt;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.databinding.ItemCashierAddOnBinding;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BU\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004\u0012*\u0010\u000f\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R&\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR8\u0010\b\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/cashier/viewholder/CashierAddOnViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/CashierOrderGoodModel;", "Lid/dana/databinding/ItemCashierAddOnBinding;", "Lkotlin/Function2;", "", "", "", "getAuthRequestContext", "Lkotlin/jvm/functions/Function2;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function5;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function5;", "p0", "p1", "Landroid/view/ViewGroup;", "p2", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierAddOnViewHolder extends ViewBindingRecyclerViewHolder<CashierOrderGoodModel, ItemCashierAddOnBinding> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function5<String, String, String, Boolean, String, Unit> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function2<String, Boolean, Unit> BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        String format;
        final CashierOrderGoodModel cashierOrderGoodModel = (CashierOrderGoodModel) obj;
        if (cashierOrderGoodModel != null) {
            ItemCashierAddOnBinding binding = getBinding();
            binding.getAuthRequestContext.setText(cashierOrderGoodModel.DatabaseTableConfigUtil);
            binding.MyBillsEntityDataFactory.setText(cashierOrderGoodModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
            String str = null;
            if (!CashierOrderGoodModelKt.BuiltInFictitiousFunctionClassFactory(cashierOrderGoodModel) && !CashierOrderGoodModelKt.PlaceComponentResult(cashierOrderGoodModel)) {
                AppCompatTextView appCompatTextView = binding.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                AppCompatTextView appCompatTextView2 = appCompatTextView;
                AddOnChannelSupportInfo addOnChannelSupportInfo = cashierOrderGoodModel.KClassImpl$Data$declaredNonStaticMembers$2;
                String str2 = addOnChannelSupportInfo != null ? addOnChannelSupportInfo.MyBillsEntityDataFactory : null;
                appCompatTextView2.setVisibility((str2 == null || str2.length() == 0) ^ true ? 0 : 8);
                AppCompatTextView appCompatTextView3 = binding.MyBillsEntityDataFactory;
                AddOnChannelSupportInfo addOnChannelSupportInfo2 = cashierOrderGoodModel.KClassImpl$Data$declaredNonStaticMembers$2;
                String str3 = addOnChannelSupportInfo2 != null ? addOnChannelSupportInfo2.MyBillsEntityDataFactory : null;
                if (str3 == null) {
                    str3 = "";
                }
                appCompatTextView3.setText(str3);
                binding.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
                binding.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
                binding.PlaceComponentResult.setEnabled(CashierOrderGoodModelKt.KClassImpl$Data$declaredNonStaticMembers$2(cashierOrderGoodModel) && CashierOrderGoodModelKt.PlaceComponentResult(cashierOrderGoodModel));
                binding.PlaceComponentResult.setChecked(CashierOrderGoodModelKt.getAuthRequestContext(cashierOrderGoodModel) && CashierOrderGoodModelKt.PlaceComponentResult(cashierOrderGoodModel));
            } else {
                AppCompatTextView appCompatTextView4 = binding.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView4, "");
                AppCompatTextView appCompatTextView5 = appCompatTextView4;
                String str4 = cashierOrderGoodModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                appCompatTextView5.setVisibility(true ^ (str4 == null || str4.length() == 0) ? 0 : 8);
                binding.MyBillsEntityDataFactory.setText(cashierOrderGoodModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
                binding.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
                binding.BuiltInFictitiousFunctionClassFactory.setVisibility(0);
                binding.PlaceComponentResult.setEnabled(CashierOrderGoodModelKt.KClassImpl$Data$declaredNonStaticMembers$2(cashierOrderGoodModel));
                binding.PlaceComponentResult.setChecked(CashierOrderGoodModelKt.getAuthRequestContext(cashierOrderGoodModel));
            }
            AppCompatTextView appCompatTextView6 = binding.BuiltInFictitiousFunctionClassFactory;
            MoneyViewModel moneyViewModel = cashierOrderGoodModel.getAuthRequestContext;
            if (moneyViewModel != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
                sb.append(format != null ? format : "");
                str = sb.toString();
            }
            appCompatTextView6.setText(str);
            final AppCompatCheckBox appCompatCheckBox = binding.PlaceComponentResult;
            appCompatCheckBox.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.viewholder.CashierAddOnViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CashierAddOnViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(CashierAddOnViewHolder.this, cashierOrderGoodModel, appCompatCheckBox);
                }
            });
            appCompatCheckBox.setContentDescription(appCompatCheckBox.getContext().getString(R.string.checkbox_additionals));
            binding.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.viewholder.CashierAddOnViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CashierAddOnViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(CashierAddOnViewHolder.this, cashierOrderGoodModel);
                }
            });
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemCashierAddOnBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemCashierAddOnBinding KClassImpl$Data$declaredNonStaticMembers$2 = ItemCashierAddOnBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CashierAddOnViewHolder(kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> r3, kotlin.jvm.functions.Function5<? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> r4, android.view.ViewGroup r5) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.Context r1 = r5.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559067(0x7f0d029b, float:1.8743468E38)
            r2.<init>(r1, r0, r5)
            r2.BuiltInFictitiousFunctionClassFactory = r3
            r2.getAuthRequestContext = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.CashierAddOnViewHolder.<init>(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function5, android.view.ViewGroup):void");
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CashierAddOnViewHolder cashierAddOnViewHolder, CashierOrderGoodModel cashierOrderGoodModel, AppCompatCheckBox appCompatCheckBox) {
        Intrinsics.checkNotNullParameter(cashierAddOnViewHolder, "");
        Intrinsics.checkNotNullParameter(cashierOrderGoodModel, "");
        Intrinsics.checkNotNullParameter(appCompatCheckBox, "");
        Function2<String, Boolean, Unit> function2 = cashierAddOnViewHolder.BuiltInFictitiousFunctionClassFactory;
        String str = cashierOrderGoodModel.MyBillsEntityDataFactory;
        function2.invoke(str != null ? str : "", Boolean.valueOf(appCompatCheckBox.isChecked()));
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CashierAddOnViewHolder cashierAddOnViewHolder, CashierOrderGoodModel cashierOrderGoodModel) {
        Intrinsics.checkNotNullParameter(cashierAddOnViewHolder, "");
        Intrinsics.checkNotNullParameter(cashierOrderGoodModel, "");
        Function5<String, String, String, Boolean, String, Unit> function5 = cashierAddOnViewHolder.getAuthRequestContext;
        String str = cashierOrderGoodModel.BuiltInFictitiousFunctionClassFactory;
        String str2 = str == null ? "" : str;
        String str3 = cashierOrderGoodModel.MyBillsEntityDataFactory;
        String str4 = str3 == null ? "" : str3;
        String str5 = cashierOrderGoodModel.initRecordTimeStamp;
        String str6 = str5 == null ? "" : str5;
        Boolean bool = cashierOrderGoodModel.GetContactSyncConfig;
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        String str7 = cashierOrderGoodModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
        function5.invoke(str2, str4, str6, Boolean.valueOf(booleanValue), str7 == null ? "" : str7);
    }
}

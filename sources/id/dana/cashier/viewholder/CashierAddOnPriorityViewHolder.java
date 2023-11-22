package id.dana.cashier.viewholder;

import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.AddOnChannelSupportInfo;
import id.dana.cashier.model.CashierOrderGoodModel;
import id.dana.cashier.model.CashierOrderGoodModelKt;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.databinding.ItemCashierAddOnPriorityBinding;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.utils.safeonclicklistener.SafeClickListenerExtKt;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BU\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004\u0012*\u0010\u000f\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R&\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR8\u0010\f\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/cashier/viewholder/CashierAddOnPriorityViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/CashierOrderGoodModel;", "Lid/dana/databinding/ItemCashierAddOnPriorityBinding;", "Lkotlin/Function2;", "", "", "", "getAuthRequestContext", "Lkotlin/jvm/functions/Function2;", "MyBillsEntityDataFactory", "Lkotlin/Function5;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function5;", "p0", "p1", "Landroid/view/ViewGroup;", "p2", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierAddOnPriorityViewHolder extends ViewBindingRecyclerViewHolder<CashierOrderGoodModel, ItemCashierAddOnPriorityBinding> {
    private final Function5<String, String, String, Boolean, String, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function2<String, Boolean, Unit> MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        String format;
        final CashierOrderGoodModel cashierOrderGoodModel = (CashierOrderGoodModel) obj;
        if (cashierOrderGoodModel != null) {
            final ItemCashierAddOnPriorityBinding binding = getBinding();
            binding.getErrorConfigVersion.setText(cashierOrderGoodModel.DatabaseTableConfigUtil);
            String str = null;
            if (!CashierOrderGoodModelKt.BuiltInFictitiousFunctionClassFactory(cashierOrderGoodModel) && !CashierOrderGoodModelKt.PlaceComponentResult(cashierOrderGoodModel)) {
                AppCompatTextView appCompatTextView = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                AppCompatTextView appCompatTextView2 = appCompatTextView;
                AddOnChannelSupportInfo addOnChannelSupportInfo = cashierOrderGoodModel.KClassImpl$Data$declaredNonStaticMembers$2;
                String str2 = addOnChannelSupportInfo != null ? addOnChannelSupportInfo.MyBillsEntityDataFactory : null;
                appCompatTextView2.setVisibility((str2 == null || str2.length() == 0) ^ true ? 0 : 8);
                AppCompatTextView appCompatTextView3 = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
                AddOnChannelSupportInfo addOnChannelSupportInfo2 = cashierOrderGoodModel.KClassImpl$Data$declaredNonStaticMembers$2;
                String str3 = addOnChannelSupportInfo2 != null ? addOnChannelSupportInfo2.MyBillsEntityDataFactory : null;
                if (str3 == null) {
                    str3 = "";
                }
                appCompatTextView3.setText(str3);
                binding.getAuthRequestContext.setVisibility(8);
                binding.PlaceComponentResult.setVisibility(8);
                binding.KClassImpl$Data$declaredNonStaticMembers$2.setEnabled(CashierOrderGoodModelKt.KClassImpl$Data$declaredNonStaticMembers$2(cashierOrderGoodModel) && CashierOrderGoodModelKt.PlaceComponentResult(cashierOrderGoodModel));
                binding.KClassImpl$Data$declaredNonStaticMembers$2.setChecked(CashierOrderGoodModelKt.getAuthRequestContext(cashierOrderGoodModel) && CashierOrderGoodModelKt.PlaceComponentResult(cashierOrderGoodModel));
            } else {
                AppCompatTextView appCompatTextView4 = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView4, "");
                AppCompatTextView appCompatTextView5 = appCompatTextView4;
                String str4 = cashierOrderGoodModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                appCompatTextView5.setVisibility(true ^ (str4 == null || str4.length() == 0) ? 0 : 8);
                binding.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(cashierOrderGoodModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
                binding.getAuthRequestContext.setVisibility(0);
                binding.PlaceComponentResult.setVisibility(0);
                binding.KClassImpl$Data$declaredNonStaticMembers$2.setEnabled(CashierOrderGoodModelKt.KClassImpl$Data$declaredNonStaticMembers$2(cashierOrderGoodModel));
                binding.KClassImpl$Data$declaredNonStaticMembers$2.setChecked(CashierOrderGoodModelKt.getAuthRequestContext(cashierOrderGoodModel));
            }
            AppCompatTextView appCompatTextView6 = binding.PlaceComponentResult;
            MoneyViewModel moneyViewModel = cashierOrderGoodModel.getAuthRequestContext;
            if (moneyViewModel != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
                if (format == null) {
                    format = "";
                }
                sb.append(format);
                str = sb.toString();
            }
            appCompatTextView6.setText(str);
            AppCompatCheckBox appCompatCheckBox = binding.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(appCompatCheckBox, "");
            SafeClickListenerExtKt.getAuthRequestContext(appCompatCheckBox, new Function1<View, Unit>() { // from class: id.dana.cashier.viewholder.CashierAddOnPriorityViewHolder$bindData$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Function2 function2;
                    Intrinsics.checkNotNullParameter(view, "");
                    function2 = CashierAddOnPriorityViewHolder.this.MyBillsEntityDataFactory;
                    String str5 = cashierOrderGoodModel.MyBillsEntityDataFactory;
                    function2.invoke(str5 != null ? str5 : "", Boolean.valueOf(binding.KClassImpl$Data$declaredNonStaticMembers$2.isChecked()));
                }
            });
            binding.KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(getContext().getString(R.string.checkbox_additionals));
            AppCompatImageView appCompatImageView = binding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            SafeClickListenerExtKt.getAuthRequestContext(appCompatImageView, new Function1<View, Unit>() { // from class: id.dana.cashier.viewholder.CashierAddOnPriorityViewHolder$bindData$1$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Function5 function5;
                    Intrinsics.checkNotNullParameter(view, "");
                    function5 = CashierAddOnPriorityViewHolder.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    String str5 = cashierOrderGoodModel.BuiltInFictitiousFunctionClassFactory;
                    String str6 = str5 == null ? "" : str5;
                    String str7 = cashierOrderGoodModel.MyBillsEntityDataFactory;
                    String str8 = str7 == null ? "" : str7;
                    String str9 = cashierOrderGoodModel.initRecordTimeStamp;
                    String str10 = str9 == null ? "" : str9;
                    Boolean bool = cashierOrderGoodModel.GetContactSyncConfig;
                    boolean booleanValue = bool != null ? bool.booleanValue() : false;
                    String str11 = cashierOrderGoodModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    function5.invoke(str6, str8, str10, Boolean.valueOf(booleanValue), str11 == null ? "" : str11);
                }
            });
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemCashierAddOnPriorityBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemCashierAddOnPriorityBinding PlaceComponentResult = ItemCashierAddOnPriorityBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CashierAddOnPriorityViewHolder(kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> r3, kotlin.jvm.functions.Function5<? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> r4, android.view.ViewGroup r5) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.Context r1 = r5.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559069(0x7f0d029d, float:1.8743472E38)
            r2.<init>(r1, r0, r5)
            r2.MyBillsEntityDataFactory = r3
            r2.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.CashierAddOnPriorityViewHolder.<init>(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function5, android.view.ViewGroup):void");
    }
}

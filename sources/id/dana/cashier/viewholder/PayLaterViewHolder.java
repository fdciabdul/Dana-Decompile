package id.dana.cashier.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import id.dana.core.ui.extension.TextViewExtKt;
import id.dana.databinding.ItemCashierPayLaterBinding;
import id.dana.extension.view.ViewExtKt;
import id.dana.utils.ResourceUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cashier/viewholder/PayLaterViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/databinding/ItemCashierPayLaterBinding;", "p0", "", "PlaceComponentResult", "(Lid/dana/cashier/model/CashierPayMethodModel;)Z", "Landroid/view/ViewGroup;", "Lkotlin/Function1;", "", "", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayLaterViewHolder extends ViewBindingRecyclerViewHolder<CashierPayMethodModel, ItemCashierPayLaterBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        Drawable PlaceComponentResult;
        String string;
        String string2;
        CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) obj;
        super.bindData(cashierPayMethodModel);
        if (cashierPayMethodModel != null) {
            ItemCashierPayLaterBinding binding = getBinding();
            ConstraintLayout constraintLayout = binding.KClassImpl$Data$declaredNonStaticMembers$2;
            boolean z = false;
            boolean z2 = (cashierPayMethodModel.PlaceComponentResult() && cashierPayMethodModel.getBuiltInFictitiousFunctionClassFactory()) ? false : true;
            boolean z3 = (z2 || cashierPayMethodModel.getNetworkUserEntityData$$ExternalSyntheticLambda0()) ? false : true;
            Glide.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout.getContext()).getAuthRequestContext(Integer.valueOf(cashierPayMethodModel.getKClassImpl$Data$declaredNonStaticMembers$2())).BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory((ImageView) binding.BuiltInFictitiousFunctionClassFactory);
            constraintLayout.setClickable(z3);
            RadioButton radioButton = binding.PlaceComponentResult;
            radioButton.setClickable(z3 && !cashierPayMethodModel.getNetworkUserEntityData$$ExternalSyntheticLambda0());
            boolean networkUserEntityData$$ExternalSyntheticLambda0 = cashierPayMethodModel.getNetworkUserEntityData$$ExternalSyntheticLambda0();
            if (z2) {
                PlaceComponentResult = ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.ic_cashier_general_radio_disabled);
            } else if (!networkUserEntityData$$ExternalSyntheticLambda0) {
                PlaceComponentResult = ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.ic_cashier_button_radio_unselected);
            } else {
                PlaceComponentResult = ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.ic_cashier_button_radio_active);
            }
            radioButton.setButtonDrawable(PlaceComponentResult);
            radioButton.setContentDescription(radioButton.getContext().getString(R.string.sdet_radio_paylater_instant));
            boolean placeComponentResult = cashierPayMethodModel.getPlaceComponentResult();
            AppCompatTextView appCompatTextView = getBinding().lookAheadTest;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
            appCompatTextView.setVisibility(placeComponentResult ? 0 : 8);
            getBinding().lookAheadTest.setBackgroundResource(z2 ? R.drawable.bg_rounded_grey40 : R.drawable.bg_rounded_blue);
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            AppCompatImageView appCompatImageView = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            AppCompatImageView appCompatImageView2 = appCompatImageView;
            if (z2) {
                ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView2);
            } else {
                ViewExtKt.getAuthRequestContext((ImageView) appCompatImageView2);
            }
            AppCompatTextView appCompatTextView2 = binding.scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
            TextViewExtKt.BuiltInFictitiousFunctionClassFactory(appCompatTextView2, cashierPayMethodModel.DatabaseTableConfigUtil(), null, null, constraintLayout.getContext().getString(R.string.sdet_lbl_paylater_instant), null, 22);
            AppCompatTextView appCompatTextView3 = binding.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView3, "");
            AppCompatTextView appCompatTextView4 = appCompatTextView3;
            if (cashierPayMethodModel.PlaceComponentResult() && cashierPayMethodModel.getBuiltInFictitiousFunctionClassFactory()) {
                TextViewExtKt.BuiltInFictitiousFunctionClassFactory(appCompatTextView4, cashierPayMethodModel.getMyBillsEntityDataFactory(), Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.getErrorConfigVersion_res_0x7f0602a3)), null, null, null, 28);
            } else {
                if (CashierPayMethodModelKt.VerifyPinStateManager$executeRiskChallenge$2$1(cashierPayMethodModel)) {
                    string = getContext().getString(R.string.paylater_is_not_activated);
                } else {
                    string = getContext().getString(R.string.paylater_unavailable);
                }
                String str = string;
                Intrinsics.checkNotNullExpressionValue(str, "");
                int BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f25492131100161);
                TextViewExtKt.BuiltInFictitiousFunctionClassFactory(appCompatTextView4, str, Integer.valueOf(BuiltInFictitiousFunctionClassFactory), null, cashierPayMethodModel.PlaceComponentResult() ? null : getContext().getString(R.string.sdet_lbl_currently_unavailable), null, 20);
            }
            AppCompatTextView appCompatTextView5 = binding.moveToNextValue;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView5, "");
            AppCompatTextView appCompatTextView6 = appCompatTextView5;
            int i = (cashierPayMethodModel.PlaceComponentResult() && cashierPayMethodModel.getBuiltInFictitiousFunctionClassFactory()) ? R.style.f54062132017900 : R.style.f49862132017440;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            String PlaceComponentResult2 = ResourceUtils.PlaceComponentResult(context, cashierPayMethodModel.scheduleImpl(), cashierPayMethodModel.scheduleImpl());
            if (PlaceComponentResult(cashierPayMethodModel) && cashierPayMethodModel.getBuiltInFictitiousFunctionClassFactory()) {
                z = true;
            }
            boolean PlaceComponentResult3 = cashierPayMethodModel.PlaceComponentResult();
            if (PlaceComponentResult3) {
                string2 = getContext().getString(R.string.sdet_desc_paylater_instant);
            } else if (PlaceComponentResult3) {
                throw new NoWhenBranchMatchedException();
            } else {
                if (CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda1(cashierPayMethodModel)) {
                    string2 = getContext().getString(R.string.sdet_lbl_insufficient_limit);
                } else {
                    string2 = getContext().getString(R.string.sdet_lbl_description_paylater_inactive);
                }
            }
            String str2 = string2;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            TextViewExtKt.BuiltInFictitiousFunctionClassFactory(appCompatTextView6, PlaceComponentResult2, null, Integer.valueOf(i), str2, Boolean.valueOf(z), 2);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemCashierPayLaterBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemCashierPayLaterBinding PlaceComponentResult = ItemCashierPayLaterBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PayLaterViewHolder(android.view.ViewGroup r3, final kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559071(0x7f0d029f, float:1.8743476E38)
            r2.<init>(r1, r0, r3)
            java.lang.Object r3 = r2.getBinding()
            id.dana.databinding.ItemCashierPayLaterBinding r3 = (id.dana.databinding.ItemCashierPayLaterBinding) r3
            androidx.constraintlayout.widget.ConstraintLayout r3 = r3.MyBillsEntityDataFactory
            id.dana.cashier.viewholder.PayLaterViewHolder$$ExternalSyntheticLambda0 r0 = new id.dana.cashier.viewholder.PayLaterViewHolder$$ExternalSyntheticLambda0
            r0.<init>()
            r3.setOnClickListener(r0)
            java.lang.Object r3 = r2.getBinding()
            id.dana.databinding.ItemCashierPayLaterBinding r3 = (id.dana.databinding.ItemCashierPayLaterBinding) r3
            android.widget.RadioButton r3 = r3.PlaceComponentResult
            id.dana.cashier.viewholder.PayLaterViewHolder$$ExternalSyntheticLambda1 r0 = new id.dana.cashier.viewholder.PayLaterViewHolder$$ExternalSyntheticLambda1
            r0.<init>()
            r3.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.PayLaterViewHolder.<init>(android.view.ViewGroup, kotlin.jvm.functions.Function1):void");
    }

    private static boolean PlaceComponentResult(CashierPayMethodModel p0) {
        return (CashierPayMethodModelKt.whenAvailable(p0) || CashierPayMethodModelKt.SubSequence(p0) || CashierPayMethodModelKt.B(p0) || CashierPayMethodModelKt.getCallingPid(p0)) ? false : true;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Function1 function1, PayLaterViewHolder payLaterViewHolder) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(payLaterViewHolder, "");
        function1.invoke(Integer.valueOf(payLaterViewHolder.getAbsoluteAdapterPosition()));
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Function1 function1, PayLaterViewHolder payLaterViewHolder) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(payLaterViewHolder, "");
        function1.invoke(Integer.valueOf(payLaterViewHolder.getAbsoluteAdapterPosition()));
    }
}

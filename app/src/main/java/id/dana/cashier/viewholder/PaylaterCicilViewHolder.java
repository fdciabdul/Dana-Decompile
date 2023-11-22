package id.dana.cashier.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import id.dana.databinding.ItemCashierPayLaterBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cashier/viewholder/PaylaterCicilViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/databinding/ItemCashierPayLaterBinding;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/model/CashierPayMethodModel;)Z", "Landroid/view/ViewGroup;", "Lkotlin/Function1;", "", "", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterCicilViewHolder extends ViewBindingRecyclerViewHolder<CashierPayMethodModel, ItemCashierPayLaterBinding> {
    /* JADX WARN: Removed duplicated region for block: B:245:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x026c  */
    @Override // id.dana.base.BaseRecyclerViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void bindData(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.PaylaterCicilViewHolder.bindData(java.lang.Object):void");
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
    public PaylaterCicilViewHolder(android.view.ViewGroup r3, final kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r4) {
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
            id.dana.cashier.viewholder.PaylaterCicilViewHolder$$ExternalSyntheticLambda0 r0 = new id.dana.cashier.viewholder.PaylaterCicilViewHolder$$ExternalSyntheticLambda0
            r0.<init>()
            r3.setOnClickListener(r0)
            java.lang.Object r3 = r2.getBinding()
            id.dana.databinding.ItemCashierPayLaterBinding r3 = (id.dana.databinding.ItemCashierPayLaterBinding) r3
            android.widget.RadioButton r3 = r3.PlaceComponentResult
            id.dana.cashier.viewholder.PaylaterCicilViewHolder$$ExternalSyntheticLambda1 r0 = new id.dana.cashier.viewholder.PaylaterCicilViewHolder$$ExternalSyntheticLambda1
            r0.<init>()
            r3.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.PaylaterCicilViewHolder.<init>(android.view.ViewGroup, kotlin.jvm.functions.Function1):void");
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(CashierPayMethodModel p0) {
        return (CashierPayMethodModelKt.whenAvailable(p0) || CashierPayMethodModelKt.SubSequence(p0) || CashierPayMethodModelKt.B(p0) || CashierPayMethodModelKt.getCallingPid(p0)) ? false : true;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Function1 function1, PaylaterCicilViewHolder paylaterCicilViewHolder) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(paylaterCicilViewHolder, "");
        function1.invoke(Integer.valueOf(paylaterCicilViewHolder.getAbsoluteAdapterPosition()));
    }

    public static /* synthetic */ void getAuthRequestContext(Function1 function1, PaylaterCicilViewHolder paylaterCicilViewHolder) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(paylaterCicilViewHolder, "");
        function1.invoke(Integer.valueOf(paylaterCicilViewHolder.getAbsoluteAdapterPosition()));
    }
}

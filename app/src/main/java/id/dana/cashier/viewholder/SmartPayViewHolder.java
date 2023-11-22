package id.dana.cashier.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.databinding.ViewCashierSmartpayBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/viewholder/SmartPayViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/databinding/ViewCashierSmartpayBinding;", "Landroid/view/ViewGroup;", "p0", "Lkotlin/Function0;", "", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SmartPayViewHolder extends ViewBindingRecyclerViewHolder<CashierPayMethodModel, ViewCashierSmartpayBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* bridge */ /* synthetic */ void bindData(Object obj) {
        CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) obj;
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ViewCashierSmartpayBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewCashierSmartpayBinding MyBillsEntityDataFactory = ViewCashierSmartpayBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SmartPayViewHolder(android.view.ViewGroup r3, final kotlin.jvm.functions.Function0<kotlin.Unit> r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559600(0x7f0d04b0, float:1.8744549E38)
            r2.<init>(r1, r0, r3)
            java.lang.Object r3 = r2.getBinding()
            id.dana.databinding.ViewCashierSmartpayBinding r3 = (id.dana.databinding.ViewCashierSmartpayBinding) r3
            androidx.constraintlayout.widget.ConstraintLayout r3 = r3.PlaceComponentResult
            id.dana.cashier.viewholder.SmartPayViewHolder$$ExternalSyntheticLambda0 r0 = new id.dana.cashier.viewholder.SmartPayViewHolder$$ExternalSyntheticLambda0
            r0.<init>()
            r3.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.SmartPayViewHolder.<init>(android.view.ViewGroup, kotlin.jvm.functions.Function0):void");
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }
}

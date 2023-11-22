package id.dana.cashier.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.databinding.ItemCashierDanaPlusBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\r\u0010\u000eR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cashier/viewholder/DanaPlusViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/databinding/ItemCashierDanaPlusBinding;", "Lkotlin/Function1;", "", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaPlusViewHolder extends ViewBindingRecyclerViewHolder<CashierPayMethodModel, ItemCashierDanaPlusBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function1<Integer, Unit> getAuthRequestContext;

    /* JADX WARN: Removed duplicated region for block: B:161:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01a6  */
    @Override // id.dana.base.BaseRecyclerViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void bindData(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.DanaPlusViewHolder.bindData(java.lang.Object):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemCashierDanaPlusBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemCashierDanaPlusBinding authRequestContext = ItemCashierDanaPlusBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DanaPlusViewHolder(android.view.ViewGroup r3, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559070(0x7f0d029e, float:1.8743474E38)
            r2.<init>(r1, r0, r3)
            r2.getAuthRequestContext = r4
            java.lang.Object r3 = r2.getBinding()
            id.dana.databinding.ItemCashierDanaPlusBinding r3 = (id.dana.databinding.ItemCashierDanaPlusBinding) r3
            androidx.constraintlayout.widget.ConstraintLayout r3 = r3.MyBillsEntityDataFactory
            id.dana.cashier.viewholder.DanaPlusViewHolder$$ExternalSyntheticLambda0 r4 = new id.dana.cashier.viewholder.DanaPlusViewHolder$$ExternalSyntheticLambda0
            r4.<init>()
            r3.setOnClickListener(r4)
            java.lang.Object r3 = r2.getBinding()
            id.dana.databinding.ItemCashierDanaPlusBinding r3 = (id.dana.databinding.ItemCashierDanaPlusBinding) r3
            android.widget.RadioButton r3 = r3.getAuthRequestContext
            id.dana.cashier.viewholder.DanaPlusViewHolder$$ExternalSyntheticLambda1 r4 = new id.dana.cashier.viewholder.DanaPlusViewHolder$$ExternalSyntheticLambda1
            r4.<init>()
            r3.setOnClickListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.DanaPlusViewHolder.<init>(android.view.ViewGroup, kotlin.jvm.functions.Function1):void");
    }

    public static /* synthetic */ void getAuthRequestContext(DanaPlusViewHolder danaPlusViewHolder) {
        Intrinsics.checkNotNullParameter(danaPlusViewHolder, "");
        danaPlusViewHolder.getAuthRequestContext.invoke(Integer.valueOf(danaPlusViewHolder.getAbsoluteAdapterPosition()));
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DanaPlusViewHolder danaPlusViewHolder) {
        Intrinsics.checkNotNullParameter(danaPlusViewHolder, "");
        danaPlusViewHolder.getAuthRequestContext.invoke(Integer.valueOf(danaPlusViewHolder.getAbsoluteAdapterPosition()));
    }
}

package id.dana.cashier.topupandpay.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.databinding.ItemTopUpAndPayBankCardBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cashier/topupandpay/viewholder/TopUpAndPayBankCardViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/databinding/ItemTopUpAndPayBankCardBinding;", "Lkotlin/Function1;", "", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "p0", "Landroid/view/ViewGroup;", "p1", "<init>", "(Lkotlin/jvm/functions/Function1;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TopUpAndPayBankCardViewHolder extends ViewBindingRecyclerViewHolder<CashierPayMethodModel, ItemTopUpAndPayBankCardBinding> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function1<CashierPayMethodModel, Unit> getAuthRequestContext;

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e7  */
    @Override // id.dana.base.BaseRecyclerViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void bindData(java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.topupandpay.viewholder.TopUpAndPayBankCardViewHolder.bindData(java.lang.Object):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemTopUpAndPayBankCardBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemTopUpAndPayBankCardBinding PlaceComponentResult = ItemTopUpAndPayBankCardBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TopUpAndPayBankCardViewHolder(kotlin.jvm.functions.Function1<? super id.dana.cashier.model.CashierPayMethodModel, kotlin.Unit> r3, android.view.ViewGroup r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r4.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559283(0x7f0d0373, float:1.8743906E38)
            r2.<init>(r1, r0, r4)
            r2.getAuthRequestContext = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.topupandpay.viewholder.TopUpAndPayBankCardViewHolder.<init>(kotlin.jvm.functions.Function1, android.view.ViewGroup):void");
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPayBankCardViewHolder topUpAndPayBankCardViewHolder, CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(topUpAndPayBankCardViewHolder, "");
        topUpAndPayBankCardViewHolder.getAuthRequestContext.invoke(cashierPayMethodModel);
    }
}

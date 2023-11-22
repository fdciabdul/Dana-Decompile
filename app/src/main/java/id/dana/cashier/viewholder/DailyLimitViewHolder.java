package id.dana.cashier.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.adapter.OnInsertVerifyElementsListener;
import id.dana.cashier.addCard.model.DailyLimitCardVerifyElementModel;
import id.dana.cashier.addCard.model.QueryCardVerifyElementModel;
import id.dana.cashier.model.DailyLimitAmountConfModel;
import id.dana.databinding.ItemDailyLimitInputBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/viewholder/DailyLimitViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/addCard/model/QueryCardVerifyElementModel;", "Lid/dana/databinding/ItemDailyLimitInputBinding;", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "PlaceComponentResult", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DailyLimitViewHolder extends ViewBindingRecyclerViewHolder<QueryCardVerifyElementModel, ItemDailyLimitInputBinding> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final OnInsertVerifyElementsListener KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        QueryCardVerifyElementModel queryCardVerifyElementModel = (QueryCardVerifyElementModel) obj;
        DailyLimitCardVerifyElementModel dailyLimitCardVerifyElementModel = queryCardVerifyElementModel instanceof DailyLimitCardVerifyElementModel ? (DailyLimitCardVerifyElementModel) queryCardVerifyElementModel : null;
        if (dailyLimitCardVerifyElementModel != null) {
            if (dailyLimitCardVerifyElementModel.MyBillsEntityDataFactory == null) {
                dailyLimitCardVerifyElementModel.MyBillsEntityDataFactory = new DailyLimitAmountConfModel(null, null, null, 7, null);
            }
            getBinding().getAuthRequestContext.setDailyLimit(dailyLimitCardVerifyElementModel);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemDailyLimitInputBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemDailyLimitInputBinding authRequestContext = ItemDailyLimitInputBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DailyLimitViewHolder(android.view.ViewGroup r3, id.dana.cashier.adapter.OnInsertVerifyElementsListener r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559084(0x7f0d02ac, float:1.8743502E38)
            r2.<init>(r1, r0, r3)
            r2.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            java.lang.Object r3 = r2.getBinding()
            id.dana.databinding.ItemDailyLimitInputBinding r3 = (id.dana.databinding.ItemDailyLimitInputBinding) r3
            id.dana.cashier.view.DailyLimitCashierView r3 = r3.getAuthRequestContext
            id.dana.cashier.viewholder.DailyLimitViewHolder$1 r4 = new id.dana.cashier.viewholder.DailyLimitViewHolder$1
            r4.<init>()
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r3.setInputDailyLimitListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.DailyLimitViewHolder.<init>(android.view.ViewGroup, id.dana.cashier.adapter.OnInsertVerifyElementsListener):void");
    }
}

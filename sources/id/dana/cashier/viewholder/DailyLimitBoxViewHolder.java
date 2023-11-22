package id.dana.cashier.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.adapter.OnInsertVerifyElementsListener;
import id.dana.cashier.addCard.model.DailyLimitCardVerifyElementModel;
import id.dana.cashier.addCard.model.QueryCardVerifyElementModel;
import id.dana.cashier.model.DailyLimitAmountConfModel;
import id.dana.databinding.ItemDailyLimitBoxBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/viewholder/DailyLimitBoxViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/addCard/model/QueryCardVerifyElementModel;", "Lid/dana/databinding/ItemDailyLimitBoxBinding;", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "getAuthRequestContext", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DailyLimitBoxViewHolder extends ViewBindingRecyclerViewHolder<QueryCardVerifyElementModel, ItemDailyLimitBoxBinding> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final OnInsertVerifyElementsListener PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        QueryCardVerifyElementModel queryCardVerifyElementModel = (QueryCardVerifyElementModel) obj;
        DailyLimitCardVerifyElementModel dailyLimitCardVerifyElementModel = queryCardVerifyElementModel instanceof DailyLimitCardVerifyElementModel ? (DailyLimitCardVerifyElementModel) queryCardVerifyElementModel : null;
        if (dailyLimitCardVerifyElementModel != null) {
            if (dailyLimitCardVerifyElementModel.MyBillsEntityDataFactory == null) {
                dailyLimitCardVerifyElementModel.MyBillsEntityDataFactory = new DailyLimitAmountConfModel(null, null, null, 7, null);
            }
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setDailyLimit(dailyLimitCardVerifyElementModel);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemDailyLimitBoxBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemDailyLimitBoxBinding authRequestContext = ItemDailyLimitBoxBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DailyLimitBoxViewHolder(android.view.ViewGroup r3, id.dana.cashier.adapter.OnInsertVerifyElementsListener r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559083(0x7f0d02ab, float:1.87435E38)
            r2.<init>(r1, r0, r3)
            r2.PlaceComponentResult = r4
            java.lang.Object r3 = r2.getBinding()
            id.dana.databinding.ItemDailyLimitBoxBinding r3 = (id.dana.databinding.ItemDailyLimitBoxBinding) r3
            id.dana.cashier.view.DailyLimitBoxView r3 = r3.KClassImpl$Data$declaredNonStaticMembers$2
            id.dana.cashier.viewholder.DailyLimitBoxViewHolder$1 r4 = new id.dana.cashier.viewholder.DailyLimitBoxViewHolder$1
            r4.<init>()
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r3.setInputDailyLimitListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.DailyLimitBoxViewHolder.<init>(android.view.ViewGroup, id.dana.cashier.adapter.OnInsertVerifyElementsListener):void");
    }
}

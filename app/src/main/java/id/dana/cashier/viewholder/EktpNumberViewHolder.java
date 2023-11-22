package id.dana.cashier.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.adapter.OnInsertVerifyElementsListener;
import id.dana.cashier.addCard.model.QueryCardVerifyElementModel;
import id.dana.databinding.ItemEktpNumberBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/viewholder/EktpNumberViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/addCard/model/QueryCardVerifyElementModel;", "Lid/dana/databinding/ItemEktpNumberBinding;", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EktpNumberViewHolder extends ViewBindingRecyclerViewHolder<QueryCardVerifyElementModel, ItemEktpNumberBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final OnInsertVerifyElementsListener PlaceComponentResult;

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemEktpNumberBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemEktpNumberBinding PlaceComponentResult = ItemEktpNumberBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public EktpNumberViewHolder(android.view.ViewGroup r4, id.dana.cashier.adapter.OnInsertVerifyElementsListener r5) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.Context r1 = r4.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r2 = 2131559092(0x7f0d02b4, float:1.8743518E38)
            r3.<init>(r1, r2, r4)
            r3.PlaceComponentResult = r5
            java.lang.Object r4 = r3.getBinding()
            id.dana.databinding.ItemEktpNumberBinding r4 = (id.dana.databinding.ItemEktpNumberBinding) r4
            com.afollestad.materialdialogs.utils.MDUtil r5 = com.afollestad.materialdialogs.utils.MDUtil.INSTANCE
            com.google.android.material.textfield.TextInputEditText r1 = r4.PlaceComponentResult
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            android.widget.EditText r1 = (android.widget.EditText) r1
            id.dana.cashier.viewholder.EktpNumberViewHolder$listenEktpNumber$1$1 r0 = new id.dana.cashier.viewholder.EktpNumberViewHolder$listenEktpNumber$1$1
            r0.<init>()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r5.textChanged(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.EktpNumberViewHolder.<init>(android.view.ViewGroup, id.dana.cashier.adapter.OnInsertVerifyElementsListener):void");
    }
}

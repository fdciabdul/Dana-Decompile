package id.dana.nearbyme.merchantreview.viewholder;

import android.view.View;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ItemReviewListHeaderBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/nearbyme/merchantreview/viewholder/MerchantReviewSectionTitleViewHolder;", "T", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/databinding/ItemReviewListHeaderBinding;", "p0", "", "bindData", "(Ljava/lang/Object;)V", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "p1", "<init>", "(Landroid/view/ViewGroup;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewSectionTitleViewHolder<T> extends ViewBindingRecyclerViewHolder<T, ItemReviewListHeaderBinding> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemReviewListHeaderBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemReviewListHeaderBinding BuiltInFictitiousFunctionClassFactory = ItemReviewListHeaderBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MerchantReviewSectionTitleViewHolder(android.view.ViewGroup r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559241(0x7f0d0349, float:1.874382E38)
            r2.<init>(r1, r0, r3)
            r2.PlaceComponentResult = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantreview.viewholder.MerchantReviewSectionTitleViewHolder.<init>(android.view.ViewGroup, java.lang.String):void");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(T p0) {
        ((TextView) this.itemView.findViewById(R.id.getLogSourceName)).setText(this.PlaceComponentResult);
    }
}

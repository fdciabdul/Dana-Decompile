package id.dana.nearbyme.merchantreview.viewholder;

import android.view.View;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ItemSkeletonMerchantReviewBinding;
import id.dana.utils.ShimmeringUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/nearbyme/merchantreview/viewholder/MerchantReviewShimmerViewHolder;", "T", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/databinding/ItemSkeletonMerchantReviewBinding;", "p0", "", "bindData", "(Ljava/lang/Object;)V", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewShimmerViewHolder<T> extends ViewBindingRecyclerViewHolder<T, ItemSkeletonMerchantReviewBinding> {
    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemSkeletonMerchantReviewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemSkeletonMerchantReviewBinding BuiltInFictitiousFunctionClassFactory = ItemSkeletonMerchantReviewBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MerchantReviewShimmerViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559266(0x7f0d0362, float:1.8743871E38)
            r2.<init>(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantreview.viewholder.MerchantReviewShimmerViewHolder.<init>(android.view.ViewGroup):void");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(T p0) {
        ShimmeringUtil.PlaceComponentResult(getBinding().PlaceComponentResult, R.layout.item_shimmer_merchant_review).MyBillsEntityDataFactory();
    }
}

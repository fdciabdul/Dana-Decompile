package id.dana.nearbyme.merchantreview.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ItemMyReviewEmptyBinding;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyme/merchantreview/viewholder/MyReviewEmptyViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "Lid/dana/databinding/ItemMyReviewEmptyBinding;", "", "MyBillsEntityDataFactory", "Z", "getAuthRequestContext", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyReviewEmptyViewHolder extends ViewBindingRecyclerViewHolder<MerchantReviewViewModel, ItemMyReviewEmptyBinding> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final boolean getAuthRequestContext;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        MerchantReviewViewModel merchantReviewViewModel = (MerchantReviewViewModel) obj;
        if (this.getAuthRequestContext) {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setGravity(17);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemMyReviewEmptyBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemMyReviewEmptyBinding BuiltInFictitiousFunctionClassFactory = ItemMyReviewEmptyBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MyReviewEmptyViewHolder(android.view.ViewGroup r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559187(0x7f0d0313, float:1.874371E38)
            r2.<init>(r1, r0, r3)
            r2.getAuthRequestContext = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantreview.viewholder.MyReviewEmptyViewHolder.<init>(android.view.ViewGroup, boolean):void");
    }
}

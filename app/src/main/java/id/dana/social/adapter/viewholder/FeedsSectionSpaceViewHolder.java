package id.dana.social.adapter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ViewholderFeedsectionSpaceBinding;
import id.dana.utils.SizeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/social/adapter/viewholder/FeedsSectionSpaceViewHolder;", "", "T", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/databinding/ViewholderFeedsectionSpaceBinding;", "p0", "", "bindData", "(Ljava/lang/Object;)V", "", "getAuthRequestContext", "I", "PlaceComponentResult", "Landroid/view/ViewGroup;", "p1", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsSectionSpaceViewHolder<T> extends ViewBindingRecyclerViewHolder<T, ViewholderFeedsectionSpaceBinding> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final int PlaceComponentResult;

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ViewholderFeedsectionSpaceBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewholderFeedsectionSpaceBinding MyBillsEntityDataFactory = ViewholderFeedsectionSpaceBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FeedsSectionSpaceViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131560278(0x7f0d0756, float:1.8745924E38)
            r2.<init>(r1, r0, r3)
            r3 = 40
            r2.PlaceComponentResult = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.adapter.viewholder.FeedsSectionSpaceViewHolder.<init>(android.view.ViewGroup):void");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(T p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.bindData(p0);
        ViewGroup.LayoutParams layoutParams = getBinding().PlaceComponentResult.getLayoutParams();
        layoutParams.height = SizeUtil.getAuthRequestContext(this.PlaceComponentResult);
        getBinding().PlaceComponentResult.setLayoutParams(layoutParams);
    }
}

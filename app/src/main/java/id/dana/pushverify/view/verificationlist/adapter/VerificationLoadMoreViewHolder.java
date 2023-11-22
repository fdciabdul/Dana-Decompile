package id.dana.pushverify.view.verificationlist.adapter;

import android.view.View;
import android.view.animation.Animation;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ViewVerificationLoadMoreBinding;
import id.dana.pushverify.model.VerificationDetailModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u0006*\u00020\u00040\u0004X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/pushverify/view/verificationlist/adapter/VerificationLoadMoreViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/pushverify/model/VerificationDetailModel;", "Lid/dana/databinding/ViewVerificationLoadMoreBinding;", "Landroid/view/animation/Animation;", "getAuthRequestContext", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationLoadMoreViewHolder extends ViewBindingRecyclerViewHolder<VerificationDetailModel, ViewVerificationLoadMoreBinding> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        VerificationDetailModel verificationDetailModel = (VerificationDetailModel) obj;
        getBinding().PlaceComponentResult.startAnimation((Animation) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ViewVerificationLoadMoreBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewVerificationLoadMoreBinding MyBillsEntityDataFactory = ViewVerificationLoadMoreBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public VerificationLoadMoreViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131560247(0x7f0d0737, float:1.874586E38)
            r2.<init>(r1, r0, r3)
            id.dana.pushverify.view.verificationlist.adapter.VerificationLoadMoreViewHolder$animationLoading$2 r3 = new id.dana.pushverify.view.verificationlist.adapter.VerificationLoadMoreViewHolder$animationLoading$2
            r3.<init>()
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.pushverify.view.verificationlist.adapter.VerificationLoadMoreViewHolder.<init>(android.view.ViewGroup):void");
    }
}

package id.dana.pushverify.view.verificationlist.adapter;

import android.view.View;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ViewDefaultLoadingContainerBinding;
import id.dana.pushverify.model.VerificationDetailModel;
import id.dana.utils.ShimmeringUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/pushverify/view/verificationlist/adapter/VerificationShimmerViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/pushverify/model/VerificationDetailModel;", "Lid/dana/databinding/ViewDefaultLoadingContainerBinding;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "PlaceComponentResult", "Lcom/ethanhua/skeleton/SkeletonScreen;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationShimmerViewHolder extends ViewBindingRecyclerViewHolder<VerificationDetailModel, ViewDefaultLoadingContainerBinding> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private SkeletonScreen KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        Intrinsics.checkNotNullParameter((VerificationDetailModel) obj, "");
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ShimmeringUtil.PlaceComponentResult(getBinding().BuiltInFictitiousFunctionClassFactory, R.layout.view_verification_skeleton);
        }
        SkeletonScreen skeletonScreen = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ViewDefaultLoadingContainerBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewDefaultLoadingContainerBinding MyBillsEntityDataFactory = ViewDefaultLoadingContainerBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public VerificationShimmerViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559685(0x7f0d0505, float:1.8744721E38)
            r2.<init>(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.pushverify.view.verificationlist.adapter.VerificationShimmerViewHolder.<init>(android.view.ViewGroup):void");
    }
}

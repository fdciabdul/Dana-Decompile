package id.dana.social.adapter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ViewholderFriendShimmerBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/social/adapter/viewholder/FeedsSimpleShimmerViewHolder;", "", DiskFormatter.MB, "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/databinding/ViewholderFriendShimmerBinding;", "p0", "", "bindData", "(Ljava/lang/Object;)V", "Landroid/view/ViewGroup;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "PlaceComponentResult", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getAuthRequestContext", "p1", "<init>", "(Landroid/view/ViewGroup;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsSimpleShimmerViewHolder<M> extends ViewBindingRecyclerViewHolder<M, ViewholderFriendShimmerBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final ViewGroup PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final int getAuthRequestContext;

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ViewholderFriendShimmerBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewholderFriendShimmerBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewholderFriendShimmerBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FeedsSimpleShimmerViewHolder(android.view.ViewGroup r3, int r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131560284(0x7f0d075c, float:1.8745936E38)
            r2.<init>(r1, r0, r3)
            r2.PlaceComponentResult = r3
            r2.getAuthRequestContext = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.adapter.viewholder.FeedsSimpleShimmerViewHolder.<init>(android.view.ViewGroup, int):void");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(M p0) {
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(getBinding().BuiltInFictitiousFunctionClassFactory);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = this.getAuthRequestContext;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0).MyBillsEntityDataFactory();
    }
}

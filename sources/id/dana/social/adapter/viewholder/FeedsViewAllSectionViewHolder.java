package id.dana.social.adapter.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ViewholderFeedViewAllBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/social/adapter/viewholder/FeedsViewAllSectionViewHolder;", "", "T", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/databinding/ViewholderFeedViewAllBinding;", "p0", "", "bindData", "(Ljava/lang/Object;)V", "Lkotlin/Function0;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function0;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsViewAllSectionViewHolder<T> extends ViewBindingRecyclerViewHolder<T, ViewholderFeedViewAllBinding> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function0<Unit> PlaceComponentResult;

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ViewholderFeedViewAllBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewholderFeedViewAllBinding BuiltInFictitiousFunctionClassFactory = ViewholderFeedViewAllBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FeedsViewAllSectionViewHolder(android.view.ViewGroup r3, kotlin.jvm.functions.Function0<kotlin.Unit> r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131560275(0x7f0d0753, float:1.8745918E38)
            r2.<init>(r1, r0, r3)
            r2.PlaceComponentResult = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.adapter.viewholder.FeedsViewAllSectionViewHolder.<init>(android.view.ViewGroup, kotlin.jvm.functions.Function0):void");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(T p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.viewholder.FeedsViewAllSectionViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsViewAllSectionViewHolder.BuiltInFictitiousFunctionClassFactory(FeedsViewAllSectionViewHolder.this);
            }
        });
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FeedsViewAllSectionViewHolder feedsViewAllSectionViewHolder) {
        Intrinsics.checkNotNullParameter(feedsViewAllSectionViewHolder, "");
        feedsViewAllSectionViewHolder.PlaceComponentResult.invoke();
    }
}

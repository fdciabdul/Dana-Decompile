package id.dana.social.v2.viewholder;

import android.view.View;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/social/v2/viewholder/FeedUsernameBannerViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "Landroid/view/ViewGroup;", "p0", "Lkotlin/Function0;", "", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedUsernameBannerViewHolder extends BaseRecyclerViewHolder<Integer> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedUsernameBannerViewHolder(ViewGroup viewGroup, final Function0<Unit> function0) {
        super(viewGroup.getContext(), R.layout.view_username_banner_v2, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.viewholder.FeedUsernameBannerViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedUsernameBannerViewHolder.BuiltInFictitiousFunctionClassFactory(Function0.this);
            }
        });
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }
}

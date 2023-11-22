package id.dana.social.view.activity.detail;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public final class ShimmerViewHolder_ViewBinding implements Unbinder {
    private ShimmerViewHolder getAuthRequestContext;

    public ShimmerViewHolder_ViewBinding(ShimmerViewHolder shimmerViewHolder, View view) {
        this.getAuthRequestContext = shimmerViewHolder;
        shimmerViewHolder.viewShimmer = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f4599view_shimmer, "field 'viewShimmer'");
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ShimmerViewHolder shimmerViewHolder = this.getAuthRequestContext;
        if (shimmerViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        shimmerViewHolder.viewShimmer = null;
    }
}

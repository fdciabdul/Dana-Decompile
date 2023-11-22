package id.dana.social.adapter;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public final class SocialFeedShimmerViewHolder_ViewBinding implements Unbinder {
    private SocialFeedShimmerViewHolder BuiltInFictitiousFunctionClassFactory;

    public SocialFeedShimmerViewHolder_ViewBinding(SocialFeedShimmerViewHolder socialFeedShimmerViewHolder, View view) {
        this.BuiltInFictitiousFunctionClassFactory = socialFeedShimmerViewHolder;
        socialFeedShimmerViewHolder.viewShimmer = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f4599view_shimmer, "field 'viewShimmer'");
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SocialFeedShimmerViewHolder socialFeedShimmerViewHolder = this.BuiltInFictitiousFunctionClassFactory;
        if (socialFeedShimmerViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        socialFeedShimmerViewHolder.viewShimmer = null;
    }
}

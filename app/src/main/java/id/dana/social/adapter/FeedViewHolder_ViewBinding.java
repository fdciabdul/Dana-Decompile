package id.dana.social.adapter;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.social.view.FeedsView;

/* loaded from: classes9.dex */
public class FeedViewHolder_ViewBinding implements Unbinder {
    private FeedViewHolder KClassImpl$Data$declaredNonStaticMembers$2;

    public FeedViewHolder_ViewBinding(FeedViewHolder feedViewHolder, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedViewHolder;
        feedViewHolder.viewFeed = (FeedsView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.PaymentResultFragment, "field 'viewFeed'", FeedsView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        FeedViewHolder feedViewHolder = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (feedViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        feedViewHolder.viewFeed = null;
    }
}

package id.dana.social.adapter;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.social.view.FeedsSectionView;

/* loaded from: classes9.dex */
public final class FeedsSectionViewHolder_ViewBinding implements Unbinder {
    private FeedsSectionViewHolder MyBillsEntityDataFactory;

    public FeedsSectionViewHolder_ViewBinding(FeedsSectionViewHolder feedsSectionViewHolder, View view) {
        this.MyBillsEntityDataFactory = feedsSectionViewHolder;
        feedsSectionViewHolder.viewFeedsSection = (FeedsSectionView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_feeds_section, "field 'viewFeedsSection'", FeedsSectionView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        FeedsSectionViewHolder feedsSectionViewHolder = this.MyBillsEntityDataFactory;
        if (feedsSectionViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        feedsSectionViewHolder.viewFeedsSection = null;
    }
}

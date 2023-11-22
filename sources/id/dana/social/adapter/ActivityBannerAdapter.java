package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.social.adapter.viewholder.ActivityBannerViewHolder;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.utils.Content;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/social/adapter/ActivityBannerAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/social/adapter/viewholder/ActivityBannerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "Lid/dana/social/adapter/ActivityBannerAdapter$socialClickListener$1;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/adapter/ActivityBannerAdapter$socialClickListener$1;", "Lid/dana/social/adapter/SocialFeedClickListener;", "getAuthRequestContext", "Lid/dana/social/adapter/SocialFeedClickListener;", "p0", "<init>", "(Lid/dana/social/adapter/SocialFeedClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityBannerAdapter extends BaseRecyclerViewAdapter<ActivityBannerViewHolder, FeedViewHolderModel> {
    private final ActivityBannerAdapter$socialClickListener$1 BuiltInFictitiousFunctionClassFactory;
    private final SocialFeedClickListener getAuthRequestContext;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new ActivityBannerViewHolder(viewGroup, this.BuiltInFictitiousFunctionClassFactory);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [id.dana.social.adapter.ActivityBannerAdapter$socialClickListener$1] */
    public ActivityBannerAdapter(SocialFeedClickListener socialFeedClickListener) {
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        this.getAuthRequestContext = socialFeedClickListener;
        this.BuiltInFictitiousFunctionClassFactory = new BaseSocialFeedInteraction() { // from class: id.dana.social.adapter.ActivityBannerAdapter$socialClickListener$1
            @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
            public final void getAuthRequestContext(Content p0) {
                SocialFeedClickListener socialFeedClickListener2;
                Intrinsics.checkNotNullParameter(p0, "");
                socialFeedClickListener2 = ActivityBannerAdapter.this.getAuthRequestContext;
                socialFeedClickListener2.getAuthRequestContext(p0);
            }
        };
    }
}

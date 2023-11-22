package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.model.SocialFeedModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\n\u001a\u00020\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\u000f\u001a\u00020\fX\u0086\"¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0012\u0010\u0013\u001a\u00020\u0010X\u0086\"¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/social/adapter/NewSocialWidgetFeedAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/SocialFeedModel;", "", "getItemCount", "()I", "p0", "p1", "", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "Lid/dana/social/adapter/SocialFeedClickListener;", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/SocialFeedClickListener;", "getAuthRequestContext", "Lid/dana/social/adapter/NewSocialWidgetFeedAdapter$OnSlideTounch;", "PlaceComponentResult", "Lid/dana/social/adapter/NewSocialWidgetFeedAdapter$OnSlideTounch;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V", "OnSlideTounch"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class NewSocialWidgetFeedAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<SocialFeedModel>, SocialFeedModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public SocialFeedClickListener getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public OnSlideTounch KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/adapter/NewSocialWidgetFeedAdapter$OnSlideTounch;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface OnSlideTounch {
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((NewSocialWidgetFeedAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        SocialFeedClickListener socialFeedClickListener = this.getAuthRequestContext;
        OnSlideTounch onSlideTounch = null;
        if (socialFeedClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            socialFeedClickListener = null;
        }
        OnSlideTounch onSlideTounch2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (onSlideTounch2 != null) {
            onSlideTounch = onSlideTounch2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        return new NewSocialFeedViewHolder(viewGroup, socialFeedClickListener, onSlideTounch);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder<SocialFeedModel> p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.bindData(getItem(p1 % getItems().size()));
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return (getItems() == null || getItems().size() <= 0) ? 0 : Integer.MAX_VALUE;
    }
}

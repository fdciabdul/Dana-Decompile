package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.adapter.viewholder.ProfileMultipleCtaViewHolder;
import id.dana.social.adapter.viewholder.ProfileSingleCtaViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0013\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/adapter/ProfileCtaAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/domain/config/model/ProfileCtaConfig;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "p0", "<init>", "(Lid/dana/feeds/ui/model/RelationshipItemModel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileCtaAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<ProfileCtaConfig>, ProfileCtaConfig> {
    public RelationshipItemModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.feeds.ui.model.RelationshipItemModel, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ProfileCtaAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.adapter.ProfileCtaAdapter.<init>():void");
    }

    public /* synthetic */ ProfileCtaAdapter(RelationshipItemModel relationshipItemModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : relationshipItemModel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ProfileMultipleCtaViewHolder profileMultipleCtaViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (getPlaceComponentResult() == 1) {
            profileMultipleCtaViewHolder = new ProfileSingleCtaViewHolder(viewGroup);
        } else {
            profileMultipleCtaViewHolder = new ProfileMultipleCtaViewHolder(viewGroup);
        }
        return profileMultipleCtaViewHolder;
    }

    private ProfileCtaAdapter(RelationshipItemModel relationshipItemModel) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = relationshipItemModel;
    }
}

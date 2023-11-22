package id.dana.userpersonalization.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.userpersonalization.view.UserPersonalizationListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0014\u0015\u0016B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/userpersonalization/adapter/UserPersonalizationViewAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "p1", "", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "Lid/dana/userpersonalization/view/UserPersonalizationListView$UserPersonalizationItemListener;", "getAuthRequestContext", "Lid/dana/userpersonalization/view/UserPersonalizationListView$UserPersonalizationItemListener;", "PlaceComponentResult", "<init>", "()V", "Companion", "UserPersonalizationListViewHolder", "UserPersonalizationTitleDescViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserPersonalizationViewAdapter extends BaseRecyclerViewAdapter {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public UserPersonalizationListView.UserPersonalizationItemListener PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return p0;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((UserPersonalizationViewAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        UserPersonalizationTitleDescViewHolder userPersonalizationTitleDescViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            userPersonalizationTitleDescViewHolder = new UserPersonalizationTitleDescViewHolder(viewGroup);
        } else if (i == 1) {
            userPersonalizationTitleDescViewHolder = new UserPersonalizationListViewHolder(viewGroup);
        } else {
            userPersonalizationTitleDescViewHolder = new UserPersonalizationListViewHolder(viewGroup);
        }
        return userPersonalizationTitleDescViewHolder;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0 instanceof UserPersonalizationListViewHolder) {
            ((UserPersonalizationListViewHolder) p0).PlaceComponentResult = this.PlaceComponentResult;
        }
        super.onBindViewHolder((UserPersonalizationViewAdapter) p0, p1);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/userpersonalization/adapter/UserPersonalizationViewAdapter$UserPersonalizationTitleDescViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class UserPersonalizationTitleDescViewHolder extends BaseRecyclerViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserPersonalizationTitleDescViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.view_user_personalization_title_desc, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/userpersonalization/adapter/UserPersonalizationViewAdapter$UserPersonalizationListViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "Lid/dana/userpersonalization/view/UserPersonalizationListView$UserPersonalizationItemListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/userpersonalization/view/UserPersonalizationListView$UserPersonalizationItemListener;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class UserPersonalizationListViewHolder extends BaseRecyclerViewHolder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        UserPersonalizationListView.UserPersonalizationItemListener PlaceComponentResult;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(Object obj) {
            Void r2 = (Void) obj;
            UserPersonalizationListView userPersonalizationListView = (UserPersonalizationListView) this.itemView.findViewById(R.id.viewUserPersonalizationList);
            if (userPersonalizationListView != null) {
                userPersonalizationListView.setUserPersonalizationItemListener(this.PlaceComponentResult);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserPersonalizationListViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.view_user_personalization_list_section, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }
}

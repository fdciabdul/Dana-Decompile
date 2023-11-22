package id.dana.myprofile.mepagerevamp.profilesettings.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.mepagerevamp.profilesettings.viewholder.NewProfileMenuFeedSharingViewHolder;
import id.dana.myprofile.mepagerevamp.profilesettings.viewholder.ProfileSettingsViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuAppVersionViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuAvatarViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuDefferedViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuHeaderViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuShareFeedViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuUserKYBViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuUserServiceViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuUsernameViewHolder;
import id.dana.nearbyme.OnRedirectListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u0013"}, d2 = {"Lid/dana/myprofile/mepagerevamp/profilesettings/adapter/ProfileSettingsAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)I", "getItemViewType", "(I)I", "", "PlaceComponentResult", "(I)Z", "p1", "", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "Lid/dana/nearbyme/OnRedirectListener;", "Lid/dana/nearbyme/OnRedirectListener;", "getAuthRequestContext", "<init>", "(Lid/dana/nearbyme/OnRedirectListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileSettingsAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<SettingModel>, SettingModel> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public OnRedirectListener getAuthRequestContext;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.nearbyme.OnRedirectListener] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ProfileSettingsAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.profilesettings.adapter.ProfileSettingsAdapter.<init>():void");
    }

    public /* synthetic */ ProfileSettingsAdapter(OnRedirectListener onRedirectListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : onRedirectListener);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((ProfileSettingsAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ProfileMenuHeaderViewHolder profileMenuHeaderViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            profileMenuHeaderViewHolder = new ProfileMenuHeaderViewHolder(viewGroup);
        } else if (i == 14) {
            profileMenuHeaderViewHolder = new NewProfileMenuFeedSharingViewHolder(viewGroup, this.getAuthRequestContext);
        } else if (i == 16) {
            profileMenuHeaderViewHolder = new ProfileMenuUsernameViewHolder(viewGroup);
        } else if (i == 19) {
            profileMenuHeaderViewHolder = new ProfileSettingsViewHolder(viewGroup, this.getAuthRequestContext);
        } else if (i == 3) {
            profileMenuHeaderViewHolder = new ProfileMenuUserKYBViewHolder(viewGroup);
        } else if (i == 4) {
            profileMenuHeaderViewHolder = new ProfileMenuAppVersionViewHolder(viewGroup);
        } else if (i == 5) {
            profileMenuHeaderViewHolder = new ProfileMenuAvatarViewHolder(viewGroup);
        } else if (i == 7) {
            profileMenuHeaderViewHolder = new ProfileMenuDefferedViewHolder(viewGroup);
        } else if (i == 8) {
            profileMenuHeaderViewHolder = new ProfileMenuShareFeedViewHolder(viewGroup);
        } else {
            profileMenuHeaderViewHolder = new ProfileMenuUserServiceViewHolder(viewGroup);
        }
        return profileMenuHeaderViewHolder;
    }

    public ProfileSettingsAdapter(OnRedirectListener onRedirectListener) {
        this.getAuthRequestContext = onRedirectListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItem(p0).getViewType();
    }

    public final boolean PlaceComponentResult(int p0) {
        return p0 == -1 || p0 >= getItems().size();
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder<SettingModel> p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onBindViewHolder((ProfileSettingsAdapter) p0, p1);
        p0.setIsRecyclable(false);
        p0.bindData(getItems().get(p1));
    }

    public final int MyBillsEntityDataFactory(String p0) {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            SettingModel item = getItem(i);
            if (!item.isNullObject() && Intrinsics.areEqual(p0, item.getName())) {
                return i;
            }
        }
        return -1;
    }
}

package id.dana.myprofile.mepagerevamp.securitysettings.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.mepagerevamp.securitysettings.viewholder.NewProfileMenuFaceAuthViewHolder;
import id.dana.myprofile.mepagerevamp.securitysettings.viewholder.ProfileMenuLocationPermissionViewHolder;
import id.dana.myprofile.mepagerevamp.securitysettings.viewholder.SecuritySettingsPasskeyViewHolder;
import id.dana.myprofile.mepagerevamp.securitysettings.viewholder.SecuritySettingsViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuDefferedViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuUserServiceViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\f2\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/myprofile/mepagerevamp/securitysettings/adapter/SecuritySettingsAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)I", "getItemViewType", "(I)I", "p1", "", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "Landroid/view/ViewGroup;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SecuritySettingsAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<SettingModel>, SettingModel> {
    public ViewGroup KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((SecuritySettingsAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ProfileMenuDefferedViewHolder profileMenuDefferedViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewGroup;
        if (i == 7) {
            profileMenuDefferedViewHolder = new ProfileMenuDefferedViewHolder(viewGroup);
        } else if (i == 9) {
            profileMenuDefferedViewHolder = new NewProfileMenuFaceAuthViewHolder(viewGroup);
        } else if (i == 19) {
            profileMenuDefferedViewHolder = new SecuritySettingsViewHolder(viewGroup);
        } else if (i == 28) {
            profileMenuDefferedViewHolder = new ProfileMenuLocationPermissionViewHolder(viewGroup);
        } else if (i == 29) {
            profileMenuDefferedViewHolder = new SecuritySettingsPasskeyViewHolder(viewGroup);
        } else {
            profileMenuDefferedViewHolder = new ProfileMenuUserServiceViewHolder(viewGroup);
        }
        return profileMenuDefferedViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItem(p0).getViewType();
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder<SettingModel> p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.setIsRecyclable(false);
        super.onBindViewHolder((SecuritySettingsAdapter) p0, p1);
    }

    public final int BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
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

package id.dana.myprofile.mepagerevamp.securitysettings.viewholder;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView;
import id.dana.myprofile.viewholder.ProfileMenuUserServiceViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/myprofile/mepagerevamp/securitysettings/viewholder/SecuritySettingsPasskeyViewHolder;", "Lid/dana/myprofile/viewholder/ProfileMenuUserServiceViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/domain/profilemenu/model/SettingModel;)V", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SecuritySettingsPasskeyViewHolder extends ProfileMenuUserServiceViewHolder {
    @Override // id.dana.myprofile.viewholder.ProfileMenuUserServiceViewHolder, id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        bindData((SettingModel) obj);
    }

    public SecuritySettingsPasskeyViewHolder(ViewGroup viewGroup) {
        super(viewGroup);
    }

    @Override // id.dana.myprofile.viewholder.ProfileMenuUserServiceViewHolder
    /* renamed from: MyBillsEntityDataFactory */
    public final void bindData(SettingModel p0) {
        super.bindData(p0);
        String string = Intrinsics.areEqual(p0 != null ? p0.getEnrolmentState() : null, NewSwitchFaceAuthenticationView.NOT_ENROLLED) ? getContext().getString(R.string.passkey_security_setting_activate) : "";
        Intrinsics.checkNotNullExpressionValue(string, "");
        getBinding().MyBillsEntityDataFactory.setSubTitle(string, p0 != null ? p0.getSubtitleIsBelow() : null, p0 != null ? p0.getSubtitleColor() : null);
    }
}

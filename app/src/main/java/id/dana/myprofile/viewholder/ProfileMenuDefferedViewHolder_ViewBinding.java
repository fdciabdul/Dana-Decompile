package id.dana.myprofile.viewholder;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.profile.ProfileSettingUserServiceView;

/* loaded from: classes9.dex */
public class ProfileMenuDefferedViewHolder_ViewBinding implements Unbinder {
    private ProfileMenuDefferedViewHolder BuiltInFictitiousFunctionClassFactory;

    public ProfileMenuDefferedViewHolder_ViewBinding(ProfileMenuDefferedViewHolder profileMenuDefferedViewHolder, View view) {
        this.BuiltInFictitiousFunctionClassFactory = profileMenuDefferedViewHolder;
        profileMenuDefferedViewHolder.viewProfileSetting = (ProfileSettingUserServiceView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_profile_setting_user_service, "field 'viewProfileSetting'", ProfileSettingUserServiceView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ProfileMenuDefferedViewHolder profileMenuDefferedViewHolder = this.BuiltInFictitiousFunctionClassFactory;
        if (profileMenuDefferedViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        profileMenuDefferedViewHolder.viewProfileSetting = null;
    }
}

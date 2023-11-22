package id.dana.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import id.dana.richview.profile.ProfileSettingUserServiceView;

/* loaded from: classes4.dex */
public final class ItemProfileSettingUserServiceBinding implements ViewBinding {
    public final ProfileSettingUserServiceView MyBillsEntityDataFactory;
    private final ProfileSettingUserServiceView getAuthRequestContext;

    private ItemProfileSettingUserServiceBinding(ProfileSettingUserServiceView profileSettingUserServiceView, ProfileSettingUserServiceView profileSettingUserServiceView2) {
        this.getAuthRequestContext = profileSettingUserServiceView;
        this.MyBillsEntityDataFactory = profileSettingUserServiceView2;
    }

    public static ItemProfileSettingUserServiceBinding MyBillsEntityDataFactory(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ProfileSettingUserServiceView profileSettingUserServiceView = (ProfileSettingUserServiceView) view;
        return new ItemProfileSettingUserServiceBinding(profileSettingUserServiceView, profileSettingUserServiceView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}

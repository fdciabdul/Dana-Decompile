package id.dana.richview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;

/* loaded from: classes9.dex */
public class SimpleProfileWithQrView_ViewBinding implements Unbinder {
    private SimpleProfileWithQrView KClassImpl$Data$declaredNonStaticMembers$2;

    public SimpleProfileWithQrView_ViewBinding(SimpleProfileWithQrView simpleProfileWithQrView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = simpleProfileWithQrView;
        simpleProfileWithQrView.phoneNumber = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_phone_number, "field 'phoneNumber'", TextView.class);
        simpleProfileWithQrView.profileImageView = (CircleImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4078x49e4d33e, "field 'profileImageView'", CircleImageView.class);
        simpleProfileWithQrView.userName = (ProfileNameTextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4208text_user_name, "field 'userName'", ProfileNameTextView.class);
        simpleProfileWithQrView.ivDanaPremium = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3883iv_dana_premium, "field 'ivDanaPremium'", ImageView.class);
        simpleProfileWithQrView.profileAvatarShadowOverlay = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4079xce2d0a5d, "field 'profileAvatarShadowOverlay'", ImageView.class);
        simpleProfileWithQrView.vgProfileWithQrShow = (ViewGroup) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4562vg_profile_with_qr_show, "field 'vgProfileWithQrShow'", ViewGroup.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SimpleProfileWithQrView simpleProfileWithQrView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (simpleProfileWithQrView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        simpleProfileWithQrView.phoneNumber = null;
        simpleProfileWithQrView.profileImageView = null;
        simpleProfileWithQrView.userName = null;
        simpleProfileWithQrView.ivDanaPremium = null;
        simpleProfileWithQrView.profileAvatarShadowOverlay = null;
        simpleProfileWithQrView.vgProfileWithQrShow = null;
    }
}

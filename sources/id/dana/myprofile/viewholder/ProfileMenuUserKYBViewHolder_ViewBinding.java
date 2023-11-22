package id.dana.myprofile.viewholder;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.KybCardView;

/* loaded from: classes9.dex */
public class ProfileMenuUserKYBViewHolder_ViewBinding implements Unbinder {
    private ProfileMenuUserKYBViewHolder KClassImpl$Data$declaredNonStaticMembers$2;

    public ProfileMenuUserKYBViewHolder_ViewBinding(ProfileMenuUserKYBViewHolder profileMenuUserKYBViewHolder, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = profileMenuUserKYBViewHolder;
        profileMenuUserKYBViewHolder.kybCardView = (KybCardView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cardview_kyb, "field 'kybCardView'", KybCardView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ProfileMenuUserKYBViewHolder profileMenuUserKYBViewHolder = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (profileMenuUserKYBViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        profileMenuUserKYBViewHolder.kybCardView = null;
    }
}

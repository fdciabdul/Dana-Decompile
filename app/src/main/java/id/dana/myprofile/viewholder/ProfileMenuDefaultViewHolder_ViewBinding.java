package id.dana.myprofile.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class ProfileMenuDefaultViewHolder_ViewBinding implements Unbinder {
    private ProfileMenuDefaultViewHolder getAuthRequestContext;

    public ProfileMenuDefaultViewHolder_ViewBinding(ProfileMenuDefaultViewHolder profileMenuDefaultViewHolder, View view) {
        this.getAuthRequestContext = profileMenuDefaultViewHolder;
        profileMenuDefaultViewHolder.title = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title, "field 'title'", TextView.class);
        profileMenuDefaultViewHolder.clNormalMenu = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_normal_menu, "field 'clNormalMenu'", ConstraintLayout.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ProfileMenuDefaultViewHolder profileMenuDefaultViewHolder = this.getAuthRequestContext;
        if (profileMenuDefaultViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        profileMenuDefaultViewHolder.title = null;
        profileMenuDefaultViewHolder.clNormalMenu = null;
    }
}

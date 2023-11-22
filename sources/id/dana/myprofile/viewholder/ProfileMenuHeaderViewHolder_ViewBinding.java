package id.dana.myprofile.viewholder;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class ProfileMenuHeaderViewHolder_ViewBinding implements Unbinder {
    private ProfileMenuHeaderViewHolder getAuthRequestContext;

    public ProfileMenuHeaderViewHolder_ViewBinding(ProfileMenuHeaderViewHolder profileMenuHeaderViewHolder, View view) {
        this.getAuthRequestContext = profileMenuHeaderViewHolder;
        profileMenuHeaderViewHolder.headerMenu = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_header_menu, "field 'headerMenu'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ProfileMenuHeaderViewHolder profileMenuHeaderViewHolder = this.getAuthRequestContext;
        if (profileMenuHeaderViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        profileMenuHeaderViewHolder.headerMenu = null;
    }
}

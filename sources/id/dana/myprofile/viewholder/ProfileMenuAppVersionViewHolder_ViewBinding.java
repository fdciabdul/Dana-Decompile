package id.dana.myprofile.viewholder;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class ProfileMenuAppVersionViewHolder_ViewBinding implements Unbinder {
    private ProfileMenuAppVersionViewHolder BuiltInFictitiousFunctionClassFactory;

    public ProfileMenuAppVersionViewHolder_ViewBinding(ProfileMenuAppVersionViewHolder profileMenuAppVersionViewHolder, View view) {
        this.BuiltInFictitiousFunctionClassFactory = profileMenuAppVersionViewHolder;
        profileMenuAppVersionViewHolder.title = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title, "field 'title'", TextView.class);
        profileMenuAppVersionViewHolder.tvSubMenu = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_sub_menu, "field 'tvSubMenu'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ProfileMenuAppVersionViewHolder profileMenuAppVersionViewHolder = this.BuiltInFictitiousFunctionClassFactory;
        if (profileMenuAppVersionViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        profileMenuAppVersionViewHolder.title = null;
        profileMenuAppVersionViewHolder.tvSubMenu = null;
    }
}

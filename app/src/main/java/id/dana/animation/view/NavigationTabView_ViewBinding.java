package id.dana.animation.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public class NavigationTabView_ViewBinding implements Unbinder {
    private NavigationTabView getAuthRequestContext;

    public NavigationTabView_ViewBinding(NavigationTabView navigationTabView, View view) {
        this.getAuthRequestContext = navigationTabView;
        navigationTabView.clViewNav = (RelativeLayout) Utils.PlaceComponentResult(view, R.id.cl_view_nav, "field 'clViewNav'", RelativeLayout.class);
        navigationTabView.titleTv = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.nav_tab_title, "field 'titleTv'", TextView.class);
        navigationTabView.tabNotif = (TextView) Utils.PlaceComponentResult(view, R.id.nav_tab_notif, "field 'tabNotif'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void getAuthRequestContext() {
        NavigationTabView navigationTabView = this.getAuthRequestContext;
        if (navigationTabView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        navigationTabView.clViewNav = null;
        navigationTabView.titleTv = null;
        navigationTabView.tabNotif = null;
    }
}

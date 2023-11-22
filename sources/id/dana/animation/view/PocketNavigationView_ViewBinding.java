package id.dana.animation.view;

import android.view.View;
import android.widget.ImageView;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public class PocketNavigationView_ViewBinding extends NavigationTabView_ViewBinding {
    private PocketNavigationView BuiltInFictitiousFunctionClassFactory;

    public PocketNavigationView_ViewBinding(PocketNavigationView pocketNavigationView, View view) {
        super(pocketNavigationView, view);
        this.BuiltInFictitiousFunctionClassFactory = pocketNavigationView;
        pocketNavigationView.tabNotif = (ImageView) Utils.PlaceComponentResult(view, R.id.nav_tab_pocket_notif, "field 'tabNotif'", ImageView.class);
    }

    @Override // id.dana.animation.view.NavigationTabView_ViewBinding, butterknife.Unbinder
    public final void getAuthRequestContext() {
        PocketNavigationView pocketNavigationView = this.BuiltInFictitiousFunctionClassFactory;
        if (pocketNavigationView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        pocketNavigationView.tabNotif = null;
        super.getAuthRequestContext();
    }
}

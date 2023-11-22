package id.dana.richview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class LogoListView_ViewBinding implements Unbinder {
    private LogoListView getAuthRequestContext;

    public LogoListView_ViewBinding(LogoListView logoListView, View view) {
        this.getAuthRequestContext = logoListView;
        logoListView.rvLogo = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rv_logo, "field 'rvLogo'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        LogoListView logoListView = this.getAuthRequestContext;
        if (logoListView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        logoListView.rvLogo = null;
    }
}

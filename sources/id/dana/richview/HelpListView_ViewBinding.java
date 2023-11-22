package id.dana.richview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class HelpListView_ViewBinding implements Unbinder {
    private HelpListView KClassImpl$Data$declaredNonStaticMembers$2;

    public HelpListView_ViewBinding(HelpListView helpListView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = helpListView;
        helpListView.rvHelpList = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rv_help_list, "field 'rvHelpList'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        HelpListView helpListView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (helpListView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        helpListView.rvHelpList = null;
    }
}

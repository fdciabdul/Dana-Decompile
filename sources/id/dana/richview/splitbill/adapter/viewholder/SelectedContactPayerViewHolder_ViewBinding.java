package id.dana.richview.splitbill.adapter.viewholder;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.sendmoney.RecentDetailView;

/* loaded from: classes9.dex */
public class SelectedContactPayerViewHolder_ViewBinding implements Unbinder {
    private SelectedContactPayerViewHolder BuiltInFictitiousFunctionClassFactory;

    public SelectedContactPayerViewHolder_ViewBinding(SelectedContactPayerViewHolder selectedContactPayerViewHolder, View view) {
        this.BuiltInFictitiousFunctionClassFactory = selectedContactPayerViewHolder;
        selectedContactPayerViewHolder.recentDetailView = (RecentDetailView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_recent_detail, "field 'recentDetailView'", RecentDetailView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SelectedContactPayerViewHolder selectedContactPayerViewHolder = this.BuiltInFictitiousFunctionClassFactory;
        if (selectedContactPayerViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        selectedContactPayerViewHolder.recentDetailView = null;
    }
}

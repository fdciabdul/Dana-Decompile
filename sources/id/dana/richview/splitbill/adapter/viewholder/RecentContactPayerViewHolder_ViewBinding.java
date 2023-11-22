package id.dana.richview.splitbill.adapter.viewholder;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.sendmoney.RecentDetailView;

/* loaded from: classes9.dex */
public class RecentContactPayerViewHolder_ViewBinding implements Unbinder {
    private RecentContactPayerViewHolder getAuthRequestContext;

    public RecentContactPayerViewHolder_ViewBinding(RecentContactPayerViewHolder recentContactPayerViewHolder, View view) {
        this.getAuthRequestContext = recentContactPayerViewHolder;
        recentContactPayerViewHolder.recentDetailView = (RecentDetailView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_recent_detail, "field 'recentDetailView'", RecentDetailView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        RecentContactPayerViewHolder recentContactPayerViewHolder = this.getAuthRequestContext;
        if (recentContactPayerViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        recentContactPayerViewHolder.recentDetailView = null;
    }
}

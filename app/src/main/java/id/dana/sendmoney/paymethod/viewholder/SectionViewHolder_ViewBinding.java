package id.dana.sendmoney.paymethod.viewholder;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class SectionViewHolder_ViewBinding implements Unbinder {
    private SectionViewHolder getAuthRequestContext;

    public SectionViewHolder_ViewBinding(SectionViewHolder sectionViewHolder, View view) {
        this.getAuthRequestContext = sectionViewHolder;
        sectionViewHolder.tvTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SectionViewHolder sectionViewHolder = this.getAuthRequestContext;
        if (sectionViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        sectionViewHolder.tvTitle = null;
    }
}

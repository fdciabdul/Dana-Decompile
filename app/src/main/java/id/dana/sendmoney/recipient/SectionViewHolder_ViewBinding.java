package id.dana.sendmoney.recipient;

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
        sectionViewHolder.tvHeaderSection = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.res_0x7f0a1720_nearbysearchpresenter_getnearbytrendingkeyword_1, "field 'tvHeaderSection'", TextView.class);
        sectionViewHolder.vDivider = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.view_divider, "field 'vDivider'");
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SectionViewHolder sectionViewHolder = this.getAuthRequestContext;
        if (sectionViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        sectionViewHolder.tvHeaderSection = null;
        sectionViewHolder.vDivider = null;
    }
}

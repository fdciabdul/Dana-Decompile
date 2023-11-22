package id.dana.richview;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class RibbonView_ViewBinding implements Unbinder {
    private RibbonView BuiltInFictitiousFunctionClassFactory;

    public RibbonView_ViewBinding(RibbonView ribbonView, View view) {
        this.BuiltInFictitiousFunctionClassFactory = ribbonView;
        ribbonView.ivRibbon = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_ribbon, "field 'ivRibbon'", LinearLayout.class);
        ribbonView.tvRibbonLineTop = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_ribbon_lineTop, "field 'tvRibbonLineTop'", TextView.class);
        ribbonView.tvRibbonLineBottom = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_ribbon_lineBottom, "field 'tvRibbonLineBottom'", TextView.class);
        ribbonView.llLineBottom = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_lineBottom, "field 'llLineBottom'", LinearLayout.class);
        ribbonView.ivInfo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.CircularRevealCoordinatorLayout, "field 'ivInfo'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        RibbonView ribbonView = this.BuiltInFictitiousFunctionClassFactory;
        if (ribbonView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        ribbonView.ivRibbon = null;
        ribbonView.tvRibbonLineTop = null;
        ribbonView.tvRibbonLineBottom = null;
        ribbonView.llLineBottom = null;
        ribbonView.ivInfo = null;
    }
}

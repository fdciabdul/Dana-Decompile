package id.dana.oauth;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class ScopeViewHolder_ViewBinding implements Unbinder {
    private ScopeViewHolder BuiltInFictitiousFunctionClassFactory;

    public ScopeViewHolder_ViewBinding(ScopeViewHolder scopeViewHolder, View view) {
        this.BuiltInFictitiousFunctionClassFactory = scopeViewHolder;
        scopeViewHolder.tvDot = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_dot, "field 'tvDot'", TextView.class);
        scopeViewHolder.tvDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_description, "field 'tvDescription'", TextView.class);
        scopeViewHolder.ivTick = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_tick, "field 'ivTick'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ScopeViewHolder scopeViewHolder = this.BuiltInFictitiousFunctionClassFactory;
        if (scopeViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        scopeViewHolder.tvDot = null;
        scopeViewHolder.tvDescription = null;
        scopeViewHolder.ivTick = null;
    }
}

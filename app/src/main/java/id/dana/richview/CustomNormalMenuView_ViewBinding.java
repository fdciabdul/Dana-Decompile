package id.dana.richview;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class CustomNormalMenuView_ViewBinding implements Unbinder {
    private CustomNormalMenuView BuiltInFictitiousFunctionClassFactory;

    public CustomNormalMenuView_ViewBinding(CustomNormalMenuView customNormalMenuView, View view) {
        this.BuiltInFictitiousFunctionClassFactory = customNormalMenuView;
        customNormalMenuView.rlIcon = (RelativeLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rl_icon, "field 'rlIcon'", RelativeLayout.class);
        customNormalMenuView.ivIcon = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
        customNormalMenuView.tvMenuName = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_menu_name, "field 'tvMenuName'", TextView.class);
        customNormalMenuView.tvNotif = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_notif, "field 'tvNotif'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        CustomNormalMenuView customNormalMenuView = this.BuiltInFictitiousFunctionClassFactory;
        if (customNormalMenuView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        customNormalMenuView.rlIcon = null;
        customNormalMenuView.ivIcon = null;
        customNormalMenuView.tvMenuName = null;
        customNormalMenuView.tvNotif = null;
    }
}

package id.dana.base;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.WebProgressView;

/* loaded from: classes8.dex */
public class BaseWebViewActivity_ViewBinding implements Unbinder {
    private BaseWebViewActivity getAuthRequestContext;

    public BaseWebViewActivity_ViewBinding(BaseWebViewActivity baseWebViewActivity, View view) {
        this.getAuthRequestContext = baseWebViewActivity;
        baseWebViewActivity.webProgressView = (WebProgressView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_web_progress, "field 'webProgressView'", WebProgressView.class);
    }

    @Override // butterknife.Unbinder
    public void getAuthRequestContext() {
        BaseWebViewActivity baseWebViewActivity = this.getAuthRequestContext;
        if (baseWebViewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        baseWebViewActivity.webProgressView = null;
    }
}

package com.alibaba.ariver.app.extensions;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppRestartResult;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.point.app.AppRestartPoint;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alipay.iap.android.aplog.log.spm.SpmTrackIntegrator;

/* loaded from: classes6.dex */
public class AppRestartExtension implements AppRestartPoint {

    /* renamed from: a  reason: collision with root package name */
    private String f5980a = null;
    private String b = null;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppRestartPoint
    public AppRestartResult onAppRestart(App app, Bundle bundle, Bundle bundle2) {
        AppRestartResult appRestartResult = new AppRestartResult();
        if (this.b == null) {
            this.b = a(app.getStartParams(), app.getSceneParams());
        }
        appRestartResult.startParam = bundle;
        appRestartResult.closeAllWindow = true;
        appRestartResult.canRestart = true;
        if (!app.isTinyApp()) {
            ParamUtils.unify(bundle, "url", false);
            String string = BundleUtils.getString(bundle, "url");
            StringBuilder sb = new StringBuilder();
            sb.append("onAppRestart for h5 app , url = ");
            sb.append(string);
            RVLogger.d("AriverApp:AppRestartExtension", sb.toString());
            appRestartResult.startUrl = string;
        } else {
            String purifyUrl = UrlUtils.purifyUrl(app.getStartUrl());
            if (purifyUrl != null && a(app, bundle, bundle2)) {
                bundle.putBoolean(RVConstants.EXTRA_START_FROM_RELAUNCH, true);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(purifyUrl);
                sb2.append("#");
                sb2.append(this.f5980a);
                appRestartResult.startUrl = sb2.toString();
            } else {
                appRestartResult.canRestart = false;
            }
        }
        return appRestartResult;
    }

    private boolean a(App app, Bundle bundle, Bundle bundle2) {
        if (bundle == null || bundle.getBoolean("IS_LITE_MOVE_TASK", false) || RVConstants.CHINFO_NAVIGATE_BACK.equalsIgnoreCase(bundle.getString(RVStartParams.KEY_CHINFO)) || "YES".equalsIgnoreCase(bundle.getString(RVStartParams.KEY_DISABLE_RELAUNCH))) {
            return false;
        }
        String a2 = a(bundle, bundle2);
        String str = this.b;
        this.b = a2;
        String string = bundle.getString("page");
        if (TextUtils.isEmpty(string)) {
            String a3 = a(app);
            if (TextUtils.isEmpty(a3)) {
                return false;
            }
            if (TextUtils.isEmpty(a2) && TextUtils.isEmpty(str)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("needRelaunch targetPage: ");
            sb.append(string);
            sb.append(" homePage: ");
            sb.append(a3);
            sb.append(" chInfo: ");
            sb.append(a2);
            sb.append(" lastChInfo: ");
            sb.append(str);
            RVLogger.d("AriverApp:AppRestartExtension", sb.toString());
            return TextUtils.isEmpty(str) || !str.equals(a2);
        }
        return false;
    }

    private String a(App app) {
        if (!TextUtils.isEmpty(this.f5980a)) {
            return this.f5980a;
        }
        AppConfigModel appConfigModel = (AppConfigModel) app.getData(AppConfigModel.class);
        if (appConfigModel == null) {
            return this.f5980a;
        }
        if (appConfigModel.getPages() != null && appConfigModel.getPages().size() > 0) {
            this.f5980a = appConfigModel.getPages().get(0);
        }
        return this.f5980a;
    }

    private static String a(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString(RVStartParams.KEY_CHINFO);
        if (TextUtils.isEmpty(string)) {
            string = BundleUtils.getString(bundle2, RVStartParams.KEY_CHINFO);
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        int indexOf = string.indexOf(SpmTrackIntegrator.SEPARATOR_CHAR);
        return indexOf > 0 ? string.substring(0, indexOf) : string;
    }
}

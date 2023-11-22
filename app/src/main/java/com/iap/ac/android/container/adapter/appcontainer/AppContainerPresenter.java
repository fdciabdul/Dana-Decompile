package com.iap.ac.android.container.adapter.appcontainer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alipay.mobile.framework.LauncherApplicationAgent;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.ui.H5NetworkCheckActivity;
import com.iap.ac.android.common.container.IContainerPresenter;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.container.js.plugin.ACContainerJSPlugin;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.analytics.tracker.TrackerKey;
import java.util.Map;

/* loaded from: classes8.dex */
public class AppContainerPresenter implements IContainerPresenter {
    private static final String TAG = "AppContainerPresenter";
    private H5BridgeContext bridgeContext;
    private H5Event h5Event;

    public AppContainerPresenter(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        this.h5Event = h5Event;
        this.bridgeContext = h5BridgeContext;
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void setTitle(String str) {
        H5Event h5Event = this.h5Event;
        if (h5Event == null || h5Event.getH5page() == null) {
            return;
        }
        this.h5Event.getH5page().setTitle(str);
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void reloadPage() {
        H5Event h5Event = this.h5Event;
        if (h5Event == null || h5Event.getH5page() == null || this.h5Event.getH5page().getWebView() == null) {
            return;
        }
        this.h5Event.getH5page().getWebView().reload();
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void loadUrl(String str) {
        H5Event h5Event = this.h5Event;
        if (h5Event == null || h5Event.getH5page() == null) {
            return;
        }
        this.h5Event.getH5page().loadUrl(str);
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void postUrl(String str, byte[] bArr) {
        H5Event h5Event = this.h5Event;
        if (h5Event == null || h5Event.getH5page() == null || this.h5Event.getH5page().getWebView() == null) {
            return;
        }
        this.h5Event.getH5page().getWebView().postUrl(str, bArr);
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void closeWebview() {
        if (Nebula.getService() == null) {
            return;
        }
        Nebula.getService().exitService();
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void showNetWorkCheckActivity(Map<String, String> map) {
        H5Event h5Event;
        if (map == null || map.isEmpty() || (h5Event = this.h5Event) == null || h5Event.getActivity() == null) {
            return;
        }
        Intent intent = new Intent(H5Environment.getContext(), H5NetworkCheckActivity.class);
        String str = map.get(TrackerKey.Property.ERROR_CODE_FIREBASE);
        String str2 = map.get("url");
        String str3 = map.get(ZdocRecordService.REASON);
        intent.putExtra(TrackerKey.Property.ERROR_CODE_FIREBASE, str);
        intent.putExtra("url", str2);
        intent.putExtra(ZdocRecordService.REASON, str3);
        try {
            LauncherApplicationAgent.getInstance().getMicroApplicationContext().startActivity(LauncherApplicationAgent.getInstance().getMicroApplicationContext().findTopRunningApp(), intent);
        } catch (Exception e) {
            ACLog.e(TAG, ACContainerJSPlugin.SHOW_NETWORK_CHECK_ACTIVITY, e);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public Context getContext() {
        H5Event h5Event = this.h5Event;
        if (h5Event != null) {
            return h5Event.getActivity();
        }
        return null;
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public Activity getActivity() {
        H5Event h5Event = this.h5Event;
        if (h5Event != null) {
            return h5Event.getActivity();
        }
        return null;
    }
}

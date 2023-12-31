package com.iap.ac.android.container.js.plugin;

import com.iap.ac.android.common.container.IContainerPresenter;
import com.iap.ac.android.common.container.js.AlipayJSAPI;
import com.iap.ac.android.common.container.js.ContainerBridgeContext;
import com.iap.ac.android.common.container.js.plugin.BaseJSPlugin;
import com.iap.ac.android.common.log.ACLog;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ACContainerJSPlugin extends BaseJSPlugin {
    private static final String ADD_NOTIFY_LISTENER = "addNotifyListener";
    private static final String JSAPI_CLOSE_WEBVIEW = "closeWebview";
    private static final String JSAPI_RELOAD_PAGE = "h5PageReload";
    private static final String JSAPI_SET_TITLE = "setTitle";
    private static final String POST_NOTIFICATION = "postNotification";
    private static final String REMOVE_NOTIFY_LISTENER = "removeNotifyListener";
    public static final String SHOW_NETWORK_CHECK_ACTIVITY = "showNetWorkCheckActivity";
    private static final String TAG = "ACContainerJSPlugin";

    @AlipayJSAPI(api = "setTitle")
    public Map<String, String> setTitle(Map<String, String> map, IContainerPresenter iContainerPresenter, ContainerBridgeContext containerBridgeContext) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (checkContainerPresenterExist(hashMap, iContainerPresenter)) {
            String str = map.get("title");
            StringBuilder sb = new StringBuilder();
            sb.append("setTitle title = ");
            sb.append(str);
            sb.append(", subTitle = ");
            sb.append(map.get("subtitle"));
            ACLog.d(TAG, sb.toString());
            iContainerPresenter.setTitle(str);
            hashMap.put("success", SummaryActivity.CHECKED);
            return hashMap;
        }
        return hashMap;
    }

    @AlipayJSAPI(api = JSAPI_RELOAD_PAGE)
    public Map<String, String> reloadPage(Map<String, String> map, IContainerPresenter iContainerPresenter, ContainerBridgeContext containerBridgeContext) {
        HashMap hashMap = new HashMap();
        if (checkContainerPresenterExist(hashMap, iContainerPresenter)) {
            iContainerPresenter.reloadPage();
            ACLog.d(TAG, "reloadPage... ");
            setResultSuccess(hashMap);
            return hashMap;
        }
        return hashMap;
    }

    @AlipayJSAPI(api = JSAPI_CLOSE_WEBVIEW)
    public void closeWebview(Map<String, String> map, IContainerPresenter iContainerPresenter, ContainerBridgeContext containerBridgeContext) {
        if (checkContainerPresenterExist(new HashMap(), iContainerPresenter)) {
            ACLog.d(TAG, "closeWebview...");
            iContainerPresenter.closeWebview();
        }
    }

    @AlipayJSAPI(api = SHOW_NETWORK_CHECK_ACTIVITY)
    public void showNetWorkCheckActivity(Map<String, String> map, IContainerPresenter iContainerPresenter, ContainerBridgeContext containerBridgeContext) {
        if (iContainerPresenter == null) {
            return;
        }
        ACLog.d(TAG, "showNetWorkCheckActivity...");
        iContainerPresenter.showNetWorkCheckActivity(map);
    }

    @Override // com.iap.ac.android.common.container.js.plugin.BaseJSPlugin
    public Class<? extends BaseJSPlugin> getJSPluginClass() {
        return ACContainerJSPlugin.class;
    }
}

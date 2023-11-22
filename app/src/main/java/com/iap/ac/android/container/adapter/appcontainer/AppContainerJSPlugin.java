package com.iap.ac.android.container.adapter.appcontainer;

import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.iap.ac.android.common.container.js.model.JSBridgeMessageToNative;
import com.iap.ac.android.common.container.js.plugin.BaseJSPlugin;
import com.iap.ac.android.common.log.ACLog;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AppContainerJSPlugin extends H5SimplePlugin {
    private static final String PARAMS_KEY_SUCCESS = "success";
    private static final String TAG = "AppContainerJSPlugin";
    private BaseJSPlugin plugin;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContainerJSPlugin(BaseJSPlugin baseJSPlugin) {
        this.plugin = baseJSPlugin;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        BaseJSPlugin baseJSPlugin = this.plugin;
        if (baseJSPlugin == null) {
            ACLog.w(TAG, "onPrepare plugin is null!");
        } else if (h5EventFilter == null) {
            ACLog.w(TAG, "onPrepare: filter is null!");
        } else {
            List<String> jsApiList = baseJSPlugin.getJsApiList();
            if (jsApiList == null || jsApiList.isEmpty()) {
                ACLog.d(TAG, "onPrepare jsApiList is empty.");
                return;
            }
            for (String str : jsApiList) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPrepare action: ");
                sb.append(str);
                ACLog.d(TAG, sb.toString());
                h5EventFilter.addAction(str);
            }
        }
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (h5Event == null) {
            return super.handleEvent(h5Event, h5BridgeContext);
        }
        if (this.plugin == null) {
            ACLog.w(TAG, "onPrepare plugin is null!");
            return super.handleEvent(h5Event, h5BridgeContext);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("handleEvent action: ");
        sb.append(h5Event.getAction());
        ACLog.d(TAG, sb.toString());
        JSBridgeMessageToNative jSBridgeMessageToNative = new JSBridgeMessageToNative();
        jSBridgeMessageToNative.func = h5Event.getAction();
        jSBridgeMessageToNative.param = ContainerUtils.fastJsonToJson(h5Event.getParam());
        try {
            JSONObject onJSEvent = this.plugin.onJSEvent(jSBridgeMessageToNative, new AppContainerPresenter(h5Event, h5BridgeContext), new AppContainerBridgeContext(h5Event, h5BridgeContext));
            if (onJSEvent != null) {
                h5BridgeContext.sendBridgeResult(ContainerUtils.jsonObjectToFastJson(onJSEvent));
                return true;
            }
            return true;
        } catch (Exception e) {
            ACLog.e(TAG, "handleEvent error: ", e);
            return super.handleEvent(h5Event, h5BridgeContext);
        }
    }
}

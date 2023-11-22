package com.alibaba.griver.core.update;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.ui.GriverAppExtension;
import com.alibaba.griver.base.api.GriverAsyncUpdateManager;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.liteprocess.LiteProcessManager;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class GriverAsyncUpdateManagerImpl implements GriverAsyncUpdateManager {
    private static final String ON_CHECK_FOR_UPDATE = "checkForUpdate";
    private static final String ON_UPDATE_FAILED = "updateFailed";
    private static final String ON_UPDATE_READY = "updateReady";
    private static final String TAG = "GriverAsyncUpdateManagerImpl";
    private String appId;
    public static volatile Map<String, Boolean> sRegisteredUpdateManager = new ConcurrentHashMap();
    public static volatile Map<String, JSONObject> sMessageCacheManager = new ConcurrentHashMap();

    @Override // com.alibaba.griver.base.api.GriverAsyncUpdateManager
    public String getAppId() {
        return this.appId;
    }

    @Override // com.alibaba.griver.base.api.GriverAsyncUpdateManager
    public void setAppId(String str) {
        this.appId = str;
    }

    private boolean hasRegisterUpdateManager() {
        Boolean bool = sRegisteredUpdateManager.get(this.appId);
        return bool != null && bool.booleanValue();
    }

    @Override // com.alibaba.griver.base.api.GriverAsyncUpdateManager
    public void onUpdateResult(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onUpdateResult...result: ");
        sb.append(z);
        GriverLogger.d(TAG, sb.toString());
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("data", (Object) jSONObject2);
        if (z) {
            jSONObject2.put("hasUpdate", (Object) Boolean.TRUE);
        } else {
            jSONObject2.put("hasUpdate", (Object) Boolean.FALSE);
        }
        sendToRender(ON_CHECK_FOR_UPDATE, jSONObject);
    }

    @Override // com.alibaba.griver.base.api.GriverAsyncUpdateManager
    public void onDownloadResult(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onDownloadResult...result: ");
        sb.append(z);
        GriverLogger.d(TAG, sb.toString());
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("data", (Object) jSONObject2);
        if (z) {
            jSONObject2.put("success", (Object) Boolean.TRUE);
            sendToRender(ON_UPDATE_READY, jSONObject);
            return;
        }
        jSONObject2.put("success", (Object) Boolean.FALSE);
        sendToRender(ON_UPDATE_FAILED, jSONObject);
    }

    @Override // com.alibaba.griver.base.api.GriverAsyncUpdateManager
    public void sendToRender(String str, JSONObject jSONObject) {
        if (hasRegisterUpdateManager()) {
            App appByAppId = ((GriverAppExtension) RVProxy.get(GriverAppExtension.class)).getAppByAppId(this.appId);
            if (appByAppId == null || appByAppId.getActivePage() == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("sendToRender action == ");
            sb.append(str);
            GriverLogger.d(TAG, sb.toString());
            EngineUtils.sendToRender(appByAppId.getActivePage().getRender(), str, jSONObject, null);
            return;
        }
        if (TextUtils.equals(str, ON_CHECK_FOR_UPDATE) && sMessageCacheManager.size() > 0) {
            sMessageCacheManager.clear();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sendToRender cache action == ");
        sb2.append(str);
        GriverLogger.d(TAG, sb2.toString());
        sMessageCacheManager.put(str, jSONObject);
        if (ProcessUtils.isMainProcess()) {
            Bundle bundle = new Bundle();
            bundle.putString("appId", this.appId);
            bundle.putString("updateAction", str);
            bundle.putSerializable("updateParam", JSON.toJSONString(jSONObject));
            LiteProcessManager.getInstance().sendMessage(this.appId, 9002, bundle);
        }
    }

    public static void sendCacheMessageToRender(App app) {
        if (sMessageCacheManager.size() == 0) {
            return;
        }
        for (String str : sMessageCacheManager.keySet()) {
            if (app != null && app.getActivePage() != null) {
                EngineUtils.sendToRender(app.getActivePage().getRender(), str, sMessageCacheManager.get(str), null);
            }
        }
        sMessageCacheManager.clear();
    }

    public static void register(String str) {
        sRegisteredUpdateManager.put(str, Boolean.TRUE);
    }

    public static void unRegister(String str) {
        sRegisteredUpdateManager.clear();
    }
}

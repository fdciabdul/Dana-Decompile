package com.iap.ac.config.lite.c;

import android.os.SystemClock;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alipay.iap.android.f2fpay.components.defaults.DefaultInitializeComponent;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.common.KVBuilder;
import com.iap.ac.config.lite.facade.request.AmcsConfigRpcRequest;
import com.iap.ac.config.lite.facade.request.AmcsConfigRpcV1Request;
import com.iap.ac.config.lite.facade.result.AmcsConfigRpcResult;
import com.iap.ac.config.lite.fetcher.FetchException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class b {
    private static final String b = com.iap.ac.config.lite.d.e.b("ConfigFetchTask");

    /* renamed from: a  reason: collision with root package name */
    protected ConfigCenterContext f7627a;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(ConfigCenterContext configCenterContext) {
        this.f7627a = configCenterContext;
    }

    private List<String> b() {
        return Arrays.asList("1002", "6667");
    }

    private AmcsConfigRpcResult c(String str, JSONObject jSONObject) throws FetchException {
        try {
            AmcsConfigRpcResult b2 = b(str, jSONObject);
            if (b2 != null) {
                if (b2.success) {
                    return b2;
                }
                throw new FetchException(b2.errorCode, b2.errorMessage);
            }
            throw new FetchException("rpc_result_is_null");
        } catch (Throwable th) {
            throw com.iap.ac.config.lite.d.e.a(th, true);
        }
    }

    public final AmcsConfigRpcResult a(String str, JSONObject jSONObject) throws FetchException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            AmcsConfigRpcResult c = c(str, jSONObject);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            ACLog.d(b, String.format("[%s] Fetch config success! increment = %s, responseTime = %s, duration = %s.", a(), Boolean.valueOf(c.increment), c.responseTime, Long.valueOf(elapsedRealtime2)));
            a(KVBuilder.newBuilder().put("version", c.responseTime).put("duration", Long.valueOf(elapsedRealtime2)).put("updateCount", Integer.valueOf(c.updateKeys != null ? c.updateKeys.length() : 0)), c);
            return c;
        } catch (FetchException e) {
            long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
            ACLog.d(b, String.format("[%s] Fetch config failed! errorCode = %s, errorMessage = %s, duration = %s.", a(), e.errorCode, e.errorMessage, Long.valueOf(elapsedRealtime3)));
            a(KVBuilder.newBuilder().put("errorCode", e.errorCode).put("errorMessage", e.errorMessage).put("duration", Long.valueOf(elapsedRealtime3)));
            throw e;
        }
    }

    public abstract String a();

    protected abstract void a(KVBuilder kVBuilder);

    protected abstract void a(KVBuilder kVBuilder, AmcsConfigRpcResult amcsConfigRpcResult);

    protected abstract AmcsConfigRpcResult b(String str, JSONObject jSONObject) throws Exception;

    public String toString() {
        return String.format("[%s]", a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AmcsConfigRpcRequest amcsConfigRpcRequest, JSONObject jSONObject) {
        if (amcsConfigRpcRequest == null) {
            return;
        }
        amcsConfigRpcRequest.tntInstId = this.f7627a.getTntInstId();
        amcsConfigRpcRequest.appId = this.f7627a.getAppId();
        amcsConfigRpcRequest.workspaceId = this.f7627a.getWorkspaceId();
        amcsConfigRpcRequest.addParameters(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AmcsConfigRpcV1Request amcsConfigRpcV1Request, JSONObject jSONObject) {
        if (amcsConfigRpcV1Request == null) {
            return;
        }
        amcsConfigRpcV1Request.productId = com.iap.ac.config.lite.d.e.a((Iterator<? extends CharSequence>) Arrays.asList(this.f7627a.getAppId(), DefaultInitializeComponent.PLATFORM_TYPE, this.f7627a.getWorkspaceId()).iterator(), '_');
        amcsConfigRpcV1Request.utdid = jSONObject.optString("utdid");
        amcsConfigRpcV1Request.reference = jSONObject.optString("reference");
        amcsConfigRpcV1Request.mobileModel = jSONObject.optString("mobileModel");
        amcsConfigRpcV1Request.osVersion = jSONObject.optString("osVersion");
        amcsConfigRpcV1Request.clientVersion = jSONObject.optString(TinyAppLogUtil.TINY_APP_STANDARD_EXTRA_CLIENTVERSION);
        amcsConfigRpcV1Request.business = jSONObject.optString("business", "default");
        amcsConfigRpcV1Request.systemType = jSONObject.optString("systemType");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Map<String, String> map) {
        this.f7627a.getConfigMonitor().behavior(str, map);
    }

    public boolean a(String str) {
        return b().contains(str);
    }
}

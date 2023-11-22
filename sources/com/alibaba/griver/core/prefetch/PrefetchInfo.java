package com.alibaba.griver.core.prefetch;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.rpc.GriverRpcExtension;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class PrefetchInfo {
    private MonitorMap.Builder d;
    private JSONObject g;
    private final JSONObject h;
    private JSONObject j;
    private JSONArray k;

    /* renamed from: a  reason: collision with root package name */
    private long f6436a = 0;
    private long b = 0;
    private long c = 0;
    private final CountDownLatch e = new CountDownLatch(1);
    private PrefetchDownloadStatus f = PrefetchDownloadStatus.PREFETCH_DOWNLOADING;
    private String l = "";
    private Map<String, JSONObject> m = new HashMap();
    private Map<String, JSONObject> i = new ConcurrentHashMap();

    public PrefetchInfo(JSONObject jSONObject, JSONArray jSONArray) {
        this.h = jSONObject;
        this.k = jSONArray;
    }

    public void initMonitor(String str) {
        this.d = new MonitorMap.Builder().appId(str).needAsynAppType(true);
    }

    public void setTimeStamp(String str, String str2) {
        this.d.append(str, str2);
    }

    public void setInfo(String str, String str2) {
        this.d.append(str, str2);
    }

    public void uploadInfo() {
        GriverMonitor.event("prefetch_time_consuming", "GriverAppContainer", this.d.build());
    }

    public JSONObject fetchData(String str) {
        if (this.f == PrefetchDownloadStatus.PREFETCH_DOWNLOADING) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!this.e.await(30L, TimeUnit.SECONDS)) {
                    jSONObject.put("fail", (Object) "request timeout");
                    return jSONObject;
                }
            } catch (InterruptedException unused) {
                jSONObject.put("fail", (Object) "interrupted error");
                return jSONObject;
            }
        }
        return this.m.get(str);
    }

    public String getAPIS() {
        return this.l;
    }

    public long getStartTime() {
        return this.b;
    }

    public long getEndTime() {
        return this.f6436a;
    }

    public long getOpTime() {
        return this.f6436a - this.b;
    }

    public CheckParamStatus checkPara(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        JSONObject jSONObject3 = this.i.get(str);
        if (jSONObject2 != null) {
            for (String str2 : jSONObject2.keySet()) {
                String string = jSONObject2.getString(str2);
                if (jSONObject3.containsKey(str2)) {
                    if (TextUtils.isEmpty(string)) {
                        if (!TextUtils.isEmpty(jSONObject3.getString(str2))) {
                            return CheckParamStatus.CHECK_PARAM_ERROR;
                        }
                    } else if (!string.equals(jSONObject3.getString(str2))) {
                        return CheckParamStatus.CHECK_PARAM_ERROR;
                    }
                } else {
                    return CheckParamStatus.CHECK_PARAM_ERROR;
                }
            }
            return CheckParamStatus.SUCCESS;
        } else if (jSONObject != null) {
            for (String str3 : jSONObject.keySet()) {
                String string2 = jSONObject.getString(str3);
                if (this.j.containsKey(str3)) {
                    if (TextUtils.isEmpty(string2) && !TextUtils.isEmpty(this.j.getString(str3))) {
                        return CheckParamStatus.CHECK_PARAM_ERROR;
                    }
                } else if (!string2.equals(this.j.getString(str3))) {
                    return CheckParamStatus.CHECK_PARAM_ERROR;
                }
            }
            return CheckParamStatus.SUCCESS;
        } else {
            return CheckParamStatus.SUCCESS;
        }
    }

    public long getTime() {
        return this.c;
    }

    public PrefetchDownloadStatus getDownloadStatus() {
        return this.f;
    }

    public void setDownloadStatus(PrefetchDownloadStatus prefetchDownloadStatus) {
        this.f = prefetchDownloadStatus;
    }

    private void a(final String str) {
        String str2;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        PrefetchInfo prefetchInfo = this;
        String str3 = "requestData";
        JSONArray jSONArray3 = prefetchInfo.k;
        if (jSONArray3 == null || jSONArray3.size() == 0) {
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(prefetchInfo.k.size());
        Iterator<Object> it = prefetchInfo.k.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            final String string = jSONObject.getString("name");
            if (jSONObject2 == null || TextUtils.isEmpty(string)) {
                return;
            }
            String string2 = jSONObject2.getJSONObject("config").getString("fetchType");
            if (TextUtils.isEmpty(string2)) {
                GriverLogger.e("PrefetchInfo", "get dependency fail, fetchType is empty");
                return;
            }
            prefetchInfo.i.put(string, JSONUtils.deepCopy(PrefetchUtils.generateRequestData(jSONObject2.getJSONObject("checkParams"))));
            JSONObject jSONObject3 = jSONObject2.getJSONObject("params");
            if (jSONObject3 == null) {
                return;
            }
            if ("rpc".equals(string2)) {
                final Map jsonToMap = JSONUtils.jsonToMap(jSONObject3.getJSONObject(InvoiceConstant.HEADER), new ArrayMap());
                try {
                    jSONArray2 = jSONObject3.getJSONArray(str3);
                } catch (Exception unused) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject(str3);
                    JSONArray jSONArray4 = new JSONArray();
                    jSONArray4.add(jSONObject4);
                    jSONArray2 = jSONArray4;
                }
                final String generateRequestData = PrefetchUtils.generateRequestData(jSONArray2);
                final String string3 = jSONObject3.getString("operationType");
                final String string4 = jSONObject3.getString("gateway");
                str2 = str3;
                ExecutorUtils.execute(ExecutorType.NETWORK, new Runnable() { // from class: com.alibaba.griver.core.prefetch.PrefetchInfo.1
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONObject invokeRpc = ((GriverRpcExtension) RVProxy.get(GriverRpcExtension.class)).invokeRpc(string3, generateRequestData, string4, jsonToMap);
                        if (invokeRpc.getString("success") != null) {
                            PrefetchUtils.setDependencies(string, invokeRpc.getJSONObject("success"));
                            PrefetchInfo.this.m.put(string, invokeRpc.getJSONObject("success"));
                        }
                        countDownLatch.countDown();
                    }
                });
            } else {
                str2 = str3;
            }
            if (SemanticAttributes.FaasTriggerValues.HTTP.equals(string2)) {
                final JSONObject jSONObject5 = jSONObject3.getJSONObject("headers");
                final String string5 = jSONObject3.getString("url");
                final String string6 = jSONObject3.getString("method");
                final int intValue = jSONObject3.getInteger(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT) == null ? 30000 : jSONObject3.getInteger(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT).intValue();
                final String string7 = jSONObject3.getString("dataType");
                try {
                    jSONArray = jSONObject3.getJSONArray("data");
                } catch (Exception unused2) {
                    JSONObject jSONObject6 = jSONObject3.getJSONObject("data");
                    JSONArray jSONArray5 = new JSONArray();
                    jSONArray5.add(jSONObject6);
                    jSONArray = jSONArray5;
                }
                final String generateRequestData2 = PrefetchUtils.generateRequestData(jSONArray);
                ExecutorUtils.execute(ExecutorType.NETWORK, new Runnable() { // from class: com.alibaba.griver.core.prefetch.PrefetchInfo.2
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONObject sendHttp = PrefetchUtils.sendHttp(string5, jSONObject5, string6, generateRequestData2, intValue, string7, str);
                        if (sendHttp.getString("success") != null) {
                            PrefetchUtils.setDependencies(string, sendHttp.getJSONObject("success"));
                            PrefetchInfo.this.m.put(string, sendHttp);
                        }
                        countDownLatch.countDown();
                    }
                });
            }
            prefetchInfo = this;
            str3 = str2;
        }
        try {
            countDownLatch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException unused3) {
            GriverLogger.e("PrefetchInfo", "fetch dependency timeout");
        }
    }

    public void getBackPrefetch(final String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        String string = this.h.getJSONObject("config").getString("fetchType");
        if (TextUtils.isEmpty(string)) {
            GriverLogger.e("PrefetchInfo", "Prefetch fail, fetchType is empty");
            return;
        }
        a(str);
        JSONObject jSONObject = this.h.getJSONObject("params");
        if (jSONObject == null) {
            this.g = null;
            return;
        }
        this.i.put("main", JSONUtils.deepCopy(PrefetchUtils.generateRequestData(this.h.getJSONObject("checkParams"))));
        this.j = PrefetchUtils.generateRequestData(this.h.getJSONObject("params"));
        this.b = SystemClock.elapsedRealtime();
        if ("rpc".equals(string)) {
            final Map jsonToMap = JSONUtils.jsonToMap(jSONObject.getJSONObject("headers"), new ArrayMap());
            try {
                jSONArray2 = jSONObject.getJSONArray("requestData");
            } catch (Exception unused) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("requestData");
                JSONArray jSONArray3 = new JSONArray();
                jSONArray3.add(jSONObject2);
                jSONArray2 = jSONArray3;
            }
            final String generateRequestData = PrefetchUtils.generateRequestData(jSONArray2);
            final String string2 = jSONObject.getString("operationType");
            this.l = string2;
            final String string3 = jSONObject.getString("gateway");
            ExecutorUtils.execute(ExecutorType.NETWORK, new Runnable() { // from class: com.alibaba.griver.core.prefetch.PrefetchInfo.3
                @Override // java.lang.Runnable
                public void run() {
                    PrefetchInfo prefetchInfo = PrefetchInfo.this;
                    prefetchInfo.setTimeStamp("start", String.valueOf(prefetchInfo.b));
                    JSONObject invokeACRpc = ((GriverRpcExtension) RVProxy.get(GriverRpcExtension.class)).invokeACRpc(string2, generateRequestData, string3, jsonToMap);
                    PrefetchInfo.this.c = System.currentTimeMillis();
                    PrefetchInfo.this.f = PrefetchDownloadStatus.PREFETCH_DOWNLOADED;
                    PrefetchInfo.this.g = invokeACRpc;
                    PrefetchInfo.this.m.put("main", PrefetchInfo.this.g);
                    PrefetchInfo.this.e.countDown();
                    PrefetchInfo.this.f6436a = SystemClock.elapsedRealtime();
                    PrefetchInfo prefetchInfo2 = PrefetchInfo.this;
                    prefetchInfo2.setTimeStamp("end", String.valueOf(prefetchInfo2.f6436a));
                }
            });
        }
        if (SemanticAttributes.FaasTriggerValues.HTTP.equals(string)) {
            final JSONObject jSONObject3 = jSONObject.getJSONObject("headers");
            final String string4 = jSONObject.getString("url");
            this.l = string4;
            final String string5 = jSONObject.getString("method");
            int intValue = jSONObject.getInteger(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT) == null ? 30000 : jSONObject.getInteger(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT).intValue();
            final String string6 = jSONObject.getString("dataType");
            try {
                jSONArray = jSONObject.getJSONArray("data");
            } catch (Exception unused2) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("data");
                JSONArray jSONArray4 = new JSONArray();
                jSONArray4.add(jSONObject4);
                jSONArray = jSONArray4;
            }
            final String generateRequestData2 = PrefetchUtils.generateRequestData(jSONArray);
            final int i = intValue;
            ExecutorUtils.execute(ExecutorType.NETWORK, new Runnable() { // from class: com.alibaba.griver.core.prefetch.PrefetchInfo.4
                @Override // java.lang.Runnable
                public void run() {
                    PrefetchInfo prefetchInfo = PrefetchInfo.this;
                    prefetchInfo.setTimeStamp("start", String.valueOf(prefetchInfo.b));
                    JSONObject sendHttp = PrefetchUtils.sendHttp(string4, jSONObject3, string5, generateRequestData2, i, string6, str);
                    PrefetchInfo.this.c = System.currentTimeMillis();
                    PrefetchInfo.this.f = PrefetchDownloadStatus.PREFETCH_DOWNLOADED;
                    PrefetchInfo.this.g = sendHttp;
                    PrefetchInfo.this.m.put("main", PrefetchInfo.this.g);
                    PrefetchInfo.this.e.countDown();
                    PrefetchInfo.this.f6436a = SystemClock.elapsedRealtime();
                    PrefetchInfo prefetchInfo2 = PrefetchInfo.this;
                    prefetchInfo2.setTimeStamp("end", String.valueOf(prefetchInfo2.f6436a));
                }
            });
        }
    }
}

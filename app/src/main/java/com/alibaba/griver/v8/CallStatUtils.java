package com.alibaba.griver.v8;

import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import id.dana.sendmoney.summary.SummaryActivity;

/* loaded from: classes6.dex */
public class CallStatUtils {
    public static final String CALLBACK_TIME_OFFSET = "off3";
    public static final String EXECUTE_TIME_OFFSET = "off2";
    public static final String KEY_CALLSTATDATA = "__ariver_callstatdata";
    public static final String START_DISPATCH_CURRENT_TIMEMILLIS = "tsc";
    public static final String START_DISPATCH_REALTIME = "tsr";
    public static final String TRIGGER_TIME_OFFSET = "off1";

    public static boolean enableCallStatResponse() {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        return rVConfigService != null && SummaryActivity.CHECKED.equalsIgnoreCase(rVConfigService.getConfigWithProcessCache("ta_enable_append_jsapi_callstat", ""));
    }

    public static JSONObject generateCallStat(long j, long j2, NativeCallContext nativeCallContext) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(START_DISPATCH_CURRENT_TIMEMILLIS, (Object) Long.valueOf(j));
            jSONObject.put(START_DISPATCH_REALTIME, (Object) Long.valueOf(j2));
            if (nativeCallContext != null && nativeCallContext.getStatData() != null) {
                if (nativeCallContext.getStatData().triggerTimeStamp > 0) {
                    jSONObject.put(TRIGGER_TIME_OFFSET, (Object) Long.valueOf(nativeCallContext.getStatData().triggerTimeStamp - j2));
                }
                if (nativeCallContext.getStatData().executeTimeStamp > 0) {
                    jSONObject.put(EXECUTE_TIME_OFFSET, (Object) Long.valueOf(nativeCallContext.getStatData().executeTimeStamp - j2));
                }
                if (nativeCallContext.getStatData().callbackTimeStamp > 0) {
                    jSONObject.put(CALLBACK_TIME_OFFSET, (Object) Long.valueOf(nativeCallContext.getStatData().callbackTimeStamp - j2));
                }
            }
            return jSONObject;
        } catch (Throwable th) {
            RVLogger.e("CallStatUtils", "generateCallStat exception!", th);
            return null;
        }
    }
}

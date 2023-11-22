package com.alibaba.ariver.engine.common.track;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class JsApiStatTrackStore {
    private long b;
    private int c;
    private boolean d;

    /* renamed from: a  reason: collision with root package name */
    private String f6047a = "";
    public final Map<String, Object> jsapiStatMap = new ConcurrentHashMap();

    /* loaded from: classes6.dex */
    public static class TinyAppJsApiStatInfo {
        public long beginDispatchTs;
        public long callTs;
        public long dispatchInMainTs;
        public long invokeTs;
        public String name;

        public TinyAppJsApiStatInfo(String str) {
            this.name = str;
        }

        public TinyAppJsApiStatInfo(String str, long j, long j2) {
            this.name = str;
            this.callTs = j;
            this.invokeTs = j2;
        }
    }

    public void clear() {
        this.f6047a = "";
        this.b = 0L;
        this.c = 0;
        this.d = false;
        this.jsapiStatMap.clear();
    }

    public void appendJsApiDetail4TinyWithT2(String str, long j, long j2, long j3, long j4, long j5) {
        try {
            StringBuilder sb = new StringBuilder();
            if (this.b == 0) {
                this.b = j3;
                sb.append("basetime1:");
                sb.append(j3);
                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                sb.append("basetime2:");
                sb.append(j4);
                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            }
            long j6 = j3 - this.b;
            if (j6 > RangedBeacon.DEFAULT_MAX_TRACKING_AGE) {
                return;
            }
            if (this.c >= 100) {
                if (this.f6047a.endsWith("__error_too_long__:0")) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f6047a);
                sb2.append("__error_too_long__:0");
                this.f6047a = sb2.toString();
                return;
            }
            sb.append(str);
            sb.append("_");
            sb.append(j6);
            sb.append(":");
            sb.append(j);
            sb.append("_");
            sb.append(j2);
            sb.append("_");
            sb.append(j5);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.f6047a);
            sb3.append(sb.toString());
            this.f6047a = sb3.toString();
            this.c++;
        } catch (Throwable th) {
            RVLogger.e("JsApiStatTrackStore", "appendJsApiDetail4TinyWithT2 exception", th);
        }
    }

    public String getJsApiDetail4TinyWithT2() {
        if (this.f6047a.length() > 0 && this.f6047a.endsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
            return this.f6047a.substring(0, r0.length() - 1);
        }
        return this.f6047a;
    }

    public void setJsApiDetail4TinyWithinT2Uploaded(boolean z) {
        this.d = z;
    }

    public boolean isJsApiDetail4TinyWithinT2Uploaded() {
        return this.d;
    }
}

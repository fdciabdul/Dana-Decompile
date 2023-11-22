package com.iap.ac.android.common.log;

import android.text.TextUtils;
import com.iap.ac.android.common.log.event.LogEvent;
import com.iap.ac.android.common.log.event.PageLogEvent;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ACMonitor {
    public static final String EVENT_GET_DEFAULT_IMPL = "ac_common_get_monitor_defalut_impl";
    public static final String EVENT_PARAM_KEY_BIZ_CODE = "bizCode";
    public static final String EVENT_PARAM_KEY_ERROR_MSG = "errorMsg";
    public static final String EVENT_PARAM_KEY_MSG = "msg";
    public static final String TAG = "ACMonitor";
    public static IACMonitor iACMonitor;
    public static final Map<String, IACMonitor> monitorMap = new HashMap();
    public static IACMonitor defaultMonitor = new IACMonitor() { // from class: com.iap.ac.android.common.log.ACMonitor.1
        @Override // com.iap.ac.android.common.log.IACMonitor
        public final void flush() {
            ACLog.w(ACMonitor.TAG, "Cannot find iACMonitor implementation. Please setiACMonitor.");
        }

        @Override // com.iap.ac.android.common.log.IACMonitor
        public final void logEvent(LogEvent logEvent) {
            ACLog.w(ACMonitor.TAG, "Cannot find iACMonitor implementation. Please setiACMonitor.");
        }

        @Override // com.iap.ac.android.common.log.IACMonitor
        public final void logPageEvent(PageLogEvent pageLogEvent) {
            ACLog.w(ACMonitor.TAG, "Cannot find iACMonitor implementation. Please setiACMonitor.");
        }

        @Override // com.iap.ac.android.common.log.IACMonitor
        public final void setGlobalParameters(Map<String, String> map) {
            ACLog.w(ACMonitor.TAG, "Cannot find iACMonitor implementation. Please setiACMonitor.");
        }
    };

    public static void flush() {
        IACMonitor iACMonitor2 = iACMonitor;
        if (iACMonitor2 == null) {
            ACLog.w(TAG, "Cannot find iACMonitor implementation. Please setiACMonitor.");
        } else {
            iACMonitor2.flush();
        }
    }

    public static IACMonitor getInstance(String str) {
        if (TextUtils.isEmpty(str)) {
            return getInstance();
        }
        IACMonitor iACMonitor2 = monitorMap.get(str);
        if (iACMonitor2 == null && (iACMonitor2 = iACMonitor) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bizCode", str);
            hashMap.put("msg", "Cannot find the implemetation for this bizCode. Using default instead.");
            LogEvent logEvent = new LogEvent(EVENT_GET_DEFAULT_IMPL, hashMap);
            logEvent.bizCode = str;
            iACMonitor2.logEvent(logEvent);
        }
        if (iACMonitor2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can not find any implementation for bizCode:");
            sb.append(str);
            ACLog.e("ac_common_get_monitor_impl_error", sb.toString());
            return defaultMonitor;
        }
        return iACMonitor2;
    }

    public static void logEvent(LogEvent logEvent) {
        IACMonitor iACMonitor2 = iACMonitor;
        if (iACMonitor2 == null) {
            ACLog.w(TAG, "Cannot find iACMonitor implementation. Please setiACMonitor.");
        } else {
            iACMonitor2.logEvent(logEvent);
        }
    }

    public static void logPageEvent(PageLogEvent pageLogEvent) {
        IACMonitor iACMonitor2 = iACMonitor;
        if (iACMonitor2 == null) {
            ACLog.w(TAG, "Cannot find iACMonitor implementation. Please setiACMonitor.");
        } else {
            iACMonitor2.logPageEvent(pageLogEvent);
        }
    }

    public static void setACMonitorImpl(IACMonitor iACMonitor2) {
        iACMonitor = iACMonitor2;
    }

    public static void setGlobalParameters(Map<String, String> map) {
        IACMonitor iACMonitor2 = iACMonitor;
        if (iACMonitor2 == null) {
            ACLog.w(TAG, "Cannot find iACMonitor implementation. Please setiACMonitor.");
        } else {
            iACMonitor2.setGlobalParameters(map);
        }
    }

    public static void setACMonitorImpl(IACMonitor iACMonitor2, String str) {
        monitorMap.put(str, iACMonitor2);
    }

    public static IACMonitor getInstance() {
        IACMonitor iACMonitor2 = iACMonitor;
        return iACMonitor2 != null ? iACMonitor2 : defaultMonitor;
    }
}

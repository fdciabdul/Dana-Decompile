package com.iap.ac.android.biz.common.utils.log;

import android.os.SystemClock;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.model.LogResult;
import com.iap.ac.android.biz.common.model.PayResultCode;
import com.iap.ac.android.biz.common.model.Result;
import com.iap.ac.android.biz.common.model.ResultCode;
import com.iap.ac.android.common.log.ACMonitor;
import com.iap.ac.android.common.log.event.LogEvent;
import com.iap.ac.android.common.log.event.LogEventType;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ACLogEvent {
    public String mBizCode;
    public String mEventId;
    public LogEventType mLogEventType = LogEventType.BEHAVIOR_LOG;
    public Map<String, String> mParams;

    public ACLogEvent(String str, String str2) {
        this.mEventId = str2;
        this.mBizCode = str;
    }

    public static void commonEvent(String str, long j, Result result) {
        LogResult logResult;
        if (result != null) {
            logResult = new LogResult();
            logResult.resultCode = result.resultCode;
            logResult.resultMessage = result.resultMessage;
        } else {
            logResult = null;
        }
        commonEvent(str, j, logResult);
    }

    public static void commonFailEvent(String str, String str2, String str3, String str4, long j) {
        newLogger(str, str2).addParams("result", LogConstants.RESULT_FALSE).addParams("resultCode", str3).addParams("resultMessage", str4).addParams("timeCost", String.valueOf(j)).event();
    }

    public static void commonRpcFailEvent(String str, String str2, String str3, String str4, long j, String str5) {
        newLogger(str, str2).addParams("result", LogConstants.RESULT_FALSE).addParams("resultCode", str3).addParams("resultMessage", str4).addParams("timeCost", String.valueOf(j)).addParams("traceId", str5).event();
    }

    public static void commonRpcSuccessEvent(String str, String str2, long j, String str3) {
        newLogger(str, str2).addParams("result", "T").addParams("timeCost", String.valueOf(j)).addParams("traceId", str3).event();
    }

    public static void commonSuccessEvent(String str, String str2, long j) {
        newLogger(str, str2).addParams("result", "T").addParams("timeCost", String.valueOf(j)).event();
    }

    public static void crucialEvent(String str, String str2, String str3) {
        newLogger(str, str2).addParams("resultMessage", str3).addParams("sdkVersion", "2.37.0").setEventType(LogEventType.CRUCIAL_LOG).event();
    }

    public static void crucialRpcEvent(String str, String str2, String str3, String str4) {
        newLogger(str, str2).addParams("resultMessage", str3).addParams("traceId", str4).addParams("sdkVersion", "2.37.0").setEventType(LogEventType.CRUCIAL_LOG).event();
    }

    public static void exceptionLog(String str) {
        newLogger("iapconnect_center", LogConstants.AC_EXCEPTION).addParams("result", LogConstants.RESULT_FALSE).addParams("resultCode", ResultCode.UNKNOWN_EXCEPTION).addParams("resultMessage", str).event();
    }

    public static void failEvent(String str, long j, Result result) {
        newLogger("iapconnect_center", str).addParams("result", LogConstants.RESULT_FALSE).addParams("resultCode", result.resultCode).addParams("resultMessage", result.resultMessage).addParams("timeCost", String.valueOf(SystemClock.elapsedRealtime() - j)).event();
    }

    public static ACLogEvent newLogger(String str, long j, Result result) {
        if (result != null && ("SUCCESS".equals(result.resultCode) || PayResultCode.PAY_SUCCESS.equals(result.resultCode))) {
            return newLogger("iapconnect_center", str).addParams("result", "T").addParams("timeCost", String.valueOf(SystemClock.elapsedRealtime() - j));
        }
        return newLogger("iapconnect_center", str).addParams("result", LogConstants.RESULT_FALSE).addParams("resultCode", result != null ? result.resultCode : ResultCode.INVALID_NETWORK).addParams("resultMessage", result != null ? result.resultMessage : "Oops! System busy. Try again later!").addParams("timeCost", String.valueOf(SystemClock.elapsedRealtime() - j));
    }

    public static void successEvent(String str, long j) {
        newLogger("iapconnect_center", str).addParams("result", "T").addParams("timeCost", String.valueOf(SystemClock.elapsedRealtime() - j)).event();
    }

    public ACLogEvent addAll(Map<String, String> map) {
        if (this.mParams == null) {
            this.mParams = new HashMap();
        }
        this.mParams.putAll(map);
        return this;
    }

    public ACLogEvent addParams(String str, String str2) {
        if (this.mParams == null) {
            this.mParams = new HashMap();
        }
        this.mParams.put(str, str2);
        return this;
    }

    public void event() {
        LogEvent logEvent = new LogEvent(this.mEventId, this.mParams);
        logEvent.bizCode = this.mBizCode;
        logEvent.eventType = this.mLogEventType;
        ACMonitor.getInstance("ac_biz").logEvent(logEvent);
    }

    public ACLogEvent setEventType(LogEventType logEventType) {
        this.mLogEventType = logEventType;
        return this;
    }

    public void event(String str) {
        LogEvent logEvent = new LogEvent(this.mEventId, this.mParams);
        logEvent.bizCode = this.mBizCode;
        logEvent.eventType = this.mLogEventType;
        ACMonitor.getInstance(str).logEvent(logEvent);
    }

    public static ACLogEvent addParams(ACLogEvent aCLogEvent, Map<String, String> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    aCLogEvent.addParams(str, map.get(str));
                }
            }
        }
        return aCLogEvent;
    }

    public static void commonEvent(String str, long j, LogResult logResult) {
        if (logResult != null && ("SUCCESS".equals(logResult.resultCode) || PayResultCode.PAY_SUCCESS.equals(logResult.resultCode))) {
            ACLogEvent addParams = newLogger("iapconnect_center", str).addParams("result", "T").addParams("timeCost", String.valueOf(SystemClock.elapsedRealtime() - j));
            if (!TextUtils.isEmpty(logResult.traceId)) {
                addParams.addParams("traceId", logResult.traceId);
            }
            addParams.event();
            return;
        }
        ACLogEvent addParams2 = newLogger("iapconnect_center", str).addParams("result", LogConstants.RESULT_FALSE).addParams("resultCode", logResult != null ? logResult.resultCode : ResultCode.INVALID_NETWORK).addParams("resultMessage", logResult != null ? logResult.resultMessage : "Oops! System busy. Try again later!").addParams("timeCost", String.valueOf(SystemClock.elapsedRealtime() - j));
        if (logResult != null && !TextUtils.isEmpty(logResult.traceId)) {
            addParams2.addParams("traceId", logResult.traceId);
        }
        addParams2.event();
    }

    public static void commonRpcSuccessEvent(String str, String str2, long j, String str3, Map<String, String> map) {
        newLogger(str, str2).addParams("result", "T").addParams("timeCost", String.valueOf(j)).addParams("traceId", str3).addAll(map).event();
    }

    public static void commonRpcFailEvent(String str, String str2, String str3, String str4, long j, String str5, Map<String, String> map) {
        newLogger(str, str2).addParams("result", LogConstants.RESULT_FALSE).addParams("resultCode", str3).addParams("resultMessage", str4).addParams("timeCost", String.valueOf(j)).addParams("traceId", str5).addAll(map).event();
    }

    public ACLogEvent addParams(String str, Object obj) {
        return addParams(str, String.valueOf(obj));
    }

    public static ACLogEvent newLogger(String str, String str2) {
        return new ACLogEvent(str, str2);
    }

    public static void commonEvent(String str, long j, Map<String, String> map, LogResult logResult) {
        if (logResult != null && ("SUCCESS".equals(logResult.resultCode) || PayResultCode.PAY_SUCCESS.equals(logResult.resultCode))) {
            ACLogEvent addParams = newLogger("iapconnect_center", str).addParams("result", "T").addParams("timeCost", String.valueOf(SystemClock.elapsedRealtime() - j));
            if (!TextUtils.isEmpty(logResult.traceId)) {
                addParams.addParams("traceId", logResult.traceId);
            }
            addParams(addParams, map);
            addParams.event();
            return;
        }
        ACLogEvent addParams2 = newLogger("iapconnect_center", str).addParams("result", LogConstants.RESULT_FALSE).addParams("resultCode", logResult != null ? logResult.resultCode : ResultCode.INVALID_NETWORK).addParams("resultMessage", logResult != null ? logResult.resultMessage : "Oops! System busy. Try again later!").addParams("timeCost", String.valueOf(SystemClock.elapsedRealtime() - j));
        if (logResult != null && !TextUtils.isEmpty(logResult.traceId)) {
            addParams2.addParams("traceId", logResult.traceId);
        }
        addParams(addParams2, map);
        addParams2.event();
    }
}

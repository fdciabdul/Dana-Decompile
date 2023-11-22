package com.iap.ac.android.acs.multilanguage.utils;

import com.iap.ac.android.common.log.event.LogEventType;

/* loaded from: classes3.dex */
public class MultiLanguageLogger {
    public static ACLogEvent logException(String str, String str2) {
        return ACLogEvent.newLogger("iapconnect_center", str).setEventType(LogEventType.CRUCIAL_LOG).addParams("langPkgId", str2);
    }

    public static ACLogEvent newLogger(String str) {
        return ACLogEvent.newLogger("iapconnect_center", str);
    }

    public static ACLogEvent newLogger(String str, String str2) {
        return ACLogEvent.newLogger("iapconnect_center", str).addParams("langPkgId", str2);
    }
}

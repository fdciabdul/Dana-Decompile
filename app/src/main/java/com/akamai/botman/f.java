package com.akamai.botman;

import android.util.Log;

/* loaded from: classes3.dex */
public final class f {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(Exception exc) {
        try {
            if (e.KClassImpl$Data$declaredNonStaticMembers$2.length() < 10000) {
                StringBuilder sb = new StringBuilder();
                sb.append(e.KClassImpl$Data$declaredNonStaticMembers$2);
                sb.append(";");
                String stackTraceString = Log.getStackTraceString(exc);
                if (stackTraceString != null && stackTraceString.length() > 500) {
                    stackTraceString = stackTraceString.substring(0, 500);
                }
                sb.append(q.getAuthRequestContext(stackTraceString));
                e.KClassImpl$Data$declaredNonStaticMembers$2 = sb.toString();
            }
        } catch (Exception unused) {
        }
    }
}

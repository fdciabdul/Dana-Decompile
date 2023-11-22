package com.splunk.rum;

import android.app.Application;
import android.os.Build;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Objects;

/* loaded from: classes.dex */
public final class BackgroundProcessDetector {
    private BackgroundProcessDetector() {
    }

    public static Boolean MyBillsEntityDataFactory(String str) {
        String authRequestContext = getAuthRequestContext();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("is background ");
        sb.append(authRequestContext);
        InstrumentInjector.log_d("SplunkRum", sb.toString());
        return Boolean.valueOf(!Objects.equals(authRequestContext, str));
    }

    private static String getAuthRequestContext() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            return (String) Class.forName(ProcessUtils.ACTIVITY_THREAD).getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return "";
        }
    }
}

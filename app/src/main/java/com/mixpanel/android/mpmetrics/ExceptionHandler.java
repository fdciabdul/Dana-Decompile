package com.mixpanel.android.mpmetrics;

import android.os.Process;
import com.fullstory.instrumentation.InstrumentInjector;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import java.lang.Thread;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static ExceptionHandler MyBillsEntityDataFactory;
    private final Thread.UncaughtExceptionHandler BuiltInFictitiousFunctionClassFactory = InstrumentInjector.getDefaultUncaughtExceptionHandler();

    public ExceptionHandler() {
        InstrumentInjector.setDefaultUncaughtExceptionHandler(this);
    }

    public static void BuiltInFictitiousFunctionClassFactory() {
        if (MyBillsEntityDataFactory == null) {
            synchronized (ExceptionHandler.class) {
                if (MyBillsEntityDataFactory == null) {
                    MyBillsEntityDataFactory = new ExceptionHandler();
                }
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, final Throwable th) {
        MixpanelAPI.getAuthRequestContext(new MixpanelAPI.InstanceProcessor() { // from class: com.mixpanel.android.mpmetrics.ExceptionHandler.1
            @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.InstanceProcessor
            public final void getAuthRequestContext(MixpanelAPI mixpanelAPI) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("$ae_crashed_reason", th.toString());
                    mixpanelAPI.BuiltInFictitiousFunctionClassFactory("$ae_crashed", jSONObject, true);
                } catch (JSONException unused) {
                }
            }
        });
        MixpanelAPI.getAuthRequestContext(new MixpanelAPI.InstanceProcessor() { // from class: com.mixpanel.android.mpmetrics.ExceptionHandler.2
            @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.InstanceProcessor
            public final void getAuthRequestContext(MixpanelAPI mixpanelAPI) {
                mixpanelAPI.PlaceComponentResult();
            }
        });
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.BuiltInFictitiousFunctionClassFactory;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        try {
            Thread.sleep(400L);
        } catch (InterruptedException unused) {
        }
        Process.killProcess(Process.myPid());
        System.exit(10);
    }
}

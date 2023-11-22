package com.crashlytics.android.answers.shim;

/* loaded from: classes3.dex */
public class AnswersOptionalLogger {
    private static final String TAG = "AnswersOptionalLogger";
    private static final KitEventLogger logger;

    /* JADX WARN: Removed duplicated region for block: B:8:0x0010  */
    static {
        /*
            com.crashlytics.android.answers.shim.AnswersKitEventLogger r0 = com.crashlytics.android.answers.shim.AnswersKitEventLogger.create()     // Catch: java.lang.Throwable -> L5 java.lang.Throwable -> Ld
            goto Le
        L5:
            r0 = move-exception
            java.lang.String r1 = "AnswersOptionalLogger"
            java.lang.String r2 = "Unexpected error creating AnswersKitEventLogger"
            com.fullstory.instrumentation.InstrumentInjector.log_w(r1, r2, r0)
        Ld:
            r0 = 0
        Le:
            if (r0 != 0) goto L14
            com.crashlytics.android.answers.shim.KitEventLogger r0 = com.crashlytics.android.answers.shim.NoopKitEventLogger.create()
        L14:
            com.crashlytics.android.answers.shim.AnswersOptionalLogger.logger = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.answers.shim.AnswersOptionalLogger.<clinit>():void");
    }

    public static KitEventLogger get() {
        return logger;
    }
}

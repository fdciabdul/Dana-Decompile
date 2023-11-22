package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public final class zzbt {
    private static final Method zza;
    private static final Method zzb;

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 6
            r2 = 0
            r3 = 24
            r4 = 0
            java.lang.String r5 = "JobSchedulerCompat"
            if (r0 < r3) goto L36
            r0 = 4
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch: java.lang.NoSuchMethodException -> L2a
            java.lang.Class<android.app.job.JobInfo> r6 = android.app.job.JobInfo.class
            r0[r2] = r6     // Catch: java.lang.NoSuchMethodException -> L2a
            r6 = 1
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r0[r6] = r7     // Catch: java.lang.NoSuchMethodException -> L2a
            r6 = 2
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch: java.lang.NoSuchMethodException -> L2a
            r0[r6] = r7     // Catch: java.lang.NoSuchMethodException -> L2a
            r6 = 3
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r0[r6] = r7     // Catch: java.lang.NoSuchMethodException -> L2a
            java.lang.Class<android.app.job.JobScheduler> r6 = android.app.job.JobScheduler.class
            java.lang.String r7 = "scheduleAsPackage"
            java.lang.reflect.Method r0 = r6.getDeclaredMethod(r7, r0)     // Catch: java.lang.NoSuchMethodException -> L2a
            goto L37
        L2a:
            boolean r0 = android.util.Log.isLoggable(r5, r1)
            if (r0 == 0) goto L36
            java.lang.String r0 = "No scheduleAsPackage method available, falling back to schedule"
            com.fullstory.instrumentation.InstrumentInjector.log_e(r5, r0)
        L36:
            r0 = r4
        L37:
            com.google.android.gms.internal.measurement.zzbt.zza = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto L54
            java.lang.Class[] r0 = new java.lang.Class[r2]     // Catch: java.lang.NoSuchMethodException -> L48
            java.lang.Class<android.os.UserHandle> r2 = android.os.UserHandle.class
            java.lang.String r3 = "myUserId"
            java.lang.reflect.Method r4 = r2.getDeclaredMethod(r3, r0)     // Catch: java.lang.NoSuchMethodException -> L48
            goto L54
        L48:
            boolean r0 = android.util.Log.isLoggable(r5, r1)
            if (r0 == 0) goto L54
            java.lang.String r0 = "No myUserId method available"
            com.fullstory.instrumentation.InstrumentInjector.log_e(r5, r0)
        L54:
            com.google.android.gms.internal.measurement.zzbt.zzb = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.<clinit>():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zza(android.content.Context r5, android.app.job.JobInfo r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r7 = "UploadAlarm"
            java.lang.String r8 = "jobscheduler"
            java.lang.Object r8 = r5.getSystemService(r8)
            android.app.job.JobScheduler r8 = (android.app.job.JobScheduler) r8
            r8.getClass()
            java.lang.reflect.Method r0 = com.google.android.gms.internal.measurement.zzbt.zza
            if (r0 == 0) goto L74
            java.lang.String r0 = "android.permission.UPDATE_DEVICE_STATS"
            int r5 = r5.checkSelfPermission(r0)
            if (r5 == 0) goto L1a
            goto L74
        L1a:
            java.lang.reflect.Method r5 = com.google.android.gms.internal.measurement.zzbt.zzb
            r0 = 0
            if (r5 == 0) goto L41
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch: java.lang.reflect.InvocationTargetException -> L30 java.lang.IllegalAccessException -> L32
            java.lang.Class<android.os.UserHandle> r2 = android.os.UserHandle.class
            java.lang.Object r5 = r5.invoke(r2, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L30 java.lang.IllegalAccessException -> L32
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.reflect.InvocationTargetException -> L30 java.lang.IllegalAccessException -> L32
            if (r5 == 0) goto L41
            int r5 = r5.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L30 java.lang.IllegalAccessException -> L32
            goto L42
        L30:
            r5 = move-exception
            goto L33
        L32:
            r5 = move-exception
        L33:
            r1 = 6
            java.lang.String r2 = "JobSchedulerCompat"
            boolean r1 = android.util.Log.isLoggable(r2, r1)
            if (r1 == 0) goto L41
            java.lang.String r1 = "myUserId invocation illegal"
            com.fullstory.instrumentation.InstrumentInjector.log_e(r2, r1, r5)
        L41:
            r5 = 0
        L42:
            java.lang.reflect.Method r1 = com.google.android.gms.internal.measurement.zzbt.zza
            if (r1 == 0) goto L6f
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L67 java.lang.IllegalAccessException -> L69
            r2[r0] = r6     // Catch: java.lang.reflect.InvocationTargetException -> L67 java.lang.IllegalAccessException -> L69
            r3 = 1
            java.lang.String r4 = "com.google.android.gms"
            r2[r3] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L67 java.lang.IllegalAccessException -> L69
            r3 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.reflect.InvocationTargetException -> L67 java.lang.IllegalAccessException -> L69
            r2[r3] = r5     // Catch: java.lang.reflect.InvocationTargetException -> L67 java.lang.IllegalAccessException -> L69
            r5 = 3
            r2[r5] = r7     // Catch: java.lang.reflect.InvocationTargetException -> L67 java.lang.IllegalAccessException -> L69
            java.lang.Object r5 = r1.invoke(r8, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L67 java.lang.IllegalAccessException -> L69
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.reflect.InvocationTargetException -> L67 java.lang.IllegalAccessException -> L69
            if (r5 == 0) goto L73
            int r0 = r5.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L67 java.lang.IllegalAccessException -> L69
            goto L73
        L67:
            r5 = move-exception
            goto L6a
        L69:
            r5 = move-exception
        L6a:
            java.lang.String r0 = "error calling scheduleAsPackage"
            com.fullstory.instrumentation.InstrumentInjector.log_e(r7, r0, r5)
        L6f:
            int r0 = r8.schedule(r6)
        L73:
            return r0
        L74:
            int r5 = r8.schedule(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}

package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import androidx.credentials.CredentialManager$$ExternalSyntheticLambda0;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Ascii;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class FcmBroadcastProcessor {
    private static final String EXTRA_BINARY_DATA = "rawData";
    private static final String EXTRA_BINARY_DATA_BASE_64 = "gcm.rawData64";
    private static WithinAppServiceConnection fcmServiceConn;
    private final Context context;
    private final Executor executor;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {104, -34, -42, -1, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int PlaceComponentResult = 17;
    private static final Object lock = new Object();

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 5
            int r6 = r6 + 18
            byte[] r0 = com.google.firebase.messaging.FcmBroadcastProcessor.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 6
            int r8 = 103 - r8
            int r7 = r7 * 22
            int r7 = r7 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r4 = r8
            r3 = 0
            r8 = r7
            r7 = r6
            goto L30
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r4 = -r4
            int r6 = r6 + r4
            int r8 = r8 + 1
            int r6 = r6 + (-8)
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FcmBroadcastProcessor.a(short, short, byte, java.lang.Object[]):void");
    }

    public FcmBroadcastProcessor(Context context) {
        this.context = context;
        this.executor = new CredentialManager$$ExternalSyntheticLambda0();
    }

    public FcmBroadcastProcessor(Context context, ExecutorService executorService) {
        this.context = context;
        this.executor = executorService;
    }

    public Task<Integer> process(Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_BINARY_DATA_BASE_64);
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra(EXTRA_BINARY_DATA_BASE_64);
        }
        return startMessagingService(this.context, intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.tasks.Task<java.lang.Integer> startMessagingService(final android.content.Context r9, final android.content.Intent r10) {
        /*
            r8 = this;
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastO()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5e
            byte[] r0 = com.google.firebase.messaging.FcmBroadcastProcessor.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L55
            r3 = 3
            r0 = r0[r3]     // Catch: java.lang.Throwable -> L55
            int r0 = -r0
            byte r0 = (byte) r0     // Catch: java.lang.Throwable -> L55
            byte[] r4 = com.google.firebase.messaging.FcmBroadcastProcessor.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L55
            r5 = 41
            r4 = r4[r5]     // Catch: java.lang.Throwable -> L55
            byte r4 = (byte) r4     // Catch: java.lang.Throwable -> L55
            byte[] r6 = com.google.firebase.messaging.FcmBroadcastProcessor.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L55
            r6 = r6[r3]     // Catch: java.lang.Throwable -> L55
            int r6 = -r6
            byte r6 = (byte) r6     // Catch: java.lang.Throwable -> L55
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L55
            a(r0, r4, r6, r7)     // Catch: java.lang.Throwable -> L55
            r0 = r7[r1]     // Catch: java.lang.Throwable -> L55
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L55
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L55
            byte[] r4 = com.google.firebase.messaging.FcmBroadcastProcessor.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L55
            r4 = r4[r5]     // Catch: java.lang.Throwable -> L55
            byte r4 = (byte) r4     // Catch: java.lang.Throwable -> L55
            byte[] r6 = com.google.firebase.messaging.FcmBroadcastProcessor.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L55
            r3 = r6[r3]     // Catch: java.lang.Throwable -> L55
            int r3 = -r3
            byte r3 = (byte) r3     // Catch: java.lang.Throwable -> L55
            byte[] r6 = com.google.firebase.messaging.FcmBroadcastProcessor.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L55
            r5 = r6[r5]     // Catch: java.lang.Throwable -> L55
            byte r5 = (byte) r5     // Catch: java.lang.Throwable -> L55
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L55
            a(r4, r3, r5, r6)     // Catch: java.lang.Throwable -> L55
            r3 = r6[r1]     // Catch: java.lang.Throwable -> L55
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L55
            r4 = 0
            java.lang.reflect.Method r0 = r0.getMethod(r3, r4)     // Catch: java.lang.Throwable -> L55
            java.lang.Object r0 = r0.invoke(r9, r4)     // Catch: java.lang.Throwable -> L55
            android.content.pm.ApplicationInfo r0 = (android.content.pm.ApplicationInfo) r0     // Catch: java.lang.Throwable -> L55
            int r0 = r0.targetSdkVersion
            r3 = 26
            if (r0 < r3) goto L5e
            r0 = 1
            goto L5f
        L55:
            r9 = move-exception
            java.lang.Throwable r10 = r9.getCause()
            if (r10 == 0) goto L5d
            throw r10
        L5d:
            throw r9
        L5e:
            r0 = 0
        L5f:
            int r3 = r10.getFlags()
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r3 & r4
            if (r3 != 0) goto L69
            goto L6a
        L69:
            r1 = 1
        L6a:
            if (r0 == 0) goto L73
            if (r1 != 0) goto L73
            com.google.android.gms.tasks.Task r9 = bindToMessagingService(r9, r10)
            return r9
        L73:
            java.util.concurrent.Executor r0 = r8.executor
            com.google.firebase.messaging.FcmBroadcastProcessor$$ExternalSyntheticLambda0 r1 = new com.google.firebase.messaging.FcmBroadcastProcessor$$ExternalSyntheticLambda0
            r1.<init>()
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.call(r0, r1)
            java.util.concurrent.Executor r1 = r8.executor
            com.google.firebase.messaging.FcmBroadcastProcessor$$ExternalSyntheticLambda1 r2 = new com.google.firebase.messaging.FcmBroadcastProcessor$$ExternalSyntheticLambda1
            r2.<init>()
            com.google.android.gms.tasks.Task r9 = r0.continueWithTask(r1, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FcmBroadcastProcessor.startMessagingService(android.content.Context, android.content.Intent):com.google.android.gms.tasks.Task");
    }

    public static /* synthetic */ Task lambda$startMessagingService$2(Context context, Intent intent, Task task) throws Exception {
        return (PlatformVersion.isAtLeastO() && ((Integer) task.getResult()).intValue() == 402) ? bindToMessagingService(context, intent).continueWith(new CredentialManager$$ExternalSyntheticLambda0(), new Continuation() { // from class: com.google.firebase.messaging.FcmBroadcastProcessor$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return FcmBroadcastProcessor.lambda$startMessagingService$1(task2);
            }
        }) : task;
    }

    public static /* synthetic */ Integer lambda$startMessagingService$1(Task task) throws Exception {
        return 403;
    }

    private static Task<Integer> bindToMessagingService(Context context, Intent intent) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            InstrumentInjector.log_d(Constants.TAG, "Binding to service");
        }
        if (ServiceStarter.getInstance().hasWakeLockPermission(context)) {
            WakeLockHolder.sendWakefulServiceIntent(context, getServiceConnection(context, "com.google.firebase.MESSAGING_EVENT"), intent);
        } else {
            getServiceConnection(context, "com.google.firebase.MESSAGING_EVENT").sendIntent(intent);
        }
        return Tasks.forResult(-1);
    }

    private static WithinAppServiceConnection getServiceConnection(Context context, String str) {
        WithinAppServiceConnection withinAppServiceConnection;
        synchronized (lock) {
            if (fcmServiceConn == null) {
                fcmServiceConn = new WithinAppServiceConnection(context, str);
            }
            withinAppServiceConnection = fcmServiceConn;
        }
        return withinAppServiceConnection;
    }

    public static void reset() {
        synchronized (lock) {
            fcmServiceConn = null;
        }
    }
}

package com.alibaba.griver.image.framework.utils;

import android.hardware.Camera;
import android.os.Build;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.executor.GriverExecutors;

/* loaded from: classes6.dex */
public class XPermissionHelper {
    public static final int PERMISSION_ACQUIRE_AUDIO = 1;
    public static final int PERMISSION_ACQUIRE_CAMERA = 2;
    public static final int PERMISSION_REQUEST_CODE_RECORD_AUDIO = 1;

    /* renamed from: a  reason: collision with root package name */
    private static boolean f6595a;

    public static void acquirePermissions(final int... iArr) {
        if (c()) {
            GriverExecutors.getExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.griver.image.framework.utils.XPermissionHelper.1
                @Override // java.lang.Runnable
                public final void run() {
                    for (int i : iArr) {
                        if (i == 1) {
                            XPermissionHelper.a();
                        } else if (i == 2) {
                            try {
                                XPermissionHelper.b();
                            } catch (Exception unused) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("take it easy, acquire permission for ");
                                sb.append(i);
                                sb.append(" error");
                                RVLogger.e("XPermissionHelper", sb.toString());
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0069 -> B:44:0x006c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a() {
        /*
            java.lang.String r0 = "acquireAudioPermission exp "
            java.lang.String r1 = "XPermissionHelper"
            java.lang.String r2 = "acquireAudioPermission enter"
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r1, r2)
            java.lang.String r2 = "android.permission.RECORD_AUDIO"
            boolean r2 = hasPermission(r2)
            if (r2 != 0) goto L12
            return
        L12:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r2 < r3) goto L19
            return
        L19:
            java.lang.String r2 = "acquireAudioPermission hasRecordAudio permission"
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r1, r2)
            r2 = 16000(0x3e80, float:2.2421E-41)
            r3 = 16
            r4 = 2
            int r10 = android.media.AudioRecord.getMinBufferSize(r2, r3, r4)
            r2 = 0
            android.media.AudioRecord r3 = new android.media.AudioRecord     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r6 = 1
            r7 = 16000(0x3e80, float:2.2421E-41)
            r8 = 16
            r9 = 2
            r5 = r3
            r5.<init>(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            int r2 = r3.getState()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L46
            r4 = 1
            if (r2 != r4) goto L3e
            r3.startRecording()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L46
        L3e:
            r3.release()     // Catch: java.lang.Exception -> L42
            goto L6c
        L42:
            r2 = move-exception
            goto L69
        L44:
            r2 = move-exception
            goto L76
        L46:
            r2 = move-exception
            r11 = r3
            r3 = r2
            r2 = r11
            goto L4e
        L4b:
            r3 = move-exception
            goto L79
        L4d:
            r3 = move-exception
        L4e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L72
            r4.<init>()     // Catch: java.lang.Throwable -> L72
            java.lang.String r5 = "take it easy, acquireAudioPermission error, "
            r4.append(r5)     // Catch: java.lang.Throwable -> L72
            r4.append(r3)     // Catch: java.lang.Throwable -> L72
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L72
            com.alibaba.ariver.kernel.common.utils.RVLogger.w(r1, r3)     // Catch: java.lang.Throwable -> L72
            if (r2 == 0) goto L6c
            r2.release()     // Catch: java.lang.Exception -> L42
            goto L6c
        L69:
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r1, r0, r2)
        L6c:
            java.lang.String r0 = "acquireAudioPermission finish"
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r1, r0)
            return
        L72:
            r3 = move-exception
            r11 = r3
            r3 = r2
            r2 = r11
        L76:
            r11 = r3
            r3 = r2
            r2 = r11
        L79:
            if (r2 == 0) goto L83
            r2.release()     // Catch: java.lang.Exception -> L7f
            goto L83
        L7f:
            r2 = move-exception
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r1, r0, r2)
        L83:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.framework.utils.XPermissionHelper.a():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        RVLogger.d("XPermissionHelper", "acquireCameraPermission enter");
        if (hasPermission("android.permission.CAMERA")) {
            RVLogger.d("XPermissionHelper", "acquireCameraPermission hasCamera permission");
            int numberOfCameras = Camera.getNumberOfCameras();
            StringBuilder sb = new StringBuilder();
            sb.append("acquireCameraPermission cameraCount: ");
            sb.append(numberOfCameras);
            RVLogger.d("XPermissionHelper", sb.toString());
            if (numberOfCameras > 0) {
                try {
                    Camera open = Camera.open();
                    if (open != null) {
                        open.release();
                    }
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("take it easy, acquireCameraPermission error, ");
                    sb2.append(e);
                    RVLogger.e("XPermissionHelper", sb2.toString());
                }
            }
            RVLogger.d("XPermissionHelper", "acquireCameraPermission finish");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0055, code lost:
    
        if (r2.getPackageManager().checkPermission(r6, r2.getPackageName()) == 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean hasPermission(java.lang.String r6) {
        /*
            java.lang.String r0 = "> 23, hasPermission permission: "
            java.lang.String r1 = "XPermissionHelper"
            android.app.Application r2 = com.alibaba.griver.base.common.env.GriverEnv.getApplicationContext()
            r3 = 0
            if (r2 == 0) goto L60
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L59
            r5 = 23
            if (r4 < r5) goto L49
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
            r4.<init>()     // Catch: java.lang.Throwable -> L59
            r4.append(r0)     // Catch: java.lang.Throwable -> L59
            r4.append(r6)     // Catch: java.lang.Throwable -> L59
            java.lang.String r5 = ", enter"
            r4.append(r5)     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L59
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r1, r4)     // Catch: java.lang.Throwable -> L59
            int r2 = androidx.core.content.ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(r2, r6)     // Catch: java.lang.Throwable -> L59
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
            r4.<init>()     // Catch: java.lang.Throwable -> L59
            r4.append(r0)     // Catch: java.lang.Throwable -> L59
            r4.append(r6)     // Catch: java.lang.Throwable -> L59
            java.lang.String r6 = ", ret: "
            r4.append(r6)     // Catch: java.lang.Throwable -> L59
            r4.append(r2)     // Catch: java.lang.Throwable -> L59
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L59
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r1, r6)     // Catch: java.lang.Throwable -> L59
            if (r2 != 0) goto L60
            goto L57
        L49:
            android.content.pm.PackageManager r0 = r2.getPackageManager()     // Catch: java.lang.Throwable -> L59
            java.lang.String r2 = r2.getPackageName()     // Catch: java.lang.Throwable -> L59
            int r6 = r0.checkPermission(r6, r2)     // Catch: java.lang.Throwable -> L59
            if (r6 != 0) goto L60
        L57:
            r3 = 1
            goto L60
        L59:
            r6 = move-exception
            java.lang.String r0 = "take it easy, os rejected this operation"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r1, r0, r6)
        L60:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.framework.utils.XPermissionHelper.hasPermission(java.lang.String):boolean");
    }

    private static boolean c() {
        return Build.VERSION.SDK_INT < 23;
    }
}

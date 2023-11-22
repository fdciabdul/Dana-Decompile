package com.google.firebase.crashlytics.internal;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.CommonUtils;

/* loaded from: classes.dex */
public class DevelopmentPlatformProvider {
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static final String FLUTTER_ASSET_FILE = "flutter_assets/NOTICES.Z";
    private static final String FLUTTER_PLATFORM = "Flutter";
    private static int MyBillsEntityDataFactory = 0;
    private static final String UNITY_PLATFORM = "Unity";
    private static final String UNITY_VERSION_FIELD = "com.google.firebase.crashlytics.unity_version";
    private final Context context;
    private DevelopmentPlatform developmentPlatform = null;

    public DevelopmentPlatformProvider(Context context) {
        this.context = context;
    }

    public String getDevelopmentPlatform() {
        return initDevelopmentPlatform().developmentPlatform;
    }

    public String getDevelopmentPlatformVersion() {
        return initDevelopmentPlatform().developmentPlatformVersion;
    }

    public static boolean isUnity(Context context) {
        return CommonUtils.getResourcesIdentifier(context, UNITY_VERSION_FIELD, "string") != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        if (r13.context.getAssets() == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        r14 = com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.MyBillsEntityDataFactory + 19;
        com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.BuiltInFictitiousFunctionClassFactory = r14 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
    
        if ((r14 % 2) != 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        if (r14 == true) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        r5 = new java.lang.Object[]{r13.context.getAssets(), r14};
        r14 = o.NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
    
        if (r14 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
    
        r14 = ((java.lang.Class) o.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (android.text.TextUtils.lastIndexOf("", '0') + 58134), (android.graphics.PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (android.graphics.PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (android.os.SystemClock.elapsedRealtimeNanos() > 0 ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0 ? 0 : -1)) + 48)).getMethod("getAuthRequestContext", android.content.res.AssetManager.class, java.lang.String.class);
        o.NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0094, code lost:
    
        r14 = (java.io.InputStream) ((java.lang.reflect.Method) r14).invoke(null, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009c, code lost:
    
        if (r14 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a0, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
    
        if (r0 == true) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a3, code lost:
    
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a8, code lost:
    
        r14 = com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.BuiltInFictitiousFunctionClassFactory + 23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ac, code lost:
    
        com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.MyBillsEntityDataFactory = r14 % 128;
        r14 = r14 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b0, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b1, code lost:
    
        throw r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b2, code lost:
    
        r14 = com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.BuiltInFictitiousFunctionClassFactory + 39;
        com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.MyBillsEntityDataFactory = r14 % 128;
        r14 = r14 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bb, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bc, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bd, code lost:
    
        r0 = r14.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c1, code lost:
    
        if (r0 != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c3, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c4, code lost:
    
        throw r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c5, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if (r0 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean assetFileExists(java.lang.String r14) {
        /*
            r13 = this;
            int r0 = com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 99
            int r1 = r0 % 128
            com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.MyBillsEntityDataFactory = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L1d
            android.content.Context r0 = r13.context
            android.content.res.AssetManager r0 = r0.getAssets()
            r2.hashCode()     // Catch: java.lang.Throwable -> L1b
            if (r0 != 0) goto L3c
            goto L25
        L1b:
            r14 = move-exception
            throw r14
        L1d:
            android.content.Context r0 = r13.context
            android.content.res.AssetManager r0 = r0.getAssets()
            if (r0 != 0) goto L3c
        L25:
            int r14 = com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.MyBillsEntityDataFactory
            int r14 = r14 + 19
            int r0 = r14 % 128
            com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.BuiltInFictitiousFunctionClassFactory = r0
            int r14 = r14 % r1
            if (r14 != 0) goto L32
            r14 = 0
            goto L33
        L32:
            r14 = 1
        L33:
            if (r14 == r4) goto L3b
            r2.hashCode()     // Catch: java.lang.Throwable -> L39
            return r3
        L39:
            r14 = move-exception
            throw r14
        L3b:
            return r3
        L3c:
            android.content.Context r0 = r13.context     // Catch: java.io.IOException -> Lc5
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch: java.io.IOException -> Lc5
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lbc
            r5[r4] = r14     // Catch: java.lang.Throwable -> Lbc
            r5[r3] = r0     // Catch: java.lang.Throwable -> Lbc
            java.util.Map<java.lang.Integer, java.lang.Object> r14 = o.NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested     // Catch: java.lang.Throwable -> Lbc
            r0 = -906490705(0xffffffffc9f80caf, float:-2032021.9)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> Lbc
            java.lang.Object r14 = r14.get(r6)     // Catch: java.lang.Throwable -> Lbc
            if (r14 == 0) goto L58
            goto L94
        L58:
            r14 = 58134(0xe316, float:8.1463E-41)
            java.lang.String r6 = ""
            r7 = 48
            int r6 = android.text.TextUtils.lastIndexOf(r6, r7)     // Catch: java.lang.Throwable -> Lbc
            int r6 = r6 + r14
            char r14 = (char) r6     // Catch: java.lang.Throwable -> Lbc
            r6 = 0
            float r8 = android.graphics.PointF.length(r6, r6)     // Catch: java.lang.Throwable -> Lbc
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            long r8 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Throwable -> Lbc
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            int r12 = r12 + r7
            java.lang.Object r14 = o.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult(r14, r6, r12)     // Catch: java.lang.Throwable -> Lbc
            java.lang.Class r14 = (java.lang.Class) r14     // Catch: java.lang.Throwable -> Lbc
            java.lang.String r6 = "getAuthRequestContext"
            java.lang.Class[] r7 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> Lbc
            java.lang.Class<android.content.res.AssetManager> r8 = android.content.res.AssetManager.class
            r7[r3] = r8     // Catch: java.lang.Throwable -> Lbc
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r4] = r8     // Catch: java.lang.Throwable -> Lbc
            java.lang.reflect.Method r14 = r14.getMethod(r6, r7)     // Catch: java.lang.Throwable -> Lbc
            java.util.Map<java.lang.Integer, java.lang.Object> r6 = o.NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested     // Catch: java.lang.Throwable -> Lbc
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> Lbc
            r6.put(r0, r14)     // Catch: java.lang.Throwable -> Lbc
        L94:
            java.lang.reflect.Method r14 = (java.lang.reflect.Method) r14     // Catch: java.lang.Throwable -> Lbc
            java.lang.Object r14 = r14.invoke(r2, r5)     // Catch: java.lang.Throwable -> Lbc
            java.io.InputStream r14 = (java.io.InputStream) r14     // Catch: java.lang.Throwable -> Lbc
            if (r14 == 0) goto La0
            r0 = 0
            goto La1
        La0:
            r0 = 1
        La1:
            if (r0 == r4) goto Lb2
            r14.close()     // Catch: java.io.IOException -> Lc5
            int r14 = com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> Lb0
            int r14 = r14 + 23
            int r0 = r14 % 128
            com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.MyBillsEntityDataFactory = r0     // Catch: java.lang.Exception -> Lb0
            int r14 = r14 % r1
            goto Lb2
        Lb0:
            r14 = move-exception
            throw r14
        Lb2:
            int r14 = com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.BuiltInFictitiousFunctionClassFactory
            int r14 = r14 + 39
            int r0 = r14 % 128
            com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.MyBillsEntityDataFactory = r0
            int r14 = r14 % r1
            return r4
        Lbc:
            r14 = move-exception
            java.lang.Throwable r0 = r14.getCause()     // Catch: java.io.IOException -> Lc5
            if (r0 == 0) goto Lc4
            throw r0     // Catch: java.io.IOException -> Lc5
        Lc4:
            throw r14     // Catch: java.io.IOException -> Lc5
        Lc5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider.assetFileExists(java.lang.String):boolean");
    }

    private DevelopmentPlatform initDevelopmentPlatform() {
        if (this.developmentPlatform == null) {
            this.developmentPlatform = new DevelopmentPlatform();
        }
        return this.developmentPlatform;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class DevelopmentPlatform {
        private final String developmentPlatform;
        private final String developmentPlatformVersion;

        private DevelopmentPlatform() {
            int resourcesIdentifier = CommonUtils.getResourcesIdentifier(DevelopmentPlatformProvider.this.context, DevelopmentPlatformProvider.UNITY_VERSION_FIELD, "string");
            if (resourcesIdentifier == 0) {
                if (DevelopmentPlatformProvider.this.assetFileExists(DevelopmentPlatformProvider.FLUTTER_ASSET_FILE)) {
                    this.developmentPlatform = DevelopmentPlatformProvider.FLUTTER_PLATFORM;
                    this.developmentPlatformVersion = null;
                    Logger.getLogger().v("Development platform is: Flutter");
                    return;
                }
                this.developmentPlatform = null;
                this.developmentPlatformVersion = null;
                return;
            }
            this.developmentPlatform = DevelopmentPlatformProvider.UNITY_PLATFORM;
            String string = DevelopmentPlatformProvider.this.context.getResources().getString(resourcesIdentifier);
            this.developmentPlatformVersion = string;
            Logger logger = Logger.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Unity Editor version is: ");
            sb.append(string);
            logger.v(sb.toString());
        }
    }
}

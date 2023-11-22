package io.branch.referral;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BranchUtil {
    private static boolean BuiltInFictitiousFunctionClassFactory;
    private static Boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private static boolean MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getAuthRequestContext(Context context) {
        if (!BuiltInFictitiousFunctionClassFactory && KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo.metaData != null && applicationInfo.metaData.containsKey("io.branch.sdk.TestMode")) {
                    BuiltInFictitiousFunctionClassFactory = applicationInfo.metaData.getBoolean("io.branch.sdk.TestMode", false);
                } else {
                    Resources resources = context.getResources();
                    BuiltInFictitiousFunctionClassFactory = Boolean.parseBoolean(resources.getString(resources.getIdentifier("io.branch.sdk.TestMode", "string", context.getPackageName())));
                }
            } catch (Exception unused) {
            }
            KClassImpl$Data$declaredNonStaticMembers$2 = Boolean.valueOf(BuiltInFictitiousFunctionClassFactory);
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static String PlaceComponentResult(Context context) {
        String str = PlaceComponentResult() ? "io.branch.sdk.BranchKey.test" : "io.branch.sdk.BranchKey";
        String str2 = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null && (str2 = applicationInfo.metaData.getString(str)) == null && PlaceComponentResult()) {
                Bundle bundle = applicationInfo.metaData;
                str2 = id.dana.data.BuildConfig.BRANCH_KEY;
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            try {
                Resources resources = context.getResources();
                return resources.getString(resources.getIdentifier(str, "string", context.getPackageName()));
            } catch (Exception unused2) {
                return str2;
            }
        }
        return str2;
    }

    public static boolean PlaceComponentResult() {
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(boolean z) {
        BuiltInFictitiousFunctionClassFactory = z;
    }

    public static boolean getAuthRequestContext() {
        return MyBillsEntityDataFactory || PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject BuiltInFictitiousFunctionClassFactory(JSONObject jSONObject) {
        return getAuthRequestContext(jSONObject);
    }

    private static JSONObject getAuthRequestContext(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("source", "android");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* loaded from: classes2.dex */
    public static class JsonReader {
        public final JSONObject MyBillsEntityDataFactory;

        public JsonReader(JSONObject jSONObject) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2 = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            this.MyBillsEntityDataFactory = jSONObject2;
        }

        public final Double MyBillsEntityDataFactory(String str, Double d) {
            if (this.MyBillsEntityDataFactory.has(str)) {
                Double valueOf = Double.valueOf(this.MyBillsEntityDataFactory.optDouble(str));
                this.MyBillsEntityDataFactory.remove(str);
                return valueOf;
            }
            return d;
        }

        public final boolean getAuthRequestContext(String str) {
            boolean optBoolean = this.MyBillsEntityDataFactory.optBoolean(str);
            this.MyBillsEntityDataFactory.remove(str);
            return optBoolean;
        }
    }

    private static boolean MyBillsEntityDataFactory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        if (r0 != null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject BuiltInFictitiousFunctionClassFactory(android.content.Context r5) {
        /*
            boolean r0 = MyBillsEntityDataFactory(r5)
            r1 = 0
            if (r0 != 0) goto L61
            java.util.jar.JarFile r0 = new java.util.jar.JarFile     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L55
            android.content.pm.PackageManager r2 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L55
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L55
            r3 = 0
            android.content.pm.ApplicationInfo r5 = r2.getApplicationInfo(r5, r3)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L55
            java.lang.String r5 = r5.publicSourceDir     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L55
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L55
            java.lang.String r5 = "AndroidManifest.xml"
            java.util.zip.ZipEntry r5 = r0.getEntry(r5)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L46
            java.io.InputStream r5 = r0.getInputStream(r5)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L46
            int r2 = r5.available()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            r5.read(r2)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            io.branch.referral.ApkParser r3 = new io.branch.referral.ApkParser     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            r3.<init>()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            org.json.JSONObject r1 = io.branch.referral.ApkParser.getAuthRequestContext(r2)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            if (r5 == 0) goto L5e
            r5.close()     // Catch: java.io.IOException -> L61
            goto L5e
        L3d:
            r1 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
            goto L4a
        L42:
            goto L57
        L44:
            r5 = move-exception
            goto L4a
        L46:
            r5 = r1
            goto L57
        L48:
            r5 = move-exception
            r0 = r1
        L4a:
            if (r1 == 0) goto L4f
            r1.close()     // Catch: java.io.IOException -> L54
        L4f:
            if (r0 == 0) goto L54
            r0.close()     // Catch: java.io.IOException -> L54
        L54:
            throw r5
        L55:
            r5 = r1
            r0 = r5
        L57:
            if (r5 == 0) goto L5c
            r5.close()     // Catch: java.io.IOException -> L61
        L5c:
            if (r0 == 0) goto L61
        L5e:
            r0.close()     // Catch: java.io.IOException -> L61
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.BranchUtil.BuiltInFictitiousFunctionClassFactory(android.content.Context):org.json.JSONObject");
    }
}

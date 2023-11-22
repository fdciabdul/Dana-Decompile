package com.appsflyer.internal;

import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.appsflyer.AppsFlyerProperties;
import com.google.common.base.Ascii;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.text.Typography;
import o.B;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class aj {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final int BuiltInFictitiousFunctionClassFactory;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 0;
    private static byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    private static int PlaceComponentResult = 0;
    public static final byte[] getAuthRequestContext;
    private static int lookAheadTest = 1;
    private static short[] moveToNextValue = null;
    private static int scheduleImpl = 0;
    private static aj valueOf = null;
    private static String values = "https://%smonitorsdk.%s/remote-debug?app_id=";
    boolean AFInAppEventParameterName;
    private JSONObject AFKeystoreWrapper;
    private boolean AFLogger$LogLevel;
    private int AppsFlyer2dXConversionCallback;
    private boolean getLevel;
    private boolean AFInAppEventType = true;
    private final List<String> AFVersionDeclaration = new ArrayList();
    private String init = "-1";

    static {
        getAuthRequestContext();
        getAuthRequestContext = new byte[]{107, -117, Ascii.NAK, -50, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        BuiltInFictitiousFunctionClassFactory = 69;
        int i = scheduleImpl + 61;
        lookAheadTest = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0043 -> B:16:0x0057). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r9, byte r10, short r11, java.lang.Object[] r12) {
        /*
            int r0 = com.appsflyer.internal.aj.lookAheadTest
            int r0 = r0 + 77
            int r1 = r0 % 128
            com.appsflyer.internal.aj.scheduleImpl = r1
            int r0 = r0 % 2
            int r10 = r10 * 3
            int r10 = r10 + 13
            int r9 = r9 * 12
            int r9 = 16 - r9
            int r11 = r11 * 7
            int r11 = r11 + 99
            byte[] r0 = com.appsflyer.internal.aj.getAuthRequestContext     // Catch: java.lang.Exception -> L64
            byte[] r1 = new byte[r10]
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L20
            r4 = 0
            goto L21
        L20:
            r4 = 1
        L21:
            if (r4 == r2) goto L2a
            r4 = r1
            r5 = 0
            r1 = r0
            r0 = r12
            r12 = r11
            r11 = r10
            goto L57
        L2a:
            r4 = 0
        L2b:
            byte r5 = (byte) r11
            r1[r4] = r5
            int r4 = r4 + r2
            if (r4 != r10) goto L43
            java.lang.String r9 = new java.lang.String
            r9.<init>(r1, r3)
            int r10 = com.appsflyer.internal.aj.scheduleImpl
            int r10 = r10 + 95
            int r11 = r10 % 128
            com.appsflyer.internal.aj.lookAheadTest = r11
            int r10 = r10 % 2
            r12[r3] = r9
            return
        L43:
            r5 = r0[r9]
            int r6 = com.appsflyer.internal.aj.scheduleImpl
            int r6 = r6 + 11
            int r7 = r6 % 128
            com.appsflyer.internal.aj.lookAheadTest = r7
            int r6 = r6 % 2
            r8 = r11
            r11 = r10
            r10 = r5
            r5 = r4
            r4 = r1
            r1 = r0
            r0 = r12
            r12 = r8
        L57:
            int r9 = r9 + r2
            int r10 = -r10
            int r12 = r12 + r10
            int r10 = r12 + 2
            r12 = r0
            r0 = r1
            r1 = r4
            r4 = r5
            r8 = r11
            r11 = r10
            r10 = r8
            goto L2b
        L64:
            r9 = move-exception
            goto L67
        L66:
            throw r9
        L67:
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.aj.b(int, byte, short, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        MyBillsEntityDataFactory = 1257195698;
        KClassImpl$Data$declaredNonStaticMembers$2 = 715795563;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = new byte[]{18, -21, Ascii.ESC, -20, -32, 2, -6, 2, -19, -30, -97};
        PlaceComponentResult = 1593936695;
    }

    private aj() {
        this.AppsFlyer2dXConversionCallback = 0;
        boolean z = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
        this.AFLogger$LogLevel = z;
        this.AFInAppEventParameterName = true ^ z;
        this.AppsFlyer2dXConversionCallback = 0;
        this.getLevel = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        if (r0 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        com.appsflyer.internal.aj.valueOf = new com.appsflyer.internal.aj();
        r0 = com.appsflyer.internal.aj.scheduleImpl + 47;
        com.appsflyer.internal.aj.lookAheadTest = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        if (com.appsflyer.internal.aj.valueOf == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.appsflyer.internal.aj valueOf() {
        /*
            int r0 = com.appsflyer.internal.aj.lookAheadTest
            int r0 = r0 + 101
            int r1 = r0 % 128
            com.appsflyer.internal.aj.scheduleImpl = r1
            int r0 = r0 % 2
            if (r0 == 0) goto Le
            r0 = 0
            goto L10
        Le:
            r0 = 93
        L10:
            if (r0 == 0) goto L17
            com.appsflyer.internal.aj r0 = com.appsflyer.internal.aj.valueOf
            if (r0 != 0) goto L30
            goto L1f
        L17:
            com.appsflyer.internal.aj r0 = com.appsflyer.internal.aj.valueOf
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L33
            if (r0 != 0) goto L30
        L1f:
            com.appsflyer.internal.aj r0 = new com.appsflyer.internal.aj
            r0.<init>()
            com.appsflyer.internal.aj.valueOf = r0
            int r0 = com.appsflyer.internal.aj.scheduleImpl
            int r0 = r0 + 47
            int r1 = r0 % 128
            com.appsflyer.internal.aj.lookAheadTest = r1
            int r0 = r0 % 2
        L30:
            com.appsflyer.internal.aj r0 = com.appsflyer.internal.aj.valueOf
            return r0
        L33:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.aj.valueOf():com.appsflyer.internal.aj");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void AFInAppEventParameterName(String str) {
        synchronized (this) {
            this.init = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void values() {
        synchronized (this) {
            this.getLevel = true;
            AFInAppEventType("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void AFInAppEventParameterName() {
        synchronized (this) {
            AFInAppEventType("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
            this.getLevel = false;
            this.AFInAppEventType = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void AFInAppEventType() {
        synchronized (this) {
            this.AFKeystoreWrapper = null;
            valueOf = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
    
        if ((r5.AFInAppEventParameterName) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0027, code lost:
    
        if ((r0 ? '%' : 2) != 2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0029, code lost:
    
        r0 = com.appsflyer.internal.aj.scheduleImpl + 53;
        com.appsflyer.internal.aj.lookAheadTest = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0036, code lost:
    
        if (r5.AFInAppEventType != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        r0 = '0';
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
    
        r0 = 24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003d, code lost:
    
        if (r0 == '0') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0040, code lost:
    
        r0 = com.appsflyer.internal.aj.scheduleImpl + 79;
        com.appsflyer.internal.aj.lookAheadTest = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        if (r5.getLevel == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean AFLogger$LogLevel() {
        /*
            r5 = this;
            int r0 = com.appsflyer.internal.aj.scheduleImpl     // Catch: java.lang.Exception -> L51
            int r0 = r0 + 99
            int r1 = r0 % 128
            com.appsflyer.internal.aj.lookAheadTest = r1     // Catch: java.lang.Exception -> L51
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == r3) goto L1d
            boolean r0 = r5.AFInAppEventParameterName
            if (r0 == 0) goto L19
            r0 = 1
            goto L1a
        L19:
            r0 = 0
        L1a:
            if (r0 == 0) goto L4e
            goto L29
        L1d:
            boolean r0 = r5.AFInAppEventParameterName     // Catch: java.lang.Exception -> L51
            r4 = 0
            int r4 = r4.length     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto L26
            r0 = 37
            goto L27
        L26:
            r0 = 2
        L27:
            if (r0 == r1) goto L4e
        L29:
            int r0 = com.appsflyer.internal.aj.scheduleImpl
            int r0 = r0 + 53
            int r4 = r0 % 128
            com.appsflyer.internal.aj.lookAheadTest = r4
            int r0 = r0 % r1
            boolean r0 = r5.AFInAppEventType
            r4 = 48
            if (r0 != 0) goto L3b
            r0 = 48
            goto L3d
        L3b:
            r0 = 24
        L3d:
            if (r0 == r4) goto L40
            goto L4d
        L40:
            int r0 = com.appsflyer.internal.aj.scheduleImpl
            int r0 = r0 + 79
            int r4 = r0 % 128
            com.appsflyer.internal.aj.lookAheadTest = r4
            int r0 = r0 % r1
            boolean r0 = r5.getLevel
            if (r0 == 0) goto L4e
        L4d:
            return r3
        L4e:
            return r2
        L4f:
            r0 = move-exception
            throw r0
        L51:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.aj.AFLogger$LogLevel():boolean");
    }

    private void valueOf(String str, String str2, String str3, String str4, String str5, String str6) {
        synchronized (this) {
            try {
                this.AFKeystoreWrapper.put(H5GetLogInfoBridge.RESULT_BRAND, str);
                this.AFKeystoreWrapper.put(H5GetLogInfoBridge.RESULT_MODEL, str2);
                this.AFKeystoreWrapper.put(TinyAppLogUtil.TINY_APP_STANDARD_EXTRA_PLATFORM, "Android");
                this.AFKeystoreWrapper.put("platform_version", str3);
                if (str4 != null && str4.length() > 0) {
                    this.AFKeystoreWrapper.put("advertiserId", str4);
                }
                if (str5 != null && str5.length() > 0) {
                    this.AFKeystoreWrapper.put("imei", str5);
                }
                if (str6 != null && str6.length() > 0) {
                    this.AFKeystoreWrapper.put("android_id", str6);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void valueOf(String str, String str2, String str3, String str4) {
        synchronized (this) {
            try {
                this.AFKeystoreWrapper.put(HianalyticsBaseData.SDK_VERSION, str);
                if (str2 != null && str2.length() > 0) {
                    this.AFKeystoreWrapper.put("devkey", str2);
                }
                if (str3 != null && str3.length() > 0) {
                    this.AFKeystoreWrapper.put("originalAppsFlyerId", str3);
                }
                if (str4 != null && str4.length() > 0) {
                    this.AFKeystoreWrapper.put("uid", str4);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void AFKeystoreWrapper(String str, String str2, String str3, String str4) {
        synchronized (this) {
            if (str != null) {
                try {
                    if (str.length() > 0) {
                        this.AFKeystoreWrapper.put("app_id", str);
                    }
                } catch (Throwable unused) {
                    return;
                }
            }
            if (str2 != null && str2.length() > 0) {
                JSONObject jSONObject = this.AFKeystoreWrapper;
                Object[] objArr = new Object[1];
                a((-367969192) - KeyEvent.keyCodeFromString(""), (-34) - (ViewConfiguration.getDoubleTapTimeout() >> 16), (short) ExpandableListView.getPackedPositionType(0L), (-1615160467) - KeyEvent.normalizeMetaState(0), (byte) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 114), objArr);
                jSONObject.put(((String) objArr[0]).intern(), str2);
            }
            if (str3 != null && str3.length() > 0) {
                this.AFKeystoreWrapper.put("channel", str3);
            }
            if (str4 != null && str4.length() > 0) {
                this.AFKeystoreWrapper.put("preInstall", str4);
            }
        }
    }

    public final void AFInAppEventType(String str, String str2, String... strArr) {
        String obj;
        synchronized (this) {
            if (AFLogger$LogLevel()) {
                if (this.AppsFlyer2dXConversionCallback < 98304) {
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        String join = TextUtils.join(", ", strArr);
                        if (str != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(currentTimeMillis);
                            sb.append(" ");
                            try {
                                byte b = (byte) (getAuthRequestContext[15] + 1);
                                byte b2 = (byte) (-getAuthRequestContext[15]);
                                Object[] objArr = new Object[1];
                                b(b, b2, b2, objArr);
                                Class<?> cls = Class.forName((String) objArr[0]);
                                byte b3 = (byte) (-getAuthRequestContext[15]);
                                byte b4 = (byte) (b3 - 1);
                                Object[] objArr2 = new Object[1];
                                b(b3, b4, b4, objArr2);
                                sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId());
                                sb.append(" _/AppsFlyer_6.3.2 [");
                                sb.append(str);
                                sb.append("] ");
                                sb.append(str2);
                                sb.append(" ");
                                sb.append(join);
                                obj = sb.toString();
                                this.AFVersionDeclaration.add(obj);
                                this.AppsFlyer2dXConversionCallback += obj.length() << 1;
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(currentTimeMillis);
                        sb2.append(" ");
                        try {
                            byte b5 = (byte) (getAuthRequestContext[15] + 1);
                            byte b6 = (byte) (-getAuthRequestContext[15]);
                            Object[] objArr3 = new Object[1];
                            b(b5, b6, b6, objArr3);
                            Class<?> cls2 = Class.forName((String) objArr3[0]);
                            byte b7 = (byte) (-getAuthRequestContext[15]);
                            byte b8 = (byte) (b7 - 1);
                            Object[] objArr4 = new Object[1];
                            b(b7, b8, b8, objArr4);
                            sb2.append(((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).getId());
                            sb2.append(" ");
                            sb2.append(str2);
                            sb2.append("/AppsFlyer_6.3.2 ");
                            sb2.append(join);
                            obj = sb2.toString();
                            this.AFVersionDeclaration.add(obj);
                            this.AppsFlyer2dXConversionCallback += obj.length() << 1;
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private String init() {
        String str;
        synchronized (this) {
            try {
                this.AFKeystoreWrapper.put("data", new JSONArray((Collection) this.AFVersionDeclaration));
                str = this.AFKeystoreWrapper.toString();
                try {
                    AFVersionDeclaration();
                } catch (JSONException unused) {
                }
            } catch (JSONException unused2) {
                str = null;
            }
        }
        return str;
    }

    private void AFInAppEventType(String str, PackageManager packageManager) {
        synchronized (this) {
            AppsFlyerProperties appsFlyerProperties = AppsFlyerProperties.getInstance();
            ae values2 = ae.values();
            String string = appsFlyerProperties.getString("remote_debug_static_data");
            if (string != null) {
                try {
                    this.AFKeystoreWrapper = new JSONObject(string);
                } catch (Throwable unused) {
                }
            } else {
                this.AFKeystoreWrapper = new JSONObject();
                valueOf(Build.BRAND, Build.MODEL, Build.VERSION.RELEASE, appsFlyerProperties.getString("advertiserId"), values2.AppsFlyer2dXConversionCallback, values2.AFLogger$LogLevel);
                StringBuilder sb = new StringBuilder("6.3.2.");
                sb.append(ae.AFInAppEventParameterName);
                valueOf(sb.toString(), appsFlyerProperties.getString(AppsFlyerProperties.AF_KEY), appsFlyerProperties.getString("KSAppsFlyerId"), appsFlyerProperties.getString("uid"));
                try {
                    int i = packageManager.getPackageInfo(str, 0).versionCode;
                    AFKeystoreWrapper(str, String.valueOf(i), appsFlyerProperties.getString("channel"), appsFlyerProperties.getString("preInstallName"));
                } catch (Throwable unused2) {
                }
                appsFlyerProperties.set("remote_debug_static_data", this.AFKeystoreWrapper.toString());
            }
            try {
                this.AFKeystoreWrapper.put("launch_counter", this.init);
            } catch (JSONException unused3) {
            }
        }
    }

    public static String[] AFInAppEventType(String str, StackTraceElement[] stackTraceElementArr) {
        int i = scheduleImpl + 109;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        int i3 = 1;
        if (!(stackTraceElementArr != null)) {
            return new String[]{str};
        }
        String[] strArr = new String[stackTraceElementArr.length + 1];
        strArr[0] = str;
        int i4 = lookAheadTest + 55;
        scheduleImpl = i4 % 128;
        int i5 = i4 % 2;
        while (true) {
            if ((i3 < stackTraceElementArr.length ? 'U' : '=') == '=') {
                return strArr;
            }
            strArr[i3] = stackTraceElementArr[i3].toString();
            i3++;
        }
    }

    private void AFVersionDeclaration() {
        synchronized (this) {
            this.AFVersionDeclaration.clear();
            this.AppsFlyer2dXConversionCallback = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void AFKeystoreWrapper() {
        synchronized (this) {
            this.AFInAppEventType = false;
            AFVersionDeclaration();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getLevel() {
        try {
            int i = lookAheadTest + 111;
            scheduleImpl = i % 128;
            if (i % 2 == 0) {
                return this.getLevel;
            }
            int i2 = 55 / 0;
            return this.getLevel;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (com.appsflyer.internal.aj.valueOf == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void valueOf(java.lang.String r7, android.content.pm.PackageManager r8) {
        /*
            int r0 = com.appsflyer.internal.aj.lookAheadTest
            int r0 = r0 + 91
            int r1 = r0 % 128
            com.appsflyer.internal.aj.scheduleImpl = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L1b
            com.appsflyer.internal.aj r0 = com.appsflyer.internal.aj.valueOf     // Catch: java.lang.Throwable -> L9e
            r4 = 68
            int r4 = r4 / r3
            if (r0 != 0) goto L2f
            goto L1f
        L1b:
            com.appsflyer.internal.aj r0 = com.appsflyer.internal.aj.valueOf     // Catch: java.lang.Throwable -> L9e
            if (r0 != 0) goto L2f
        L1f:
            com.appsflyer.internal.aj r0 = new com.appsflyer.internal.aj     // Catch: java.lang.Throwable -> L9e
            r0.<init>()     // Catch: java.lang.Throwable -> L9e
            com.appsflyer.internal.aj.valueOf = r0     // Catch: java.lang.Throwable -> L9e
            int r0 = com.appsflyer.internal.aj.lookAheadTest
            int r0 = r0 + 17
            int r4 = r0 % 128
            com.appsflyer.internal.aj.scheduleImpl = r4
            int r0 = r0 % r1
        L2f:
            com.appsflyer.internal.aj r0 = com.appsflyer.internal.aj.valueOf     // Catch: java.lang.Throwable -> L9e
            r0.AFInAppEventType(r7, r8)     // Catch: java.lang.Throwable -> L9e
            com.appsflyer.internal.aj r8 = com.appsflyer.internal.aj.valueOf     // Catch: java.lang.Throwable -> L9e
            if (r8 != 0) goto L48
            com.appsflyer.internal.aj r8 = new com.appsflyer.internal.aj     // Catch: java.lang.Throwable -> L9e
            r8.<init>()     // Catch: java.lang.Throwable -> L9e
            com.appsflyer.internal.aj.valueOf = r8     // Catch: java.lang.Throwable -> L9e
            int r8 = com.appsflyer.internal.aj.lookAheadTest
            int r8 = r8 + 71
            int r0 = r8 % 128
            com.appsflyer.internal.aj.scheduleImpl = r0
            int r8 = r8 % r1
        L48:
            com.appsflyer.internal.aj r8 = com.appsflyer.internal.aj.valueOf     // Catch: java.lang.Throwable -> L9e
            java.lang.String r8 = r8.init()     // Catch: java.lang.Throwable -> L9e
            com.appsflyer.internal.m r0 = new com.appsflyer.internal.m     // Catch: java.lang.Throwable -> L9e
            com.appsflyer.internal.bi r4 = new com.appsflyer.internal.bi     // Catch: java.lang.Throwable -> L9e
            r4.<init>()     // Catch: java.lang.Throwable -> L9e
            r4.onDeepLinkingNative = r8     // Catch: java.lang.Throwable -> L9e
            com.appsflyer.AppsFlyerLib r8 = com.appsflyer.AppsFlyerLib.getInstance()     // Catch: java.lang.Throwable -> L9e
            boolean r8 = r8.isStopped()     // Catch: java.lang.Throwable -> L9e
            r4.onConversionDataFail = r8     // Catch: java.lang.Throwable -> L9e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            r8.<init>()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r5 = com.appsflyer.internal.aj.values     // Catch: java.lang.Throwable -> L9e
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L9e
            com.appsflyer.AppsFlyerLib r6 = com.appsflyer.AppsFlyerLib.getInstance()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r6 = r6.getHostPrefix()     // Catch: java.lang.Throwable -> L9e
            r1[r3] = r6     // Catch: java.lang.Throwable -> L9e
            com.appsflyer.internal.ae r3 = com.appsflyer.internal.ae.values()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r3 = r3.getHostName()     // Catch: java.lang.Throwable -> L9e
            r1[r2] = r3     // Catch: java.lang.Throwable -> L9e
            java.lang.String r1 = java.lang.String.format(r5, r1)     // Catch: java.lang.Throwable -> L9e
            r8.append(r1)     // Catch: java.lang.Throwable -> L9e
            r8.append(r7)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r7 = r8.toString()     // Catch: java.lang.Throwable -> L9e
            com.appsflyer.internal.g r7 = r4.AFInAppEventParameterName(r7)     // Catch: java.lang.Throwable -> L9e
            com.appsflyer.internal.bf r7 = (com.appsflyer.internal.bf) r7     // Catch: java.lang.Throwable -> L9e
            r0.<init>(r7)     // Catch: java.lang.Throwable -> L9e
            java.lang.Thread r7 = new java.lang.Thread     // Catch: java.lang.Throwable -> L9e
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L9e
            r7.start()     // Catch: java.lang.Throwable -> L9e
            return
        L9e:
            r7 = move-exception
            com.appsflyer.AFLogger.values(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.aj.valueOf(java.lang.String, android.content.pm.PackageManager):void");
    }

    private static void a(int i, int i2, short s, int i3, byte b, Object[] objArr) {
        int i4;
        boolean z;
        int length;
        byte[] bArr;
        int i5;
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i6 = i2 + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L));
        boolean z2 = i6 == -1;
        if (z2) {
            byte[] bArr2 = NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (bArr2 != null) {
                int i7 = $10 + 37;
                $11 = i7 % 128;
                if (i7 % 2 == 0) {
                    length = bArr2.length;
                    bArr = new byte[length];
                    i5 = 1;
                } else {
                    length = bArr2.length;
                    bArr = new byte[length];
                    i5 = 0;
                }
                while (i5 < length) {
                    bArr[i5] = (byte) (bArr2[i5] ^ 3097486228508854431L);
                    i5++;
                }
                bArr2 = bArr;
            }
            i6 = (bArr2 != null ? '\r' : Typography.dollar) != '$' ? (byte) (((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[i + ((int) (PlaceComponentResult ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L))) : (short) (((short) (moveToNextValue[i + ((int) (PlaceComponentResult ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)));
        }
        if (i6 > 0) {
            int i8 = ((i + i6) - 2) + ((int) (PlaceComponentResult ^ 3097486228508854431L));
            if (!(!z2)) {
                int i9 = $10 + 63;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                i4 = 1;
            } else {
                i4 = 0;
            }
            b2.getAuthRequestContext = i8 + i4;
            b2.MyBillsEntityDataFactory = (char) (i3 + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (bArr3 != null) {
                int i11 = $11 + 59;
                $10 = i11 % 128;
                int i12 = i11 % 2;
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                int i13 = 0;
                while (i13 < length2) {
                    int i14 = $10 + 23;
                    $11 = i14 % 128;
                    if (i14 % 2 != 0) {
                        bArr4[i13] = (byte) (bArr3[i13] ^ 3097486228508854431L);
                        i13++;
                    } else {
                        bArr4[i13] = (byte) (bArr3[i13] - 3097486228508854431L);
                        i13 += 0;
                    }
                }
                bArr3 = bArr4;
            }
            if (bArr3 != null) {
                z = true;
            } else {
                int i15 = $10 + 1;
                $11 = i15 % 128;
                int i16 = i15 % 2;
                z = false;
            }
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i6) {
                int i17 = $10 + 105;
                $11 = i17 % 128;
                int i18 = i17 % 2;
                if (z) {
                    try {
                        byte[] bArr5 = NetworkUserEntityData$$ExternalSyntheticLambda0;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    short[] sArr = moveToNextValue;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                }
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                b2.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        objArr[0] = sb.toString();
    }
}

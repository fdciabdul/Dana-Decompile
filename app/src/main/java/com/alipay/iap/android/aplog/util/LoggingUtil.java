package com.alipay.iap.android.aplog.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewConfiguration;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.layout.mas.MasLog;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.huawei.hms.push.e;
import id.dana.cashier.view.InputCardNumberView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
public class LoggingUtil {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final int BuiltInFictitiousFunctionClassFactory;
    private static final char EXT_PARAM_GAP = '^';
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2;
    private static final char LOG_GAP = ',';
    private static int MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 0;
    private static final String TAG = "LoggingUtil";
    public static String UNDERLINE = "_";
    private static boolean debuggable = false;
    private static int getAuthRequestContext = 0;
    private static int getErrorConfigVersion = 1;
    private static int lookAheadTest;
    private static byte[] moveToNextValue;
    private static short[] scheduleImpl;

    static {
        BuiltInFictitiousFunctionClassFactory();
        KClassImpl$Data$declaredNonStaticMembers$2 = new byte[]{Ascii.DC4, -68, -64, 70, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        BuiltInFictitiousFunctionClassFactory = 50;
        int i = lookAheadTest + 7;
        getErrorConfigVersion = i % 128;
        if ((i % 2 == 0 ? 'Z' : '?') != '?') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        PlaceComponentResult = 1257195677;
        MyBillsEntityDataFactory = 2100171302;
        moveToNextValue = new byte[]{-100, 121, -43, -64, -51};
        getAuthRequestContext = -2006148506;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:20:0x0059). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r10, byte r11, byte r12, java.lang.Object[] r13) {
        /*
            byte[] r0 = com.alipay.iap.android.aplog.util.LoggingUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r12 = r12 * 12
            int r12 = 16 - r12
            int r11 = r11 * 3
            int r11 = r11 + 13
            r1 = 7
            int r10 = r10 * 7
            int r10 = 106 - r10
            byte[] r2 = new byte[r11]
            int r11 = r11 + (-1)
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L19
            r5 = 0
            goto L1a
        L19:
            r5 = 1
        L1a:
            if (r5 == r3) goto L33
            int r10 = com.alipay.iap.android.aplog.util.LoggingUtil.getErrorConfigVersion
            int r10 = r10 + 109
            int r5 = r10 % 128
            com.alipay.iap.android.aplog.util.LoggingUtil.lookAheadTest = r5
            int r10 = r10 % 2
            if (r10 == 0) goto L2c
            int r1 = r1 / r4
            goto L2c
        L2a:
            r10 = move-exception
            throw r10
        L2c:
            r10 = r11
            r1 = r0
            r5 = r2
            r2 = 0
            r0 = r13
            r13 = r12
            goto L59
        L33:
            r1 = 0
        L34:
            byte r5 = (byte) r10
            r2[r1] = r5
            if (r1 != r11) goto L41
            java.lang.String r10 = new java.lang.String
            r10.<init>(r2, r4)
            r13[r4] = r10
            return
        L41:
            int r1 = r1 + 1
            r5 = r0[r12]
            int r6 = com.alipay.iap.android.aplog.util.LoggingUtil.getErrorConfigVersion
            int r6 = r6 + 29
            int r7 = r6 % 128
            com.alipay.iap.android.aplog.util.LoggingUtil.lookAheadTest = r7
            int r6 = r6 % 2
            r8 = r11
            r11 = r10
            r10 = r8
            r9 = r13
            r13 = r12
            r12 = r5
            r5 = r2
            r2 = r1
            r1 = r0
            r0 = r9
        L59:
            int r12 = -r12
            int r11 = r11 + r12
            int r11 = r11 + 2
            int r12 = r13 + 1
            r13 = r0
            r0 = r1
            r1 = r2
            r2 = r5
            r8 = r11
            r11 = r10
            r10 = r8
            goto L34
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.LoggingUtil.b(short, byte, byte, java.lang.Object[]):void");
    }

    public static File getCommonExternalStorageDir() {
        File file;
        try {
            file = new File(Environment.getExternalStorageDirectory(), "iapLog");
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getCommonExternalStorageDir: ");
            sb.append(th);
            InstrumentInjector.log_e(TAG, sb.toString());
            file = new File("/sdcard/iapLog");
        }
        try {
            boolean z = false;
            if (!(!file.exists())) {
                try {
                    int i = lookAheadTest + 33;
                    getErrorConfigVersion = i % 128;
                    int i2 = i % 2;
                    if (!file.isFile()) {
                        z = true;
                    }
                    if (!z) {
                        FileUtil.deleteFileNotDir(file);
                        file.mkdirs();
                        try {
                            int i3 = getErrorConfigVersion + 31;
                            lookAheadTest = i3 % 128;
                            int i4 = i3 % 2;
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            } else {
                file.mkdirs();
                int i5 = getErrorConfigVersion + 53;
                lookAheadTest = i5 % 128;
                int i6 = i5 % 2;
            }
        } catch (Throwable unused) {
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File getStorageFilesDir(android.content.Context r4, java.lang.String r5) {
        /*
            boolean r0 = com.alipay.iap.android.aplog.util.LoggingUtil.debuggable
            r1 = 0
            if (r0 == 0) goto L34
            int r0 = com.alipay.iap.android.aplog.util.LoggingUtil.lookAheadTest     // Catch: java.lang.Exception -> L32
            int r0 = r0 + 53
            int r2 = r0 % 128
            com.alipay.iap.android.aplog.util.LoggingUtil.getErrorConfigVersion = r2     // Catch: java.lang.Exception -> L32
            int r0 = r0 % 2
            boolean r0 = com.alipay.iap.android.aplog.util.FileUtil.sdCardAvailable()
            if (r0 == 0) goto L34
            java.io.File r0 = getCommonExternalStorageDir()     // Catch: java.lang.Throwable -> L34
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L34
            java.lang.String r3 = r4.getPackageName()     // Catch: java.lang.Throwable -> L34
            r2.<init>(r0, r3)     // Catch: java.lang.Throwable -> L34
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L34
            r0.<init>(r2, r5)     // Catch: java.lang.Throwable -> L34
            int r2 = com.alipay.iap.android.aplog.util.LoggingUtil.getErrorConfigVersion     // Catch: java.lang.Exception -> L32
            int r2 = r2 + 19
            int r3 = r2 % 128
            com.alipay.iap.android.aplog.util.LoggingUtil.lookAheadTest = r3     // Catch: java.lang.Exception -> L32
            int r2 = r2 % 2
            goto L35
        L32:
            r4 = move-exception
            throw r4
        L34:
            r0 = r1
        L35:
            if (r0 != 0) goto L42
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L41
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L41
            r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> L41
            goto L42
        L41:
            r0 = r1
        L42:
            if (r0 == 0) goto L73
            int r4 = com.alipay.iap.android.aplog.util.LoggingUtil.getErrorConfigVersion
            int r4 = r4 + 75
            int r5 = r4 % 128
            com.alipay.iap.android.aplog.util.LoggingUtil.lookAheadTest = r5
            int r4 = r4 % 2
            boolean r4 = r0.exists()
            if (r4 != 0) goto L73
            int r4 = com.alipay.iap.android.aplog.util.LoggingUtil.lookAheadTest
            int r4 = r4 + 25
            int r5 = r4 % 128
            com.alipay.iap.android.aplog.util.LoggingUtil.getErrorConfigVersion = r5
            int r4 = r4 % 2
            r5 = 1
            if (r4 != 0) goto L63
            r4 = 1
            goto L64
        L63:
            r4 = 0
        L64:
            if (r4 == r5) goto L6a
            r0.mkdirs()
            goto L73
        L6a:
            r0.mkdirs()
            r1.hashCode()     // Catch: java.lang.Throwable -> L71
            goto L73
        L71:
            r4 = move-exception
            throw r4
        L73:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.LoggingUtil.getStorageFilesDir(android.content.Context, java.lang.String):java.io.File");
    }

    public static byte[] gzipDataByBytes(byte[] bArr, int i, int i2) throws IllegalStateException {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
            gZIPOutputStream = null;
        }
        try {
            gZIPOutputStream.write(bArr, i, i2);
            gZIPOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                gZIPOutputStream.close();
            } catch (Throwable unused) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (Throwable unused2) {
            }
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            try {
                throw new IllegalStateException(th);
            } finally {
            }
        }
    }

    public static String getMdapStyleName(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(str);
        String obj = sb.toString();
        try {
            int i = lookAheadTest + 67;
            getErrorConfigVersion = i % 128;
            if (i % 2 != 0) {
                return obj;
            }
            int i2 = 70 / 0;
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    public static byte[] gzipDataByString(String str) throws IllegalStateException {
        int i = lookAheadTest + 35;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            a(1031548167 - (ViewConfiguration.getDoubleTapTimeout() >> 16), Drawable.resolveOpacity(0, 0) - 3, (short) (Drawable.resolveOpacity(0, 0) + 96), TextUtils.lastIndexOf("", '0') - 935418467, (byte) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 77), objArr);
            byte[] bytes = str.getBytes(((String) objArr[0]).intern());
            byte[] gzipDataByBytes = gzipDataByBytes(bytes, 0, bytes.length);
            int i3 = lookAheadTest + 79;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            return gzipDataByBytes;
        } catch (Throwable th) {
            throw new IllegalStateException(th);
        }
    }

    public static boolean isDebuggable() {
        int i = lookAheadTest + 21;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        boolean z = debuggable;
        int i3 = lookAheadTest + 77;
        getErrorConfigVersion = i3 % 128;
        if ((i3 % 2 == 0 ? 'M' : '\\') != 'M') {
            return z;
        }
        int i4 = 29 / 0;
        return z;
    }

    public static void setDebuggable(boolean z) {
        int i = lookAheadTest + 85;
        getErrorConfigVersion = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? (char) 21 : (char) 23) != 21) {
            try {
                debuggable = z;
            } catch (Exception e) {
                throw e;
            }
        } else {
            debuggable = z;
            int length = objArr.length;
        }
        int i2 = lookAheadTest + 63;
        getErrorConfigVersion = i2 % 128;
        if (i2 % 2 != 0) {
            return;
        }
        objArr.hashCode();
    }

    public static String getNowTime() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        StringBuilder sb = new StringBuilder();
        int i = calendar.get(1);
        int i2 = calendar.get(2) + 1;
        int i3 = calendar.get(5);
        int i4 = calendar.get(11);
        int i5 = calendar.get(12);
        int i6 = calendar.get(13);
        int i7 = calendar.get(14);
        sb.append(i);
        sb.append('-');
        if (i2 < 10) {
            sb.append('0');
        }
        try {
            sb.append(i2);
            sb.append('-');
            if (i3 < 10) {
                int i8 = lookAheadTest + 45;
                getErrorConfigVersion = i8 % 128;
                if (i8 % 2 == 0) {
                    sb.append('m');
                } else {
                    sb.append('0');
                }
            }
            sb.append(i3);
            sb.append(InputCardNumberView.DIVIDER);
            if (i4 < 10) {
                int i9 = getErrorConfigVersion + 17;
                lookAheadTest = i9 % 128;
                if (i9 % 2 != 0) {
                    try {
                        sb.append((char) 17);
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    sb.append('0');
                }
            }
            sb.append(i4);
            sb.append(':');
            if ((i5 < 10 ? (char) 15 : ']') != ']') {
                sb.append('0');
            }
            sb.append(i5);
            sb.append(':');
            if (i6 < 10) {
                sb.append('0');
            }
            sb.append(i6);
            sb.append('.');
            if (i7 < 100) {
                sb.append('0');
            }
            if (i7 < 10) {
                int i10 = getErrorConfigVersion + 15;
                lookAheadTest = i10 % 128;
                if (!(i10 % 2 == 0)) {
                    sb.append((char) 19);
                } else {
                    sb.append('0');
                }
            }
            sb.append(i7);
            return sb.toString();
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static StringBuilder appendParam(StringBuilder sb, String str) {
        int i = getErrorConfigVersion + 47;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        if ((sb == null ? '*' : (char) 24) != 24) {
            return null;
        }
        sb.append(LOG_GAP);
        boolean z = false;
        if (!(str == null)) {
            try {
                int i3 = getErrorConfigVersion + 69;
                lookAheadTest = i3 % 128;
                if (i3 % 2 == 0) {
                    z = true;
                }
                if (z) {
                    sb.append(str.replace(LOG_GAP, InputCardNumberView.DIVIDER));
                } else {
                    try {
                        sb.append(str.replace(Ascii.MAX, 'b'));
                    } catch (Exception e) {
                        throw e;
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return sb;
    }

    public static StringBuilder appendExtParam(StringBuilder sb, Map<String, String> map) {
        if ((sb == null ? 'W' : '\n') != '\n') {
            try {
                int i = getErrorConfigVersion + 27;
                lookAheadTest = i % 128;
                if (i % 2 != 0) {
                    int i2 = 98 / 0;
                    return null;
                }
                return null;
            } catch (Exception e) {
                throw e;
            }
        }
        sb.append(LOG_GAP);
        if (!(map == null) && map.size() != 0) {
            int i3 = getErrorConfigVersion + 7;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            boolean z = true;
            while (true) {
                try {
                    if ((it.hasNext() ? (char) 4 : ']') != 4) {
                        break;
                    }
                    Map.Entry<String, String> next = it.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    if ((value == null ? JSONLexer.EOI : 'B') == 26) {
                        value = "";
                    }
                    if (!(key == null) && value != null) {
                        String fliterChar = fliterChar(value);
                        if (z) {
                            z = false;
                        } else {
                            sb.append(EXT_PARAM_GAP);
                        }
                        sb.append(key.replace(LOG_GAP, InputCardNumberView.DIVIDER).replace(EXT_PARAM_GAP, InputCardNumberView.DIVIDER).replace('=', InputCardNumberView.DIVIDER));
                        sb.append('=');
                        sb.append(fliterChar.replace(LOG_GAP, InputCardNumberView.DIVIDER).replace(EXT_PARAM_GAP, InputCardNumberView.DIVIDER));
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        return sb;
    }

    public static String fliterChar(String str) {
        if (!TextUtils.isEmpty(str)) {
            int i = getErrorConfigVersion + 29;
            lookAheadTest = i % 128;
            if (i % 2 == 0) {
                str = str.replace("\r\n", "###").replace("\n", "###").replace("\r", "###");
            } else {
                try {
                    str = str.replace("\r\n", "###").replace("\n", "###").replace("\r", "###");
                    int i2 = 36 / 0;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        int i3 = lookAheadTest + 1;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public static boolean loadLibrary(Context context, String str) {
        try {
            int i = getErrorConfigVersion + 107;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            if ((TextUtils.isEmpty(str) ? (char) 15 : '3') == '3') {
                try {
                    System.loadLibrary(str);
                    TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                    StringBuilder sb = new StringBuilder();
                    sb.append("success to System.loadLibrary : ");
                    sb.append(str);
                    traceLogger.info(TAG, sb.toString());
                    int i3 = lookAheadTest + 69;
                    getErrorConfigVersion = i3 % 128;
                    int i4 = i3 % 2;
                    return true;
                } catch (Throwable th) {
                    TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("failed to System.loadLibrary : ");
                    sb2.append(str);
                    traceLogger2.error(TAG, sb2.toString(), th);
                    if (context == null) {
                        return false;
                    }
                    String str2 = "";
                    try {
                        File dir = context.getDir("plugins_lib", 0);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("lib");
                        sb3.append(str);
                        sb3.append(".so");
                        str2 = new File(dir, sb3.toString()).getAbsolutePath();
                        System.load(str2);
                        TraceLogger traceLogger3 = LoggerFactory.getTraceLogger();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("success to System.load : ");
                        sb4.append(str2);
                        traceLogger3.info(TAG, sb4.toString());
                        return true;
                    } catch (Throwable th2) {
                        TraceLogger traceLogger4 = LoggerFactory.getTraceLogger();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("failed to System.load : ");
                        sb5.append(str2);
                        traceLogger4.error(TAG, sb5.toString(), th2);
                        return false;
                    }
                }
            }
            int i5 = lookAheadTest + 79;
            getErrorConfigVersion = i5 % 128;
            int i6 = i5 % 2;
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void reflectErrorLog(String str, String str2, boolean z) {
        try {
            StringBuilder sb = new StringBuilder();
            if (!(!z)) {
                int i = getErrorConfigVersion + 91;
                lookAheadTest = i % 128;
                if ((i % 2 != 0 ? (char) 6 : 'E') != 'E') {
                    sb.append((char) 19);
                } else {
                    sb.append('[');
                }
                try {
                    byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                    byte b2 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                    Object[] objArr = new Object[1];
                    b(b, b2, (byte) (b2 - 1), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                    Object[] objArr2 = new Object[1];
                    b(b3, (byte) (b3 - 1), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]), objArr2);
                    sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
                    sb.append(']');
                    int i2 = getErrorConfigVersion + 45;
                    lookAheadTest = i2 % 128;
                    int i3 = i2 % 2;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            sb.append(str2);
            Class.forName("android.util.Log").getMethod(e.PlaceComponentResult, String.class, String.class).invoke(null, str, sb.toString());
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
    
        if ((r4 != null ? '=' : 'c') != '=') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0028, code lost:
    
        r0 = com.alipay.iap.android.aplog.util.LoggingUtil.getErrorConfigVersion + 37;
        com.alipay.iap.android.aplog.util.LoggingUtil.lookAheadTest = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        if (r4.contains(com.alipay.iap.android.aplog.util.LoggingUtil.UNDERLINE) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        r0 = 'B';
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        r0 = '@';
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        if (r0 == 'B') goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
    
        r4 = r4.split(com.alipay.iap.android.aplog.util.LoggingUtil.UNDERLINE)[0];
        r0 = com.alipay.iap.android.aplog.util.LoggingUtil.lookAheadTest + 85;
        com.alipay.iap.android.aplog.util.LoggingUtil.getErrorConfigVersion = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        if ((r0 % 2) != 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if ((r4 != null) != true) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getViewID(java.lang.String r4) {
        /*
            int r0 = com.alipay.iap.android.aplog.util.LoggingUtil.lookAheadTest
            int r0 = r0 + 97
            int r1 = r0 % 128
            com.alipay.iap.android.aplog.util.LoggingUtil.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L1c
            r2.hashCode()     // Catch: java.lang.Throwable -> L1a
            r0 = 1
            if (r4 == 0) goto L16
            r3 = 1
            goto L17
        L16:
            r3 = 0
        L17:
            if (r3 == r0) goto L28
            goto L43
        L1a:
            r4 = move-exception
            throw r4
        L1c:
            r0 = 61
            if (r4 == 0) goto L23
            r3 = 61
            goto L25
        L23:
            r3 = 99
        L25:
            if (r3 == r0) goto L28
            goto L43
        L28:
            int r0 = com.alipay.iap.android.aplog.util.LoggingUtil.getErrorConfigVersion
            int r0 = r0 + 37
            int r3 = r0 % 128
            com.alipay.iap.android.aplog.util.LoggingUtil.lookAheadTest = r3
            int r0 = r0 % 2
            java.lang.String r0 = com.alipay.iap.android.aplog.util.LoggingUtil.UNDERLINE
            boolean r0 = r4.contains(r0)
            r3 = 66
            if (r0 == 0) goto L3f
            r0 = 66
            goto L41
        L3f:
            r0 = 64
        L41:
            if (r0 == r3) goto L44
        L43:
            return r2
        L44:
            java.lang.String r0 = com.alipay.iap.android.aplog.util.LoggingUtil.UNDERLINE
            java.lang.String[] r4 = r4.split(r0)
            r4 = r4[r1]
            int r0 = com.alipay.iap.android.aplog.util.LoggingUtil.lookAheadTest
            int r0 = r0 + 85
            int r1 = r0 % 128
            com.alipay.iap.android.aplog.util.LoggingUtil.getErrorConfigVersion = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L5e
            r2.hashCode()     // Catch: java.lang.Throwable -> L5c
            return r4
        L5c:
            r4 = move-exception
            throw r4
        L5e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.LoggingUtil.getViewID(java.lang.String):java.lang.String");
    }

    public static String getResolution() {
        DisplayMetrics displayMetrics = LoggerFactory.getLogContext().getApplicationContext().getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("*");
        sb.append(i2);
        String obj = sb.toString();
        int i3 = lookAheadTest + 29;
        getErrorConfigVersion = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 4 : 'R') != 4) {
            return obj;
        }
        int i4 = 10 / 0;
        return obj;
    }

    public static String throwableToString(Throwable th) {
        try {
            String stackTraceString = Log.getStackTraceString(th);
            if (!(stackTraceString != null)) {
                int i = getErrorConfigVersion + 65;
                lookAheadTest = i % 128;
                int i2 = i % 2;
                return null;
            }
            try {
                int i3 = getErrorConfigVersion + 113;
                lookAheadTest = i3 % 128;
                int i4 = i3 % 2;
                return stackTraceString.replace(MasLog.Constant.GAP, "<2$>");
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00aa, code lost:
    
        if (r3 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b7, code lost:
    
        if (r3 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b9, code lost:
    
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bb, code lost:
    
        r3 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r13, int r14, short r15, int r16, byte r17, java.lang.Object[] r18) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.LoggingUtil.a(int, int, short, int, byte, java.lang.Object[]):void");
    }
}

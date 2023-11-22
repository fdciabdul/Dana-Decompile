package com.apiguard3.internal;

import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.apiguard3.BuildConfig;
import com.apiguard3.internal.ConfigInstance;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class readResolve {
    private static int APIGuard = 0;
    private static int getSharedInstance = 1;
    private static ConfigInstance.ConfigSerializationProxy.values valueOf = ConfigInstance.ConfigSerializationProxy.values.values;

    static {
        int i = APIGuard + 23;
        getSharedInstance = i % 128;
        if (!(i % 2 == 0)) {
            return;
        }
        throw new ArithmeticException();
    }

    private static ConfigInstance.ConfigSerializationProxy.values AGState() {
        ConfigInstance.ConfigSerializationProxy.values valuesVar;
        synchronized (readResolve.class) {
            int i = getSharedInstance;
            APIGuard = (i + 91) % 128;
            valuesVar = valueOf;
            int i2 = i + 85;
            APIGuard = i2 % 128;
            if ((i2 % 2 != 0 ? 'M' : (char) 19) == 'M') {
                throw new ArithmeticException();
            }
        }
        return valuesVar;
    }

    public static void values(ConfigInstance.ConfigSerializationProxy.values valuesVar) {
        synchronized (readResolve.class) {
            int i = APIGuard;
            int i2 = i + 21;
            getSharedInstance = i2 % 128;
            if ((i2 % 2 == 0 ? '=' : (char) 4) == '=') {
                throw new NullPointerException();
            } else if (valuesVar == null) {
                return;
            } else {
                valueOf = valuesVar;
                int i3 = i + 87;
                getSharedInstance = i3 % 128;
                if (i3 % 2 != 0) {
                    return;
                }
                throw new ArithmeticException();
            }
        }
    }

    public static void getSharedInstance(ConfigInstance.ConfigSerializationProxy.values valuesVar, ConfigInstance.ConfigSerializationProxy.AGState aGState, String str) {
        int i = APIGuard + 109;
        getSharedInstance = i % 128;
        if ((i % 2 == 0 ? '?' : 'F') == '?') {
            AGState();
            throw new ArithmeticException();
        } else if (valuesVar.compareTo(AGState()) > 0) {
        } else {
            Message message = new Message();
            message.obj = new ConfigInstance(valuesVar, aGState, str, System.currentTimeMillis());
            KernelPayloadInstance.getSharedInstance().sendMessage(message);
            int i2 = APIGuard + 79;
            getSharedInstance = i2 % 128;
            if (!(i2 % 2 == 0)) {
                return;
            }
            throw new ArithmeticException();
        }
    }

    public static void values(ConfigInstance.ConfigSerializationProxy.values valuesVar, String str, String str2) {
        int i = getSharedInstance + 21;
        APIGuard = i % 128;
        if ((i % 2 != 0 ? (char) 2 : '\b') != 2) {
            if (valuesVar.compareTo(AGState()) <= 0) {
                Message message = new Message();
                message.obj = new ConfigInstance(valuesVar, str, str2, System.currentTimeMillis());
                KernelPayloadInstance.getSharedInstance().sendMessage(message);
                return;
            }
            int i2 = APIGuard + 109;
            getSharedInstance = i2 % 128;
            if ((i2 % 2 == 0 ? 'G' : Typography.greater) == '>') {
                return;
            }
            throw new NullPointerException();
        }
        AGState();
        throw null;
    }

    public static void values(ConfigInstance.ConfigSerializationProxy.values valuesVar, String str) {
        APIGuard = (getSharedInstance + 7) % 128;
        if (valuesVar.compareTo(AGState()) > 0) {
            return;
        }
        getSharedInstance(valuesVar, new ConfigInstance.ConfigSerializationProxy.AGState() { // from class: com.apiguard3.internal.readResolve.3
            private static int APIGuard = 1;
            private static int values;

            @Override // com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.AGState
            public final String getSharedInstance() {
                int i = values + 33;
                APIGuard = i % 128;
                if ((i % 2 == 0 ? 'E' : '\t') == '\t') {
                    return "";
                }
                throw new NullPointerException();
            }
        }, str);
        int i = getSharedInstance + 109;
        APIGuard = i % 128;
        if (i % 2 != 0) {
            throw null;
        }
    }

    public static void valueOf(ConfigInstance.ConfigSerializationProxy.values valuesVar, ConfigInstance.ConfigSerializationProxy.AGState aGState) {
        int i = APIGuard + 49;
        getSharedInstance = i % 128;
        if (i % 2 == 0) {
            AGState();
            throw new NullPointerException();
        } else if (valuesVar.compareTo(AGState()) > 0) {
        } else {
            getSharedInstance(valuesVar, aGState, null);
            int i2 = APIGuard + 27;
            getSharedInstance = i2 % 128;
            if ((i2 % 2 == 0 ? '#' : '3') == '3') {
                return;
            }
            throw new ArithmeticException();
        }
    }

    public static void valueOf(final int i, final String str, final String str2) {
        APIGuard = (getSharedInstance + 47) % 128;
        if (BuildConfig.valueOf.booleanValue()) {
            final ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.getSharedInstance;
            final ConfigInstance.ConfigSerializationProxy.AGState aGState = new ConfigInstance.ConfigSerializationProxy.AGState() { // from class: com.apiguard3.internal.readResolve.4
                private static int APIGuard = 0;
                private static int values = 1;

                @Override // com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.AGState
                public final String getSharedInstance() {
                    int i2 = values + 97;
                    int i3 = i2 % 128;
                    APIGuard = i3;
                    if (i2 % 2 != 0) {
                        throw null;
                    }
                    String str3 = str;
                    int i4 = i3 + 45;
                    values = i4 % 128;
                    if (i4 % 2 != 0) {
                        return str3;
                    }
                    throw new NullPointerException();
                }
            };
            final long currentTimeMillis = System.currentTimeMillis();
            ConfigInstance configInstance = new ConfigInstance(i, str, valuesVar, aGState, str2, currentTimeMillis) { // from class: com.apiguard3.internal.UriFilter$UrlMatcherSpec
                private static int getState = 0;
                private static int log = 1;
                private static boolean updateKernel = true;
                private long generateHeaders;
                private String getSharedInstance;
                private String initialize;
                private int parseResponseHeaders;
                public static final byte[] BuiltInFictitiousFunctionClassFactory = {114, -124, TarHeader.LF_CONTIG, 72, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
                public static final int MyBillsEntityDataFactory = 178;
                private static char[] analyzeResponse = {366, 386, 396, 383, 379, 382, 355, 350, 360, 391, 364, 381, 393, 365, 398, 385, 387, 394, 358};
                private static int getRequestHeaders = 282;
                private static boolean checkCertificates = true;

                private static void a(int i2, int i3, short s, Object[] objArr) {
                    int i4 = (s * 12) + 4;
                    int i5 = (i3 * 7) + 99;
                    int i6 = (i2 * 3) + 13;
                    byte[] bArr = BuiltInFictitiousFunctionClassFactory;
                    byte[] bArr2 = new byte[i6];
                    int i7 = -1;
                    int i8 = i6 - 1;
                    if (bArr == null) {
                        i4++;
                        i5 = i5 + i4 + 2;
                    }
                    while (true) {
                        i7++;
                        bArr2[i7] = (byte) i5;
                        if (i7 == i8) {
                            objArr[0] = new String(bArr2, 0);
                            return;
                        }
                        byte b = bArr[i4];
                        i4++;
                        i5 = i5 + b + 2;
                    }
                }

                {
                    super(valuesVar, aGState, str2, currentTimeMillis);
                    try {
                        byte b = BuiltInFictitiousFunctionClassFactory[15];
                        byte b2 = b;
                        Object[] objArr = new Object[1];
                        a(b, b2, b2, objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
                        byte b4 = b3;
                        Object[] objArr2 = new Object[1];
                        a(b3, b4, b4, objArr2);
                        this.generateHeaders = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId();
                        try {
                            byte b5 = BuiltInFictitiousFunctionClassFactory[15];
                            byte b6 = b5;
                            Object[] objArr3 = new Object[1];
                            a(b5, b6, b6, objArr3);
                            Class<?> cls2 = Class.forName((String) objArr3[0]);
                            byte b7 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
                            byte b8 = b7;
                            Object[] objArr4 = new Object[1];
                            a(b7, b8, b8, objArr4);
                            this.initialize = ((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).getName();
                            this.parseResponseHeaders = i;
                            this.getSharedInstance = str;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }

                @Override // com.apiguard3.internal.ConfigInstance
                public final String toString() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        Object[] objArr = new Object[1];
                        valueOf(127 - (ViewConfiguration.getWindowTouchSlop() >> 8), null, null, "\u0088\u0087\u0086\u0085\u0084\u0083\u0082\u0081", objArr);
                        jSONObject.put(((String) objArr[0]).intern(), this.generateHeaders);
                        Object[] objArr2 = new Object[1];
                        valueOf(127 - ExpandableListView.getPackedPositionType(0L), null, null, "\u0084\u008a\u0085\u0089\u0086\u0085\u0084\u0083\u0082\u0081", objArr2);
                        jSONObject.put(((String) objArr2[0]).intern(), this.initialize);
                        Object[] objArr3 = new Object[1];
                        valueOf(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 128, null, null, "\u0084\u008f\u0085\u008f\u008e\u0086\u0083\u008d\u008c\u0084\u008b", objArr3);
                        jSONObject.put(((String) objArr3[0]).intern(), this.parseResponseHeaders - 1);
                        Object[] objArr4 = new Object[1];
                        valueOf(ExpandableListView.getPackedPositionChild(0L) + 128, null, null, "\u0090\u0085\u0081", objArr4);
                        jSONObject.put(((String) objArr4[0]).intern(), this.getSharedInstance);
                        Object[] objArr5 = new Object[1];
                        valueOf(KeyEvent.keyCodeFromString("") + 127, null, null, "\u0092\u008a\u0085\u008f\u008e\u0084\u008a\u0091\u0081", objArr5);
                        jSONObject.put(((String) objArr5[0]).intern(), this.AGState);
                        Object[] objArr6 = new Object[1];
                        valueOf(TextUtils.indexOf((CharSequence) "", '0', 0) + 128, null, null, "\u0090\u008d\u0093", objArr6);
                        jSONObject.put(((String) objArr6[0]).intern(), this.valueOf);
                        getState = (log + 27) % 128;
                    } catch (JSONException unused) {
                    }
                    return jSONObject.toString();
                }

                /* JADX WARN: $VALUES field not found */
                /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
                /* loaded from: classes3.dex */
                public static final class valueOf {
                    public static final int AGState;
                    private static final /* synthetic */ int[] APIGuard;
                    private static int analyzeResponse = 0;
                    private static char generateHeaders = 0;
                    private static char getSharedInstance = 0;
                    private static int initialize = 1;
                    private static char parseResponseHeaders;
                    public static final int valueOf;
                    private static char values;

                    static void values() {
                        generateHeaders = (char) 22128;
                        parseResponseHeaders = (char) 20518;
                        values = (char) 33053;
                        getSharedInstance = (char) 42864;
                    }

                    public static int[] values$605170aa() {
                        initialize = (analyzeResponse + 69) % 128;
                        int[] iArr = (int[]) APIGuard.clone();
                        analyzeResponse = (initialize + 29) % 128;
                        return iArr;
                    }

                    static {
                        values();
                        SystemClock.uptimeMillis();
                        valueOf = 1;
                        ViewConfiguration.getKeyRepeatDelay();
                        AGState = 2;
                        View.MeasureSpec.getMode(0);
                        APIGuard = new int[]{1, 2, 3};
                        int i = initialize + 35;
                        analyzeResponse = i % 128;
                        if (!(i % 2 != 0)) {
                            return;
                        }
                        throw new ArithmeticException();
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
                    
                        r13 = r13;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    private static void APIGuard(java.lang.String r13, int r14, java.lang.Object[] r15) {
                        /*
                            if (r13 == 0) goto L6
                            char[] r13 = r13.toCharArray()
                        L6:
                            char[] r13 = (char[]) r13
                            java.lang.Object r0 = com.apiguard3.internal.setBackgroundDrawable.getSharedInstance
                            monitor-enter(r0)
                            int r1 = r13.length     // Catch: java.lang.Throwable -> L7a
                            char[] r1 = new char[r1]     // Catch: java.lang.Throwable -> L7a
                            r2 = 0
                            com.apiguard3.internal.setBackgroundDrawable.valueOf = r2     // Catch: java.lang.Throwable -> L7a
                            r3 = 2
                            char[] r4 = new char[r3]     // Catch: java.lang.Throwable -> L7a
                        L14:
                            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                            int r6 = r13.length     // Catch: java.lang.Throwable -> L7a
                            if (r5 >= r6) goto L71
                            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                            char r5 = r13[r5]     // Catch: java.lang.Throwable -> L7a
                            r4[r2] = r5     // Catch: java.lang.Throwable -> L7a
                            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                            r6 = 1
                            int r5 = r5 + r6
                            char r5 = r13[r5]     // Catch: java.lang.Throwable -> L7a
                            r4[r6] = r5     // Catch: java.lang.Throwable -> L7a
                            r5 = 58224(0xe370, float:8.1589E-41)
                            r7 = 0
                        L2b:
                            r8 = 16
                            if (r7 >= r8) goto L5e
                            char r8 = r4[r6]     // Catch: java.lang.Throwable -> L7a
                            char r9 = r4[r2]     // Catch: java.lang.Throwable -> L7a
                            int r10 = r9 + r5
                            int r11 = r9 << 4
                            char r12 = com.apiguard3.internal.UriFilter$UrlMatcherSpec.valueOf.generateHeaders     // Catch: java.lang.Throwable -> L7a
                            int r11 = r11 + r12
                            r10 = r10 ^ r11
                            int r11 = r9 >>> 5
                            char r12 = com.apiguard3.internal.UriFilter$UrlMatcherSpec.valueOf.parseResponseHeaders     // Catch: java.lang.Throwable -> L7a
                            int r11 = r11 + r12
                            r10 = r10 ^ r11
                            int r8 = r8 - r10
                            char r8 = (char) r8     // Catch: java.lang.Throwable -> L7a
                            r4[r6] = r8     // Catch: java.lang.Throwable -> L7a
                            char r10 = com.apiguard3.internal.UriFilter$UrlMatcherSpec.valueOf.values     // Catch: java.lang.Throwable -> L7a
                            int r11 = r8 >>> 5
                            char r12 = com.apiguard3.internal.UriFilter$UrlMatcherSpec.valueOf.getSharedInstance     // Catch: java.lang.Throwable -> L7a
                            int r11 = r11 + r12
                            int r12 = r8 + r5
                            int r8 = r8 << 4
                            int r8 = r8 + r10
                            r8 = r8 ^ r12
                            r8 = r8 ^ r11
                            int r9 = r9 - r8
                            char r8 = (char) r9     // Catch: java.lang.Throwable -> L7a
                            r4[r2] = r8     // Catch: java.lang.Throwable -> L7a
                            r8 = 40503(0x9e37, float:5.6757E-41)
                            int r5 = r5 - r8
                            int r7 = r7 + 1
                            goto L2b
                        L5e:
                            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                            char r7 = r4[r2]     // Catch: java.lang.Throwable -> L7a
                            r1[r5] = r7     // Catch: java.lang.Throwable -> L7a
                            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                            int r5 = r5 + r6
                            char r6 = r4[r6]     // Catch: java.lang.Throwable -> L7a
                            r1[r5] = r6     // Catch: java.lang.Throwable -> L7a
                            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                            int r5 = r5 + r3
                            com.apiguard3.internal.setBackgroundDrawable.valueOf = r5     // Catch: java.lang.Throwable -> L7a
                            goto L14
                        L71:
                            java.lang.String r13 = new java.lang.String     // Catch: java.lang.Throwable -> L7a
                            r13.<init>(r1, r2, r14)     // Catch: java.lang.Throwable -> L7a
                            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7a
                            r15[r2] = r13
                            return
                        L7a:
                            r13 = move-exception
                            monitor-exit(r0)
                            goto L7e
                        L7d:
                            throw r13
                        L7e:
                            goto L7d
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.UriFilter$UrlMatcherSpec.valueOf.APIGuard(java.lang.String, int, java.lang.Object[]):void");
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
                
                    r9 = r9;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                private static void valueOf(int r6, java.lang.String r7, int[] r8, java.lang.String r9, java.lang.Object[] r10) {
                    /*
                        Method dump skipped, instructions count: 180
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.UriFilter$UrlMatcherSpec.valueOf(int, java.lang.String, int[], java.lang.String, java.lang.Object[]):void");
                }
            };
            Message message = new Message();
            message.obj = configInstance;
            KernelPayloadInstance.getSharedInstance().sendMessage(message);
        }
        int i2 = getSharedInstance + 57;
        APIGuard = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 5 : (char) 17) != 5) {
            return;
        }
        throw new NullPointerException();
    }
}

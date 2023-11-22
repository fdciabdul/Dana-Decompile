package com.apiguard3.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.writeReplace;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public class D {
    private static D APIGuard = null;
    private static int generateHeaders = 1;
    private static int getRequestHeaders;
    private static int[] initialize;
    private static cs<Boolean> valueOf;
    private static boolean values;
    private final NTE AGState = new NTE();
    private Context getSharedInstance;

    static void values() {
        initialize = new int[]{321142214, 246100483, -1953690289, -1597150243, -403339407, 1697027639, -1145162434, 2047733716, 375416701, -1369317945, 1871012182, 1215676525, 1266205558, -716061421, -1687811026, 967434504, 845623027, 268747632};
    }

    native String cs(String str, String str2, String str3);

    native int dpi();

    native String[] gt(String str, String str2);

    native int ipi(String str);

    native int sdf(long j, long j2);

    native int spi(String str);

    static /* synthetic */ Context APIGuard(D d) {
        int i = generateHeaders + 117;
        getRequestHeaders = i % 128;
        boolean z = i % 2 == 0;
        Context context = d.getSharedInstance;
        if (z) {
            return context;
        }
        throw null;
    }

    static {
        values();
        AndroidCharacter.getMirror('0');
        KeyEvent.getDeadChar(0, 0);
        ViewConfiguration.getScrollBarFadeDuration();
        Process.myPid();
        Drawable.resolveOpacity(0, 0);
        ExpandableListView.getPackedPositionForChild(0, 0);
        values = false;
        getRequestHeaders = (generateHeaders + 33) % 128;
    }

    D() {
    }

    public static D AGState() {
        synchronized (D.class) {
            generateHeaders = (getRequestHeaders + 25) % 128;
            D d = APIGuard;
            if (d == null) {
                APIGuard = new D();
                try {
                    Context context = (Context) ((Class) com.apiguard3.internal.AGState.values(TextUtils.lastIndexOf("", '0') + 6397, Color.rgb(0, 0, 0) + 16777262, (char) Drawable.resolveOpacity(0, 0))).getMethod("APIGuard", null).invoke(null, null);
                    APIGuard.getSharedInstance = context;
                    valueOf = MatchConfig$Match.valueOf(context, "ag3");
                    D d2 = APIGuard;
                    int i = generateHeaders + 57;
                    getRequestHeaders = i % 128;
                    if ((i % 2 != 0 ? '.' : 'D') != '.') {
                        return d2;
                    }
                    throw new ArithmeticException();
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
            return d;
        }
    }

    public final void APIGuard(long j, long j2) {
        generateHeaders generateheaders = new generateHeaders(this, j, j2, (byte) 0);
        Object[] objArr = new Object[1];
        valueOf(new int[]{-557424001, 1019966272}, 2 - TextUtils.indexOf((CharSequence) "", '0', 0), objArr);
        this.AGState.getSharedInstance(new AGState(generateheaders, ((String) objArr[0]).intern()));
        int i = getRequestHeaders + 89;
        generateHeaders = i % 128;
        if (i % 2 != 0) {
            return;
        }
        throw new NullPointerException();
    }

    public final String valueOf(String str, String str2, String str3, String str4) {
        Object obj;
        valueOf valueof = new valueOf(this, str, str2, str3, str4, (byte) 0);
        Object[] objArr = new Object[1];
        valueOf(new int[]{861173149, -1257068191}, 3 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr);
        String str5 = (String) this.AGState.getSharedInstance(new AGState(valueof, ((String) objArr[0]).intern()));
        if ((str5 == null ? (char) 21 : '0') != '0') {
            int i = getRequestHeaders + 67;
            generateHeaders = i % 128;
            if ((i % 2 == 0 ? ')' : 'W') != ')') {
                Object[] objArr2 = new Object[1];
                valueOf(new int[]{-1226177023, 1610668944}, 1 - TextUtils.lastIndexOf("", '0', 0, 0), objArr2);
                obj = objArr2[0];
            } else {
                Object[] objArr3 = new Object[1];
                valueOf(new int[]{-1226177023, 1610668944}, TextUtils.lastIndexOf("", 'i', 0, 1) * 1, objArr3);
                obj = objArr3[0];
            }
            String intern = ((String) obj).intern();
            getRequestHeaders = (generateHeaders + 73) % 128;
            return intern;
        }
        return str5;
    }

    public final String[] values(String str, String str2) {
        values valuesVar = new values(this, str, str2, (byte) 0);
        Object[] objArr = new Object[1];
        valueOf(new int[]{-2021963427, 1153989716}, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 1, objArr);
        String[] strArr = (String[]) this.AGState.getSharedInstance(new AGState(valuesVar, ((String) objArr[0]).intern()));
        if (strArr != null) {
            int i = generateHeaders + 19;
            int i2 = i % 128;
            getRequestHeaders = i2;
            if (!(i % 2 == 0)) {
                int length = strArr.length;
                throw new ArithmeticException();
            }
            if (!(strArr.length == 0)) {
                generateHeaders = (i2 + 91) % 128;
                return strArr;
            }
        }
        readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.getSharedInstance, writeReplace.getSharedInstance.FraudScore);
        return new String[0];
    }

    static boolean APIGuard() {
        synchronized (D.class) {
            int i = getRequestHeaders + 67;
            generateHeaders = i % 128;
            if (i % 2 == 0) {
                throw new NullPointerException();
            }
            if ((!values ? 'K' : (char) 16) == 'K') {
                try {
                    values = valueOf.get(3L, TimeUnit.SECONDS).booleanValue();
                    getRequestHeaders = (generateHeaders + 9) % 128;
                } catch (InterruptedException e) {
                    e = e;
                    readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.getSharedInstance.log, e.toString());
                    boolean z = values;
                    generateHeaders = (getRequestHeaders + 53) % 128;
                    return z;
                } catch (TimeoutException e2) {
                    e = e2;
                    readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.getSharedInstance.log, e.toString());
                    boolean z2 = values;
                    generateHeaders = (getRequestHeaders + 53) % 128;
                    return z2;
                }
            }
            boolean z22 = values;
            generateHeaders = (getRequestHeaders + 53) % 128;
        }
        return z22;
    }

    public final int getSharedInstance() {
        getSharedInstance getsharedinstance = new getSharedInstance(this, (byte) 0);
        Object[] objArr = new Object[1];
        valueOf(new int[]{61603804, 2069091663}, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 3, objArr);
        Integer num = (Integer) this.AGState.getSharedInstance(new AGState(getsharedinstance, ((String) objArr[0]).intern()));
        if ((num == null ? 'b' : '\t') != 'b') {
            return num.intValue();
        }
        int i = getRequestHeaders + 35;
        generateHeaders = i % 128;
        if ((i % 2 == 0 ? 'U' : 'A') != 'U') {
            return -1;
        }
        throw null;
    }

    public final int getSharedInstance(String str) {
        parseResponseHeaders parseresponseheaders = new parseResponseHeaders(this, str, (byte) 0);
        Object[] objArr = new Object[1];
        valueOf(new int[]{1685218341, 1714107924}, TextUtils.getCapsMode("", 0, 0) + 3, objArr);
        Integer num = (Integer) this.AGState.getSharedInstance(new AGState(parseresponseheaders, ((String) objArr[0]).intern()));
        if (num != null) {
            return num.intValue();
        }
        int i = (generateHeaders + 119) % 128;
        getRequestHeaders = i;
        int i2 = i + 109;
        generateHeaders = i2 % 128;
        if ((i2 % 2 == 0 ? (byte) 1 : (byte) 0) != 1) {
            return -1;
        }
        throw new NullPointerException();
    }

    public final int valueOf() {
        APIGuard aPIGuard = new APIGuard(this, (byte) 0);
        Object[] objArr = new Object[1];
        valueOf(new int[]{-224177201, -1011660475}, ExpandableListView.getPackedPositionType(0L) + 3, objArr);
        Integer num = (Integer) this.AGState.getSharedInstance(new AGState(aPIGuard, ((String) objArr[0]).intern()));
        if ((num == null ? '1' : 'O') != '1') {
            int intValue = num.intValue();
            getRequestHeaders = (generateHeaders + 103) % 128;
            return intValue;
        }
        int i = getRequestHeaders + 1;
        generateHeaders = i % 128;
        if ((i % 2 == 0 ? '`' : (char) 18) != '`') {
            return -1;
        }
        throw new ArithmeticException();
    }

    /* loaded from: classes7.dex */
    static final class AGState<TaskResult> extends MT<TaskResult> {
        private static int getSharedInstance = 1;
        private static int valueOf;

        AGState(Callable<TaskResult> callable, String str) {
            super(callable, str);
        }

        @Override // com.apiguard3.internal.MT, java.util.concurrent.Callable
        public final TaskResult call() throws Exception {
            valueOf = (getSharedInstance + 63) % 128;
            try {
                if (D.APIGuard()) {
                    return (TaskResult) super.call();
                }
                getSharedInstance = (valueOf + 125) % 128;
                readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.ScoredEntry);
                return null;
            } catch (Throwable th) {
                readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.E, th.toString());
                throw th;
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class generateHeaders implements Callable<Boolean> {
        private static int APIGuard = 1;
        private static int getSharedInstance;
        private long AGState;
        private long valueOf;
        private WeakReference<D> values;

        /* synthetic */ generateHeaders(D d, long j, long j2, byte b) {
            this(d, j, j2);
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Boolean call() throws Exception {
            int i = getSharedInstance + 63;
            APIGuard = i % 128;
            if ((i % 2 == 0 ? Typography.less : (char) 24) == '<') {
                AGState();
                throw new NullPointerException();
            }
            Boolean AGState = AGState();
            int i2 = APIGuard + 83;
            getSharedInstance = i2 % 128;
            if ((i2 % 2 != 0 ? Typography.greater : '\n') != '>') {
                return AGState;
            }
            throw new ArithmeticException();
        }

        private generateHeaders(D d, long j, long j2) {
            this.values = new WeakReference<>(d);
            this.valueOf = j;
            this.AGState = j2;
        }

        private Boolean AGState() throws Exception {
            boolean z;
            D d = this.values.get();
            if (d == null) {
                return Boolean.FALSE;
            }
            if ((d.sdf(this.valueOf, this.AGState) == 0 ? '^' : '0') != '^') {
                z = false;
            } else {
                int i = APIGuard;
                getSharedInstance = (i + 27) % 128;
                getSharedInstance = (i + 111) % 128;
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    /* loaded from: classes7.dex */
    static final class valueOf implements Callable<String> {
        private static int analyzeResponse = 0;
        private static int generateHeaders = 1;
        private static int parseResponseHeaders = 75;
        private final String AGState;
        private final String APIGuard;
        private final String getSharedInstance;
        private final String valueOf;
        private WeakReference<D> values;

        /* synthetic */ valueOf(D d, String str, String str2, String str3, String str4, byte b) {
            this(d, str, str2, str3, str4);
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ String call() throws Exception {
            int i = analyzeResponse + 87;
            generateHeaders = i % 128;
            if ((i % 2 == 0 ? '/' : '@') != '@') {
                valueOf();
                throw new NullPointerException();
            }
            String valueOf = valueOf();
            int i2 = analyzeResponse + 41;
            generateHeaders = i2 % 128;
            if (i2 % 2 == 0) {
                throw new ArithmeticException();
            }
            return valueOf;
        }

        private valueOf(D d, String str, String str2, String str3, String str4) {
            this.values = new WeakReference<>(d);
            this.valueOf = str;
            this.getSharedInstance = str2;
            this.AGState = str3;
            this.APIGuard = str4;
        }

        private String valueOf() throws Exception {
            D d = this.values.get();
            if (d != null) {
                String cs = d.cs(this.valueOf, this.getSharedInstance, this.AGState);
                if (cs == null) {
                    int i = generateHeaders + 95;
                    analyzeResponse = i % 128;
                    if ((i % 2 != 0 ? 'X' : '[') == '[') {
                        readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.getRequestHeaders);
                        analyzeResponse = (generateHeaders + 91) % 128;
                        return null;
                    }
                    readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.getRequestHeaders);
                    throw new ArithmeticException();
                }
                StringBuilder sb = new StringBuilder();
                Object[] objArr = new Object[1];
                getSharedInstance("\u001d￤", ExpandableListView.getPackedPositionGroup(0L) + 2, 137 - (ViewConfiguration.getScrollBarSize() >> 8), 2 - View.resolveSize(0, 0), false, objArr);
                sb.append(((String) objArr[0]).intern());
                sb.append(cs);
                Object[] objArr2 = new Object[1];
                getSharedInstance("\u0007��", View.combineMeasuredStates(0, 0) + 2, 112 - TextUtils.indexOf("", "", 0), 3 - TextUtils.indexOf("", "", 0), true, objArr2);
                sb.append(((String) objArr2[0]).intern());
                sb.append(this.AGState);
                Object[] objArr3 = new Object[1];
                getSharedInstance("\u0007��", (ViewConfiguration.getLongPressTimeout() >> 16) + 2, 113 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 3 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), true, objArr3);
                sb.append(((String) objArr3[0]).intern());
                sb.append(this.APIGuard);
                Object[] objArr4 = new Object[1];
                getSharedInstance("\u001e￣", View.MeasureSpec.getMode(0) + 1, 138 - (ViewConfiguration.getWindowTouchSlop() >> 8), 2 - ((Process.getThreadPriority(0) + 20) >> 6), false, objArr4);
                sb.append(((String) objArr4[0]).intern());
                return sb.toString();
            }
            analyzeResponse = (generateHeaders + 53) % 128;
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        
            r6 = r6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void getSharedInstance(java.lang.String r6, int r7, int r8, int r9, boolean r10, java.lang.Object[] r11) {
            /*
                if (r6 == 0) goto L6
                char[] r6 = r6.toCharArray()
            L6:
                char[] r6 = (char[]) r6
                java.lang.Object r0 = com.apiguard3.internal.setForegroundTintList.getSharedInstance
                monitor-enter(r0)
                char[] r1 = new char[r9]     // Catch: java.lang.Throwable -> L75
                r2 = 0
                com.apiguard3.internal.setForegroundTintList.APIGuard = r2     // Catch: java.lang.Throwable -> L75
            L10:
                int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                if (r3 >= r9) goto L33
                int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                char r3 = r6[r3]     // Catch: java.lang.Throwable -> L75
                com.apiguard3.internal.setForegroundTintList.values = r3     // Catch: java.lang.Throwable -> L75
                int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                int r4 = com.apiguard3.internal.setForegroundTintList.values     // Catch: java.lang.Throwable -> L75
                int r4 = r4 + r8
                char r4 = (char) r4     // Catch: java.lang.Throwable -> L75
                r1[r3] = r4     // Catch: java.lang.Throwable -> L75
                int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                char r4 = r1[r3]     // Catch: java.lang.Throwable -> L75
                int r5 = com.apiguard3.internal.D.valueOf.parseResponseHeaders     // Catch: java.lang.Throwable -> L75
                int r4 = r4 - r5
                char r4 = (char) r4     // Catch: java.lang.Throwable -> L75
                r1[r3] = r4     // Catch: java.lang.Throwable -> L75
                int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                int r3 = r3 + 1
                com.apiguard3.internal.setForegroundTintList.APIGuard = r3     // Catch: java.lang.Throwable -> L75
                goto L10
            L33:
                if (r7 <= 0) goto L4e
                com.apiguard3.internal.setForegroundTintList.AGState = r7     // Catch: java.lang.Throwable -> L75
                char[] r6 = new char[r9]     // Catch: java.lang.Throwable -> L75
                java.lang.System.arraycopy(r1, r2, r6, r2, r9)     // Catch: java.lang.Throwable -> L75
                int r7 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
                int r7 = r9 - r7
                int r8 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
                java.lang.System.arraycopy(r6, r2, r1, r7, r8)     // Catch: java.lang.Throwable -> L75
                int r7 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
                int r8 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
                int r8 = r9 - r8
                java.lang.System.arraycopy(r6, r7, r1, r2, r8)     // Catch: java.lang.Throwable -> L75
            L4e:
                if (r10 == 0) goto L6c
                char[] r6 = new char[r9]     // Catch: java.lang.Throwable -> L75
                com.apiguard3.internal.setForegroundTintList.APIGuard = r2     // Catch: java.lang.Throwable -> L75
            L54:
                int r7 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                if (r7 >= r9) goto L6b
                int r7 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                int r8 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                int r8 = r9 - r8
                int r8 = r8 + (-1)
                char r8 = r1[r8]     // Catch: java.lang.Throwable -> L75
                r6[r7] = r8     // Catch: java.lang.Throwable -> L75
                int r7 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                int r7 = r7 + 1
                com.apiguard3.internal.setForegroundTintList.APIGuard = r7     // Catch: java.lang.Throwable -> L75
                goto L54
            L6b:
                r1 = r6
            L6c:
                java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L75
                r6.<init>(r1)     // Catch: java.lang.Throwable -> L75
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L75
                r11[r2] = r6
                return
            L75:
                r6 = move-exception
                monitor-exit(r0)
                goto L79
            L78:
                throw r6
            L79:
                goto L78
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.D.valueOf.getSharedInstance(java.lang.String, int, int, int, boolean, java.lang.Object[]):void");
        }
    }

    /* loaded from: classes7.dex */
    static final class values implements Callable<String[]> {
        private static int APIGuard = 0;
        private static int valueOf = 1;
        private WeakReference<D> AGState;
        private final String getSharedInstance;
        private final String values;

        /* synthetic */ values(D d, String str, String str2, byte b) {
            this(d, str, str2);
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ String[] call() throws Exception {
            APIGuard = (valueOf + 119) % 128;
            String[] values = values();
            APIGuard = (valueOf + 53) % 128;
            return values;
        }

        private values(D d, String str, String str2) {
            this.AGState = new WeakReference<>(d);
            this.values = str;
            this.getSharedInstance = str2;
        }

        private String[] values() throws Exception {
            valueOf = (APIGuard + 39) % 128;
            D d = this.AGState.get();
            if ((d == null ? '!' : 'N') == 'N') {
                String[] gt = d.gt(this.values, this.getSharedInstance);
                if (gt != null) {
                    APIGuard = (valueOf + 85) % 128;
                    if ((gt.length == 0 ? '[' : Typography.quote) == '\"') {
                        return gt;
                    }
                }
                readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.ipi);
                return new String[0];
            }
            int i = valueOf + 17;
            APIGuard = i % 128;
            if (i % 2 == 0) {
                return null;
            }
            throw new NullPointerException();
        }
    }

    /* loaded from: classes7.dex */
    static final class getSharedInstance implements Callable<Integer> {
        private static int APIGuard = 0;
        private static long getSharedInstance = 8434416912005175242L;
        private static int values = 1;
        private WeakReference<D> valueOf;

        /* synthetic */ getSharedInstance(D d, byte b) {
            this(d);
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Integer call() throws Exception {
            int i = values + 37;
            APIGuard = i % 128;
            if ((i % 2 != 0 ? '_' : 'M') == '_') {
                APIGuard();
                throw new NullPointerException();
            }
            Integer APIGuard2 = APIGuard();
            int i2 = APIGuard + 83;
            values = i2 % 128;
            if ((i2 % 2 == 0 ? 'H' : (char) 7) != 'H') {
                return APIGuard2;
            }
            throw null;
        }

        private getSharedInstance(D d) {
            this.valueOf = new WeakReference<>(d);
        }

        private Integer APIGuard() throws Exception {
            int i = APIGuard + 117;
            values = i % 128;
            if (i % 2 != 0) {
                D d = this.valueOf.get();
                if ((d == null ? '-' : 'T') == '-') {
                    values = (APIGuard + 71) % 128;
                    return null;
                }
                int ipi = d.ipi(D.APIGuard(d).getFilesDir().getAbsolutePath());
                if (ipi != 0) {
                    ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.values;
                    StringBuilder sb = new StringBuilder();
                    Object[] objArr = new Object[1];
                    getSharedInstance("溳滶\ud905亽ڂ帠⥤餑\u31e9\u2fd7衉磏킗轷\ueb46\udbe7玻氮䮴", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1, objArr);
                    sb.append(((String) objArr[0]).intern());
                    sb.append(ipi);
                    readResolve.values(valuesVar, sb.toString());
                }
                return Integer.valueOf(ipi);
            }
            this.valueOf.get();
            throw new ArithmeticException();
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        
            r8 = r8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void getSharedInstance(java.lang.String r8, int r9, java.lang.Object[] r10) {
            /*
                if (r8 == 0) goto L6
                char[] r8 = r8.toCharArray()
            L6:
                char[] r8 = (char[]) r8
                java.lang.Object r0 = com.apiguard3.internal.setForegroundTintBlendMode.getSharedInstance
                monitor-enter(r0)
                long r1 = com.apiguard3.internal.D.getSharedInstance.getSharedInstance     // Catch: java.lang.Throwable -> L4a
                char[] r8 = com.apiguard3.internal.setForegroundTintBlendMode.APIGuard(r1, r8, r9)     // Catch: java.lang.Throwable -> L4a
                r9 = 4
                com.apiguard3.internal.setForegroundTintBlendMode.valueOf = r9     // Catch: java.lang.Throwable -> L4a
            L14:
                int r1 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
                int r2 = r8.length     // Catch: java.lang.Throwable -> L4a
                if (r1 >= r2) goto L3e
                int r1 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
                int r1 = r1 - r9
                com.apiguard3.internal.setForegroundTintBlendMode.APIGuard = r1     // Catch: java.lang.Throwable -> L4a
                int r1 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
                int r2 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
                char r2 = r8[r2]     // Catch: java.lang.Throwable -> L4a
                int r3 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
                int r3 = r3 % r9
                char r3 = r8[r3]     // Catch: java.lang.Throwable -> L4a
                r2 = r2 ^ r3
                long r2 = (long) r2     // Catch: java.lang.Throwable -> L4a
                int r4 = com.apiguard3.internal.setForegroundTintBlendMode.APIGuard     // Catch: java.lang.Throwable -> L4a
                long r4 = (long) r4     // Catch: java.lang.Throwable -> L4a
                long r6 = com.apiguard3.internal.D.getSharedInstance.getSharedInstance     // Catch: java.lang.Throwable -> L4a
                long r4 = r4 * r6
                long r2 = r2 ^ r4
                int r3 = (int) r2     // Catch: java.lang.Throwable -> L4a
                char r2 = (char) r3     // Catch: java.lang.Throwable -> L4a
                r8[r1] = r2     // Catch: java.lang.Throwable -> L4a
                int r1 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
                int r1 = r1 + 1
                com.apiguard3.internal.setForegroundTintBlendMode.valueOf = r1     // Catch: java.lang.Throwable -> L4a
                goto L14
            L3e:
                java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L4a
                int r2 = r8.length     // Catch: java.lang.Throwable -> L4a
                int r2 = r2 - r9
                r1.<init>(r8, r9, r2)     // Catch: java.lang.Throwable -> L4a
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L4a
                r8 = 0
                r10[r8] = r1
                return
            L4a:
                r8 = move-exception
                monitor-exit(r0)
                goto L4e
            L4d:
                throw r8
            L4e:
                goto L4d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.D.getSharedInstance.getSharedInstance(java.lang.String, int, java.lang.Object[]):void");
        }
    }

    /* loaded from: classes7.dex */
    static final class parseResponseHeaders implements Callable<Integer> {
        private static int analyzeResponse = 1;
        private static char generateHeaders = 13288;
        private static char getSharedInstance = 18864;
        private static int initialize = 0;
        private static char valueOf = 19034;
        private static char values = 55042;
        private WeakReference<D> AGState;
        private final String APIGuard;

        /* synthetic */ parseResponseHeaders(D d, String str, byte b) {
            this(d, str);
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Integer call() throws Exception {
            analyzeResponse = (initialize + 85) % 128;
            Integer AGState = AGState();
            analyzeResponse = (initialize + 19) % 128;
            return AGState;
        }

        private parseResponseHeaders(D d, String str) {
            this.AGState = new WeakReference<>(d);
            this.APIGuard = str;
        }

        private Integer AGState() throws Exception {
            int i = analyzeResponse + 113;
            initialize = i % 128;
            if (!(i % 2 == 0)) {
                this.AGState.get();
                throw new ArithmeticException();
            }
            D d = this.AGState.get();
            if ((d == null ? 'B' : (char) 15) != 15) {
                analyzeResponse = (initialize + 93) % 128;
                return null;
            }
            int spi = d.spi(this.APIGuard);
            if (spi != 0) {
                ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.values;
                StringBuilder sb = new StringBuilder();
                Object[] objArr = new Object[1];
                AGState("\ue3d4আ⯼ႍ송⧰\uec35큥愺\uee8b徤\ue524\uea57졽忦棢", KeyEvent.getDeadChar(0, 0) + 15, objArr);
                sb.append(((String) objArr[0]).intern());
                sb.append(spi);
                readResolve.values(valuesVar, sb.toString());
            }
            return Integer.valueOf(spi);
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        
            r13 = r13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void AGState(java.lang.String r13, int r14, java.lang.Object[] r15) {
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
                char r12 = com.apiguard3.internal.D.parseResponseHeaders.values     // Catch: java.lang.Throwable -> L7a
                int r11 = r11 + r12
                r10 = r10 ^ r11
                int r11 = r9 >>> 5
                char r12 = com.apiguard3.internal.D.parseResponseHeaders.generateHeaders     // Catch: java.lang.Throwable -> L7a
                int r11 = r11 + r12
                r10 = r10 ^ r11
                int r8 = r8 - r10
                char r8 = (char) r8     // Catch: java.lang.Throwable -> L7a
                r4[r6] = r8     // Catch: java.lang.Throwable -> L7a
                char r10 = com.apiguard3.internal.D.parseResponseHeaders.getSharedInstance     // Catch: java.lang.Throwable -> L7a
                int r11 = r8 >>> 5
                char r12 = com.apiguard3.internal.D.parseResponseHeaders.valueOf     // Catch: java.lang.Throwable -> L7a
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
            throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.D.parseResponseHeaders.AGState(java.lang.String, int, java.lang.Object[]):void");
        }
    }

    /* loaded from: classes7.dex */
    static final class APIGuard implements Callable<Integer> {
        private static char AGState = 4;
        private static int APIGuard = 0;
        private static int getSharedInstance = 1;
        private static char[] values = {2, 3, 13754, 13802, 1, 13800, 13805, 13810, 13791, 5, 13806, 13728, 13822, 13811, 13813, 4};
        private WeakReference<D> valueOf;

        /* synthetic */ APIGuard(D d, byte b) {
            this(d);
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Integer call() throws Exception {
            APIGuard = (getSharedInstance + 77) % 128;
            Integer APIGuard2 = APIGuard();
            APIGuard = (getSharedInstance + 19) % 128;
            return APIGuard2;
        }

        private APIGuard(D d) {
            this.valueOf = new WeakReference<>(d);
        }

        private Integer APIGuard() throws Exception {
            D d = this.valueOf.get();
            if (d != null) {
                int dpi = d.dpi();
                if (dpi != 0) {
                    ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.values;
                    StringBuilder sb = new StringBuilder();
                    Object[] objArr = new Object[1];
                    getSharedInstance("\t\u0004\u0006\r\u0006\u0001\u0005\u000e\u000b\u0006\u0000\u000e\u0001\u000f㘀", (byte) (96 - Color.argb(0, 0, 0, 0)), 15 - TextUtils.indexOf("", "", 0, 0), objArr);
                    sb.append(((String) objArr[0]).intern());
                    sb.append(dpi);
                    readResolve.values(valuesVar, sb.toString());
                }
                Integer valueOf = Integer.valueOf(dpi);
                int i = APIGuard + 41;
                getSharedInstance = i % 128;
                if (i % 2 == 0) {
                    throw new ArithmeticException();
                }
                return valueOf;
            }
            APIGuard = (getSharedInstance + 25) % 128;
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        
            r12 = r12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void getSharedInstance(java.lang.String r12, byte r13, int r14, java.lang.Object[] r15) {
            /*
                Method dump skipped, instructions count: 257
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.D.APIGuard.getSharedInstance(java.lang.String, byte, int, java.lang.Object[]):void");
        }
    }

    private static void valueOf(int[] iArr, int i, Object[] objArr) {
        String str;
        synchronized (setBackgroundTintBlendMode.getSharedInstance) {
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length << 1];
            int[] iArr2 = (int[]) initialize.clone();
            setBackgroundTintBlendMode.valueOf = 0;
            while (setBackgroundTintBlendMode.valueOf < iArr.length) {
                cArr[0] = (char) (iArr[setBackgroundTintBlendMode.valueOf] >> 16);
                cArr[1] = (char) iArr[setBackgroundTintBlendMode.valueOf];
                cArr[2] = (char) (iArr[setBackgroundTintBlendMode.valueOf + 1] >> 16);
                cArr[3] = (char) iArr[setBackgroundTintBlendMode.valueOf + 1];
                setBackgroundTintBlendMode.values = (cArr[0] << 16) + cArr[1];
                setBackgroundTintBlendMode.AGState = (cArr[2] << 16) + cArr[3];
                setBackgroundTintBlendMode.values(iArr2);
                for (int i2 = 0; i2 < 16; i2++) {
                    int i3 = setBackgroundTintBlendMode.values ^ iArr2[i2];
                    setBackgroundTintBlendMode.values = i3;
                    setBackgroundTintBlendMode.AGState = setBackgroundTintBlendMode.valueOf(i3) ^ setBackgroundTintBlendMode.AGState;
                    int i4 = setBackgroundTintBlendMode.values;
                    setBackgroundTintBlendMode.values = setBackgroundTintBlendMode.AGState;
                    setBackgroundTintBlendMode.AGState = i4;
                }
                int i5 = setBackgroundTintBlendMode.values;
                setBackgroundTintBlendMode.values = setBackgroundTintBlendMode.AGState;
                setBackgroundTintBlendMode.AGState = i5;
                setBackgroundTintBlendMode.AGState = i5 ^ iArr2[16];
                setBackgroundTintBlendMode.values ^= iArr2[17];
                int i6 = setBackgroundTintBlendMode.values;
                int i7 = setBackgroundTintBlendMode.AGState;
                cArr[0] = (char) (setBackgroundTintBlendMode.values >>> 16);
                cArr[1] = (char) setBackgroundTintBlendMode.values;
                cArr[2] = (char) (setBackgroundTintBlendMode.AGState >>> 16);
                cArr[3] = (char) setBackgroundTintBlendMode.AGState;
                setBackgroundTintBlendMode.values(iArr2);
                cArr2[setBackgroundTintBlendMode.valueOf << 1] = cArr[0];
                cArr2[(setBackgroundTintBlendMode.valueOf << 1) + 1] = cArr[1];
                cArr2[(setBackgroundTintBlendMode.valueOf << 1) + 2] = cArr[2];
                cArr2[(setBackgroundTintBlendMode.valueOf << 1) + 3] = cArr[3];
                setBackgroundTintBlendMode.valueOf += 2;
            }
            str = new String(cArr2, 0, i);
        }
        objArr[0] = str;
    }
}

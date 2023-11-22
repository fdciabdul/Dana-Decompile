package com.apiguard3.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.apiguard3.BuildConfig;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.writeReplace;
import java.io.IOException;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public class C {
    private static int APIGuard$Callback = 0;
    private static int APIGuard$InitializationCallback = 1;
    private static boolean BuildConfig;
    private static char[] getState;
    private static long log;
    private static boolean onInitializationFailure;
    private static Object parseResponseHeaders$1cf25108;
    private static int pushMinPayload;
    private static values updateKernel$138bf7f2;
    private final HandlerThread AGState;
    private values APIGuard;
    private Object analyzeResponse$6d23221;
    private final long getSharedInstance;
    private final Handler valueOf;
    private Thread.UncaughtExceptionHandler values;
    private long generateHeaders = 0;
    private boolean initialize = false;
    private boolean checkCertificates = false;
    private AtomicBoolean getRequestHeaders = new AtomicBoolean(true);

    /* loaded from: classes7.dex */
    public interface values {
        void values(long j, String str);
    }

    static {
        AGState();
        ViewConfiguration.getWindowTouchSlop();
        Color.red(0);
        KeyEvent.getMaxKeyCode();
        ViewConfiguration.getScrollDefaultDelay();
        PointF.length(0.0f, 0.0f);
        TextUtils.indexOf("", "", 0, 0);
        KeyEvent.keyCodeFromString("");
        TextUtils.lastIndexOf("", '0', 0, 0);
        Color.rgb(0, 0, 0);
        APIGuard$InitializationCallback = (pushMinPayload + 87) % 128;
    }

    static void AGState() {
        log = -5851962514654712664L;
        BuildConfig = true;
        getState = new char[]{201, 221, 231, 218, 214, 217, Typography.times, 225, 222, 227, 233, 199, 234, 193, 175, 187, 216, 228, 200, 220, 232, 236, 184, 219, Typography.paragraph, 229, 165};
        APIGuard$Callback = 117;
        onInitializationFailure = true;
    }

    private native int am(long j, String str, byte[] bArr);

    private native long ce();

    private native boolean cf(long j, String str, int i, int i2);

    private native void de(long j);

    private native String rf(long j, String str, Object[] objArr);

    private native int rm(long j, String str);

    private native boolean ss(long j, String str, int i);

    static /* synthetic */ void AGState(C c) {
        int i = pushMinPayload + 27;
        APIGuard$InitializationCallback = i % 128;
        char c2 = i % 2 == 0 ? '!' : (char) 30;
        c.APIGuard();
        if (c2 == '!') {
            throw new ArithmeticException();
        }
        int i2 = pushMinPayload + 67;
        APIGuard$InitializationCallback = i2 % 128;
        if ((i2 % 2 == 0 ? '\f' : (char) 18) == 18) {
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void AGState$41615e18(C c, Object obj, String str, String str2) {
        int i = APIGuard$InitializationCallback + 15;
        pushMinPayload = i % 128;
        char c2 = i % 2 != 0 ? 'V' : Typography.greater;
        c.AGState$2e3c443f(obj, str, str2);
        if (c2 != 'V') {
            return;
        }
        throw new ArithmeticException();
    }

    public final boolean values() {
        int i = (pushMinPayload + 25) % 128;
        APIGuard$InitializationCallback = i;
        boolean z = this.initialize;
        int i2 = i + 17;
        pushMinPayload = i2 % 128;
        if (i2 % 2 != 0) {
            throw new ArithmeticException();
        }
        return z;
    }

    public C(long j, Object obj, values valuesVar) {
        this.getSharedInstance = j;
        this.APIGuard = valuesVar;
        this.analyzeResponse$6d23221 = obj;
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        valueOf("곤絬྇", 53634 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), objArr);
        sb.append(((String) objArr[0]).intern());
        sb.append(j);
        HandlerThread handlerThread = new HandlerThread(sb.toString());
        this.AGState = handlerThread;
        handlerThread.start();
        this.valueOf = new Handler(handlerThread.getLooper());
        valueOf valueof = new valueOf(this);
        this.values = valueof;
        handlerThread.setUncaughtExceptionHandler(valueof);
    }

    public final void AGState$3698d92d(final Object obj) {
        this.valueOf.post(new Runnable() { // from class: com.apiguard3.internal.C.1
            private static char AGState = 35604;
            private static char analyzeResponse = 29290;
            private static int initialize = 0;
            private static int parseResponseHeaders = 1;
            private static char valueOf = 39693;
            private static char values = 37217;

            @Override // java.lang.Runnable
            public final void run() {
                initialize = (parseResponseHeaders + 111) % 128;
                C c = C.this;
                Object obj2 = obj;
                Object[] objArr = new Object[1];
                valueOf("粋坠", 1 - ImageFormat.getBitsPerPixel(0), objArr);
                String intern = ((String) objArr[0]).intern();
                Object[] objArr2 = new Object[1];
                valueOf("빊ꈡ༁ހ鈡嚹㦪∫", 8 - Color.blue(0), objArr2);
                C.AGState$41615e18(c, obj2, intern, ((String) objArr2[0]).intern());
                C c2 = C.this;
                Object[] objArr3 = new Object[1];
                valueOf("Ꮱ\uf1e1禁倛\ued93嫲槾⧝ᐪ\ud8a9쀟\ue7a0㭖渿", (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 13, objArr3);
                c2.AGState(((String) objArr3[0]).intern(), null);
                C c3 = C.this;
                Object[] objArr4 = new Object[1];
                valueOf("䄖戮䄰僗醘굒ႌ謊࿊溚", (ViewConfiguration.getScrollDefaultDelay() >> 16) + 10, objArr4);
                c3.AGState(((String) objArr4[0]).intern(), null);
                initialize = (parseResponseHeaders + 41) % 128;
            }

            /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
            
                r13 = r13;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private static void valueOf(java.lang.String r13, int r14, java.lang.Object[] r15) {
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
                    char r12 = com.apiguard3.internal.C.AnonymousClass1.values     // Catch: java.lang.Throwable -> L7a
                    int r11 = r11 + r12
                    r10 = r10 ^ r11
                    int r11 = r9 >>> 5
                    char r12 = com.apiguard3.internal.C.AnonymousClass1.analyzeResponse     // Catch: java.lang.Throwable -> L7a
                    int r11 = r11 + r12
                    r10 = r10 ^ r11
                    int r8 = r8 - r10
                    char r8 = (char) r8     // Catch: java.lang.Throwable -> L7a
                    r4[r6] = r8     // Catch: java.lang.Throwable -> L7a
                    char r10 = com.apiguard3.internal.C.AnonymousClass1.AGState     // Catch: java.lang.Throwable -> L7a
                    int r11 = r8 >>> 5
                    char r12 = com.apiguard3.internal.C.AnonymousClass1.valueOf     // Catch: java.lang.Throwable -> L7a
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
                throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.C.AnonymousClass1.valueOf(java.lang.String, int, java.lang.Object[]):void");
            }
        });
        APIGuard$InitializationCallback = (pushMinPayload + 77) % 128;
    }

    public final void valueOf(final String str, final Object[] objArr) {
        this.valueOf.post(new Runnable() { // from class: com.apiguard3.internal.C.4
            private static int getSharedInstance = 0;
            private static int values = 1;

            @Override // java.lang.Runnable
            public final void run() {
                int i = getSharedInstance + 29;
                values = i % 128;
                if ((i % 2 == 0 ? (char) 23 : 'L') != 23) {
                    C.this.AGState(str, objArr);
                } else {
                    C.this.AGState(str, objArr);
                    throw null;
                }
            }
        });
        APIGuard$InitializationCallback = (pushMinPayload + 63) % 128;
    }

    private void values$29e3d4ad(String str, Object[] objArr, Object obj) {
        APIGuard$InitializationCallback = (pushMinPayload + 63) % 128;
        valueOf$29e3d4ad(str, objArr, obj);
        APIGuard$InitializationCallback = (pushMinPayload + 125) % 128;
    }

    public final long valueOf() {
        int i = pushMinPayload + 71;
        int i2 = i % 128;
        APIGuard$InitializationCallback = i2;
        if ((i % 2 == 0 ? '/' : '!') == '/') {
            throw new ArithmeticException();
        }
        long j = this.getSharedInstance;
        int i3 = i2 + 63;
        pushMinPayload = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 27 : '\f') == '\f') {
            return j;
        }
        throw new ArithmeticException();
    }

    public final void getSharedInstance() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Object[] objArr = new Object[1];
        valueOf("곍ޡ﨣꺏ĳ\uf5f8\ua878᳚\uf74eꨥẝ\uf11fꖋ\u187a쳶", 43889 - (KeyEvent.getMaxKeyCode() >> 16), objArr);
        values$29e3d4ad(((String) objArr[0]).intern(), null, null);
        this.valueOf.post(new Runnable() { // from class: com.apiguard3.internal.C.5
            private static int AGState = 1;
            private static int getSharedInstance;

            @Override // java.lang.Runnable
            public final void run() {
                getSharedInstance = (AGState + 67) % 128;
                try {
                    C.AGState(C.this);
                    countDownLatch.countDown();
                    int i = AGState + 3;
                    getSharedInstance = i % 128;
                    if ((i % 2 != 0 ? 'M' : 'J') == 'J') {
                        return;
                    }
                    throw new ArithmeticException();
                } catch (Throwable th) {
                    try {
                        try {
                            readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.SLE, (String) ((Class) AGState.values((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 6573, 36 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (1941 - (KeyEvent.getMaxKeyCode() >> 16)))).getMethod("values", Throwable.class).invoke(null, th));
                        } catch (Throwable th2) {
                            Throwable cause = th2.getCause();
                            if (cause == null) {
                                throw th2;
                            }
                            throw cause;
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }
        });
        try {
            countDownLatch.await(20L, TimeUnit.SECONDS);
            int i = APIGuard$InitializationCallback + 81;
            pushMinPayload = i % 128;
            if ((i % 2 != 0 ? '*' : (char) 15) != '*') {
                return;
            }
            throw new ArithmeticException();
        } catch (Throwable th) {
            try {
                readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.values$605170aa, (String) ((Class) AGState.values(Color.green(0) + 6573, 35 - (Process.myTid() >> 22), (char) (MotionEvent.axisFromString("") + 1942))).getMethod("values", Throwable.class).invoke(null, th));
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    throw th2;
                }
                throw cause;
            }
        }
    }

    public final boolean AGState$afd2e0c(Object obj) {
        int i = pushMinPayload + 15;
        int i2 = i % 128;
        APIGuard$InitializationCallback = i2;
        if (!(i % 2 != 0)) {
            throw new NullPointerException();
        }
        Object obj2 = this.analyzeResponse$6d23221;
        if (obj2 == null) {
            int i3 = i2 + 31;
            pushMinPayload = i3 % 128;
            if (i3 % 2 == 0) {
                return false;
            }
            throw new NullPointerException();
        }
        try {
            return ((Boolean) ((Class) AGState.values(59 - MotionEvent.axisFromString(""), 40 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (5393 - ExpandableListView.getPackedPositionGroup(0L)))).getMethod("valueOf", (Class) AGState.values((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 342, 38 - ExpandableListView.getPackedPositionType(0L), (char) View.combineMeasuredStates(0, 0))).invoke(obj2, obj)).booleanValue();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public final void APIGuard(String str, int i) {
        int i2 = pushMinPayload + 29;
        APIGuard$InitializationCallback = i2 % 128;
        if (i2 % 2 == 0) {
            throw new ArithmeticException();
        } else if (str != null) {
            ss(this.generateHeaders, str, i);
            APIGuard$InitializationCallback = (pushMinPayload + 47) % 128;
        }
    }

    private void AGState$2e3c443f(Object obj, String str, String str2) {
        if (!BuildConfig.APIGuard.booleanValue()) {
            pushMinPayload = (APIGuard$InitializationCallback + 61) % 128;
            return;
        }
        long ce = ce();
        if (ce == 0) {
            readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.RB);
            this.getRequestHeaders.set(true);
            return;
        }
        this.getRequestHeaders.set(false);
        this.generateHeaders = ce;
        parseResponseHeaders$1cf25108 = obj;
        try {
            if (APIGuard((Map) ((Class) AGState.values(31 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 29 - Color.blue(0), (char) Drawable.resolveOpacity(0, 0))).getMethod("AGState", null).invoke(obj, null), str) == 0) {
                pushMinPayload = (APIGuard$InitializationCallback + 91) % 128;
                long j = this.generateHeaders;
                Object[] objArr = new Object[1];
                valueOf("곍麩젣㮣攀傤舎춆㽿櫷", Color.red(0) + 12919, objArr);
                this.initialize = cf(j, ((String) objArr[0]).intern(), 0, 6);
                long j2 = this.generateHeaders;
                Object[] objArr2 = new Object[1];
                getSharedInstance(null, null, (KeyEvent.getMaxKeyCode() >> 16) + 127, "\u0084\u0088\u0087\u0085\u0081\u0086\u0085\u0084\u0083\u0082\u0081", objArr2);
                this.checkCertificates = cf(j2, ((String) objArr2[0]).intern(), 1, 5);
                Object obj2 = this.analyzeResponse$6d23221;
                if (obj2 != null) {
                    int i = APIGuard$InitializationCallback + 63;
                    pushMinPayload = i % 128;
                    if (i % 2 != 0) {
                        try {
                            ((Class) AGState.values(Process.getGidForName("") + 61, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 40, (char) (Color.argb(0, 0, 0, 0) + 5393))).getMethod("values", C.class).invoke(obj2, this);
                            throw new NullPointerException();
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    try {
                        ((Class) AGState.values(60 - View.combineMeasuredStates(0, 0), 40 - TextUtils.getCapsMode("", 0, 0), (char) (5393 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))))).getMethod("values", C.class).invoke(obj2, this);
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                valueOf(str2);
            }
        } catch (Throwable th3) {
            Throwable cause3 = th3.getCause();
            if (cause3 == null) {
                throw th3;
            }
            throw cause3;
        }
    }

    private int APIGuard(Map<String, String> map, String str) {
        if (this.getRequestHeaders.get()) {
            readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.ConfigInstance$ConfigSerializationProxy);
            return -1;
        }
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                int rm = rm(this.generateHeaders, str);
                if (rm == 1) {
                    readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.ConfigInstance);
                } else {
                    if ((rm == 2 ? 'E' : 'C') != 'C') {
                        readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.MT);
                    } else {
                        if (rm == 3) {
                            int i = APIGuard$InitializationCallback + 115;
                            pushMinPayload = i % 128;
                            if (i % 2 != 0) {
                                readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.UriFilter);
                                throw new NullPointerException();
                            }
                            readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.UriFilter);
                        }
                    }
                }
                pushMinPayload = (APIGuard$InitializationCallback + 11) % 128;
                return rm;
            }
            int i2 = APIGuard$InitializationCallback + 103;
            pushMinPayload = i2 % 128;
            if ((i2 % 2 != 0 ? (char) 7 : (char) 25) != 25) {
                APIGuard(it.next().getValue());
                throw new ArithmeticException();
            }
            Map.Entry<String, String> next = it.next();
            if (APIGuard(next.getValue()) != null && am(this.generateHeaders, next.getKey(), APIGuard(next.getValue())) != 0) {
                ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.values;
                writeReplace.APIGuard aPIGuard = writeReplace.APIGuard.UriFilter$UrlMatcherSpec;
                StringBuilder sb = new StringBuilder();
                Object[] objArr = new Object[1];
                valueOf("계ܲﬣ꼓͜\uf70cꭹ\u1f7f\uf375ꝙ᭟켕", 44021 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), objArr);
                sb.append(((String) objArr[0]).intern());
                sb.append(next.getKey());
                readResolve.getSharedInstance(valuesVar, aPIGuard, sb.toString());
                return -1;
            }
            APIGuard$InitializationCallback = (pushMinPayload + 49) % 128;
        }
    }

    private static byte[] APIGuard(String str) {
        APIGuard$InitializationCallback = (pushMinPayload + 63) % 128;
        byte[] bArr = null;
        try {
            try {
                bArr = (byte[]) ((Class) AGState.values(Color.green(0) + 6573, 35 - (ViewConfiguration.getTouchSlop() >> 8), (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 1941))).getMethod("APIGuard", byte[].class).invoke(null, Base64.decode(str, 0));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (IOException unused) {
            readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.E$CvmPayloadSerializationProxy);
        }
        int i = APIGuard$InitializationCallback + 117;
        pushMinPayload = i % 128;
        if ((i % 2 != 0 ? '\f' : (char) 14) != '\f') {
            return bArr;
        }
        throw new NullPointerException();
    }

    private String valueOf(String str) {
        pushMinPayload = (APIGuard$InitializationCallback + 43) % 128;
        String rf = rf(this.generateHeaders, str, null);
        if (rf == null) {
            ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.AGState;
            writeReplace.APIGuard aPIGuard = writeReplace.APIGuard.FU;
            StringBuilder sb = new StringBuilder();
            Object[] objArr = new Object[1];
            valueOf("곁ꍫ뎆菊鉮\ue2a7\uf2c7셿톒⇈〄\u0084Ⴢ朌瞛䟥嘌ꚧ뛻蔹镙\ue5f7\uf415쑗퓹⬢㭔\u0bad", Color.argb(0, 0, 0, 0) + 4013, objArr);
            sb.append(((String) objArr[0]).intern());
            sb.append(str);
            readResolve.getSharedInstance(valuesVar, aPIGuard, sb.toString());
            pushMinPayload = (APIGuard$InitializationCallback + 53) % 128;
        }
        APIGuard$InitializationCallback = (pushMinPayload + 61) % 128;
        return rf;
    }

    private void valueOf$29e3d4ad(String str, Object[] objArr, Object obj) {
        pushMinPayload = (APIGuard$InitializationCallback + 45) % 128;
        if (this.getRequestHeaders.get()) {
            ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.values;
            writeReplace.APIGuard aPIGuard = writeReplace.APIGuard.KernelPayloadInstance$KernelPayloadSerializationProxy;
            StringBuilder sb = new StringBuilder();
            Object[] objArr2 = new Object[1];
            getSharedInstance(null, null, TextUtils.getCapsMode("", 0, 0) + 127, "\u008f\u0086\u0085\u0084\u0083\u0082\u0081\u0085\u008d\u008e\u008a\u008d\u008c\u0088\u0085\u008a\u0083\u0084\u008b\u008a\u0089", objArr2);
            sb.append(((String) objArr2[0]).intern());
            sb.append(str);
            readResolve.getSharedInstance(valuesVar, aPIGuard, sb.toString());
            int i = APIGuard$InitializationCallback + 49;
            pushMinPayload = i % 128;
            if ((i % 2 != 0 ? 'K' : '%') != 'K') {
                return;
            }
            throw null;
        } else if (this.checkCertificates) {
            try {
                AGState$afd2e0c(((Class) AGState.values(418 - (ViewConfiguration.getEdgeSlop() >> 16), Color.alpha(0) + 43, (char) (59140 - Color.blue(0)))).getDeclaredConstructor(String.class, Object[].class, (Class) AGState.values(100 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 48 - Color.alpha(0), (char) ((Process.myPid() >> 22) + 26446))).newInstance(str, objArr, obj));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } else {
            ConfigInstance.ConfigSerializationProxy.values valuesVar2 = ConfigInstance.ConfigSerializationProxy.values.values;
            writeReplace.APIGuard aPIGuard2 = writeReplace.APIGuard.FU;
            StringBuilder sb2 = new StringBuilder();
            Object[] objArr3 = new Object[1];
            getSharedInstance(null, null, View.combineMeasuredStates(0, 0) + 127, "\u008f\u0086\u0085\u0084\u0083\u0082\u0081\u0085\u008d\u008e\u008a\u008d\u008c\u0088\u0085\u008a\u0083\u0084\u008b\u008a\u0089", objArr3);
            sb2.append(((String) objArr3[0]).intern());
            sb2.append(str);
            readResolve.getSharedInstance(valuesVar2, aPIGuard2, sb2.toString());
            APIGuard$InitializationCallback = (pushMinPayload + 35) % 128;
        }
    }

    final String AGState(String str, Object[] objArr) {
        if (this.getRequestHeaders.get()) {
            ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.values;
            writeReplace.APIGuard aPIGuard = writeReplace.APIGuard.KernelPayloadInstance$KernelPayloadSerializationProxy;
            StringBuilder sb = new StringBuilder();
            Object[] objArr2 = new Object[1];
            getSharedInstance(null, null, 127 - (ViewConfiguration.getEdgeSlop() >> 16), "\u008f\u008a\u0092\u0089\u008b\u0091\u008a\u008d\u0090\u0085\u008d\u008e\u008a\u008d\u008c\u0088\u0085\u008a\u0083\u0084\u008b\u008a\u0089", objArr2);
            sb.append(((String) objArr2[0]).intern());
            sb.append(str);
            readResolve.getSharedInstance(valuesVar, aPIGuard, sb.toString());
            return null;
        }
        String rf = rf(this.generateHeaders, str, objArr);
        if (rf == null) {
            ConfigInstance.ConfigSerializationProxy.values valuesVar2 = ConfigInstance.ConfigSerializationProxy.values.values;
            writeReplace.APIGuard aPIGuard2 = writeReplace.APIGuard.FU;
            StringBuilder sb2 = new StringBuilder();
            Object[] objArr3 = new Object[1];
            getSharedInstance(null, null, 127 - (ViewConfiguration.getKeyRepeatDelay() >> 16), "\u008f\u008a\u0092\u0089\u008b\u0091\u008a\u008d\u0090\u0085\u008d\u008e\u008a\u008d\u008c\u0088\u0085\u008a\u0083\u0084\u008b\u008a\u0089", objArr3);
            sb2.append(((String) objArr3[0]).intern());
            sb2.append(str);
            readResolve.getSharedInstance(valuesVar2, aPIGuard2, sb2.toString());
        }
        if (this.APIGuard != null) {
            pushMinPayload = (APIGuard$InitializationCallback + 91) % 128;
            if (!(rf == null)) {
                getSharedInstance(null, null, 175 - AndroidCharacter.getMirror('0'), "\u0095\u0088\u0085\u008a\u0094\u0089\u0093\u008b\u0091\u0084\u0088\u0088\u0092\u0091", new Object[1]);
                if ((!str.equals(((String) r1[0]).intern())) == false) {
                    this.APIGuard.values(this.getSharedInstance, rf);
                    APIGuard$InitializationCallback = (pushMinPayload + 69) % 128;
                }
            }
        }
        return rf;
    }

    private void APIGuard() {
        int i = pushMinPayload + 37;
        APIGuard$InitializationCallback = i % 128;
        try {
            if (i % 2 != 0) {
                Object obj = this.analyzeResponse$6d23221;
                if ((obj != null ? 'S' : '\b') != '\b') {
                    try {
                        ((Class) AGState.values(60 - TextUtils.indexOf("", "", 0), 40 - (Process.myTid() >> 22), (char) (5393 - (ViewConfiguration.getKeyRepeatDelay() >> 16)))).getMethod("valueOf", null).invoke(obj, null);
                        this.analyzeResponse$6d23221 = null;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                this.APIGuard = null;
                Object[] objArr = new Object[1];
                getSharedInstance(null, null, (-16777089) - Color.rgb(0, 0, 0), "\u008a\u0096\u0092\u0086\u008b\u008d\u0082\u0095", objArr);
                AGState(((String) objArr[0]).intern(), null);
                if (this.getRequestHeaders.getAndSet(true)) {
                    return;
                }
                de(this.generateHeaders);
                this.generateHeaders = 0L;
                this.AGState.quit();
                return;
            }
            throw new NullPointerException();
        } catch (Throwable th2) {
            try {
                try {
                    readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.SLE, (String) ((Class) AGState.values((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 6572, 35 - ExpandableListView.getPackedPositionType(0L), (char) (1941 - (ViewConfiguration.getKeyRepeatDelay() >> 16)))).getMethod("values", Throwable.class).invoke(null, th2));
                    if (this.getRequestHeaders.getAndSet(true)) {
                        return;
                    }
                    de(this.generateHeaders);
                    this.generateHeaders = 0L;
                    this.AGState.quit();
                } catch (Throwable th3) {
                    Throwable cause2 = th3.getCause();
                    if (cause2 == null) {
                        throw th3;
                    }
                    throw cause2;
                }
            } catch (Throwable th4) {
                if (this.getRequestHeaders.getAndSet(true)) {
                    pushMinPayload = (APIGuard$InitializationCallback + 99) % 128;
                    return;
                }
                de(this.generateHeaders);
                this.generateHeaders = 0L;
                this.AGState.quit();
                throw th4;
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class valueOf implements Thread.UncaughtExceptionHandler {
        private static int getSharedInstance = 1;
        private static int values;
        private WeakReference<C> valueOf;

        valueOf(C c) {
            this.valueOf = new WeakReference<>(c);
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th) {
            try {
                readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.SLE, (String) ((Class) AGState.values(6573 - (ViewConfiguration.getFadingEdgeLength() >> 16), 35 - (KeyEvent.getMaxKeyCode() >> 16), (char) (ExpandableListView.getPackedPositionType(0L) + 1941))).getMethod("values", Throwable.class).invoke(null, th));
                C c = this.valueOf.get();
                if ((c != null ? 'T' : 'P') != 'P') {
                    C.AGState(c);
                    values = (getSharedInstance + 27) % 128;
                }
                int i = values + 103;
                getSharedInstance = i % 128;
                if ((i % 2 == 0 ? '@' : '6') != '@') {
                    return;
                }
                throw new ArithmeticException();
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    throw th2;
                }
                throw cause;
            }
        }
    }

    private Object parseResponseHeaders$259901a0() {
        int i = pushMinPayload;
        APIGuard$InitializationCallback = (i + 31) % 128;
        Object obj = this.analyzeResponse$6d23221;
        int i2 = i + 29;
        APIGuard$InitializationCallback = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 16 : ',') != 16) {
            return obj;
        }
        throw new NullPointerException();
    }

    public static Context gt() {
        APIGuard$InitializationCallback = (pushMinPayload + 73) % 128;
        try {
            Context context = (Context) ((Class) AGState.values((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 6395, 46 - (ViewConfiguration.getTapTimeout() >> 16), (char) (Process.myTid() >> 22))).getMethod("APIGuard", null).invoke(null, null);
            pushMinPayload = (APIGuard$InitializationCallback + 3) % 128;
            return context;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static String gc() {
        pushMinPayload = (APIGuard$InitializationCallback + 95) % 128;
        try {
            String str = (String) ((Class) AGState.values((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 31, 29 - Drawable.resolveOpacity(0, 0), (char) View.resolveSize(0, 0))).getMethod("getSharedInstance", null).invoke(parseResponseHeaders$1cf25108, null);
            int i = pushMinPayload + 9;
            APIGuard$InitializationCallback = i % 128;
            if ((i % 2 == 0 ? '7' : ']') != '7') {
                return str;
            }
            throw new NullPointerException();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int sc(String str) {
        Object parseResponseHeaders$259901a0;
        values valuesVar = updateKernel$138bf7f2;
        if ((valuesVar != null ? (char) 6 : (char) 31) != 6) {
            try {
                try {
                    parseResponseHeaders$259901a0 = ((C) ((Class) AGState.values(Color.argb(0, 0, 0, 0) + 1892, 25 - Gravity.getAbsoluteGravity(0, 0), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("APIGuard", null).invoke(((Class) AGState.values((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1892, TextUtils.lastIndexOf("", '0') + 26, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("getSharedInstance", null).invoke(null, null), null)).parseResponseHeaders$259901a0();
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        } else {
            try {
                parseResponseHeaders$259901a0 = ((C) ((Class) AGState.values(1892 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 26 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("APIGuard", null).invoke(valuesVar, null)).parseResponseHeaders$259901a0();
                APIGuard$InitializationCallback = (pushMinPayload + 125) % 128;
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 != null) {
                    throw cause3;
                }
                throw th3;
            }
        }
        if (parseResponseHeaders$259901a0 != null) {
            int i = APIGuard$InitializationCallback + 61;
            pushMinPayload = i % 128;
            if (i % 2 == 0) {
                try {
                    return !((Boolean) ((Class) AGState.values(60 - View.resolveSize(0, 0), (ViewConfiguration.getPressedStateDuration() >> 16) + 40, (char) (5393 - Color.argb(0, 0, 0, 0)))).getMethod("getSharedInstance", String.class).invoke(parseResponseHeaders$259901a0, str)).booleanValue() ? -1 : 0;
                } catch (Throwable th4) {
                    Throwable cause4 = th4.getCause();
                    if (cause4 != null) {
                        throw cause4;
                    }
                    throw th4;
                }
            }
            try {
                Boolean bool = (Boolean) ((Class) AGState.values(((byte) KeyEvent.getModifierMetaStateMask()) + 61, View.resolveSizeAndState(0, 0, 0) + 40, (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 5393))).getMethod("getSharedInstance", String.class).invoke(parseResponseHeaders$259901a0, str);
                throw new ArithmeticException();
            } catch (Throwable th5) {
                Throwable cause5 = th5.getCause();
                if (cause5 != null) {
                    throw cause5;
                }
                throw th5;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r7 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void valueOf(java.lang.String r7, int r8, java.lang.Object[] r9) {
        /*
            if (r7 == 0) goto L6
            char[] r7 = r7.toCharArray()
        L6:
            char[] r7 = (char[]) r7
            java.lang.Object r0 = com.apiguard3.internal.setForeground.valueOf
            monitor-enter(r0)
            com.apiguard3.internal.setForeground.APIGuard = r8     // Catch: java.lang.Throwable -> L3d
            int r8 = r7.length     // Catch: java.lang.Throwable -> L3d
            char[] r8 = new char[r8]     // Catch: java.lang.Throwable -> L3d
            r1 = 0
            com.apiguard3.internal.setForeground.values = r1     // Catch: java.lang.Throwable -> L3d
        L13:
            int r2 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r3 = r7.length     // Catch: java.lang.Throwable -> L3d
            if (r2 >= r3) goto L34
            int r2 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r3 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            char r3 = r7[r3]     // Catch: java.lang.Throwable -> L3d
            int r4 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r5 = com.apiguard3.internal.setForeground.APIGuard     // Catch: java.lang.Throwable -> L3d
            int r4 = r4 * r5
            r3 = r3 ^ r4
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L3d
            long r5 = com.apiguard3.internal.C.log     // Catch: java.lang.Throwable -> L3d
            long r3 = r3 ^ r5
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L3d
            char r3 = (char) r4     // Catch: java.lang.Throwable -> L3d
            r8[r2] = r3     // Catch: java.lang.Throwable -> L3d
            int r2 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r2 = r2 + 1
            com.apiguard3.internal.setForeground.values = r2     // Catch: java.lang.Throwable -> L3d
            goto L13
        L34:
            java.lang.String r7 = new java.lang.String     // Catch: java.lang.Throwable -> L3d
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L3d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3d
            r9[r1] = r7
            return
        L3d:
            r7 = move-exception
            monitor-exit(r0)
            goto L41
        L40:
            throw r7
        L41:
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.C.valueOf(java.lang.String, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r9 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void getSharedInstance(int[] r6, java.lang.String r7, int r8, java.lang.String r9, java.lang.Object[] r10) {
        /*
            Method dump skipped, instructions count: 180
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.C.getSharedInstance(int[], java.lang.String, int, java.lang.String, java.lang.Object[]):void");
    }
}

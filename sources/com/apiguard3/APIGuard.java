package com.apiguard3;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.apiguard3.domain.Config;
import com.apiguard3.internal.BHT;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.UriFilter$UrlMatcherSpec;
import com.apiguard3.internal.UriFilter$valueOf;
import com.apiguard3.internal.UrlMatcherConfig;
import com.apiguard3.internal.dpi;
import com.apiguard3.internal.readResolve;
import com.apiguard3.internal.setBackgroundTintList;
import com.apiguard3.internal.writeReplace;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public class APIGuard {
    public static final String ANY_URL;
    private static int APIGuard$InitializationCallback = 1;
    private static int BuildConfig;
    private static char[] log;
    private static char onInitializationFailure;
    private static char[] onInitializationSuccess;
    private static long pushMinPayload;
    private static APIGuard valueOf;
    private Object AGState$2b631d65;
    private volatile Object analyzeResponse$1a4bb38;
    private Object checkCertificates$384309d8;
    private volatile Object generateHeaders$17bfd588;
    private String getRequestHeaders;
    private Object getSharedInstance$4fc7517c;
    private InitializationCallback getState;
    private values initialize;
    private volatile Object parseResponseHeaders$4ad913bb;
    private getSharedInstance updateKernel;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {111, -54, 77, -36, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int BuiltInFictitiousFunctionClassFactory = 153;
    private final Object APIGuard = new Object();
    private volatile AGState values = AGState.APIGuardStateNotReady;
    private ExecutorService APIGuard$Callback = Executors.newSingleThreadExecutor();

    /* loaded from: classes.dex */
    public interface Callback {
        void checkCertificates(List<Certificate> list, String str) throws IOException;

        void log(String str);
    }

    /* loaded from: classes.dex */
    public interface InitializationCallback extends Callback {
        void onInitializationFailure(String str);

        void onInitializationSuccess();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface values {
    }

    static {
        APIGuard();
        Color.alpha(0);
        MotionEvent.axisFromString("");
        Color.green(0);
        Object[] objArr = new Object[1];
        APIGuard(22 - TextUtils.lastIndexOf("", '0'), (byte) (TextUtils.indexOf("", "", 0, 0) + 92), " \u001d\"\u0007\u0017\u0004㘑㘑(.0\u0003\n\u0001(\u0012\t0\r\u0001#%㙓", objArr);
        ANY_URL = ((String) objArr[0]).intern();
        BuildConfig = (APIGuard$InitializationCallback + 113) % 128;
    }

    static void APIGuard() {
        onInitializationFailure = (char) 7;
        log = new char[]{13788, 13778, 13728, 13794, 13774, 13787, 13748, 13789, 13823, 13822, 13754, 13820, 13804, 13802, 13747, 13773, 13811, 13792, 13790, 13815, 13796, 13783, 13821, 13816, 13780, 13801, 13807, 13779, 13806, 13800, 13798, 13810, 13797, 13793, 13803, 13757, 13813, 13770, 13785, 13819, 13768, 13817, 13749, 13771, 13814, 13795, 13769, 13812, 13791};
        pushMinPayload = 3414926550490724786L;
        onInitializationSuccess = new char[]{'S', 47603, 29474, 11603, 59014, 41011, 23151, 5005, 52729, 34597, 16538, 64199, 46132, 28281, 10140, 57641, 39749, 21692, 3809, 51268, 33161, 15342, 62757, 44689, 26846, 'F', 47552, 29445, 11619, 59052, 41003, 23129, 5051, 52706, 34619, 16572, 64195, 46137, 28270, 10201, 57628, 39796, 21691, 3817, 51283, 'G', 47575, 29456, 11600, 59066, 40987, 23129, 5050, 52673, 34615, 16529, 64212, 46113, 28226, 10201, 57615, 39748, 21687, 3830, 51222, 33211, 15343, 62767, 44701, 26837, 8721, 56423, 38304, 20237, 2374, 'r', 47575, 29448, 11641, 59049, 40990, 'A', 47586, 29485, 11601, 59069, 40987, 23134, 5050};
    }

    private static void a(Object[] objArr) {
        byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
        byte[] bArr2 = new byte[23];
        int i = 97;
        int i2 = 4;
        int i3 = 0;
        if (bArr == null) {
            i = (97 + (-22)) - 8;
            i2 = 4 + 1;
        }
        while (true) {
            bArr2[i3] = (byte) i;
            if (i3 == 22) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3++;
            i = (i + (-bArr[i2])) - 8;
            i2++;
        }
    }

    static /* synthetic */ void AGState(APIGuard aPIGuard) {
        APIGuard$InitializationCallback = (BuildConfig + 101) % 128;
        aPIGuard.valueOf();
        APIGuard$InitializationCallback = (BuildConfig + 79) % 128;
    }

    static /* synthetic */ void AGState(APIGuard aPIGuard, AGState aGState) {
        BuildConfig = (APIGuard$InitializationCallback + 1) % 128;
        aPIGuard.getSharedInstance(aGState);
        int i = BuildConfig + 89;
        APIGuard$InitializationCallback = i % 128;
        if (i % 2 != 0) {
            return;
        }
        throw null;
    }

    static /* synthetic */ void AGState(APIGuard aPIGuard, String str) {
        BuildConfig = (APIGuard$InitializationCallback + 125) % 128;
        aPIGuard.APIGuard(str);
        APIGuard$InitializationCallback = (BuildConfig + 101) % 128;
    }

    static /* synthetic */ values APIGuard(APIGuard aPIGuard) {
        int i = BuildConfig;
        int i2 = i + 33;
        APIGuard$InitializationCallback = i2 % 128;
        char c = i2 % 2 == 0 ? (char) 29 : Typography.greater;
        values valuesVar = aPIGuard.initialize;
        if (c == 29) {
            throw new ArithmeticException();
        }
        APIGuard$InitializationCallback = (i + 3) % 128;
        return valuesVar;
    }

    static /* synthetic */ void APIGuard(APIGuard aPIGuard, Application application, InputStream inputStream, Callback callback) {
        APIGuard$InitializationCallback = (BuildConfig + 73) % 128;
        aPIGuard.valueOf(application, inputStream, callback);
        int i = BuildConfig + 107;
        APIGuard$InitializationCallback = i % 128;
        if (i % 2 != 0) {
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ Object APIGuard$4dcd9e4e(APIGuard aPIGuard, Object obj) {
        APIGuard$InitializationCallback = (BuildConfig + 1) % 128;
        aPIGuard.generateHeaders$17bfd588 = obj;
        int i = APIGuard$InitializationCallback + 71;
        BuildConfig = i % 128;
        if ((i % 2 != 0 ? (char) 29 : 'B') != 29) {
            return obj;
        }
        throw null;
    }

    static /* synthetic */ Object getSharedInstance$f917bad(APIGuard aPIGuard) {
        int i = APIGuard$InitializationCallback + 33;
        BuildConfig = i % 128;
        boolean z = i % 2 != 0;
        Object obj = aPIGuard.parseResponseHeaders$4ad913bb;
        if (z) {
            throw null;
        }
        APIGuard$InitializationCallback = (BuildConfig + 73) % 128;
        return obj;
    }

    static /* synthetic */ InitializationCallback parseResponseHeaders(APIGuard aPIGuard) {
        int i = (BuildConfig + 15) % 128;
        APIGuard$InitializationCallback = i;
        InitializationCallback initializationCallback = aPIGuard.getState;
        BuildConfig = (i + 49) % 128;
        return initializationCallback;
    }

    static /* synthetic */ Object valueOf$2fb50a3a(APIGuard aPIGuard) {
        APIGuard$InitializationCallback = (BuildConfig + 93) % 128;
        Object obj = aPIGuard.analyzeResponse$1a4bb38;
        APIGuard$InitializationCallback = (BuildConfig + 11) % 128;
        return obj;
    }

    static /* synthetic */ void valueOf$3a2e006f(Config config, Object obj) {
        BuildConfig = (APIGuard$InitializationCallback + 25) % 128;
        APIGuard$3a2e006f(config, obj);
        int i = APIGuard$InitializationCallback + 75;
        BuildConfig = i % 128;
        if ((i % 2 != 0 ? '\b' : (char) 20) != '\b') {
            return;
        }
        throw null;
    }

    static /* synthetic */ Object values$15f2fffa(APIGuard aPIGuard) {
        int i = APIGuard$InitializationCallback + 125;
        BuildConfig = i % 128;
        boolean z = i % 2 == 0;
        Object obj = aPIGuard.generateHeaders$17bfd588;
        if (z) {
            return obj;
        }
        throw null;
    }

    private APIGuard() {
    }

    public static APIGuard getSharedInstance() {
        APIGuard aPIGuard;
        synchronized (APIGuard.class) {
            APIGuard$InitializationCallback = (BuildConfig + 89) % 128;
            if (valueOf == null) {
                try {
                    APIGuard aPIGuard2 = new APIGuard();
                    valueOf = aPIGuard2;
                    aPIGuard2.AGState();
                    BuildConfig = (APIGuard$InitializationCallback + 85) % 128;
                } catch (Exception unused) {
                    valueOf = null;
                }
            }
            aPIGuard = valueOf;
        }
        return aPIGuard;
    }

    private void AGState() {
        try {
            BHT.valueOf();
            try {
                this.AGState$2b631d65 = ((Class) com.apiguard3.internal.AGState.values(3215 - ImageFormat.getBitsPerPixel(0), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 33, (char) (ExpandableListView.getPackedPositionType(0L) + 40045))).getDeclaredConstructor(null).newInstance(null);
                try {
                    this.getSharedInstance$4fc7517c = ((Class) com.apiguard3.internal.AGState.values(1120 - ExpandableListView.getPackedPositionGroup(0L), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 33, (char) (62364 - (ViewConfiguration.getScrollBarSize() >> 8)))).getMethod("APIGuard", null).invoke(null, null);
                    BuildConfig = (APIGuard$InitializationCallback + 83) % 128;
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
        } catch (Exception unused) {
            BHT.getSharedInstance();
            this.AGState$2b631d65 = null;
            this.getSharedInstance$4fc7517c = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0084 A[Catch: all -> 0x00a8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:13:0x002c, B:14:0x002d, B:19:0x003e, B:24:0x004a, B:29:0x005e, B:36:0x0075, B:41:0x0084, B:44:0x0095, B:45:0x009e, B:42:0x008c, B:30:0x0063, B:34:0x006d, B:35:0x006e, B:10:0x0025, B:11:0x002a, B:31:0x0066, B:32:0x006b), top: B:51:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008c A[Catch: all -> 0x00a8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:13:0x002c, B:14:0x002d, B:19:0x003e, B:24:0x004a, B:29:0x005e, B:36:0x0075, B:41:0x0084, B:44:0x0095, B:45:0x009e, B:42:0x008c, B:30:0x0063, B:34:0x006d, B:35:0x006e, B:10:0x0025, B:11:0x002a, B:31:0x0066, B:32:0x006b), top: B:51:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0095 A[Catch: all -> 0x00a8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:13:0x002c, B:14:0x002d, B:19:0x003e, B:24:0x004a, B:29:0x005e, B:36:0x0075, B:41:0x0084, B:44:0x0095, B:45:0x009e, B:42:0x008c, B:30:0x0063, B:34:0x006d, B:35:0x006e, B:10:0x0025, B:11:0x002a, B:31:0x0066, B:32:0x006b), top: B:51:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009e A[Catch: all -> 0x00a8, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:13:0x002c, B:14:0x002d, B:19:0x003e, B:24:0x004a, B:29:0x005e, B:36:0x0075, B:41:0x0084, B:44:0x0095, B:45:0x009e, B:42:0x008c, B:30:0x0063, B:34:0x006d, B:35:0x006e, B:10:0x0025, B:11:0x002a, B:31:0x0066, B:32:0x006b), top: B:51:0x0001, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.String> getRequestHeaders(java.lang.String r8, byte[] r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Throwable -> La8
            r0.<init>()     // Catch: java.lang.Throwable -> La8
            if (r8 != 0) goto L2d
            int r8 = com.apiguard3.APIGuard.APIGuard$InitializationCallback     // Catch: java.lang.Throwable -> La8
            int r8 = r8 + 55
            int r8 = r8 % 128
            com.apiguard3.APIGuard.BuildConfig = r8     // Catch: java.lang.Throwable -> La8
            com.apiguard3.internal.ConfigInstance$ConfigSerializationProxy$values r8 = com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.values.getSharedInstance     // Catch: java.lang.Throwable -> La8
            com.apiguard3.internal.writeReplace$getSharedInstance r9 = com.apiguard3.internal.writeReplace.getSharedInstance.send     // Catch: java.lang.Throwable -> La8
            com.apiguard3.internal.readResolve.valueOf(r8, r9)     // Catch: java.lang.Throwable -> La8
            int r8 = com.apiguard3.APIGuard.BuildConfig     // Catch: java.lang.Throwable -> La8
            int r8 = r8 + 71
            int r9 = r8 % 128
            com.apiguard3.APIGuard.APIGuard$InitializationCallback = r9     // Catch: java.lang.Throwable -> La8
            int r8 = r8 % 2
            if (r8 == 0) goto L25
            monitor-exit(r7)
            return r0
        L25:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L2b
            r8.<init>()     // Catch: java.lang.Throwable -> L2b
            throw r8     // Catch: java.lang.Throwable -> L2b
        L2b:
            r8 = move-exception
            throw r8     // Catch: java.lang.Throwable -> La8
        L2d:
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La8
            com.apiguard3.AGState r3 = r7.values     // Catch: java.lang.Throwable -> La8
            com.apiguard3.AGState r4 = com.apiguard3.AGState.APIGuardStateReady     // Catch: java.lang.Throwable -> La8
            r5 = 1
            r6 = 0
            if (r3 != r4) goto L3b
            r3 = 0
            goto L3c
        L3b:
            r3 = 1
        L3c:
            if (r3 == r5) goto L6e
            com.apiguard3.getSharedInstance r3 = r7.updateKernel     // Catch: java.lang.Throwable -> La8
            r4 = 67
            if (r3 == 0) goto L47
            r5 = 67
            goto L48
        L47:
            r5 = 5
        L48:
            if (r5 != r4) goto L6e
            int r4 = com.apiguard3.APIGuard.BuildConfig     // Catch: java.lang.Throwable -> La8
            r5 = 43
            int r4 = r4 + r5
            int r6 = r4 % 128
            com.apiguard3.APIGuard.APIGuard$InitializationCallback = r6     // Catch: java.lang.Throwable -> La8
            int r4 = r4 % 2
            if (r4 != 0) goto L5a
            r4 = 43
            goto L5c
        L5a:
            r4 = 61
        L5c:
            if (r4 == r5) goto L63
            boolean r6 = r3.valueOf(r0, r8, r9)     // Catch: java.lang.Throwable -> La8
            goto L75
        L63:
            r3.valueOf(r0, r8, r9)     // Catch: java.lang.Throwable -> La8
            java.lang.ArithmeticException r8 = new java.lang.ArithmeticException     // Catch: java.lang.Throwable -> L6c
            r8.<init>()     // Catch: java.lang.Throwable -> L6c
            throw r8     // Catch: java.lang.Throwable -> L6c
        L6c:
            r8 = move-exception
            throw r8     // Catch: java.lang.Throwable -> La8
        L6e:
            com.apiguard3.internal.ConfigInstance$ConfigSerializationProxy$values r8 = com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.values.getSharedInstance     // Catch: java.lang.Throwable -> La8
            com.apiguard3.internal.writeReplace$getSharedInstance r9 = com.apiguard3.internal.writeReplace.getSharedInstance.clearCallback     // Catch: java.lang.Throwable -> La8
            com.apiguard3.internal.readResolve.valueOf(r8, r9)     // Catch: java.lang.Throwable -> La8
        L75:
            boolean r8 = r0.isEmpty()     // Catch: java.lang.Throwable -> La8
            r9 = 17
            if (r8 != 0) goto L80
            r8 = 52
            goto L82
        L80:
            r8 = 17
        L82:
            if (r8 == r9) goto L8c
            com.apiguard3.internal.ConfigInstance$ConfigSerializationProxy$values r8 = com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.values.valueOf     // Catch: java.lang.Throwable -> La8
            com.apiguard3.internal.writeReplace$AGState r9 = com.apiguard3.internal.writeReplace.AGState.values     // Catch: java.lang.Throwable -> La8
            com.apiguard3.internal.readResolve.valueOf(r8, r9)     // Catch: java.lang.Throwable -> La8
            goto L93
        L8c:
            com.apiguard3.internal.ConfigInstance$ConfigSerializationProxy$values r8 = com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.values.valueOf     // Catch: java.lang.Throwable -> La8
            com.apiguard3.internal.writeReplace$AGState r9 = com.apiguard3.internal.writeReplace.AGState.AGState     // Catch: java.lang.Throwable -> La8
            com.apiguard3.internal.readResolve.valueOf(r8, r9)     // Catch: java.lang.Throwable -> La8
        L93:
            if (r6 == 0) goto L9e
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La8
            long r8 = r8 - r1
            com.apiguard3.internal.UrlMatcherConfig.getSharedInstance.valueOf(r8)     // Catch: java.lang.Throwable -> La8
            goto La6
        L9e:
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La8
            long r8 = r8 - r1
            com.apiguard3.internal.UrlMatcherConfig.getSharedInstance.values(r8)     // Catch: java.lang.Throwable -> La8
        La6:
            monitor-exit(r7)
            return r0
        La8:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.APIGuard.getRequestHeaders(java.lang.String, byte[]):java.util.Map");
    }

    public void parseResponseHeaders(Map<String, String> map) {
        synchronized (this) {
            if (map == null) {
                BuildConfig = (APIGuard$InitializationCallback + 35) % 128;
                readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.getSharedInstance, writeReplace.getSharedInstance.AnalysesEntry);
                return;
            }
            if (this.values == AGState.APIGuardStateReady) {
                if ((this.analyzeResponse$1a4bb38 != null ? 'M' : 'X') != 'X') {
                    BuildConfig = (APIGuard$InitializationCallback + 85) % 128;
                    AGState(map);
                    return;
                }
            }
            readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.getSharedInstance, writeReplace.getSharedInstance.getVersion);
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object] */
    public Map<String, String> generateHeaders(String str, String str2, Map<String, List<String>> map, byte[] bArr) {
        Map<String, String> requestHeaders;
        synchronized (this) {
            BuildConfig = (APIGuard$InitializationCallback + 31) % 128;
            int i = UriFilter$UrlMatcherSpec.valueOf.valueOf;
            Object[] objArr = new Object[1];
            APIGuard(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, (byte) (85 - View.getDefaultSize(0, 0)), "/\u0004\u0006*\u0019\u0015'-\u000f\u0017.(.\u0017\u0002\u0012\u000f\f", objArr);
            String intern = ((String) objArr[0]).intern();
            ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.getSharedInstance;
            Object[] objArr2 = new Object[1];
            values((char) TextUtils.getOffsetBefore("", 0), 25 - ((Process.getThreadPriority(0) + 20) >> 6), KeyEvent.normalizeMetaState(0), objArr2);
            readResolve.valueOf(i, intern, ((String) objArr2[0]).intern());
            try {
                ((Class) com.apiguard3.internal.AGState.values(3182 - (KeyEvent.getMaxKeyCode() >> 16), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 34, (char) Drawable.resolveOpacity(0, 0))).getMethod("values", String.class, String.class, Map.class, byte[].class).invoke(this.AGState$2b631d65, str, str2, map, bArr);
                int i2 = UriFilter$UrlMatcherSpec.valueOf.valueOf;
                Object[] objArr3 = new Object[1];
                values((char) View.MeasureSpec.makeMeasureSpec(0, 0), 20 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 26, objArr3);
                String intern2 = ((String) objArr3[0]).intern();
                ConfigInstance.ConfigSerializationProxy.values valuesVar2 = ConfigInstance.ConfigSerializationProxy.values.getSharedInstance;
                Object[] objArr4 = new Object[1];
                APIGuard(TextUtils.indexOf("", "", 0, 0) + 16, (byte) (65 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), "\u0001\u001c(\u0019\b,\u0016\f\u001f+\b\u000f%\u000b\u000f$", objArr4);
                readResolve.valueOf(i2, intern2, ((String) objArr4[0]).intern());
                try {
                    Pair pair = (Pair) ((Class) com.apiguard3.internal.AGState.values(1120 - (ViewConfiguration.getFadingEdgeLength() >> 16), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 33, (char) (Color.rgb(0, 0, 0) + 16839580))).getMethod("APIGuard", String.class).invoke(this.getSharedInstance$4fc7517c, str);
                    int i3 = UriFilter$UrlMatcherSpec.valueOf.AGState;
                    Object[] objArr5 = new Object[1];
                    values((char) (ViewConfiguration.getJumpTapTimeout() >> 16), 'D' - AndroidCharacter.getMirror('0'), 25 - Color.alpha(0), objArr5);
                    String intern3 = ((String) objArr5[0]).intern();
                    ConfigInstance.ConfigSerializationProxy.values valuesVar3 = ConfigInstance.ConfigSerializationProxy.values.getSharedInstance;
                    Object[] objArr6 = new Object[1];
                    values((char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), 30 - Color.red(0), 45 - KeyEvent.getDeadChar(0, 0), objArr6);
                    readResolve.valueOf(i3, intern3, ((String) objArr6[0]).intern());
                    requestHeaders = getRequestHeaders(str, bArr);
                    if (pair != null) {
                        requestHeaders.put(pair.first, pair.second);
                        int i4 = BuildConfig + 101;
                        APIGuard$InitializationCallback = i4 % 128;
                        int i5 = i4 % 2;
                    }
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
        }
        return requestHeaders;
    }

    public void analyzeResponse(String str, Map<String, List<String>> map, byte[] bArr, int i) {
        synchronized (this) {
            BuildConfig = (APIGuard$InitializationCallback + 85) % 128;
            try {
                ((Class) com.apiguard3.internal.AGState.values(3182 - View.MeasureSpec.getSize(0), Color.alpha(0) + 34, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("APIGuard", String.class, Map.class, byte[].class, Integer.TYPE).invoke(this.AGState$2b631d65, str, map, bArr, Integer.valueOf(i));
                try {
                    parseResponseHeaders((Map) ((Class) com.apiguard3.internal.AGState.values((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 6534, 39 - (Process.myPid() >> 22), (char) (Color.rgb(0, 0, 0) + 16803250))).getMethod("valueOf", Map.class).invoke(null, map));
                    BuildConfig = (APIGuard$InitializationCallback + 113) % 128;
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
    }

    public void initialize(Application application, Callback callback, int i, String str) {
        synchronized (this) {
            APIGuard$InitializationCallback = (BuildConfig + 87) % 128;
            if (!values()) {
                ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.APIGuard;
                StringBuilder sb = new StringBuilder();
                Object[] objArr = new Object[1];
                APIGuard(AndroidCharacter.getMirror('0') + 5, (byte) (TextUtils.indexOf("", "", 0) + 25), "'(*(\u001f\u0007\u0015 $ \u001f\u0007\u0013,\u000e\u001e\u0012%\u0002\u0017\u0012&\u001e\u000e(+\u000b\n\u0016\f\u0007\u001f&\b\u001d \t\u000b(\u001b㘁㘁\f+\u001f\u0007\u0015 # \t\u0001㗓", objArr);
                sb.append(((String) objArr[0]).intern());
                sb.append(this.values);
                readResolve.values(valuesVar, sb.toString());
                return;
            }
            UrlMatcherConfig.getSharedInstance.AGState();
            getSharedInstance(AGState.APIGuardStateInProgress);
            try {
                getSharedInstance(application);
                this.getRequestHeaders = str;
                getSharedInstance(callback);
                valueOf(callback);
                int i2 = UriFilter$UrlMatcherSpec.valueOf.valueOf;
                Object[] objArr2 = new Object[1];
                APIGuard((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 55, (byte) (View.combineMeasuredStates(0, 0) + 73), "\u0019&\u001e\u000e\r\t\u0016\u000f\u0016\u0002\u000b$\n\t \u0016\u0002\u0012\u000f\f\u001c\u0002/$\r\u001d\u0016\f\u0015 \u0002\u0012\u000f\f ,\u0006\u0001*/ #\u001e\u000e'0\u000f\u0017.(.\u0017\u0002\u0012\u000f\f", objArr2);
                String intern = ((String) objArr2[0]).intern();
                ConfigInstance.ConfigSerializationProxy.values valuesVar2 = ConfigInstance.ConfigSerializationProxy.values.getSharedInstance;
                Object[] objArr3 = new Object[1];
                APIGuard(6 - View.getDefaultSize(0, 0), (byte) ((ViewConfiguration.getTapTimeout() >> 16) + 73), "\u0000\f\u001a0\u000e\u001e", objArr3);
                readResolve.valueOf(i2, intern, ((String) objArr3[0]).intern());
                getSharedInstance(application, callback, application.getApplicationContext().getResources().openRawResource(i));
                BuildConfig = (APIGuard$InitializationCallback + 61) % 128;
            } catch (Throwable th) {
                values(th);
            }
        }
    }

    private void values(Throwable th) {
        int i = APIGuard$InitializationCallback + 81;
        BuildConfig = i % 128;
        if (i % 2 != 0) {
            getSharedInstance(AGState.APIGuardStateFailed);
            TextUtils.isEmpty(th.getMessage());
            throw null;
        }
        getSharedInstance(AGState.APIGuardStateFailed);
        String message = th.getMessage();
        if (TextUtils.isEmpty(message)) {
            int i2 = BuildConfig + 75;
            APIGuard$InitializationCallback = i2 % 128;
            if (i2 % 2 == 0) {
                throw new NullPointerException();
            }
            message = th.toString();
        }
        readResolve.values(ConfigInstance.ConfigSerializationProxy.values.getSharedInstance, message);
        APIGuard(message);
        if (th instanceof IllegalArgumentException) {
            APIGuard$InitializationCallback = (BuildConfig + 31) % 128;
            throw ((IllegalArgumentException) th);
        }
    }

    private boolean values() {
        BuildConfig = (APIGuard$InitializationCallback + 51) % 128;
        if (this.values != AGState.APIGuardStateNotReady) {
            if ((this.values == AGState.APIGuardStateFailed ? '^' : 'Y') != '^') {
                return false;
            }
        }
        APIGuard$InitializationCallback = (BuildConfig + 37) % 128;
        return true;
    }

    public AGState getState() {
        int i = APIGuard$InitializationCallback + 63;
        BuildConfig = i % 128;
        if ((i % 2 != 0 ? (char) 7 : 'F') == 'F') {
            return this.values;
        }
        throw null;
    }

    private void getSharedInstance(AGState aGState) {
        synchronized (this.APIGuard) {
            this.values = aGState;
            dpi.AGState().values(this.values);
        }
    }

    protected boolean updateKernel() {
        if (this.generateHeaders$17bfd588 == null) {
            return false;
        }
        BuildConfig = (APIGuard$InitializationCallback + 5) % 128;
        try {
            boolean booleanValue = ((Boolean) ((Class) com.apiguard3.internal.AGState.values(TextUtils.indexOf("", "") + 2731, 43 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (13731 - Color.alpha(0)))).getMethod("valueOf", null).invoke(this.generateHeaders$17bfd588, null)).booleanValue();
            int i = BuildConfig + 119;
            APIGuard$InitializationCallback = i % 128;
            if (!(i % 2 == 0)) {
                return booleanValue;
            }
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static void getSharedInstance(Application application) {
        int i = APIGuard$InitializationCallback + 79;
        BuildConfig = i % 128;
        if ((i % 2 != 0 ? (char) 31 : (char) 7) == 31) {
            throw null;
        } else if (application == null) {
            throw new IllegalArgumentException(writeReplace.getSharedInstance.AGState.getSharedInstance());
        } else {
            try {
                Object invoke = ((Class) com.apiguard3.internal.AGState.values(6397 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 46, (char) TextUtils.getOffsetAfter("", 0))).getMethod("values", null).invoke(null, null);
                try {
                    Object[] objArr = {application};
                    Class cls = (Class) com.apiguard3.internal.AGState.values(6395 - ((byte) KeyEvent.getModifierMetaStateMask()), KeyEvent.normalizeMetaState(0) + 46, (char) TextUtils.getCapsMode("", 0, 0));
                    Object[] objArr2 = new Object[1];
                    a(objArr2);
                    cls.getMethod("getSharedInstance", Class.forName((String) objArr2[0])).invoke(invoke, objArr);
                    APIGuard$InitializationCallback = (BuildConfig + 91) % 128;
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
    }

    private void getSharedInstance(final Application application, final Callback callback, final InputStream inputStream) throws IllegalArgumentException {
        try {
            Object[] objArr = new Object[1];
            APIGuard(12 - View.combineMeasuredStates(0, 0), (byte) ((ViewConfiguration.getLongPressTimeout() >> 16) + 38), ")\u000b\u000f\u0017\u0019(\u001e\b\t\u0017#\u0014", objArr);
            BHT.APIGuard(((String) objArr[0]).intern(), new Runnable() { // from class: com.apiguard3.APIGuard.5
                private static int analyzeResponse = 1;
                private static int valueOf;

                @Override // java.lang.Runnable
                public final void run() {
                    analyzeResponse = (valueOf + 19) % 128;
                    try {
                        APIGuard.APIGuard(APIGuard.this, application, inputStream, callback);
                        int i = analyzeResponse + 53;
                        valueOf = i % 128;
                        if ((i % 2 != 0 ? '\\' : 'S') != '\\') {
                            return;
                        }
                        throw new NullPointerException();
                    } catch (Throwable th) {
                        readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.getSharedInstance, writeReplace.getSharedInstance.ScoredEntry);
                        readResolve.values(ConfigInstance.ConfigSerializationProxy.values.values, Arrays.toString(th.getStackTrace()));
                    }
                }
            });
            int i = APIGuard$InitializationCallback + 69;
            BuildConfig = i % 128;
            if ((i % 2 != 0 ? (char) 4 : 'Y') != 4) {
                return;
            }
            throw new ArithmeticException();
        } catch (Throwable th) {
            readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.getSharedInstance.ScoredEntry, th.toString());
            throw new IllegalThreadStateException(writeReplace.getSharedInstance.ScoredEntry.getSharedInstance());
        }
    }

    private void valueOf(final Application application, InputStream inputStream, final Callback callback) {
        int i = (APIGuard$InitializationCallback + 97) % 128;
        BuildConfig = i;
        if (inputStream == null) {
            APIGuard$InitializationCallback = (i + 109) % 128;
            readResolve.values(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.valueOf.getSharedInstance());
        }
        try {
            final Context context = (Context) ((Class) com.apiguard3.internal.AGState.values(ExpandableListView.getPackedPositionType(0L) + 6396, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 45, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("APIGuard", null).invoke(null, null);
            if (context == null) {
                int i2 = APIGuard$InitializationCallback + 29;
                BuildConfig = i2 % 128;
                if (i2 % 2 != 0) {
                    readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.getSharedInstance, writeReplace.getSharedInstance.AGState);
                    throw new ArithmeticException();
                }
                readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.getSharedInstance, writeReplace.getSharedInstance.AGState);
                APIGuard$InitializationCallback = (BuildConfig + 23) % 128;
                return;
            }
            try {
                ((Class) com.apiguard3.internal.AGState.values(1120 - TextUtils.indexOf("", ""), 33 - TextUtils.indexOf("", "", 0, 0), (char) (62364 - (ViewConfiguration.getTapTimeout() >> 16)))).getMethod("getSharedInstance", null).invoke(this.getSharedInstance$4fc7517c, null);
                try {
                    ((Class) com.apiguard3.internal.AGState.values(AndroidCharacter.getMirror('0') + 1072, (ViewConfiguration.getLongPressTimeout() >> 16) + 33, (char) (62364 - (ViewConfiguration.getWindowTouchSlop() >> 8)))).getMethod("values", (Class) com.apiguard3.internal.AGState.values(TextUtils.indexOf((CharSequence) "", '0', 0) + 1294, 41 - View.resolveSize(0, 0), (char) (TextUtils.getTrimmedLength("") + 31633))).invoke(this.getSharedInstance$4fc7517c, this.AGState$2b631d65);
                    try {
                        Object[] objArr = {context, this.getRequestHeaders};
                        Class cls = (Class) com.apiguard3.internal.AGState.values(2441 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 32, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 46224));
                        Object[] objArr2 = new Object[1];
                        a(objArr2);
                        this.analyzeResponse$1a4bb38 = cls.getDeclaredConstructor(Class.forName((String) objArr2[0]), String.class).newInstance(objArr);
                        try {
                            Object[] objArr3 = {this.analyzeResponse$1a4bb38, context};
                            Class cls2 = (Class) com.apiguard3.internal.AGState.values(KeyEvent.getDeadChar(0, 0) + 2695, 36 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 1754));
                            Object[] objArr4 = new Object[1];
                            a(objArr4);
                            this.parseResponseHeaders$4ad913bb = cls2.getDeclaredConstructor((Class) com.apiguard3.internal.AGState.values(2441 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), TextUtils.getOffsetAfter("", 0) + 32, (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 46225)), Class.forName((String) objArr4[0])).newInstance(objArr3);
                            try {
                                this.checkCertificates$384309d8 = ((Class) com.apiguard3.internal.AGState.values(4715 - View.getDefaultSize(0, 0), (ViewConfiguration.getTouchSlop() >> 8) + 39, (char) (25417 - View.getDefaultSize(0, 0)))).getDeclaredConstructor((Class) com.apiguard3.internal.AGState.values(ExpandableListView.getPackedPositionType(0L) + 2575, 37 - TextUtils.indexOf((CharSequence) "", '0'), (char) (ExpandableListView.getPackedPositionType(0L) + 59159)), (Class) com.apiguard3.internal.AGState.values(2441 - Color.green(0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 32, (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 46225))).newInstance(this.parseResponseHeaders$4ad913bb, this.analyzeResponse$1a4bb38);
                                this.updateKernel = new getSharedInstance(this.parseResponseHeaders$4ad913bb, this.analyzeResponse$1a4bb38, this.checkCertificates$384309d8);
                                try {
                                    try {
                                        ((Class) com.apiguard3.internal.AGState.values(5683 - Drawable.resolveOpacity(0, 0), KeyEvent.keyCodeFromString("") + 46, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("APIGuard", (Class) com.apiguard3.internal.AGState.values((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 2441, 32 - Gravity.getAbsoluteGravity(0, 0), (char) (46224 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).invoke(((Class) com.apiguard3.internal.AGState.values((ViewConfiguration.getLongPressTimeout() >> 16) + 5683, 45 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("getSharedInstance", null).invoke(null, null), this.analyzeResponse$1a4bb38);
                                        int i3 = UriFilter$UrlMatcherSpec.valueOf.valueOf;
                                        Object[] objArr5 = new Object[1];
                                        APIGuard(TextUtils.lastIndexOf("", '0', 0, 0) + 11, (byte) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 72), "'%.\f\u000f\u0017\u001a0\u000e\u001e", objArr5);
                                        String intern = ((String) objArr5[0]).intern();
                                        ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.getSharedInstance;
                                        Object[] objArr6 = new Object[1];
                                        APIGuard(12 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (byte) ((ViewConfiguration.getTapTimeout() >> 16) + 100), "'%.\f\u000f\u0017\r\u0018,\u0013㙒", objArr6);
                                        readResolve.valueOf(i3, intern, ((String) objArr6[0]).intern());
                                        try {
                                            ((Class) com.apiguard3.internal.AGState.values(2441 - (ViewConfiguration.getScrollBarSize() >> 8), TextUtils.indexOf("", "") + 32, (char) (TextUtils.lastIndexOf("", '0', 0) + 46226))).getMethod("APIGuard", InputStream.class, UriFilter$valueOf.class).invoke(this.analyzeResponse$1a4bb38, inputStream, new UriFilter$valueOf() { // from class: com.apiguard3.APIGuard.3
                                                private static int getRequestHeaders = 0;
                                                private static int parseResponseHeaders = 1;
                                                private static int valueOf = 85;
                                                public static final byte[] PlaceComponentResult = {122, TarHeader.LF_CONTIG, -29, -99, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
                                                public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 168;

                                                /* JADX WARN: Removed duplicated region for block: B:14:0x023e A[Catch: all -> 0x0464, TRY_LEAVE, TryCatch #2 {all -> 0x0464, blocks: (B:8:0x01de, B:12:0x0236, B:14:0x023e, B:56:0x0459), top: B:84:0x01de }] */
                                                /* JADX WARN: Removed duplicated region for block: B:55:0x044d  */
                                                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0459 -> B:57:0x045b). Please submit an issue!!! */
                                                @Override // com.apiguard3.internal.UriFilter$valueOf
                                                /*
                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                                                */
                                                public final void APIGuard() {
                                                    /*
                                                        Method dump skipped, instructions count: 1162
                                                        To view this dump change 'Code comments level' option to 'DEBUG'
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.APIGuard.AnonymousClass3.APIGuard():void");
                                                }

                                                @Override // com.apiguard3.internal.UriFilter$valueOf
                                                public final void values(String str) {
                                                    getRequestHeaders = (parseResponseHeaders + 97) % 128;
                                                    int i4 = UriFilter$UrlMatcherSpec.valueOf.AGState;
                                                    Object[] objArr7 = new Object[1];
                                                    valueOf(1 - TextUtils.lastIndexOf("", '0', 0, 0), true, "\u000b\uffdf\u0010\u0005\n￥\u0003\u0005\u0002\n", (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 9, 186 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), objArr7);
                                                    String intern2 = ((String) objArr7[0]).intern();
                                                    ConfigInstance.ConfigSerializationProxy.values valuesVar2 = ConfigInstance.ConfigSerializationProxy.values.getSharedInstance;
                                                    Object[] objArr8 = new Object[1];
                                                    valueOf((ViewConfiguration.getPressedStateDuration() >> 16) + 14, true, "\u0006￫ￅ\u0019\u000e\u0013￮ￅ\f\u000e\u000b\u0013\u0014￨\t\n\u0011\u000e", MotionEvent.axisFromString("") + 19, 176 - Color.argb(0, 0, 0, 0), objArr8);
                                                    readResolve.valueOf(i4, intern2, ((String) objArr8[0]).intern());
                                                    APIGuard.AGState(APIGuard.this, AGState.APIGuardStateFailed);
                                                    APIGuard.AGState(APIGuard.this, str);
                                                    readResolve.values(ConfigInstance.ConfigSerializationProxy.values.values, str);
                                                    int i5 = getRequestHeaders + 91;
                                                    parseResponseHeaders = i5 % 128;
                                                    if (i5 % 2 != 0) {
                                                        return;
                                                    }
                                                    throw new NullPointerException();
                                                }

                                                /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
                                                
                                                    r8 = r8;
                                                 */
                                                /*
                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                                                */
                                                private static void valueOf(int r6, boolean r7, java.lang.String r8, int r9, int r10, java.lang.Object[] r11) {
                                                    /*
                                                        if (r8 == 0) goto L6
                                                        char[] r8 = r8.toCharArray()
                                                    L6:
                                                        char[] r8 = (char[]) r8
                                                        java.lang.Object r0 = com.apiguard3.internal.setForegroundTintList.getSharedInstance
                                                        monitor-enter(r0)
                                                        char[] r1 = new char[r9]     // Catch: java.lang.Throwable -> L75
                                                        r2 = 0
                                                        com.apiguard3.internal.setForegroundTintList.APIGuard = r2     // Catch: java.lang.Throwable -> L75
                                                    L10:
                                                        int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                                                        if (r3 >= r9) goto L33
                                                        int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                                                        char r3 = r8[r3]     // Catch: java.lang.Throwable -> L75
                                                        com.apiguard3.internal.setForegroundTintList.values = r3     // Catch: java.lang.Throwable -> L75
                                                        int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                                                        int r4 = com.apiguard3.internal.setForegroundTintList.values     // Catch: java.lang.Throwable -> L75
                                                        int r4 = r4 + r10
                                                        char r4 = (char) r4     // Catch: java.lang.Throwable -> L75
                                                        r1[r3] = r4     // Catch: java.lang.Throwable -> L75
                                                        int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                                                        char r4 = r1[r3]     // Catch: java.lang.Throwable -> L75
                                                        int r5 = com.apiguard3.APIGuard.AnonymousClass3.valueOf     // Catch: java.lang.Throwable -> L75
                                                        int r4 = r4 - r5
                                                        char r4 = (char) r4     // Catch: java.lang.Throwable -> L75
                                                        r1[r3] = r4     // Catch: java.lang.Throwable -> L75
                                                        int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
                                                        int r3 = r3 + 1
                                                        com.apiguard3.internal.setForegroundTintList.APIGuard = r3     // Catch: java.lang.Throwable -> L75
                                                        goto L10
                                                    L33:
                                                        if (r6 <= 0) goto L4e
                                                        com.apiguard3.internal.setForegroundTintList.AGState = r6     // Catch: java.lang.Throwable -> L75
                                                        char[] r6 = new char[r9]     // Catch: java.lang.Throwable -> L75
                                                        java.lang.System.arraycopy(r1, r2, r6, r2, r9)     // Catch: java.lang.Throwable -> L75
                                                        int r8 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
                                                        int r8 = r9 - r8
                                                        int r10 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
                                                        java.lang.System.arraycopy(r6, r2, r1, r8, r10)     // Catch: java.lang.Throwable -> L75
                                                        int r8 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
                                                        int r10 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
                                                        int r10 = r9 - r10
                                                        java.lang.System.arraycopy(r6, r8, r1, r2, r10)     // Catch: java.lang.Throwable -> L75
                                                    L4e:
                                                        if (r7 == 0) goto L6c
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
                                                    throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.APIGuard.AnonymousClass3.valueOf(int, boolean, java.lang.String, int, int, java.lang.Object[]):void");
                                                }
                                            });
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
                                } catch (Throwable th3) {
                                    Throwable cause3 = th3.getCause();
                                    if (cause3 == null) {
                                        throw th3;
                                    }
                                    throw cause3;
                                }
                            } catch (Throwable th4) {
                                Throwable cause4 = th4.getCause();
                                if (cause4 == null) {
                                    throw th4;
                                }
                                throw cause4;
                            }
                        } catch (Throwable th5) {
                            Throwable cause5 = th5.getCause();
                            if (cause5 == null) {
                                throw th5;
                            }
                            throw cause5;
                        }
                    } catch (Throwable th6) {
                        Throwable cause6 = th6.getCause();
                        if (cause6 == null) {
                            throw th6;
                        }
                        throw cause6;
                    }
                } catch (Throwable th7) {
                    Throwable cause7 = th7.getCause();
                    if (cause7 == null) {
                        throw th7;
                    }
                    throw cause7;
                }
            } catch (Throwable th8) {
                Throwable cause8 = th8.getCause();
                if (cause8 == null) {
                    throw th8;
                }
                throw cause8;
            }
        } catch (Throwable th9) {
            Throwable cause9 = th9.getCause();
            if (cause9 == null) {
                throw th9;
            }
            throw cause9;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.apiguard3.APIGuard$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] APIGuard;
        private static int getSharedInstance = 1;
        private static int values;

        static {
            try {
                int[] iArr = new int[((Object[]) ((Class) com.apiguard3.internal.AGState.values(TextUtils.indexOf((CharSequence) "", '0', 0) + 1852, Color.rgb(0, 0, 0) + 16777257, (char) KeyEvent.getDeadChar(0, 0))).getMethod("values", null).invoke(null, null)).length];
                APIGuard = iArr;
                try {
                    iArr[((Enum) ((Class) com.apiguard3.internal.AGState.values(MotionEvent.axisFromString("") + 1852, 41 - (KeyEvent.getMaxKeyCode() >> 16), (char) Color.red(0))).getField("getSharedInstance").get(null)).ordinal()] = 1;
                    values = (getSharedInstance + 89) % 128;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    APIGuard[((Enum) ((Class) com.apiguard3.internal.AGState.values((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1851, View.resolveSize(0, 0) + 41, (char) (ViewConfiguration.getTapTimeout() >> 16))).getField("APIGuard").get(null)).ordinal()] = 2;
                    int i = getSharedInstance + 87;
                    values = i % 128;
                    if ((i % 2 != 0 ? (char) 6 : 'V') != 6) {
                        return;
                    }
                    throw new NullPointerException();
                } catch (NoSuchFieldError unused2) {
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    private static void APIGuard$3a2e006f(Config config, Object obj) {
        if (config == null || obj == null) {
            return;
        }
        try {
            Object invoke = ((Class) com.apiguard3.internal.AGState.values(TextUtils.indexOf((CharSequence) "", '0', 0) + 2576, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 38, (char) (((Process.getThreadPriority(0) + 20) >> 6) + 59159))).getMethod("AGState", null).invoke(obj, null);
            if (invoke == null) {
                return;
            }
            String onInitializationFailure2 = config.onInitializationFailure();
            try {
                if ((((Map) ((Class) com.apiguard3.internal.AGState.values(1572 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 28 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("AGState", null).invoke(invoke, null)).isEmpty() ? '\f' : (char) 16) == '\f') {
                    int i = APIGuard$InitializationCallback + 123;
                    BuildConfig = i % 128;
                    if (i % 2 != 0) {
                        try {
                            ((Map) ((Class) com.apiguard3.internal.AGState.values(1572 - (ViewConfiguration.getDoubleTapTimeout() >> 16), Color.red(0) + 28, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("valueOf", null).invoke(invoke, null)).isEmpty();
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
                        if (((Map) ((Class) com.apiguard3.internal.AGState.values(View.MeasureSpec.makeMeasureSpec(0, 0) + 1572, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 27, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("valueOf", null).invoke(invoke, null)).isEmpty()) {
                            try {
                                try {
                                    File file = (File) ((Class) com.apiguard3.internal.AGState.values(View.MeasureSpec.makeMeasureSpec(0, 0) + 2227, TextUtils.indexOf("", "", 0, 0) + 25, (char) View.MeasureSpec.getMode(0))).getMethod("APIGuard", null).invoke(((Class) com.apiguard3.internal.AGState.values(2227 - (ViewConfiguration.getScrollDefaultDelay() >> 16), KeyEvent.normalizeMetaState(0) + 25, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getDeclaredConstructor(null).newInstance(null), null);
                                    if (file.exists()) {
                                        try {
                                            try {
                                                if (((Boolean) ((Class) com.apiguard3.internal.AGState.values(6573 - View.resolveSizeAndState(0, 0, 0), 35 - TextUtils.getOffsetBefore("", 0), (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 1941))).getMethod("values", (Class) com.apiguard3.internal.AGState.values(1572 - (ViewConfiguration.getScrollBarSize() >> 8), (ViewConfiguration.getFadingEdgeLength() >> 16) + 28, (char) Color.red(0)), byte[].class, String.class).invoke(null, invoke, ((Class) com.apiguard3.internal.AGState.values(2203 - (ViewConfiguration.getEdgeSlop() >> 16), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 24, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("valueOf", File.class).invoke(null, file), onInitializationFailure2)).booleanValue()) {
                                                    ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.values;
                                                    writeReplace.APIGuard aPIGuard = writeReplace.APIGuard.registerForContextMenu;
                                                    Object[] objArr = new Object[1];
                                                    APIGuard(ImageFormat.getBitsPerPixel(0) + 24, (byte) (104 - TextUtils.indexOf((CharSequence) "", '0')), "\u0017\u000e-\f(.\n\u000b\u0019#\n\u0011\u000b).-%(\n\u000b\u0016\u000b㙗", objArr);
                                                    readResolve.getSharedInstance(valuesVar, aPIGuard, ((String) objArr[0]).intern());
                                                    return;
                                                }
                                                ConfigInstance.ConfigSerializationProxy.values valuesVar2 = ConfigInstance.ConfigSerializationProxy.values.values;
                                                writeReplace.APIGuard aPIGuard2 = writeReplace.APIGuard.registerForContextMenu;
                                                Object[] objArr2 = new Object[1];
                                                APIGuard(26 - TextUtils.getCapsMode("", 0, 0), (byte) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 59), "\u0017\u000e-\f(.\n\u000b\u0019#\n\u0011&(.-%(\n\u000b\u0004#\u0017\u0002\t\n", objArr2);
                                                readResolve.getSharedInstance(valuesVar2, aPIGuard2, ((String) objArr2[0]).intern());
                                                APIGuard$InitializationCallback = (BuildConfig + 45) % 128;
                                            } catch (Throwable th2) {
                                                Throwable cause2 = th2.getCause();
                                                if (cause2 == null) {
                                                    throw th2;
                                                }
                                                throw cause2;
                                            }
                                        } catch (Throwable th3) {
                                            Throwable cause3 = th3.getCause();
                                            if (cause3 == null) {
                                                throw th3;
                                            }
                                            throw cause3;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    Throwable cause4 = th4.getCause();
                                    if (cause4 == null) {
                                        throw th4;
                                    }
                                    throw cause4;
                                }
                            } catch (Throwable th5) {
                                Throwable cause5 = th5.getCause();
                                if (cause5 == null) {
                                    throw th5;
                                }
                                throw cause5;
                            }
                        }
                    } catch (Throwable th6) {
                        Throwable cause6 = th6.getCause();
                        if (cause6 == null) {
                            throw th6;
                        }
                        throw cause6;
                    }
                }
            } catch (Throwable th7) {
                Throwable cause7 = th7.getCause();
                if (cause7 == null) {
                    throw th7;
                }
                throw cause7;
            }
        } catch (Throwable th8) {
            Throwable cause8 = th8.getCause();
            if (cause8 == null) {
                throw th8;
            }
            throw cause8;
        }
    }

    private void getSharedInstance(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException(writeReplace.getSharedInstance.values.getSharedInstance());
        }
        if ((!(callback instanceof InitializationCallback)) == false) {
            APIGuard$InitializationCallback = (BuildConfig + 45) % 128;
            this.getState = (InitializationCallback) callback;
        }
        APIGuard$InitializationCallback = (BuildConfig + 11) % 128;
    }

    private void valueOf() {
        int i = BuildConfig + 59;
        APIGuard$InitializationCallback = i % 128;
        if (i % 2 == 0) {
            throw new NullPointerException();
        }
        if (this.getState != null) {
            values(new Callable<Void>() { // from class: com.apiguard3.APIGuard.2
                private static char AGState = 0;
                private static int APIGuard = 0;
                private static int analyzeResponse = 1;
                private static int valueOf = 0;
                private static long values = 695551653427299426L;

                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Void call() throws Exception {
                    APIGuard = (analyzeResponse + 87) % 128;
                    Void sharedInstance = getSharedInstance();
                    int i2 = analyzeResponse + 29;
                    APIGuard = i2 % 128;
                    if (i2 % 2 != 0) {
                        throw new ArithmeticException();
                    }
                    return sharedInstance;
                }

                private Void getSharedInstance() {
                    analyzeResponse = (APIGuard + 9) % 128;
                    ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.APIGuard;
                    Object[] objArr = new Object[1];
                    AGState((char) (59554 - KeyEvent.normalizeMetaState(0)), 1780327987 + (ViewConfiguration.getPressedStateDuration() >> 16), "䑢⥸ᢋধ", "烖ᭈ䈸ᔎ\u2009ꋲ숆\ue8e0㨫谲嗵驺\uda00躟\u1bf7붨腥ﮑ\uda44잗㐯螭ꩽ忸⣀夦뷸ꉚ곲⒜䟟", "㍜ᶦꉪ㗨", objArr);
                    readResolve.values(valuesVar, ((String) objArr[0]).intern());
                    APIGuard.parseResponseHeaders(APIGuard.this).onInitializationSuccess();
                    analyzeResponse = (APIGuard + 65) % 128;
                    return null;
                }

                /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
                
                    r12 = r12;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                private static void AGState(char r8, int r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.Object[] r13) {
                    /*
                        if (r12 == 0) goto L6
                        char[] r12 = r12.toCharArray()
                    L6:
                        char[] r12 = (char[]) r12
                        if (r11 == 0) goto Le
                        char[] r11 = r11.toCharArray()
                    Le:
                        char[] r11 = (char[]) r11
                        if (r10 == 0) goto L16
                        char[] r10 = r10.toCharArray()
                    L16:
                        char[] r10 = (char[]) r10
                        java.lang.Object r0 = com.apiguard3.internal.setForegroundGravity.AGState
                        monitor-enter(r0)
                        java.lang.Object r12 = r12.clone()     // Catch: java.lang.Throwable -> L94
                        char[] r12 = (char[]) r12     // Catch: java.lang.Throwable -> L94
                        java.lang.Object r10 = r10.clone()     // Catch: java.lang.Throwable -> L94
                        char[] r10 = (char[]) r10     // Catch: java.lang.Throwable -> L94
                        r1 = 0
                        char r2 = r12[r1]     // Catch: java.lang.Throwable -> L94
                        r8 = r8 ^ r2
                        char r8 = (char) r8     // Catch: java.lang.Throwable -> L94
                        r12[r1] = r8     // Catch: java.lang.Throwable -> L94
                        r8 = 2
                        char r2 = r10[r8]     // Catch: java.lang.Throwable -> L94
                        char r9 = (char) r9     // Catch: java.lang.Throwable -> L94
                        int r2 = r2 + r9
                        char r9 = (char) r2     // Catch: java.lang.Throwable -> L94
                        r10[r8] = r9     // Catch: java.lang.Throwable -> L94
                        int r9 = r11.length     // Catch: java.lang.Throwable -> L94
                        char[] r2 = new char[r9]     // Catch: java.lang.Throwable -> L94
                        com.apiguard3.internal.setForegroundGravity.valueOf = r1     // Catch: java.lang.Throwable -> L94
                    L3b:
                        int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                        if (r3 >= r9) goto L8b
                        int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                        int r3 = r3 + r8
                        int r3 = r3 % 4
                        int r4 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                        int r4 = r4 + 3
                        int r4 = r4 % 4
                        int r5 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                        int r5 = r5 % 4
                        char r5 = r12[r5]     // Catch: java.lang.Throwable -> L94
                        int r5 = r5 * 32718
                        char r6 = r10[r3]     // Catch: java.lang.Throwable -> L94
                        int r5 = r5 + r6
                        r6 = 65535(0xffff, float:9.1834E-41)
                        int r5 = r5 % r6
                        char r5 = (char) r5     // Catch: java.lang.Throwable -> L94
                        com.apiguard3.internal.setForegroundGravity.APIGuard = r5     // Catch: java.lang.Throwable -> L94
                        char r5 = r12[r4]     // Catch: java.lang.Throwable -> L94
                        int r5 = r5 * 32718
                        char r3 = r10[r3]     // Catch: java.lang.Throwable -> L94
                        int r5 = r5 + r3
                        int r5 = r5 / r6
                        char r3 = (char) r5     // Catch: java.lang.Throwable -> L94
                        r10[r4] = r3     // Catch: java.lang.Throwable -> L94
                        char r3 = com.apiguard3.internal.setForegroundGravity.APIGuard     // Catch: java.lang.Throwable -> L94
                        r12[r4] = r3     // Catch: java.lang.Throwable -> L94
                        int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                        int r5 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                        char r5 = r11[r5]     // Catch: java.lang.Throwable -> L94
                        char r4 = r12[r4]     // Catch: java.lang.Throwable -> L94
                        r4 = r4 ^ r5
                        long r4 = (long) r4     // Catch: java.lang.Throwable -> L94
                        long r6 = com.apiguard3.APIGuard.AnonymousClass2.values     // Catch: java.lang.Throwable -> L94
                        long r4 = r4 ^ r6
                        int r6 = com.apiguard3.APIGuard.AnonymousClass2.valueOf     // Catch: java.lang.Throwable -> L94
                        long r6 = (long) r6     // Catch: java.lang.Throwable -> L94
                        long r4 = r4 ^ r6
                        char r6 = com.apiguard3.APIGuard.AnonymousClass2.AGState     // Catch: java.lang.Throwable -> L94
                        long r6 = (long) r6     // Catch: java.lang.Throwable -> L94
                        long r4 = r4 ^ r6
                        int r5 = (int) r4     // Catch: java.lang.Throwable -> L94
                        char r4 = (char) r5     // Catch: java.lang.Throwable -> L94
                        r2[r3] = r4     // Catch: java.lang.Throwable -> L94
                        int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                        int r3 = r3 + 1
                        com.apiguard3.internal.setForegroundGravity.valueOf = r3     // Catch: java.lang.Throwable -> L94
                        goto L3b
                    L8b:
                        java.lang.String r8 = new java.lang.String     // Catch: java.lang.Throwable -> L94
                        r8.<init>(r2)     // Catch: java.lang.Throwable -> L94
                        monitor-exit(r0)     // Catch: java.lang.Throwable -> L94
                        r13[r1] = r8
                        return
                    L94:
                        r8 = move-exception
                        monitor-exit(r0)
                        goto L98
                    L97:
                        throw r8
                    L98:
                        goto L97
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.APIGuard.AnonymousClass2.AGState(char, int, java.lang.String, java.lang.String, java.lang.String, java.lang.Object[]):void");
                }
            });
        }
        int i2 = APIGuard$InitializationCallback + 37;
        BuildConfig = i2 % 128;
        if ((i2 % 2 != 0 ? '=' : 'Z') == 'Z') {
            return;
        }
        throw new NullPointerException();
    }

    private void APIGuard(final String str) {
        APIGuard$InitializationCallback = (BuildConfig + 23) % 128;
        if (this.getState != null) {
            values(new Callable<Void>() { // from class: com.apiguard3.APIGuard.4
                private static int getSharedInstance = 1;
                private static int values;

                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Void call() throws Exception {
                    values = (getSharedInstance + 105) % 128;
                    Void AGState = AGState();
                    int i = values + 37;
                    getSharedInstance = i % 128;
                    if (!(i % 2 == 0)) {
                        return AGState;
                    }
                    throw new NullPointerException();
                }

                private Void AGState() {
                    int i = values + 59;
                    getSharedInstance = i % 128;
                    if ((i % 2 == 0 ? '#' : 'R') != '#') {
                        APIGuard.parseResponseHeaders(APIGuard.this).onInitializationFailure(str);
                        return null;
                    }
                    APIGuard.parseResponseHeaders(APIGuard.this).onInitializationFailure(str);
                    throw new ArithmeticException();
                }
            });
        }
        int i = APIGuard$InitializationCallback + 57;
        BuildConfig = i % 128;
        if ((i % 2 != 0 ? (char) 29 : '^') == '^') {
            return;
        }
        throw null;
    }

    private void values(Callable<Void> callable) {
        APIGuard$InitializationCallback = (BuildConfig + 45) % 128;
        try {
            this.APIGuard$Callback.submit(callable);
            int i = APIGuard$InitializationCallback + 13;
            BuildConfig = i % 128;
            if ((i % 2 != 0 ? (char) 16 : 'E') == 'E') {
                return;
            }
            throw null;
        } catch (Throwable th) {
            readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.getSharedInstance, writeReplace.getSharedInstance.pushMaxPayload, th.toString());
        }
    }

    private static void valueOf(Callback callback) {
        int i = BuildConfig + 29;
        APIGuard$InitializationCallback = i % 128;
        if (i % 2 == 0) {
            dpi.AGState().values(callback);
            throw new ArithmeticException();
        } else {
            dpi.AGState().values(callback);
        }
    }

    private void AGState(Map<String, String> map) {
        try {
            try {
                try {
                    String str = (String) ((Class) com.apiguard3.internal.AGState.values(6573 - (ViewConfiguration.getJumpTapTimeout() >> 16), 35 - (Process.myTid() >> 22), (char) (1942 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("getSharedInstance", Map.class, String.class).invoke(null, map, ((Config) ((Class) com.apiguard3.internal.AGState.values(2440 - MotionEvent.axisFromString(""), 33 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 46224))).getMethod("AGState", null).invoke(this.analyzeResponse$1a4bb38, null)).pushMinPayload());
                    if (!TextUtils.isEmpty(str)) {
                        Object[] objArr = new Object[1];
                        values((char) View.MeasureSpec.getSize(0), 6 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), KeyEvent.getDeadChar(0, 0) + 75, objArr);
                        if ((!str.equals(((String) objArr[0]).intern()) ? '`' : '@') != '@') {
                            try {
                                if ((((Config) ((Class) com.apiguard3.internal.AGState.values(2441 - Drawable.resolveOpacity(0, 0), (ViewConfiguration.getJumpTapTimeout() >> 16) + 32, (char) (TextUtils.lastIndexOf("", '0', 0) + 46226))).getMethod("AGState", null).invoke(this.analyzeResponse$1a4bb38, null)).getRequestHeaders(str) ? (char) 28 : '[') != 28) {
                                    readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.valueOf, writeReplace.AGState.generateHeaders);
                                    return;
                                }
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        }
                        updateKernel();
                        BuildConfig = (APIGuard$InitializationCallback + 57) % 128;
                        return;
                    }
                    int i = APIGuard$InitializationCallback + 71;
                    BuildConfig = i % 128;
                    if (i % 2 == 0) {
                        readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.valueOf, writeReplace.AGState.getSharedInstance);
                    } else {
                        readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.valueOf, writeReplace.AGState.getSharedInstance);
                        throw new ArithmeticException();
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } catch (Throwable th4) {
            readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.pushMinPayload, th4.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r14 = r14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void APIGuard(int r12, byte r13, java.lang.String r14, java.lang.Object[] r15) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.APIGuard.APIGuard(int, byte, java.lang.String, java.lang.Object[]):void");
    }

    private static void values(char c, int i, int i2, Object[] objArr) {
        String str;
        synchronized (setBackgroundTintList.AGState) {
            char[] cArr = new char[i];
            setBackgroundTintList.getSharedInstance = 0;
            while (setBackgroundTintList.getSharedInstance < i) {
                cArr[setBackgroundTintList.getSharedInstance] = (char) ((onInitializationSuccess[setBackgroundTintList.getSharedInstance + i2] ^ (setBackgroundTintList.getSharedInstance * pushMinPayload)) ^ c);
                setBackgroundTintList.getSharedInstance++;
            }
            str = new String(cArr);
        }
        objArr[0] = str;
    }
}

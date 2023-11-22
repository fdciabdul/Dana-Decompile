package com.google.firebase.perf.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.perf.FirebasePerformanceInitializer;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import java.lang.reflect.Method;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public class FirebasePerfProvider extends ContentProvider {
    private static final Timer APP_START_TIME;
    private static byte[] BuiltInFictitiousFunctionClassFactory = null;
    static final String EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY = "com.google.firebase.firebaseperfprovider";
    private static int KClassImpl$Data$declaredNonStaticMembers$2;
    private static int MyBillsEntityDataFactory;
    private static int PlaceComponentResult;
    private static short[] getAuthRequestContext;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    static void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = 1257195685;
        KClassImpl$Data$declaredNonStaticMembers$2 = -972582182;
        BuiltInFictitiousFunctionClassFactory = new byte[]{-127, -113, -125, -43, -36, 99, 99, Ascii.SUB, -123, SignedBytes.MAX_POWER_OF_TWO, -53, -38, -37, -36, -113, -41, -116, -18, -109, -53, -69, -52, -55, -4, -45, -95, -28, -46, -44, -4, -38, -62, -34, -85, -36, 7, -51, -40, -68, 19, -60, -61, -54, -41, -1, -38, -34, -91, -40, -78, -35, -39, -96, -33, -93, -114, -16, -91, -84, -46, -93, -96, -79, Ascii.EM, TarHeader.LF_DIR, -29, Ascii.CAN, TarHeader.LF_FIFO, -6, Ascii.EM, TarHeader.LF_LINK, -52, -55, -27, Ascii.ETB, TarHeader.LF_LINK, -56, -57, -32, TarHeader.LF_NORMAL, -57, 6, -6, Ascii.CAN, 47, -7, Ascii.SUB, -27, TarHeader.LF_BLK, -55, TarHeader.LF_DIR, Ascii.GS, 47, TarHeader.LF_BLK, -51, 47, -55, -9, -55, TarHeader.LF_DIR, -54, Ascii.SUB, -55, -55, Ascii.US, 0, -52, TarHeader.LF_FIFO, -27, Ascii.CAN, 110, 13, TarHeader.LF_FIFO, 110, 126, 3, TarHeader.LF_NORMAL, 126, TarHeader.LF_NORMAL, 120, Byte.MAX_VALUE, TarHeader.LF_LINK, TarHeader.LF_CHR, TarHeader.LF_DIR, TarHeader.LF_LINK, 125, TarHeader.LF_CONTIG, 123, 101, 3, 109, 4, 122, TarHeader.LF_CHR, TarHeader.LF_SYMLINK, 108, TarHeader.LF_LINK, 10, TarHeader.LF_DIR, 97, TarHeader.LF_NORMAL, 0, TarHeader.LF_LINK, 111, 13, 98, 13, 102, 13, TarHeader.LF_SYMLINK, 124, TarHeader.LF_BLK, 108, 2, 106, 5, TarHeader.LF_LINK, Byte.MAX_VALUE, TarHeader.LF_SYMLINK, TarHeader.LF_LINK, 108, 14, 125, 103, 126, 13, 41, 70, 98, TarHeader.LF_CHR, 15, TarHeader.LF_NORMAL, 101, 98, -98, -89, -82, -7, 98, -8, -100, -89, -79, -9, -87, -100, -124, -53, 98, -99, -83, -10, 98, -101, -93, -120, -98, -100, -9, -47, -124, 96, -88, -119, -46, -118, -51, -98, -120, -9, -53, -121, 98, -52, -9, -82, -88, -82, -89, 98, -124, -97, -7, -100, -98, -11, -98, -98, 98, -100, -13, -8, -49, -7, -78, -9, 106, TarHeader.LF_CHR, 60, -102, 4, 35, 104, -87, -14, -82, TarHeader.LF_BLK, 59, 107, 108, TarHeader.LF_NORMAL, 47, 115, 108, 58, 39, 119, 107, 57, 32, 124, 102, 4, -103, TarHeader.LF_LINK, 107, 58, 103, 4, -103, 59, 44, -81, TarHeader.LF_BLK, 7, 107, -102, 6, 105, 102, 63, 97, -13, 120, 102, 56, 104, 32, TarHeader.LF_DIR, 96, 114, TarHeader.LF_FIFO, 105, TarHeader.LF_DIR, 57, -8, -67, -5, -65, -18, -97, -97, -97, -97, -97, -97, -97, -97, -97};
        PlaceComponentResult = 1907513008;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Object[] objArr = new Object[1];
        a(1914119708 - Color.rgb(0, 0, 0), (-40) - (ViewConfiguration.getScrollDefaultDelay() >> 16), (byte) (110 - (ViewConfiguration.getFadingEdgeLength() >> 16)), (short) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 80), (-995958319) - TextUtils.getOffsetAfter("", 0), objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a(1930896936 - Color.blue(0), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) - 53, (byte) (82 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), (short) (57 - (ViewConfiguration.getEdgeSlop() >> 16)), (-995958302) - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Object[] objArr3 = new Object[1];
            a((ViewConfiguration.getScrollDefaultDelay() >> 16) + 1930896924, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) - 31, (byte) (125 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), (short) (KeyEvent.getDeadChar(0, 0) + 43), (ViewConfiguration.getKeyRepeatDelay() >> 16) - 995958298, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(1930896926 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 41, (byte) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 126), (short) (View.combineMeasuredStates(0, 0) + 65), (-995958272) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), objArr4);
            Context context = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            if (context != null) {
                context = context.getApplicationContext();
            }
            if (context != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.green(0), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 35, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr5 = new Object[1];
                    a(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1930896883, (-10) - (ViewConfiguration.getLongPressTimeout() >> 16), (byte) (View.MeasureSpec.getSize(0) - 86), (short) ((-1) - TextUtils.getOffsetBefore("", 0)), TextUtils.getOffsetBefore("", 0) - 995958256, objArr5);
                    String str = (String) objArr5[0];
                    Object[] objArr6 = new Object[1];
                    a(1930896924 - (ViewConfiguration.getWindowTouchSlop() >> 8), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 5, (byte) (102 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), (short) ((-72) - View.getDefaultSize(0, 0)), (ViewConfiguration.getScrollBarFadeDuration() >> 16) - 995958209, objArr6);
                    String str2 = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(1930896877 - (Process.myPid() >> 22), (Process.myTid() >> 22) + 6, (byte) ((-52) - KeyEvent.normalizeMetaState(0)), (short) ((-54) - TextUtils.lastIndexOf("", '0', 0)), (-995958147) - Process.getGidForName(""), objArr7);
                    String str3 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(1930896931 - (ViewConfiguration.getScrollDefaultDelay() >> 16), View.MeasureSpec.makeMeasureSpec(0, 0) + 2, (byte) ((-38) - KeyEvent.getDeadChar(0, 0)), (short) (48 - View.MeasureSpec.makeMeasureSpec(0, 0)), AndroidCharacter.getMirror('0') - 7539, objArr8);
                    String str4 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(TextUtils.getOffsetBefore("", 0) + 1930896884, (-52) - (ViewConfiguration.getDoubleTapTimeout() >> 16), (byte) ((-37) - View.resolveSizeAndState(0, 0, 0)), (short) ((-67) - Color.argb(0, 0, 0, 0)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) - 995958024, objArr9);
                    try {
                        Object[] objArr10 = {context, str, str2, str3, str4, true, (String) objArr9[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0, 0), 18 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (Process.myTid() >> 22))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr10);
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
        }
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    static {
        MyBillsEntityDataFactory();
        APP_START_TIME = new Clock().getTime();
    }

    public static Timer getAppStartTime() {
        return APP_START_TIME;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        checkContentProviderAuthority(providerInfo);
        super.attachInfo(context, providerInfo);
        ConfigResolver.getInstance().setContentProviderContext(getContext());
        AppStateMonitor appStateMonitor = AppStateMonitor.getInstance();
        appStateMonitor.registerActivityLifecycleCallbacks(getContext());
        appStateMonitor.registerForAppColdStart(new FirebasePerformanceInitializer());
        AppStartTrace appStartTrace = AppStartTrace.getInstance();
        appStartTrace.registerActivityLifecycleCallbacks(getContext());
        this.mainHandler.post(new AppStartTrace.StartFromBackgroundRunnable(appStartTrace));
        SessionManager.getInstance().initializeGaugeCollection();
    }

    private static void checkContentProviderAuthority(ProviderInfo providerInfo) {
        Preconditions.checkNotNull(providerInfo, "FirebasePerfProvider ProviderInfo cannot be null.");
        if (EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY.equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
    }

    private static void a(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = BuiltInFictitiousFunctionClassFactory;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (BuiltInFictitiousFunctionClassFactory[i3 + ((int) (PlaceComponentResult ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (getAuthRequestContext[i3 + ((int) (PlaceComponentResult ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (PlaceComponentResult ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = BuiltInFictitiousFunctionClassFactory;
            if (bArr3 != null) {
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                for (int i7 = 0; i7 < length2; i7++) {
                    bArr4[i7] = (byte) (bArr3[i7] ^ 3097486228508854431L);
                }
                bArr3 = bArr4;
            }
            boolean z = bArr3 != null;
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                if (z) {
                    byte[] bArr5 = BuiltInFictitiousFunctionClassFactory;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = getAuthRequestContext;
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

package id.dana.onboarding.unsafe;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ResourceManagerInternal;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.plus.security.lite.SecLiteException;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.danah5.easteregg.QuickTap;
import id.dana.myprofile.EasterEggActivity;
import id.dana.onboarding.splash.LauncherActivity;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\u0004JA\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/onboarding/unsafe/UnsafeDeviceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "", "onBackPressed", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "", "p0", "p1", "p2", "p3", "p4", "Landroid/graphics/drawable/Drawable;", "p5", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danah5/easteregg/QuickTap;", "moveToNextValue", "Lid/dana/danah5/easteregg/QuickTap;", "PlaceComponentResult", "<init>", "Companion", "UnsafeStatus"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UnsafeDeviceActivity extends AppCompatActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static short[] DatabaseTableConfigUtil = null;
    public static final String EGG_MESSAGE = "egg_message";
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    public static final String UNSAFE_STATUS = "unsafe_status";
    private static int getErrorConfigVersion;
    private static int lookAheadTest;
    private static byte[] scheduleImpl;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Disposable KClassImpl$Data$declaredNonStaticMembers$2;
    public static final byte[] $$a = {Ascii.EM, 108, 7, 61, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 168;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {116, 44, -28, -115, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 76;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final QuickTap PlaceComponentResult = new QuickTap(2000, 5, new QuickTap.OnQuickTapListener() { // from class: id.dana.onboarding.unsafe.UnsafeDeviceActivity$$ExternalSyntheticLambda0
        @Override // id.dana.danah5.easteregg.QuickTap.OnQuickTapListener
        public final void onQuickTap() {
            UnsafeDeviceActivity.$r8$lambda$dDnXJCphIHS6OrslVpQmvbwdnbs(UnsafeDeviceActivity.this);
        }
    });

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        NetworkUserEntityData$$ExternalSyntheticLambda0 = 1257195695;
        lookAheadTest = -1354394659;
        scheduleImpl = new byte[]{-97, -111, -99, 107, 98, -67, -67, 36, -101, -34, 85, 100, 101, 98, -111, 105, -110, 100, -117, 67, -109, -100, 99, 108, -107, -117, 68, -102, -108, 108, -110, 106, -114, -67, -116, 33, -97, -112, -84, 85, 100, 101, 98, -111, 105, -110, 96, -103, 106, -116, 97, 101, 98, 99, -97, -80, 82, -103, -106, 108, -97, 98, -115, -80, -100, 78, -77, -99, 81, -80, -104, 103, 96, 76, -78, -104, 99, 98, 75, -101, 98, -83, 81, -77, -102, 80, -79, 76, -97, 96, -100, -76, -102, -97, 100, -102, 96, 82, 96, -100, 97, -79, 96, 96, 74, -85, 103, -99, 76, -77, 80, -77, -104, 80, 96, -83, -98, 96, -98, 102, 97, -97, -99, -101, -97, 99, -103, 101, 75, -83, 83, -86, 100, -99, -100, 82, -97, -76, -101, 79, -98, -82, -97, 81, -77, 76, -77, 72, -77, -100, 98, -102, 82, -84, 84, -85, -97, 97, -100, -97, 82, -80, 99, 73, 96, -77, -105, 104, 76, -99, -79, -98, 75, -101, -97, 80, -81, 98, -101, 97, -99, 80, -86, 96, 82, -99, -75, 76, -101, -98, -82, 103, -101, -100, 84, -79, -97, -99, 96, 74, -75, -103, 81, -78, 75, -77, 78, -97, -79, 96, 76, -80, -101, 77, 96, -81, 81, -81, 80, -101, -75, -104, 98, -99, -97, 102, -97, -97, -101, -99, 100, 97, 72, 98, -85, 96, 96, -103, -106, 112, -114, -87, 98, 35, -40, 36, -98, -111, 97, 102, -102, -91, 89, 102, -112, -83, 93, 97, -109, -86, 86, 108, -114, 115, -101, 97, -112, 109, -114, 115, -111, -90, 37, -98, -115, 97, 112, -116, 99, 108, -107, 107, -39, 82, 108, -110, 98, -86, -97, 106, 88, -100, 99, -97, -109, 96, -101, 101, -103, 106, -97, -97, -97, -97, -97, -97, -97, -97, -97};
        getErrorConfigVersion = -1170973003;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0021 -> B:23:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 16
            byte[] r0 = id.dana.onboarding.unsafe.UnsafeDeviceActivity.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = 56 - r8
            int r6 = r6 + 97
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r6 = r7
            r4 = r8
            r3 = 0
            goto L28
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L28:
            int r8 = r8 + 1
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + (-4)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.unsafe.UnsafeDeviceActivity.b(short, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            int r6 = r6 * 3
            int r6 = 42 - r6
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r0 = id.dana.onboarding.unsafe.UnsafeDeviceActivity.$$a
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L33
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L33:
            int r9 = r9 + r7
            int r7 = r8 + 1
            int r8 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.unsafe.UnsafeDeviceActivity.c(int, short, int, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final void show(Application application, UnsafeStatus unsafeStatus) {
        Companion.PlaceComponentResult(application, unsafeStatus);
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 441787678, (-30) - (KeyEvent.getMaxKeyCode() >> 16), (byte) TextUtils.getOffsetBefore("", 0), (short) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 254077397, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(441787692 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), TextUtils.lastIndexOf("", '0', 0, 0) - 42, (byte) (ViewConfiguration.getKeyRepeatTimeout() >> 16), (short) View.MeasureSpec.makeMeasureSpec(0, 0), ExpandableListView.getPackedPositionChild(0L) + 254077416, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getEdgeSlop() >> 16), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 35, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(441787636 - TextUtils.indexOf((CharSequence) "", '0', 0), TextUtils.getCapsMode("", 0, 0), (byte) Drawable.resolveOpacity(0, 0), (short) TextUtils.indexOf("", ""), 254077461 - TextUtils.getOffsetAfter("", 0), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 441787678, 16 - View.getDefaultSize(0, 0), (byte) TextUtils.indexOf("", ""), (short) ExpandableListView.getPackedPositionType(0L), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 254077508, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(441787632 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), ExpandableListView.getPackedPositionType(0L) + 16, (byte) ('0' - AndroidCharacter.getMirror('0')), (short) Color.green(0), TextUtils.getOffsetAfter("", 0) + 254077571, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(441787685 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 12 - View.MeasureSpec.getSize(0), (byte) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), (short) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 254077634, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(ExpandableListView.getPackedPositionGroup(0L) + 441787639, (-42) - Color.green(0), (byte) (Color.rgb(0, 0, 0) + 16777216), (short) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 254077694 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 910, 18 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
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
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                Object[] objArr13 = new Object[1];
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[31]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (PlaceComponentResult & 58);
                byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr14 = new Object[1];
                b(b, b2, (byte) (b2 | Ascii.RS), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getFadingEdgeLength() >> 16), 2 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) TextUtils.indexOf("", ""));
                        Object[] objArr16 = new Object[1];
                        c($$a[31], (byte) ($$a[78] - 1), $$a[12], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 800, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 16, (char) View.MeasureSpec.getMode(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ExpandableListView.getPackedPositionType(0L), ExpandableListView.getPackedPositionChild(0L) + 16, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 815, (ViewConfiguration.getWindowTouchSlop() >> 8) + 29, (char) (57994 - TextUtils.getOffsetAfter("", 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (ViewConfiguration.getTouchSlop() >> 8) + 15, (char) TextUtils.getCapsMode("", 0, 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r8 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 35 - View.MeasureSpec.getMode(0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1098352213, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, 18 - KeyEvent.getDeadChar(0, 0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr18);
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
        Context applicationContext3 = context != null ? context.getApplicationContext() : context;
        if (applicationContext3 != null) {
            try {
                Object[] objArr19 = new Object[1];
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[31]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = (byte) (PlaceComponentResult & 58);
                byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr20 = new Object[1];
                b(b3, b4, (byte) (b4 | Ascii.RS), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(60 - TextUtils.indexOf((CharSequence) "", '0'), 46 - Gravity.getAbsoluteGravity(0, 0), (char) Color.blue(0));
                        byte b5 = $$a[2];
                        Object[] objArr22 = new Object[1];
                        c(b5, (byte) (b5 | 16), (byte) ($$a[78] - 1), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-1098352213, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, 18 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr24);
                            } catch (Throwable th10) {
                                Throwable cause10 = th10.getCause();
                                if (cause10 == null) {
                                    throw th10;
                                }
                                throw cause10;
                            }
                        } catch (Throwable th11) {
                            Throwable cause11 = th11.getCause();
                            if (cause11 == null) {
                                throw th11;
                            }
                            throw cause11;
                        }
                    }
                } catch (Throwable th12) {
                    Throwable cause12 = th12.getCause();
                    if (cause12 == null) {
                        throw th12;
                    }
                    throw cause12;
                }
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        }
        Context applicationContext4 = context != null ? context.getApplicationContext() : context;
        if (applicationContext4 != null) {
            try {
                Object[] objArr25 = new Object[1];
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[31]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b6 = (byte) (PlaceComponentResult & 58);
                byte b7 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr26 = new Object[1];
                b(b6, b7, (byte) (b7 | Ascii.RS), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 118, View.resolveSize(0, 0) + 3, (char) (38969 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))));
                        byte b8 = $$a[2];
                        Object[] objArr28 = new Object[1];
                        c(b8, (byte) (b8 | 16), (byte) ($$a[78] - 1), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTouchSlop() >> 8), View.resolveSizeAndState(0, 0, 0) + 35, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1098352213, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 910, 18 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr30);
                            } catch (Throwable th14) {
                                Throwable cause14 = th14.getCause();
                                if (cause14 == null) {
                                    throw th14;
                                }
                                throw cause14;
                            }
                        } catch (Throwable th15) {
                            Throwable cause15 = th15.getCause();
                            if (cause15 == null) {
                                throw th15;
                            }
                            throw cause15;
                        }
                    }
                } catch (Throwable th16) {
                    Throwable cause16 = th16.getCause();
                    if (cause16 == null) {
                        throw th16;
                    }
                    throw cause16;
                }
            } catch (Throwable th17) {
                Throwable cause17 = th17.getCause();
                if (cause17 == null) {
                    throw th17;
                }
                throw cause17;
            }
        }
        Context applicationContext5 = context != null ? context.getApplicationContext() : context;
        if (applicationContext5 != null) {
            try {
                Object[] objArr31 = new Object[1];
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[31]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b9 = (byte) (PlaceComponentResult & 58);
                byte b10 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr32 = new Object[1];
                b(b9, b10, (byte) (b10 | Ascii.RS), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 107, 3 - ExpandableListView.getPackedPositionType(0L), (char) TextUtils.getOffsetBefore("", 0));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[53], $$a[9], objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.normalizeMetaState(0), ExpandableListView.getPackedPositionType(0L) + 35, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-1098352213, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, (-16777198) - Color.rgb(0, 0, 0), (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr36);
                            } catch (Throwable th18) {
                                Throwable cause18 = th18.getCause();
                                if (cause18 == null) {
                                    throw th18;
                                }
                                throw cause18;
                            }
                        } catch (Throwable th19) {
                            Throwable cause19 = th19.getCause();
                            if (cause19 == null) {
                                throw th19;
                            }
                            throw cause19;
                        }
                    }
                } catch (Throwable th20) {
                    Throwable cause20 = th20.getCause();
                    if (cause20 == null) {
                        throw th20;
                    }
                    throw cause20;
                }
            } catch (Throwable th21) {
                Throwable cause21 = th21.getCause();
                if (cause21 == null) {
                    throw th21;
                }
                throw cause21;
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Class<?> cls;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.input_card_expired_date_placeholder).substring(12, 13).codePointAt(0) + 441787647, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 23, (byte) (getPackageName().codePointAt(5) - 110), (short) (super.getResources().getString(R.string.feed_comment_fetch_subcomment_error_message).substring(59, 61).codePointAt(1) - 32), super.getResources().getString(R.string.dana_plus_card_title).substring(0, 12).codePointAt(9) + 254077311, objArr);
            Class<?> cls2 = Class.forName((String) objArr[0]);
            int pressedStateDuration = 441787681 - (ViewConfiguration.getPressedStateDuration() >> 16);
            int length = super.getResources().getString(R.string.merchant_address_label).substring(0, 1).length() - 31;
            try {
                Object[] objArr2 = new Object[1];
                b(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), objArr2);
                cls = Class.forName((String) objArr2[0]);
                b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[8], KClassImpl$Data$declaredNonStaticMembers$2[25], new Object[1]);
            } catch (Throwable th) {
                th = th;
            }
            try {
                Object[] objArr3 = new Object[1];
                a(pressedStateDuration, length, (byte) (((ApplicationInfo) cls.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 33), (short) (super.getResources().getString(R.string.mybills_edit_period_label).substring(0, 6).length() - 6), super.getResources().getString(R.string.feed_onboarding_second_page_title).substring(10, 13).codePointAt(1) + 254077346, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
            } catch (Throwable th2) {
                th = th2;
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + PDF417Common.NUMBER_OF_CODEWORDS, KeyEvent.normalizeMetaState(0) + 35, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 912, (ViewConfiguration.getScrollBarSize() >> 8) + 18, (char) ((-1) - Process.getGidForName("")))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
                } catch (Throwable th3) {
                    Throwable cause2 = th3.getCause();
                    if (cause2 == null) {
                        throw th3;
                    }
                    throw cause2;
                }
            } catch (Throwable th4) {
                Throwable cause3 = th4.getCause();
                if (cause3 == null) {
                    throw th4;
                }
                throw cause3;
            }
        }
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int length = super.getResources().getString(R.string.missed_call_otp_resend_success).substring(1, 2).length() + 441787678;
            try {
                Object[] objArr = new Object[1];
                b(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[8], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr2);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 55;
                byte offsetBefore = (byte) TextUtils.getOffsetBefore("", 0);
                short length2 = (short) (super.getResources().getString(R.string.unstable_internet_network_description).substring(0, 1).length() - 1);
                try {
                    Object[] objArr3 = new Object[1];
                    b(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[8], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr4);
                    Object[] objArr5 = new Object[1];
                    a(length, i, offsetBefore, length2, ((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 254077386, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    try {
                        Object[] objArr6 = new Object[1];
                        b(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[8], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr7);
                        int i2 = ((ApplicationInfo) cls4.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + 441787648;
                        try {
                            Object[] objArr8 = new Object[1];
                            b(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            Object[] objArr9 = new Object[1];
                            b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[8], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr9);
                            int i3 = ((ApplicationInfo) cls5.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion - 63;
                            try {
                                Object[] objArr10 = new Object[1];
                                b(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), objArr10);
                                Class<?> cls6 = Class.forName((String) objArr10[0]);
                                b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[8], KClassImpl$Data$declaredNonStaticMembers$2[25], new Object[1]);
                                Object[] objArr11 = new Object[1];
                                a(i2, i3, (byte) (((ApplicationInfo) cls6.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33), (short) (super.getResources().getString(R.string.paylater_tnc_onboarding).substring(39, 40).codePointAt(0) - 32), super.getResources().getString(R.string.my_bills_label_top_up).substring(0, 6).length() + 254077438, objArr11);
                                baseContext = (Context) cls3.getMethod((String) objArr11[0], new Class[0]).invoke(null, null);
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
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0, 0), 35 - (KeyEvent.getMaxKeyCode() >> 16), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr12 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, 18 - Gravity.getAbsoluteGravity(0, 0), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr12);
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
        }
        super.onResume();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        Drawable BuiltInFictitiousFunctionClassFactory;
        Drawable BuiltInFictitiousFunctionClassFactory2;
        Object[] objArr2;
        Object[] objArr3 = new Object[1];
        a(441787679 - TextUtils.indexOf("", "", 0), super.getResources().getString(R.string.twilio_bottomsheet_description).substring(17, 18).length() - 31, (byte) (super.getResources().getString(R.string.complete_yesterday).substring(1, 2).length() - 1), (short) ((Process.getThreadPriority(0) + 20) >> 6), 254077398 + (Process.myTid() >> 22), objArr3);
        Class<?> cls = Class.forName((String) objArr3[0]);
        int length = super.getResources().getString(R.string.history).substring(9, 10).length() + 441787690;
        int axisFromString = (-44) - MotionEvent.axisFromString("");
        byte gidForName = (byte) (Process.getGidForName("") + 1);
        short length2 = (short) (getPackageName().length() - 7);
        try {
            Object[] objArr4 = new Object[1];
            b(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[8], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr5);
            int i = ((ApplicationInfo) cls2.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 254077382;
            Object[] objArr6 = new Object[1];
            a(length, axisFromString, gidForName, length2, i, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    int codePointAt = super.getResources().getString(R.string.emas_subtitle).substring(5, 11).codePointAt(1) + 441787606;
                    int indexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0) - 21;
                    byte length3 = (byte) (super.getResources().getString(R.string.my_payment_card).substring(1, 2).length() - 1);
                    short codePointAt2 = (short) (super.getResources().getString(R.string.exchange_rate_dialog_title).substring(5, 6).codePointAt(0) + SecLiteException.ERROR_API_KEY_OR_SIGN);
                    try {
                        Object[] objArr7 = new Object[1];
                        b(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), objArr7);
                        Class<?> cls3 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[8], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr8);
                        int i2 = ((ApplicationInfo) cls3.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 254077386;
                        Object[] objArr9 = new Object[1];
                        a(codePointAt, indexOf, length3, codePointAt2, i2, objArr9);
                        Class<?> cls4 = Class.forName((String) objArr9[0]);
                        try {
                            Object[] objArr10 = new Object[1];
                            b(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), objArr10);
                            Class<?> cls5 = Class.forName((String) objArr10[0]);
                            Object[] objArr11 = new Object[1];
                            b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[8], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr11);
                            Object[] objArr12 = new Object[1];
                            a(((ApplicationInfo) cls5.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 441787648, TextUtils.getOffsetAfter("", 0) - 30, (byte) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1), (short) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), getPackageName().length() + 254077437, objArr12);
                            baseContext = (Context) cls4.getMethod((String) objArr12[0], new Class[0]).invoke(null, null);
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
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 35, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        int rgb = 425010421 - Color.rgb(0, 0, 0);
                        int normalizeMetaState = KeyEvent.normalizeMetaState(0);
                        byte length4 = (byte) (super.getResources().getString(R.string.buy_text).substring(0, 1).length() - 1);
                        short maxKeyCode = (short) (KeyEvent.getMaxKeyCode() >> 16);
                        try {
                            Object[] objArr13 = new Object[1];
                            b(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), objArr13);
                            Class<?> cls6 = Class.forName((String) objArr13[0]);
                            Object[] objArr14 = new Object[1];
                            b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[8], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr14);
                            int i3 = ((ApplicationInfo) cls6.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion + 254077428;
                            Object[] objArr15 = new Object[1];
                            a(rgb, normalizeMetaState, length4, maxKeyCode, i3, objArr15);
                            String str = (String) objArr15[0];
                            try {
                                Object[] objArr16 = new Object[1];
                                b(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), objArr16);
                                Class<?> cls7 = Class.forName((String) objArr16[0]);
                                Object[] objArr17 = new Object[1];
                                b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[8], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr17);
                                Object[] objArr18 = new Object[1];
                                a(((ApplicationInfo) cls7.getMethod((String) objArr17[0], null).invoke(this, null)).targetSdkVersion + 441787646, getPackageName().length() + 9, (byte) TextUtils.getOffsetAfter("", 0), (short) (super.getResources().getString(R.string.mybills_detail_label_total_payment_period).substring(0, 7).codePointAt(2) - 116), getPackageName().codePointAt(4) + 254077411, objArr18);
                                String str2 = (String) objArr18[0];
                                int length5 = super.getResources().getString(R.string.empty_state_insurance_desc).substring(7, 12).length() + 441787627;
                                try {
                                    Object[] objArr19 = new Object[1];
                                    b(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), objArr19);
                                    Class<?> cls8 = Class.forName((String) objArr19[0]);
                                    Object[] objArr20 = new Object[1];
                                    b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[8], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr20);
                                    int i4 = ((ApplicationInfo) cls8.getMethod((String) objArr20[0], null).invoke(this, null)).targetSdkVersion - 17;
                                    try {
                                        Object[] objArr21 = new Object[1];
                                        b(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), objArr21);
                                        Class<?> cls9 = Class.forName((String) objArr21[0]);
                                        b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[8], KClassImpl$Data$declaredNonStaticMembers$2[25], new Object[1]);
                                        byte b = (byte) (((ApplicationInfo) cls9.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33);
                                        short length6 = (short) (getPackageName().length() - 7);
                                        try {
                                            Object[] objArr22 = new Object[1];
                                            b(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), objArr22);
                                            Class<?> cls10 = Class.forName((String) objArr22[0]);
                                            Object[] objArr23 = new Object[1];
                                            b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[8], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr23);
                                            int i5 = ((ApplicationInfo) cls10.getMethod((String) objArr23[0], null).invoke(this, null)).targetSdkVersion + 254077538;
                                            Object[] objArr24 = new Object[1];
                                            a(length5, i4, b, length6, i5, objArr24);
                                            String str3 = (String) objArr24[0];
                                            Object[] objArr25 = new Object[1];
                                            a(441787685 - TextUtils.indexOf((CharSequence) "", '0'), 13 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (byte) (super.getResources().getString(R.string.tooltip_highlight_description_request_money).substring(8, 9).codePointAt(0) - 97), (short) (super.getResources().getString(R.string.my_bills_all_paid_subtitle).substring(14, 15).codePointAt(0) - 97), 254077633 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), objArr25);
                                            String str4 = (String) objArr25[0];
                                            int codePointAt3 = getPackageName().codePointAt(4) + 441787542;
                                            int length7 = super.getResources().getString(R.string.card_detail_empty_desc).substring(21, 22).length() - 43;
                                            byte length8 = (byte) (super.getResources().getString(R.string.goal_title_hint).substring(5, 6).length() - 1);
                                            try {
                                                Object[] objArr26 = new Object[1];
                                                b(KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), objArr26);
                                                Class<?> cls11 = Class.forName((String) objArr26[0]);
                                                b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[8], KClassImpl$Data$declaredNonStaticMembers$2[25], new Object[1]);
                                                Object[] objArr27 = new Object[1];
                                                a(codePointAt3, length7, length8, (short) (((ApplicationInfo) cls11.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 33), super.getResources().getString(R.string.reset_pin_input_new_pin_error_sequential_pin).substring(11, 12).codePointAt(0) + 254077661, objArr27);
                                                try {
                                                    Object[] objArr28 = {baseContext, str, str2, str3, str4, true, (String) objArr27[0], 995651014};
                                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                    if (obj2 == null) {
                                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), ExpandableListView.getPackedPositionGroup(0L) + 18, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                    }
                                                    ((Method) obj2).invoke(invoke, objArr28);
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
                    } catch (Throwable th10) {
                        Throwable cause10 = th10.getCause();
                        if (cause10 == null) {
                            throw th10;
                        }
                        throw cause10;
                    }
                }
            }
            try {
                Object[] objArr29 = new Object[1];
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[31]), objArr29);
                Class<?> cls12 = Class.forName((String) objArr29[0]);
                byte b2 = (byte) (PlaceComponentResult & 58);
                byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr30 = new Object[1];
                b(b2, b3, (byte) (b3 | Ascii.RS), objArr30);
                try {
                    Object[] objArr31 = {Integer.valueOf(((Integer) cls12.getMethod((String) objArr30[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls13 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getEdgeSlop() >> 16), View.resolveSizeAndState(0, 0, 0) + 4, (char) ('0' - AndroidCharacter.getMirror('0')));
                        Object[] objArr32 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[53], $$a[9], objArr32);
                        obj3 = cls13.getMethod((String) objArr32[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr33 = (Object[]) ((Method) obj3).invoke(null, objArr31);
                    int i6 = ((int[]) objArr33[1])[0];
                    if (((int[]) objArr33[0])[0] != i6) {
                        long j = ((r2 ^ i6) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 35 - View.combineMeasuredStates(0, 0), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr34 = {-1769545600, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 911, 18 - Color.alpha(0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr34);
                                objArr = objArr2;
                            } catch (Throwable th11) {
                                Throwable cause11 = th11.getCause();
                                if (cause11 == null) {
                                    throw th11;
                                }
                                throw cause11;
                            }
                        } catch (Throwable th12) {
                            Throwable cause12 = th12.getCause();
                            if (cause12 == null) {
                                throw th12;
                            }
                            throw cause12;
                        }
                    } else {
                        objArr = null;
                    }
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_unsafe_device);
                    Bundle extras = getIntent().getExtras();
                    Object[] objArr35 = objArr;
                    if (extras != null) {
                        objArr35 = extras.getString(UNSAFE_STATUS);
                    }
                    if (Intrinsics.areEqual(objArr35, UnsafeStatus.ROOTED.invoke())) {
                        String string = getString(R.string.unsafe_device_rooted_title);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        String string2 = getString(R.string.unsafe_device_rooted_description);
                        Intrinsics.checkNotNullExpressionValue(string2, "");
                        String string3 = getString(R.string.unsafe_device_rooted_image_title);
                        Intrinsics.checkNotNullExpressionValue(string3, "");
                        String string4 = getString(R.string.unsafe_device_rooted_image_description);
                        Intrinsics.checkNotNullExpressionValue(string4, "");
                        String string5 = getString(R.string.unsafe_device_rooted_footer);
                        Intrinsics.checkNotNullExpressionValue(string5, "");
                        BuiltInFictitiousFunctionClassFactory2 = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(this, R.drawable.ic_rooted_device);
                        getAuthRequestContext(string, string2, string3, string4, string5, BuiltInFictitiousFunctionClassFactory2);
                    } else {
                        String string6 = getString(R.string.unsafe_device_tamper_title);
                        Intrinsics.checkNotNullExpressionValue(string6, "");
                        String string7 = getString(R.string.unsafe_device_tamper_description);
                        Intrinsics.checkNotNullExpressionValue(string7, "");
                        String string8 = getString(R.string.unsafe_device_tamper_image_title);
                        Intrinsics.checkNotNullExpressionValue(string8, "");
                        String string9 = getString(R.string.unsafe_device_tamper_image_description);
                        Intrinsics.checkNotNullExpressionValue(string9, "");
                        String string10 = getString(R.string.unsafe_device_tamper_footer);
                        Intrinsics.checkNotNullExpressionValue(string10, "");
                        BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(this, R.drawable.ic_tampered_device);
                        getAuthRequestContext(string6, string7, string8, string9, string10, BuiltInFictitiousFunctionClassFactory);
                    }
                    ScrollView scrollView = (ScrollView) _$_findCachedViewById(R.id.CreateOrderTopUpFamilyBalance_res_0x7f0a03ed);
                    if (scrollView != null) {
                        scrollView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.unsafe.UnsafeDeviceActivity$$ExternalSyntheticLambda1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                UnsafeDeviceActivity.m2768$r8$lambda$4n2Y5U2_CDMqKyFa7IA8cN30zI(UnsafeDeviceActivity.this, view);
                            }
                        });
                    }
                    ImageView imageView = (ImageView) _$_findCachedViewById(R.id.ivUnsafeDeviceImage);
                    if (imageView != null) {
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.unsafe.UnsafeDeviceActivity$$ExternalSyntheticLambda2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                UnsafeDeviceActivity.$r8$lambda$3qKF2kkBCcsgV_BL2vAdy4QoZD4(UnsafeDeviceActivity.this, view);
                            }
                        });
                    }
                    Completable BuiltInFictitiousFunctionClassFactory3 = Completable.BuiltInFictitiousFunctionClassFactory(5L, TimeUnit.SECONDS);
                    Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
                    ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "scheduler is null");
                    Completable KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(BuiltInFictitiousFunctionClassFactory3, MyBillsEntityDataFactory));
                    Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
                    ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
                    RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$22, PlaceComponentResult2)).getAuthRequestContext(new CompletableObserver() { // from class: id.dana.onboarding.unsafe.UnsafeDeviceActivity$onCreate$1
                        @Override // io.reactivex.CompletableObserver
                        public final void onSubscribe(Disposable p0) {
                            Intrinsics.checkNotNullParameter(p0, "");
                            UnsafeDeviceActivity.this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
                        }

                        @Override // io.reactivex.CompletableObserver
                        public final void onComplete() {
                            UnsafeDeviceActivity.this.finishAffinity();
                        }

                        @Override // io.reactivex.CompletableObserver
                        public final void onError(Throwable p0) {
                            Intrinsics.checkNotNullParameter(p0, "");
                            UnsafeDeviceActivity.this.finishAffinity();
                        }
                    });
                } catch (Throwable th13) {
                    Throwable cause13 = th13.getCause();
                    if (cause13 == null) {
                        throw th13;
                    }
                    throw cause13;
                }
            } catch (Throwable th14) {
                Throwable cause14 = th14.getCause();
                if (cause14 == null) {
                    throw th14;
                }
                throw cause14;
            }
        } catch (Throwable th15) {
            Throwable cause15 = th15.getCause();
            if (cause15 == null) {
                throw th15;
            }
            throw cause15;
        }
    }

    private final void getAuthRequestContext(String p0, String p1, String p2, String p3, String p4, Drawable p5) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.NullabilityAnnotationStates);
        if (textView != null) {
            textView.setText(p0);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvUnsafeDeviceDescription);
        if (textView2 != null) {
            textView2.setText(p1);
        }
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.tvUnsafeDeviceImageTitle);
        if (textView3 != null) {
            textView3.setText(p2);
        }
        TextView textView4 = (TextView) _$_findCachedViewById(R.id.tvUnsafeDeviceImageDescription);
        if (textView4 != null) {
            textView4.setText(p3);
        }
        TextView textView5 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a15d8_r8_lambda_0ephpghfbd4otod9a9_myz9rrhy);
        if (textView5 != null) {
            textView5.setText(p4);
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.ivUnsafeDeviceImage);
        if (imageView != null) {
            imageView.setImageDrawable(p5);
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        finishAffinity();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000b"}, d2 = {"Lid/dana/onboarding/unsafe/UnsafeDeviceActivity$Companion;", "", "Landroid/app/Application;", "p0", "Lid/dana/onboarding/unsafe/UnsafeDeviceActivity$UnsafeStatus;", "p1", "", "PlaceComponentResult", "(Landroid/app/Application;Lid/dana/onboarding/unsafe/UnsafeDeviceActivity$UnsafeStatus;)V", "", "EGG_MESSAGE", "Ljava/lang/String;", "UNSAFE_STATUS", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void PlaceComponentResult(Application p0, UnsafeStatus p1) {
            Intrinsics.checkNotNullParameter(p1, "");
            if (p0 != null) {
                Intent putExtra = new Intent(p0, UnsafeDeviceActivity.class).addFlags(268468224).putExtra(UnsafeDeviceActivity.UNSAFE_STATUS, p1.getStatus());
                Intrinsics.checkNotNullExpressionValue(putExtra, "");
                p0.startActivity(putExtra);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r"}, d2 = {"Lid/dana/onboarding/unsafe/UnsafeDeviceActivity$UnsafeStatus;", "", "", BridgeDSL.INVOKE, "()Ljava/lang/String;", "status", "Ljava/lang/String;", "getStatus", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ROOTED", "TAMPERED", "EMULATOR", "HOOKED"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public enum UnsafeStatus {
        ROOTED("Rooted"),
        TAMPERED("Tampered"),
        EMULATOR("Emulator"),
        HOOKED("Hooked");

        private final String status;

        UnsafeStatus(String str) {
            this.status = str;
        }

        @JvmName(name = "getStatus")
        public final String getStatus() {
            return this.status;
        }

        public final String invoke() {
            return this.status;
        }
    }

    public static /* synthetic */ void $r8$lambda$3qKF2kkBCcsgV_BL2vAdy4QoZD4(UnsafeDeviceActivity unsafeDeviceActivity, View view) {
        Intrinsics.checkNotNullParameter(unsafeDeviceActivity, "");
        unsafeDeviceActivity.PlaceComponentResult.process();
    }

    /* renamed from: $r8$lambda$4n2Y5U2_CDMqKy-Fa7IA8cN30zI */
    public static /* synthetic */ void m2768$r8$lambda$4n2Y5U2_CDMqKyFa7IA8cN30zI(UnsafeDeviceActivity unsafeDeviceActivity, View view) {
        Intrinsics.checkNotNullParameter(unsafeDeviceActivity, "");
        unsafeDeviceActivity.finishAffinity();
    }

    public static /* synthetic */ void $r8$lambda$dDnXJCphIHS6OrslVpQmvbwdnbs(UnsafeDeviceActivity unsafeDeviceActivity) {
        Intrinsics.checkNotNullParameter(unsafeDeviceActivity, "");
        try {
            Intent intent = new Intent(unsafeDeviceActivity, EasterEggActivity.class);
            Bundle extras = unsafeDeviceActivity.getIntent().getExtras();
            intent.putExtra("egg_message", extras != null ? extras.getString("egg_message") : null);
            unsafeDeviceActivity.startActivity(intent);
        } catch (Exception e) {
        }
    }

    private static void a(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = scheduleImpl;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (scheduleImpl[i3 + ((int) (getErrorConfigVersion ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (DatabaseTableConfigUtil[i3 + ((int) (getErrorConfigVersion ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (getErrorConfigVersion ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (lookAheadTest ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = scheduleImpl;
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
                    byte[] bArr5 = scheduleImpl;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = DatabaseTableConfigUtil;
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

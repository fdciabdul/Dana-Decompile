package id.dana.geofence;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.core.app.DANAJobIntentService;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGeofenceComponent;
import id.dana.di.modules.GeofenceModule;
import id.dana.domain.DefaultObserver;
import id.dana.geofence.GeofenceContract;
import id.dana.geofence.model.PoiModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.rum.Rum;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/geofence/GeoFenceTransitionsJobIntentService;", "Landroidx/core/app/DANAJobIntentService;", "", "onCreate", "()V", "Landroid/content/Intent;", "intent", "onHandleWork", "(Landroid/content/Intent;)V", "Lid/dana/geofence/GeoFencePresenter;", "geoFencePresenter", "Lid/dana/geofence/GeoFencePresenter;", "getGeoFencePresenter", "()Lid/dana/geofence/GeoFencePresenter;", "setGeoFencePresenter", "(Lid/dana/geofence/GeoFencePresenter;)V", "Lid/dana/geofence/GeofenceManager;", "geofenceManager", "Lid/dana/geofence/GeofenceManager;", "getGeofenceManager", "()Lid/dana/geofence/GeofenceManager;", "setGeofenceManager", "(Lid/dana/geofence/GeofenceManager;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GeoFenceTransitionsJobIntentService extends DANAJobIntentService {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int getAuthRequestContext;
    @Inject
    public GeoFencePresenter geoFencePresenter;
    @Inject
    public GeofenceManager geofenceManager;
    public static final byte[] $$a = {Ascii.DC4, -68, -64, 70, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 132;
    public static final byte[] MyBillsEntityDataFactory = {120, 42, -65, -64, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int BuiltInFictitiousFunctionClassFactory = 114;

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        getAuthRequestContext = 269894829;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r7 = r7 * 4
            int r7 = 16 - r7
            byte[] r0 = id.dana.geofence.GeoFenceTransitionsJobIntentService.MyBillsEntityDataFactory
            int r8 = 106 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L34
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            int r6 = r6 + 1
            r1[r3] = r4
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.geofence.GeoFenceTransitionsJobIntentService.a(byte, short, short, java.lang.Object[]):void");
    }

    private static void b(short s, short s2, byte b, Object[] objArr) {
        int i = 103 - (s * 2);
        int i2 = 42 - (b * 3);
        int i3 = 46 - s2;
        byte[] bArr = $$a;
        byte[] bArr2 = new byte[i2];
        int i4 = -1;
        int i5 = i2 - 1;
        if (bArr == null) {
            i = (i + i5) - 7;
            i5 = i5;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
        }
        while (true) {
            i3++;
            int i6 = i4 + 1;
            bArr2[i6] = (byte) i;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            Object[] objArr2 = objArr;
            int i7 = i5;
            byte[] bArr3 = bArr2;
            byte[] bArr4 = bArr;
            i = (i + bArr[i3]) - 7;
            i5 = i7;
            objArr = objArr2;
            bArr = bArr4;
            bArr2 = bArr3;
            i4 = i6;
        }
    }

    @Override // androidx.core.app.DANAJobIntentService, android.app.Service, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        c(false, (ViewConfiguration.getScrollBarSize() >> 8) + 235, 16 - TextUtils.lastIndexOf("", '0'), (ViewConfiguration.getPressedStateDuration() >> 16) + 18, new char[]{11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65517, 15, '\f', 0, 2, 16, 16, 65534}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        c(false, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 240, 3 - TextUtils.indexOf("", ""), TextUtils.lastIndexOf("", '0', 0, 0) + 6, new char[]{65517, 1, 65532, 5, 17}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 35 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    c(true, 206 - Process.getGidForName(""), 43 - (ViewConfiguration.getPressedStateDuration() >> 16), TextUtils.getOffsetAfter("", 0) + 48, new char[]{65517, 31, 65520, 65513, 65521, 65522, 31, 65522, 65515, 65519, 65522, 30, JSONLexer.EOI, 29, 65515, 29, 65521, 65516, 29, 65519, 28, 28, 29, JSONLexer.EOI, 65519, 65514, 65514, 65519, 65514, 65515, 30, 31, 28, 30, 65520, 65521, 65522, 29, 65513, 65521, 65519, 28, 65520, 30, 65519, 65516, 27, 65519}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    c(true, 203 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 65 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 64, new char[]{65521, Typography.quote, 65526, 65519, InputCardNumberView.DIVIDER, '!', 65519, 65518, 65519, 65518, 65525, 65527, 65527, 65525, 65521, 65521, 65525, 65519, 65525, '!', 65519, '#', 65518, 65523, 65521, 65518, '!', '!', 65526, 65522, Typography.quote, '!', 65520, 65520, Typography.quote, 65526, '#', 65527, InputCardNumberView.DIVIDER, 65524, 65521, 65524, 65519, Typography.quote, 65519, Typography.dollar, 65520, 65520, 65522, 65519, 65519, Typography.quote, 65523, 65527, '!', Typography.quote, 65526, 65518, 65527, Typography.dollar, Typography.quote, 65524, 65523, 31}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    c(false, 204 - (ViewConfiguration.getTouchSlop() >> 8), 21 - TextUtils.lastIndexOf("", '0'), 63 - ImageFormat.getBitsPerPixel(0), new char[]{65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    c(false, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 233, 9 - (KeyEvent.getMaxKeyCode() >> 16), 60 - TextUtils.indexOf("", "", 0, 0), new char[]{21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0, 65485, 19, 7, 17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    c(false, View.MeasureSpec.getMode(0) + 186, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1, (-16777210) - Color.rgb(0, 0, 0), new char[]{65535, 7, 65532, 2, 65532, 0}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778127, KeyEvent.keyCodeFromString("") + 18, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (MyBillsEntityDataFactory[8] + 1);
                byte b2 = (byte) (MyBillsEntityDataFactory[5] - 1);
                Object[] objArr13 = new Object[1];
                a(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = (byte) (-MyBillsEntityDataFactory[5]);
                Object[] objArr14 = new Object[1];
                a(b3, (byte) (b3 + 1), MyBillsEntityDataFactory[5], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 56, 4 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        Object[] objArr16 = new Object[1];
                        b($$a[12], $$a[53], $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, Drawable.resolveOpacity(0, 0) + 15, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 800, TextUtils.indexOf("", "", 0) + 15, (char) ((-1) - Process.getGidForName("")))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getJumpTapTimeout() >> 16), 29 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (57994 - (Process.myTid() >> 22)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 800, 15 - View.getDefaultSize(0, 0), (char) ((-16777216) - Color.rgb(0, 0, 0))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r7 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), ImageFormat.getBitsPerPixel(0) + 36, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1728432738, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = (byte) (MyBillsEntityDataFactory[8] + 1);
                byte b5 = (byte) (MyBillsEntityDataFactory[5] - 1);
                Object[] objArr19 = new Object[1];
                a(b4, b5, b5, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b6 = (byte) (-MyBillsEntityDataFactory[5]);
                Object[] objArr20 = new Object[1];
                a(b6, (byte) (b6 + 1), MyBillsEntityDataFactory[5], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 45 - MotionEvent.axisFromString(""), (char) ExpandableListView.getPackedPositionGroup(0L));
                        Object[] objArr22 = new Object[1];
                        b((byte) ($$a[78] - 1), $$a[0], $$a[8], objArr22);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 930, 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {1728432738, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, 18 - Color.blue(0), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = (byte) (MyBillsEntityDataFactory[8] + 1);
                byte b8 = (byte) (MyBillsEntityDataFactory[5] - 1);
                Object[] objArr25 = new Object[1];
                a(b7, b8, b8, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b9 = (byte) (-MyBillsEntityDataFactory[5]);
                Object[] objArr26 = new Object[1];
                a(b9, (byte) (b9 + 1), MyBillsEntityDataFactory[5], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 118, Color.rgb(0, 0, 0) + 16777219, (char) (38968 - ExpandableListView.getPackedPositionType(0L)));
                        Object[] objArr28 = new Object[1];
                        b((byte) ($$a[78] - 1), $$a[0], $$a[8], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), 35 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1728432738, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 911, 18 - (Process.myTid() >> 22), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b10 = (byte) (MyBillsEntityDataFactory[8] + 1);
                byte b11 = (byte) (MyBillsEntityDataFactory[5] - 1);
                Object[] objArr31 = new Object[1];
                a(b10, b11, b11, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b12 = (byte) (-MyBillsEntityDataFactory[5]);
                Object[] objArr32 = new Object[1];
                a(b12, (byte) (b12 + 1), MyBillsEntityDataFactory[5], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - TextUtils.getOffsetBefore("", 0), 3 - TextUtils.getCapsMode("", 0, 0), (char) View.resolveSize(0, 0));
                        byte b13 = $$a[9];
                        byte b14 = (byte) ($$a[78] - 1);
                        Object[] objArr34 = new Object[1];
                        b(b13, b14, b14, objArr34);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), 35 - TextUtils.indexOf("", "", 0), (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {1728432738, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 911, TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // androidx.core.app.DANAJobIntentService, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // androidx.core.app.DANAJobIntentService, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // androidx.core.app.DANAJobIntentService, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @JvmName(name = "getGeoFencePresenter")
    public final GeoFencePresenter getGeoFencePresenter() {
        GeoFencePresenter geoFencePresenter = this.geoFencePresenter;
        if (geoFencePresenter != null) {
            return geoFencePresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGeoFencePresenter")
    public final void setGeoFencePresenter(GeoFencePresenter geoFencePresenter) {
        Intrinsics.checkNotNullParameter(geoFencePresenter, "");
        this.geoFencePresenter = geoFencePresenter;
    }

    @JvmName(name = "getGeofenceManager")
    public final GeofenceManager getGeofenceManager() {
        GeofenceManager geofenceManager = this.geofenceManager;
        if (geofenceManager != null) {
            return geofenceManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGeofenceManager")
    public final void setGeofenceManager(GeofenceManager geofenceManager) {
        Intrinsics.checkNotNullParameter(geofenceManager, "");
        this.geofenceManager = geofenceManager;
    }

    @Override // androidx.core.app.DANAJobIntentService, android.app.Service
    public final void onCreate() {
        try {
            byte b = 0;
            byte b2 = (byte) (MyBillsEntityDataFactory[8] + 1);
            byte b3 = (byte) (MyBillsEntityDataFactory[5] - 1);
            Object[] objArr = new Object[1];
            a(b2, b3, b3, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b4 = (byte) (-MyBillsEntityDataFactory[5]);
            Object[] objArr2 = new Object[1];
            a(b4, (byte) (b4 + 1), MyBillsEntityDataFactory[5], objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), View.resolveSize(0, 0) + 4, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                    byte b5 = $$a[9];
                    byte b6 = (byte) ($$a[78] - 1);
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, b6, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.lastIndexOf("", '0', 0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {632067967, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, TextUtils.lastIndexOf("", '0', 0) + 19, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
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
                super.onCreate();
                Rum.Companion companion = Rum.getAuthRequestContext;
                Rum.Companion.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult("GeoFenceTransitionsJobIntentService.onCreate");
                DaggerGeofenceComponent.Builder MyBillsEntityDataFactory2 = DaggerGeofenceComponent.MyBillsEntityDataFactory();
                Application application = getApplication();
                if (application == null) {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
                }
                MyBillsEntityDataFactory2.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
                MyBillsEntityDataFactory2.MyBillsEntityDataFactory = (GeofenceModule) Preconditions.getAuthRequestContext(new GeofenceModule(new GeofenceContract.View() { // from class: id.dana.geofence.GeoFenceTransitionsJobIntentService$initComponent$geoFenceComponent$1
                    @Override // id.dana.geofence.GeofenceContract.View
                    public final void MyBillsEntityDataFactory(List<PoiModel> p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                    }

                    @Override // id.dana.base.AbstractContract.AbstractView
                    public final void dismissProgress() {
                    }

                    @Override // id.dana.base.AbstractContract.AbstractView
                    public final void onError(String p0) {
                    }

                    @Override // id.dana.base.AbstractContract.AbstractView
                    public final void showProgress() {
                    }
                }));
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.MyBillsEntityDataFactory, GeofenceModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.getAuthRequestContext, ApplicationComponent.class);
                new DaggerGeofenceComponent.GeofenceComponentImpl(MyBillsEntityDataFactory2.MyBillsEntityDataFactory, MyBillsEntityDataFactory2.getAuthRequestContext, b).MyBillsEntityDataFactory(this);
                Rum.Companion companion2 = Rum.getAuthRequestContext;
                Rum.Companion.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory("GeoFenceTransitionsJobIntentService.onCreate");
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
    }

    @Override // androidx.core.app.DANAJobIntentService
    public final void onHandleWork(Intent intent) {
        List<Geofence> triggeringGeofences;
        Intrinsics.checkNotNullParameter(intent, "");
        Rum.Companion companion = Rum.getAuthRequestContext;
        Rum.Companion.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult("GeoFenceTransitionsJobIntentService.onHandleWork");
        GeofencingEvent fromIntent = GeofencingEvent.fromIntent(intent);
        if (fromIntent == null || fromIntent.hasError()) {
            Rum.Companion companion2 = Rum.getAuthRequestContext;
            Rum.Companion.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory("GeoFenceTransitionsJobIntentService.onHandleWork");
            return;
        }
        if (fromIntent.getGeofenceTransition() == 4 && (triggeringGeofences = fromIntent.getTriggeringGeofences()) != null) {
            final GeoFencePresenter geoFencePresenter = getGeoFencePresenter();
            List<Geofence> list = triggeringGeofences;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String requestId = ((Geofence) it.next()).getRequestId();
                Intrinsics.checkNotNullExpressionValue(requestId, "");
                arrayList.add(requestId);
            }
            ArrayList arrayList2 = arrayList;
            Intrinsics.checkNotNullParameter(arrayList2, "");
            geoFencePresenter.BuiltInFictitiousFunctionClassFactory.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.geofence.GeoFencePresenter$notifyPoi$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    Lazy lazy;
                    Boolean bool = (Boolean) obj;
                    lazy = GeoFencePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    GeofenceContract.View view = (GeofenceContract.View) lazy.get();
                }
            }, arrayList2);
        }
        Rum.Companion companion3 = Rum.getAuthRequestContext;
        Rum.Companion.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory("GeoFenceTransitionsJobIntentService.onHandleWork");
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/geofence/GeoFenceTransitionsJobIntentService$Companion;", "", "Landroid/content/Context;", "p0", "Landroid/content/Intent;", "p1", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;Landroid/content/Intent;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void MyBillsEntityDataFactory(Context p0, Intent p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            DANAJobIntentService.Companion companion = DANAJobIntentService.INSTANCE;
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(GeoFenceTransitionsJobIntentService.class, "");
            Intrinsics.checkNotNullParameter(p1, "");
            ComponentName componentName = new ComponentName(p0, GeoFenceTransitionsJobIntentService.class);
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(componentName, "");
            Intrinsics.checkNotNullParameter(p1, "");
            (Build.VERSION.SDK_INT >= 26 ? new DANAJobIntentService.EnqueueCompatNew() : new DANAJobIntentService.EnqueueCompatOld()).PlaceComponentResult(p0, componentName, 573, p1);
        }
    }

    private static void c(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i3];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i3) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (getAuthRequestContext ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i2 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i2;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i3 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            char[] cArr4 = new char[i3];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i3) {
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i3 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}

package id.dana.ipg.tncagreement;

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
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.R;
import id.dana.base.BaseWebViewActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.UrlUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0004"}, d2 = {"Lid/dana/ipg/tncagreement/IpgTermsAndConditionActivity;", "Lid/dana/base/BaseWebViewActivity;", "", "configToolbar", "()V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "onAgreeClicked", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IpgTermsAndConditionActivity extends BaseWebViewActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String IPG_TNC_ACTION_RESULT = "IPG_TNC_ACTION_RESULT";
    public static final String IPG_TNC_URL_EXTRA_KEY = "ipg_tnc_url_extra_key";
    private static int lookAheadTest;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public static final byte[] $$g = {86, TarHeader.LF_NORMAL, -68, 79, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$h = 56;
    public static final byte[] getErrorConfigVersion = {103, 121, -60, -41, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int scheduleImpl = 192;

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        lookAheadTest = 269894724;
    }

    private static void h(short s, int i, short s2, Object[] objArr) {
        int i2 = i + 16;
        int i3 = 106 - s;
        byte[] bArr = getErrorConfigVersion;
        int i4 = 55 - s2;
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            i3 = (i6 + i3) - 4;
            i6 = i6;
            i4 = i4;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            int i8 = i4 + 1;
            bArr2[i7] = (byte) i3;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i9 = i6;
            i3 = (i3 + bArr[i8]) - 4;
            i6 = i9;
            i4 = i8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
        }
    }

    private static void j(byte b, byte b2, int i, Object[] objArr) {
        int i2 = (b2 * 3) + 21;
        int i3 = 103 - (b * 2);
        byte[] bArr = $$g;
        int i4 = i + 4;
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            int i7 = (i4 + i6) - 7;
            i4 = i4;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i6 = i6;
            i3 = i7;
        }
        while (true) {
            int i8 = i5 + 1;
            bArr2[i8] = (byte) i3;
            if (i8 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i9 = i4 + 1;
            byte b3 = bArr[i9];
            int i10 = i3;
            int i11 = i6;
            int i12 = (i10 + b3) - 7;
            i4 = i9;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i8;
            i6 = i11;
            i3 = i12;
        }
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

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        g(false, new char[]{16, 16, 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65517, 15, '\f', 0, 2}, 18 - KeyEvent.keyCodeFromString(""), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 2, KeyEvent.getDeadChar(0, 0) + 196, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        g(true, new char[]{17, 5, 65532, 1, 65517}, 5 - TextUtils.indexOf("", "", 0), 1 - ((byte) KeyEvent.getModifierMetaStateMask()), 200 - TextUtils.indexOf((CharSequence) "", '0', 0), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getWindowTouchSlop() >> 8), 'S' - AndroidCharacter.getMirror('0'), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    g(true, new char[]{30, 65519, 65516, 27, 65519, 65517, 31, 65520, 65513, 65521, 65522, 31, 65522, 65515, 65519, 65522, 30, JSONLexer.EOI, 29, 65515, 29, 65521, 65516, 29, 65519, 28, 28, 29, JSONLexer.EOI, 65519, 65514, 65514, 65519, 65514, 65515, 30, 31, 28, 30, 65520, 65521, 65522, 29, 65513, 65521, 65519, 28, 65520}, 49 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 48 - Color.alpha(0), 167 - ExpandableListView.getPackedPositionChild(0L), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g(false, new char[]{65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524}, 65 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 42, View.resolveSize(0, 0) + 163, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g(true, new char[]{65525, Typography.quote, 65523, 65519, 29, 30, 65518, InputCardNumberView.DIVIDER, 65520, '!', 29, 65523, 65516, 65519, 65517, 65517, 65524, 65524, 65524, 65520, 65518, 65523, 65525, 30, '!', 65517, 65518, 65525, 65521, 65521, Typography.quote, 65522, 65525, 65521, 65523, 65521, Typography.quote, 65517, 65518, '!', 31, 65525, Typography.quote, 30, 29, 65516, 65524, 65520, 65517, Typography.quote, 65524, 65524, 65522, 65523, 30, 65524, 65518, InputCardNumberView.DIVIDER, 65523, 31, 65523, Typography.quote, Typography.quote, 65524}, 63 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 27 - TextUtils.indexOf("", "", 0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 165, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g(false, new char[]{65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0, 65485, 19, 7, 17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489}, 61 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getTouchSlop() >> 8) + 7, Color.alpha(0) + 194, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    g(false, new char[]{2, 65532, 0, 65535, 7, 65532}, 6 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 3 - TextUtils.lastIndexOf("", '0', 0, 0), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 146, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 911, 18 - Color.argb(0, 0, 0, 0), (char) (Process.myTid() >> 22))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = getErrorConfigVersion[25];
                Object[] objArr13 = new Object[1];
                h(b, b, getErrorConfigVersion[31], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = getErrorConfigVersion[7];
                byte b3 = getErrorConfigVersion[25];
                Object[] objArr14 = new Object[1];
                h(b2, b3, (byte) (b3 | Ascii.RS), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 55, 3 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) View.combineMeasuredStates(0, 0));
                        Object[] objArr16 = new Object[1];
                        j($$g[12], $$g[78], $$g[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.indexOf("", "", 0, 0), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 14, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 16 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(863 - AndroidCharacter.getMirror('0'), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 29, (char) (57994 - TextUtils.getOffsetBefore("", 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 800, TextUtils.getOffsetAfter("", 0) + 15, (char) (ViewConfiguration.getTouchSlop() >> 8)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r6 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 35, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1510758616, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, TextUtils.lastIndexOf("", '0', 0) + 19, (char) (Process.getGidForName("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = getErrorConfigVersion[25];
                Object[] objArr19 = new Object[1];
                h(b4, b4, getErrorConfigVersion[31], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b5 = getErrorConfigVersion[7];
                byte b6 = getErrorConfigVersion[25];
                Object[] objArr20 = new Object[1];
                h(b5, b6, (byte) (b6 | Ascii.RS), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 61, 46 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L));
                        byte b7 = (byte) ($$g[78] - 1);
                        Object[] objArr22 = new Object[1];
                        j(b7, b7, $$g[28], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getMode(0), 35 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {1510758616, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, 18 - (Process.myPid() >> 22), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b8 = getErrorConfigVersion[25];
                Object[] objArr25 = new Object[1];
                h(b8, b8, getErrorConfigVersion[31], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b9 = getErrorConfigVersion[7];
                byte b10 = getErrorConfigVersion[25];
                Object[] objArr26 = new Object[1];
                h(b9, b10, (byte) (b10 | Ascii.RS), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 118, Gravity.getAbsoluteGravity(0, 0) + 3, (char) (38968 - ExpandableListView.getPackedPositionGroup(0L)));
                        byte b11 = (byte) ($$g[78] - 1);
                        Object[] objArr28 = new Object[1];
                        j(b11, b11, $$g[28], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.getDefaultSize(0, 0), 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1510758616, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, 17 - ExpandableListView.getPackedPositionChild(0L), (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b12 = getErrorConfigVersion[25];
                Object[] objArr31 = new Object[1];
                h(b12, b12, getErrorConfigVersion[31], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b13 = getErrorConfigVersion[7];
                byte b14 = getErrorConfigVersion[25];
                Object[] objArr32 = new Object[1];
                h(b13, b14, (byte) (b14 | Ascii.RS), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - View.getDefaultSize(0, 0), 3 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))));
                        Object[] objArr34 = new Object[1];
                        j($$g[9], $$g[8], (byte) (-$$g[40]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 930, 36 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {1510758616, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), Color.green(0) + 18, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_tnc_ipg_agreement;
    }

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        g(false, new char[]{16, 16, 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65517, 15, '\f', 0, 2}, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, getPackageName().codePointAt(0) - 103, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 196, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        char[] cArr = {17, 5, 65532, 1, 65517};
        try {
            Object[] objArr3 = new Object[1];
            h(getErrorConfigVersion[32], (byte) (-getErrorConfigVersion[30]), (byte) (getErrorConfigVersion[59] + 1), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            h(getErrorConfigVersion[13], getErrorConfigVersion[56], getErrorConfigVersion[25], objArr4);
            int i = ((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion - 28;
            try {
                Object[] objArr5 = new Object[1];
                h(getErrorConfigVersion[32], (byte) (-getErrorConfigVersion[30]), (byte) (getErrorConfigVersion[59] + 1), objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                h(getErrorConfigVersion[13], getErrorConfigVersion[56], getErrorConfigVersion[25], new Object[1]);
                Object[] objArr6 = new Object[1];
                g(true, cArr, i, ((ApplicationInfo) cls3.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 31, 202 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), objArr6);
                int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr7 = new Object[1];
                        g(true, new char[]{'\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6}, super.getResources().getString(R.string.mybills_edit_bill_penalty_fee_label).substring(1, 3).codePointAt(1) - 84, (ViewConfiguration.getLongPressTimeout() >> 16) + 5, super.getResources().getString(R.string.popup_winner_message).substring(0, 5).codePointAt(0) + 107, objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        char[] cArr2 = {65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529};
                        int codePointAt = super.getResources().getString(R.string.warning_add_on_not_supported).substring(27, 28).codePointAt(0) - 14;
                        int length = getPackageName().length() + 5;
                        try {
                            Object[] objArr8 = new Object[1];
                            h(getErrorConfigVersion[32], (byte) (-getErrorConfigVersion[30]), (byte) (getErrorConfigVersion[59] + 1), objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            Object[] objArr9 = new Object[1];
                            h(getErrorConfigVersion[13], getErrorConfigVersion[56], getErrorConfigVersion[25], objArr9);
                            Object[] objArr10 = new Object[1];
                            g(true, cArr2, codePointAt, length, ((ApplicationInfo) cls5.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 170, objArr10);
                            baseContext = (Context) cls4.getMethod((String) objArr10[0], new Class[0]).invoke(null, null);
                        } catch (Throwable th) {
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
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), 34 - TextUtils.lastIndexOf("", '0'), (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            char[] cArr3 = {30, 65519, 65516, 27, 65519, 65517, 31, 65520, 65513, 65521, 65522, 31, 65522, 65515, 65519, 65522, 30, JSONLexer.EOI, 29, 65515, 29, 65521, 65516, 29, 65519, 28, 28, 29, JSONLexer.EOI, 65519, 65514, 65514, 65519, 65514, 65515, 30, 31, 28, 30, 65520, 65521, 65522, 29, 65513, 65521, 65519, 28, 65520};
                            int scrollBarSize = 48 - (ViewConfiguration.getScrollBarSize() >> 8);
                            try {
                                Object[] objArr11 = new Object[1];
                                h(getErrorConfigVersion[32], (byte) (-getErrorConfigVersion[30]), (byte) (getErrorConfigVersion[59] + 1), objArr11);
                                Class<?> cls6 = Class.forName((String) objArr11[0]);
                                Object[] objArr12 = new Object[1];
                                h(getErrorConfigVersion[13], getErrorConfigVersion[56], getErrorConfigVersion[25], objArr12);
                                int i2 = ((ApplicationInfo) cls6.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 15;
                                try {
                                    Object[] objArr13 = new Object[1];
                                    h(getErrorConfigVersion[32], (byte) (-getErrorConfigVersion[30]), (byte) (getErrorConfigVersion[59] + 1), objArr13);
                                    Class<?> cls7 = Class.forName((String) objArr13[0]);
                                    Object[] objArr14 = new Object[1];
                                    h(getErrorConfigVersion[13], getErrorConfigVersion[56], getErrorConfigVersion[25], objArr14);
                                    Object[] objArr15 = new Object[1];
                                    g(true, cArr3, scrollBarSize, i2, ((ApplicationInfo) cls7.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion + 135, objArr15);
                                    String str = (String) objArr15[0];
                                    Object[] objArr16 = new Object[1];
                                    g(false, new char[]{65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524}, super.getResources().getString(R.string.pocket_voucher_amount_transaction).substring(0, 11).length() + 53, super.getResources().getString(R.string.input_card_expired_date_placeholder).substring(12, 13).codePointAt(0) + 9, getPackageName().length() + 156, objArr16);
                                    String str2 = (String) objArr16[0];
                                    Object[] objArr17 = new Object[1];
                                    g(true, new char[]{65525, Typography.quote, 65523, 65519, 29, 30, 65518, InputCardNumberView.DIVIDER, 65520, '!', 29, 65523, 65516, 65519, 65517, 65517, 65524, 65524, 65524, 65520, 65518, 65523, 65525, 30, '!', 65517, 65518, 65525, 65521, 65521, Typography.quote, 65522, 65525, 65521, 65523, 65521, Typography.quote, 65517, 65518, '!', 31, 65525, Typography.quote, 30, 29, 65516, 65524, 65520, 65517, Typography.quote, 65524, 65524, 65522, 65523, 30, 65524, 65518, InputCardNumberView.DIVIDER, 65523, 31, 65523, Typography.quote, Typography.quote, 65524}, super.getResources().getString(R.string.tap_here_to_top_up_and_see_your_balance).substring(0, 4).length() + 60, super.getResources().getString(R.string.link_not_found_toolbar_title).substring(0, 5).codePointAt(4) - 5, super.getResources().getString(R.string.otp_sent_to_your_bank_number).substring(1, 5).codePointAt(1) + 65, objArr17);
                                    String str3 = (String) objArr17[0];
                                    Object[] objArr18 = new Object[1];
                                    g(false, new char[]{65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0, 65485, 19, 7, 17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489}, getPackageName().codePointAt(3) - 40, super.getResources().getString(R.string.label_openhours).substring(0, 10).length() - 3, 193 - ImageFormat.getBitsPerPixel(0), objArr18);
                                    String str4 = (String) objArr18[0];
                                    char[] cArr4 = {2, 65532, 0, 65535, 7, 65532};
                                    try {
                                        Object[] objArr19 = new Object[1];
                                        h(getErrorConfigVersion[32], (byte) (-getErrorConfigVersion[30]), (byte) (getErrorConfigVersion[59] + 1), objArr19);
                                        Class<?> cls8 = Class.forName((String) objArr19[0]);
                                        Object[] objArr20 = new Object[1];
                                        h(getErrorConfigVersion[13], getErrorConfigVersion[56], getErrorConfigVersion[25], objArr20);
                                        int i3 = ((ApplicationInfo) cls8.getMethod((String) objArr20[0], null).invoke(this, null)).targetSdkVersion - 27;
                                        int length2 = super.getResources().getString(R.string.loading_info_text_preprocessing).substring(1, 2).length() + 3;
                                        try {
                                            Object[] objArr21 = new Object[1];
                                            h(getErrorConfigVersion[32], (byte) (-getErrorConfigVersion[30]), (byte) (getErrorConfigVersion[59] + 1), objArr21);
                                            Class<?> cls9 = Class.forName((String) objArr21[0]);
                                            Object[] objArr22 = new Object[1];
                                            h(getErrorConfigVersion[13], getErrorConfigVersion[56], getErrorConfigVersion[25], objArr22);
                                            Object[] objArr23 = new Object[1];
                                            g(false, cArr4, i3, length2, ((ApplicationInfo) cls9.getMethod((String) objArr22[0], null).invoke(this, null)).targetSdkVersion + 114, objArr23);
                                            try {
                                                Object[] objArr24 = {baseContext, str, str2, str3, str4, true, (String) objArr23[0], 995651014};
                                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                if (obj2 == null) {
                                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTapTimeout() >> 16), (ViewConfiguration.getPressedStateDuration() >> 16) + 18, (char) (MotionEvent.axisFromString("") + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                }
                                                ((Method) obj2).invoke(invoke, objArr24);
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
                    }
                }
                try {
                    byte b = getErrorConfigVersion[25];
                    Object[] objArr25 = new Object[1];
                    h(b, b, getErrorConfigVersion[31], objArr25);
                    Class<?> cls10 = Class.forName((String) objArr25[0]);
                    byte b2 = getErrorConfigVersion[7];
                    byte b3 = getErrorConfigVersion[25];
                    Object[] objArr26 = new Object[1];
                    h(b2, b3, (byte) (b3 | Ascii.RS), objArr26);
                    try {
                        Object[] objArr27 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls11 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 494, 5 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) KeyEvent.keyCodeFromString(""));
                            Object[] objArr28 = new Object[1];
                            j($$g[9], $$g[8], (byte) (-$$g[40]), objArr28);
                            obj3 = cls11.getMethod((String) objArr28[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr29 = (Object[]) ((Method) obj3).invoke(null, objArr27);
                        int i4 = ((int[]) objArr29[1])[0];
                        if (((int[]) objArr29[0])[0] != i4) {
                            long j = ((r0 ^ i4) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr30 = {137727769, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 863, (ViewConfiguration.getEdgeSlop() >> 16) + 18, (char) View.resolveSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr30);
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
                        super.onCreate(bundle);
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

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(true, new char[]{'\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6}, getPackageName().length() + 19, getPackageName().codePointAt(3) - 95, getPackageName().codePointAt(1) + 96, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(true, new char[]{65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529}, super.getResources().getString(R.string.dana_viz_prompt_subtitle).substring(7, 8).length() + 17, (ViewConfiguration.getEdgeSlop() >> 16) + 12, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 203, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), 35 - View.combineMeasuredStates(0, 0), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 17, (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
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
        super.onPause();
    }

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(true, new char[]{'\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6}, KeyEvent.getDeadChar(0, 0) + 26, getPackageName().length() - 2, getPackageName().codePointAt(5) + 86, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(true, new char[]{65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529}, Color.blue(0) + 18, 13 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 203, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 35 - (Process.myTid() >> 22), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
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
        super.onResume();
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setTitle(getString(R.string.ipg_terms_and_conditions));
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        Bundle extras;
        setMenuLeftButton(R.drawable.btn_arrow_left);
        Intent intent = getIntent();
        load(UrlUtil.getAuthRequestContext((intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString(IPG_TNC_URL_EXTRA_KEY)));
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\n"}, d2 = {"Lid/dana/ipg/tncagreement/IpgTermsAndConditionActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "Landroid/content/Intent;", "getAuthRequestContext", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", IpgTermsAndConditionActivity.IPG_TNC_ACTION_RESULT, "Ljava/lang/String;", "IPG_TNC_URL_EXTRA_KEY", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent getAuthRequestContext(Context p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent putExtra = new Intent(p0, IpgTermsAndConditionActivity.class).putExtra(IpgTermsAndConditionActivity.IPG_TNC_URL_EXTRA_KEY, p1);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            return putExtra;
        }
    }

    @OnClick({R.id.btn_ipg_agree})
    public final void onAgreeClicked() {
        Intent intent = new Intent();
        intent.putExtra(IPG_TNC_ACTION_RESULT, true);
        setResult(-1, intent);
        finish();
    }

    private static void g(boolean z, char[] cArr, int i, int i2, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i3);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (lookAheadTest ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i2 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i2;
            char[] cArr3 = new char[i];
            System.arraycopy(cArr2, 0, cArr3, 0, i);
            System.arraycopy(cArr3, 0, cArr2, i - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            char[] cArr4 = new char[i];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i) {
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}

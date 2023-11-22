package id.dana.cardbinding.activity;

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
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.plus.security.lite.SecLiteException;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.HelpListView;
import id.dana.usereducation.adapter.HelpListAdapter;
import id.dana.usereducation.model.ContentOnBoardingModel;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/cardbinding/activity/OnboardingCardBindingActivity;", "Lid/dana/base/BaseActivity;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onBackPressed", "", "Lid/dana/usereducation/model/ContentOnBoardingModel;", "scheduleImpl", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class OnboardingCardBindingActivity extends BaseActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char[] getErrorConfigVersion;
    private static long lookAheadTest;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private List<ContentOnBoardingModel> KClassImpl$Data$declaredNonStaticMembers$2;
    public static final byte[] $$a = {108, -22, 67, 3, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 61;
    public static final byte[] getAuthRequestContext = {109, -87, 105, -77, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 3;

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 97
            byte[] r0 = id.dana.cardbinding.activity.OnboardingCardBindingActivity.getAuthRequestContext
            int r8 = 56 - r8
            int r7 = 23 - r7
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L31
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L31:
            int r8 = r8 + r7
            int r7 = r9 + 1
            int r8 = r8 + (-4)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.activity.OnboardingCardBindingActivity.b(short, byte, byte, java.lang.Object[]):void");
    }

    private static void c(byte b, byte b2, short s, Object[] objArr) {
        byte[] bArr = $$a;
        int i = 42 - (s * 3);
        int i2 = b2 + 4;
        int i3 = 103 - (b * 2);
        byte[] bArr2 = new byte[i];
        int i4 = -1;
        int i5 = i - 1;
        if (bArr == null) {
            int i6 = i5 + i2;
            i2++;
            i3 = i6 - 7;
            i5 = i5;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
        }
        while (true) {
            int i7 = i4 + 1;
            bArr2[i7] = (byte) i3;
            if (i7 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b3 = bArr[i2];
            i2++;
            i3 = (i3 + b3) - 7;
            i5 = i5;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i7;
        }
    }

    static void getAuthRequestContext() {
        getErrorConfigVersion = new char[]{62255, 62945, 65192, 59263, 59429, 53986, 56236, 56359, 50471, 53239, 45236, 47403, 41475, 42208, 44468, 38504, 40744, 33270, 35496, 29540, 29710, 32499, 26538, 26748, 20791, 23539, 62253, 62970, 65214, 59263, 59439, 53989, 56252, 56392, 50486, 53239, 45224, 47468, 41505, 42210, 44468, 38504, 40753, 33265, 62255, 62945, 65192, 59263, 59429, 53986, 56236, 56359, 50473, 53236, 45290, 47445, 41520, 42220, 44451, 38500, 40749, 33260, 22160, 20549, 23338, 17111, 19869, 40035, 39670, 37344, 34863, 34656, 48629, 46315, 45867, 43627, 41208, 57277, 54905, 52541, 52139, 49899, 63789, 61557, 61108, 58864, 7270, 6948, 4578, 2209, 1845, 15912, 13502, 13302, 10859, 8570, 24557, 22187, 19822, 17485, 17027, 31172, 28686, 28438, 25992, 40138, 39683, 37451, 35035, 34762, 48649, 46362, 45962, 43724, 41310, 35298, 36727, 33847, 40356, 37601, 43135, 41269, 42748, 49135, 46377, 51760, 50173, 55531, 56959, 55100, 60664, 58785, 64352, 61559, 2529, 3827, 1127, 7459, 4839, 11181, 8504, 9760, 16317, 13479, 19002, 17199, 22766, 20928, 22278, 27669, 26072, 31428, 28677, 35093, 36567, 34718, 40282, 37452, 43993, 41164, 42585, 48924, 46299, 52608, 49985, 55302, 53705, 54926, 60481, 58629, 64197, 62347, 2379, 3674, 1946, 7310, 4678, 11097, 8399, 62332, 62910, 65193, 59247, 59507, 53948, 56314, 56381, 50558, 53183, 45308, 47412, 41587, 42160, 44528, 38454, 40767, 33274, 35560, 29561, 29800, 32505, 26553, 26666, 20833, 23537, 23789, 17709, 20020, 12533, 14823, 8818, 11097, 11723, 5854, 7957, '\b', 2716, 62430, 62481, 64862, 59329, 59605, 53521, 55898, 56467, 50561, 52803, 46872, 47494, 41631, 43864, 44104, 38538, 40862, 32780, 35137, 29570, 29901, 32003, 26132, 26758, 20933, 23048, 8811, 9398, 12277, 13872, 14708, 1020, 2730, 3435, 5231, 7851, 25063, 26665, 29473, 30138, 31973, 18238, 20086, 20659, 23525, 41523, 42358, 44965, 46817, 47482, 32892, 35503, 36344, 37930, 40827, 57773, 59628, 62249, 64066, 64656, 51140, 52814, 53572, 56201, 8904, 9547, 11338, 13978, 14784, 'G', 2886, 3456, 5322, 7945, 26176, 26758, 29598, 31238, 32005, 18393, 20176, 20738, 22622, 41620, 42445, 44043, 60114, 60420, 59229, 65158, 61917, 51999};
        lookAheadTest = 3124081676217021839L;
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(18 - KeyEvent.getDeadChar(0, 0), AndroidCharacter.getMirror('0') - 4, (char) (ViewConfiguration.getEdgeSlop() >> 16), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(5 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 62 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (KeyEvent.getDeadChar(0, 0) + 42419), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0'), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 34, (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(48 - TextUtils.getTrimmedLength(""), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 66, (char) (28442 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 64, TextUtils.indexOf("", "", 0) + 115, (char) (View.getDefaultSize(0, 0) + 31437), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(64 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 179 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ViewConfiguration.getJumpTapTimeout() >> 16), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(60 - Gravity.getAbsoluteGravity(0, 0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 244, (char) (53581 - TextUtils.getOffsetAfter("", 0)), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 6, 303 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (6565 - (ViewConfiguration.getTapTimeout() >> 16)), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 911, 18 - (Process.myTid() >> 22), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[31], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (PlaceComponentResult + 5), (byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[34] + 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - Color.red(0), (ViewConfiguration.getLongPressTimeout() >> 16) + 3, (char) View.MeasureSpec.getSize(0));
                        Object[] objArr16 = new Object[1];
                        c($$a[12], (byte) ($$a[78] - 1), $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, Process.getGidForName("") + 16, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 800, 15 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 29, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 800, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 14, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {642893794, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 18 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr19 = {this};
                Object[] objArr20 = new Object[1];
                b(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[31], objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                Object[] objArr21 = new Object[1];
                b((byte) (PlaceComponentResult + 5), (byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[34] + 1), objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - View.MeasureSpec.getSize(0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 46, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1));
                        byte b = (byte) ($$a[78] - 1);
                        Object[] objArr23 = new Object[1];
                        c(b, (byte) (b | Ascii.ETB), $$a[8], objArr23);
                        obj9 = cls5.getMethod((String) objArr23[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr24 = (Object[]) ((Method) obj9).invoke(null, objArr22);
                    int i = ((int[]) objArr24[1])[0];
                    if (((int[]) objArr24[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr25 = {642893794, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 911, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 18, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr25);
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
                Object[] objArr26 = {this};
                Object[] objArr27 = new Object[1];
                b(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[31], objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                b((byte) (PlaceComponentResult + 5), (byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[34] + 1), objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - Color.argb(0, 0, 0, 0), View.MeasureSpec.getMode(0) + 3, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 38967));
                        byte b2 = (byte) ($$a[78] - 1);
                        Object[] objArr30 = new Object[1];
                        c(b2, (byte) (b2 | Ascii.ETB), $$a[8], objArr30);
                        obj12 = cls7.getMethod((String) objArr30[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr31 = (Object[]) ((Method) obj12).invoke(null, objArr29);
                    int i2 = ((int[]) objArr31[1])[0];
                    if (((int[]) objArr31[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.green(0), 34 - ImageFormat.getBitsPerPixel(0), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {642893794, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.combineMeasuredStates(0, 0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 18, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr32);
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
                Object[] objArr33 = {this};
                Object[] objArr34 = new Object[1];
                b(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[31], objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                Object[] objArr35 = new Object[1];
                b((byte) (PlaceComponentResult + 5), (byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[34] + 1), objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(108 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 4 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1));
                        Object[] objArr37 = new Object[1];
                        c($$a[9], $$a[53], (byte) ($$a[78] - 1), objArr37);
                        obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                    int i3 = ((int[]) objArr38[1])[0];
                    if (((int[]) objArr38[0])[0] != i3) {
                        long j4 = (4294967295L & (r1 ^ i3)) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), View.MeasureSpec.getMode(0) + 35, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr39 = {642893794, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 910, ((byte) KeyEvent.getModifierMetaStateMask()) + 19, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr39);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_onboarding_card_binding;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(getPackageName().length() + 11, super.getResources().getString(R.string.share_activity_cancel_dialog_title).substring(1, 2).codePointAt(0) - 53, (char) (getPackageName().codePointAt(1) - 100), objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        int codePointAt = super.getResources().getString(R.string.hint_form_city).substring(2, 3).codePointAt(0) - 103;
        int codePointAt2 = super.getResources().getString(R.string.login_with_face_verification).substring(5, 6).codePointAt(0) + 30;
        try {
            byte b = getAuthRequestContext[25];
            byte b2 = b;
            Object[] objArr3 = new Object[1];
            b(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b((byte) (-getAuthRequestContext[5]), getAuthRequestContext[27], getAuthRequestContext[25], objArr4);
            Object[] objArr5 = new Object[1];
            a(codePointAt, codePointAt2, (char) (((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 42386), objArr5);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr6 = new Object[1];
                    a(getPackageName().codePointAt(5) - 84, (-16777216) - Color.rgb(0, 0, 0), (char) (getPackageName().length() - 7), objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    a(getPackageName().length() + 11, super.getResources().getString(R.string.text_desc_landing_second_point).substring(34, 35).length() + 25, (char) (super.getResources().getString(R.string.trending_merchant).substring(0, 1).length() - 1), objArr7);
                    baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        a(super.getResources().getString(R.string.msg_pin_less_than6_error).substring(0, 4).length() + 44, super.getResources().getString(R.string.set_success).substring(1, 2).length() + 66, (char) (super.getResources().getString(R.string.popup_resend_error_otp_title).substring(9, 13).codePointAt(3) + 28410), objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a(getPackageName().codePointAt(3) - 36, getPackageName().codePointAt(2) + 69, (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 31437), objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(TextUtils.indexOf("", "", 0) + 64, super.getResources().getString(R.string.mp_all_mini_programs).substring(7, 8).codePointAt(0) + 74, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)), objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(super.getResources().getString(R.string.group_send_empty_state_description).substring(0, 2).length() + 58, super.getResources().getString(R.string.dialog_invitation_success).substring(26, 27).length() + 242, (char) (super.getResources().getString(R.string.referral_tracker_register).substring(0, 8).length() + 53573), objArr11);
                        String str4 = (String) objArr11[0];
                        int codePointAt3 = super.getResources().getString(R.string.platform_service_fee).substring(2, 3).codePointAt(0) - 91;
                        int codePointAt4 = super.getResources().getString(R.string.popup_location_desc).substring(3, 4).codePointAt(0) + 206;
                        try {
                            byte b3 = getAuthRequestContext[25];
                            byte b4 = b3;
                            Object[] objArr12 = new Object[1];
                            b(b3, b4, (byte) (b4 | TarHeader.LF_BLK), objArr12);
                            Class<?> cls4 = Class.forName((String) objArr12[0]);
                            Object[] objArr13 = new Object[1];
                            b((byte) (-getAuthRequestContext[5]), getAuthRequestContext[27], getAuthRequestContext[25], objArr13);
                            Object[] objArr14 = new Object[1];
                            a(codePointAt3, codePointAt4, (char) (((ApplicationInfo) cls4.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 6532), objArr14);
                            try {
                                Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 910, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr15);
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
                }
            }
            try {
                Object[] objArr16 = new Object[1];
                b(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[31], objArr16);
                Class<?> cls5 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                b((byte) (PlaceComponentResult + 5), (byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[34] + 1), objArr17);
                try {
                    Object[] objArr18 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 495, (ViewConfiguration.getWindowTouchSlop() >> 8) + 4, (char) (Process.myTid() >> 22));
                        Object[] objArr19 = new Object[1];
                        c($$a[9], $$a[53], (byte) ($$a[78] - 1), objArr19);
                        obj3 = cls6.getMethod((String) objArr19[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                    int i = ((int[]) objArr20[1])[0];
                    if (((int[]) objArr20[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.keyCodeFromString(""), 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr21 = {1162693787, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 911, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr21);
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
                    super.onCreate(bundle);
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
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.merchant_detail_see_other_reviews).substring(7, 8).codePointAt(0) - 43, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1, (char) (getPackageName().length() - 7), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.error_updating_app_snackbar).substring(15, 18).codePointAt(1) - 79, super.getResources().getString(R.string.find_friend_empty_message).substring(9, 10).length() + 25, (char) (super.getResources().getString(R.string.family_account_text_title_intro_1).substring(0, 2).codePointAt(1) + SecLiteException.ERROR_API_KEY_OR_SIGN), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 911, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int packedPositionGroup = 26 - ExpandableListView.getPackedPositionGroup(0L);
            try {
                byte b = getAuthRequestContext[25];
                byte b2 = b;
                Object[] objArr = new Object[1];
                b(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b((byte) (-getAuthRequestContext[5]), getAuthRequestContext[27], getAuthRequestContext[25], new Object[1]);
                Object[] objArr2 = new Object[1];
                a(packedPositionGroup, ((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                int length = getPackageName().length() + 11;
                int keyCodeFromString = KeyEvent.keyCodeFromString("") + 26;
                try {
                    byte b3 = getAuthRequestContext[25];
                    byte b4 = b3;
                    Object[] objArr3 = new Object[1];
                    b(b3, b4, (byte) (b4 | TarHeader.LF_BLK), objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    b((byte) (-getAuthRequestContext[5]), getAuthRequestContext[27], getAuthRequestContext[25], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    a(length, keyCodeFromString, (char) (((ApplicationInfo) cls3.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33), objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), 35 - View.resolveSize(0, 0), (char) ((-1) - Process.getGidForName("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.green(0), (ViewConfiguration.getTouchSlop() >> 8) + 18, (char) (Process.myPid() >> 22))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        super.onResume();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cardbinding/activity/OnboardingCardBindingActivity$Companion;", "", "Landroid/content/Context;", "p0", "Landroid/content/Intent;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent BuiltInFictitiousFunctionClassFactory(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new Intent(p0, OnboardingCardBindingActivity.class);
        }
    }

    public static /* synthetic */ void $r8$lambda$duV8XBgTkFoiIbNRGqGj6OtoMPE(OnboardingCardBindingActivity onboardingCardBindingActivity, View view) {
        Intrinsics.checkNotNullParameter(onboardingCardBindingActivity, "");
        onboardingCardBindingActivity.setResult(-1);
        onboardingCardBindingActivity.finish();
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        String string = getString(R.string.card_binding_onboarding_title_trusted_security);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = getString(R.string.card_binding_onboarding_content_trusted_security);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String string3 = getString(R.string.card_binding_onboarding_title_hassle_free);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = getString(R.string.card_binding_onboarding_content_hassle_free);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        String string5 = getString(R.string.card_binding_onboarding_title_easy_to_manage);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        String string6 = getString(R.string.card_binding_onboarding_content_easy_to_manage);
        Intrinsics.checkNotNullExpressionValue(string6, "");
        ArrayList arrayListOf = CollectionsKt.arrayListOf(new ContentOnBoardingModel((int) R.drawable.ic_trusted_security, string, string2), new ContentOnBoardingModel((int) R.drawable.ic_hassle_free, string3, string4), new ContentOnBoardingModel((int) R.drawable.ic_easy_to_manage, string5, string6));
        this.KClassImpl$Data$declaredNonStaticMembers$2 = arrayListOf;
        if (arrayListOf == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            arrayListOf = null;
        }
        ((HelpListView) _$_findCachedViewById(R.id.helpListViewOnboardingCardBinding)).setAdapter(new HelpListAdapter(arrayListOf));
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnNextOnboarding);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cardbinding.activity.OnboardingCardBindingActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OnboardingCardBindingActivity.$r8$lambda$duV8XBgTkFoiIbNRGqGj6OtoMPE(OnboardingCardBindingActivity.this, view);
                }
            });
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        setResult(-1);
        finish();
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (getErrorConfigVersion[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ lookAheadTest))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        objArr[0] = new String(cArr);
    }
}

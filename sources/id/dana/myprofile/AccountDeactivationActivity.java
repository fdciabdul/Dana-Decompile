package id.dana.myprofile;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
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
import android.widget.EditText;
import android.widget.ExpandableListView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.di.component.ApplicationComponent;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.extension.view.InputExtKt;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.social.contract.AccountDeactivationContract;
import id.dana.social.di.component.DaggerAccountDeactivationComponent;
import id.dana.social.di.module.AccountDeactivationModule;
import id.dana.utils.BorderedToastUtil;
import io.reactivex.Observable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007R\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/myprofile/AccountDeactivationActivity;", "Lid/dana/base/BaseActivity;", "", "getLayout", "()I", "", "BuiltInFictitiousFunctionClassFactory", "()V", IAPSyncCommand.COMMAND_INIT, "Lid/dana/social/contract/AccountDeactivationContract$Presenter;", "accountDeactivationPresenter", "Lid/dana/social/contract/AccountDeactivationContract$Presenter;", "getAccountDeactivationPresenter", "()Lid/dana/social/contract/AccountDeactivationContract$Presenter;", "setAccountDeactivationPresenter", "(Lid/dana/social/contract/AccountDeactivationContract$Presenter;)V", "Lid/dana/dialog/DanaLoadingDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/dialog/DanaLoadingDialog;", "getAuthRequestContext", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AccountDeactivationActivity extends BaseActivity {
    public static final byte[] $$a = {103, 121, -60, -41, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 142;
    public static final byte[] PlaceComponentResult = {56, -13, -61, 104, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 244;
    private static char[] getErrorConfigVersion = {62255, 17120, 37034, 59004, 13345, 35815, 55722, 12064, 32047, 52478, 702, 20512, 42511, 62957, 19386, 39271, 61240, 16103, 36026, 49783, 4122, 26598, 46524, 2923, 22831, 43242, 62253, 17147, 37052, 59004, 13355, 35808, 55738, 12111, 32062, 52478, 674, 20583, 42541, 62959, 19386, 39271, 61217, 16096, 62255, 17120, 37034, 59004, 13345, 35815, 55722, 12064, 32033, 52477, 736, 20574, 42556, 62945, 19373, 39275, 61245, 16125, 11318, 40418, 20366, 14706, 60223, 62329, 17133, 37112, 58934, 13438, 35818, 55799, 12086, 32121, 52459, 685, 20584, 42539, 62908, 19455, 39224, 61311, 16063, 36088, 49775, 4138, 26605, 46509, 2872, 22826, 43197, 65270, 19562, 33404, 53738, 10159, 30059, 52087, 6840, 26876, 48695, 3112, 17335, 37366, 59198, 13689, 34024, 56058, 10296, 32300, 52669, 1016, 20843, 5283, 42295, 30580, 486, 54180, 27707, 15986, 51386, 39590, 11105, 58747, 47031, 16806, 4659, 44147, 32438, 2288, 55600, 27428, 9651, 63398, 32819, 21108, 60593, 48884, 20320, 6523, 44007, 26106, 13926, 49264, 37552, 11425, 64870, 36726, 22970, 60321, 42081, 30322, Typography.plusMinus, 54007, 25394, 15655, 53171, 39329, 10805, 58483, 46773, 16625, 4401, 41845, 32187, 4091, 55349, 27250, 9395, 63218, 34611, 20769, 58336, 48627, 20026, 6182, 43697, 62332, 17087, 37035, 58988, 13431, 35769, 55804, 12090, 32118, 52406, 758, 20543, 42623, 62909, 19454, 39225, 61231, 16107, 36090, 49770, 4220, 26604, 46511, 2877, 22905, 43240, 65271, 19510, 33320, 53736, 10233, 30061, 52089, 6890, 26876, 48694, 3116, 17337, 37368, 59190, 13686, 34024, 56063, 10298, 32374, 52670, 943, 20844, 42792, 63159, 17581, 39531, 59516, 16319, 36264, 49979, 4473, 24763, 46839, 1080, 23080, 43451, 65531, 19767, 62246, 17146, 37050, 59006, 13373, 35764, 55777, 12065, 32042, 52463, 672, 20591, 42592, 62970, 19366, 39292, 61227, 16111, 36026, 49773, 4143, 26621, 46522, 2848, 22825, 43259, 65199, 19580, 33322, 53757, 10175, 30075, 52015, 6908, 26795, 48672, 3117, 17377, 37283, 59169, 13615, 34046, 55975, 10273, 32295, 52704, 937, 20843, 42813, 63226, 17633, 39544, 59516, 16289, 36267, 50040, 4395, 24800, 46778, 1149, 6654, 43049, 31347, 3241, 57077, 24886};
    private static long lookAheadTest = 6746004099688120974L;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private DanaLoadingDialog getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public AccountDeactivationContract.Presenter accountDeactivationPresenter;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 + 97
            int r9 = r9 + 16
            byte[] r0 = id.dana.myprofile.AccountDeactivationActivity.PlaceComponentResult
            int r8 = r8 + 4
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L30
        L14:
            r3 = 0
        L15:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L30:
            int r8 = r8 + r7
            int r7 = r8 + (-4)
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.AccountDeactivationActivity.a(byte, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r0 = id.dana.myprofile.AccountDeactivationActivity.$$a
            int r9 = r9 * 3
            int r9 = 42 - r9
            int r8 = 47 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L30
        L17:
            r3 = 0
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L30:
            int r8 = r8 + 1
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.AccountDeactivationActivity.c(byte, byte, short, java.lang.Object[]):void");
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
        b((ViewConfiguration.getKeyRepeatDelay() >> 16) + 18, ExpandableListView.getPackedPositionGroup(0L) + 44, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(5 - KeyEvent.keyCodeFromString(""), 63 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (57109 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1))), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.getDefaultSize(0, 0), (ViewConfiguration.getTouchSlop() >> 8) + 35, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(47 - ((byte) KeyEvent.getModifierMetaStateMask()), (ViewConfiguration.getJumpTapTimeout() >> 16) + 67, (char) (ViewConfiguration.getEdgeSlop() >> 16), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 64, (ViewConfiguration.getScrollBarSize() >> 8) + 115, (char) (59277 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(63 - TextUtils.indexOf((CharSequence) "", '0'), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 178, (char) ((Process.getThreadPriority(0) + 20) >> 6), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(ImageFormat.getBitsPerPixel(0) + 61, Drawable.resolveOpacity(0, 0) + 243, (char) ((-1) - TextUtils.lastIndexOf("", '0')), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 5, 303 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (TextUtils.getOffsetBefore("", 0) + 60041), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), ExpandableListView.getPackedPositionType(0L) + 18, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = PlaceComponentResult[32];
                Object[] objArr13 = new Object[1];
                a(b, (byte) (b << 2), PlaceComponentResult[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a((byte) (PlaceComponentResult[32] - 1), (byte) (PlaceComponentResult[35] - 1), PlaceComponentResult[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 55, 3 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) TextUtils.getCapsMode("", 0, 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[47], (byte) (-$$a[53]), $$a[68], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 14 - MotionEvent.axisFromString(""), (char) Color.alpha(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getScrollBarSize() >> 8), 15 - View.MeasureSpec.getSize(0), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - TextUtils.lastIndexOf("", '0', 0), View.resolveSize(0, 0) + 29, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (ViewConfiguration.getLongPressTimeout() >> 16) + 15, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r5 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), TextUtils.lastIndexOf("", '0', 0) + 36, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {380452040, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 911, 18 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b2 = PlaceComponentResult[32];
                Object[] objArr19 = new Object[1];
                a(b2, (byte) (b2 << 2), PlaceComponentResult[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a((byte) (PlaceComponentResult[32] - 1), (byte) (PlaceComponentResult[35] - 1), PlaceComponentResult[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), KeyEvent.keyCodeFromString("") + 46, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[9]), $$a[20], (byte) (-$$a[8]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), 34 - TextUtils.lastIndexOf("", '0'), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {380452040, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 911, 18 - TextUtils.indexOf("", "", 0), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = PlaceComponentResult[32];
                Object[] objArr25 = new Object[1];
                a(b3, (byte) (b3 << 2), PlaceComponentResult[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                a((byte) (PlaceComponentResult[32] - 1), (byte) (PlaceComponentResult[35] - 1), PlaceComponentResult[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 3, (char) (Color.red(0) + 38968));
                        Object[] objArr28 = new Object[1];
                        c((byte) (-$$a[9]), $$a[20], (byte) (-$$a[8]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {380452040, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 911, TextUtils.lastIndexOf("", '0', 0) + 19, (char) KeyEvent.getDeadChar(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = PlaceComponentResult[32];
                Object[] objArr31 = new Object[1];
                a(b4, (byte) (b4 << 2), PlaceComponentResult[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a((byte) (PlaceComponentResult[32] - 1), (byte) (PlaceComponentResult[35] - 1), PlaceComponentResult[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 106, TextUtils.indexOf((CharSequence) "", '0') + 4, (char) ExpandableListView.getPackedPositionType(0L));
                        byte b5 = (byte) ($$a[47] - 1);
                        byte b6 = b5;
                        Object[] objArr34 = new Object[1];
                        c(b5, b6, b6, objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {380452040, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 911, 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_account_deactivation;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        int codePointAt = getPackageName().codePointAt(1) - 82;
        try {
            Object[] objArr2 = new Object[1];
            a(PlaceComponentResult[25], PlaceComponentResult[9], (byte) (-PlaceComponentResult[30]), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            a((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[56], objArr3);
            Object[] objArr4 = new Object[1];
            b(codePointAt, ((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 11, (char) (getPackageName().length() - 7), objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            int indexOf = 4 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
            try {
                Object[] objArr5 = new Object[1];
                a(PlaceComponentResult[25], PlaceComponentResult[9], (byte) (-PlaceComponentResult[30]), objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                Object[] objArr6 = new Object[1];
                a((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[56], objArr6);
                Object[] objArr7 = new Object[1];
                b(indexOf, ((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 29, (char) (super.getResources().getString(R.string.error_username_consecutive_period).substring(0, 9).length() + 57100), objArr7);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr7[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr8 = new Object[1];
                        b(getPackageName().length() + 19, (-1) - ExpandableListView.getPackedPositionChild(0L), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        try {
                            Object[] objArr9 = new Object[1];
                            a(PlaceComponentResult[25], PlaceComponentResult[9], (byte) (-PlaceComponentResult[30]), objArr9);
                            Class<?> cls5 = Class.forName((String) objArr9[0]);
                            a((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[56], new Object[1]);
                            Object[] objArr10 = new Object[1];
                            b(((ApplicationInfo) cls5.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 15, getPackageName().length() + 19, (char) (getPackageName().codePointAt(1) - 100), objArr10);
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
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTouchSlop() >> 8), 35 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            try {
                                Object[] objArr11 = new Object[1];
                                a(PlaceComponentResult[25], PlaceComponentResult[9], (byte) (-PlaceComponentResult[30]), objArr11);
                                Class<?> cls6 = Class.forName((String) objArr11[0]);
                                Object[] objArr12 = new Object[1];
                                a((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[56], objArr12);
                                Object[] objArr13 = new Object[1];
                                b(((ApplicationInfo) cls6.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 15, getPackageName().codePointAt(5) - 43, (char) (getPackageName().length() - 7), objArr13);
                                String str = (String) objArr13[0];
                                Object[] objArr14 = new Object[1];
                                b(getPackageName().length() + 57, super.getResources().getString(R.string.family_member_transaction_limit_success_changed_message).substring(2, 3).length() + 114, (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 59276), objArr14);
                                String str2 = (String) objArr14[0];
                                try {
                                    Object[] objArr15 = new Object[1];
                                    a(PlaceComponentResult[25], PlaceComponentResult[9], (byte) (-PlaceComponentResult[30]), objArr15);
                                    Class<?> cls7 = Class.forName((String) objArr15[0]);
                                    Object[] objArr16 = new Object[1];
                                    a((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[56], objArr16);
                                    Object[] objArr17 = new Object[1];
                                    b(((ApplicationInfo) cls7.getMethod((String) objArr16[0], null).invoke(this, null)).targetSdkVersion + 31, 179 - Color.alpha(0), (char) (super.getResources().getString(R.string.verify_limit_amount_daily_title1).substring(3, 4).codePointAt(0) - 97), objArr17);
                                    String str3 = (String) objArr17[0];
                                    int length = super.getResources().getString(R.string.success_show_goal_balance_msg).substring(20, 21).length() + 59;
                                    try {
                                        Object[] objArr18 = new Object[1];
                                        a(PlaceComponentResult[25], PlaceComponentResult[9], (byte) (-PlaceComponentResult[30]), objArr18);
                                        Class<?> cls8 = Class.forName((String) objArr18[0]);
                                        Object[] objArr19 = new Object[1];
                                        a((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[56], objArr19);
                                        int i = ((ApplicationInfo) cls8.getMethod((String) objArr19[0], null).invoke(this, null)).targetSdkVersion + 210;
                                        try {
                                            Object[] objArr20 = new Object[1];
                                            a(PlaceComponentResult[25], PlaceComponentResult[9], (byte) (-PlaceComponentResult[30]), objArr20);
                                            Class<?> cls9 = Class.forName((String) objArr20[0]);
                                            a((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[56], new Object[1]);
                                            Object[] objArr21 = new Object[1];
                                            b(length, i, (char) (((ApplicationInfo) cls9.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 33), objArr21);
                                            String str4 = (String) objArr21[0];
                                            Object[] objArr22 = new Object[1];
                                            b(super.getResources().getString(R.string.twilio_intro_3_title).substring(0, 1).codePointAt(0) - 77, super.getResources().getString(R.string.balance_subtitle).substring(9, 10).length() + 302, (char) (super.getResources().getString(R.string.family_account_setting_maintenance_subtitle).substring(7, 8).codePointAt(0) + 59944), objArr22);
                                            try {
                                                Object[] objArr23 = {baseContext, str, str2, str3, str4, true, (String) objArr22[0], 995651014};
                                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                if (obj2 == null) {
                                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 910, Color.red(0) + 18, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                }
                                                ((Method) obj2).invoke(invoke, objArr23);
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
                    byte b = PlaceComponentResult[32];
                    Object[] objArr24 = new Object[1];
                    a(b, (byte) (b << 2), PlaceComponentResult[25], objArr24);
                    Class<?> cls10 = Class.forName((String) objArr24[0]);
                    Object[] objArr25 = new Object[1];
                    a((byte) (PlaceComponentResult[32] - 1), (byte) (PlaceComponentResult[35] - 1), PlaceComponentResult[25], objArr25);
                    try {
                        Object[] objArr26 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr25[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls11 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 4 - KeyEvent.getDeadChar(0, 0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                            byte b2 = (byte) ($$a[47] - 1);
                            byte b3 = b2;
                            Object[] objArr27 = new Object[1];
                            c(b2, b3, b3, objArr27);
                            obj3 = cls11.getMethod((String) objArr27[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr28 = (Object[]) ((Method) obj3).invoke(null, objArr26);
                        int i2 = ((int[]) objArr28[1])[0];
                        if (((int[]) objArr28[0])[0] != i2) {
                            long j = ((r0 ^ i2) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, 36 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr29 = {933528393, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 911, 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (Process.getGidForName("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr29);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int length = super.getResources().getString(R.string.my_payment_card).substring(1, 2).length() + 25;
            int green = Color.green(0);
            try {
                Object[] objArr = new Object[1];
                a(PlaceComponentResult[25], PlaceComponentResult[9], (byte) (-PlaceComponentResult[30]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[56], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(length, green, (char) (((ApplicationInfo) cls.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                int length2 = getPackageName().length() + 11;
                try {
                    Object[] objArr3 = new Object[1];
                    a(PlaceComponentResult[25], PlaceComponentResult[9], (byte) (-PlaceComponentResult[30]), objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    a((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[56], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(length2, ((ApplicationInfo) cls3.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 7, (char) (super.getResources().getString(R.string.family_account_member_title).substring(12, 13).codePointAt(0) - 110), objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.getDefaultSize(0, 0), 18 - (Process.myPid() >> 22), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int myPid = 26 - (Process.myPid() >> 22);
            try {
                Object[] objArr = new Object[1];
                a(PlaceComponentResult[25], PlaceComponentResult[9], (byte) (-PlaceComponentResult[30]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[56], objArr2);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 33;
                try {
                    Object[] objArr3 = new Object[1];
                    a(PlaceComponentResult[25], PlaceComponentResult[9], (byte) (-PlaceComponentResult[30]), objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    a((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[56], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(myPid, i, (char) (((ApplicationInfo) cls2.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33), objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    b(18 - TextUtils.getOffsetAfter("", 0), getPackageName().length() + 19, (char) (super.getResources().getString(R.string.faq).substring(0, 3).codePointAt(1) - 65), objArr5);
                    baseContext = (Context) cls3.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 930, 35 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr6 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 912, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr6);
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

    @JvmName(name = "getAccountDeactivationPresenter")
    public final AccountDeactivationContract.Presenter getAccountDeactivationPresenter() {
        AccountDeactivationContract.Presenter presenter = this.accountDeactivationPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setAccountDeactivationPresenter")
    public final void setAccountDeactivationPresenter(AccountDeactivationContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.accountDeactivationPresenter = presenter;
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        this.getAuthRequestContext = new DanaLoadingDialog(this);
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.btn_deactivate);
        byte b = 0;
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setDanaButtonView(0, getString(R.string.btn_account_deactivation_deactivate), "", null);
            danaButtonSecondaryView.setEnabled(false);
        }
        setTitle(getString(R.string.lbl_account_deactivation_toolbar_title));
        setMenuLeftButton(R.drawable.arrow_left_white);
        ((DanaButtonSecondaryView) _$_findCachedViewById(R.id.btn_deactivate)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.AccountDeactivationActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountDeactivationActivity.m2688$r8$lambda$UZkLGrITzaL4mKlriVZ0dBpNk(AccountDeactivationActivity.this, view);
            }
        });
        EditText editText = (EditText) _$_findCachedViewById(R.id.res_0x7f0a0693_daggerkycamleddactivitycomponent_kycamleddactivitycomponentimpl_kycamleddrepositoryprovider);
        if (editText != null) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.myprofile.AccountDeactivationActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    AccountDeactivationActivity.m2687$r8$lambda$RJOnxJmfTk5MQX5WU1H1GQBA2U(AccountDeactivationActivity.this, view, z);
                }
            });
            Unit unit = Unit.INSTANCE;
        }
        DaggerAccountDeactivationComponent.Builder authRequestContext = DaggerAccountDeactivationComponent.getAuthRequestContext();
        authRequestContext.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        authRequestContext.getAuthRequestContext = (AccountDeactivationModule) Preconditions.getAuthRequestContext(new AccountDeactivationModule(new AccountDeactivationContract.View() { // from class: id.dana.myprofile.AccountDeactivationActivity$getAccountDeactivationModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.social.contract.AccountDeactivationContract.View
            public final void getAuthRequestContext() {
                AccountDeactivationActivity.access$showInvalidEmailMsg(AccountDeactivationActivity.this);
                AccountDeactivationActivity accountDeactivationActivity = AccountDeactivationActivity.this;
                DanaButtonSecondaryView danaButtonSecondaryView2 = (DanaButtonSecondaryView) accountDeactivationActivity._$_findCachedViewById(R.id.btn_deactivate);
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView2, "");
                AccountDeactivationActivity.access$disable(accountDeactivationActivity, danaButtonSecondaryView2);
            }

            @Override // id.dana.social.contract.AccountDeactivationContract.View
            public final void MyBillsEntityDataFactory() {
                AccountDeactivationActivity.this.BuiltInFictitiousFunctionClassFactory();
                AccountDeactivationActivity accountDeactivationActivity = AccountDeactivationActivity.this;
                DanaButtonSecondaryView danaButtonSecondaryView2 = (DanaButtonSecondaryView) accountDeactivationActivity._$_findCachedViewById(R.id.btn_deactivate);
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView2, "");
                AccountDeactivationActivity.access$enable(accountDeactivationActivity, danaButtonSecondaryView2);
            }

            @Override // id.dana.social.contract.AccountDeactivationContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                AccountDeactivationActivity.access$dismissLoadingDialog(AccountDeactivationActivity.this);
                AccountDeactivationActivity.access$closeActivityWithSuccessToast(AccountDeactivationActivity.this);
            }

            @Override // id.dana.social.contract.AccountDeactivationContract.View
            public final void PlaceComponentResult() {
                AccountDeactivationActivity.access$dismissLoadingDialog(AccountDeactivationActivity.this);
                AccountDeactivationActivity.access$resetToInitialState(AccountDeactivationActivity.this);
                AccountDeactivationActivity accountDeactivationActivity = AccountDeactivationActivity.this;
                String string = accountDeactivationActivity.getString(R.string.toast_account_deactivation_failed);
                Intrinsics.checkNotNullExpressionValue(string, "");
                AccountDeactivationActivity.access$showErrorToastMsgOnTop(accountDeactivationActivity, string);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getAuthRequestContext, AccountDeactivationModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerAccountDeactivationComponent.AccountDeactivationComponentImpl(authRequestContext.getAuthRequestContext, authRequestContext.BuiltInFictitiousFunctionClassFactory, b).getAuthRequestContext(this);
        registerPresenter(getAccountDeactivationPresenter());
        AccountDeactivationContract.Presenter accountDeactivationPresenter = getAccountDeactivationPresenter();
        Observable<CharSequence> skipInitialValue = RxTextView.textChanges((EditText) _$_findCachedViewById(R.id.res_0x7f0a0693_daggerkycamleddactivitycomponent_kycamleddactivitycomponentimpl_kycamleddrepositoryprovider)).skipInitialValue();
        Intrinsics.checkNotNullExpressionValue(skipInitialValue, "");
        accountDeactivationPresenter.MyBillsEntityDataFactory(skipInitialValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.cl_bottom_hint);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.BarLineScatterCandleBubbleRenderer$XBounds);
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.f23982131099995));
        }
        EditText editText = (EditText) _$_findCachedViewById(R.id.res_0x7f0a0693_daggerkycamleddactivitycomponent_kycamleddactivitycomponentimpl_kycamleddrepositoryprovider);
        if (editText != null) {
            InputExtKt.BuiltInFictitiousFunctionClassFactory(editText, R.color.f23962131099992);
        }
    }

    /* renamed from: $r8$lambda$-RJOnxJmfTk5MQX5WU1H1GQBA2U  reason: not valid java name */
    public static /* synthetic */ void m2687$r8$lambda$RJOnxJmfTk5MQX5WU1H1GQBA2U(AccountDeactivationActivity accountDeactivationActivity, View view, boolean z) {
        Intrinsics.checkNotNullParameter(accountDeactivationActivity, "");
        if (z) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) accountDeactivationActivity._$_findCachedViewById(R.id.BarLineScatterCandleBubbleRenderer$XBounds);
            if (appCompatTextView != null) {
                appCompatTextView.setVisibility(0);
                return;
            }
            return;
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) accountDeactivationActivity._$_findCachedViewById(R.id.BarLineScatterCandleBubbleRenderer$XBounds);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setVisibility(4);
        }
    }

    /* renamed from: $r8$lambda$UZkLGrITz-aL4mKlri-VZ0dBpNk  reason: not valid java name */
    public static /* synthetic */ void m2688$r8$lambda$UZkLGrITzaL4mKlriVZ0dBpNk(final AccountDeactivationActivity accountDeactivationActivity, View view) {
        Intrinsics.checkNotNullParameter(accountDeactivationActivity, "");
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.myprofile.AccountDeactivationActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountDeactivationActivity.m2689$r8$lambda$ustQrlggJRGW5Y8vWAPh8p0Wcs(AccountDeactivationActivity.this, view2);
            }
        };
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(accountDeactivationActivity);
        builder.FragmentBottomSheetPaymentSettingBinding = accountDeactivationActivity.getString(R.string.popup_account_deactivation_confirmation_title);
        builder.getErrorConfigVersion = accountDeactivationActivity.getString(R.string.popup_account_deactivation_confirmation_message);
        String string = accountDeactivationActivity.getString(R.string.option_no);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String upperCase = string.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = upperCase;
        builder.DatabaseTableConfigUtil = null;
        builder.initRecordTimeStamp = true;
        String string2 = accountDeactivationActivity.getString(R.string.option_yes);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String upperCase2 = string2.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase2, "");
        builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = upperCase2;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        builder.PlaceComponentResult(false);
        builder.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory();
    }

    /* renamed from: $r8$lambda$u-stQrlggJRGW5Y8vWAPh8p0Wcs  reason: not valid java name */
    public static /* synthetic */ void m2689$r8$lambda$ustQrlggJRGW5Y8vWAPh8p0Wcs(AccountDeactivationActivity accountDeactivationActivity, View view) {
        Intrinsics.checkNotNullParameter(accountDeactivationActivity, "");
        DanaLoadingDialog danaLoadingDialog = accountDeactivationActivity.getAuthRequestContext;
        if (danaLoadingDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaLoadingDialog = null;
        }
        if (!danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
        accountDeactivationActivity.getAccountDeactivationPresenter().PlaceComponentResult();
    }

    public static final /* synthetic */ void access$closeActivityWithSuccessToast(AccountDeactivationActivity accountDeactivationActivity) {
        Intent intent = new Intent();
        intent.putExtra("accountDeactivationResult", accountDeactivationActivity.getString(R.string.toast_account_deactivation_success));
        accountDeactivationActivity.setResult(-1, intent);
        accountDeactivationActivity.finish();
    }

    public static final /* synthetic */ void access$disable(AccountDeactivationActivity accountDeactivationActivity, DanaButtonSecondaryView danaButtonSecondaryView) {
        danaButtonSecondaryView.setDanaButtonView(0, accountDeactivationActivity.getString(R.string.btn_account_deactivation_deactivate), "", null);
        danaButtonSecondaryView.setEnabled(false);
    }

    public static final /* synthetic */ void access$dismissLoadingDialog(AccountDeactivationActivity accountDeactivationActivity) {
        DanaLoadingDialog danaLoadingDialog = accountDeactivationActivity.getAuthRequestContext;
        if (danaLoadingDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaLoadingDialog = null;
        }
        danaLoadingDialog.PlaceComponentResult();
    }

    public static final /* synthetic */ void access$enable(AccountDeactivationActivity accountDeactivationActivity, DanaButtonSecondaryView danaButtonSecondaryView) {
        danaButtonSecondaryView.setDanaButtonView(5, accountDeactivationActivity.getString(R.string.btn_account_deactivation_deactivate), "", null);
        danaButtonSecondaryView.setEnabled(true);
    }

    public static final /* synthetic */ void access$resetToInitialState(AccountDeactivationActivity accountDeactivationActivity) {
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) accountDeactivationActivity._$_findCachedViewById(R.id.btn_deactivate);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setDanaButtonView(5, accountDeactivationActivity.getString(R.string.btn_account_deactivation_deactivate), "", null);
            danaButtonSecondaryView.setEnabled(true);
        }
        accountDeactivationActivity.BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ void access$showErrorToastMsgOnTop(AccountDeactivationActivity accountDeactivationActivity, String str) {
        BorderedToastUtil borderedToastUtil = BorderedToastUtil.MyBillsEntityDataFactory;
        BorderedToastUtil.MyBillsEntityDataFactory(accountDeactivationActivity, R.drawable.res_0x7f08065e_networkuserentitydata_externalsyntheticlambda1, R.color.f26712131100373, str, 48, SettingMoreProfileActivity.TOAST_DURATION, 3);
    }

    public static final /* synthetic */ void access$showInvalidEmailMsg(AccountDeactivationActivity accountDeactivationActivity) {
        ConstraintLayout constraintLayout = (ConstraintLayout) accountDeactivationActivity._$_findCachedViewById(R.id.cl_bottom_hint);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        EditText editText = (EditText) accountDeactivationActivity._$_findCachedViewById(R.id.res_0x7f0a0693_daggerkycamleddactivitycomponent_kycamleddactivitycomponentimpl_kycamleddrepositoryprovider);
        if (editText != null) {
            InputExtKt.BuiltInFictitiousFunctionClassFactory(editText, R.color.f26712131100373);
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) accountDeactivationActivity._$_findCachedViewById(R.id.BarLineScatterCandleBubbleRenderer$XBounds);
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(accountDeactivationActivity, R.color.f26712131100373));
        }
    }

    private static void b(int i, int i2, char c, Object[] objArr) {
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

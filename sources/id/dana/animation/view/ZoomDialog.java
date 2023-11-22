package id.dana.animation.view;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.view.ComponentActivity;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.plus.security.lite.SecLiteException;
import com.anggrayudi.storage.extension.ContextUtils;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.contract.payqr.OfflinePayModule;
import id.dana.contract.payqr.PayQrContract;
import id.dana.contract.payqr.PayQrModule;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerZoomDialogComponent;
import id.dana.di.component.ZoomDialogComponent;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.BarcodeUtil;
import id.dana.utils.BrightnessUtil;
import id.dana.utils.DanaScreenshotDetector;
import id.dana.utils.OSUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes5.dex */
public class ZoomDialog extends BaseActivity implements AppLifeCycleObserver.KeyBoardOperationListener {
    public static final String QR_BAR_CODE = "QR_BAR_CODE";
    public static final String QR_DISPLAYED = "QR_DISPLAY";
    private final ActivityPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    AppLifeCycleObserver appLifeCycleObserver;
    private ZoomDialogComponent getErrorConfigVersion;
    @BindView(R.id.iv_zoom_barcode)
    ImageView ivBarcodeZoom;
    @BindView(R.id.SendMoneyHomePresenter)
    ImageView ivLogo;
    @BindView(R.id.iv_zoom_qr)
    ImageView ivQrZoom;
    @BindView(R.id.layout_zoom_barcode)
    LinearLayout layoutBarcodeZoom;
    @BindView(R.id.rl_zoom)
    RelativeLayout layoutParent;
    @BindView(R.id.layout_zoom_qr)
    RelativeLayout layoutQrZoom;
    private QrRefreshNotification lookAheadTest;
    @Inject
    OfflinePayContract.Presenter offlinePayPresenter;
    @Inject
    PayQrContract.Presenter payQrPresenter;
    private boolean scheduleImpl;
    @BindView(R.id.tv_zoom_code)
    TextView tvCode;
    public static final byte[] $$a = {8, 83, -102, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 136;
    public static final byte[] PlaceComponentResult = {75, 108, -123, 87, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 96;
    private static char GetContactSyncConfig = 20822;
    private static long DatabaseTableConfigUtil = 4360990799332652212L;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = -956812108;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.animation.view.ZoomDialog.PlaceComponentResult
            int r9 = 23 - r9
            int r7 = r7 + 4
            int r8 = r8 + 97
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L31
        L14:
            r3 = 0
            r6 = r9
            r9 = r8
        L17:
            r8 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L31:
            int r10 = r10 + r7
            int r7 = r10 + (-4)
            int r8 = r8 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r8
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.view.ZoomDialog.a(int, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.animation.view.ZoomDialog.$$a
            int r9 = r9 * 2
            int r9 = 103 - r9
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r7 = 46 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r9
            r4 = 0
            r9 = r8
            goto L2c
        L15:
            r3 = 0
        L16:
            int r7 = r7 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r6
        L2c:
            int r8 = r8 + r3
            int r8 = r8 + (-7)
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.view.ZoomDialog.c(int, byte, int, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(new char[]{0, 0, 0, 0}, new char[]{5074, 29190, 27801, 54853}, TextUtils.indexOf("", ""), (char) (17772 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), new char[]{24497, 15158, 52773, 40358, 32928, 2412, 21807, 57500, 34982, 60450, 2688, 55806, 18375, 38034, 48745, 30256, 23493, 60943}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(new char[]{0, 0, 0, 0}, new char[]{30074, 28900, 14779, 21447}, (-1150229388) - TextUtils.lastIndexOf("", '0'), (char) (51001 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), new char[]{35281, 12339, 51964, 57738, 59715}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - MotionEvent.axisFromString(""), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{11919, 59391, 59446, 53330}, Gravity.getAbsoluteGravity(0, 0), (char) TextUtils.getCapsMode("", 0, 0), new char[]{6789, 27012, 21876, 45083, 50470, 48403, 21726, 40226, 27755, 12381, 8829, 21438, 34580, 31813, 52041, 45443, 52590, 52199, 6173, 21500, 57172, 58441, 10462, 31449, 26486, 33415, 55835, 61617, 12770, 2054, 31932, 32135, 31729, 44417, 63349, 21166, 43744, 20944, 20227, 19178, 61008, 64264, 40267, 65221, 2785, 54986, 46827, 5952}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{25162, 51662, 40440, 41899}, KeyEvent.getDeadChar(0, 0), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), new char[]{39710, 10734, 49323, 52405, 29773, 39733, 35650, 2020, 27845, 33371, 58862, 18803, 14782, 57237, 47058, 3786, 29772, 30560, 49796, 25848, 65003, 56314, 10839, 16383, 56918, 2485, 35618, 32877, 42346, 52686, 42185, 20721, 36157, 60478, 60353, 14906, 7382, 7970, 57100, 13655, 40087, 32593, 52934, 20200, 57944, 47849, 21656, 62778, 36510, 24089, 36085, 32115, 56568, 1096, 15493, 16936, 51634, 62426, 36907, 45672, 62665, 45221, 61159, 2515}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{59229, 20797, 3752, 13671}, View.MeasureSpec.getMode(0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{42631, 32926, 64389, 34454, 21786, 45526, 60509, 1105, 38779, 39586, 27633, 49032, 44825, 24095, 41754, 46345, 47393, 37100, 57086, 56377, 5686, 22598, 27255, 37297, 3891, 16815, 48076, 14771, 40492, 42564, 54907, 41010, 12680, 56029, 49831, 60530, 34805, 11694, 42149, 27658, 42296, 60427, 23462, 29037, 36478, 43341, 42755, 60234, 40182, 48229, 44156, 16600, 18738, 34853, 55115, 53964, 27324, 26344, 60202, 48032, 24383, 34348, 39891, 2547}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{19623, 21730, 2415, 59118}, AndroidCharacter.getMirror('0') - '0', (char) (ViewConfiguration.getEdgeSlop() >> 16), new char[]{51244, 27665, 46810, 62263, 51337, 7822, 1649, 38138, 5242, 26878, 31950, 17145, 14707, 13110, 279, 63499, 13875, 23645, 21566, 26460, 31668, 59989, 27313, 42221, 20841, 50320, 2620, 44659, 55543, 39798, 1611, 29659, 65133, 30125, 18955, 28410, 723, 31152, 47272, 30848, 27204, 38349, 34340, 33959, 29087, 58577, 33875, 59982, 35173, 15215, 38614, 64247, 3905, 37289, 47137, 15316, 27529, 15612, 9478, 54113}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{46339, 42267, 4486, 43915}, TextUtils.getOffsetAfter("", 0), (char) (35602 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), new char[]{39587, 36103, 56902, 35147, 57473, 24285}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) Color.argb(0, 0, 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a(37, PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(PlaceComponentResult[35], (byte) (PlaceComponentResult[32] - 1), (byte) (-PlaceComponentResult[30]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (KeyEvent.getMaxKeyCode() >> 16), Gravity.getAbsoluteGravity(0, 0) + 3, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1));
                        Object[] objArr16 = new Object[1];
                        c($$a[53], $$a[31], $$a[12], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 800, 15 - (ViewConfiguration.getTapTimeout() >> 16), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - ((Process.getThreadPriority(0) + 20) >> 6), (char) KeyEvent.getDeadChar(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 815, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 30, (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 15 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ViewConfiguration.getEdgeSlop() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), Color.rgb(0, 0, 0) + 16777251, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {873740060, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(37, PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                Object[] objArr21 = new Object[1];
                a(PlaceComponentResult[35], (byte) (PlaceComponentResult[32] - 1), (byte) (-PlaceComponentResult[30]), objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 62, 46 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                        Object[] objArr23 = new Object[1];
                        c($$a[84], $$a[8], (byte) ($$a[78] - 1), objArr23);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 930, (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr25 = {873740060, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.argb(0, 0, 0, 0), 18 - View.getDefaultSize(0, 0), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(37, PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                a(PlaceComponentResult[35], (byte) (PlaceComponentResult[32] - 1), (byte) (-PlaceComponentResult[30]), objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(117 - Process.getGidForName(""), View.resolveSizeAndState(0, 0, 0) + 3, (char) ((ViewConfiguration.getTapTimeout() >> 16) + 38968));
                        Object[] objArr30 = new Object[1];
                        c($$a[84], $$a[8], (byte) ($$a[78] - 1), objArr30);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {873740060, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, 17 - MotionEvent.axisFromString(""), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(37, PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                Object[] objArr35 = new Object[1];
                a(PlaceComponentResult[35], (byte) (PlaceComponentResult[32] - 1), (byte) (-PlaceComponentResult[30]), objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 107, Color.blue(0) + 3, (char) Color.green(0));
                        byte b = (byte) ($$a[78] - 1);
                        Object[] objArr37 = new Object[1];
                        c(b, b, $$a[9], objArr37);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr39 = {873740060, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 863, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public int getLayout() {
        return R.layout.dialog_zoom;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        char[] cArr = {0, 0, 0, 0};
        char[] cArr2 = {5074, 29190, 27801, 54853};
        try {
            byte b = PlaceComponentResult[25];
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], new Object[1]);
            Object[] objArr3 = new Object[1];
            b(cArr, cArr2, ((ApplicationInfo) cls.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (getPackageName().codePointAt(1) + 17672), new char[]{24497, 15158, 52773, 40358, 32928, 2412, 21807, 57500, 34982, 60450, 2688, 55806, 18375, 38034, 48745, 30256, 23493, 60943}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{30074, 28900, 14779, 21447}, super.getResources().getString(R.string.benefit_dana_app).substring(6, 7).length() - 1150229388, (char) (getPackageName().codePointAt(3) + 50901), new char[]{35281, 12339, 51964, 57738, 59715}, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{12119, 57302, 26473, 45153}, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1, (char) (super.getResources().getString(R.string.bottom_on_boarding_body_text_request_money_second).substring(10, 11).length() + 24934), new char[]{33835, 30094, 52641, 43015, 32439, 2422, 41637, 30203, 46624, 27071, 63057, 37617, 18625, 13014, 53774, 59075, 32159, 62251, 44162, 20504, 17611, 20470, 6083, 3894, 34359, 4115}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    char[] cArr3 = {0, 0, 0, 0};
                    char[] cArr4 = {19281, 9529, 19875, 35443};
                    try {
                        byte b3 = PlaceComponentResult[25];
                        byte b4 = b3;
                        Object[] objArr6 = new Object[1];
                        a(b3, b4, b4, objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        b(cArr3, cArr4, ((ApplicationInfo) cls4.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.family_account_text_top_up_not_enough).substring(51, 52).codePointAt(0) + 29420), new char[]{17162, 63238, 64895, 31549, 10779, 25958, 48932, 33283, 34690, 48058, 21337, 54113, 6973, 13244, 29969, 64613, 19359, 59563}, objArr7);
                        baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0), ((Process.getThreadPriority(0) + 20) >> 6) + 35, (char) ((-1) - Process.getGidForName("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        char[] cArr5 = {0, 0, 0, 0};
                        char[] cArr6 = {11919, 59391, 59446, 53330};
                        try {
                            byte b5 = PlaceComponentResult[25];
                            byte b6 = b5;
                            Object[] objArr8 = new Object[1];
                            a(b5, b6, b6, objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], new Object[1]);
                            Object[] objArr9 = new Object[1];
                            b(cArr5, cArr6, ((ApplicationInfo) cls5.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.share_activity_hint).substring(5, 6).codePointAt(0) - 32), new char[]{6789, 27012, 21876, 45083, 50470, 48403, 21726, 40226, 27755, 12381, 8829, 21438, 34580, 31813, 52041, 45443, 52590, 52199, 6173, 21500, 57172, 58441, 10462, 31449, 26486, 33415, 55835, 61617, 12770, 2054, 31932, 32135, 31729, 44417, 63349, 21166, 43744, 20944, 20227, 19178, 61008, 64264, 40267, 65221, 2785, 54986, 46827, 5952}, objArr9);
                            String str = (String) objArr9[0];
                            Object[] objArr10 = new Object[1];
                            b(new char[]{0, 0, 0, 0}, new char[]{25162, 51662, 40440, 41899}, TextUtils.lastIndexOf("", '0', 0, 0) + 1, (char) (super.getResources().getString(R.string.pickerview_submit).substring(4, 5).codePointAt(0) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS), new char[]{39710, 10734, 49323, 52405, 29773, 39733, 35650, 2020, 27845, 33371, 58862, 18803, 14782, 57237, 47058, 3786, 29772, 30560, 49796, 25848, 65003, 56314, 10839, 16383, 56918, 2485, 35618, 32877, 42346, 52686, 42185, 20721, 36157, 60478, 60353, 14906, 7382, 7970, 57100, 13655, 40087, 32593, 52934, 20200, 57944, 47849, 21656, 62778, 36510, 24089, 36085, 32115, 56568, 1096, 15493, 16936, 51634, 62426, 36907, 45672, 62665, 45221, 61159, 2515}, objArr10);
                            String str2 = (String) objArr10[0];
                            char[] cArr7 = {0, 0, 0, 0};
                            char[] cArr8 = {59229, 20797, 3752, 13671};
                            try {
                                byte b7 = PlaceComponentResult[25];
                                byte b8 = b7;
                                Object[] objArr11 = new Object[1];
                                a(b7, b8, b8, objArr11);
                                Class<?> cls6 = Class.forName((String) objArr11[0]);
                                a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], new Object[1]);
                                Object[] objArr12 = new Object[1];
                                b(cArr7, cArr8, ((ApplicationInfo) cls6.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (getPackageName().length() - 7), new char[]{42631, 32926, 64389, 34454, 21786, 45526, 60509, 1105, 38779, 39586, 27633, 49032, 44825, 24095, 41754, 46345, 47393, 37100, 57086, 56377, 5686, 22598, 27255, 37297, 3891, 16815, 48076, 14771, 40492, 42564, 54907, 41010, 12680, 56029, 49831, 60530, 34805, 11694, 42149, 27658, 42296, 60427, 23462, 29037, 36478, 43341, 42755, 60234, 40182, 48229, 44156, 16600, 18738, 34853, 55115, 53964, 27324, 26344, 60202, 48032, 24383, 34348, 39891, 2547}, objArr12);
                                String str3 = (String) objArr12[0];
                                Object[] objArr13 = new Object[1];
                                b(new char[]{0, 0, 0, 0}, new char[]{19623, 21730, 2415, 59118}, super.getResources().getString(R.string.merchant_detail).substring(1, 2).codePointAt(0) + SecLiteException.ERROR_API_KEY_OR_SIGN, (char) (super.getResources().getString(R.string.redirect_not_found).substring(0, 2).codePointAt(0) - 65), new char[]{51244, 27665, 46810, 62263, 51337, 7822, 1649, 38138, 5242, 26878, 31950, 17145, 14707, 13110, 279, 63499, 13875, 23645, 21566, 26460, 31668, 59989, 27313, 42221, 20841, 50320, 2620, 44659, 55543, 39798, 1611, 29659, 65133, 30125, 18955, 28410, 723, 31152, 47272, 30848, 27204, 38349, 34340, 33959, 29087, 58577, 33875, 59982, 35173, 15215, 38614, 64247, 3905, 37289, 47137, 15316, 27529, 15612, 9478, 54113}, objArr13);
                                String str4 = (String) objArr13[0];
                                Object[] objArr14 = new Object[1];
                                b(new char[]{0, 0, 0, 0}, new char[]{46339, 42267, 4486, 43915}, ViewConfiguration.getKeyRepeatDelay() >> 16, (char) (getPackageName().codePointAt(3) + 35501), new char[]{39587, 36103, 56902, 35147, 57473, 24285}, objArr14);
                                try {
                                    Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), TextUtils.lastIndexOf("", '0') + 19, (char) Color.green(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr15);
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
            }
            try {
                Object[] objArr16 = new Object[1];
                a(37, PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), objArr16);
                Class<?> cls7 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                a(PlaceComponentResult[35], (byte) (PlaceComponentResult[32] - 1), (byte) (-PlaceComponentResult[30]), objArr17);
                try {
                    Object[] objArr18 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 494, 4 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getTouchSlop() >> 8));
                        byte b9 = (byte) ($$a[78] - 1);
                        Object[] objArr19 = new Object[1];
                        c(b9, b9, $$a[9], objArr19);
                        obj3 = cls8.getMethod((String) objArr19[0], Integer.TYPE);
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
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 36 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr21 = {-1921116851, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 911, 17 - TextUtils.lastIndexOf("", '0'), (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr21);
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
                    super.onCreate(bundle);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            char[] cArr = {0, 0, 0, 0};
            char[] cArr2 = {12119, 57302, 26473, 45153};
            try {
                byte b = PlaceComponentResult[25];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(cArr, cArr2, ((ApplicationInfo) cls.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.payment_success).substring(0, 1).codePointAt(0) + 24855), new char[]{33835, 30094, 52641, 43015, 32439, 2422, 41637, 30203, 46624, 27071, 63057, 37617, 18625, 13014, 53774, 59075, 32159, 62251, 44162, 20504, 17611, 20470, 6083, 3894, 34359, 4115}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                char[] cArr3 = {0, 0, 0, 0};
                char[] cArr4 = {19281, 9529, 19875, 35443};
                int myPid = Process.myPid() >> 22;
                try {
                    byte b3 = PlaceComponentResult[25];
                    byte b4 = b3;
                    Object[] objArr3 = new Object[1];
                    a(b3, b4, b4, objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    a((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], objArr4);
                    Object[] objArr5 = new Object[1];
                    b(cArr3, cArr4, myPid, (char) (((ApplicationInfo) cls3.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 29484), new char[]{17162, 63238, 64895, 31549, 10779, 25958, 48932, 33283, 34690, 48058, 21337, 54113, 6973, 13244, 29969, 64613, 19359, 59563}, objArr5);
                    baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 34 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr6 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 911, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{12119, 57302, 26473, 45153}, getPackageName().codePointAt(1) - 100, (char) (getPackageName().codePointAt(5) + 24825), new char[]{33835, 30094, 52641, 43015, 32439, 2422, 41637, 30203, 46624, 27071, 63057, 37617, 18625, 13014, 53774, 59075, 32159, 62251, 44162, 20504, 17611, 20470, 6083, 3894, 34359, 4115}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{19281, 9529, 19875, 35443}, (Process.getThreadPriority(0) + 20) >> 6, (char) (getPackageName().length() + 29510), new char[]{17162, 63238, 64895, 31549, 10779, 25958, 48932, 33283, 34690, 48058, 21337, 54113, 6973, 13244, 29969, 64613, 19359, 59563}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), (-16777181) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.argb(0, 0, 0, 0), 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) KeyEvent.getDeadChar(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public ZoomDialog() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.home.view.ZoomDialog$$ExternalSyntheticLambda3
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult permissionResult, boolean z) {
                ZoomDialog.this.m2631lambda$new$0$iddanahomeviewZoomDialog(permissionResult, z);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = builder.PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$id-dana-home-view-ZoomDialog  reason: not valid java name */
    public /* synthetic */ void m2631lambda$new$0$iddanahomeviewZoomDialog(PermissionResult permissionResult, boolean z) {
        if (permissionResult.MyBillsEntityDataFactory()) {
            getAuthRequestContext();
        }
    }

    public void displayQrImage(String str) {
        if (this.scheduleImpl) {
            this.layoutQrZoom.setVisibility(0);
            this.layoutBarcodeZoom.setVisibility(8);
            addDisposable(BarcodeUtil.BuiltInFictitiousFunctionClassFactory(str).subscribe(new Consumer() { // from class: id.dana.home.view.ZoomDialog$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ZoomDialog.this.m2628lambda$displayQrImageView$2$iddanahomeviewZoomDialog((Bitmap) obj);
                }
            }, new Consumer() { // from class: id.dana.home.view.ZoomDialog$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ZoomDialog.this.m2629lambda$displayQrImageView$3$iddanahomeviewZoomDialog((Throwable) obj);
                }
            }));
            this.tvCode.setText("");
            return;
        }
        this.layoutQrZoom.setVisibility(8);
        this.layoutBarcodeZoom.setVisibility(0);
        this.layoutBarcodeZoom.setRotation(90.0f);
        this.layoutBarcodeZoom.setScaleX(1.5f);
        this.layoutBarcodeZoom.setScaleY(1.5f);
        addDisposable(BarcodeUtil.BuiltInFictitiousFunctionClassFactory(str, 500).subscribe(new Consumer() { // from class: id.dana.home.view.ZoomDialog$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ZoomDialog.this.m2626lambda$displayBarcodeImageView$4$iddanahomeviewZoomDialog((Bitmap) obj);
            }
        }, new Consumer() { // from class: id.dana.home.view.ZoomDialog$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ZoomDialog.this.m2627lambda$displayBarcodeImageView$5$iddanahomeviewZoomDialog((Throwable) obj);
            }
        }));
        this.tvCode.setText(str);
    }

    private void getAuthRequestContext() {
        addDisposable(DanaScreenshotDetector.KClassImpl$Data$declaredNonStaticMembers$2(this).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.home.view.ZoomDialog$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ZoomDialog.this.m2630lambda$initScreenshotListener$1$iddanahomeviewZoomDialog((String) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$displayQrImageView$2$id-dana-home-view-ZoomDialog  reason: not valid java name */
    public /* synthetic */ void m2628lambda$displayQrImageView$2$iddanahomeviewZoomDialog(Bitmap bitmap) throws Exception {
        this.ivQrZoom.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$displayQrImageView$3$id-dana-home-view-ZoomDialog  reason: not valid java name */
    public /* synthetic */ void m2629lambda$displayQrImageView$3$iddanahomeviewZoomDialog(Throwable th) throws Exception {
        this.ivQrZoom.setImageBitmap(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$displayBarcodeImageView$4$id-dana-home-view-ZoomDialog  reason: not valid java name */
    public /* synthetic */ void m2626lambda$displayBarcodeImageView$4$iddanahomeviewZoomDialog(Bitmap bitmap) throws Exception {
        this.ivBarcodeZoom.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$displayBarcodeImageView$5$id-dana-home-view-ZoomDialog  reason: not valid java name */
    public /* synthetic */ void m2627lambda$displayBarcodeImageView$5$iddanahomeviewZoomDialog(Throwable th) throws Exception {
        this.ivBarcodeZoom.setImageBitmap(null);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(QrRefreshNotification.ACTION);
        registerReceiver(this.lookAheadTest, intentFilter);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        ContextUtils.MyBillsEntityDataFactory(this, this.lookAheadTest);
        super.onStop();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AppLifeCycleObserver appLifeCycleObserver = this.appLifeCycleObserver;
        if (appLifeCycleObserver != null) {
            try {
                appLifeCycleObserver.MyBillsEntityDataFactory.remove(this);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.rl_zoom})
    public void onParentLayoutClicked() {
        finish();
    }

    @Override // id.dana.AppLifeCycleObserver.KeyBoardOperationListener
    public void onHomeClicked() {
        this.offlinePayPresenter.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        byte b = 0;
        if (this.getErrorConfigVersion == null) {
            DaggerZoomDialogComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerZoomDialogComponent.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (PayQrModule) Preconditions.getAuthRequestContext(new PayQrModule(new PayQrContract.View() { // from class: id.dana.home.view.ZoomDialog.2
                @Override // id.dana.contract.payqr.PayQrContract.View
                public final void BuiltInFictitiousFunctionClassFactory() {
                }

                @Override // id.dana.contract.payqr.PayQrContract.View
                public final void BuiltInFictitiousFunctionClassFactory(String str) {
                }

                @Override // id.dana.contract.payqr.PayQrContract.View
                public final void MyBillsEntityDataFactory() {
                }

                @Override // id.dana.contract.payqr.PayQrContract.View
                public final void MyBillsEntityDataFactory(String str) {
                }

                @Override // id.dana.contract.payqr.PayQrContract.View
                public final void PlaceComponentResult() {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void dismissProgress() {
                }

                @Override // id.dana.contract.payqr.PayQrContract.View
                public final void getAuthRequestContext() {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void onError(String str) {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void showProgress() {
                }
            }));
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (OfflinePayModule) Preconditions.getAuthRequestContext(new OfflinePayModule(new OfflinePayContract.View() { // from class: id.dana.home.view.ZoomDialog.1
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public void dismissProgress() {
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public void onError(String str) {
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public void showProgress() {
                }

                @Override // id.dana.contract.payqr.OfflinePayContract.View
                public final void MyBillsEntityDataFactory(Boolean bool) {
                    if (bool.booleanValue()) {
                        ZoomDialog.this.payQrPresenter.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }
            }));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, PayQrModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, OfflinePayModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, ApplicationComponent.class);
            this.getErrorConfigVersion = new DaggerZoomDialogComponent.ZoomDialogComponentImpl(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, b);
        }
        this.getErrorConfigVersion.PlaceComponentResult(this);
        registerPresenter(this.payQrPresenter);
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(QR_BAR_CODE);
            this.scheduleImpl = intent.getBooleanExtra(QR_DISPLAYED, false);
            displayQrImage(stringExtra);
        }
        BrightnessUtil.KClassImpl$Data$declaredNonStaticMembers$2(this);
        if (OSUtil.MyBillsEntityDataFactory()) {
            getAuthRequestContext();
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.check();
        }
        if (this.lookAheadTest == null) {
            this.lookAheadTest = new QrRefreshNotification(this);
        }
        AppLifeCycleObserver appLifeCycleObserver = this.appLifeCycleObserver;
        if (appLifeCycleObserver != null) {
            appLifeCycleObserver.MyBillsEntityDataFactory.add(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initScreenshotListener$1$id-dana-home-view-ZoomDialog  reason: not valid java name */
    public /* synthetic */ void m2630lambda$initScreenshotListener$1$iddanahomeviewZoomDialog(String str) throws Exception {
        showWarningDialog(getString(R.string.screenshot_warning));
    }

    private static void b(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (DatabaseTableConfigUtil ^ 4360990799332652212L)) ^ ((int) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 4360990799332652212L))) ^ ((char) (GetContactSyncConfig ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}

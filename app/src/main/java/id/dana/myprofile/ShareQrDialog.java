package id.dana.myprofile;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.core.widget.NestedScrollView;
import androidx.view.ComponentActivity;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.QRView;
import id.dana.utils.BarcodeUtil;
import id.dana.utils.BrightnessUtil;
import id.dana.utils.FileUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.android.IntentUtil;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes2.dex */
public class ShareQrDialog extends BaseActivity {
    public static final String AVATAR_URL = "AVATAR_URI";
    public static final String KYC_STATUS = "KYC_STATUS";
    public static final String QR_CODE = "QR_CODE";
    public static final String USER_ID = "USER_ID";
    @BindView(R.id.button_share)
    Button buttonShare;
    @BindView(R.id.dana_logo_request_dana)
    ImageView ivDanaLogo;
    @BindView(R.id.static_qr_footer)
    LinearLayout layoutFooter;
    @BindView(R.id.layout_qr)
    QRView layoutQr;
    private final ActivityPermissionRequest lookAheadTest;
    @BindView(R.id.nsv_static_qr)
    NestedScrollView nsvStaticQr;
    @BindView(R.id.request_dana_note)
    TextView tvNote;
    @BindView(R.id.view_title)
    TextView tvQrTitle;
    @BindView(R.id.f4537tv_userid_static)
    TextView tvUserIDStatic;
    public static final byte[] $$a = {107, -40, -73, 40, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 222;
    public static final byte[] getAuthRequestContext = {4, -41, 37, 5, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 194;
    private static long getErrorConfigVersion = -2107979093775196930L;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 97
            byte[] r0 = id.dana.myprofile.ShareQrDialog.getAuthRequestContext
            int r7 = r7 + 16
            int r6 = r6 + 4
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r8
            r4 = 0
            r8 = r7
            r7 = r6
            goto L2a
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2a:
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + (-4)
            int r7 = r7 + 1
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.ShareQrDialog.b(int, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 2
            int r7 = 103 - r7
            int r9 = 47 - r9
            byte[] r0 = id.dana.myprofile.ShareQrDialog.$$a
            int r8 = r8 * 3
            int r8 = r8 + 21
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L18
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L18:
            r3 = 0
        L19:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            r3 = r0[r9]
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L32:
            int r9 = r9 + r8
            int r8 = r10 + 1
            int r9 = r9 + (-7)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.ShareQrDialog.c(int, short, int, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((-1) - TextUtils.lastIndexOf("", '0'), new char[]{11762, 11667, 'p', 4360, 56928, 64552, 49242, 62314, 27077, 17423, 39624, 47086, 42285, 35005, 22234, 31736, 57480, 53113, 4991, 49269, 15585, 13069}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(TextUtils.getTrimmedLength(""), new char[]{43176, 43205, 40695, 36760, 33292, 41077, 13728, 1675, 60564}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, KeyEvent.keyCodeFromString("") + 35, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(ViewConfiguration.getDoubleTapTimeout() >> 16, new char[]{14691, 14676, 64485, 60048, 33453, 41143, 1015, 12429, 32011, 49050, 50698, 29781, 45540, 29491, 2568, 47203, 62478, 13500, 20402, 907, 10290, 51415, 37645, 18228, 27839, 35901, 55088, 35643, 41751, 16773, 7347, 52929, 59193, 1418, 41026, 4664, 7066, 55664, 58473, 21964, 24093, 37511, 10699, 39325, 37412, 22128, 27935, 56691, 54985, 60029, 45429, 8344}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((-1) - TextUtils.lastIndexOf("", '0'), new char[]{43666, 43763, 14972, 11103, 1543, 9245, 10718, 6904, 61100, 32264, 17065, 24188, 8774, 45818, 36600, 37401, 26622, 62832, 51992, 10656, 48064, 2331, 6135, 27981, 65358, 19872, 21455, 41239, 12468, 32795, 38936, 58601, 29890, 50245, 9403, 14406, 34865, 6381, 24773, 32740, 52713, 21266, 44393, 46007, 471, 38889, 59876, 63325, 17721, 11190, 13784, 2787, 40577, 28250, 29286, 20101, 53971, 41702, 48777, 33365, 5746, 59016, 64130, 55726, 43915, 14681, 1837, 7559}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{4423, 4469, 13964, 10155, 20730, 29363, 59057, 54673, 21798, 29426, 5125, 37151, 39375, 48725, 55383, 23922, 56446, 63878, 40375, 59084, 'F', 1464, 16651, 41591, 17613, 16647, 1334, 28280, 35680, 36075, 52918, 11227, 53065, 51379, 29200, 63352, 13232, 5145, 13933, 45195, 30269, 24498, 64449, 31955, 47631, 39755, 48926, 14391, 65207, 10053, 25382, 50649, 9473, 25252, 9372, 33206, 26893, 44564, 59505, 19774, 44448, 60024, 44150, 5781, 4105, 13728, 20946, 53986}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((-1) - ((byte) KeyEvent.getModifierMetaStateMask()), new char[]{11704, 11728, 44257, 48515, 42717, 33925, 14270, 1164, 27027, 59607, 57902, 16395, 42348, 9252, 11831, 35885, 57502, 25577, 27609, 14214, 15549, 40852, 46973, 29567, 30817, 56126, 62229, 49002, 47055, 5840, 14552, 64158, 62388, 21134, 33888, 9825, 3865, 36391, 49164, 24978, 19139, 50626, 3500, 44491, 34473, 373, 18800, 59683, 49689, 48435, 38166, 5329, 6635, 63681, 53990, 20650, 22002, 13346, 7748, 40050, 37133, 28683, 23053, 51167}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(TextUtils.lastIndexOf("", '0', 0, 0) + 1, new char[]{47081, 47056, 48744, 44880, 10513, 2825, 38413, 42337, 62339, 64015}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(getAuthRequestContext[2], getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (-getAuthRequestContext[35]);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr14 = new Object[1];
                b(b, b2, (byte) (b2 | 8), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 55, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        Object[] objArr16 = new Object[1];
                        c($$a[12], $$a[78], $$a[53], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 15, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - Process.getGidForName(""), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 14, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getScrollBarSize() >> 8), 29 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (57995 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - MotionEvent.axisFromString(""), View.MeasureSpec.getSize(0) + 15, (char) Color.green(0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.normalizeMetaState(0), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-436867145, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, (ViewConfiguration.getEdgeSlop() >> 16) + 18, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[2], getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = (byte) (-getAuthRequestContext[35]);
                byte b4 = getAuthRequestContext[25];
                Object[] objArr20 = new Object[1];
                b(b3, b4, (byte) (b4 | 8), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 46 - (ViewConfiguration.getScrollBarSize() >> 8), (char) Color.argb(0, 0, 0, 0));
                        byte b5 = (byte) ($$a[78] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b5, b5, $$a[84], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 35 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-436867145, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getSize(0), TextUtils.lastIndexOf("", '0') + 19, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[2], getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b6 = (byte) (-getAuthRequestContext[35]);
                byte b7 = getAuthRequestContext[25];
                Object[] objArr26 = new Object[1];
                b(b6, b7, (byte) (b7 | 8), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - View.combineMeasuredStates(0, 0), 4 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 38967));
                        byte b8 = (byte) ($$a[78] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b8, b8, $$a[84], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 34, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-436867145, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[2], getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b9 = (byte) (-getAuthRequestContext[35]);
                byte b10 = getAuthRequestContext[25];
                Object[] objArr32 = new Object[1];
                b(b9, b10, (byte) (b10 | 8), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getScrollBarSize() >> 8), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 3, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))));
                        Object[] objArr34 = new Object[1];
                        c($$a[9], $$a[8], (byte) ($$a[78] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-436867145, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 912, 18 - View.getDefaultSize(0, 0), (char) KeyEvent.getDeadChar(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_share_static_qr;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        try {
            Object[] objArr2 = new Object[1];
            b(getAuthRequestContext[25], getAuthRequestContext[30], getAuthRequestContext[25], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[8], getAuthRequestContext[5], new Object[1]);
            Object[] objArr3 = new Object[1];
            a(((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{11762, 11667, 'p', 4360, 56928, 64552, 49242, 62314, 27077, 17423, 39624, 47086, 42285, 35005, 22234, 31736, 57480, 53113, 4991, 49269, 15585, 13069}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(getPackageName().codePointAt(1) - 100, new char[]{43176, 43205, 40695, 36760, 33292, 41077, 13728, 1675, 60564}, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    a((-1) - TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{10314, 10283, 5665, 1881, 29015, 21279, 20598, 25414, 27773, 21086, 13823, 10178, 41115, 40687, 63923, 60330, 58627, 55588, 48223, 20565, 14684, 9542, 24807, 5293, 32166, 25087, 9353, 55529, 45627, 44059}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a(getPackageName().length() - 7, new char[]{15139, 15168, 65410, 61153, 62688, 54974, 14858, 2362, 32542, 48097, 45134, 19921, 46051, 30551, 31758, 33169, 63048, 12446, 14846, 14889, 10796, 52473}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), ExpandableListView.getPackedPositionGroup(0L) + 35, (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        a(super.getResources().getString(R.string.group_send_type_bank).substring(4, 5).codePointAt(0) - 32, new char[]{14691, 14676, 64485, 60048, 33453, 41143, 1015, 12429, 32011, 49050, 50698, 29781, 45540, 29491, 2568, 47203, 62478, 13500, 20402, 907, 10290, 51415, 37645, 18228, 27839, 35901, 55088, 35643, 41751, 16773, 7347, 52929, 59193, 1418, 41026, 4664, 7066, 55664, 58473, 21964, 24093, 37511, 10699, 39325, 37412, 22128, 27935, 56691, 54985, 60029, 45429, 8344}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        a(getPackageName().codePointAt(1) - 100, new char[]{43666, 43763, 14972, 11103, 1543, 9245, 10718, 6904, 61100, 32264, 17065, 24188, 8774, 45818, 36600, 37401, 26622, 62832, 51992, 10656, 48064, 2331, 6135, 27981, 65358, 19872, 21455, 41239, 12468, 32795, 38936, 58601, 29890, 50245, 9403, 14406, 34865, 6381, 24773, 32740, 52713, 21266, 44393, 46007, 471, 38889, 59876, 63325, 17721, 11190, 13784, 2787, 40577, 28250, 29286, 20101, 53971, 41702, 48777, 33365, 5746, 59016, 64130, 55726, 43915, 14681, 1837, 7559}, objArr8);
                        String str2 = (String) objArr8[0];
                        try {
                            Object[] objArr9 = new Object[1];
                            b(getAuthRequestContext[25], getAuthRequestContext[30], getAuthRequestContext[25], objArr9);
                            Class<?> cls4 = Class.forName((String) objArr9[0]);
                            b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[8], getAuthRequestContext[5], new Object[1]);
                            Object[] objArr10 = new Object[1];
                            a(((ApplicationInfo) cls4.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{4423, 4469, 13964, 10155, 20730, 29363, 59057, 54673, 21798, 29426, 5125, 37151, 39375, 48725, 55383, 23922, 56446, 63878, 40375, 59084, 'F', 1464, 16651, 41591, 17613, 16647, 1334, 28280, 35680, 36075, 52918, 11227, 53065, 51379, 29200, 63352, 13232, 5145, 13933, 45195, 30269, 24498, 64449, 31955, 47631, 39755, 48926, 14391, 65207, 10053, 25382, 50649, 9473, 25252, 9372, 33206, 26893, 44564, 59505, 19774, 44448, 60024, 44150, 5781, 4105, 13728, 20946, 53986}, objArr10);
                            String str3 = (String) objArr10[0];
                            Object[] objArr11 = new Object[1];
                            a(super.getResources().getString(R.string.trending_section_title).substring(0, 1).length() - 1, new char[]{11704, 11728, 44257, 48515, 42717, 33925, 14270, 1164, 27027, 59607, 57902, 16395, 42348, 9252, 11831, 35885, 57502, 25577, 27609, 14214, 15549, 40852, 46973, 29567, 30817, 56126, 62229, 49002, 47055, 5840, 14552, 64158, 62388, 21134, 33888, 9825, 3865, 36391, 49164, 24978, 19139, 50626, 3500, 44491, 34473, 373, 18800, 59683, 49689, 48435, 38166, 5329, 6635, 63681, 53990, 20650, 22002, 13346, 7748, 40050, 37133, 28683, 23053, 51167}, objArr11);
                            String str4 = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            a(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1, new char[]{47081, 47056, 48744, 44880, 10513, 2825, 38413, 42337, 62339, 64015}, objArr12);
                            try {
                                Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - MotionEvent.axisFromString(""), 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr13);
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
                Object[] objArr14 = new Object[1];
                b(getAuthRequestContext[2], getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr14);
                Class<?> cls5 = Class.forName((String) objArr14[0]);
                byte b = (byte) (-getAuthRequestContext[35]);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr15 = new Object[1];
                b(b, b2, (byte) (b2 | 8), objArr15);
                try {
                    Object[] objArr16 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776722) - Color.rgb(0, 0, 0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 4, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        Object[] objArr17 = new Object[1];
                        c($$a[9], $$a[8], (byte) ($$a[78] - 1), objArr17);
                        obj3 = cls6.getMethod((String) objArr17[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                    int i = ((int[]) objArr18[1])[0];
                    if (((int[]) objArr18[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, View.resolveSizeAndState(0, 0, 0) + 35, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr19 = {705293980, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getEdgeSlop() >> 16), 18 - KeyEvent.keyCodeFromString(""), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr19);
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
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(View.MeasureSpec.getMode(0), new char[]{10314, 10283, 5665, 1881, 29015, 21279, 20598, 25414, 27773, 21086, 13823, 10178, 41115, 40687, 63923, 60330, 58627, 55588, 48223, 20565, 14684, 9542, 24807, 5293, 32166, 25087, 9353, 55529, 45627, 44059}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(getPackageName().length() - 7, new char[]{15139, 15168, 65410, 61153, 62688, 54974, 14858, 2362, 32542, 48097, 45134, 19921, 46051, 30551, 31758, 33169, 63048, 12446, 14846, 14889, 10796, 52473}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 18 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(Process.myPid() >> 22, new char[]{10314, 10283, 5665, 1881, 29015, 21279, 20598, 25414, 27773, 21086, 13823, 10178, 41115, 40687, 63923, 60330, 58627, 55588, 48223, 20565, 14684, 9542, 24807, 5293, 32166, 25087, 9353, 55529, 45627, 44059}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.add_new_debit_card).substring(0, 6).codePointAt(3) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS, new char[]{15139, 15168, 65410, 61153, 62688, 54974, 14858, 2362, 32542, 48097, 45134, 19921, 46051, 30551, 31758, 33169, 63048, 12446, 14846, 14889, 10796, 52473}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0', 0, 0) + 36, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 911, (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public ShareQrDialog() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.myprofile.ShareQrDialog$$ExternalSyntheticLambda0
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult permissionResult, boolean z) {
                ShareQrDialog.this.m2694lambda$new$0$iddanamyprofileShareQrDialog(permissionResult, z);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.lookAheadTest = builder.PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$id-dana-myprofile-ShareQrDialog  reason: not valid java name */
    public /* synthetic */ void m2694lambda$new$0$iddanamyprofileShareQrDialog(PermissionResult permissionResult, boolean z) {
        if (permissionResult.MyBillsEntityDataFactory()) {
            BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        BrightnessUtil.KClassImpl$Data$declaredNonStaticMembers$2(this);
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("USER_ID");
            String stringExtra2 = intent.getStringExtra("QR_CODE");
            String stringExtra3 = intent.getStringExtra(KYC_STATUS);
            String stringExtra4 = intent.getStringExtra(AVATAR_URL);
            this.tvUserIDStatic.setText(stringExtra);
            this.layoutQr.setKycView(stringExtra3);
            this.layoutQr.displayUserAvatar(stringExtra4);
            this.layoutQr.showSkeleton();
            addDisposable(BarcodeUtil.BuiltInFictitiousFunctionClassFactory(stringExtra2).subscribe(new Consumer() { // from class: id.dana.myprofile.ShareQrDialog$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ShareQrDialog.this.m2692lambda$displayQrImageView$1$iddanamyprofileShareQrDialog((Bitmap) obj);
                }
            }, new Consumer() { // from class: id.dana.myprofile.ShareQrDialog$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ShareQrDialog.this.m2693lambda$displayQrImageView$2$iddanamyprofileShareQrDialog((Throwable) obj);
                }
            }));
        }
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        try {
            Intent authRequestContext = IntentUtil.getAuthRequestContext(FileProvider.getUriForFile(getApplicationContext(), "id.dana.provider", getStaticQrCode()));
            Intent createChooser = Intent.createChooser(authRequestContext, getString(R.string.share_via));
            if (authRequestContext.resolveActivity(getPackageManager()) != null) {
                startActivity(createChooser);
            } else {
                Toast.makeText(this, getString(R.string.share_qr_failed), 0).show();
            }
        } catch (IllegalArgumentException unused) {
            Toast.makeText(this, getString(R.string.share_qr_failed), 0).show();
        } catch (Exception unused2) {
            Toast.makeText(this, getString(R.string.share_qr_failed), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$displayQrImageView$1$id-dana-myprofile-ShareQrDialog  reason: not valid java name */
    public /* synthetic */ void m2692lambda$displayQrImageView$1$iddanamyprofileShareQrDialog(Bitmap bitmap) throws Exception {
        this.layoutQr.hideSkeleton();
        this.layoutQr.getQrImageView().setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$displayQrImageView$2$id-dana-myprofile-ShareQrDialog  reason: not valid java name */
    public /* synthetic */ void m2693lambda$displayQrImageView$2$iddanamyprofileShareQrDialog(Throwable th) throws Exception {
        this.layoutQr.hideSkeleton();
        this.layoutQr.getQrImageView().setImageBitmap(null);
    }

    public File getStaticQrCode() {
        this.layoutFooter.setVisibility(0);
        this.buttonShare.setVisibility(8);
        InstrumentInjector.Resources_setImageResource(this.ivDanaLogo, R.drawable.ic_info);
        View childAt = this.nsvStaticQr.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i = layoutParams.bottomMargin;
        int i2 = layoutParams.topMargin;
        int height = childAt.getHeight();
        NestedScrollView nestedScrollView = this.nsvStaticQr;
        Bitmap authRequestContext = FileUtil.getAuthRequestContext(nestedScrollView, nestedScrollView.getWidth(), height + i + i2);
        this.buttonShare.setVisibility(0);
        this.layoutFooter.setVisibility(8);
        InstrumentInjector.Resources_setImageResource(this.ivDanaLogo, R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2);
        return FileUtil.PlaceComponentResult(getApplicationContext(), "shareqr", authRequestContext);
    }

    @OnClick({R.id.button_share})
    public void onShareButtonClick(View view) {
        if (OSUtil.MyBillsEntityDataFactory()) {
            BuiltInFictitiousFunctionClassFactory();
        } else {
            this.lookAheadTest.check();
        }
    }

    @OnClick({R.id.f3668cl_main_qr_profile})
    public void onParentClick(View view) {
        finish();
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(getErrorConfigVersion ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (getErrorConfigVersion ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
    }
}

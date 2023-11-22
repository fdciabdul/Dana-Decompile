package id.dana.lazada;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.plus.android.push.fcm.UtdidDeviceIdProvider;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerLazadaComponent;
import id.dana.di.component.LazadaComponent;
import id.dana.di.modules.LazadaModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.lazada.LazadaRegistrationUrl;
import id.dana.extension.ContextExtKt;
import id.dana.lazada.LazadaGuideContract;
import id.dana.lazada.model.MiniAppParamsModel;
import id.dana.lazada.tncagreement.LazadaTermsAndConditionActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.util.MinApiUtils;
import id.dana.utils.RandomInteger;
import id.dana.utils.UrlUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import net.sqlcipher.database.SQLiteDatabase;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes5.dex */
public class LazadaGuideActivity extends BaseActivity {
    private static char DatabaseTableConfigUtil;
    private static final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda1;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda2;
    private static char initRecordTimeStamp;
    private MiniAppParamsModel GetContactSyncConfig;
    private DanaLoadingDialog getErrorConfigVersion;
    @Inject
    LazadaGuideContract.Presenter lazadaPresenter;
    private LazadaRegistrationUrl lookAheadTest;
    @BindView(R.id.f4108res_0x7f0a10ca_groupdetailactivity_initdeletegroupdialog_1)
    View rootLayout;
    private LazadaComponent scheduleImpl;
    @BindView(R.id.tv_lazada_title)
    TextView tvLazadaTitle;
    @BindView(R.id.MissingMainCoroutineDispatcher)
    TextView tvTermsAndConditions;
    public static final byte[] $$a = {116, 15, TarHeader.LF_BLK, -20, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 183;
    public static final byte[] PlaceComponentResult = {113, -101, 105, Ascii.SUB, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 196;

    private static void b(short s, byte b, short s2, Object[] objArr) {
        int i = 106 - b;
        byte[] bArr = PlaceComponentResult;
        int i2 = 56 - s2;
        int i3 = s + 16;
        byte[] bArr2 = new byte[i3];
        int i4 = -1;
        int i5 = i3 - 1;
        if (bArr == null) {
            i2++;
            i = (i5 + (-i)) - 4;
            i5 = i5;
        }
        while (true) {
            i4++;
            bArr2[i4] = (byte) i;
            if (i4 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i6 = i;
            int i7 = i5;
            i2++;
            i = (i6 + (-bArr[i2])) - 4;
            i5 = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r9 = 47 - r9
            int r7 = r7 * 3
            int r7 = 42 - r7
            byte[] r0 = id.dana.lazada.LazadaGuideActivity.$$a
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L35
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r9]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L35:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            int r9 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lazada.LazadaGuideActivity.c(int, byte, byte, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        DatabaseTableConfigUtil = (char) 62465;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = (char) 6508;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = (char) 62666;
        initRecordTimeStamp = (char) 51595;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(18 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{32577, 50044, 62696, 39691, 37442, 46160, 7198, 47356, 27276, 33763, 14926, 52860, 216, 34385, 61561, 18309, 6177, 63836}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((ViewConfiguration.getLongPressTimeout() >> 16) + 5, new char[]{38954, 61521, 4909, 61811, 35177, 42740}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myTid() >> 22), 34 - ExpandableListView.getPackedPositionChild(0L), (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(KeyEvent.getDeadChar(0, 0) + 48, new char[]{9101, 21277, 64052, 8356, 44487, 11586, 24765, 13091, 19406, 16560, 27621, 64698, 2078, 63427, 56715, 42013, 30290, 26388, 45625, 51910, 46877, 36159, 37136, 16823, 47525, 32611, 51440, 46936, 62387, 36618, 31447, 19494, 2180, 4865, 10300, 3779, 10913, 9473, 60324, 9039, 58793, 9924, 6260, 31241, 13290, 38801, 25561, 23945}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(64 - (Process.myTid() >> 22), new char[]{3592, 28618, 43532, 59272, 10913, 9473, 65453, 6419, 46877, 36159, 63122, 11853, 26117, 48755, 46931, 51182, 36775, 9047, 42372, 47627, 26117, 48755, 48797, 17481, 20244, 44384, 52799, 29346, 51440, 46936, 36775, 9047, 30647, 2431, 9310, 55458, 42286, 20982, 17953, 2675, 2624, 35815, 56026, 64392, 19385, 57792, 33598, 18802, 50537, 38534, 46612, 38643, 39447, 57365, 5536, 2558, 5536, 2558, 18738, 56785, 52307, 59837, 47525, 32611}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(TextUtils.indexOf((CharSequence) "", '0') + 65, new char[]{18599, 19504, 28187, 17649, 39447, 57365, 49074, 63855, 47066, 11257, 45696, 37911, 5000, 40182, 14551, 13018, 31447, 19494, 21320, 12444, 43648, 36472, 27871, 33222, 58793, 9924, 24765, 13091, 62516, 17710, 9101, 21277, 14325, 44168, 59232, 48207, 18417, 25341, 64052, 8356, 44263, 49035, 46931, 51182, 60324, 9039, 34377, 16783, 10913, 9473, 61561, 18309, 18599, 19504, 57303, 53317, 2649, 45751, 2180, 4865, 57303, 53317, 58045, 55101}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 59, new char[]{12440, 36131, 59926, 33563, 58227, 25197, 5648, 21071, 33608, 63658, 63941, 7919, 33393, 5220, 64770, 62640, 55662, 30567, 44760, 62197, 27601, 7569, 16544, 25958, 53542, 20308, 43241, 43292, 39845, 39455, 56779, 1742, 43241, 43292, 35635, 32962, 48749, 63784, 60935, 7422, 20555, 46205, 35693, 5561, 29030, 46353, 36107, 45942, 2519, 27873, 10935, 54075, 16179, 26169, 40880, 30120, 'R', 33930, 37149, 6967}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(Color.rgb(0, 0, 0) + 16777222, new char[]{14958, 10966, 63917, 36702, 18599, 19504}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = PlaceComponentResult[25];
                Object[] objArr13 = new Object[1];
                b(b, b, (byte) (-PlaceComponentResult[31]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[9], (short) 30, objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 55, (ViewConfiguration.getTouchSlop() >> 8) + 3, (char) KeyEvent.getDeadChar(0, 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[68], $$a[47], (byte) (-$$a[53]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 800, 16 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 800, TextUtils.getCapsMode("", 0, 0) + 15, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 815, 29 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0') + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (ViewConfiguration.getWindowTouchSlop() >> 8)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1770663137, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 17, (char) TextUtils.getOffsetAfter("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b2 = PlaceComponentResult[25];
                Object[] objArr20 = new Object[1];
                b(b2, b2, (byte) (-PlaceComponentResult[31]), objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                Object[] objArr21 = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[9], (short) 30, objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), KeyEvent.keyCodeFromString("") + 46, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')));
                        Object[] objArr23 = new Object[1];
                        c((byte) (-$$a[8]), (byte) (-$$a[9]), $$a[20], objArr23);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getCapsMode("", 0, 0) + 35, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr25 = {-1770663137, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.argb(0, 0, 0, 0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) Color.green(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = PlaceComponentResult[25];
                Object[] objArr27 = new Object[1];
                b(b3, b3, (byte) (-PlaceComponentResult[31]), objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[9], (short) 30, objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 118, TextUtils.lastIndexOf("", '0') + 4, (char) (38968 - ((Process.getThreadPriority(0) + 20) >> 6)));
                        Object[] objArr30 = new Object[1];
                        c((byte) (-$$a[8]), (byte) (-$$a[9]), $$a[20], objArr30);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {-1770663137, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 912, 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = PlaceComponentResult[25];
                Object[] objArr34 = new Object[1];
                b(b4, b4, (byte) (-PlaceComponentResult[31]), objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                Object[] objArr35 = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[9], (short) 30, objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - TextUtils.indexOf("", ""), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 4, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)));
                        byte b5 = (byte) ($$a[47] - 1);
                        byte b6 = b5;
                        Object[] objArr37 = new Object[1];
                        c(b5, b6, b6, objArr37);
                        obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                    int i3 = ((int[]) objArr38[1])[0];
                    if (((int[]) objArr38[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), TextUtils.indexOf("", "") + 35, (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr39 = {-1770663137, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), 18 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_lazada;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.error_saving_unable_process).substring(33, 34).codePointAt(0) - 84, new char[]{32577, 50044, 62696, 39691, 37442, 46160, 7198, 47356, 20555, 46205, 41979, 47473, 18480, 64418, 36823, 8162, 14729, 29486, 48523, 3739, 43237, 18877, 769, 38145, 15816, 2791}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.twilio_intro_3_description).substring(74, 76).codePointAt(0) - 14, new char[]{35769, 4198, 35813, 23187, 'R', 33930, 27427, 32813, 1167, 43585, 65467, 26325, 24709, 59186, 36823, 8162, 46241, 42924}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (KeyEvent.getMaxKeyCode() >> 16), 34 - MotionEvent.axisFromString(""), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), TextUtils.getTrimmedLength("") + 18, (char) Drawable.resolveOpacity(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    static {
        getAuthRequestContext();
        NetworkUserEntityData$$ExternalSyntheticLambda0 = RandomInteger.BuiltInFictitiousFunctionClassFactory();
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, LazadaGuideActivity.class);
    }

    public static Intent createIntent(Context context, MiniAppParamsModel miniAppParamsModel) {
        Intent intent = new Intent(context, LazadaGuideActivity.class);
        intent.putExtra("KEY_MINI_APP_PARAMS", miniAppParamsModel);
        return intent;
    }

    public static PendingIntent createPendingIntent(Context context) {
        return PendingIntent.getActivity(context, 0, createIntent(context).setFlags(603979776), MinApiUtils.PlaceComponentResult() ? 301989888 : SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(18 - Color.red(0), new char[]{32577, 50044, 62696, 39691, 37442, 46160, 7198, 47356, 27276, 33763, 14926, 52860, 216, 34385, 61561, 18309, 6177, 63836}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(getPackageName().codePointAt(0) - 100, new char[]{38954, 61521, 4909, 61811, 35177, 42740}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(TextUtils.indexOf((CharSequence) "", '0', 0) + 27, new char[]{32577, 50044, 62696, 39691, 37442, 46160, 7198, 47356, 20555, 46205, 41979, 47473, 18480, 64418, 36823, 8162, 14729, 29486, 48523, 3739, 43237, 18877, 769, 38145, 15816, 2791}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(18 - ExpandableListView.getPackedPositionGroup(0L), new char[]{35769, 4198, 35813, 23187, 'R', 33930, 27427, 32813, 1167, 43585, 65467, 26325, 24709, 59186, 36823, 8162, 46241, 42924}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Gravity.getAbsoluteGravity(0, 0), (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(super.getResources().getString(R.string.mybills_detail_label_energy_total).substring(0, 11).length() + 37, new char[]{9101, 21277, 64052, 8356, 44487, 11586, 24765, 13091, 19406, 16560, 27621, 64698, 2078, 63427, 56715, 42013, 30290, 26388, 45625, 51910, 46877, 36159, 37136, 16823, 47525, 32611, 51440, 46936, 62387, 36618, 31447, 19494, 2180, 4865, 10300, 3779, 10913, 9473, 60324, 9039, 58793, 9924, 6260, 31241, 13290, 38801, 25561, 23945}, objArr6);
                    String str = (String) objArr6[0];
                    try {
                        Object[] objArr7 = new Object[1];
                        b(PlaceComponentResult[30], (byte) (-PlaceComponentResult[32]), (byte) (PlaceComponentResult[49] - 1), objArr7);
                        Class<?> cls3 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        b(PlaceComponentResult[8], PlaceComponentResult[48], PlaceComponentResult[25], objArr8);
                        Object[] objArr9 = new Object[1];
                        a(((ApplicationInfo) cls3.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 31, new char[]{3592, 28618, 43532, 59272, 10913, 9473, 65453, 6419, 46877, 36159, 63122, 11853, 26117, 48755, 46931, 51182, 36775, 9047, 42372, 47627, 26117, 48755, 48797, 17481, 20244, 44384, 52799, 29346, 51440, 46936, 36775, 9047, 30647, 2431, 9310, 55458, 42286, 20982, 17953, 2675, 2624, 35815, 56026, 64392, 19385, 57792, 33598, 18802, 50537, 38534, 46612, 38643, 39447, 57365, 5536, 2558, 5536, 2558, 18738, 56785, 52307, 59837, 47525, 32611}, objArr9);
                        String str2 = (String) objArr9[0];
                        try {
                            Object[] objArr10 = new Object[1];
                            b(PlaceComponentResult[30], (byte) (-PlaceComponentResult[32]), (byte) (PlaceComponentResult[49] - 1), objArr10);
                            Class<?> cls4 = Class.forName((String) objArr10[0]);
                            Object[] objArr11 = new Object[1];
                            b(PlaceComponentResult[8], PlaceComponentResult[48], PlaceComponentResult[25], objArr11);
                            Object[] objArr12 = new Object[1];
                            a(((ApplicationInfo) cls4.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 31, new char[]{18599, 19504, 28187, 17649, 39447, 57365, 49074, 63855, 47066, 11257, 45696, 37911, 5000, 40182, 14551, 13018, 31447, 19494, 21320, 12444, 43648, 36472, 27871, 33222, 58793, 9924, 24765, 13091, 62516, 17710, 9101, 21277, 14325, 44168, 59232, 48207, 18417, 25341, 64052, 8356, 44263, 49035, 46931, 51182, 60324, 9039, 34377, 16783, 10913, 9473, 61561, 18309, 18599, 19504, 57303, 53317, 2649, 45751, 2180, 4865, 57303, 53317, 58045, 55101}, objArr12);
                            String str3 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            a(super.getResources().getString(R.string.view).substring(1, 2).length() + 59, new char[]{12440, 36131, 59926, 33563, 58227, 25197, 5648, 21071, 33608, 63658, 63941, 7919, 33393, 5220, 64770, 62640, 55662, 30567, 44760, 62197, 27601, 7569, 16544, 25958, 53542, 20308, 43241, 43292, 39845, 39455, 56779, 1742, 43241, 43292, 35635, 32962, 48749, 63784, 60935, 7422, 20555, 46205, 35693, 5561, 29030, 46353, 36107, 45942, 2519, 27873, 10935, 54075, 16179, 26169, 40880, 30120, 'R', 33930, 37149, 6967}, objArr13);
                            String str4 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            a(super.getResources().getString(R.string.invite_your_friend_below).substring(12, 13).codePointAt(0) - 26, new char[]{14958, 10966, 63917, 36702, 18599, 19504}, objArr14);
                            try {
                                Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 18 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                } catch (Throwable th4) {
                    Throwable cause4 = th4.getCause();
                    if (cause4 == null) {
                        throw th4;
                    }
                    throw cause4;
                }
            }
        }
        try {
            byte b = PlaceComponentResult[25];
            Object[] objArr16 = new Object[1];
            b(b, b, (byte) (-PlaceComponentResult[31]), objArr16);
            Class<?> cls5 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            b(PlaceComponentResult[25], PlaceComponentResult[9], (short) 30, objArr17);
            try {
                Object[] objArr18 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 4 - (ViewConfiguration.getTapTimeout() >> 16), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1));
                    byte b2 = (byte) ($$a[47] - 1);
                    byte b3 = b2;
                    Object[] objArr19 = new Object[1];
                    c(b2, b3, b3, objArr19);
                    obj3 = cls6.getMethod((String) objArr19[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                int i = ((int[]) objArr20[1])[0];
                if (((int[]) objArr20[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.keyCodeFromString(""), 36 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr21 = {1393884292, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 911, Color.alpha(0) + 18, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr21);
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
                }
                overridePendingTransition(0, 0);
                super.onCreate(bundle);
                ContextExtKt.PlaceComponentResult(this);
                View view = this.rootLayout;
                if (view != null) {
                    view.setVisibility(8);
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
            a(super.getResources().getString(R.string.unsafe_device_tamper_image_title).substring(5, 6).codePointAt(0) - 71, new char[]{32577, 50044, 62696, 39691, 37442, 46160, 7198, 47356, 20555, 46205, 41979, 47473, 18480, 64418, 36823, 8162, 14729, 29486, 48523, 3739, 43237, 18877, 769, 38145, 15816, 2791}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(18 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new char[]{35769, 4198, 35813, 23187, 'R', 33930, 27427, 32813, 1167, 43585, 65467, 26325, 24709, 59186, 36823, 8162, 46241, 42924}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), 35 - Drawable.resolveOpacity(0, 0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 911, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        overridePendingTransition(0, 0);
        super.onPause();
    }

    @OnClick({R.id.btn_refuse})
    public void refuseRegisterLazada() {
        PlaceComponentResult(Boolean.FALSE);
        finish();
    }

    @OnClick({R.id.btn_agree})
    public void agreeRegisterLazada() {
        PlaceComponentResult(Boolean.TRUE);
        this.lazadaPresenter.MyBillsEntityDataFactory();
        BuiltInFictitiousFunctionClassFactory();
    }

    private void PlaceComponentResult(Boolean bool) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.HOME_POP_UP_ACTION;
        EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.IS_CONFIRM, bool.booleanValue());
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(BuiltInFictitiousFunctionClassFactory, (byte) 0));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (PlaceComponentResult(i, intent)) {
            this.lazadaPresenter.MyBillsEntityDataFactory();
            BuiltInFictitiousFunctionClassFactory();
        }
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        MiniAppParamsModel miniAppParamsModel = this.GetContactSyncConfig;
        if (miniAppParamsModel != null && !TextUtils.isEmpty(miniAppParamsModel.PlaceComponentResult)) {
            this.lazadaPresenter.getAuthRequestContext(this.GetContactSyncConfig);
            return;
        }
        LazadaRegistrationUrl lazadaRegistrationUrl = this.lookAheadTest;
        if (lazadaRegistrationUrl != null) {
            this.lazadaPresenter.getAuthRequestContext(MiniAppParamsModel.BuiltInFictitiousFunctionClassFactory(lazadaRegistrationUrl.getRedirectUrl()));
        } else {
            showWarningDialog(getString(R.string.home_error), new LazadaGuideActivity$$ExternalSyntheticLambda1(this));
        }
    }

    public void showDanaLoadingDialog() {
        DanaLoadingDialog danaLoadingDialog = new DanaLoadingDialog(this);
        this.getErrorConfigVersion = danaLoadingDialog;
        if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            return;
        }
        danaLoadingDialog.MyBillsEntityDataFactory.show();
        danaLoadingDialog.getAuthRequestContext.startRefresh();
    }

    public void dismissDanaLoadingDialog() {
        DanaLoadingDialog danaLoadingDialog = this.getErrorConfigVersion;
        if (danaLoadingDialog != null) {
            danaLoadingDialog.PlaceComponentResult();
        }
    }

    private static boolean PlaceComponentResult(int i, Intent intent) {
        return intent != null && NetworkUserEntityData$$ExternalSyntheticLambda0 == i && intent.getBooleanExtra(LazadaTermsAndConditionActivity.LAZADA_TNC_ACTION_RESULT, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showGeneralError$0$id-dana-lazada-LazadaGuideActivity  reason: not valid java name */
    public /* synthetic */ void m2641lambda$showGeneralError$0$iddanalazadaLazadaGuideActivity(DialogInterface dialogInterface) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showWarningDialogForFailGetRedirectUrl$1$id-dana-lazada-LazadaGuideActivity  reason: not valid java name */
    public /* synthetic */ void m2642xb8257ae6(DialogInterface dialogInterface) {
        finish();
    }

    static /* synthetic */ void access$000(LazadaGuideActivity lazadaGuideActivity, boolean z) {
        if (z) {
            lazadaGuideActivity.BuiltInFictitiousFunctionClassFactory();
            return;
        }
        View view = lazadaGuideActivity.rootLayout;
        if (view != null) {
            view.setVisibility(0);
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(lazadaGuideActivity);
            builder.MyBillsEntityDataFactory = TrackerKey.Event.HOME_POP_UP_OPEN;
            EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Purpose", "Lazada Registration");
            MyBillsEntityDataFactory.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
        }
    }

    static /* synthetic */ void access$100(LazadaGuideActivity lazadaGuideActivity, LazadaRegistrationUrl lazadaRegistrationUrl) {
        lazadaGuideActivity.lookAheadTest = lazadaRegistrationUrl;
        if (lazadaRegistrationUrl == null || lazadaGuideActivity.tvLazadaTitle == null) {
            return;
        }
        if (lazadaRegistrationUrl != null) {
            String userConsentMessage = lazadaRegistrationUrl.getUserConsentMessage();
            if (!TextUtils.isEmpty(userConsentMessage)) {
                lazadaGuideActivity.tvLazadaTitle.setText(userConsentMessage);
            }
        }
        lazadaGuideActivity.lazadaPresenter.getAuthRequestContext();
    }

    static /* synthetic */ void access$200(final LazadaGuideActivity lazadaGuideActivity, String str) {
        lazadaGuideActivity.showWarningDialog(str, new DialogInterface.OnDismissListener() { // from class: id.dana.lazada.LazadaGuideActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                LazadaGuideActivity.this.m2642xb8257ae6(dialogInterface);
            }
        });
    }

    static /* synthetic */ void access$300(LazadaGuideActivity lazadaGuideActivity) {
        lazadaGuideActivity.showWarningDialog(lazadaGuideActivity.getString(R.string.home_error), new LazadaGuideActivity$$ExternalSyntheticLambda1(lazadaGuideActivity));
    }

    static /* synthetic */ void access$400(LazadaGuideActivity lazadaGuideActivity) {
        lazadaGuideActivity.startActivityForResult(LazadaTermsAndConditionActivity.returnAgreeToTncResult(lazadaGuideActivity), NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        if (this.scheduleImpl == null) {
            DaggerLazadaComponent.Builder PlaceComponentResult2 = DaggerLazadaComponent.PlaceComponentResult();
            PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = (LazadaModule) Preconditions.getAuthRequestContext(new LazadaModule(new LazadaGuideContract.View() { // from class: id.dana.lazada.LazadaGuideActivity.1
                @Override // id.dana.lazada.LazadaGuideContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
                    LazadaGuideActivity.access$000(LazadaGuideActivity.this, z);
                }

                @Override // id.dana.lazada.LazadaGuideContract.View
                public final void MyBillsEntityDataFactory(LazadaRegistrationUrl lazadaRegistrationUrl) {
                    LazadaGuideActivity.access$100(LazadaGuideActivity.this, lazadaRegistrationUrl);
                }

                @Override // id.dana.lazada.LazadaGuideContract.View
                public final void getAuthRequestContext(String str) {
                    LazadaGuideActivity.access$200(LazadaGuideActivity.this, str);
                }

                @Override // id.dana.lazada.LazadaGuideContract.View
                public final void BuiltInFictitiousFunctionClassFactory(String str) {
                    DanaH5.startContainerFullUrl(UrlUtil.getAuthRequestContext(str));
                    LazadaGuideActivity.this.finish();
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void showProgress() {
                    LazadaGuideActivity.this.showDanaLoadingDialog();
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void dismissProgress() {
                    LazadaGuideActivity.this.dismissDanaLoadingDialog();
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public void onError(String str) {
                    LazadaGuideActivity.access$300(LazadaGuideActivity.this);
                }
            }));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, LazadaModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
            this.scheduleImpl = new DaggerLazadaComponent.LazadaComponentImpl(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
        }
        this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.GetContactSyncConfig = (MiniAppParamsModel) intent.getParcelableExtra("KEY_MINI_APP_PARAMS");
        }
        String string = getString(R.string.lazada_desc);
        String string2 = getString(R.string.lazada_desc_item_click);
        int indexOf = string.indexOf(string2);
        if (indexOf != -1) {
            ClickableSpan clickableSpan = new ClickableSpan() { // from class: id.dana.lazada.LazadaGuideActivity.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    LazadaGuideActivity.access$400(LazadaGuideActivity.this);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            };
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(clickableSpan, indexOf, string2.length() + indexOf, 33);
            spannableString.setSpan(new ForegroundColorSpan(-15692055), indexOf, string2.length() + indexOf, 33);
            spannableString.setSpan(new StyleSpan(1), indexOf, string2.length() + indexOf, 33);
            this.tvTermsAndConditions.setText(spannableString);
            this.tvTermsAndConditions.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.lazadaPresenter.BuiltInFictitiousFunctionClassFactory(UtdidDeviceIdProvider.getDeviceId(getApplication()), "lazada");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            int i2 = 58224;
            for (int i3 = 0; i3 < 16; i3++) {
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (initRecordTimeStamp ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (DatabaseTableConfigUtil ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}

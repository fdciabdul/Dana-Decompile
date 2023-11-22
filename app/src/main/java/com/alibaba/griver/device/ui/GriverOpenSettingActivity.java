package com.alibaba.griver.device.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
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
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.service.LocalAuthPermissionManager;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.api.constants.GriverLaunchParams;
import com.alibaba.griver.api.ui.auth.GriverOpenAuthExtension;
import com.alibaba.griver.base.common.account.GriverAccount;
import com.alibaba.griver.base.common.utils.APIContextUtils;
import com.alibaba.griver.device.adapter.GriverOpenSettingListAdapter;
import com.alibaba.griver.device.model.OpenSettingItem;
import com.alibaba.griver.device.model.SerializableMap;
import com.alibaba.griver.image.framework.encode.APEncodeOptions;
import com.alibaba.griver.ui.ant.AUTitleBar;
import com.alibaba.wireless.security.SecExceptionCode;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.domain.notificationcenter.interactor.ConnectionType;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.tracker.mixpanel.RegistrationEvent;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes6.dex */
public class GriverOpenSettingActivity extends Activity {
    private static int[] getAuthRequestContext;

    /* renamed from: o  reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f6532o;
    private AppModel c;
    private String d;
    private GriverOpenSettingListAdapter f;
    private LinearLayout h;
    private RelativeLayout i;
    private RecyclerView j;
    private TextView k;
    private AUTitleBar l;
    private LinearLayout m;
    private TextView n;
    public static final byte[] $$a = {76, 9, -56, 93, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 75;
    public static final byte[] PlaceComponentResult = {Ascii.ESC, 47, Ascii.SUB, Ascii.GS, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int BuiltInFictitiousFunctionClassFactory = 92;

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Boolean> f6533a = new HashMap();
    private Map<String, Boolean> b = new HashMap();
    private String e = "Mini Program";
    private List<OpenSettingItem> g = new ArrayList();

    static void BuiltInFictitiousFunctionClassFactory() {
        getAuthRequestContext = new int[]{1785103533, 323454910, 125969976, -568334880, -1786964786, 1755310331, -1075267225, 615177754, -230467518, 611051089, -1530051190, -1310657643, 138138668, -373093339, -662697227, 1180868153, 716949812, -938206364};
    }

    private static void q(byte b, int i, short s, Object[] objArr) {
        byte[] bArr = PlaceComponentResult;
        int i2 = b + 97;
        int i3 = 55 - i;
        int i4 = 23 - s;
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            int i7 = (i6 + (-i3)) - 4;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i3 = i3;
            i2 = i7;
        }
        while (true) {
            int i8 = i5 + 1;
            bArr2[i8] = (byte) i2;
            int i9 = i3 + 1;
            if (i8 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i8;
            i3 = i9;
            i2 = (i2 + (-bArr[i9])) - 4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void r(short r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.alibaba.griver.device.ui.GriverOpenSettingActivity.$$a
            int r7 = 46 - r7
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r9 = r9 * 3
            int r9 = r9 + 21
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L35
        L19:
            r3 = 0
        L1a:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            int r7 = r7 + 1
            if (r4 != r9) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.device.ui.GriverOpenSettingActivity.r(short, byte, byte, java.lang.Object[]):void");
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        p(18 - (ViewConfiguration.getFadingEdgeLength() >> 16), new int[]{1611219908, -1747655900, -395651990, 1494289726, -1802103648, 968823199, -1723247617, -548682663, 1662010423, -736738343}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        p(View.combineMeasuredStates(0, 0) + 5, new int[]{932308870, -1689351065, -1487634918, 1869865345}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetAfter("", 0), 34 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    p(Color.rgb(0, 0, 0) + 16777264, new int[]{1856544218, 228210975, -830546848, -828651329, 1042932906, -1278859084, -341181541, 1765222840, 2077781411, -841987041, 1067899805, -1076776076, -1096051631, -1269182128, -1966516033, 960783827, 382721530, -2008745149, 1633502542, 144871666, 238690170, 836758849, -184497056, 116669884}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    p((ViewConfiguration.getKeyRepeatDelay() >> 16) + 64, new int[]{2045934748, -288311315, 817872755, -1058824341, 1942540566, -32377724, 1223419938, -327251878, -990867712, -1238325543, -1179318707, -1326312541, -722609110, 89883862, -296526849, 2058399529, -1006002865, -1589644245, 121561950, 1659024858, -741878609, -199154344, 1405042451, 1497783382, -1019464038, -2052542530, -358422098, 1246763120, 1304521736, -348679726, 411316692, -1384760438}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    p(64 - View.resolveSize(0, 0), new int[]{-646815578, 103468253, 635064673, -1587398950, 440449557, -267215307, 1253475854, 1679419609, 775532941, 911754137, 1036557702, -1721669390, 828867195, -879590677, -1252176958, 903583387, 238267864, -1077947696, 678169961, -1505182606, 479357131, 1160338590, -1478837426, -1558201472, -1215718811, -1826381232, 2092664254, -1457497205, 224058113, -1861652696, -553330135, -1636414002}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    p(View.MeasureSpec.getSize(0) + 60, new int[]{-1563414063, -813823263, 2139794454, -1071985449, -2112681806, -705663220, -1965488130, 1182905047, -1466169406, 829076010, 2122312102, -389227902, 612863771, 207248908, 630900387, 45387392, 1012108573, -1478023232, -265661357, -1154958109, -1053635075, -1140288017, -90417544, -2058781810, -1491458550, 1284349237, -1598926251, -51185755, -1460229936, -1046270935}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    p((ViewConfiguration.getPressedStateDuration() >> 16) + 6, new int[]{-1079900251, 483302972, 336325835, 1442159939}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.getDeadChar(0, 0), (KeyEvent.getMaxKeyCode() >> 16) + 18, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                q((byte) (-PlaceComponentResult[32]), (byte) (-PlaceComponentResult[31]), PlaceComponentResult[30], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory & 42);
                Object[] objArr14 = new Object[1];
                q(b, (byte) (b | 22), PlaceComponentResult[30], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 55, 3 - View.combineMeasuredStates(0, 0), (char) View.MeasureSpec.makeMeasureSpec(0, 0));
                        byte b2 = (byte) (-$$a[53]);
                        byte b3 = $$a[47];
                        Object[] objArr16 = new Object[1];
                        r(b2, b3, b3, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 15 - View.MeasureSpec.getMode(0), (char) (Process.myTid() >> 22))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - View.MeasureSpec.getMode(0), 29 - View.MeasureSpec.getSize(0), (char) (57994 - Color.blue(0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 800, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 15, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getEdgeSlop() >> 16), 35 - TextUtils.indexOf("", "", 0, 0), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-213020917, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, (Process.myTid() >> 22) + 18, (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                q((byte) (-PlaceComponentResult[32]), (byte) (-PlaceComponentResult[31]), PlaceComponentResult[30], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b4 = (byte) (BuiltInFictitiousFunctionClassFactory & 42);
                Object[] objArr20 = new Object[1];
                q(b4, (byte) (b4 | 22), PlaceComponentResult[30], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (KeyEvent.getMaxKeyCode() >> 16), 46 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
                        Object[] objArr22 = new Object[1];
                        r($$a[20], (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0, 0), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-213020917, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTapTimeout() >> 16), 18 - TextUtils.indexOf("", ""), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                q((byte) (-PlaceComponentResult[32]), (byte) (-PlaceComponentResult[31]), PlaceComponentResult[30], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = (byte) (BuiltInFictitiousFunctionClassFactory & 42);
                Object[] objArr26 = new Object[1];
                q(b5, (byte) (b5 | 22), PlaceComponentResult[30], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(119 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 3 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (38968 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))));
                        Object[] objArr28 = new Object[1];
                        r($$a[20], (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-213020917, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 911, MotionEvent.axisFromString("") + 19, (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                q((byte) (-PlaceComponentResult[32]), (byte) (-PlaceComponentResult[31]), PlaceComponentResult[30], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b6 = (byte) (BuiltInFictitiousFunctionClassFactory & 42);
                Object[] objArr32 = new Object[1];
                q(b6, (byte) (b6 | 22), PlaceComponentResult[30], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getJumpTapTimeout() >> 16), 4 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) KeyEvent.keyCodeFromString(""));
                        byte b7 = (byte) ($$a[47] - 1);
                        Object[] objArr34 = new Object[1];
                        r(b7, b7, (byte) (-$$a[8]), objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.combineMeasuredStates(0, 0), 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-213020917, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) KeyEvent.getDeadChar(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            p(super.getResources().getString(R.string.card_binding_desc_success_save_card_text).substring(9, 10).length() + 25, new int[]{1611219908, -1747655900, -395651990, 1494289726, -1374153295, 287033721, -228597402, -307571974, -1019318661, -1939846066, 262404735, -1587274024, 2083963247, 872954327}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            p(super.getResources().getString(R.string.reset_pin_input_confirm_pin_subtitle).substring(1, 3).length() + 16, new int[]{1546572643, 175103176, -383994491, 854261990, 955130033, -254921024, -1260704023, -1186423906, -1863289020, 1952771932}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSizeAndState(0, 0, 0), KeyEvent.normalizeMetaState(0) + 35, (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 17, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            p(super.getResources().getString(R.string.ss_please_select_base_path_with_storage_type_sd_card).substring(3, 4).length() + 25, new int[]{1611219908, -1747655900, -395651990, 1494289726, -1374153295, 287033721, -228597402, -307571974, -1019318661, -1939846066, 262404735, -1587274024, 2083963247, 872954327}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            p(super.getResources().getString(R.string.cashier_top_up_dialog_title).substring(4, 5).codePointAt(0) - 97, new int[]{1546572643, 175103176, -383994491, 854261990, 955130033, -254921024, -1260704023, -1186423906, -1863289020, 1952771932}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 910, ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        BuiltInFictitiousFunctionClassFactory();
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        f6532o = concurrentHashMap;
        concurrentHashMap.put("getLocation", "Location");
        concurrentHashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_USERLOCATION, "Location");
        concurrentHashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_RECORD, "Microphone");
        concurrentHashMap.put("scope.scan", RegistrationEvent.ProfilePhotoSource.CAMERA);
        concurrentHashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CAMERA, RegistrationEvent.ProfilePhotoSource.CAMERA);
        concurrentHashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CHOOSE_PHOTOS_ALBUM, "Album");
        concurrentHashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_BLUETOOTH, ConnectionType.BLUETOOTH);
        concurrentHashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CONTACT, "Contact");
        concurrentHashMap.put("scope.saveImage", "Album");
        concurrentHashMap.put("scope.stopAudioRecord", "Microphone");
        concurrentHashMap.put("scope.cancelAudioRecord", "Microphone");
        concurrentHashMap.put("scope.saveVideoToPhotosAlbum", "Album");
        concurrentHashMap.put("scope.shareTokenImageSilent", "Album");
        concurrentHashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_USERINFO, "UserInfo");
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        p(super.getResources().getString(R.string.request_money_add_bank_account_number_label).substring(10, 11).length() + 17, new int[]{1611219908, -1747655900, -395651990, 1494289726, -1802103648, 968823199, -1723247617, -548682663, 1662010423, -736738343}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        p((ViewConfiguration.getScrollBarSize() >> 8) + 5, new int[]{932308870, -1689351065, -1487634918, 1869865345}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                p(super.getResources().getString(R.string.mission_prize).substring(10, 11).length() + 25, new int[]{1611219908, -1747655900, -395651990, 1494289726, -1374153295, 287033721, -228597402, -307571974, -1019318661, -1939846066, 262404735, -1587274024, 2083963247, 872954327}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                p(super.getResources().getString(R.string.passkey_enrollment_failed_enrollment_desc_dialog).substring(21, 23).length() + 16, new int[]{1546572643, 175103176, -383994491, 854261990, 955130033, -254921024, -1260704023, -1186423906, -1863289020, 1952771932}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 35 - TextUtils.getCapsMode("", 0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    p(48 - (ViewConfiguration.getJumpTapTimeout() >> 16), new int[]{1856544218, 228210975, -830546848, -828651329, 1042932906, -1278859084, -341181541, 1765222840, 2077781411, -841987041, 1067899805, -1076776076, -1096051631, -1269182128, -1966516033, 960783827, 382721530, -2008745149, 1633502542, 144871666, 238690170, 836758849, -184497056, 116669884}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    p(getPackageName().length() + 57, new int[]{2045934748, -288311315, 817872755, -1058824341, 1942540566, -32377724, 1223419938, -327251878, -990867712, -1238325543, -1179318707, -1326312541, -722609110, 89883862, -296526849, 2058399529, -1006002865, -1589644245, 121561950, 1659024858, -741878609, -199154344, 1405042451, 1497783382, -1019464038, -2052542530, -358422098, 1246763120, 1304521736, -348679726, 411316692, -1384760438}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    p(super.getResources().getString(R.string.title_empty_search_beneficiary).substring(7, 8).codePointAt(0) - 36, new int[]{-646815578, 103468253, 635064673, -1587398950, 440449557, -267215307, 1253475854, 1679419609, 775532941, 911754137, 1036557702, -1721669390, 828867195, -879590677, -1252176958, 903583387, 238267864, -1077947696, 678169961, -1505182606, 479357131, 1160338590, -1478837426, -1558201472, -1215718811, -1826381232, 2092664254, -1457497205, 224058113, -1861652696, -553330135, -1636414002}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    p(getPackageName().length() + 53, new int[]{-1563414063, -813823263, 2139794454, -1071985449, -2112681806, -705663220, -1965488130, 1182905047, -1466169406, 829076010, 2122312102, -389227902, 612863771, 207248908, 630900387, 45387392, 1012108573, -1478023232, -265661357, -1154958109, -1053635075, -1140288017, -90417544, -2058781810, -1491458550, 1284349237, -1598926251, -51185755, -1460229936, -1046270935}, objArr9);
                    String str4 = (String) objArr9[0];
                    try {
                        byte b = PlaceComponentResult[25];
                        Object[] objArr10 = new Object[1];
                        q(b, (byte) (b | TarHeader.LF_BLK), PlaceComponentResult[25], objArr10);
                        Class<?> cls3 = Class.forName((String) objArr10[0]);
                        q(PlaceComponentResult[5], PlaceComponentResult[25], PlaceComponentResult[41], new Object[1]);
                        Object[] objArr11 = new Object[1];
                        p(((ApplicationInfo) cls3.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 27, new int[]{-1079900251, 483302972, 336325835, 1442159939}, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 911, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            Object[] objArr13 = new Object[1];
            q((byte) (-PlaceComponentResult[32]), (byte) (-PlaceComponentResult[31]), PlaceComponentResult[30], objArr13);
            Class<?> cls4 = Class.forName((String) objArr13[0]);
            byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory & 42);
            Object[] objArr14 = new Object[1];
            q(b2, (byte) (b2 | 22), PlaceComponentResult[30], objArr14);
            try {
                Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - KeyEvent.normalizeMetaState(0), 5 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1));
                    byte b3 = (byte) ($$a[47] - 1);
                    Object[] objArr16 = new Object[1];
                    r(b3, b3, (byte) (-$$a[8]), objArr16);
                    obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                int i = ((int[]) objArr17[1])[0];
                if (((int[]) objArr17[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), TextUtils.lastIndexOf("", '0') + 36, (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr18 = {-1025333088, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", ""), 18 - Color.alpha(0), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr18);
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
                setContentView(com.alibaba.griver.device.R.layout.griver_device_activity_open_setting);
                SerializableMap serializableMap = (SerializableMap) getIntent().getSerializableExtra("data");
                if (serializableMap != null) {
                    this.f6533a = serializableMap.getMap();
                }
                setStatusBar();
                AppModel appModel = (AppModel) getIntent().getSerializableExtra("appInfo");
                this.c = appModel;
                if (appModel != null) {
                    this.d = appModel.getAppId();
                    this.e = this.c.getAppInfoModel().getName();
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (this.f6533a.containsKey(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_USERLOCATION)) {
                    linkedHashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_USERLOCATION, this.f6533a.get(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_USERLOCATION));
                }
                if (this.f6533a.containsKey(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_WRITE_PHOTOS_ALBUM)) {
                    linkedHashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_WRITE_PHOTOS_ALBUM, this.f6533a.get(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_WRITE_PHOTOS_ALBUM));
                }
                if (this.f6533a.containsKey(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CHOOSE_PHOTOS_ALBUM)) {
                    linkedHashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CHOOSE_PHOTOS_ALBUM, this.f6533a.get(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CHOOSE_PHOTOS_ALBUM));
                }
                if (this.f6533a.containsKey(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CAMERA)) {
                    linkedHashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CAMERA, this.f6533a.get(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CAMERA));
                }
                if (this.f6533a.containsKey(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_BLUETOOTH)) {
                    linkedHashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_BLUETOOTH, this.f6533a.get(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_BLUETOOTH));
                }
                if (this.f6533a.containsKey(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CONTACT)) {
                    linkedHashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CONTACT, this.f6533a.get(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CONTACT));
                }
                if (this.f6533a.containsKey(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_RECORD)) {
                    linkedHashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_RECORD, this.f6533a.get(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_RECORD));
                }
                if (this.f6533a.containsKey(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_ADDRESS)) {
                    linkedHashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_ADDRESS, this.f6533a.get(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_ADDRESS));
                }
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    OpenSettingItem openSettingItem = new OpenSettingItem();
                    openSettingItem.enabled = ((Boolean) entry.getValue()).booleanValue();
                    openSettingItem.scope = (String) entry.getKey();
                    openSettingItem.appId = this.d;
                    openSettingItem.displayName = f6532o.get(entry.getKey());
                    this.g.add(openSettingItem);
                }
                c();
                b();
                a();
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

    protected void setStatusBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(APEncodeOptions.DEFAULT_MAX_LEN);
            getWindow().setStatusBarColor(GriverLaunchParams.DEFAULT_STATUS_BAR_COLOR);
        } else if (Build.VERSION.SDK_INT >= 19) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags = 67108864 | attributes.flags;
        }
    }

    private void a() {
        this.f.setOnSettingChangeListener(new GriverOpenSettingListAdapter.OnSettingChangeListener() { // from class: com.alibaba.griver.device.ui.GriverOpenSettingActivity.1
            @Override // com.alibaba.griver.device.adapter.GriverOpenSettingListAdapter.OnSettingChangeListener
            public void onChange(int i, boolean z) {
                ((OpenSettingItem) GriverOpenSettingActivity.this.g.get(i)).enabled = z;
                String str = ((OpenSettingItem) GriverOpenSettingActivity.this.g.get(i)).scope;
                GriverOpenSettingActivity.this.b.put(str, Boolean.valueOf(z));
                ((AuthenticationProxy) RVProxy.get(AuthenticationProxy.class)).setPermissionState(GriverAccount.getUserId(), GriverOpenSettingActivity.this.d, str, null, z);
            }
        });
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.device.ui.GriverOpenSettingActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GriverOpenAuthExtension griverOpenAuthExtension = (GriverOpenAuthExtension) RVProxy.get(GriverOpenAuthExtension.class);
                GriverOpenSettingActivity griverOpenSettingActivity = GriverOpenSettingActivity.this;
                griverOpenAuthExtension.revokeOpenAuthItemClicked(griverOpenSettingActivity, griverOpenSettingActivity.d, APIContextUtils.createApiContext(GriverOpenSettingActivity.this.c), new GriverOpenAuthExtension.RevokeCallback() { // from class: com.alibaba.griver.device.ui.GriverOpenSettingActivity.2.1
                    @Override // com.alibaba.griver.api.ui.auth.GriverOpenAuthExtension.RevokeCallback
                    public void onComplete() {
                        GriverOpenSettingActivity.this.b();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        GriverOpenSettingListAdapter griverOpenSettingListAdapter = new GriverOpenSettingListAdapter(this, this.g);
        this.f = griverOpenSettingListAdapter;
        this.j.setAdapter(griverOpenSettingListAdapter);
        this.k.setText(getString(com.alibaba.griver.device.R.string.griver_open_setting_intro, this.e));
        if (!d()) {
            this.m.setVisibility(0);
            this.h.setVisibility(8);
            this.n.setText(getString(com.alibaba.griver.device.R.string.griver_no_permission_used, this.e));
            return;
        }
        this.h.setVisibility(0);
        this.m.setVisibility(8);
        e();
    }

    private void c() {
        RecyclerView recyclerView = (RecyclerView) findViewById(com.alibaba.griver.device.R.id.rv_griver_open_setting);
        this.j = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.j.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, 1);
        Drawable Resources_getDrawable = InstrumentInjector.Resources_getDrawable(getResources(), com.alibaba.griver.device.R.drawable.griver_device_settings_divider);
        if (Resources_getDrawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        dividerItemDecoration.MyBillsEntityDataFactory = Resources_getDrawable;
        this.j.addItemDecoration(dividerItemDecoration);
        this.k = (TextView) findViewById(com.alibaba.griver.device.R.id.tv_griver_open_settings);
        AUTitleBar aUTitleBar = (AUTitleBar) findViewById(com.alibaba.griver.device.R.id.griver_tool_bar);
        this.l = aUTitleBar;
        aUTitleBar.setTitleText(getString(com.alibaba.griver.device.R.string.griver_open_settings));
        this.l.setRightButtonEnabled(false);
        this.m = (LinearLayout) findViewById(com.alibaba.griver.device.R.id.layout_empty);
        this.n = (TextView) findViewById(com.alibaba.griver.device.R.id.tv_empty_text);
        this.h = (LinearLayout) findViewById(com.alibaba.griver.device.R.id.layout_content);
        this.i = (RelativeLayout) findViewById(com.alibaba.griver.device.R.id.layout_user);
    }

    private boolean d() {
        return this.g.size() > 0 || ((GriverOpenAuthExtension) RVProxy.get(GriverOpenAuthExtension.class)).shouldShowRevokeOpenAuthItem(this.d, APIContextUtils.createApiContext(this.c));
    }

    private void e() {
        if (((GriverOpenAuthExtension) RVProxy.get(GriverOpenAuthExtension.class)).shouldShowRevokeOpenAuthItem(this.d, APIContextUtils.createApiContext(this.c))) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent();
        intent.setAction("griver_setting_changes");
        intent.putExtra("data", new SerializableMap(this.b));
        sendBroadcast(intent);
    }

    private static void p(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = getAuthRequestContext;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = getAuthRequestContext;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            for (int i3 = 0; i3 < length3; i3++) {
                iArr6[i3] = (int) (iArr5[i3] ^ (-3152031022165484798L));
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i4 = 0; i4 < 16; i4++) {
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i4];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i5 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i5;
            }
            int i6 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i6;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i7 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i8 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}

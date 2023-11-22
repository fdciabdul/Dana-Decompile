package com.alibaba.griver.core.ui.activity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AndroidVersionUtils;
import com.alibaba.griver.base.common.utils.PermissionUtils;
import com.alibaba.griver.core.render.NXWebChromeClient;
import com.alibaba.griver.file.jsapi.ChooseFileBridgeExtension;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import id.dana.R;
import id.dana.danah5.constant.BridgeName;
import id.dana.onboarding.splash.LauncherActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class GriverFileChooserActivity extends GriverBaseFragmentActivity {
    public static final int FILE_CHOOSER_REQUEST_CODE = 1;
    public static final String TAG = "GriverFileChooserActivity";

    /* renamed from: a  reason: collision with root package name */
    private String f6465a;
    String[] acceptType;
    private Uri b;
    String capture;
    boolean multiple;
    public static final byte[] $$d = {79, Ascii.DC4, Ascii.EM, -22, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$e = 66;
    public static final byte[] PlaceComponentResult = {121, 107, -47, -24, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int scheduleImpl = 2;
    private static long lookAheadTest = -8873791699279476028L;

    private static void n(byte b, short s, short s2, Object[] objArr) {
        int i = 56 - s;
        int i2 = b + 16;
        byte[] bArr = PlaceComponentResult;
        int i3 = 106 - s2;
        byte[] bArr2 = new byte[i2];
        int i4 = -1;
        int i5 = i2 - 1;
        if (bArr == null) {
            i3 = (i5 + (-i)) - 4;
            i5 = i5;
            i++;
        }
        while (true) {
            i4++;
            bArr2[i4] = (byte) i3;
            if (i4 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3 = (i3 + (-bArr[i])) - 4;
            i5 = i5;
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void o(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alibaba.griver.core.ui.activity.GriverFileChooserActivity.$$d
            int r6 = r6 * 3
            int r6 = 42 - r6
            int r8 = r8 + 4
            int r7 = r7 * 2
            int r7 = 103 - r7
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r7 = r6
            r3 = r8
            r4 = 0
            goto L2c
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L2c:
            int r8 = r8 + 1
            int r6 = r6 + r3
            int r6 = r6 + (-7)
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverFileChooserActivity.o(byte, int, int, java.lang.Object[]):void");
    }

    @Override // com.alibaba.griver.core.ui.activity.GriverBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        m(Drawable.resolveOpacity(0, 0), new char[]{4270, 46566, 4303, 62116, 6821, 38041, 26222, 45976, 3185, 54867, 45513, 38004, 10657, 13593, 56627, 26842, 18124, 10421, 65198, 19871, 25117, 3193}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        m(MotionEvent.axisFromString("") + 1, new char[]{55621, 49602, 55592, 34455, 43304, 10021, 45575, 26602, 50577}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    m(ViewConfiguration.getLongPressTimeout() >> 16, new char[]{38324, 23304, 38275, 7239, 7778, 36876, 51888, 7948, 35124, 14512, 46419, 14524, 44259, 56289, 55737, 50226, 50113, 50694, 64059, 57618, 59205, 58069, 8012, 33429, 6816, 36343, 969, 44658, 14832, 43127, 9250, 19312, 23894, 21648, 18731, 21633, 28685, 30610, 28040, 29069, 38882, 4717, 36562, 7476, 35683, 15714, 45934, 16098, 44614, 55687, 55228, 56257}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    m((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1, new char[]{24467, 39206, 24562, 56895, 62339, 32237, 53749, 1045, 17221, 64195, 22715, 9209, 26263, 6601, 13314, 57124, 2535, 1067, 6106, 64085, 11617, 8440, 62205, 39296, 53383, 20363, 61053, 46386, 62341, 27144, 51650, 20532, 38779, 38590, 42137, 20371, 47728, 46574, 32879, 27337, 24000, 53273, 25403, 1650, 16710, 65306, 24286, 9632, 25696, 7085, 14938, 49366, 2016, 1657, 5420, 64520, 11098, 9485, 61691, 39856, 52739, 16859, 60440, 46771, 61938, 27746, 53071, 21010}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    m(TextUtils.indexOf("", ""), new char[]{15320, 60936, 15338, 43285, 6503, 38746, 44792, 31518, 10065, 36323, 45661, 23800, 640, 28348, 57063, 41005, 28153, 29447, 64831, 34139, 18809, 22401, 6219, 59096, 46234, 14582, 1230, 51775, 38863, 7458, 8998, 12132, 62318, 57746, 20088, 12495, 56943, 49856, 27277, 5572, 14730, 42851, 35289, 31092, 9472, 34914, 46190, 23208, 'p', 27780, 53486, 49038, 25598, 29021, 65436, 33625, 20250, 21029, 6729, 58553, 43599, 14065, 1702, 51690, 38382, 6977, 9722, 11541}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    m(ImageFormat.getBitsPerPixel(0) + 1, new char[]{35627, 4957, 35651, 21509, 58369, 27181, 42721, 29461, 38888, 28859, 20262, 21754, 45615, 37808, 9175, 43108, 56597, 36373, 1, 36103, 63886, 43728, 58733, 61126, 1082, 50610, 63933, 49723, 10092, 57444, 56856, 10039, 17311, 7378, 45912, 14528, 28362, 16259, 38844, 7627, 35192, 23150, 29924, 29050, 38314, 29985, 18768, 21162, 45266, 37263, 11662, 46992, 54040, 35909, 694, 35667, 65513, 44910, 59180, 60643, 6894, 52223, 64397, 49590}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    m(TextUtils.lastIndexOf("", '0') + 1, new char[]{24585, 16616, 24624, 2026, 25071, 61315, 39523, 20425, 31883, 8965}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), ((byte) KeyEvent.getModifierMetaStateMask()) + 19, (char) (Process.myTid() >> 22))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                n(PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), PlaceComponentResult[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = PlaceComponentResult[25];
                Object[] objArr14 = new Object[1];
                n(b, (byte) (b | Ascii.RS), PlaceComponentResult[9], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(56 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 3 - View.MeasureSpec.getSize(0), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
                        Object[] objArr16 = new Object[1];
                        o($$d[31], $$d[12], (byte) ($$d[78] - 1), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 800, 16 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 800, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 15, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(863 - AndroidCharacter.getMirror('0'), TextUtils.indexOf("", "") + 29, (char) (57994 - KeyEvent.normalizeMetaState(0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getLongPressTimeout() >> 16), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 15, (char) (ViewConfiguration.getTapTimeout() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-2107003837, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                n(PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), PlaceComponentResult[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr20 = new Object[1];
                n(b2, (byte) (b2 | Ascii.RS), PlaceComponentResult[9], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - KeyEvent.getDeadChar(0, 0), (-16777170) - Color.rgb(0, 0, 0), (char) ((-1) - Process.getGidForName("")));
                        byte b3 = $$d[8];
                        byte b4 = (byte) ($$d[78] - 1);
                        Object[] objArr22 = new Object[1];
                        o(b3, b4, (byte) (b4 | Ascii.ETB), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-2107003837, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 911, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                n(PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), PlaceComponentResult[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = PlaceComponentResult[25];
                Object[] objArr26 = new Object[1];
                n(b5, (byte) (b5 | Ascii.RS), PlaceComponentResult[9], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 118, 2 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (38968 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)));
                        byte b6 = $$d[8];
                        byte b7 = (byte) ($$d[78] - 1);
                        Object[] objArr28 = new Object[1];
                        o(b6, b7, (byte) (b7 | Ascii.ETB), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.makeMeasureSpec(0, 0), 35 - TextUtils.getOffsetAfter("", 0), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-2107003837, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getLongPressTimeout() >> 16), 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                n(PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), PlaceComponentResult[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b8 = PlaceComponentResult[25];
                Object[] objArr32 = new Object[1];
                n(b8, (byte) (b8 | Ascii.RS), PlaceComponentResult[9], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 106, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 3, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1));
                        Object[] objArr34 = new Object[1];
                        o((byte) ($$d[78] - 1), $$d[9], $$d[53], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), Color.argb(0, 0, 0, 0) + 35, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-2107003837, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 911, 18 - View.getDefaultSize(0, 0), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // com.alibaba.griver.core.ui.activity.GriverBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.alibaba.griver.core.ui.activity.GriverBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.alibaba.griver.core.ui.activity.GriverBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // com.alibaba.griver.core.ui.activity.GriverBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            m(View.MeasureSpec.getMode(0), new char[]{20463, 30610, 20366, 12496, 33672, 3508, 33091, 21685, 21296, 5159, 10468, 29529, 30446, 63342, 17472, 36745, 6590, 60109, 26516, 43710, 15705, 52759, 33508, 51582, 49355, 41318, 40498, 58834, 58286, 33978}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                n(PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), (byte) (-PlaceComponentResult[32]), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                n((byte) scheduleImpl, PlaceComponentResult[25], PlaceComponentResult[48], new Object[1]);
                Object[] objArr3 = new Object[1];
                m(((ApplicationInfo) cls2.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{7302, 19721, 7397, 2640, 43493, 10191, 23216, 36678, 'S', 11963, 665, 43205, 9622, 52725, 28209, 21565, 19189, 53332, 19961, 29005, 28201, 62603}, objArr3);
                baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, Color.green(0) + 35, (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getLongPressTimeout() >> 16), 18 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
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
        super.onPause();
    }

    @Override // com.alibaba.griver.core.ui.activity.GriverBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            m((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{20463, 30610, 20366, 12496, 33672, 3508, 33091, 21685, 21296, 5159, 10468, 29529, 30446, 63342, 17472, 36745, 6590, 60109, 26516, 43710, 15705, 52759, 33508, 51582, 49355, 41318, 40498, 58834, 58286, 33978}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            m(getPackageName().codePointAt(4) - 97, new char[]{7302, 19721, 7397, 2640, 43493, 10191, 23216, 36678, 'S', 11963, 665, 43205, 9622, 52725, 28209, 21565, 19189, 53332, 19961, 29005, 28201, 62603}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.indexOf("", ""), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), 18 - (KeyEvent.getMaxKeyCode() >> 16), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // com.alibaba.griver.core.ui.activity.GriverBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr = new Object[1];
        m(1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new char[]{4270, 46566, 4303, 62116, 6821, 38041, 26222, 45976, 3185, 54867, 45513, 38004, 10657, 13593, 56627, 26842, 18124, 10421, 65198, 19871, 25117, 3193}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        m(super.getResources().getString(R.string.pushverify_enable_pn_bs_title).substring(9, 10).codePointAt(0) - 97, new char[]{55621, 49602, 55592, 34455, 43304, 10021, 45575, 26602, 50577}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr3 = new Object[1];
                m(super.getResources().getString(R.string.bank_card).substring(1, 2).codePointAt(0) - 97, new char[]{20463, 30610, 20366, 12496, 33672, 3508, 33091, 21685, 21296, 5159, 10468, 29529, 30446, 63342, 17472, 36745, 6590, 60109, 26516, 43710, 15705, 52759, 33508, 51582, 49355, 41318, 40498, 58834, 58286, 33978}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                try {
                    Object[] objArr4 = new Object[1];
                    n(PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), (byte) (-PlaceComponentResult[32]), objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    n((byte) scheduleImpl, PlaceComponentResult[25], PlaceComponentResult[48], new Object[1]);
                    Object[] objArr5 = new Object[1];
                    m(((ApplicationInfo) cls3.getMethod((String) r3[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{7302, 19721, 7397, 2640, 43493, 10191, 23216, 36678, 'S', 11963, 665, 43205, 9622, 52725, 28209, 21565, 19189, 53332, 19961, 29005, 28201, 62603}, objArr5);
                    baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr6 = new Object[1];
                        n(PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), (byte) (-PlaceComponentResult[32]), objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        n((byte) scheduleImpl, PlaceComponentResult[25], PlaceComponentResult[48], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        m(((ApplicationInfo) cls4.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{38324, 23304, 38275, 7239, 7778, 36876, 51888, 7948, 35124, 14512, 46419, 14524, 44259, 56289, 55737, 50226, 50113, 50694, 64059, 57618, 59205, 58069, 8012, 33429, 6816, 36343, 969, 44658, 14832, 43127, 9250, 19312, 23894, 21648, 18731, 21633, 28685, 30610, 28040, 29069, 38882, 4717, 36562, 7476, 35683, 15714, 45934, 16098, 44614, 55687, 55228, 56257}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        m(TextUtils.getTrimmedLength(""), new char[]{24467, 39206, 24562, 56895, 62339, 32237, 53749, 1045, 17221, 64195, 22715, 9209, 26263, 6601, 13314, 57124, 2535, 1067, 6106, 64085, 11617, 8440, 62205, 39296, 53383, 20363, 61053, 46386, 62341, 27144, 51650, 20532, 38779, 38590, 42137, 20371, 47728, 46574, 32879, 27337, 24000, 53273, 25403, 1650, 16710, 65306, 24286, 9632, 25696, 7085, 14938, 49366, 2016, 1657, 5420, 64520, 11098, 9485, 61691, 39856, 52739, 16859, 60440, 46771, 61938, 27746, 53071, 21010}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        m(getPackageName().codePointAt(1) - 100, new char[]{15320, 60936, 15338, 43285, 6503, 38746, 44792, 31518, 10065, 36323, 45661, 23800, 640, 28348, 57063, 41005, 28153, 29447, 64831, 34139, 18809, 22401, 6219, 59096, 46234, 14582, 1230, 51775, 38863, 7458, 8998, 12132, 62318, 57746, 20088, 12495, 56943, 49856, 27277, 5572, 14730, 42851, 35289, 31092, 9472, 34914, 46190, 23208, 'p', 27780, 53486, 49038, 25598, 29021, 65436, 33625, 20250, 21029, 6729, 58553, 43599, 14065, 1702, 51690, 38382, 6977, 9722, 11541}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        m(ViewConfiguration.getScrollDefaultDelay() >> 16, new char[]{35627, 4957, 35651, 21509, 58369, 27181, 42721, 29461, 38888, 28859, 20262, 21754, 45615, 37808, 9175, 43108, 56597, 36373, 1, 36103, 63886, 43728, 58733, 61126, 1082, 50610, 63933, 49723, 10092, 57444, 56856, 10039, 17311, 7378, 45912, 14528, 28362, 16259, 38844, 7627, 35192, 23150, 29924, 29050, 38314, 29985, 18768, 21162, 45266, 37263, 11662, 46992, 54040, 35909, 694, 35667, 65513, 44910, 59180, 60643, 6894, 52223, 64397, 49590}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        m(super.getResources().getString(R.string.smartpay_info_desc_1).substring(21, 23).length() - 2, new char[]{24585, 16616, 24624, 2026, 25071, 61315, 39523, 20425, 31883, 8965}, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), View.getDefaultSize(0, 0) + 18, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr12);
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
            Object[] objArr13 = new Object[1];
            n(PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), PlaceComponentResult[25], objArr13);
            Class<?> cls5 = Class.forName((String) objArr13[0]);
            byte b = PlaceComponentResult[25];
            Object[] objArr14 = new Object[1];
            n(b, (byte) (b | Ascii.RS), PlaceComponentResult[9], objArr14);
            try {
                Object[] objArr15 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 494, 3 - ImageFormat.getBitsPerPixel(0), (char) View.MeasureSpec.makeMeasureSpec(0, 0));
                    Object[] objArr16 = new Object[1];
                    o((byte) ($$d[78] - 1), $$d[9], $$d[53], objArr16);
                    obj3 = cls6.getMethod((String) objArr16[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                int i = ((int[]) objArr17[1])[0];
                if (((int[]) objArr17[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr18 = {-1823437544, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 911, 18 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr18);
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
                super.onCreate(bundle);
                requestWindowFeature(1);
                Intent intent = getIntent();
                if (intent == null) {
                    finish();
                    return;
                }
                this.acceptType = intent.getStringArrayExtra("acceptType");
                this.capture = intent.getStringExtra(BridgeName.CAPTURE);
                this.multiple = intent.getBooleanExtra("multiple", false);
                try {
                    b();
                } catch (Exception e) {
                    GriverLogger.e(TAG, "choose file failed", e);
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

    private boolean a() {
        String[] strArr = this.acceptType;
        if (strArr == null || strArr.length == 0) {
            return true;
        }
        for (String str : strArr) {
            if (TextUtils.equals(str, "*/*") || str.contains("image") || str.contains("video")) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 33) {
            arrayList.add("android.permission.READ_MEDIA_AUDIO");
            arrayList.add("android.permission.READ_MEDIA_VIDEO");
            arrayList.add("android.permission.READ_MEDIA_IMAGES");
        } else if (Build.VERSION.SDK_INT >= 30) {
            arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
        } else {
            arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (!TextUtils.isEmpty(this.capture) && a()) {
            arrayList.add("android.permission.CAMERA");
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        if (PermissionUtils.hasPermissions(strArr)) {
            GriverLogger.d(TAG, "get CAMERA permission success!");
            try {
                startActivityForResult(a(this), 1);
                return;
            } catch (Exception e) {
                GriverLogger.e(TAG, "exception detail", e);
                return;
            }
        }
        PermissionUtils.requestPermissions(strArr, 1, new IPermissionRequestCallback() { // from class: com.alibaba.griver.core.ui.activity.GriverFileChooserActivity.1
            @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
            public void onRequestPermissionResult(int i, String[] strArr2, int[] iArr) {
                if (PermissionUtils.positivePermissionsResult(iArr)) {
                    GriverLogger.d(GriverFileChooserActivity.TAG, "get CAMERA permission success!");
                    try {
                        GriverFileChooserActivity griverFileChooserActivity = GriverFileChooserActivity.this;
                        griverFileChooserActivity.startActivityForResult(griverFileChooserActivity.a(griverFileChooserActivity), 1);
                        return;
                    } catch (Exception e2) {
                        GriverLogger.e(GriverFileChooserActivity.TAG, "exception detail", e2);
                        return;
                    }
                }
                GriverFileChooserActivity.this.showDeniedForCamera();
            }
        });
    }

    void showDeniedForCamera() {
        Intent intent = new Intent();
        intent.setAction(NXWebChromeClient.FILE_CHOOSER_RESULT);
        Context applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = getApplicationContext();
        }
        if (applicationContext != null) {
            LocalBroadcastManager.getInstance(applicationContext).sendBroadcastSync(intent);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent a(Context context) {
        Intent a2;
        if (TextUtils.isEmpty(this.capture)) {
            a2 = a(context, new Intent[0]);
        } else {
            a2 = a(context, g());
        }
        a2.putExtra("android.intent.extra.INTENT", c());
        return a2;
    }

    private Intent c() {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 19) {
            intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
        }
        intent.addCategory("android.intent.category.OPENABLE");
        String[] strArr = this.acceptType;
        String str = "*/*";
        if (strArr != null && strArr.length > 0) {
            String str2 = "";
            for (String str3 : strArr) {
                if (!TextUtils.isEmpty(str3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str3);
                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                    str2 = sb.toString();
                }
            }
            if (!TextUtils.isEmpty(str2) && str2.length() > 0) {
                str = str2.substring(0, str2.length() - 1);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                String[] strArr2 = this.acceptType;
                if (strArr2.length > 1) {
                    intent.putExtra("android.intent.extra.MIME_TYPES", strArr2);
                }
            }
        }
        if (this.multiple && Build.VERSION.SDK_INT >= 18) {
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }
        intent.setType(str);
        return intent;
    }

    private Intent a(Context context, Intent... intentArr) {
        Intent intent = new Intent("android.intent.action.CHOOSER");
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
        intent.putExtra("android.intent.extra.TITLE", context.getString(com.alibaba.griver.core.R.string.griver_core_file_chooser));
        return intent;
    }

    private Intent d() {
        Uri fromFile;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (AndroidVersionUtils.isQAndAbove()) {
            ContentResolver contentResolver = GriverEnv.getApplicationContext().getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("mime_type", "image/jpeg");
            contentValues.put("relative_path", "DCIM/browser-photos");
            fromFile = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            this.b = fromFile;
            StringBuilder sb = new StringBuilder();
            sb.append("choose file from camera, file uri: ");
            sb.append(fromFile);
            GriverLogger.d(TAG, sb.toString());
        } else {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(externalStoragePublicDirectory.getAbsolutePath());
            sb2.append(File.separator);
            sb2.append("browser-photos");
            File file = new File(sb2.toString());
            file.mkdirs();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(file.getAbsolutePath());
            sb3.append(File.separator);
            sb3.append(System.currentTimeMillis());
            sb3.append(".jpg");
            this.f6465a = sb3.toString();
            fromFile = Uri.fromFile(new File(this.f6465a));
        }
        intent.putExtra(TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT, fromFile);
        return intent;
    }

    private Intent e() {
        return new Intent("android.media.action.VIDEO_CAPTURE");
    }

    private Intent f() {
        return new Intent("android.provider.MediaStore.RECORD_SOUND");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.content.Intent[] g() {
        /*
            r10 = this;
            java.lang.String[] r0 = r10.acceptType
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L44
            int r3 = r0.length
            if (r3 == 0) goto L44
            int r3 = r0.length
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
        Le:
            if (r4 >= r3) goto L42
            r8 = r0[r4]
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 == 0) goto L19
            goto L3f
        L19:
        */
        //  java.lang.String r9 = "*/*"
        /*
            boolean r9 = android.text.TextUtils.equals(r8, r9)
            if (r9 != 0) goto L44
            java.lang.String r9 = "image"
            boolean r9 = r8.contains(r9)
            if (r9 == 0) goto L2b
            r7 = 1
            goto L3f
        L2b:
            java.lang.String r9 = "video"
            boolean r9 = r8.contains(r9)
            if (r9 == 0) goto L36
            r6 = 1
            goto L3f
        L36:
            java.lang.String r9 = "audio"
            boolean r8 = r8.contains(r9)
            if (r8 == 0) goto L3f
            r5 = 1
        L3f:
            int r4 = r4 + 1
            goto Le
        L42:
            r2 = r7
            goto L46
        L44:
            r5 = 1
            r6 = 1
        L46:
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            if (r2 == 0) goto L54
            android.content.Intent r2 = r10.d()
            r0.add(r2)
        L54:
            if (r6 == 0) goto L5d
            android.content.Intent r2 = r10.e()
            r0.add(r2)
        L5d:
            if (r5 == 0) goto L66
            android.content.Intent r2 = r10.f()
            r0.add(r2)
        L66:
            android.content.Intent[] r1 = new android.content.Intent[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            android.content.Intent[] r0 = (android.content.Intent[]) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverFileChooserActivity.g():android.content.Intent[]");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        GriverLogger.d(TAG, "EditAvatarModActivity onDestroy");
        super.onDestroy();
    }

    private void h() {
        if (!AndroidVersionUtils.isQAndAbove() || this.b == null) {
            return;
        }
        try {
            getContentResolver().openInputStream(this.b);
        } catch (FileNotFoundException unused) {
            GriverLogger.w(TAG, "Camera file not exist, delete temp file");
            getContentResolver().delete(this.b, null, null);
            this.b = null;
        } catch (Throwable th) {
            GriverLogger.w(TAG, "read file exception", th);
            getContentResolver().delete(this.b, null, null);
            this.b = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007d A[Catch: Exception -> 0x00e5, TryCatch #0 {Exception -> 0x00e5, blocks: (B:9:0x0014, B:11:0x002b, B:13:0x0031, B:14:0x0035, B:16:0x003b, B:18:0x004b, B:19:0x0052, B:21:0x0058, B:23:0x005c, B:37:0x0095, B:40:0x009d, B:42:0x00a3, B:44:0x00af, B:46:0x00b5, B:48:0x00d6, B:47:0x00c8, B:49:0x00d9, B:51:0x00dd, B:25:0x0066, B:27:0x006a, B:33:0x007d, B:35:0x008d, B:8:0x0010, B:53:0x00e1), top: B:58:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d A[Catch: Exception -> 0x00e5, TryCatch #0 {Exception -> 0x00e5, blocks: (B:9:0x0014, B:11:0x002b, B:13:0x0031, B:14:0x0035, B:16:0x003b, B:18:0x004b, B:19:0x0052, B:21:0x0058, B:23:0x005c, B:37:0x0095, B:40:0x009d, B:42:0x00a3, B:44:0x00af, B:46:0x00b5, B:48:0x00d6, B:47:0x00c8, B:49:0x00d9, B:51:0x00dd, B:25:0x0066, B:27:0x006a, B:33:0x007d, B:35:0x008d, B:8:0x0010, B:53:0x00e1), top: B:58:0x0007 }] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r6, int r7, android.content.Intent r8) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverFileChooserActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    private Uri a(Uri uri) {
        String decode = Uri.decode(uri.toString());
        boolean configBoolean = GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_H5_CHOOSE_VIDEO_CONFIG, true);
        if (decode.startsWith("content://com.android.providers.media.documents/document/image")) {
            String substring = decode.substring(decode.lastIndexOf(":") + 1);
            StringBuilder sb = new StringBuilder();
            sb.append("content://media/external/images/media/");
            sb.append(substring);
            Uri parse = Uri.parse(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("new result: ");
            sb2.append(parse);
            GriverLogger.d(TAG, sb2.toString());
            return parse;
        } else if (configBoolean && decode.startsWith("content://com.android.providers.media.documents/document/video")) {
            String substring2 = decode.substring(decode.lastIndexOf(":") + 1);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
            sb3.append("/");
            sb3.append(substring2);
            Uri parse2 = Uri.parse(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("new result: ");
            sb4.append(parse2);
            GriverLogger.d(TAG, sb4.toString());
            return parse2;
        } else if (!configBoolean || !decode.startsWith("content://com.android.providers.media.documents/document/audio")) {
            return (!decode.startsWith("content://com.android.providers.downloads.documents/document") && AndroidVersionUtils.isAboveR()) ? MediaStore.getMediaUri(this, uri) : uri;
        } else {
            String substring3 = decode.substring(decode.lastIndexOf(":") + 1);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
            sb5.append("/");
            sb5.append(substring3);
            Uri parse3 = Uri.parse(sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("new result: ");
            sb6.append(parse3);
            GriverLogger.d(TAG, sb6.toString());
            return parse3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Uri[] uriArr) {
        Intent intent = new Intent();
        intent.setAction(NXWebChromeClient.FILE_CHOOSER_RESULT);
        intent.putExtra(ChooseFileBridgeExtension.CHOOSE_FILE_RESULT_DATA_KEY, uriArr);
        Context applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = getApplicationContext();
        }
        if (applicationContext != null) {
            LocalBroadcastManager.getInstance(applicationContext).sendBroadcastSync(intent);
        }
        GriverLogger.d(TAG, "onActivityResult finish");
        finish();
    }

    private static void m(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(lookAheadTest ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (lookAheadTest ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
    }
}

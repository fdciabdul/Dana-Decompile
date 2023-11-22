package com.alibaba.griver.file.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.OfficeFileType;
import com.alibaba.griver.base.common.utils.PermissionUtils;
import com.alibaba.griver.base.common.utils.ToastUtils;
import com.alibaba.griver.file.pdf.PdfImageSource;
import com.alibaba.griver.file.pdf.PdfSourceManager;
import com.alibaba.griver.file.utils.MimeTypeUtil;
import com.alibaba.griver.ui.ant.AUTitleBar;
import com.alibaba.wireless.security.SecExceptionCode;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.lib.gcontainer.app.bridge.constant.BridgeKey;
import id.dana.onboarding.splash.LauncherActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes2.dex */
public class FileViewerActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private String f6538a;
    private String b;
    private ProgressDialog c;
    private AUTitleBar d;
    private ZoomRecyclerView e;
    private LinearLayout f;
    public static final byte[] $$a = {Ascii.EM, -104, -116, 103, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 136;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {116, -27, -60, 115, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 196;
    private static int[] MyBillsEntityDataFactory = {157872044, 458278790, -1638275929, -1548418119, -19932780, 132538245, -1455314591, 1857301017, 705642541, -1724640246, 837952956, 415648226, 969507757, -1981278506, -1478785418, -2017922172, -614191834, -905502411};

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = 106 - r7
            int r8 = r8 + 4
            int r6 = 23 - r6
            byte[] r0 = com.alibaba.griver.file.ui.FileViewerActivity.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r7
            r3 = 0
            r7 = r6
            goto L2a
        L13:
            r3 = 0
        L14:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L2a:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + (-4)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.file.ui.FileViewerActivity.h(byte, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void i(short r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.alibaba.griver.file.ui.FileViewerActivity.$$a
            int r9 = r9 * 2
            int r9 = r9 + 75
            int r7 = r7 * 3
            int r7 = 42 - r7
            int r8 = r8 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L16
            r9 = r8
            r3 = r9
            r5 = 0
            r8 = r7
            goto L2e
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            int r8 = r8 + 1
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L2e:
            int r7 = r7 + r3
            int r7 = r7 + (-7)
            r3 = r5
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.file.ui.FileViewerActivity.i(short, short, byte, java.lang.Object[]):void");
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        g(19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new int[]{-1344476764, 1557865252, 935361296, 259874243, 1009206376, 1777941375, 1484255738, 221591471, 506496416, -2135444161}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        g((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 5, new int[]{896034494, 175163711, -1285798800, -771292481}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    g((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 48, new int[]{-497394378, 1385819923, 244178737, 1594512818, -1795666219, 14765890, -211832608, -1703189620, 1300015272, -1411389246, -305394324, 409688044, 2082869645, -1794344319, -1097985035, 1204660422, -2062545233, 823379567, -1447053329, 1024301164, -1113009746, 2023198989, -2091308918, -1460380550}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g(65 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new int[]{-753642615, -456874895, 876704006, 837159008, -1922813960, -630647337, 597939313, -443281399, 1807791442, -1194044815, 1100392903, -59277081, -1652339561, -974746813, -68373496, -423904240, 1684318953, -1652772306, -927755612, -560930823, -1093297799, -2123158705, 440919462, -435268500, 1672212055, -479655934, -739720634, -565035134, -304758278, 668707949, 610155045, 1646224034}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g('p' - AndroidCharacter.getMirror('0'), new int[]{-1212679118, 1661335270, 35365332, -544118918, 1174316507, 1447482340, -1281114100, 72752706, 13663177, -77387627, 1663326616, -1227117996, -7503849, 768447738, 1447773603, -1575706491, 1487836199, -1240190373, 1169513138, 1618106995, 557551265, 947835903, -1351602513, -1879638020, -1521279677, -867866985, -1808422800, -2123231080, 397626871, -522828557, -1245089373, -1561165470}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g(ImageFormat.getBitsPerPixel(0) + 61, new int[]{457632967, 1850133765, -213384889, -1455024521, 693510379, -2083260840, -72599245, 609125201, -1619024688, -1533173549, 1065694205, -1660415310, -1741115193, 1568832922, 1681645334, -507495746, -1193938648, 2021867806, 1806796458, 1512827824, 1148241221, -392464903, -1281985572, 2073907405, 670805353, -857391917, -198559096, 1115748609, 1967647939, -43149083}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    g(TextUtils.lastIndexOf("", '0') + 7, new int[]{-2057757412, -54387580, 999603216, -1706967272}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, (char) Color.argb(0, 0, 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = BuiltInFictitiousFunctionClassFactory[30];
                byte b2 = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr13 = new Object[1];
                h(b, b2, (byte) (b2 | 36), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = BuiltInFictitiousFunctionClassFactory[30];
                byte b4 = BuiltInFictitiousFunctionClassFactory[9];
                Object[] objArr14 = new Object[1];
                h(b3, b4, (byte) (b4 | Ascii.DC4), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - KeyEvent.normalizeMetaState(0), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                        Object[] objArr16 = new Object[1];
                        i($$a[31], $$a[47], $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.indexOf("", ""), 15 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - TextUtils.indexOf("", ""), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - View.resolveSizeAndState(0, 0, 0), KeyEvent.getDeadChar(0, 0) + 29, (char) ((Process.myPid() >> 22) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 15 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (ViewConfiguration.getLongPressTimeout() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0'), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 34, (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {304795386, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 911, 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = BuiltInFictitiousFunctionClassFactory[30];
                byte b6 = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr19 = new Object[1];
                h(b5, b6, (byte) (b6 | 36), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b7 = BuiltInFictitiousFunctionClassFactory[30];
                byte b8 = BuiltInFictitiousFunctionClassFactory[9];
                Object[] objArr20 = new Object[1];
                h(b7, b8, (byte) (b8 | Ascii.DC4), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 61, 46 - Color.alpha(0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr22 = new Object[1];
                        i($$a[8], $$a[28], $$a[9], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - Process.getGidForName(""), KeyEvent.keyCodeFromString("") + 35, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {304795386, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myTid() >> 22), MotionEvent.axisFromString("") + 19, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b9 = BuiltInFictitiousFunctionClassFactory[30];
                byte b10 = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr25 = new Object[1];
                h(b9, b10, (byte) (b10 | 36), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b11 = BuiltInFictitiousFunctionClassFactory[30];
                byte b12 = BuiltInFictitiousFunctionClassFactory[9];
                Object[] objArr26 = new Object[1];
                h(b11, b12, (byte) (b12 | Ascii.DC4), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 117, Color.rgb(0, 0, 0) + 16777219, (char) (38968 - View.MeasureSpec.makeMeasureSpec(0, 0)));
                        Object[] objArr28 = new Object[1];
                        i($$a[8], $$a[28], $$a[9], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {304795386, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0, 0), 18 - TextUtils.indexOf("", "", 0), (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b13 = BuiltInFictitiousFunctionClassFactory[30];
                byte b14 = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr31 = new Object[1];
                h(b13, b14, (byte) (b14 | 36), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b15 = BuiltInFictitiousFunctionClassFactory[30];
                byte b16 = BuiltInFictitiousFunctionClassFactory[9];
                Object[] objArr32 = new Object[1];
                h(b15, b16, (byte) (b16 | Ascii.DC4), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.getCapsMode("", 0, 0) + 3, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1));
                        Object[] objArr34 = new Object[1];
                        i((byte) ($$a[78] - 1), (byte) (-$$a[40]), (byte) ($$a[78] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), 35 - View.resolveSize(0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {304795386, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
            g(super.getResources().getString(R.string.referral_footer).substring(8, 9).codePointAt(0) - 6, new int[]{-1344476764, 1557865252, 935361296, 259874243, -992448394, -1501243356, 1594887160, -604367724, 388222395, 979627369, 432429867, 786547366, -1915479722, -1083709206}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(super.getResources().getString(R.string.feed_onboarding_tnc_v2).substring(27, 28).codePointAt(0) - 79, new int[]{410961179, -911083947, 1419123952, 975889510, -1871128514, -304433382, -182251607, -998849673, -369810685, 914496562}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 911, 17 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            g(getPackageName().codePointAt(2) - 20, new int[]{-1344476764, 1557865252, 935361296, 259874243, -992448394, -1501243356, 1594887160, -604367724, 388222395, 979627369, 432429867, 786547366, -1915479722, -1083709206}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(18 - TextUtils.getTrimmedLength(""), new int[]{410961179, -911083947, 1419123952, 975889510, -1871128514, -304433382, -182251607, -998849673, -369810685, 914496562}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ExpandableListView.getPackedPositionChild(0L), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 35, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.normalizeMetaState(0), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String[] strArr;
        Object[] objArr = new Object[1];
        g(super.getResources().getString(R.string.kyc_renewal_dialog_message).substring(62, 64).length() + 16, new int[]{-1344476764, 1557865252, 935361296, 259874243, 1009206376, 1777941375, 1484255738, 221591471, 506496416, -2135444161}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        g(View.resolveSize(0, 0) + 5, new int[]{896034494, 175163711, -1285798800, -771292481}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr3 = new Object[1];
                g(26 - (ViewConfiguration.getDoubleTapTimeout() >> 16), new int[]{-1344476764, 1557865252, 935361296, 259874243, -992448394, -1501243356, 1594887160, -604367724, 388222395, 979627369, 432429867, 786547366, -1915479722, -1083709206}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                try {
                    Object[] objArr4 = new Object[1];
                    h(BuiltInFictitiousFunctionClassFactory[25], (byte) (-BuiltInFictitiousFunctionClassFactory[32]), BuiltInFictitiousFunctionClassFactory[7], objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    h(BuiltInFictitiousFunctionClassFactory[41], BuiltInFictitiousFunctionClassFactory[48], (byte) (-BuiltInFictitiousFunctionClassFactory[59]), new Object[1]);
                    Object[] objArr5 = new Object[1];
                    g(((ApplicationInfo) cls3.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{410961179, -911083947, 1419123952, 975889510, -1871128514, -304433382, -182251607, -998849673, -369810685, 914496562}, objArr5);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), 35 - (ViewConfiguration.getTapTimeout() >> 16), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    g(super.getResources().getString(R.string.alias).substring(0, 5).length() + 43, new int[]{-497394378, 1385819923, 244178737, 1594512818, -1795666219, 14765890, -211832608, -1703189620, 1300015272, -1411389246, -305394324, 409688044, 2082869645, -1794344319, -1097985035, 1204660422, -2062545233, 823379567, -1447053329, 1024301164, -1113009746, 2023198989, -2091308918, -1460380550}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    g(super.getResources().getString(R.string.text_desc_landing_first_point).substring(0, 6).codePointAt(3) - 46, new int[]{-753642615, -456874895, 876704006, 837159008, -1922813960, -630647337, 597939313, -443281399, 1807791442, -1194044815, 1100392903, -59277081, -1652339561, -974746813, -68373496, -423904240, 1684318953, -1652772306, -927755612, -560930823, -1093297799, -2123158705, 440919462, -435268500, 1672212055, -479655934, -739720634, -565035134, -304758278, 668707949, 610155045, 1646224034}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g(getPackageName().codePointAt(2) + 18, new int[]{-1212679118, 1661335270, 35365332, -544118918, 1174316507, 1447482340, -1281114100, 72752706, 13663177, -77387627, 1663326616, -1227117996, -7503849, 768447738, 1447773603, -1575706491, 1487836199, -1240190373, 1169513138, 1618106995, 557551265, 947835903, -1351602513, -1879638020, -1521279677, -867866985, -1808422800, -2123231080, 397626871, -522828557, -1245089373, -1561165470}, objArr8);
                    String str3 = (String) objArr8[0];
                    try {
                        Object[] objArr9 = new Object[1];
                        h(BuiltInFictitiousFunctionClassFactory[25], (byte) (-BuiltInFictitiousFunctionClassFactory[32]), BuiltInFictitiousFunctionClassFactory[7], objArr9);
                        Class<?> cls4 = Class.forName((String) objArr9[0]);
                        Object[] objArr10 = new Object[1];
                        h(BuiltInFictitiousFunctionClassFactory[41], BuiltInFictitiousFunctionClassFactory[48], (byte) (-BuiltInFictitiousFunctionClassFactory[59]), objArr10);
                        Object[] objArr11 = new Object[1];
                        g(((ApplicationInfo) cls4.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 27, new int[]{457632967, 1850133765, -213384889, -1455024521, 693510379, -2083260840, -72599245, 609125201, -1619024688, -1533173549, 1065694205, -1660415310, -1741115193, 1568832922, 1681645334, -507495746, -1193938648, 2021867806, 1806796458, 1512827824, 1148241221, -392464903, -1281985572, 2073907405, 670805353, -857391917, -198559096, 1115748609, 1967647939, -43149083}, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        g(6 - ((Process.getThreadPriority(0) + 20) >> 6), new int[]{-2057757412, -54387580, 999603216, -1706967272}, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 912, 19 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) KeyEvent.getDeadChar(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr13);
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
            byte b = BuiltInFictitiousFunctionClassFactory[30];
            byte b2 = BuiltInFictitiousFunctionClassFactory[25];
            Object[] objArr14 = new Object[1];
            h(b, b2, (byte) (b2 | 36), objArr14);
            Class<?> cls5 = Class.forName((String) objArr14[0]);
            byte b3 = BuiltInFictitiousFunctionClassFactory[30];
            byte b4 = BuiltInFictitiousFunctionClassFactory[9];
            Object[] objArr15 = new Object[1];
            h(b3, b4, (byte) (b4 | Ascii.DC4), objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 494, ImageFormat.getBitsPerPixel(0) + 5, (char) Color.blue(0));
                    Object[] objArr17 = new Object[1];
                    i((byte) ($$a[78] - 1), (byte) (-$$a[40]), (byte) ($$a[78] - 1), objArr17);
                    obj3 = cls6.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr19 = {-1683212813, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
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
                try {
                    setContentView(com.alibaba.griver.file.R.layout.griver_file_activity_page_list);
                    this.f6538a = getIntent().getStringExtra(BridgeKey.FILE_PATH);
                    this.b = getIntent().getStringExtra("fileType");
                    this.d = (AUTitleBar) findViewById(com.alibaba.griver.file.R.id.title_bar);
                    if (GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_OPEN_DOCUMENT_APP_PREVIEW, true)) {
                        this.d.setRightButtonIcon(InstrumentInjector.Resources_getDrawable(getResources(), com.alibaba.griver.file.R.drawable.griver_file_share_image));
                        this.d.getRightButtonIconView().setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.file.ui.FileViewerActivity.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                FileViewerActivity.this.a();
                            }
                        });
                    }
                    this.e = (ZoomRecyclerView) findViewById(com.alibaba.griver.file.R.id.list);
                    this.f = (LinearLayout) findViewById(com.alibaba.griver.file.R.id.ll_file_not_support);
                    if (OfficeFileType.Pdf.checkType(this.b)) {
                        this.d.setTitleText(getString(com.alibaba.griver.file.R.string.griver_open_document));
                        ProgressDialog progressDialog = new ProgressDialog(this);
                        this.c = progressDialog;
                        progressDialog.show();
                        if (Build.VERSION.SDK_INT >= 33) {
                            strArr = new String[]{"android.permission.READ_MEDIA_AUDIO", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES"};
                        } else {
                            strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
                        }
                        if (!PermissionUtils.hasPermission(strArr)) {
                            PermissionUtils.requestPermissions(strArr, 2001, new IPermissionRequestCallback() { // from class: com.alibaba.griver.file.ui.FileViewerActivity.2
                                @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
                                public void onRequestPermissionResult(int i2, String[] strArr2, int[] iArr) {
                                    GriverLogger.d("FileViewerActivity", "receive request permission result");
                                    if (PermissionUtils.positivePermissionResult(iArr)) {
                                        FileViewerActivity.this.b();
                                        return;
                                    }
                                    FileViewerActivity.this.d();
                                    ToastUtils.showToast(GriverEnv.getApplicationContext(), FileViewerActivity.this.getString(com.alibaba.griver.file.R.string.griver_lack_read_external_perission), 0);
                                }
                            });
                            return;
                        } else {
                            b();
                            return;
                        }
                    }
                    c();
                } catch (Exception e) {
                    GriverLogger.e("FileViewerActivity", "view file error", e);
                    d();
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.io.OutputStream] */
    private void a(File file, File file2) {
        Throwable th;
        ?? r11;
        Exception e;
        if (file2.exists()) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    ?? fileOutputStream = new FileOutputStream(file2);
                    try {
                        FileChannel channel = fileOutputStream.getChannel();
                        FileChannel channel2 = fileInputStream2.getChannel();
                        channel2.transferTo(0L, channel2.size(), channel);
                        fileInputStream2.close();
                        fileOutputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fileOutputStream;
                        r11 = fileInputStream;
                        fileInputStream = fileInputStream2;
                        try {
                            GriverLogger.e("FileViewerActivity", "open file fail", e);
                            fileInputStream.close();
                            r11.close();
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                fileInputStream.close();
                                r11.close();
                            } catch (Exception e3) {
                                GriverLogger.e("FileViewerActivity", "close file stream fail", e3);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileOutputStream;
                        r11 = fileInputStream;
                        fileInputStream = fileInputStream2;
                        fileInputStream.close();
                        r11.close();
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e5) {
                e = e5;
                r11 = 0;
            } catch (Throwable th5) {
                th = th5;
                r11 = 0;
            }
        } catch (Exception e6) {
            GriverLogger.e("FileViewerActivity", "close file stream fail", e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Uri fromFile;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6538a);
            sb.append(".");
            sb.append(this.b);
            File file = new File(sb.toString());
            a(new File(this.f6538a), file);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.addFlags(1);
            intent.addFlags(2);
            if (Build.VERSION.SDK_INT >= 24) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(getPackageName());
                sb2.append(".griver.file.provider");
                fromFile = FileProvider.getUriForFile(this, sb2.toString(), file);
            } else {
                fromFile = Uri.fromFile(file);
            }
            intent.setDataAndType(fromFile, MimeTypeUtil.getMimeTypeByExtension(this.b));
            intent.putExtra("android.intent.extra.STREAM", fromFile);
            startActivity(Intent.createChooser(intent, getString(com.alibaba.griver.file.R.string.griver_open_file_with)));
        } catch (Throwable th) {
            GriverLogger.e("FileViewerActivity", "open share page fail", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f.setVisibility(8);
        this.e.setVisibility(0);
        this.e.setEnableScale(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.e.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(1);
        this.e.setAdapter(new PageAdapter());
        this.e.addItemDecoration(new DividerGridItemDecoration());
        this.e.setItemAnimator(new DefaultItemAnimator());
    }

    private void c() {
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        TextView textView = (TextView) findViewById(com.alibaba.griver.file.R.id.tv_filename);
        TextView textView2 = (TextView) findViewById(com.alibaba.griver.file.R.id.tv_share_btn);
        int i = com.alibaba.griver.file.R.string.griver_file_name_pattern;
        StringBuilder sb = new StringBuilder();
        sb.append(a(this.f6538a));
        sb.append(".");
        sb.append(this.b);
        textView.setText(getString(i, sb.toString()));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.file.ui.FileViewerActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FileViewerActivity.this.a();
            }
        });
    }

    private String a(String str) {
        int lastIndexOf;
        return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(File.separator)) == -1) ? "" : str.substring(lastIndexOf + 1);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        PdfSourceManager.getInstance().destory(this.f6538a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ProgressDialog progressDialog = this.c;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.c.dismiss();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        RVNativePermissionRequestProxy rVNativePermissionRequestProxy = (RVNativePermissionRequestProxy) RVProxy.get(RVNativePermissionRequestProxy.class);
        if (rVNativePermissionRequestProxy != null) {
            rVNativePermissionRequestProxy.onRequestPermissionResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class PageAdapter extends RecyclerView.Adapter<PageImageHolder> {

        /* renamed from: a  reason: collision with root package name */
        private Activity f6539a;
        private PdfImageSource b;

        public PageAdapter() {
            this.f6539a = FileViewerActivity.this;
            GriverExecutors.getExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.griver.file.ui.FileViewerActivity.PageAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    Resources resources = FileViewerActivity.this.getResources();
                    if (resources != null) {
                        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                        int i = displayMetrics.widthPixels;
                        int i2 = displayMetrics.heightPixels;
                        PageAdapter.this.b = PdfSourceManager.getInstance().getOrCreate(FileViewerActivity.this.f6538a, i, i2);
                    }
                    FileViewerActivity.this.d();
                    PageAdapter.this.a();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            FileViewerActivity.this.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.file.ui.FileViewerActivity.PageAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    PageAdapter.this.notifyDataSetChanged();
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public PageImageHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new PageImageHolder(LayoutInflater.from(this.f6539a).inflate(com.alibaba.griver.file.R.layout.griver_file_item_page_image, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(PageImageHolder pageImageHolder, int i) {
            pageImageHolder.bindData(this.b.getItem(i), i, this.b.getTotalCount());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getGetAuthRequestContext() {
            PdfImageSource pdfImageSource = this.b;
            if (pdfImageSource == null) {
                return 0;
            }
            return pdfImageSource.getTotalCount();
        }

        /* loaded from: classes6.dex */
        public class PageImageHolder extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            private ImageView f6540a;
            private TextView b;

            public PageImageHolder(View view) {
                super(view);
                this.f6540a = (ImageView) view.findViewById(com.alibaba.griver.file.R.id.page);
                this.b = (TextView) view.findViewById(com.alibaba.griver.file.R.id.page_index);
                WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                int i = displayMetrics.widthPixels;
                double d = i;
                Double.isNaN(d);
                int i2 = (int) (d * 1.42d);
                ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
                layoutParams.width = i;
                layoutParams.height = i2;
            }

            public void bindData(Bitmap bitmap, int i, int i2) {
                ViewGroup.LayoutParams layoutParams = this.f6540a.getLayoutParams();
                double d = layoutParams.width;
                Double.isNaN(d);
                layoutParams.height = (int) (d * 1.42d);
                this.f6540a.setImageBitmap(bitmap);
                this.b.setText(String.format("%d/%d", Integer.valueOf(i + 1), Integer.valueOf(i2)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class DividerGridItemDecoration extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            super.onDraw(canvas, recyclerView, state);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            super.onDrawOver(canvas, recyclerView, state);
        }
    }

    private static void g(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = MyBillsEntityDataFactory;
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
        int[] iArr5 = MyBillsEntityDataFactory;
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

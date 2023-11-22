package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.IBinder;
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
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.bg;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes8.dex */
public class MessageHandleService extends BaseService {
    public static final byte[] $$d = {94, Ascii.EM, -44, 73, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 255;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {119, -93, -18, -42, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int MyBillsEntityDataFactory = 229;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentLinkedQueue<a> f7737a;

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f75a;
    private static long getAuthRequestContext;
    private static int scheduleImpl;

    /* loaded from: classes8.dex */
    public static class a {
        Intent BuiltInFictitiousFunctionClassFactory;
        PushMessageReceiver MyBillsEntityDataFactory;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.MyBillsEntityDataFactory = pushMessageReceiver;
            this.BuiltInFictitiousFunctionClassFactory = intent;
        }
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        f7737a = new ConcurrentLinkedQueue<>();
        f75a = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        NetworkUserEntityData$$ExternalSyntheticLambda0 = (char) 13492;
        getAuthRequestContext = -8090644998727485224L;
        scheduleImpl = -956812108;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        b(context);
    }

    public static void addJob(Context context, a aVar) {
        if (aVar != null) {
            f7737a.add(aVar);
            b(context);
            startService(context);
        }
    }

    private static void b(Context context) {
        if (f75a.isShutdown()) {
            return;
        }
        f75a.execute(new t(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        try {
            a(context, f7737a.poll());
        } catch (RuntimeException e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 2
            int r6 = 16 - r6
            int r7 = 106 - r7
            byte[] r0 = com.xiaomi.mipush.sdk.MessageHandleService.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 15
            int r8 = r8 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L33:
            int r8 = r8 + 1
            int r9 = r9 + r6
            int r6 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MessageHandleService.h(short, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void i(int r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 2
            int r7 = 103 - r7
            byte[] r0 = com.xiaomi.mipush.sdk.MessageHandleService.$$d
            int r9 = r9 * 3
            int r9 = r9 + 21
            int r8 = 46 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L18
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L18:
            r3 = 0
        L19:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            int r8 = r8 + 1
            if (r4 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L34:
            int r8 = -r8
            int r9 = r9 + r8
            int r8 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MessageHandleService.i(int, int, byte, java.lang.Object[]):void");
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    protected boolean mo257a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = f7737a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        g((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 52371), View.MeasureSpec.getSize(0), new char[]{1904, 42577, 38015, 6604}, new char[]{8816, 59413, 41751, 39333, 58270, 13968, 62019, 36567, 64230, 49152, 53524, 19858, 17698, 41771, 16057, 51537, 52851, 23100}, new char[]{35948, 39414, 6971, 45885}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        g((char) (59310 - ImageFormat.getBitsPerPixel(0)), (-1783833110) - Color.argb(0, 0, 0, 0), new char[]{60021, 44253, 44949, 31207}, new char[]{51069, 50154, 8001, 12737, 54210}, new char[]{35948, 39414, 6971, 45885}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0') + 36, (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    g((char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), TextUtils.indexOf((CharSequence) "", '0') + 1, new char[]{48736, 17495, 63403, 45934}, new char[]{51165, 11963, 30480, 3058, 35300, 700, 39634, 60939, 10132, 43957, 19907, 56989, 3635, 20720, 6094, 48682, 61750, 10149, 8480, 367, 21648, 16235, 29508, 63831, 6805, 687, 47905, 21491, 6834, 40463, 62501, 24825, 65313, 33756, 46132, 25762, 63956, 56655, 63364, 56826, 18924, 50690, 53900, 3741, 21542, 33018, 55096, 61304}, new char[]{35948, 39414, 6971, 45885}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g((char) (Process.myPid() >> 22), 1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new char[]{28610, 30436, 18828, 16273}, new char[]{62255, 44758, 29552, 10791, 31232, 25842, 58198, 24592, 23159, 36446, 18567, 45550, 3906, 53256, 7780, 29441, 18451, 63287, 49723, 24491, 44702, 20261, 52537, 64350, 4514, 24732, 21144, 6427, 61780, 13830, 12125, 53245, 56476, 46396, 17545, 45234, 40484, 24486, 55894, 60594, 15689, 59982, 42956, 25188, 65499, 60830, 11932, 15390, 33563, 52540, 5902, 53709, 48922, 62154, 35826, 28134, 47556, 4395, 38227, 10984, 29212, 48935, 34059, 61113}, new char[]{35948, 39414, 6971, 45885}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g((char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), ExpandableListView.getPackedPositionGroup(0L), new char[]{57630, 4183, 24457, 2050}, new char[]{8092, 55156, 64346, 64006, 33638, 15227, 54974, 18282, 24141, 63840, 40270, 33085, 14225, 38405, 10284, 13353, 25165, 7664, 61089, 52354, 11789, 24503, 16937, 49762, 9106, 63718, 17549, 25918, 1884, 3549, 37992, 65286, 21767, 39847, 3616, 35061, 43293, 48469, 10986, 6565, 2628, 23379, 5659, 60253, 43688, 57883, 29690, 20301, 60564, 39255, 31100, 23843, 56779, 46605, 5311, 47218, 44465, 44487, 2708, 12589, 5629, 3803, 25209, 29104}, new char[]{35948, 39414, 6971, 45885}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g((char) View.MeasureSpec.makeMeasureSpec(0, 0), TextUtils.getOffsetBefore("", 0), new char[]{48565, 39639, 19633, 1539}, new char[]{24722, 7767, 34421, 514, 55289, 32337, 16993, 52330, 30305, 56875, 7384, 63334, 45533, 63193, 18366, 21016, 36157, 13865, 49900, 42536, 64691, 12355, 14915, 55002, 9495, 63892, 21918, 11233, 32343, 20041, 45788, 33547, 19477, 23228, 64270, 30408, 2822, 22519, 30022, 4951, 31030, 995, 10071, 7448, 31621, 54768, 8356, 62993, 26667, 7040, 7535, 47590, 24748, 54163, 22371, 64411, 6177, 34080, 6228, 19374}, new char[]{35948, 39414, 6971, 45885}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    g((char) (50912 - (Process.myTid() >> 22)), Color.alpha(0), new char[]{42288, 13310, 57530, 39110}, new char[]{16954, 45788, 12777, 8980, 55494, 46447}, new char[]{35948, 39414, 6971, 45885}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), 19 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                Object[] objArr13 = new Object[1];
                h(b, b, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
                Object[] objArr14 = new Object[1];
                h(b2, b3, (byte) (b3 - 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 55, 3 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)));
                        Object[] objArr16 = new Object[1];
                        i((byte) (-$$d[12]), (byte) (-$$d[53]), $$d[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(848 - AndroidCharacter.getMirror('0'), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 15, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.getDefaultSize(0, 0), 15 - Color.blue(0), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 815, 29 - TextUtils.indexOf("", "", 0), (char) (57994 - (KeyEvent.getMaxKeyCode() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 16, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-679851410, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.red(0), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                Object[] objArr20 = new Object[1];
                h(b4, b4, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                byte b5 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                byte b6 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
                Object[] objArr21 = new Object[1];
                h(b5, b6, (byte) (b6 - 1), objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - TextUtils.indexOf("", "", 0), (ViewConfiguration.getLongPressTimeout() >> 16) + 46, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)));
                        Object[] objArr23 = new Object[1];
                        i((byte) ($$d[47] - 1), $$d[20], (byte) ($$d[47] - 1), objArr23);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ((Process.getThreadPriority(0) + 20) >> 6), 35 - TextUtils.getTrimmedLength(""), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr25 = {-679851410, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 911, 18 - (Process.myPid() >> 22), (char) Color.green(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                Object[] objArr27 = new Object[1];
                h(b7, b7, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                byte b8 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                byte b9 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
                Object[] objArr28 = new Object[1];
                h(b8, b9, (byte) (b9 - 1), objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getEdgeSlop() >> 16), (ViewConfiguration.getLongPressTimeout() >> 16) + 3, (char) (KeyEvent.normalizeMetaState(0) + 38968));
                        Object[] objArr30 = new Object[1];
                        i((byte) ($$d[47] - 1), $$d[20], (byte) ($$d[47] - 1), objArr30);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.getDeadChar(0, 0), 34 - MotionEvent.axisFromString(""), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {-679851410, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, 'B' - AndroidCharacter.getMirror('0'), (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b10 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                Object[] objArr34 = new Object[1];
                h(b10, b10, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                byte b11 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                byte b12 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
                Object[] objArr35 = new Object[1];
                h(b11, b12, (byte) (b12 - 1), objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getScrollBarSize() >> 8), 3 - TextUtils.indexOf("", "", 0, 0), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                        Object[] objArr37 = new Object[1];
                        i((byte) (-$$d[9]), (byte) ($$d[47] - 1), (byte) (-$$d[8]), objArr37);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.indexOf((CharSequence) "", '0'), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr39 = {-679851410, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 912, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, (char) (MotionEvent.axisFromString("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // com.xiaomi.mipush.sdk.BaseService, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onCreate() {
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            Object[] objArr = new Object[1];
            h(b, b, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
            Object[] objArr2 = new Object[1];
            h(b2, b3, (byte) (b3 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getTapTimeout() >> 16), 4 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))));
                    Object[] objArr4 = new Object[1];
                    i((byte) (-$$d[9]), (byte) ($$d[47] - 1), (byte) (-$$d[8]), objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1632781477, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 911, 18 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, a aVar) {
        String[] stringArrayExtra;
        if (aVar == null) {
            return;
        }
        try {
            PushMessageReceiver pushMessageReceiver = aVar.MyBillsEntityDataFactory;
            Intent intent = aVar.BuiltInFictitiousFunctionClassFactory;
            int intExtra = intent.getIntExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE, 1);
            if (intExtra == 1) {
                PushMessageHandler.a PlaceComponentResult = ae.MyBillsEntityDataFactory(context).PlaceComponentResult(intent);
                intent.getIntExtra("eventMessageType", -1);
                if (PlaceComponentResult == null) {
                    return;
                }
                if (PlaceComponentResult instanceof MiPushMessage) {
                    MiPushMessage miPushMessage = (MiPushMessage) PlaceComponentResult;
                    if (!miPushMessage.isArrivedMessage()) {
                        pushMessageReceiver.onReceiveMessage(context, miPushMessage);
                    }
                    if (miPushMessage.getPassThrough() == 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("begin execute onReceivePassThroughMessage from ");
                        sb.append(miPushMessage.getMessageId());
                        com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb.toString());
                        pushMessageReceiver.onReceivePassThroughMessage(context, miPushMessage);
                        return;
                    } else if (miPushMessage.isNotified()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("begin execute onNotificationMessageClicked from\u3000");
                        sb2.append(miPushMessage.getMessageId());
                        com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb2.toString());
                        pushMessageReceiver.onNotificationMessageClicked(context, miPushMessage);
                        return;
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("begin execute onNotificationMessageArrived from ");
                        sb3.append(miPushMessage.getMessageId());
                        com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb3.toString());
                        pushMessageReceiver.onNotificationMessageArrived(context, miPushMessage);
                        return;
                    }
                } else if (!(PlaceComponentResult instanceof MiPushCommandMessage)) {
                    return;
                } else {
                    MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) PlaceComponentResult;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("begin execute onCommandResult, command=");
                    sb4.append(miPushCommandMessage.getCommand());
                    sb4.append(", resultCode=");
                    sb4.append(miPushCommandMessage.getResultCode());
                    sb4.append(", reason=");
                    sb4.append(miPushCommandMessage.getReason());
                    com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb4.toString());
                    pushMessageReceiver.onCommandResult(context, miPushCommandMessage);
                    if (!TextUtils.equals(miPushCommandMessage.getCommand(), bg.COMMAND_REGISTER.f83a)) {
                        return;
                    }
                    pushMessageReceiver.onReceiveRegisterResult(context, miPushCommandMessage);
                    PushMessageHandler.a(context, miPushCommandMessage);
                    if (miPushCommandMessage.getResultCode() != 0) {
                        return;
                    }
                }
            } else if (intExtra != 3) {
                if (intExtra == 5 && "error_lack_of_permission".equals(intent.getStringExtra("error_type")) && (stringArrayExtra = intent.getStringArrayExtra(TrackerKey.Property.ERROR_MESSAGE_FIREBASE)) != null) {
                    com.xiaomi.channel.commonutils.logger.b.moveToNextValue("begin execute onRequirePermissions, lack of necessary permissions");
                    pushMessageReceiver.onRequirePermissions(context, stringArrayExtra);
                    return;
                }
                return;
            } else {
                MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) intent.getSerializableExtra("key_command");
                StringBuilder sb5 = new StringBuilder();
                sb5.append("(Local) begin execute onCommandResult, command=");
                sb5.append(miPushCommandMessage2.getCommand());
                sb5.append(", resultCode=");
                sb5.append(miPushCommandMessage2.getResultCode());
                sb5.append(", reason=");
                sb5.append(miPushCommandMessage2.getReason());
                com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb5.toString());
                pushMessageReceiver.onCommandResult(context, miPushCommandMessage2);
                if (!TextUtils.equals(miPushCommandMessage2.getCommand(), bg.COMMAND_REGISTER.f83a)) {
                    return;
                }
                pushMessageReceiver.onReceiveRegisterResult(context, miPushCommandMessage2);
                PushMessageHandler.a(context, miPushCommandMessage2);
                if (miPushCommandMessage2.getResultCode() != 0) {
                    return;
                }
            }
            g.BuiltInFictitiousFunctionClassFactory(context);
        } catch (RuntimeException e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
        }
    }

    public static void startService(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, MessageHandleService.class));
        com.xiaomi.push.o PlaceComponentResult = com.xiaomi.push.o.PlaceComponentResult(context);
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.schedule(new s(context, intent), 0L, TimeUnit.SECONDS);
    }

    private static void g(char c, int i, char[] cArr, char[] cArr2, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr2.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr2[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (getAuthRequestContext ^ 4360990799332652212L)) ^ ((int) (scheduleImpl ^ 4360990799332652212L))) ^ ((char) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}

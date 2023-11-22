package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.bg;
import id.dana.onboarding.splash.LauncherActivity;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes8.dex */
public class PushMessageHandler extends BaseService {
    private static int[] MyBillsEntityDataFactory;

    /* renamed from: a  reason: collision with root package name */
    private static List<MiPushClient.ICallbackResult> f7739a;

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f77a;
    private static List<MiPushClient.MiPushClientCallback> b;
    public static final byte[] $$d = {Ascii.ESC, -74, -29, -66, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 58;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {110, -41, 63, 58, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int getAuthRequestContext = 48;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface a extends Serializable {
    }

    static {
        getAuthRequestContext();
        f7739a = new ArrayList();
        b = new ArrayList();
        f77a = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a() {
        synchronized (b) {
            b.clear();
        }
    }

    public static void a(long j, String str, String str2) {
        synchronized (b) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : b) {
            }
        }
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e.getMessage());
        }
    }

    public static void a(Context context, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("addjob PushMessageHandler ");
        sb.append(intent);
        com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
        if (intent != null) {
            c(context, intent);
            a(context);
        }
    }

    private static void a(Context context, Intent intent, ResolveInfo resolveInfo, boolean z) {
        try {
            MessageHandleService.a aVar = new MessageHandleService.a(intent, (PushMessageReceiver) com.xiaomi.channel.commonutils.android.j.PlaceComponentResult(context, resolveInfo.activityInfo.name).newInstance());
            if (z) {
                MessageHandleService.a(context.getApplicationContext(), aVar);
            } else {
                MessageHandleService.addJob(context.getApplicationContext(), aVar);
            }
            MessageHandleService.a(context, new Intent(context.getApplicationContext(), MessageHandleService.class));
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(th);
        }
    }

    public static void a(Context context, a aVar) {
        if (aVar instanceof MiPushMessage) {
            a(context, (MiPushMessage) aVar);
        } else if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String command = miPushCommandMessage.getCommand();
            String str = null;
            if (bg.COMMAND_REGISTER.f83a.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (bg.COMMAND_SET_ALIAS.f83a.equals(command) || bg.COMMAND_UNSET_ALIAS.f83a.equals(command) || bg.COMMAND_SET_ACCEPT_TIME.f83a.equals(command)) {
                a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
            } else if (bg.COMMAND_SUBSCRIBE_TOPIC.f83a.equals(command)) {
                List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                    str = commandArguments2.get(0);
                }
                a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (bg.COMMAND_UNSUBSCRIBE_TOPIC.f83a.equals(command)) {
                List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                    str = commandArguments3.get(0);
                }
                b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(MiPushClient.ICallbackResult iCallbackResult) {
        synchronized (f7739a) {
            if (!f7739a.contains(iCallbackResult)) {
                f7739a.add(iCallbackResult);
            }
        }
    }

    protected static void a(MiPushClient.MiPushClientCallback miPushClientCallback) {
        synchronized (b) {
            if (!b.contains(miPushClientCallback)) {
                b.add(miPushClientCallback);
            }
        }
    }

    protected static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b() {
        synchronized (f7739a) {
            f7739a.clear();
        }
    }

    private static void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("action_clicked_activity_finish");
            context.sendBroadcast(intent, b.MyBillsEntityDataFactory(context));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("callback sync error");
            sb.append(e);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(Context context, Intent intent) {
        boolean z = false;
        try {
            z = intent.getBooleanExtra("is_clicked_activity_call", false);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("intent unparcel error:");
            sb.append(th);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        }
        try {
            if (!"com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                if (1 == PushMessageHelper.getAuthRequestContext(context)) {
                    if (m256b()) {
                        com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("receive a message before application calling initialize");
                        if (z) {
                            b(context);
                            return;
                        }
                        return;
                    }
                    a PlaceComponentResult = ae.MyBillsEntityDataFactory(context).PlaceComponentResult(intent);
                    if (PlaceComponentResult != null) {
                        a(context, PlaceComponentResult);
                    }
                } else if (!"com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                    Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                    intent2.setPackage(context.getPackageName());
                    intent2.putExtras(intent);
                    try {
                        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                        ResolveInfo resolveInfo = null;
                        if (queryBroadcastReceivers != null) {
                            Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ResolveInfo next = it.next();
                                if (next.activityInfo != null && next.activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(com.xiaomi.channel.commonutils.android.j.PlaceComponentResult(context, next.activityInfo.name))) {
                                    resolveInfo = next;
                                    break;
                                }
                            }
                        }
                        if (resolveInfo != null) {
                            a(context, intent2, resolveInfo, z);
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("cannot find the receiver to handler this message, check your manifest");
                        }
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                    }
                }
            }
            if (!z) {
            }
        } catch (Throwable th2) {
            try {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(th2);
            } finally {
                if (z) {
                    b(context);
                }
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m256b() {
        return b.isEmpty();
    }

    private static void c(Context context, Intent intent) {
        if (intent == null || f77a.isShutdown()) {
            return;
        }
        f77a.execute(new ad(context, intent));
    }

    static void getAuthRequestContext() {
        MyBillsEntityDataFactory = new int[]{683485486, -1269598987, 1125726671, 483985205, -107229437, 173732571, 1925200951, -483842712, 522474536, 646602341, 820248329, -1671103206, 1905640005, 1203916137, -280006638, 460399770, -805481554, 1295902799};
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0030 -> B:11:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 15
            int r8 = 18 - r8
            byte[] r0 = com.xiaomi.mipush.sdk.PushMessageHandler.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = 106 - r6
            int r7 = r7 * 2
            int r7 = 16 - r7
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r6 = r8
            r3 = r1
            r4 = 0
            r8 = r7
            r1 = r0
            r0 = r9
            r9 = r6
            goto L39
        L1b:
            r3 = 0
            r5 = r8
            r8 = r6
            r6 = r5
        L1f:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            int r6 = r6 + 1
            if (r3 != r7) goto L30
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L30:
            r3 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L39:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.PushMessageHandler.h(byte, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void i(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.xiaomi.mipush.sdk.PushMessageHandler.$$d
            int r8 = r8 * 3
            int r8 = r8 + 21
            int r6 = r6 + 4
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r6 = r6 + 1
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.PushMessageHandler.i(byte, short, short, java.lang.Object[]):void");
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a  reason: collision with other method in class */
    protected boolean mo257a() {
        ThreadPoolExecutor threadPoolExecutor = f77a;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f77a.getQueue().size() <= 0) ? false : true;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        g(Color.green(0) + 18, new int[]{-2053576340, 768831228, -1388280565, -141133596, 947129986, 444599640, -690009441, -866958491, 279513683, 153247774}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        g(TextUtils.indexOf((CharSequence) "", '0') + 6, new int[]{1786582452, 1909299181, -1847262125, 108195067}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    g(48 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new int[]{680642877, 2095409898, -2118679504, -1259120166, -1607287232, 670225327, -1487027786, -1480117343, 1605119046, 508122147, -1774455282, 506639889, 1213619138, -59952030, -1814574010, -269438277, -603677545, 1118058152, 1143690684, 996388457, -1587489951, -482853521, -1740524161, 586303152}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 63, new int[]{1354787052, -282349235, 1143495338, -706801326, 1908808403, -325663050, -1951041151, -1672809151, 833538656, 416813922, 381280483, -101923612, -1160061711, 1189203942, -1406178645, 386218689, 1272621293, -1048426127, 1868358981, -1772959092, -1979552839, -949395577, -1925614775, 1041486358, -1876935740, 1906112769, -1287730667, 1447488148, -345104708, 875979563, -1263271031, -1111312876}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g((ViewConfiguration.getPressedStateDuration() >> 16) + 64, new int[]{212579098, 107124085, -651142981, 1702229678, 528626828, -294565587, -688383393, 2119903257, 2080320488, -1965051721, -1045024563, 468026709, -1190220513, 597268443, -263556024, 7989827, 1549017721, 1520901673, 1653179675, -89731512, -1569229146, 1822736225, -1172981055, -103029680, -1029503768, -1245646256, -927062343, -587926375, -390071312, 560011139, -1787273651, 1643955224}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 59, new int[]{1062577910, -915619211, 1776132882, -1985126397, -941821861, 2075368849, -2113824289, -865428748, 1443069593, -1906329991, 745811649, -2093106979, 1873799091, -1311083131, -2141125211, -306055484, 1988313586, 135781112, -665894322, 1048688002, -1058254744, -600576867, -1492417308, -1841784820, 1321432808, 130770669, -991586054, 875221189, 596736200, -1367798071}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    g(TextUtils.indexOf((CharSequence) "", '0', 0) + 7, new int[]{-1430690267, 1552789946, 2023416059, -661758114}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, Drawable.resolveOpacity(0, 0) + 18, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                byte b3 = b2;
                Object[] objArr13 = new Object[1];
                h(b2, b3, b3, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr14 = new Object[1];
                h(b4, (byte) (b4 - 1), KClassImpl$Data$declaredNonStaticMembers$2[5], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(56 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getJumpTapTimeout() >> 16) + 3, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                        byte b5 = (byte) ($$d[47] - 1);
                        byte b6 = $$d[47];
                        Object[] objArr16 = new Object[1];
                        i(b5, b6, b6, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 15 - View.MeasureSpec.getSize(0), (char) Color.green(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 14, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 815, MotionEvent.axisFromString("") + 30, (char) (57994 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 800, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 14, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - Process.getGidForName(""), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-2062342863, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.keyCodeFromString(""), Color.blue(0) + 18, (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                byte b8 = b7;
                Object[] objArr20 = new Object[1];
                h(b7, b8, b8, objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                byte b9 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr21 = new Object[1];
                h(b9, (byte) (b9 - 1), KClassImpl$Data$declaredNonStaticMembers$2[5], objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 61, '^' - AndroidCharacter.getMirror('0'), (char) Drawable.resolveOpacity(0, 0));
                        Object[] objArr23 = new Object[1];
                        i((byte) 23, (byte) (-$$d[9]), (byte) ($$d[47] - 1), objArr23);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr25 = {-2062342863, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 911, TextUtils.getOffsetAfter("", 0) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b10 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                byte b11 = b10;
                Object[] objArr27 = new Object[1];
                h(b10, b11, b11, objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                byte b12 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr28 = new Object[1];
                h(b12, (byte) (b12 - 1), KClassImpl$Data$declaredNonStaticMembers$2[5], objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 118, (-16777213) - Color.rgb(0, 0, 0), (char) (TextUtils.getOffsetAfter("", 0) + 38968));
                        Object[] objArr30 = new Object[1];
                        i((byte) 23, (byte) (-$$d[9]), (byte) ($$d[47] - 1), objArr30);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {-2062342863, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 910, (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b13 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                byte b14 = b13;
                Object[] objArr34 = new Object[1];
                h(b13, b14, b14, objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                byte b15 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr35 = new Object[1];
                h(b15, (byte) (b15 - 1), KClassImpl$Data$declaredNonStaticMembers$2[5], objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - Drawable.resolveOpacity(0, 0), AndroidCharacter.getMirror('0') - '-', (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
                        Object[] objArr37 = new Object[1];
                        i((byte) (-$$d[53]), (byte) ($$d[47] - 1), (byte) (-$$d[8]), objArr37);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0) + 36, (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr39 = {-2062342863, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
            byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
            byte b3 = b2;
            Object[] objArr = new Object[1];
            h(b2, b3, b3, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            Object[] objArr2 = new Object[1];
            h(b4, (byte) (b4 - 1), KClassImpl$Data$declaredNonStaticMembers$2[5], objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 494, 4 - (ViewConfiguration.getTouchSlop() >> 8), (char) Color.alpha(0));
                    Object[] objArr4 = new Object[1];
                    i((byte) (-$$d[53]), (byte) ($$d[47] - 1), (byte) (-$$d[8]), objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getFadingEdgeLength() >> 16), 35 - Color.green(0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-232836224, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 911, 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        c(getApplicationContext(), intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, MiPushCommandMessage miPushCommandMessage) {
        synchronized (f7739a) {
            Iterator<MiPushClient.ICallbackResult> it = f7739a.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof MiPushClient.UPSRegisterCallBack) {
                    MiPushClient.TokenResult tokenResult = new MiPushClient.TokenResult();
                    if (miPushCommandMessage != null && miPushCommandMessage.getCommandArguments() != null && miPushCommandMessage.getCommandArguments().size() > 0) {
                        tokenResult.PlaceComponentResult = miPushCommandMessage.getResultCode();
                        tokenResult.BuiltInFictitiousFunctionClassFactory = miPushCommandMessage.getCommandArguments().get(0);
                    }
                }
            }
        }
    }

    public static void a(Context context, MiPushMessage miPushMessage) {
        synchronized (b) {
            Iterator<MiPushClient.MiPushClientCallback> it = b.iterator();
            while (it.hasNext()) {
                if (a(miPushMessage.getCategory(), it.next().getAuthRequestContext)) {
                    miPushMessage.getContent();
                    miPushMessage.getAlias();
                    miPushMessage.getTopic();
                    miPushMessage.isNotified();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, String str, long j, String str2, String str3) {
        synchronized (b) {
            Iterator<MiPushClient.MiPushClientCallback> it = b.iterator();
            while (it.hasNext()) {
                a(str, it.next().getAuthRequestContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, String str, String str2, long j, String str3, List<String> list) {
        synchronized (b) {
            Iterator<MiPushClient.MiPushClientCallback> it = b.iterator();
            while (it.hasNext()) {
                a(str, it.next().getAuthRequestContext);
            }
        }
    }

    protected static void b(Context context, String str, long j, String str2, String str3) {
        synchronized (b) {
            Iterator<MiPushClient.MiPushClientCallback> it = b.iterator();
            while (it.hasNext()) {
                a(str, it.next().getAuthRequestContext);
            }
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

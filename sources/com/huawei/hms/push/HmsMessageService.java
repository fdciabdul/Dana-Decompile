package com.huawei.hms.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
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
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.push.t;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import id.dana.danah5.transactionstatus.TransactionStatusBridge;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class HmsMessageService extends Service {
    public static final String PROXY_TYPE = "proxy_type";
    public static final String SUBJECT_ID = "subject_id";

    /* renamed from: a  reason: collision with root package name */
    public final Messenger f7479a = new Messenger(new t(new a(this, 0)));
    public static final byte[] $$a = {42, -48, 107, -19, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 248;
    public static final byte[] getAuthRequestContext = {83, 16, 71, 115, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int BuiltInFictitiousFunctionClassFactory = 9;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = -5179104140446010824L;

    /* loaded from: classes8.dex */
    class a implements t.a {
        private a() {
        }

        @Override // com.huawei.hms.push.t.a
        public final void BuiltInFictitiousFunctionClassFactory(Message message) {
            if (message == null) {
                HMSLog.e("HmsMessageService", "receive message is null");
                return;
            }
            HMSLog.i("HmsMessageService", "handle message start...");
            Bundle data = Message.obtain(message).getData();
            if (data != null) {
                Intent intent = new Intent();
                intent.putExtras(data);
                intent.putExtra(RequestConstants.Pin.INPUTTYPE, data.getInt(RequestConstants.Pin.INPUTTYPE, -1));
                HmsMessageService.this.handleIntentMessage(intent);
            }
        }

        public /* synthetic */ a(HmsMessageService hmsMessageService, byte b) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.huawei.hms.push.HmsMessageService.getAuthRequestContext
            int r6 = r6 + 105
            int r8 = r8 * 4
            int r8 = r8 + 16
            int r7 = r7 * 15
            int r7 = 18 - r7
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L35
        L19:
            r3 = 0
        L1a:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
            int r8 = r8 + r6
            int r6 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.HmsMessageService.d(int, short, int, java.lang.Object[]):void");
    }

    private static void e(byte b, int i, short s, Object[] objArr) {
        byte[] bArr = $$a;
        int i2 = (b * 3) + 21;
        int i3 = (s * 2) + 75;
        int i4 = i + 4;
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            i3 = (i6 + i4) - 7;
            i6 = i6;
            i4 = i4;
        }
        while (true) {
            i5++;
            int i7 = i4 + 1;
            bArr2[i5] = (byte) i3;
            if (i5 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3 = (i3 + bArr[i7]) - 7;
            i6 = i6;
            i4 = i7;
        }
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Context applicationContext = getApplicationContext();
        if (str.equals(BaseUtils.BuiltInFictitiousFunctionClassFactory(applicationContext, str2))) {
            com.huawei.hms.opendevice.n.BuiltInFictitiousFunctionClassFactory(applicationContext, str);
            return;
        }
        HMSLog.i("HmsMessageService", "receive a token, refresh the local token");
        BaseUtils.MyBillsEntityDataFactory(applicationContext, str2, str);
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        c((-16777216) - Color.rgb(0, 0, 0), new char[]{18765, 44092, 24320, 11524, 18732, 4994, 8388, 4614, 46690, 4933, 8580, 5018, 47010, 4639, 8462, 4260, 46335, 4547, 8707, 4177, 46142, 4255}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        c((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{51482, 16729, 42171, 29083, 51575, 65264, 56142, 20098, 13886}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ImageFormat.getBitsPerPixel(0), 35 - TextUtils.getTrimmedLength(""), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    c(Color.red(0), new char[]{42441, 33501, 11117, 50089, 42494, 15726, 21755, 64737, 23225, 15785, 21940, 64801, 23422, 15592, 21806, 65087, 22636, 16255, 22076, 65199, 22776, 15932, 22523, 65464, 23021, 16046, 20718, 63535, 24109, 14782, 20597, 63805, 24379, 14377, 20844, 63996, 24560, 15163, 21247, 64224, 23791, 15348, 21429, 64297, 23934, 15083, 21369, 62575, 21099, 13694, 23611, 62716}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    c(TextUtils.getOffsetAfter("", 0), new char[]{3267, 64553, 19187, 41240, 3234, 17356, 13669, 40460, 62437, 17152, 13347, 40848, 61991, 16922, 13546, 40157, 61799, 16776, 14242, 39964, 61937, 16587, 13877, 40281, 61671, 16392, 12581, 39579, 63349, 18203, 12778, 39821, 63035, 18141, 12449, 39706, 63136, 17821, 13159, 38992, 62944, 17754, 12835, 39323, 62582, 17481, 12982, 38617, 64352, 19342, 15778, 38431, 64496, 19146, 15460, 38737, 64186, 18958, 16163, 38041, 63859, 18760, 16304, 38282, 63538, 18561, 16119, 38171}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    c(TextUtils.getOffsetBefore("", 0), new char[]{25634, 60279, 340, 37552, 25616, 21654, 32401, 44450, 39771, 21584, 32646, 44084, 39578, 21791, 32588, 44913, 39379, 22228, 31748, 44983, 39235, 22466, 32192, 44708, 38992, 22277, 31445, 43315, 40853, 20545, 31309, 43128, 40580, 20865, 31491, 43235, 40469, 21187, 30918, 44024, 40192, 21072, 31106, 43576, 40090, 21313, 31045, 42356, 37850, 23767, 30293, 42466, 37700, 23966, 30615, 42149, 37456, 23894, 29906, 42805, 37269, 24082, 29773, 42614, 36996, 24530, 29953, 42681}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    c(ExpandableListView.getPackedPositionType(0L), new char[]{45508, 56863, 19469, 30259, 45484, 25019, 13273, 18739, 20215, 24885, 12994, 18604, 20256, 24622, 12867, 19362, 19498, 25595, 12549, 19313, 19617, 25262, 12505, 18976, 19941, 25212, 14233, 19885, 18979, 25914, 14156, 19633, 19296, 25852, 13852, 19574, 19365, 26557, 13768, 20333, 18663, 26464, 13440, 20140, 18725, 26175, 13380, 16876, 18029, 27105, 15114, 16742, 18103, 26811, 14978, 16437, 18358, 26656, 14728, 17397, 17441, 27425, 14681, 17072}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    c(View.MeasureSpec.getMode(0), new char[]{61674, 63092, 2647, 13181, 61651, 18826, 30147, 3107, 3992, 18773}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 911, 18 - Color.argb(0, 0, 0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (-getAuthRequestContext[5]);
                byte b2 = (byte) (b - 1);
                Object[] objArr13 = new Object[1];
                d(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = (byte) (getAuthRequestContext[5] + 1);
                byte b4 = (byte) (-getAuthRequestContext[5]);
                Object[] objArr14 = new Object[1];
                d(b3, b4, (byte) (b4 - 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 55, 3 - KeyEvent.keyCodeFromString(""), (char) ((-1) - ImageFormat.getBitsPerPixel(0)));
                        Object[] objArr16 = new Object[1];
                        e($$a[78], $$a[47], $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), TextUtils.indexOf((CharSequence) "", '0') + 16, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 800, 15 - TextUtils.getOffsetAfter("", 0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - TextUtils.indexOf((CharSequence) "", '0'), 29 - KeyEvent.keyCodeFromString(""), (char) (57994 - (ViewConfiguration.getTouchSlop() >> 8)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 14, (char) (ViewConfiguration.getWindowTouchSlop() >> 8)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.alpha(0), (Process.myPid() >> 22) + 35, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1970489530, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getSize(0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = (byte) (-getAuthRequestContext[5]);
                byte b6 = (byte) (b5 - 1);
                Object[] objArr19 = new Object[1];
                d(b5, b6, b6, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b7 = (byte) (getAuthRequestContext[5] + 1);
                byte b8 = (byte) (-getAuthRequestContext[5]);
                Object[] objArr20 = new Object[1];
                d(b7, b8, (byte) (b8 - 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 61, 46 - TextUtils.indexOf("", ""), (char) ((-1) - ImageFormat.getBitsPerPixel(0)));
                        Object[] objArr22 = new Object[1];
                        e((byte) ($$a[78] - 1), $$a[28], $$a[9], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Drawable.resolveOpacity(0, 0), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1970489530, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, (char) Drawable.resolveOpacity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b9 = (byte) (-getAuthRequestContext[5]);
                byte b10 = (byte) (b9 - 1);
                Object[] objArr25 = new Object[1];
                d(b9, b10, b10, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b11 = (byte) (getAuthRequestContext[5] + 1);
                byte b12 = (byte) (-getAuthRequestContext[5]);
                Object[] objArr26 = new Object[1];
                d(b11, b12, (byte) (b12 - 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - TextUtils.getCapsMode("", 0, 0), 4 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (38969 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))));
                        Object[] objArr28 = new Object[1];
                        e((byte) ($$a[78] - 1), $$a[28], $$a[9], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Gravity.getAbsoluteGravity(0, 0), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1970489530, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 17, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b13 = (byte) (-getAuthRequestContext[5]);
                byte b14 = (byte) (b13 - 1);
                Object[] objArr31 = new Object[1];
                d(b13, b14, b14, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b15 = (byte) (getAuthRequestContext[5] + 1);
                byte b16 = (byte) (-getAuthRequestContext[5]);
                Object[] objArr32 = new Object[1];
                d(b15, b16, (byte) (b16 - 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 3 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) View.MeasureSpec.makeMeasureSpec(0, 0));
                        Object[] objArr34 = new Object[1];
                        e($$a[8], $$a[0], (byte) ($$a[78] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 35 - TextUtils.getTrimmedLength(""), (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1970489530, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 17, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    public final void b(Intent intent) {
        HMSLog.i("HmsMessageService", "parse batch response.");
        String stringExtra = intent.getStringExtra("batchMsgbody");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(stringExtra);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString(TransactionStatusBridge.Companion.TransactionStatusParamKey.TRANSACTION_ID);
                String optString2 = jSONObject.optString("msgId");
                int optInt = jSONObject.optInt("ret", ErrorEnum.ERROR_UNKNOWN.getInternalCode());
                if (ErrorEnum.SUCCESS.getInternalCode() == optInt) {
                    b(optString, optString2);
                } else {
                    b(optString, optString2, optInt);
                }
            }
        } catch (JSONException unused) {
            HMSLog.w("HmsMessageService", "parse batch response failed.");
        }
    }

    public void doMsgReceived(Intent intent) {
        onMessageReceived(new RemoteMessage(a(intent)));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    public void handleIntentMessage(Intent intent) {
        if (intent == null) {
            HMSLog.e("HmsMessageService", "receive message is null");
            return;
        }
        try {
            String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.MSGID_SERVER);
            String stringExtra2 = intent.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE);
            String stringExtra3 = intent.getStringExtra("transaction_id");
            if ("new_token".equals(stringExtra2)) {
                HMSLog.i("HmsMessageService", "onNewToken");
                a(intent, stringExtra3);
            } else if ("received_message".equals(stringExtra2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("onMessageReceived, message id:");
                sb.append(stringExtra);
                HMSLog.i("HmsMessageService", sb.toString());
                a(PushNaming.RECEIVE_MSG_RSP, stringExtra, ErrorEnum.SUCCESS.getInternalCode());
                doMsgReceived(intent);
            } else if ("sent_message".equals(stringExtra2)) {
                b(stringExtra3, stringExtra);
            } else if (Constants.MessageTypes.SEND_ERROR.equals(stringExtra2)) {
                b(stringExtra3, stringExtra, intent.getIntExtra("error", ErrorEnum.ERROR_UNKNOWN.getInternalCode()));
            } else if ("delivery".equals(stringExtra2)) {
                int intExtra = intent.getIntExtra("error", ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onMessageDelivery, message id:");
                sb2.append(stringExtra);
                sb2.append(", status:");
                sb2.append(intExtra);
                sb2.append(", transactionId: ");
                sb2.append(stringExtra3);
                HMSLog.i("HmsMessageService", sb2.toString());
                a(PushNaming.UPSEND_RECEIPT, stringExtra3, intExtra);
                onMessageDelivered(stringExtra, new SendException(intExtra));
            } else if ("server_deleted_message".equals(stringExtra2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("delete message, message id:");
                sb3.append(stringExtra);
                HMSLog.i("HmsMessageService", sb3.toString());
                onDeletedMessages();
            } else if ("batchSent".equals(stringExtra2)) {
                b(intent);
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Receive unknown message: ");
                sb4.append(stringExtra2);
                HMSLog.e("HmsMessageService", sb4.toString());
            }
        } catch (RuntimeException e) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handle intent RuntimeException: ");
            sb5.append(e.getMessage());
            HMSLog.e("HmsMessageService", sb5.toString());
        } catch (Exception e2) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("handle intent exception: ");
            sb6.append(e2.getMessage());
            HMSLog.e("HmsMessageService", sb6.toString());
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        HMSLog.i("HmsMessageService", "start to bind");
        return this.f7479a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            byte b = (byte) (-getAuthRequestContext[5]);
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            d(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (getAuthRequestContext[5] + 1);
            byte b4 = (byte) (-getAuthRequestContext[5]);
            Object[] objArr2 = new Object[1];
            d(b3, b4, (byte) (b4 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - TextUtils.getTrimmedLength(""), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 4, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                    Object[] objArr4 = new Object[1];
                    e($$a[8], $$a[0], (byte) ($$a[78] - 1), objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.combineMeasuredStates(0, 0), ((byte) KeyEvent.getModifierMetaStateMask()) + 36, (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {632139427, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Drawable.resolveOpacity(0, 0), Color.red(0) + 18, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    public void onDeletedMessages() {
    }

    @Override // android.app.Service
    public void onDestroy() {
        HMSLog.i("HmsMessageService", "start to destroy");
        super.onDestroy();
    }

    public void onMessageDelivered(String str, Exception exc) {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onNewToken(String str, Bundle bundle) {
    }

    public void onSendError(String str, Exception exc) {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("start to command , startId = ");
        sb.append(i2);
        HMSLog.i("HmsMessageService", sb.toString());
        handleIntentMessage(intent);
        return 2;
    }

    public void onTokenError(Exception exc) {
    }

    public void onTokenError(Exception exc, Bundle bundle) {
    }

    public final Bundle a(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.MessagePayloadKeys.MSGID_SERVER, intent.getStringExtra(Constants.MessagePayloadKeys.MSGID_SERVER));
        bundle.putByteArray("message_body", intent.getByteArrayExtra("message_body"));
        bundle.putString("device_token", intent.getStringExtra("device_token"));
        if (intent.getIntExtra(RequestConstants.Pin.INPUTTYPE, -1) == 1) {
            bundle.putInt(RequestConstants.Pin.INPUTTYPE, 1);
        }
        return bundle;
    }

    public final void b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("onMessageSent, message id:");
        sb.append(str2);
        sb.append(", transactionId: ");
        sb.append(str);
        HMSLog.i("HmsMessageService", sb.toString());
        a(PushNaming.UPSEND_MSG_ASYNC_RSP, str, ErrorEnum.SUCCESS.getInternalCode());
        onMessageSent(str2);
    }

    public final void a(Intent intent, String str) {
        int intExtra = intent.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode());
        a(PushNaming.GETTOKEN_ASYNC_RSP, str, intExtra);
        String stringExtra = intent.getStringExtra("subjectId");
        String stringExtra2 = intent.getStringExtra("message_proxy_type");
        StringBuilder sb = new StringBuilder();
        sb.append("doOnNewToken:transactionId = ");
        sb.append(str);
        sb.append(" , internalCode = ");
        sb.append(intExtra);
        sb.append(",subjectId:");
        sb.append(stringExtra);
        sb.append(",proxyType:");
        sb.append(stringExtra2);
        HMSLog.i("HmsMessageService", sb.toString());
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(stringExtra)) {
            bundle.putString(SUBJECT_ID, stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            bundle.putString(PROXY_TYPE, stringExtra2);
        }
        if (intExtra == ErrorEnum.SUCCESS.getInternalCode()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Apply token OnNewToken, subId: ");
            sb2.append(stringExtra);
            HMSLog.i("HmsMessageService", sb2.toString());
            a(intent, bundle, stringExtra);
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Apply token failed, subId: ");
        sb3.append(stringExtra);
        HMSLog.i("HmsMessageService", sb3.toString());
        a(intent, bundle, stringExtra, intExtra);
    }

    public final void b(String str, String str2, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onSendError, message id:");
        sb.append(str2);
        sb.append(" error:");
        sb.append(i);
        sb.append(", transactionId: ");
        sb.append(str);
        HMSLog.i("HmsMessageService", sb.toString());
        a(PushNaming.UPSEND_MSG_ASYNC_RSP, str, i);
        onSendError(str2, new SendException(i));
    }

    public final void a(Intent intent, Bundle bundle, String str, int i) {
        synchronized (this) {
            Context applicationContext = getApplicationContext();
            boolean isEmpty = TextUtils.isEmpty(BaseUtils.MyBillsEntityDataFactory(applicationContext, applicationContext.getPackageName()));
            if (bundle.isEmpty() && (!isEmpty) != false) {
                HMSLog.i("HmsMessageService", "onTokenError to host app.");
                onTokenError(new BaseException(i));
                BaseUtils.PlaceComponentResult(applicationContext, applicationContext.getPackageName());
            }
            if (TextUtils.isEmpty(str)) {
                String[] BuiltInFictitiousFunctionClassFactory2 = BaseUtils.BuiltInFictitiousFunctionClassFactory(applicationContext);
                if (BuiltInFictitiousFunctionClassFactory2 != null && BuiltInFictitiousFunctionClassFactory2.length != 0) {
                    for (int i2 = 0; i2 < BuiltInFictitiousFunctionClassFactory2.length; i2++) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(SUBJECT_ID, BuiltInFictitiousFunctionClassFactory2[i2]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("onTokenError to sub app, subjectId:");
                        sb.append(BuiltInFictitiousFunctionClassFactory2[i2]);
                        HMSLog.i("HmsMessageService", sb.toString());
                        onTokenError(new BaseException(i), bundle2);
                    }
                    BaseUtils.PlaceComponentResult(applicationContext);
                }
                HMSLog.i("HmsMessageService", "onTokenError to host app with bundle.");
                onTokenError(new BaseException(i), bundle);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onTokenError to sub app, subjectId:");
            sb2.append(str);
            HMSLog.i("HmsMessageService", sb2.toString());
            onTokenError(new BaseException(i), bundle);
        }
    }

    public final void a(Intent intent, Bundle bundle, String str) {
        synchronized (this) {
            String stringExtra = intent.getStringExtra("device_token");
            a(stringExtra, str);
            Context applicationContext = getApplicationContext();
            boolean isEmpty = TextUtils.isEmpty(BaseUtils.MyBillsEntityDataFactory(applicationContext, applicationContext.getPackageName()));
            if (bundle.isEmpty() && (!isEmpty) != false) {
                HMSLog.i("HmsMessageService", "onNewToken to host app.");
                onNewToken(stringExtra);
                BaseUtils.PlaceComponentResult(applicationContext, applicationContext.getPackageName());
            }
            if (TextUtils.isEmpty(str)) {
                String[] BuiltInFictitiousFunctionClassFactory2 = BaseUtils.BuiltInFictitiousFunctionClassFactory(applicationContext);
                if (BuiltInFictitiousFunctionClassFactory2 != null && BuiltInFictitiousFunctionClassFactory2.length != 0) {
                    for (int i = 0; i < BuiltInFictitiousFunctionClassFactory2.length; i++) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(SUBJECT_ID, BuiltInFictitiousFunctionClassFactory2[i]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("onNewToken to sub app, subjectId:");
                        sb.append(BuiltInFictitiousFunctionClassFactory2[i]);
                        HMSLog.i("HmsMessageService", sb.toString());
                        onNewToken(stringExtra, bundle2);
                        a(stringExtra, BuiltInFictitiousFunctionClassFactory2[i]);
                    }
                    BaseUtils.PlaceComponentResult(applicationContext);
                }
                HMSLog.i("HmsMessageService", "onNewToken to host app with bundle.");
                bundle.putString("belongId", intent.getStringExtra("belongId"));
                onNewToken(stringExtra, bundle);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onNewToken to sub app, subjectId:");
            sb2.append(str);
            HMSLog.i("HmsMessageService", sb2.toString());
            onNewToken(stringExtra, bundle);
        }
    }

    public final void a(String str, String str2, int i) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "null";
        }
        HiAnalyticsClient.reportExit(getApplicationContext(), str, str2, Status.SUCCESS.getStatusCode(), i, 60500300);
    }

    private static void c(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2 ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
    }
}

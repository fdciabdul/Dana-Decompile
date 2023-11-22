package id.dana.danah5.easteregg;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/danah5/easteregg/AppSignatureHelper;", "Landroid/content/ContextWrapper;", "", "", "getAppSignatures", "()Ljava/util/List;", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "signingInfo", "hash", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AppSignatureHelper extends ContextWrapper {
    private final Context context;
    public static final byte[] $$a = {103, 121, -60, -41, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 154;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {1, -107, Ascii.ESC, -41, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int BuiltInFictitiousFunctionClassFactory = 143;
    private static char[] PlaceComponentResult = {48515, 17662, 20322, 20934, 22597, 25265, 25898, 28626, 30237, 30867, 952, 2644, 3272, 5959, 6589, 8233, 10929, 11523, 51993, 12927, 14789, 10059, 11992, 62329, 2655, 412, 7968, 5814, 11280, 11227, 8552, 14569, 13865, 19801, 17614, 17011, 22966, 22339, 28374, 25695, 25581, 31100, 28761, 36802, 34167, 40161, 39494, 37274, 44895, 42722, 48172, 47876, 45760, 51315, 51173, 56631, 54474, 53848, 59873, 59168, 65037, 62874, 62240, 2729, 'j', 8142, 5470, 11444, 10871, 8452, 14533, 30515, 36373, 34176, 39776, 37628, 43089, 45006, 42356, 48294, 45619, 51487, 49281, 50798, 56745, 54111, 60104, 57408, 59378, 64816, 62485, 3038, 313, 6312, 7775, 5588, 11026, 8959, 14385, 16146, 14044, 19516, 17326, 22897, 20612, 22082, 28156, 25401, 31307, 29070, 30527, 36535, 33824, 39811, 37189, 43177, 44655, 42271, 48267, 45569, 51635, 53025, 50909, 56387, 54271, 59758, 57373, 59282, 64769, 62693, 2678, 475, 1856, 7850, 5231, 62332, 2573, 463, 8058, 5823, 11331, 11216, 8548, 14566, 13940, 19714, 17561, 16935, 22967, 22338, 28375, 25615, 25529, 31102, 28764, 36756, 34166, 40163, 39491, 37321, 44810, 42723, 48240, 47952, 45762, 51237, 51171, 56633, 54424, 53848, 59872, 59172, 65027, 62868, 62248, 2726, 'j', 8139, 5468, 11502, 10868, 8531, 14530, 13896, 19877, 19305, 17053, 22612, 22501, 27940, 25605, 25481, 31001, 28835, 36414, 34192, 33617, 39655, 36985, 62246, 2632, 478, 8040, 5877, 11342, 11213, 8575, 14522, 13869, 19796, 17609, 16952, 23024, 22298, 28306, 25611, 25533, 31038, 28763, 36807, 34151, 40182, 39518, 37273, 44825, 42683, 48186, 47954, 45783, 51299, 51189, 56687, 54414, 53775, 59894, 59173, 65115, 62927, 62271, 2815, '|', 8083, 5447, 11455, 10794, 8533, 14533, 13917, 19944, 19237, 17038, 22612, 22523, 27943, 25670, 25563, 31042, 28910, 36475, 17730, 48167, 47019, 43267, 41089, 39536};
    private static long MyBillsEntityDataFactory = -6661209159388689860L;

    private static void b(short s, int i, short s2, Object[] objArr) {
        byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
        int i2 = s + 105;
        int i3 = 19 - (i * 15);
        int i4 = (s2 * 4) + 16;
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            i3++;
            i2 = i2 + i3 + 2;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i2;
            if (i5 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b = bArr[i3];
            i3++;
            i2 = i2 + b + 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r9 = 46 - r9
            byte[] r0 = id.dana.danah5.easteregg.AppSignatureHelper.$$a
            int r7 = r7 * 3
            int r7 = 42 - r7
            byte[] r1 = new byte[r7]
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
            int r9 = r9 + 1
            if (r4 != r7) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.easteregg.AppSignatureHelper.c(int, short, short, java.lang.Object[]):void");
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(18 - Color.red(0), Process.myPid() >> 22, (char) (20140 - TextUtils.getOffsetBefore("", 0)), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(4 - TextUtils.lastIndexOf("", '0', 0), AndroidCharacter.getMirror('0') - 30, (char) (AndroidCharacter.getMirror('0') + 14346), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetAfter("", 0), KeyEvent.normalizeMetaState(0) + 35, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(TextUtils.indexOf("", "") + 48, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 22, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 64, Gravity.getAbsoluteGravity(0, 0) + 71, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.GS), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 64, Color.rgb(0, 0, 0) + 16777351, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(60 - KeyEvent.getDeadChar(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0) + SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, (char) (KeyEvent.getMaxKeyCode() >> 16), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(ImageFormat.getBitsPerPixel(0) + 7, 259 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (46645 - (ViewConfiguration.getTapTimeout() >> 16)), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 911, (-16777198) - Color.rgb(0, 0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[0];
                byte b2 = (byte) (b - 1);
                Object[] objArr13 = new Object[1];
                b(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[0] - 1);
                byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[0];
                Object[] objArr14 = new Object[1];
                b(b3, b4, (byte) (b4 - 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), KeyEvent.keyCodeFromString("") + 3, (char) (ViewConfiguration.getJumpTapTimeout() >> 16));
                        Object[] objArr16 = new Object[1];
                        c($$a[31], $$a[78], $$a[53], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 800, 15 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 800, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 15, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 815, View.resolveSize(0, 0) + 29, (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 800, 15 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) View.resolveSizeAndState(0, 0, 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, Color.blue(0) + 35, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1398468776, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 863, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = KClassImpl$Data$declaredNonStaticMembers$2[0];
                byte b6 = (byte) (b5 - 1);
                Object[] objArr19 = new Object[1];
                b(b5, b6, b6, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b7 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[0] - 1);
                byte b8 = KClassImpl$Data$declaredNonStaticMembers$2[0];
                Object[] objArr20 = new Object[1];
                b(b7, b8, (byte) (b8 - 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getScrollBarSize() >> 8), Color.blue(0) + 46, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        Object[] objArr22 = new Object[1];
                        c($$a[8], $$a[9], $$a[84], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1398468776, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), TextUtils.lastIndexOf("", '0', 0) + 19, (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b9 = KClassImpl$Data$declaredNonStaticMembers$2[0];
                byte b10 = (byte) (b9 - 1);
                Object[] objArr25 = new Object[1];
                b(b9, b10, b10, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b11 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[0] - 1);
                byte b12 = KClassImpl$Data$declaredNonStaticMembers$2[0];
                Object[] objArr26 = new Object[1];
                b(b11, b12, (byte) (b12 - 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 119, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 2, (char) (Process.getGidForName("") + 38969));
                        Object[] objArr28 = new Object[1];
                        c($$a[8], $$a[9], $$a[84], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), 35 - (KeyEvent.getMaxKeyCode() >> 16), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1398468776, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 911, TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b13 = KClassImpl$Data$declaredNonStaticMembers$2[0];
                byte b14 = (byte) (b13 - 1);
                Object[] objArr31 = new Object[1];
                b(b13, b14, b14, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b15 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[0] - 1);
                byte b16 = KClassImpl$Data$declaredNonStaticMembers$2[0];
                Object[] objArr32 = new Object[1];
                b(b15, b16, (byte) (b16 - 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 107, 3 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                        byte b17 = (byte) ($$a[78] - 1);
                        byte b18 = b17;
                        Object[] objArr34 = new Object[1];
                        c(b17, b18, b18, objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 930, 35 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1398468776, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 18, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSignatureHelper(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
    }

    public final List<String> getAppSignatures() {
        try {
            Signature[] signatureArr = getPackageManager().getPackageInfo(getPackageName(), 64).signatures;
            Intrinsics.checkNotNullExpressionValue(signatureArr, "");
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                String packageName = getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "");
                String charsString = signature.toCharsString();
                Intrinsics.checkNotNullExpressionValue(charsString, "");
                String hash = hash(packageName, charsString);
                if (hash != null) {
                    arrayList.add(hash);
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            InstrumentInjector.log_e("AppSignatureHelper", "Unable to find package to obtain hash.", e);
            return CollectionsKt.emptyList();
        }
    }

    private final String hash(String packageName, String signingInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(signingInfo);
        String obj = sb.toString();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset, "");
            byte[] bytes = obj.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "");
            messageDigest.update(bytes);
            String encodeToString = Base64.encodeToString(Arrays.copyOfRange(messageDigest.digest(), 0, 9), 3);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "");
            String substring = encodeToString.substring(0, 11);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            return substring;
        } catch (NoSuchAlgorithmException e) {
            InstrumentInjector.log_e("AppSignatureHelper", "hash:NoSuchAlgorithm", e);
            return null;
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (PlaceComponentResult[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ MyBillsEntityDataFactory))) ^ c;
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

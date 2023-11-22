package com.iap.ac.android.gol.google;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
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
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.callback.InitCallback;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.AcBaseResult;
import com.iap.ac.android.biz.common.model.AcCallback;
import com.iap.ac.android.biz.common.model.InitErrorCode;
import com.iap.ac.android.biz.common.model.gol.SignContractRequest;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.gol.R;
import com.iap.ac.android.gol.SignContractManager;
import com.iap.ac.android.gol.google.model.AuthenticationResult;
import com.iap.ac.android.gol.google.network.GolGooglePrepareProcessor;
import com.iap.ac.android.gol.google.network.GolGooglePrepareResponse;
import com.iap.ac.android.gol.rpc.AuthDataUtils;
import com.iap.ac.android.gol.rpc.AuthProcessor;
import com.iap.ac.android.gol.rpc.result.AuthPrepareResult;
import com.iap.ac.android.gol.utils.GolMonitorUtils;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes8.dex */
public class GolGoogleAuthActivity extends Activity {
    private static List<String> DEFAULT_STATION_OPENAPI_LIST = null;
    public static final String GSP_ASSOCIATION_ID = "gspAssociationId";
    public static final String GSP_AUTHENTICATION_REQUEST = "gspAuthenticationRequest";
    public static final String GSP_AUTHENTICATION_RESPONSE = "gspAuthenticationResponse";
    public static final String GSP_CALLBACK_URL = "gspCallbackUrl";
    public static final String GSP_MAJOR_VERSION = "gspMajorVersion";
    private static char[] MyBillsEntityDataFactory = null;
    private static final String TAG = "GolGoogleAuthActivity";
    private static final String URL_PARAM_BIZ_CONTENT = "bizContent";
    private static final String URL_PARAM_NEED_CALLBACK = "needCallback";
    private String mAuthenticationResponse;
    private Map<String, String> mMerchantOriginalRequest = new HashMap();
    private long mStartTime;
    public static final byte[] $$a = {36, -18, 4, 125, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 90;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {96, 83, 72, -80, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int getAuthRequestContext = 57;

    private static void b(byte b, byte b2, byte b3, Object[] objArr) {
        int i = (b * 15) + 4;
        int i2 = 106 - b3;
        int i3 = (b2 * 4) + 16;
        byte[] bArr = BuiltInFictitiousFunctionClassFactory;
        byte[] bArr2 = new byte[i3];
        int i4 = -1;
        int i5 = i3 - 1;
        if (bArr == null) {
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
            i2 = i2 + (-i) + 2;
            i++;
            i5 = i5;
        }
        while (true) {
            int i6 = i4 + 1;
            bArr2[i6] = (byte) i2;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b4 = bArr[i];
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i6;
            i2 = i2 + (-b4) + 2;
            i++;
            i5 = i5;
        }
    }

    private static void c(byte b, byte b2, int i, Object[] objArr) {
        byte[] bArr = $$a;
        int i2 = 42 - (b * 3);
        int i3 = b2 + 4;
        int i4 = 103 - (i * 2);
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i4 = (i4 + (-i6)) - 7;
            i6 = i6;
            i3++;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i4;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b3 = bArr[i3];
            int i8 = i3;
            int i9 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
            i4 = (i4 + (-b3)) - 7;
            i6 = i9;
            i3 = i8 + 1;
        }
    }

    static void getAuthRequestContext() {
        MyBillsEntityDataFactory = new char[]{35465, 35534, 35567, 35536, 35543, 35576, 35570, 35566, 35573, 35575, 35577, 35572, 35565, 35570, 35578, 35575, 35566, 35583, 35508, 35521, 35576, 35574, 35565, 35364, 35383, 35353, 35562, 35368, 35368, 35385, 35562, 35380, 35377, 35371, 35366, 35380, 35370, 35385, 35380, 35385, 35381, 35366, 35376, 35332, 35361, 35364, 35377, 35362, 35377, 35346, 35775, 35766, 35769, 35774, 35712, 35768, 35729, 35731, 35771, 35773, 35713, 35717, 35721, 35713, 35773, 35775, 35773, 35500, 35539, 35498, 35540, 35538, 35499, 35539, 35536, 35501, 35498, 35494, 35537, 35537, 35499, 35498, 35497, 35537, 35581, 35580, 35541, 35541, 35536, 35499, 35541, 35539, 35538, 35581, 35581, 35580, 35541, 35501, 35503, 35501, 35501, 35503, 35541, 35579, 35578, 35578, 35536, 35497, 35494, 35536, 35540, 35498, 35497, 35538, 35539, 35542, 35341, 35334, 35335, 35334, 35339, 35341, 35339, 35338, 35338, 35379, 35380, 35381, 35380, 35340, 35338, 35343, 35383, 35421, 35379, 35336, 35378, 35421, 35380, 35340, 35381, 35376, 35376, 35377, 35379, 35378, 35338, 35338, 35341, 35380, 35380, 35381, 35378, 35340, 35341, 35340, 35343, 35380, 35378, 35337, 35376, 35421, 35376, 35338, 35338, 35377, 35419, 35379, 35339, 35381, 35380, 35381, 35376, 35338, 35383, 35420, 35380, 35342, 35342, 35576, 35413, 35415, 35455, 35452, 35413, 35413, 35412, 35412, 35455, 35393, 35419, 35393, 35430, 35452, 35453, 35430, 35435, 35394, 35414, 35412, 35416, 35393, 35453, 35410, 35413, 35412, 35454, 35455, 35415, 35393, 35455, 35455, 35455, 35452, 35428, 35453, 35410, 35453, 35452, 35415, 35392, 35435, 35392, 35393, 35454, 35454, 35433, 35454, 35417, 35419, 35416, 35419, 35414, 35410, 35410, 35412, 35417, 35414, 35410, 35455, 35433, 35393, 35419, 35583, 35421, 35423, 35367, 35363, 35363, 35332, 35358, 35386, 35388, 35391, 35421, 35362, 35368, 35364, 35365, 35330, 35330, 35362, 35366, 35334, 35328, 35360, 35367, 35334, 35335, 35365, 35367, 35365, 35421, 35420, 35365, 35365, 35367, 35365, 35360, 35332, 35391, 35421, 35364, 35372, 35365, 35364, 35373, 35365, 35363, 35360, 35391, 35337, 35369, 35369, 35372, 35335, 35553, 35354, 35384, 35423, 35420, 35418, 35360, 35583, 35363, 35365, 35365, 35364, 35365};
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(true, new int[]{0, 18, 0, 11}, new byte[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(false, new int[]{18, 5, 0, 3}, new byte[]{1, 0, 1, 1, 0}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, KeyEvent.keyCodeFromString("") + 35, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(true, new int[]{67, 48, 0, 0}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(true, new int[]{115, 64, 96, 55}, new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(true, new int[]{179, 64, 148, 0}, new byte[]{1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(true, new int[]{243, 60, 80, 0}, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(false, new int[]{303, 6, 138, 0}, new byte[]{1, 1, 0, 0, 0, 1}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, 18 - View.resolveSizeAndState(0, 0, 0), (char) View.MeasureSpec.getMode(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = BuiltInFictitiousFunctionClassFactory[5];
                byte b2 = (byte) (b - 1);
                Object[] objArr13 = new Object[1];
                b(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
                Object[] objArr14 = new Object[1];
                b(b3, b3, BuiltInFictitiousFunctionClassFactory[5], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 56, 3 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) View.MeasureSpec.getSize(0));
                        Object[] objArr16 = new Object[1];
                        c($$a[68], (byte) ($$a[47] - 1), (byte) (-$$a[12]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ExpandableListView.getPackedPositionType(0L), 16 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 800, ImageFormat.getBitsPerPixel(0) + 16, (char) Color.red(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 814, 30 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (57994 - TextUtils.getOffsetBefore("", 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 15, (char) (ViewConfiguration.getWindowTouchSlop() >> 8)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 35 - ExpandableListView.getPackedPositionType(0L), (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-46721373, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = BuiltInFictitiousFunctionClassFactory[5];
                byte b5 = (byte) (b4 - 1);
                Object[] objArr19 = new Object[1];
                b(b4, b5, b5, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b6 = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
                Object[] objArr20 = new Object[1];
                b(b6, b6, BuiltInFictitiousFunctionClassFactory[5], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (Process.myTid() >> 22), 46 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) View.resolveSizeAndState(0, 0, 0));
                        byte b7 = (byte) (-$$a[8]);
                        Object[] objArr22 = new Object[1];
                        c(b7, (byte) (b7 | 16), (byte) ($$a[47] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 930, (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-46721373, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myTid() >> 22), Color.rgb(0, 0, 0) + 16777234, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b8 = BuiltInFictitiousFunctionClassFactory[5];
                byte b9 = (byte) (b8 - 1);
                Object[] objArr25 = new Object[1];
                b(b8, b9, b9, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b10 = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
                Object[] objArr26 = new Object[1];
                b(b10, b10, BuiltInFictitiousFunctionClassFactory[5], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), Process.getGidForName("") + 4, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 38967));
                        byte b11 = (byte) (-$$a[8]);
                        Object[] objArr28 = new Object[1];
                        c(b11, (byte) (b11 | 16), (byte) ($$a[47] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 34 - MotionEvent.axisFromString(""), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-46721373, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - MotionEvent.axisFromString(""), 18 - (Process.myTid() >> 22), (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b12 = BuiltInFictitiousFunctionClassFactory[5];
                byte b13 = (byte) (b12 - 1);
                Object[] objArr31 = new Object[1];
                b(b12, b13, b13, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b14 = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
                Object[] objArr32 = new Object[1];
                b(b14, b14, BuiltInFictitiousFunctionClassFactory[5], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - Color.alpha(0), 3 - Color.blue(0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[53]), (byte) (-$$a[9]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 930, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-46721373, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 911, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 17, (char) Color.green(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(true, new int[]{23, 26, 70, 15}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(false, new int[]{49, 18, 181, 0}, new byte[]{0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.MeasureSpec.getSize(0), (char) (MotionEvent.axisFromString("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 911, 18 - KeyEvent.keyCodeFromString(""), (char) ((-1) - Process.getGidForName("")))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(true, new int[]{23, 26, 70, 15}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(false, new int[]{49, 18, 181, 0}, new byte[]{0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 912, 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        ArrayList arrayList = new ArrayList();
        DEFAULT_STATION_OPENAPI_LIST = arrayList;
        arrayList.add("TNGD_WALLET_MY");
        DEFAULT_STATION_OPENAPI_LIST.add("PAYPAY_WALLET_JP");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }

    public void initSDK(InitCallback initCallback) {
        ACLog.e(TAG, "initSDK");
        initCallback.onSuccess();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(true, new int[]{0, 18, 0, 11}, new byte[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(false, new int[]{18, 5, 0, 3}, new byte[]{1, 0, 1, 1, 0}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(true, new int[]{23, 26, 70, 15}, null, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(false, new int[]{49, 18, 181, 0}, new byte[]{0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, Color.alpha(0) + 35, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(true, new int[]{67, 48, 0, 0}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(true, new int[]{115, 64, 96, 55}, new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(true, new int[]{179, 64, 148, 0}, new byte[]{1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(true, new int[]{243, 60, 80, 0}, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(false, new int[]{303, 6, 138, 0}, new byte[]{1, 1, 0, 0, 0, 1}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 911, TextUtils.getOffsetBefore("", 0) + 18, (char) KeyEvent.keyCodeFromString(""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr11);
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
        try {
            byte b = BuiltInFictitiousFunctionClassFactory[5];
            byte b2 = (byte) (b - 1);
            Object[] objArr12 = new Object[1];
            b(b, b2, b2, objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
            Object[] objArr13 = new Object[1];
            b(b3, b3, BuiltInFictitiousFunctionClassFactory[5], objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 4, (char) (Process.myPid() >> 22));
                    Object[] objArr15 = new Object[1];
                    c((byte) ($$a[47] - 1), (byte) (-$$a[53]), (byte) (-$$a[9]), objArr15);
                    obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                int i = ((int[]) objArr16[1])[0];
                if (((int[]) objArr16[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - TextUtils.getCapsMode("", 0, 0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {33387448, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSizeAndState(0, 0, 0), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr17);
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
                super.onCreate(bundle);
                ConfigCenter.INSTANCE.refreshConfigs();
                if (ConfigCenter.INSTANCE.getLoadingGolGoogleAuthToggle()) {
                    setContentView(R.layout.acsdk_activity_gol_google_auth);
                }
                this.mStartTime = SystemClock.elapsedRealtime();
                GolMonitorUtils.googleSignContractBegin();
                prepareOriginAuthenticationRequest();
                if (!preCheck()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("google sign contract error with invalid param: ");
                    sb.append(this.mMerchantOriginalRequest);
                    GolMonitorUtils.googleSignContractFail(sb.toString(), this.mStartTime);
                    onAuthFailed();
                    return;
                }
                initSDK(new InitCallback() { // from class: com.iap.ac.android.gol.google.GolGoogleAuthActivity.1
                    @Override // com.iap.ac.android.biz.common.callback.InitCallback
                    public void onSuccess() {
                        ACLog.e(GolGoogleAuthActivity.TAG, "Method:initSDK asyncTask");
                        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.gol.google.GolGoogleAuthActivity.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ACLog.e(GolGoogleAuthActivity.TAG, "Method:initSDK asyncTask start");
                                GolGoogleAuthActivity.this.googlePrepareInThread();
                                ACLog.e(GolGoogleAuthActivity.TAG, "Method:initSDK asyncTask end");
                            }
                        });
                    }

                    @Override // com.iap.ac.android.biz.common.callback.InitCallback
                    public void onFailure(InitErrorCode initErrorCode, String str5) {
                        GolGoogleAuthActivity.this.onAuthFailed();
                    }
                });
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

    /* JADX INFO: Access modifiers changed from: private */
    public void googlePrepareInThread() {
        if (!ConfigCenter.INSTANCE.getGoogleInvokeImgsApi()) {
            if (DEFAULT_STATION_OPENAPI_LIST.contains(ACManager.getInstance().getCommonConfig().appId)) {
                signContractByOpenApi();
                return;
            }
        }
        signContractByRPC();
    }

    private void signContractByOpenApi() {
        ACLog.e(TAG, "Method:signContractByOpenApi start");
        GolGooglePrepareResponse prepare = new GolGooglePrepareProcessor(this).prepare(this.mMerchantOriginalRequest);
        this.mAuthenticationResponse = prepare == null ? "" : prepare.gspAuthenticationResponse;
        String str = prepare != null ? prepare.authUrl : "";
        StringBuilder sb = new StringBuilder();
        sb.append("Method:signContractByRPC result mAuthenticationResponse is");
        sb.append(this.mAuthenticationResponse);
        ACLog.e(TAG, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Method:signContractByRPC result gspCallbackUrl is");
        sb2.append(str);
        ACLog.e(TAG, sb2.toString());
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mAuthenticationResponse)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(singContractByOpenApi)google sign contract, prepare error: ");
            sb3.append(str);
            sb3.append(", ");
            sb3.append(this.mAuthenticationResponse);
            GolMonitorUtils.googleSignContractFail(sb3.toString(), this.mStartTime);
            onAuthFailed();
            return;
        }
        signContract(str);
    }

    private void signContractByRPC() {
        ACLog.e(TAG, "Method:signContractByRPC start");
        AuthPrepareResult prepare = new AuthProcessor().prepare(AuthDataUtils.generatePrepareRequest(this.mMerchantOriginalRequest));
        String str = prepare == null ? "" : prepare.responseBody;
        StringBuilder sb = new StringBuilder();
        sb.append("Method:signContractByRPC result body is ");
        sb.append(str);
        ACLog.e(TAG, sb.toString());
        AuthenticationResult authenticationResult = (AuthenticationResult) JsonUtils.fromJson(str, AuthenticationResult.class);
        if (authenticationResult != null && authenticationResult.merchantAuthenticationResponse != null) {
            this.mAuthenticationResponse = authenticationResult.merchantAuthenticationResponse.gspAuthenticationResponse;
        }
        String authUrl = authenticationResult != null ? authenticationResult.getAuthUrl() : "";
        if (TextUtils.isEmpty(authUrl) || TextUtils.isEmpty(this.mAuthenticationResponse)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("(signContractByRPC)google sign contract, prepare error: ");
            sb2.append(authUrl);
            sb2.append(", ");
            sb2.append(this.mAuthenticationResponse);
            GolMonitorUtils.googleSignContractFail(sb2.toString(), this.mStartTime);
            onAuthFailed();
            return;
        }
        signContract(authUrl);
    }

    private void signContract(String str) {
        Uri parse = Uri.parse(str);
        SignContractRequest signContractRequest = new SignContractRequest();
        signContractRequest.needCallback = parse.getBooleanQueryParameter(URL_PARAM_NEED_CALLBACK, false);
        signContractRequest.bizContent = parse.getQueryParameter(URL_PARAM_BIZ_CONTENT);
        if (TextUtils.isEmpty(signContractRequest.bizContent)) {
            signContractRequest.authUrl = str;
        }
        ACLog.d(Constants.TAG, String.format("signContract begin, needCallback: %s, bizContent: %s, authUrl: %s", Boolean.valueOf(signContractRequest.needCallback), signContractRequest.bizContent, signContractRequest.authUrl));
        SignContractManager.getInstance().signContract(true, signContractRequest, new AcCallback<AcBaseResult>() { // from class: com.iap.ac.android.gol.google.GolGoogleAuthActivity.2
            @Override // com.iap.ac.android.biz.common.model.AcCallback
            public void onResult(AcBaseResult acBaseResult) {
                if (!acBaseResult.success) {
                    GolMonitorUtils.googleSignContractFinish(false, GolGoogleAuthActivity.this.mStartTime);
                    if (TextUtils.equals(acBaseResult.errorCode, "USER_CANCEL")) {
                        GolGoogleAuthActivity.this.onAuthCanceled();
                        return;
                    } else {
                        GolGoogleAuthActivity.this.onAuthFailed();
                        return;
                    }
                }
                GolGoogleAuthActivity.this.onAuthSuccess();
                GolMonitorUtils.googleSignContractFinish(true, GolGoogleAuthActivity.this.mStartTime);
            }
        });
    }

    public void onAuthSuccess() {
        Intent intent = new Intent();
        intent.putExtra("gspAuthenticationResponse", this.mAuthenticationResponse);
        setResult(-1, intent);
        finish();
    }

    public void onAuthCanceled() {
        if (this.mAuthenticationResponse != null) {
            Intent intent = new Intent();
            intent.putExtra("gspAuthenticationResponse", this.mAuthenticationResponse);
            setResult(0, intent);
        } else {
            setResult(0);
        }
        finish();
    }

    public void onAuthFailed() {
        Intent intent = new Intent();
        String str = this.mAuthenticationResponse;
        if (str != null) {
            intent.putExtra("gspAuthenticationResponse", str);
        }
        setResult(1, intent);
        finish();
    }

    private boolean preCheck() {
        return this.mMerchantOriginalRequest.size() > 0;
    }

    private void prepareOriginAuthenticationRequest() {
        Intent intent = getIntent();
        if (intent == null) {
            ACLog.e("AGS_AgsForGoogleAuthActivity", "intent is null, return directly");
            return;
        }
        if (intent.hasExtra(GSP_ASSOCIATION_ID)) {
            this.mMerchantOriginalRequest.put(GSP_ASSOCIATION_ID, intent.getStringExtra(GSP_ASSOCIATION_ID));
        } else {
            this.mMerchantOriginalRequest.put(GSP_ASSOCIATION_ID, "");
        }
        this.mMerchantOriginalRequest.put(GSP_AUTHENTICATION_REQUEST, intent.getStringExtra(GSP_AUTHENTICATION_REQUEST));
        if (intent.hasExtra(GSP_CALLBACK_URL)) {
            this.mMerchantOriginalRequest.put(GSP_CALLBACK_URL, intent.getStringExtra(GSP_CALLBACK_URL));
        }
        if (intent.hasExtra(GSP_MAJOR_VERSION)) {
            this.mMerchantOriginalRequest.put(GSP_MAJOR_VERSION, intent.getStringExtra(GSP_MAJOR_VERSION));
        }
    }

    private static void a(boolean z, int[] iArr, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr = MyBillsEntityDataFactory;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            for (int i5 = 0; i5 < length; i5++) {
                cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i2];
        System.arraycopy(cArr, i, cArr3, 0, i2);
        if (bArr != null) {
            char[] cArr4 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                } else {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                }
                c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr4;
        }
        if (i4 > 0) {
            char[] cArr5 = new char[i2];
            System.arraycopy(cArr3, 0, cArr5, 0, i2);
            int i6 = i2 - i4;
            System.arraycopy(cArr5, 0, cArr3, i6, i4);
            System.arraycopy(cArr5, i4, cArr3, 0, i6);
        }
        if (z) {
            char[] cArr6 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr6;
        }
        if (i3 > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        objArr[0] = new String(cArr3);
    }
}

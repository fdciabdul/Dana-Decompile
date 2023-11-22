package com.ipification.mobile.sdk.im.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationManagerCompat;
import androidx.view.Observer;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import com.ipification.mobile.sdk.android.IPConfiguration;
import com.ipification.mobile.sdk.android.R;
import com.ipification.mobile.sdk.android.databinding.ActivityImVerificationBinding;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.model.IMSession;
import com.ipification.mobile.sdk.android.response.AuthResponse;
import com.ipification.mobile.sdk.android.utils.IPConstant;
import com.ipification.mobile.sdk.im.IMService;
import com.ipification.mobile.sdk.im.base.BaseVerificationActivity;
import com.ipification.mobile.sdk.im.data.IMInfo;
import com.ipification.mobile.sdk.im.data.SessionResponse;
import com.ipification.mobile.sdk.im.di.RepositoryModule;
import com.ipification.mobile.sdk.im.listener.RedirectDataCallback;
import com.ipification.mobile.sdk.im.util.IMAPI;
import com.ipification.mobile.sdk.im.util.SingleLiveEvent;
import com.ipification.mobile.sdk.im.util.VerificationExtensionKt;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0005\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lcom/ipification/mobile/sdk/im/ui/IMVerificationActivity;", "Lcom/ipification/mobile/sdk/im/base/BaseVerificationActivity;", "Landroid/content/Intent;", "p0", "", "getAuthRequestContext", "(Landroid/content/Intent;)V", "Landroid/widget/LinearLayout;", "getBindingRoot", "()Landroid/widget/LinearLayout;", "Landroid/os/Bundle;", "savedInstanceState", "onCreateActivity", "(Landroid/os/Bundle;)V", "intent", "onNewIntent", "onResume", "()V", "", "(Ljava/lang/String;)V", "Lcom/ipification/mobile/sdk/android/response/AuthResponse;", "BuiltInFictitiousFunctionClassFactory", "(Lcom/ipification/mobile/sdk/android/response/AuthResponse;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "Lcom/ipification/mobile/sdk/android/databinding/ActivityImVerificationBinding;", "binding", "Lcom/ipification/mobile/sdk/android/databinding/ActivityImVerificationBinding;", "getBinding", "()Lcom/ipification/mobile/sdk/android/databinding/ActivityImVerificationBinding;", "setBinding", "(Lcom/ipification/mobile/sdk/android/databinding/ActivityImVerificationBinding;)V", "", "getErrorConfigVersion", "Z", "PlaceComponentResult", "<init>"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class IMVerificationActivity extends BaseVerificationActivity {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final String getAuthRequestContext = "IMActivity";
    public ActivityImVerificationBinding binding;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean PlaceComponentResult;
    public static final byte[] $$d = {93, 18, 67, -65, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 83;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {15, -40, -114, -21, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int scheduleImpl = 183;
    private static char[] lookAheadTest = {35359, 35429, 35432, 35432, 35433, 35425, 35743, 35436, 35428, 35732, 35740, 35741, 35741, 35740, 35425, 35448, 35413, 35453, 35738, 35426, 35397, 35395, 35428, 35742, 35738, 35425, 35563, 35451, 35449, 35440, 35441, 35446, 35450, 35444, 35446, 35444, 35448, 35392, 35452, 35448, 35444, 35442, 35402, 35400, 35536, 35389, 35387, 35385, 35378, 35382, 35388, 35355, 35348, 35379, 35346, 35557, 35331, 35378, 35387, 35390, 35382, 35377, 35566, 35448, 35396, 35404, 35399, 35500, 35541, 35541, 35580, 35581, 35537, 35497, 35498, 35499, 35537, 35537, 35494, 35498, 35501, 35536, 35539, 35499, 35538, 35540, 35498, 35539, 35536, 35539, 35538, 35497, 35498, 35540, 35536, 35494, 35497, 35536, 35578, 35578, 35579, 35541, 35503, 35501, 35501, 35503, 35501, 35541, 35580, 35581, 35581, 35538, 35539, 35541, 35499, 35551, 35571, 35529, 35569, 35353, 35567, 35528, 35528, 35566, 35355, 35566, 35527, 35568, 35570, 35533, 35530, 35531, 35530, 35568, 35571, 35570, 35570, 35531, 35528, 35528, 35568, 35569, 35567, 35566, 35566, 35571, 35530, 35570, 35355, 35568, 35526, 35569, 35355, 35573, 35533, 35528, 35530, 35570, 35571, 35570, 35569, 35528, 35528, 35529, 35531, 35529, 35524, 35525, 35524, 35531, 35532, 35532, 35532, 35570, 35354, 35573, 35528, 35566, 35571, 35458, 35497, 35499, 35539, 35536, 35497, 35497, 35496, 35496, 35539, 35541, 35503, 35541, 35578, 35536, 35537, 35578, 35583, 35542, 35498, 35496, 35500, 35541, 35537, 35494, 35497, 35496, 35538, 35539, 35499, 35541, 35539, 35539, 35539, 35536, 35576, 35537, 35494, 35537, 35536, 35499, 35540, 35583, 35540, 35541, 35538, 35538, 35581, 35538, 35501, 35503, 35500, 35503, 35498, 35494, 35494, 35496, 35501, 35498, 35494, 35539, 35581, 35541, 35503, 35495, 35565, 35567, 35575, 35571, 35571, 35540, 35502, 35530, 35532, 35535, 35565, 35570, 35576, 35572, 35573, 35538, 35538, 35570, 35574, 35542, 35536, 35568, 35575, 35542, 35543, 35573, 35575, 35573, 35565, 35564, 35573, 35573, 35575, 35573, 35568, 35540, 35535, 35565, 35572, 35580, 35573, 35572, 35581, 35573, 35571, 35568, 35535, 35545, 35577, 35577, 35580, 35543, 35505, 35498, 35528, 35567, 35564, 35562, 35568, 35458, 35499, 35503, 35502, 35503, 35503};

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 15
            int r8 = r8 + 4
            int r6 = 106 - r6
            byte[] r0 = com.ipification.mobile.sdk.im.ui.IMVerificationActivity.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 * 4
            int r7 = r7 + 16
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L34
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + 2
            int r7 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.im.ui.IMVerificationActivity.e(short, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(byte r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 3
            int r7 = 42 - r7
            int r9 = r9 + 4
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r0 = com.ipification.mobile.sdk.im.ui.IMVerificationActivity.$$d
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r7
            goto L34
        L18:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r6
        L1c:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L34:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + (-7)
            int r8 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.im.ui.IMVerificationActivity.f(byte, int, short, java.lang.Object[]):void");
    }

    public static /* synthetic */ void getAuthRequestContext$default(IMVerificationActivity iMVerificationActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        iMVerificationActivity.getAuthRequestContext(str);
    }

    @Override // com.ipification.mobile.sdk.im.base.BaseVerificationActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        d(false, new int[]{44, 18, 60, 18}, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        d(false, new int[]{62, 5, 115, 0}, new byte[]{0, 0, 0, 0, 1}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), Process.getGidForName("") + 36, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    d(false, new int[]{67, 48, 0, 21}, new byte[]{0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    d(false, new int[]{115, 64, 34, 0}, new byte[]{1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    d(true, new int[]{179, 64, 0, 0}, new byte[]{1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    d(true, new int[]{243, 60, 0, 0}, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    d(true, new int[]{303, 6, 0, 1}, new byte[]{1, 0, 1, 0, 0, 0}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.combineMeasuredStates(0, 0), 18 - TextUtils.getOffsetBefore("", 0), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                Object[] objArr13 = new Object[1];
                e(b, b, KClassImpl$Data$declaredNonStaticMembers$2[5], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                byte b3 = (byte) (b2 - 1);
                Object[] objArr14 = new Object[1];
                e(b2, b3, b3, objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 54, 3 - Color.alpha(0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                        Object[] objArr16 = new Object[1];
                        f($$d[68], (byte) (-$$d[12]), (byte) ($$d[47] - 1), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - ImageFormat.getBitsPerPixel(0), KeyEvent.normalizeMetaState(0) + 15, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 800, Color.green(0) + 15, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 815, 29 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (57994 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getLongPressTimeout() >> 16), 15 - Color.red(0), (char) (TextUtils.lastIndexOf("", '0') + 1)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1433802272, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 911, 18 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                Object[] objArr20 = new Object[1];
                e(b4, b4, KClassImpl$Data$declaredNonStaticMembers$2[5], objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                byte b5 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                byte b6 = (byte) (b5 - 1);
                Object[] objArr21 = new Object[1];
                e(b5, b6, b6, objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getPressedStateDuration() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 47, (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                        byte b7 = (byte) (-$$d[8]);
                        byte b8 = (byte) ($$d[47] - 1);
                        Object[] objArr23 = new Object[1];
                        f(b7, b8, (byte) (b8 | Ascii.ETB), objArr23);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 35 - Color.alpha(0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr25 = {1433802272, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", ""), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 18, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b9 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                Object[] objArr27 = new Object[1];
                e(b9, b9, KClassImpl$Data$declaredNonStaticMembers$2[5], objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                byte b10 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                byte b11 = (byte) (b10 - 1);
                Object[] objArr28 = new Object[1];
                e(b10, b11, b11, objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 2 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (TextUtils.getTrimmedLength("") + 38968));
                        byte b12 = (byte) (-$$d[8]);
                        byte b13 = (byte) ($$d[47] - 1);
                        Object[] objArr30 = new Object[1];
                        f(b12, b13, (byte) (b13 | Ascii.ETB), objArr30);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), 35 - KeyEvent.getDeadChar(0, 0), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {1433802272, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 911, 18 - Gravity.getAbsoluteGravity(0, 0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b14 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                Object[] objArr34 = new Object[1];
                e(b14, b14, KClassImpl$Data$declaredNonStaticMembers$2[5], objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                byte b15 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                byte b16 = (byte) (b15 - 1);
                Object[] objArr35 = new Object[1];
                e(b15, b16, b16, objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 4 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))));
                        Object[] objArr37 = new Object[1];
                        f((byte) ($$d[47] - 1), (byte) (-$$d[9]), (byte) (-$$d[53]), objArr37);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.makeMeasureSpec(0, 0), View.resolveSizeAndState(0, 0, 0) + 35, (char) ((-1) - Process.getGidForName("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr39 = {1433802272, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 18 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // com.ipification.mobile.sdk.im.base.BaseVerificationActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.ipification.mobile.sdk.im.base.BaseVerificationActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @JvmName(name = "getBinding")
    public final ActivityImVerificationBinding getBinding() {
        ActivityImVerificationBinding activityImVerificationBinding = this.binding;
        if (activityImVerificationBinding != null) {
            return activityImVerificationBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        throw null;
    }

    @Override // com.ipification.mobile.sdk.im.base.BaseVerificationActivity
    public final LinearLayout getBindingRoot() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_im_verification, (ViewGroup) null, false);
        int i = R.id.fl_toolbar_container;
        if (((FrameLayout) inflate.findViewById(i)) != null) {
            i = R.id.iv_back_btn;
            ImageView imageView = (ImageView) inflate.findViewById(i);
            if (imageView != null) {
                i = R.id.MyBillsEntityDataFactory_res_0x7f0a0e08;
                TextView textView = (TextView) inflate.findViewById(i);
                if (textView != null) {
                    i = R.id.moveToNextValue;
                    TextView textView2 = (TextView) inflate.findViewById(i);
                    if (textView2 != null) {
                        i = R.id.res_0x7f0a1a1e_networkuserentitydata_externalsyntheticlambda1;
                        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(i);
                        if (frameLayout != null) {
                            ActivityImVerificationBinding activityImVerificationBinding = new ActivityImVerificationBinding((LinearLayout) inflate, imageView, textView, textView2, frameLayout);
                            Intrinsics.checkExpressionValueIsNotNull(activityImVerificationBinding, "");
                            setBinding(activityImVerificationBinding);
                            getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: com.ipification.mobile.sdk.im.ui.IMVerificationActivity$$ExternalSyntheticLambda6
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    IMVerificationActivity.$r8$lambda$rvaMB53Ky8GvcE0vDGkWx_DL910(IMVerificationActivity.this, view);
                                }
                            });
                            LinearLayout linearLayout = getBinding().BuiltInFictitiousFunctionClassFactory;
                            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "");
                            return linearLayout;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // com.ipification.mobile.sdk.im.base.BaseVerificationActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // com.ipification.mobile.sdk.im.base.BaseVerificationActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        d(false, new int[]{44, 18, 60, 18}, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        d(false, new int[]{62, 5, 115, 0}, new byte[]{0, 0, 0, 0, 1}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                d(true, new int[]{0, 26, 148, 2}, new byte[]{0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                d(true, new int[]{26, 18, 124, 6}, new byte[]{0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getOffsetBefore("", 0), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    d(false, new int[]{67, 48, 0, 21}, new byte[]{0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    d(false, new int[]{115, 64, 34, 0}, new byte[]{1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    d(true, new int[]{179, 64, 0, 0}, new byte[]{1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    d(true, new int[]{243, 60, 0, 0}, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    d(true, new int[]{303, 6, 0, 1}, new byte[]{1, 0, 1, 0, 0, 0}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 911, 18 - Color.argb(0, 0, 0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
            Object[] objArr12 = new Object[1];
            e(b, b, KClassImpl$Data$declaredNonStaticMembers$2[5], objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            byte b3 = (byte) (b2 - 1);
            Object[] objArr13 = new Object[1];
            e(b2, b3, b3, objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - ExpandableListView.getPackedPositionGroup(0L), 5 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1));
                    Object[] objArr15 = new Object[1];
                    f((byte) ($$d[47] - 1), (byte) (-$$d[9]), (byte) (-$$d[53]), objArr15);
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
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), Color.red(0) + 35, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {830098497, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - MotionEvent.axisFromString(""), 17 - Process.getGidForName(""), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.PlaceComponentResult = true;
        getAuthRequestContext(intent);
    }

    @Override // com.ipification.mobile.sdk.im.base.BaseVerificationActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            d(true, new int[]{0, 26, 148, 2}, new byte[]{0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            d(true, new int[]{26, 18, 124, 6}, new byte[]{0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 930, ((byte) KeyEvent.getModifierMetaStateMask()) + 36, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // com.ipification.mobile.sdk.im.base.BaseVerificationActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            d(true, new int[]{0, 26, 148, 2}, new byte[]{0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            d(true, new int[]{26, 18, 124, 6}, new byte[]{0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), View.MeasureSpec.getSize(0) + 35, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getWindowTouchSlop() >> 8), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        if (this.PlaceComponentResult) {
            return;
        }
        getAuthRequestContext(getIntent());
    }

    @JvmName(name = "setBinding")
    public final void setBinding(ActivityImVerificationBinding activityImVerificationBinding) {
        Intrinsics.checkParameterIsNotNull(activityImVerificationBinding, "");
        this.binding = activityImVerificationBinding;
    }

    public static /* synthetic */ void $r8$lambda$KRBODaVpRxkbqP1ssOZOfEQS3XQ(IMInfo iMInfo, final IMVerificationActivity iMVerificationActivity) {
        Intrinsics.checkParameterIsNotNull(iMVerificationActivity, "");
        IMAPI.Companion companion = IMAPI.INSTANCE;
        IMAPI.Companion.getAuthRequestContext(iMInfo.MyBillsEntityDataFactory, iMVerificationActivity, new RedirectDataCallback() { // from class: com.ipification.mobile.sdk.im.ui.IMVerificationActivity$subscribeInitResult$1$1
            @Override // com.ipification.mobile.sdk.im.listener.RedirectDataCallback
            public final void PlaceComponentResult(String p0) {
                Intrinsics.checkParameterIsNotNull(p0, "");
                IMAPI.Companion companion2 = IMAPI.INSTANCE;
                IMAPI.Companion.PlaceComponentResult(IMVerificationActivity.this, p0);
            }
        });
    }

    public static /* synthetic */ void $r8$lambda$UlHrLAYYt_u4NiiGC0n9LlQl5Fo(IMVerificationActivity iMVerificationActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkParameterIsNotNull(iMVerificationActivity, "");
        IPConstant.Companion companion = IPConstant.INSTANCE;
        iMVerificationActivity.getAuthRequestContext(IPConstant.Companion.PlaceComponentResult().PlaceComponentResult);
    }

    /* renamed from: $r8$lambda$ZSLwldWulqesPW-fkUAyHd8Jaag */
    public static /* synthetic */ void m231$r8$lambda$ZSLwldWulqesPWfkUAyHd8Jaag(List list, final IMVerificationActivity iMVerificationActivity) {
        Intrinsics.checkParameterIsNotNull(list, "");
        Intrinsics.checkParameterIsNotNull(iMVerificationActivity, "");
        IMAPI.Companion companion = IMAPI.INSTANCE;
        IMAPI.Companion.getAuthRequestContext(((IMInfo) list.get(0)).MyBillsEntityDataFactory, iMVerificationActivity, new RedirectDataCallback() { // from class: com.ipification.mobile.sdk.im.ui.IMVerificationActivity$subscribeInitResult$2$1
            @Override // com.ipification.mobile.sdk.im.listener.RedirectDataCallback
            public final void PlaceComponentResult(String p0) {
                Intrinsics.checkParameterIsNotNull(p0, "");
                IMAPI.Companion companion2 = IMAPI.INSTANCE;
                IMAPI.Companion.PlaceComponentResult(IMVerificationActivity.this, p0);
            }
        });
    }

    /* renamed from: $r8$lambda$eDmSOQgL5RDSfXg-5F_f3hnafTc */
    public static /* synthetic */ void m232$r8$lambda$eDmSOQgL5RDSfXg5F_f3hnafTc(IMVerificationActivity iMVerificationActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkParameterIsNotNull(iMVerificationActivity, "");
        IPConstant.Companion companion = IPConstant.INSTANCE;
        iMVerificationActivity.getAuthRequestContext(IPConstant.Companion.PlaceComponentResult().getErrorConfigVersion);
    }

    public static /* synthetic */ void $r8$lambda$m2sBMxv6tyAFvMrZTw6SZjJv2_w(IMVerificationActivity iMVerificationActivity) {
        Intrinsics.checkParameterIsNotNull(iMVerificationActivity, "");
        iMVerificationActivity.BuiltInFictitiousFunctionClassFactory(null);
    }

    public static /* synthetic */ void $r8$lambda$npC4mQ4Kjt3m6tIGFeLKQr22TZ0(final IMVerificationActivity iMVerificationActivity, SessionResponse sessionResponse) {
        CellularException cellularException;
        CellularException cellularException2;
        CellularException cellularException3;
        CellularException cellularException4;
        CellularException cellularException5;
        Intrinsics.checkParameterIsNotNull(iMVerificationActivity, "");
        String str = iMVerificationActivity.getAuthRequestContext;
        Objects.toString(sessionResponse == null ? null : Boolean.valueOf(sessionResponse.getMyBillsEntityDataFactory()));
        Objects.toString((sessionResponse == null || (cellularException5 = sessionResponse.getAuthRequestContext) == null) ? null : cellularException5.BuiltInFictitiousFunctionClassFactory);
        if (sessionResponse != null && sessionResponse.getMyBillsEntityDataFactory()) {
            IPConstant.Companion companion = IPConstant.INSTANCE;
            IPConstant PlaceComponentResult = IPConstant.Companion.PlaceComponentResult();
            StringBuilder sb = new StringBuilder();
            sb.append(PlaceComponentResult.DatabaseTableConfigUtil);
            sb.append("completeSession - success: ");
            AuthResponse authResponse = sessionResponse.PlaceComponentResult;
            sb.append((Object) (authResponse != null ? authResponse.getAuthRequestContext() : null));
            sb.append(" \n");
            String obj = sb.toString();
            Intrinsics.checkParameterIsNotNull(obj, "");
            PlaceComponentResult.DatabaseTableConfigUtil = obj;
            AuthResponse authResponse2 = sessionResponse.PlaceComponentResult;
            if (authResponse2 != null) {
                iMVerificationActivity.BuiltInFictitiousFunctionClassFactory(authResponse2);
                return;
            }
            return;
        }
        IPConstant.Companion companion2 = IPConstant.INSTANCE;
        IPConstant PlaceComponentResult2 = IPConstant.Companion.PlaceComponentResult();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(PlaceComponentResult2.DatabaseTableConfigUtil);
        sb2.append("completeSession - error: ");
        sb2.append((Object) ((sessionResponse == null || (cellularException4 = sessionResponse.getAuthRequestContext) == null) ? null : cellularException4.BuiltInFictitiousFunctionClassFactory));
        sb2.append('\n');
        String obj2 = sb2.toString();
        Intrinsics.checkParameterIsNotNull(obj2, "");
        PlaceComponentResult2.DatabaseTableConfigUtil = obj2;
        if (Intrinsics.areEqual((sessionResponse == null || (cellularException3 = sessionResponse.getAuthRequestContext) == null) ? null : cellularException3.BuiltInFictitiousFunctionClassFactory, "not_found")) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(iMVerificationActivity);
                IMService.Companion companion3 = IMService.INSTANCE;
                builder.setTitle(IMService.Companion.BuiltInFictitiousFunctionClassFactory().NetworkUserEntityData$$ExternalSyntheticLambda0);
                builder.setMessage(IMService.Companion.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory);
                builder.setPositiveButton(IMService.Companion.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult, new DialogInterface.OnClickListener() { // from class: com.ipification.mobile.sdk.im.ui.IMVerificationActivity$$ExternalSyntheticLambda5
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        IMVerificationActivity.m232$r8$lambda$eDmSOQgL5RDSfXg5F_f3hnafTc(IMVerificationActivity.this, dialogInterface, i);
                    }
                });
                builder.show();
            } catch (Exception unused) {
                IPConstant.Companion companion4 = IPConstant.INSTANCE;
                iMVerificationActivity.getAuthRequestContext(IPConstant.Companion.PlaceComponentResult().getErrorConfigVersion);
            }
        }
        if (Intrinsics.areEqual((sessionResponse == null || (cellularException2 = sessionResponse.getAuthRequestContext) == null) ? null : cellularException2.BuiltInFictitiousFunctionClassFactory, "finished")) {
            try {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(iMVerificationActivity);
                IMService.Companion companion5 = IMService.INSTANCE;
                builder2.setTitle(IMService.Companion.BuiltInFictitiousFunctionClassFactory().NetworkUserEntityData$$ExternalSyntheticLambda0);
                builder2.setMessage(IMService.Companion.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext);
                builder2.setPositiveButton(IMService.Companion.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult, new DialogInterface.OnClickListener() { // from class: com.ipification.mobile.sdk.im.ui.IMVerificationActivity$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        IMVerificationActivity.$r8$lambda$UlHrLAYYt_u4NiiGC0n9LlQl5Fo(IMVerificationActivity.this, dialogInterface, i);
                    }
                });
                builder2.show();
            } catch (Exception unused2) {
                IPConstant.Companion companion6 = IPConstant.INSTANCE;
                iMVerificationActivity.getAuthRequestContext(IPConstant.Companion.PlaceComponentResult().PlaceComponentResult);
            }
        }
        if (Intrinsics.areEqual((sessionResponse == null || (cellularException = sessionResponse.getAuthRequestContext) == null) ? null : cellularException.BuiltInFictitiousFunctionClassFactory, "pending")) {
            RepositoryModule.Companion companion7 = RepositoryModule.INSTANCE;
            IMSession getAuthRequestContext = RepositoryModule.Companion.getAuthRequestContext().MyBillsEntityDataFactory().getGetAuthRequestContext();
            iMVerificationActivity.getBinding().MyBillsEntityDataFactory.setVisibility(0);
            List<IMInfo> KClassImpl$Data$declaredNonStaticMembers$22 = getAuthRequestContext != null ? getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2() : null;
            if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                VerificationExtensionKt.Companion companion8 = VerificationExtensionKt.INSTANCE;
                PackageManager packageManager = iMVerificationActivity.getPackageManager();
                Intrinsics.checkExpressionValueIsNotNull(packageManager, "");
                List<IMInfo> authRequestContext = VerificationExtensionKt.Companion.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, packageManager);
                if (authRequestContext.size() == 1) {
                    IPConfiguration.Companion companion9 = IPConfiguration.INSTANCE;
                    if (IPConfiguration.Companion.MyBillsEntityDataFactory().getIsLayoutRequested()) {
                        iMVerificationActivity.replaceFragmentWith(VerificationExtensionKt.Companion.PlaceComponentResult(authRequestContext), false, R.id.res_0x7f0a1a1e_networkuserentitydata_externalsyntheticlambda1);
                    }
                }
            }
        }
        iMVerificationActivity.hideLoading();
    }

    public static /* synthetic */ void $r8$lambda$rvaMB53Ky8GvcE0vDGkWx_DL910(IMVerificationActivity iMVerificationActivity, View view) {
        Intrinsics.checkParameterIsNotNull(iMVerificationActivity, "");
        iMVerificationActivity.onBackPressed();
    }

    private final void getAuthRequestContext(Intent p0) {
        Intrinsics.stringPlus("finishSessionIfRequired ", p0);
        try {
            NotificationManagerCompat MyBillsEntityDataFactory = NotificationManagerCompat.MyBillsEntityDataFactory(this);
            IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
            MyBillsEntityDataFactory.MyBillsEntityDataFactory(IPConfiguration.Companion.MyBillsEntityDataFactory().NetworkUserEntityData$$ExternalSyntheticLambda4);
        } catch (Exception unused) {
        }
        Bundle extras = p0 == null ? null : p0.getExtras();
        if (extras != null && extras.getBoolean(IAPSyncCommand.COMMAND_INIT)) {
            p0.replaceExtras((Bundle) null);
            return;
        }
        TextView textView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        IMService.Companion companion2 = IMService.INSTANCE;
        textView.setText(IMService.Companion.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2);
        IPConfiguration.Companion companion3 = IPConfiguration.INSTANCE;
        if (IPConfiguration.Companion.MyBillsEntityDataFactory().getNetworkUserEntityData$$ExternalSyntheticLambda8()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ipification.mobile.sdk.im.ui.IMVerificationActivity$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    IMVerificationActivity.$r8$lambda$m2sBMxv6tyAFvMrZTw6SZjJv2_w(IMVerificationActivity.this);
                }
            }, 2000L);
            return;
        }
        showLoading();
        IPConstant.Companion companion4 = IPConstant.INSTANCE;
        IPConstant PlaceComponentResult = IPConstant.Companion.PlaceComponentResult();
        String stringPlus = Intrinsics.stringPlus(PlaceComponentResult.DatabaseTableConfigUtil, "completeSession - start \n");
        Intrinsics.checkParameterIsNotNull(stringPlus, "");
        PlaceComponentResult.DatabaseTableConfigUtil = stringPlus;
        RepositoryModule.Companion companion5 = RepositoryModule.INSTANCE;
        SingleLiveEvent<SessionResponse> authRequestContext = RepositoryModule.Companion.getAuthRequestContext().MyBillsEntityDataFactory().getAuthRequestContext(this);
        if (authRequestContext != null) {
            authRequestContext.PlaceComponentResult(this, new Observer() { // from class: com.ipification.mobile.sdk.im.ui.IMVerificationActivity$$ExternalSyntheticLambda4
                @Override // androidx.view.Observer
                public final void onChanged(Object obj) {
                    IMVerificationActivity.$r8$lambda$npC4mQ4Kjt3m6tIGFeLKQr22TZ0(IMVerificationActivity.this, (SessionResponse) obj);
                }
            });
            return;
        }
        try {
            hideLoading();
            Toast.makeText(this, "ERROR: IMBOX_SESSION_ID is empty. Please try again!", 0).show();
        } catch (Exception unused2) {
        }
        returnErrorToApp$default(this, null, 1, null);
    }

    private final void getAuthRequestContext(String p0) {
        Intent intent = new Intent();
        IPConstant.Companion companion = IPConstant.INSTANCE;
        String str = IPConstant.Companion.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory;
        RepositoryModule.Companion companion2 = RepositoryModule.INSTANCE;
        IMSession getAuthRequestContext = RepositoryModule.Companion.getAuthRequestContext().MyBillsEntityDataFactory().getGetAuthRequestContext();
        intent.putExtra(str, getAuthRequestContext == null ? null : getAuthRequestContext.getAuthRequestContext);
        intent.putExtra(IPConstant.Companion.PlaceComponentResult().getAuthRequestContext, p0);
        setResult(-1, intent);
        finish();
    }

    public static /* synthetic */ void returnErrorToApp$default(IMVerificationActivity iMVerificationActivity, CellularException cellularException, int i, Object obj) {
        if ((i & 1) != 0) {
            cellularException = null;
        }
        Intent intent = new Intent();
        IPConstant.Companion companion = IPConstant.INSTANCE;
        String str = IPConstant.Companion.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory;
        RepositoryModule.Companion companion2 = RepositoryModule.INSTANCE;
        IMSession getAuthRequestContext = RepositoryModule.Companion.getAuthRequestContext().MyBillsEntityDataFactory().getGetAuthRequestContext();
        intent.putExtra(str, getAuthRequestContext == null ? null : getAuthRequestContext.getAuthRequestContext);
        intent.putExtra(IPConstant.Companion.PlaceComponentResult().getAuthRequestContext, cellularException != null ? cellularException.PlaceComponentResult() : null);
        iMVerificationActivity.setResult(-1, intent);
        iMVerificationActivity.finish();
    }

    private final void BuiltInFictitiousFunctionClassFactory(AuthResponse p0) {
        Intent intent = new Intent();
        IPConstant.Companion companion = IPConstant.INSTANCE;
        String str = IPConstant.Companion.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory;
        RepositoryModule.Companion companion2 = RepositoryModule.INSTANCE;
        IMSession getAuthRequestContext = RepositoryModule.Companion.getAuthRequestContext().MyBillsEntityDataFactory().getGetAuthRequestContext();
        intent.putExtra(str, getAuthRequestContext == null ? null : getAuthRequestContext.getAuthRequestContext);
        intent.putExtra(IPConstant.Companion.PlaceComponentResult().scheduleImpl, p0 != null ? p0.getAuthRequestContext : null);
        setResult(-1, intent);
        finish();
    }

    @Override // com.ipification.mobile.sdk.im.base.BaseVerificationActivity
    public final void onCreateActivity(Bundle savedInstanceState) {
        String str;
        RepositoryModule.Companion companion = RepositoryModule.INSTANCE;
        IMSession getAuthRequestContext = RepositoryModule.Companion.getAuthRequestContext().MyBillsEntityDataFactory().getGetAuthRequestContext();
        Intrinsics.stringPlus("sessionInfo ", getAuthRequestContext);
        Intent intent = getIntent();
        final IMInfo iMInfo = null;
        Bundle extras = intent == null ? null : intent.getExtras();
        if (extras != null && extras.getBoolean(IAPSyncCommand.COMMAND_INIT)) {
            IPConfiguration.Companion companion2 = IPConfiguration.INSTANCE;
            if (!IPConfiguration.Companion.MyBillsEntityDataFactory().getNetworkUserEntityData$$ExternalSyntheticLambda8() || getAuthRequestContext == null) {
                PackageManager packageManager = getPackageManager();
                Intrinsics.checkExpressionValueIsNotNull(packageManager, "");
                Intrinsics.stringPlus("sessionInfo ", getAuthRequestContext);
                if (getAuthRequestContext != null) {
                    List<IMInfo> KClassImpl$Data$declaredNonStaticMembers$22 = getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
                    VerificationExtensionKt.Companion companion3 = VerificationExtensionKt.INSTANCE;
                    final List<IMInfo> authRequestContext = VerificationExtensionKt.Companion.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, packageManager);
                    if (authRequestContext.size() == 1 && IPConfiguration.Companion.MyBillsEntityDataFactory().getIsLayoutRequested()) {
                        TextView textView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
                        IMService.Companion companion4 = IMService.INSTANCE;
                        String format = String.format(IMService.Companion.BuiltInFictitiousFunctionClassFactory().moveToNextValue, Arrays.copyOf(new Object[]{StringsKt.capitalize(authRequestContext.get(0).BuiltInFictitiousFunctionClassFactory)}, 1));
                        Intrinsics.checkExpressionValueIsNotNull(format, "");
                        textView.setText(format);
                        getBinding().MyBillsEntityDataFactory.setVisibility(8);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ipification.mobile.sdk.im.ui.IMVerificationActivity$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                IMVerificationActivity.m231$r8$lambda$ZSLwldWulqesPWfkUAyHd8Jaag(authRequestContext, this);
                            }
                        }, 500L);
                    } else if ((!authRequestContext.isEmpty()) == true) {
                        getBinding().MyBillsEntityDataFactory.setVisibility(0);
                        replaceFragmentWith(VerificationExtensionKt.Companion.PlaceComponentResult(authRequestContext), false, R.id.res_0x7f0a1a1e_networkuserentitydata_externalsyntheticlambda1);
                    } else {
                        str = "Error: Supported IM App is not available. Please try again!";
                    }
                } else {
                    str = "Error: SessionId is empty. Please try again!";
                }
                try {
                    Toast.makeText(this, str, 0).show();
                    finish();
                } catch (Exception unused) {
                }
            } else {
                VerificationExtensionKt.Companion companion5 = VerificationExtensionKt.INSTANCE;
                List<IMInfo> KClassImpl$Data$declaredNonStaticMembers$23 = getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
                PackageManager packageManager2 = getPackageManager();
                Intrinsics.checkExpressionValueIsNotNull(packageManager2, "");
                Intrinsics.checkParameterIsNotNull(KClassImpl$Data$declaredNonStaticMembers$23, "");
                Intrinsics.checkParameterIsNotNull(packageManager2, "");
                if ((!VerificationExtensionKt.Companion.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$23, packageManager2).isEmpty()) != false) {
                    List<IMInfo> BuiltInFictitiousFunctionClassFactory = VerificationExtensionKt.Companion.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$23, packageManager2);
                    IPConfiguration.Companion companion6 = IPConfiguration.INSTANCE;
                    String[] strArr = IPConfiguration.Companion.MyBillsEntityDataFactory().FragmentBottomSheetPaymentSettingBinding;
                    if ((!BuiltInFictitiousFunctionClassFactory.isEmpty()) != false) {
                        int length = strArr.length;
                        int i = 0;
                        loop0: while (true) {
                            if (i >= length) {
                                break;
                            }
                            String str2 = strArr[i];
                            i++;
                            for (IMInfo iMInfo2 : BuiltInFictitiousFunctionClassFactory) {
                                if (Intrinsics.areEqual(str2, iMInfo2.BuiltInFictitiousFunctionClassFactory)) {
                                    iMInfo = iMInfo2;
                                    break loop0;
                                }
                            }
                        }
                    }
                }
                if (iMInfo != null) {
                    TextView textView2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
                    IMService.Companion companion7 = IMService.INSTANCE;
                    String format2 = String.format(IMService.Companion.BuiltInFictitiousFunctionClassFactory().moveToNextValue, Arrays.copyOf(new Object[]{StringsKt.capitalize(iMInfo.BuiltInFictitiousFunctionClassFactory)}, 1));
                    Intrinsics.checkExpressionValueIsNotNull(format2, "");
                    textView2.setText(format2);
                    getBinding().MyBillsEntityDataFactory.setVisibility(8);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ipification.mobile.sdk.im.ui.IMVerificationActivity$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            IMVerificationActivity.$r8$lambda$KRBODaVpRxkbqP1ssOZOfEQS3XQ(IMInfo.this, this);
                        }
                    }, 500L);
                }
            }
        }
        TextView textView3 = getBinding().PlaceComponentResult;
        Intrinsics.checkExpressionValueIsNotNull(textView3, "");
        customizeToolbar(textView3);
        this.PlaceComponentResult = false;
    }

    private static void d(boolean z, int[] iArr, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr = lookAheadTest;
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

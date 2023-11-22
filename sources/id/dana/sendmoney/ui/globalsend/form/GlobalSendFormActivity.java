package id.dana.sendmoney.ui.globalsend.form;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.view.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.adapter.BaseViewPager2StateAdapter;
import id.dana.core.ui.util.OSUtil;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.databinding.ActivityGlobalSendFormBinding;
import id.dana.sendmoney.ui.globalsend.form.adapter.GlobalSendFormVPAdapter;
import id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment;
import id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment;
import id.dana.sendmoney.ui.globalsend.form.model.BeneficiaryInfoModel;
import id.dana.sendmoney.ui.globalsend.form.model.GlobalTransferInitModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CountryModel;
import id.dana.sendmoney.util.ViewPagerExtKt;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005J1\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0013J)\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\b\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\u00068\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\tR\u0013\u0010\u0014\u001a\u00020\u000eX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b&\u0010'"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/GlobalSendFormActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/sendmoney/databinding/ActivityGlobalSendFormBinding;", "", "configToolbar", "()V", "", "p0", "PlaceComponentResult", "(Z)V", "inflateViewBinding", "()Lid/dana/sendmoney/databinding/ActivityGlobalSendFormBinding;", IAPSyncCommand.COMMAND_INIT, "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "", "p1", "Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;", "p2", "p3", "(Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;Ljava/lang/String;Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;Ljava/lang/String;Z)V", "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "getAuthRequestContext", "scheduleImpl", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryModel;", "getErrorConfigVersion", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryModel;", "lookAheadTest", "Z", "isNewTransaction", "()Z", "setNewTransaction", "initRecordTimeStamp", "Lkotlin/Lazy;", "Lid/dana/sendmoney/ui/globalsend/form/adapter/GlobalSendFormVPAdapter;", "DatabaseTableConfigUtil", "Lid/dana/sendmoney/ui/globalsend/form/adapter/GlobalSendFormVPAdapter;", "BuiltInFictitiousFunctionClassFactory", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSendFormActivity extends BaseViewBindingActivity<ActivityGlobalSendFormBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static long GetContactSyncConfig = 0;
    public static final String IS_NEW_RECIPIENT = "IS_NEW_RECIPIENT";
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
    public static final String PAGE_SOURCE = "PAGE_SOURCE";

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private GlobalSendFormVPAdapter BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private BeneficiaryInfoModel getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;
    public static final byte[] $$a = {71, Ascii.US, 113, 39, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 169;
    public static final byte[] getAuthRequestContext = {38, -105, 32, Ascii.RS, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 192;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean isNewTransaction = true;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private CountryModel PlaceComponentResult = new CountryModel(null, null, null, null, null, null, null, null, false, false, 1023, null);

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<String>() { // from class: id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity$pageSource$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String stringExtra = GlobalSendFormActivity.this.getIntent().getStringExtra(GlobalSendFormActivity.PAGE_SOURCE);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    static {
        MyBillsEntityDataFactory();
        INSTANCE = new Companion(null);
    }

    static void MyBillsEntityDataFactory() {
        NetworkUserEntityData$$ExternalSyntheticLambda1 = new char[]{62255, 56649, 45048, 30727, 19077, 6954, 58716, 47039, 32871, 21135, 8996, 3555, 57315, 43128, 31364, 19200, 5544, 59358, 45144, 33532, 21294, 15803, 3642, 55364, 43767, 31595, 57970, 52237, 48817, 26968, 23504, 2674, 62483, 42639, 37161, 17360, 12903, 7419, 52894, 47397, 27611, 23135, 1262, 63110, 7691, 12397, 17116, 38179, 42913, 62990, 2168, 23195, 27981, 49064, 52830, 57529, 13044, 17744, 38839, 42536, 63625, 2784, 30691, 22942, 11017, 64732, 52814, 62329, 56644, 44970, 30797, 19162, 6951, 58625, 47017, 32817, 21146, 9015, 3499, 57287, 43049, 31425, 19295, 5615, 59270, 45082, 33508, 21278, 15792, 3627, 55319, 43762, 31548, 17884, 5689, 57344, 45775, 33633, 28060, 15959, 2289, 55950, 43820, 30188, 18010, 4320, 57985, 45841, 40441, 28224, 14555, 2336, 56072, 42406, 30316, 24940, 20305, 15849, 59986, 55503, 35129, 30539, 9706, 4641, 49375, 45358, 40891, 19845, 14953, 59522, 55582, 34735, 30150, 8713, 4343, 49501, 44961, 39997, 19025, 14563, 59694, 55198, 33915, 29257, 8332, 4465, 65416, 44110, 39648, 18635, 14702, 59306, 54339, 33451, 28865, 8528, 4076, 64594, 43679, 39778, 18767, 14306, 58493, 53902, 33575, 29112, 24543, 3168, 64135, 43803, 39347, 18373, 13405, 58020, 54108, 33184, 28208, 23559, 2793, 24877, 20295, 15784, 59974, 55426, 35109, 30555, 9716, 4719, 49302, 45373, 40877, 19906, 14969, 59537, 55567, 34798, 30083, 8777, 4272, 49433, 45024, 40056, 19011, 14576, 59704, 55180, 33844, 29189, 8348, 4454, 65483, 44040, 39666, 18655, 14716, 59321, 54277, 33471, 28888, 8527, 4008, 64532, 43656, 39723, 18778, 14240, 58426, 53961, 33599, 29182, 24465, 3193, 64147, 43871, 39333, 18384, 13387, 58092, 54042, 33253, 28207, 23620, 2801, 62246, 56659, 45032, 30725, 19097, 7033, 58647, 47038, 32866, 21150, 9018, 3500, 57228, 43119, 31384, 19227, 5563, 59350, 45144, 33510, 21275, 15776, 3644, 55311, 43761, 31610, 17797, 5679, 57430, 45784, 33649, 28044, 15887, 2229, 56025, 43835, 30185, 17932, 4277, 58014, 45895, 40431, 28189, 14530, 2347, 56149, 42487, 30316, 16525, 4387, 58339, 52691, 40488, 26844, 14605, 2999, 54739, 42561, 28912, 16654, 9783, 2121, 31464, 44315, 40856, 52786};
        GetContactSyncConfig = 5347882263316651303L;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = 56 - r8
            int r7 = r7 + 16
            int r6 = 106 - r6
            byte[] r0 = id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity.getAuthRequestContext
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L31
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L31:
            int r6 = -r6
            int r7 = r7 + r6
            int r6 = r7 + (-4)
            int r7 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity.b(byte, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 2
            int r9 = r9 + 75
            int r7 = r7 * 3
            int r7 = 42 - r7
            byte[] r0 = id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity.$$a
            int r8 = r8 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r9
            r5 = 0
            r9 = r8
            goto L2c
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            int r8 = r8 + 1
            if (r5 != r7) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r6
        L2c:
            int r8 = r8 + r3
            int r8 = r8 + (-7)
            r3 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity.c(byte, int, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((ViewConfiguration.getWindowTouchSlop() >> 8) + 18, 44 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (60708 - Gravity.getAbsoluteGravity(0, 0)), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(4 - ((byte) KeyEvent.getModifierMetaStateMask()), (ViewConfiguration.getLongPressTimeout() >> 16) + 62, (char) (33984 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.keyCodeFromString(""), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(47 - ((byte) KeyEvent.getModifierMetaStateMask()), (ViewConfiguration.getWindowTouchSlop() >> 8) + 67, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((Process.myTid() >> 22) + 64, 115 - KeyEvent.keyCodeFromString(""), (char) (View.MeasureSpec.getMode(0) + 37443), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(64 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 178, (char) (View.MeasureSpec.getMode(0) + 37457), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(TextUtils.indexOf("", "", 0, 0) + 60, 243 - (ViewConfiguration.getTouchSlop() >> 8), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 7, 303 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (54593 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = getAuthRequestContext[25];
                Object[] objArr13 = new Object[1];
                b(b, b, (byte) (-getAuthRequestContext[31]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(getAuthRequestContext[9], getAuthRequestContext[25], getAuthRequestContext[3], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(56 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 3 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getTapTimeout() >> 16));
                        Object[] objArr16 = new Object[1];
                        c($$a[31], $$a[47], $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.MeasureSpec.getMode(0), 15 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) View.combineMeasuredStates(0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 800, 15 - View.getDefaultSize(0, 0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 28 - TextUtils.lastIndexOf("", '0'), (char) (57994 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 800, 15 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (ViewConfiguration.getTouchSlop() >> 8)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0') + 36, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1340709892, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 910, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b2 = getAuthRequestContext[25];
                Object[] objArr19 = new Object[1];
                b(b2, b2, (byte) (-getAuthRequestContext[31]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b(getAuthRequestContext[9], getAuthRequestContext[25], getAuthRequestContext[3], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getLongPressTimeout() >> 16), View.resolveSizeAndState(0, 0, 0) + 46, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
                        Object[] objArr22 = new Object[1];
                        c($$a[8], $$a[28], $$a[9], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 35, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-1340709892, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 911, Gravity.getAbsoluteGravity(0, 0) + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = getAuthRequestContext[25];
                Object[] objArr25 = new Object[1];
                b(b3, b3, (byte) (-getAuthRequestContext[31]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b(getAuthRequestContext[9], getAuthRequestContext[25], getAuthRequestContext[3], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 119, (ViewConfiguration.getTouchSlop() >> 8) + 3, (char) (Color.rgb(0, 0, 0) + 16816184));
                        Object[] objArr28 = new Object[1];
                        c($$a[8], $$a[28], $$a[9], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1340709892, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, (char) View.MeasureSpec.getSize(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = getAuthRequestContext[25];
                Object[] objArr31 = new Object[1];
                b(b4, b4, (byte) (-getAuthRequestContext[31]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b(getAuthRequestContext[9], getAuthRequestContext[25], getAuthRequestContext[3], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 107, 3 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (Process.myTid() >> 22));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[78] - 1), (byte) (-$$a[40]), (byte) ($$a[78] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), 35 - KeyEvent.keyCodeFromString(""), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-1340709892, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ((Process.getThreadPriority(0) + 20) >> 6), (Process.myPid() >> 22) + 18, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(getPackageName().codePointAt(3) - 82, getPackageName().length() + 37, (char) (super.getResources().getString(R.string.deals_online_category_lifestyle_and_other).substring(2, 3).codePointAt(0) + 60600), objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        int codePointAt = super.getResources().getString(R.string.promo_period).substring(0, 1).codePointAt(0) - 75;
        try {
            Object[] objArr3 = new Object[1];
            b((byte) (-getAuthRequestContext[32]), getAuthRequestContext[30], (byte) (getAuthRequestContext[49] - 1), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(getAuthRequestContext[48], getAuthRequestContext[8], getAuthRequestContext[25], objArr4);
            Object[] objArr5 = new Object[1];
            a(codePointAt, ((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 29, (char) (KeyEvent.keyCodeFromString("") + 33984), objArr5);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    try {
                        Object[] objArr6 = new Object[1];
                        b((byte) (-getAuthRequestContext[32]), getAuthRequestContext[30], (byte) (getAuthRequestContext[49] - 1), objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        b(getAuthRequestContext[48], getAuthRequestContext[8], getAuthRequestContext[25], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        a(((ApplicationInfo) cls3.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 7, super.getResources().getString(R.string.too_many_verify_otp_title_dialog).substring(17, 20).length() - 3, (char) (super.getResources().getString(R.string.card_binding_tips_content).substring(0, 5).length() - 5), objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        a(super.getResources().getString(R.string.ep_paylater_activation_subtitle).substring(8, 18).length() + 8, getPackageName().length() + 19, (char) (super.getResources().getString(R.string.mybills_payment_status_marked_paid).substring(11, 12).codePointAt(0) + 4350), objArr8);
                        baseContext = (Context) cls4.getMethod((String) objArr8[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionType(0L), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 36, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        int length = super.getResources().getString(R.string.system_error_title).substring(2, 7).length() + 43;
                        try {
                            Object[] objArr9 = new Object[1];
                            b((byte) (-getAuthRequestContext[32]), getAuthRequestContext[30], (byte) (getAuthRequestContext[49] - 1), objArr9);
                            Class<?> cls5 = Class.forName((String) objArr9[0]);
                            Object[] objArr10 = new Object[1];
                            b(getAuthRequestContext[48], getAuthRequestContext[8], getAuthRequestContext[25], objArr10);
                            Object[] objArr11 = new Object[1];
                            a(length, ((ApplicationInfo) cls5.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 34, (char) (ViewConfiguration.getLongPressTimeout() >> 16), objArr11);
                            String str = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            a(64 - TextUtils.indexOf("", ""), super.getResources().getString(R.string.pushverify_list_login).substring(0, 6).length() + 109, (char) (getPackageName().codePointAt(1) + 37343), objArr12);
                            String str2 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            a(63 - ImageFormat.getBitsPerPixel(0), super.getResources().getString(R.string.voucher_code_asset_empty_title).substring(10, 11).length() + 178, (char) (37457 - KeyEvent.getDeadChar(0, 0)), objArr13);
                            String str3 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            a(TextUtils.lastIndexOf("", '0') + 61, getPackageName().codePointAt(4) + 146, (char) (getPackageName().length() - 7), objArr14);
                            String str4 = (String) objArr14[0];
                            Object[] objArr15 = new Object[1];
                            a(super.getResources().getString(R.string.mix_pay_promo_not_available_dialog_title).substring(15, 16).length() + 5, getPackageName().length() + 296, (char) (super.getResources().getString(R.string.image_capture_upload_photo_btn_label).substring(0, 6).codePointAt(4) + 54527), objArr15);
                            try {
                                Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 18 - KeyEvent.keyCodeFromString(""), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr16);
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
                byte b = getAuthRequestContext[25];
                Object[] objArr17 = new Object[1];
                b(b, b, (byte) (-getAuthRequestContext[31]), objArr17);
                Class<?> cls6 = Class.forName((String) objArr17[0]);
                Object[] objArr18 = new Object[1];
                b(getAuthRequestContext[9], getAuthRequestContext[25], getAuthRequestContext[3], objArr18);
                try {
                    Object[] objArr19 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 4, (char) ExpandableListView.getPackedPositionType(0L));
                        Object[] objArr20 = new Object[1];
                        c((byte) ($$a[78] - 1), (byte) (-$$a[40]), (byte) ($$a[78] - 1), objArr20);
                        obj3 = cls7.getMethod((String) objArr20[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                    int i = ((int[]) objArr21[1])[0];
                    if (((int[]) objArr21[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0', 0) + 36, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr22 = {-1713259795, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, 18 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr22);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.upgrade_to_premium_message).substring(43, 44).codePointAt(0) - 6, super.getResources().getString(R.string.res_0x7f1302fa_networkuserentitydata_externalsyntheticlambda5).substring(0, 1).length() - 1, (char) (super.getResources().getString(R.string.paylater_bill_detail_title).substring(8, 9).length() - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            int length = getPackageName().length() + 11;
            try {
                Object[] objArr2 = new Object[1];
                b((byte) (-getAuthRequestContext[32]), getAuthRequestContext[30], (byte) (getAuthRequestContext[49] - 1), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(getAuthRequestContext[48], getAuthRequestContext[8], getAuthRequestContext[25], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(length, ((ApplicationInfo) cls2.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 7, (char) (4447 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ImageFormat.getBitsPerPixel(0), 34 - TextUtils.lastIndexOf("", '0'), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myTid() >> 22), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 26, Color.green(0), (char) ExpandableListView.getPackedPositionGroup(0L), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                b((byte) (-getAuthRequestContext[32]), getAuthRequestContext[30], (byte) (getAuthRequestContext[49] - 1), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(getAuthRequestContext[48], getAuthRequestContext[8], getAuthRequestContext[25], objArr3);
                int i = ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion - 15;
                int keyRepeatTimeout = 26 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                try {
                    Object[] objArr4 = new Object[1];
                    b((byte) (-getAuthRequestContext[32]), getAuthRequestContext[30], (byte) (getAuthRequestContext[49] - 1), objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    b(getAuthRequestContext[48], getAuthRequestContext[8], getAuthRequestContext[25], objArr5);
                    Object[] objArr6 = new Object[1];
                    a(i, keyRepeatTimeout, (char) (((ApplicationInfo) cls3.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 4414), objArr6);
                    baseContext = (Context) cls.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr7 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSizeAndState(0, 0, 0), Color.red(0) + 18, (char) Color.alpha(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr7);
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
        super.onResume();
    }

    @JvmName(name = "isNewTransaction")
    /* renamed from: isNewTransaction  reason: from getter */
    public final boolean getIsNewTransaction() {
        return this.isNewTransaction;
    }

    @JvmName(name = "setNewTransaction")
    public final void setNewTransaction(boolean z) {
        this.isNewTransaction = z;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityGlobalSendFormBinding inflateViewBinding() {
        ActivityGlobalSendFormBinding KClassImpl$Data$declaredNonStaticMembers$22 = ActivityGlobalSendFormBinding.KClassImpl$Data$declaredNonStaticMembers$2(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        Toolbar toolbar = getBinding().PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        setToolbar(toolbar);
        Toolbar toolbar2 = getToolbar();
        Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(toolbar2.getContext(), id.dana.sendmoney.R.drawable.PlaceComponentResult);
        toolbar2.setContentDescription(getString(id.dana.sendmoney.R.string.NetworkUserEntityData$$ExternalSyntheticLambda1));
        toolbar2.setNavigationIcon(PlaceComponentResult);
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GlobalSendFormActivity.$r8$lambda$Rn7ZdjPd_4eOCcRtvhn_df6XeDM(GlobalSendFormActivity.this, view);
            }
        });
        getBinding().PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(id.dana.sendmoney.R.string.global_send_toolbar_title));
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2$default(GlobalSendFormActivity globalSendFormActivity, BeneficiaryInfoModel beneficiaryInfoModel, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        globalSendFormActivity.KClassImpl$Data$declaredNonStaticMembers$2(beneficiaryInfoModel, str, z);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(BeneficiaryInfoModel p0, String p1, boolean p2) {
        GlobalSendFormVPAdapter globalSendFormVPAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (globalSendFormVPAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalSendFormVPAdapter = null;
        }
        AmountFormFragment amountFormFragment = (AmountFormFragment) ((BaseViewPager2StateAdapter) globalSendFormVPAdapter).getAuthRequestContext.get(1);
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        amountFormFragment.getAuthRequestContext = p0;
        amountFormFragment.BuiltInFictitiousFunctionClassFactory = p1;
        amountFormFragment.initRecordTimeStamp = p2;
    }

    static /* synthetic */ void PlaceComponentResult$default(GlobalSendFormActivity globalSendFormActivity, BeneficiaryInfoModel beneficiaryInfoModel, String str, GlobalTransferInitModel globalTransferInitModel, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        globalSendFormActivity.PlaceComponentResult(beneficiaryInfoModel, str, globalTransferInitModel, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult(BeneficiaryInfoModel p0, String p1, GlobalTransferInitModel p2, boolean p3) {
        GlobalSendFormVPAdapter globalSendFormVPAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (globalSendFormVPAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalSendFormVPAdapter = null;
        }
        ((AmountFormFragment) ((BaseViewPager2StateAdapter) globalSendFormVPAdapter).getAuthRequestContext.get(1)).PlaceComponentResult(p0, p1, p2, p3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void PlaceComponentResult$default(GlobalSendFormActivity globalSendFormActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        globalSendFormActivity.PlaceComponentResult(z);
    }

    private final void PlaceComponentResult(boolean p0) {
        ViewPager2 viewPager2 = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "");
        GlobalSendFormVPAdapter globalSendFormVPAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (globalSendFormVPAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalSendFormVPAdapter = null;
        }
        ViewPagerExtKt.MyBillsEntityDataFactory(viewPager2, globalSendFormVPAdapter.getGetAuthRequestContext(), p0);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/GlobalSendFormActivity$Companion;", "", "", GlobalSendFormActivity.IS_NEW_RECIPIENT, "Ljava/lang/String;", GlobalSendFormActivity.PAGE_SOURCE, "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$Rn7ZdjPd_4eOCcRtvhn_df6XeDM(GlobalSendFormActivity globalSendFormActivity, View view) {
        Intrinsics.checkNotNullParameter(globalSendFormActivity, "");
        globalSendFormActivity.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        boolean booleanExtra = getIntent().getBooleanExtra(IS_NEW_RECIPIENT, true);
        this.isNewTransaction = booleanExtra;
        if (booleanExtra) {
            Intent intent = getIntent();
            OSUtil oSUtil = OSUtil.INSTANCE;
            if (OSUtil.PlaceComponentResult()) {
                CountryModel countryModel = (CountryModel) intent.getParcelableExtra("COUNTRY_MODEL", CountryModel.class);
                if (countryModel != null) {
                    this.PlaceComponentResult = countryModel;
                }
            } else {
                CountryModel countryModel2 = (CountryModel) intent.getParcelableExtra("COUNTRY_MODEL");
                if (countryModel2 != null) {
                    this.PlaceComponentResult = countryModel2;
                }
            }
        } else {
            Intent intent2 = getIntent();
            String stringExtra = intent2.getStringExtra("CARD_NUMBER");
            if (stringExtra != null) {
                Intrinsics.checkNotNullExpressionValue(stringExtra, "");
                this.MyBillsEntityDataFactory = stringExtra;
            }
            OSUtil oSUtil2 = OSUtil.INSTANCE;
            if (OSUtil.PlaceComponentResult()) {
                BeneficiaryInfoModel beneficiaryInfoModel = (BeneficiaryInfoModel) intent2.getParcelableExtra("BENEFICIARY_INFO_MODEL", BeneficiaryInfoModel.class);
                if (beneficiaryInfoModel != null) {
                    this.getAuthRequestContext = beneficiaryInfoModel;
                }
            } else {
                BeneficiaryInfoModel beneficiaryInfoModel2 = (BeneficiaryInfoModel) intent2.getParcelableExtra("BENEFICIARY_INFO_MODEL");
                if (beneficiaryInfoModel2 != null) {
                    this.getAuthRequestContext = beneficiaryInfoModel2;
                }
            }
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        BaseViewBindingFragment[] baseViewBindingFragmentArr = new BaseViewBindingFragment[2];
        ReceiverFormFragment.Companion companion = ReceiverFormFragment.INSTANCE;
        baseViewBindingFragmentArr[0] = ReceiverFormFragment.Companion.MyBillsEntityDataFactory(this.PlaceComponentResult, new Function3<BeneficiaryInfoModel, String, GlobalTransferInitModel, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity$initViewPager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final /* bridge */ /* synthetic */ Unit invoke(BeneficiaryInfoModel beneficiaryInfoModel3, String str, GlobalTransferInitModel globalTransferInitModel) {
                invoke2(beneficiaryInfoModel3, str, globalTransferInitModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BeneficiaryInfoModel beneficiaryInfoModel3, String str, GlobalTransferInitModel globalTransferInitModel) {
                Intrinsics.checkNotNullParameter(beneficiaryInfoModel3, "");
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(globalTransferInitModel, "");
                GlobalSendFormActivity.this.PlaceComponentResult(beneficiaryInfoModel3, str, globalTransferInitModel, false);
                GlobalSendFormActivity.PlaceComponentResult$default(GlobalSendFormActivity.this, false, 1, null);
            }
        }, (String) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
        AmountFormFragment.Companion companion2 = AmountFormFragment.INSTANCE;
        baseViewBindingFragmentArr[1] = AmountFormFragment.Companion.BuiltInFictitiousFunctionClassFactory(this.isNewTransaction ? "Input Receiver" : PAGE_SOURCE);
        this.BuiltInFictitiousFunctionClassFactory = new GlobalSendFormVPAdapter(supportFragmentManager, lifecycle, CollectionsKt.listOf((Object[]) baseViewBindingFragmentArr));
        ViewPager2 viewPager2 = getBinding().getAuthRequestContext;
        viewPager2.setUserInputEnabled(false);
        GlobalSendFormVPAdapter globalSendFormVPAdapter = this.BuiltInFictitiousFunctionClassFactory;
        String str = null;
        if (globalSendFormVPAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalSendFormVPAdapter = null;
        }
        viewPager2.setAdapter(globalSendFormVPAdapter);
        if (this.isNewTransaction) {
            return;
        }
        BeneficiaryInfoModel beneficiaryInfoModel3 = this.getAuthRequestContext;
        if (beneficiaryInfoModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            beneficiaryInfoModel3 = null;
        }
        String str2 = this.MyBillsEntityDataFactory;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            str = str2;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(beneficiaryInfoModel3, str, true);
        PlaceComponentResult(false);
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (NetworkUserEntityData$$ExternalSyntheticLambda1[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ GetContactSyncConfig))) ^ c;
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

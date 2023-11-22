package id.dana.savings.activity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.usereducation.BottomSheetHelpActivity;
import id.dana.usereducation.BottomSheetOnBoardingActivity;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.constant.BottomSheetType;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.usereducation.model.OnBoardingModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b \u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH&¢\u0006\u0004\b\u0010\u0010\u000eJ\u0019\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/savings/activity/OnBoardingActivity;", "Lid/dana/base/BaseActivity;", "", "configToolbar", "()V", "Lid/dana/di/modules/BottomSheetOnBoardingModule;", "getBottomOnBoardingModule", "()Lid/dana/di/modules/BottomSheetOnBoardingModule;", "", "Lid/dana/usereducation/model/ContentOnBoardingModel;", "getOnBoardingContents", "()Ljava/util/List;", "", "getOnBoardingListViewTitleStringRes", "()Ljava/lang/String;", "getOnBoardingPageViewTitleStringRes", "getOnBoardingScenario", "Landroid/os/Bundle;", "savedInstanceState", IAPSyncCommand.COMMAND_INIT, "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onClickRightMenuButton", "(Landroid/view/View;)V", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "onBoardingPresenter", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "getOnBoardingPresenter", "()Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "setOnBoardingPresenter", "(Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class OnBoardingActivity extends BaseActivity {
    private static char NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    public static final int REQUEST_CODE_ON_BOARDING_BOTTOM_SHEET = 1007;
    public static final int SPOTLIGHT_SIZE = 20;
    private static char getErrorConfigVersion;
    private static char lookAheadTest;
    private static char scheduleImpl;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public BottomSheetOnBoardingContract.Presenter onBoardingPresenter;
    public static final byte[] $$a = {10, -99, -17, -84, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 193;
    public static final byte[] getAuthRequestContext = {94, Ascii.EM, -44, 73, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 93;

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.savings.activity.OnBoardingActivity.getAuthRequestContext
            int r7 = r7 + 97
            int r6 = 23 - r6
            int r8 = 55 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L2f
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r8 = r8 + 1
            r3 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L2f:
            int r7 = r7 + r8
            int r7 = r7 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.activity.OnBoardingActivity.b(byte, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 + 4
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r9 = r9 * 2
            int r9 = 103 - r9
            byte[] r0 = id.dana.savings.activity.OnBoardingActivity.$$a
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L18
            r9 = r7
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r8
            goto L37
        L18:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L1d:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            int r8 = r8 + 1
            if (r5 != r9) goto L2e
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2e:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L37:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + (-7)
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.activity.OnBoardingActivity.c(int, byte, short, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        scheduleImpl = (char) 59752;
        lookAheadTest = (char) 18876;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = (char) 23692;
        getErrorConfigVersion = (char) 28968;
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(AndroidCharacter.getMirror('0') - 30, new char[]{18094, 50819, 13906, 24853, 42381, 37081, 47906, 53661, 27705, 7727, 20848, 38210, 58747, 58410, 57278, 14138, 24861, 63555}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(5 - View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{9246, 1554, 18354, 29875, 6220, 59246}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(Color.green(0) + 48, new char[]{39486, 45314, 25104, 5987, 22703, 56942, 41819, 33054, 13553, 15974, 32380, 8112, 51472, 63897, 32745, 10647, 6557, 53328, 13264, 12117, 24980, 37037, 10367, 3336, 28610, 8673, 15307, 31835, 48589, 31391, 26876, 54982, 18983, 3888, 49436, 58872, 21564, 37327, 40009, 30223, 20543, 40572, 42268, 50651, 27550, 47103, 41217, 3882}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(AndroidCharacter.getMirror('0') + 16, new char[]{20131, 45064, 62848, 7107, 21564, 37327, 59378, 8868, 24980, 37037, 2170, 56046, 61578, 47533, 4742, 1853, 53600, 15820, 60989, 15390, 61578, 47533, 20151, 39463, 48018, 8728, 61499, 62338, 15307, 31835, 53600, 15820, 12678, 8543, 31386, 55278, 17225, 48557, 45818, 147, 16404, 6700, 56501, 42223, 19988, 6050, 3674, 25258, 40960, 63751, 19897, 38187, 48710, 64802, 27503, 14272, 27503, 14272, 17829, 14993, 54430, 23826, 28610, 8673}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(Color.alpha(0) + 64, new char[]{51825, 1535, 35256, 32506, 48710, 64802, 803, 12316, 29602, 31342, 7144, 62508, 57940, 5883, 59616, 34251, 26876, 54982, 43684, 33655, 34846, 61998, 55807, 420, 20543, 40572, 41819, 33054, 33423, 26743, 39486, 45314, 27626, 30447, 36410, 56178, 1803, 64973, 25104, 5987, 50746, 25573, 4742, 1853, 40009, 30223, 63117, 11756, 21564, 37327, 57278, 14138, 51825, 1535, 52748, 23968, 57318, 27444, 18983, 3888, 52748, 23968, 15974, 225}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(60 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), new char[]{43412, 40218, 59379, 37662, 20303, 15224, 18892, 31663, 52496, 24612, 29616, 5743, 39238, 54218, 64208, 25747, 19244, 2957, 31871, 24330, 48706, 6184, 53356, 62775, 19985, 19243, 62181, 27740, 27792, 16957, 32964, 12998, 62181, 27740, 48949, 60771, 25829, 59280, 9771, 54150, 20420, 39278, 42695, 32218, 45600, 25731, 32617, 1172, 54872, 58866, 11228, 7002, 45609, 12328, 46099, 34300, 12474, 11884, 59139, 8295}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(6 - (Process.myTid() >> 22), new char[]{9968, 14421, 56096, 6415, 51825, 1535}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 911, View.getDefaultSize(0, 0) + 18, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) (-getAuthRequestContext[30]), getAuthRequestContext[32], getAuthRequestContext[31], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (-getAuthRequestContext[30]);
                byte b2 = (byte) (b + 1);
                Object[] objArr14 = new Object[1];
                b(b, b2, (byte) (b2 | 22), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - View.MeasureSpec.getSize(0), View.MeasureSpec.getSize(0) + 3, (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[68], (byte) (-$$a[12]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 15 - View.combineMeasuredStates(0, 0), (char) (Process.getGidForName("") + 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.blue(0), 16 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) TextUtils.indexOf("", ""))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - View.getDefaultSize(0, 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 29, (char) (57995 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.getDefaultSize(0, 0), TextUtils.getTrimmedLength("") + 15, (char) TextUtils.getCapsMode("", 0, 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r4 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, Gravity.getAbsoluteGravity(0, 0) + 35, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {2029613821, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 910, 18 - Gravity.getAbsoluteGravity(0, 0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[30]), getAuthRequestContext[32], getAuthRequestContext[31], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = (byte) (-getAuthRequestContext[30]);
                byte b4 = (byte) (b3 + 1);
                Object[] objArr20 = new Object[1];
                b(b3, b4, (byte) (b4 | 22), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 61, 47 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getScrollBarSize() >> 8));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[28]), (byte) (-$$a[8]), (byte) ($$a[47] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {2029613821, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 911, TextUtils.indexOf("", "") + 18, (char) Drawable.resolveOpacity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[30]), getAuthRequestContext[32], getAuthRequestContext[31], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = (byte) (-getAuthRequestContext[30]);
                byte b6 = (byte) (b5 + 1);
                Object[] objArr26 = new Object[1];
                b(b5, b6, (byte) (b6 | 22), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - TextUtils.getCapsMode("", 0, 0), 3 - (Process.myPid() >> 22), (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 38968));
                        Object[] objArr28 = new Object[1];
                        c((byte) (-$$a[28]), (byte) (-$$a[8]), (byte) ($$a[47] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {2029613821, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.red(0), 18 - (ViewConfiguration.getScrollBarSize() >> 8), (char) Drawable.resolveOpacity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[30]), getAuthRequestContext[32], getAuthRequestContext[31], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b7 = (byte) (-getAuthRequestContext[30]);
                byte b8 = (byte) (b7 + 1);
                Object[] objArr32 = new Object[1];
                b(b7, b8, (byte) (b8 | 22), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 107, TextUtils.lastIndexOf("", '0', 0, 0) + 4, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        Object[] objArr34 = new Object[1];
                        c($$a[40], (byte) ($$a[47] - 1), (byte) (-$$a[9]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {2029613821, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 911, KeyEvent.keyCodeFromString("") + 18, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    public abstract List<ContentOnBoardingModel> getOnBoardingContents();

    public abstract String getOnBoardingListViewTitleStringRes();

    public abstract String getOnBoardingPageViewTitleStringRes();

    public abstract String getOnBoardingScenario();

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        try {
            byte b = getAuthRequestContext[25];
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            b(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            b(getAuthRequestContext[27], (byte) (-getAuthRequestContext[5]), getAuthRequestContext[25], new Object[1]);
            Object[] objArr3 = new Object[1];
            a(((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{18094, 50819, 13906, 24853, 42381, 37081, 47906, 53661, 27705, 7727, 20848, 38210, 58747, 58410, 57278, 14138, 24861, 63555}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(getPackageName().codePointAt(3) - 95, new char[]{9246, 1554, 18354, 29875, 6220, 59246}, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    a(super.getResources().getString(R.string.tooltip_insufficient_balance_description).substring(8, 9).length() + 25, new char[]{18094, 50819, 13906, 24853, 42381, 37081, 47906, 53661, 20420, 39278, 5769, 58292, 46670, 52207, 56945, 6595, 59725, 17245, 14311, 8387, 43519, 19176, 11028, 57438, 20015, 11920}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a(ImageFormat.getBitsPerPixel(0) + 19, new char[]{28700, 13615, 44352, 55038, 12474, 11884, 36270, 11297, 31571, 34753, 15076, 41044, 47200, 11490, 56945, 6595, 17544, 54153}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getTouchSlop() >> 8), (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        a(super.getResources().getString(R.string.ep_gold_price_not_changed_title).substring(2, 3).codePointAt(0) - 62, new char[]{39486, 45314, 25104, 5987, 22703, 56942, 41819, 33054, 13553, 15974, 32380, 8112, 51472, 63897, 32745, 10647, 6557, 53328, 13264, 12117, 24980, 37037, 10367, 3336, 28610, 8673, 15307, 31835, 48589, 31391, 26876, 54982, 18983, 3888, 49436, 58872, 21564, 37327, 40009, 30223, 20543, 40572, 42268, 50651, 27550, 47103, 41217, 3882}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        a(64 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{20131, 45064, 62848, 7107, 21564, 37327, 59378, 8868, 24980, 37037, 2170, 56046, 61578, 47533, 4742, 1853, 53600, 15820, 60989, 15390, 61578, 47533, 20151, 39463, 48018, 8728, 61499, 62338, 15307, 31835, 53600, 15820, 12678, 8543, 31386, 55278, 17225, 48557, 45818, 147, 16404, 6700, 56501, 42223, 19988, 6050, 3674, 25258, 40960, 63751, 19897, 38187, 48710, 64802, 27503, 14272, 27503, 14272, 17829, 14993, 54430, 23826, 28610, 8673}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a((Process.myTid() >> 22) + 64, new char[]{51825, 1535, 35256, 32506, 48710, 64802, 803, 12316, 29602, 31342, 7144, 62508, 57940, 5883, 59616, 34251, 26876, 54982, 43684, 33655, 34846, 61998, 55807, 420, 20543, 40572, 41819, 33054, 33423, 26743, 39486, 45314, 27626, 30447, 36410, 56178, 1803, 64973, 25104, 5987, 50746, 25573, 4742, 1853, 40009, 30223, 63117, 11756, 21564, 37327, 57278, 14138, 51825, 1535, 52748, 23968, 57318, 27444, 18983, 3888, 52748, 23968, 15974, 225}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(getPackageName().length() + 53, new char[]{43412, 40218, 59379, 37662, 20303, 15224, 18892, 31663, 52496, 24612, 29616, 5743, 39238, 54218, 64208, 25747, 19244, 2957, 31871, 24330, 48706, 6184, 53356, 62775, 19985, 19243, 62181, 27740, 27792, 16957, 32964, 12998, 62181, 27740, 48949, 60771, 25829, 59280, 9771, 54150, 20420, 39278, 42695, 32218, 45600, 25731, 32617, 1172, 54872, 58866, 11228, 7002, 45609, 12328, 46099, 34300, 12474, 11884, 59139, 8295}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(ImageFormat.getBitsPerPixel(0) + 7, new char[]{9968, 14421, 56096, 6415, 51825, 1535}, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.normalizeMetaState(0), AndroidCharacter.getMirror('0') - 30, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            try {
                Object[] objArr13 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), getAuthRequestContext[32], getAuthRequestContext[31], objArr13);
                Class<?> cls4 = Class.forName((String) objArr13[0]);
                byte b3 = (byte) (-getAuthRequestContext[30]);
                byte b4 = (byte) (b3 + 1);
                Object[] objArr14 = new Object[1];
                b(b3, b4, (byte) (b4 | 22), objArr14);
                try {
                    Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 4 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) TextUtils.getOffsetBefore("", 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[40], (byte) ($$a[47] - 1), (byte) (-$$a[9]), objArr16);
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
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr18 = {-1968861302, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, View.resolveSize(0, 0) + 18, (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr18);
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
        } catch (Throwable th7) {
            Throwable cause7 = th7.getCause();
            if (cause7 == null) {
                throw th7;
            }
            throw cause7;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.mybills_tooltip_description_not_issued).substring(7, 8).codePointAt(0) - 6, new char[]{18094, 50819, 13906, 24853, 42381, 37081, 47906, 53661, 20420, 39278, 5769, 58292, 46670, 52207, 56945, 6595, 59725, 17245, 14311, 8387, 43519, 19176, 11028, 57438, 20015, 11920}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.error_description_failed_inquiry_balance).substring(19, 21).length() + 16, new char[]{28700, 13615, 44352, 55038, 12474, 11884, 36270, 11297, 31571, 34753, 15076, 41044, 47200, 11490, 56945, 6595, 17544, 54153}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getJumpTapTimeout() >> 16), ImageFormat.getBitsPerPixel(0) + 36, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + 911, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.promotion).substring(0, 5).length() + 21, new char[]{18094, 50819, 13906, 24853, 42381, 37081, 47906, 53661, 20420, 39278, 5769, 58292, 46670, 52207, 56945, 6595, 59725, 17245, 14311, 8387, 43519, 19176, 11028, 57438, 20015, 11920}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((Process.myTid() >> 22) + 18, new char[]{28700, 13615, 44352, 55038, 12474, 11884, 36270, 11297, 31571, 34753, 15076, 41044, 47200, 11490, 56945, 6595, 17544, 54153}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 930, ExpandableListView.getPackedPositionGroup(0L) + 35, (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0'), ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getOnBoardingPresenter")
    public final BottomSheetOnBoardingContract.Presenter getOnBoardingPresenter() {
        BottomSheetOnBoardingContract.Presenter presenter = this.onBoardingPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setOnBoardingPresenter")
    public final void setOnBoardingPresenter(BottomSheetOnBoardingContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.onBoardingPresenter = presenter;
    }

    @Override // id.dana.base.BaseActivity
    public void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        registerPresenter(getOnBoardingPresenter());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BottomSheetOnBoardingModule getBottomOnBoardingModule() {
        return new BottomSheetOnBoardingModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.savings.activity.OnBoardingActivity$getBottomOnBoardingModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str, String str2) {
                BottomSheetOnBoardingContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final void onGetBottomSheetOnBoardingAvailability(boolean p0, String p1) {
                if (p0) {
                    r1.startActivityForResult(BottomSheetOnBoardingActivity.createOnBoardingIntent(r1, new OnBoardingModel(r1.getOnBoardingPageViewTitleStringRes(), BottomSheetType.VIEW_PAGER, r1.getOnBoardingContents(), OnBoardingActivity.this.getOnBoardingScenario(), null, null, null, 112, null)), 1007);
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getName());
                sb.append("on Error: ");
                sb.append(p0);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString());
            }
        });
    }

    @Override // id.dana.base.BaseActivity
    public void onClickRightMenuButton(View view) {
        BottomSheetHelpActivity.Companion companion = BottomSheetHelpActivity.INSTANCE;
        startActivity(BottomSheetHelpActivity.Companion.PlaceComponentResult(this, new OnBoardingModel(getOnBoardingListViewTitleStringRes(), "list", getOnBoardingContents(), getOnBoardingScenario(), null, null, null, 112, null), true));
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            int i2 = 58224;
            for (int i3 = 0; i3 < 16; i3++) {
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (getErrorConfigVersion ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (lookAheadTest ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (scheduleImpl ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}

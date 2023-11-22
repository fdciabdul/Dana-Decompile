package id.dana.challenge;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.ViewPagerBaseActivity;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.ChallengeScenarioListener;
import id.dana.challenge.otp.WhatsAppOtpReceiver;
import id.dana.challenge.scenario.ScenarioFacade;
import id.dana.domain.model.rpc.response.LoginResponse;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.popup.LockableViewPager;
import id.dana.richview.socialshare.AppPackageName;
import id.dana.utils.KeyboardHelper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b(\u0010\nJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u0019\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0019\u001a\u00020\u00062\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001b\u0010\nJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001c\u0010\nJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\nR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&"}, d2 = {"Lid/dana/challenge/ChallengeActivity;", "Lid/dana/base/ViewPagerBaseActivity;", "Lid/dana/challenge/ChallengeScenarioListener;", "Lid/dana/challenge/OtpHeightListener;", "", "additionalHeight", "", "addBottomSheetHeight", "(I)V", "closeChallengeSession", "()V", "configToolbar", "getLayout", "()I", "hideClose", IAPSyncCommand.COMMAND_INIT, "onBackPressed", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "", "", ChallengePinWithFaceActivity.CHALLENGE_METHOD_LIST, "otpPurpose", "onNext", "(Ljava/util/List;Ljava/lang/String;)V", "onPause", "onStart", "showClose", "Lid/dana/challenge/scenario/ScenarioFacade;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/challenge/scenario/ScenarioFacade;", "getAuthRequestContext", "getErrorConfigVersion", "I", "MyBillsEntityDataFactory", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChallengeActivity extends ViewPagerBaseActivity implements ChallengeScenarioListener, OtpHeightListener {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private ScenarioFacade getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;
    public static final byte[] $$g = {45, -61, Ascii.ETB, 105, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$h = 97;
    public static final byte[] lookAheadTest = {116, 39, -17, SignedBytes.MAX_POWER_OF_TWO, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int scheduleImpl = 57;
    private static int[] DatabaseTableConfigUtil = {-136347067, -980928742, -556438897, 1417293106, -1550963708, -321938719, -463661299, 755106914, 1989747899, 802311631, 59654672, -1798796045, -1022933107, -1891715729, -721330860, 1465494464, 224352769, -1620554870};
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2 = "";

    /* JADX WARN: Removed duplicated region for block: B:20:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0026 -> B:23:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = 23 - r7
            byte[] r0 = id.dana.challenge.ChallengeActivity.lookAheadTest
            int r8 = 55 - r8
            int r6 = r6 + 97
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L14
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L31
        L14:
            r3 = 0
        L15:
            int r8 = r8 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r4 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L31:
            int r8 = r8 + r7
            int r7 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.challenge.ChallengeActivity.h(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002d -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = 46 - r8
            byte[] r0 = id.dana.challenge.ChallengeActivity.$$g
            int r7 = r7 * 2
            int r7 = 103 - r7
            int r6 = r6 * 3
            int r6 = 42 - r6
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L37
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r8 = r8 + 1
            int r4 = r3 + 1
            if (r3 != r6) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
            int r8 = r8 + r6
            int r6 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.challenge.ChallengeActivity.j(short, byte, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.base.ViewPagerBaseActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.ViewPagerBaseActivity
    public final View _$_findCachedViewById(int i) {
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

    @Override // id.dana.base.ViewPagerBaseActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        g(TextUtils.lastIndexOf("", '0', 0) + 19, new int[]{-288668964, -1019738812, -414493868, -21013271, -75500199, -1005066012, -490271787, 1423544310, 1623602826, 1191515076}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        g(4 - MotionEvent.axisFromString(""), new int[]{272737234, -338713427, -1082075043, -306410314}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 930, 35 - KeyEvent.normalizeMetaState(0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    g(48 - View.resolveSizeAndState(0, 0, 0), new int[]{-1120267614, 211468368, -141307744, -2120013143, -1501661485, -369083292, -1973163881, -2124380064, 630736039, 356616753, 1562952198, -474489869, 1382183871, 1478956581, 2064708123, -271232247, -1386159552, -1922742222, -631789707, 82851476, 172695331, -1523778086, -292520012, -804916750}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 63, new int[]{-697510631, 1191391044, -1274985862, 1632297113, 2073053326, -1670508941, 1627542326, 595413311, 65082183, -1058273488, 907815616, -426903001, -824936565, -612707890, -1173879011, -1477803642, -2101098669, 2021658904, -344269553, 1356001673, -596695741, -891165990, 1310334018, 299598987, 480637843, -1157046748, 236145788, -710123236, 1602921279, 1663448753, -1763570936, -1472553078}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g(63 - TextUtils.lastIndexOf("", '0', 0), new int[]{1118202510, -1976546268, -1664352400, 588345342, 1765289947, 1916193335, -1095876483, -1716043672, 484114711, -1781012038, -1658200916, -1014421733, 830849481, 918456434, -1054842798, 288674348, 859773405, -126403296, 824834773, 369500619, 298902587, -1429090529, 1867306458, -853506726, -263790987, -210526370, 1741878819, -1151532114, 1328204558, -1318299067, 1773171450, -662671376}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g(60 - Color.alpha(0), new int[]{-1622508475, -1527173495, -584734601, -31439578, 689180902, -581205975, 1374497708, 60004177, 532149503, -714415243, 265479127, 942617799, 1793164923, 7909343, 2035770858, -1882199052, -1242345678, -175881464, 124875718, 1588338392, -30324139, -1702741792, 149032880, 1112878369, 1640264376, 374509564, -1312247494, -543650147, -1918138519, 1691271210}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    g((KeyEvent.getMaxKeyCode() >> 16) + 6, new int[]{-608840832, -1208128740, -757466375, 910297673}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, TextUtils.indexOf((CharSequence) "", '0') + 19, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                h(lookAheadTest[32], (byte) (-lookAheadTest[30]), lookAheadTest[31], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                h((byte) (scheduleImpl & 14), (byte) (-lookAheadTest[30]), (byte) (lookAheadTest[34] + 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 55, 3 - Color.blue(0), (char) (AndroidCharacter.getMirror('0') - '0'));
                        Object[] objArr16 = new Object[1];
                        j($$g[31], $$g[12], $$g[53], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.green(0), 14 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 800, 15 - Color.green(0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 815, 28 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 57993))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.resolveSize(0, 0), '?' - AndroidCharacter.getMirror('0'), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 35, (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {551392453, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 910, 18 - View.MeasureSpec.getSize(0), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                h(lookAheadTest[32], (byte) (-lookAheadTest[30]), lookAheadTest[31], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                h((byte) (scheduleImpl & 14), (byte) (-lookAheadTest[30]), (byte) (lookAheadTest[34] + 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - TextUtils.getTrimmedLength(""), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 46, (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                        Object[] objArr22 = new Object[1];
                        j($$g[8], (byte) ($$g[78] - 1), $$g[84], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 34 - TextUtils.lastIndexOf("", '0', 0), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {551392453, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 911, 18 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                h(lookAheadTest[32], (byte) (-lookAheadTest[30]), lookAheadTest[31], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                h((byte) (scheduleImpl & 14), (byte) (-lookAheadTest[30]), (byte) (lookAheadTest[34] + 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - Color.red(0), TextUtils.indexOf((CharSequence) "", '0', 0) + 4, (char) (38969 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))));
                        Object[] objArr28 = new Object[1];
                        j($$g[8], (byte) ($$g[78] - 1), $$g[84], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getTouchSlop() >> 8) + 35, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {551392453, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.argb(0, 0, 0, 0), Color.blue(0) + 18, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                h(lookAheadTest[32], (byte) (-lookAheadTest[30]), lookAheadTest[31], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                h((byte) (scheduleImpl & 14), (byte) (-lookAheadTest[30]), (byte) (lookAheadTest[34] + 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - Drawable.resolveOpacity(0, 0), (ViewConfiguration.getScrollBarSize() >> 8) + 3, (char) View.MeasureSpec.getMode(0));
                        Object[] objArr34 = new Object[1];
                        j((byte) ($$g[78] - 1), $$g[9], (byte) ($$g[78] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - ExpandableListView.getPackedPositionType(0L), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {551392453, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 911, 18 - View.resolveSize(0, 0), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    public final void configToolbar() {
    }

    @Override // id.dana.base.ViewPagerBaseActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.ViewPagerBaseActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_challenge;
    }

    @Override // id.dana.base.ViewPagerBaseActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.ViewPagerBaseActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        g(18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), new int[]{-288668964, -1019738812, -414493868, -21013271, -75500199, -1005066012, -490271787, 1423544310, 1623602826, 1191515076}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        g(ImageFormat.getBitsPerPixel(0) + 6, new int[]{272737234, -338713427, -1082075043, -306410314}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    byte b = lookAheadTest[25];
                    byte b2 = b;
                    Object[] objArr4 = new Object[1];
                    h(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    h((byte) (-lookAheadTest[5]), lookAheadTest[27], lookAheadTest[25], new Object[1]);
                    Object[] objArr5 = new Object[1];
                    g(((ApplicationInfo) cls2.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 7, new int[]{-288668964, -1019738812, -414493868, -21013271, 589767921, -368070516, 2123478214, 138734614, 485530160, -216615733, 294160822, -1876179751, -502252763, -1203709552}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    g(TextUtils.indexOf((CharSequence) "", '0') + 19, new int[]{-1458788007, -596896010, -62184745, 1961430477, 1855884969, 435751805, -817180124, 708353433, 1609241546, -1298537355}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        byte b3 = lookAheadTest[25];
                        byte b4 = b3;
                        Object[] objArr7 = new Object[1];
                        h(b3, b4, (byte) (b4 | TarHeader.LF_BLK), objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        h((byte) (-lookAheadTest[5]), lookAheadTest[27], lookAheadTest[25], objArr8);
                        Object[] objArr9 = new Object[1];
                        g(((ApplicationInfo) cls4.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 15, new int[]{-1120267614, 211468368, -141307744, -2120013143, -1501661485, -369083292, -1973163881, -2124380064, 630736039, 356616753, 1562952198, -474489869, 1382183871, 1478956581, 2064708123, -271232247, -1386159552, -1922742222, -631789707, 82851476, 172695331, -1523778086, -292520012, -804916750}, objArr9);
                        String str = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        g(getPackageName().length() + 57, new int[]{-697510631, 1191391044, -1274985862, 1632297113, 2073053326, -1670508941, 1627542326, 595413311, 65082183, -1058273488, 907815616, -426903001, -824936565, -612707890, -1173879011, -1477803642, -2101098669, 2021658904, -344269553, 1356001673, -596695741, -891165990, 1310334018, 299598987, 480637843, -1157046748, 236145788, -710123236, 1602921279, 1663448753, -1763570936, -1472553078}, objArr10);
                        String str2 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        g(super.getResources().getString(R.string.twilio_identity_verification_auto_logout_message).substring(2, 3).codePointAt(0) - 50, new int[]{1118202510, -1976546268, -1664352400, 588345342, 1765289947, 1916193335, -1095876483, -1716043672, 484114711, -1781012038, -1658200916, -1014421733, 830849481, 918456434, -1054842798, 288674348, 859773405, -126403296, 824834773, 369500619, 298902587, -1429090529, 1867306458, -853506726, -263790987, -210526370, 1741878819, -1151532114, 1328204558, -1318299067, 1773171450, -662671376}, objArr11);
                        String str3 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        g(60 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new int[]{-1622508475, -1527173495, -584734601, -31439578, 689180902, -581205975, 1374497708, 60004177, 532149503, -714415243, 265479127, 942617799, 1793164923, 7909343, 2035770858, -1882199052, -1242345678, -175881464, 124875718, 1588338392, -30324139, -1702741792, 149032880, 1112878369, 1640264376, 374509564, -1312247494, -543650147, -1918138519, 1691271210}, objArr12);
                        String str4 = (String) objArr12[0];
                        Object[] objArr13 = new Object[1];
                        g(getPackageName().codePointAt(2) - 40, new int[]{-608840832, -1208128740, -757466375, 910297673}, objArr13);
                        try {
                            Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 911, KeyEvent.normalizeMetaState(0) + 18, (char) Color.blue(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr14);
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
            Object[] objArr15 = new Object[1];
            h(lookAheadTest[32], (byte) (-lookAheadTest[30]), lookAheadTest[31], objArr15);
            Class<?> cls5 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            h((byte) (scheduleImpl & 14), (byte) (-lookAheadTest[30]), (byte) (lookAheadTest[34] + 1), objArr16);
            try {
                Object[] objArr17 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 494, 4 - TextUtils.indexOf("", "", 0), (char) KeyEvent.getDeadChar(0, 0));
                    Object[] objArr18 = new Object[1];
                    j((byte) ($$g[78] - 1), $$g[9], (byte) ($$g[78] - 1), objArr18);
                    obj3 = cls6.getMethod((String) objArr18[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr19 = (Object[]) ((Method) obj3).invoke(null, objArr17);
                int i = ((int[]) objArr19[1])[0];
                if (((int[]) objArr19[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 35 - Color.alpha(0), (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr20 = {-1347699022, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getSize(0), 'B' - AndroidCharacter.getMirror('0'), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr20);
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
    }

    public final /* synthetic */ void onDismiss() {
        ChallengeScenarioListener.CC.getAuthRequestContext();
    }

    public final /* synthetic */ void onNextCarrierIdentificationFirst(LoginResponse loginResponse, List list) {
        ChallengeScenarioListener.CC.BuiltInFictitiousFunctionClassFactory(loginResponse);
    }

    @Override // id.dana.base.ViewPagerBaseActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = lookAheadTest[25];
                byte b2 = b;
                Object[] objArr = new Object[1];
                h(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                h((byte) (-lookAheadTest[5]), lookAheadTest[27], lookAheadTest[25], new Object[1]);
                Object[] objArr2 = new Object[1];
                g(((ApplicationInfo) cls.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 7, new int[]{-288668964, -1019738812, -414493868, -21013271, 589767921, -368070516, 2123478214, 138734614, 485530160, -216615733, 294160822, -1876179751, -502252763, -1203709552}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                g(super.getResources().getString(R.string.send_to_phone_number_title).substring(10, 11).length() + 17, new int[]{-1458788007, -596896010, -62184745, 1961430477, 1855884969, 435751805, -817180124, 708353433, 1609241546, -1298537355}, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), (Process.myTid() >> 22) + 35, (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), ExpandableListView.getPackedPositionChild(0L) + 19, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.f5052130772056, R.anim.f5092130772063);
    }

    @Override // id.dana.base.BaseActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        PendingIntent pendingIntent;
        super.onNewIntent(intent);
        if (Build.VERSION.SDK_INT >= 33) {
            if (intent != null) {
                pendingIntent = (PendingIntent) intent.getParcelableExtra(WhatsAppOtpReceiver.CI, PendingIntent.class);
            }
            pendingIntent = null;
        } else {
            if (intent != null) {
                pendingIntent = (PendingIntent) intent.getParcelableExtra(WhatsAppOtpReceiver.CI);
            }
            pendingIntent = null;
        }
        String creatorPackage = pendingIntent != null ? pendingIntent.getCreatorPackage() : null;
        if (Intrinsics.areEqual("com.whatsapp", creatorPackage) || Intrinsics.areEqual(AppPackageName.WHATSAPP_FOR_BUSINESS, creatorPackage)) {
            String stringExtra = intent != null ? intent.getStringExtra("code") : null;
            if (stringExtra == null) {
                stringExtra = "";
            }
            Intent putExtra = new Intent(WhatsAppOtpReceiver.ACTION_RECEIVE_OTP).putExtra(WhatsAppOtpReceiver.OTP, stringExtra);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            sendBroadcast(putExtra);
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString(ChallengeControl.Key.SCENARIO, "login");
            Intrinsics.checkNotNullExpressionValue(string, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = string;
            this.getAuthRequestContext = ChallengeScenarioFactory.PlaceComponentResult(string, extras);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            ScenarioFacade scenarioFacade = this.getAuthRequestContext;
            if (scenarioFacade == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                scenarioFacade = null;
            }
            registerViewPager((LockableViewPager) _$_findCachedViewById(R.id.popup_view), new ChallengeFragmentStateAdapter(supportFragmentManager, scenarioFacade.getAuthRequestContext()));
            LockableViewPager lockableViewPager = (LockableViewPager) _$_findCachedViewById(R.id.popup_view);
            if (lockableViewPager != null) {
                lockableViewPager.setSwipeable(false);
            }
        }
        LockableViewPager lockableViewPager2 = (LockableViewPager) _$_findCachedViewById(R.id.popup_view);
        if (lockableViewPager2 != null) {
            lockableViewPager2.post(new Runnable() { // from class: id.dana.challenge.ChallengeActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ChallengeActivity.$r8$lambda$0oRiLWIKtU6Cd4vC_f1UqmEJlUc(ChallengeActivity.this);
                }
            });
        }
        ImageButton imageButton = (ImageButton) _$_findCachedViewById(R.id.forEach);
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: id.dana.challenge.ChallengeActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChallengeActivity.m598$r8$lambda$tB8AyRcpgUpgSz90osUooz2E(ChallengeActivity.this, view);
                }
            });
        }
        DanaApplication danaApplication = getDanaApplication();
        if (danaApplication != null) {
            danaApplication.chckTmprdApp();
        }
    }

    @Override // id.dana.base.ViewPagerBaseActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(27 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new int[]{-288668964, -1019738812, -414493868, -21013271, 589767921, -368070516, 2123478214, 138734614, 485530160, -216615733, 294160822, -1876179751, -502252763, -1203709552}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(super.getResources().getString(R.string.top_up_balance_btn).substring(3, 4).length() + 17, new int[]{-1458788007, -596896010, -62184745, 1961430477, 1855884969, 435751805, -817180124, 708353433, 1609241546, -1298537355}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 930, TextUtils.indexOf((CharSequence) "", '0') + 36, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 911, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 18, (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        if (isFinishing()) {
            overridePendingTransition(R.anim.f5032130772052, R.anim.f5082130772059);
        }
    }

    @Override // id.dana.challenge.ChallengeScenarioListener
    public final void showClose() {
        ImageButton imageButton = (ImageButton) _$_findCachedViewById(R.id.forEach);
        if (imageButton != null) {
            imageButton.setVisibility(0);
        }
    }

    @Override // id.dana.challenge.ChallengeScenarioListener
    public final void hideClose() {
        ImageButton imageButton = (ImageButton) _$_findCachedViewById(R.id.forEach);
        if (imageButton != null) {
            imageButton.setVisibility(4);
        }
    }

    @Override // id.dana.challenge.ChallengeScenarioListener
    public final void onNext(List<String> r3, final String otpPurpose) {
        if (TextUtils.isEmpty(r3 != null ? r3.get(0) : null)) {
            addDisposable(Observable.timer(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.getAuthRequestContext()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.challenge.ChallengeActivity$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ChallengeActivity.$r8$lambda$Nq9R5Omf4WaMx2SBd1hmVidVf7Y(ChallengeActivity.this, (Long) obj);
                }
            }));
        } else {
            addDisposable(Observable.timer(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.getAuthRequestContext()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.challenge.ChallengeActivity$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ChallengeActivity.$r8$lambda$UwN4xQgPB0vdZC7AYnfkdrQUDZs(ChallengeActivity.this, otpPurpose, (Long) obj);
                }
            }));
        }
    }

    @Override // id.dana.challenge.ChallengeScenarioListener
    public final void closeChallengeSession() {
        KeyboardHelper.MyBillsEntityDataFactory(this);
        finish();
    }

    @Override // id.dana.base.ViewPagerBaseActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        KeyboardHelper.MyBillsEntityDataFactory(this);
        Intent intent = new Intent();
        intent.putExtra(ChallengeControl.Key.CANCEL_REASON, "back");
        setResult(0, intent);
        super.onBackPressed();
    }

    @Override // id.dana.challenge.OtpHeightListener
    public final void addBottomSheetHeight(int additionalHeight) {
        LockableViewPager lockableViewPager = (LockableViewPager) _$_findCachedViewById(R.id.popup_view);
        ViewGroup.LayoutParams layoutParams = lockableViewPager != null ? lockableViewPager.getLayoutParams() : null;
        if (layoutParams != null) {
            LockableViewPager lockableViewPager2 = (LockableViewPager) _$_findCachedViewById(R.id.popup_view);
            layoutParams.height = (lockableViewPager2 != null ? Integer.valueOf(lockableViewPager2.getHeight() + additionalHeight) : null).intValue();
        }
    }

    public static /* synthetic */ void $r8$lambda$0oRiLWIKtU6Cd4vC_f1UqmEJlUc(ChallengeActivity challengeActivity) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(challengeActivity, "");
        LockableViewPager lockableViewPager = (LockableViewPager) challengeActivity._$_findCachedViewById(R.id.popup_view);
        challengeActivity.MyBillsEntityDataFactory = (lockableViewPager == null || (layoutParams = lockableViewPager.getLayoutParams()) == null) ? 0 : layoutParams.height;
    }

    public static /* synthetic */ void $r8$lambda$Nq9R5Omf4WaMx2SBd1hmVidVf7Y(ChallengeActivity challengeActivity, Long l) {
        Intrinsics.checkNotNullParameter(challengeActivity, "");
        LockableViewPager lockableViewPager = (LockableViewPager) challengeActivity._$_findCachedViewById(R.id.popup_view);
        if (lockableViewPager != null) {
            lockableViewPager.requestFocus();
        }
        if (challengeActivity.getAuthRequestContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory((LockableViewPager) challengeActivity._$_findCachedViewById(R.id.popup_view));
        challengeActivity.setResult(-1, challengeActivity.getIntent());
        challengeActivity.finish();
    }

    public static /* synthetic */ void $r8$lambda$UwN4xQgPB0vdZC7AYnfkdrQUDZs(ChallengeActivity challengeActivity, String str, Long l) {
        Intrinsics.checkNotNullParameter(challengeActivity, "");
        LockableViewPager lockableViewPager = (LockableViewPager) challengeActivity._$_findCachedViewById(R.id.popup_view);
        if (lockableViewPager != null) {
            lockableViewPager.requestFocus();
        }
        if (challengeActivity.getAuthRequestContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory((LockableViewPager) challengeActivity._$_findCachedViewById(R.id.popup_view));
        Intent intent = new Intent();
        if (str == null) {
            str = "";
        }
        intent.putExtra("otpPurpose", str);
        challengeActivity.setResult(0, intent);
        challengeActivity.finish();
    }

    /* renamed from: $r8$lambda$tB8AyRcpgUpgSz90-o-s-Uooz2E */
    public static /* synthetic */ void m598$r8$lambda$tB8AyRcpgUpgSz90osUooz2E(ChallengeActivity challengeActivity, View view) {
        Intrinsics.checkNotNullParameter(challengeActivity, "");
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(new View(challengeActivity));
        challengeActivity.onBackPressed();
    }

    private static void g(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = DatabaseTableConfigUtil;
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
        int[] iArr5 = DatabaseTableConfigUtil;
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

package id.dana.miniprogram.tnc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
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
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequests;
import id.dana.danah5.showagreement.ShowAgreementBridge;
import id.dana.data.tracker.UserConsentTracker;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerServiceAgreementComponent;
import id.dana.miniprogram.adapter.MiniProgramAgreementsAdapter;
import id.dana.miniprogram.tnc.TncDetailMiniProgramActivity;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004R\u001e\u0010\r\u001a\f\u0012\b\u0012\u0006*\u00020\n0\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u00020\u00128\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/miniprogram/tnc/TncServiceDialogActivity;", "Lid/dana/miniprogram/tnc/AbstractTncMiniProgramDialogActivity;", "", "onBackPressed", "()V", "onTncClicked", "setupBehavior", "setupContent", "showIcon", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "getErrorConfigVersion", "Landroidx/activity/result/ActivityResultLauncher;", "PlaceComponentResult", "Lid/dana/miniprogram/tnc/TncServiceDialogActivity$StartParams;", "lookAheadTest", "Lid/dana/miniprogram/tnc/TncServiceDialogActivity$StartParams;", "getAuthRequestContext", "Lid/dana/data/tracker/UserConsentTracker;", "userConsentTracker", "Lid/dana/data/tracker/UserConsentTracker;", "getUserConsentTracker", "()Lid/dana/data/tracker/UserConsentTracker;", "setUserConsentTracker", "(Lid/dana/data/tracker/UserConsentTracker;)V", "<init>", "Companion", "StartParams"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class TncServiceDialogActivity extends AbstractTncMiniProgramDialogActivity {
    public static final String EXTRA_START_PARAMS = "startParams";
    private static int[] initRecordTimeStamp;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private StartParams getAuthRequestContext;
    @Inject
    public UserConsentTracker userConsentTracker;
    public static final byte[] $$g = {112, 117, 112, -122, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$h = 82;
    public static final byte[] scheduleImpl = {75, 108, -123, 87, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 144;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        initRecordTimeStamp = new int[]{1371052583, 1039318622, -1263421834, 765325471, 1822032273, -113753118, -1638696965, -1211745320, -1310951313, 1162600397, 359962385, 1634808333, 627876782, -1287424580, -699913062, -1915890131, -969286897, -420754295};
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = 55 - r7
            int r6 = 106 - r6
            byte[] r0 = id.dana.miniprogram.tnc.TncServiceDialogActivity.scheduleImpl
            int r8 = 23 - r8
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L16:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r6 = r6 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L34:
            int r7 = r7 + r8
            int r7 = r7 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.miniprogram.tnc.TncServiceDialogActivity.h(int, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(int r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.miniprogram.tnc.TncServiceDialogActivity.$$g
            int r8 = r8 * 3
            int r8 = r8 + 21
            int r9 = 46 - r9
            int r7 = r7 * 2
            int r7 = 103 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L33
        L18:
            r3 = 0
        L19:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            int r9 = r9 + 1
            if (r4 != r8) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L33:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + (-7)
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.miniprogram.tnc.TncServiceDialogActivity.j(int, short, short, java.lang.Object[]):void");
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity
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

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        g(18 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new int[]{2118472893, -1694235807, -1176400386, -1207181524, -799356602, 500577902, 1824842697, -601719037, 838305271, 270160072}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        g(4 - MotionEvent.axisFromString(""), new int[]{376043021, 1677955942, 2070135704, -2093682051}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((-1) - Process.getGidForName("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    g(TextUtils.getCapsMode("", 0, 0) + 48, new int[]{-1895929895, -1120874547, 1829417622, 1431450780, 815834861, 113247796, 1078532767, -938460086, 143572315, -643655970, -1362538283, -256749568, 781602333, 1762826363, -2005888099, 323964209, -850403297, -1937502246, 967279525, 1547879290, -587031262, -1488738179, 1671217116, -161802708}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g(63 - TextUtils.lastIndexOf("", '0', 0, 0), new int[]{1086856292, 1636391421, -576415674, 1949011586, -2139805580, -946231125, -2025557618, -1154838889, -1305007582, 66889089, -1747427676, 746779196, 174649299, 442212095, -575210102, -1369842411, 1098942296, -1028024269, 1511084479, -504987560, -1359964366, -1875123750, -1496930311, 117394363, -1222741283, -580920930, 1757960319, 2134136922, 1782742553, -1971650749, -302325212, 1734233264}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g(64 - (ViewConfiguration.getScrollBarSize() >> 8), new int[]{-990399775, 1118230585, -448550323, -1950446292, 637431102, 2103714091, 1915306765, 996675073, -2140453264, -291413378, -2101838403, 1151875635, 855211574, 1206133584, 158713683, -320666807, -189821760, 159153802, -427224018, 129098128, 1337478226, 608445622, -1127434895, 1820310994, 2070231803, -1555366528, 182616184, 48035321, -1577016579, 934386795, 365623392, 160261049}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g((ViewConfiguration.getTapTimeout() >> 16) + 60, new int[]{-1197536053, 1569706559, 1143783009, -154845508, -1880122415, -1397580376, -1286347472, 341033992, -1624121352, 1161130001, 1145751135, -1734472117, 72207592, -1943673127, -927067087, -1830369368, -592214090, 1732984303, -1443327357, 243979511, -1772195255, 1766020199, -1088080245, -985480405, -1368135731, -514192302, -1653586628, 759630677, -145358585, 290770613}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    g(TextUtils.getCapsMode("", 0, 0) + 6, new int[]{356307203, 1190993794, 1218674175, -481819582}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, (ViewConfiguration.getEdgeSlop() >> 16) + 18, (char) KeyEvent.normalizeMetaState(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                h(scheduleImpl[25], scheduleImpl[31], (byte) (-scheduleImpl[30]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                h(scheduleImpl[7], (byte) (scheduleImpl[34] + 1), (byte) (-scheduleImpl[30]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - Gravity.getAbsoluteGravity(0, 0), 3 - View.combineMeasuredStates(0, 0), (char) ExpandableListView.getPackedPositionGroup(0L));
                        Object[] objArr16 = new Object[1];
                        j((byte) (-$$g[12]), $$g[47], (byte) (-$$g[53]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 800, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 14, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.getDefaultSize(0, 0), 15 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(863 - AndroidCharacter.getMirror('0'), View.MeasureSpec.makeMeasureSpec(0, 0) + 29, (char) (ExpandableListView.getPackedPositionType(0L) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getOffsetBefore("", 0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 15, (char) (TextUtils.lastIndexOf("", '0') + 1)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.getDefaultSize(0, 0), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-802884676, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 911, 18 - TextUtils.getTrimmedLength(""), (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                h(scheduleImpl[25], scheduleImpl[31], (byte) (-scheduleImpl[30]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                h(scheduleImpl[7], (byte) (scheduleImpl[34] + 1), (byte) (-scheduleImpl[30]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 46 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) TextUtils.indexOf("", ""));
                        byte b = (byte) ($$g[47] - 1);
                        Object[] objArr22 = new Object[1];
                        j(b, b, $$g[20], objArr22);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-802884676, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 911, Color.green(0) + 18, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                h(scheduleImpl[25], scheduleImpl[31], (byte) (-scheduleImpl[30]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                h(scheduleImpl[7], (byte) (scheduleImpl[34] + 1), (byte) (-scheduleImpl[30]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - TextUtils.getOffsetBefore("", 0), TextUtils.indexOf((CharSequence) "", '0') + 4, (char) (Color.green(0) + 38968));
                        byte b2 = (byte) ($$g[47] - 1);
                        Object[] objArr28 = new Object[1];
                        j(b2, b2, $$g[20], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), 35 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-802884676, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 911, TextUtils.indexOf((CharSequence) "", '0', 0) + 19, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                h(scheduleImpl[25], scheduleImpl[31], (byte) (-scheduleImpl[30]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                h(scheduleImpl[7], (byte) (scheduleImpl[34] + 1), (byte) (-scheduleImpl[30]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 106, 3 - KeyEvent.keyCodeFromString(""), (char) TextUtils.getCapsMode("", 0, 0));
                        Object[] objArr34 = new Object[1];
                        j((byte) (-$$g[9]), (byte) (-$$g[8]), (byte) ($$g[47] - 1), objArr34);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetAfter("", 0), View.MeasureSpec.makeMeasureSpec(0, 0) + 35, (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-802884676, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 911, View.getDefaultSize(0, 0) + 18, (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        g((Process.myTid() >> 22) + 18, new int[]{2118472893, -1694235807, -1176400386, -1207181524, -799356602, 500577902, 1824842697, -601719037, 838305271, 270160072}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        g(4 - TextUtils.lastIndexOf("", '0', 0, 0), new int[]{376043021, 1677955942, 2070135704, -2093682051}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                g(getPackageName().codePointAt(5) - 84, new int[]{2118472893, -1694235807, -1176400386, -1207181524, -405077323, 488091875, -362004419, -372834657, 1125874872, -1278785818, 99788670, 443254534, -2057019327, -613527806}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                try {
                    Object[] objArr5 = new Object[1];
                    h(scheduleImpl[32], (byte) (scheduleImpl[59] + 1), scheduleImpl[25], objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    h(scheduleImpl[13], scheduleImpl[25], scheduleImpl[27], new Object[1]);
                    Object[] objArr6 = new Object[1];
                    g(((ApplicationInfo) cls3.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{28089367, -1089870523, -2101524309, -304489052, 1732048100, 1379030169, -421548241, 2106185460, 373270999, 1702475799}, objArr6);
                    baseContext = (Context) cls2.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, Color.alpha(0) + 35, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    g(48 - View.MeasureSpec.getSize(0), new int[]{-1895929895, -1120874547, 1829417622, 1431450780, 815834861, 113247796, 1078532767, -938460086, 143572315, -643655970, -1362538283, -256749568, 781602333, 1762826363, -2005888099, 323964209, -850403297, -1937502246, 967279525, 1547879290, -587031262, -1488738179, 1671217116, -161802708}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 64, new int[]{1086856292, 1636391421, -576415674, 1949011586, -2139805580, -946231125, -2025557618, -1154838889, -1305007582, 66889089, -1747427676, 746779196, 174649299, 442212095, -575210102, -1369842411, 1098942296, -1028024269, 1511084479, -504987560, -1359964366, -1875123750, -1496930311, 117394363, -1222741283, -580920930, 1757960319, 2134136922, 1782742553, -1971650749, -302325212, 1734233264}, objArr8);
                    String str2 = (String) objArr8[0];
                    try {
                        Object[] objArr9 = new Object[1];
                        h(scheduleImpl[32], (byte) (scheduleImpl[59] + 1), scheduleImpl[25], objArr9);
                        Class<?> cls4 = Class.forName((String) objArr9[0]);
                        Object[] objArr10 = new Object[1];
                        h(scheduleImpl[13], scheduleImpl[25], scheduleImpl[27], objArr10);
                        Object[] objArr11 = new Object[1];
                        g(((ApplicationInfo) cls4.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 31, new int[]{-990399775, 1118230585, -448550323, -1950446292, 637431102, 2103714091, 1915306765, 996675073, -2140453264, -291413378, -2101838403, 1151875635, 855211574, 1206133584, 158713683, -320666807, -189821760, 159153802, -427224018, 129098128, 1337478226, 608445622, -1127434895, 1820310994, 2070231803, -1555366528, 182616184, 48035321, -1577016579, 934386795, 365623392, 160261049}, objArr11);
                        String str3 = (String) objArr11[0];
                        try {
                            Object[] objArr12 = new Object[1];
                            h(scheduleImpl[32], (byte) (scheduleImpl[59] + 1), scheduleImpl[25], objArr12);
                            Class<?> cls5 = Class.forName((String) objArr12[0]);
                            Object[] objArr13 = new Object[1];
                            h(scheduleImpl[13], scheduleImpl[25], scheduleImpl[27], objArr13);
                            Object[] objArr14 = new Object[1];
                            g(((ApplicationInfo) cls5.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 27, new int[]{-1197536053, 1569706559, 1143783009, -154845508, -1880122415, -1397580376, -1286347472, 341033992, -1624121352, 1161130001, 1145751135, -1734472117, 72207592, -1943673127, -927067087, -1830369368, -592214090, 1732984303, -1443327357, 243979511, -1772195255, 1766020199, -1088080245, -985480405, -1368135731, -514192302, -1653586628, 759630677, -145358585, 290770613}, objArr14);
                            String str4 = (String) objArr14[0];
                            Object[] objArr15 = new Object[1];
                            g(Color.argb(0, 0, 0, 0) + 6, new int[]{356307203, 1190993794, 1218674175, -481819582}, objArr15);
                            try {
                                Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) View.resolveSize(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                } catch (Throwable th5) {
                    Throwable cause5 = th5.getCause();
                    if (cause5 == null) {
                        throw th5;
                    }
                    throw cause5;
                }
            }
        }
        try {
            Object[] objArr17 = new Object[1];
            h(scheduleImpl[25], scheduleImpl[31], (byte) (-scheduleImpl[30]), objArr17);
            Class<?> cls6 = Class.forName((String) objArr17[0]);
            Object[] objArr18 = new Object[1];
            h(scheduleImpl[7], (byte) (scheduleImpl[34] + 1), (byte) (-scheduleImpl[30]), objArr18);
            try {
                Object[] objArr19 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 495, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 5, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                    Object[] objArr20 = new Object[1];
                    j((byte) (-$$g[9]), (byte) (-$$g[8]), (byte) ($$g[47] - 1), objArr20);
                    obj3 = cls7.getMethod((String) objArr20[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                int i = ((int[]) objArr21[1])[0];
                if (((int[]) objArr21[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr22 = {-69010515, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr22);
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
                super.onCreate(bundle);
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

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(super.getResources().getString(R.string.intro_2_title).substring(1, 3).codePointAt(1) - 95, new int[]{2118472893, -1694235807, -1176400386, -1207181524, -405077323, 488091875, -362004419, -372834657, 1125874872, -1278785818, 99788670, 443254534, -2057019327, -613527806}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(18 - TextUtils.getOffsetAfter("", 0), new int[]{28089367, -1089870523, -2101524309, -304489052, 1732048100, 1379030169, -421548241, 2106185460, 373270999, 1702475799}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 35, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.getDeadChar(0, 0), 18 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(super.getResources().getString(R.string.join_invitation_text_create_family_account).substring(9, 10).codePointAt(0) - 6, new int[]{2118472893, -1694235807, -1176400386, -1207181524, -405077323, 488091875, -362004419, -372834657, 1125874872, -1278785818, 99788670, 443254534, -2057019327, -613527806}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(getPackageName().length() + 11, new int[]{28089367, -1089870523, -2101524309, -304489052, 1732048100, 1379030169, -421548241, 2106185460, 373270999, 1702475799}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myTid() >> 22), (Process.myTid() >> 22) + 35, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) View.resolveSize(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public TncServiceDialogActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.miniprogram.tnc.TncServiceDialogActivity$$ExternalSyntheticLambda2
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                TncServiceDialogActivity.$r8$lambda$OCe1PtOPGanGDP0rbhGI2TtHk0s(TncServiceDialogActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.PlaceComponentResult = registerForActivityResult;
    }

    @JvmName(name = "getUserConsentTracker")
    public final UserConsentTracker getUserConsentTracker() {
        UserConsentTracker userConsentTracker = this.userConsentTracker;
        if (userConsentTracker != null) {
            return userConsentTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setUserConsentTracker")
    public final void setUserConsentTracker(UserConsentTracker userConsentTracker) {
        Intrinsics.checkNotNullParameter(userConsentTracker, "");
        this.userConsentTracker = userConsentTracker;
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity
    public final void showIcon() {
        GlideRequests PlaceComponentResult = GlideApp.PlaceComponentResult(this);
        StartParams startParams = this.getAuthRequestContext;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams = null;
        }
        PlaceComponentResult.PlaceComponentResult(startParams.BuiltInFictitiousFunctionClassFactory).getErrorConfigVersion((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).PlaceComponentResult((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a09c7_call_errorhandler)));
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity
    public final void setupBehavior() {
        ((DanaButtonPrimaryView) _$_findCachedViewById(R.id.res_0x7f0a0128_networkuserentitydata_externalsyntheticlambda4)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.miniprogram.tnc.TncServiceDialogActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TncServiceDialogActivity.$r8$lambda$LIARYc7w6Ar0Rwodsp8Hmm3jujQ(TncServiceDialogActivity.this, view);
            }
        });
        ((DanaButtonGhostView) _$_findCachedViewById(R.id.getOnBoardingScenario_res_0x7f0a0149)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.miniprogram.tnc.TncServiceDialogActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TncServiceDialogActivity.m2673$r8$lambda$2_zB3tZNdq98CF9M0irNHuACM(TncServiceDialogActivity.this, view);
            }
        });
        StartParams startParams = this.getAuthRequestContext;
        StartParams startParams2 = null;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams = null;
        }
        if (Intrinsics.areEqual(startParams.MyBillsEntityDataFactory, "GET")) {
            ((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1050_linkedtreemap_linkedtreemapiterator)).setVisibility(8);
            ((AppCompatTextView) _$_findCachedViewById(R.id.getHeaderBackgroundColor)).setVisibility(0);
            AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.getHeaderBackgroundColor);
            StartParams startParams3 = this.getAuthRequestContext;
            if (startParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                startParams3 = null;
            }
            appCompatTextView.setText(HtmlCompat.PlaceComponentResult(String.valueOf(startParams3.KClassImpl$Data$declaredNonStaticMembers$2), 63));
        } else {
            ((AppCompatTextView) _$_findCachedViewById(R.id.getHeaderBackgroundColor)).setVisibility(8);
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1050_linkedtreemap_linkedtreemapiterator);
            recyclerView.setVisibility(0);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            StartParams startParams4 = this.getAuthRequestContext;
            if (startParams4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                startParams4 = null;
            }
            ArrayList<String> arrayList = startParams4.getAuthRequestContext;
            Intrinsics.checkNotNull(arrayList);
            recyclerView.setAdapter(new MiniProgramAgreementsAdapter(arrayList, 0, 0, 6, null));
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.getRelativeLeft);
        Object[] objArr = new Object[1];
        StartParams startParams5 = this.getAuthRequestContext;
        if (startParams5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            startParams2 = startParams5;
        }
        objArr[0] = startParams2.PlaceComponentResult;
        textView.setText(getString(R.string.text_title_content_tnc_service, objArr));
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity
    public final void onTncClicked() {
        StartParams startParams = this.getAuthRequestContext;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams = null;
        }
        String str = startParams.PlaceComponentResult;
        StartParams startParams2 = this.getAuthRequestContext;
        if (startParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams2 = null;
        }
        String str2 = startParams2.BuiltInFictitiousFunctionClassFactory;
        StartParams startParams3 = this.getAuthRequestContext;
        if (startParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams3 = null;
        }
        ArrayList<String> arrayList = startParams3.getAuthRequestContext;
        StartParams startParams4 = this.getAuthRequestContext;
        if (startParams4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams4 = null;
        }
        String str3 = startParams4.KClassImpl$Data$declaredNonStaticMembers$2;
        StartParams startParams5 = this.getAuthRequestContext;
        if (startParams5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams5 = null;
        }
        Intent putExtra = new Intent(this, TncDetailMiniProgramActivity.class).putExtra("startParams", new TncDetailMiniProgramActivity.StartParams(str, str2, arrayList, str3, startParams5.MyBillsEntityDataFactory));
        Intrinsics.checkNotNullExpressionValue(putExtra, "");
        this.PlaceComponentResult.MyBillsEntityDataFactory(putExtra, null);
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\u001c\b\u0002\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0017\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R%\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0017X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0011\u0010\u0013\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014"}, d2 = {"Lid/dana/miniprogram/tnc/TncServiceDialogActivity$StartParams;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "PlaceComponentResult", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAuthRequestContext", "Ljava/util/ArrayList;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final /* data */ class StartParams implements Parcelable {
        public static final Parcelable.Creator<StartParams> CREATOR = new Creator();

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;
        final ArrayList<String> getAuthRequestContext;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof StartParams) {
                StartParams startParams = (StartParams) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, startParams.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, startParams.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, startParams.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, startParams.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, startParams.MyBillsEntityDataFactory);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
            int hashCode2 = this.PlaceComponentResult.hashCode();
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int hashCode3 = str == null ? 0 : str.hashCode();
            ArrayList<String> arrayList = this.getAuthRequestContext;
            int hashCode4 = arrayList == null ? 0 : arrayList.hashCode();
            String str2 = this.MyBillsEntityDataFactory;
            return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StartParams(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
            p0.writeString(this.PlaceComponentResult);
            p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
            p0.writeStringList(this.getAuthRequestContext);
            p0.writeString(this.MyBillsEntityDataFactory);
        }

        public StartParams(String str, String str2, String str3, ArrayList<String> arrayList, String str4) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.PlaceComponentResult = str2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
            this.getAuthRequestContext = arrayList;
            this.MyBillsEntityDataFactory = str4;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes9.dex */
        public static final class Creator implements Parcelable.Creator<StartParams> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StartParams createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new StartParams(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StartParams[] newArray(int i) {
                return new StartParams[i];
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* renamed from: $r8$lambda$2_zB3tZN-dq98CF-9M0irNHuACM  reason: not valid java name */
    public static /* synthetic */ void m2673$r8$lambda$2_zB3tZNdq98CF9M0irNHuACM(TncServiceDialogActivity tncServiceDialogActivity, View view) {
        Intrinsics.checkNotNullParameter(tncServiceDialogActivity, "");
        UserConsentTracker userConsentTracker = tncServiceDialogActivity.getUserConsentTracker();
        StartParams startParams = tncServiceDialogActivity.getAuthRequestContext;
        ?? r2 = 0;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams = null;
        }
        UserConsentTracker.trackServiceUserConsent$default(userConsentTracker, startParams.PlaceComponentResult, false, 2, null);
        EventBus.getDefault().post(new ShowAgreementBridge.AgreementMessageEvent(false, r2, 2, r2));
        tncServiceDialogActivity.finish();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public static /* synthetic */ void $r8$lambda$LIARYc7w6Ar0Rwodsp8Hmm3jujQ(TncServiceDialogActivity tncServiceDialogActivity, View view) {
        Intrinsics.checkNotNullParameter(tncServiceDialogActivity, "");
        UserConsentTracker userConsentTracker = tncServiceDialogActivity.getUserConsentTracker();
        StartParams startParams = tncServiceDialogActivity.getAuthRequestContext;
        ?? r2 = 0;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams = null;
        }
        userConsentTracker.trackServiceUserConsent(startParams.PlaceComponentResult, true);
        EventBus.getDefault().post(new ShowAgreementBridge.AgreementMessageEvent(true, r2, 2, r2));
        tncServiceDialogActivity.finish();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public static /* synthetic */ void $r8$lambda$OCe1PtOPGanGDP0rbhGI2TtHk0s(TncServiceDialogActivity tncServiceDialogActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(tncServiceDialogActivity, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory == -1) {
            Intent intent = activityResult.MyBillsEntityDataFactory;
            ?? r3 = 0;
            EventBus.getDefault().post(new ShowAgreementBridge.AgreementMessageEvent(intent != null ? intent.getBooleanExtra("AGREE", false) : false, r3, 2, r3));
            tncServiceDialogActivity.finish();
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        ?? r2 = 0;
        EventBus.getDefault().post(new ShowAgreementBridge.AgreementMessageEvent(false, r2, 2, r2));
        super.onBackPressed();
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity
    public final void setupContent() {
        DaggerServiceAgreementComponent.Builder authRequestContext = DaggerServiceAgreementComponent.getAuthRequestContext();
        authRequestContext.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getAuthRequestContext, ApplicationComponent.class);
        new DaggerServiceAgreementComponent.ServiceAgreementComponentImpl(authRequestContext.getAuthRequestContext, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        Parcelable parcelableExtra = getIntent().getParcelableExtra("startParams");
        Intrinsics.checkNotNull(parcelableExtra);
        this.getAuthRequestContext = (StartParams) parcelableExtra;
        TextView textView = (TextView) _$_findCachedViewById(R.id.getRelativeLeft);
        Object[] objArr = new Object[1];
        StartParams startParams = this.getAuthRequestContext;
        StartParams startParams2 = null;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams = null;
        }
        objArr[0] = startParams.PlaceComponentResult;
        textView.setText(getString(R.string.text_title_content_tnc_mp, objArr));
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.getLogSourceName);
        StartParams startParams3 = this.getAuthRequestContext;
        if (startParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            startParams2 = startParams3;
        }
        textView2.setText(startParams2.PlaceComponentResult);
    }

    private static void g(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = initRecordTimeStamp;
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
        int[] iArr5 = initRecordTimeStamp;
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

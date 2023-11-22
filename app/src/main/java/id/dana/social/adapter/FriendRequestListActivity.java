package id.dana.social.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.component.customsnackbarcomponent.SnackbarPosition;
import id.dana.component.customsnackbarcomponent.SnackbarState;
import id.dana.databinding.ActivityFriendRequestListBinding;
import id.dana.feeds.ui.enums.FriendshipStatus;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.feeds.ui.tracker.FeedsErrorSource;
import id.dana.feeds.ui.tracker.FeedsSourceType;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.social.adapter.FriendRequestAdapter;
import id.dana.social.contract.FriendRequestContract;
import id.dana.social.di.module.FriendRequestListModule;
import id.dana.social.v2.view.FeedPullToRefreshView;
import id.dana.utils.SizeUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u00020\u000f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/social/adapter/FriendRequestListActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityFriendRequestListBinding;", "", "configToolbar", "()V", "PlaceComponentResult", IAPSyncCommand.COMMAND_INIT, "initViewBinding", "()Lid/dana/databinding/ActivityFriendRequestListBinding;", "onBackPressed", "Lid/dana/social/adapter/FriendRequestAdapter;", "lookAheadTest", "Lid/dana/social/adapter/FriendRequestAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "getFriendshipAnalyticTracker", "()Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "setFriendshipAnalyticTracker", "(Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;)V", "Lid/dana/social/contract/FriendRequestContract$Presenter;", "presenter", "Lid/dana/social/contract/FriendRequestContract$Presenter;", "getPresenter", "()Lid/dana/social/contract/FriendRequestContract$Presenter;", "setPresenter", "(Lid/dana/social/contract/FriendRequestContract$Presenter;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendRequestListActivity extends ViewBindingActivity<ActivityFriendRequestListBinding> {
    public static final String FRIEND_REQUEST_HAS_MORE_BUNDLE = "friend_request_has_more_bundle";
    public static final String FRIEND_REQUEST_LIST_BUNDLE = "friend_request_list_bundle";
    public static final String FRIEND_REQUEST_MIN_ID_BUNDLE = "friend_request_min_id_bundle";
    public static final int FRIEND_REQUEST_VIEW_ALL_REQ_CODE = 999;
    private static int[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private FriendRequestAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public FriendRequestContract.Presenter presenter;
    public static final byte[] $$a = {45, -61, Ascii.ETB, 105, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 54;
    public static final byte[] PlaceComponentResult = {14, -73, -90, 103, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 245;

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        NetworkUserEntityData$$ExternalSyntheticLambda0 = new int[]{1752045428, 582113894, 231893886, -511362735, -121782509, 298130212, -792278954, -2078501089, 2113545091, -431864858, 1676095522, -1417888815, -1737884731, 128177399, 1249195631, 1095246817, -2019133476, -1177336529};
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.social.adapter.FriendRequestListActivity.PlaceComponentResult
            int r7 = 23 - r7
            int r9 = r9 + 4
            int r8 = r8 + 97
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L16:
            r3 = 0
        L17:
            int r9 = r9 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r9]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L34:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-4)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.adapter.FriendRequestListActivity.b(int, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r7 = r7 + 4
            int r6 = r6 * 2
            int r6 = 103 - r6
            byte[] r0 = id.dana.social.adapter.FriendRequestListActivity.$$a
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L36
        L1a:
            r3 = 0
        L1b:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + (-7)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.adapter.FriendRequestListActivity.c(byte, short, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(MotionEvent.axisFromString("") + 19, new int[]{601636510, -1229953888, 880931730, -719176653, -1430253277, 1319828567, -700638597, 1442700081, -65264286, 2029207346}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(Color.alpha(0) + 5, new int[]{1594084326, -261367178, -524883214, 830074478}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.alpha(0), 35 - ExpandableListView.getPackedPositionType(0L), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(48 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new int[]{1555050739, 768369792, -1103229869, 419319021, 891581310, -890020697, 22599531, 617072665, 1267125568, -1510304710, 698251197, -742910115, 239891900, 1092023313, -335303922, -1104387643, -304395482, -802002301, 1036610744, -989501403, -1295858626, -1822163135, 300745876, -1889410052}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(TextUtils.indexOf("", "") + 64, new int[]{961267065, -1418706143, 479094809, 1282825592, -457462583, -2139761066, -1008830273, 549361911, 192402607, -238711751, 653888954, -947634402, 682351967, 975232832, -1935168894, -510917532, 1057107960, -1668553716, -1696963435, 1360572608, -2048213657, 1083075144, 623380080, -1575683675, -1324683629, -1214077879, 790247438, -347093052, -1991952045, 1978109491, 330679926, -56902464}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 64, new int[]{-167190102, 225525911, 1410598571, 844398346, -927312021, -1883097913, -1311158820, 1237024930, 924216835, 1220237857, -1707941051, -964327005, 1599330246, 335298322, 285364771, 1478760609, 1756817657, -1906385290, -1399477257, -1190191540, -1066938673, 1971664231, 1254717888, -350618290, -595453198, 1147823055, -1312323320, 579465279, -1283449086, 1403787814, -787579936, -253397330}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(60 - TextUtils.getTrimmedLength(""), new int[]{-1737480849, 1745411451, 817795848, -1475754626, 1137907269, 511949995, -360874498, -1668811969, -1078906682, -188659151, 985244980, 2047654745, -1659950882, -1456707749, -526932900, -1323114992, 1799622692, 1604104455, -1434404316, 1718305144, 1742949834, -1858838475, -485514219, -348840121, -966315814, 1528099373, 236781744, 845289747, -1625984279, -1563878749}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((ViewConfiguration.getTapTimeout() >> 16) + 6, new int[]{587827104, 1102880592, -1905511220, -677587791}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 911, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr13 = {this};
                byte b = PlaceComponentResult[30];
                byte b2 = (byte) (-PlaceComponentResult[32]);
                Object[] objArr14 = new Object[1];
                b(b, b2, (byte) (b2 << 2), objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                byte b3 = PlaceComponentResult[30];
                Object[] objArr15 = new Object[1];
                b(b3, (byte) (b3 + 1), (byte) (getAuthRequestContext & 31), objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 55, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 3, (char) (ViewConfiguration.getFadingEdgeLength() >> 16));
                        Object[] objArr17 = new Object[1];
                        c((byte) (-$$a[12]), $$a[78], $$a[68], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 800, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 14, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 15 - ExpandableListView.getPackedPositionType(0L), (char) TextUtils.indexOf("", "", 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 814, 28 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (TextUtils.getOffsetBefore("", 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 800, 15 - Color.green(0), (char) (ViewConfiguration.getTouchSlop() >> 8)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {-1891003173, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 911, 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr19);
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
                Object[] objArr20 = {this};
                byte b4 = PlaceComponentResult[30];
                byte b5 = (byte) (-PlaceComponentResult[32]);
                Object[] objArr21 = new Object[1];
                b(b4, b5, (byte) (b5 << 2), objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                byte b6 = PlaceComponentResult[30];
                Object[] objArr22 = new Object[1];
                b(b6, (byte) (b6 + 1), (byte) (getAuthRequestContext & 31), objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(60 - TextUtils.indexOf((CharSequence) "", '0', 0), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 45, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                        Object[] objArr24 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[28]), (byte) (-$$a[8]), objArr24);
                        obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                    int i = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 34 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr26 = {-1891003173, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 911, TextUtils.indexOf("", "") + 18, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr26);
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
                Object[] objArr27 = {this};
                byte b7 = PlaceComponentResult[30];
                byte b8 = (byte) (-PlaceComponentResult[32]);
                Object[] objArr28 = new Object[1];
                b(b7, b8, (byte) (b8 << 2), objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                byte b9 = PlaceComponentResult[30];
                Object[] objArr29 = new Object[1];
                b(b9, (byte) (b9 + 1), (byte) (getAuthRequestContext & 31), objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(117 - TextUtils.indexOf((CharSequence) "", '0'), 3 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (TextUtils.indexOf("", "") + 38968));
                        Object[] objArr31 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[28]), (byte) (-$$a[8]), objArr31);
                        obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                    int i2 = ((int[]) objArr32[1])[0];
                    if (((int[]) objArr32[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ((byte) KeyEvent.getModifierMetaStateMask()), 35 - ExpandableListView.getPackedPositionGroup(0L), (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {-1891003173, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + 911, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr33);
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
                Object[] objArr34 = {this};
                byte b10 = PlaceComponentResult[30];
                byte b11 = (byte) (-PlaceComponentResult[32]);
                Object[] objArr35 = new Object[1];
                b(b10, b11, (byte) (b11 << 2), objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                byte b12 = PlaceComponentResult[30];
                Object[] objArr36 = new Object[1];
                b(b12, (byte) (b12 + 1), (byte) (getAuthRequestContext & 31), objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 107, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 2, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr38 = new Object[1];
                        c((byte) (-$$a[9]), $$a[40], (byte) ($$a[47] - 1), objArr38);
                        obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                    int i3 = ((int[]) objArr39[1])[0];
                    if (((int[]) objArr39[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) ((-1) - Process.getGidForName("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr40 = {-1891003173, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 911, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) View.combineMeasuredStates(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr40);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(super.getResources().getString(R.string.monday).substring(2, 3).length() + 17, new int[]{601636510, -1229953888, 880931730, -719176653, -1430253277, 1319828567, -700638597, 1442700081, -65264286, 2029207346}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(super.getResources().getString(R.string.qrcode_guide).substring(7, 8).codePointAt(0) - 27, new int[]{1594084326, -261367178, -524883214, 830074478}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(getPackageName().length() + 19, new int[]{601636510, -1229953888, 880931730, -719176653, 662770327, -707522963, 1867572707, -1657353036, -673428855, 1797009813, -1691859241, -1910086358, -1520309662, -181312690}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(super.getResources().getString(R.string.zdoc_user_cancel_msg).substring(0, 1).length() + 17, new int[]{-1391126947, -1346864768, -180795391, 133645209, 1367733360, -1437830981, -2010500349, 1342821456, -689387043, -880147063}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getFadingEdgeLength() >> 16), 35 - View.resolveSize(0, 0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(48 - KeyEvent.keyCodeFromString(""), new int[]{1555050739, 768369792, -1103229869, 419319021, 891581310, -890020697, 22599531, 617072665, 1267125568, -1510304710, 698251197, -742910115, 239891900, 1092023313, -335303922, -1104387643, -304395482, -802002301, 1036610744, -989501403, -1295858626, -1822163135, 300745876, -1889410052}, objArr6);
                    String str = (String) objArr6[0];
                    try {
                        byte b = PlaceComponentResult[25];
                        Object[] objArr7 = new Object[1];
                        b(b, b, PlaceComponentResult[7], objArr7);
                        Class<?> cls3 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        b(PlaceComponentResult[41], PlaceComponentResult[5], (byte) (-PlaceComponentResult[59]), objArr8);
                        Object[] objArr9 = new Object[1];
                        a(((ApplicationInfo) cls3.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 31, new int[]{961267065, -1418706143, 479094809, 1282825592, -457462583, -2139761066, -1008830273, 549361911, 192402607, -238711751, 653888954, -947634402, 682351967, 975232832, -1935168894, -510917532, 1057107960, -1668553716, -1696963435, 1360572608, -2048213657, 1083075144, 623380080, -1575683675, -1324683629, -1214077879, 790247438, -347093052, -1991952045, 1978109491, 330679926, -56902464}, objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(getPackageName().length() + 57, new int[]{-167190102, 225525911, 1410598571, 844398346, -927312021, -1883097913, -1311158820, 1237024930, 924216835, 1220237857, -1707941051, -964327005, 1599330246, 335298322, 285364771, 1478760609, 1756817657, -1906385290, -1399477257, -1190191540, -1066938673, 1971664231, 1254717888, -350618290, -595453198, 1147823055, -1312323320, 579465279, -1283449086, 1403787814, -787579936, -253397330}, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(super.getResources().getString(R.string.msg_save_services_fail).substring(37, 39).codePointAt(0) + 14, new int[]{-1737480849, 1745411451, 817795848, -1475754626, 1137907269, 511949995, -360874498, -1668811969, -1078906682, -188659151, 985244980, 2047654745, -1659950882, -1456707749, -526932900, -1323114992, 1799622692, 1604104455, -1434404316, 1718305144, 1742949834, -1858838475, -485514219, -348840121, -966315814, 1528099373, 236781744, 845289747, -1625984279, -1563878749}, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(super.getResources().getString(R.string.sendmoney_minimum_amount).substring(0, 24).codePointAt(16) - 104, new int[]{587827104, 1102880592, -1905511220, -677587791}, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr13);
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
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            }
        }
        try {
            byte b2 = PlaceComponentResult[30];
            byte b3 = (byte) (-PlaceComponentResult[32]);
            Object[] objArr14 = new Object[1];
            b(b2, b3, (byte) (b3 << 2), objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            byte b4 = PlaceComponentResult[30];
            Object[] objArr15 = new Object[1];
            b(b4, (byte) (b4 + 1), (byte) (getAuthRequestContext & 31), objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 4, (char) (ViewConfiguration.getTapTimeout() >> 16));
                    Object[] objArr17 = new Object[1];
                    c((byte) (-$$a[9]), $$a[40], (byte) ($$a[47] - 1), objArr17);
                    obj3 = cls5.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0', 0) + 36, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr19 = {2143809968, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), Color.rgb(0, 0, 0) + 16777234, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
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
                super.onCreate(bundle);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().codePointAt(0) - 79, new int[]{601636510, -1229953888, 880931730, -719176653, 662770327, -707522963, 1867572707, -1657353036, -673428855, 1797009813, -1691859241, -1910086358, -1520309662, -181312690}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((ViewConfiguration.getFadingEdgeLength() >> 16) + 18, new int[]{-1391126947, -1346864768, -180795391, 133645209, 1367733360, -1437830981, -2010500349, 1342821456, -689387043, -880147063}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 930, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 35, (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = PlaceComponentResult[25];
                Object[] objArr = new Object[1];
                b(b, b, PlaceComponentResult[7], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b(PlaceComponentResult[41], PlaceComponentResult[5], (byte) (-PlaceComponentResult[59]), new Object[1]);
                Object[] objArr2 = new Object[1];
                a(((ApplicationInfo) cls.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 7, new int[]{601636510, -1229953888, 880931730, -719176653, 662770327, -707522963, 1867572707, -1657353036, -673428855, 1797009813, -1691859241, -1910086358, -1520309662, -181312690}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a(getPackageName().length() + 11, new int[]{-1391126947, -1346864768, -180795391, 133645209, 1367733360, -1437830981, -2010500349, 1342821456, -689387043, -880147063}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 930, 35 - View.resolveSize(0, 0), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetAfter("", 0), TextUtils.indexOf("", "", 0, 0) + 18, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getPresenter")
    public final FriendRequestContract.Presenter getPresenter() {
        FriendRequestContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(FriendRequestContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getFriendshipAnalyticTracker")
    public final FriendshipAnalyticTracker getFriendshipAnalyticTracker() {
        FriendshipAnalyticTracker friendshipAnalyticTracker = this.friendshipAnalyticTracker;
        if (friendshipAnalyticTracker != null) {
            return friendshipAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFriendshipAnalyticTracker")
    public final void setFriendshipAnalyticTracker(FriendshipAnalyticTracker friendshipAnalyticTracker) {
        Intrinsics.checkNotNullParameter(friendshipAnalyticTracker, "");
        this.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityFriendRequestListBinding initViewBinding() {
        ActivityFriendRequestListBinding PlaceComponentResult2 = ActivityFriendRequestListBinding.PlaceComponentResult(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        return PlaceComponentResult2;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        super.configToolbar();
        setCenterTitle(getString(R.string.friend_request_section_title));
        setMenuLeftButton(R.drawable.ic_close_white);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult() {
        RecyclerView recyclerView = getBinding().scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        recyclerView.setVisibility(0);
        Group group = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(group, "");
        group.setVisibility(8);
        FriendRequestAdapter friendRequestAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (friendRequestAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendRequestAdapter = null;
        }
        friendRequestAdapter.MyBillsEntityDataFactory(6, false);
        getPresenter().getAuthRequestContext(10);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        FriendRequestAdapter friendRequestAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (friendRequestAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendRequestAdapter = null;
        }
        List<FriendModel> items = friendRequestAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            if (((FriendModel) obj).initRecordTimeStamp == 0) {
                arrayList.add(obj);
            }
        }
        List take = CollectionsKt.take(arrayList, 10);
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra(FRIEND_REQUEST_LIST_BUNDLE, new ArrayList<>(take));
        intent.putExtra(FRIEND_REQUEST_HAS_MORE_BUNDLE, getPresenter().getScheduleImpl());
        setResult(-1, intent);
        finish();
    }

    public static /* synthetic */ void $r8$lambda$C5klMbP_6bNgLoPLb4pGaSqj8No(FriendRequestListActivity friendRequestListActivity, View view) {
        Intrinsics.checkNotNullParameter(friendRequestListActivity, "");
        friendRequestListActivity.getPresenter().PlaceComponentResult();
        friendRequestListActivity.PlaceComponentResult();
    }

    public static final /* synthetic */ void access$showSuccessToast(FriendRequestListActivity friendRequestListActivity, String str) {
        ConstraintLayout constraintLayout = friendRequestListActivity.getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        CustomSnackbar.Builder MyBillsEntityDataFactory = new CustomSnackbar.Builder(constraintLayout).MyBillsEntityDataFactory(SnackbarState.SUCCESS);
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_success;
        MyBillsEntityDataFactory.moveToNextValue = 1000;
        MyBillsEntityDataFactory.initRecordTimeStamp = friendRequestListActivity.getString(R.string.approve_friend_request_success_message, str);
        SnackbarPosition snackbarPosition = SnackbarPosition.TOP;
        Intrinsics.checkNotNullParameter(snackbarPosition, "");
        MyBillsEntityDataFactory.GetContactSyncConfig = snackbarPosition;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = SizeUtil.getAuthRequestContext(2);
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory().show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [id.dana.social.adapter.FriendRequestAdapter$FriendRequestSectionFontType, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [id.dana.base.BaseRecyclerViewAdapter] */
    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        ArrayList arrayList;
        ?? r3 = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new FriendRequestAdapter(r3, new FriendRequestAdapter.FriendRequestListener() { // from class: id.dana.social.adapter.FriendRequestListActivity$setupRecyclerView$1
            @Override // id.dana.social.adapter.FriendRequestAdapter.FriendRequestListener
            public final void PlaceComponentResult() {
            }

            @Override // id.dana.social.adapter.FriendRequestAdapter.FriendRequestListener
            public final void BuiltInFictitiousFunctionClassFactory(FriendModel p0) {
                FriendRequestAdapter friendRequestAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                friendRequestAdapter = FriendRequestListActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (friendRequestAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendRequestAdapter = null;
                }
                friendRequestAdapter.getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PROCESSING);
                FriendRequestListActivity.this.getPresenter().BuiltInFictitiousFunctionClassFactory(p0);
            }

            @Override // id.dana.social.adapter.FriendRequestAdapter.FriendRequestListener
            public final void getAuthRequestContext(FriendModel p0) {
                FriendRequestAdapter friendRequestAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                friendRequestAdapter = FriendRequestListActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (friendRequestAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendRequestAdapter = null;
                }
                friendRequestAdapter.getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PROCESSING);
                FriendRequestListActivity.this.getPresenter().getAuthRequestContext(p0);
            }
        }, 1, r3);
        final RecyclerView recyclerView = getBinding().scheduleImpl;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        FriendRequestAdapter friendRequestAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (friendRequestAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendRequestAdapter = null;
        }
        recyclerView.setAdapter(friendRequestAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.social.adapter.FriendRequestListActivity$setupRecyclerView$2$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView p0, int p1, int p2) {
                ActivityFriendRequestListBinding binding;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onScrolled(p0, p1, p2);
                binding = FriendRequestListActivity.this.getBinding();
                FeedPullToRefreshView feedPullToRefreshView = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                }
                feedPullToRefreshView.setEnabled(((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrollStateChanged(RecyclerView p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                RecyclerView.LayoutManager layoutManager = p0.getLayoutManager();
                if (layoutManager == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                RecyclerView.Adapter adapter = p0.getAdapter();
                if (p0.canScrollVertically(130) || adapter == null || linearLayoutManager.findLastCompletelyVisibleItemPosition() < adapter.getItemCount() - 1) {
                    return;
                }
                FriendRequestListActivity.this.getPresenter().getAuthRequestContext(10);
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.FriendRequestListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendRequestListActivity.$r8$lambda$C5klMbP_6bNgLoPLb4pGaSqj8No(FriendRequestListActivity.this, view);
            }
        });
        FeedPullToRefreshView feedPullToRefreshView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "");
        feedPullToRefreshView.initPullToRefreshView(layoutInflater, new Function0<Unit>() { // from class: id.dana.social.adapter.FriendRequestListActivity$initPullToRefresh$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FriendRequestListActivity.this.getPresenter().PlaceComponentResult();
                FriendRequestListActivity.this.PlaceComponentResult();
            }
        });
        getDanaApplication().getSocialCommonComponent().BuiltInFictitiousFunctionClassFactory(new FriendRequestListModule(new FriendRequestContract.View() { // from class: id.dana.social.adapter.FriendRequestListActivity$initComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final String getErrorSource() {
                return FeedsErrorSource.FRIEND_REQUEST;
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.social.contract.FriendRequestContract.View
            public final void PlaceComponentResult(List<FriendModel> p0, boolean p1) {
                ActivityFriendRequestListBinding binding;
                ActivityFriendRequestListBinding binding2;
                ActivityFriendRequestListBinding binding3;
                FriendRequestAdapter friendRequestAdapter2;
                FriendRequestAdapter friendRequestAdapter3;
                FriendRequestAdapter friendRequestAdapter4;
                Intrinsics.checkNotNullParameter(p0, "");
                binding = FriendRequestListActivity.this.getBinding();
                binding.NetworkUserEntityData$$ExternalSyntheticLambda0.setDoneRefreshing(true);
                binding2 = FriendRequestListActivity.this.getBinding();
                RecyclerView recyclerView2 = binding2.scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "");
                recyclerView2.setVisibility(0);
                binding3 = FriendRequestListActivity.this.getBinding();
                Group group = binding3.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(group, "");
                group.setVisibility(8);
                if (!p0.isEmpty()) {
                    friendRequestAdapter2 = FriendRequestListActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    FriendRequestAdapter friendRequestAdapter5 = null;
                    if (friendRequestAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendRequestAdapter2 = null;
                    }
                    if (friendRequestAdapter2.BuiltInFictitiousFunctionClassFactory() || p1) {
                        friendRequestAdapter3 = FriendRequestListActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (friendRequestAdapter3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            friendRequestAdapter5 = friendRequestAdapter3;
                        }
                        friendRequestAdapter5.setItems(p0);
                        return;
                    }
                    friendRequestAdapter4 = FriendRequestListActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (friendRequestAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        friendRequestAdapter5 = friendRequestAdapter4;
                    }
                    friendRequestAdapter5.appendItems(p0);
                    return;
                }
                FriendRequestListActivity.this.setResult(-1);
                FriendRequestListActivity.this.finish();
            }

            @Override // id.dana.social.contract.FriendRequestContract.View
            public final void getAuthRequestContext() {
                ActivityFriendRequestListBinding binding;
                ActivityFriendRequestListBinding binding2;
                ActivityFriendRequestListBinding binding3;
                binding = FriendRequestListActivity.this.getBinding();
                binding.NetworkUserEntityData$$ExternalSyntheticLambda0.setDoneRefreshing(true);
                binding2 = FriendRequestListActivity.this.getBinding();
                RecyclerView recyclerView2 = binding2.scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "");
                recyclerView2.setVisibility(8);
                binding3 = FriendRequestListActivity.this.getBinding();
                Group group = binding3.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(group, "");
                group.setVisibility(0);
            }

            @Override // id.dana.social.contract.FriendRequestContract.View
            public final void MyBillsEntityDataFactory(FriendModel p0) {
                FriendRequestAdapter friendRequestAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                friendRequestAdapter2 = FriendRequestListActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (friendRequestAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendRequestAdapter2 = null;
                }
                friendRequestAdapter2.removeItemEquals(p0);
                FriendRequestListActivity.access$showSuccessToast(FriendRequestListActivity.this, p0.lookAheadTest);
                FriendRequestListActivity.this.getPresenter().BuiltInFictitiousFunctionClassFactory();
                FriendRequestListActivity.this.getFriendshipAnalyticTracker().PlaceComponentResult(FeedsSourceType.FRIEND_REQUEST_PAGE);
            }

            @Override // id.dana.social.contract.FriendRequestContract.View
            public final void getAuthRequestContext(FriendModel p0) {
                FriendRequestAdapter friendRequestAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                friendRequestAdapter2 = FriendRequestListActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (friendRequestAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendRequestAdapter2 = null;
                }
                friendRequestAdapter2.getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PENDING);
            }

            @Override // id.dana.social.contract.FriendRequestContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(FriendModel p0) {
                FriendRequestAdapter friendRequestAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                friendRequestAdapter2 = FriendRequestListActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (friendRequestAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendRequestAdapter2 = null;
                }
                friendRequestAdapter2.removeItemEquals(p0);
                FriendRequestListActivity.this.getPresenter().BuiltInFictitiousFunctionClassFactory();
                FriendRequestListActivity.this.getFriendshipAnalyticTracker().getAuthRequestContext(FeedsSourceType.FRIEND_REQUEST_PAGE);
            }

            @Override // id.dana.social.contract.FriendRequestContract.View
            public final void PlaceComponentResult(FriendModel p0) {
                FriendRequestAdapter friendRequestAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                friendRequestAdapter2 = FriendRequestListActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (friendRequestAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendRequestAdapter2 = null;
                }
                friendRequestAdapter2.getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PENDING);
            }

            @Override // id.dana.social.contract.FriendRequestContract.View
            public final void MyBillsEntityDataFactory(Throwable p0, String p1, String p2) {
                ActivityFriendRequestListBinding binding;
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                FriendshipAnalyticTracker friendshipAnalyticTracker = FriendRequestListActivity.this.getFriendshipAnalyticTracker();
                binding = FriendRequestListActivity.this.getBinding();
                friendshipAnalyticTracker.MyBillsEntityDataFactory(p0, p1, binding.moveToNextValue.getText().toString(), p2);
            }
        })).PlaceComponentResult(this);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(FRIEND_REQUEST_LIST_BUNDLE);
        if (parcelableArrayListExtra != null) {
            arrayList = parcelableArrayListExtra;
        } else {
            arrayList = CollectionsKt.emptyList();
        }
        boolean booleanExtra = getIntent().getBooleanExtra(FRIEND_REQUEST_HAS_MORE_BUNDLE, false);
        String stringExtra = getIntent().getStringExtra(FRIEND_REQUEST_MIN_ID_BUNDLE);
        if (stringExtra == null) {
            stringExtra = "";
        }
        if ((!arrayList.isEmpty()) != false) {
            if ((stringExtra.length() <= 0 ? 0 : 1) != 0) {
                getPresenter().getAuthRequestContext(booleanExtra);
                getPresenter().BuiltInFictitiousFunctionClassFactory(stringExtra);
                FriendRequestAdapter friendRequestAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (friendRequestAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    r3 = friendRequestAdapter2;
                }
                r3.setItems(arrayList);
                return;
            }
        }
        PlaceComponentResult();
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = NetworkUserEntityData$$ExternalSyntheticLambda0;
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
        int[] iArr5 = NetworkUserEntityData$$ExternalSyntheticLambda0;
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

package id.dana.promoquest.activity;

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
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.tabs.TabLayout;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.contract.promoquest.mission.MissionListContract;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerPromoQuestComponent;
import id.dana.di.modules.PromoQuestModule;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.promoquest.adapter.TabAdapter;
import id.dana.promoquest.fragment.MissionListFragment;
import id.dana.promoquest.model.MissionModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0007¢\u0006\u0004\b1\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u0019\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001c\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u001e\u0010\u0018J\u001d\u0010\u001f\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016¢\u0006\u0004\b\u001f\u0010\u001dJ\r\u0010 \u001a\u00020\u0003¢\u0006\u0004\b \u0010\u0005J\u0017\u0010\"\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\"\u0010\u0018J\u000f\u0010#\u001a\u00020\u0003H\u0016¢\u0006\u0004\b#\u0010\u0005J\u000f\u0010$\u001a\u00020\u0003H\u0016¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010%\u001a\u00020\u0003H\u0016¢\u0006\u0004\b%\u0010\u0005R\"\u0010-\u001a\u00020&8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u00100"}, d2 = {"Lid/dana/promoquest/activity/MissionListActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/contract/promoquest/mission/MissionListContract$View;", "", "closeToHome", "()V", "dismissProgress", "dismisssActiveMissionProgress", "dismisssPastMissionProgress", "", "p0", "Lid/dana/promoquest/fragment/MissionListFragment;", "getAuthRequestContext", "(Ljava/lang/String;)Lid/dana/promoquest/fragment/MissionListFragment;", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "errorMessage", "onFetchActiveMissionFailed", "(Ljava/lang/String;)V", "", "Lid/dana/promoquest/model/MissionModel;", "missionModels", "onFetchActiveMissionSucceeded", "(Ljava/util/List;)V", "onFetchPastMissionFailed", "onFetchPastMissionSucceeded", "reloadBothMissions", "keyFragment", "reloadMissions", "showActiveMissionProgress", "showPastMissionProgress", "showProgress", "", "getErrorConfigVersion", "Z", "getMixpanelEventTracked", "()Z", "setMixpanelEventTracked", "(Z)V", "mixpanelEventTracked", "Lid/dana/contract/promoquest/mission/MissionListContract$Presenter;", "presenter", "Lid/dana/contract/promoquest/mission/MissionListContract$Presenter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MissionListActivity extends BaseActivity implements MissionListContract.View {
    public static final String ACTIVE_MISSIONS_KEY = "activeMissions";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
    public static final String PAST_MISSIONS_KEY = "pastMissions";
    private static int lookAheadTest;
    private static char[] scheduleImpl;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean mixpanelEventTracked;
    @Inject
    public MissionListContract.Presenter presenter;
    public static final byte[] $$a = {125, -100, 71, Ascii.FS, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 147;
    public static final byte[] getAuthRequestContext = {Ascii.ETB, -59, 18, 83, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = WSContextConstant.HANDSHAKE_RECEIVE_SIZE;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        scheduleImpl = new char[]{39771, 39756, 39766, 39752, 39757, 39763, 39692, 39753, 39786, 39769, 39767, 39759, 39747, 39783, 39754, 39803, 39750, 39748, 39782, 39762, 39751, 39758, 39685, 39684, 39682, 39690, 39683, 39764, 39688, 39691, 39689, 39686, 39768, 39687, 39680, 39693, 39765, 39755};
        NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        lookAheadTest = 909155130;
    }

    private static void b(int i, short s, byte b, Object[] objArr) {
        byte[] bArr = getAuthRequestContext;
        int i2 = b + 97;
        int i3 = 55 - i;
        int i4 = s + 16;
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i2 = (i2 + (-i6)) - 4;
            i6 = i6;
        }
        while (true) {
            int i7 = i5 + 1;
            i3++;
            bArr2[i7] = (byte) i2;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b2 = bArr[i3];
            int i8 = i2;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
            i2 = (i8 + (-b2)) - 4;
            i6 = i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = 42 - r6
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r0 = id.dana.promoquest.activity.MissionListActivity.$$a
            int r8 = r8 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            int r8 = r8 + 1
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
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promoquest.activity.MissionListActivity.c(byte, int, byte, java.lang.Object[]):void");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(null, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 127, new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(null, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 128, new byte[]{-125, -122, -114, -115, -116}, null, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.getDeadChar(0, 0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(null, TextUtils.getOffsetAfter("", 0) + 127, new byte[]{-117, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -117, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -117, -100, -118, -117, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(null, 127 - TextUtils.getOffsetAfter("", 0), new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -117, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -117, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(null, 127 - Gravity.getAbsoluteGravity(0, 0), new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -117, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -117, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -117, -98, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(null, 127 - (ViewConfiguration.getScrollBarSize() >> 8), new byte[]{-120, -111, -126, -117, -110, -117, -92, -99, -110, -92, -111, -120, -117, -91, -126, -122, -92, -122, -113, -127, -92, -116, -123, -118, -121, -117, -124, -127, -107, -90, -120, -125, -124, -127, -107, -91, -121, -111, -120, -127, -118, -111, -127, -117, -124, -108, -111, -121, -127, -126, -127, -125, -92, -92, -93, -120, -113, -111, -111, -108}, null, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(null, View.MeasureSpec.getMode(0) + 127, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, (-16777198) - Color.rgb(0, 0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = getAuthRequestContext[25];
                Object[] objArr14 = new Object[1];
                b(30, b, (byte) (b | 8), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - Color.green(0), 3 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr16 = new Object[1];
                        c($$a[31], $$a[78], $$a[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 15 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 800, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 15, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 815, AndroidCharacter.getMirror('0') - 19, (char) (KeyEvent.keyCodeFromString("") + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 800, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 15, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r6 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 35 - Color.green(0), (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1701109492, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, Color.red(0) + 18, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr20 = new Object[1];
                b(30, b2, (byte) (b2 | 8), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 60, 45 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) TextUtils.getTrimmedLength(""));
                        Object[] objArr22 = new Object[1];
                        c($$a[8], $$a[9], $$a[28], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 930, TextUtils.indexOf("", "", 0, 0) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1701109492, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 911, Color.blue(0) + 18, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b3 = getAuthRequestContext[25];
                Object[] objArr26 = new Object[1];
                b(30, b3, (byte) (b3 | 8), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - Color.alpha(0), 3 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (38967 - MotionEvent.axisFromString("")));
                        Object[] objArr28 = new Object[1];
                        c($$a[8], $$a[9], $$a[28], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), 35 - Color.red(0), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1701109492, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 18 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) View.MeasureSpec.getSize(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b4 = getAuthRequestContext[25];
                Object[] objArr32 = new Object[1];
                b(30, b4, (byte) (b4 | 8), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 107, ExpandableListView.getPackedPositionChild(0L) + 4, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                        byte b5 = (byte) ($$a[78] - 1);
                        Object[] objArr34 = new Object[1];
                        c(b5, b5, (byte) (-$$a[40]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getWindowTouchSlop() >> 8), TextUtils.getOffsetBefore("", 0) + 35, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1701109492, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSizeAndState(0, 0, 0), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19, (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_promo_quest;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(null, 127 - View.combineMeasuredStates(0, 0), new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, 128 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, Color.rgb(0, 0, 0) + 16777251, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
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
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(null, getPackageName().length() + 120, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, 127 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0), KeyEvent.keyCodeFromString("") + 35, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 911, 18 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ((-1) - Process.getGidForName("")))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getMixpanelEventTracked")
    public final boolean getMixpanelEventTracked() {
        return this.mixpanelEventTracked;
    }

    @JvmName(name = "setMixpanelEventTracked")
    public final void setMixpanelEventTracked(boolean z) {
        this.mixpanelEventTracked = z;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        MissionListContract.Presenter presenter;
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(null, getPackageName().length() + 120, new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(null, 127 - Color.blue(0), new byte[]{-125, -122, -114, -115, -116}, null, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr4 = new Object[1];
                    b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[30], getAuthRequestContext[25], objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    b(getAuthRequestContext[25], getAuthRequestContext[8], getAuthRequestContext[5], objArr5);
                    Object[] objArr6 = new Object[1];
                    a(null, ((ApplicationInfo) cls2.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    a(null, super.getResources().getString(R.string.send_or_request_money_here).substring(15, 16).codePointAt(0) + 95, new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr7);
                    baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr8 = new Object[1];
                    a(null, getPackageName().codePointAt(3) + 27, new byte[]{-117, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -117, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -117, -100, -118, -117, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr8);
                    String str = (String) objArr8[0];
                    try {
                        Object[] objArr9 = new Object[1];
                        b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[30], getAuthRequestContext[25], objArr9);
                        Class<?> cls4 = Class.forName((String) objArr9[0]);
                        Object[] objArr10 = new Object[1];
                        b(getAuthRequestContext[25], getAuthRequestContext[8], getAuthRequestContext[5], objArr10);
                        Object[] objArr11 = new Object[1];
                        a(null, ((ApplicationInfo) cls4.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -117, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -117, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr11);
                        String str2 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(null, super.getResources().getString(R.string.balance_menu_title).substring(14, 15).codePointAt(0) + 12, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -117, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -117, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -117, -98, -99}, null, objArr12);
                        String str3 = (String) objArr12[0];
                        try {
                            Object[] objArr13 = new Object[1];
                            b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[30], getAuthRequestContext[25], objArr13);
                            Class<?> cls5 = Class.forName((String) objArr13[0]);
                            Object[] objArr14 = new Object[1];
                            b(getAuthRequestContext[25], getAuthRequestContext[8], getAuthRequestContext[5], objArr14);
                            Object[] objArr15 = new Object[1];
                            a(null, ((ApplicationInfo) cls5.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-120, -111, -126, -117, -110, -117, -92, -99, -110, -92, -111, -120, -117, -91, -126, -122, -92, -122, -113, -127, -92, -116, -123, -118, -121, -117, -124, -127, -107, -90, -120, -125, -124, -127, -107, -91, -121, -111, -120, -127, -118, -111, -127, -117, -124, -108, -111, -121, -127, -126, -127, -125, -92, -92, -93, -120, -113, -111, -111, -108}, null, objArr15);
                            String str4 = (String) objArr15[0];
                            try {
                                Object[] objArr16 = new Object[1];
                                b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[30], getAuthRequestContext[25], objArr16);
                                Class<?> cls6 = Class.forName((String) objArr16[0]);
                                Object[] objArr17 = new Object[1];
                                b(getAuthRequestContext[25], getAuthRequestContext[8], getAuthRequestContext[5], objArr17);
                                Object[] objArr18 = new Object[1];
                                a(null, ((ApplicationInfo) cls6.getMethod((String) objArr17[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr18);
                                try {
                                    Object[] objArr19 = {baseContext, str, str2, str3, str4, true, (String) objArr18[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), KeyEvent.normalizeMetaState(0) + 18, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr19);
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
                } catch (Throwable th6) {
                    Throwable cause6 = th6.getCause();
                    if (cause6 == null) {
                        throw th6;
                    }
                    throw cause6;
                }
            }
        }
        try {
            Object[] objArr20 = new Object[1];
            b((byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr20);
            Class<?> cls7 = Class.forName((String) objArr20[0]);
            byte b = getAuthRequestContext[25];
            Object[] objArr21 = new Object[1];
            b(30, b, (byte) (b | 8), objArr21);
            try {
                Object[] objArr22 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr21[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 494, 4 - TextUtils.indexOf("", ""), (char) (ExpandableListView.getPackedPositionChild(0L) + 1));
                    byte b2 = (byte) ($$a[78] - 1);
                    Object[] objArr23 = new Object[1];
                    c(b2, b2, (byte) (-$$a[40]), objArr23);
                    obj3 = cls8.getMethod((String) objArr23[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr24 = (Object[]) ((Method) obj3).invoke(null, objArr22);
                int i = ((int[]) objArr24[1])[0];
                if (((int[]) objArr24[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), 35 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr25 = {-778950083, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 911, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) View.MeasureSpec.getSize(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr25);
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
                super.onCreate(savedInstanceState);
                if (savedInstanceState != null || (presenter = this.presenter) == null) {
                    return;
                }
                presenter.BuiltInFictitiousFunctionClassFactory();
            } catch (Throwable th9) {
                Throwable cause9 = th9.getCause();
                if (cause9 == null) {
                    throw th9;
                }
                throw cause9;
            }
        } catch (Throwable th10) {
            Throwable cause10 = th10.getCause();
            if (cause10 == null) {
                throw th10;
            }
            throw cause10;
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        showActiveMissionProgress();
        showPastMissionProgress();
    }

    @Override // id.dana.contract.promoquest.mission.MissionListContract.View
    public final void showActiveMissionProgress() {
        MissionListFragment authRequestContext = getAuthRequestContext(ACTIVE_MISSIONS_KEY);
        if (authRequestContext != null) {
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // id.dana.contract.promoquest.mission.MissionListContract.View
    public final void showPastMissionProgress() {
        MissionListFragment authRequestContext = getAuthRequestContext(PAST_MISSIONS_KEY);
        if (authRequestContext != null) {
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // id.dana.contract.promoquest.mission.MissionListContract.View
    public final void dismisssActiveMissionProgress() {
        MissionListFragment authRequestContext = getAuthRequestContext(ACTIVE_MISSIONS_KEY);
        if (authRequestContext != null) {
            authRequestContext.PlaceComponentResult();
        }
    }

    @Override // id.dana.contract.promoquest.mission.MissionListContract.View
    public final void dismisssPastMissionProgress() {
        MissionListFragment authRequestContext = getAuthRequestContext(PAST_MISSIONS_KEY);
        if (authRequestContext != null) {
            authRequestContext.PlaceComponentResult();
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        dismisssActiveMissionProgress();
        dismisssPastMissionProgress();
    }

    @OnClick({R.id.left_button})
    public final void closeToHome() {
        finish();
    }

    public final void reloadMissions(String keyFragment) {
        if (keyFragment != null) {
            if (!Intrinsics.areEqual(keyFragment, ACTIVE_MISSIONS_KEY)) {
                if (Intrinsics.areEqual(keyFragment, PAST_MISSIONS_KEY)) {
                    MissionListFragment authRequestContext = getAuthRequestContext(PAST_MISSIONS_KEY);
                    if (authRequestContext != null) {
                        MissionListFragment.getAuthRequestContext(authRequestContext);
                    }
                    MissionListContract.Presenter presenter = this.presenter;
                    if (presenter != null) {
                        presenter.getAuthRequestContext();
                        return;
                    }
                    return;
                }
                return;
            }
            MissionListFragment authRequestContext2 = getAuthRequestContext(ACTIVE_MISSIONS_KEY);
            if (authRequestContext2 != null) {
                MissionListFragment.getAuthRequestContext(authRequestContext2);
            }
            MissionListContract.Presenter presenter2 = this.presenter;
            if (presenter2 != null) {
                presenter2.MyBillsEntityDataFactory();
            }
        }
    }

    @Override // id.dana.contract.promoquest.mission.MissionListContract.View
    public final void onFetchActiveMissionFailed(String errorMessage) {
        MissionListFragment authRequestContext = getAuthRequestContext(ACTIVE_MISSIONS_KEY);
        if (authRequestContext == null || !authRequestContext.MyBillsEntityDataFactory()) {
            authRequestContext = null;
        }
        if (authRequestContext != null) {
            authRequestContext.getAuthRequestContext(CollectionsKt.emptyList());
            authRequestContext.getAuthRequestContext(true, 0);
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) authRequestContext.MyBillsEntityDataFactory(R.id.res_0x7f0a1057_splitgroupsendentitydata_geteditmemberswitch_1);
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setRefreshing(false);
                swipeRefreshLayout.setEnabled(false);
            }
        }
    }

    @Override // id.dana.contract.promoquest.mission.MissionListContract.View
    public final void onFetchPastMissionFailed(String errorMessage) {
        MissionListFragment authRequestContext = getAuthRequestContext(PAST_MISSIONS_KEY);
        if (authRequestContext == null || !authRequestContext.MyBillsEntityDataFactory()) {
            authRequestContext = null;
        }
        if (authRequestContext != null) {
            authRequestContext.getAuthRequestContext(CollectionsKt.emptyList());
            authRequestContext.getAuthRequestContext(true, 0);
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) authRequestContext.MyBillsEntityDataFactory(R.id.res_0x7f0a1057_splitgroupsendentitydata_geteditmemberswitch_1);
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setRefreshing(false);
                swipeRefreshLayout.setEnabled(false);
            }
        }
    }

    private final MissionListFragment getAuthRequestContext(String p0) {
        Object obj;
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "");
        Iterator<T> it = fragments.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Bundle arguments = ((Fragment) obj).getArguments();
            if (Intrinsics.areEqual(arguments != null ? arguments.getString("TabAdapter.key") : null, p0)) {
                break;
            }
        }
        if (obj instanceof MissionListFragment) {
            return (MissionListFragment) obj;
        }
        return null;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\t"}, d2 = {"Lid/dana/promoquest/activity/MissionListActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "getAuthRequestContext", "(Landroid/content/Context;)V", "", "ACTIVE_MISSIONS_KEY", "Ljava/lang/String;", "PAST_MISSIONS_KEY", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void getAuthRequestContext(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.startActivity(new Intent(p0, MissionListActivity.class));
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        DaggerPromoQuestComponent.Builder authRequestContext = DaggerPromoQuestComponent.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        authRequestContext.BuiltInFictitiousFunctionClassFactory = (PromoQuestModule) Preconditions.getAuthRequestContext(new PromoQuestModule(this));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.BuiltInFictitiousFunctionClassFactory, PromoQuestModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerPromoQuestComponent.PromoQuestComponentImpl(authRequestContext.BuiltInFictitiousFunctionClassFactory, authRequestContext.MyBillsEntityDataFactory, (byte) 0).getAuthRequestContext(this);
        registerPresenter(this.presenter);
        setCenterTitle(getString(R.string.promo_quest));
        setMenuLeftButton(R.drawable.btn_arrow_left);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        TabAdapter tabAdapter = new TabAdapter(supportFragmentManager);
        tabAdapter.PlaceComponentResult(new MissionListFragment(), ACTIVE_MISSIONS_KEY, getText(R.string.active));
        tabAdapter.PlaceComponentResult(new MissionListFragment(), PAST_MISSIONS_KEY, getText(R.string.past));
        ((ViewPager) _$_findCachedViewById(R.id.getLeaderboards)).setAdapter(tabAdapter);
        ((TabLayout) _$_findCachedViewById(R.id.res_0x7f0a12c8_component1_gbym_se)).setupWithViewPager((ViewPager) _$_findCachedViewById(R.id.getLeaderboards));
    }

    @Override // id.dana.contract.promoquest.mission.MissionListContract.View
    public final void onFetchActiveMissionSucceeded(List<MissionModel> missionModels) {
        Intrinsics.checkNotNullParameter(missionModels, "");
        boolean z = !this.mixpanelEventTracked;
        this.mixpanelEventTracked = z;
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : missionModels) {
                if (((MissionModel) obj).MyBillsEntityDataFactory()) {
                    arrayList.add(obj);
                }
            }
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this);
            builder.MyBillsEntityDataFactory = TrackerKey.Event.PROMO_QUEST_MAIN_PAGE_OPEN;
            EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = builder.MyBillsEntityDataFactory("Source", getIntent().getStringExtra("source")).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.UNFINISHED_QUEST_EXIST, !arrayList.isEmpty());
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(BuiltInFictitiousFunctionClassFactory, (byte) 0));
        }
        MissionListFragment authRequestContext = getAuthRequestContext(ACTIVE_MISSIONS_KEY);
        if (authRequestContext != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : missionModels) {
                if (((MissionModel) obj2).MyBillsEntityDataFactory()) {
                    arrayList2.add(obj2);
                }
            }
            List<MissionModel> sortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: id.dana.promoquest.activity.MissionListActivity$postActiveMissionsToFragment$lambda-10$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Date date = ((MissionModel) t).lookAheadTest;
                    Long valueOf = Long.valueOf(date != null ? date.getTime() : 0L);
                    Date date2 = ((MissionModel) t2).lookAheadTest;
                    return ComparisonsKt.compareValues(valueOf, Long.valueOf(date2 != null ? date2.getTime() : 0L));
                }
            });
            authRequestContext.getAuthRequestContext(sortedWith);
            authRequestContext.getAuthRequestContext(sortedWith.isEmpty(), 1);
        }
    }

    @Override // id.dana.contract.promoquest.mission.MissionListContract.View
    public final void onFetchPastMissionSucceeded(List<MissionModel> missionModels) {
        Intrinsics.checkNotNullParameter(missionModels, "");
        MissionListFragment authRequestContext = getAuthRequestContext(PAST_MISSIONS_KEY);
        if (authRequestContext != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : missionModels) {
                if (((MissionModel) obj).BuiltInFictitiousFunctionClassFactory()) {
                    arrayList.add(obj);
                }
            }
            List<MissionModel> sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: id.dana.promoquest.activity.MissionListActivity$postPastMissionsToFragment$lambda-14$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Date date = ((MissionModel) t2).lookAheadTest;
                    Long valueOf = Long.valueOf(date != null ? date.getTime() : 0L);
                    Date date2 = ((MissionModel) t).lookAheadTest;
                    return ComparisonsKt.compareValues(valueOf, Long.valueOf(date2 != null ? date2.getTime() : 0L));
                }
            });
            authRequestContext.getAuthRequestContext(sortedWith);
            authRequestContext.getAuthRequestContext(sortedWith.isEmpty(), 2);
        }
    }

    public final void reloadBothMissions() {
        MissionListFragment authRequestContext = getAuthRequestContext(ACTIVE_MISSIONS_KEY);
        if (authRequestContext != null) {
            MissionListFragment.getAuthRequestContext(authRequestContext);
        }
        MissionListContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            presenter.MyBillsEntityDataFactory();
        }
        MissionListFragment authRequestContext2 = getAuthRequestContext(PAST_MISSIONS_KEY);
        if (authRequestContext2 != null) {
            MissionListFragment.getAuthRequestContext(authRequestContext2);
        }
        MissionListContract.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter2.getAuthRequestContext();
        }
    }

    private static void a(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = scheduleImpl;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ lookAheadTest);
        if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (NetworkUserEntityData$$ExternalSyntheticLambda0) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr6);
        }
    }
}

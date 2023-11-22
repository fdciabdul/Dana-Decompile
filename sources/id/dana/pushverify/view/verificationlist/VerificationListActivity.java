package id.dana.pushverify.view.verificationlist;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
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
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.zxing.pdf417.PDF417Common;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.databinding.ActivityVerificationListBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerVerificationListMainComponent;
import id.dana.di.modules.VerificationListMainModule;
import id.dana.notification.NotificationUtils;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.pushverify.view.bottomsheet.EnableNotificationBottomSheetDialogFragment;
import id.dana.pushverify.view.verificationlist.VerificationListMainContract;
import id.dana.pushverify.view.verificationlist.list.VerificationListActiveFragment;
import id.dana.pushverify.view.verificationlist.list.VerificationListHistoryFragment;
import id.dana.social.adapter.BaseTabFragmentAdapter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001!B\u0007¢\u0006\u0004\b \u0010\u0006J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0006R\u0013\u0010\u0014\u001a\u00020\u0011X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001f\u001a\u00020\u001dX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013"}, d2 = {"Lid/dana/pushverify/view/verificationlist/VerificationListActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityVerificationListBinding;", "Lid/dana/pushverify/view/verificationlist/VerificationListMainContract$View;", "", "checkNotificationDisabled", "()V", "configToolbar", IAPSyncCommand.COMMAND_INIT, "initViewBinding", "()Lid/dana/databinding/ActivityVerificationListBinding;", "", "tabIndex", "openTab", "(I)V", "showEnableNotificationPrompt", "successDisableNotificationPrompt", "Lid/dana/pushverify/view/bottomsheet/EnableNotificationBottomSheetDialogFragment;", "lookAheadTest", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Ldagger/Lazy;", "Lid/dana/pushverify/view/verificationlist/VerificationListMainContract$Presenter;", "presenter", "Ldagger/Lazy;", "getPresenter", "()Ldagger/Lazy;", "setPresenter", "(Ldagger/Lazy;)V", "Lid/dana/social/adapter/BaseTabFragmentAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getAuthRequestContext", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VerificationListActivity extends ViewBindingActivity<ActivityVerificationListBinding> implements VerificationListMainContract.View {
    public static final int ACTIVE_TAB = 0;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char[] GetContactSyncConfig = null;
    public static final int HISTORY_TAB = 1;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda2;
    @Inject
    public Lazy<VerificationListMainContract.Presenter> presenter;
    public static final byte[] $$a = {86, TarHeader.LF_NORMAL, -68, 79, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 125;
    public static final byte[] PlaceComponentResult = {Ascii.GS, SignedBytes.MAX_POWER_OF_TWO, 35, 67, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 151;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final kotlin.Lazy getAuthRequestContext = LazyKt.lazy(new Function0<BaseTabFragmentAdapter>() { // from class: id.dana.pushverify.view.verificationlist.VerificationListActivity$tabAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BaseTabFragmentAdapter invoke() {
            FragmentManager supportFragmentManager = VerificationListActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            Lifecycle lifecycle = VerificationListActivity.this.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "");
            BaseTabFragmentAdapter baseTabFragmentAdapter = new BaseTabFragmentAdapter(supportFragmentManager, lifecycle);
            VerificationListActivity verificationListActivity = VerificationListActivity.this;
            VerificationListActiveFragment.Companion companion = VerificationListActiveFragment.Companion;
            VerificationListActiveFragment MyBillsEntityDataFactory = VerificationListActiveFragment.Companion.MyBillsEntityDataFactory();
            String string = verificationListActivity.getString(R.string.verification_list_active_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            baseTabFragmentAdapter.PlaceComponentResult(MyBillsEntityDataFactory, string, "");
            VerificationListHistoryFragment.Companion companion2 = VerificationListHistoryFragment.Companion;
            VerificationListHistoryFragment authRequestContext = VerificationListHistoryFragment.Companion.getAuthRequestContext();
            String string2 = verificationListActivity.getString(R.string.verification_list_history_title);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            baseTabFragmentAdapter.PlaceComponentResult(authRequestContext, string2, "");
            return baseTabFragmentAdapter;
        }
    });

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final kotlin.Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<EnableNotificationBottomSheetDialogFragment>() { // from class: id.dana.pushverify.view.verificationlist.VerificationListActivity$enableNotificationBottomSheet$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final EnableNotificationBottomSheetDialogFragment invoke() {
            EnableNotificationBottomSheetDialogFragment.Companion companion = EnableNotificationBottomSheetDialogFragment.INSTANCE;
            final VerificationListActivity verificationListActivity = VerificationListActivity.this;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.pushverify.view.verificationlist.VerificationListActivity$enableNotificationBottomSheet$2.1
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
                    VerificationListActivity.access$openNotificationSettings(VerificationListActivity.this);
                }
            };
            final VerificationListActivity verificationListActivity2 = VerificationListActivity.this;
            return EnableNotificationBottomSheetDialogFragment.Companion.BuiltInFictitiousFunctionClassFactory(function0, new Function0<Unit>() { // from class: id.dana.pushverify.view.verificationlist.VerificationListActivity$enableNotificationBottomSheet$2.2
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
                    VerificationListActivity.this.getPresenter().get().MyBillsEntityDataFactory();
                }
            });
        }
    });

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        GetContactSyncConfig = new char[]{62255, 10382, 17526, 24630, 40345, 47425, 54590, 62114, 11871, 18976, 26610, 33562, 48935, 54523, 61630, 11285, 18904, 26025, 33030, 48861, 55938, 63072, 5064, 20361, 27519, 32980, 62253, 10389, 17504, 24630, 40339, 47430, 54574, 62157, 11854, 18976, 26606, 33629, 48901, 54521, 61630, 11285, 18881, 26030, 60304, 12337, 23753, 30857, 34086, 41470, 52609, 59933, 14062, 21148, 32531, 39899, 42923, 52296, 59414, 13478, 20834, 32012, 43211, 29553, 8111, 15301, 50810, 24925, 47783, 54784, 62040, 4066, 11112, 18247, 24720, 48173, 55313, 62917, 4470, 11559, 18062, 25311, 48750, 56251, 63445, 4960, 11489, 18582, 25679, 33277, 56830, 63838, 4775, 12030, 19028, 26192, 33720, 57199, 64285, 5267, 12338, 19524, 27033, 34164, 41333, 64134, 5848, 12909, 20434, 27602, 34662, 41184, 64719, 6168, 13821, 18457, 37859, 65298, 56086, 9894, 551, 28252, 18818, 38252, 61701, 56461, 14391, 1076, 28575, 19405, 38782, 62122, 57028, 14882, 1443, 24964, 19727, 43194, 62697, 53278, 15332, 2029, 25415, 20296, 43690, 63022, 53848, 15835, 6514, 25936, 16522, 44131, 34877, 54172, 16329, 7037, 26262, 17041, 44659, 35315, 54745, 12557, 7357, 30955, 17413, 44979, 35819, 55065, 13129, 7932, 31275, 18008, 41463, 36215, 59648, 13441, 4150, 31800, 18329, 62332, 10449, 17527, 24614, 40399, 47391, 54632, 62136, 11782, 19048, 26554, 33541, 48983, 54443, 61690, 11339, 18895, 26021, 33094, 48832, 56036, 63082, 5083, 20447, 27433, 32982, 48347, 55340, 62496, 4510, 19741, 26943, 34489, 41540, 56928, 64444, 5972, 13151, 26796, 34036, 41030, 56822, 63987, 5440, 12958, 28392, 35435, 42974, 50056, 65337, 5329, 12417, 27684, 34937, 42396, 49433, 64873, 6853, 13851, 21090, 36832, 43789, 51039, 64677, 65209, 9483, 18937, 28075, 36890, 46221, 55530, 65340, 9157, 18350, 27251, 36554, 45783, 55667, 64829, 8593, 17492, 26686, 35993, 45912, 55080, 64484, 7761, 16989, 26342, 36186, 45340, 54777, 63933, 7188, 16580, 25782, 35696, 45005, 54184, 63029, 6858, 16024, 25960, 35196, 44416, 53375, 62516, 6340, 16208, 25385, 34802, 43590, 52738, 62187, 6402, 15629, 25019, 34296, 43008, 52421, 61604, 5889, 15305, 24504, 34555, 23874, 12714, 5606, 59464, 52373};
        NetworkUserEntityData$$ExternalSyntheticLambda2 = 198686193653328096L;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = 56 - r6
            int r8 = r8 + 97
            int r7 = r7 + 16
            byte[] r0 = id.dana.pushverify.view.verificationlist.VerificationListActivity.PlaceComponentResult
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r7
            r3 = r8
            r4 = 0
            r7 = r6
            goto L2a
        L14:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L19:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r3 = r0[r7]
        L2a:
            int r3 = -r3
            int r6 = r6 + r3
            int r7 = r7 + 1
            int r6 = r6 + (-4)
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.pushverify.view.verificationlist.VerificationListActivity.b(short, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = 42 - r7
            byte[] r0 = id.dana.pushverify.view.verificationlist.VerificationListActivity.$$a
            int r6 = r6 * 2
            int r6 = r6 + 75
            int r8 = 46 - r8
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
            goto L37
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r8 = r8 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
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
        L37:
            int r7 = r7 + r6
            int r6 = r7 + (-7)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.pushverify.view.verificationlist.VerificationListActivity.c(int, int, short, java.lang.Object[]):void");
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
        a(18 - (ViewConfiguration.getTouchSlop() >> 8), 44 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 6336), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(6 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 62 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 23528), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 35 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(Color.blue(0) + 48, (ViewConfiguration.getFadingEdgeLength() >> 16) + 67, (char) (ImageFormat.getBitsPerPixel(0) + 37413), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(65 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), KeyEvent.keyCodeFromString("") + 115, (char) (47926 - View.combineMeasuredStates(0, 0)), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(View.MeasureSpec.getSize(0) + 64, 178 - ImageFormat.getBitsPerPixel(0), (char) ((Process.getThreadPriority(0) + 20) >> 6), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(60 - (ViewConfiguration.getTouchSlop() >> 8), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 243, (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 3487), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(6 - View.resolveSize(0, 0), 304 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (30092 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 911, 18 - (ViewConfiguration.getTapTimeout() >> 16), (char) KeyEvent.keyCodeFromString(""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) (-PlaceComponentResult[31]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (PlaceComponentResult[0] + 1);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr14 = new Object[1];
                b(b, b2, (byte) (b2 | 8), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 55, 3 - TextUtils.getCapsMode("", 0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[31], $$a[53], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, TextUtils.indexOf((CharSequence) "", '0', 0) + 16, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 16 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 815, 29 - Color.blue(0), (char) (57993 - ExpandableListView.getPackedPositionChild(0L)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 15, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.combineMeasuredStates(0, 0), (KeyEvent.getMaxKeyCode() >> 16) + 35, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1265315891, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, 18 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-PlaceComponentResult[31]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = (byte) (PlaceComponentResult[0] + 1);
                byte b4 = PlaceComponentResult[25];
                Object[] objArr20 = new Object[1];
                b(b3, b4, (byte) (b4 | 8), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(62 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 45, (char) KeyEvent.keyCodeFromString(""));
                        Object[] objArr22 = new Object[1];
                        c($$a[9], $$a[8], $$a[84], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), 35 - Color.blue(0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-1265315891, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 911, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-PlaceComponentResult[31]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = (byte) (PlaceComponentResult[0] + 1);
                byte b6 = PlaceComponentResult[25];
                Object[] objArr26 = new Object[1];
                b(b5, b6, (byte) (b6 | 8), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), Color.blue(0) + 3, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 38967));
                        Object[] objArr28 = new Object[1];
                        c($$a[9], $$a[8], $$a[84], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getCapsMode("", 0, 0), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1265315891, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 911, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-PlaceComponentResult[31]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b7 = (byte) (PlaceComponentResult[0] + 1);
                byte b8 = PlaceComponentResult[25];
                Object[] objArr32 = new Object[1];
                b(b7, b8, (byte) (b8 | 8), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - KeyEvent.getDeadChar(0, 0), 3 - Color.red(0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        byte b9 = (byte) ($$a[78] - 1);
                        byte b10 = b9;
                        Object[] objArr34 = new Object[1];
                        c(b9, b10, b10, objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.getDefaultSize(0, 0), 35 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-1265315891, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 910, 18 - TextUtils.getTrimmedLength(""), (char) View.combineMeasuredStates(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        int codePointAt = getPackageName().codePointAt(2) - 28;
        int length = getPackageName().length() + 37;
        try {
            Object[] objArr2 = new Object[1];
            b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[30], PlaceComponentResult[25], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            b(PlaceComponentResult[25], PlaceComponentResult[8], PlaceComponentResult[5], objArr3);
            Object[] objArr4 = new Object[1];
            a(codePointAt, length, (char) (((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 6302), objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            try {
                Object[] objArr5 = new Object[1];
                b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[30], PlaceComponentResult[25], objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                b(PlaceComponentResult[25], PlaceComponentResult[8], PlaceComponentResult[5], new Object[1]);
                Object[] objArr6 = new Object[1];
                a(((ApplicationInfo) cls3.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 28, super.getResources().getString(R.string.bottom_on_boarding_body_text_my_bills_second).substring(2, 3).codePointAt(0) - 52, (char) (23529 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), objArr6);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        try {
                            Object[] objArr7 = new Object[1];
                            b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[30], PlaceComponentResult[25], objArr7);
                            Class<?> cls4 = Class.forName((String) objArr7[0]);
                            b(PlaceComponentResult[25], PlaceComponentResult[8], PlaceComponentResult[5], new Object[1]);
                            Object[] objArr8 = new Object[1];
                            a(((ApplicationInfo) cls4.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 7, getPackageName().codePointAt(5) - 110, (char) (super.getResources().getString(R.string.notes_1).substring(13, 15).length() - 2), objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 18;
                            try {
                                Object[] objArr9 = new Object[1];
                                b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[30], PlaceComponentResult[25], objArr9);
                                Class<?> cls6 = Class.forName((String) objArr9[0]);
                                Object[] objArr10 = new Object[1];
                                b(PlaceComponentResult[25], PlaceComponentResult[8], PlaceComponentResult[5], objArr10);
                                int i = ((ApplicationInfo) cls6.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion - 7;
                                try {
                                    Object[] objArr11 = new Object[1];
                                    b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[30], PlaceComponentResult[25], objArr11);
                                    Class<?> cls7 = Class.forName((String) objArr11[0]);
                                    b(PlaceComponentResult[25], PlaceComponentResult[8], PlaceComponentResult[5], new Object[1]);
                                    Object[] objArr12 = new Object[1];
                                    a(windowTouchSlop, i, (char) (((ApplicationInfo) cls7.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33), objArr12);
                                    baseContext = (Context) cls5.getMethod((String) objArr12[0], new Class[0]).invoke(null, null);
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
                    if (baseContext != null) {
                        baseContext = baseContext.getApplicationContext();
                    }
                    if (baseContext != null) {
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj == null) {
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 930, 36 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            Object[] objArr13 = new Object[1];
                            a((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 49, getPackageName().length() + 60, (char) (37412 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), objArr13);
                            String str = (String) objArr13[0];
                            try {
                                Object[] objArr14 = new Object[1];
                                b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[30], PlaceComponentResult[25], objArr14);
                                Class<?> cls8 = Class.forName((String) objArr14[0]);
                                Object[] objArr15 = new Object[1];
                                b(PlaceComponentResult[25], PlaceComponentResult[8], PlaceComponentResult[5], objArr15);
                                Object[] objArr16 = new Object[1];
                                a(((ApplicationInfo) cls8.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion + 31, getPackageName().length() + 108, (char) (super.getResources().getString(R.string.family_account_success_remove_family_member_message).substring(16, 17).codePointAt(0) + 47894), objArr16);
                                String str2 = (String) objArr16[0];
                                int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 64;
                                try {
                                    Object[] objArr17 = new Object[1];
                                    b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[30], PlaceComponentResult[25], objArr17);
                                    Class<?> cls9 = Class.forName((String) objArr17[0]);
                                    Object[] objArr18 = new Object[1];
                                    b(PlaceComponentResult[25], PlaceComponentResult[8], PlaceComponentResult[5], objArr18);
                                    int i2 = ((ApplicationInfo) cls9.getMethod((String) objArr18[0], null).invoke(this, null)).targetSdkVersion + 146;
                                    try {
                                        Object[] objArr19 = new Object[1];
                                        b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[30], PlaceComponentResult[25], objArr19);
                                        Class<?> cls10 = Class.forName((String) objArr19[0]);
                                        b(PlaceComponentResult[25], PlaceComponentResult[8], PlaceComponentResult[5], new Object[1]);
                                        Object[] objArr20 = new Object[1];
                                        a(maximumFlingVelocity, i2, (char) (((ApplicationInfo) cls10.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33), objArr20);
                                        String str3 = (String) objArr20[0];
                                        Object[] objArr21 = new Object[1];
                                        a(super.getResources().getString(R.string.bottom_on_boarding_share_to_feed_third_subtitle).substring(0, 18).codePointAt(13) - 61, super.getResources().getString(R.string.voucher_promo_available).substring(0, 8).codePointAt(3) + 144, (char) (((Process.getThreadPriority(0) + 20) >> 6) + 3487), objArr21);
                                        String str4 = (String) objArr21[0];
                                        Object[] objArr22 = new Object[1];
                                        a(super.getResources().getString(R.string.remove_trusted_device_info).substring(55, 57).length() + 4, TextUtils.getOffsetBefore("", 0) + 303, (char) (30091 - TextUtils.lastIndexOf("", '0', 0, 0)), objArr22);
                                        try {
                                            Object[] objArr23 = {baseContext, str, str2, str3, str4, true, (String) objArr22[0], 995651014};
                                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                            if (obj2 == null) {
                                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ((Process.getThreadPriority(0) + 20) >> 6), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 17, (char) Color.red(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                            }
                                            ((Method) obj2).invoke(invoke, objArr23);
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
                }
                try {
                    Object[] objArr24 = new Object[1];
                    b((byte) (-PlaceComponentResult[31]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), objArr24);
                    Class<?> cls11 = Class.forName((String) objArr24[0]);
                    byte b = (byte) (PlaceComponentResult[0] + 1);
                    byte b2 = PlaceComponentResult[25];
                    Object[] objArr25 = new Object[1];
                    b(b, b2, (byte) (b2 | 8), objArr25);
                    try {
                        Object[] objArr26 = {Integer.valueOf(((Integer) cls11.getMethod((String) objArr25[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls12 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 494, 4 - KeyEvent.getDeadChar(0, 0), (char) TextUtils.getOffsetBefore("", 0));
                            byte b3 = (byte) ($$a[78] - 1);
                            byte b4 = b3;
                            Object[] objArr27 = new Object[1];
                            c(b3, b4, b4, objArr27);
                            obj3 = cls12.getMethod((String) objArr27[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr28 = (Object[]) ((Method) obj3).invoke(null, objArr26);
                        int i3 = ((int[]) objArr28[1])[0];
                        if (((int[]) objArr28[0])[0] != i3) {
                            long j = ((r0 ^ i3) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), 35 - TextUtils.getTrimmedLength(""), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr29 = {1688271450, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getEdgeSlop() >> 16), TextUtils.lastIndexOf("", '0', 0) + 19, (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr29);
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
                        super.onCreate(bundle);
                    } catch (Throwable th11) {
                        Throwable cause11 = th11.getCause();
                        if (cause11 == null) {
                            throw th11;
                        }
                        throw cause11;
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
        } catch (Throwable th14) {
            Throwable cause14 = th14.getCause();
            if (cause14 == null) {
                throw th14;
            }
            throw cause14;
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().length() + 19, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1, (char) (super.getResources().getString(R.string.pushverify_verify_dialog_binding_success_title).substring(12, 13).length() - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 18;
            int i = 27 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
            try {
                Object[] objArr2 = new Object[1];
                b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[30], PlaceComponentResult[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(PlaceComponentResult[25], PlaceComponentResult[8], PlaceComponentResult[5], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(jumpTapTimeout, i, (char) (((ApplicationInfo) cls2.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33), objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (Process.myPid() >> 22), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776305) - Color.rgb(0, 0, 0), TextUtils.indexOf("", "") + 18, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(AndroidCharacter.getMirror('0') - 22, getPackageName().codePointAt(5) - 110, (char) (super.getResources().getString(R.string.title_saving).substring(0, 10).codePointAt(9) - 115), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            int i = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19;
            try {
                Object[] objArr2 = new Object[1];
                b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[30], PlaceComponentResult[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(PlaceComponentResult[25], PlaceComponentResult[8], PlaceComponentResult[5], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(i, ((ApplicationInfo) cls2.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 7, (char) (super.getResources().getString(R.string.subtitle_saving_benefit_1).substring(9, 10).codePointAt(0) - 117), objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 911, 18 - (KeyEvent.getMaxKeyCode() >> 16), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }

    @JvmName(name = "getPresenter")
    public final Lazy<VerificationListMainContract.Presenter> getPresenter() {
        Lazy<VerificationListMainContract.Presenter> lazy = this.presenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(Lazy<VerificationListMainContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.presenter = lazy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityVerificationListBinding initViewBinding() {
        ActivityVerificationListBinding authRequestContext = ActivityVerificationListBinding.getAuthRequestContext(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setCenterTitle(getString(R.string.verification_list_title));
        setMenuLeftButton(R.drawable.btn_arrow_left);
    }

    @Override // id.dana.pushverify.view.verificationlist.VerificationListMainContract.View
    public final void showEnableNotificationPrompt() {
        NotificationUtils notificationUtils = NotificationUtils.BuiltInFictitiousFunctionClassFactory;
        NotificationManagerCompat MyBillsEntityDataFactory = NotificationManagerCompat.MyBillsEntityDataFactory(this);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        if (NotificationUtils.PlaceComponentResult(MyBillsEntityDataFactory)) {
            return;
        }
        EnableNotificationBottomSheetDialogFragment enableNotificationBottomSheetDialogFragment = (EnableNotificationBottomSheetDialogFragment) this.MyBillsEntityDataFactory.getValue();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        enableNotificationBottomSheetDialogFragment.MyBillsEntityDataFactory(supportFragmentManager);
    }

    public final void openTab(int tabIndex) {
        ActivityVerificationListBinding binding = getBinding();
        TabLayout.Tab tabAt = binding.KClassImpl$Data$declaredNonStaticMembers$2.getTabAt(tabIndex);
        if (tabAt != null) {
            tabAt.select();
        }
        ViewPager2 viewPager2 = binding.MyBillsEntityDataFactory;
        viewPager2.setCurrentItem(tabIndex, false);
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        ((BaseTabFragmentAdapter) this.getAuthRequestContext.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda0.get(tabIndex).onResume();
    }

    public final void checkNotificationDisabled() {
        getPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\n"}, d2 = {"Lid/dana/pushverify/view/verificationlist/VerificationListActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;I)V", "ACTIVE_TAB", "I", "HISTORY_TAB", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void MyBillsEntityDataFactory(Context p0, int p1) {
            Intent intent = new Intent(p0, VerificationListActivity.class);
            intent.putExtra("ex-target-open", p1);
            p0.startActivity(intent);
        }
    }

    public static /* synthetic */ void $r8$lambda$pG7WvEpGqooO7_wTvYCiWBNgZrc(VerificationListActivity verificationListActivity, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(verificationListActivity, "");
        Intrinsics.checkNotNullParameter(tab, "");
        tab.setText(((BaseTabFragmentAdapter) verificationListActivity.getAuthRequestContext.getValue()).moveToNextValue.get(i));
    }

    public static final /* synthetic */ void access$openNotificationSettings(VerificationListActivity verificationListActivity) {
        NotificationUtils notificationUtils = NotificationUtils.BuiltInFictitiousFunctionClassFactory;
        NotificationUtils.MyBillsEntityDataFactory(verificationListActivity);
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        DaggerVerificationListMainComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerVerificationListMainComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (VerificationListMainModule) Preconditions.getAuthRequestContext(new VerificationListMainModule(this));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, VerificationListMainModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerVerificationListMainComponent.VerificationListMainComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, (byte) 0).getAuthRequestContext(this);
        registerPresenter(getPresenter().get());
        ActivityVerificationListBinding binding = getBinding();
        ViewPager2 viewPager2 = binding.MyBillsEntityDataFactory;
        viewPager2.setAdapter((BaseTabFragmentAdapter) this.getAuthRequestContext.getValue());
        viewPager2.setOffscreenPageLimit(1);
        viewPager2.setUserInputEnabled(false);
        new TabLayoutMediator(binding.KClassImpl$Data$declaredNonStaticMembers$2, binding.MyBillsEntityDataFactory, new TabLayoutMediator.TabConfigurationStrategy() { // from class: id.dana.pushverify.view.verificationlist.VerificationListActivity$$ExternalSyntheticLambda0
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                VerificationListActivity.$r8$lambda$pG7WvEpGqooO7_wTvYCiWBNgZrc(VerificationListActivity.this, tab, i);
            }
        }).attach();
        Intent intent = getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra("ex-target-open", 0);
            openTab(intExtra);
            if (intExtra == 1) {
                getPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
    }

    @Override // id.dana.pushverify.view.verificationlist.VerificationListMainContract.View
    public final void successDisableNotificationPrompt() {
        ((EnableNotificationBottomSheetDialogFragment) this.MyBillsEntityDataFactory.getValue()).dismiss();
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (GetContactSyncConfig[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ NetworkUserEntityData$$ExternalSyntheticLambda2))) ^ c;
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

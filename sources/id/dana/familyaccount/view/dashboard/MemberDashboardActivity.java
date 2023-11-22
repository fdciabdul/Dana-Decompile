package id.dana.familyaccount.view.dashboard;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
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
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.databinding.ActivityFamilyAccountDashboardMemberBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.databinding.ViewMemberDashboardSectionListOfBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerFamilyAccountDashboardComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.FamilyAccountDashboardModule;
import id.dana.domain.familyaccount.model.AvailableServicesConfig;
import id.dana.domain.familyaccount.model.AvailableServicesConfigKt;
import id.dana.domain.familyaccount.model.MaxMemberLimitConfig;
import id.dana.familyaccount.adapter.FamilyDashboardServicesAdapter;
import id.dana.familyaccount.constants.StatusInformationType;
import id.dana.familyaccount.contract.FamilyDashboardContract;
import id.dana.familyaccount.model.DashboardModel;
import id.dana.familyaccount.model.FamilyMemberInfoModel;
import id.dana.familyaccount.model.TopUpUserConsultModel;
import id.dana.familyaccount.view.dashboard.FamilyMembersActivity;
import id.dana.familyaccount.view.managefamily.ManageFamilyView;
import id.dana.familyaccount.view.statusinformation.StatusInformationView;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.utils.SafeClickListenerExtensionKt;
import id.dana.utils.ShimmeringUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\n\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u00020\u000f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/familyaccount/view/dashboard/MemberDashboardActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityFamilyAccountDashboardMemberBinding;", "", "configToolbar", "()V", "inflateViewBinding", "()Lid/dana/databinding/ActivityFamilyAccountDashboardMemberBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "onDestroy", "Lid/dana/familyaccount/adapter/FamilyDashboardServicesAdapter;", "PlaceComponentResult", "Lid/dana/familyaccount/adapter/FamilyDashboardServicesAdapter;", "getAuthRequestContext", "Lid/dana/familyaccount/contract/FamilyDashboardContract$Presenter;", "familyDashboardPresenter", "Lid/dana/familyaccount/contract/FamilyDashboardContract$Presenter;", "getFamilyDashboardPresenter", "()Lid/dana/familyaccount/contract/FamilyDashboardContract$Presenter;", "setFamilyDashboardPresenter", "(Lid/dana/familyaccount/contract/FamilyDashboardContract$Presenter;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "getErrorConfigVersion", "Lcom/ethanhua/skeleton/SkeletonScreen;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MemberDashboardActivity extends BaseViewBindingActivity<ActivityFamilyAccountDashboardMemberBinding> {
    public static final byte[] $$a = {4, -20, -33, -123, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 13;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {104, -1, -63, 36, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 32;
    private static long lookAheadTest = 4223654099669795732L;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private FamilyDashboardServicesAdapter getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public FamilyDashboardContract.Presenter familyDashboardPresenter;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private SkeletonScreen KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 97
            int r7 = 55 - r7
            int r6 = 23 - r6
            byte[] r0 = id.dana.familyaccount.view.dashboard.MemberDashboardActivity.KClassImpl$Data$declaredNonStaticMembers$2
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L34
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r7 = r7 + 1
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L34:
            int r9 = r9 + r6
            int r6 = r9 + (-4)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.dashboard.MemberDashboardActivity.b(int, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 21
            int r6 = r6 + 4
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r0 = id.dana.familyaccount.view.dashboard.MemberDashboardActivity.$$a
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1a:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L1e:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L36:
            int r8 = -r8
            int r6 = r6 + r8
            int r7 = r7 + 1
            int r6 = r6 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.dashboard.MemberDashboardActivity.c(byte, short, short, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(15581 - ExpandableListView.getPackedPositionGroup(0L), new char[]{4790, 11876, 27401, 42034, 57804, 8943, 32669, 47346, 62544, 12641, 29275, 36856, 51449, 1409, 18082, 33345, 57204, 6153}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((-16728269) - Color.rgb(0, 0, 0), new char[]{4794, 44445, 27876, 12071, 61055}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ExpandableListView.getPackedPositionChild(0L), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(View.getDefaultSize(0, 0) + 28789, new char[]{4832, 25281, 61963, 17328, 54067, 8442, 45136, 476, 37192, 59055, 30246, 51126, 22478, 42772, 13440, 33850, 5558, 25891, 64219, 18969, 56215, 11053, 47290, 2146, 38987, 59785, 30989, 52964, 24105, 45042, 16128, 35993, 7246, 28148, 64879, 19729, 49861, 20999, 41905, 13108, 32936, 4108, 25041, 61766, 18089, 54901, 10215, 47049}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(35339 - (ViewConfiguration.getTouchSlop() >> 8), new char[]{4790, 39145, 1783, 35986, 15005, 41177, 11941, 54434, 17131, 51415, 30336, 64667, 27191, 4201, 40572, 1094, 45653, 14430, 42615, 11319, 55919, 16385, 52755, 29721, 58345, 27046, 6128, 40347, 3035, 45452, 16303, 42416, 21460, 55768, 18325, 52590, 31544, 57635, 28485, 5449, 33626, 2340, 46972, 15679, 43856, 20751, 57116, 19173, 61684, 32511, 58566, 37599, 6354, 34471, 3253, 47803, 8335, 44693, 21706, 49724, 18546, 63088, 31769, 59985}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 20388, new char[]{4837, 23875, 36344, 64602, 11386, 40153, 53051, 16224, 28615, 56866, 3741, 32497, 43354, 6533, 18913, 47179, 59622, 23367, 35705, 64396, 10753, 39484, 51864, 13623, 26008, 54700, 1068, 29832, 42173, 5888, 18358, 46671, 58944, 22262, 33039, 61792, 8577, 36921, 49311, 12492, 25383, 54236, 1012, 29268, 41651, 4838, 23824, 36350, 64577, 11387, 40078, 53101, 16225, 28623, 56959, 3729, 32504, 43359, 6540, 18918, 47133, 59571, 23316, 35701}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(TextUtils.indexOf((CharSequence) "", '0') + 7044, new char[]{4799, 2336, 9637, 16430, 31912, 39778, 47082, 53869, 52907, 58669, 423, 15383, 22749, 30468, 37781, 36360, 43650, 49413, 64917, 6157, 13450, 21275, 20449, 27196, 34552, 48489, 55800, 62580, 4327, 3955, 11260, 18047, 25302, 39238, 46548, 53264, 52440, 60247, 1992, 8717, 24270, 30044, 37312, 36345, 43066, 50366, 58170, 8127, 14900, 22192, 19822, 27064, 33913, 41191, 57104, 64388, 5658, 12946, 10509, 17813}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 65053, new char[]{4846, 60644, 61145, 59566, 60049, 58487}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetBefore("", 0), AndroidCharacter.getMirror('0') - 30, (char) Color.red(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[32], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]);
                byte b2 = (byte) (getAuthRequestContext - 2);
                Object[] objArr14 = new Object[1];
                b(b, b2, (byte) (b2 & 40), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 55, TextUtils.indexOf("", "", 0, 0) + 3, (char) Color.argb(0, 0, 0, 0));
                        byte b3 = (byte) ($$a[47] - 1);
                        byte b4 = $$a[47];
                        Object[] objArr16 = new Object[1];
                        c(b3, b4, b4, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 800, 14 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 800, 15 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(816 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), TextUtils.indexOf("", "") + 29, (char) (57994 - (KeyEvent.getMaxKeyCode() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(848 - AndroidCharacter.getMirror('0'), 15 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 35, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1167963933, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776305) - Color.rgb(0, 0, 0), 18 - TextUtils.getTrimmedLength(""), (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[32], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b5 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]);
                byte b6 = (byte) (getAuthRequestContext - 2);
                Object[] objArr20 = new Object[1];
                b(b5, b6, (byte) (b6 & 40), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - View.combineMeasuredStates(0, 0), TextUtils.lastIndexOf("", '0', 0, 0) + 47, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1));
                        Object[] objArr22 = new Object[1];
                        c((byte) 23, (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, ExpandableListView.getPackedPositionChild(0L) + 36, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {1167963933, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 912, TextUtils.getOffsetBefore("", 0) + 18, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[32], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b7 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]);
                byte b8 = (byte) (getAuthRequestContext - 2);
                Object[] objArr26 = new Object[1];
                b(b7, b8, (byte) (b8 & 40), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (Process.myTid() >> 22), (ViewConfiguration.getPressedStateDuration() >> 16) + 3, (char) (38967 - ImageFormat.getBitsPerPixel(0)));
                        Object[] objArr28 = new Object[1];
                        c((byte) 23, (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), 'S' - AndroidCharacter.getMirror('0'), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1167963933, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, TextUtils.lastIndexOf("", '0', 0) + 19, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[32], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b9 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]);
                byte b10 = (byte) (getAuthRequestContext - 2);
                Object[] objArr32 = new Object[1];
                b(b9, b10, (byte) (b10 & 40), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - Gravity.getAbsoluteGravity(0, 0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 4, (char) TextUtils.indexOf("", "", 0, 0));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[53]), (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.resolveSizeAndState(0, 0, 0), (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {1167963933, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 910, 17 - ImageFormat.getBitsPerPixel(0), (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        a(super.getResources().getString(R.string.lazada_desc).substring(4, 5).codePointAt(0) + 15484, new char[]{4790, 11876, 27401, 42034, 57804, 8943, 32669, 47346, 62544, 12641, 29275, 36856, 51449, 1409, 18082, 33345, 57204, 6153}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(48947 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), new char[]{4794, 44445, 27876, 12071, 61055}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(super.getResources().getString(R.string.topup_and_pay_via_bank_transfer_title).substring(0, 4).codePointAt(1) + 18118, new char[]{4790, 21910, 40173, 50984, 3588, 29013, 47529, 57520, 11214, 37376, 54641, 7676, 17570, 36823, 63025, 14719, 24657, 43169, 5101, 23251, 40239, 50276, 3247, 30603, 48862, 57636}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 40740, new char[]{4788, 36225, 11491, 53196, 28222, 2326, 43121, 19299, 60351, 35484, 9701, 50239, 26384, 1649, 41289, 16819, 57480, 33770}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), ExpandableListView.getPackedPositionType(0L) + 35, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(super.getResources().getString(R.string.modify_group_name_failed_message).substring(14, 16).codePointAt(1) + 28757, new char[]{4832, 25281, 61963, 17328, 54067, 8442, 45136, 476, 37192, 59055, 30246, 51126, 22478, 42772, 13440, 33850, 5558, 25891, 64219, 18969, 56215, 11053, 47290, 2146, 38987, 59785, 30989, 52964, 24105, 45042, 16128, 35993, 7246, 28148, 64879, 19729, 49861, 20999, 41905, 13108, 32936, 4108, 25041, 61766, 18089, 54901, 10215, 47049}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(getPackageName().length() + 35332, new char[]{4790, 39145, 1783, 35986, 15005, 41177, 11941, 54434, 17131, 51415, 30336, 64667, 27191, 4201, 40572, 1094, 45653, 14430, 42615, 11319, 55919, 16385, 52755, 29721, 58345, 27046, 6128, 40347, 3035, 45452, 16303, 42416, 21460, 55768, 18325, 52590, 31544, 57635, 28485, 5449, 33626, 2340, 46972, 15679, 43856, 20751, 57116, 19173, 61684, 32511, 58566, 37599, 6354, 34471, 3253, 47803, 8335, 44693, 21706, 49724, 18546, 63088, 31769, 59985}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(super.getResources().getString(R.string.carrier_identification_verify_loading_desc).substring(2, 3).length() + 20388, new char[]{4837, 23875, 36344, 64602, 11386, 40153, 53051, 16224, 28615, 56866, 3741, 32497, 43354, 6533, 18913, 47179, 59622, 23367, 35705, 64396, 10753, 39484, 51864, 13623, 26008, 54700, 1068, 29832, 42173, 5888, 18358, 46671, 58944, 22262, 33039, 61792, 8577, 36921, 49311, 12492, 25383, 54236, 1012, 29268, 41651, 4838, 23824, 36350, 64577, 11387, 40078, 53101, 16225, 28623, 56959, 3729, 32504, 43359, 6540, 18918, 47133, 59571, 23316, 35701}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(7043 - (ViewConfiguration.getWindowTouchSlop() >> 8), new char[]{4799, 2336, 9637, 16430, 31912, 39778, 47082, 53869, 52907, 58669, 423, 15383, 22749, 30468, 37781, 36360, 43650, 49413, 64917, 6157, 13450, 21275, 20449, 27196, 34552, 48489, 55800, 62580, 4327, 3955, 11260, 18047, 25302, 39238, 46548, 53264, 52440, 60247, 1992, 8717, 24270, 30044, 37312, 36345, 43066, 50366, 58170, 8127, 14900, 22192, 19822, 27064, 33913, 41191, 57104, 64388, 5658, 12946, 10509, 17813}, objArr9);
                    String str4 = (String) objArr9[0];
                    try {
                        byte b = KClassImpl$Data$declaredNonStaticMembers$2[25];
                        Object[] objArr10 = new Object[1];
                        b(b, (byte) (b | TarHeader.LF_BLK), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr10);
                        Class<?> cls3 = Class.forName((String) objArr10[0]);
                        Object[] objArr11 = new Object[1];
                        b(KClassImpl$Data$declaredNonStaticMembers$2[27], KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), objArr11);
                        Object[] objArr12 = new Object[1];
                        a(((ApplicationInfo) cls3.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 65020, new char[]{4846, 60644, 61145, 59566, 60049, 58487}, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getPressedStateDuration() >> 16), 18 - KeyEvent.getDeadChar(0, 0), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            Object[] objArr14 = new Object[1];
            b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[31], KClassImpl$Data$declaredNonStaticMembers$2[32], objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            byte b2 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]);
            byte b3 = (byte) (getAuthRequestContext - 2);
            Object[] objArr15 = new Object[1];
            b(b2, b3, (byte) (b3 & 40), objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - TextUtils.lastIndexOf("", '0', 0), 4 - View.resolveSize(0, 0), (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                    Object[] objArr17 = new Object[1];
                    c((byte) (-$$a[53]), (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr17);
                    obj3 = cls5.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0'), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 35, (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr19 = {143288042, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, Color.rgb(0, 0, 0) + 16777234, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(18222 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{4790, 21910, 40173, 50984, 3588, 29013, 47529, 57520, 11214, 37376, 54641, 7676, 17570, 36823, 63025, 14719, 24657, 43169, 5101, 23251, 40239, 50276, 3247, 30603, 48862, 57636}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((ViewConfiguration.getScrollBarSize() >> 8) + 40739, new char[]{4788, 36225, 11491, 53196, 28222, 2326, 43121, 19299, 60351, 35484, 9701, 50239, 26384, 1649, 41289, 16819, 57480, 33770}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 18 - View.resolveSizeAndState(0, 0, 0), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.friendship_block).substring(0, 3).length() + 18220, new char[]{4790, 21910, 40173, 50984, 3588, 29013, 47529, 57520, 11214, 37376, 54641, 7676, 17570, 36823, 63025, 14719, 24657, 43169, 5101, 23251, 40239, 50276, 3247, 30603, 48862, 57636}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(40739 - Color.green(0), new char[]{4788, 36225, 11491, 53196, 28222, 2326, 43121, 19299, 60351, 35484, 9701, 50239, 26384, 1649, 41289, 16819, 57480, 33770}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetAfter("", 0), 18 - Color.argb(0, 0, 0, 0), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getFamilyDashboardPresenter")
    public final FamilyDashboardContract.Presenter getFamilyDashboardPresenter() {
        FamilyDashboardContract.Presenter presenter = this.familyDashboardPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFamilyDashboardPresenter")
    public final void setFamilyDashboardPresenter(FamilyDashboardContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.familyDashboardPresenter = presenter;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityFamilyAccountDashboardMemberBinding inflateViewBinding() {
        ActivityFamilyAccountDashboardMemberBinding PlaceComponentResult = ActivityFamilyAccountDashboardMemberBinding.PlaceComponentResult(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        initComponent();
        RecyclerView recyclerView = getBinding().getErrorConfigVersion;
        FamilyDashboardServicesAdapter familyDashboardServicesAdapter = new FamilyDashboardServicesAdapter();
        recyclerView.setAdapter(familyDashboardServicesAdapter);
        this.getAuthRequestContext = familyDashboardServicesAdapter;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        this.KClassImpl$Data$declaredNonStaticMembers$2 = ShimmeringUtil.PlaceComponentResult(getBinding().MyBillsEntityDataFactory, R.layout.view_family_account_manage_skeleton);
        getFamilyDashboardPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        getFamilyDashboardPresenter().BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        DaggerFamilyAccountDashboardComponent.Builder MyBillsEntityDataFactory = DaggerFamilyAccountDashboardComponent.MyBillsEntityDataFactory();
        Application application = getApplication();
        DanaApplication danaApplication = application instanceof DanaApplication ? (DanaApplication) application : null;
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(danaApplication != null ? danaApplication.getApplicationComponent() : null);
        MyBillsEntityDataFactory.getAuthRequestContext = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(new BottomSheetOnBoardingModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.familyaccount.view.dashboard.MemberDashboardActivity$getBottomSheetOnBoardingModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str) {
                BottomSheetOnBoardingContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str, String str2) {
                BottomSheetOnBoardingContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }
        }));
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (FamilyAccountDashboardModule) Preconditions.getAuthRequestContext(new FamilyAccountDashboardModule(new FamilyDashboardContract.View() { // from class: id.dana.familyaccount.view.dashboard.MemberDashboardActivity$getFamilyDashboardModule$1
            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
                FamilyDashboardContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MaxMemberLimitConfig maxMemberLimitConfig) {
                FamilyDashboardContract.View.CC.getAuthRequestContext(maxMemberLimitConfig);
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(String str) {
                FamilyDashboardContract.View.CC.BuiltInFictitiousFunctionClassFactory(str);
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
                FamilyDashboardContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
                FamilyDashboardContract.View.CC.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory() {
                FamilyDashboardContract.View.CC.getErrorConfigVersion();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(TopUpUserConsultModel topUpUserConsultModel) {
                Intrinsics.checkNotNullParameter(topUpUserConsultModel, "");
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(String str) {
                FamilyDashboardContract.View.CC.moveToNextValue();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(List list) {
                FamilyDashboardContract.View.CC.MyBillsEntityDataFactory(list);
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void PlaceComponentResult() {
                FamilyDashboardContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void PlaceComponentResult(String str) {
                FamilyDashboardContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void getAuthRequestContext(String str) {
                FamilyDashboardContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void getErrorConfigVersion() {
                FamilyDashboardContract.View.CC.scheduleImpl();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void moveToNextValue() {
                FamilyDashboardContract.View.CC.NetworkUserEntityData$$ExternalSyntheticLambda1();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void scheduleImpl() {
                FamilyDashboardContract.View.CC.lookAheadTest();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void MyBillsEntityDataFactory(DashboardModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MemberDashboardActivity.access$loadDashboardData(MemberDashboardActivity.this, p0);
                MemberDashboardActivity.access$showDashboard(MemberDashboardActivity.this);
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void getAuthRequestContext() {
                MemberDashboardActivity.access$setViewStatusInformation(MemberDashboardActivity.this);
                MemberDashboardActivity.access$hideDashboard(MemberDashboardActivity.this);
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<AvailableServicesConfig> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MemberDashboardActivity.access$setItemsAvailableServices(MemberDashboardActivity.this, p0);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                MemberDashboardActivity.access$showShimmerView(MemberDashboardActivity.this);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                MemberDashboardActivity.access$dismissShimmerView(MemberDashboardActivity.this);
            }
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory().getAuthRequestContext(this);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        getFamilyDashboardPresenter().onDestroy();
        super.onDestroy();
    }

    public static /* synthetic */ void $r8$lambda$d9LIwgKRPMDwMKOBhe_YBdklBFo(MemberDashboardActivity memberDashboardActivity, View view) {
        Intrinsics.checkNotNullParameter(memberDashboardActivity, "");
        memberDashboardActivity.getFamilyDashboardPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        StatusInformationView statusInformationView = memberDashboardActivity.getBinding().DatabaseTableConfigUtil;
        Intrinsics.checkNotNullExpressionValue(statusInformationView, "");
        statusInformationView.setVisibility(8);
    }

    public static /* synthetic */ void $r8$lambda$tIIg4ji6aMza3NPnxdNhYqg5hXI(MemberDashboardActivity memberDashboardActivity, View view) {
        Intrinsics.checkNotNullParameter(memberDashboardActivity, "");
        memberDashboardActivity.finish();
    }

    public static final /* synthetic */ void access$dismissShimmerView(MemberDashboardActivity memberDashboardActivity) {
        SkeletonScreen skeletonScreen = memberDashboardActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    public static final /* synthetic */ void access$hideDashboard(MemberDashboardActivity memberDashboardActivity) {
        ConstraintLayout constraintLayout = memberDashboardActivity.getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(8);
        StatusInformationView statusInformationView = memberDashboardActivity.getBinding().DatabaseTableConfigUtil;
        Intrinsics.checkNotNullExpressionValue(statusInformationView, "");
        statusInformationView.setVisibility(0);
    }

    public static final /* synthetic */ void access$loadDashboardData(final MemberDashboardActivity memberDashboardActivity, DashboardModel dashboardModel) {
        String authRequestContext = memberDashboardActivity.getFamilyDashboardPresenter().getAuthRequestContext();
        for (FamilyMemberInfoModel familyMemberInfoModel : dashboardModel.MyBillsEntityDataFactory) {
            if (Intrinsics.areEqual(familyMemberInfoModel.getAuthRequestContext.scheduleImpl, authRequestContext)) {
                ManageFamilyView manageFamilyView = memberDashboardActivity.getBinding().initRecordTimeStamp;
                if (manageFamilyView != null) {
                    manageFamilyView.setManageFamilyType(familyMemberInfoModel);
                }
                memberDashboardActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.initMemberDashboardLimitSection(familyMemberInfoModel.KClassImpl$Data$declaredNonStaticMembers$2);
                memberDashboardActivity.getFamilyDashboardPresenter().KClassImpl$Data$declaredNonStaticMembers$2(familyMemberInfoModel.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
            }
        }
        final List<FamilyMemberInfoModel> list = dashboardModel.MyBillsEntityDataFactory;
        ViewMemberDashboardSectionListOfBinding viewMemberDashboardSectionListOfBinding = memberDashboardActivity.getBinding().lookAheadTest;
        TextView textView = viewMemberDashboardSectionListOfBinding.scheduleImpl;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = memberDashboardActivity.getString(R.string.section_list_of_family_desc);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Object[] objArr = new Object[1];
        String str = list.get(0).getAuthRequestContext.getAuthRequestContext;
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, (char) InputCardNumberView.DIVIDER, 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1) {
            str = str.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(str, "");
        }
        if (str.length() > 0) {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            StringBuilder sb = new StringBuilder();
            sb.append(upperCase);
            sb.append(substring);
            str = sb.toString();
        }
        objArr[0] = str;
        String format = String.format(string, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        textView.setText(format);
        ConstraintLayout constraintLayout = viewMemberDashboardSectionListOfBinding.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        SafeClickListenerExtensionKt.MyBillsEntityDataFactory(constraintLayout, new Function1<View, Unit>() { // from class: id.dana.familyaccount.view.dashboard.MemberDashboardActivity$setSectionListOfFamily$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                MemberDashboardActivity memberDashboardActivity2 = MemberDashboardActivity.this;
                FamilyMembersActivity.Companion companion = FamilyMembersActivity.INSTANCE;
                Context applicationContext = MemberDashboardActivity.this.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "");
                memberDashboardActivity2.startActivity(FamilyMembersActivity.Companion.MyBillsEntityDataFactory(applicationContext, list));
            }
        });
    }

    public static final /* synthetic */ void access$setItemsAvailableServices(MemberDashboardActivity memberDashboardActivity, List list) {
        FamilyDashboardServicesAdapter familyDashboardServicesAdapter = memberDashboardActivity.getAuthRequestContext;
        if (familyDashboardServicesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            familyDashboardServicesAdapter = null;
        }
        BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(familyDashboardServicesAdapter, list);
        ConstraintLayout constraintLayout = memberDashboardActivity.getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(AvailableServicesConfigKt.isEnableTrueExist(list) ^ true ? 0 : 8);
    }

    public static final /* synthetic */ void access$setViewStatusInformation(final MemberDashboardActivity memberDashboardActivity) {
        StatusInformationView statusInformationView = memberDashboardActivity.getBinding().DatabaseTableConfigUtil;
        statusInformationView.setStatusInformationType(StatusInformationType.GENERAL_STATUS_ERROR);
        DanaButtonPrimaryView btnStatusInformationGotIt = statusInformationView.getBtnStatusInformationGotIt();
        if (btnStatusInformationGotIt != null) {
            btnStatusInformationGotIt.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.dashboard.MemberDashboardActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberDashboardActivity.$r8$lambda$d9LIwgKRPMDwMKOBhe_YBdklBFo(MemberDashboardActivity.this, view);
                }
            });
        }
    }

    public static final /* synthetic */ void access$showDashboard(MemberDashboardActivity memberDashboardActivity) {
        ConstraintLayout constraintLayout = memberDashboardActivity.getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(0);
        StatusInformationView statusInformationView = memberDashboardActivity.getBinding().DatabaseTableConfigUtil;
        Intrinsics.checkNotNullExpressionValue(statusInformationView, "");
        statusInformationView.setVisibility(8);
    }

    public static final /* synthetic */ void access$showShimmerView(MemberDashboardActivity memberDashboardActivity) {
        SkeletonScreen skeletonScreen = memberDashboardActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        LayoutToolbarBinding layoutToolbarBinding = getBinding().PlaceComponentResult;
        TextView textView = layoutToolbarBinding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        ImageView imageView = layoutToolbarBinding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
        layoutToolbarBinding.initRecordTimeStamp.setText(getString(R.string.family_account_text_title_toolbar));
        LayoutToolbarBinding layoutToolbarBinding2 = getBinding().PlaceComponentResult;
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationIcon(R.drawable.btn_arrow_left);
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.dashboard.MemberDashboardActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberDashboardActivity.$r8$lambda$tIIg4ji6aMza3NPnxdNhYqg5hXI(MemberDashboardActivity.this, view);
            }
        });
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(4);
        Toolbar toolbar = layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        int childCount = toolbar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = toolbar.getChildAt(i);
            ImageButton imageButton = childAt instanceof ImageButton ? (ImageButton) childAt : null;
            if (imageButton != null) {
                imageButton.setContentDescription(getResources().getString(R.string.imgBtnLeft));
            }
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (lookAheadTest ^ 4796183387843776835L);
            getonboardingscenario.getAuthRequestContext++;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            getonboardingscenario.getAuthRequestContext++;
        }
        objArr[0] = new String(cArr2);
    }
}

package id.dana.familyaccount.view.memberlimit;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.ActivityFamilyAccountManageLimitBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerFamilyAccountManageComponent;
import id.dana.di.modules.FamilyAccountManageModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.familyaccount.model.AvailableServicesConfig;
import id.dana.domain.familyaccount.model.MaxMemberLimitConfig;
import id.dana.familyaccount.adapter.ManageMemberLimitAdapter;
import id.dana.familyaccount.contract.FamilyManageContract;
import id.dana.familyaccount.model.DashboardModel;
import id.dana.familyaccount.model.FamilyMemberInfoModel;
import id.dana.familyaccount.model.LimitInfoModel;
import id.dana.familyaccount.model.LimitInfoModelKt;
import id.dana.familyaccount.model.SetLimitAndServicesRequestModel;
import id.dana.familyaccount.view.bottomsheet.SetLimitBottomSheet;
import id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.DANAToast;
import id.dana.utils.LocaleUtil;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b3\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0017\u001a\u00020\u0014X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00188\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b!\u0010\u0013R\u0016\u0010\b\u001a\u00020#8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010!\u001a\u00020*8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u0015\u001a\u00020-8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0013\u00102\u001a\u000200X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b1\u0010\u0016"}, d2 = {"Lid/dana/familyaccount/view/memberlimit/ManageMemberLimitActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityFamilyAccountManageLimitBinding;", "", "configToolbar", "()V", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/lang/String;", "inflateViewBinding", "()Lid/dana/databinding/ActivityFamilyAccountManageLimitBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "onBackPressed", "onDestroy", "", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "PlaceComponentResult", "Ljava/util/List;", "Lid/dana/dialog/DanaLoadingDialog;", "getErrorConfigVersion", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/familyaccount/contract/FamilyManageContract$Presenter;", "familyManagePresenter", "Lid/dana/familyaccount/contract/FamilyManageContract$Presenter;", "getFamilyManagePresenter", "()Lid/dana/familyaccount/contract/FamilyManageContract$Presenter;", "setFamilyManagePresenter", "(Lid/dana/familyaccount/contract/FamilyManageContract$Presenter;)V", "", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "scheduleImpl", "BuiltInFictitiousFunctionClassFactory", "", "lookAheadTest", "Z", "Lid/dana/familyaccount/adapter/ManageMemberLimitAdapter;", "DatabaseTableConfigUtil", "Lid/dana/familyaccount/adapter/ManageMemberLimitAdapter;", "MyBillsEntityDataFactory", "Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "initRecordTimeStamp", "Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "", "NetworkUserEntityData$$ExternalSyntheticLambda1", "I", "Lid/dana/familyaccount/view/bottomsheet/SetLimitBottomSheet;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "moveToNextValue", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManageMemberLimitActivity extends BaseViewBindingActivity<ActivityFamilyAccountManageLimitBinding> {
    public static final String AVAILABLE_SERVICES_CONFIG = "AVAILABLE_SERVICES_CONFIG";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char GetContactSyncConfig = 0;
    public static final String MAX_MEMBER_LIMIT_CONFIG = "MAX_MEMBER_LIMIT_CONFIG";
    private static char NetworkUserEntityData$$ExternalSyntheticLambda7;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda8;
    private static char newProxyInstance;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private ManageMemberLimitAdapter MyBillsEntityDataFactory;
    private List<AvailableServicesConfig> PlaceComponentResult;
    @Inject
    public FamilyManageContract.Presenter familyManagePresenter;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private MaxMemberLimitConfig scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private List<FamilyMemberInfoModel> BuiltInFictitiousFunctionClassFactory;
    public static final byte[] $$a = {1, -107, Ascii.ESC, -41, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 80;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {105, 42, 72, -81, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 141;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private int getErrorConfigVersion = -1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy moveToNextValue = LazyKt.lazy(new Function0<SetLimitBottomSheet>() { // from class: id.dana.familyaccount.view.memberlimit.ManageMemberLimitActivity$setLimitBottomSheet$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SetLimitBottomSheet invoke() {
            return new SetLimitBottomSheet();
        }
    });

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.familyaccount.view.memberlimit.ManageMemberLimitActivity$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(ManageMemberLimitActivity.this);
        }
    });

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        newProxyInstance = (char) 34073;
        GetContactSyncConfig = (char) 10449;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = (char) 26844;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = (char) 2376;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r9 = 23 - r9
            int r8 = 106 - r8
            byte[] r0 = id.dana.familyaccount.view.memberlimit.ManageMemberLimitActivity.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 + 4
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L2f
        L15:
            r3 = 0
        L16:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L25:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L2f:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + (-4)
            int r8 = r8 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.memberlimit.ManageMemberLimitActivity.b(int, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.familyaccount.view.memberlimit.ManageMemberLimitActivity.$$a
            int r6 = 47 - r6
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r7 = r7 * 3
            int r7 = r7 + 21
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L36
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L36:
            int r9 = r9 + r6
            int r6 = r7 + 1
            int r7 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.memberlimit.ManageMemberLimitActivity.c(short, byte, short, java.lang.Object[]):void");
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
        a(18 - Color.green(0), new char[]{31335, 49644, 'M', 21454, 52413, 34055, 64089, 11677, 37661, 45556, 58503, 65029, 6868, Typography.rightSingleQuote, 5675, 20304, 62784, 2983}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(4 - ImageFormat.getBitsPerPixel(0), new char[]{35067, 13855, 13148, 18705, 11852, 30298}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), ((Process.getThreadPriority(0) + 20) >> 6) + 35, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((ViewConfiguration.getFadingEdgeLength() >> 16) + 48, new char[]{16927, 53357, 32074, 52628, 17121, 6186, 2923, 37419, 21070, 38148, 15419, 50595, 56027, 42514, 13243, 28360, 65429, 60834, 12923, 16521, 27847, 7522, 32652, 27765, 47030, 28687, 27251, 4689, 45378, 46695, 32446, 46110, 38988, 57211, 32665, 8631, 59817, 13090, 55396, 12801, 23468, 21392, 6515, 21993, 37603, 59607, 65155, 10261}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(64 - Color.red(0), new char[]{10548, 36163, 20916, 50722, 59817, 13090, 14637, 45274, 27847, 7522, 6551, 13792, 9181, 53966, 42459, 13369, 43040, 60461, 30707, 27125, 9181, 53966, 61162, 23046, 30709, 35987, 6419, 32269, 27251, 4689, 43040, 60461, 29175, 36097, 45489, 27570, 27005, 50920, 31665, 12352, 6299, 11173, 29159, 38368, 14056, 26250, 55858, 20066, 11433, 30698, 35651, 25256, 33238, 35537, 18499, 53284, 18499, 53284, 50533, 462, 59217, 38373, 47030, 28687}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(64 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new char[]{3386, 32330, 24280, 7956, 33238, 35537, 36583, 28317, 14365, 56184, 3316, 59569, 29572, 63882, 19589, 16211, 32446, 46110, 14938, 24179, 11171, 33284, 54262, 57127, 23468, 21392, 2923, 37419, 14201, 30017, 16927, 53357, 34203, 41255, 12735, 12906, 22052, 15471, 32074, 52628, 65237, 53930, 42459, 13369, 55396, 12801, 35057, 35298, 59817, 13090, 5675, 20304, 3386, 32330, 'X', 12027, 21127, 49340, 38988, 57211, 'X', 12027, 63582, 56245}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(TextUtils.indexOf("", "", 0) + 60, new char[]{37780, 60720, 56212, 418, 20484, 2011, 19346, 54620, 36458, 22824, 29439, 22801, 50028, 53753, 23446, 35265, 21002, 46644, 47088, 9047, 53095, 64144, 48943, 36652, 35637, 36180, 35556, 28435, 43260, 18046, 47187, 8174, 35556, 28435, 29679, 41232, 29192, 37309, 39858, 14488, 5637, 11300, 51010, 28434, 36217, 57697, 33502, 56410, 31121, 28538, 37664, 8906, 22479, 35149, 11789, 20826, 26137, 12117, 54520, 5704}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 6, new char[]{59673, 43154, 41285, 55452, 3386, 32330}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - Process.getGidForName(""), 18 - Gravity.getAbsoluteGravity(0, 0), (char) Color.red(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(37, KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[35]), KClassImpl$Data$declaredNonStaticMembers$2[9], KClassImpl$Data$declaredNonStaticMembers$2[30], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - View.MeasureSpec.getSize(0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 3, (char) ((-16777216) - Color.rgb(0, 0, 0)));
                        byte b = $$a[53];
                        byte b2 = $$a[0];
                        Object[] objArr16 = new Object[1];
                        c(b, b2, b2, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.MeasureSpec.getMode(0), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 16, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, AndroidCharacter.getMirror('0') - '!', (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - TextUtils.lastIndexOf("", '0'), 28 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (57993 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.indexOf("", "", 0), Color.argb(0, 0, 0, 0) + 15, (char) (KeyEvent.getMaxKeyCode() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 35, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-740278672, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, 18 - View.combineMeasuredStates(0, 0), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(37, KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[35]), KClassImpl$Data$declaredNonStaticMembers$2[9], KClassImpl$Data$declaredNonStaticMembers$2[30], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 61, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 46, (char) TextUtils.getOffsetBefore("", 0));
                        Object[] objArr22 = new Object[1];
                        c($$a[84], (byte) ($$a[0] - 1), $$a[9], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 35, (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-740278672, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (ViewConfiguration.getScrollBarSize() >> 8) + 18, (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(37, KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[35]), KClassImpl$Data$declaredNonStaticMembers$2[9], KClassImpl$Data$declaredNonStaticMembers$2[30], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 118, ExpandableListView.getPackedPositionGroup(0L) + 3, (char) (KeyEvent.getDeadChar(0, 0) + 38968));
                        Object[] objArr28 = new Object[1];
                        c($$a[84], (byte) ($$a[0] - 1), $$a[9], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, View.getDefaultSize(0, 0) + 35, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-740278672, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 910, 18 - TextUtils.indexOf("", "", 0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(37, KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[35]), KClassImpl$Data$declaredNonStaticMembers$2[9], KClassImpl$Data$declaredNonStaticMembers$2[30], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 107, TextUtils.lastIndexOf("", '0', 0, 0) + 4, (char) ExpandableListView.getPackedPositionGroup(0L));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[0] - 1), $$a[8], (byte) ($$a[0] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-740278672, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), TextUtils.getOffsetAfter("", 0) + 18, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        a(getPackageName().length() + 11, new char[]{31335, 49644, 'M', 21454, 52413, 34055, 64089, 11677, 37661, 45556, 58503, 65029, 6868, Typography.rightSingleQuote, 5675, 20304, 62784, 2983}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(super.getResources().getString(R.string.pocket_voucher_value).substring(0, 9).codePointAt(5) - 41, new char[]{35067, 13855, 13148, 18705, 11852, 30298}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(Color.red(0) + 26, new char[]{31335, 49644, 'M', 21454, 52413, 34055, 64089, 11677, 5637, 11300, 19026, 32802, 44673, 60771, 51426, 41129, 37881, 42068, 43774, 18527, 44097, 46046, 41372, 23158, 55106, 42326}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(super.getResources().getString(R.string.blocked_contacts_label).substring(9, 10).codePointAt(0) - 93, new char[]{4037, 20811, 5250, 4763, 26137, 12117, 53276, 40531, 16438, 16375, 63579, 49271, 14130, 9657, 51426, 41129, 39491, 24662}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(super.getResources().getString(R.string.sendmoney_recent_search_hint).substring(4, 5).codePointAt(0) + 16, new char[]{16927, 53357, 32074, 52628, 17121, 6186, 2923, 37419, 21070, 38148, 15419, 50595, 56027, 42514, 13243, 28360, 65429, 60834, 12923, 16521, 27847, 7522, 32652, 27765, 47030, 28687, 27251, 4689, 45378, 46695, 32446, 46110, 38988, 57211, 32665, 8631, 59817, 13090, 55396, 12801, 23468, 21392, 6515, 21993, 37603, 59607, 65155, 10261}, objArr6);
                    String str = (String) objArr6[0];
                    try {
                        Object[] objArr7 = new Object[1];
                        b(KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr7);
                        Class<?> cls3 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        b((byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), KClassImpl$Data$declaredNonStaticMembers$2[48], KClassImpl$Data$declaredNonStaticMembers$2[41], objArr8);
                        Object[] objArr9 = new Object[1];
                        a(((ApplicationInfo) cls3.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 31, new char[]{10548, 36163, 20916, 50722, 59817, 13090, 14637, 45274, 27847, 7522, 6551, 13792, 9181, 53966, 42459, 13369, 43040, 60461, 30707, 27125, 9181, 53966, 61162, 23046, 30709, 35987, 6419, 32269, 27251, 4689, 43040, 60461, 29175, 36097, 45489, 27570, 27005, 50920, 31665, 12352, 6299, 11173, 29159, 38368, 14056, 26250, 55858, 20066, 11433, 30698, 35651, 25256, 33238, 35537, 18499, 53284, 18499, 53284, 50533, 462, 59217, 38373, 47030, 28687}, objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(64 - View.MeasureSpec.getSize(0), new char[]{3386, 32330, 24280, 7956, 33238, 35537, 36583, 28317, 14365, 56184, 3316, 59569, 29572, 63882, 19589, 16211, 32446, 46110, 14938, 24179, 11171, 33284, 54262, 57127, 23468, 21392, 2923, 37419, 14201, 30017, 16927, 53357, 34203, 41255, 12735, 12906, 22052, 15471, 32074, 52628, 65237, 53930, 42459, 13369, 55396, 12801, 35057, 35298, 59817, 13090, 5675, 20304, 3386, 32330, 'X', 12027, 21127, 49340, 38988, 57211, 'X', 12027, 63582, 56245}, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(getPackageName().codePointAt(0) - 45, new char[]{37780, 60720, 56212, 418, 20484, 2011, 19346, 54620, 36458, 22824, 29439, 22801, 50028, 53753, 23446, 35265, 21002, 46644, 47088, 9047, 53095, 64144, 48943, 36652, 35637, 36180, 35556, 28435, 43260, 18046, 47187, 8174, 35556, 28435, 29679, 41232, 29192, 37309, 39858, 14488, 5637, 11300, 51010, 28434, 36217, 57697, 33502, 56410, 31121, 28538, 37664, 8906, 22479, 35149, 11789, 20826, 26137, 12117, 54520, 5704}, objArr11);
                        String str4 = (String) objArr11[0];
                        try {
                            Object[] objArr12 = new Object[1];
                            b(KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr12);
                            Class<?> cls4 = Class.forName((String) objArr12[0]);
                            b((byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), KClassImpl$Data$declaredNonStaticMembers$2[48], KClassImpl$Data$declaredNonStaticMembers$2[41], new Object[1]);
                            Object[] objArr13 = new Object[1];
                            a(((ApplicationInfo) cls4.getMethod((String) r0[0], null).invoke(this, null)).targetSdkVersion - 27, new char[]{59673, 43154, 41285, 55452, 3386, 32330}, objArr13);
                            try {
                                Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (Process.myTid() >> 22) + 18, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr14);
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
            b(37, KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[30], objArr15);
            Class<?> cls5 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[35]), KClassImpl$Data$declaredNonStaticMembers$2[9], KClassImpl$Data$declaredNonStaticMembers$2[30], objArr16);
            try {
                Object[] objArr17 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - View.resolveSize(0, 0), 4 - TextUtils.indexOf("", ""), (char) (AndroidCharacter.getMirror('0') - '0'));
                    Object[] objArr18 = new Object[1];
                    c((byte) ($$a[0] - 1), $$a[8], (byte) ($$a[0] - 1), objArr18);
                    obj3 = cls6.getMethod((String) objArr18[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr19 = (Object[]) ((Method) obj3).invoke(null, objArr17);
                int i = ((int[]) objArr19[1])[0];
                if (((int[]) objArr19[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 35, (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr20 = {878953105, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().codePointAt(5) - 84, new char[]{31335, 49644, 'M', 21454, 52413, 34055, 64089, 11677, 5637, 11300, 19026, 32802, 44673, 60771, 51426, 41129, 37881, 42068, 43774, 18527, 44097, 46046, 41372, 23158, 55106, 42326}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                b(KClassImpl$Data$declaredNonStaticMembers$2[25], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b((byte) (KClassImpl$Data$declaredNonStaticMembers$2[49] - 1), KClassImpl$Data$declaredNonStaticMembers$2[48], KClassImpl$Data$declaredNonStaticMembers$2[41], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(((ApplicationInfo) cls2.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{4037, 20811, 5250, 4763, 26137, 12117, 53276, 40531, 16438, 16375, 63579, 49271, 14130, 9657, 51426, 41129, 39491, 24662}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 910, ImageFormat.getBitsPerPixel(0) + 19, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            a(super.getResources().getString(R.string.voucher_ticket_tooltip_title).substring(1, 2).length() + 25, new char[]{31335, 49644, 'M', 21454, 52413, 34055, 64089, 11677, 5637, 11300, 19026, 32802, 44673, 60771, 51426, 41129, 37881, 42068, 43774, 18527, 44097, 46046, 41372, 23158, 55106, 42326}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(getPackageName().length() + 11, new char[]{4037, 20811, 5250, 4763, 26137, 12117, 53276, 40531, 16438, 16375, 63579, 49271, 14130, 9657, 51426, 41129, 39491, 24662}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 930, 35 - Color.alpha(0), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getMode(0), 18 - TextUtils.getTrimmedLength(""), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getFamilyManagePresenter")
    public final FamilyManageContract.Presenter getFamilyManagePresenter() {
        FamilyManageContract.Presenter presenter = this.familyManagePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFamilyManagePresenter")
    public final void setFamilyManagePresenter(FamilyManageContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.familyManagePresenter = presenter;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityFamilyAccountManageLimitBinding inflateViewBinding() {
        ActivityFamilyAccountManageLimitBinding MyBillsEntityDataFactory = ActivityFamilyAccountManageLimitBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        DaggerFamilyAccountManageComponent.Builder authRequestContext = DaggerFamilyAccountManageComponent.getAuthRequestContext();
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        authRequestContext.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        authRequestContext.PlaceComponentResult = (FamilyAccountManageModule) Preconditions.getAuthRequestContext(new FamilyAccountManageModule(new FamilyManageContract.View() { // from class: id.dana.familyaccount.view.memberlimit.ManageMemberLimitActivity$getFamilyManageModule$1
            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
                FamilyManageContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3) {
                FamilyManageContract.View.CC.getAuthRequestContext(str, str2, str3);
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory() {
                FamilyManageContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final /* synthetic */ void PlaceComponentResult() {
                FamilyManageContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final /* synthetic */ void getAuthRequestContext() {
                FamilyManageContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final /* synthetic */ void getAuthRequestContext(String str, String str2) {
                FamilyManageContract.View.CC.BuiltInFictitiousFunctionClassFactory(str, str2);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                DanaLoadingDialog access$getDanaLoadingDialog = ManageMemberLimitActivity.access$getDanaLoadingDialog(ManageMemberLimitActivity.this);
                if (access$getDanaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                    return;
                }
                access$getDanaLoadingDialog.MyBillsEntityDataFactory.show();
                access$getDanaLoadingDialog.getAuthRequestContext.startRefresh();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                ManageMemberLimitActivity.access$getDanaLoadingDialog(ManageMemberLimitActivity.this).PlaceComponentResult();
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, SetLimitAndServicesRequestModel p1) {
                Intrinsics.checkNotNullParameter(p1, "");
                ManageMemberLimitActivity.access$handleSetLimitSuccess(ManageMemberLimitActivity.this, p0, p1);
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                ManageMemberLimitActivity.this.getAuthRequestContext();
            }
        }));
        authRequestContext.PlaceComponentResult().MyBillsEntityDataFactory(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext() {
        DANAToast dANAToast = DANAToast.PlaceComponentResult;
        String string = getResources().getString(R.string.family_member_transaction_limit_failed_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        DANAToast.PlaceComponentResult(this, string);
    }

    private static String getAuthRequestContext(String p0) {
        String str = p0;
        if (str.length() == 0) {
            str = "Rp";
        }
        return str;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        getFamilyManagePresenter().onDestroy();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.getAuthRequestContext) {
            setResult(-1);
        }
        finish();
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010"}, d2 = {"Lid/dana/familyaccount/view/memberlimit/ManageMemberLimitActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/familyaccount/model/DashboardModel;", "p1", "", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "p2", "Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "p3", "Landroid/content/Intent;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Lid/dana/familyaccount/model/DashboardModel;Ljava/util/List;Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;)Landroid/content/Intent;", "", "AVAILABLE_SERVICES_CONFIG", "Ljava/lang/String;", "MAX_MEMBER_LIMIT_CONFIG", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent BuiltInFictitiousFunctionClassFactory(Context p0, DashboardModel p1, List<AvailableServicesConfig> p2, MaxMemberLimitConfig p3) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intent intent = new Intent(p0, ManageMemberLimitActivity.class);
            intent.putExtra("DASHBOARD_MODEL", p1);
            intent.putParcelableArrayListExtra("AVAILABLE_SERVICES_CONFIG", new ArrayList<>(p2));
            intent.putExtra("MAX_MEMBER_LIMIT_CONFIG", p3);
            return intent;
        }
    }

    public static /* synthetic */ void $r8$lambda$pKoXB_p2OflIrMLV7IrsRNkET54(ManageMemberLimitActivity manageMemberLimitActivity, View view) {
        Intrinsics.checkNotNullParameter(manageMemberLimitActivity, "");
        manageMemberLimitActivity.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ DanaLoadingDialog access$getDanaLoadingDialog(ManageMemberLimitActivity manageMemberLimitActivity) {
        return (DanaLoadingDialog) manageMemberLimitActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ SetLimitBottomSheet access$getSetLimitBottomSheet(ManageMemberLimitActivity manageMemberLimitActivity) {
        return (SetLimitBottomSheet) manageMemberLimitActivity.moveToNextValue.getValue();
    }

    public static final /* synthetic */ void access$handleSetLimitSuccess(ManageMemberLimitActivity manageMemberLimitActivity, boolean z, SetLimitAndServicesRequestModel setLimitAndServicesRequestModel) {
        String format;
        if (z) {
            DANAToast dANAToast = DANAToast.PlaceComponentResult;
            String string = manageMemberLimitActivity.getResources().getString(R.string.family_member_transaction_limit_success_message);
            Intrinsics.checkNotNullExpressionValue(string, "");
            DANAToast.getAuthRequestContext(manageMemberLimitActivity, string);
            ((SetLimitBottomSheet) manageMemberLimitActivity.moveToNextValue.getValue()).dismiss();
            List<FamilyMemberInfoModel> list = manageMemberLimitActivity.BuiltInFictitiousFunctionClassFactory;
            ManageMemberLimitAdapter manageMemberLimitAdapter = null;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                list = null;
            }
            FamilyMemberInfoModel familyMemberInfoModel = list.get(manageMemberLimitActivity.getErrorConfigVersion);
            List<FamilyMemberInfoModel> list2 = manageMemberLimitActivity.BuiltInFictitiousFunctionClassFactory;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                list2 = null;
            }
            FamilyMemberInfoModel familyMemberInfoModel2 = list2.get(manageMemberLimitActivity.getErrorConfigVersion);
            List<String> list3 = setLimitAndServicesRequestModel.PlaceComponentResult;
            format = NumberFormat.getNumberInstance(LocaleUtil.getAuthRequestContext()).format((long) Integer.parseInt(setLimitAndServicesRequestModel.KClassImpl$Data$declaredNonStaticMembers$2));
            Intrinsics.checkNotNullExpressionValue(format, "");
            LimitInfoModel limitInfoModel = new LimitInfoModel(list3, new MoneyViewModel(format, getAuthRequestContext(familyMemberInfoModel.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2), getAuthRequestContext(familyMemberInfoModel.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext)));
            Intrinsics.checkNotNullParameter(limitInfoModel, "");
            familyMemberInfoModel2.KClassImpl$Data$declaredNonStaticMembers$2 = limitInfoModel;
            ManageMemberLimitAdapter manageMemberLimitAdapter2 = manageMemberLimitActivity.MyBillsEntityDataFactory;
            if (manageMemberLimitAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                manageMemberLimitAdapter = manageMemberLimitAdapter2;
            }
            manageMemberLimitAdapter.notifyItemChanged(manageMemberLimitActivity.getErrorConfigVersion);
            manageMemberLimitActivity.getAuthRequestContext = true;
            return;
        }
        manageMemberLimitActivity.getAuthRequestContext();
    }

    public static final /* synthetic */ void access$setMemberLimit(ManageMemberLimitActivity manageMemberLimitActivity, String str) {
        List<AvailableServicesConfig> list = manageMemberLimitActivity.PlaceComponentResult;
        List<FamilyMemberInfoModel> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            list = null;
        }
        List<AvailableServicesConfig> list3 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        Iterator<T> it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(((AvailableServicesConfig) it.next()).getUseCase());
        }
        ArrayList arrayList2 = arrayList;
        List<FamilyMemberInfoModel> list4 = manageMemberLimitActivity.BuiltInFictitiousFunctionClassFactory;
        if (list4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            list2 = list4;
        }
        FamilyMemberInfoModel familyMemberInfoModel = list2.get(manageMemberLimitActivity.getErrorConfigVersion);
        if (!LimitInfoModelKt.BuiltInFictitiousFunctionClassFactory(familyMemberInfoModel.KClassImpl$Data$declaredNonStaticMembers$2)) {
            arrayList2 = familyMemberInfoModel.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
        }
        manageMemberLimitActivity.getFamilyManagePresenter().MyBillsEntityDataFactory(new SetLimitAndServicesRequestModel(familyMemberInfoModel.getAuthRequestContext.scheduleImpl, arrayList2, str));
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
        layoutToolbarBinding.initRecordTimeStamp.setText(getString(R.string.family_account_text_month_transaction_limit_title));
        LayoutToolbarBinding layoutToolbarBinding2 = getBinding().PlaceComponentResult;
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationIcon(R.drawable.btn_arrow_left);
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.memberlimit.ManageMemberLimitActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageMemberLimitActivity.$r8$lambda$pKoXB_p2OflIrMLV7IrsRNkET54(ManageMemberLimitActivity.this, view);
            }
        });
        Toolbar toolbar = layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        for (View view : ViewGroupKt.BuiltInFictitiousFunctionClassFactory(toolbar)) {
            ImageButton imageButton = view instanceof ImageButton ? (ImageButton) view : null;
            if (imageButton != null) {
                imageButton.setContentDescription(getResources().getString(R.string.imgBtnLeft));
            }
        }
        TextView textView2 = layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(4);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            DashboardModel dashboardModel = (DashboardModel) extras.getParcelable("DASHBOARD_MODEL");
            if (dashboardModel != null) {
                List<FamilyMemberInfoModel> list = dashboardModel.MyBillsEntityDataFactory;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    String str = ((FamilyMemberInfoModel) obj).MyBillsEntityDataFactory;
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "");
                    String upperCase = str.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "");
                    if (Intrinsics.areEqual(upperCase, "MEMBER")) {
                        arrayList.add(obj);
                    }
                }
                this.BuiltInFictitiousFunctionClassFactory = CollectionsKt.toMutableList((Collection) arrayList);
            }
            ArrayList parcelableArrayList = extras.getParcelableArrayList("AVAILABLE_SERVICES_CONFIG");
            if (parcelableArrayList != null) {
                this.PlaceComponentResult = parcelableArrayList;
            }
            MaxMemberLimitConfig maxMemberLimitConfig = (MaxMemberLimitConfig) extras.getParcelable("MAX_MEMBER_LIMIT_CONFIG");
            if (maxMemberLimitConfig != null) {
                this.scheduleImpl = maxMemberLimitConfig;
            }
        }
        RecyclerView recyclerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        ManageMemberLimitAdapter manageMemberLimitAdapter = new ManageMemberLimitAdapter(new Function2<FamilyMemberInfoModel, Integer, Unit>() { // from class: id.dana.familyaccount.view.memberlimit.ManageMemberLimitActivity$setupManageMemberLimitAdapter$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void invoke(FamilyMemberInfoModel familyMemberInfoModel, int i) {
                ManageMemberLimitAdapter manageMemberLimitAdapter2;
                Intrinsics.checkNotNullParameter(familyMemberInfoModel, "");
                SetLimitBottomSheet access$getSetLimitBottomSheet = ManageMemberLimitActivity.access$getSetLimitBottomSheet(ManageMemberLimitActivity.this);
                String cleanAll = NumberUtils.getCleanAll(familyMemberInfoModel.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
                if (cleanAll == null) {
                    cleanAll = "0";
                }
                Long longOrNull = StringsKt.toLongOrNull(cleanAll);
                access$getSetLimitBottomSheet.BuiltInFictitiousFunctionClassFactory = longOrNull != null ? longOrNull.longValue() : 0L;
                ManageMemberLimitActivity.access$getSetLimitBottomSheet(ManageMemberLimitActivity.this).show(ManageMemberLimitActivity.this.getSupportFragmentManager(), OrganizerDashboardActivity.SET_MEMBER_LIMIT);
                manageMemberLimitAdapter2 = ManageMemberLimitActivity.this.MyBillsEntityDataFactory;
                if (manageMemberLimitAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    manageMemberLimitAdapter2 = null;
                }
                manageMemberLimitAdapter2.getAuthRequestContext(i);
                ManageMemberLimitActivity.this.getErrorConfigVersion = i;
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(FamilyMemberInfoModel familyMemberInfoModel, Integer num) {
                invoke(familyMemberInfoModel, num.intValue());
                return Unit.INSTANCE;
            }
        });
        recyclerView.setAdapter(manageMemberLimitAdapter);
        ManageMemberLimitAdapter manageMemberLimitAdapter2 = manageMemberLimitAdapter;
        List<FamilyMemberInfoModel> list2 = this.BuiltInFictitiousFunctionClassFactory;
        MaxMemberLimitConfig maxMemberLimitConfig2 = null;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            list2 = null;
        }
        BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(manageMemberLimitAdapter2, list2);
        this.MyBillsEntityDataFactory = manageMemberLimitAdapter;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), 1));
        SetLimitBottomSheet setLimitBottomSheet = (SetLimitBottomSheet) this.moveToNextValue.getValue();
        MaxMemberLimitConfig maxMemberLimitConfig3 = this.scheduleImpl;
        if (maxMemberLimitConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            maxMemberLimitConfig2 = maxMemberLimitConfig3;
        }
        setLimitBottomSheet.getAuthRequestContext = maxMemberLimitConfig2;
        SetLimitBottomSheet setLimitBottomSheet2 = (SetLimitBottomSheet) this.moveToNextValue.getValue();
        Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: id.dana.familyaccount.view.memberlimit.ManageMemberLimitActivity$setupMemberLimitBottomSheet$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                ManageMemberLimitActivity.access$setMemberLimit(ManageMemberLimitActivity.this, str2);
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        setLimitBottomSheet2.PlaceComponentResult = function1;
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
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda8 ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda7 ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (GetContactSyncConfig ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (newProxyInstance ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}

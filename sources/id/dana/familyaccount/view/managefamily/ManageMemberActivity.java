package id.dana.familyaccount.view.managefamily;

import android.app.Application;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.ChallengeScenario;
import id.dana.common.DividerItemDecoration;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.ActivityFamilyMemberDetailBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerFamilyAccountManageComponent;
import id.dana.di.modules.FamilyAccountManageModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.familyaccount.model.AvailableServicesConfig;
import id.dana.domain.familyaccount.model.MaxMemberLimitConfig;
import id.dana.familyaccount.adapter.FamilyManageAvailableServicesAdapter;
import id.dana.familyaccount.contract.FamilyManageContract;
import id.dana.familyaccount.model.FamilyMemberInfoModel;
import id.dana.familyaccount.model.LimitInfoModel;
import id.dana.familyaccount.model.LimitInfoModelKt;
import id.dana.familyaccount.model.SetLimitAndServicesRequestModel;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.familyaccount.view.bottomsheet.SetLimitBottomSheet;
import id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity;
import id.dana.familyaccount.view.dialog.FamilyAccountCustomDialog;
import id.dana.familyaccount.view.section.SectionCellView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.DANAToast;
import id.dana.utils.LocaleUtil;
import id.dana.utils.SizeUtil;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\bN\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\b\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0005J)\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001a\u0010\u0005J\r\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001c\u0010\u0005J#\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010#R\u0013\u0010\u001c\u001a\u00020$X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b/\u00100R\"\u00103\u001a\u0002028\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010\b\u001a\u00020\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b=\u0010<R\u0016\u0010%\u001a\u00020?8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u00109\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0013\u0010/\u001a\u00020DX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bE\u0010&R$\u0010M\u001a\u0004\u0018\u00010F8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L"}, d2 = {"Lid/dana/familyaccount/view/managefamily/ManageMemberActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityFamilyMemberDetailBinding;", "", "configToolbar", "()V", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)Ljava/lang/String;", "inflateViewBinding", "()Lid/dana/databinding/ActivityFamilyMemberDetailBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "(Lid/dana/familyaccount/model/FamilyMemberInfoModel;)V", "getAuthRequestContext", "initView", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "onDestroy", "prepareBundle", "BuiltInFictitiousFunctionClassFactory", "", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(ZLjava/lang/String;)V", "", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "Ljava/util/List;", "Lid/dana/dialog/DanaLoadingDialog;", "getErrorConfigVersion", "Lkotlin/Lazy;", "Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "familyAccountAnalyticalTracker", "Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "getFamilyAccountAnalyticalTracker", "()Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "setFamilyAccountAnalyticalTracker", "(Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;)V", "Lid/dana/familyaccount/adapter/FamilyManageAvailableServicesAdapter;", "lookAheadTest", "Lid/dana/familyaccount/adapter/FamilyManageAvailableServicesAdapter;", "MyBillsEntityDataFactory", "Lid/dana/familyaccount/contract/FamilyManageContract$Presenter;", "familyManagePresenter", "Lid/dana/familyaccount/contract/FamilyManageContract$Presenter;", "getFamilyManagePresenter", "()Lid/dana/familyaccount/contract/FamilyManageContract$Presenter;", "setFamilyManagePresenter", "(Lid/dana/familyaccount/contract/FamilyManageContract$Presenter;)V", "scheduleImpl", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "GetContactSyncConfig", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda2", "moveToNextValue", "Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "initRecordTimeStamp", "Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "DatabaseTableConfigUtil", "I", "Lid/dana/familyaccount/view/bottomsheet/SetLimitBottomSheet;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lcom/ethanhua/skeleton/SkeletonScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lcom/ethanhua/skeleton/SkeletonScreen;", "getSkeletonScreen", "()Lcom/ethanhua/skeleton/SkeletonScreen;", "setSkeletonScreen", "(Lcom/ethanhua/skeleton/SkeletonScreen;)V", "skeletonScreen", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManageMemberActivity extends BaseViewBindingActivity<ActivityFamilyMemberDetailBinding> {
    public static final String AVAILABLE_SERVICES_CONFIG = "AVAILABLE_SERVICES_CONFIG";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String FAMILY_MEMBER_INFO_MODEL = "FAMILY_MEMBER_INFO_MODEL";
    public static final String MAX_MEMBER_LIMIT_CONFIG = "MAX_MEMBER_LIMIT_CONFIG";
    private static char NetworkUserEntityData$$ExternalSyntheticLambda8;
    private static int PrepareContext;
    private static long newProxyInstance;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private List<AvailableServicesConfig> getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private SkeletonScreen skeletonScreen;
    @Inject
    public FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker;
    @Inject
    public FamilyManageContract.Presenter familyManagePresenter;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private MaxMemberLimitConfig getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private FamilyManageAvailableServicesAdapter MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private FamilyMemberInfoModel KClassImpl$Data$declaredNonStaticMembers$2;
    public static final byte[] $$a = {11, -83, -14, 91, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 78;
    public static final byte[] getAuthRequestContext = {41, -91, 83, 107, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 95;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy lookAheadTest = LazyKt.lazy(new Function0<SetLimitBottomSheet>() { // from class: id.dana.familyaccount.view.managefamily.ManageMemberActivity$setLimitBottomSheet$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SetLimitBottomSheet invoke() {
            return new SetLimitBottomSheet();
        }
    });

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.familyaccount.view.managefamily.ManageMemberActivity$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(ManageMemberActivity.this);
        }
    });

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private int scheduleImpl = -1;

    public static /* synthetic */ void $r8$lambda$QV11_Luo_QSsDvzj7zsFYitUmmg(View view) {
    }

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    private static void b(byte b, byte b2, int i, Object[] objArr) {
        byte[] bArr = getAuthRequestContext;
        int i2 = b + 97;
        int i3 = 23 - i;
        int i4 = 55 - b2;
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            i2 = (i2 + (-i6)) - 4;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i2;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i4++;
            Object[] objArr2 = objArr;
            int i8 = i6;
            byte[] bArr3 = bArr2;
            byte[] bArr4 = bArr;
            i2 = (i2 + (-bArr[i4])) - 4;
            i6 = i8;
            objArr = objArr2;
            bArr = bArr4;
            bArr2 = bArr3;
            i5 = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x002a -> B:35:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.familyaccount.view.managefamily.ManageMemberActivity.$$a
            int r6 = r6 * 2
            int r6 = r6 + 75
            int r7 = r7 + 4
            int r8 = r8 * 3
            int r8 = 42 - r8
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
            goto L34
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L34:
            int r7 = r7 + r6
            int r6 = r7 + (-7)
            int r7 = r8 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.managefamily.ManageMemberActivity.c(short, int, int, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        NetworkUserEntityData$$ExternalSyntheticLambda8 = (char) 37247;
        newProxyInstance = 4360990799332652212L;
        PrepareContext = -956812108;
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
        a(new char[]{0, 0, 0, 0}, new char[]{5240, 59822, 27036, 32821}, View.getDefaultSize(0, 0), (char) (TextUtils.getTrimmedLength("") + 13673), new char[]{48794, 46346, 364, 38757, 57156, 5151, 38767, 10812, 40594, 51350, 44494, 962, 36591, 44185, 10628, 1860, 44039, 24252}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(new char[]{0, 0, 0, 0}, new char[]{34623, 61604, 57195, 26851}, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1810932871, (char) (58335 - TextUtils.indexOf("", "")), new char[]{34434, 2506, 55966, 2308, 45978}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Drawable.resolveOpacity(0, 0), 35 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{60762, 58253, 44102, 28160}, TextUtils.getCapsMode("", 0, 0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), new char[]{48919, 4946, 33576, 6359, 20860, 44694, 27980, 61162, 5913, 3230, 42398, 59747, 52027, 60198, 57193, 48075, 50128, 42571, 59924, 56916, 32245, 39628, 44426, 63401, 22955, 31894, 37291, 60599, 48082, 64364, 61425, 24933, 62532, 35733, 1041, 64940, 52407, 32701, 42270, 23491, 53329, 8969, 57607, 6806, 54195, 16710, 6687, 59902}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{11199, 25139, 27752, 37942}, View.getDefaultSize(0, 0), (char) (ViewConfiguration.getWindowTouchSlop() >> 8), new char[]{44835, 26864, 47707, 553, 10863, 17232, 42029, 58973, 7821, 18763, 63744, 29773, 30233, 49525, 52229, 39794, 54030, 53046, 15433, 4587, 23985, 56394, 17947, 63279, 30648, 53011, 7663, 60649, 9148, 60052, 11270, 18035, 63285, 45451, 36300, 28299, 10551, 18161, 6089, 50895, 19020, 29853, 26596, 23078, 4494, 17353, 19124, 11903, 55720, 45525, 23810, 51227, 31516, 48447, 60564, 50404, 18654, 6589, 57685, 27770, 60775, 15000, 29220, 15871}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{31861, 29090, 32938, 35887}, ViewConfiguration.getWindowTouchSlop() >> 8, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new char[]{51889, 59625, 63620, 4496, 31986, 38433, 26792, 40230, 30528, 40182, 15888, 36161, 12324, 24917, 6589, 63157, 10513, 18058, 25213, 533, 38923, 6097, 42853, 52411, 29849, 46667, 56162, 41412, 65085, 18996, 7351, 12141, 34858, 31806, 34709, 55915, 5693, 51973, 25948, 61981, 61323, 16333, 37675, 23575, 63435, 44610, 24367, 37075, 7638, 40406, 2832, 62600, 39499, 13977, 52915, 41917, 36158, 52372, 13933, 62994, 1185, 44288, 56359, 32816}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{36586, 49522, 9272, 45212}, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), new char[]{63494, 21957, 58305, 24738, 14327, 10404, 32374, 64810, 11252, 29071, 48908, 49984, 736, 15072, 9781, 58382, 18381, 17517, 48925, 24264, 23810, 61205, 28872, 23930, 10577, 4294, 14323, 562, 49383, 57257, 53410, 5678, 40174, 11244, 8664, 33313, 61874, 55816, 13063, 23277, 50773, 11270, 51948, 53429, 63631, 2532, 45096, 5861, 52839, 41157, 36664, 2743, 61331, 18851, 36741, 5226, 33493, 55400, 14207, 22276}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{57063, 22434, 61362, 7881}, ViewConfiguration.getScrollDefaultDelay() >> 16, (char) (51694 - MotionEvent.axisFromString("")), new char[]{11805, 47263, 6042, 14603, 24948, 58056}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 911, (ViewConfiguration.getTapTimeout() >> 16) + 18, (char) Color.argb(0, 0, 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (PlaceComponentResult & 40);
                Object[] objArr14 = new Object[1];
                b(b, (byte) (b | 22), getAuthRequestContext[30], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getPressedStateDuration() >> 16), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 4, (char) Color.alpha(0));
                        byte b2 = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b2, (byte) (b2 - 1), $$a[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), ExpandableListView.getPackedPositionChild(0L) + 16, (char) View.getDefaultSize(0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.lastIndexOf("", '0', 0, 0), 15 - TextUtils.indexOf("", ""), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 29, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 57993))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 800, 15 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 930, TextUtils.indexOf("", "", 0, 0) + 35, (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1978916925, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.argb(0, 0, 0, 0), 17 - ImageFormat.getBitsPerPixel(0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr20 = new Object[1];
                b((byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                byte b3 = (byte) (PlaceComponentResult & 40);
                Object[] objArr21 = new Object[1];
                b(b3, (byte) (b3 | 22), getAuthRequestContext[30], objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 61, 47 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)));
                        Object[] objArr23 = new Object[1];
                        c($$a[9], (byte) ($$a[23] - 1), $$a[8], objArr23);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr25 = {1978916925, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, 18 - ExpandableListView.getPackedPositionGroup(0L), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr27 = new Object[1];
                b((byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                byte b4 = (byte) (PlaceComponentResult & 40);
                Object[] objArr28 = new Object[1];
                b(b4, (byte) (b4 | 22), getAuthRequestContext[30], objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 119, 3 - (ViewConfiguration.getTapTimeout() >> 16), (char) (MotionEvent.axisFromString("") + 38969));
                        Object[] objArr30 = new Object[1];
                        c($$a[9], (byte) ($$a[23] - 1), $$a[8], objArr30);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.indexOf("", "", 0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {1978916925, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 910, TextUtils.lastIndexOf("", '0') + 19, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr34 = new Object[1];
                b((byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                byte b5 = (byte) (PlaceComponentResult & 40);
                Object[] objArr35 = new Object[1];
                b(b5, (byte) (b5 | 22), getAuthRequestContext[30], objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 107, 3 - KeyEvent.keyCodeFromString(""), (char) (Process.getGidForName("") + 1));
                        Object[] objArr37 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[53], (byte) ($$a[78] - 1), objArr37);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, View.resolveSize(0, 0) + 35, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr39 = {1978916925, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0'), 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        char[] cArr = {0, 0, 0, 0};
        char[] cArr2 = {5240, 59822, 27036, 32821};
        try {
            byte b = getAuthRequestContext[25];
            Object[] objArr2 = new Object[1];
            b(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[25], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            b(getAuthRequestContext[5], getAuthRequestContext[25], getAuthRequestContext[41], new Object[1]);
            Object[] objArr3 = new Object[1];
            a(cArr, cArr2, ((ApplicationInfo) cls.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (13672 - ((byte) KeyEvent.getModifierMetaStateMask())), new char[]{48794, 46346, 364, 38757, 57156, 5151, 38767, 10812, 40594, 51350, 44494, 962, 36591, 44185, 10628, 1860, 44039, 24252}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(new char[]{0, 0, 0, 0}, new char[]{34623, 61604, 57195, 26851}, super.getResources().getString(R.string.card_binding_cannot_be_used).substring(1, 3).length() + 1810932869, (char) (getPackageName().length() + 58328), new char[]{34434, 2506, 55966, 2308, 45978}, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{40488, 27393, 11727, 27200}, super.getResources().getString(R.string.setting_more).substring(0, 1).codePointAt(0) - 80, (char) (super.getResources().getString(R.string.dana_protection_account_secured_title).substring(0, 1).codePointAt(0) + 16364), new char[]{13431, 41440, 46823, 9389, 26145, 11200, 43269, 7847, 7624, 19201, 46101, 64222, 37341, 21836, 10379, 52309, 16123, 27093, 57171, 58858, 36386, 11624, 20666, 60900, 35182, 36925}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{56031, 18053, 39028, 34139}, getPackageName().codePointAt(3) - 100, (char) (getPackageName().codePointAt(2) + 23402), new char[]{9476, 47728, 24647, 58467, 32879, 21212, 61842, 12405, 25457, 59822, 24327, 7282, 45420, 18615, 40351, 56471, 42719, 38278}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        a(new char[]{0, 0, 0, 0}, new char[]{60762, 58253, 44102, 28160}, ImageFormat.getBitsPerPixel(0) + 1, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)), new char[]{48919, 4946, 33576, 6359, 20860, 44694, 27980, 61162, 5913, 3230, 42398, 59747, 52027, 60198, 57193, 48075, 50128, 42571, 59924, 56916, 32245, 39628, 44426, 63401, 22955, 31894, 37291, 60599, 48082, 64364, 61425, 24933, 62532, 35733, 1041, 64940, 52407, 32701, 42270, 23491, 53329, 8969, 57607, 6806, 54195, 16710, 6687, 59902}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        a(new char[]{0, 0, 0, 0}, new char[]{11199, 25139, 27752, 37942}, 1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) KeyEvent.normalizeMetaState(0), new char[]{44835, 26864, 47707, 553, 10863, 17232, 42029, 58973, 7821, 18763, 63744, 29773, 30233, 49525, 52229, 39794, 54030, 53046, 15433, 4587, 23985, 56394, 17947, 63279, 30648, 53011, 7663, 60649, 9148, 60052, 11270, 18035, 63285, 45451, 36300, 28299, 10551, 18161, 6089, 50895, 19020, 29853, 26596, 23078, 4494, 17353, 19124, 11903, 55720, 45525, 23810, 51227, 31516, 48447, 60564, 50404, 18654, 6589, 57685, 27770, 60775, 15000, 29220, 15871}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a(new char[]{0, 0, 0, 0}, new char[]{31861, 29090, 32938, 35887}, ViewConfiguration.getKeyRepeatTimeout() >> 16, (char) (ViewConfiguration.getPressedStateDuration() >> 16), new char[]{51889, 59625, 63620, 4496, 31986, 38433, 26792, 40230, 30528, 40182, 15888, 36161, 12324, 24917, 6589, 63157, 10513, 18058, 25213, 533, 38923, 6097, 42853, 52411, 29849, 46667, 56162, 41412, 65085, 18996, 7351, 12141, 34858, 31806, 34709, 55915, 5693, 51973, 25948, 61981, 61323, 16333, 37675, 23575, 63435, 44610, 24367, 37075, 7638, 40406, 2832, 62600, 39499, 13977, 52915, 41917, 36158, 52372, 13933, 62994, 1185, 44288, 56359, 32816}, objArr9);
                        String str3 = (String) objArr9[0];
                        char[] cArr3 = {0, 0, 0, 0};
                        char[] cArr4 = {36586, 49522, 9272, 45212};
                        int codePointAt = super.getResources().getString(R.string.no_more_feed).substring(10, 11).codePointAt(0) - 32;
                        try {
                            byte b2 = getAuthRequestContext[25];
                            Object[] objArr10 = new Object[1];
                            b(b2, (byte) (b2 | TarHeader.LF_BLK), getAuthRequestContext[25], objArr10);
                            Class<?> cls4 = Class.forName((String) objArr10[0]);
                            b(getAuthRequestContext[5], getAuthRequestContext[25], getAuthRequestContext[41], new Object[1]);
                            Object[] objArr11 = new Object[1];
                            a(cArr3, cArr4, codePointAt, (char) (((ApplicationInfo) cls4.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33), new char[]{63494, 21957, 58305, 24738, 14327, 10404, 32374, 64810, 11252, 29071, 48908, 49984, 736, 15072, 9781, 58382, 18381, 17517, 48925, 24264, 23810, 61205, 28872, 23930, 10577, 4294, 14323, 562, 49383, 57257, 53410, 5678, 40174, 11244, 8664, 33313, 61874, 55816, 13063, 23277, 50773, 11270, 51948, 53429, 63631, 2532, 45096, 5861, 52839, 41157, 36664, 2743, 61331, 18851, 36741, 5226, 33493, 55400, 14207, 22276}, objArr11);
                            String str4 = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            a(new char[]{0, 0, 0, 0}, new char[]{57063, 22434, 61362, 7881}, ((byte) KeyEvent.getModifierMetaStateMask()) + 1, (char) (51695 - Color.argb(0, 0, 0, 0)), new char[]{11805, 47263, 6042, 14603, 24948, 58056}, objArr12);
                            try {
                                Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 18 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) (-getAuthRequestContext[32]), (byte) (-getAuthRequestContext[31]), getAuthRequestContext[30], objArr14);
                Class<?> cls5 = Class.forName((String) objArr14[0]);
                byte b3 = (byte) (PlaceComponentResult & 40);
                Object[] objArr15 = new Object[1];
                b(b3, (byte) (b3 | 22), getAuthRequestContext[30], objArr15);
                try {
                    Object[] objArr16 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 3, (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                        Object[] objArr17 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[53], (byte) ($$a[78] - 1), objArr17);
                        obj3 = cls6.getMethod((String) objArr17[0], Integer.TYPE);
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
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionType(0L), (ViewConfiguration.getTouchSlop() >> 8) + 35, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr19 = {1350542282, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 910, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
            a(new char[]{0, 0, 0, 0}, new char[]{40488, 27393, 11727, 27200}, super.getResources().getString(R.string.personalization_entry_title).substring(1, 2).length() - 1, (char) (super.getResources().getString(R.string.pocket_voucher_amount_transaction).substring(0, 11).length() + 16418), new char[]{13431, 41440, 46823, 9389, 26145, 11200, 43269, 7847, 7624, 19201, 46101, 64222, 37341, 21836, 10379, 52309, 16123, 27093, 57171, 58858, 36386, 11624, 20666, 60900, 35182, 36925}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(new char[]{0, 0, 0, 0}, new char[]{56031, 18053, 39028, 34139}, super.getResources().getString(R.string.loading_pay_qr).substring(0, 10).codePointAt(5) - 110, (char) (super.getResources().getString(R.string.share_activity_loading_description).substring(0, 8).length() + 23440), new char[]{9476, 47728, 24647, 58467, 32879, 21212, 61842, 12405, 25457, 59822, 24327, 7282, 45420, 18615, 40351, 56471, 42719, 38278}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, ((Process.getThreadPriority(0) + 20) >> 6) + 35, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 911, (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            char[] cArr = {0, 0, 0, 0};
            char[] cArr2 = {40488, 27393, 11727, 27200};
            try {
                byte b = getAuthRequestContext[25];
                Object[] objArr = new Object[1];
                b(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b(getAuthRequestContext[5], getAuthRequestContext[25], getAuthRequestContext[41], new Object[1]);
                Object[] objArr2 = new Object[1];
                a(cArr, cArr2, ((ApplicationInfo) cls.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (View.resolveSizeAndState(0, 0, 0) + 16429), new char[]{13431, 41440, 46823, 9389, 26145, 11200, 43269, 7847, 7624, 19201, 46101, 64222, 37341, 21836, 10379, 52309, 16123, 27093, 57171, 58858, 36386, 11624, 20666, 60900, 35182, 36925}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a(new char[]{0, 0, 0, 0}, new char[]{56031, 18053, 39028, 34139}, super.getResources().getString(R.string.paylater_loan_personal_subtitle_due).substring(1, 3).length() - 2, (char) (getPackageName().codePointAt(3) + 23348), new char[]{9476, 47728, 24647, 58467, 32879, 21212, 61842, 12405, 25457, 59822, 24327, 7282, 45420, 18615, 40351, 56471, 42719, 38278}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.red(0), 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 911, 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getFamilyAccountAnalyticalTracker")
    public final FamilyAccountAnalyticalTracker getFamilyAccountAnalyticalTracker() {
        FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker = this.familyAccountAnalyticalTracker;
        if (familyAccountAnalyticalTracker != null) {
            return familyAccountAnalyticalTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFamilyAccountAnalyticalTracker")
    public final void setFamilyAccountAnalyticalTracker(FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker) {
        Intrinsics.checkNotNullParameter(familyAccountAnalyticalTracker, "");
        this.familyAccountAnalyticalTracker = familyAccountAnalyticalTracker;
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

    @JvmName(name = "getSkeletonScreen")
    public final SkeletonScreen getSkeletonScreen() {
        return this.skeletonScreen;
    }

    @JvmName(name = "setSkeletonScreen")
    public final void setSkeletonScreen(SkeletonScreen skeletonScreen) {
        this.skeletonScreen = skeletonScreen;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityFamilyMemberDetailBinding inflateViewBinding() {
        ActivityFamilyMemberDetailBinding KClassImpl$Data$declaredNonStaticMembers$2 = ActivityFamilyMemberDetailBinding.KClassImpl$Data$declaredNonStaticMembers$2(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        prepareBundle();
        initView();
        ManageFamilyView manageFamilyView = getBinding().DatabaseTableConfigUtil;
        FamilyMemberInfoModel familyMemberInfoModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        FamilyMemberInfoModel familyMemberInfoModel2 = null;
        if (familyMemberInfoModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            familyMemberInfoModel = null;
        }
        manageFamilyView.setManageFamilyType(familyMemberInfoModel);
        FamilyMemberInfoModel familyMemberInfoModel3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (familyMemberInfoModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            familyMemberInfoModel2 = familyMemberInfoModel3;
        }
        PlaceComponentResult(familyMemberInfoModel2);
        getAuthRequestContext(familyMemberInfoModel2);
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setOnClickListener(new ManageMemberActivity$$ExternalSyntheticLambda0(this));
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        DaggerFamilyAccountManageComponent.Builder authRequestContext = DaggerFamilyAccountManageComponent.getAuthRequestContext();
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        authRequestContext.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        authRequestContext.PlaceComponentResult = (FamilyAccountManageModule) Preconditions.getAuthRequestContext(new FamilyAccountManageModule(new FamilyManageContract.View() { // from class: id.dana.familyaccount.view.managefamily.ManageMemberActivity$getFamilyManageModule$1
            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory() {
                FamilyManageContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final /* synthetic */ void PlaceComponentResult() {
                FamilyManageContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
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
                DanaLoadingDialog access$getDanaLoadingDialog = ManageMemberActivity.access$getDanaLoadingDialog(ManageMemberActivity.this);
                if (access$getDanaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                    return;
                }
                access$getDanaLoadingDialog.MyBillsEntityDataFactory.show();
                access$getDanaLoadingDialog.getAuthRequestContext.startRefresh();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                ManageMemberActivity.access$getDanaLoadingDialog(ManageMemberActivity.this).PlaceComponentResult();
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                ManageMemberActivity.this.PlaceComponentResult = true;
                ManageMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2$default(ManageMemberActivity.this, true, null, 2, null);
                ManageMemberActivity.this.onBackPressed();
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final void getAuthRequestContext() {
                ManageMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2$default(ManageMemberActivity.this, false, null, 2, null);
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, SetLimitAndServicesRequestModel p1) {
                Intrinsics.checkNotNullParameter(p1, "");
                ManageMemberActivity.access$handleSetLimitAndServicesSuccess(ManageMemberActivity.this, p0, p1);
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                ManageMemberActivity.access$handleSetLimitAndServicesFailed(ManageMemberActivity.this);
            }

            @Override // id.dana.familyaccount.contract.FamilyManageContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                ManageMemberActivity.access$startPinChallenge(ManageMemberActivity.this, p0, p1, p2);
            }
        }));
        authRequestContext.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory(this);
    }

    public final void prepareBundle() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            FamilyMemberInfoModel familyMemberInfoModel = (FamilyMemberInfoModel) extras.getParcelable("FAMILY_MEMBER_INFO_MODEL");
            if (familyMemberInfoModel != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = familyMemberInfoModel;
            }
            ArrayList parcelableArrayList = extras.getParcelableArrayList("AVAILABLE_SERVICES_CONFIG");
            if (parcelableArrayList != null) {
                this.getAuthRequestContext = parcelableArrayList;
            }
            MaxMemberLimitConfig maxMemberLimitConfig = (MaxMemberLimitConfig) extras.getParcelable("MAX_MEMBER_LIMIT_CONFIG");
            if (maxMemberLimitConfig != null) {
                this.getErrorConfigVersion = maxMemberLimitConfig;
            }
        }
    }

    private final void getAuthRequestContext(final FamilyMemberInfoModel p0) {
        SectionCellView sectionCellView = getBinding().moveToNextValue;
        sectionCellView.initMemberDetailLimitSection(p0.KClassImpl$Data$declaredNonStaticMembers$2);
        sectionCellView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.managefamily.ManageMemberActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageMemberActivity.$r8$lambda$bwC0AazmkaBix8npCn3gy6kNGxQ(ManageMemberActivity.this, p0, view);
            }
        });
        String string = getString(R.string.btn_set_member_limit);
        Intrinsics.checkNotNullExpressionValue(string, "");
        sectionCellView.setContentDescription(string);
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        DANAToast dANAToast = DANAToast.PlaceComponentResult;
        ManageMemberActivity manageMemberActivity = this;
        String string = getResources().getString(R.string.family_member_transaction_limit_failed_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = getString(this.moveToNextValue ? R.string.toast_failed_limit_changed : R.string.toast_failed_change_service);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        DANAToast.getAuthRequestContext(manageMemberActivity, string, string2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r2, int resultCode, Intent data) {
        Bundle extras;
        Bundle extras2;
        super.onActivityResult(r2, resultCode, data);
        if (r2 == 1010) {
            String str = null;
            if (resultCode == -1) {
                this.PlaceComponentResult = true;
                KClassImpl$Data$declaredNonStaticMembers$2$default(this, true, null, 2, null);
                onBackPressed();
            } else if (resultCode == 0) {
                String string = (data == null || (extras2 = data.getExtras()) == null) ? null : extras2.getString("message");
                if (data != null && (extras = data.getExtras()) != null) {
                    str = extras.getString(ChallengeControl.Key.CANCEL_REASON);
                }
                if (Intrinsics.areEqual(str, "back") || Intrinsics.areEqual(str, "close")) {
                    return;
                }
                KClassImpl$Data$declaredNonStaticMembers$2(false, string);
            }
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2$default(ManageMemberActivity manageMemberActivity, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        manageMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2(z, str);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, String p1) {
        if (p0) {
            getFamilyAccountAnalyticalTracker().MyBillsEntityDataFactory("Success");
            DANAToast dANAToast = DANAToast.PlaceComponentResult;
            String string = getString(R.string.family_account_success_remove_family_member_message);
            Intrinsics.checkNotNullExpressionValue(string, "");
            DANAToast.getAuthRequestContext(this, string);
            return;
        }
        getFamilyAccountAnalyticalTracker().MyBillsEntityDataFactory("Failed");
        String str = p1;
        if (str == null || str.length() == 0) {
            DANAToast dANAToast2 = DANAToast.PlaceComponentResult;
            String string2 = getString(R.string.family_account_failed_delete_family_account_message);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            DANAToast.PlaceComponentResult(this, string2);
            return;
        }
        DANAToast dANAToast3 = DANAToast.PlaceComponentResult;
        DANAToast.PlaceComponentResult(this, p1);
    }

    private static String PlaceComponentResult(String p0) {
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
        if (this.PlaceComponentResult) {
            setResult(-1);
        }
        finish();
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010"}, d2 = {"Lid/dana/familyaccount/view/managefamily/ManageMemberActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "p1", "", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "p2", "Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "p3", "Landroid/content/Intent;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Lid/dana/familyaccount/model/FamilyMemberInfoModel;Ljava/util/List;Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;)Landroid/content/Intent;", "", "AVAILABLE_SERVICES_CONFIG", "Ljava/lang/String;", "FAMILY_MEMBER_INFO_MODEL", "MAX_MEMBER_LIMIT_CONFIG", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent BuiltInFictitiousFunctionClassFactory(Context p0, FamilyMemberInfoModel p1, List<AvailableServicesConfig> p2, MaxMemberLimitConfig p3) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intent intent = new Intent(p0, ManageMemberActivity.class);
            intent.putExtra("FAMILY_MEMBER_INFO_MODEL", p1);
            intent.putParcelableArrayListExtra("AVAILABLE_SERVICES_CONFIG", new ArrayList<>(p2));
            intent.putExtra("MAX_MEMBER_LIMIT_CONFIG", p3);
            return intent;
        }
    }

    public static /* synthetic */ void $r8$lambda$I6yiWyuaK5UajL0iX9r9eC4tMn8(ManageMemberActivity manageMemberActivity, View view) {
        Intrinsics.checkNotNullParameter(manageMemberActivity, "");
        FamilyAccountCustomDialog.Builder builder = new FamilyAccountCustomDialog.Builder(manageMemberActivity);
        String string = manageMemberActivity.getString(R.string.family_account_delete_member_description);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Intrinsics.checkNotNullParameter(string, "");
        builder.PlaceComponentResult = string;
        String string2 = manageMemberActivity.getString(R.string.family_account_delete_member_question_mark);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        Intrinsics.checkNotNullParameter(string2, "");
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
        FamilyAccountCustomDialog.Builder MyBillsEntityDataFactory = FamilyAccountCustomDialog.Builder.MyBillsEntityDataFactory(FamilyAccountCustomDialog.Builder.KClassImpl$Data$declaredNonStaticMembers$2(builder, manageMemberActivity.getString(R.string.button_delete), new View.OnClickListener() { // from class: id.dana.familyaccount.view.managefamily.ManageMemberActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ManageMemberActivity.$r8$lambda$SyYaUV0DOuBgzT9b9eY4C9rIvdI(ManageMemberActivity.this, view2);
            }
        }), manageMemberActivity.getString(R.string.cancel_allow_contact), null, new View.OnClickListener() { // from class: id.dana.familyaccount.view.managefamily.ManageMemberActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ManageMemberActivity.$r8$lambda$QV11_Luo_QSsDvzj7zsFYitUmmg(view2);
            }
        }, 2).MyBillsEntityDataFactory();
        new FamilyAccountCustomDialog(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.GetContactSyncConfig, MyBillsEntityDataFactory, null).MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void $r8$lambda$SyYaUV0DOuBgzT9b9eY4C9rIvdI(ManageMemberActivity manageMemberActivity, View view) {
        Intrinsics.checkNotNullParameter(manageMemberActivity, "");
        FamilyManageContract.Presenter familyManagePresenter = manageMemberActivity.getFamilyManagePresenter();
        FamilyMemberInfoModel familyMemberInfoModel = manageMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (familyMemberInfoModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            familyMemberInfoModel = null;
        }
        familyManagePresenter.PlaceComponentResult(familyMemberInfoModel.BuiltInFictitiousFunctionClassFactory);
    }

    public static /* synthetic */ void $r8$lambda$WTcZf4D3f5cyikfybP8jIIlHaSs(ManageMemberActivity manageMemberActivity, View view) {
        Intrinsics.checkNotNullParameter(manageMemberActivity, "");
        manageMemberActivity.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void $r8$lambda$_dty_BnjLXVTnYkOFnKxpHj6KWc(boolean z, ManageMemberActivity manageMemberActivity, FamilyMemberInfoModel familyMemberInfoModel, View view) {
        Intrinsics.checkNotNullParameter(manageMemberActivity, "");
        Intrinsics.checkNotNullParameter(familyMemberInfoModel, "");
        if (z) {
            String str = familyMemberInfoModel.getAuthRequestContext.scheduleImpl;
            String str2 = familyMemberInfoModel.getAuthRequestContext.PlaceComponentResult;
            StringBuilder sb = new StringBuilder();
            sb.append("[\"");
            sb.append(str);
            sb.append("\"]");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[\"");
            sb2.append(str2);
            sb2.append("\"]");
            String format = String.format(DanaUrl.FAMILY_ACCOUNT_HISTORY_TRANSACTION, Arrays.copyOf(new Object[]{sb.toString(), sb2.toString()}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "");
            DanaH5.startContainerFullUrl(format);
        }
    }

    public static /* synthetic */ void $r8$lambda$bwC0AazmkaBix8npCn3gy6kNGxQ(ManageMemberActivity manageMemberActivity, FamilyMemberInfoModel familyMemberInfoModel, View view) {
        Intrinsics.checkNotNullParameter(manageMemberActivity, "");
        Intrinsics.checkNotNullParameter(familyMemberInfoModel, "");
        String cleanAll = NumberUtils.getCleanAll(familyMemberInfoModel.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
        if (cleanAll == null) {
            cleanAll = "0";
        }
        Long longOrNull = StringsKt.toLongOrNull(cleanAll);
        ((SetLimitBottomSheet) manageMemberActivity.lookAheadTest.getValue()).BuiltInFictitiousFunctionClassFactory = longOrNull != null ? longOrNull.longValue() : 0L;
        ((SetLimitBottomSheet) manageMemberActivity.lookAheadTest.getValue()).show(manageMemberActivity.getSupportFragmentManager(), OrganizerDashboardActivity.SET_MEMBER_LIMIT);
    }

    public static final /* synthetic */ DanaLoadingDialog access$getDanaLoadingDialog(ManageMemberActivity manageMemberActivity) {
        return (DanaLoadingDialog) manageMemberActivity.BuiltInFictitiousFunctionClassFactory.getValue();
    }

    public static final /* synthetic */ void access$handleSetLimitAndServicesFailed(ManageMemberActivity manageMemberActivity) {
        manageMemberActivity.BuiltInFictitiousFunctionClassFactory();
        FamilyManageAvailableServicesAdapter familyManageAvailableServicesAdapter = manageMemberActivity.MyBillsEntityDataFactory;
        if (familyManageAvailableServicesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            familyManageAvailableServicesAdapter = null;
        }
        familyManageAvailableServicesAdapter.notifyItemChanged(manageMemberActivity.scheduleImpl);
    }

    public static final /* synthetic */ void access$handleSetLimitAndServicesSuccess(ManageMemberActivity manageMemberActivity, boolean z, SetLimitAndServicesRequestModel setLimitAndServicesRequestModel) {
        String format;
        FamilyManageAvailableServicesAdapter familyManageAvailableServicesAdapter = null;
        FamilyMemberInfoModel familyMemberInfoModel = null;
        if (z) {
            if (manageMemberActivity.moveToNextValue) {
                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                ManageMemberActivity manageMemberActivity2 = manageMemberActivity;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = manageMemberActivity.getResources().getString(R.string.family_member_transaction_limit_success_changed_message);
                Intrinsics.checkNotNullExpressionValue(string, "");
                Object[] objArr = new Object[1];
                FamilyMemberInfoModel familyMemberInfoModel2 = manageMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2;
                if (familyMemberInfoModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    familyMemberInfoModel2 = null;
                }
                objArr[0] = familyMemberInfoModel2.getAuthRequestContext.PlaceComponentResult;
                String format2 = String.format(string, Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "");
                String string2 = manageMemberActivity.getString(R.string.toast_success_limit_changed);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                DANAToast.PlaceComponentResult(manageMemberActivity2, format2, string2);
                ((SetLimitBottomSheet) manageMemberActivity.lookAheadTest.getValue()).dismiss();
            } else {
                DANAToast dANAToast2 = DANAToast.PlaceComponentResult;
                ManageMemberActivity manageMemberActivity3 = manageMemberActivity;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String string3 = manageMemberActivity.getResources().getString(R.string.family_member_service_success_changed_message);
                Intrinsics.checkNotNullExpressionValue(string3, "");
                Object[] objArr2 = new Object[1];
                FamilyMemberInfoModel familyMemberInfoModel3 = manageMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2;
                if (familyMemberInfoModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    familyMemberInfoModel3 = null;
                }
                objArr2[0] = familyMemberInfoModel3.getAuthRequestContext.PlaceComponentResult;
                String format3 = String.format(string3, Arrays.copyOf(objArr2, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "");
                String string4 = manageMemberActivity.getString(R.string.toast_success_change_service);
                Intrinsics.checkNotNullExpressionValue(string4, "");
                DANAToast.PlaceComponentResult(manageMemberActivity3, format3, string4);
                manageMemberActivity.getFamilyAccountAnalyticalTracker().PlaceComponentResult(setLimitAndServicesRequestModel.PlaceComponentResult);
            }
            FamilyMemberInfoModel familyMemberInfoModel4 = manageMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2;
            if (familyMemberInfoModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                familyMemberInfoModel4 = null;
            }
            FamilyMemberInfoModel familyMemberInfoModel5 = manageMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2;
            if (familyMemberInfoModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                familyMemberInfoModel5 = null;
            }
            List<String> list = setLimitAndServicesRequestModel.PlaceComponentResult;
            format = NumberFormat.getNumberInstance(LocaleUtil.getAuthRequestContext()).format((long) Integer.parseInt(setLimitAndServicesRequestModel.KClassImpl$Data$declaredNonStaticMembers$2));
            Intrinsics.checkNotNullExpressionValue(format, "");
            LimitInfoModel limitInfoModel = new LimitInfoModel(list, new MoneyViewModel(format, PlaceComponentResult(familyMemberInfoModel5.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2), PlaceComponentResult(familyMemberInfoModel5.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext)));
            Intrinsics.checkNotNullParameter(limitInfoModel, "");
            familyMemberInfoModel4.KClassImpl$Data$declaredNonStaticMembers$2 = limitInfoModel;
            FamilyMemberInfoModel familyMemberInfoModel6 = manageMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2;
            if (familyMemberInfoModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                familyMemberInfoModel = familyMemberInfoModel6;
            }
            manageMemberActivity.PlaceComponentResult(familyMemberInfoModel);
            manageMemberActivity.getAuthRequestContext(familyMemberInfoModel);
            manageMemberActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setOnClickListener(new ManageMemberActivity$$ExternalSyntheticLambda0(manageMemberActivity));
            manageMemberActivity.PlaceComponentResult = true;
            return;
        }
        manageMemberActivity.BuiltInFictitiousFunctionClassFactory();
        FamilyManageAvailableServicesAdapter familyManageAvailableServicesAdapter2 = manageMemberActivity.MyBillsEntityDataFactory;
        if (familyManageAvailableServicesAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            familyManageAvailableServicesAdapter = familyManageAvailableServicesAdapter2;
        }
        familyManageAvailableServicesAdapter.notifyItemChanged(manageMemberActivity.scheduleImpl);
    }

    public static final /* synthetic */ void access$setMemberLimit(ManageMemberActivity manageMemberActivity, String str) {
        List<AvailableServicesConfig> list = manageMemberActivity.getAuthRequestContext;
        FamilyMemberInfoModel familyMemberInfoModel = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            list = null;
        }
        List<AvailableServicesConfig> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((AvailableServicesConfig) it.next()).getUseCase());
        }
        ArrayList arrayList2 = arrayList;
        FamilyMemberInfoModel familyMemberInfoModel2 = manageMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (familyMemberInfoModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            familyMemberInfoModel2 = null;
        }
        if (!LimitInfoModelKt.BuiltInFictitiousFunctionClassFactory(familyMemberInfoModel2.KClassImpl$Data$declaredNonStaticMembers$2)) {
            FamilyMemberInfoModel familyMemberInfoModel3 = manageMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2;
            if (familyMemberInfoModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                familyMemberInfoModel3 = null;
            }
            arrayList2 = familyMemberInfoModel3.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
        }
        FamilyMemberInfoModel familyMemberInfoModel4 = manageMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (familyMemberInfoModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            familyMemberInfoModel = familyMemberInfoModel4;
        }
        manageMemberActivity.getFamilyManagePresenter().MyBillsEntityDataFactory(new SetLimitAndServicesRequestModel(familyMemberInfoModel.getAuthRequestContext.scheduleImpl, arrayList2, str));
    }

    public static final /* synthetic */ void access$setMemberServices(ManageMemberActivity manageMemberActivity, String str, boolean z) {
        FamilyMemberInfoModel familyMemberInfoModel = manageMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        FamilyMemberInfoModel familyMemberInfoModel2 = null;
        if (familyMemberInfoModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            familyMemberInfoModel = null;
        }
        List mutableList = CollectionsKt.toMutableList((Collection) familyMemberInfoModel.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
        if (z) {
            mutableList.add(str);
        } else {
            mutableList.remove(str);
        }
        FamilyMemberInfoModel familyMemberInfoModel3 = manageMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (familyMemberInfoModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            familyMemberInfoModel3 = null;
        }
        String str2 = familyMemberInfoModel3.getAuthRequestContext.scheduleImpl;
        FamilyMemberInfoModel familyMemberInfoModel4 = manageMemberActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (familyMemberInfoModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            familyMemberInfoModel2 = familyMemberInfoModel4;
        }
        String cleanAll = NumberUtils.getCleanAll(familyMemberInfoModel2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
        if (cleanAll == null) {
            cleanAll = "0";
        }
        manageMemberActivity.getFamilyManagePresenter().MyBillsEntityDataFactory(new SetLimitAndServicesRequestModel(str2, mutableList, cleanAll));
    }

    public static final /* synthetic */ void access$startPinChallenge(ManageMemberActivity manageMemberActivity, String str, String str2, String str3) {
        ChallengeControl.Builder builder = new ChallengeControl.Builder(manageMemberActivity);
        builder.scheduleImpl = ChallengeScenario.REMOVE_FAMILY_MEMBER;
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "family_account";
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        builder.E = str;
        builder.PrepareContext = str2;
        builder.BottomSheetCardBindingView$watcherCardNumberView$1 = str3;
        new ChallengeControl(builder, null).getAuthRequestContext();
    }

    private final void PlaceComponentResult(final FamilyMemberInfoModel p0) {
        final boolean z = !LimitInfoModelKt.BuiltInFictitiousFunctionClassFactory(p0.KClassImpl$Data$declaredNonStaticMembers$2);
        getBinding().scheduleImpl.initHistorySection(z);
        getBinding().scheduleImpl.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.managefamily.ManageMemberActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageMemberActivity.$r8$lambda$_dty_BnjLXVTnYkOFnKxpHj6KWc(z, this, p0, view);
            }
        });
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        LayoutToolbarBinding layoutToolbarBinding = getBinding().BuiltInFictitiousFunctionClassFactory;
        TextView textView = layoutToolbarBinding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        ImageView imageView = layoutToolbarBinding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
        layoutToolbarBinding.initRecordTimeStamp.setText(getString(R.string.manage_family_role_member));
        LayoutToolbarBinding layoutToolbarBinding2 = getBinding().BuiltInFictitiousFunctionClassFactory;
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationIcon(R.drawable.btn_arrow_left);
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.managefamily.ManageMemberActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageMemberActivity.$r8$lambda$WTcZf4D3f5cyikfybP8jIIlHaSs(ManageMemberActivity.this, view);
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

    public final void initView() {
        getBinding().PlaceComponentResult.setVisibility(0);
        SkeletonScreen skeletonScreen = this.skeletonScreen;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        RecyclerView recyclerView = getBinding().getAuthRequestContext;
        FamilyMemberInfoModel familyMemberInfoModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        MaxMemberLimitConfig maxMemberLimitConfig = null;
        if (familyMemberInfoModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            familyMemberInfoModel = null;
        }
        FamilyManageAvailableServicesAdapter familyManageAvailableServicesAdapter = new FamilyManageAvailableServicesAdapter(familyMemberInfoModel.KClassImpl$Data$declaredNonStaticMembers$2, new Function3<String, Boolean, Integer, Unit>() { // from class: id.dana.familyaccount.view.managefamily.ManageMemberActivity$setupManageAvailableServicesAdapter$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void invoke(String str, boolean z, int i) {
                Intrinsics.checkNotNullParameter(str, "");
                ManageMemberActivity.this.scheduleImpl = i;
                ManageMemberActivity.this.moveToNextValue = false;
                ManageMemberActivity.access$setMemberServices(ManageMemberActivity.this, str, z);
            }

            @Override // kotlin.jvm.functions.Function3
            public final /* synthetic */ Unit invoke(String str, Boolean bool, Integer num) {
                invoke(str, bool.booleanValue(), num.intValue());
                return Unit.INSTANCE;
            }
        });
        recyclerView.setAdapter(familyManageAvailableServicesAdapter);
        FamilyManageAvailableServicesAdapter familyManageAvailableServicesAdapter2 = familyManageAvailableServicesAdapter;
        List<AvailableServicesConfig> list = this.getAuthRequestContext;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            list = null;
        }
        BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(familyManageAvailableServicesAdapter2, list);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), ContextCompat.BuiltInFictitiousFunctionClassFactory(recyclerView.getContext(), R.color.f23952131099990), SizeUtil.getAuthRequestContext(16), (char) 0));
        this.MyBillsEntityDataFactory = familyManageAvailableServicesAdapter;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        SetLimitBottomSheet setLimitBottomSheet = (SetLimitBottomSheet) this.lookAheadTest.getValue();
        MaxMemberLimitConfig maxMemberLimitConfig2 = this.getErrorConfigVersion;
        if (maxMemberLimitConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            maxMemberLimitConfig = maxMemberLimitConfig2;
        }
        setLimitBottomSheet.getAuthRequestContext = maxMemberLimitConfig;
        SetLimitBottomSheet setLimitBottomSheet2 = (SetLimitBottomSheet) this.lookAheadTest.getValue();
        Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: id.dana.familyaccount.view.managefamily.ManageMemberActivity$setupMemberLimitBottomSheet$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                ManageMemberActivity.this.moveToNextValue = true;
                ManageMemberActivity.access$setMemberLimit(ManageMemberActivity.this, str);
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        setLimitBottomSheet2.PlaceComponentResult = function1;
    }

    private static void a(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (newProxyInstance ^ 4360990799332652212L)) ^ ((int) (PrepareContext ^ 4360990799332652212L))) ^ ((char) (NetworkUserEntityData$$ExternalSyntheticLambda8 ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}

package id.dana.familyaccount.view.dashboard;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.animation.view.GridItemDecoration;
import id.dana.base.AbstractContractKt;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.extension.ViewExtKt;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.danah5.DanaH5;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.ActivityFamilyAccountDashboardOrganizerBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerFamilyAccountDashboardComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.FamilyAccountDashboardModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.familyaccount.model.AvailableServicesConfig;
import id.dana.domain.familyaccount.model.MaxMemberLimitConfig;
import id.dana.familyaccount.adapter.FamilyDashboardServicesAdapter;
import id.dana.familyaccount.adapter.MembersForOrganizerAdapter;
import id.dana.familyaccount.constants.FamilyAccountInvitationStatusType;
import id.dana.familyaccount.constants.StatusInformationType;
import id.dana.familyaccount.contract.FamilyDashboardContract;
import id.dana.familyaccount.model.DashboardModel;
import id.dana.familyaccount.model.FamilyMemberInfoModel;
import id.dana.familyaccount.model.FamilyMemberInfoModelKt;
import id.dana.familyaccount.model.MemberInfoModel;
import id.dana.familyaccount.model.TopUpUserConsultModel;
import id.dana.familyaccount.model.TransactionHistoryModel;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.familyaccount.util.TopUpUserConsultManager;
import id.dana.familyaccount.view.bottomsheet.HistoryTransactionBottomSheet;
import id.dana.familyaccount.view.bottomsheet.ResendInvitationBottomSheet;
import id.dana.familyaccount.view.bottomsheet.TopUpBottomSheet;
import id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity;
import id.dana.familyaccount.view.dialog.FamilyAccountCustomDialog;
import id.dana.familyaccount.view.invite.FamilyInviteMemberActivity;
import id.dana.familyaccount.view.invite.FamilyTncConsentActivity;
import id.dana.familyaccount.view.managefamily.ManageMemberActivity;
import id.dana.familyaccount.view.managefamily.ManageOrganizerActivity;
import id.dana.familyaccount.view.memberlimit.ManageMemberLimitActivity;
import id.dana.familyaccount.view.section.SectionCellViewSimple;
import id.dana.familyaccount.view.statusinformation.StatusInformationView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.usereducation.BottomSheetHelpActivity;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.usereducation.model.OnBoardingModel;
import id.dana.utils.DANAToast;
import id.dana.utils.RandomInteger;
import id.dana.utils.SafeClickListenerExtensionKt;
import id.dana.utils.ShimmeringUtil;
import id.dana.utils.SizeUtil;
import id.dana.utils.danah5.DanaH5Listener;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.ArrayList;
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
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 `2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002`aB\u0007¢\u0006\u0004\b_\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\u0005J)\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0012\u0010\u0005J\r\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0005J\r\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0005R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0013\u0010!\u001a\u00020\u001eX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010#\u001a\u00020\"8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b1\u00102R\"\u00105\u001a\u0002048\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0013\u0010=\u001a\u00020;X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b<\u0010 R\u0018\u0010\u001f\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010\u0016\u001a\u00020A8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bB\u0010CR\"\u0010E\u001a\u00020D8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0013\u0010\u001b\u001a\u00020OX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bP\u0010 R\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0013\u0010L\u001a\u00020UX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bV\u0010 R*\u0010^\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010W8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bY\u0010\u001c\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]"}, d2 = {"Lid/dana/familyaccount/view/dashboard/OrganizerDashboardActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityFamilyAccountDashboardOrganizerBinding;", "", "configToolbar", "()V", "inflateViewBinding", "()Lid/dana/databinding/ActivityFamilyAccountDashboardOrganizerBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onDestroy", "onResume", "setMenuRightButton", "showResendConfirmationDialog", "Lid/dana/familyaccount/adapter/FamilyDashboardServicesAdapter;", "lookAheadTest", "Lid/dana/familyaccount/adapter/FamilyDashboardServicesAdapter;", "PlaceComponentResult", "", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "getErrorConfigVersion", "Ljava/util/List;", "getAuthRequestContext", "Lid/dana/dialog/DanaLoadingDialog;", "scheduleImpl", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "familyAccountAnalyticalTracker", "Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "getFamilyAccountAnalyticalTracker", "()Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "setFamilyAccountAnalyticalTracker", "(Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;)V", "Lid/dana/familyaccount/contract/FamilyDashboardContract$Presenter;", "familyDashboardPresenter", "Lid/dana/familyaccount/contract/FamilyDashboardContract$Presenter;", "getFamilyDashboardPresenter", "()Lid/dana/familyaccount/contract/FamilyDashboardContract$Presenter;", "setFamilyDashboardPresenter", "(Lid/dana/familyaccount/contract/FamilyDashboardContract$Presenter;)V", "Lid/dana/familyaccount/adapter/MembersForOrganizerAdapter;", "initRecordTimeStamp", "Lid/dana/familyaccount/adapter/MembersForOrganizerAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "familyMemberInfoModelSelected", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "getFamilyMemberInfoModelSelected", "()Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "setFamilyMemberInfoModelSelected", "(Lid/dana/familyaccount/model/FamilyMemberInfoModel;)V", "Lid/dana/familyaccount/view/bottomsheet/HistoryTransactionBottomSheet;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "KClassImpl$Data$declaredNonStaticMembers$2", "", "GetContactSyncConfig", "Ljava/lang/Boolean;", "Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "onBoardingServicePresenter", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "getOnBoardingServicePresenter", "()Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "setOnBoardingServicePresenter", "(Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;)V", "Lid/dana/familyaccount/view/dashboard/OrganizerDashboardActivity$StartParams;", "DatabaseTableConfigUtil", "Lid/dana/familyaccount/view/dashboard/OrganizerDashboardActivity$StartParams;", "moveToNextValue", "Lid/dana/familyaccount/view/bottomsheet/ResendInvitationBottomSheet;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lcom/ethanhua/skeleton/SkeletonScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lcom/ethanhua/skeleton/SkeletonScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/familyaccount/view/bottomsheet/TopUpBottomSheet;", "isLayoutRequested", "", "Lid/dana/familyaccount/model/TransactionHistoryModel;", "newProxyInstance", "getTransactionHistoryModels", "()Ljava/util/List;", "setTransactionHistoryModels", "(Ljava/util/List;)V", "transactionHistoryModels", "<init>", "Companion", "StartParams"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OrganizerDashboardActivity extends BaseViewBindingActivity<ActivityFamilyAccountDashboardOrganizerBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final int DASHBOARD_TOTAL_COLUMN = 3;
    public static final String EXTRA_START_PARAMS = "startParams";
    public static final String FIRST_TIMER_TOPUP = "FIRST_TIMER_TOPUP";
    public static final String GET_EXIST_MEMBER = "getExistMember";
    private static int[] PrepareContext = null;
    public static final String REJECT = "REJECT";
    public static final String RESEND_INVITATION = "RESEND_INVITATION";
    public static final String SET_MEMBER_LIMIT = "SET_MEMBER_LIMIT";
    public static final String SHOW_TOPUP = "SHOW_TOPUP";
    public static final String SUCCESS = "SUCCESS";
    public static final String TRANSACTION_HISTORY = "TRANSACTION_HISTORY";
    private static final int getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private MaxMemberLimitConfig lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private SkeletonScreen NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker;
    @Inject
    public FamilyDashboardContract.Presenter familyDashboardPresenter;
    public FamilyMemberInfoModel familyMemberInfoModelSelected;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private List<AvailableServicesConfig> getAuthRequestContext;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private MembersForOrganizerAdapter BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private FamilyDashboardServicesAdapter PlaceComponentResult;
    @Inject
    public BottomSheetOnBoardingContract.Presenter onBoardingServicePresenter;
    public static final byte[] $$a = {TarHeader.LF_LINK, 16, -25, 45, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 125;
    public static final byte[] PlaceComponentResult = {Ascii.EM, 16, -94, Ascii.FS, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 252;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private StartParams moveToNextValue = new StartParams("", "");

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private Boolean scheduleImpl = Boolean.FALSE;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final Lazy DatabaseTableConfigUtil = LazyKt.lazy(new Function0<TopUpBottomSheet>() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$topUpBottomSheet$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TopUpBottomSheet invoke() {
            return new TopUpBottomSheet();
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<HistoryTransactionBottomSheet>() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$historyTransactionBottomSheet$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HistoryTransactionBottomSheet invoke() {
            return new HistoryTransactionBottomSheet();
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion = LazyKt.lazy(new Function0<ResendInvitationBottomSheet>() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$resendTransactionBottomSheet$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ResendInvitationBottomSheet invoke() {
            return new ResendInvitationBottomSheet();
        }
    });

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private List<TransactionHistoryModel> transactionHistoryModels = new ArrayList();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(OrganizerDashboardActivity.this);
        }
    });

    public static /* synthetic */ void $r8$lambda$QOjuzYaux6GbdnW3ey9T3dq04g4(View view) {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 15
            int r6 = 19 - r6
            int r8 = r8 * 3
            int r8 = r8 + 16
            int r7 = 106 - r7
            byte[] r0 = id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity.PlaceComponentResult
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L30
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r4 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L30:
            int r6 = r6 + 1
            int r7 = r7 + r8
            int r7 = r7 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity.b(int, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 75
            byte[] r0 = id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity.$$a
            int r7 = r7 * 3
            int r7 = 42 - r7
            int r6 = r6 + 4
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
            goto L37
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r6 = r6 + 1
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity.c(short, byte, short, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        PrepareContext = new int[]{170716702, -2013559956, -2116646628, 1776837910, -693486709, -1546684536, -1648263440, 43748813, 1812593258, 428802158, 1868923999, 1111198937, -864465189, 1787047419, 440888665, -905142042, 891419472, -785728180};
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
        a(18 - TextUtils.getCapsMode("", 0, 0), new int[]{1532070689, 1629423609, -637742, 1847115419, -2145666994, -1649755689, 1520760857, -1581022279, -523428424, -37548653}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(5 - TextUtils.getOffsetAfter("", 0), new int[]{-1773281221, -1451635982, 368532113, -210189206}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getTrimmedLength("") + 35, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(48 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new int[]{-1287832032, -1928046978, -1961451903, 415995222, 1879151114, 473250606, -1366127401, 2111779674, -1460147286, 1737996301, -379803018, -297600149, -994771961, 480749619, -657999579, 1425090429, 673932339, -526582591, 1351436736, 648330813, 321830493, 286853385, 1723268278, 947113005}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(64 - TextUtils.indexOf("", ""), new int[]{-2037276959, 397663085, 1666004713, -512043808, 248549403, 1063701492, -862494349, -249576482, 1304518515, -231718857, 425186917, -1500407881, 956395791, 1201440653, 82678100, -1397136132, -1642322664, 1138414213, 2074195643, 893077080, 308052292, -278166875, 835142461, -2027909978, 32781535, 1317144799, 1111726381, 64295217, -551580517, 1881463052, 625448467, 1291118597}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(64 - Color.alpha(0), new int[]{757914718, 526391372, 1462813205, -259067542, -420732743, -1503122757, -522246142, 656251819, 1919491899, 210283191, -618418636, 1262597999, 2145278765, 941723747, 2143836461, 2817035, 584560276, -202973047, -2090248923, 1912909713, -2089459475, -599288931, -2049621672, -1744418017, -1770543677, 1577262421, 347753073, -842529823, 515596516, 280061908, 347418481, 544810269}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(60 - (Process.myPid() >> 22), new int[]{-501234659, -1176713886, -930321208, -1412189840, 1494060332, 1796890598, -395718721, -1099608704, 780991228, 437457056, -139974817, -1262041607, 1867569132, 2082463544, -1911010835, -840226581, 1539671947, 509338116, -1725699297, -1387261098, -90601863, -1711317675, -54101642, 968257618, 1463776377, 1408145631, 932255018, -1780550334, 661844410, -1420965626}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(Color.blue(0) + 6, new int[]{947920303, 188496160, -988738553, 1360014261}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0), TextUtils.indexOf("", "", 0) + 18, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (PlaceComponentResult[5] + 1);
                byte b2 = b;
                Object[] objArr13 = new Object[1];
                b(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = (byte) (-PlaceComponentResult[5]);
                byte b4 = b3;
                Object[] objArr14 = new Object[1];
                b(b3, b4, (byte) (b4 - 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 55, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 2, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[68], $$a[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 800, TextUtils.getCapsMode("", 0, 0) + 15, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 15 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getPressedStateDuration() >> 16), Color.red(0) + 29, (char) (Color.blue(0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getOffsetBefore("", 0), (ViewConfiguration.getLongPressTimeout() >> 16) + 15, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (ViewConfiguration.getWindowTouchSlop() >> 8) + 35, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1087111448, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 911, 18 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = (byte) (PlaceComponentResult[5] + 1);
                byte b6 = b5;
                Object[] objArr19 = new Object[1];
                b(b5, b6, b6, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b7 = (byte) (-PlaceComponentResult[5]);
                byte b8 = b7;
                Object[] objArr20 = new Object[1];
                b(b7, b8, (byte) (b8 - 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getTouchSlop() >> 8), Color.red(0) + 46, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[28]), (byte) (-$$a[8]), (byte) (-$$a[9]), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r3 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 34, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {1087111448, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getWindowTouchSlop() >> 8), View.resolveSizeAndState(0, 0, 0) + 18, (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b9 = (byte) (PlaceComponentResult[5] + 1);
                byte b10 = b9;
                Object[] objArr25 = new Object[1];
                b(b9, b10, b10, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b11 = (byte) (-PlaceComponentResult[5]);
                byte b12 = b11;
                Object[] objArr26 = new Object[1];
                b(b11, b12, (byte) (b12 - 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - KeyEvent.getDeadChar(0, 0), 3 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (38968 - View.resolveSize(0, 0)));
                        Object[] objArr28 = new Object[1];
                        c((byte) (-$$a[28]), (byte) (-$$a[8]), (byte) (-$$a[9]), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r3 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 930, 34 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1087111448, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b13 = (byte) (PlaceComponentResult[5] + 1);
                byte b14 = b13;
                Object[] objArr31 = new Object[1];
                b(b13, b14, b14, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b15 = (byte) (-PlaceComponentResult[5]);
                byte b16 = b15;
                Object[] objArr32 = new Object[1];
                b(b15, b16, (byte) (b16 - 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - TextUtils.indexOf("", "", 0), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 3, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                        byte b17 = $$a[40];
                        byte b18 = (byte) ($$a[47] - 1);
                        Object[] objArr34 = new Object[1];
                        c(b17, b18, b18, objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r3 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 35 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {1087111448, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0, 0), 18 - View.getDefaultSize(0, 0), (char) View.getDefaultSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        a(super.getResources().getString(R.string.bottom_on_boarding_title_my_bills).substring(40, 42).length() + 16, new int[]{1532070689, 1629423609, -637742, 1847115419, -2145666994, -1649755689, 1520760857, -1581022279, -523428424, -37548653}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(4 - TextUtils.lastIndexOf("", '0', 0), new int[]{-1773281221, -1451635982, 368532113, -210189206}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 26, new int[]{1532070689, 1629423609, -637742, 1847115419, -1904041827, 1981712806, 879603515, 1422524650, 1733699841, 2016692197, -1559313140, -578114861, -1581838057, 715357819}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(super.getResources().getString(R.string.error_search_not_found_title).substring(17, 18).codePointAt(0) - 14, new int[]{2143594932, -734432188, -1708636429, 1269519546, 484933447, 574498628, 453885113, 1815986956, -865188790, -1319368198}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 35 - Drawable.resolveOpacity(0, 0), (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(super.getResources().getString(R.string.join_invitation_title_content).substring(9, 10).codePointAt(0) + 16, new int[]{-1287832032, -1928046978, -1961451903, 415995222, 1879151114, 473250606, -1366127401, 2111779674, -1460147286, 1737996301, -379803018, -297600149, -994771961, 480749619, -657999579, 1425090429, 673932339, -526582591, 1351436736, 648330813, 321830493, 286853385, 1723268278, 947113005}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(getPackageName().codePointAt(3) - 36, new int[]{-2037276959, 397663085, 1666004713, -512043808, 248549403, 1063701492, -862494349, -249576482, 1304518515, -231718857, 425186917, -1500407881, 956395791, 1201440653, 82678100, -1397136132, -1642322664, 1138414213, 2074195643, 893077080, 308052292, -278166875, 835142461, -2027909978, 32781535, 1317144799, 1111726381, 64295217, -551580517, 1881463052, 625448467, 1291118597}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(super.getResources().getString(R.string.automation_passkey_btn_maybe_later).substring(0, 15).length() + 49, new int[]{757914718, 526391372, 1462813205, -259067542, -420732743, -1503122757, -522246142, 656251819, 1919491899, 210283191, -618418636, 1262597999, 2145278765, 941723747, 2143836461, 2817035, 584560276, -202973047, -2090248923, 1912909713, -2089459475, -599288931, -2049621672, -1744418017, -1770543677, 1577262421, 347753073, -842529823, 515596516, 280061908, 347418481, 544810269}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(60 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new int[]{-501234659, -1176713886, -930321208, -1412189840, 1494060332, 1796890598, -395718721, -1099608704, 780991228, 437457056, -139974817, -1262041607, 1867569132, 2082463544, -1911010835, -840226581, 1539671947, 509338116, -1725699297, -1387261098, -90601863, -1711317675, -54101642, 968257618, 1463776377, 1408145631, 932255018, -1780550334, 661844410, -1420965626}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(super.getResources().getString(R.string.google_error_title_page).substring(6, 8).length() + 4, new int[]{947920303, 188496160, -988738553, 1360014261}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 911, (ViewConfiguration.getTouchSlop() >> 8) + 18, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr11);
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
            byte b = (byte) (PlaceComponentResult[5] + 1);
            byte b2 = b;
            Object[] objArr12 = new Object[1];
            b(b, b2, b2, objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            byte b3 = (byte) (-PlaceComponentResult[5]);
            byte b4 = b3;
            Object[] objArr13 = new Object[1];
            b(b3, b4, (byte) (b4 - 1), objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 494, '4' - AndroidCharacter.getMirror('0'), (char) (ViewConfiguration.getScrollBarSize() >> 8));
                    byte b5 = $$a[40];
                    byte b6 = (byte) ($$a[47] - 1);
                    Object[] objArr15 = new Object[1];
                    c(b5, b6, b6, objArr15);
                    obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                int i = ((int[]) objArr16[1])[0];
                if (((int[]) objArr16[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {-1653819047, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, 17 - TextUtils.lastIndexOf("", '0', 0, 0), (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr17);
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
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(TextUtils.indexOf("", "", 0) + 26, new int[]{1532070689, 1629423609, -637742, 1847115419, -1904041827, 1981712806, 879603515, 1422524650, 1733699841, 2016692197, -1559313140, -578114861, -1581838057, 715357819}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(17 - ((byte) KeyEvent.getModifierMetaStateMask()), new int[]{2143594932, -734432188, -1708636429, 1269519546, 484933447, 574498628, 453885113, 1815986956, -865188790, -1319368198}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 35 - KeyEvent.keyCodeFromString(""), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 911, (ViewConfiguration.getPressedStateDuration() >> 16) + 18, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @JvmName(name = "getOnBoardingServicePresenter")
    public final BottomSheetOnBoardingContract.Presenter getOnBoardingServicePresenter() {
        BottomSheetOnBoardingContract.Presenter presenter = this.onBoardingServicePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setOnBoardingServicePresenter")
    public final void setOnBoardingServicePresenter(BottomSheetOnBoardingContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.onBoardingServicePresenter = presenter;
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

    @JvmName(name = "getTransactionHistoryModels")
    public final List<TransactionHistoryModel> getTransactionHistoryModels() {
        return this.transactionHistoryModels;
    }

    @JvmName(name = "setTransactionHistoryModels")
    public final void setTransactionHistoryModels(List<TransactionHistoryModel> list) {
        this.transactionHistoryModels = list;
    }

    @JvmName(name = "getFamilyMemberInfoModelSelected")
    public final FamilyMemberInfoModel getFamilyMemberInfoModelSelected() {
        FamilyMemberInfoModel familyMemberInfoModel = this.familyMemberInfoModelSelected;
        if (familyMemberInfoModel != null) {
            return familyMemberInfoModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFamilyMemberInfoModelSelected")
    public final void setFamilyMemberInfoModelSelected(FamilyMemberInfoModel familyMemberInfoModel) {
        Intrinsics.checkNotNullParameter(familyMemberInfoModel, "");
        this.familyMemberInfoModelSelected = familyMemberInfoModel;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityFamilyAccountDashboardOrganizerBinding inflateViewBinding() {
        ActivityFamilyAccountDashboardOrganizerBinding authRequestContext = ActivityFamilyAccountDashboardOrganizerBinding.getAuthRequestContext(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
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

    public final void setMenuRightButton() {
        TextView textView = getBinding().lookAheadTest.getErrorConfigVersion;
        ViewGroup.LayoutParams layoutParams = getBinding().lookAheadTest.scheduleImpl.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, SizeUtil.getAuthRequestContext(10), marginLayoutParams.bottomMargin);
        }
        getBinding().lookAheadTest.scheduleImpl.setLayoutParams(marginLayoutParams);
        textView.setBackground(ContextCompat.PlaceComponentResult(this, (int) R.drawable.ic_tooltip_help));
        textView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrganizerDashboardActivity.m2590$r8$lambda$_YTKJph6R5msHrRBZVoCpmeyyI(OrganizerDashboardActivity.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        String string;
        this.moveToNextValue = (StartParams) getIntent().getParcelableExtra("startParams");
        initComponent();
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrganizerDashboardActivity.$r8$lambda$WVvi3qEl8abK9L9KAqsYIvtUYeo(OrganizerDashboardActivity.this, view);
            }
        });
        RecyclerView recyclerView = getBinding().initRecordTimeStamp;
        MembersForOrganizerAdapter membersForOrganizerAdapter = new MembersForOrganizerAdapter(new MembersForOrganizerAdapter.OrganizerClickListener() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$setupFamilymemberAdapter$1$1
            @Override // id.dana.familyaccount.adapter.MembersForOrganizerAdapter.OrganizerClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(FamilyMemberInfoModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OrganizerDashboardActivity.this.setFamilyMemberInfoModelSelected(p0);
                OrganizerDashboardActivity.access$getResendTransactionBottomSheet(OrganizerDashboardActivity.this).show(OrganizerDashboardActivity.this.getSupportFragmentManager(), OrganizerDashboardActivity.RESEND_INVITATION);
            }
        }, new Function2<FamilyMemberInfoModel, Integer, Unit>() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$setupFamilymemberAdapter$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void invoke(FamilyMemberInfoModel familyMemberInfoModel, int i) {
                Intrinsics.checkNotNullParameter(familyMemberInfoModel, "");
                OrganizerDashboardActivity.access$setupFamilyMemberItemClickListener(OrganizerDashboardActivity.this, familyMemberInfoModel);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(FamilyMemberInfoModel familyMemberInfoModel, Integer num) {
                invoke(familyMemberInfoModel, num.intValue());
                return Unit.INSTANCE;
            }
        });
        recyclerView.setAdapter(membersForOrganizerAdapter);
        recyclerView.addItemDecoration(new GridItemDecoration(recyclerView.getContext(), 3, 2));
        this.BuiltInFictitiousFunctionClassFactory = membersForOrganizerAdapter;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
        RecyclerView recyclerView2 = getBinding().DatabaseTableConfigUtil;
        FamilyDashboardServicesAdapter familyDashboardServicesAdapter = new FamilyDashboardServicesAdapter();
        recyclerView2.setAdapter(familyDashboardServicesAdapter);
        this.PlaceComponentResult = familyDashboardServicesAdapter;
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 1, false));
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ShimmeringUtil.PlaceComponentResult(getBinding().PlaceComponentResult, R.layout.view_dashboard_family_account_skeleton);
        StartParams startParams = this.moveToNextValue;
        if (Intrinsics.areEqual(startParams != null ? startParams.MyBillsEntityDataFactory : null, "SUCCESS")) {
            DANAToast dANAToast = DANAToast.PlaceComponentResult;
            String string2 = getString(R.string.dialog_invitation_success);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String string3 = getString(R.string.toast_invite_success);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            DANAToast.PlaceComponentResult(this, string2, string3);
        } else {
            StartParams startParams2 = this.moveToNextValue;
            if (Intrinsics.areEqual(startParams2 != null ? startParams2.MyBillsEntityDataFactory : null, "REJECT")) {
                DANAToast dANAToast2 = DANAToast.PlaceComponentResult;
                OrganizerDashboardActivity organizerDashboardActivity = this;
                StartParams startParams3 = this.moveToNextValue;
                if (startParams3 == null || (string = startParams3.PlaceComponentResult) == null) {
                    string = getResources().getString(R.string.family_account_general_toast_error);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                }
                DANAToast.PlaceComponentResult(organizerDashboardActivity, string);
            }
        }
        getFamilyDashboardPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        getFamilyDashboardPresenter().BuiltInFictitiousFunctionClassFactory();
        getFamilyDashboardPresenter().PlaceComponentResult();
        getFamilyDashboardPresenter().MyBillsEntityDataFactory();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        DaggerFamilyAccountDashboardComponent.Builder MyBillsEntityDataFactory = DaggerFamilyAccountDashboardComponent.MyBillsEntityDataFactory();
        Application application = getApplication();
        DanaApplication danaApplication = application instanceof DanaApplication ? (DanaApplication) application : null;
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(danaApplication != null ? danaApplication.getApplicationComponent() : null);
        MyBillsEntityDataFactory.getAuthRequestContext = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(new BottomSheetOnBoardingModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$getBottomSheetOnBoardingModule$1
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
            public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str, String str2) {
                BottomSheetOnBoardingContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final void onGetBottomSheetOnBoardingAvailability(boolean p0, String p1) {
                if (!p0) {
                    if (TopUpUserConsultManager.BuiltInFictitiousFunctionClassFactory() == null) {
                        OrganizerDashboardActivity.this.getFamilyDashboardPresenter().scheduleImpl();
                        return;
                    } else {
                        ((TopUpBottomSheet) r1.DatabaseTableConfigUtil.getValue()).show(OrganizerDashboardActivity.this.getSupportFragmentManager(), OrganizerDashboardActivity.SHOW_TOPUP);
                        return;
                    }
                }
                ((TopUpBottomSheet) r1.DatabaseTableConfigUtil.getValue()).show(OrganizerDashboardActivity.this.getSupportFragmentManager(), OrganizerDashboardActivity.FIRST_TIMER_TOPUP);
                OrganizerDashboardActivity.this.getOnBoardingServicePresenter().MyBillsEntityDataFactory("family_account_topup_first_timer");
            }
        }));
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (FamilyAccountDashboardModule) Preconditions.getAuthRequestContext(new FamilyAccountDashboardModule(new FamilyDashboardContract.View() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$getFamilyDashboardModule$1
            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
                FamilyDashboardContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(List list) {
                FamilyDashboardContract.View.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory() {
                FamilyDashboardContract.View.CC.getErrorConfigVersion();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void MyBillsEntityDataFactory(DashboardModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OrganizerDashboardActivity.access$loadDashboardData(OrganizerDashboardActivity.this, p0);
                OrganizerDashboardActivity.access$showDashboard(OrganizerDashboardActivity.this);
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void getAuthRequestContext() {
                OrganizerDashboardActivity.access$setViewStatusInformation(OrganizerDashboardActivity.this);
                OrganizerDashboardActivity.access$hideDashboard(OrganizerDashboardActivity.this);
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void MyBillsEntityDataFactory(List<AvailableServicesConfig> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OrganizerDashboardActivity.this.getAuthRequestContext = p0;
                OrganizerDashboardActivity.access$setItemsAvailableServices(OrganizerDashboardActivity.this, p0);
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void MyBillsEntityDataFactory(TopUpUserConsultModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                TopUpUserConsultManager.PlaceComponentResult(p0);
                ((TopUpBottomSheet) r2.DatabaseTableConfigUtil.getValue()).show(OrganizerDashboardActivity.this.getSupportFragmentManager(), OrganizerDashboardActivity.SHOW_TOPUP);
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void scheduleImpl() {
                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                OrganizerDashboardActivity organizerDashboardActivity = OrganizerDashboardActivity.this;
                OrganizerDashboardActivity organizerDashboardActivity2 = organizerDashboardActivity;
                String string = organizerDashboardActivity.getString(R.string.family_account_text_success_cancel_invitation_toast);
                Intrinsics.checkNotNullExpressionValue(string, "");
                String string2 = OrganizerDashboardActivity.this.getString(R.string.toast_success_cancel_invitation);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                DANAToast.PlaceComponentResult(organizerDashboardActivity2, string, string2);
                OrganizerDashboardActivity.access$getResendTransactionBottomSheet(OrganizerDashboardActivity.this).dismiss();
                OrganizerDashboardActivity.this.getFamilyDashboardPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void getAuthRequestContext(String p0) {
                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                OrganizerDashboardActivity organizerDashboardActivity = OrganizerDashboardActivity.this;
                OrganizerDashboardActivity organizerDashboardActivity2 = organizerDashboardActivity;
                if (p0 == null) {
                    p0 = organizerDashboardActivity.getString(R.string.family_account_failed_delete_family_account_message);
                    Intrinsics.checkNotNullExpressionValue(p0, "");
                }
                DANAToast.PlaceComponentResult(organizerDashboardActivity2, p0);
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void getErrorConfigVersion() {
                OrganizerDashboardActivity.this.getFamilyAccountAnalyticalTracker().PlaceComponentResult("Success");
                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                OrganizerDashboardActivity organizerDashboardActivity = OrganizerDashboardActivity.this;
                OrganizerDashboardActivity organizerDashboardActivity2 = organizerDashboardActivity;
                String string = organizerDashboardActivity.getString(R.string.family_account_text_resend_invitation_success);
                Intrinsics.checkNotNullExpressionValue(string, "");
                DANAToast.getAuthRequestContext(organizerDashboardActivity2, string);
                OrganizerDashboardActivity.access$getResendTransactionBottomSheet(OrganizerDashboardActivity.this).dismiss();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void MyBillsEntityDataFactory(String p0) {
                OrganizerDashboardActivity.this.getFamilyAccountAnalyticalTracker().PlaceComponentResult("Failed");
                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                OrganizerDashboardActivity organizerDashboardActivity = OrganizerDashboardActivity.this;
                OrganizerDashboardActivity organizerDashboardActivity2 = organizerDashboardActivity;
                if (p0 == null) {
                    p0 = organizerDashboardActivity.getString(R.string.family_account_text_resend_invitation_error);
                    Intrinsics.checkNotNullExpressionValue(p0, "");
                }
                DANAToast.PlaceComponentResult(organizerDashboardActivity2, p0);
                OrganizerDashboardActivity.access$getResendTransactionBottomSheet(OrganizerDashboardActivity.this).dismiss();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                OrganizerDashboardActivity.access$showShimmeringView(OrganizerDashboardActivity.this);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                OrganizerDashboardActivity.access$dismissShimmeringView(OrganizerDashboardActivity.this);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                OrganizerDashboardActivity organizerDashboardActivity = OrganizerDashboardActivity.this;
                OrganizerDashboardActivity organizerDashboardActivity2 = organizerDashboardActivity;
                String string = organizerDashboardActivity.getString(R.string.SchedulerPoolFactory);
                Intrinsics.checkNotNullExpressionValue(string, "");
                DANAToast.PlaceComponentResult(organizerDashboardActivity2, string);
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void moveToNextValue() {
                OrganizerDashboardActivity.access$showDanaLoadingDialog(OrganizerDashboardActivity.this);
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void PlaceComponentResult() {
                ((DanaLoadingDialog) OrganizerDashboardActivity.this.MyBillsEntityDataFactory.getValue()).PlaceComponentResult();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void BuiltInFictitiousFunctionClassFactory(MaxMemberLimitConfig p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OrganizerDashboardActivity.this.lookAheadTest = p0;
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                OrganizerDashboardActivity organizerDashboardActivity = OrganizerDashboardActivity.this;
                OrganizerDashboardActivity organizerDashboardActivity2 = organizerDashboardActivity;
                if (p0 == null) {
                    p0 = organizerDashboardActivity.getString(R.string.SchedulerPoolFactory);
                    Intrinsics.checkNotNullExpressionValue(p0, "");
                }
                DANAToast.PlaceComponentResult(organizerDashboardActivity2, p0);
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                final OrganizerDashboardActivity organizerDashboardActivity = OrganizerDashboardActivity.this;
                DanaH5.startContainerFullUrl(p0, new DanaH5Listener() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$getFamilyDashboardModule$1$onSuccessCreateOrderTopUpFamilyBalance$$inlined$withDanaH5Callback$1
                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final void onContainerDestroyed(Bundle p02) {
                    }

                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final void onContainerCreated(Bundle p02) {
                        OrganizerDashboardActivity.this.scheduleImpl = Boolean.TRUE;
                    }
                });
                OrganizerDashboardActivity.access$getTopUpBottomSheet(OrganizerDashboardActivity.this).dismiss();
            }

            @Override // id.dana.familyaccount.contract.FamilyDashboardContract.View
            public final void PlaceComponentResult(String p0) {
                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                OrganizerDashboardActivity organizerDashboardActivity = OrganizerDashboardActivity.this;
                OrganizerDashboardActivity organizerDashboardActivity2 = organizerDashboardActivity;
                if (p0 == null) {
                    p0 = organizerDashboardActivity.getString(R.string.SchedulerPoolFactory);
                    Intrinsics.checkNotNullExpressionValue(p0, "");
                }
                DANAToast.PlaceComponentResult(organizerDashboardActivity2, p0);
            }
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().codePointAt(3) - 74, new int[]{1532070689, 1629423609, -637742, 1847115419, -1904041827, 1981712806, 879603515, 1422524650, 1733699841, 2016692197, -1559313140, -578114861, -1581838057, 715357819}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(getPackageName().codePointAt(1) - 82, new int[]{2143594932, -734432188, -1708636429, 1269519546, 484933447, 574498628, 453885113, 1815986956, -865188790, -1319368198}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, ((Process.getThreadPriority(0) + 20) >> 6) + 35, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0), 18 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        if (Intrinsics.areEqual(this.scheduleImpl, Boolean.TRUE)) {
            TopUpUserConsultManager.MyBillsEntityDataFactory();
            getFamilyDashboardPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
            this.scheduleImpl = Boolean.FALSE;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r1, int resultCode, Intent data) {
        super.onActivityResult(r1, resultCode, data);
        if (r1 == getAuthRequestContext && resultCode == -1) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ShimmeringUtil.PlaceComponentResult(getBinding().PlaceComponentResult, R.layout.view_dashboard_family_account_skeleton);
            getFamilyDashboardPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        getOnBoardingServicePresenter().onDestroy();
        getFamilyDashboardPresenter().onDestroy();
        super.onDestroy();
    }

    public final void showResendConfirmationDialog() {
        CustomDialog.Builder builder = new CustomDialog.Builder(this);
        builder.SubSequence = getString(R.string.family_account_text_resend_title_dialog);
        builder.GetContactSyncConfig = getString(R.string.family_account_text_resend_desc_dialog);
        builder.moveToNextValue = 0L;
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$22 = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory(getString(R.string.option_yes), new Function1<View, Unit>() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$showResendConfirmationDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                OrganizerDashboardActivity.this.getFamilyDashboardPresenter().MyBillsEntityDataFactory(OrganizerDashboardActivity.this.getFamilyMemberInfoModelSelected().BuiltInFictitiousFunctionClassFactory);
                OrganizerDashboardActivity.this.getFamilyAccountAnalyticalTracker().PlaceComponentResult(true);
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(getString(R.string.option_no), new Function1<View, Unit>() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$showResendConfirmationDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                OrganizerDashboardActivity.this.getFamilyAccountAnalyticalTracker().PlaceComponentResult(false);
            }
        });
        KClassImpl$Data$declaredNonStaticMembers$22.whenAvailable = getString(R.string.lbl_cancel_invitation);
        KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda4 = getString(R.string.btn_yes_cancel_invitation);
        KClassImpl$Data$declaredNonStaticMembers$22.newProxyInstance = getString(R.string.btn_no_cancel_invitation);
        ViewExtKt.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory(), KClassImpl$Data$declaredNonStaticMembers$22.moveToNextValue);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014"}, d2 = {"Lid/dana/familyaccount/view/dashboard/OrganizerDashboardActivity$StartParams;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "getAuthRequestContext", "MyBillsEntityDataFactory", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class StartParams implements Parcelable {
        public static final Parcelable.Creator<StartParams> CREATOR = new Creator();

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public StartParams() {
            /*
                r2 = this;
                r0 = 0
                r1 = 3
                r2.<init>(r0, r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity.StartParams.<init>():void");
        }

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
                return Intrinsics.areEqual(this.MyBillsEntityDataFactory, startParams.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, startParams.PlaceComponentResult);
            }
            return false;
        }

        public final int hashCode() {
            String str = this.MyBillsEntityDataFactory;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.PlaceComponentResult;
            return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StartParams(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.MyBillsEntityDataFactory);
            p0.writeString(this.PlaceComponentResult);
        }

        public StartParams(String str, String str2) {
            this.MyBillsEntityDataFactory = str;
            this.PlaceComponentResult = str2;
        }

        public /* synthetic */ StartParams(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<StartParams> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StartParams createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new StartParams(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StartParams[] newArray(int i) {
                return new StartParams[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0017\u0010\u0010\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0007"}, d2 = {"Lid/dana/familyaccount/view/dashboard/OrganizerDashboardActivity$Companion;", "", "", "DASHBOARD_TOTAL_COLUMN", "I", "", "EXTRA_START_PARAMS", "Ljava/lang/String;", OrganizerDashboardActivity.FIRST_TIMER_TOPUP, "GET_EXIST_MEMBER", "REJECT", OrganizerDashboardActivity.RESEND_INVITATION, OrganizerDashboardActivity.SET_MEMBER_LIMIT, "getAuthRequestContext", "MyBillsEntityDataFactory", "()I", "PlaceComponentResult", OrganizerDashboardActivity.SHOW_TOPUP, "SUCCESS", "TRANSACTION_HISTORY", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        public static int MyBillsEntityDataFactory() {
            return OrganizerDashboardActivity.getAuthRequestContext;
        }
    }

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
        getAuthRequestContext = RandomInteger.BuiltInFictitiousFunctionClassFactory();
    }

    /* renamed from: $r8$lambda$0LHSGleRd79K5bP-8u9J2bbOjrg */
    public static /* synthetic */ void m2589$r8$lambda$0LHSGleRd79K5bP8u9J2bbOjrg(OrganizerDashboardActivity organizerDashboardActivity, View view) {
        Intrinsics.checkNotNullParameter(organizerDashboardActivity, "");
        organizerDashboardActivity.finish();
    }

    public static /* synthetic */ void $r8$lambda$Jinvt_ipGYeCL0No4hvLX5PcPRs(OrganizerDashboardActivity organizerDashboardActivity, View view) {
        Intrinsics.checkNotNullParameter(organizerDashboardActivity, "");
        organizerDashboardActivity.getFamilyDashboardPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        StatusInformationView statusInformationView = organizerDashboardActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda3;
        Intrinsics.checkNotNullExpressionValue(statusInformationView, "");
        statusInformationView.setVisibility(8);
    }

    public static /* synthetic */ void $r8$lambda$WVvi3qEl8abK9L9KAqsYIvtUYeo(OrganizerDashboardActivity organizerDashboardActivity, View view) {
        Intrinsics.checkNotNullParameter(organizerDashboardActivity, "");
        FamilyAccountCustomDialog.Builder builder = new FamilyAccountCustomDialog.Builder(organizerDashboardActivity);
        String string = organizerDashboardActivity.getString(R.string.family_account_dashboard_tooltip_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Intrinsics.checkNotNullParameter(string, "");
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = string;
        String string2 = organizerDashboardActivity.getString(R.string.family_account_dashboard_tooltip_description);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        Intrinsics.checkNotNullParameter(string2, "");
        builder.PlaceComponentResult = string2;
        String string3 = organizerDashboardActivity.getString(R.string.family_account_dashboard_tooltip_button);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OrganizerDashboardActivity.$r8$lambda$QOjuzYaux6GbdnW3ey9T3dq04g4(view2);
            }
        };
        Boolean bool = Boolean.TRUE;
        builder.moveToNextValue = string3;
        builder.scheduleImpl = onClickListener;
        builder.lookAheadTest = bool;
        FamilyAccountCustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$22 = FamilyAccountCustomDialog.Builder.MyBillsEntityDataFactory(builder, null, Boolean.FALSE, null, 5).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.DatabaseTableConfigUtil = organizerDashboardActivity.getString(R.string.lbl_family_account_popup);
        KClassImpl$Data$declaredNonStaticMembers$22.getErrorConfigVersion = organizerDashboardActivity.getString(R.string.btn_family_member_got_it);
        new FamilyAccountCustomDialog(KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22.GetContactSyncConfig, KClassImpl$Data$declaredNonStaticMembers$22, null).MyBillsEntityDataFactory();
    }

    /* renamed from: $r8$lambda$_YTKJph6R5msHr-RBZVoCpmeyyI */
    public static /* synthetic */ void m2590$r8$lambda$_YTKJph6R5msHrRBZVoCpmeyyI(OrganizerDashboardActivity organizerDashboardActivity, View view) {
        Intrinsics.checkNotNullParameter(organizerDashboardActivity, "");
        BottomSheetHelpActivity.Companion companion = BottomSheetHelpActivity.INSTANCE;
        String string = organizerDashboardActivity.getString(R.string.bottom_help_family_account_dashboard_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = organizerDashboardActivity.getString(R.string.bottom_help_family_account_dashboard_first_subtitle);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String string3 = organizerDashboardActivity.getString(R.string.bottom_help_family_account_dashboard_first_body_text);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = organizerDashboardActivity.getString(R.string.bottom_help_family_account_dashboard_second_subtitle);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        String string5 = organizerDashboardActivity.getString(R.string.bottom_help_family_account_dashboard_second_body_text);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        String string6 = organizerDashboardActivity.getString(R.string.bottom_help_family_account_dashboard_third_subtitle);
        Intrinsics.checkNotNullExpressionValue(string6, "");
        String string7 = organizerDashboardActivity.getString(R.string.bottom_help_family_account_dashboard_third_body_text);
        Intrinsics.checkNotNullExpressionValue(string7, "");
        List listOf = CollectionsKt.listOf((Object[]) new ContentOnBoardingModel[]{new ContentOnBoardingModel((int) R.drawable.ic_illustration_family_account_family, string2, string3), new ContentOnBoardingModel((int) R.drawable.ic_illustration_family_account_children_pay, string4, string5), new ContentOnBoardingModel((int) R.drawable.ic_illustration_family_account_setting, string6, string7)});
        String string8 = organizerDashboardActivity.getString(R.string.lbl_family_account);
        Intrinsics.checkNotNullExpressionValue(string8, "");
        organizerDashboardActivity.startActivity(BottomSheetHelpActivity.Companion.PlaceComponentResult(organizerDashboardActivity, new OnBoardingModel(string, "list", listOf, "family_account", string8, null, null, 96, null), true));
    }

    public static /* synthetic */ void $r8$lambda$yo37cxxdIaxvECPn4gEKurPI4Mk(OrganizerDashboardActivity organizerDashboardActivity, View view) {
        Intrinsics.checkNotNullParameter(organizerDashboardActivity, "");
        organizerDashboardActivity.getOnBoardingServicePresenter().KClassImpl$Data$declaredNonStaticMembers$2("family_account_topup_first_timer");
    }

    public static final /* synthetic */ void access$dismissShimmeringView(OrganizerDashboardActivity organizerDashboardActivity) {
        SkeletonScreen skeletonScreen = organizerDashboardActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    public static final /* synthetic */ HistoryTransactionBottomSheet access$getHistoryTransactionBottomSheet(OrganizerDashboardActivity organizerDashboardActivity) {
        return (HistoryTransactionBottomSheet) organizerDashboardActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ ResendInvitationBottomSheet access$getResendTransactionBottomSheet(OrganizerDashboardActivity organizerDashboardActivity) {
        return (ResendInvitationBottomSheet) organizerDashboardActivity.getErrorConfigVersion.getValue();
    }

    public static final /* synthetic */ TopUpBottomSheet access$getTopUpBottomSheet(OrganizerDashboardActivity organizerDashboardActivity) {
        return (TopUpBottomSheet) organizerDashboardActivity.DatabaseTableConfigUtil.getValue();
    }

    public static final /* synthetic */ void access$hideDashboard(OrganizerDashboardActivity organizerDashboardActivity) {
        NestedScrollView nestedScrollView = organizerDashboardActivity.getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
        nestedScrollView.setVisibility(8);
        StatusInformationView statusInformationView = organizerDashboardActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda3;
        Intrinsics.checkNotNullExpressionValue(statusInformationView, "");
        statusInformationView.setVisibility(0);
    }

    public static final /* synthetic */ void access$loadDashboardData(final OrganizerDashboardActivity organizerDashboardActivity, final DashboardModel dashboardModel) {
        String format;
        boolean z;
        MembersForOrganizerAdapter membersForOrganizerAdapter = organizerDashboardActivity.BuiltInFictitiousFunctionClassFactory;
        MaxMemberLimitConfig maxMemberLimitConfig = null;
        if (membersForOrganizerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            membersForOrganizerAdapter = null;
        }
        List<FamilyMemberInfoModel> list = dashboardModel.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(list, "");
        List mutableList = CollectionsKt.toMutableList(membersForOrganizerAdapter.getAuthRequestContext);
        mutableList.clear();
        mutableList.addAll(list);
        if (list.size() < 6) {
            mutableList.add(membersForOrganizerAdapter.PlaceComponentResult);
        }
        BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(membersForOrganizerAdapter, mutableList);
        TextView textView = organizerDashboardActivity.getBinding().isLayoutRequested;
        MoneyViewModel moneyViewModel = dashboardModel.getAuthRequestContext;
        StringBuilder sb = new StringBuilder();
        sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
        format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
        if (format == null) {
            format = "";
        }
        sb.append(format);
        textView.setText(sb.toString());
        List<TransactionHistoryModel> list2 = organizerDashboardActivity.transactionHistoryModels;
        if (list2 != null) {
            list2.clear();
        }
        List<FamilyMemberInfoModel> list3 = dashboardModel.MyBillsEntityDataFactory;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list3) {
            String str = ((FamilyMemberInfoModel) obj).MyBillsEntityDataFactory;
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "");
            String upperCase = str.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            if (Intrinsics.areEqual(upperCase, "MEMBER")) {
                arrayList.add(obj);
            }
        }
        int i = 0;
        for (Object obj2 : arrayList) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            FamilyMemberInfoModel familyMemberInfoModel = (FamilyMemberInfoModel) obj2;
            List<TransactionHistoryModel> list4 = organizerDashboardActivity.transactionHistoryModels;
            if (list4 != null) {
                list4.add(i, new TransactionHistoryModel(familyMemberInfoModel.getAuthRequestContext.scheduleImpl, familyMemberInfoModel.getAuthRequestContext.PlaceComponentResult, true));
            }
            i++;
        }
        MoneyViewModel moneyViewModel2 = dashboardModel.getAuthRequestContext;
        DanaButtonSecondaryView danaButtonSecondaryView = organizerDashboardActivity.getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrganizerDashboardActivity.$r8$lambda$yo37cxxdIaxvECPn4gEKurPI4Mk(OrganizerDashboardActivity.this, view);
            }
        });
        MaxMemberLimitConfig maxMemberLimitConfig2 = organizerDashboardActivity.lookAheadTest;
        if (maxMemberLimitConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            maxMemberLimitConfig = maxMemberLimitConfig2;
        }
        long parseLong = Long.parseLong(maxMemberLimitConfig.getMaxAllMemberLimit());
        Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
        danaButtonSecondaryView.setVisibility(moneyViewModel2.PlaceComponentResult(parseLong) ? 0 : 8);
        String cleanAll = NumberUtils.getCleanAll(moneyViewModel2.PlaceComponentResult);
        if (cleanAll == null) {
            cleanAll = "0";
        }
        Long longOrNull = StringsKt.toLongOrNull(cleanAll);
        if ((longOrNull != null ? longOrNull.longValue() : 0L) == parseLong) {
            danaButtonSecondaryView.setDisabled(danaButtonSecondaryView.getResources().getString(R.string.balance_topup));
            z = false;
        } else {
            z = true;
        }
        danaButtonSecondaryView.setEnabled(z);
        SectionCellViewSimple sectionCellViewSimple = organizerDashboardActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2;
        sectionCellViewSimple.initOrganizerDashboardLimitSection(FamilyMemberInfoModelKt.MyBillsEntityDataFactory(dashboardModel.MyBillsEntityDataFactory));
        if (FamilyMemberInfoModelKt.MyBillsEntityDataFactory(dashboardModel.MyBillsEntityDataFactory)) {
            Intrinsics.checkNotNullExpressionValue(sectionCellViewSimple, "");
            SafeClickListenerExtensionKt.MyBillsEntityDataFactory(sectionCellViewSimple, new Function1<View, Unit>() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$setHistoryAndLimit$1$1
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
                    List list5;
                    MaxMemberLimitConfig maxMemberLimitConfig3;
                    Intrinsics.checkNotNullParameter(view, "");
                    OrganizerDashboardActivity organizerDashboardActivity2 = OrganizerDashboardActivity.this;
                    ManageMemberLimitActivity.Companion companion = ManageMemberLimitActivity.INSTANCE;
                    Context applicationContext = OrganizerDashboardActivity.this.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "");
                    DashboardModel dashboardModel2 = dashboardModel;
                    list5 = OrganizerDashboardActivity.this.getAuthRequestContext;
                    MaxMemberLimitConfig maxMemberLimitConfig4 = null;
                    if (list5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        list5 = null;
                    }
                    maxMemberLimitConfig3 = OrganizerDashboardActivity.this.lookAheadTest;
                    if (maxMemberLimitConfig3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        maxMemberLimitConfig4 = maxMemberLimitConfig3;
                    }
                    Intent BuiltInFictitiousFunctionClassFactory = ManageMemberLimitActivity.Companion.BuiltInFictitiousFunctionClassFactory(applicationContext, dashboardModel2, list5, maxMemberLimitConfig4);
                    OrganizerDashboardActivity.Companion companion2 = OrganizerDashboardActivity.INSTANCE;
                    organizerDashboardActivity2.startActivityForResult(BuiltInFictitiousFunctionClassFactory, OrganizerDashboardActivity.Companion.MyBillsEntityDataFactory());
                }
            });
        }
        SectionCellViewSimple sectionCellViewSimple2 = organizerDashboardActivity.getBinding().GetContactSyncConfig;
        sectionCellViewSimple2.initHistorySection(FamilyMemberInfoModelKt.MyBillsEntityDataFactory(dashboardModel.MyBillsEntityDataFactory));
        if (FamilyMemberInfoModelKt.MyBillsEntityDataFactory(dashboardModel.MyBillsEntityDataFactory)) {
            sectionCellViewSimple2.setEnabled(true);
            Intrinsics.checkNotNullExpressionValue(sectionCellViewSimple2, "");
            SafeClickListenerExtensionKt.MyBillsEntityDataFactory(sectionCellViewSimple2, new Function1<View, Unit>() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$setHistoryAndLimit$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    OrganizerDashboardActivity.access$getHistoryTransactionBottomSheet(OrganizerDashboardActivity.this).show(OrganizerDashboardActivity.this.getSupportFragmentManager(), "TRANSACTION_HISTORY");
                }
            });
            return;
        }
        sectionCellViewSimple2.setEnabled(false);
    }

    public static final /* synthetic */ void access$setItemsAvailableServices(OrganizerDashboardActivity organizerDashboardActivity, List list) {
        FamilyDashboardServicesAdapter familyDashboardServicesAdapter = organizerDashboardActivity.PlaceComponentResult;
        MembersForOrganizerAdapter membersForOrganizerAdapter = null;
        if (familyDashboardServicesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            familyDashboardServicesAdapter = null;
        }
        BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(familyDashboardServicesAdapter, list);
        MembersForOrganizerAdapter membersForOrganizerAdapter2 = organizerDashboardActivity.BuiltInFictitiousFunctionClassFactory;
        if (membersForOrganizerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            membersForOrganizerAdapter = membersForOrganizerAdapter2;
        }
        Intrinsics.checkNotNullParameter(list, "");
        membersForOrganizerAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = (ArrayList) list;
        membersForOrganizerAdapter.notifyDataSetChanged();
    }

    public static final /* synthetic */ void access$setViewStatusInformation(final OrganizerDashboardActivity organizerDashboardActivity) {
        StatusInformationView statusInformationView = organizerDashboardActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda3;
        statusInformationView.setStatusInformationType(StatusInformationType.GENERAL_STATUS_ERROR);
        DanaButtonPrimaryView btnStatusInformationGotIt = statusInformationView.getBtnStatusInformationGotIt();
        if (btnStatusInformationGotIt != null) {
            btnStatusInformationGotIt.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OrganizerDashboardActivity.$r8$lambda$Jinvt_ipGYeCL0No4hvLX5PcPRs(OrganizerDashboardActivity.this, view);
                }
            });
        }
    }

    public static final /* synthetic */ void access$setupFamilyMemberItemClickListener(OrganizerDashboardActivity organizerDashboardActivity, FamilyMemberInfoModel familyMemberInfoModel) {
        MemberInfoModel memberInfoModel;
        MemberInfoModel memberInfoModel2;
        String str = familyMemberInfoModel.MyBillsEntityDataFactory;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        MaxMemberLimitConfig maxMemberLimitConfig = null;
        MembersForOrganizerAdapter membersForOrganizerAdapter = null;
        switch (upperCase.hashCode()) {
            case -2024440166:
                if (upperCase.equals("MEMBER")) {
                    ManageMemberActivity.Companion companion = ManageMemberActivity.INSTANCE;
                    Context applicationContext = organizerDashboardActivity.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "");
                    List<AvailableServicesConfig> list = organizerDashboardActivity.getAuthRequestContext;
                    if (list == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        list = null;
                    }
                    MaxMemberLimitConfig maxMemberLimitConfig2 = organizerDashboardActivity.lookAheadTest;
                    if (maxMemberLimitConfig2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        maxMemberLimitConfig = maxMemberLimitConfig2;
                    }
                    organizerDashboardActivity.startActivityForResult(ManageMemberActivity.Companion.BuiltInFictitiousFunctionClassFactory(applicationContext, familyMemberInfoModel, list, maxMemberLimitConfig), getAuthRequestContext);
                    return;
                }
                return;
            case 35394935:
                if (upperCase.equals("PENDING")) {
                    organizerDashboardActivity.setFamilyMemberInfoModelSelected(familyMemberInfoModel);
                    ((ResendInvitationBottomSheet) organizerDashboardActivity.getErrorConfigVersion.getValue()).show(organizerDashboardActivity.getSupportFragmentManager(), RESEND_INVITATION);
                    return;
                }
                return;
            case 616564505:
                if (upperCase.equals(FamilyAccountInvitationStatusType.ADD_MEMBER)) {
                    Intent intent = new Intent(organizerDashboardActivity, FamilyInviteMemberActivity.class);
                    FamilyTncConsentActivity.Companion companion2 = FamilyTncConsentActivity.INSTANCE;
                    String PlaceComponentResult2 = FamilyTncConsentActivity.Companion.PlaceComponentResult();
                    MembersForOrganizerAdapter membersForOrganizerAdapter2 = organizerDashboardActivity.BuiltInFictitiousFunctionClassFactory;
                    if (membersForOrganizerAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        membersForOrganizerAdapter2 = null;
                    }
                    FamilyMemberInfoModel authRequestContext = membersForOrganizerAdapter2.getAuthRequestContext(0);
                    intent.putExtra(PlaceComponentResult2, (authRequestContext == null || (memberInfoModel2 = authRequestContext.getAuthRequestContext) == null) ? null : memberInfoModel2.PlaceComponentResult);
                    FamilyTncConsentActivity.Companion companion3 = FamilyTncConsentActivity.INSTANCE;
                    String BuiltInFictitiousFunctionClassFactory = FamilyTncConsentActivity.Companion.BuiltInFictitiousFunctionClassFactory();
                    MembersForOrganizerAdapter membersForOrganizerAdapter3 = organizerDashboardActivity.BuiltInFictitiousFunctionClassFactory;
                    if (membersForOrganizerAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        membersForOrganizerAdapter3 = null;
                    }
                    FamilyMemberInfoModel authRequestContext2 = membersForOrganizerAdapter3.getAuthRequestContext(0);
                    intent.putExtra(BuiltInFictitiousFunctionClassFactory, (authRequestContext2 == null || (memberInfoModel = authRequestContext2.getAuthRequestContext) == null) ? null : memberInfoModel.getErrorConfigVersion);
                    MembersForOrganizerAdapter membersForOrganizerAdapter4 = organizerDashboardActivity.BuiltInFictitiousFunctionClassFactory;
                    if (membersForOrganizerAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        membersForOrganizerAdapter = membersForOrganizerAdapter4;
                    }
                    intent.putParcelableArrayListExtra(GET_EXIST_MEMBER, new ArrayList<>(membersForOrganizerAdapter.getAuthRequestContext));
                    organizerDashboardActivity.startActivity(intent);
                    return;
                }
                return;
            case 1698997952:
                if (upperCase.equals(FamilyAccountInvitationStatusType.ACCOUNT_OWNER)) {
                    ManageOrganizerActivity.Companion companion4 = ManageOrganizerActivity.INSTANCE;
                    Context applicationContext2 = organizerDashboardActivity.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext2, "");
                    organizerDashboardActivity.startActivity(ManageOrganizerActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(applicationContext2, familyMemberInfoModel));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static final /* synthetic */ void access$showDanaLoadingDialog(OrganizerDashboardActivity organizerDashboardActivity) {
        DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) organizerDashboardActivity.MyBillsEntityDataFactory.getValue();
        if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            return;
        }
        danaLoadingDialog.MyBillsEntityDataFactory.show();
        danaLoadingDialog.getAuthRequestContext.startRefresh();
    }

    public static final /* synthetic */ void access$showDashboard(OrganizerDashboardActivity organizerDashboardActivity) {
        NestedScrollView nestedScrollView = organizerDashboardActivity.getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
        nestedScrollView.setVisibility(0);
        StatusInformationView statusInformationView = organizerDashboardActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda3;
        Intrinsics.checkNotNullExpressionValue(statusInformationView, "");
        statusInformationView.setVisibility(8);
    }

    public static final /* synthetic */ void access$showShimmeringView(OrganizerDashboardActivity organizerDashboardActivity) {
        SkeletonScreen skeletonScreen = organizerDashboardActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        LayoutToolbarBinding layoutToolbarBinding = getBinding().lookAheadTest;
        TextView textView = layoutToolbarBinding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        ImageView imageView = layoutToolbarBinding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
        layoutToolbarBinding.initRecordTimeStamp.setText(getString(R.string.family_account_text_title_toolbar));
        LayoutToolbarBinding layoutToolbarBinding2 = getBinding().lookAheadTest;
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationIcon(R.drawable.btn_arrow_left);
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrganizerDashboardActivity.m2589$r8$lambda$0LHSGleRd79K5bP8u9J2bbOjrg(OrganizerDashboardActivity.this, view);
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
        setMenuRightButton();
        getBinding().lookAheadTest.getErrorConfigVersion.setContentDescription(getResources().getString(R.string.btn_tooltip_family));
        getBinding().lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda0.setContentDescription(getString(R.string.btn_help_family));
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = PrepareContext;
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
        int[] iArr5 = PrepareContext;
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

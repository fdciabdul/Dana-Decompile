package id.dana.sendmoney.ui.groupsend.landing.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ComponentActivity;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelKt;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContract;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.plus.security.lite.SecLiteException;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.DanaLogoLoadingDialog;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.usereducation.BottomSheetOnBoardingScenario;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.constants.GroupSendRecipientType;
import id.dana.sendmoney.databinding.ActivityGroupSendLandingBinding;
import id.dana.sendmoney.di.component.GroupSendComponent;
import id.dana.sendmoney.di.provider.GroupSendComponentProvider;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;
import id.dana.sendmoney.domain.groupsend.model.config.GroupSendScenarioConfig;
import id.dana.sendmoney.ui.common.EmptyStateView;
import id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity;
import id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendQueryAdapter;
import id.dana.sendmoney.ui.groupsend.landing.mapper.GroupSendScenarioModelMapperKt;
import id.dana.sendmoney.ui.groupsend.landing.model.GroupSendScenarioConfigModel;
import id.dana.sendmoney.ui.groupsend.landing.view.GroupSendLandingShimmerExt;
import id.dana.sendmoney.ui.groupsend.landing.view.GroupSendNavigationBottomSheet;
import id.dana.sendmoney.ui.groupsend.landing.view.GroupSendOnboardingDialogFragment;
import id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingUiState;
import id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingViewModel;
import id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity;
import id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity;
import id.dana.sendmoney.ui.groupsend.summary.model.GroupSendIntentModel;
import id.dana.sendmoney.util.GroupSendTrackerHelper;
import id.dana.sendmoney.util.SourceTypeProperty;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\bC\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\u0005J\u0015\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u000f\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0011R\u0013\u0010\u000f\u001a\u00020\u0014X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0019\u001a\u00020\u0017X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0012\u001a\u00020\u001aX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0015\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\u001e\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b5\u00103R\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b6\u00103R\u0016\u0010)\u001a\u0002078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0013\u0010$\u001a\u00020AX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bB\u0010\u0016"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/activity/GroupSendLandingActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/sendmoney/databinding/ActivityGroupSendLandingBinding;", "", "configToolbar", "()V", "inflateViewBinding", "()Lid/dana/sendmoney/databinding/ActivityGroupSendLandingBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "", "groupId", "navigateToDetailActivity", "(Ljava/lang/String;)V", "p0", "BuiltInFictitiousFunctionClassFactory", "", "(Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "Lid/dana/sendmoney/ui/groupsend/landing/view/GroupSendNavigationBottomSheet;", "getAuthRequestContext", "Lkotlin/Lazy;", "Lid/dana/sendmoney/ui/groupsend/landing/view/GroupSendOnboardingDialogFragment;", "lookAheadTest", "MyBillsEntityDataFactory", "Lid/dana/core/ui/dialog/DanaLogoLoadingDialog;", "scheduleImpl", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "getErrorConfigVersion", "Landroidx/activity/result/ActivityResultLauncher;", "Lid/dana/sendmoney/di/component/GroupSendComponent;", "initRecordTimeStamp", "Lid/dana/sendmoney/di/component/GroupSendComponent;", "Lid/dana/sendmoney/ui/groupsend/landing/activity/GroupSendQueryAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/sendmoney/ui/groupsend/landing/activity/GroupSendQueryAdapter;", "moveToNextValue", "", "Lid/dana/sendmoney/ui/groupsend/landing/model/GroupSendScenarioConfigModel;", "GetContactSyncConfig", "Ljava/util/List;", "Lid/dana/sendmoney/util/GroupSendTrackerHelper;", "groupSendTrackerHelper", "Lid/dana/sendmoney/util/GroupSendTrackerHelper;", "getGroupSendTrackerHelper", "()Lid/dana/sendmoney/util/GroupSendTrackerHelper;", "setGroupSendTrackerHelper", "(Lid/dana/sendmoney/util/GroupSendTrackerHelper;)V", "DatabaseTableConfigUtil", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda8", "", "NetworkUserEntityData$$ExternalSyntheticLambda7", "I", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/core/ui/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/core/ui/di/module/ViewModelFactory;)V", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingViewModel;", "newProxyInstance", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendLandingActivity extends BaseViewBindingActivity<ActivityGroupSendLandingBinding> {
    public static final String ACTIVITY_NAME = "GroupSendLandingActivity";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int FragmentBottomSheetPaymentSettingBinding = 0;
    public static final String IS_GROUP_MODIFIED = "IS_GROUP_MODIFIED";
    private static short[] NetworkUserEntityData$$ExternalSyntheticLambda4;
    private static byte[] NetworkUserEntityData$$ExternalSyntheticLambda6;
    private static int PrepareContext;
    private static int isLayoutRequested;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private List<GroupSendScenarioConfigModel> lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private GroupSendQueryAdapter moveToNextValue;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private ActivityResultLauncher<Intent> PlaceComponentResult;
    @Inject
    public GroupSendTrackerHelper groupSendTrackerHelper;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private GroupSendComponent getAuthRequestContext;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda2;
    @Inject
    public ViewModelFactory viewModelFactory;
    public static final byte[] $$a = {42, -75, 2, Ascii.US, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 190;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {Ascii.ETB, -59, 18, 83, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 13;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private int GetContactSyncConfig = 10;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<DanaLogoLoadingDialog>() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$danaLogoLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLogoLoadingDialog invoke() {
            return new DanaLogoLoadingDialog(GroupSendLandingActivity.this);
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private boolean scheduleImpl = true;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<GroupSendOnboardingDialogFragment>() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$bottomSheetOnboardingGroupSend$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GroupSendOnboardingDialogFragment invoke() {
            final GroupSendLandingActivity groupSendLandingActivity = GroupSendLandingActivity.this;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$bottomSheetOnboardingGroupSend$2.1
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
                    List list;
                    List list2;
                    List list3;
                    list = GroupSendLandingActivity.this.lookAheadTest;
                    if (list != null) {
                        list2 = GroupSendLandingActivity.this.lookAheadTest;
                        List list4 = null;
                        if (list2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            list2 = null;
                        }
                        if (list2.size() == 1) {
                            list3 = GroupSendLandingActivity.this.lookAheadTest;
                            if (list3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                            } else {
                                list4 = list3;
                            }
                            if (Intrinsics.areEqual(((GroupSendScenarioConfigModel) list4.get(0)).PlaceComponentResult, GroupSendRecipientType.CONTACT)) {
                                GroupSendLandingActivity.this.BuiltInFictitiousFunctionClassFactory(GroupSendRecipientType.CONTACT);
                            }
                        }
                        GroupSendLandingActivity.access$showBottomSheetNavigationGroupSend(GroupSendLandingActivity.this);
                    }
                    GroupSendLandingActivity.access$saveDisplayedPermissionRequestDialog(GroupSendLandingActivity.this);
                }
            };
            final GroupSendLandingActivity groupSendLandingActivity2 = GroupSendLandingActivity.this;
            return new GroupSendOnboardingDialogFragment(function0, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$bottomSheetOnboardingGroupSend$2.2
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
                    GroupSendLandingActivity.access$saveDisplayedPermissionRequestDialog(GroupSendLandingActivity.this);
                }
            });
        }
    });

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<GroupSendNavigationBottomSheet>() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$bottomSheetNavigationGroupSend$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GroupSendNavigationBottomSheet invoke() {
            final GroupSendLandingActivity groupSendLandingActivity = GroupSendLandingActivity.this;
            return new GroupSendNavigationBottomSheet(new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$bottomSheetNavigationGroupSend$2.1
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
                    GroupSendLandingActivity.this.BuiltInFictitiousFunctionClassFactory(str);
                }
            });
        }
    });

    static {
        MyBillsEntityDataFactory();
        INSTANCE = new Companion(null);
    }

    static void MyBillsEntityDataFactory() {
        isLayoutRequested = 1257195757;
        FragmentBottomSheetPaymentSettingBinding = 565803019;
        NetworkUserEntityData$$ExternalSyntheticLambda6 = new byte[]{-100, 99, 108, -107, -117, 68, -102, -108, 108, -110, 106, -114, -67, -116, 33, -97, -112, -84, 85, 100, 101, 98, -111, 105, -110, 96, -103, 106, -116, 97, 101, 98, 99, -97, -80, 82, -103, -106, 108, -97, 98, -115, -97, -111, -99, 107, 98, -67, -67, 36, -101, -34, 85, 100, 101, 98, -111, 105, -110, 100, -117, 67, -109, -80, -100, 78, -77, -99, 81, -80, -104, 103, 96, 76, -78, -104, 99, 98, 75, -101, 98, -83, 81, -77, -102, 80, -79, 76, -97, 96, -100, -76, -102, -97, 100, -102, 96, 82, 96, -100, 97, -79, 96, 96, 74, -85, 103, -99, 76, -77, 80, -77, -104, 80, 96, -83, -98, 96, -98, 102, 97, -97, -99, -101, -97, 99, -103, 101, 75, -83, 83, -86, 100, -99, -100, 82, -97, -76, -101, 79, -98, -82, -97, 81, -77, 76, -77, 72, -77, -100, 98, -102, 82, -84, 84, -85, -97, 97, -100, -97, 82, -80, 99, 73, 96, -77, -105, 104, 76, -99, -79, -98, 75, -101, -97, 80, -81, 98, -101, 97, -99, 80, -86, 96, 82, -99, -75, 76, -101, -98, -82, 103, -101, -100, 84, -79, -97, -99, 96, 74, -75, -103, 81, -78, 75, -77, 78, -97, -79, 96, 76, -80, -101, 77, 96, -81, 81, -81, 80, -101, -75, -104, 98, -99, -97, 102, -97, -97, -101, -99, 100, 97, 72, 98, -85, 96, 96, -103, -106, 112, -114, -87, 98, 35, -40, 36, -98, -111, 97, 102, -102, -91, 89, 102, -112, -83, 93, 97, -109, -86, 86, 108, -114, 115, -101, 97, -112, 109, -114, 115, -111, -90, 37, -98, -115, 97, 112, -116, 99, 108, -107, 107, -39, 82, 108, -110, 98, -86, -97, 106, 88, -100, 99, -97, -109, 96, -101, 101, -103, 106, -97, -97, -97, -97, -97, -97, -97, -97, -97};
        PrepareContext = -1874685084;
    }

    private static void a(short s, byte b, short s2, Object[] objArr) {
        int i = s + 4;
        int i2 = s2 + 97;
        int i3 = 23 - b;
        byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
        byte[] bArr2 = new byte[i3];
        int i4 = -1;
        int i5 = i3 - 1;
        if (bArr == null) {
            i2 = (i5 + (-i)) - 4;
            i = i;
            i5 = i5;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
        }
        while (true) {
            int i6 = i + 1;
            int i7 = i4 + 1;
            bArr2[i7] = (byte) i2;
            if (i7 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i2 = (i2 + (-bArr[i6])) - 4;
            i = i6;
            i5 = i5;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = 46 - r6
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r7 = r7 * 3
            int r7 = 42 - r7
            byte[] r0 = id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity.$$a
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L37:
            int r8 = r8 + r6
            int r8 = r8 + (-7)
            r6 = r7
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity.c(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:333:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x0750  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x0759  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x0916  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x091b  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x091f  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x0ad1 A[ORIG_RETURN, RETURN] */
    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r32) {
        /*
            Method dump skipped, instructions count: 2770
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity.attachBaseContext(android.content.Context):void");
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
        try {
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[7];
            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[25];
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], objArr3);
            int i = ((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion - 1800810580;
            try {
                byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr4 = new Object[1];
                a(b3, b4, b4, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], new Object[1]);
                Object[] objArr5 = new Object[1];
                b(i, ((ApplicationInfo) cls2.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 129, (byte) (ViewConfiguration.getMinimumFlingVelocity() >> 16), (short) (getPackageName().codePointAt(1) - 100), 626140207 - (Process.myPid() >> 22), objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                int gidForName = Process.getGidForName("") - 1800810534;
                try {
                    byte b5 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                    byte b6 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                    Object[] objArr6 = new Object[1];
                    a(b5, b6, b6, objArr6);
                    Class<?> cls4 = Class.forName((String) objArr6[0]);
                    a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], new Object[1]);
                    Object[] objArr7 = new Object[1];
                    b(gidForName, ((ApplicationInfo) cls4.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 142, (byte) (getPackageName().codePointAt(2) - 46), (short) (ViewConfiguration.getEdgeSlop() >> 16), super.getResources().getString(R.string.manage_bills).substring(8, 9).length() + 626140223, objArr7);
                    int intValue = ((Integer) cls3.getDeclaredMethod((String) objArr7[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                    if (intValue < 99000 || intValue > 99999) {
                        Context baseContext = getBaseContext();
                        if (baseContext == null) {
                            int length = super.getResources().getString(R.string.nps_survey_title_suggestion).substring(0, 1).length() - 1800810548;
                            int codePointAt = getPackageName().codePointAt(0) - 193;
                            byte lastIndexOf = (byte) (TextUtils.lastIndexOf("", '0', 0, 0) + 1);
                            short codePointAt2 = (short) (super.getResources().getString(R.string.bottom_on_boarding_body_text_dana_kaget_fourth).substring(35, 37).codePointAt(1) - 32);
                            try {
                                byte b7 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                                byte b8 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                                Object[] objArr8 = new Object[1];
                                a(b7, b8, b8, objArr8);
                                Class<?> cls5 = Class.forName((String) objArr8[0]);
                                Object[] objArr9 = new Object[1];
                                a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], objArr9);
                                int i2 = ((ApplicationInfo) cls5.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 626140132;
                                Object[] objArr10 = new Object[1];
                                b(length, codePointAt, lastIndexOf, codePointAt2, i2, objArr10);
                                Class<?> cls6 = Class.forName((String) objArr10[0]);
                                int length2 = super.getResources().getString(R.string.family_account_text_invite_by_phone_numbers).substring(1, 2).length() - 1800810546;
                                try {
                                    byte b9 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                                    byte b10 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                                    Object[] objArr11 = new Object[1];
                                    a(b9, b10, b10, objArr11);
                                    Class<?> cls7 = Class.forName((String) objArr11[0]);
                                    Object[] objArr12 = new Object[1];
                                    a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], objArr12);
                                    int i3 = ((ApplicationInfo) cls7.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion - 129;
                                    byte length3 = (byte) (super.getResources().getString(R.string.auto_redirect_payment).substring(15, 16).length() - 1);
                                    try {
                                        byte b11 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                                        byte b12 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                                        Object[] objArr13 = new Object[1];
                                        a(b11, b12, b12, objArr13);
                                        Class<?> cls8 = Class.forName((String) objArr13[0]);
                                        a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], new Object[1]);
                                        Object[] objArr14 = new Object[1];
                                        b(length2, i3, length3, (short) (((ApplicationInfo) cls8.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33), 626140189 - ((byte) KeyEvent.getModifierMetaStateMask()), objArr14);
                                        baseContext = (Context) cls6.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
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
                                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                                }
                                Object invoke = ((Method) obj).invoke(null, null);
                                int resolveSize = View.resolveSize(0, 0) - 1800810589;
                                try {
                                    byte b13 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                                    byte b14 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                                    Object[] objArr15 = new Object[1];
                                    a(b13, b14, b14, objArr15);
                                    Class<?> cls9 = Class.forName((String) objArr15[0]);
                                    a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], new Object[1]);
                                    Object[] objArr16 = new Object[1];
                                    b(resolveSize, ((ApplicationInfo) cls9.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 99, (byte) TextUtils.indexOf("", "", 0, 0), (short) (ViewConfiguration.getEdgeSlop() >> 16), super.getResources().getString(R.string.desc_tap_card_please).substring(4, 5).length() + 626140227, objArr16);
                                    String str = (String) objArr16[0];
                                    int length4 = super.getResources().getString(R.string.my_bills_internet_connection_problem).substring(18, 21).length() - 1800810550;
                                    int myTid = (Process.myTid() >> 22) - 50;
                                    try {
                                        byte b15 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                                        byte b16 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                                        Object[] objArr17 = new Object[1];
                                        a(b15, b16, b16, objArr17);
                                        Class<?> cls10 = Class.forName((String) objArr17[0]);
                                        a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], new Object[1]);
                                        byte b17 = (byte) (((ApplicationInfo) cls10.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33);
                                        try {
                                            byte b18 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                                            byte b19 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                                            Object[] objArr18 = new Object[1];
                                            a(b18, b19, b19, objArr18);
                                            Class<?> cls11 = Class.forName((String) objArr18[0]);
                                            a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], new Object[1]);
                                            Object[] objArr19 = new Object[1];
                                            b(length4, myTid, b17, (short) (((ApplicationInfo) cls11.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 33), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 626140274, objArr19);
                                            String str2 = (String) objArr19[0];
                                            Object[] objArr20 = new Object[1];
                                            b(super.getResources().getString(R.string.error_maxlength_phonenumber).substring(5, 6).codePointAt(0) - 1800810626, super.getResources().getString(R.string.akamai_verify_dialog_desc).substring(3, 4).length() - 51, (byte) (super.getResources().getString(R.string.Sysytem_error).substring(8, 9).length() - 1), (short) (super.getResources().getString(R.string.res_0x7f1313a0_securitysettingsactivity_createpinlauncher_2_1).substring(5, 6).codePointAt(0) - 97), ExpandableListView.getPackedPositionChild(0L) + 626140339, objArr20);
                                            String str3 = (String) objArr20[0];
                                            int codePointAt3 = getPackageName().codePointAt(4) - 1800810637;
                                            int codePointAt4 = super.getResources().getString(R.string.bottom_on_boarding_subtitle_my_bills_first).substring(6, 7).codePointAt(0) - 151;
                                            try {
                                                byte b20 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                                                byte b21 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                                                Object[] objArr21 = new Object[1];
                                                a(b20, b21, b21, objArr21);
                                                Class<?> cls12 = Class.forName((String) objArr21[0]);
                                                a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], new Object[1]);
                                                byte b22 = (byte) (((ApplicationInfo) cls12.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 33);
                                                try {
                                                    byte b23 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                                                    byte b24 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                                                    Object[] objArr22 = new Object[1];
                                                    a(b23, b24, b24, objArr22);
                                                    Class<?> cls13 = Class.forName((String) objArr22[0]);
                                                    a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], new Object[1]);
                                                    Object[] objArr23 = new Object[1];
                                                    b(codePointAt3, codePointAt4, b22, (short) (((ApplicationInfo) cls13.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 33), 626140401 - (ViewConfiguration.getFadingEdgeLength() >> 16), objArr23);
                                                    String str4 = (String) objArr23[0];
                                                    int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) - 1800810587;
                                                    int codePointAt5 = super.getResources().getString(R.string.pushverify_binding_toolbar_title).substring(13, 15).codePointAt(1) - 211;
                                                    byte normalizeMetaState = (byte) KeyEvent.normalizeMetaState(0);
                                                    try {
                                                        byte b25 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                                                        byte b26 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                                                        Object[] objArr24 = new Object[1];
                                                        a(b25, b26, b26, objArr24);
                                                        Class<?> cls14 = Class.forName((String) objArr24[0]);
                                                        a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], new Object[1]);
                                                        Object[] objArr25 = new Object[1];
                                                        b(fadingEdgeLength, codePointAt5, normalizeMetaState, (short) (((ApplicationInfo) cls14.getMethod((String) r0[0], null).invoke(this, null)).targetSdkVersion - 33), getPackageName().codePointAt(2) + 626140414, objArr25);
                                                        try {
                                                            Object[] objArr26 = {baseContext, str, str2, str3, str4, true, (String) objArr25[0], 995651014};
                                                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                            if (obj2 == null) {
                                                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 911, 19 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) Color.argb(0, 0, 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                            }
                                                            ((Method) obj2).invoke(invoke, objArr26);
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
                            } catch (Throwable th11) {
                                Throwable cause11 = th11.getCause();
                                if (cause11 == null) {
                                    throw th11;
                                }
                                throw cause11;
                            }
                        }
                    }
                    try {
                        Object[] objArr27 = new Object[1];
                        a((short) 36, KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), objArr27);
                        Class<?> cls15 = Class.forName((String) objArr27[0]);
                        byte b27 = KClassImpl$Data$declaredNonStaticMembers$2[30];
                        Object[] objArr28 = new Object[1];
                        a((short) 21, b27, (byte) (b27 + 1), objArr28);
                        try {
                            Object[] objArr29 = {Integer.valueOf(((Integer) cls15.getMethod((String) objArr28[0], Object.class).invoke(null, this)).intValue())};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                            if (obj3 == null) {
                                Class cls16 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - TextUtils.indexOf("", "", 0, 0), 4 - (Process.myPid() >> 22), (char) (ViewConfiguration.getTapTimeout() >> 16));
                                byte b28 = (byte) ($$a[78] - 1);
                                Object[] objArr30 = new Object[1];
                                c(b28, b28, $$a[9], objArr30);
                                obj3 = cls16.getMethod((String) objArr30[0], Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                            }
                            Object[] objArr31 = (Object[]) ((Method) obj3).invoke(null, objArr29);
                            int i4 = ((int[]) objArr31[1])[0];
                            if (((int[]) objArr31[0])[0] != i4) {
                                long j = ((r0 ^ i4) & 4294967295L) | 42949672960L;
                                try {
                                    Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                    if (obj4 != null) {
                                        objArr = null;
                                    } else {
                                        objArr = null;
                                        obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.lastIndexOf("", '0', 0), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                    }
                                    Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                    try {
                                        Object[] objArr32 = {230617875, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                        Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                        if (obj5 == null) {
                                            obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTapTimeout() >> 16), 17 - ImageFormat.getBitsPerPixel(0), (char) Drawable.resolveOpacity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                        }
                                        ((Method) obj5).invoke(invoke2, objArr32);
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
                            super.onCreate(bundle);
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
        } catch (Throwable th18) {
            Throwable cause18 = th18.getCause();
            if (cause18 == null) {
                throw th18;
            }
            throw cause18;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[7];
                byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 1800810580, super.getResources().getString(R.string.home_shopping_tutorial_pay_step_3).substring(29, 30).length() - 89, (byte) (getPackageName().length() - 7), (short) (super.getResources().getString(R.string.consist_of_consecutive_numbers).substring(15, 16).length() - 1), 626140165 - TextUtils.getOffsetBefore("", 0), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                try {
                    byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                    byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                    Object[] objArr3 = new Object[1];
                    a(b3, b4, b4, objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(((ApplicationInfo) cls3.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 1800810578, super.getResources().getString(R.string.empty_state_identity_cards_desc_v3).substring(28, 29).codePointAt(0) - 128, (byte) (ImageFormat.getBitsPerPixel(0) + 1), (short) (super.getResources().getString(R.string.danaviz_only_confirmation_subtitle).substring(7, 8).codePointAt(0) + SecLiteException.ERROR_API_KEY_OR_SIGN), 626140190 - (Process.myPid() >> 22), objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 34 - Process.getGidForName(""), (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 911, 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        super.onPause();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[7];
                byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], objArr2);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 1800810580;
                int i2 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 89;
                try {
                    byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                    byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                    Object[] objArr3 = new Object[1];
                    a(b3, b4, b4, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[59]), KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(i, i2, (byte) (((ApplicationInfo) cls2.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33), (short) (TextUtils.lastIndexOf("", '0', 0) + 1), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 626140164, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    b((-1800810545) - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), View.resolveSizeAndState(0, 0, 0) - 96, (byte) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1), (short) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), getPackageName().length() + 626140183, objArr5);
                    baseContext = (Context) cls3.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr6 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 911, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr6);
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
        super.onResume();
    }

    public GroupSendLandingActivity() {
        final GroupSendLandingActivity groupSendLandingActivity = this;
        final Function0 function0 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new ViewModelLazy(Reflection.getOrCreateKotlinClass(GroupSendLandingViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GroupSendLandingActivity.this.getViewModelFactory();
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) {
                    CreationExtras defaultViewModelCreationExtras = groupSendLandingActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        });
    }

    @JvmName(name = "getViewModelFactory")
    public final ViewModelFactory getViewModelFactory() {
        ViewModelFactory viewModelFactory = this.viewModelFactory;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setViewModelFactory")
    public final void setViewModelFactory(ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "");
        this.viewModelFactory = viewModelFactory;
    }

    @JvmName(name = "getGroupSendTrackerHelper")
    public final GroupSendTrackerHelper getGroupSendTrackerHelper() {
        GroupSendTrackerHelper groupSendTrackerHelper = this.groupSendTrackerHelper;
        if (groupSendTrackerHelper != null) {
            return groupSendTrackerHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGroupSendTrackerHelper")
    public final void setGroupSendTrackerHelper(GroupSendTrackerHelper groupSendTrackerHelper) {
        Intrinsics.checkNotNullParameter(groupSendTrackerHelper, "");
        this.groupSendTrackerHelper = groupSendTrackerHelper;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            GroupSendComponent authRequestContext = ((GroupSendComponentProvider) applicationContext).provideGroupSendComponent().getAuthRequestContext();
            this.getAuthRequestContext = authRequestContext;
            authRequestContext.MyBillsEntityDataFactory(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.di.provider.GroupSendComponentProvider");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityGroupSendLandingBinding inflateViewBinding() {
        ActivityGroupSendLandingBinding authRequestContext = ActivityGroupSendLandingBinding.getAuthRequestContext(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        Toolbar toolbar = getBinding().moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        setToolbar(toolbar);
        Toolbar toolbar2 = getToolbar();
        Drawable PlaceComponentResult2 = ContextCompat.PlaceComponentResult(toolbar2.getContext(), id.dana.sendmoney.R.drawable.PlaceComponentResult);
        toolbar2.setContentDescription(getString(id.dana.sendmoney.R.string.NetworkUserEntityData$$ExternalSyntheticLambda1));
        toolbar2.setNavigationIcon(PlaceComponentResult2);
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupSendLandingActivity.m2920$r8$lambda$f5t7bFvvIkSo6tpNEBpXGvB8_w(GroupSendLandingActivity.this, view);
            }
        });
        getBinding().moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(id.dana.sendmoney.R.string.send_to_group_toolbar));
        getBinding().moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda2.setContentDescription(getApplicationContext().getString(id.dana.sendmoney.R.string.lbl_title_send_group));
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        ActivityResultLauncher<Intent> activityResultLauncher = this.PlaceComponentResult;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activityResultLauncher = null;
        }
        GroupRecipientActivity.Companion companion = GroupRecipientActivity.INSTANCE;
        activityResultLauncher.MyBillsEntityDataFactory(GroupRecipientActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(this, p0), null);
        this.scheduleImpl = false;
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().lookAheadTest.getAuthRequestContext;
        danaButtonPrimaryView.setEnabled(p0);
        danaButtonPrimaryView.setClickable(p0);
        danaButtonPrimaryView.setDanaButtonView(p0 ? 1 : 0, danaButtonPrimaryView.getContext().getString(id.dana.sendmoney.R.string.res_0x7f1314b1_flowkt__reducekt_firstornull_inlined_collectwhile_2_1), "", null);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        ConstraintLayout constraintLayout = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(p0 ^ true ? 0 : 8);
        LinearLayout linearLayout = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(p0 ? 0 : 8);
    }

    public final void PlaceComponentResult(boolean p0) {
        ConstraintLayout constraintLayout = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        boolean z = !p0;
        constraintLayout.setVisibility(z ? 0 : 8);
        ConstraintLayout constraintLayout2 = getBinding().lookAheadTest.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
        constraintLayout2.setVisibility(z ? 0 : 8);
        EmptyStateView emptyStateView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(emptyStateView, "");
        emptyStateView.setVisibility(p0 ? 0 : 8);
    }

    public final void navigateToDetailActivity(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "");
        ActivityResultLauncher<Intent> activityResultLauncher = this.PlaceComponentResult;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activityResultLauncher = null;
        }
        GroupDetailActivity.Companion companion = GroupDetailActivity.INSTANCE;
        activityResultLauncher.MyBillsEntityDataFactory(GroupDetailActivity.Companion.getAuthRequestContext(this, groupId), null);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\t"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/activity/GroupSendLandingActivity$Companion;", "", "", "p0", "Landroid/content/Intent;", "BuiltInFictitiousFunctionClassFactory", "(Z)Landroid/content/Intent;", "", "ACTIVITY_NAME", "Ljava/lang/String;", GroupSendLandingActivity.IS_GROUP_MODIFIED, "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent BuiltInFictitiousFunctionClassFactory(boolean p0) {
            Intent intent = new Intent();
            intent.putExtra(GroupSendLandingActivity.IS_GROUP_MODIFIED, p0);
            return intent;
        }
    }

    /* renamed from: $r8$lambda$-f5t7bFvvIkSo6tpNEBpXGvB8_w */
    public static /* synthetic */ void m2920$r8$lambda$f5t7bFvvIkSo6tpNEBpXGvB8_w(GroupSendLandingActivity groupSendLandingActivity, View view) {
        Intrinsics.checkNotNullParameter(groupSendLandingActivity, "");
        groupSendLandingActivity.onBackPressed();
    }

    public static /* synthetic */ void $r8$lambda$fhc2PL5zpnF_9SR2OjGkoWhkRnE(GroupSendLandingActivity groupSendLandingActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(groupSendLandingActivity, "");
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (booleanValue) {
                ((GroupSendLandingViewModel) groupSendLandingActivity.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
            }
            groupSendLandingActivity.getErrorConfigVersion = booleanValue;
        }
    }

    public static /* synthetic */ void $r8$lambda$lNxCHRtlhI9oPP9DMSJndSN4Cic(GroupSendLandingActivity groupSendLandingActivity, View view) {
        Intrinsics.checkNotNullParameter(groupSendLandingActivity, "");
        List<GroupSendScenarioConfigModel> list = groupSendLandingActivity.lookAheadTest;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            list = null;
        }
        if (list.size() < 2) {
            groupSendLandingActivity.BuiltInFictitiousFunctionClassFactory(GroupSendRecipientType.CONTACT);
            return;
        }
        GroupSendNavigationBottomSheet groupSendNavigationBottomSheet = (GroupSendNavigationBottomSheet) groupSendLandingActivity.BuiltInFictitiousFunctionClassFactory.getValue();
        FragmentManager supportFragmentManager = groupSendLandingActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        groupSendNavigationBottomSheet.PlaceComponentResult(supportFragmentManager);
    }

    public static final /* synthetic */ GroupSendLandingViewModel access$getVm(GroupSendLandingActivity groupSendLandingActivity) {
        return (GroupSendLandingViewModel) groupSendLandingActivity.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
    }

    public static final /* synthetic */ void access$handleOnSuccessGetGroupSendQuery(GroupSendLandingActivity groupSendLandingActivity, List list) {
        if (list.isEmpty()) {
            groupSendLandingActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            groupSendLandingActivity.KClassImpl$Data$declaredNonStaticMembers$2(true);
        } else {
            groupSendLandingActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            GroupSendQueryAdapter groupSendQueryAdapter = groupSendLandingActivity.moveToNextValue;
            if (groupSendQueryAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                groupSendQueryAdapter = null;
            }
            Intrinsics.checkNotNullParameter(list, "");
            groupSendQueryAdapter.MyBillsEntityDataFactory = list;
            groupSendQueryAdapter.notifyDataSetChanged();
        }
        final GroupSendLandingViewModel groupSendLandingViewModel = (GroupSendLandingViewModel) groupSendLandingActivity.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
        BaseFlowUseCase.execute$default(groupSendLandingViewModel.KClassImpl$Data$declaredNonStaticMembers$2, NoParams.INSTANCE, null, new Function1<List<? extends GroupSendScenarioConfig>, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingViewModel$getGroupSendScenario$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends GroupSendScenarioConfig> list2) {
                invoke2((List<GroupSendScenarioConfig>) list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<GroupSendScenarioConfig> list2) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(list2, "");
                mutableStateFlow = GroupSendLandingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendLandingUiState groupSendLandingUiState = (GroupSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendLandingUiState.OnSuccessGetGroupSendScenario(GroupSendScenarioModelMapperKt.BuiltInFictitiousFunctionClassFactory(list2))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingViewModel$getGroupSendScenario$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GROUP_SEND_EXCEPTION, th.getMessage(), th);
                mutableStateFlow = GroupSendLandingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendLandingUiState groupSendLandingUiState = (GroupSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendLandingUiState.Error(0, th, GroupSendOperationType.GROUP_GET_GROUP_SEND_SCENARIO, 1, null)));
            }
        }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingViewModel$getGroupSendScenario$3
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
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = GroupSendLandingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendLandingUiState groupSendLandingUiState = (GroupSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendLandingUiState.ShimmerLoading(false)));
            }
        }, ViewModelKt.PlaceComponentResult(groupSendLandingViewModel), 2, null);
    }

    public static final /* synthetic */ void access$handleOnSuccessGetGroupSendScenario(GroupSendLandingActivity groupSendLandingActivity, List list) {
        groupSendLandingActivity.lookAheadTest = list;
        GroupSendNavigationBottomSheet groupSendNavigationBottomSheet = (GroupSendNavigationBottomSheet) groupSendLandingActivity.BuiltInFictitiousFunctionClassFactory.getValue();
        List<GroupSendScenarioConfigModel> list2 = groupSendLandingActivity.lookAheadTest;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            list2 = null;
        }
        Intrinsics.checkNotNullParameter(list2, "");
        groupSendNavigationBottomSheet.BuiltInFictitiousFunctionClassFactory = list2;
        if (groupSendLandingActivity.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            final GroupSendLandingViewModel groupSendLandingViewModel = (GroupSendLandingViewModel) groupSendLandingActivity.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
            Intrinsics.checkNotNullParameter(BottomSheetOnBoardingScenario.GROUP_SEND, "");
            BaseFlowUseCase.execute$default(groupSendLandingViewModel.BuiltInFictitiousFunctionClassFactory, BottomSheetOnBoardingScenario.GROUP_SEND, null, new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingViewModel$checkIsNeedToShowBottomSheetRequestPermission$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    mutableStateFlow = GroupSendLandingViewModel.this.getAuthRequestContext;
                    do {
                        value = mutableStateFlow.getValue();
                        GroupSendLandingUiState groupSendLandingUiState = (GroupSendLandingUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, new GroupSendLandingUiState.OnSuccessGetIsNeedToShowBottomSheet(z)));
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingViewModel$checkIsNeedToShowBottomSheetRequestPermission$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "");
                    StringBuilder sb = new StringBuilder();
                    sb.append(DanaLogConstants.Prefix.GET_ON_BOARDING_PREFIX);
                    sb.append(GroupSendLandingViewModel.this.getClass().getName());
                    sb.append("on Error");
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString(), th);
                }
            }, null, ViewModelKt.PlaceComponentResult(groupSendLandingViewModel), 18, null);
        }
        final GroupSendLandingViewModel groupSendLandingViewModel2 = (GroupSendLandingViewModel) groupSendLandingActivity.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
        BaseFlowUseCase.execute$default(groupSendLandingViewModel2.MyBillsEntityDataFactory, NoParams.INSTANCE, null, new Function1<Integer, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingViewModel$getGroupSendMaxGroup$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = GroupSendLandingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendLandingUiState groupSendLandingUiState = (GroupSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendLandingUiState.OnSuccessGetGroupSendMaxGroup(i)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingViewModel$getGroupSendMaxGroup$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GROUP_SEND_EXCEPTION, th.getMessage(), th);
                mutableStateFlow = GroupSendLandingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendLandingUiState groupSendLandingUiState = (GroupSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendLandingUiState.Error(0, th, GroupSendOperationType.GROUP_GET_GROUP_SEND_MAX_GROUP, 1, null)));
            }
        }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingViewModel$getGroupSendMaxGroup$3
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
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = GroupSendLandingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendLandingUiState groupSendLandingUiState = (GroupSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendLandingUiState.ShimmerLoading(false)));
            }
        }, ViewModelKt.PlaceComponentResult(groupSendLandingViewModel2), 2, null);
    }

    public static final /* synthetic */ void access$handleOnSuccessIsNeedToShowBottomSheet(GroupSendLandingActivity groupSendLandingActivity, boolean z) {
        if (!z) {
            if (groupSendLandingActivity.lookAheadTest != null) {
                GroupSendQueryAdapter groupSendQueryAdapter = groupSendLandingActivity.moveToNextValue;
                if (groupSendQueryAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    groupSendQueryAdapter = null;
                }
                if (groupSendQueryAdapter.getPlaceComponentResult() == 0 && groupSendLandingActivity.scheduleImpl) {
                    groupSendLandingActivity.BuiltInFictitiousFunctionClassFactory(GroupSendRecipientType.CONTACT);
                    return;
                } else if (groupSendLandingActivity.getErrorConfigVersion || !groupSendLandingActivity.scheduleImpl) {
                    return;
                } else {
                    GroupSendNavigationBottomSheet groupSendNavigationBottomSheet = (GroupSendNavigationBottomSheet) groupSendLandingActivity.BuiltInFictitiousFunctionClassFactory.getValue();
                    FragmentManager supportFragmentManager = groupSendLandingActivity.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                    groupSendNavigationBottomSheet.PlaceComponentResult(supportFragmentManager);
                    return;
                }
            }
            return;
        }
        GroupSendOnboardingDialogFragment groupSendOnboardingDialogFragment = (GroupSendOnboardingDialogFragment) groupSendLandingActivity.MyBillsEntityDataFactory.getValue();
        FragmentManager supportFragmentManager2 = groupSendLandingActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "");
        groupSendOnboardingDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(supportFragmentManager2);
    }

    public static final /* synthetic */ void access$navigateToGroupSummaryActivity(GroupSendLandingActivity groupSendLandingActivity, String str) {
        GroupSendIntentModel groupSendIntentModel = new GroupSendIntentModel(ACTIVITY_NAME, null, null, str, null, null, null, false, 246, null);
        ActivityResultLauncher<Intent> activityResultLauncher = groupSendLandingActivity.PlaceComponentResult;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activityResultLauncher = null;
        }
        GroupSendSummaryActivity.Companion companion = GroupSendSummaryActivity.INSTANCE;
        activityResultLauncher.MyBillsEntityDataFactory(GroupSendSummaryActivity.Companion.getAuthRequestContext(groupSendIntentModel, SourceTypeProperty.GROUP_LIST, groupSendLandingActivity), null);
    }

    public static final /* synthetic */ void access$saveDisplayedPermissionRequestDialog(GroupSendLandingActivity groupSendLandingActivity) {
        final GroupSendLandingViewModel groupSendLandingViewModel = (GroupSendLandingViewModel) groupSendLandingActivity.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue();
        Intrinsics.checkNotNullParameter(BottomSheetOnBoardingScenario.GROUP_SEND, "");
        BaseFlowUseCase.execute$default(groupSendLandingViewModel.moveToNextValue, BottomSheetOnBoardingScenario.GROUP_SEND, null, null, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingViewModel$saveDisplayedBottomSheetOnboarding$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.SAVE_ON_BOARDING_PREFIX);
                sb.append(GroupSendLandingViewModel.this.getClass().getName());
                sb.append("on Error");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString(), th);
            }
        }, null, ViewModelKt.PlaceComponentResult(groupSendLandingViewModel), 22, null);
        ((GroupSendOnboardingDialogFragment) groupSendLandingActivity.MyBillsEntityDataFactory.getValue()).dismiss();
    }

    public static final /* synthetic */ void access$setDanaLoadingState(GroupSendLandingActivity groupSendLandingActivity, boolean z) {
        if (!z) {
            ((DanaLogoLoadingDialog) groupSendLandingActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).PlaceComponentResult();
            return;
        }
        DanaLogoLoadingDialog danaLogoLoadingDialog = (DanaLogoLoadingDialog) groupSendLandingActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        if (danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.isShowing()) {
            return;
        }
        danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.show();
        danaLogoLoadingDialog.MyBillsEntityDataFactory.startRefresh();
    }

    public static final /* synthetic */ void access$setSendBtnState(GroupSendLandingActivity groupSendLandingActivity, int i) {
        groupSendLandingActivity.GetContactSyncConfig = i;
        GroupSendQueryAdapter groupSendQueryAdapter = groupSendLandingActivity.moveToNextValue;
        if (groupSendQueryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            groupSendQueryAdapter = null;
        }
        if (groupSendQueryAdapter.getPlaceComponentResult() >= i) {
            groupSendLandingActivity.BuiltInFictitiousFunctionClassFactory(false);
            TextView textView = groupSendLandingActivity.getBinding().lookAheadTest.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            String string = groupSendLandingActivity.getString(id.dana.sendmoney.R.string.group_landing_max_group);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            textView.setText(format);
        }
    }

    public static final /* synthetic */ void access$showBottomSheetNavigationGroupSend(GroupSendLandingActivity groupSendLandingActivity) {
        GroupSendNavigationBottomSheet groupSendNavigationBottomSheet = (GroupSendNavigationBottomSheet) groupSendLandingActivity.BuiltInFictitiousFunctionClassFactory.getValue();
        FragmentManager supportFragmentManager = groupSendLandingActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        groupSendNavigationBottomSheet.PlaceComponentResult(supportFragmentManager);
    }

    public static final /* synthetic */ void access$updateViewOnLoading(GroupSendLandingActivity groupSendLandingActivity, boolean z) {
        boolean z2 = false;
        if (z) {
            groupSendLandingActivity.PlaceComponentResult(false);
            groupSendLandingActivity.KClassImpl$Data$declaredNonStaticMembers$2(false);
        }
        if (!z) {
            GroupSendQueryAdapter groupSendQueryAdapter = groupSendLandingActivity.moveToNextValue;
            if (groupSendQueryAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                groupSendQueryAdapter = null;
            }
            if (groupSendQueryAdapter.getPlaceComponentResult() < groupSendLandingActivity.GetContactSyncConfig) {
                z2 = true;
            }
        }
        groupSendLandingActivity.BuiltInFictitiousFunctionClassFactory(z2);
        GroupSendLandingShimmerExt groupSendLandingShimmerExt = GroupSendLandingShimmerExt.INSTANCE;
        ActivityGroupSendLandingBinding binding = groupSendLandingActivity.getBinding();
        Intrinsics.checkNotNullParameter(binding, "");
        if (z) {
            GroupSendLandingShimmerExt.KClassImpl$Data$declaredNonStaticMembers$2(binding);
        } else {
            GroupSendLandingShimmerExt.BuiltInFictitiousFunctionClassFactory();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContract<Intent, Boolean>() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$groupModified$1
            @Override // androidx.view.result.contract.ActivityResultContract
            public final /* synthetic */ Intent createIntent(Context context, Intent intent) {
                Intent intent2 = intent;
                Intrinsics.checkNotNullParameter(context, "");
                Intrinsics.checkNotNullParameter(intent2, "");
                return intent2;
            }

            @Override // androidx.view.result.contract.ActivityResultContract
            public final /* synthetic */ Boolean parseResult(int i, Intent intent) {
                if (i == -1 && intent != null) {
                    return Boolean.valueOf(intent.getBooleanExtra(GroupSendLandingActivity.IS_GROUP_MODIFIED, false));
                }
                return null;
            }
        }, new ActivityResultCallback() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GroupSendLandingActivity.$r8$lambda$fhc2PL5zpnF_9SR2OjGkoWhkRnE(GroupSendLandingActivity.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.PlaceComponentResult = registerForActivityResult;
        ?? r8 = 0;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(this), null, null, new GroupSendLandingActivity$initLifecycleActivity$1(this, null), 3, null);
        GroupSendLandingActivity groupSendLandingActivity = this;
        this.moveToNextValue = new GroupSendQueryAdapter(groupSendLandingActivity, r8, 2, r8);
        RecyclerView recyclerView = getBinding().BuiltInFictitiousFunctionClassFactory;
        recyclerView.setLayoutManager(new LinearLayoutManager(groupSendLandingActivity));
        GroupSendQueryAdapter groupSendQueryAdapter = this.moveToNextValue;
        if (groupSendQueryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            groupSendQueryAdapter = null;
        }
        groupSendQueryAdapter.getAuthRequestContext = new GroupSendQueryAdapter.GroupQueryListener() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$getQueryListener$1
            @Override // id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendQueryAdapter.GroupQueryListener
            public final void MyBillsEntityDataFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                GroupSendLandingActivity.access$navigateToGroupSummaryActivity(GroupSendLandingActivity.this, p0);
            }

            @Override // id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendQueryAdapter.GroupQueryListener
            public final void getAuthRequestContext(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                GroupSendLandingActivity.this.navigateToDetailActivity(p0);
            }
        };
        GroupSendQueryAdapter groupSendQueryAdapter2 = this.moveToNextValue;
        if (groupSendQueryAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            r8 = groupSendQueryAdapter2;
        }
        recyclerView.setAdapter((RecyclerView.Adapter) r8);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$getItemDecorator$1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public final void getItemOffsets(Rect p0, View p1, RecyclerView p2, RecyclerView.State p3) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                Intrinsics.checkNotNullParameter(p3, "");
                int authRequestContext = ViewExtKt.getAuthRequestContext(16.0f);
                p0.left = authRequestContext;
                p0.right = authRequestContext;
                p0.bottom = authRequestContext;
            }
        });
        ((GroupSendLandingViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
        getBinding().lookAheadTest.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupSendLandingActivity.$r8$lambda$lNxCHRtlhI9oPP9DMSJndSN4Cic(GroupSendLandingActivity.this, view);
            }
        });
        getBinding().MyBillsEntityDataFactory.setOnBottomActionClickListener(new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$initOnClickListener$2
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
                GroupSendLandingActivity.access$getVm(GroupSendLandingActivity.this).KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        getGroupSendTrackerHelper().PlaceComponentResult();
    }

    private static void b(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (isLayoutRequested ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (NetworkUserEntityData$$ExternalSyntheticLambda6[i3 + ((int) (PrepareContext ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (isLayoutRequested ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (NetworkUserEntityData$$ExternalSyntheticLambda4[i3 + ((int) (PrepareContext ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (isLayoutRequested ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (PrepareContext ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (FragmentBottomSheetPaymentSettingBinding ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (bArr3 != null) {
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                for (int i7 = 0; i7 < length2; i7++) {
                    bArr4[i7] = (byte) (bArr3[i7] ^ 3097486228508854431L);
                }
                bArr3 = bArr4;
            }
            boolean z = bArr3 != null;
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                if (z) {
                    byte[] bArr5 = NetworkUserEntityData$$ExternalSyntheticLambda6;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = NetworkUserEntityData$$ExternalSyntheticLambda4;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                }
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                b2.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        objArr[0] = sb.toString();
    }
}

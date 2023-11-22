package id.dana.sendmoney.ui.groupsend.summary.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
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
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.DanaLogoLoadingDialog;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.core.ui.util.NumberUtil;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.recentrecipient.interactor.SaveRecentGroup;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.R;
import id.dana.sendmoney.constants.GroupSendRecipientType;
import id.dana.sendmoney.databinding.ActivityGroupSendSummaryBinding;
import id.dana.sendmoney.databinding.ViewGroupSendEditProfileBinding;
import id.dana.sendmoney.databinding.ViewStickyBottomSheetSummaryBinding;
import id.dana.sendmoney.di.component.GroupSendComponent;
import id.dana.sendmoney.di.provider.GroupSendComponentProvider;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;
import id.dana.sendmoney.domain.groupsend.interactor.ConfirmSendMoneyGroup;
import id.dana.sendmoney.domain.groupsend.model.submit.SendMoneyGroupConfirm;
import id.dana.sendmoney.ui.common.EmptyStateView;
import id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity;
import id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity;
import id.dana.sendmoney.ui.groupsend.landing.view.GroupCircleImageRichView;
import id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import id.dana.sendmoney.ui.groupsend.summary.factory.GroupSendSummaryFactory;
import id.dana.sendmoney.ui.groupsend.summary.mapper.GroupSendSummaryModelMapperKt;
import id.dana.sendmoney.ui.groupsend.summary.model.AvatarModel;
import id.dana.sendmoney.ui.groupsend.summary.model.GroupSendIntentModel;
import id.dana.sendmoney.ui.groupsend.summary.model.ParticipantSubmitModel;
import id.dana.sendmoney.ui.groupsend.summary.model.PayeeUserInfoModel;
import id.dana.sendmoney.ui.groupsend.summary.model.SendMoneyGroupInitModel;
import id.dana.sendmoney.ui.groupsend.summary.state.GroupSendSummary;
import id.dana.sendmoney.ui.groupsend.summary.util.GroupSendAvatarRandomizerEngine;
import id.dana.sendmoney.ui.groupsend.summary.util.GroupSendSummaryExtKt;
import id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment;
import id.dana.sendmoney.ui.groupsend.summary.view.GroupSendEditNameDialog;
import id.dana.sendmoney.ui.groupsend.summary.view.GroupSendMembersAdapter;
import id.dana.sendmoney.ui.groupsend.summary.view.GroupSendSummaryShimmerExt;
import id.dana.sendmoney.ui.groupsend.summary.view.InformationDialogFragment;
import id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryUIState;
import id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel;
import id.dana.sendmoney.util.GroupSendTrackerExtKt;
import id.dana.sendmoney.util.GroupSendTrackerHelper;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 m2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001mB\u0007¢\u0006\u0004\bl\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0005J%\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0007\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0006\u0010\u001aJ\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u0007\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010\u0005R\u0013\u0010\t\u001a\u00020 X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\t\u0010!R\u0013\u0010\u0014\u001a\u00020\"X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010!R\u0013\u0010\u0007\u001a\u00020#X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010!R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010&R\u0016\u0010\u0006\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\u001e\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010\u0016\u001a\u00020;8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010F\u001a\u00020E8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0016\u0010\u001f\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010\\\u001a\u00020U8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0016\u0010\u001d\u001a\u00020U8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b]\u0010WR\"\u0010^\u001a\u00020\u001b8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010\u001cR\"\u0010d\u001a\u00020c8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0013\u0010\u0019\u001a\u00020jX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bk\u0010!"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/activity/GroupSendSummaryActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/sendmoney/databinding/ActivityGroupSendSummaryBinding;", "", "configToolbar", "()V", "PlaceComponentResult", "MyBillsEntityDataFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/lang/String;", "inflateViewBinding", "()Lid/dana/sendmoney/databinding/ActivityGroupSendSummaryBinding;", IAPSyncCommand.COMMAND_INIT, "p0", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "p1", "(Ljava/lang/String;Ljava/util/List;)V", "initComponent", "BuiltInFictitiousFunctionClassFactory", "", "lookAheadTest", "()Z", "onBackPressed", "moveToNextValue", "(Z)V", "Lid/dana/sendmoney/ui/groupsend/summary/model/GroupSendIntentModel;", "(Lid/dana/sendmoney/ui/groupsend/summary/model/GroupSendIntentModel;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "scheduleImpl", "Lid/dana/sendmoney/ui/groupsend/summary/view/InformationDialogFragment;", "Lkotlin/Lazy;", "Lid/dana/core/ui/dialog/DanaLogoLoadingDialog;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResultLauncher;", "getAuthRequestContext", "GetContactSyncConfig", "Ljava/lang/String;", "Lid/dana/sendmoney/di/component/GroupSendComponent;", "DatabaseTableConfigUtil", "Lid/dana/sendmoney/di/component/GroupSendComponent;", "Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupInitModel;", "groupSendInitResponse", "Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupInitModel;", "getGroupSendInitResponse", "()Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupInitModel;", "setGroupSendInitResponse", "(Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupInitModel;)V", "Lid/dana/sendmoney/ui/groupsend/summary/view/GroupSendMembersAdapter;", "groupSendMembersAdapter", "Lid/dana/sendmoney/ui/groupsend/summary/view/GroupSendMembersAdapter;", "getGroupSendMembersAdapter", "()Lid/dana/sendmoney/ui/groupsend/summary/view/GroupSendMembersAdapter;", "setGroupSendMembersAdapter", "(Lid/dana/sendmoney/ui/groupsend/summary/view/GroupSendMembersAdapter;)V", "Lid/dana/sendmoney/ui/groupsend/summary/state/GroupSendSummary;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/sendmoney/ui/groupsend/summary/state/GroupSendSummary;", "Lid/dana/sendmoney/ui/groupsend/summary/factory/GroupSendSummaryFactory;", "groupSendSummaryFactory", "Lid/dana/sendmoney/ui/groupsend/summary/factory/GroupSendSummaryFactory;", "getGroupSendSummaryFactory", "()Lid/dana/sendmoney/ui/groupsend/summary/factory/GroupSendSummaryFactory;", "setGroupSendSummaryFactory", "(Lid/dana/sendmoney/ui/groupsend/summary/factory/GroupSendSummaryFactory;)V", "Lid/dana/sendmoney/util/GroupSendTrackerHelper;", "groupSendTrackerHelper", "Lid/dana/sendmoney/util/GroupSendTrackerHelper;", "getGroupSendTrackerHelper", "()Lid/dana/sendmoney/util/GroupSendTrackerHelper;", "setGroupSendTrackerHelper", "(Lid/dana/sendmoney/util/GroupSendTrackerHelper;)V", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Z", "Lid/dana/core/ui/model/CurrencyAmountModel;", "remainingLimit", "Lid/dana/core/ui/model/CurrencyAmountModel;", "getRemainingLimit", "()Lid/dana/core/ui/model/CurrencyAmountModel;", "setRemainingLimit", "(Lid/dana/core/ui/model/CurrencyAmountModel;)V", "", "initRecordTimeStamp", "I", "getSelectedMemberIndex", "()I", "setSelectedMemberIndex", "(I)V", "selectedMemberIndex", "isLayoutRequested", "summaryIntentModel", "Lid/dana/sendmoney/ui/groupsend/summary/model/GroupSendIntentModel;", "getSummaryIntentModel", "()Lid/dana/sendmoney/ui/groupsend/summary/model/GroupSendIntentModel;", "setSummaryIntentModel", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/core/ui/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/core/ui/di/module/ViewModelFactory;)V", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupSendSummaryActivity extends BaseViewBindingActivity<ActivityGroupSendSummaryBinding> {
    public static final String ACTIVITY_NAME = "GroupSendSummaryActivity";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char[] PrepareContext;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private GroupSendComponent getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private GroupSendSummary lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy moveToNextValue;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private ActivityResultLauncher<Intent> getAuthRequestContext;
    public SendMoneyGroupInitModel groupSendInitResponse;
    public GroupSendMembersAdapter groupSendMembersAdapter;
    @Inject
    public GroupSendSummaryFactory groupSendSummaryFactory;
    @Inject
    public GroupSendTrackerHelper groupSendTrackerHelper;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private int selectedMemberIndex;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    public CurrencyAmountModel remainingLimit;
    public GroupSendIntentModel summaryIntentModel;
    @Inject
    public ViewModelFactory viewModelFactory;
    public static final byte[] $$a = {63, Ascii.SUB, 111, -17, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 122;
    public static final byte[] PlaceComponentResult = {42, -75, 2, Ascii.US, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int getAuthRequestContext = 93;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<DanaLogoLoadingDialog>() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$danaLogoLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLogoLoadingDialog invoke() {
            return new DanaLogoLoadingDialog(GroupSendSummaryActivity.this);
        }
    });

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$discardChangesConfirmationDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MaterialDialog invoke() {
            CustomDialog.Builder builder = new CustomDialog.Builder(GroupSendSummaryActivity.this);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_warning_red;
            builder.SubSequence = GroupSendSummaryActivity.this.getString(R.string.dialog_discard_changes_title);
            builder.GetContactSyncConfig = GroupSendSummaryActivity.this.getString(R.string.dialog_discard_changes_desc);
            String string = GroupSendSummaryActivity.this.getString(R.string.dialog_discard_positive_button_text);
            final GroupSendSummaryActivity groupSendSummaryActivity = GroupSendSummaryActivity.this;
            return builder.BuiltInFictitiousFunctionClassFactory(string, new Function1<View, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$discardChangesConfirmationDialog$2.1
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
                    GroupSendSummaryActivity.this.finish();
                }
            }).KClassImpl$Data$declaredNonStaticMembers$2(GroupSendSummaryActivity.this.getString(R.string.dialog_discard_negative_button_text), new Function1<View, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$discardChangesConfirmationDialog$2.2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }
            }).KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory();
        }
    });
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<InformationDialogFragment>() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$bottomSheetInformationDialog$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InformationDialogFragment invoke() {
            return new InformationDialogFragment();
        }
    });

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private String PlaceComponentResult = "";

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    public static void __fsTypeCheck_074055a5770ceee3ff60e06bca0881e0(CircleImageView circleImageView, int i) {
        if (circleImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(circleImageView, i);
        } else {
            circleImageView.setImageResource(i);
        }
    }

    private static void b(byte b, short s, byte b2, Object[] objArr) {
        int i = 18 - (s * 15);
        int i2 = 16 - (b2 * 2);
        int i3 = 106 - b;
        byte[] bArr = PlaceComponentResult;
        byte[] bArr2 = new byte[i2];
        int i4 = -1;
        int i5 = i2 - 1;
        if (bArr == null) {
            int i6 = i + (-i5) + 2;
            i5 = i5;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
            i = i;
            i3 = i6;
        }
        while (true) {
            int i7 = i + 1;
            int i8 = i4 + 1;
            bArr2[i8] = (byte) i3;
            if (i8 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i5 = i5;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i8;
            i = i7;
            i3 = i3 + (-bArr[i7]) + 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0027 -> B:35:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 2
            int r6 = 103 - r6
            byte[] r0 = id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity.$$a
            int r8 = r8 * 3
            int r8 = r8 + 21
            int r7 = 47 - r7
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r6 = r6 + r8
            int r6 = r6 + (-7)
            int r7 = r7 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity.c(short, byte, short, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        PrepareContext = new char[]{35541, 35331, 35329, 35391, 35384, 35388, 35330, 35553, 35555, 35328, 35384, 35355, 35571, 35350, 35391, 35386, 35387, 35387, 35386, 35378, 35330, 35338, 35389, 35391, 35335, 35334, 35352, 35732, 35736, 35740, 35424, 35736, 35732, 35734, 35732, 35738, 35734, 35729, 35728, 35737, 35739, 35731, 35432, 35434, 35465, 35543, 35576, 35570, 35566, 35573, 35575, 35577, 35572, 35565, 35570, 35578, 35575, 35566, 35583, 35489, 35534, 35567, 35498, 35521, 35577, 35565, 35574, 35492, 35562, 35523, 35520, 35522, 35544, 35521, 35522, 35522, 35565, 35562, 35582, 35542, 35547, 35544, 35582, 35582, 35543, 35547, 35546, 35521, 35520, 35544, 35523, 35525, 35547, 35520, 35521, 35520, 35523, 35542, 35547, 35525, 35521, 35543, 35542, 35521, 35563, 35563, 35560, 35522, 35548, 35546, 35546, 35548, 35546, 35522, 35565, 35499, 35357, 35352, 35570, 35359, 35332, 35356, 35574, 35574, 35574, 35573, 35566, 35567, 35566, 35571, 35573, 35571, 35570, 35570, 35355, 35356, 35357, 35356, 35572, 35570, 35575, 35359, 35333, 35355, 35568, 35354, 35333, 35356, 35572, 35357, 35352, 35352, 35353, 35355, 35354, 35570, 35570, 35573, 35356, 35356, 35357, 35354, 35572, 35573, 35572, 35575, 35356, 35354, 35569, 35352, 35333, 35352, 35570, 35570, 35353, 35331, 35355, 35571, 35357, 35357, 35375, 35372, 35356, 35370, 35354, 35371, 35375, 35353, 35358, 35357, 35359, 35359, 35350, 35350, 35350, 35354, 35356, 35353, 35351, 35372, 35371, 35359, 35356, 35351, 35355, 35355, 35368, 35352, 35351, 35355, 35353, 35355, 35368, 35359, 35356, 35371, 35373, 35351, 35368, 35372, 35375, 35358, 35350, 35354, 35359, 35368, 35350, 35350, 35352, 35353, 35372, 35350, 35356, 35370, 35353, 35373, 35353, 35368, 35368, 35350, 35351, 35368, 35353, 35495, 35565, 35567, 35575, 35571, 35571, 35540, 35502, 35530, 35532, 35535, 35565, 35570, 35576, 35572, 35573, 35538, 35538, 35570, 35574, 35542, 35536, 35568, 35575, 35542, 35543, 35573, 35575, 35573, 35565, 35564, 35573, 35573, 35575, 35573, 35568, 35540, 35535, 35565, 35572, 35580, 35573, 35572, 35581, 35573, 35571, 35568, 35535, 35545, 35577, 35577, 35580, 35543, 35505, 35498, 35528, 35567, 35564, 35562, 35568, 35462, 35503, 35502, 35503, 35503, 35501};
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(true, new int[]{44, 18, 0, 8}, new byte[]{0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(true, new int[]{62, 5, 0, 4}, new byte[]{1, 0, 0, 0, 1}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionGroup(0L), ((Process.getThreadPriority(0) + 20) >> 6) + 35, (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(false, new int[]{67, 48, 17, 27}, new byte[]{0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(true, new int[]{115, 64, 56, 0}, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(true, new int[]{179, 64, 80, 24}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(true, new int[]{243, 60, 0, 0}, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(true, new int[]{303, 6, 0, 0}, new byte[]{1, 1, 0, 0, 0, 1}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 912, 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (PlaceComponentResult[5] - 1);
                byte b2 = b;
                Object[] objArr14 = new Object[1];
                b(b, b2, b2, objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                byte b3 = PlaceComponentResult[5];
                byte b4 = b3;
                Object[] objArr15 = new Object[1];
                b(b3, b4, (byte) (b4 - 1), objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 55, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 2, (char) (Process.myTid() >> 22));
                        Object[] objArr17 = new Object[1];
                        c($$a[12], $$a[53], $$a[78], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), TextUtils.indexOf("", "", 0, 0) + 15, (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776416) - Color.rgb(0, 0, 0), Color.argb(0, 0, 0, 0) + 15, (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 815, TextUtils.getCapsMode("", 0, 0) + 29, (char) (KeyEvent.getDeadChar(0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - MotionEvent.axisFromString(""), 16 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) Color.argb(0, 0, 0, 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r5 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {1065304782, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), TextUtils.getTrimmedLength("") + 18, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = (byte) (PlaceComponentResult[5] - 1);
                byte b6 = b5;
                Object[] objArr21 = new Object[1];
                b(b5, b6, b6, objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                byte b7 = PlaceComponentResult[5];
                byte b8 = b7;
                Object[] objArr22 = new Object[1];
                b(b7, b8, (byte) (b8 - 1), objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 61, 46 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) KeyEvent.keyCodeFromString(""));
                        Object[] objArr24 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], (byte) ($$a[78] - 1), objArr24);
                        obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                    int i = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getOffsetAfter("", 0), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr26 = {1065304782, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 912, 18 - View.MeasureSpec.getMode(0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b9 = (byte) (PlaceComponentResult[5] - 1);
                byte b10 = b9;
                Object[] objArr28 = new Object[1];
                b(b9, b10, b10, objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                byte b11 = PlaceComponentResult[5];
                byte b12 = b11;
                Object[] objArr29 = new Object[1];
                b(b11, b12, (byte) (b12 - 1), objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(117 - MotionEvent.axisFromString(""), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2, (char) (38968 - (ViewConfiguration.getEdgeSlop() >> 16)));
                        Object[] objArr31 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], (byte) ($$a[78] - 1), objArr31);
                        obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                    int i2 = ((int[]) objArr32[1])[0];
                    if (((int[]) objArr32[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {1065304782, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b13 = (byte) (PlaceComponentResult[5] - 1);
                byte b14 = b13;
                Object[] objArr35 = new Object[1];
                b(b13, b14, b14, objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                byte b15 = PlaceComponentResult[5];
                byte b16 = b15;
                Object[] objArr36 = new Object[1];
                b(b15, b16, (byte) (b16 - 1), objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 107, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 3, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')));
                        Object[] objArr38 = new Object[1];
                        c($$a[9], (byte) ($$a[78] - 1), $$a[8], objArr38);
                        obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                    int i3 = ((int[]) objArr39[1])[0];
                    if (((int[]) objArr39[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ImageFormat.getBitsPerPixel(0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr40 = {1065304782, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 911, 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        a(true, new int[]{44, 18, 0, 8}, new byte[]{0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(true, new int[]{62, 5, 0, 4}, new byte[]{1, 0, 0, 0, 1}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(false, new int[]{0, 26, 54, 0}, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(false, new int[]{26, 18, 156, 9}, new byte[]{0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 35 - (Process.myTid() >> 22), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(false, new int[]{67, 48, 17, 27}, new byte[]{0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(true, new int[]{115, 64, 56, 0}, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(true, new int[]{179, 64, 80, 24}, null, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(true, new int[]{243, 60, 0, 0}, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(true, new int[]{303, 6, 0, 0}, new byte[]{1, 1, 0, 0, 0, 1}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 911, 18 - (Process.myPid() >> 22), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            byte b = (byte) (PlaceComponentResult[5] - 1);
            byte b2 = b;
            Object[] objArr12 = new Object[1];
            b(b, b2, b2, objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            byte b3 = PlaceComponentResult[5];
            byte b4 = b3;
            Object[] objArr13 = new Object[1];
            b(b3, b4, (byte) (b4 - 1), objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 494, 4 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) TextUtils.getOffsetBefore("", 0));
                    Object[] objArr15 = new Object[1];
                    c($$a[9], (byte) ($$a[78] - 1), $$a[8], objArr15);
                    obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                int i = ((int[]) objArr16[1])[0];
                if (((int[]) objArr16[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {-1400953625, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ImageFormat.getBitsPerPixel(0), Color.red(0) + 18, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
            a(false, new int[]{0, 26, 54, 0}, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(false, new int[]{26, 18, 156, 9}, new byte[]{0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.indexOf("", "", 0, 0), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            a(false, new int[]{0, 26, 54, 0}, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(false, new int[]{26, 18, 156, 9}, new byte[]{0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getTouchSlop() >> 8), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public GroupSendSummaryActivity() {
        final GroupSendSummaryActivity groupSendSummaryActivity = this;
        final Function0 function0 = null;
        this.moveToNextValue = new ViewModelLazy(Reflection.getOrCreateKotlinClass(GroupSendSummaryViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GroupSendSummaryActivity.this.getViewModelFactory();
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$special$$inlined$viewModels$default$3
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
                    CreationExtras defaultViewModelCreationExtras = groupSendSummaryActivity.getDefaultViewModelCreationExtras();
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

    @JvmName(name = "getGroupSendSummaryFactory")
    public final GroupSendSummaryFactory getGroupSendSummaryFactory() {
        GroupSendSummaryFactory groupSendSummaryFactory = this.groupSendSummaryFactory;
        if (groupSendSummaryFactory != null) {
            return groupSendSummaryFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGroupSendSummaryFactory")
    public final void setGroupSendSummaryFactory(GroupSendSummaryFactory groupSendSummaryFactory) {
        Intrinsics.checkNotNullParameter(groupSendSummaryFactory, "");
        this.groupSendSummaryFactory = groupSendSummaryFactory;
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

    @JvmName(name = "getGroupSendMembersAdapter")
    public final GroupSendMembersAdapter getGroupSendMembersAdapter() {
        GroupSendMembersAdapter groupSendMembersAdapter = this.groupSendMembersAdapter;
        if (groupSendMembersAdapter != null) {
            return groupSendMembersAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGroupSendMembersAdapter")
    public final void setGroupSendMembersAdapter(GroupSendMembersAdapter groupSendMembersAdapter) {
        Intrinsics.checkNotNullParameter(groupSendMembersAdapter, "");
        this.groupSendMembersAdapter = groupSendMembersAdapter;
    }

    @JvmName(name = "getGroupSendInitResponse")
    public final SendMoneyGroupInitModel getGroupSendInitResponse() {
        SendMoneyGroupInitModel sendMoneyGroupInitModel = this.groupSendInitResponse;
        if (sendMoneyGroupInitModel != null) {
            return sendMoneyGroupInitModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGroupSendInitResponse")
    public final void setGroupSendInitResponse(SendMoneyGroupInitModel sendMoneyGroupInitModel) {
        Intrinsics.checkNotNullParameter(sendMoneyGroupInitModel, "");
        this.groupSendInitResponse = sendMoneyGroupInitModel;
    }

    @JvmName(name = "getRemainingLimit")
    public final CurrencyAmountModel getRemainingLimit() {
        CurrencyAmountModel currencyAmountModel = this.remainingLimit;
        if (currencyAmountModel != null) {
            return currencyAmountModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setRemainingLimit")
    public final void setRemainingLimit(CurrencyAmountModel currencyAmountModel) {
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        this.remainingLimit = currencyAmountModel;
    }

    @JvmName(name = "getSummaryIntentModel")
    public final GroupSendIntentModel getSummaryIntentModel() {
        GroupSendIntentModel groupSendIntentModel = this.summaryIntentModel;
        if (groupSendIntentModel != null) {
            return groupSendIntentModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSummaryIntentModel")
    public final void setSummaryIntentModel(GroupSendIntentModel groupSendIntentModel) {
        Intrinsics.checkNotNullParameter(groupSendIntentModel, "");
        this.summaryIntentModel = groupSendIntentModel;
    }

    @JvmName(name = "getSelectedMemberIndex")
    public final int getSelectedMemberIndex() {
        return this.selectedMemberIndex;
    }

    @JvmName(name = "setSelectedMemberIndex")
    public final void setSelectedMemberIndex(int i) {
        this.selectedMemberIndex = i;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityGroupSendSummaryBinding inflateViewBinding() {
        ActivityGroupSendSummaryBinding BuiltInFictitiousFunctionClassFactory = ActivityGroupSendSummaryBinding.BuiltInFictitiousFunctionClassFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            GroupSendComponent authRequestContext = ((GroupSendComponentProvider) applicationContext).provideGroupSendComponent().getAuthRequestContext();
            this.getErrorConfigVersion = authRequestContext;
            authRequestContext.BuiltInFictitiousFunctionClassFactory(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.di.provider.GroupSendComponentProvider");
    }

    public final void MyBillsEntityDataFactory() {
        if (!Intrinsics.areEqual(getSummaryIntentModel().NetworkUserEntityData$$ExternalSyntheticLambda0, GroupDetailActivity.ACTIVITY_NAME) && !Intrinsics.areEqual(getSummaryIntentModel().NetworkUserEntityData$$ExternalSyntheticLambda0, GroupRecipientActivity.ACTIVITY_NAME)) {
            ((GroupSendSummaryViewModel) this.moveToNextValue.getValue()).MyBillsEntityDataFactory(getSummaryIntentModel().BuiltInFictitiousFunctionClassFactory);
        } else {
            PlaceComponentResult();
        }
        final GroupSendSummaryViewModel groupSendSummaryViewModel = (GroupSendSummaryViewModel) this.moveToNextValue.getValue();
        String str = getSummaryIntentModel().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(str, "");
        BaseUseCase.execute$default(groupSendSummaryViewModel.BuiltInFictitiousFunctionClassFactory, str, new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$getGroupFavoriteValue$1
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
                mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendSummaryUIState groupSendSummaryUIState = (GroupSendSummaryUIState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.OnSuccessGetGroupFavoriteValue(z)));
            }
        }, null, 4, null);
    }

    private final void moveToNextValue() {
        AppCompatImageView appCompatImageView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(StringsKt.isBlank(getSummaryIntentModel().BuiltInFictitiousFunctionClassFactory) ? 0 : 8);
        AppCompatImageView appCompatImageView2 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
        appCompatImageView2.setVisibility(StringsKt.isBlank(getSummaryIntentModel().BuiltInFictitiousFunctionClassFactory) ? 0 : 8);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        Toolbar toolbar = getBinding().PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        setToolbar(toolbar);
        Toolbar toolbar2 = getToolbar();
        toolbar2.setNavigationIcon(ContextCompat.PlaceComponentResult(toolbar2.getContext(), R.drawable.PlaceComponentResult));
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupSendSummaryActivity.m2922$r8$lambda$NAELOhMgshZlhkdXwu_Sia3Co(GroupSendSummaryActivity.this, view);
            }
        });
        toolbar2.setContentDescription(toolbar2.getContext().getString(R.string.NetworkUserEntityData$$ExternalSyntheticLambda1));
        TextView textView = getBinding().PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2;
        GroupSendSummary groupSendSummary = this.lookAheadTest;
        if (groupSendSummary == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            groupSendSummary = null;
        }
        textView.setText(getString(groupSendSummary.MyBillsEntityDataFactory()));
    }

    private final void MyBillsEntityDataFactory(GroupSendIntentModel p0) {
        setSummaryIntentModel(p0);
        MyBillsEntityDataFactory(p0.getAuthRequestContext, p0.scheduleImpl);
        moveToNextValue();
        scheduleImpl();
        NetworkUserEntityData$$ExternalSyntheticLambda0();
        BuiltInFictitiousFunctionClassFactory();
        PlaceComponentResult(false);
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        if (getSummaryIntentModel().PlaceComponentResult.length() > 0) {
            TextView textView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.moveToNextValue;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R.string.last_transaction);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{getSummaryIntentModel().BuiltInFictitiousFunctionClassFactory()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            textView.setText(format);
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        RecyclerView recyclerView = getBinding().getAuthRequestContext.MyBillsEntityDataFactory;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), 1, false);
        setGroupSendMembersAdapter(new GroupSendMembersAdapter(getSummaryIntentModel().scheduleImpl));
        getGroupSendMembersAdapter().KClassImpl$Data$declaredNonStaticMembers$2 = GroupSendSummaryExtKt.PlaceComponentResult(this, new GroupSendSummaryActivity$setupAdapter$1$1(this), getSummaryIntentModel().scheduleImpl.size());
        recyclerView.setAdapter(getGroupSendMembersAdapter());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private final void scheduleImpl() {
        ViewStickyBottomSheetSummaryBinding viewStickyBottomSheetSummaryBinding = getBinding().getErrorConfigVersion;
        CurrencyAmountModel currencyAmountModel = new CurrencyAmountModel(KClassImpl$Data$declaredNonStaticMembers$2(), "Rp", false, 4, null);
        viewStickyBottomSheetSummaryBinding.MyBillsEntityDataFactory.setText(currencyAmountModel.getCurrencyAndAmountValue());
        if (currencyAmountModel.isAmountLessThanOne()) {
            viewStickyBottomSheetSummaryBinding.KClassImpl$Data$declaredNonStaticMembers$2.setEnabled(false);
            viewStickyBottomSheetSummaryBinding.KClassImpl$Data$declaredNonStaticMembers$2.setDisabled(getString(R.string.btn_send_now_text));
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(viewStickyBottomSheetSummaryBinding.MyBillsEntityDataFactory, R.style.getErrorConfigVersion);
        } else {
            viewStickyBottomSheetSummaryBinding.KClassImpl$Data$declaredNonStaticMembers$2.setEnabled(true);
            viewStickyBottomSheetSummaryBinding.KClassImpl$Data$declaredNonStaticMembers$2.setActiveButton(getString(R.string.btn_send_now_text), null);
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(viewStickyBottomSheetSummaryBinding.MyBillsEntityDataFactory, R.style.moveToNextValue);
        }
        getErrorConfigVersion();
    }

    public final void getErrorConfigVersion() {
        String string = getString(R.string.btn_send_now_text);
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2;
        if (lookAheadTest()) {
            danaButtonPrimaryView.setActiveButton(string, null);
            danaButtonPrimaryView.setEnabled(true);
        } else {
            danaButtonPrimaryView.setDisabled(string);
            danaButtonPrimaryView.setEnabled(false);
        }
        danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupSendSummaryActivity.$r8$lambda$Zwg4StjKzuH_RrQlKhxDWfg_XJM(GroupSendSummaryActivity.this, view);
            }
        });
    }

    private final String KClassImpl$Data$declaredNonStaticMembers$2() {
        long j;
        Iterator<T> it = getSummaryIntentModel().scheduleImpl.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            String str = ((RecipientViewModel) it.next()).BuiltInFictitiousFunctionClassFactory;
            if (str != null) {
                Intrinsics.checkNotNullExpressionValue(str, "");
                j = Long.parseLong(str);
            } else {
                j = 0;
            }
            j2 += j;
        }
        return String.valueOf(j2);
    }

    private final boolean lookAheadTest() {
        RecipientViewModel recipientViewModel;
        Iterator<T> it = getSummaryIntentModel().scheduleImpl.iterator();
        do {
            boolean z = true;
            if (!it.hasNext()) {
                return true;
            }
            recipientViewModel = (RecipientViewModel) it.next();
            String str = recipientViewModel.BuiltInFictitiousFunctionClassFactory;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (z) {
                break;
            }
        } while (!Intrinsics.areEqual(recipientViewModel.BuiltInFictitiousFunctionClassFactory, "0"));
        return false;
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public final void onBackPressed() {
        if (getBinding().BuiltInFictitiousFunctionClassFactory.isRootVisible()) {
            getBinding().BuiltInFictitiousFunctionClassFactory.dismiss();
        } else if (this.scheduleImpl) {
            ((MaterialDialog) this.MyBillsEntityDataFactory.getValue()).show();
        } else {
            super.onBackPressed();
        }
    }

    private final void MyBillsEntityDataFactory(String p0, List<? extends RecipientViewModel> p1) {
        if (StringsKt.isBlank(getSummaryIntentModel().BuiltInFictitiousFunctionClassFactory)) {
            GroupSendIntentModel summaryIntentModel = getSummaryIntentModel();
            String authRequestContext = GroupSendSummaryExtKt.getAuthRequestContext(this, p0, p1);
            Intrinsics.checkNotNullParameter(authRequestContext, "");
            summaryIntentModel.getAuthRequestContext = authRequestContext;
        }
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.GetContactSyncConfig.setText(getSummaryIntentModel().getAuthRequestContext);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/activity/GroupSendSummaryActivity$Companion;", "", "()V", "ACTIVITY_NAME", "", "SUMMARY_INTENT_MODEL", "createIntentForResult", "Landroid/content/Intent;", "intentModel", "Lid/dana/sendmoney/ui/groupsend/summary/model/GroupSendIntentModel;", "source", HummerConstants.CONTEXT, "Landroid/content/Context;", "feature-sendmoney_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent getAuthRequestContext(GroupSendIntentModel groupSendIntentModel, String str, Context context) {
            Intrinsics.checkNotNullParameter(groupSendIntentModel, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intent intent = new Intent();
            if (context != null) {
                intent = new Intent(context, GroupSendSummaryActivity.class);
            }
            intent.putExtra("summary_intent_model", groupSendIntentModel);
            intent.putExtra("source", str);
            return intent;
        }
    }

    public static /* synthetic */ void $r8$lambda$9W4ozEFLnDVNf6CYXbtt27mIjSo(GroupSendSummaryActivity groupSendSummaryActivity, View view) {
        Intrinsics.checkNotNullParameter(groupSendSummaryActivity, "");
        GroupSendIntentModel summaryIntentModel = groupSendSummaryActivity.getSummaryIntentModel();
        Intrinsics.checkNotNullParameter(ACTIVITY_NAME, "");
        summaryIntentModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = ACTIVITY_NAME;
        ActivityResultLauncher<Intent> activityResultLauncher = groupSendSummaryActivity.getAuthRequestContext;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activityResultLauncher = null;
        }
        GroupRecipientActivity.Companion companion = GroupRecipientActivity.INSTANCE;
        activityResultLauncher.MyBillsEntityDataFactory(GroupRecipientActivity.Companion.PlaceComponentResult(groupSendSummaryActivity, groupSendSummaryActivity.getSummaryIntentModel()), null);
    }

    public static /* synthetic */ void $r8$lambda$AT7DLWKDcaBswovQ8Ycj4_imtgM(ViewGroupSendEditProfileBinding viewGroupSendEditProfileBinding, GroupSendSummaryActivity groupSendSummaryActivity, View view) {
        Intrinsics.checkNotNullParameter(viewGroupSendEditProfileBinding, "");
        Intrinsics.checkNotNullParameter(groupSendSummaryActivity, "");
        AppCompatImageView appCompatImageView = viewGroupSendEditProfileBinding.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        if (appCompatImageView.getVisibility() == 0) {
            new BottomSheetImagePickerDialogFragment(new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$showImagePicker$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    Intrinsics.checkNotNullParameter(str, "");
                    GroupSendIntentModel summaryIntentModel = GroupSendSummaryActivity.this.getSummaryIntentModel();
                    Intrinsics.checkNotNullParameter(str, "");
                    summaryIntentModel.MyBillsEntityDataFactory = str;
                    GroupSendSummaryActivity.access$initGroupImage(GroupSendSummaryActivity.this);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }
            }).show(groupSendSummaryActivity.getSupportFragmentManager(), "ImageChooserDialogFragment");
        }
    }

    /* renamed from: $r8$lambda$NAELOhMgshZlhk-d-Xwu_Sia3Co */
    public static /* synthetic */ void m2922$r8$lambda$NAELOhMgshZlhkdXwu_Sia3Co(GroupSendSummaryActivity groupSendSummaryActivity, View view) {
        Intrinsics.checkNotNullParameter(groupSendSummaryActivity, "");
        groupSendSummaryActivity.onBackPressed();
    }

    public static /* synthetic */ void $r8$lambda$Zwg4StjKzuH_RrQlKhxDWfg_XJM(GroupSendSummaryActivity groupSendSummaryActivity, View view) {
        Intrinsics.checkNotNullParameter(groupSendSummaryActivity, "");
        GroupSendIntentModel summaryIntentModel = groupSendSummaryActivity.getSummaryIntentModel();
        final GroupSendSummaryViewModel groupSendSummaryViewModel = (GroupSendSummaryViewModel) groupSendSummaryActivity.moveToNextValue.getValue();
        String str = summaryIntentModel.BuiltInFictitiousFunctionClassFactory;
        final String str2 = summaryIntentModel.getAuthRequestContext;
        final String str3 = summaryIntentModel.MyBillsEntityDataFactory;
        final List<ParticipantSubmitModel> MyBillsEntityDataFactory = GroupSendSummaryModelMapperKt.MyBillsEntityDataFactory(summaryIntentModel.scheduleImpl, Intrinsics.areEqual(summaryIntentModel.moveToNextValue, GroupSendRecipientType.CONTACT) ? "BALANCE" : "BANK_TRANSFER", groupSendSummaryActivity, groupSendSummaryActivity.getGroupSendInitResponse().KClassImpl$Data$declaredNonStaticMembers$2);
        final boolean kClassImpl$Data$declaredNonStaticMembers$2 = summaryIntentModel.getKClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
        ConfirmSendMoneyGroup confirmSendMoneyGroup = groupSendSummaryViewModel.KClassImpl$Data$declaredNonStaticMembers$2;
        List<ParticipantSubmitModel> list = MyBillsEntityDataFactory;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(GroupSendSummaryModelMapperKt.getAuthRequestContext((ParticipantSubmitModel) it.next()));
        }
        confirmSendMoneyGroup.execute(new ConfirmSendMoneyGroup.Param(null, str, str2, str3, arrayList, null, 33, null), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$confirmSendMoneyGroup$2
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
                mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendSummaryUIState groupSendSummaryUIState = (GroupSendSummaryUIState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.DanaLogoLoading(true)));
            }
        }, new Function1<SendMoneyGroupConfirm, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$confirmSendMoneyGroup$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SendMoneyGroupConfirm sendMoneyGroupConfirm) {
                invoke2(sendMoneyGroupConfirm);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SendMoneyGroupConfirm sendMoneyGroupConfirm) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(sendMoneyGroupConfirm, "");
                GroupSendSummaryViewModel groupSendSummaryViewModel2 = GroupSendSummaryViewModel.this;
                String str4 = sendMoneyGroupConfirm.BuiltInFictitiousFunctionClassFactory;
                if (str4 == null) {
                    str4 = "";
                }
                groupSendSummaryViewModel2.getErrorConfigVersion.execute(SaveRecentGroup.Params.INSTANCE.forSaveRecentGroup(str4, str2, str3, MyBillsEntityDataFactory.size(), GroupSendRecipientType.CONTACT, kClassImpl$Data$declaredNonStaticMembers$2), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001a: INVOKE 
                      (wrap: id.dana.domain.recentrecipient.interactor.SaveRecentGroup : 0x000c: IGET (r1v0 'groupSendSummaryViewModel2' id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel) A[WRAPPED] (LINE:1251) id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel.getErrorConfigVersion id.dana.domain.recentrecipient.interactor.SaveRecentGroup)
                      (wrap: id.dana.domain.recentrecipient.interactor.SaveRecentGroup$Params : 0x0008: INVOKE 
                      (wrap: id.dana.domain.recentrecipient.interactor.SaveRecentGroup$Params$Companion : 0x0000: SGET  A[WRAPPED] (LINE:1242) id.dana.domain.recentrecipient.interactor.SaveRecentGroup.Params.Companion id.dana.domain.recentrecipient.interactor.SaveRecentGroup$Params$Companion)
                      (r2v1 'str4' java.lang.String)
                      (wrap: java.lang.String : 0x000c: IGET 
                      (r8v0 'this' id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$confirmSendMoneyGroup$3 A[IMMUTABLE_TYPE, THIS])
                     A[WRAPPED] (LINE:114) id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$confirmSendMoneyGroup$3.$$groupName java.lang.String)
                      (wrap: java.lang.String : 0x000e: IGET 
                      (r8v0 'this' id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$confirmSendMoneyGroup$3 A[IMMUTABLE_TYPE, THIS])
                     A[WRAPPED] id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$confirmSendMoneyGroup$3.$$groupLogo java.lang.String)
                      (wrap: int : 0x0012: INVOKE 
                      (wrap: java.util.List<id.dana.sendmoney.ui.groupsend.summary.model.ParticipantSubmitModel> : 0x0010: IGET 
                      (r8v0 'this' id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$confirmSendMoneyGroup$3 A[IMMUTABLE_TYPE, THIS])
                     A[WRAPPED] (LINE:115) id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$confirmSendMoneyGroup$3.$$participants java.util.List)
                     type: INTERFACE call: java.util.List.size():int A[MD:():int (c), WRAPPED] (LINE:115))
                      (wrap: java.lang.String : SGET  A[DONT_GENERATE, REMOVE, WRAPPED] id.dana.sendmoney.constants.GroupSendRecipientType.CONTACT java.lang.String)
                      (wrap: boolean : 0x0016: IGET 
                      (r8v0 'this' id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$confirmSendMoneyGroup$3 A[IMMUTABLE_TYPE, THIS])
                     A[WRAPPED] id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$confirmSendMoneyGroup$3.$$isFavorite boolean)
                     type: VIRTUAL call: id.dana.domain.recentrecipient.interactor.SaveRecentGroup.Params.Companion.forSaveRecentGroup(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, boolean):id.dana.domain.recentrecipient.interactor.SaveRecentGroup$Params A[MD:(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, boolean):id.dana.domain.recentrecipient.interactor.SaveRecentGroup$Params (m), WRAPPED] (LINE:1242))
                      (wrap: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$doWhenSendMoneyComplete$1 : 0x000e: SGET  A[WRAPPED] id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$doWhenSendMoneyComplete$1.INSTANCE id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$doWhenSendMoneyComplete$1)
                      (wrap: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$doWhenSendMoneyComplete$2 : 0x0012: SGET  A[WRAPPED] id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$doWhenSendMoneyComplete$2.INSTANCE id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$doWhenSendMoneyComplete$2)
                     type: VIRTUAL call: id.dana.domain.core.usecase.BaseUseCase.execute(java.lang.Object, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void A[MD:(Params, kotlin.jvm.functions.Function1<? super T, kotlin.Unit>, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit>):void (m)] (LINE:1251) in method: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$confirmSendMoneyGroup$3.invoke(id.dana.sendmoney.domain.groupsend.model.submit.SendMoneyGroupConfirm):void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                    	at java.base/java.util.ArrayList.forEach(Unknown Source)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$doWhenSendMoneyComplete$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:307)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                    	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1105)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                    	... 15 more
                    */
                /*
                    this = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                    id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel r1 = id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel.this
                    java.lang.String r2 = r9.BuiltInFictitiousFunctionClassFactory
                    if (r2 != 0) goto Lc
                    r2 = r0
                Lc:
                    java.lang.String r3 = r2
                    java.lang.String r4 = r3
                    java.util.List<id.dana.sendmoney.ui.groupsend.summary.model.ParticipantSubmitModel> r0 = r4
                    int r5 = r0.size()
                    boolean r7 = r5
                    java.lang.String r6 = "group_phone"
                    id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel.BuiltInFictitiousFunctionClassFactory(r1, r2, r3, r4, r5, r6, r7)
                    id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel r0 = id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel.this
                    kotlinx.coroutines.flow.MutableStateFlow r0 = id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel.PlaceComponentResult(r0)
                L23:
                    java.lang.Object r1 = r0.getValue()
                    r2 = r1
                    id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryUIState r2 = (id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryUIState) r2
                    id.dana.sendmoney.ui.groupsend.summary.model.SendMoneyGroupConfirmModel r2 = id.dana.sendmoney.ui.groupsend.summary.mapper.GroupSendSummaryModelMapperKt.MyBillsEntityDataFactory(r9)
                    id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryUIState$OnSuccessConfirmSendMoneyGroup r3 = new id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryUIState$OnSuccessConfirmSendMoneyGroup
                    r3.<init>(r2)
                    id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryUIState r3 = (id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryUIState) r3
                    boolean r1 = r0.compareAndSet(r1, r3)
                    if (r1 == 0) goto L23
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$confirmSendMoneyGroup$3.invoke2(id.dana.sendmoney.domain.groupsend.model.submit.SendMoneyGroupConfirm):void");
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$confirmSendMoneyGroup$4
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
                mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendSummaryUIState groupSendSummaryUIState = (GroupSendSummaryUIState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.Error(0, th, GroupSendOperationType.GROUP_TRANSFER_SUBMIT, 1, null)));
            }
        }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$confirmSendMoneyGroup$5
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
                mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendSummaryUIState groupSendSummaryUIState = (GroupSendSummaryUIState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.DanaLogoLoading(false)));
            }
        }, ViewModelKt.PlaceComponentResult(groupSendSummaryViewModel));
        groupSendSummaryActivity.getGroupSendTrackerHelper().BuiltInFictitiousFunctionClassFactory(GroupSendTrackerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(groupSendSummaryActivity.getSummaryIntentModel().moveToNextValue), Integer.parseInt(groupSendSummaryActivity.KClassImpl$Data$declaredNonStaticMembers$2()), summaryIntentModel.scheduleImpl.size());
    }

    /* renamed from: $r8$lambda$aJw45U2O9P4-6-Hi-Ln6umBITP0 */
    public static /* synthetic */ void m2923$r8$lambda$aJw45U2O9P46HiLn6umBITP0(GroupSendSummaryActivity groupSendSummaryActivity, View view) {
        Intrinsics.checkNotNullParameter(groupSendSummaryActivity, "");
        groupSendSummaryActivity.getBinding().BuiltInFictitiousFunctionClassFactory.show();
    }

    public static /* synthetic */ void $r8$lambda$bVyloFONwOvu2IUMCZrr4nJUecA(GroupSendSummaryActivity groupSendSummaryActivity, GroupSendIntentModel groupSendIntentModel) {
        Intrinsics.checkNotNullParameter(groupSendSummaryActivity, "");
        if (groupSendIntentModel != null) {
            groupSendSummaryActivity.setSummaryIntentModel(groupSendIntentModel);
            groupSendSummaryActivity.scheduleImpl = true;
            groupSendSummaryActivity.MyBillsEntityDataFactory(groupSendIntentModel);
            ((GroupSendSummaryViewModel) groupSendSummaryActivity.moveToNextValue.getValue()).MyBillsEntityDataFactory(Intrinsics.areEqual(groupSendSummaryActivity.getSummaryIntentModel().moveToNextValue, GroupSendRecipientType.CONTACT) ? "BALANCE" : "BANK_TRANSFER", groupSendSummaryActivity.getSummaryIntentModel().getAuthRequestContext());
        }
    }

    public static final /* synthetic */ void access$checkIsThereNonDanaUser(GroupSendSummaryActivity groupSendSummaryActivity) {
        if (groupSendSummaryActivity.getGroupSendInitResponse().KClassImpl$Data$declaredNonStaticMembers$2.size() != groupSendSummaryActivity.getSummaryIntentModel().scheduleImpl.size()) {
            InformationDialogFragment informationDialogFragment = (InformationDialogFragment) groupSendSummaryActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
            FragmentManager supportFragmentManager = groupSendSummaryActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            informationDialogFragment.MyBillsEntityDataFactory(supportFragmentManager);
        }
    }

    public static final /* synthetic */ GroupSendSummaryViewModel access$getVm(GroupSendSummaryActivity groupSendSummaryActivity) {
        return (GroupSendSummaryViewModel) groupSendSummaryActivity.moveToNextValue.getValue();
    }

    public static final /* synthetic */ void access$initGroupImage(GroupSendSummaryActivity groupSendSummaryActivity) {
        if (groupSendSummaryActivity.getSummaryIntentModel().MyBillsEntityDataFactory.length() > 0) {
            CircleImageView circleImageView = groupSendSummaryActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(circleImageView, "");
            GlideApp.getAuthRequestContext(circleImageView.getContext()).PlaceComponentResult(groupSendSummaryActivity.getSummaryIntentModel().MyBillsEntityDataFactory).getErrorConfigVersion(R.drawable.ic_user_default_placeholder).PlaceComponentResult(R.drawable.ic_user_default_placeholder).MyBillsEntityDataFactory((ImageView) circleImageView);
            return;
        }
        GroupSendAvatarRandomizerEngine groupSendAvatarRandomizerEngine = new GroupSendAvatarRandomizerEngine(groupSendSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda0, new Function1<AvatarModel, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$initGroupImage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AvatarModel avatarModel) {
                Intrinsics.checkNotNullParameter(avatarModel, "");
                GroupSendSummaryActivity.access$setAvatarState(GroupSendSummaryActivity.this, avatarModel);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(AvatarModel avatarModel) {
                invoke2(avatarModel);
                return Unit.INSTANCE;
            }
        });
        SecureRandom secureRandom = new SecureRandom();
        if (groupSendAvatarRandomizerEngine.getAuthRequestContext == -1) {
            List<Integer> list = groupSendAvatarRandomizerEngine.PlaceComponentResult;
            groupSendAvatarRandomizerEngine.MyBillsEntityDataFactory.invoke(GroupSendAvatarRandomizerEngine.MyBillsEntityDataFactory(list.get(secureRandom.nextInt(list.size())).intValue()));
            return;
        }
        List<Integer> list2 = groupSendAvatarRandomizerEngine.PlaceComponentResult;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (((Number) obj).intValue() != groupSendAvatarRandomizerEngine.getAuthRequestContext) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        groupSendAvatarRandomizerEngine.MyBillsEntityDataFactory.invoke(GroupSendAvatarRandomizerEngine.MyBillsEntityDataFactory(((Number) arrayList2.get(secureRandom.nextInt(arrayList2.size()))).intValue()));
    }

    public static final /* synthetic */ void access$onAmountChanged(GroupSendSummaryActivity groupSendSummaryActivity, String str, boolean z) {
        groupSendSummaryActivity.scheduleImpl = true;
        groupSendSummaryActivity.getSummaryIntentModel().scheduleImpl.get(groupSendSummaryActivity.selectedMemberIndex).BuiltInFictitiousFunctionClassFactory = str;
        if (z) {
            Iterator<T> it = groupSendSummaryActivity.getSummaryIntentModel().scheduleImpl.iterator();
            while (it.hasNext()) {
                ((RecipientViewModel) it.next()).BuiltInFictitiousFunctionClassFactory = str;
            }
        }
        groupSendSummaryActivity.NetworkUserEntityData$$ExternalSyntheticLambda0();
        groupSendSummaryActivity.setRemainingLimit(new CurrencyAmountModel(String.valueOf(Integer.parseInt(StringsKt.replace$default(groupSendSummaryActivity.getGroupSendInitResponse().PlaceComponentResult.getAmount(), ".", "", false, 4, (Object) null)) - Integer.parseInt(groupSendSummaryActivity.KClassImpl$Data$declaredNonStaticMembers$2())), "Rp", false, 4, null));
        groupSendSummaryActivity.scheduleImpl();
    }

    public static final /* synthetic */ void access$setAvatarState(GroupSendSummaryActivity groupSendSummaryActivity, AvatarModel avatarModel) {
        __fsTypeCheck_074055a5770ceee3ff60e06bca0881e0(groupSendSummaryActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult, avatarModel.PlaceComponentResult);
        groupSendSummaryActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult.setTag(Integer.valueOf(avatarModel.PlaceComponentResult));
        GroupSendIntentModel summaryIntentModel = groupSendSummaryActivity.getSummaryIntentModel();
        String str = avatarModel.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(str, "");
        summaryIntentModel.MyBillsEntityDataFactory = str;
        final GroupSendSummaryViewModel groupSendSummaryViewModel = (GroupSendSummaryViewModel) groupSendSummaryActivity.moveToNextValue.getValue();
        int i = avatarModel.KClassImpl$Data$declaredNonStaticMembers$2;
        BaseFlowUseCase.execute$default(groupSendSummaryViewModel.moveToNextValue, Integer.valueOf(i), null, new Function1<Unit, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$saveDefaultAvatarGroup$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(unit, "");
                mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendSummaryUIState groupSendSummaryUIState = (GroupSendSummaryUIState) value;
                } while (!mutableStateFlow.compareAndSet(value, GroupSendSummaryUIState.None.INSTANCE));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$saveDefaultAvatarGroup$2
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
                mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendSummaryUIState groupSendSummaryUIState = (GroupSendSummaryUIState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.Error(0, th, GroupSendOperationType.GROUP_SAVE_DEFAULT_AVATAR_GROUP, 1, null)));
            }
        }, null, ViewModelKt.PlaceComponentResult(groupSendSummaryViewModel), 18, null);
    }

    public static final /* synthetic */ void access$setDanaLoadingVisibility(GroupSendSummaryActivity groupSendSummaryActivity, boolean z) {
        if (!z) {
            ((DanaLogoLoadingDialog) groupSendSummaryActivity.BuiltInFictitiousFunctionClassFactory.getValue()).PlaceComponentResult();
            return;
        }
        DanaLogoLoadingDialog danaLogoLoadingDialog = (DanaLogoLoadingDialog) groupSendSummaryActivity.BuiltInFictitiousFunctionClassFactory.getValue();
        if (danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.isShowing()) {
            return;
        }
        danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.show();
        danaLogoLoadingDialog.MyBillsEntityDataFactory.startRefresh();
    }

    public static final /* synthetic */ void access$setEditMemberButtonVisibility(GroupSendSummaryActivity groupSendSummaryActivity, boolean z) {
        if (groupSendSummaryActivity.getSummaryIntentModel().BuiltInFictitiousFunctionClassFactory.length() == 0) {
            TextView textView = groupSendSummaryActivity.getBinding().getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = groupSendSummaryActivity.getBinding().getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(z ? 0 : 8);
    }

    public static final /* synthetic */ void access$setGroupModifiedResult(GroupSendSummaryActivity groupSendSummaryActivity) {
        Intent intent = new Intent();
        intent.putExtra(GroupSendLandingActivity.IS_GROUP_MODIFIED, true);
        groupSendSummaryActivity.setResult(-1, intent);
    }

    public static final /* synthetic */ void access$setShimmerLoadingVisibility(GroupSendSummaryActivity groupSendSummaryActivity, boolean z) {
        if (z) {
            GroupSendSummaryShimmerExt groupSendSummaryShimmerExt = GroupSendSummaryShimmerExt.INSTANCE;
            ActivityGroupSendSummaryBinding binding = groupSendSummaryActivity.getBinding();
            Intrinsics.checkNotNullParameter(binding, "");
            GroupSendSummaryShimmerExt.getAuthRequestContext(binding);
            GroupSendSummaryShimmerExt.BuiltInFictitiousFunctionClassFactory(binding);
            GroupSendSummaryShimmerExt.KClassImpl$Data$declaredNonStaticMembers$2(binding);
            return;
        }
        GroupSendSummaryShimmerExt groupSendSummaryShimmerExt2 = GroupSendSummaryShimmerExt.INSTANCE;
        GroupSendSummaryShimmerExt.PlaceComponentResult();
    }

    public static final /* synthetic */ void access$updateGroupSendGroupId(GroupSendSummaryActivity groupSendSummaryActivity, String str) {
        GroupSendIntentModel summaryIntentModel = groupSendSummaryActivity.getSummaryIntentModel();
        Intrinsics.checkNotNullParameter(str, "");
        summaryIntentModel.BuiltInFictitiousFunctionClassFactory = str;
        groupSendSummaryActivity.getErrorConfigVersion();
        groupSendSummaryActivity.moveToNextValue();
    }

    public static final /* synthetic */ void access$updateParticipantAdapterList(GroupSendSummaryActivity groupSendSummaryActivity) {
        ArrayList arrayList;
        do {
            arrayList = new ArrayList();
        } while (groupSendSummaryActivity.groupSendMembersAdapter == null);
        List<? extends RecipientViewModel> list = groupSendSummaryActivity.getGroupSendMembersAdapter().BuiltInFictitiousFunctionClassFactory;
        if (list.isEmpty()) {
            list = groupSendSummaryActivity.getSummaryIntentModel().scheduleImpl;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(GroupSendSummaryExtKt.KClassImpl$Data$declaredNonStaticMembers$2(groupSendSummaryActivity, groupSendSummaryActivity.getGroupSendInitResponse().KClassImpl$Data$declaredNonStaticMembers$2, (RecipientViewModel) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        groupSendSummaryActivity.MyBillsEntityDataFactory("", arrayList2);
        GroupSendMembersAdapter groupSendMembersAdapter = groupSendSummaryActivity.getGroupSendMembersAdapter();
        Intrinsics.checkNotNullParameter(arrayList2, "");
        groupSendMembersAdapter.BuiltInFictitiousFunctionClassFactory = arrayList2;
        groupSendMembersAdapter.notifyDataSetChanged();
    }

    public static final /* synthetic */ void access$updatePreviousTransactionAvatarList(GroupSendSummaryActivity groupSendSummaryActivity) {
        Object obj;
        for (PayeeUserInfoModel payeeUserInfoModel : groupSendSummaryActivity.getGroupSendInitResponse().KClassImpl$Data$declaredNonStaticMembers$2) {
            NumberUtil numberUtil = NumberUtil.INSTANCE;
            String NetworkUserEntityData$$ExternalSyntheticLambda0 = NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda0(payeeUserInfoModel.MyBillsEntityDataFactory);
            Iterator<T> it = groupSendSummaryActivity.getSummaryIntentModel().scheduleImpl.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((RecipientViewModel) obj).DatabaseTableConfigUtil, NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                    break;
                }
            }
            RecipientViewModel recipientViewModel = (RecipientViewModel) obj;
            if (recipientViewModel != null) {
                recipientViewModel.scheduleImpl = payeeUserInfoModel.BuiltInFictitiousFunctionClassFactory;
            }
        }
        GroupCircleImageRichView groupCircleImageRichView = groupSendSummaryActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext;
        List<? extends RecipientViewModel> list = groupSendSummaryActivity.getSummaryIntentModel().scheduleImpl;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((RecipientViewModel) it2.next()).scheduleImpl);
        }
        groupCircleImageRichView.setGroupImages(arrayList);
        TextView textView = groupSendSummaryActivity.getBinding().getAuthRequestContext.PlaceComponentResult;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = groupSendSummaryActivity.getString(R.string.send_to_members_text);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(groupSendSummaryActivity.getSummaryIntentModel().scheduleImpl.size())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        textView.setText(format);
    }

    private final void PlaceComponentResult() {
        ((GroupSendSummaryViewModel) this.moveToNextValue.getValue()).MyBillsEntityDataFactory(Intrinsics.areEqual(getSummaryIntentModel().moveToNextValue, GroupSendRecipientType.CONTACT) ? "BALANCE" : "BANK_TRANSFER", getSummaryIntentModel().getAuthRequestContext());
    }

    public final void PlaceComponentResult(boolean p0) {
        if (p0) {
            GroupSendSummaryShimmerExt groupSendSummaryShimmerExt = GroupSendSummaryShimmerExt.INSTANCE;
            GroupSendSummaryShimmerExt.PlaceComponentResult();
        }
        NestedScrollView nestedScrollView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
        boolean z = !p0;
        nestedScrollView.setVisibility(z ? 0 : 8);
        FrameLayout frameLayout = getBinding().getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(z ? 0 : 8);
        EmptyStateView emptyStateView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(emptyStateView, "");
        emptyStateView.setVisibility(p0 ? 0 : 8);
        View view = getBinding().scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(view, "");
        view.setVisibility(z ? 0 : 8);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContract<Intent, GroupSendIntentModel>() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$editRecipient$1
            @Override // androidx.view.result.contract.ActivityResultContract
            public final /* synthetic */ Intent createIntent(Context context, Intent intent) {
                Intent intent2 = intent;
                Intrinsics.checkNotNullParameter(context, "");
                Intrinsics.checkNotNullParameter(intent2, "");
                return intent2;
            }

            @Override // androidx.view.result.contract.ActivityResultContract
            public final /* synthetic */ GroupSendIntentModel parseResult(int i, Intent intent) {
                if (i == -1 && intent != null) {
                    return (GroupSendIntentModel) intent.getParcelableExtra("summary_intent_model");
                }
                return null;
            }
        }, new ActivityResultCallback() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$$ExternalSyntheticLambda5
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GroupSendSummaryActivity.$r8$lambda$bVyloFONwOvu2IUMCZrr4nJUecA(GroupSendSummaryActivity.this, (GroupSendIntentModel) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.getAuthRequestContext = registerForActivityResult;
        Intent intent = getIntent();
        GroupSendIntentModel groupSendIntentModel = (GroupSendIntentModel) intent.getParcelableExtra("summary_intent_model");
        if (groupSendIntentModel != null) {
            Intrinsics.checkNotNullExpressionValue(groupSendIntentModel, "");
            MyBillsEntityDataFactory(groupSendIntentModel);
            this.scheduleImpl = Intrinsics.areEqual(groupSendIntentModel.NetworkUserEntityData$$ExternalSyntheticLambda0, GroupRecipientActivity.ACTIVITY_NAME);
        }
        String stringExtra = intent.getStringExtra("source");
        this.PlaceComponentResult = stringExtra != null ? stringExtra : "";
        GroupSendSummaryActivity groupSendSummaryActivity = this;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(groupSendSummaryActivity), null, null, new GroupSendSummaryActivity$initLifecycleActivity$1(this, null), 3, null);
        GroupSendSummaryFactory groupSendSummaryFactory = getGroupSendSummaryFactory();
        this.lookAheadTest = Intrinsics.areEqual(getSummaryIntentModel().moveToNextValue, GroupSendRecipientType.CONTACT) ? groupSendSummaryFactory.BuiltInFictitiousFunctionClassFactory : groupSendSummaryFactory.PlaceComponentResult;
        final ViewGroupSendEditProfileBinding viewGroupSendEditProfileBinding = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        viewGroupSendEditProfileBinding.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupSendSummaryActivity.$r8$lambda$AT7DLWKDcaBswovQ8Ycj4_imtgM(ViewGroupSendEditProfileBinding.this, this, view);
            }
        });
        viewGroupSendEditProfileBinding.scheduleImpl.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupSendSummaryActivity.m2923$r8$lambda$aJw45U2O9P46HiLn6umBITP0(GroupSendSummaryActivity.this, view);
            }
        });
        TextView textView = getBinding().getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        textView.setContentDescription(getString(R.string.btn_edit_member));
        textView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupSendSummaryActivity.$r8$lambda$9W4ozEFLnDVNf6CYXbtt27mIjSo(GroupSendSummaryActivity.this, view);
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnBottomActionClickListener(new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$initViewListener$3
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
                GroupSendSummaryActivity.this.PlaceComponentResult(false);
                GroupSendSummaryActivity.this.MyBillsEntityDataFactory();
            }
        });
        GroupSendEditNameDialog groupSendEditNameDialog = getBinding().BuiltInFictitiousFunctionClassFactory;
        groupSendEditNameDialog.setTextChangeListenerLifecycle(LifecycleOwnerKt.PlaceComponentResult(groupSendSummaryActivity));
        groupSendEditNameDialog.setOnPositiveButtonClicked(new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$initEditGroupNameDialog$1$1
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
                ActivityGroupSendSummaryBinding binding;
                Intrinsics.checkNotNullParameter(str, "");
                GroupSendIntentModel summaryIntentModel = GroupSendSummaryActivity.this.getSummaryIntentModel();
                Intrinsics.checkNotNullParameter(str, "");
                summaryIntentModel.getAuthRequestContext = str;
                binding = GroupSendSummaryActivity.this.getBinding();
                binding.NetworkUserEntityData$$ExternalSyntheticLambda0.GetContactSyncConfig.setText(str);
            }
        });
        groupSendEditNameDialog.setOnDismissDialogListener(new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$initEditGroupNameDialog$1$2
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
                KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(GroupSendSummaryActivity.this);
            }
        });
        moveToNextValue();
        MyBillsEntityDataFactory();
        getGroupSendTrackerHelper().getAuthRequestContext(this.PlaceComponentResult, "Peer");
    }

    private static void a(boolean z, int[] iArr, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr = PrepareContext;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            for (int i5 = 0; i5 < length; i5++) {
                cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i2];
        System.arraycopy(cArr, i, cArr3, 0, i2);
        if (bArr != null) {
            char[] cArr4 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                } else {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                }
                c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr4;
        }
        if (i4 > 0) {
            char[] cArr5 = new char[i2];
            System.arraycopy(cArr3, 0, cArr5, 0, i2);
            int i6 = i2 - i4;
            System.arraycopy(cArr5, 0, cArr3, i6, i4);
            System.arraycopy(cArr5, i4, cArr3, 0, i6);
        }
        if (z) {
            char[] cArr6 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr6;
        }
        if (i3 > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        objArr[0] = new String(cArr3);
    }
}

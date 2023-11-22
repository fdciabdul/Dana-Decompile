package id.dana.sendmoney.ui.globalsend.landing.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
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
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.SkeletonScreen;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.DanaLogoLoadingDialog;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.core.ui.util.ShimmeringUtil;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.network.exception.NetworkException;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ActivityGlobalSendLandingBinding;
import id.dana.sendmoney.di.component.GlobalSendComponent;
import id.dana.sendmoney.di.provider.GlobalSendComponentProvider;
import id.dana.sendmoney.domain.globalsend.interactor.ValidateRecurringTransaction;
import id.dana.sendmoney.domain.globalsend.model.validate.TransferValidateResult;
import id.dana.sendmoney.ui.common.DefaultSearchHelper;
import id.dana.sendmoney.ui.common.EmptyStateView;
import id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity;
import id.dana.sendmoney.ui.globalsend.form.mapper.BeneficiaryModelMapperKt;
import id.dana.sendmoney.ui.globalsend.form.mapper.TransferValidateModelMapperKt;
import id.dana.sendmoney.ui.globalsend.form.model.BeneficiaryInfoModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CountryModel;
import id.dana.sendmoney.ui.globalsend.form.view.SelectCountryBottomSheet;
import id.dana.sendmoney.ui.globalsend.landing.GlobalSendSortRecipientExtKt;
import id.dana.sendmoney.ui.globalsend.landing.adapter.GlobalSendBeneficiaryAdapter;
import id.dana.sendmoney.ui.globalsend.landing.constant.MoreActionType;
import id.dana.sendmoney.ui.globalsend.landing.model.QueryBeneficiaryResultModel;
import id.dana.sendmoney.ui.globalsend.landing.view.GlobalSendMoreActionBeneficiarySheet;
import id.dana.sendmoney.ui.globalsend.landing.view.GlobalSendOnBoardingSheet;
import id.dana.sendmoney.ui.globalsend.landing.view.GlobalSendSortBeneficiarySheet;
import id.dana.sendmoney.ui.globalsend.landing.view.MoreActionBeneficiaryListener;
import id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingUiState;
import id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel;
import id.dana.sendmoney.ui.groupsend.recipient.view.SearchView;
import id.dana.sendmoney.util.GlobalSendTrackerHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\bR\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u0019\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\n\u0010\u0016R\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u0016\u0010\u0013\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0013\u0010\n\u001a\u00020\u001fX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b \u0010!R\u0013\u0010\u0012\u001a\u00020\"X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010 \u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u001d\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\u0013\u0010,\u001a\u00020*X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b+\u0010!R\"\u0010.\u001a\u00020-8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0013\u0010\u0019\u001a\u000204X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b5\u0010!R\u001e\u0010:\u001a\f\u0012\b\u0012\u0006*\u00020707068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010#\u001a\u00020;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u00105\u001a\u00020>8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010%\u001a\u00020A8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010+\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\"\u0010J\u001a\u00020I8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0013\u00108\u001a\u00020PX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bQ\u0010!"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/activity/GlobalSendLandingActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/sendmoney/databinding/ActivityGlobalSendLandingBinding;", "", "configToolbar", "()V", "", "p0", "", "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Ljava/util/List;", "inflateViewBinding", "()Lid/dana/sendmoney/databinding/ActivityGlobalSendLandingBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "getAuthRequestContext", "(Ljava/lang/String;)V", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "", "(Z)V", "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "Lid/dana/sendmoney/ui/globalsend/form/view/SelectCountryBottomSheet;", "scheduleImpl", "Lid/dana/sendmoney/ui/globalsend/form/view/SelectCountryBottomSheet;", "", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryModel;", "lookAheadTest", "Ljava/util/List;", "Lid/dana/core/ui/dialog/DanaLogoLoadingDialog;", "getErrorConfigVersion", "Lkotlin/Lazy;", "Lid/dana/sendmoney/ui/globalsend/landing/view/GlobalSendMoreActionBeneficiarySheet;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/sendmoney/ui/globalsend/landing/adapter/GlobalSendBeneficiaryAdapter;", "initRecordTimeStamp", "Lid/dana/sendmoney/ui/globalsend/landing/adapter/GlobalSendBeneficiaryAdapter;", "Lid/dana/sendmoney/di/component/GlobalSendComponent;", "DatabaseTableConfigUtil", "Lid/dana/sendmoney/di/component/GlobalSendComponent;", "Lid/dana/sendmoney/ui/globalsend/landing/view/GlobalSendOnBoardingSheet;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/sendmoney/util/GlobalSendTrackerHelper;", "globalSendTrackerHelper", "Lid/dana/sendmoney/util/GlobalSendTrackerHelper;", "getGlobalSendTrackerHelper", "()Lid/dana/sendmoney/util/GlobalSendTrackerHelper;", "setGlobalSendTrackerHelper", "(Lid/dana/sendmoney/util/GlobalSendTrackerHelper;)V", "Lid/dana/sendmoney/ui/globalsend/landing/view/GlobalSendSortBeneficiarySheet;", "GetContactSyncConfig", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "PrepareContext", "Landroidx/activity/result/ActivityResultLauncher;", "moveToNextValue", "", "NetworkUserEntityData$$ExternalSyntheticLambda7", "I", "Lid/dana/sendmoney/ui/globalsend/landing/model/QueryBeneficiaryResultModel;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/sendmoney/ui/globalsend/landing/model/QueryBeneficiaryResultModel;", "Lid/dana/sendmoney/ui/common/DefaultSearchHelper;", "isLayoutRequested", "Lid/dana/sendmoney/ui/common/DefaultSearchHelper;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "newProxyInstance", "Lcom/ethanhua/skeleton/SkeletonScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Ljava/lang/String;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/core/ui/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/core/ui/di/module/ViewModelFactory;)V", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSendLandingActivity extends BaseViewBindingActivity<ActivityGlobalSendLandingBinding> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private GlobalSendComponent lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final Lazy PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private BeneficiaryInfoModel PlaceComponentResult;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> moveToNextValue;
    @Inject
    public GlobalSendTrackerHelper globalSendTrackerHelper;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private GlobalSendBeneficiaryAdapter getErrorConfigVersion;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private DefaultSearchHelper initRecordTimeStamp;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private SkeletonScreen NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private SelectCountryBottomSheet BuiltInFictitiousFunctionClassFactory;
    @Inject
    public ViewModelFactory viewModelFactory;
    public static final byte[] $$a = {11, Ascii.GS, 107, 8, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 136;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {16, -72, -107, 15, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 20;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda5 = {62255, 33249, 5800, 43903, 14373, 52962, 17324, 53287, 25895, 64503, 34996, 7467, 37379, 8416, 46516, 19048, 57128, 28150, 58024, 30564, 1038, 39667, 12202, 48252, 12599, 51187, 19545, 16014, 43466, 5131, 34651, 29073, 64712, 28476, 55874, 17539, 14300, 41496, 11605, 40854, 2752, 62748, 24645, 53893, 15001, 18519, 57118, 25289, 61843, 1876, 35354, 6545, 44191, 12866, 16732, 54499, 23430, 59738, 31765, 33746, 5787, 42074, 62243, 33270, 5785, 43876, 14382, 62329, 33260, 5882, 43829, 14458, 52975, 17393, 53297, 25969, 64482, 34983, 7523, 37415, 8369, 46577, 18999, 57199, 28078, 58090, 30588, 1086, 39672, 12219, 48175, 12594, 51108, 21740, 59761, 32352, 3319, 33201, 5748, 43863, 14745, 52958, 17172, 53260, 26258, 64464, 34841, 7505, 37825, 8400, 46355, 18944, 55440, 28118, 57924, 53941, 40992, 14176, 35571, 6582, 61224, 25186, 61867, 17592, 55934, 43367, 15530, 46012, 296, 37995, 27567, 65270, 19511, 49952, 22198, 9636, 47920, 3700, 40368, 4346, 58991, 30071, 51434, 24560, 11629, 41080, 14265, 35479, 6225, 61250, 25231, 61843, 18258, 55874, 43392, 15561, 45581, 283, 38030, 27547, 63758, 19531, 50060, 22231, 9238, 47953, 3742, 40409, 4886, 58962, 30098, 51420, 24092, 11533, 41165, 14297, 34065, 6158, 61336, 62332, 33214, 5801, 43887, 14451, 52924, 17402, 53309, 25982, 64447, 35068, 7476, 37491, 8368, 46576, 18998, 57151, 28154, 58088, 30585, 1128, 39673, 12217, 48170, 12641, 51185, 21741, 59693, 32308, 3317, 33255, 5746, 43865, 14795, 52958, 17173, 53256, 26268, 64478, 34833, 7518, 37825, 8405, 46353, 19034, 55443, 28033, 57923, 30488, 1414, 39583, 12120, 48200, 12938, 51102, 21516, 59713, 32642, 3277, 33027, 5652, 42118, 14789, 52744, 50382, 46611, 8528, 40085, 4049, 63833, 29711, 59342, 21194, 52238, 48962, 10892, 42372, 5919, 33344, 32155, 59603, 23062, 54592, 16534, 13267, 44288, 6212, 35807, 1753, 61450, 25437, 56975, 18910, 15112, 46665, 8588, 40167, 3637, 63841, 29931, 59361, 20780, 52333, 49134, 10991, 42047, 5989, 33506, 32227, 61221, 23151, 54700, 16613, 12835, 44347, 6307, 35744, 1404, 61557, 25511, 57083, 18481, 15208, 46766, 62327, 33185, 5880, 43811, 14456, 52922};
    private static long FragmentBottomSheetPaymentSettingBinding = 8468365379048145295L;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private List<CountryModel> getAuthRequestContext = CollectionsKt.emptyList();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private QueryBeneficiaryResultModel GetContactSyncConfig = new QueryBeneficiaryResultModel(null, 0, null, 7, null);

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private String DatabaseTableConfigUtil = "RECENT";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<GlobalSendOnBoardingSheet>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$globalSendOnBoardingSheet$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GlobalSendOnBoardingSheet invoke() {
            return new GlobalSendOnBoardingSheet();
        }
    });

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy scheduleImpl = LazyKt.lazy(new Function0<GlobalSendSortBeneficiarySheet>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$globalSortRecentRecipientSheet$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GlobalSendSortBeneficiarySheet invoke() {
            final GlobalSendLandingActivity globalSendLandingActivity = GlobalSendLandingActivity.this;
            return new GlobalSendSortBeneficiarySheet(new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$globalSortRecentRecipientSheet$2.1
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
                    GlobalSendBeneficiaryAdapter globalSendBeneficiaryAdapter;
                    Intrinsics.checkNotNullParameter(str, "");
                    final GlobalSendLandingViewModel access$getVm = GlobalSendLandingActivity.access$getVm(GlobalSendLandingActivity.this);
                    Intrinsics.checkNotNullParameter(str, "");
                    BaseFlowUseCase.execute$default(access$getVm.lookAheadTest, str, null, new Function1<Unit, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$saveSortBeneficiaryList$1
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
                            mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                            do {
                                value = mutableStateFlow.getValue();
                                GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                            } while (!mutableStateFlow.compareAndSet(value, GlobalSendLandingUiState.None.INSTANCE));
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$saveSortBeneficiaryList$2
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
                            mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                            do {
                                value = mutableStateFlow.getValue();
                                GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                            } while (!mutableStateFlow.compareAndSet(value, GlobalSendLandingUiState.None.INSTANCE));
                        }
                    }, null, ViewModelKt.PlaceComponentResult(access$getVm), 18, null);
                    GlobalSendLandingActivity.this.BuiltInFictitiousFunctionClassFactory(str);
                    GlobalSendLandingActivity.this.DatabaseTableConfigUtil = str;
                    globalSendBeneficiaryAdapter = GlobalSendLandingActivity.this.getErrorConfigVersion;
                    if (globalSendBeneficiaryAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        globalSendBeneficiaryAdapter = null;
                    }
                    Intrinsics.checkNotNullParameter(str, "");
                    globalSendBeneficiaryAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = GlobalSendSortRecipientExtKt.MyBillsEntityDataFactory(globalSendBeneficiaryAdapter.KClassImpl$Data$declaredNonStaticMembers$2, str);
                    globalSendBeneficiaryAdapter.notifyDataSetChanged();
                }
            });
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<GlobalSendMoreActionBeneficiarySheet>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$globalMoreActionRecipientSheet$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GlobalSendMoreActionBeneficiarySheet invoke() {
            final GlobalSendLandingActivity globalSendLandingActivity = GlobalSendLandingActivity.this;
            return new GlobalSendMoreActionBeneficiarySheet(new Function2<String, String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$globalMoreActionRecipientSheet$2.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                    invoke2(str, str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str, final String str2) {
                    Intrinsics.checkNotNullParameter(str, "");
                    Intrinsics.checkNotNullParameter(str2, "");
                    if (Intrinsics.areEqual(str, MoreActionType.FAVORITE) || !Intrinsics.areEqual(str, "DELETE")) {
                        return;
                    }
                    CustomDialog.Builder builder = new CustomDialog.Builder(GlobalSendLandingActivity.this);
                    builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_warning_red;
                    builder.SubSequence = GlobalSendLandingActivity.this.getString(R.string.text_delete_beneficiary_confirmation);
                    String string = GlobalSendLandingActivity.this.getString(R.string.yes_confirmation);
                    final GlobalSendLandingActivity globalSendLandingActivity2 = GlobalSendLandingActivity.this;
                    builder.BuiltInFictitiousFunctionClassFactory(string, new Function1<View, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity.globalMoreActionRecipientSheet.2.1.1
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
                            final GlobalSendLandingViewModel access$getVm = GlobalSendLandingActivity.access$getVm(GlobalSendLandingActivity.this);
                            final String str3 = str2;
                            Intrinsics.checkNotNullParameter(str3, "");
                            access$getVm.KClassImpl$Data$declaredNonStaticMembers$2.execute(str3, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$deleteBeneficiaryList$1
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
                                    mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                                    do {
                                        value = mutableStateFlow.getValue();
                                        GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                                    } while (!mutableStateFlow.compareAndSet(value, new GlobalSendLandingUiState.DanaLoading(true)));
                                }
                            }, new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$deleteBeneficiaryList$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                                    String str4 = str3;
                                    do {
                                        value = mutableStateFlow.getValue();
                                        GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                                    } while (!mutableStateFlow.compareAndSet(value, new GlobalSendLandingUiState.OnSuccessDeleteBeneficiary(str4)));
                                }
                            }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$deleteBeneficiaryList$3
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
                                    mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                                    do {
                                        value = mutableStateFlow.getValue();
                                        GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                                    } while (!mutableStateFlow.compareAndSet(value, GlobalSendLandingUiState.OnErrorDeleteBeneficiary.INSTANCE));
                                }
                            }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$deleteBeneficiaryList$4
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
                                    mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                                    do {
                                        value = mutableStateFlow.getValue();
                                        GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                                    } while (!mutableStateFlow.compareAndSet(value, new GlobalSendLandingUiState.DanaLoading(false)));
                                }
                            }, ViewModelKt.PlaceComponentResult(access$getVm));
                        }
                    }).KClassImpl$Data$declaredNonStaticMembers$2(GlobalSendLandingActivity.this.getString(R.string.no_confirmation), new Function1<View, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity.globalMoreActionRecipientSheet.2.1.2
                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(View view) {
                            Intrinsics.checkNotNullParameter(view, "");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                            invoke2(view);
                            return Unit.INSTANCE;
                        }
                    }).KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory().show();
                }
            });
        }
    });

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<DanaLogoLoadingDialog>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$danaLogoLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLogoLoadingDialog invoke() {
            return new DanaLogoLoadingDialog(GlobalSendLandingActivity.this);
        }
    });

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0026 -> B:35:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = 56 - r8
            byte[] r0 = id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity.KClassImpl$Data$declaredNonStaticMembers$2
            int r9 = r9 + 16
            int r7 = r7 + 97
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2f
        L13:
            r3 = 0
        L14:
            r6 = r9
            r9 = r7
            r7 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2f:
            int r7 = -r7
            int r8 = r8 + 1
            int r10 = r10 + r7
            int r7 = r10 + (-4)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity.b(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x002a -> B:35:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 4
            byte[] r0 = id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity.$$a
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r6 = r6 * 2
            int r6 = 103 - r6
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
            goto L33
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L33:
            int r9 = r9 + 1
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity.c(short, int, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(17 - TextUtils.lastIndexOf("", '0'), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 44, (char) (TextUtils.getOffsetAfter("", 0) + 51638), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 5, (ViewConfiguration.getTapTimeout() >> 16) + 62, (char) TextUtils.indexOf("", ""), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getScrollBarSize() >> 8), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(48 - (ViewConfiguration.getTapTimeout() >> 16), TextUtils.indexOf("", "", 0) + 67, (char) (Process.myPid() >> 22), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(64 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), Color.red(0) + 115, (char) (8602 - KeyEvent.normalizeMetaState(0)), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((ViewConfiguration.getEdgeSlop() >> 16) + 64, AndroidCharacter.getMirror('0') + 131, (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((ViewConfiguration.getTouchSlop() >> 8) + 60, 243 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (14312 - (ViewConfiguration.getWindowTouchSlop() >> 8)), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(6 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 302 - TextUtils.lastIndexOf("", '0'), (char) Gravity.getAbsoluteGravity(0, 0), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 911, 17 - Process.getGidForName(""), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[3], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[30] + 1);
                Object[] objArr14 = new Object[1];
                b(b, (byte) (b | 22), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 55, Color.green(0) + 3, (char) TextUtils.getCapsMode("", 0, 0));
                        byte b2 = $$a[12];
                        byte b3 = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b2, b3, (byte) (b3 - 1), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getCapsMode("", 0, 0), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 15, (char) (Process.myPid() >> 22))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.indexOf("", "", 0, 0), 14 - TextUtils.lastIndexOf("", '0', 0), (char) KeyEvent.keyCodeFromString(""))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(816 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), View.MeasureSpec.getSize(0) + 29, (char) (57994 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, Process.getGidForName("") + 16, (char) ((-1) - Process.getGidForName(""))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {80532826, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[3], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b4 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[30] + 1);
                Object[] objArr20 = new Object[1];
                b(b4, (byte) (b4 | 22), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - View.getDefaultSize(0, 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 46, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))));
                        byte b5 = (byte) ($$a[78] - 1);
                        byte b6 = b5;
                        Object[] objArr22 = new Object[1];
                        c(b5, b6, (byte) (b6 | Ascii.ETB), objArr22);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), Color.blue(0) + 35, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {80532826, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), Color.rgb(0, 0, 0) + 16777234, (char) View.MeasureSpec.getSize(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[3], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b7 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[30] + 1);
                Object[] objArr26 = new Object[1];
                b(b7, (byte) (b7 | 22), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - Color.alpha(0), 2 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ((-16738248) - Color.rgb(0, 0, 0)));
                        byte b8 = (byte) ($$a[78] - 1);
                        byte b9 = b8;
                        Object[] objArr28 = new Object[1];
                        c(b8, b9, (byte) (b9 | Ascii.ETB), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Gravity.getAbsoluteGravity(0, 0), 35 - (ViewConfiguration.getTapTimeout() >> 16), (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {80532826, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 18, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), KClassImpl$Data$declaredNonStaticMembers$2[3], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b10 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[30] + 1);
                Object[] objArr32 = new Object[1];
                b(b10, (byte) (b10 | 22), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(106 - Process.getGidForName(""), KeyEvent.normalizeMetaState(0) + 3, (char) View.getDefaultSize(0, 0));
                        Object[] objArr34 = new Object[1];
                        c($$a[9], $$a[8], $$a[53], objArr34);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), 35 - TextUtils.indexOf("", "", 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {80532826, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.blue(0), 18 - (ViewConfiguration.getTouchSlop() >> 8), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    /* JADX WARN: Removed duplicated region for block: B:425:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0566 A[Catch: all -> 0x06ab, TryCatch #5 {all -> 0x06ab, blocks: (B:423:0x054d, B:427:0x05b9, B:426:0x0566), top: B:477:0x054d }] */
    /* JADX WARN: Removed duplicated region for block: B:430:0x05d1  */
    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate(android.os.Bundle r23) {
        /*
            Method dump skipped, instructions count: 1727
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity.onCreate(android.os.Bundle):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().codePointAt(1) - 74, getPackageName().length() - 7, (char) (super.getResources().getString(id.dana.R.string.bank_account_verify).substring(0, 5).length() - 5), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(18 - View.resolveSizeAndState(0, 0, 0), getPackageName().length() + 19, (char) (MotionEvent.axisFromString("") + 49013), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getTrimmedLength(""), ExpandableListView.getPackedPositionType(0L) + 35, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            try {
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr = new Object[1];
                b(b, (byte) (b | TarHeader.LF_BLK), KClassImpl$Data$declaredNonStaticMembers$2[30], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[8], new Object[1]);
                Object[] objArr2 = new Object[1];
                a(((ApplicationInfo) cls.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 7, super.getResources().getString(id.dana.R.string.card_binding_otp_resend).substring(16, 17).codePointAt(0) - 100, (char) (super.getResources().getString(id.dana.R.string.sendmoney_bank_promo_desc).substring(0, 3).codePointAt(0) - 49), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                int length = super.getResources().getString(id.dana.R.string.res_0x7f13087d_daggeruserbankcardcomponent_userbankcardcomponentimpl_postexecutionthreadprovider).substring(9, 10).length() + 17;
                try {
                    byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                    Object[] objArr3 = new Object[1];
                    b(b2, (byte) (b2 | TarHeader.LF_BLK), KClassImpl$Data$declaredNonStaticMembers$2[30], objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    b(KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[25], KClassImpl$Data$declaredNonStaticMembers$2[8], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    a(length, ((ApplicationInfo) cls3.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 7, (char) (super.getResources().getString(id.dana.R.string.tooltip_highlight_description_scan_qr).substring(8, 9).length() + 49011), objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 36 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) Color.red(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getFadingEdgeLength() >> 16), 18 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) TextUtils.indexOf("", ""))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
    }

    public GlobalSendLandingActivity() {
        final GlobalSendLandingActivity globalSendLandingActivity = this;
        final Function0 function0 = null;
        this.PrepareContext = new ViewModelLazy(Reflection.getOrCreateKotlinClass(GlobalSendLandingViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GlobalSendLandingActivity.this.getViewModelFactory();
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$special$$inlined$viewModels$default$3
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
                    CreationExtras defaultViewModelCreationExtras = globalSendLandingActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        });
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$$ExternalSyntheticLambda1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GlobalSendLandingActivity.m2915$r8$lambda$Bbhr337Mc_tJp1ZItkaRqcYX_M(GlobalSendLandingActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.moveToNextValue = registerForActivityResult;
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

    @JvmName(name = "getGlobalSendTrackerHelper")
    public final GlobalSendTrackerHelper getGlobalSendTrackerHelper() {
        GlobalSendTrackerHelper globalSendTrackerHelper = this.globalSendTrackerHelper;
        if (globalSendTrackerHelper != null) {
            return globalSendTrackerHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGlobalSendTrackerHelper")
    public final void setGlobalSendTrackerHelper(GlobalSendTrackerHelper globalSendTrackerHelper) {
        Intrinsics.checkNotNullParameter(globalSendTrackerHelper, "");
        this.globalSendTrackerHelper = globalSendTrackerHelper;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        Context applicationContext = getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.di.provider.GlobalSendComponentProvider");
        }
        GlobalSendComponent authRequestContext = ((GlobalSendComponentProvider) applicationContext).provideGlobalSendComponent().getAuthRequestContext();
        this.lookAheadTest = authRequestContext;
        authRequestContext.MyBillsEntityDataFactory(this);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityGlobalSendLandingBinding inflateViewBinding() {
        ActivityGlobalSendLandingBinding KClassImpl$Data$declaredNonStaticMembers$22 = ActivityGlobalSendLandingBinding.KClassImpl$Data$declaredNonStaticMembers$2(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        Toolbar toolbar = getBinding().MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        setToolbar(toolbar);
        Toolbar toolbar2 = getToolbar();
        Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(toolbar2.getContext(), R.drawable.PlaceComponentResult);
        toolbar2.setContentDescription(getString(R.string.NetworkUserEntityData$$ExternalSyntheticLambda1));
        toolbar2.setNavigationIcon(PlaceComponentResult);
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GlobalSendLandingActivity.m2917$r8$lambda$qpuRwM5zxS3gQEP9kuvB6nR70k(GlobalSendLandingActivity.this, view);
            }
        });
        getBinding().MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(R.string.global_send_toolbar_title));
    }

    public final void getAuthRequestContext(String p0) {
        if (p0.length() == 0) {
            GlobalSendBeneficiaryAdapter globalSendBeneficiaryAdapter = this.getErrorConfigVersion;
            if (globalSendBeneficiaryAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                globalSendBeneficiaryAdapter = null;
            }
            globalSendBeneficiaryAdapter.BuiltInFictitiousFunctionClassFactory(this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory, this.DatabaseTableConfigUtil);
            KClassImpl$Data$declaredNonStaticMembers$2(false);
            return;
        }
        MyBillsEntityDataFactory(p0);
    }

    private final void MyBillsEntityDataFactory(String p0) {
        List<BeneficiaryInfoModel> KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(p0);
        GlobalSendBeneficiaryAdapter globalSendBeneficiaryAdapter = null;
        if (KClassImpl$Data$declaredNonStaticMembers$22.isEmpty()) {
            GlobalSendBeneficiaryAdapter globalSendBeneficiaryAdapter2 = this.getErrorConfigVersion;
            if (globalSendBeneficiaryAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                globalSendBeneficiaryAdapter = globalSendBeneficiaryAdapter2;
            }
            globalSendBeneficiaryAdapter.BuiltInFictitiousFunctionClassFactory(new ArrayList(), this.DatabaseTableConfigUtil);
            PlaceComponentResult();
            return;
        }
        GlobalSendBeneficiaryAdapter globalSendBeneficiaryAdapter3 = this.getErrorConfigVersion;
        if (globalSendBeneficiaryAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            globalSendBeneficiaryAdapter = globalSendBeneficiaryAdapter3;
        }
        globalSendBeneficiaryAdapter.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$22, this.DatabaseTableConfigUtil);
        KClassImpl$Data$declaredNonStaticMembers$2(true);
    }

    private final List<BeneficiaryInfoModel> KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        List<BeneficiaryInfoModel> list = this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            BeneficiaryInfoModel beneficiaryInfoModel = (BeneficiaryInfoModel) obj;
            String str = p0;
            boolean z = true;
            if (!StringsKt.contains((CharSequence) beneficiaryInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda2, (CharSequence) str, true) && !StringsKt.contains((CharSequence) beneficiaryInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda8, (CharSequence) str, true) && !StringsKt.contains((CharSequence) beneficiaryInfoModel.MyBillsEntityDataFactory(), (CharSequence) str, true) && !StringsKt.contains((CharSequence) beneficiaryInfoModel.GetContactSyncConfig, (CharSequence) str, true)) {
                z = false;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        if (Intrinsics.areEqual(p0, "ALPHABET")) {
            getBinding().PlaceComponentResult.isLayoutRequested.setText(getString(R.string.text_value_sorted_by_alphabet));
        } else if (Intrinsics.areEqual(p0, "RECENT")) {
            getBinding().PlaceComponentResult.isLayoutRequested.setText(getString(R.string.text_value_sorted_by_recent));
        } else {
            getBinding().PlaceComponentResult.isLayoutRequested.setText(getString(R.string.text_value_sorted_by_oldest));
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        getAuthRequestContext();
        SelectCountryBottomSheet selectCountryBottomSheet = this.BuiltInFictitiousFunctionClassFactory;
        SelectCountryBottomSheet selectCountryBottomSheet2 = null;
        if (selectCountryBottomSheet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            selectCountryBottomSheet = null;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        SelectCountryBottomSheet selectCountryBottomSheet3 = this.BuiltInFictitiousFunctionClassFactory;
        if (selectCountryBottomSheet3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            selectCountryBottomSheet2 = selectCountryBottomSheet3;
        }
        selectCountryBottomSheet.show(supportFragmentManager, selectCountryBottomSheet2.getTag());
    }

    private final void getAuthRequestContext() {
        this.BuiltInFictitiousFunctionClassFactory = new SelectCountryBottomSheet(this.getAuthRequestContext, new Function1<List<? extends CountryModel>, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$instantiateBottomSheet$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends CountryModel> list) {
                invoke2((List<CountryModel>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<CountryModel> list) {
                Intrinsics.checkNotNullParameter(list, "");
                GlobalSendLandingActivity.this.getAuthRequestContext = list;
            }
        }, new Function1<CountryModel, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$instantiateBottomSheet$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CountryModel countryModel) {
                invoke2(countryModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CountryModel countryModel) {
                ActivityResultLauncher activityResultLauncher;
                Intrinsics.checkNotNullParameter(countryModel, "");
                activityResultLauncher = GlobalSendLandingActivity.this.moveToNextValue;
                activityResultLauncher.MyBillsEntityDataFactory(new Intent(GlobalSendLandingActivity.this, GlobalSendFormActivity.class).putExtra("COUNTRY_MODEL", countryModel).putExtra(GlobalSendFormActivity.PAGE_SOURCE, GlobalSendLandingActivity.access$getCurrentViewStateForPageSource(GlobalSendLandingActivity.this)).putExtra(GlobalSendFormActivity.IS_NEW_RECIPIENT, true), null);
            }
        });
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2$default(GlobalSendLandingActivity globalSendLandingActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        globalSendLandingActivity.KClassImpl$Data$declaredNonStaticMembers$2(z);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        String string;
        TextView textView = getBinding().PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (p0) {
            string = getString(R.string.text_search_result);
        } else {
            string = getString(R.string.text_list_recipient_global_send);
        }
        textView.setText(string);
        ConstraintLayout constraintLayout = getBinding().PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(0);
        ConstraintLayout constraintLayout2 = getBinding().PlaceComponentResult.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
        constraintLayout2.setVisibility(0);
        EmptyStateView emptyStateView = getBinding().PlaceComponentResult.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(emptyStateView, "");
        emptyStateView.setVisibility(8);
    }

    public final void PlaceComponentResult() {
        getBinding().PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1.setText(getString(R.string.text_search_result));
        ConstraintLayout constraintLayout = getBinding().PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(8);
        ConstraintLayout constraintLayout2 = getBinding().PlaceComponentResult.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
        constraintLayout2.setVisibility(0);
        EmptyStateView emptyStateView = getBinding().PlaceComponentResult.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(emptyStateView, "");
        emptyStateView.setVisibility(0);
    }

    public static /* synthetic */ void $r8$lambda$9FoWVWz4_x1nHi3dQfy2qUJs0Xs(GlobalSendLandingActivity globalSendLandingActivity, View view) {
        Intrinsics.checkNotNullParameter(globalSendLandingActivity, "");
        GlobalSendSortBeneficiarySheet globalSendSortBeneficiarySheet = (GlobalSendSortBeneficiarySheet) globalSendLandingActivity.scheduleImpl.getValue();
        FragmentManager supportFragmentManager = globalSendLandingActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        globalSendSortBeneficiarySheet.KClassImpl$Data$declaredNonStaticMembers$2(supportFragmentManager, globalSendLandingActivity.DatabaseTableConfigUtil);
    }

    /* renamed from: $r8$lambda$9UuD5QIE_yYIyRqiXy-s0nI6EDM */
    public static /* synthetic */ void m2914$r8$lambda$9UuD5QIE_yYIyRqiXys0nI6EDM(GlobalSendLandingActivity globalSendLandingActivity, View view) {
        Intrinsics.checkNotNullParameter(globalSendLandingActivity, "");
        SearchView searchView = globalSendLandingActivity.getBinding().PlaceComponentResult.newProxyInstance;
        searchView.clearEditText();
        searchView.clearEditTextFocus();
        KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(globalSendLandingActivity);
        globalSendLandingActivity.getAuthRequestContext("");
    }

    /* renamed from: $r8$lambda$B-bhr337Mc_tJp1ZItkaRqcYX_M */
    public static /* synthetic */ void m2915$r8$lambda$Bbhr337Mc_tJp1ZItkaRqcYX_M(GlobalSendLandingActivity globalSendLandingActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(globalSendLandingActivity, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory == -1) {
            ((GlobalSendLandingViewModel) globalSendLandingActivity.PrepareContext.getValue()).PlaceComponentResult(globalSendLandingActivity.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
    }

    /* renamed from: $r8$lambda$myaRpzfZQe-vcb26BPj2nVn47RM */
    public static /* synthetic */ void m2916$r8$lambda$myaRpzfZQevcb26BPj2nVn47RM(GlobalSendLandingActivity globalSendLandingActivity, View view) {
        Intrinsics.checkNotNullParameter(globalSendLandingActivity, "");
        globalSendLandingActivity.KClassImpl$Data$declaredNonStaticMembers$2();
        globalSendLandingActivity.getGlobalSendTrackerHelper().BuiltInFictitiousFunctionClassFactory(true);
    }

    /* renamed from: $r8$lambda$qpuRwM5zxS3gQEP9kuvB-6nR70k */
    public static /* synthetic */ void m2917$r8$lambda$qpuRwM5zxS3gQEP9kuvB6nR70k(GlobalSendLandingActivity globalSendLandingActivity, View view) {
        Intrinsics.checkNotNullParameter(globalSendLandingActivity, "");
        globalSendLandingActivity.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void $r8$lambda$rRxkw_jvkUBqPLD1C_TcU4tQKTw(GlobalSendLandingActivity globalSendLandingActivity, View view) {
        Intrinsics.checkNotNullParameter(globalSendLandingActivity, "");
        globalSendLandingActivity.KClassImpl$Data$declaredNonStaticMembers$2();
        globalSendLandingActivity.getGlobalSendTrackerHelper().BuiltInFictitiousFunctionClassFactory(true);
    }

    public static /* synthetic */ void $r8$lambda$turWDq_PiL2t2YlD1sNDBArHMZQ(GlobalSendLandingActivity globalSendLandingActivity, View view) {
        Intrinsics.checkNotNullParameter(globalSendLandingActivity, "");
        GlobalSendOnBoardingSheet globalSendOnBoardingSheet = (GlobalSendOnBoardingSheet) globalSendLandingActivity.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
        FragmentManager supportFragmentManager = globalSendLandingActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        globalSendOnBoardingSheet.getAuthRequestContext(supportFragmentManager);
    }

    public static final /* synthetic */ String access$getCurrentViewStateForPageSource(GlobalSendLandingActivity globalSendLandingActivity) {
        ConstraintLayout constraintLayout = globalSendLandingActivity.getBinding().BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        if (constraintLayout.getVisibility() == 0) {
            return "Intro Page";
        }
        ConstraintLayout constraintLayout2 = globalSendLandingActivity.getBinding().PlaceComponentResult.lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
        return constraintLayout2.getVisibility() == 0 ? "Landing Page" : "";
    }

    public static final /* synthetic */ GlobalSendMoreActionBeneficiarySheet access$getGlobalMoreActionRecipientSheet(GlobalSendLandingActivity globalSendLandingActivity) {
        return (GlobalSendMoreActionBeneficiarySheet) globalSendLandingActivity.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ GlobalSendLandingViewModel access$getVm(GlobalSendLandingActivity globalSendLandingActivity) {
        return (GlobalSendLandingViewModel) globalSendLandingActivity.PrepareContext.getValue();
    }

    public static final /* synthetic */ void access$handleActivityStateAfterQueryBeneficiary(GlobalSendLandingActivity globalSendLandingActivity, QueryBeneficiaryResultModel queryBeneficiaryResultModel) {
        if (queryBeneficiaryResultModel.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
            ConstraintLayout constraintLayout = globalSendLandingActivity.getBinding().BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            constraintLayout.setVisibility(0);
            ConstraintLayout constraintLayout2 = globalSendLandingActivity.getBinding().PlaceComponentResult.lookAheadTest;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
            constraintLayout2.setVisibility(8);
            globalSendLandingActivity.getBinding().BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setOnClickListener(new GlobalSendLandingActivity$$ExternalSyntheticLambda6(globalSendLandingActivity));
            return;
        }
        ConstraintLayout constraintLayout3 = globalSendLandingActivity.getBinding().BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout3, "");
        constraintLayout3.setVisibility(8);
        ConstraintLayout constraintLayout4 = globalSendLandingActivity.getBinding().PlaceComponentResult.lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(constraintLayout4, "");
        constraintLayout4.setVisibility(0);
        GlobalSendBeneficiaryAdapter globalSendBeneficiaryAdapter = globalSendLandingActivity.getErrorConfigVersion;
        if (globalSendBeneficiaryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalSendBeneficiaryAdapter = null;
        }
        globalSendBeneficiaryAdapter.BuiltInFictitiousFunctionClassFactory(CollectionsKt.toMutableList((Collection) queryBeneficiaryResultModel.BuiltInFictitiousFunctionClassFactory), globalSendLandingActivity.DatabaseTableConfigUtil);
        AppCompatImageView appCompatImageView = globalSendLandingActivity.getBinding().MyBillsEntityDataFactory.lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, R.drawable.ic_hint_question);
        appCompatImageView.setContentDescription(globalSendLandingActivity.getString(R.string.FragmentBottomSheetPaymentSettingBinding_res_0x7f130310));
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GlobalSendLandingActivity.$r8$lambda$turWDq_PiL2t2YlD1sNDBArHMZQ(GlobalSendLandingActivity.this, view);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x002d, code lost:
    
        if (r3.equals("DE15012088999100") == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0046, code lost:
    
        if (r3.equals("DE13112088999203") == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x004f, code lost:
    
        if (r3.equals("DE13112088999202") == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0058, code lost:
    
        if (r3.equals("DE13112088999201") == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0061, code lost:
    
        if (r3.equals("DE13112088999200") == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x006a, code lost:
    
        if (r3.equals("DE13112088999113") == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0073, code lost:
    
        if (r3.equals("DE15112088999103") == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x007d, code lost:
    
        r3 = id.dana.core.ui.util.DANAToast.BuiltInFictitiousFunctionClassFactory;
        id.dana.core.ui.util.DANAToast.MyBillsEntityDataFactory(r2, r4, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0084, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x001b, code lost:
    
        if (r3.equals("DE15012088999102") == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0024, code lost:
    
        if (r3.equals("DE15012088999101") == false) goto L125;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void access$handleOnErrorWithCode(id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity r2, java.lang.String r3, java.lang.String r4) {
        /*
            int r0 = r3.hashCode()
            r1 = -343200130(0xffffffffeb8b2e7e, float:-3.365205E26)
            if (r0 == r1) goto L6d
            r1 = 243605915(0xe85219b, float:3.2819392E-30)
            if (r0 == r1) goto L64
            switch(r0) {
                case -472282852: goto L27;
                case -472282851: goto L1e;
                case -472282850: goto L15;
                default: goto L11;
            }
        L11:
            switch(r0) {
                case 243606842: goto L5b;
                case 243606843: goto L52;
                case 243606844: goto L49;
                case 243606845: goto L40;
                case 243606846: goto L30;
                default: goto L14;
            }
        L14:
            goto L75
        L15:
            java.lang.String r0 = "DE15012088999102"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L7d
            goto L75
        L1e:
            java.lang.String r0 = "DE15012088999101"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L7d
            goto L75
        L27:
            java.lang.String r0 = "DE15012088999100"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L7d
            goto L75
        L30:
            java.lang.String r4 = "DE13112088999204"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L75
            id.dana.sendmoney.util.GlobalSendErrorHelper r3 = id.dana.sendmoney.util.GlobalSendErrorHelper.getAuthRequestContext
            android.content.Context r2 = (android.content.Context) r2
            id.dana.sendmoney.util.GlobalSendErrorHelper.KClassImpl$Data$declaredNonStaticMembers$2(r2)
            return
        L40:
            java.lang.String r0 = "DE13112088999203"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L7d
            goto L75
        L49:
            java.lang.String r0 = "DE13112088999202"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L7d
            goto L75
        L52:
            java.lang.String r0 = "DE13112088999201"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L7d
            goto L75
        L5b:
            java.lang.String r0 = "DE13112088999200"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L7d
            goto L75
        L64:
            java.lang.String r0 = "DE13112088999113"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L7d
            goto L75
        L6d:
            java.lang.String r0 = "DE15112088999103"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L7d
        L75:
            id.dana.sendmoney.util.GlobalSendErrorHelper r3 = id.dana.sendmoney.util.GlobalSendErrorHelper.getAuthRequestContext
            android.content.Context r2 = (android.content.Context) r2
            id.dana.sendmoney.util.GlobalSendErrorHelper.PlaceComponentResult(r2)
            return
        L7d:
            id.dana.core.ui.util.DANAToast r3 = id.dana.core.ui.util.DANAToast.BuiltInFictitiousFunctionClassFactory
            android.app.Activity r2 = (android.app.Activity) r2
            id.dana.core.ui.util.DANAToast.BuiltInFictitiousFunctionClassFactory(r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity.access$handleOnErrorWithCode(id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity, java.lang.String, java.lang.String):void");
    }

    public static final /* synthetic */ void access$removeItemFromBeneficiaryResult(GlobalSendLandingActivity globalSendLandingActivity, String str) {
        Object obj;
        Iterator<T> it = globalSendLandingActivity.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((BeneficiaryInfoModel) obj).MyBillsEntityDataFactory, str)) {
                break;
            }
        }
        BeneficiaryInfoModel beneficiaryInfoModel = (BeneficiaryInfoModel) obj;
        if (beneficiaryInfoModel != null) {
            globalSendLandingActivity.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory.remove(globalSendLandingActivity.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory.indexOf(beneficiaryInfoModel));
        }
    }

    public static final /* synthetic */ void access$setErrorState(GlobalSendLandingActivity globalSendLandingActivity, boolean z) {
        EmptyStateView emptyStateView = globalSendLandingActivity.getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(emptyStateView, "");
        emptyStateView.setVisibility(z ? 0 : 8);
        ConstraintLayout constraintLayout = globalSendLandingActivity.getBinding().BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        boolean z2 = !z;
        constraintLayout.setVisibility(z2 ? 0 : 8);
        ConstraintLayout constraintLayout2 = globalSendLandingActivity.getBinding().PlaceComponentResult.lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
        constraintLayout2.setVisibility(z2 ? 0 : 8);
    }

    public static final /* synthetic */ void access$setErrorTextGetBeneficiary(GlobalSendLandingActivity globalSendLandingActivity) {
        EmptyStateView emptyStateView = globalSendLandingActivity.getBinding().getAuthRequestContext;
        String string = globalSendLandingActivity.getString(R.string.title_error_failed_beneficiary_list);
        Intrinsics.checkNotNullExpressionValue(string, "");
        emptyStateView.setTitle(string);
        String string2 = globalSendLandingActivity.getString(R.string.desc_error_failed_beneficiary_list);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        emptyStateView.setDesc(string2);
        emptyStateView.setOnBottomActionClickListener(new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$setErrorTextGetBeneficiary$1$1
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
                int i;
                GlobalSendLandingActivity.access$setErrorState(GlobalSendLandingActivity.this, false);
                GlobalSendLandingViewModel access$getVm = GlobalSendLandingActivity.access$getVm(GlobalSendLandingActivity.this);
                i = GlobalSendLandingActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                access$getVm.PlaceComponentResult(i);
            }
        });
    }

    public static final /* synthetic */ void access$toggleDanaLoadingDialogState(GlobalSendLandingActivity globalSendLandingActivity, boolean z) {
        if (!z) {
            ((DanaLogoLoadingDialog) globalSendLandingActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).PlaceComponentResult();
            return;
        }
        DanaLogoLoadingDialog danaLogoLoadingDialog = (DanaLogoLoadingDialog) globalSendLandingActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        if (danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.isShowing()) {
            return;
        }
        danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.show();
        danaLogoLoadingDialog.MyBillsEntityDataFactory.startRefresh();
    }

    public static final /* synthetic */ void access$toggleLoadingShimmerState(GlobalSendLandingActivity globalSendLandingActivity, boolean z) {
        if (z) {
            if (globalSendLandingActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                ShimmeringUtil shimmeringUtil = ShimmeringUtil.INSTANCE;
                globalSendLandingActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = ShimmeringUtil.getAuthRequestContext(globalSendLandingActivity.getBinding().KClassImpl$Data$declaredNonStaticMembers$2, R.layout.view_global_send_landing_skeleton);
            }
            SkeletonScreen skeletonScreen = globalSendLandingActivity.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (skeletonScreen != null) {
                skeletonScreen.MyBillsEntityDataFactory();
                return;
            }
            return;
        }
        SkeletonScreen skeletonScreen2 = globalSendLandingActivity.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (skeletonScreen2 != null) {
            skeletonScreen2.PlaceComponentResult();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        GlobalSendLandingActivity globalSendLandingActivity = this;
        GlobalSendBeneficiaryAdapter globalSendBeneficiaryAdapter = null;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(globalSendLandingActivity), null, null, new GlobalSendLandingActivity$initLifecycleActivity$1(this, null), 3, null);
        this.getErrorConfigVersion = new GlobalSendBeneficiaryAdapter(null, new MoreActionBeneficiaryListener() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$setupAdapter$1
            @Override // id.dana.sendmoney.ui.globalsend.landing.view.MoreActionBeneficiaryListener
            public final void BuiltInFictitiousFunctionClassFactory(BeneficiaryInfoModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                GlobalSendMoreActionBeneficiarySheet access$getGlobalMoreActionRecipientSheet = GlobalSendLandingActivity.access$getGlobalMoreActionRecipientSheet(GlobalSendLandingActivity.this);
                FragmentManager supportFragmentManager = GlobalSendLandingActivity.this.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                access$getGlobalMoreActionRecipientSheet.MyBillsEntityDataFactory(supportFragmentManager, p0);
            }
        }, new Function1<BeneficiaryInfoModel, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$setupAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(BeneficiaryInfoModel beneficiaryInfoModel) {
                invoke2(beneficiaryInfoModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BeneficiaryInfoModel beneficiaryInfoModel) {
                Intrinsics.checkNotNullParameter(beneficiaryInfoModel, "");
                GlobalSendLandingActivity.this.PlaceComponentResult = beneficiaryInfoModel;
                final GlobalSendLandingViewModel access$getVm = GlobalSendLandingActivity.access$getVm(GlobalSendLandingActivity.this);
                Intrinsics.checkNotNullParameter(beneficiaryInfoModel, "");
                access$getVm.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new ValidateRecurringTransaction.Param(BeneficiaryModelMapperKt.BuiltInFictitiousFunctionClassFactory(beneficiaryInfoModel)), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$validateRecurringTransaction$1
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
                        mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                        do {
                            value = mutableStateFlow.getValue();
                            GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GlobalSendLandingUiState.DanaLoading(true)));
                    }
                }, new Function1<TransferValidateResult, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$validateRecurringTransaction$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(TransferValidateResult transferValidateResult) {
                        invoke2(transferValidateResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(TransferValidateResult transferValidateResult) {
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        Intrinsics.checkNotNullParameter(transferValidateResult, "");
                        mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                        do {
                            value = mutableStateFlow.getValue();
                            GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GlobalSendLandingUiState.OnSuccessValidateRecurringTransaction(TransferValidateModelMapperKt.BuiltInFictitiousFunctionClassFactory(transferValidateResult))));
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$validateRecurringTransaction$3
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
                        GlobalSendLandingUiState error;
                        Intrinsics.checkNotNullParameter(th, "");
                        mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                        do {
                            value = mutableStateFlow.getValue();
                            GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                            if (th instanceof NetworkException) {
                                NetworkException networkException = (NetworkException) th;
                                String errorCode = networkException.getErrorCode();
                                if (errorCode == null) {
                                    errorCode = "";
                                }
                                String localizedMessage = networkException.getLocalizedMessage();
                                if (localizedMessage == null) {
                                    localizedMessage = "";
                                }
                                error = new GlobalSendLandingUiState.OnErrorCode(errorCode, localizedMessage);
                            } else {
                                error = new GlobalSendLandingUiState.Error(th.getMessage());
                            }
                        } while (!mutableStateFlow.compareAndSet(value, error));
                    }
                }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$validateRecurringTransaction$4
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
                        mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                        do {
                            value = mutableStateFlow.getValue();
                            GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new GlobalSendLandingUiState.DanaLoading(false)));
                    }
                }, ViewModelKt.PlaceComponentResult(access$getVm));
                GlobalSendLandingActivity.this.getGlobalSendTrackerHelper().BuiltInFictitiousFunctionClassFactory(false);
            }
        }, 1, null);
        RecyclerView recyclerView = getBinding().PlaceComponentResult.initRecordTimeStamp;
        GlobalSendBeneficiaryAdapter globalSendBeneficiaryAdapter2 = this.getErrorConfigVersion;
        if (globalSendBeneficiaryAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            globalSendBeneficiaryAdapter = globalSendBeneficiaryAdapter2;
        }
        recyclerView.setAdapter(globalSendBeneficiaryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        getBinding().PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GlobalSendLandingActivity.$r8$lambda$9FoWVWz4_x1nHi3dQfy2qUJs0Xs(GlobalSendLandingActivity.this, view);
            }
        });
        getBinding().PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GlobalSendLandingActivity.$r8$lambda$rRxkw_jvkUBqPLD1C_TcU4tQKTw(GlobalSendLandingActivity.this, view);
            }
        });
        BuiltInFictitiousFunctionClassFactory(this.DatabaseTableConfigUtil);
        getBinding().PlaceComponentResult.PlaceComponentResult.setOnCenterActionClickListener(new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$initViewListener$3
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
                GlobalSendLandingActivity.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        getBinding().PlaceComponentResult.GetContactSyncConfig.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GlobalSendLandingActivity.m2914$r8$lambda$9UuD5QIE_yYIyRqiXys0nI6EDM(GlobalSendLandingActivity.this, view);
            }
        });
        SearchView searchView = getBinding().PlaceComponentResult.newProxyInstance;
        String string = getString(R.string.text_hint_search);
        Intrinsics.checkNotNullExpressionValue(string, "");
        searchView.setEditTextHint(string);
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(searchView, "");
        DefaultSearchHelper defaultSearchHelper = new DefaultSearchHelper(this, searchView, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$initSearchViewHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                GlobalSendLandingActivity.this.getAuthRequestContext(str);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        }, new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity$initSearchViewHelper$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void invoke(boolean z) {
                ActivityGlobalSendLandingBinding binding;
                ActivityGlobalSendLandingBinding binding2;
                binding = GlobalSendLandingActivity.this.getBinding();
                TextView textView = binding.PlaceComponentResult.GetContactSyncConfig;
                Intrinsics.checkNotNullExpressionValue(textView, "");
                textView.setVisibility(z ? 0 : 8);
                binding2 = GlobalSendLandingActivity.this.getBinding();
                ConstraintLayout constraintLayout = binding2.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                constraintLayout.setVisibility(z ^ true ? 0 : 8);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        });
        defaultSearchHelper.PlaceComponentResult(LifecycleOwnerKt.PlaceComponentResult(globalSendLandingActivity));
        this.initRecordTimeStamp = defaultSearchHelper;
        final GlobalSendLandingViewModel globalSendLandingViewModel = (GlobalSendLandingViewModel) this.PrepareContext.getValue();
        BaseFlowUseCase.execute$default(globalSendLandingViewModel.getAuthRequestContext, NoParams.INSTANCE, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$getMaxBeneficiaryPageSize$1
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
                mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GlobalSendLandingUiState.ShimmerLoading(true)));
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$getMaxBeneficiaryPageSize$2
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
                mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GlobalSendLandingUiState.OnSuccessGetMaxBeneficiaryPageSize(i)));
            }
        }, null, null, ViewModelKt.PlaceComponentResult(globalSendLandingViewModel), 24, null);
        final GlobalSendLandingViewModel globalSendLandingViewModel2 = (GlobalSendLandingViewModel) this.PrepareContext.getValue();
        BaseFlowUseCase.execute$default(globalSendLandingViewModel2.BuiltInFictitiousFunctionClassFactory, NoParams.INSTANCE, null, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$getSortBeneficiaryList$1
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
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(str, "");
                mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GlobalSendLandingUiState.OnSuccessGetSort(str)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$getSortBeneficiaryList$2
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
                mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, GlobalSendLandingUiState.None.INSTANCE));
            }
        }, null, ViewModelKt.PlaceComponentResult(globalSendLandingViewModel2), 18, null);
        getGlobalSendTrackerHelper().BuiltInFictitiousFunctionClassFactory();
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (NetworkUserEntityData$$ExternalSyntheticLambda5[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ FragmentBottomSheetPaymentSettingBinding))) ^ c;
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

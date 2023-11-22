package id.dana.mybills.ui.v2.dashboard;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.FlowExtKt;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import androidx.view.NavController;
import androidx.view.NavDirections;
import androidx.view.NavOptions;
import androidx.view.ViewModelKt;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.android.material.card.MaterialCardView;
import com.google.common.base.Ascii;
import com.google.firebase.perf.metrics.Trace;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.analytics.executiontime.TrackerExecutionCounter;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.custom.tooltip.Tooltip;
import id.dana.core.ui.extension.StringExtKt;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.core.ui.util.ShimmeringUtil;
import id.dana.data.util.DateTimeUtil;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.user.CurrencyAmount;
import id.dana.mybills.R;
import id.dana.mybills.databinding.FragmentMyBillsDashboardBinding;
import id.dana.mybills.databinding.ItemBillPaymentViewBinding;
import id.dana.mybills.di.component.MyBillsComponent;
import id.dana.mybills.di.module.ViewModelFactory;
import id.dana.mybills.di.provider.MyBillsComponentProvider;
import id.dana.mybills.domain.model.MonthlyAmountAndHighlightRequest;
import id.dana.mybills.domain.model.MonthlyAmountWithConsultView;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;
import id.dana.mybills.ui.constant.RecurringType;
import id.dana.mybills.ui.mapper.MoneyModelMapperKt;
import id.dana.mybills.ui.model.BillPaymentStatusModel;
import id.dana.mybills.ui.model.MoneyViewModel;
import id.dana.mybills.ui.model.generalize.BillPaginationModel;
import id.dana.mybills.ui.v2.MyBillsHomeActivity;
import id.dana.mybills.ui.v2.MyBillsUiState;
import id.dana.mybills.ui.v2.MyBillsViewModel;
import id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragmentDirections;
import id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter;
import id.dana.network.util.DanaH5Helper;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.utils.formatter.TagFormat;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002KLB\u0007¢\u0006\u0004\bJ\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0006\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u001d\u0010\r\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0004\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u0019\u0010\u0014\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J!\u0010\u001a\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H\u0002¢\u0006\u0004\b \u0010\u0005J\u0017\u0010!\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000fH\u0002¢\u0006\u0004\b!\u0010\u0011J'\u0010!\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b!\u0010%J\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\r\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\u0010\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010)R\u0016\u0010\u0004\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010*R\u0013\u0010\u0006\u001a\u00020+X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010,R\u0013\u0010!\u001a\u00020-X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00100R\u0016\u0010\n\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00100R\u0013\u0010 \u001a\u00020+X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b3\u0010,R\u0012\u00105\u001a\u000204X\u0087\"¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010.\u001a\u0002078\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b8\u00109R\u0013\u00108\u001a\u00020+X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b:\u0010,R\u0013\u0010/\u001a\u00020+X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b;\u0010,R\u0012\u00101\u001a\u00020\u0007X\u0087\u0002¢\u0006\u0006\n\u0004\b!\u0010'R\u0013\u00103\u001a\u00020-X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b<\u0010,R\u0013\u00102\u001a\u00020-X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b=\u0010,R\u0013\u0010;\u001a\u00020-X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b>\u0010,R\u0013\u0010@\u001a\u00020-X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b?\u0010,R\u0014\u0010D\u001a\u00020A8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0012\u0010F\u001a\u00020EX\u0087\"¢\u0006\u0006\n\u0004\bF\u0010GR\u0013\u0010:\u001a\u00020HX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bI\u0010,"}, d2 = {"Lid/dana/mybills/ui/v2/dashboard/MyBillsDashboardFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/mybills/databinding/FragmentMyBillsDashboardBinding;", "", "PlaceComponentResult", "()V", "MyBillsEntityDataFactory", "", "p0", "(Ljava/lang/String;)Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "getAuthRequestContext", "(Ljava/util/List;)Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "lookAheadTest", "Landroid/os/Bundle;", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "onDestroyView", "Landroid/view/View;", "p1", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lid/dana/mybills/ui/v2/dashboard/MyBillsDashboardFragment$PaymentResultStatusEvent;", "event", "paymentResultStatusAction", "(Lid/dana/mybills/ui/v2/dashboard/MyBillsDashboardFragment$PaymentResultStatusEvent;)V", "scheduleImpl", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/core/widget/NestedScrollView;", "", "p2", "(Landroidx/core/widget/NestedScrollView;II)Z", "getErrorConfigVersion", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicLong;", "I", "Lid/dana/mybills/ui/v2/dashboard/adapter/BillsAdapter;", "Lkotlin/Lazy;", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "moveToNextValue", "DatabaseTableConfigUtil", "Z", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "myBillsAnalyticTracker", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "Lid/dana/mybills/di/component/MyBillsComponent;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/mybills/di/component/MyBillsComponent;", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda7", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/analytics/executiontime/TrackerExecutionCounter;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lid/dana/analytics/executiontime/TrackerExecutionCounter;", "PrepareContext", "Lid/dana/mybills/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/mybills/di/module/ViewModelFactory;", "Lid/dana/mybills/ui/v2/MyBillsViewModel;", "getSupportButtonTintMode", "<init>", "Companion", "PaymentResultStatusEvent"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MyBillsDashboardFragment extends BaseViewBindingFragment<FragmentMyBillsDashboardBinding> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy scheduleImpl;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    String initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private MyBillsComponent moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final Lazy GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private final TrackerExecutionCounter PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy DatabaseTableConfigUtil;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private final Lazy isLayoutRequested;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean lookAheadTest;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private int PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public MyBillsAnalyticTracker myBillsAnalyticTracker;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final AtomicLong BuiltInFictitiousFunctionClassFactory;
    @Inject
    public ViewModelFactory viewModelFactory;
    public static final byte[] $$a = {117, -10, 119, -11, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 18;
    public static final byte[] MyBillsEntityDataFactory = {68, -4, -93, 76, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int PlaceComponentResult = 18;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = 106 - r7
            int r8 = r8 * 15
            int r8 = 18 - r8
            int r6 = r6 * 2
            int r6 = 16 - r6
            byte[] r0 = id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment.MyBillsEntityDataFactory
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r8 = r8 + 1
            r3 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L33:
            int r7 = r7 + r8
            int r7 = r7 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment.a(byte, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0030  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0030 -> B:23:0x003a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 4
            int r7 = r7 + 4
            int r8 = r8 * 4
            int r8 = 75 - r8
            int r6 = r6 * 4
            int r6 = 42 - r6
            byte[] r0 = id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment.$$a
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1d
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L3a
        L1d:
            r3 = 0
            r5 = r8
            r8 = r7
        L20:
            r7 = r5
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L30
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L30:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L3a:
            int r8 = r8 + r6
            int r6 = r9 + 1
            int r8 = r8 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment.b(byte, short, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentMyBillsDashboardBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentMyBillsDashboardBinding PlaceComponentResult2 = FragmentMyBillsDashboardBinding.PlaceComponentResult(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        return PlaceComponentResult2;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.mybills.di.provider.MyBillsComponentProvider");
        }
        MyBillsComponent authRequestContext = ((MyBillsComponentProvider) applicationContext).provideMyBillsComponent().getAuthRequestContext();
        this.moveToNextValue = authRequestContext;
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this);
        StateFlow<MyBillsUiState> stateFlow = ((MyBillsViewModel) this.isLayoutRequested.getValue()).readMicros;
        Lifecycle lifecycle = getViewLifecycleOwner().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        Flow onEach = FlowKt.onEach(FlowKt.distinctUntilChanged(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle)), new MyBillsDashboardFragment$initLifecycle$1(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner2), null, null, new MyBillsDashboardFragment$observeUIState$1(this, null), 3, null);
        scheduleImpl();
        MyBillsEntityDataFactory();
        PlaceComponentResult();
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            AppCompatImageView appCompatImageView = ((FragmentMyBillsDashboardBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda5.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(0);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                AppCompatImageView appCompatImageView2 = ((FragmentMyBillsDashboardBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda5.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                appCompatImageView2.setVisibility(0);
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    ((FragmentMyBillsDashboardBinding) vb3).NetworkUserEntityData$$ExternalSyntheticLambda5.initRecordTimeStamp.setText(getString(R.string.my_bills_title));
                    VB vb4 = this.PlaceComponentResult;
                    if (vb4 != 0) {
                        ((FragmentMyBillsDashboardBinding) vb4).NetworkUserEntityData$$ExternalSyntheticLambda5.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                MyBillsDashboardFragment.PlaceComponentResult(MyBillsDashboardFragment.this);
                            }
                        });
                        MyBillsDashboardFragment myBillsDashboardFragment = this;
                        FragmentKt.PlaceComponentResult(myBillsDashboardFragment, RecordError.ERROR_INITIALIZE_NO_APP_ID, new Function2<String, Bundle, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$initListener$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
                                invoke2(str, bundle);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(String str, Bundle bundle) {
                                Intrinsics.checkNotNullParameter(str, "");
                                Intrinsics.checkNotNullParameter(bundle, "");
                                if (bundle.getBoolean("isSaveBill", false)) {
                                    MyBillsDashboardFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment.this, bundle.getBoolean("isAutoDeduction"));
                                }
                            }
                        });
                        FragmentKt.PlaceComponentResult(myBillsDashboardFragment, RecordError.ERROR_INITIALIZE_NO_WORKSPACE_ID, new Function2<String, Bundle, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$initListener$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
                                invoke2(str, bundle);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(String str, Bundle bundle) {
                                Intrinsics.checkNotNullParameter(str, "");
                                Intrinsics.checkNotNullParameter(bundle, "");
                                if (bundle.getBoolean("need_refresh", false)) {
                                    MyBillsDashboardFragment.NetworkUserEntityData$$ExternalSyntheticLambda5(MyBillsDashboardFragment.this);
                                }
                            }
                        });
                        VB vb5 = this.PlaceComponentResult;
                        if (vb5 != 0) {
                            ((FragmentMyBillsDashboardBinding) vb5).PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$$ExternalSyntheticLambda3
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    MyBillsDashboardFragment.BuiltInFictitiousFunctionClassFactory(MyBillsDashboardFragment.this);
                                }
                            });
                            VB vb6 = this.PlaceComponentResult;
                            if (vb6 != 0) {
                                ((FragmentMyBillsDashboardBinding) vb6).NetworkUserEntityData$$ExternalSyntheticLambda5.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$$ExternalSyntheticLambda4
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        MyBillsDashboardFragment.MyBillsEntityDataFactory(MyBillsDashboardFragment.this);
                                    }
                                });
                                VB vb7 = this.PlaceComponentResult;
                                if (vb7 != 0) {
                                    ((FragmentMyBillsDashboardBinding) vb7).VerifyPinStateManager$executeRiskChallenge$2$1.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$$ExternalSyntheticLambda5
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            MyBillsDashboardFragment.getAuthRequestContext(MyBillsDashboardFragment.this);
                                        }
                                    });
                                    VB vb8 = this.PlaceComponentResult;
                                    if (vb8 != 0) {
                                        ((FragmentMyBillsDashboardBinding) vb8).initRecordTimeStamp.setButtonPayOnClick(new Function0<Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$initListener$6
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
                                                if ((!MyBillsDashboardFragment.GetContactSyncConfig(MyBillsDashboardFragment.this).moveToNextValue.getValue().isEmpty()) == true) {
                                                    MyBillsAnalyticTracker myBillsAnalyticTracker = MyBillsDashboardFragment.this.myBillsAnalyticTracker;
                                                    if (myBillsAnalyticTracker == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("");
                                                        myBillsAnalyticTracker = null;
                                                    }
                                                    myBillsAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsPurposeAction.BULK_PAY);
                                                    MyBillsDashboardFragmentDirections.Companion companion = MyBillsDashboardFragmentDirections.INSTANCE;
                                                    Object[] array = MyBillsDashboardFragment.GetContactSyncConfig(MyBillsDashboardFragment.this).moveToNextValue.getValue().toArray(new BillPaymentStatusModel[0]);
                                                    if (array != null) {
                                                        NavDirections authRequestContext2 = MyBillsDashboardFragmentDirections.Companion.getAuthRequestContext((BillPaymentStatusModel[]) array);
                                                        NavController authRequestContext3 = androidx.view.fragment.FragmentKt.getAuthRequestContext(MyBillsDashboardFragment.this);
                                                        Intrinsics.checkNotNullParameter(authRequestContext2, "");
                                                        authRequestContext3.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext2.getKClassImpl$Data$declaredNonStaticMembers$2(), authRequestContext2.getKClassImpl$Data$declaredNonStaticMembers$2(), (NavOptions) null);
                                                        return;
                                                    }
                                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                }
                                            }
                                        });
                                        VB vb9 = this.PlaceComponentResult;
                                        if (vb9 != 0) {
                                            ((FragmentMyBillsDashboardBinding) vb9).initRecordTimeStamp.setButtonTopUpOnClick(new Function0<Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$initListener$7
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
                                                    MyBillsDashboardFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(MyBillsDashboardFragment.this);
                                                }
                                            });
                                            VB vb10 = this.PlaceComponentResult;
                                            if (vb10 != 0) {
                                                ((FragmentMyBillsDashboardBinding) vb10).MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$$ExternalSyntheticLambda6
                                                    @Override // android.view.View.OnClickListener
                                                    public final void onClick(View view) {
                                                        MyBillsDashboardFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment.this);
                                                    }
                                                });
                                                VB vb11 = this.PlaceComponentResult;
                                                if (vb11 != 0) {
                                                    ((FragmentMyBillsDashboardBinding) vb11).BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$$ExternalSyntheticLambda7
                                                        @Override // android.view.View.OnClickListener
                                                        public final void onClick(View view) {
                                                            MyBillsDashboardFragment.scheduleImpl(MyBillsDashboardFragment.this);
                                                        }
                                                    });
                                                    VB vb12 = this.PlaceComponentResult;
                                                    if (vb12 != 0) {
                                                        ((FragmentMyBillsDashboardBinding) vb12).getErrorConfigVersion.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$$ExternalSyntheticLambda8
                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                MyBillsDashboardFragment.moveToNextValue(MyBillsDashboardFragment.this);
                                                            }
                                                        });
                                                        VB vb13 = this.PlaceComponentResult;
                                                        if (vb13 != 0) {
                                                            ItemBillPaymentViewBinding itemBillPaymentViewBinding = ((FragmentMyBillsDashboardBinding) vb13).NetworkUserEntityData$$ExternalSyntheticLambda8;
                                                            PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                                                            itemBillPaymentViewBinding.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$$ExternalSyntheticLambda2
                                                                @Override // android.view.View.OnClickListener
                                                                public final void onClick(View view) {
                                                                    MyBillsDashboardFragment.getErrorConfigVersion(MyBillsDashboardFragment.this);
                                                                }
                                                            });
                                                            VB vb14 = this.PlaceComponentResult;
                                                            if (vb14 != 0) {
                                                                ItemBillPaymentViewBinding itemBillPaymentViewBinding2 = ((FragmentMyBillsDashboardBinding) vb14).newProxyInstance;
                                                                BuiltInFictitiousFunctionClassFactory(this.lookAheadTest);
                                                                itemBillPaymentViewBinding2.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$$ExternalSyntheticLambda1
                                                                    @Override // android.view.View.OnClickListener
                                                                    public final void onClick(View view) {
                                                                        MyBillsDashboardFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(MyBillsDashboardFragment.this);
                                                                    }
                                                                });
                                                                VB vb15 = this.PlaceComponentResult;
                                                                if (vb15 != 0) {
                                                                    RecyclerView recyclerView = ((FragmentMyBillsDashboardBinding) vb15).NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2;
                                                                    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                                                                    recyclerView.setAdapter((BillsAdapter) this.DatabaseTableConfigUtil.getValue());
                                                                    VB vb16 = this.PlaceComponentResult;
                                                                    if (vb16 != 0) {
                                                                        RecyclerView recyclerView2 = ((FragmentMyBillsDashboardBinding) vb16).GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2;
                                                                        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
                                                                        recyclerView2.setAdapter((BillsAdapter) this.MyBillsEntityDataFactory.getValue());
                                                                        VB vb17 = this.PlaceComponentResult;
                                                                        if (vb17 != 0) {
                                                                            RecyclerView recyclerView3 = ((FragmentMyBillsDashboardBinding) vb17).isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2;
                                                                            recyclerView3.setLayoutManager(new LinearLayoutManager(recyclerView3.getContext()));
                                                                            recyclerView3.setAdapter((BillsAdapter) this.scheduleImpl.getValue());
                                                                            VB vb18 = this.PlaceComponentResult;
                                                                            if (vb18 != 0) {
                                                                                RecyclerView recyclerView4 = ((FragmentMyBillsDashboardBinding) vb18).newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2;
                                                                                recyclerView4.setLayoutManager(new LinearLayoutManager(recyclerView4.getContext()));
                                                                                recyclerView4.setAdapter((BillsAdapter) this.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue());
                                                                                VB vb19 = this.PlaceComponentResult;
                                                                                if (vb19 != 0) {
                                                                                    ((FragmentMyBillsDashboardBinding) vb19).PrepareContext.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$$ExternalSyntheticLambda9
                                                                                        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                                                                                        public final void getAuthRequestContext(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                                                                                            MyBillsDashboardFragment.BuiltInFictitiousFunctionClassFactory(MyBillsDashboardFragment.this, nestedScrollView, i2, i4);
                                                                                        }
                                                                                    });
                                                                                    this.PrepareContext.initiateStartTime();
                                                                                    return;
                                                                                }
                                                                                throw new IllegalArgumentException("Required value was null.".toString());
                                                                            }
                                                                            throw new IllegalArgumentException("Required value was null.".toString());
                                                                        }
                                                                        throw new IllegalArgumentException("Required value was null.".toString());
                                                                    }
                                                                    throw new IllegalArgumentException("Required value was null.".toString());
                                                                }
                                                                throw new IllegalArgumentException("Required value was null.".toString());
                                                            }
                                                            throw new IllegalArgumentException("Required value was null.".toString());
                                                        }
                                                        throw new IllegalArgumentException("Required value was null.".toString());
                                                    }
                                                    throw new IllegalArgumentException("Required value was null.".toString());
                                                }
                                                throw new IllegalArgumentException("Required value was null.".toString());
                                            }
                                            throw new IllegalArgumentException("Required value was null.".toString());
                                        }
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void PlaceComponentResult() {
        FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2("mybills_qos_performances_header");
        final MyBillsViewModel myBillsViewModel = (MyBillsViewModel) this.isLayoutRequested.getValue();
        MonthlyAmountAndHighlightRequest monthlyAmountAndHighlightRequest = new MonthlyAmountAndHighlightRequest(null, null, null, null, null, true, 0, 10, null, 351, null);
        Intrinsics.checkNotNullParameter(monthlyAmountAndHighlightRequest, "");
        MutableStateFlow<MyBillsUiState> mutableStateFlow = myBillsViewModel.BuiltInFictitiousFunctionClassFactory;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), MyBillsUiState.Loading.INSTANCE));
        BaseFlowUseCase.execute$default(myBillsViewModel.NetworkUserEntityData$$ExternalSyntheticLambda8, monthlyAmountAndHighlightRequest, null, new Function1<MonthlyAmountWithConsultView, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$getMonthlyWithConsult$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MonthlyAmountWithConsultView monthlyAmountWithConsultView) {
                invoke2(monthlyAmountWithConsultView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MonthlyAmountWithConsultView monthlyAmountWithConsultView) {
                MutableStateFlow mutableStateFlow2;
                Object value;
                MutableStateFlow mutableStateFlow3;
                Object value2;
                Intrinsics.checkNotNullParameter(monthlyAmountWithConsultView, "");
                mutableStateFlow2 = MyBillsViewModel.this.BuiltInFictitiousFunctionClassFactory;
                do {
                    value = mutableStateFlow2.getValue();
                    MyBillsUiState myBillsUiState = (MyBillsUiState) value;
                } while (!mutableStateFlow2.compareAndSet(value, new MyBillsUiState.Success(monthlyAmountWithConsultView)));
                mutableStateFlow3 = MyBillsViewModel.this.scheduleImpl;
                do {
                    value2 = mutableStateFlow3.getValue();
                    MyBillsUiState myBillsUiState2 = (MyBillsUiState) value2;
                } while (!mutableStateFlow3.compareAndSet(value2, MyBillsUiState.None.INSTANCE));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$getMonthlyWithConsult$3
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
                MutableStateFlow mutableStateFlow2;
                Object value;
                String message;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow2 = MyBillsViewModel.this.BuiltInFictitiousFunctionClassFactory;
                do {
                    value = mutableStateFlow2.getValue();
                    MyBillsUiState myBillsUiState = (MyBillsUiState) value;
                    message = th.getMessage();
                    if (message == null) {
                        message = "";
                    }
                } while (!mutableStateFlow2.compareAndSet(value, new MyBillsUiState.Error(message, th)));
            }
        }, null, ViewModelKt.PlaceComponentResult(myBillsViewModel), 18, null);
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2("mybills_qos_performances_next_month");
        ((MyBillsViewModel) this.isLayoutRequested.getValue()).MyBillsEntityDataFactory(new MonthlyAmountAndHighlightRequest(null, null, null, null, null, true, ((MyBillsViewModel) this.isLayoutRequested.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda7.getPageNum(), 10, "NEXT_MONTH", 31, null));
    }

    private static String getAuthRequestContext(List<BillPaymentStatusModel> p0) {
        String PlaceComponentResult2;
        String amount;
        Iterator<T> it = p0.iterator();
        long j = 0;
        while (it.hasNext()) {
            MoneyViewModel totalAmount = ((BillPaymentStatusModel) it.next()).getTotalAmount();
            j += (totalAmount == null || (amount = totalAmount.getAmount()) == null) ? 0L : StringExtKt.BuiltInFictitiousFunctionClassFactory(amount);
        }
        PlaceComponentResult2 = StringExtKt.PlaceComponentResult(String.valueOf(j), "Rp", "0");
        return PlaceComponentResult2;
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2(NestedScrollView p0, int p1, int p2) {
        if (p1 > p2) {
            int bottom = p0.getChildAt(0).getBottom();
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                return bottom <= ((FragmentMyBillsDashboardBinding) vb).PrepareContext.getHeight() + p1;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        return false;
    }

    private static String MyBillsEntityDataFactory(String p0) {
        TagFormat.Companion companion = TagFormat.INSTANCE;
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(p0);
        return TagFormat.Companion.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString()).MyBillsEntityDataFactory("entryPoint", TopupSource.MY_BILLS).PlaceComponentResult();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        Intent intent;
        try {
            byte b = (byte) (MyBillsEntityDataFactory[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (MyBillsEntityDataFactory[5] + 1);
            byte b4 = (byte) (-MyBillsEntityDataFactory[5]);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 4 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) View.combineMeasuredStates(0, 0));
                    byte b5 = (byte) ($$a[35] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, b6, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, View.MeasureSpec.getMode(0) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-549586092, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, AndroidCharacter.getMirror('0') - 30, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
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
                super.onCreate(p0);
                if (!EventBus.getDefault().isRegistered(this)) {
                    EventBus.getDefault().register(this);
                }
                FragmentActivity activity = getActivity();
                if (activity == null || (intent = activity.getIntent()) == null || !intent.hasExtra(MyBillsHomeActivity.MY_BILLS_SUBSCRIPTION_LIST_OPEN_TRACKER_SOURCE)) {
                    return;
                }
                String stringExtra = intent.getStringExtra(MyBillsHomeActivity.MY_BILLS_SUBSCRIPTION_LIST_OPEN_TRACKER_SOURCE);
                this.initRecordTimeStamp = stringExtra != null ? stringExtra : "";
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

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((MyBillsViewModel) this.isLayoutRequested.getValue()).MyBillsEntityDataFactory();
        this.PrepareContext.initiateEndTime();
    }

    private final void getAuthRequestContext(boolean p0) {
        if (this.getErrorConfigVersion) {
            this.PlaceComponentResult++;
            this.PrepareContext.initiateEndTime();
            if (this.PlaceComponentResult == 4 || p0) {
                int placeComponentResult = ((BillsAdapter) this.MyBillsEntityDataFactory.getValue()).getPlaceComponentResult();
                int placeComponentResult2 = ((BillsAdapter) this.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue()).getPlaceComponentResult();
                int placeComponentResult3 = ((BillsAdapter) this.scheduleImpl.getValue()).getPlaceComponentResult();
                int placeComponentResult4 = ((BillsAdapter) this.DatabaseTableConfigUtil.getValue()).getPlaceComponentResult();
                MyBillsAnalyticTracker myBillsAnalyticTracker = this.myBillsAnalyticTracker;
                if (myBillsAnalyticTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    myBillsAnalyticTracker = null;
                }
                myBillsAnalyticTracker.MyBillsEntityDataFactory(this.initRecordTimeStamp, "Success", this.PrepareContext.getExecutionTime(), placeComponentResult + placeComponentResult2 + placeComponentResult3 + placeComponentResult4);
                this.getErrorConfigVersion = false;
            }
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        super.lookAheadTest();
        requireActivity().finish();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/v2/dashboard/MyBillsDashboardFragment$PaymentResultStatusEvent;", "", "", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class PaymentResultStatusEvent {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        public PaymentResultStatusEvent(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.MyBillsEntityDataFactory = str;
        }
    }

    public MyBillsDashboardFragment() {
        final MyBillsDashboardFragment myBillsDashboardFragment = this;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = MyBillsDashboardFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) Function0.this.invoke();
            }
        });
        final Function0 function03 = null;
        this.isLayoutRequested = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(myBillsDashboardFragment, Reflection.getOrCreateKotlinClass(MyBillsViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = FragmentViewModelLazyKt.PlaceComponentResult(Lazy.this).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = Function0.this;
                if (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) {
                    ViewModelStoreOwner PlaceComponentResult2 = FragmentViewModelLazyKt.PlaceComponentResult(lazy);
                    HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = PlaceComponentResult2 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) PlaceComponentResult2 : null;
                    CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                    return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, function0);
        this.BuiltInFictitiousFunctionClassFactory = new AtomicLong(0L);
        this.PrepareContext = new TrackerExecutionCounter();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<ViewSkeletonScreen>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$headerSkeletons$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewSkeletonScreen invoke() {
                ShimmeringUtil shimmeringUtil = ShimmeringUtil.INSTANCE;
                VB vb = MyBillsDashboardFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    return ShimmeringUtil.getAuthRequestContext(((FragmentMyBillsDashboardBinding) vb).whenAvailable, R.layout.view_item_skeleton);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = LazyKt.lazy(new Function0<ViewSkeletonScreen>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$sectionPastDueSkeletons$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewSkeletonScreen invoke() {
                ShimmeringUtil shimmeringUtil = ShimmeringUtil.INSTANCE;
                VB vb = MyBillsDashboardFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    return ShimmeringUtil.getAuthRequestContext(((FragmentMyBillsDashboardBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda8.NetworkUserEntityData$$ExternalSyntheticLambda0, R.layout.view_item_skeleton);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        });
        this.GetContactSyncConfig = LazyKt.lazy(new Function0<ViewSkeletonScreen>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$sectionDueSoonSkeletons$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewSkeletonScreen invoke() {
                ShimmeringUtil shimmeringUtil = ShimmeringUtil.INSTANCE;
                VB vb = MyBillsDashboardFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    return ShimmeringUtil.getAuthRequestContext(((FragmentMyBillsDashboardBinding) vb).GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda0, R.layout.view_item_skeleton);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = LazyKt.lazy(new Function0<ViewSkeletonScreen>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$sectionLaterThisMonthSkeletons$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewSkeletonScreen invoke() {
                ShimmeringUtil shimmeringUtil = ShimmeringUtil.INSTANCE;
                VB vb = MyBillsDashboardFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    return ShimmeringUtil.getAuthRequestContext(((FragmentMyBillsDashboardBinding) vb).isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda0, R.layout.view_item_skeleton);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = LazyKt.lazy(new Function0<ViewSkeletonScreen>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$sectionNextMonthSkeletons$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewSkeletonScreen invoke() {
                ShimmeringUtil shimmeringUtil = ShimmeringUtil.INSTANCE;
                VB vb = MyBillsDashboardFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    return ShimmeringUtil.getAuthRequestContext(((FragmentMyBillsDashboardBinding) vb).newProxyInstance.NetworkUserEntityData$$ExternalSyntheticLambda0, R.layout.view_item_skeleton);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        });
        this.getAuthRequestContext = "";
        this.DatabaseTableConfigUtil = LazyKt.lazy(new Function0<BillsAdapter>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$pastDueSectionAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BillsAdapter invoke() {
                final MyBillsDashboardFragment myBillsDashboardFragment2 = MyBillsDashboardFragment.this;
                Function2<View, BillPaymentStatusModel, Unit> function2 = new Function2<View, BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$pastDueSectionAdapter$2.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final /* bridge */ /* synthetic */ Unit invoke(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        invoke2(view, billPaymentStatusModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        Intrinsics.checkNotNullParameter(view, "");
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.getAuthRequestContext(MyBillsDashboardFragment.this, view, billPaymentStatusModel);
                    }
                };
                final MyBillsDashboardFragment myBillsDashboardFragment3 = MyBillsDashboardFragment.this;
                Function2<View, BillPaymentStatusModel, Unit> function22 = new Function2<View, BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$pastDueSectionAdapter$2.2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final /* bridge */ /* synthetic */ Unit invoke(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        invoke2(view, billPaymentStatusModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        Intrinsics.checkNotNullParameter(view, "");
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment.this, view, billPaymentStatusModel);
                    }
                };
                final MyBillsDashboardFragment myBillsDashboardFragment4 = MyBillsDashboardFragment.this;
                Function2<BillPaymentStatusModel, Boolean, Unit> function23 = new Function2<BillPaymentStatusModel, Boolean, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$pastDueSectionAdapter$2.3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final /* synthetic */ Unit invoke(BillPaymentStatusModel billPaymentStatusModel, Boolean bool) {
                        invoke(billPaymentStatusModel, bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BillPaymentStatusModel billPaymentStatusModel, boolean z) {
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.GetContactSyncConfig(MyBillsDashboardFragment.this).getAuthRequestContext(CollectionsKt.listOf(billPaymentStatusModel), z);
                    }
                };
                final MyBillsDashboardFragment myBillsDashboardFragment5 = MyBillsDashboardFragment.this;
                return new BillsAdapter(function2, function22, function23, new Function1<BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$pastDueSectionAdapter$2.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(BillPaymentStatusModel billPaymentStatusModel) {
                        invoke2(billPaymentStatusModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(BillPaymentStatusModel billPaymentStatusModel) {
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment.this, billPaymentStatusModel);
                    }
                });
            }
        });
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<BillsAdapter>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$dueSoonSectionAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BillsAdapter invoke() {
                final MyBillsDashboardFragment myBillsDashboardFragment2 = MyBillsDashboardFragment.this;
                Function2<View, BillPaymentStatusModel, Unit> function2 = new Function2<View, BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$dueSoonSectionAdapter$2.1
                    {
                        super(2);
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        Intrinsics.checkNotNullParameter(view, "");
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.getAuthRequestContext(MyBillsDashboardFragment.this, view, billPaymentStatusModel);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final /* bridge */ /* synthetic */ Unit invoke(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        invoke2(view, billPaymentStatusModel);
                        return Unit.INSTANCE;
                    }
                };
                final MyBillsDashboardFragment myBillsDashboardFragment3 = MyBillsDashboardFragment.this;
                Function2<View, BillPaymentStatusModel, Unit> function22 = new Function2<View, BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$dueSoonSectionAdapter$2.2
                    {
                        super(2);
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        Intrinsics.checkNotNullParameter(view, "");
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment.this, view, billPaymentStatusModel);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final /* bridge */ /* synthetic */ Unit invoke(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        invoke2(view, billPaymentStatusModel);
                        return Unit.INSTANCE;
                    }
                };
                final MyBillsDashboardFragment myBillsDashboardFragment4 = MyBillsDashboardFragment.this;
                Function2<BillPaymentStatusModel, Boolean, Unit> function23 = new Function2<BillPaymentStatusModel, Boolean, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$dueSoonSectionAdapter$2.3
                    {
                        super(2);
                    }

                    public final void invoke(BillPaymentStatusModel billPaymentStatusModel, boolean z) {
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.GetContactSyncConfig(MyBillsDashboardFragment.this).getAuthRequestContext(CollectionsKt.listOf(billPaymentStatusModel), z);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final /* synthetic */ Unit invoke(BillPaymentStatusModel billPaymentStatusModel, Boolean bool) {
                        invoke(billPaymentStatusModel, bool.booleanValue());
                        return Unit.INSTANCE;
                    }
                };
                final MyBillsDashboardFragment myBillsDashboardFragment5 = MyBillsDashboardFragment.this;
                BillsAdapter billsAdapter = new BillsAdapter(function2, function22, function23, new Function1<BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$dueSoonSectionAdapter$2.4
                    {
                        super(1);
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(BillPaymentStatusModel billPaymentStatusModel) {
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment.this, billPaymentStatusModel);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(BillPaymentStatusModel billPaymentStatusModel) {
                        invoke2(billPaymentStatusModel);
                        return Unit.INSTANCE;
                    }
                });
                BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(billsAdapter, MyBillsDashboardFragment.BuiltInFictitiousFunctionClassFactory());
                return billsAdapter;
            }
        });
        this.scheduleImpl = LazyKt.lazy(new Function0<BillsAdapter>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$monthLaterSectionAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BillsAdapter invoke() {
                final MyBillsDashboardFragment myBillsDashboardFragment2 = MyBillsDashboardFragment.this;
                Function2<View, BillPaymentStatusModel, Unit> function2 = new Function2<View, BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$monthLaterSectionAdapter$2.1
                    {
                        super(2);
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        Intrinsics.checkNotNullParameter(view, "");
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.getAuthRequestContext(MyBillsDashboardFragment.this, view, billPaymentStatusModel);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final /* bridge */ /* synthetic */ Unit invoke(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        invoke2(view, billPaymentStatusModel);
                        return Unit.INSTANCE;
                    }
                };
                final MyBillsDashboardFragment myBillsDashboardFragment3 = MyBillsDashboardFragment.this;
                Function2<View, BillPaymentStatusModel, Unit> function22 = new Function2<View, BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$monthLaterSectionAdapter$2.2
                    {
                        super(2);
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        Intrinsics.checkNotNullParameter(view, "");
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment.this, view, billPaymentStatusModel);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final /* bridge */ /* synthetic */ Unit invoke(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        invoke2(view, billPaymentStatusModel);
                        return Unit.INSTANCE;
                    }
                };
                final MyBillsDashboardFragment myBillsDashboardFragment4 = MyBillsDashboardFragment.this;
                Function2<BillPaymentStatusModel, Boolean, Unit> function23 = new Function2<BillPaymentStatusModel, Boolean, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$monthLaterSectionAdapter$2.3
                    {
                        super(2);
                    }

                    public final void invoke(BillPaymentStatusModel billPaymentStatusModel, boolean z) {
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.GetContactSyncConfig(MyBillsDashboardFragment.this).getAuthRequestContext(CollectionsKt.listOf(billPaymentStatusModel), z);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final /* synthetic */ Unit invoke(BillPaymentStatusModel billPaymentStatusModel, Boolean bool) {
                        invoke(billPaymentStatusModel, bool.booleanValue());
                        return Unit.INSTANCE;
                    }
                };
                final MyBillsDashboardFragment myBillsDashboardFragment5 = MyBillsDashboardFragment.this;
                BillsAdapter billsAdapter = new BillsAdapter(function2, function22, function23, new Function1<BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$monthLaterSectionAdapter$2.4
                    {
                        super(1);
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(BillPaymentStatusModel billPaymentStatusModel) {
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment.this, billPaymentStatusModel);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(BillPaymentStatusModel billPaymentStatusModel) {
                        invoke2(billPaymentStatusModel);
                        return Unit.INSTANCE;
                    }
                });
                BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(billsAdapter, MyBillsDashboardFragment.BuiltInFictitiousFunctionClassFactory());
                return billsAdapter;
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = LazyKt.lazy(new Function0<BillsAdapter>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$nextMonthSectionAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BillsAdapter invoke() {
                final MyBillsDashboardFragment myBillsDashboardFragment2 = MyBillsDashboardFragment.this;
                Function2<View, BillPaymentStatusModel, Unit> function2 = new Function2<View, BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$nextMonthSectionAdapter$2.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final /* bridge */ /* synthetic */ Unit invoke(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        invoke2(view, billPaymentStatusModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        Intrinsics.checkNotNullParameter(view, "");
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.getAuthRequestContext(MyBillsDashboardFragment.this, view, billPaymentStatusModel);
                    }
                };
                final MyBillsDashboardFragment myBillsDashboardFragment3 = MyBillsDashboardFragment.this;
                Function2<View, BillPaymentStatusModel, Unit> function22 = new Function2<View, BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$nextMonthSectionAdapter$2.2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final /* bridge */ /* synthetic */ Unit invoke(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        invoke2(view, billPaymentStatusModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view, BillPaymentStatusModel billPaymentStatusModel) {
                        Intrinsics.checkNotNullParameter(view, "");
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment.this, view, billPaymentStatusModel);
                    }
                };
                final MyBillsDashboardFragment myBillsDashboardFragment4 = MyBillsDashboardFragment.this;
                Function2<BillPaymentStatusModel, Boolean, Unit> function23 = new Function2<BillPaymentStatusModel, Boolean, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$nextMonthSectionAdapter$2.3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final /* synthetic */ Unit invoke(BillPaymentStatusModel billPaymentStatusModel, Boolean bool) {
                        invoke(billPaymentStatusModel, bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BillPaymentStatusModel billPaymentStatusModel, boolean z) {
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.GetContactSyncConfig(MyBillsDashboardFragment.this).getAuthRequestContext(CollectionsKt.listOf(billPaymentStatusModel), z);
                    }
                };
                final MyBillsDashboardFragment myBillsDashboardFragment5 = MyBillsDashboardFragment.this;
                return new BillsAdapter(function2, function22, function23, new Function1<BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$nextMonthSectionAdapter$2.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(BillPaymentStatusModel billPaymentStatusModel) {
                        invoke2(billPaymentStatusModel);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(BillPaymentStatusModel billPaymentStatusModel) {
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        MyBillsDashboardFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment.this, billPaymentStatusModel);
                    }
                });
            }
        });
        this.getErrorConfigVersion = true;
        this.initRecordTimeStamp = "";
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment myBillsDashboardFragment) {
        Intrinsics.checkNotNullParameter(myBillsDashboardFragment, "");
        MyBillsAnalyticTracker myBillsAnalyticTracker = myBillsDashboardFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        myBillsAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsPurposeAction.ADD_NEW_RECOMENDED_BILLS);
    }

    public static /* synthetic */ void PlaceComponentResult(MyBillsDashboardFragment myBillsDashboardFragment) {
        Intrinsics.checkNotNullParameter(myBillsDashboardFragment, "");
        MyBillsAnalyticTracker myBillsAnalyticTracker = myBillsDashboardFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        myBillsAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsPurposeAction.MANAGE_BILLS);
        NavController authRequestContext = androidx.view.fragment.FragmentKt.getAuthRequestContext(myBillsDashboardFragment);
        MyBillsDashboardFragmentDirections.Companion companion = MyBillsDashboardFragmentDirections.INSTANCE;
        NavDirections PlaceComponentResult2 = MyBillsDashboardFragmentDirections.Companion.PlaceComponentResult();
        Intrinsics.checkNotNullParameter(PlaceComponentResult2, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.getKClassImpl$Data$declaredNonStaticMembers$2(), PlaceComponentResult2.getKClassImpl$Data$declaredNonStaticMembers$2(), (NavOptions) null);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(MyBillsDashboardFragment myBillsDashboardFragment) {
        Intrinsics.checkNotNullParameter(myBillsDashboardFragment, "");
        myBillsDashboardFragment.requireActivity().finish();
    }

    public static /* synthetic */ void getAuthRequestContext(MyBillsDashboardFragment myBillsDashboardFragment) {
        Intrinsics.checkNotNullParameter(myBillsDashboardFragment, "");
        myBillsDashboardFragment.scheduleImpl();
        myBillsDashboardFragment.MyBillsEntityDataFactory();
        myBillsDashboardFragment.PlaceComponentResult();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MyBillsDashboardFragment myBillsDashboardFragment) {
        Intrinsics.checkNotNullParameter(myBillsDashboardFragment, "");
        MyBillsAnalyticTracker myBillsAnalyticTracker = myBillsDashboardFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        myBillsAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsPurposeAction.ADD_NEW_BILLS);
        NavController authRequestContext = androidx.view.fragment.FragmentKt.getAuthRequestContext(myBillsDashboardFragment);
        MyBillsDashboardFragmentDirections.Companion companion = MyBillsDashboardFragmentDirections.INSTANCE;
        NavDirections BuiltInFictitiousFunctionClassFactory = MyBillsDashboardFragmentDirections.Companion.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getKClassImpl$Data$declaredNonStaticMembers$2(), BuiltInFictitiousFunctionClassFactory.getKClassImpl$Data$declaredNonStaticMembers$2(), (NavOptions) null);
    }

    public static /* synthetic */ void getErrorConfigVersion(MyBillsDashboardFragment myBillsDashboardFragment) {
        Intrinsics.checkNotNullParameter(myBillsDashboardFragment, "");
        boolean z = !myBillsDashboardFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
        myBillsDashboardFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
        myBillsDashboardFragment.PlaceComponentResult(z);
    }

    public static /* synthetic */ void moveToNextValue(MyBillsDashboardFragment myBillsDashboardFragment) {
        Intrinsics.checkNotNullParameter(myBillsDashboardFragment, "");
        NavController authRequestContext = androidx.view.fragment.FragmentKt.getAuthRequestContext(myBillsDashboardFragment);
        MyBillsDashboardFragmentDirections.Companion companion = MyBillsDashboardFragmentDirections.INSTANCE;
        NavDirections MyBillsEntityDataFactory2 = MyBillsDashboardFragmentDirections.Companion.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory2, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.getKClassImpl$Data$declaredNonStaticMembers$2(), MyBillsEntityDataFactory2.getKClassImpl$Data$declaredNonStaticMembers$2(), (NavOptions) null);
    }

    public static /* synthetic */ void scheduleImpl(MyBillsDashboardFragment myBillsDashboardFragment) {
        Intrinsics.checkNotNullParameter(myBillsDashboardFragment, "");
        NavController authRequestContext = androidx.view.fragment.FragmentKt.getAuthRequestContext(myBillsDashboardFragment);
        MyBillsDashboardFragmentDirections.Companion companion = MyBillsDashboardFragmentDirections.INSTANCE;
        NavDirections authRequestContext2 = MyBillsDashboardFragmentDirections.Companion.getAuthRequestContext();
        Intrinsics.checkNotNullParameter(authRequestContext2, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext2.getKClassImpl$Data$declaredNonStaticMembers$2(), authRequestContext2.getKClassImpl$Data$declaredNonStaticMembers$2(), (NavOptions) null);
    }

    public static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(MyBillsDashboardFragment myBillsDashboardFragment) {
        Intrinsics.checkNotNullParameter(myBillsDashboardFragment, "");
        boolean z = !myBillsDashboardFragment.lookAheadTest;
        myBillsDashboardFragment.lookAheadTest = z;
        myBillsDashboardFragment.BuiltInFictitiousFunctionClassFactory(z);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MyBillsDashboardFragment myBillsDashboardFragment, NestedScrollView nestedScrollView, int i, int i2) {
        Intrinsics.checkNotNullParameter(myBillsDashboardFragment, "");
        Intrinsics.checkNotNullParameter(nestedScrollView, "");
        if (myBillsDashboardFragment.KClassImpl$Data$declaredNonStaticMembers$2(nestedScrollView, i, i2)) {
            MyBillsViewModel myBillsViewModel = (MyBillsViewModel) myBillsDashboardFragment.isLayoutRequested.getValue();
            if (myBillsViewModel.getErrorConfigVersion.getHasMore() && !myBillsViewModel.getErrorConfigVersion.getIsLoading()) {
                BillPaginationModel billPaginationModel = myBillsViewModel.getErrorConfigVersion;
                billPaginationModel.setPageNum(billPaginationModel.getPageNum() + 1);
                myBillsViewModel.getErrorConfigVersion.setLoading(true);
                myBillsViewModel.MyBillsEntityDataFactory(new MonthlyAmountAndHighlightRequest(null, null, null, null, null, true, myBillsViewModel.getErrorConfigVersion.getPageNum(), 10, "DUE_SOON", 31, null));
            }
            if (myBillsViewModel.isLayoutRequested.getHasMore() && !myBillsViewModel.isLayoutRequested.getIsLoading()) {
                BillPaginationModel billPaginationModel2 = myBillsViewModel.isLayoutRequested;
                billPaginationModel2.setPageNum(billPaginationModel2.getPageNum() + 1);
                myBillsViewModel.MyBillsEntityDataFactory(new MonthlyAmountAndHighlightRequest(null, null, null, null, null, true, myBillsViewModel.isLayoutRequested.getPageNum(), 10, "LATER", 31, null));
            }
            if (myBillsViewModel.NetworkUserEntityData$$ExternalSyntheticLambda7.getHasMore() && !myBillsViewModel.NetworkUserEntityData$$ExternalSyntheticLambda7.getIsLoading()) {
                BillPaginationModel billPaginationModel3 = myBillsViewModel.NetworkUserEntityData$$ExternalSyntheticLambda7;
                billPaginationModel3.setPageNum(billPaginationModel3.getPageNum() + 1);
                myBillsViewModel.MyBillsEntityDataFactory(new MonthlyAmountAndHighlightRequest(null, null, null, null, null, true, myBillsViewModel.NetworkUserEntityData$$ExternalSyntheticLambda7.getPageNum(), 10, "NEXT_MONTH", 31, null));
            }
            if (!myBillsViewModel.PrepareContext.getHasMore() || myBillsViewModel.PrepareContext.getIsLoading()) {
                return;
            }
            BillPaginationModel billPaginationModel4 = myBillsViewModel.PrepareContext;
            billPaginationModel4.setPageNum(billPaginationModel4.getPageNum() + 1);
            myBillsViewModel.MyBillsEntityDataFactory(new MonthlyAmountAndHighlightRequest(null, null, null, null, null, true, myBillsViewModel.PrepareContext.getPageNum(), 10, "PAST_DUE", 31, null));
        }
    }

    public static final /* synthetic */ List BuiltInFictitiousFunctionClassFactory() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            BillPaymentStatusModel billPaymentStatusModel = new BillPaymentStatusModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, null, 33554431, null);
            billPaymentStatusModel.setViewType(4);
            arrayList.add(billPaymentStatusModel);
        }
        return arrayList;
    }

    public static final /* synthetic */ MyBillsViewModel GetContactSyncConfig(MyBillsDashboardFragment myBillsDashboardFragment) {
        return (MyBillsViewModel) myBillsDashboardFragment.isLayoutRequested.getValue();
    }

    public static final /* synthetic */ void getAuthRequestContext(MyBillsDashboardFragment myBillsDashboardFragment, MyBillsUiState.OnSuccessGetCurrentBalance onSuccessGetCurrentBalance) {
        VB vb = myBillsDashboardFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentMyBillsDashboardBinding) vb).initRecordTimeStamp.setBalance(MoneyViewModel.INSTANCE.fromCurrencyAmountModel(onSuccessGetCurrentBalance.MyBillsEntityDataFactory));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x004b, code lost:
    
        if (kotlin.text.StringsKt.equals$default(r0 != null ? r0.getAmount() : null, "0", false, 2, null) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00ba, code lost:
    
        if (kotlin.text.StringsKt.equals$default(r0 != null ? r0.getAmount() : null, "0", false, 2, null) != false) goto L125;
     */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void MyBillsEntityDataFactory(id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment r13, id.dana.mybills.domain.model.MonthlyAmountWithConsultView r14) {
        /*
            Method dump skipped, instructions count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment.MyBillsEntityDataFactory(id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment, id.dana.mybills.domain.model.MonthlyAmountWithConsultView):void");
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda1(MyBillsDashboardFragment myBillsDashboardFragment) {
        ((ViewSkeletonScreen) myBillsDashboardFragment.GetContactSyncConfig.getValue()).PlaceComponentResult();
        VB vb = myBillsDashboardFragment.PlaceComponentResult;
        if (vb != 0) {
            View view = ((FragmentMyBillsDashboardBinding) vb).GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(8);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void initRecordTimeStamp(MyBillsDashboardFragment myBillsDashboardFragment) {
        ((ViewSkeletonScreen) myBillsDashboardFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).PlaceComponentResult();
        VB vb = myBillsDashboardFragment.PlaceComponentResult;
        if (vb != 0) {
            View view = ((FragmentMyBillsDashboardBinding) vb).whenAvailable;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(8);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda8(MyBillsDashboardFragment myBillsDashboardFragment) {
        ((ViewSkeletonScreen) myBillsDashboardFragment.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue()).PlaceComponentResult();
        VB vb = myBillsDashboardFragment.PlaceComponentResult;
        if (vb != 0) {
            View view = ((FragmentMyBillsDashboardBinding) vb).isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(8);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void newProxyInstance(MyBillsDashboardFragment myBillsDashboardFragment) {
        ((ViewSkeletonScreen) myBillsDashboardFragment.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue()).PlaceComponentResult();
        VB vb = myBillsDashboardFragment.PlaceComponentResult;
        if (vb != 0) {
            View view = ((FragmentMyBillsDashboardBinding) vb).newProxyInstance.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(8);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void PrepareContext(MyBillsDashboardFragment myBillsDashboardFragment) {
        ((ViewSkeletonScreen) myBillsDashboardFragment.NetworkUserEntityData$$ExternalSyntheticLambda8.getValue()).PlaceComponentResult();
        VB vb = myBillsDashboardFragment.PlaceComponentResult;
        if (vb != 0) {
            View view = ((FragmentMyBillsDashboardBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda8.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(8);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void PlaceComponentResult(MyBillsDashboardFragment myBillsDashboardFragment, String str) {
        DanaH5Helper danaH5Helper = DanaH5Helper.INSTANCE;
        Context requireContext = myBillsDashboardFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        danaH5Helper.openUrl(requireContext, MyBillsEntityDataFactory(str));
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda7(MyBillsDashboardFragment myBillsDashboardFragment) {
        DanaH5Helper danaH5Helper = DanaH5Helper.INSTANCE;
        Context requireContext = myBillsDashboardFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        TagFormat.Companion companion = TagFormat.INSTANCE;
        danaH5Helper.openUrl(requireContext, TagFormat.Companion.KClassImpl$Data$declaredNonStaticMembers$2("https://m.dana.id/m/portal/topup?entryPoint={entryPoint}").MyBillsEntityDataFactory("entryPoint", TopupSource.MY_BILLS).PlaceComponentResult());
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment myBillsDashboardFragment, BillPaymentStatusModel billPaymentStatusModel) {
        MyBillsAnalyticTracker myBillsAnalyticTracker = myBillsDashboardFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        myBillsAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsPurposeAction.BILL_DETAIL);
        if (billPaymentStatusModel.isPaylater()) {
            if (!(myBillsDashboardFragment.getAuthRequestContext.length() == 0)) {
                String str = myBillsDashboardFragment.getAuthRequestContext;
                DanaH5Helper danaH5Helper = DanaH5Helper.INSTANCE;
                Context requireContext = myBillsDashboardFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                danaH5Helper.openUrl(requireContext, MyBillsEntityDataFactory(str));
                return;
            }
            final MyBillsViewModel myBillsViewModel = (MyBillsViewModel) myBillsDashboardFragment.isLayoutRequested.getValue();
            myBillsViewModel.NetworkUserEntityData$$ExternalSyntheticLambda2.execute("service_paylater_loan_personal", new Function1<HashMap<String, Object>, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$getDanaCicilLink$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(HashMap<String, Object> hashMap) {
                    invoke2(hashMap);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(HashMap<String, Object> hashMap) {
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    Intrinsics.checkNotNullParameter(hashMap, "");
                    String str2 = (String) hashMap.get("link");
                    if (str2 != null) {
                        mutableStateFlow = MyBillsViewModel.this.scheduleImpl;
                        do {
                            value = mutableStateFlow.getValue();
                            MyBillsUiState myBillsUiState = (MyBillsUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new MyBillsUiState.OnSuccessGetDanaCicilLink(str2)));
                    }
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$getDanaCicilLink$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        NavController authRequestContext = androidx.view.fragment.FragmentKt.getAuthRequestContext(myBillsDashboardFragment);
        int i = R.id.action_myBillsDashboardPage_to_singlePayBillBottomSheetFragment;
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", billPaymentStatusModel);
        Unit unit = Unit.INSTANCE;
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(i, bundle, (NavOptions) null);
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda5(MyBillsDashboardFragment myBillsDashboardFragment) {
        myBillsDashboardFragment.scheduleImpl();
        myBillsDashboardFragment.MyBillsEntityDataFactory();
        myBillsDashboardFragment.PlaceComponentResult();
    }

    public static final /* synthetic */ void PlaceComponentResult(MyBillsDashboardFragment myBillsDashboardFragment, BillPaginationModel billPaginationModel) {
        List<BillPaymentStatusModel> bills = billPaginationModel.getBills();
        ArrayList arrayList = new ArrayList();
        for (Object obj : bills) {
            if (((BillPaymentStatusModel) obj).isSelected()) {
                arrayList.add(obj);
            }
        }
        ((MyBillsViewModel) myBillsDashboardFragment.isLayoutRequested.getValue()).getAuthRequestContext(arrayList, true);
        VB vb = myBillsDashboardFragment.PlaceComponentResult;
        if (vb == 0) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        ConstraintLayout constraintLayout = ((FragmentMyBillsDashboardBinding) vb).GetContactSyncConfig.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(billPaginationModel.getBills().isEmpty() ? 8 : 0);
        VB vb2 = myBillsDashboardFragment.PlaceComponentResult;
        if (vb2 != 0) {
            ItemBillPaymentViewBinding itemBillPaymentViewBinding = ((FragmentMyBillsDashboardBinding) vb2).GetContactSyncConfig;
            MaterialCardView materialCardView = itemBillPaymentViewBinding.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(materialCardView, "");
            if (!(materialCardView.getVisibility() == 0)) {
                MaterialCardView materialCardView2 = itemBillPaymentViewBinding.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(materialCardView2, "");
                materialCardView2.setVisibility(0);
            }
            ImageView imageView = itemBillPaymentViewBinding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(imageView, "");
            imageView.setVisibility(8);
            TextView textView = itemBillPaymentViewBinding.scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            itemBillPaymentViewBinding.scheduleImpl.setText(String.valueOf(billPaginationModel.getBills().size()));
            itemBillPaymentViewBinding.getErrorConfigVersion.setText(getAuthRequestContext(billPaginationModel.getBills()));
            if (billPaginationModel.getIsShimmerFirstTimeShowed()) {
                ((BillsAdapter) myBillsDashboardFragment.MyBillsEntityDataFactory.getValue()).BuiltInFictitiousFunctionClassFactory();
                View view = itemBillPaymentViewBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullExpressionValue(view, "");
                view.setVisibility(8);
                billPaginationModel.setShimmerFirstTimeShowed(false);
            }
            BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext((BillsAdapter) myBillsDashboardFragment.MyBillsEntityDataFactory.getValue(), billPaginationModel.getBills());
            myBillsDashboardFragment.getAuthRequestContext(false);
            FirebasePerformanceMonitor MyBillsEntityDataFactory2 = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
            Intrinsics.checkNotNullParameter("mybills_qos_performances_due_soon", "");
            Trace trace = MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2.get("mybills_qos_performances_due_soon");
            if (trace != null) {
                trace.stop();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MyBillsDashboardFragment myBillsDashboardFragment, BillPaginationModel billPaginationModel) {
        VB vb = myBillsDashboardFragment.PlaceComponentResult;
        if (vb == 0) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        ConstraintLayout constraintLayout = ((FragmentMyBillsDashboardBinding) vb).isLayoutRequested.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(billPaginationModel.getBills().isEmpty() ? 8 : 0);
        VB vb2 = myBillsDashboardFragment.PlaceComponentResult;
        if (vb2 != 0) {
            ItemBillPaymentViewBinding itemBillPaymentViewBinding = ((FragmentMyBillsDashboardBinding) vb2).isLayoutRequested;
            MaterialCardView materialCardView = itemBillPaymentViewBinding.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(materialCardView, "");
            if (!(materialCardView.getVisibility() == 0)) {
                MaterialCardView materialCardView2 = itemBillPaymentViewBinding.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(materialCardView2, "");
                materialCardView2.setVisibility(0);
            }
            ImageView imageView = itemBillPaymentViewBinding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(imageView, "");
            imageView.setVisibility(8);
            TextView textView = itemBillPaymentViewBinding.scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            itemBillPaymentViewBinding.scheduleImpl.setText(String.valueOf(billPaginationModel.getBills().size()));
            itemBillPaymentViewBinding.getErrorConfigVersion.setText(getAuthRequestContext(billPaginationModel.getBills()));
            if (((MyBillsViewModel) myBillsDashboardFragment.isLayoutRequested.getValue()).isLayoutRequested.getIsShimmerFirstTimeShowed()) {
                itemBillPaymentViewBinding.KClassImpl$Data$declaredNonStaticMembers$2.removeAllViews();
                View view = itemBillPaymentViewBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullExpressionValue(view, "");
                view.setVisibility(8);
                ((MyBillsViewModel) myBillsDashboardFragment.isLayoutRequested.getValue()).isLayoutRequested.setShimmerFirstTimeShowed(false);
            }
            BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext((BillsAdapter) myBillsDashboardFragment.scheduleImpl.getValue(), billPaginationModel.getBills());
            myBillsDashboardFragment.getAuthRequestContext(false);
            FirebasePerformanceMonitor MyBillsEntityDataFactory2 = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
            Intrinsics.checkNotNullParameter("mybills_qos_performances_later", "");
            Trace trace = MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2.get("mybills_qos_performances_later");
            if (trace != null) {
                trace.stop();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment myBillsDashboardFragment, BillPaginationModel billPaginationModel) {
        VB vb = myBillsDashboardFragment.PlaceComponentResult;
        if (vb == 0) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        ConstraintLayout constraintLayout = ((FragmentMyBillsDashboardBinding) vb).newProxyInstance.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(billPaginationModel.getBills().isEmpty() ? 8 : 0);
        VB vb2 = myBillsDashboardFragment.PlaceComponentResult;
        if (vb2 != 0) {
            ItemBillPaymentViewBinding itemBillPaymentViewBinding = ((FragmentMyBillsDashboardBinding) vb2).newProxyInstance;
            itemBillPaymentViewBinding.getErrorConfigVersion.setText(getAuthRequestContext(billPaginationModel.getBills()));
            MaterialCardView materialCardView = itemBillPaymentViewBinding.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(materialCardView, "");
            if (!(materialCardView.getVisibility() == 0)) {
                MaterialCardView materialCardView2 = itemBillPaymentViewBinding.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(materialCardView2, "");
                materialCardView2.setVisibility(0);
            }
            if (billPaginationModel.getIsShimmerFirstTimeShowed()) {
                View view = itemBillPaymentViewBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullExpressionValue(view, "");
                view.setVisibility(8);
                billPaginationModel.setShimmerFirstTimeShowed(false);
            }
            BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext((BillsAdapter) myBillsDashboardFragment.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue(), billPaginationModel.getBills());
            myBillsDashboardFragment.BuiltInFictitiousFunctionClassFactory(myBillsDashboardFragment.lookAheadTest);
            myBillsDashboardFragment.getAuthRequestContext(false);
            FirebasePerformanceMonitor MyBillsEntityDataFactory2 = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
            Intrinsics.checkNotNullParameter("mybills_qos_performances_next_month", "");
            Trace trace = MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2.get("mybills_qos_performances_next_month");
            if (trace != null) {
                trace.stop();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void getAuthRequestContext(MyBillsDashboardFragment myBillsDashboardFragment, View view, BillPaymentStatusModel billPaymentStatusModel) {
        Tooltip.Builder builder = new Tooltip.Builder(view, 0, 2, null);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda5 = myBillsDashboardFragment.getString(Intrinsics.areEqual(billPaymentStatusModel.getRecurringType(), RecurringType.REMINDER) ? R.string.mybills_tooltip_reminder : R.string.mybills_tooltip_auto_deduct);
        builder.GetContactSyncConfig = true;
        builder.PlaceComponentResult = ContextCompat.BuiltInFictitiousFunctionClassFactory(view.getContext(), R.color.MyBillsEntityDataFactory);
        builder.MyBillsEntityDataFactory = 32.0f;
        builder.BuiltInFictitiousFunctionClassFactory = 32.0f;
        builder.lookAheadTest = 8.0f;
        builder.PrepareContext = ColorStateList.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(view.getContext(), R.color.res_0x7f06031d_networkuserentitydata_externalsyntheticlambda1));
        builder.NetworkUserEntityData$$ExternalSyntheticLambda6 = TypedValue.applyDimension(2, 14.0f, builder.getErrorConfigVersion.getResources().getDisplayMetrics());
        builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = 10.0f;
        builder.newProxyInstance = 16;
        builder.moveToNextValue = 10;
        builder.scheduleImpl = 48;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = ResourcesCompat.BuiltInFictitiousFunctionClassFactory(builder.getErrorConfigVersion.getResources(), R.drawable.res_0x7f080b31_networkuserentitydata_externalsyntheticlambda7, null);
        MyBillsDashboardFragment$setOnBillsIconClicked$1 myBillsDashboardFragment$setOnBillsIconClicked$1 = new Function1<Tooltip, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$setOnBillsIconClicked$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Tooltip tooltip) {
                invoke2(tooltip);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Tooltip tooltip) {
                Intrinsics.checkNotNullParameter(tooltip, "");
                tooltip.DatabaseTableConfigUtil.dismiss();
            }
        };
        Intrinsics.checkNotNullParameter(myBillsDashboardFragment$setOnBillsIconClicked$1, "");
        builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = myBillsDashboardFragment$setOnBillsIconClicked$1;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = 3000L;
        builder.BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment myBillsDashboardFragment, View view, BillPaymentStatusModel billPaymentStatusModel) {
        int i = 0;
        Tooltip.Builder builder = new Tooltip.Builder(view, i, 2, null);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda5 = myBillsDashboardFragment.getString(billPaymentStatusModel.getBillState().BuiltInFictitiousFunctionClassFactory);
        builder.GetContactSyncConfig = true;
        builder.PlaceComponentResult = ContextCompat.BuiltInFictitiousFunctionClassFactory(view.getContext(), R.color.MyBillsEntityDataFactory);
        builder.MyBillsEntityDataFactory = 32.0f;
        builder.BuiltInFictitiousFunctionClassFactory = 32.0f;
        builder.lookAheadTest = 16.0f;
        builder.PrepareContext = ColorStateList.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(view.getContext(), R.color.res_0x7f06031d_networkuserentitydata_externalsyntheticlambda1));
        builder.NetworkUserEntityData$$ExternalSyntheticLambda6 = TypedValue.applyDimension(2, 14.0f, builder.getErrorConfigVersion.getResources().getDisplayMetrics());
        builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = 10.0f;
        builder.newProxyInstance = 16;
        builder.moveToNextValue = 10;
        builder.scheduleImpl = 48;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = ResourcesCompat.BuiltInFictitiousFunctionClassFactory(builder.getErrorConfigVersion.getResources(), R.drawable.res_0x7f080b31_networkuserentitydata_externalsyntheticlambda7, null);
        MyBillsDashboardFragment$setOnBillsInfoClicked$1 myBillsDashboardFragment$setOnBillsInfoClicked$1 = new Function1<Tooltip, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$setOnBillsInfoClicked$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Tooltip tooltip) {
                invoke2(tooltip);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Tooltip tooltip) {
                Intrinsics.checkNotNullParameter(tooltip, "");
                tooltip.DatabaseTableConfigUtil.dismiss();
            }
        };
        Intrinsics.checkNotNullParameter(myBillsDashboardFragment$setOnBillsInfoClicked$1, "");
        builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = myBillsDashboardFragment$setOnBillsInfoClicked$1;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = 3000L;
        builder.BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ void getAuthRequestContext(MyBillsDashboardFragment myBillsDashboardFragment, BillPaginationModel billPaginationModel) {
        List<BillPaymentStatusModel> bills = billPaginationModel.getBills();
        ArrayList arrayList = new ArrayList();
        for (Object obj : bills) {
            if (((BillPaymentStatusModel) obj).isSelected()) {
                arrayList.add(obj);
            }
        }
        ((MyBillsViewModel) myBillsDashboardFragment.isLayoutRequested.getValue()).getAuthRequestContext(arrayList, true);
        VB vb = myBillsDashboardFragment.PlaceComponentResult;
        if (vb == 0) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        ConstraintLayout constraintLayout = ((FragmentMyBillsDashboardBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda8.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(billPaginationModel.getBills().isEmpty() ? 8 : 0);
        VB vb2 = myBillsDashboardFragment.PlaceComponentResult;
        if (vb2 != 0) {
            ItemBillPaymentViewBinding itemBillPaymentViewBinding = ((FragmentMyBillsDashboardBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda8;
            itemBillPaymentViewBinding.getErrorConfigVersion.setText(getAuthRequestContext(billPaginationModel.getBills()));
            MaterialCardView materialCardView = itemBillPaymentViewBinding.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(materialCardView, "");
            if (!(materialCardView.getVisibility() == 0)) {
                MaterialCardView materialCardView2 = itemBillPaymentViewBinding.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(materialCardView2, "");
                materialCardView2.setVisibility(0);
            }
            if (((MyBillsViewModel) myBillsDashboardFragment.isLayoutRequested.getValue()).PrepareContext.getIsShimmerFirstTimeShowed()) {
                View view = itemBillPaymentViewBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullExpressionValue(view, "");
                view.setVisibility(8);
                ((MyBillsViewModel) myBillsDashboardFragment.isLayoutRequested.getValue()).PrepareContext.setShimmerFirstTimeShowed(false);
            }
            BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext((BillsAdapter) myBillsDashboardFragment.DatabaseTableConfigUtil.getValue(), billPaginationModel.getBills());
            myBillsDashboardFragment.PlaceComponentResult(myBillsDashboardFragment.NetworkUserEntityData$$ExternalSyntheticLambda0);
            myBillsDashboardFragment.getAuthRequestContext(false);
            FirebasePerformanceMonitor MyBillsEntityDataFactory2 = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
            Intrinsics.checkNotNullParameter("mybills_qos_performances_past_due", "");
            Trace trace = MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2.get("mybills_qos_performances_past_due");
            if (trace != null) {
                trace.stop();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment myBillsDashboardFragment, boolean z) {
        int i;
        int i2;
        Context requireContext = myBillsDashboardFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(requireContext);
        if (z) {
            i = R.string.res_0x7f1313a0_securitysettingsactivity_createpinlauncher_2_1;
        } else {
            i = R.string.save_bills_reminder_title;
        }
        builder.SubSequence = myBillsDashboardFragment.getString(i);
        if (z) {
            i2 = R.string.save_bills_auto_deduct_message;
        } else {
            i2 = R.string.save_bills_reminder_message;
        }
        builder.GetContactSyncConfig = myBillsDashboardFragment.getString(i2);
        builder.DatabaseTableConfigUtil = z ? R.drawable.ic_save_bills_auto_deduct : R.drawable.res_0x7f080b5b_networkuserentitydata_externalsyntheticlambda8;
        CustomDialog.Builder PlaceComponentResult2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
        PlaceComponentResult2.moveToNextValue = 0L;
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory(myBillsDashboardFragment.getString(R.string.res_0x7f1313a1_securitysettingsactivity_createpinlauncher_2_2), new Function1<View, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$showSaveBillsDialog$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        }).BuiltInFictitiousFunctionClassFactory().show();
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda6(MyBillsDashboardFragment myBillsDashboardFragment) {
        VB vb = myBillsDashboardFragment.PlaceComponentResult;
        if (vb != 0) {
            ItemBillPaymentViewBinding itemBillPaymentViewBinding = ((FragmentMyBillsDashboardBinding) vb).GetContactSyncConfig;
            View view = itemBillPaymentViewBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(0);
            itemBillPaymentViewBinding.moveToNextValue.setText(myBillsDashboardFragment.getString(R.string.res_0x7f130f26_networkuserentitydata_externalsyntheticlambda8));
            RecyclerView recyclerView = itemBillPaymentViewBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(0);
            ((ViewSkeletonScreen) myBillsDashboardFragment.GetContactSyncConfig.getValue()).MyBillsEntityDataFactory();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda3(MyBillsDashboardFragment myBillsDashboardFragment) {
        VB vb = myBillsDashboardFragment.PlaceComponentResult;
        if (vb != 0) {
            FragmentMyBillsDashboardBinding fragmentMyBillsDashboardBinding = (FragmentMyBillsDashboardBinding) vb;
            fragmentMyBillsDashboardBinding.getCallingPid.setText(myBillsDashboardFragment.getString(R.string.my_bills_month_bills, DateTimeUtil.INSTANCE.getCurrentMonth()));
            View view = fragmentMyBillsDashboardBinding.whenAvailable;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(0);
            ((ViewSkeletonScreen) myBillsDashboardFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).MyBillsEntityDataFactory();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void FragmentBottomSheetPaymentSettingBinding(MyBillsDashboardFragment myBillsDashboardFragment) {
        VB vb = myBillsDashboardFragment.PlaceComponentResult;
        if (vb != 0) {
            ItemBillPaymentViewBinding itemBillPaymentViewBinding = ((FragmentMyBillsDashboardBinding) vb).isLayoutRequested;
            View view = itemBillPaymentViewBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(0);
            itemBillPaymentViewBinding.moveToNextValue.setText(myBillsDashboardFragment.getString(R.string.my_bills_later_this_month));
            RecyclerView recyclerView = itemBillPaymentViewBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(0);
            ((ViewSkeletonScreen) myBillsDashboardFragment.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue()).MyBillsEntityDataFactory();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void getCallingPid(MyBillsDashboardFragment myBillsDashboardFragment) {
        VB vb = myBillsDashboardFragment.PlaceComponentResult;
        if (vb != 0) {
            ItemBillPaymentViewBinding itemBillPaymentViewBinding = ((FragmentMyBillsDashboardBinding) vb).newProxyInstance;
            View view = itemBillPaymentViewBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(0);
            itemBillPaymentViewBinding.moveToNextValue.setText(myBillsDashboardFragment.getString(R.string.my_bills_next_month));
            RecyclerView recyclerView = itemBillPaymentViewBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(8);
            ((ViewSkeletonScreen) myBillsDashboardFragment.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue()).MyBillsEntityDataFactory();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void whenAvailable(MyBillsDashboardFragment myBillsDashboardFragment) {
        VB vb = myBillsDashboardFragment.PlaceComponentResult;
        if (vb != 0) {
            ItemBillPaymentViewBinding itemBillPaymentViewBinding = ((FragmentMyBillsDashboardBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda8;
            View view = itemBillPaymentViewBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(0);
            itemBillPaymentViewBinding.moveToNextValue.setText(myBillsDashboardFragment.getString(R.string.my_bills_past_due));
            RecyclerView recyclerView = itemBillPaymentViewBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(8);
            ((ViewSkeletonScreen) myBillsDashboardFragment.NetworkUserEntityData$$ExternalSyntheticLambda8.getValue()).MyBillsEntityDataFactory();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void MyBillsEntityDataFactory() {
        final MyBillsViewModel myBillsViewModel = (MyBillsViewModel) this.isLayoutRequested.getValue();
        BaseFlowUseCase.execute$default(myBillsViewModel.newProxyInstance, NoParams.INSTANCE, null, new Function1<CurrencyAmount, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$getUserCurrentBalance$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CurrencyAmount currencyAmount) {
                invoke2(currencyAmount);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CurrencyAmount currencyAmount) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(currencyAmount, "");
                mutableStateFlow = MyBillsViewModel.this.scheduleImpl;
                do {
                    value = mutableStateFlow.getValue();
                    MyBillsUiState myBillsUiState = (MyBillsUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new MyBillsUiState.OnSuccessGetCurrentBalance(MoneyModelMapperKt.MyBillsEntityDataFactory(currencyAmount))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$getUserCurrentBalance$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append("error ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory("MyBillsViewModel", sb.toString());
            }
        }, null, ViewModelKt.PlaceComponentResult(myBillsViewModel), 18, null);
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ItemBillPaymentViewBinding itemBillPaymentViewBinding = ((FragmentMyBillsDashboardBinding) vb).newProxyInstance;
            RecyclerView recyclerView = itemBillPaymentViewBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(p0 ? 0 : 8);
            itemBillPaymentViewBinding.getAuthRequestContext.setRotation(p0 ? 180.0f : 0.0f);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void PlaceComponentResult(boolean p0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ItemBillPaymentViewBinding itemBillPaymentViewBinding = ((FragmentMyBillsDashboardBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda8;
            RecyclerView recyclerView = itemBillPaymentViewBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(p0 ? 0 : 8);
            itemBillPaymentViewBinding.getAuthRequestContext.setRotation(p0 ? 180.0f : 0.0f);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void scheduleImpl() {
        ((MyBillsViewModel) this.isLayoutRequested.getValue()).MyBillsEntityDataFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentMyBillsDashboardBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda8.getAuthRequestContext.setRotation(0.0f);
            this.lookAheadTest = false;
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentMyBillsDashboardBinding) vb2).newProxyInstance.getAuthRequestContext.setRotation(0.0f);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        if (p0) {
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                ((FragmentMyBillsDashboardBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.setBackgroundResource(R.color.GetContactSyncConfig);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentMyBillsDashboardBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.setBackgroundResource(R.color.lookAheadTest);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        VB vb3 = this.PlaceComponentResult;
        if (vb3 != 0) {
            ConstraintLayout constraintLayout = ((FragmentMyBillsDashboardBinding) vb3).scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            constraintLayout.setVisibility(p0 ? 8 : 0);
            VB vb4 = this.PlaceComponentResult;
            if (vb4 != 0) {
                ConstraintLayout constraintLayout2 = ((FragmentMyBillsDashboardBinding) vb4).getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
                boolean z = !p0;
                constraintLayout2.setVisibility(z ? 8 : 0);
                VB vb5 = this.PlaceComponentResult;
                if (vb5 == 0) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                ConstraintLayout constraintLayout3 = ((FragmentMyBillsDashboardBinding) vb5).NetworkUserEntityData$$ExternalSyntheticLambda8.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(constraintLayout3, "");
                constraintLayout3.setVisibility(p0 ? 8 : 0);
                VB vb6 = this.PlaceComponentResult;
                if (vb6 == 0) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                ConstraintLayout constraintLayout4 = ((FragmentMyBillsDashboardBinding) vb6).GetContactSyncConfig.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(constraintLayout4, "");
                constraintLayout4.setVisibility(p0 ? 8 : 0);
                VB vb7 = this.PlaceComponentResult;
                if (vb7 == 0) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                ConstraintLayout constraintLayout5 = ((FragmentMyBillsDashboardBinding) vb7).isLayoutRequested.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(constraintLayout5, "");
                constraintLayout5.setVisibility(p0 ? 8 : 0);
                VB vb8 = this.PlaceComponentResult;
                if (vb8 != 0) {
                    ConstraintLayout constraintLayout6 = ((FragmentMyBillsDashboardBinding) vb8).DatabaseTableConfigUtil;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout6, "");
                    constraintLayout6.setVisibility(z ? 8 : 0);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Subscribe
    public final void paymentResultStatusAction(PaymentResultStatusEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        if (Intrinsics.areEqual(event.MyBillsEntityDataFactory, "SUCCESS") || Intrinsics.areEqual(event.MyBillsEntityDataFactory, "PENDING") || Intrinsics.areEqual(event.MyBillsEntityDataFactory, "PAYMENT_BULK_PAY_REFRESH")) {
            scheduleImpl();
            MyBillsEntityDataFactory();
            PlaceComponentResult();
        }
    }
}

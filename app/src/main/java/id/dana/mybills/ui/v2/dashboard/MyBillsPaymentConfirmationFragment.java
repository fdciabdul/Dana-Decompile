package id.dana.mybills.ui.v2.dashboard;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.FlowExtKt;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import androidx.view.NavArgsLazy;
import androidx.view.ViewModelKt;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import id.dana.analytics.executiontime.TrackerExecutionCounter;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.extension.StringExtKt;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.mybills.R;
import id.dana.mybills.databinding.FragmentMyBillsPaymentConfirmationBinding;
import id.dana.mybills.di.component.MyBillsComponent;
import id.dana.mybills.di.module.ViewModelFactory;
import id.dana.mybills.di.provider.MyBillsComponentProvider;
import id.dana.mybills.domain.interactor.GetHighlightPayTransaction;
import id.dana.mybills.domain.model.HighlightTransactionPay;
import id.dana.mybills.domain.model.HighlightTransactionPayKt;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;
import id.dana.mybills.ui.customview.MyBillsToolbarView;
import id.dana.mybills.ui.model.BillPaymentStatusModel;
import id.dana.mybills.ui.model.HighlightTransactionPayModelKt;
import id.dana.mybills.ui.model.HighlightTransactionPayRequestModel;
import id.dana.mybills.ui.model.HighlightTransactionPayRequestModelKt;
import id.dana.mybills.ui.model.MoneyViewModel;
import id.dana.mybills.ui.model.PaidStatus;
import id.dana.mybills.ui.v2.MyBillsHomeActivity;
import id.dana.mybills.ui.v2.MyBillsUiState;
import id.dana.mybills.ui.v2.MyBillsViewModel;
import id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment;
import id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter;
import id.dana.mybills.utils.MyBillsTrackerUtil;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010\u000fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00192\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u0017\u0010\u001bR\u0013\u0010\u001f\u001a\u00020\u001cX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0013\u0010#\u001a\u00020 X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\u0017\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u001d\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010(R\u0012\u0010,\u001a\u00020+X\u0087\"¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u0010!\u001a\u0002018\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0013\u0010'\u001a\u000204X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b5\u0010\"R\u0012\u00107\u001a\u000206X\u0087\"¢\u0006\u0006\n\u0004\b7\u00108"}, d2 = {"Lid/dana/mybills/ui/v2/dashboard/MyBillsPaymentConfirmationFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/os/Bundle;", "p0", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "p1", "p2", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onDestroyView", "()V", "Landroid/content/DialogInterface;", "onDismiss", "(Landroid/content/DialogInterface;)V", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)V", "", "", "(ZLjava/util/List;)V", "Lid/dana/mybills/ui/v2/dashboard/MyBillsPaymentConfirmationFragmentArgs;", "MyBillsEntityDataFactory", "Landroidx/navigation/NavArgsLazy;", "getAuthRequestContext", "Lid/dana/mybills/ui/v2/dashboard/adapter/BillsAdapter;", "scheduleImpl", "Lkotlin/Lazy;", "PlaceComponentResult", "Lid/dana/mybills/databinding/FragmentMyBillsPaymentConfirmationBinding;", "lookAheadTest", "Lid/dana/mybills/databinding/FragmentMyBillsPaymentConfirmationBinding;", "moveToNextValue", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "myBillsAnalyticTracker", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "Lid/dana/mybills/di/component/MyBillsComponent;", "getErrorConfigVersion", "Lid/dana/mybills/di/component/MyBillsComponent;", "Lid/dana/analytics/executiontime/TrackerExecutionCounter;", "GetContactSyncConfig", "Lid/dana/analytics/executiontime/TrackerExecutionCounter;", "Lid/dana/mybills/ui/v2/MyBillsViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/mybills/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/mybills/di/module/ViewModelFactory;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class MyBillsPaymentConfirmationFragment extends BottomSheetDialogFragment {

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final TrackerExecutionCounter scheduleImpl;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final NavArgsLazy getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy moveToNextValue;
    private MyBillsComponent getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private FragmentMyBillsPaymentConfirmationBinding BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public MyBillsAnalyticTracker myBillsAnalyticTracker;
    @Inject
    public ViewModelFactory viewModelFactory;
    public static final byte[] $$a = {16, -72, -107, 15, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 87;
    public static final byte[] PlaceComponentResult = {116, 39, -17, SignedBytes.MAX_POWER_OF_TWO, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 36;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory = true;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<BillsAdapter>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment$billsAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BillsAdapter invoke() {
            return new BillsAdapter(null, null, null, null, 15, null);
        }
    });

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0024 -> B:23:0x0026). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment.PlaceComponentResult
            int r6 = r6 * 15
            int r6 = 19 - r6
            int r8 = r8 * 3
            int r8 = r8 + 16
            int r7 = 106 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r4 = 0
            r3 = r6
            goto L26
        L14:
            r3 = 0
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            r3 = r0[r6]
        L26:
            int r6 = r6 + 1
            int r7 = r7 + r3
            int r7 = r7 + 2
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment.a(int, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r7 = r7 + 4
            int r9 = r9 * 3
            int r9 = r9 + 75
            byte[] r0 = id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment.$$a
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L35
        L19:
            r3 = 0
        L1a:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            int r7 = r7 + 1
            if (r4 != r8) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r7 = -r7
            int r10 = r10 + r7
            int r7 = r10 + (-7)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment.b(byte, byte, short, java.lang.Object[]):void");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (PlaceComponentResult[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-PlaceComponentResult[5]);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, (byte) (b4 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 5, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16));
                    byte b5 = $$a[35];
                    byte b6 = (byte) (b5 + 1);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), 35 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {1992682495, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, 18 - (ViewConfiguration.getTouchSlop() >> 8), (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                setStyle(0, R.style.BuiltInFictitiousFunctionClassFactory);
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
    public final View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        FragmentMyBillsPaymentConfirmationBinding KClassImpl$Data$declaredNonStaticMembers$22 = FragmentMyBillsPaymentConfirmationBinding.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
        this.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$22;
        CoordinatorLayout coordinatorLayout = KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(coordinatorLayout, "");
        return coordinatorLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.mybills.di.provider.MyBillsComponentProvider");
        }
        MyBillsComponent authRequestContext = ((MyBillsComponentProvider) applicationContext).provideMyBillsComponent().getAuthRequestContext();
        this.getErrorConfigVersion = authRequestContext;
        authRequestContext.PlaceComponentResult(this);
        final FragmentMyBillsPaymentConfirmationBinding fragmentMyBillsPaymentConfirmationBinding = this.BuiltInFictitiousFunctionClassFactory;
        if (fragmentMyBillsPaymentConfirmationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragmentMyBillsPaymentConfirmationBinding = null;
        }
        ViewParent parent = p0.getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        BottomSheetBehavior.from((View) parent).setState(3);
        MyBillsToolbarView myBillsToolbarView = fragmentMyBillsPaymentConfirmationBinding.GetContactSyncConfig;
        myBillsToolbarView.setToolbarBackgroundColor(R.color.GetContactSyncConfig);
        myBillsToolbarView.setToolbarAction(R.drawable.res_0x7f08086b_networkuserentitydata_externalsyntheticlambda2, new Function0<Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment$initView$1$2$1
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
                MyBillsPaymentConfirmationFragment.this.dismiss();
            }
        });
        final RecyclerView recyclerView = fragmentMyBillsPaymentConfirmationBinding.DatabaseTableConfigUtil;
        LinearLayout linearLayout = fragmentMyBillsPaymentConfirmationBinding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        LinearLayout linearLayout2 = linearLayout;
        if (ViewCompat.getValueOfTouchPositionAbsolute(linearLayout2) && !linearLayout2.isLayoutRequested()) {
            recyclerView.setPadding(0, 0, 0, fragmentMyBillsPaymentConfirmationBinding.scheduleImpl.getHeight());
        } else {
            linearLayout2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment$initView$lambda-23$lambda-17$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View p02, int p12, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
                    Intrinsics.checkNotNullParameter(p02, "");
                    p02.removeOnLayoutChangeListener(this);
                    RecyclerView.this.setPadding(0, 0, 0, fragmentMyBillsPaymentConfirmationBinding.scheduleImpl.getHeight());
                }
            });
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter((BillsAdapter) this.PlaceComponentResult.getValue());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), 1);
        Drawable PlaceComponentResult2 = ContextCompat.PlaceComponentResult(recyclerView.getContext(), R.drawable.divider_item_decoration);
        if (PlaceComponentResult2 != null) {
            if (PlaceComponentResult2 == null) {
                throw new IllegalArgumentException("Drawable cannot be null.");
            }
            dividerItemDecoration.MyBillsEntityDataFactory = PlaceComponentResult2;
            recyclerView.addItemDecoration(dividerItemDecoration);
            fragmentMyBillsPaymentConfirmationBinding.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyBillsPaymentConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsPaymentConfirmationFragment.this);
                }
            });
            fragmentMyBillsPaymentConfirmationBinding.lookAheadTest.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyBillsPaymentConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            });
            fragmentMyBillsPaymentConfirmationBinding.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyBillsPaymentConfirmationFragment.PlaceComponentResult(MyBillsPaymentConfirmationFragment.this);
                }
            });
        }
        BillPaymentStatusModel[] billPaymentStatusModelArr = ((MyBillsPaymentConfirmationFragmentArgs) this.getAuthRequestContext.getValue()).getAuthRequestContext;
        if (billPaymentStatusModelArr != null) {
            BuiltInFictitiousFunctionClassFactory(ArraysKt.toList(billPaymentStatusModelArr));
        }
        StateFlow<MyBillsUiState> stateFlow = ((MyBillsViewModel) this.moveToNextValue.getValue()).readMicros;
        Lifecycle lifecycle = getViewLifecycleOwner().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        Flow onEach = FlowKt.onEach(FlowKt.distinctUntilChanged(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle)), new MyBillsPaymentConfirmationFragment$observeState$1(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner));
        BuiltInFictitiousFunctionClassFactory(false, CollectionsKt.toMutableList(((BillsAdapter) this.PlaceComponentResult.getValue()).getAuthRequestContext));
    }

    private final void BuiltInFictitiousFunctionClassFactory(List<BillPaymentStatusModel> p0) {
        String PlaceComponentResult2;
        boolean z;
        FragmentMyBillsPaymentConfirmationBinding fragmentMyBillsPaymentConfirmationBinding = this.BuiltInFictitiousFunctionClassFactory;
        if (fragmentMyBillsPaymentConfirmationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragmentMyBillsPaymentConfirmationBinding = null;
        }
        BillsAdapter billsAdapter = (BillsAdapter) this.PlaceComponentResult.getValue();
        List<BillPaymentStatusModel> list = p0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (BillPaymentStatusModel billPaymentStatusModel : list) {
            billPaymentStatusModel.setViewType(2);
            arrayList.add(billPaymentStatusModel);
        }
        BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(billsAdapter, arrayList);
        Iterator<T> it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            MoneyViewModel totalAmount = ((BillPaymentStatusModel) it.next()).getTotalAmount();
            j += totalAmount != null ? totalAmount.getAmountLong() : 0L;
        }
        PlaceComponentResult2 = StringExtKt.PlaceComponentResult(String.valueOf(j), "Rp", "0");
        fragmentMyBillsPaymentConfirmationBinding.getErrorConfigVersion.setText(PlaceComponentResult2);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (!(((BillPaymentStatusModel) it2.next()).getPaidStatus() instanceof PaidStatus.Confirm)) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        this.MyBillsEntityDataFactory = z;
        MyBillsToolbarView myBillsToolbarView = fragmentMyBillsPaymentConfirmationBinding.GetContactSyncConfig;
        String string = getString(this.MyBillsEntityDataFactory ? R.string.mybills_payment_confirmation : R.string.mybills_payment_status);
        Intrinsics.checkNotNullExpressionValue(string, "");
        myBillsToolbarView.setToolbarTitle(string);
        DanaButtonPrimaryView danaButtonPrimaryView = fragmentMyBillsPaymentConfirmationBinding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
        danaButtonPrimaryView.setVisibility(this.MyBillsEntityDataFactory ? 0 : 8);
        DanaButtonSecondaryView danaButtonSecondaryView = fragmentMyBillsPaymentConfirmationBinding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
        danaButtonSecondaryView.setVisibility(this.MyBillsEntityDataFactory ^ true ? 0 : 8);
        View view = fragmentMyBillsPaymentConfirmationBinding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(view, "");
        view.setVisibility(this.MyBillsEntityDataFactory ^ true ? 0 : 8);
        ConstraintLayout constraintLayout = fragmentMyBillsPaymentConfirmationBinding.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(8);
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0, List<BillPaymentStatusModel> p1) {
        List<BillPaymentStatusModel> list = p1;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<BillPaymentStatusModel> list2 = p1;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (true) {
            String str = "";
            if (!it.hasNext()) {
                break;
            }
            BillPaymentStatusModel billPaymentStatusModel = (BillPaymentStatusModel) it.next();
            MyBillsTrackerUtil myBillsTrackerUtil = MyBillsTrackerUtil.getAuthRequestContext;
            String goodsType = billPaymentStatusModel.getGoodsType();
            if (goodsType != null) {
                str = goodsType;
            }
            arrayList.add(MyBillsTrackerUtil.getAuthRequestContext(str));
        }
        ArrayList arrayList2 = arrayList;
        MyBillsAnalyticTracker myBillsAnalyticTracker = this.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        myBillsAnalyticTracker.BuiltInFictitiousFunctionClassFactory(p0, String.valueOf(p1.size()), arrayList2);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            EventBus.getDefault().post(new MyBillsDashboardFragment.PaymentResultStatusEvent("PAYMENT_BULK_PAY_REFRESH"));
        }
        super.onDismiss(p0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.scheduleImpl.initiateEndTime();
    }

    public MyBillsPaymentConfirmationFragment() {
        final MyBillsPaymentConfirmationFragment myBillsPaymentConfirmationFragment = this;
        this.getAuthRequestContext = new NavArgsLazy(Reflection.getOrCreateKotlinClass(MyBillsPaymentConfirmationFragmentArgs.class), new Function0<Bundle>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment$special$$inlined$navArgs$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bundle invoke() {
                Bundle arguments = Fragment.this.getArguments();
                if (arguments != null) {
                    return arguments;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Fragment ");
                sb.append(Fragment.this);
                sb.append(" has null arguments");
                throw new IllegalStateException(sb.toString());
            }
        });
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = MyBillsPaymentConfirmationFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment$special$$inlined$viewModels$default$2
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
        this.moveToNextValue = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(myBillsPaymentConfirmationFragment, Reflection.getOrCreateKotlinClass(MyBillsViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment$special$$inlined$viewModels$default$4
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
        this.scheduleImpl = new TrackerExecutionCounter();
    }

    public static /* synthetic */ void PlaceComponentResult(MyBillsPaymentConfirmationFragment myBillsPaymentConfirmationFragment) {
        Intrinsics.checkNotNullParameter(myBillsPaymentConfirmationFragment, "");
        myBillsPaymentConfirmationFragment.dismiss();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MyBillsPaymentConfirmationFragment myBillsPaymentConfirmationFragment) {
        Intrinsics.checkNotNullParameter(myBillsPaymentConfirmationFragment, "");
        Collection collection = ((BillsAdapter) myBillsPaymentConfirmationFragment.PlaceComponentResult.getValue()).getAuthRequestContext;
        myBillsPaymentConfirmationFragment.scheduleImpl.initiateStartTime();
        final MyBillsViewModel myBillsViewModel = (MyBillsViewModel) myBillsPaymentConfirmationFragment.moveToNextValue.getValue();
        Collection collection2 = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection2, 10));
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(HighlightTransactionPayModelKt.toPayRequestModel((BillPaymentStatusModel) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        Intrinsics.checkNotNullParameter(arrayList2, "");
        ArrayList<HighlightTransactionPayRequestModel> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        for (HighlightTransactionPayRequestModel highlightTransactionPayRequestModel : arrayList3) {
            highlightTransactionPayRequestModel.setPayMode("AUTO_DEBIT");
            arrayList4.add(HighlightTransactionPayRequestModelKt.toHighlightTransactionPayRequest(highlightTransactionPayRequestModel));
        }
        BaseFlowUseCase.execute$default(myBillsViewModel.GetContactSyncConfig, new GetHighlightPayTransaction.Params(arrayList4, false, 2, null), null, new Function1<List<? extends HighlightTransactionPay>, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$doBulkPayAction$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends HighlightTransactionPay> list) {
                invoke2((List<HighlightTransactionPay>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<HighlightTransactionPay> list) {
                MutableStateFlow mutableStateFlow;
                Object value;
                ArrayList arrayList5;
                Intrinsics.checkNotNullParameter(list, "");
                mutableStateFlow = MyBillsViewModel.this.scheduleImpl;
                do {
                    value = mutableStateFlow.getValue();
                    MyBillsUiState myBillsUiState = (MyBillsUiState) value;
                    List<HighlightTransactionPay> list2 = list;
                    arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList5.add(HighlightTransactionPayKt.toHighlighTransactionPayModel((HighlightTransactionPay) it2.next()));
                    }
                } while (!mutableStateFlow.compareAndSet(value, new MyBillsUiState.OnResultBulkPayAction(arrayList5)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$doBulkPayAction$2
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
                mutableStateFlow = MyBillsViewModel.this.scheduleImpl;
                do {
                    value = mutableStateFlow.getValue();
                    MyBillsUiState myBillsUiState = (MyBillsUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, MyBillsUiState.OnErrorGetPayTransaction.INSTANCE));
            }
        }, null, ViewModelKt.PlaceComponentResult(myBillsViewModel), 18, null);
        myBillsPaymentConfirmationFragment.BuiltInFictitiousFunctionClassFactory(true, CollectionsKt.toMutableList(collection));
        ((MyBillsHomeActivity) myBillsPaymentConfirmationFragment.requireActivity()).showBlockerLoading();
    }

    /* JADX WARN: Code restructure failed: missing block: B:168:0x0128, code lost:
    
        r1.add(id.dana.mybills.ui.model.HighlightTransactionPayModelKt.toBillPaymentStatusModel(r5, r7));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void getAuthRequestContext(id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment r14, id.dana.mybills.ui.v2.MyBillsUiState.OnResultBulkPayAction r15) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment.getAuthRequestContext(id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment, id.dana.mybills.ui.v2.MyBillsUiState$OnResultBulkPayAction):void");
    }
}

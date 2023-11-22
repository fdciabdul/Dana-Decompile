package id.dana.mybills.ui.v2.managebills;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.FlowExtKt;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import androidx.view.NavController;
import androidx.view.NavOptions;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.fragment.FragmentKt;
import androidx.view.viewmodel.CreationExtras;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.mybills.R;
import id.dana.mybills.databinding.FragmentManageBillsBinding;
import id.dana.mybills.databinding.MyBillsToolbarLayoutBinding;
import id.dana.mybills.di.component.MyBillsComponent;
import id.dana.mybills.di.module.ViewModelFactory;
import id.dana.mybills.di.provider.MyBillsComponentProvider;
import id.dana.mybills.domain.model.MonthlyAmountAndHighlightRequest;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;
import id.dana.mybills.ui.constant.RecurringType;
import id.dana.mybills.ui.model.BillPaymentStatusModel;
import id.dana.mybills.ui.model.generalize.BillPaginationModel;
import id.dana.mybills.ui.v2.MyBillsUiState;
import id.dana.mybills.ui.v2.MyBillsViewModel;
import id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter;
import id.dana.mybills.utils.MyBillsTrackerUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J!\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0011\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u00020\u0016X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\u0012\u0010\u001b\u001a\u00020\u001aX\u0087\"¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0012\u0010\"\u001a\u00020!X\u0087\"¢\u0006\u0006\n\u0004\b\"\u0010#R\u0013\u0010\u0017\u001a\u00020$X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018"}, d2 = {"Lid/dana/mybills/ui/v2/managebills/ManageBillsFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/mybills/databinding/FragmentManageBillsBinding;", "", "MyBillsEntityDataFactory", "()V", "lookAheadTest", "Landroid/view/View;", "p0", "Landroid/os/Bundle;", "p1", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/core/widget/NestedScrollView;", "", "p2", "", "getAuthRequestContext", "(Landroidx/core/widget/NestedScrollView;II)Z", "Lid/dana/mybills/ui/model/generalize/BillPaginationModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/ui/model/generalize/BillPaginationModel;", "Lid/dana/mybills/ui/v2/dashboard/adapter/BillsAdapter;", "PlaceComponentResult", "Lkotlin/Lazy;", "Z", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "myBillsAnalyticTracker", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "Lid/dana/mybills/di/component/MyBillsComponent;", "scheduleImpl", "Lid/dana/mybills/di/component/MyBillsComponent;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/mybills/di/module/ViewModelFactory;", "Lid/dana/mybills/ui/v2/MyBillsViewModel;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ManageBillsFragment extends BaseViewBindingFragment<FragmentManageBillsBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private BillPaginationModel getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Lazy MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;
    @Inject
    public MyBillsAnalyticTracker myBillsAnalyticTracker;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private MyBillsComponent BuiltInFictitiousFunctionClassFactory;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentManageBillsBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentManageBillsBinding BuiltInFictitiousFunctionClassFactory = FragmentManageBillsBinding.BuiltInFictitiousFunctionClassFactory(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            Context applicationContext = requireActivity().getApplicationContext();
            if (applicationContext == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.mybills.di.provider.MyBillsComponentProvider");
            }
            MyBillsComponent authRequestContext = ((MyBillsComponentProvider) applicationContext).provideMyBillsComponent().getAuthRequestContext();
            this.BuiltInFictitiousFunctionClassFactory = authRequestContext;
            authRequestContext.getAuthRequestContext(this);
        }
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            MyBillsToolbarLayoutBinding myBillsToolbarLayoutBinding = ((FragmentManageBillsBinding) vb).getAuthRequestContext;
            AppCompatImageView appCompatImageView = myBillsToolbarLayoutBinding.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(0);
            myBillsToolbarLayoutBinding.initRecordTimeStamp.setText(getString(R.string.title_manage_bills));
            myBillsToolbarLayoutBinding.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.managebills.ManageBillsFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ManageBillsFragment.KClassImpl$Data$declaredNonStaticMembers$2(ManageBillsFragment.this);
                }
            });
            Intrinsics.checkNotNullExpressionValue(myBillsToolbarLayoutBinding, "");
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentManageBillsBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.managebills.ManageBillsFragment$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ManageBillsFragment.BuiltInFictitiousFunctionClassFactory(ManageBillsFragment.this);
                    }
                });
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    RecyclerView recyclerView = ((FragmentManageBillsBinding) vb3).BuiltInFictitiousFunctionClassFactory;
                    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                    recyclerView.setAdapter((BillsAdapter) this.MyBillsEntityDataFactory.getValue());
                    VB vb4 = this.PlaceComponentResult;
                    if (vb4 != 0) {
                        ((FragmentManageBillsBinding) vb4).PlaceComponentResult.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: id.dana.mybills.ui.v2.managebills.ManageBillsFragment$$ExternalSyntheticLambda0
                            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                            public final void getAuthRequestContext(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                                ManageBillsFragment.PlaceComponentResult(ManageBillsFragment.this, nestedScrollView, i2, i4);
                            }
                        });
                        StateFlow<MyBillsUiState> stateFlow = ((MyBillsViewModel) this.PlaceComponentResult.getValue()).readMicros;
                        Lifecycle lifecycle = getViewLifecycleOwner().getLifecycle();
                        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
                        Flow onEach = FlowKt.onEach(FlowKt.distinctUntilChanged(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle)), new ManageBillsFragment$initLifecycle$1(this, null));
                        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "");
                        FlowKt.launchIn(onEach, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner));
                        this.getAuthRequestContext = new BillPaginationModel();
                        MyBillsEntityDataFactory();
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

    private final void MyBillsEntityDataFactory() {
        this.getAuthRequestContext.setLoading(true);
        ((MyBillsViewModel) this.PlaceComponentResult.getValue()).MyBillsEntityDataFactory(new MonthlyAmountAndHighlightRequest(null, null, null, null, null, true, this.getAuthRequestContext.getPageNum(), 10, null, 287, null));
    }

    private final boolean getAuthRequestContext(NestedScrollView p0, int p1, int p2) {
        if (p1 > p2) {
            int bottom = p0.getChildAt(0).getBottom();
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                return bottom <= ((FragmentManageBillsBinding) vb).PlaceComponentResult.getHeight() + p1;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        return false;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        super.lookAheadTest();
        FragmentKt.getAuthRequestContext(this).moveToNextValue();
    }

    public ManageBillsFragment() {
        final ManageBillsFragment manageBillsFragment = this;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.mybills.ui.v2.managebills.ManageBillsFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = ManageBillsFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.mybills.ui.v2.managebills.ManageBillsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.mybills.ui.v2.managebills.ManageBillsFragment$special$$inlined$viewModels$default$2
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
        this.PlaceComponentResult = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(manageBillsFragment, Reflection.getOrCreateKotlinClass(MyBillsViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.mybills.ui.v2.managebills.ManageBillsFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: id.dana.mybills.ui.v2.managebills.ManageBillsFragment$special$$inlined$viewModels$default$4
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
                    ViewModelStoreOwner PlaceComponentResult = FragmentViewModelLazyKt.PlaceComponentResult(lazy);
                    HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = PlaceComponentResult instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) PlaceComponentResult : null;
                    CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                    return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, function0);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<BillsAdapter>() { // from class: id.dana.mybills.ui.v2.managebills.ManageBillsFragment$billsAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BillsAdapter invoke() {
                final ManageBillsFragment manageBillsFragment2 = ManageBillsFragment.this;
                BillsAdapter billsAdapter = new BillsAdapter(null, null, null, new Function1<BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.managebills.ManageBillsFragment$billsAdapter$2.1
                    {
                        super(1);
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(BillPaymentStatusModel billPaymentStatusModel) {
                        Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                        ManageBillsFragment.PlaceComponentResult(ManageBillsFragment.this, billPaymentStatusModel);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(BillPaymentStatusModel billPaymentStatusModel) {
                        invoke2(billPaymentStatusModel);
                        return Unit.INSTANCE;
                    }
                }, 7, null);
                BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(billsAdapter, ManageBillsFragment.PlaceComponentResult(ManageBillsFragment.this));
                return billsAdapter;
            }
        });
        this.getAuthRequestContext = new BillPaginationModel();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ManageBillsFragment manageBillsFragment) {
        Intrinsics.checkNotNullParameter(manageBillsFragment, "");
        FragmentKt.getAuthRequestContext(manageBillsFragment).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void PlaceComponentResult(ManageBillsFragment manageBillsFragment, NestedScrollView nestedScrollView, int i, int i2) {
        Intrinsics.checkNotNullParameter(manageBillsFragment, "");
        Intrinsics.checkNotNullParameter(nestedScrollView, "");
        if (manageBillsFragment.getAuthRequestContext(nestedScrollView, i, i2) && manageBillsFragment.getAuthRequestContext.getHasMore() && !manageBillsFragment.getAuthRequestContext.getIsLoading()) {
            BillPaginationModel billPaginationModel = manageBillsFragment.getAuthRequestContext;
            billPaginationModel.setPageNum(billPaginationModel.getPageNum() + 1);
            manageBillsFragment.MyBillsEntityDataFactory();
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ManageBillsFragment manageBillsFragment) {
        Intrinsics.checkNotNullParameter(manageBillsFragment, "");
        manageBillsFragment.getAuthRequestContext = new BillPaginationModel();
        manageBillsFragment.MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ BillsAdapter MyBillsEntityDataFactory(ManageBillsFragment manageBillsFragment) {
        return (BillsAdapter) manageBillsFragment.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ List PlaceComponentResult(ManageBillsFragment manageBillsFragment) {
        VB vb = manageBillsFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentManageBillsBinding) vb).BuiltInFictitiousFunctionClassFactory.suppressLayout(true);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 6; i++) {
                BillPaymentStatusModel billPaymentStatusModel = new BillPaymentStatusModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, null, 33554431, null);
                billPaymentStatusModel.setViewType(3);
                arrayList.add(billPaymentStatusModel);
            }
            return arrayList;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void PlaceComponentResult(ManageBillsFragment manageBillsFragment, BillPaymentStatusModel billPaymentStatusModel) {
        NavController authRequestContext = FragmentKt.getAuthRequestContext(manageBillsFragment);
        int i = R.id.action_manageBillsFragment_to_singlePayBillPage;
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", billPaymentStatusModel);
        bundle.putBoolean("EDIT_STATE", true);
        Unit unit = Unit.INSTANCE;
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(i, bundle, (NavOptions) null);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(ManageBillsFragment manageBillsFragment, BillPaginationModel billPaginationModel) {
        ArrayList arrayList = new ArrayList();
        List<BillPaymentStatusModel> bills = billPaginationModel.getBills();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : bills) {
            if (Intrinsics.areEqual(((BillPaymentStatusModel) obj).getRecurringType(), RecurringType.REMINDER)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            String goodsType = ((BillPaymentStatusModel) it.next()).getGoodsType();
            if (goodsType != null) {
                MyBillsTrackerUtil myBillsTrackerUtil = MyBillsTrackerUtil.getAuthRequestContext;
                arrayList.add(MyBillsTrackerUtil.getAuthRequestContext(goodsType));
            }
        }
        int size = arrayList3.size();
        List<BillPaymentStatusModel> bills2 = billPaginationModel.getBills();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : bills2) {
            if (Intrinsics.areEqual(((BillPaymentStatusModel) obj2).getRecurringType(), RecurringType.AUTO_DEDUCTION)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = arrayList4;
        Iterator it2 = arrayList5.iterator();
        while (it2.hasNext()) {
            String goodsType2 = ((BillPaymentStatusModel) it2.next()).getGoodsType();
            if (goodsType2 != null) {
                MyBillsTrackerUtil myBillsTrackerUtil2 = MyBillsTrackerUtil.getAuthRequestContext;
                arrayList.add(MyBillsTrackerUtil.getAuthRequestContext(goodsType2));
            }
        }
        int size2 = arrayList5.size();
        MyBillsAnalyticTracker myBillsAnalyticTracker = manageBillsFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        myBillsAnalyticTracker.getAuthRequestContext(size, size2, arrayList);
    }
}

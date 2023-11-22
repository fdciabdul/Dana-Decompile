package id.dana.pushverify.view.verificationlist.list;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.viewbinding.ViewBindingFragment;
import id.dana.databinding.FragmentVerificationListActiveBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerVerificationListComponent;
import id.dana.di.modules.VerificationListModule;
import id.dana.pushverify.constant.PushVerifyEntryPoint;
import id.dana.pushverify.constant.PushVerifyTab;
import id.dana.pushverify.model.PushVerifyParamsModel;
import id.dana.pushverify.model.VerificationDetailModel;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.pushverify.view.richview.VerificationStateView;
import id.dana.pushverify.view.verificationdetail.PushVerifyActivity;
import id.dana.pushverify.view.verificationlist.VerificationListActivity;
import id.dana.pushverify.view.verificationlist.adapter.VerificationAdapterUtil;
import id.dana.pushverify.view.verificationlist.adapter.VerificationItemDecoration;
import id.dana.pushverify.view.verificationlist.adapter.VerificationListAdapter;
import id.dana.pushverify.view.verificationlist.list.VerificationListContract;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u0010\u001a\u00020\rX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0015\u001a\f\u0012\b\u0012\u0006*\u00020\u00120\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0087\"¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016X\u0087\"¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019"}, d2 = {"Lid/dana/pushverify/view/verificationlist/list/VerificationListActiveFragment;", "Lid/dana/base/viewbinding/ViewBindingFragment;", "Lid/dana/databinding/FragmentVerificationListActiveBinding;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onSelected", "p0", "BuiltInFictitiousFunctionClassFactory", "(I)V", "Lid/dana/pushverify/view/verificationlist/adapter/VerificationListAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "getAuthRequestContext", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "Landroidx/activity/result/ActivityResultLauncher;", "PlaceComponentResult", "Ldagger/Lazy;", "Lid/dana/pushverify/view/verificationlist/list/VerificationListContract$Presenter;", "presenter", "Ldagger/Lazy;", "Lid/dana/pushverify/tracker/PushVerifyTracker;", "pushVerifyTracker", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationListActiveFragment extends ViewBindingFragment<FragmentVerificationListActiveBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> PlaceComponentResult;
    @Inject
    public Lazy<VerificationListContract.Presenter> presenter;
    @Inject
    public Lazy<PushVerifyTracker> pushVerifyTracker;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final kotlin.Lazy getAuthRequestContext = LazyKt.lazy(new Function0<VerificationListAdapter>() { // from class: id.dana.pushverify.view.verificationlist.list.VerificationListActiveFragment$activeListAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VerificationListAdapter invoke() {
            return new VerificationListAdapter();
        }
    });

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_verification_list_active;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public VerificationListActiveFragment() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.pushverify.view.verificationlist.list.VerificationListActiveFragment$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                VerificationListActiveFragment.getAuthRequestContext(VerificationListActiveFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.PlaceComponentResult = registerForActivityResult;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ FragmentVerificationListActiveBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentVerificationListActiveBinding PlaceComponentResult = FragmentVerificationListActiveBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.base.BaseFragment
    public final void onSelected() {
        super.onSelected();
        Lazy<PushVerifyTracker> lazy = this.pushVerifyTracker;
        Lazy<VerificationListContract.Presenter> lazy2 = null;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        lazy.get().MyBillsEntityDataFactory(PushVerifyTab.ACTIVE);
        if (((VerificationListAdapter) this.getAuthRequestContext.getValue()).getGetAuthRequestContext() == 0) {
            Lazy<VerificationListContract.Presenter> lazy3 = this.presenter;
            if (lazy3 != null) {
                lazy2 = lazy3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            lazy2.get().getAuthRequestContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory(int p0) {
        FragmentVerificationListActiveBinding binding = getBinding();
        if (binding != null) {
            RecyclerView recyclerView = binding.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(8);
            VerificationStateView verificationStateView = binding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(verificationStateView, "");
            verificationStateView.setVisibility(0);
            verificationStateView.show(p0);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/pushverify/view/verificationlist/list/VerificationListActiveFragment$Companion;", "", "Lid/dana/pushverify/view/verificationlist/list/VerificationListActiveFragment;", "MyBillsEntityDataFactory", "()Lid/dana/pushverify/view/verificationlist/list/VerificationListActiveFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static VerificationListActiveFragment MyBillsEntityDataFactory() {
            return new VerificationListActiveFragment();
        }
    }

    public static /* synthetic */ void PlaceComponentResult(VerificationListAdapter verificationListAdapter, List list) {
        Intrinsics.checkNotNullParameter(verificationListAdapter, "");
        Intrinsics.checkNotNullParameter(list, "");
        VerificationListAdapter.KClassImpl$Data$declaredNonStaticMembers$2(verificationListAdapter, list);
    }

    public static /* synthetic */ void getAuthRequestContext(VerificationListActiveFragment verificationListActiveFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(verificationListActiveFragment, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory == -1) {
            Lazy<VerificationListContract.Presenter> lazy = verificationListActiveFragment.presenter;
            if (lazy == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy = null;
            }
            VerificationListContract.Presenter presenter = lazy.get();
            presenter.MyBillsEntityDataFactory();
            presenter.getAuthRequestContext();
            FragmentActivity activity = verificationListActiveFragment.getActivity();
            VerificationListActivity verificationListActivity = activity instanceof VerificationListActivity ? (VerificationListActivity) activity : null;
            if (verificationListActivity != null) {
                verificationListActivity.openTab(1);
                verificationListActivity.checkNotificationDisabled();
            }
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(VerificationListAdapter verificationListAdapter, VerificationListActiveFragment verificationListActiveFragment, int i) {
        Intrinsics.checkNotNullParameter(verificationListAdapter, "");
        Intrinsics.checkNotNullParameter(verificationListActiveFragment, "");
        VerificationDetailModel authRequestContext = verificationListAdapter.getAuthRequestContext(i);
        if (authRequestContext != null) {
            Lazy<PushVerifyTracker> lazy = verificationListActiveFragment.pushVerifyTracker;
            if (lazy == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy = null;
            }
            lazy.get().BuiltInFictitiousFunctionClassFactory(PushVerifyEntryPoint.VERIFICATION_LIST);
            PushVerifyParamsModel pushVerifyParamsModel = new PushVerifyParamsModel(authRequestContext.moveToNextValue, authRequestContext.getErrorConfigVersion, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2);
            ActivityResultLauncher<Intent> activityResultLauncher = verificationListActiveFragment.PlaceComponentResult;
            PushVerifyActivity.Companion companion = PushVerifyActivity.INSTANCE;
            FragmentActivity requireActivity = verificationListActiveFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "");
            activityResultLauncher.MyBillsEntityDataFactory(PushVerifyActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(requireActivity, pushVerifyParamsModel, PushVerifyEntryPoint.VERIFICATION_LIST), null);
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(VerificationListActiveFragment verificationListActiveFragment, final List list) {
        FragmentVerificationListActiveBinding binding = verificationListActiveFragment.getBinding();
        if (binding != null) {
            RecyclerView recyclerView = binding.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(0);
            VerificationStateView verificationStateView = binding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(verificationStateView, "");
            verificationStateView.setVisibility(8);
        }
        final VerificationListAdapter verificationListAdapter = (VerificationListAdapter) verificationListActiveFragment.getAuthRequestContext.getValue();
        List<VerificationDetailModel> emptyList = CollectionsKt.emptyList();
        Runnable runnable = new Runnable() { // from class: id.dana.pushverify.view.verificationlist.list.VerificationListActiveFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                VerificationListActiveFragment.PlaceComponentResult(VerificationListAdapter.this, list);
            }
        };
        Intrinsics.checkNotNullParameter(emptyList, "");
        verificationListAdapter.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(emptyList, runnable);
    }

    public static final /* synthetic */ void getAuthRequestContext(VerificationListActiveFragment verificationListActiveFragment) {
        VerificationListAdapter verificationListAdapter = (VerificationListAdapter) verificationListActiveFragment.getAuthRequestContext.getValue();
        VerificationAdapterUtil verificationAdapterUtil = VerificationAdapterUtil.INSTANCE;
        VerificationListAdapter.KClassImpl$Data$declaredNonStaticMembers$2(verificationListAdapter, VerificationAdapterUtil.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        RecyclerView recyclerView;
        DaggerVerificationListComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerVerificationListComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (VerificationListModule) Preconditions.getAuthRequestContext(new VerificationListModule(new VerificationListContract.View() { // from class: id.dana.pushverify.view.verificationlist.list.VerificationListActiveFragment$getVerificationListModule$1
            @Override // id.dana.pushverify.view.verificationlist.list.VerificationListContract.View
            public final void MyBillsEntityDataFactory() {
            }

            @Override // id.dana.pushverify.view.verificationlist.list.VerificationListContract.View
            public final void MyBillsEntityDataFactory(List<VerificationDetailModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.pushverify.view.verificationlist.list.VerificationListContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<VerificationDetailModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                VerificationListActiveFragment.PlaceComponentResult(VerificationListActiveFragment.this, p0);
            }

            @Override // id.dana.pushverify.view.verificationlist.list.VerificationListContract.View
            public final void PlaceComponentResult(List<VerificationDetailModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                VerificationListActiveFragment.PlaceComponentResult(VerificationListActiveFragment.this, p0);
            }

            @Override // id.dana.pushverify.view.verificationlist.list.VerificationListContract.View
            public final void getAuthRequestContext() {
                VerificationListActiveFragment.this.BuiltInFictitiousFunctionClassFactory(0);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                VerificationListActiveFragment.this.BuiltInFictitiousFunctionClassFactory(99);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                VerificationListActiveFragment.getAuthRequestContext(VerificationListActiveFragment.this);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                VerificationListAdapter.KClassImpl$Data$declaredNonStaticMembers$2((VerificationListAdapter) VerificationListActiveFragment.this.getAuthRequestContext.getValue(), CollectionsKt.emptyList());
            }
        }));
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(this);
        FragmentVerificationListActiveBinding binding = getBinding();
        if (binding != null) {
            binding.getAuthRequestContext.addOnActionClickCallback(new Function0<Unit>() { // from class: id.dana.pushverify.view.verificationlist.list.VerificationListActiveFragment$setupView$1$1
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
                    Lazy<VerificationListContract.Presenter> lazy = VerificationListActiveFragment.this.presenter;
                    if (lazy == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        lazy = null;
                    }
                    lazy.get().getAuthRequestContext();
                }
            });
            binding.PlaceComponentResult.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        final VerificationListAdapter verificationListAdapter = (VerificationListAdapter) this.getAuthRequestContext.getValue();
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.pushverify.view.verificationlist.list.VerificationListActiveFragment$$ExternalSyntheticLambda1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                VerificationListActiveFragment.KClassImpl$Data$declaredNonStaticMembers$2(VerificationListAdapter.this, this, i);
            }
        };
        Intrinsics.checkNotNullParameter(onItemClickListener, "");
        verificationListAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = onItemClickListener;
        FragmentVerificationListActiveBinding binding2 = getBinding();
        if (binding2 == null || (recyclerView = binding2.PlaceComponentResult) == null) {
            return;
        }
        recyclerView.setAdapter((VerificationListAdapter) this.getAuthRequestContext.getValue());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "");
            recyclerView.addItemDecoration(new VerificationItemDecoration(activity));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }
}

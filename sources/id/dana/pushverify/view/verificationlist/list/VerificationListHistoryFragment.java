package id.dana.pushverify.view.verificationlist.list;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingFragment;
import id.dana.databinding.FragmentVerificationListHistoryBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerVerificationListComponent;
import id.dana.di.modules.VerificationListModule;
import id.dana.pushverify.constant.PushVerifyTab;
import id.dana.pushverify.model.VerificationDetailModel;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.pushverify.view.richview.VerificationStateView;
import id.dana.pushverify.view.verificationlist.adapter.VerificationAdapterUtil;
import id.dana.pushverify.view.verificationlist.adapter.VerificationItemDecoration;
import id.dana.pushverify.view.verificationlist.adapter.VerificationListAdapter;
import id.dana.pushverify.view.verificationlist.list.VerificationListContract;
import id.dana.utils.LazyLoadScrollListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u001a\u0010\bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0087\"¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011X\u0087\"¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u0017X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/pushverify/view/verificationlist/list/VerificationListHistoryFragment;", "Lid/dana/base/viewbinding/ViewBindingFragment;", "Lid/dana/databinding/FragmentVerificationListHistoryBinding;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onSelected", "p0", "getAuthRequestContext", "(I)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "MyBillsEntityDataFactory", "Ldagger/Lazy;", "Lid/dana/pushverify/view/verificationlist/list/VerificationListContract$Presenter;", "presenter", "Ldagger/Lazy;", "Lid/dana/pushverify/tracker/PushVerifyTracker;", "pushVerifyTracker", "Lid/dana/pushverify/view/verificationlist/adapter/VerificationListAdapter;", "PlaceComponentResult", "Lkotlin/Lazy;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationListHistoryFragment extends ViewBindingFragment<FragmentVerificationListHistoryBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<VerificationListAdapter>() { // from class: id.dana.pushverify.view.verificationlist.list.VerificationListHistoryFragment$verificationListAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VerificationListAdapter invoke() {
            return new VerificationListAdapter();
        }
    });
    @Inject
    public dagger.Lazy<VerificationListContract.Presenter> presenter;
    @Inject
    public dagger.Lazy<PushVerifyTracker> pushVerifyTracker;

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.MyBillsEntityDataFactory;
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
        return R.layout.fragment_verification_list_history;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ FragmentVerificationListHistoryBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentVerificationListHistoryBinding authRequestContext = FragmentVerificationListHistoryBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.base.BaseFragment
    public final void onSelected() {
        super.onSelected();
        dagger.Lazy<PushVerifyTracker> lazy = this.pushVerifyTracker;
        dagger.Lazy<VerificationListContract.Presenter> lazy2 = null;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        lazy.get().MyBillsEntityDataFactory(PushVerifyTab.HISTORY);
        if (((VerificationListAdapter) this.getAuthRequestContext.getValue()).getItemCount() == 0) {
            dagger.Lazy<VerificationListContract.Presenter> lazy3 = this.presenter;
            if (lazy3 != null) {
                lazy2 = lazy3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            lazy2.get().BuiltInFictitiousFunctionClassFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext(int p0) {
        FragmentVerificationListHistoryBinding binding = getBinding();
        if (binding != null) {
            RecyclerView recyclerView = binding.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(8);
            VerificationStateView verificationStateView = binding.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(verificationStateView, "");
            verificationStateView.setVisibility(0);
            verificationStateView.show(p0);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/pushverify/view/verificationlist/list/VerificationListHistoryFragment$Companion;", "", "Lid/dana/pushverify/view/verificationlist/list/VerificationListHistoryFragment;", "getAuthRequestContext", "()Lid/dana/pushverify/view/verificationlist/list/VerificationListHistoryFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static VerificationListHistoryFragment getAuthRequestContext() {
            return new VerificationListHistoryFragment();
        }
    }

    public static /* synthetic */ void PlaceComponentResult(VerificationListAdapter verificationListAdapter, List list) {
        Intrinsics.checkNotNullParameter(verificationListAdapter, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (verificationListAdapter.getItemCount() == 0) {
            VerificationListAdapter.KClassImpl$Data$declaredNonStaticMembers$2(verificationListAdapter, list);
            return;
        }
        List<VerificationDetailModel> list2 = verificationListAdapter.getAuthRequestContext.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(list2, "");
        ArrayList arrayList = new ArrayList(list2);
        arrayList.addAll(list);
        VerificationListAdapter.KClassImpl$Data$declaredNonStaticMembers$2(verificationListAdapter, arrayList);
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(VerificationListHistoryFragment verificationListHistoryFragment, final List list) {
        VerificationDetailModel authRequestContext = ((VerificationListAdapter) verificationListHistoryFragment.getAuthRequestContext.getValue()).getAuthRequestContext(r0.getItemCount() - 1);
        if (authRequestContext == null || authRequestContext.scheduleImpl != 98) {
            return;
        }
        final VerificationListAdapter verificationListAdapter = (VerificationListAdapter) verificationListHistoryFragment.getAuthRequestContext.getValue();
        int itemCount = verificationListAdapter.getItemCount() - 1;
        Runnable runnable = new Runnable() { // from class: id.dana.pushverify.view.verificationlist.list.VerificationListHistoryFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VerificationListHistoryFragment.PlaceComponentResult(VerificationListAdapter.this, list);
            }
        };
        List<VerificationDetailModel> list2 = verificationListAdapter.getAuthRequestContext.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(list2, "");
        ArrayList arrayList = new ArrayList(list2);
        if (verificationListAdapter.PlaceComponentResult(itemCount)) {
            arrayList.remove(itemCount);
        }
        ArrayList arrayList2 = arrayList;
        Intrinsics.checkNotNullParameter(arrayList2, "");
        verificationListAdapter.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(arrayList2, runnable);
    }

    public static final /* synthetic */ VerificationListAdapter MyBillsEntityDataFactory(VerificationListHistoryFragment verificationListHistoryFragment) {
        return (VerificationListAdapter) verificationListHistoryFragment.getAuthRequestContext.getValue();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(VerificationListHistoryFragment verificationListHistoryFragment) {
        VerificationListAdapter verificationListAdapter = (VerificationListAdapter) verificationListHistoryFragment.getAuthRequestContext.getValue();
        VerificationAdapterUtil verificationAdapterUtil = VerificationAdapterUtil.INSTANCE;
        VerificationListAdapter.KClassImpl$Data$declaredNonStaticMembers$2(verificationListAdapter, VerificationAdapterUtil.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    public static final /* synthetic */ void lookAheadTest(VerificationListHistoryFragment verificationListHistoryFragment) {
        FragmentVerificationListHistoryBinding binding = verificationListHistoryFragment.getBinding();
        if (binding != null) {
            RecyclerView recyclerView = binding.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(0);
            VerificationStateView verificationStateView = binding.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(verificationStateView, "");
            verificationStateView.setVisibility(8);
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        DaggerVerificationListComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerVerificationListComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (VerificationListModule) Preconditions.getAuthRequestContext(new VerificationListModule(new VerificationListHistoryFragment$getVerificationListModule$1(this)));
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(this);
        FragmentVerificationListHistoryBinding binding = getBinding();
        if (binding != null) {
            binding.PlaceComponentResult.addOnActionClickCallback(new Function0<Unit>() { // from class: id.dana.pushverify.view.verificationlist.list.VerificationListHistoryFragment$setupView$1$1
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
                    dagger.Lazy<VerificationListContract.Presenter> lazy = VerificationListHistoryFragment.this.presenter;
                    if (lazy == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        lazy = null;
                    }
                    lazy.get().BuiltInFictitiousFunctionClassFactory();
                }
            });
            RecyclerView recyclerView = binding.BuiltInFictitiousFunctionClassFactory;
            recyclerView.setAdapter((VerificationListAdapter) this.getAuthRequestContext.getValue());
            FragmentActivity activity = getActivity();
            if (activity != null) {
                Intrinsics.checkNotNullExpressionValue(activity, "");
                recyclerView.addItemDecoration(new VerificationItemDecoration(activity));
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.addOnScrollListener(new LazyLoadScrollListener(1, new LazyLoadScrollListener.LazyLoadInteraction() { // from class: id.dana.pushverify.view.verificationlist.list.VerificationListHistoryFragment$createScrollInteraction$1
                @Override // id.dana.utils.LazyLoadScrollListener.LazyLoadInteraction
                public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
                    LazyLoadScrollListener.LazyLoadInteraction.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.utils.LazyLoadScrollListener.LazyLoadInteraction
                public final /* synthetic */ void PlaceComponentResult() {
                    LazyLoadScrollListener.LazyLoadInteraction.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.utils.LazyLoadScrollListener.LazyLoadInteraction
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    boolean z;
                    z = VerificationListHistoryFragment.this.MyBillsEntityDataFactory;
                    if (z) {
                        return;
                    }
                    VerificationListHistoryFragment.this.MyBillsEntityDataFactory = true;
                    dagger.Lazy<VerificationListContract.Presenter> lazy = VerificationListHistoryFragment.this.presenter;
                    if (lazy == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        lazy = null;
                    }
                    lazy.get().BuiltInFictitiousFunctionClassFactory();
                }
            }));
        }
    }
}

package id.dana.social.view.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingFragment;
import id.dana.databinding.ViewActivityReactionsListBinding;
import id.dana.feeds.ui.model.ActivityReactionsUserModel;
import id.dana.richview.LogoProgressView;
import id.dana.social.adapter.ActivityReactionsAdapter;
import id.dana.social.contract.ActivityReactionsContract;
import id.dana.social.di.module.ActivityReactionsModule;
import id.dana.social.model.ReactionCountModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u001f\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\f¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\r\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0014\u001a\u00020\u0013X\u0087\"¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/social/view/fragment/ActivityReactionsListFragment;", "Lid/dana/base/viewbinding/ViewBindingFragment;", "Lid/dana/databinding/ViewActivityReactionsListBinding;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/ActivityReactionsAdapter;", "PlaceComponentResult", "Lid/dana/social/adapter/ActivityReactionsAdapter;", "Lid/dana/social/contract/ActivityReactionsContract$Presenter;", "activityReactionsPresenter", "Lid/dana/social/contract/ActivityReactionsContract$Presenter;", "moveToNextValue", "Lid/dana/social/model/ReactionCountModel;", "lookAheadTest", "Lid/dana/social/model/ReactionCountModel;", "getAuthRequestContext", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;Lid/dana/social/model/ReactionCountModel;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityReactionsListFragment extends ViewBindingFragment<ViewActivityReactionsListBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final String MyBillsEntityDataFactory;
    public Map<Integer, View> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private ActivityReactionsAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public ActivityReactionsContract.Presenter activityReactionsPresenter;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final ReactionCountModel getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final String PlaceComponentResult;

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
        return R.layout.view_activity_reactions_list;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public ActivityReactionsListFragment(String str, ReactionCountModel reactionCountModel, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(reactionCountModel, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.MyBillsEntityDataFactory = new LinkedHashMap();
        this.MyBillsEntityDataFactory = str;
        this.getAuthRequestContext = reactionCountModel;
        this.PlaceComponentResult = str2;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewActivityReactionsListBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewActivityReactionsListBinding authRequestContext = ViewActivityReactionsListBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        RecyclerView recyclerView;
        ViewActivityReactionsListBinding binding = getBinding();
        ActivityReactionsContract.Presenter presenter = null;
        RecyclerView.LayoutManager layoutManager = (binding == null || (recyclerView = binding.getAuthRequestContext) == null) ? null : recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager != null) {
            int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            ActivityReactionsContract.Presenter presenter2 = this.activityReactionsPresenter;
            if (presenter2 != null) {
                presenter = presenter2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            return findLastCompletelyVisibleItemPosition == presenter.MyBillsEntityDataFactory();
        }
        return false;
    }

    public static final /* synthetic */ void getAuthRequestContext(ActivityReactionsListFragment activityReactionsListFragment) {
        ViewActivityReactionsListBinding binding = activityReactionsListFragment.getBinding();
        if (binding != null) {
            binding.MyBillsEntityDataFactory.stopRefresh();
            binding.MyBillsEntityDataFactory.setVisibility(8);
            binding.getAuthRequestContext.setVisibility(0);
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(ActivityReactionsListFragment activityReactionsListFragment, List list) {
        ActivityReactionsAdapter activityReactionsAdapter = activityReactionsListFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (activityReactionsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activityReactionsAdapter = null;
        }
        activityReactionsAdapter.appendItems(list);
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        LogoProgressView logoProgressView;
        getBaseActivity().getDanaApplication().getSocialCommonComponent().MyBillsEntityDataFactory(new ActivityReactionsModule(new ActivityReactionsContract.View() { // from class: id.dana.social.view.fragment.ActivityReactionsListFragment$initComponent$1
            @Override // id.dana.social.contract.ActivityReactionsContract.View
            public final String BuiltInFictitiousFunctionClassFactory() {
                return "Reaction";
            }

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

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.social.contract.ActivityReactionsContract.View
            public final void getAuthRequestContext() {
                String str;
                ReactionCountModel reactionCountModel;
                ActivityReactionsContract.Presenter presenter = ActivityReactionsListFragment.this.activityReactionsPresenter;
                if (presenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                str = ActivityReactionsListFragment.this.MyBillsEntityDataFactory;
                reactionCountModel = ActivityReactionsListFragment.this.getAuthRequestContext;
                presenter.getAuthRequestContext(str, reactionCountModel.PlaceComponentResult, false);
            }

            @Override // id.dana.social.contract.ActivityReactionsContract.View
            public final String MyBillsEntityDataFactory() {
                String shownErrorMessage;
                shownErrorMessage = ActivityReactionsListFragment.this.getShownErrorMessage();
                return shownErrorMessage == null ? "" : shownErrorMessage;
            }

            @Override // id.dana.social.contract.ActivityReactionsContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<ActivityReactionsUserModel> p0) {
                ActivityReactionsListFragment.getAuthRequestContext(ActivityReactionsListFragment.this);
                ActivityReactionsListFragment.PlaceComponentResult(ActivityReactionsListFragment.this, p0);
            }
        })).getAuthRequestContext(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        ActivityReactionsContract.Presenter presenter = this.activityReactionsPresenter;
        ActivityReactionsContract.Presenter presenter2 = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        registerPresenter(abstractPresenterArr);
        ViewActivityReactionsListBinding binding = getBinding();
        if (binding != null && (logoProgressView = binding.MyBillsEntityDataFactory) != null) {
            logoProgressView.startRefresh();
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ActivityReactionsAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        ViewActivityReactionsListBinding binding2 = getBinding();
        if (binding2 != null && (recyclerView2 = binding2.getAuthRequestContext) != null) {
            recyclerView2.setNestedScrollingEnabled(true);
            recyclerView2.setLayoutManager(linearLayoutManager);
            ActivityReactionsAdapter activityReactionsAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (activityReactionsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                activityReactionsAdapter = null;
            }
            recyclerView2.setAdapter(activityReactionsAdapter);
        }
        ViewActivityReactionsListBinding binding3 = getBinding();
        if (binding3 != null && (recyclerView = binding3.getAuthRequestContext) != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.social.view.fragment.ActivityReactionsListFragment$initScrollListener$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrolled(RecyclerView p0, int p1, int p2) {
                    boolean BuiltInFictitiousFunctionClassFactory;
                    String str;
                    ReactionCountModel reactionCountModel;
                    Intrinsics.checkNotNullParameter(p0, "");
                    super.onScrolled(p0, p1, p2);
                    BuiltInFictitiousFunctionClassFactory = ActivityReactionsListFragment.this.BuiltInFictitiousFunctionClassFactory();
                    if (BuiltInFictitiousFunctionClassFactory) {
                        ActivityReactionsContract.Presenter presenter3 = ActivityReactionsListFragment.this.activityReactionsPresenter;
                        if (presenter3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            presenter3 = null;
                        }
                        str = ActivityReactionsListFragment.this.MyBillsEntityDataFactory;
                        reactionCountModel = ActivityReactionsListFragment.this.getAuthRequestContext;
                        presenter3.PlaceComponentResult(str, reactionCountModel.PlaceComponentResult);
                    }
                }
            });
        }
        ViewActivityReactionsListBinding binding4 = getBinding();
        TextView textView = binding4 != null ? binding4.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        if (textView != null) {
            String upperCase = this.PlaceComponentResult.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            textView.setText(upperCase);
        }
        ActivityReactionsContract.Presenter presenter3 = this.activityReactionsPresenter;
        if (presenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter3 = null;
        }
        presenter3.PlaceComponentResult(this.getAuthRequestContext.getKClassImpl$Data$declaredNonStaticMembers$2());
        ActivityReactionsContract.Presenter presenter4 = this.activityReactionsPresenter;
        if (presenter4 != null) {
            presenter2 = presenter4;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter2.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}

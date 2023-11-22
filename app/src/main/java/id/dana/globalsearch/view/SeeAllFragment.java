package id.dana.globalsearch.view;

import android.content.Intent;
import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.alibaba.ariver.kernel.RVEvents;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.globalsearch.AbstractGlobalSearchView;
import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.data.util.NetworkUtils;
import id.dana.databinding.FragmentSeeAllBinding;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.eventbus.models.TimerEvent;
import id.dana.explore.domain.globalsearch.model.GlobalSearchConfig;
import id.dana.extension.lang.StringExtKt;
import id.dana.globalsearch.basecategory.CategoryVerticalView;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.globalsearch.model.SearchResultModel;
import id.dana.globalsearch.view.widget.GlobalSearchErrorStateView;
import id.dana.lib.gcontainer.GContainer;
import id.dana.richview.globalsearch.ToolbarGlobalSearchView;
import id.dana.utils.TextUtil;
import id.dana.utils.UrlUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001.B\u0007¢\u0006\u0004\b-\u0010\nJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0010\u0010\nJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u000b\u0010\u0014J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0007\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0019J)\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u001bJ\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\nJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u000b\u0010\u001eJ\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\bJ\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\nR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010!R\u0013\u0010\u0007\u001a\u00020\"X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u000b\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010!R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,"}, d2 = {"Lid/dana/globalsearch/view/SeeAllFragment;", "Lid/dana/contract/globalsearch/AbstractGlobalSearchView;", "Lid/dana/databinding/FragmentSeeAllBinding;", "Lid/dana/contract/globalsearch/GlobalSearchContract$View;", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "dismissProgress", "()V", "PlaceComponentResult", "()Lid/dana/contract/globalsearch/GlobalSearchContract$View;", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "Lid/dana/globalsearch/model/SearchResultModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/globalsearch/model/SearchResultModel;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "lookAheadTest", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "p1", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;Ljava/lang/String;)V", "p2", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/eventbus/models/TimerEvent;", "", "(Lid/dana/eventbus/models/TimerEvent;J)V", "MyBillsEntityDataFactory", "showProgress", "Ljava/lang/String;", "Lid/dana/dialog/DanaLoadingDialog;", "scheduleImpl", "Lkotlin/Lazy;", "", "initRecordTimeStamp", "Z", "moveToNextValue", "", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ljava/util/List;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SeeAllFragment extends AbstractGlobalSearchView<FragmentSeeAllBinding> implements GlobalSearchContract.View {
    public Map<Integer, View> getErrorConfigVersion = new LinkedHashMap();

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    String BuiltInFictitiousFunctionClassFactory = "";

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    String MyBillsEntityDataFactory = "";

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.globalsearch.view.SeeAllFragment$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(SeeAllFragment.this.getBaseActivity());
        }
    });

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean PlaceComponentResult = true;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final List<PaySearchInfoModel> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void BuiltInFictitiousFunctionClassFactory(SearchResultModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(String str) {
        GlobalSearchContract.View.CC.PlaceComponentResult(str);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(SearchResultModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(List list) {
        Intrinsics.checkNotNullParameter(list, "");
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void MyBillsEntityDataFactory() {
        GlobalSearchContract.View.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void MyBillsEntityDataFactory(GlobalSearchConfig globalSearchConfig) {
        GlobalSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory(globalSearchConfig);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void MyBillsEntityDataFactory(SearchResultModel searchResultModel) {
        GlobalSearchContract.View.CC.getAuthRequestContext(searchResultModel);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void MyBillsEntityDataFactory(List list) {
        GlobalSearchContract.View.CC.PlaceComponentResult(list);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void MyBillsEntityDataFactory(boolean z) {
        GlobalSearchContract.View.CC.getAuthRequestContext();
    }

    @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker
    public final void PlaceComponentResult(TimerEvent p0, long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void PlaceComponentResult(SearchResultModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void PlaceComponentResult(String str) {
        GlobalSearchContract.View.CC.MyBillsEntityDataFactory(str);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void PlaceComponentResult(List list) {
        GlobalSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory(list);
    }

    @Override // id.dana.contract.globalsearch.AbstractGlobalSearchView, id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.getErrorConfigVersion.clear();
    }

    @Override // id.dana.contract.globalsearch.AbstractGlobalSearchView, id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.getErrorConfigVersion;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void getAuthRequestContext(List list) {
        GlobalSearchContract.View.CC.MyBillsEntityDataFactory(list);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void getAuthRequestContext(boolean z) {
        GlobalSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_see_all;
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void lookAheadTest() {
        GlobalSearchContract.View.CC.lookAheadTest();
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void lookAheadTest(SearchResultModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void moveToNextValue() {
        GlobalSearchContract.View.CC.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    @Override // id.dana.contract.globalsearch.AbstractGlobalSearchView, id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void scheduleImpl() {
        GlobalSearchContract.View.CC.moveToNextValue();
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void scheduleImpl(SearchResultModel searchResultModel) {
        GlobalSearchContract.View.CC.moveToNextValue(searchResultModel);
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentSeeAllBinding MyBillsEntityDataFactory = FragmentSeeAllBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        CategoryVerticalView categoryVerticalView;
        ToolbarGlobalSearchView toolbarGlobalSearchView;
        l_().MyBillsEntityDataFactory(this);
        registerPresenter(k_(), j_(), h_(), i_(), NetworkUserEntityData$$ExternalSyntheticLambda0());
        FragmentSeeAllBinding fragmentSeeAllBinding = (FragmentSeeAllBinding) getBinding();
        if (fragmentSeeAllBinding != null && (toolbarGlobalSearchView = fragmentSeeAllBinding.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
            toolbarGlobalSearchView.setMenuButtonListener();
            toolbarGlobalSearchView.setListener(new ToolbarGlobalSearchView.Listener() { // from class: id.dana.globalsearch.view.SeeAllFragment$initToolbar$1$1
                @Override // id.dana.richview.globalsearch.ToolbarGlobalSearchView.Listener
                public final void MyBillsEntityDataFactory() {
                }

                @Override // id.dana.richview.globalsearch.ToolbarGlobalSearchView.Listener
                public final void MyBillsEntityDataFactory(CharSequence p0) {
                }

                @Override // id.dana.richview.globalsearch.ToolbarGlobalSearchView.Listener
                public final void getAuthRequestContext() {
                    SeeAllFragment.this.requireActivity().onBackPressed();
                }

                @Override // id.dana.richview.globalsearch.ToolbarGlobalSearchView.Listener
                public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    Intent intent = new Intent();
                    intent.putExtra(SeeAllActivity.GLOBAL_SEARCH_KEYWORD, p0);
                    SeeAllFragment.this.requireActivity().setResult(29, intent);
                    SeeAllFragment.this.requireActivity().finish();
                }

                @Override // id.dana.richview.globalsearch.ToolbarGlobalSearchView.Listener
                public final void BuiltInFictitiousFunctionClassFactory() {
                    SeeAllFragment.this.requireActivity().onBackPressed();
                }
            });
        }
        FragmentSeeAllBinding fragmentSeeAllBinding2 = (FragmentSeeAllBinding) getBinding();
        if (fragmentSeeAllBinding2 != null && (categoryVerticalView = fragmentSeeAllBinding2.MyBillsEntityDataFactory) != null) {
            categoryVerticalView.setLoadMoreCallback(new Function0<Unit>() { // from class: id.dana.globalsearch.view.SeeAllFragment$setupList$1$1
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
                    GlobalSearchContract.Presenter k_;
                    String str;
                    String str2;
                    k_ = SeeAllFragment.this.k_();
                    str = SeeAllFragment.this.BuiltInFictitiousFunctionClassFactory;
                    str2 = SeeAllFragment.this.MyBillsEntityDataFactory;
                    k_.getAuthRequestContext(str, str2);
                }
            });
            categoryVerticalView.setItemClickCallback(new Function1<Integer, Unit>() { // from class: id.dana.globalsearch.view.SeeAllFragment$setupList$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    List list;
                    list = SeeAllFragment.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (!(i < list.size())) {
                        list = null;
                    }
                    if (list != null) {
                        SeeAllFragment seeAllFragment = SeeAllFragment.this;
                        PaySearchInfoModel paySearchInfoModel = (PaySearchInfoModel) list.get(i);
                        SeeAllFragment.BuiltInFictitiousFunctionClassFactory(seeAllFragment, paySearchInfoModel.getAuthRequestContext, paySearchInfoModel);
                    }
                }
            });
        }
        k_().getErrorConfigVersion();
    }

    @Override // id.dana.contract.globalsearch.AbstractGlobalSearchView
    public final GlobalSearchContract.View PlaceComponentResult() {
        return this;
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void getAuthRequestContext(SearchResultModel p0) {
        CategoryVerticalView categoryVerticalView;
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.addAll(p0.getAuthRequestContext);
        FragmentSeeAllBinding fragmentSeeAllBinding = (FragmentSeeAllBinding) getBinding();
        if (fragmentSeeAllBinding == null || (categoryVerticalView = fragmentSeeAllBinding.MyBillsEntityDataFactory) == null) {
            return;
        }
        categoryVerticalView.setDataSeeAll(p0, this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void getAuthRequestContext(ThirdPartyServiceResponse p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (UrlUtil.getErrorConfigVersion(p1)) {
            getErrorConfigVersion().MyBillsEntityDataFactory(p1);
            return;
        }
        String authRequestContext = UrlUtil.getAuthRequestContext(p1);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        KClassImpl$Data$declaredNonStaticMembers$2(p0, authRequestContext, null, null);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void PlaceComponentResult(ThirdPartyServiceResponse p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String authRequestContext = UrlUtil.getAuthRequestContext(p1);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        KClassImpl$Data$declaredNonStaticMembers$2(p0, authRequestContext, p2, g_().getDeviceUUID());
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        ToolbarGlobalSearchView toolbarGlobalSearchView;
        Intrinsics.checkNotNullParameter(p0, "");
        FragmentSeeAllBinding fragmentSeeAllBinding = (FragmentSeeAllBinding) getBinding();
        if (fragmentSeeAllBinding == null || (toolbarGlobalSearchView = fragmentSeeAllBinding.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        toolbarGlobalSearchView.showKeyword(p0);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void BuiltInFictitiousFunctionClassFactory() {
        MyBillsEntityDataFactory("success");
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        CategoryVerticalView categoryVerticalView;
        if (this.PlaceComponentResult) {
            this.PlaceComponentResult = false;
            DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) this.getAuthRequestContext.getValue();
            if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                return;
            }
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
            return;
        }
        FragmentSeeAllBinding fragmentSeeAllBinding = (FragmentSeeAllBinding) getBinding();
        if (fragmentSeeAllBinding == null || (categoryVerticalView = fragmentSeeAllBinding.MyBillsEntityDataFactory) == null) {
            return;
        }
        categoryVerticalView.showLoadMoreShimmer();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String str) {
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        if (!NetworkUtils.isNetworkAvailable(baseActivity)) {
            MyBillsEntityDataFactory("002");
        } else if (str != null) {
            MyBillsEntityDataFactory(str);
        }
    }

    private final void MyBillsEntityDataFactory(String p0) {
        final GlobalSearchErrorStateView globalSearchErrorStateView;
        FragmentSeeAllBinding fragmentSeeAllBinding = (FragmentSeeAllBinding) getBinding();
        if (fragmentSeeAllBinding == null || (globalSearchErrorStateView = fragmentSeeAllBinding.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        globalSearchErrorStateView.setVisibility(0);
        globalSearchErrorStateView.setErrorState(p0);
        globalSearchErrorStateView.setTryAgainClickListener(new Function0<Unit>() { // from class: id.dana.globalsearch.view.SeeAllFragment$showErrorState$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                GlobalSearchContract.Presenter k_;
                String str;
                String str2;
                GlobalSearchErrorStateView globalSearchErrorStateView2 = GlobalSearchErrorStateView.this;
                Intrinsics.checkNotNullExpressionValue(globalSearchErrorStateView2, "");
                globalSearchErrorStateView2.setVisibility(8);
                k_ = this.k_();
                str = this.BuiltInFictitiousFunctionClassFactory;
                str2 = this.MyBillsEntityDataFactory;
                k_.getAuthRequestContext(str, str2);
            }
        });
    }

    private final void getAuthRequestContext(String p0) {
        if (p0 != null) {
            if (StringsKt.contains$default((CharSequence) StringExtKt.PlaceComponentResult(p0), (CharSequence) DanaUrl.DEEPLINK_URL, false, 2, (Object) null)) {
                ReadLinkPropertiesContract.Presenter errorConfigVersion = getErrorConfigVersion();
                String PlaceComponentResult = TextUtil.PlaceComponentResult(p0, "");
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                errorConfigVersion.MyBillsEntityDataFactory(PlaceComponentResult);
            } else if (GContainer.isOpeningH5()) {
            } else {
                String authRequestContext = UrlUtil.getAuthRequestContext(p0);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                DanaH5.startContainerFullUrl(authRequestContext);
            }
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SeeAllFragment seeAllFragment, String str, PaySearchInfoModel paySearchInfoModel) {
        int hashCode = str.hashCode();
        if (hashCode != -1592831339) {
            if (hashCode != -667013580) {
                if (hashCode == 1016896708 && str.equals("OFFLINE_MERCHANT")) {
                    GlobalSearchBottomSheetDialog globalSearchBottomSheetDialog = new GlobalSearchBottomSheetDialog();
                    Intrinsics.checkNotNullParameter(paySearchInfoModel, "");
                    globalSearchBottomSheetDialog.getAuthRequestContext = paySearchInfoModel;
                    globalSearchBottomSheetDialog.show(seeAllFragment.getBaseActivity().getSupportFragmentManager(), "Show Nearby Bottom Sheet for Global Search");
                    return;
                }
            } else if (str.equals("ONLINE_MERCHANT")) {
                seeAllFragment.getAuthRequestContext(paySearchInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda7.get("REDIRECT_URL"));
                return;
            }
        } else if (str.equals("SERVICE")) {
            BaseActivity baseActivity = seeAllFragment.getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity, "");
            if (NetworkUtils.isNetworkAvailable(baseActivity)) {
                seeAllFragment.k_().getAuthRequestContext(paySearchInfoModel);
                return;
            } else {
                seeAllFragment.getBaseActivity().showWarningDialog(seeAllFragment.getString(R.string.global_search_error_message_dialog));
                return;
            }
        }
        seeAllFragment.getAuthRequestContext(paySearchInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda7.get("DETAIL"));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        CategoryVerticalView categoryVerticalView;
        ((DanaLoadingDialog) this.getAuthRequestContext.getValue()).PlaceComponentResult();
        FragmentSeeAllBinding fragmentSeeAllBinding = (FragmentSeeAllBinding) getBinding();
        if (fragmentSeeAllBinding == null || (categoryVerticalView = fragmentSeeAllBinding.MyBillsEntityDataFactory) == null) {
            return;
        }
        categoryVerticalView.hideLoadMoreShimmer();
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void getAuthRequestContext() {
        getBaseActivity().showWarningDialog(getString(R.string.global_search_error_message_dialog));
    }
}

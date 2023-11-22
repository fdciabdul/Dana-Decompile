package id.dana.tutorial;

import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.view.GridItemDecoration;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseFragment;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerTutorialComponent;
import id.dana.di.modules.DanaTutorialModule;
import id.dana.di.modules.OauthModule;
import id.dana.model.ThirdPartyService;
import id.dana.tutorial.TutorialContract;
import id.dana.tutorial.adapter.TutorialAdapter;
import id.dana.tutorial.model.TutorialModel;
import id.dana.utils.UrlUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0012\u0010\t\u001a\u00020\bX\u0087\"¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0015\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\u0012X\u0087\"¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/tutorial/TutorialFragment;", "Lid/dana/base/BaseFragment;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readDeepLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "Lcom/ethanhua/skeleton/RecyclerViewSkeletonScreen;", "PlaceComponentResult", "Lkotlin/Lazy;", "Lid/dana/tutorial/adapter/TutorialAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/tutorial/adapter/TutorialAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/tutorial/TutorialContract$Presenter;", "tutorialPresenter", "Lid/dana/tutorial/TutorialContract$Presenter;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class TutorialFragment extends BaseFragment {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private TutorialAdapter BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<RecyclerViewSkeletonScreen>() { // from class: id.dana.tutorial.TutorialFragment$skeletonScreen$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RecyclerViewSkeletonScreen invoke() {
            TutorialAdapter tutorialAdapter;
            TutorialAdapter tutorialAdapter2 = null;
            if (((RecyclerView) TutorialFragment.this.MyBillsEntityDataFactory(R.id.getSupportsPasswordLogin)) != null) {
                TutorialFragment tutorialFragment = TutorialFragment.this;
                RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((RecyclerView) tutorialFragment.MyBillsEntityDataFactory(R.id.getSupportsPasswordLogin));
                tutorialAdapter = tutorialFragment.BuiltInFictitiousFunctionClassFactory;
                if (tutorialAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    tutorialAdapter2 = tutorialAdapter;
                }
                BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = tutorialAdapter2;
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = TutorialFragment.BuiltInFictitiousFunctionClassFactory(tutorialFragment);
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.tutorial_item_skeleton;
                BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
                BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
                BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
                RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
                recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
                return recyclerViewSkeletonScreen;
            }
            return null;
        }
    });
    @Inject
    public ReadLinkPropertiesContract.Presenter readDeepLinkPropertiesPresenter;
    @Inject
    public TutorialContract.Presenter tutorialPresenter;

    public final View MyBillsEntityDataFactory(int i) {
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
        return R.layout.fragment_tutorial;
    }

    public static /* synthetic */ void getAuthRequestContext(TutorialFragment tutorialFragment, int i) {
        Intrinsics.checkNotNullParameter(tutorialFragment, "");
        TutorialAdapter tutorialAdapter = tutorialFragment.BuiltInFictitiousFunctionClassFactory;
        ReadLinkPropertiesContract.Presenter presenter = null;
        if (tutorialAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            tutorialAdapter = null;
        }
        String str = tutorialAdapter.getItem(i).MyBillsEntityDataFactory;
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://m.dana.id/m/standalone/news-tutorial?contentId=");
            sb.append(str);
            String obj = sb.toString();
            if (!UrlUtil.getErrorConfigVersion(obj)) {
                DanaH5.startContainerFullUrl(obj);
                return;
            }
            ReadLinkPropertiesContract.Presenter presenter2 = tutorialFragment.readDeepLinkPropertiesPresenter;
            if (presenter2 != null) {
                presenter = presenter2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            presenter.MyBillsEntityDataFactory(obj);
        }
    }

    public static final /* synthetic */ int BuiltInFictitiousFunctionClassFactory(TutorialFragment tutorialFragment) {
        return (tutorialFragment.getResources().getDisplayMetrics().heightPixels / ((int) (tutorialFragment.getResources().getDisplayMetrics().density * 184.0f))) * 2;
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(TutorialFragment tutorialFragment) {
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = (RecyclerViewSkeletonScreen) tutorialFragment.PlaceComponentResult.getValue();
        if (recyclerViewSkeletonScreen != null) {
            recyclerViewSkeletonScreen.MyBillsEntityDataFactory.setAdapter(recyclerViewSkeletonScreen.getAuthRequestContext);
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        DaggerTutorialComponent.Builder PlaceComponentResult = DaggerTutorialComponent.PlaceComponentResult();
        PlaceComponentResult.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.tutorial.TutorialFragment$setupInjection$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionFailed(String str) {
                ServicesContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
                ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                ServicesContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onEmptySearchService() {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onFeatureServices(List list) {
                ServicesContract.View.CC.PlaceComponentResult(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetThirdPartyServices(List list) {
                ServicesContract.View.CC.getAuthRequestContext(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onShowTooltip(boolean z) {
                ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }
        }));
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = getBaseActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = TrackerKey.SourceType.DANA_NEWS;
        byte b = 0;
        PlaceComponentResult.PlaceComponentResult = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getBaseActivity();
        PlaceComponentResult.lookAheadTest = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = getBaseActivity();
        PlaceComponentResult.moveToNextValue = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
        PlaceComponentResult.MyBillsEntityDataFactory = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (DanaTutorialModule) Preconditions.getAuthRequestContext(new DanaTutorialModule(new TutorialContract.View() { // from class: id.dana.tutorial.TutorialFragment$setupInjection$2
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

            @Override // id.dana.tutorial.TutorialContract.View
            public final void MyBillsEntityDataFactory(List<TutorialModel> p0) {
                TutorialAdapter tutorialAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                TutorialFragment.MyBillsEntityDataFactory(TutorialFragment.this);
                tutorialAdapter = TutorialFragment.this.BuiltInFictitiousFunctionClassFactory;
                if (tutorialAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    tutorialAdapter = null;
                }
                tutorialAdapter.setItems(p0);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, DanaTutorialModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.PlaceComponentResult, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.lookAheadTest, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.moveToNextValue, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.MyBillsEntityDataFactory, OauthModule.class);
        if (PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getAuthRequestContext, ApplicationComponent.class);
        new DaggerTutorialComponent.TutorialComponentImpl(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult.PlaceComponentResult, PlaceComponentResult.lookAheadTest, PlaceComponentResult.moveToNextValue, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult.MyBillsEntityDataFactory, PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0, PlaceComponentResult.getAuthRequestContext, (byte) 0).MyBillsEntityDataFactory(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[2];
        TutorialContract.Presenter presenter = this.tutorialPresenter;
        TutorialContract.Presenter presenter2 = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        ReadLinkPropertiesContract.Presenter presenter3 = this.readDeepLinkPropertiesPresenter;
        if (presenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter3 = null;
        }
        abstractPresenterArr[1] = presenter3;
        registerPresenter(abstractPresenterArr);
        this.BuiltInFictitiousFunctionClassFactory = new TutorialAdapter();
        RecyclerView recyclerView = (RecyclerView) MyBillsEntityDataFactory(R.id.getSupportsPasswordLogin);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }
        RecyclerView recyclerView2 = (RecyclerView) MyBillsEntityDataFactory(R.id.getSupportsPasswordLogin);
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new GridItemDecoration(getContext(), 2, 8));
        }
        TutorialAdapter tutorialAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (tutorialAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            tutorialAdapter = null;
        }
        tutorialAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.tutorial.TutorialFragment$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                TutorialFragment.getAuthRequestContext(TutorialFragment.this, i);
            }
        });
        RecyclerView recyclerView3 = (RecyclerView) MyBillsEntityDataFactory(R.id.getSupportsPasswordLogin);
        if (recyclerView3 != null) {
            TutorialAdapter tutorialAdapter2 = this.BuiltInFictitiousFunctionClassFactory;
            if (tutorialAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                tutorialAdapter2 = null;
            }
            recyclerView3.setAdapter(tutorialAdapter2);
        }
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = (RecyclerViewSkeletonScreen) this.PlaceComponentResult.getValue();
        if (recyclerViewSkeletonScreen != null) {
            recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        }
        TutorialContract.Presenter presenter4 = this.tutorialPresenter;
        if (presenter4 != null) {
            presenter2 = presenter4;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter2.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory.clear();
    }
}

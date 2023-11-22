package id.dana.notificationcenter.views;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseWithToolbarFragment;
import id.dana.base.SingleItemClickListener;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerNotificationCenterComponent;
import id.dana.di.component.NotificationCenterComponent;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.NotificationCenterModule;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.lazada.LazadaGuideActivity;
import id.dana.lib.gcontainer.GContainer;
import id.dana.model.ThirdPartyService;
import id.dana.notificationcenter.NotificationAdapter;
import id.dana.notificationcenter.NotificationCenterContract;
import id.dana.notificationcenter.model.NotificationCenter;
import id.dana.notificationcenter.model.NotificationDTO;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewContractView;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.danah5.DanaH5Listener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public class NotificationCenterFragment extends BaseWithToolbarFragment implements NotificationCenterContract.View {
    String KClassImpl$Data$declaredNonStaticMembers$2;
    String MyBillsEntityDataFactory;
    private NotificationAdapter NetworkUserEntityData$$ExternalSyntheticLambda0;
    boolean PlaceComponentResult;
    @Inject
    CheckoutH5EventContract.Presenter checkoutH5EventPresenter;
    @Inject
    DynamicUrlWrapper dynamicUrlWrapper;
    @Inject
    FeatureContract.Presenter featurePresenter;
    private boolean getErrorConfigVersion = false;
    private NotificationCenterComponent lookAheadTest;
    private DanaH5Listener moveToNextValue;
    @Inject
    PlayStoreReviewContract.Presenter playStoreReviewPresenter;
    @Inject
    NotificationCenterContract.Presenter presenter;
    @BindView(R.id.f4080progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.notication_center_rcview)
    RecyclerView rcNotifications;
    @Inject
    ReadLinkPropertiesContract.Presenter readDeepLinkPropertiesPresenter;
    @BindView(R.id.refresh_notification)
    SwipeRefreshLayout refreshNotification;
    @Inject
    RestoreUrlContract.Presenter restoreUrlPresenter;
    @Inject
    ScanQrContract.Presenter scanQrPresenter;
    private String scheduleImpl;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface State {
        public static final String APPEND = "0";
        public static final String PREPEND = "1";
    }

    @Override // id.dana.base.BaseFragment
    public int getLayout() {
        return R.layout.fragment_notification_center;
    }

    public static NotificationCenterFragment BuiltInFictitiousFunctionClassFactory() {
        return new NotificationCenterFragment();
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
        this.progressBar.setVisibility(0);
        this.refreshNotification.setVisibility(8);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
        this.refreshNotification.setRefreshing(false);
        this.progressBar.setVisibility(8);
        this.refreshNotification.setVisibility(0);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
        dismissProgress();
    }

    @Override // id.dana.base.BaseFragment
    public void init() {
        String string = getResources().getString(R.string.notification_center);
        TextView textView = this.toolbarTitle;
        if (textView != null) {
            textView.setText(string);
        }
        MyBillsEntityDataFactory(R.drawable.btn_arrow_left);
        byte b = 0;
        if (this.lookAheadTest == null) {
            DaggerNotificationCenterComponent.Builder MyBillsEntityDataFactory = DaggerNotificationCenterComponent.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            MyBillsEntityDataFactory.getAuthRequestContext = (NotificationCenterModule) Preconditions.getAuthRequestContext(new NotificationCenterModule(this));
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CheckoutH5EventModule) Preconditions.getAuthRequestContext(new CheckoutH5EventModule(new CheckoutH5EventContract.View() { // from class: id.dana.notificationcenter.views.NotificationCenterFragment$$ExternalSyntheticLambda1
                @Override // id.dana.h5event.CheckoutH5EventContract.View
                public final void getAuthRequestContext(boolean z) {
                    NotificationCenterFragment.this.PlaceComponentResult = z;
                }
            }));
            MyBillsEntityDataFactory.moveToNextValue = (PlayStoreReviewModules) Preconditions.getAuthRequestContext(new PlayStoreReviewModules(new PlayStoreReviewContractView(getActivity())));
            MyBillsEntityDataFactory.lookAheadTest = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.notificationcenter.views.NotificationCenterFragment.2
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onActionFailed(String str) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
                    ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                    ServicesContract.View.CC.PlaceComponentResult();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
                    Intrinsics.checkNotNullParameter(thirdPartyService, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onEmptySearchService() {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onFeatureServices(List list) {
                    ServicesContract.View.CC.PlaceComponentResult(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onGetInitThirdPartyServices(List list) {
                    Intrinsics.checkNotNullParameter(list, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onGetThirdPartyServices(List list) {
                    ServicesContract.View.CC.getAuthRequestContext(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public /* synthetic */ void onShowTooltip(boolean z) {
                    ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }
            }));
            DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = getBaseActivity();
            if (this.moveToNextValue == null) {
                this.moveToNextValue = new AnonymousClass3();
            }
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = this.moveToNextValue;
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = "Notification";
            MyBillsEntityDataFactory.PlaceComponentResult = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
            ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
            authRequestContext.MyBillsEntityDataFactory = getBaseActivity();
            if (this.moveToNextValue == null) {
                this.moveToNextValue = new AnonymousClass3();
            }
            authRequestContext.getAuthRequestContext = this.moveToNextValue;
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
            RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = getBaseActivity();
            if (this.moveToNextValue == null) {
                this.moveToNextValue = new AnonymousClass3();
            }
            KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = this.moveToNextValue;
            MyBillsEntityDataFactory.scheduleImpl = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
            FeatureModule.Builder MyBillsEntityDataFactory2 = FeatureModule.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
            MyBillsEntityDataFactory.MyBillsEntityDataFactory = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory2, b));
            OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
            MyBillsEntityDataFactory.getErrorConfigVersion = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, NotificationCenterModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult, DeepLinkModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, ScanQrModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.scheduleImpl, RestoreUrlModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, FeatureModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getErrorConfigVersion, OauthModule.class);
            if (MyBillsEntityDataFactory.lookAheadTest == null) {
                MyBillsEntityDataFactory.lookAheadTest = new ServicesModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.moveToNextValue, PlayStoreReviewModules.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, CheckoutH5EventModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            this.lookAheadTest = new DaggerNotificationCenterComponent.NotificationCenterComponentImpl(MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.PlaceComponentResult, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, MyBillsEntityDataFactory.scheduleImpl, MyBillsEntityDataFactory.MyBillsEntityDataFactory, MyBillsEntityDataFactory.getErrorConfigVersion, MyBillsEntityDataFactory.lookAheadTest, MyBillsEntityDataFactory.moveToNextValue, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, (byte) 0);
        }
        this.lookAheadTest.MyBillsEntityDataFactory(this);
        registerPresenter(this.presenter, this.readDeepLinkPropertiesPresenter, this.scanQrPresenter, this.restoreUrlPresenter, this.featurePresenter);
        this.refreshNotification.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: id.dana.notificationcenter.views.NotificationCenterFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void MyBillsEntityDataFactory() {
                NotificationCenterFragment notificationCenterFragment = NotificationCenterFragment.this;
                notificationCenterFragment.presenter.getAuthRequestContext(100, null, notificationCenterFragment.KClassImpl$Data$declaredNonStaticMembers$2);
                notificationCenterFragment.MyBillsEntityDataFactory = "1";
            }
        });
    }

    @Override // id.dana.base.BaseFragment
    public void onUnSelected() {
        dismissProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setItems(Collections.emptyList());
        super.onUnSelected();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: id.dana.notificationcenter.views.NotificationCenterFragment$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 implements DanaH5Listener {
        @Override // id.dana.utils.danah5.DanaH5Listener
        public void onContainerCreated(Bundle bundle) {
        }

        AnonymousClass3() {
        }

        @Override // id.dana.utils.danah5.DanaH5Listener
        public void onContainerDestroyed(Bundle bundle) {
            if (NotificationCenterFragment.this.checkoutH5EventPresenter != null) {
                NotificationCenterFragment.this.checkoutH5EventPresenter.BuiltInFictitiousFunctionClassFactory();
            }
            if (NotificationCenterFragment.this.PlaceComponentResult) {
                NotificationCenterFragment.this.playStoreReviewPresenter.PlaceComponentResult();
            }
        }
    }

    @Override // id.dana.notificationcenter.NotificationCenterContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(NotificationCenter notificationCenter) {
        List<NotificationDTO> list;
        dismissProgress();
        this.getErrorConfigVersion = true;
        if (notificationCenter == null || (list = notificationCenter.BuiltInFictitiousFunctionClassFactory) == null || list.isEmpty()) {
            return;
        }
        if ("1".equals(this.MyBillsEntityDataFactory)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.prependItems(list);
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.appendItems(list);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2 = notificationCenter.BuiltInFictitiousFunctionClassFactory();
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getItem(0).PlaceComponentResult;
        this.scheduleImpl = notificationCenter.getAuthRequestContext;
    }

    @Override // id.dana.notificationcenter.NotificationCenterContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        dismissProgress();
        this.getErrorConfigVersion = true;
    }

    @Override // id.dana.base.BaseWithToolbarFragment
    public void onClickLeftMenuButton(View view) {
        getBaseActivity().onBackPressed();
    }

    static /* synthetic */ void getAuthRequestContext(NotificationCenterFragment notificationCenterFragment, int i) {
        NotificationDTO item;
        int itemViewType = notificationCenterFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.getItemViewType(i);
        byte b = 0;
        if (itemViewType == 2) {
            if (notificationCenterFragment.getErrorConfigVersion) {
                notificationCenterFragment.getErrorConfigVersion = false;
                notificationCenterFragment.presenter.getAuthRequestContext(10, notificationCenterFragment.scheduleImpl, null);
                notificationCenterFragment.MyBillsEntityDataFactory = "0";
            }
            notificationCenterFragment.enableClick();
        } else if (itemViewType != 1 || GContainer.isOpeningH5() || (item = notificationCenterFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.getItem(i)) == null) {
        } else {
            item.getAuthRequestContext = notificationCenterFragment.dynamicUrlWrapper;
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(notificationCenterFragment.getContext().getApplicationContext());
            builder.MyBillsEntityDataFactory = "Notification Inbox Read";
            EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerDataKey.NotificationInboxProperty.NOTIFICATION_ID, item.PlaceComponentResult).MyBillsEntityDataFactory(TrackerDataKey.NotificationInboxProperty.REDIRECT_TYPE, item.lookAheadTest).MyBillsEntityDataFactory(TrackerDataKey.NotificationInboxProperty.REDIRECT_VALUE, item.getAuthRequestContext()).MyBillsEntityDataFactory(TrackerDataKey.NotificationInboxProperty.ICON_URL, item.KClassImpl$Data$declaredNonStaticMembers$2);
            MyBillsEntityDataFactory.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, b));
            if (!item.PlaceComponentResult()) {
                item.getErrorConfigVersion = true;
                notificationCenterFragment.presenter.BuiltInFictitiousFunctionClassFactory(item.PlaceComponentResult, item.getAuthRequestContext());
            }
            if (!MyBillsEntityDataFactory(item)) {
                notificationCenterFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.notifyItemChanged(i);
                String authRequestContext = item.getAuthRequestContext();
                if (authRequestContext.trim().contains(DanaUrl.DEEPLINK_URL)) {
                    notificationCenterFragment.readDeepLinkPropertiesPresenter.MyBillsEntityDataFactory(authRequestContext);
                    return;
                }
                if (notificationCenterFragment.moveToNextValue == null) {
                    notificationCenterFragment.moveToNextValue = new AnonymousClass3();
                }
                DanaH5.startContainerFullUrl(authRequestContext, notificationCenterFragment.moveToNextValue);
                notificationCenterFragment.checkoutH5EventPresenter.MyBillsEntityDataFactory();
                notificationCenterFragment.PlaceComponentResult = false;
                return;
            }
            notificationCenterFragment.getBaseActivity().onBackPressed();
            notificationCenterFragment.getBaseActivity().startActivity(LazadaGuideActivity.createIntent(notificationCenterFragment.getBaseActivity()));
        }
    }

    private static boolean MyBillsEntityDataFactory(NotificationDTO notificationDTO) {
        return "ipgRegistration".equals(notificationDTO.lookAheadTest) && "lazada".equals(notificationDTO.moveToNextValue);
    }

    @Override // id.dana.base.BaseFragment
    public void onSelected() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new NotificationAdapter(this.dynamicUrlWrapper);
        this.rcNotifications.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rcNotifications.setAdapter(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setOnItemClickListener(new SingleItemClickListener(getBaseActivity()) { // from class: id.dana.notificationcenter.views.NotificationCenterFragment.1
            @Override // id.dana.base.SingleItemClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                NotificationCenterFragment.getAuthRequestContext(NotificationCenterFragment.this, i);
            }
        });
        NotificationCenterContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            presenter.getAuthRequestContext(10, null, null);
            this.MyBillsEntityDataFactory = "0";
        }
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext().getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerDataKey.Event.INBOX_PAGE_OPEN;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
        super.onSelected();
    }
}

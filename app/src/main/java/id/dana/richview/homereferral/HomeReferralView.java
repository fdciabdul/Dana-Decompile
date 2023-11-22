package id.dana.richview.homereferral;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.OnClick;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.RoundedCornersTransformation;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRichView;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.promoquest.quest.MissionSummaryContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.core.ui.glide.GlideApp;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerHomeReferralComponent;
import id.dana.di.component.HomeReferralComponent;
import id.dana.di.modules.HomeReferralModule;
import id.dana.di.modules.MissionSummaryModule;
import id.dana.di.modules.OauthModule;
import id.dana.model.ReferralStatus;
import id.dana.model.ThirdPartyService;
import id.dana.promoquest.model.MissionModel;
import id.dana.richview.homereferral.HomeReferralContract;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.UrlUtil;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes9.dex */
public class HomeReferralView extends BaseRichView implements HomeReferralContract.View {
    private ReferralStatus BuiltInFictitiousFunctionClassFactory;
    private HomeReferralComponent KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;
    private SkeletonScreen PlaceComponentResult;
    @BindView(R.id.cl_home_referral_container)
    ConstraintLayout clReferralContainer;
    @BindView(R.id.iv_home_referral_banner)
    ImageView ivReferralBanner;
    @Inject
    MissionSummaryContract.Presenter missionSummaryPresenter;
    @Inject
    HomeReferralContract.Presenter presenter;
    @Inject
    ReadLinkPropertiesContract.Presenter readDeepLinkPropertiesPresenter;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_home_referral;
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    public HomeReferralView(Context context) {
        super(context);
    }

    public HomeReferralView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HomeReferralView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public HomeReferralView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        byte b = 0;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            DaggerHomeReferralComponent.Builder MyBillsEntityDataFactory = DaggerHomeReferralComponent.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            MyBillsEntityDataFactory.PlaceComponentResult = (HomeReferralModule) Preconditions.getAuthRequestContext(new HomeReferralModule(this));
            MyBillsEntityDataFactory.getAuthRequestContext = (MissionSummaryModule) Preconditions.getAuthRequestContext(new MissionSummaryModule(new MissionSummaryContract.View() { // from class: id.dana.richview.homereferral.HomeReferralView.3
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.contract.promoquest.quest.MissionSummaryContract.View
                public final void MyBillsEntityDataFactory(List<MissionModel> list, boolean z) {
                    if (z) {
                        HomeReferralView.this.enableEntryPoint(false);
                    } else {
                        HomeReferralView.this.presenter.PlaceComponentResult();
                    }
                }

                @Override // id.dana.contract.promoquest.quest.MissionSummaryContract.View
                public final void getAuthRequestContext() {
                    HomeReferralView.this.presenter.PlaceComponentResult();
                }

                @Override // id.dana.contract.promoquest.quest.MissionSummaryContract.View
                public final void MyBillsEntityDataFactory(boolean z) {
                    if (z) {
                        HomeReferralView.this.missionSummaryPresenter.BuiltInFictitiousFunctionClassFactory();
                    }
                }
            }));
            MyBillsEntityDataFactory.scheduleImpl = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.richview.homereferral.HomeReferralView.1
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
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = TrackerKey.SourceType.REFERRAL;
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
            ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
            authRequestContext.MyBillsEntityDataFactory = getBaseActivity();
            MyBillsEntityDataFactory.lookAheadTest = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
            RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = getBaseActivity();
            MyBillsEntityDataFactory.moveToNextValue = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
            FeatureModule.Builder MyBillsEntityDataFactory2 = FeatureModule.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
            MyBillsEntityDataFactory.MyBillsEntityDataFactory = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory2, b));
            OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
            MyBillsEntityDataFactory.getErrorConfigVersion = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult, HomeReferralModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, DeepLinkModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.lookAheadTest, ScanQrModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.moveToNextValue, RestoreUrlModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, FeatureModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getErrorConfigVersion, OauthModule.class);
            if (MyBillsEntityDataFactory.scheduleImpl == null) {
                MyBillsEntityDataFactory.scheduleImpl = new ServicesModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, MissionSummaryModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new DaggerHomeReferralComponent.HomeReferralComponentImpl(MyBillsEntityDataFactory.PlaceComponentResult, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.lookAheadTest, MyBillsEntityDataFactory.moveToNextValue, MyBillsEntityDataFactory.MyBillsEntityDataFactory, MyBillsEntityDataFactory.getErrorConfigVersion, MyBillsEntityDataFactory.scheduleImpl, MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, (byte) 0);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(this.presenter, this.readDeepLinkPropertiesPresenter, this.missionSummaryPresenter);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.presenter.KClassImpl$Data$declaredNonStaticMembers$2();
        this.missionSummaryPresenter.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
        showSkeleton();
    }

    @Override // id.dana.richview.homereferral.HomeReferralContract.View
    public void onGetReferralStatusConsultSuccess(ReferralStatus referralStatus) {
        if (referralStatus != null) {
            this.BuiltInFictitiousFunctionClassFactory = referralStatus;
        }
    }

    @Override // id.dana.richview.homereferral.HomeReferralContract.View
    public void enableBanner(boolean z) {
        this.ivReferralBanner.setVisibility(z ? 0 : 8);
    }

    @Override // id.dana.richview.homereferral.HomeReferralContract.View
    public void onLoadBanner(String str) {
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new MultiTransformation(new FitCenter(), new RoundedCornersTransformation(getContext().getResources().getDimensionPixelSize(R.dimen.f28142131165293), 1, KClassImpl$Data$declaredNonStaticMembers$2() ? RoundedCornersTransformation.CornerType.TOP : RoundedCornersTransformation.CornerType.ALL))).BuiltInFictitiousFunctionClassFactory(new RequestListener<Drawable>() { // from class: id.dana.richview.homereferral.HomeReferralView.2
            @Override // com.bumptech.glide.request.RequestListener
            public /* bridge */ /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                HomeReferralView.this.enableEntryPoint(false);
                return false;
            }
        }).MyBillsEntityDataFactory(this.ivReferralBanner);
    }

    @Override // id.dana.richview.homereferral.HomeReferralContract.View
    public void saveEntryPointUrl(String str) {
        this.MyBillsEntityDataFactory = str;
    }

    @Override // id.dana.richview.homereferral.HomeReferralContract.View
    public void enableEntryPoint(boolean z) {
        this.clReferralContainer.setVisibility(z ? 0 : 8);
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        ReferralStatus referralStatus = this.BuiltInFictitiousFunctionClassFactory;
        return (referralStatus == null || TextUtils.isEmpty(referralStatus.getAuthRequestContext)) ? false : true;
    }

    public void showSkeleton() {
        SkeletonScreen skeletonScreen = this.PlaceComponentResult;
        if (skeletonScreen == null) {
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(this.clReferralContainer);
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_home_referral_entry_skeleton;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
            ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
            viewSkeletonScreen.MyBillsEntityDataFactory();
            this.PlaceComponentResult = viewSkeletonScreen;
            return;
        }
        skeletonScreen.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
        SkeletonScreen skeletonScreen = this.PlaceComponentResult;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
            this.PlaceComponentResult = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.iv_home_referral_banner})
    public void onBannerClicked() {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getBaseActivity().getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.REFERRAL_BANNER_CLICK;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
        String str = this.MyBillsEntityDataFactory;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.trim().contains(DanaUrl.DEEPLINK_URL)) {
            this.readDeepLinkPropertiesPresenter.MyBillsEntityDataFactory(str);
        } else {
            DanaH5.startContainerFullUrl(UrlUtil.getAuthRequestContext(str));
        }
    }
}

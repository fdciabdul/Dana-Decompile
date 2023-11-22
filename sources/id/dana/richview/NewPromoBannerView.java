package id.dana.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.view.Lifecycle;
import com.alibaba.ariver.kernel.RVEvents;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.animation.adapter.HomeAdapter;
import id.dana.animation.promobanner.NewPromoBannerContract;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.NewViewPromoBannerBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerNewPromoBannerComponent;
import id.dana.di.component.NewPromoBannerComponent;
import id.dana.di.modules.NewPromoBannerModule;
import id.dana.model.CdpContentModel;
import id.dana.model.PromotionModel;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.pushverify.constant.PushVerifyEntryPoint;
import id.dana.pushverify.model.PushVerifyParamsModel;
import id.dana.pushverify.view.verificationdetail.PushVerifyActivity;
import id.dana.tracker.constant.TrackerType;
import id.dana.tracker.mixpanel.TopupSource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 H2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001HB\u0011\b\u0016\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BB\u001b\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u0012\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bA\u0010EB#\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u0012\u0006\u0010F\u001a\u00020\b¢\u0006\u0004\bA\u0010GJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0006J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u0006J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u001d\u0010(\u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0004¢\u0006\u0004\b*\u0010\u0006J\u000f\u0010+\u001a\u00020\u0004H\u0016¢\u0006\u0004\b+\u0010\u0006J\u000f\u0010,\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010\u0006J\u0015\u0010-\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b-\u0010$R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R(\u00104\u001a\b\u0012\u0004\u0012\u000203028\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010/\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b,\u0010:R(\u0010<\u001a\b\u0012\u0004\u0012\u00020;028\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b<\u00105\u001a\u0004\b=\u00107\"\u0004\b>\u00109"}, d2 = {"Lid/dana/richview/NewPromoBannerView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/NewViewPromoBannerBinding;", "Lid/dana/home/promobanner/NewPromoBannerContract$View;", "", "dismissProgress", "()V", "disposeByActivity", "", "getLayout", "()I", "hideBannerSkeleton", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/NewViewPromoBannerBinding;", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "", "isForRecyclerViewholder", "()Z", "notifyFinishCheckSessionWatcher", "Lid/dana/pushverify/model/PushVerifyParamsModel;", "pushVerifyParamsModel", "onActiveVerificationAnnounced", "(Lid/dana/pushverify/model/PushVerifyParamsModel;)V", "", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "onErrorGetPromoBannerWidgetFromPersistence", "Lid/dana/model/PromotionModel;", "promotionModel", "onGetPromoCenterBannerSuccess", "(Lid/dana/model/PromotionModel;)V", "", "Lid/dana/model/CdpContentModel;", "cdpContentModels", "onSuccessGetPromoBannerWidgetFromPersistence", "(Ljava/util/List;)V", "refreshView", "setup", "getAuthRequestContext", "updateBanner", "Lid/dana/di/component/NewPromoBannerComponent;", "MyBillsEntityDataFactory", "Lid/dana/di/component/NewPromoBannerComponent;", "PlaceComponentResult", "Ldagger/Lazy;", "Lid/dana/home/tracker/HomeTrackerImpl;", "homeTrackerImpl", "Ldagger/Lazy;", "getHomeTrackerImpl", "()Ldagger/Lazy;", "setHomeTrackerImpl", "(Ldagger/Lazy;)V", "Z", "Lid/dana/home/promobanner/NewPromoBannerContract$Presenter;", "promoBannerPresenter", "getPromoBannerPresenter", "setPromoBannerPresenter", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewPromoBannerView extends ViewBindingRichView<NewViewPromoBannerBinding> implements NewPromoBannerContract.View {
    public static final int PROMO_CENTER_VERSION_1 = 1;
    public static final int PROMO_CENTER_VERSION_2 = 2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private NewPromoBannerComponent PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    @Inject
    public Lazy<HomeTrackerImpl> homeTrackerImpl;
    @Inject
    public Lazy<NewPromoBannerContract.Presenter> promoBannerPresenter;

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.new_view_promo_banner;
    }

    @Override // id.dana.base.BaseRichView
    public final boolean isForRecyclerViewholder() {
        return true;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewPromoBannerView(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewPromoBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewPromoBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getPromoBannerPresenter")
    public final Lazy<NewPromoBannerContract.Presenter> getPromoBannerPresenter() {
        Lazy<NewPromoBannerContract.Presenter> lazy = this.promoBannerPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPromoBannerPresenter")
    public final void setPromoBannerPresenter(Lazy<NewPromoBannerContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.promoBannerPresenter = lazy;
    }

    @JvmName(name = "getHomeTrackerImpl")
    public final Lazy<HomeTrackerImpl> getHomeTrackerImpl() {
        Lazy<HomeTrackerImpl> lazy = this.homeTrackerImpl;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setHomeTrackerImpl")
    public final void setHomeTrackerImpl(Lazy<HomeTrackerImpl> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.homeTrackerImpl = lazy;
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        Intrinsics.checkNotNullParameter(applicationComponent, "");
        if (this.PlaceComponentResult != null) {
            return;
        }
        DaggerNewPromoBannerComponent.Builder authRequestContext = DaggerNewPromoBannerComponent.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        authRequestContext.getAuthRequestContext = (NewPromoBannerModule) Preconditions.getAuthRequestContext(new NewPromoBannerModule(this));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getAuthRequestContext, NewPromoBannerModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.MyBillsEntityDataFactory, ApplicationComponent.class);
        DaggerNewPromoBannerComponent.NewPromoBannerComponentImpl newPromoBannerComponentImpl = new DaggerNewPromoBannerComponent.NewPromoBannerComponentImpl(authRequestContext.getAuthRequestContext, authRequestContext.MyBillsEntityDataFactory, (byte) 0);
        this.PlaceComponentResult = newPromoBannerComponentImpl;
        newPromoBannerComponentImpl.MyBillsEntityDataFactory(this);
        registerPresenter(getPromoBannerPresenter().get());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final NewViewPromoBannerBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        NewViewPromoBannerBinding KClassImpl$Data$declaredNonStaticMembers$2 = NewViewPromoBannerBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        AppReadyMixpanelTracker.getAuthRequestContext(HomeAdapter.HomeWidget.PROMO_BANNER);
        getPromoBannerPresenter().get().BuiltInFictitiousFunctionClassFactory();
        getPromoBannerPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2();
        getPromoBannerPresenter().get().MyBillsEntityDataFactory();
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setGnNotificationCloseContainerCallback(new NewPromoBannerView$setBannerViewCallback$1(this));
    }

    public final void refreshView() {
        if (isInflated()) {
            getPromoBannerPresenter().get().PlaceComponentResult(true);
            getPromoBannerPresenter().get().MyBillsEntityDataFactory(true);
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        hideBannerSkeleton();
    }

    public final void hideBannerSkeleton() {
        if (isBindingInitialized()) {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.hideSkeleton();
        }
    }

    public final void updateBanner(PromotionModel promotionModel) {
        Intrinsics.checkNotNullParameter(promotionModel, "");
        NewBannerView newBannerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        newBannerView.setPromotionModel(promotionModel);
        List<CdpContentModel> list = promotionModel.KClassImpl$Data$declaredNonStaticMembers$2;
        if (list != null) {
            Intrinsics.checkNotNullExpressionValue(list, "");
            newBannerView.setContents(list);
        }
        newBannerView.display();
        newBannerView.setEntryPoint(TopupSource.PROMOTION_BANNER);
    }

    @Override // id.dana.home.promobanner.NewPromoBannerContract.View
    public final void onGetPromoCenterBannerSuccess(PromotionModel promotionModel) {
        Intrinsics.checkNotNullParameter(promotionModel, "");
        if (getView() != null) {
            NewBannerView newBannerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            if (promotionModel.NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
                newBannerView.setPromotionModel(promotionModel);
            }
            Intrinsics.checkNotNullExpressionValue(newBannerView, "");
            NewBannerView newBannerView2 = newBannerView;
            List<CdpContentModel> list = promotionModel.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(list, "");
            newBannerView2.setVisibility(list.isEmpty() ^ true ? 0 : 8);
            List<CdpContentModel> list2 = promotionModel.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(list2, "");
            newBannerView.setContents(list2);
            newBannerView.display();
        }
        getAuthRequestContext();
    }

    @Override // id.dana.home.promobanner.NewPromoBannerContract.View
    public final void onSuccessGetPromoBannerWidgetFromPersistence(List<? extends CdpContentModel> cdpContentModels) {
        Intrinsics.checkNotNullParameter(cdpContentModels, "");
        List<? extends CdpContentModel> list = cdpContentModels;
        if ((!list.isEmpty()) == false) {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.showSkeleton();
            return;
        }
        NewBannerView newBannerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(newBannerView, "");
        newBannerView.setVisibility(list.isEmpty() ^ true ? 0 : 8);
        newBannerView.setContents(cdpContentModels);
        newBannerView.display();
        getAuthRequestContext();
    }

    @Override // id.dana.home.promobanner.NewPromoBannerContract.View
    public final void onErrorGetPromoBannerWidgetFromPersistence() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.showSkeleton();
    }

    @Override // id.dana.home.promobanner.NewPromoBannerContract.View
    public final void onActiveVerificationAnnounced(PushVerifyParamsModel pushVerifyParamsModel) {
        Intrinsics.checkNotNullParameter(pushVerifyParamsModel, "");
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || !baseActivity.getLifecycle().PlaceComponentResult().isAtLeast(Lifecycle.State.RESUMED)) {
            return;
        }
        Context context = getContext();
        PushVerifyActivity.Companion companion = PushVerifyActivity.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        context.startActivity(PushVerifyActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context2, pushVerifyParamsModel, PushVerifyEntryPoint.AUTO_REDIRECTION));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String errorMessage) {
        getAuthRequestContext();
    }

    private final void getAuthRequestContext() {
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        HomeTrackerImpl homeTrackerImpl = getHomeTrackerImpl().get();
        AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory(HomeAdapter.HomeWidget.PROMO_BANNER);
        if (homeTrackerImpl.MyBillsEntityDataFactory.get()) {
            homeTrackerImpl.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Event.HOME_ASSET_READY, TrackerDataKey.Property.PROMO_CAROUSEL_LOAD_TIME, System.currentTimeMillis());
        }
        this.MyBillsEntityDataFactory = true;
    }

    public final void disposeByActivity() {
        getPromoBannerPresenter().get().onDestroy();
    }

    public final void notifyFinishCheckSessionWatcher() {
        getPromoBannerPresenter().get().getAuthRequestContext();
    }
}

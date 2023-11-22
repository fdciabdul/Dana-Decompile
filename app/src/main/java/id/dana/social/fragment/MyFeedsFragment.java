package id.dana.social.fragment;

import android.view.View;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.core.ui.richview.LoadingLottieAnimationView;
import id.dana.databinding.FragmentMeFeedBinding;
import id.dana.di.modules.OauthModule;
import id.dana.eventbus.models.TimerEvent;
import id.dana.feeds.ui.tracker.FeedsSourceType;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.model.ThirdPartyService;
import id.dana.social.adapter.BaseSocialFeedInteraction;
import id.dana.social.adapter.MyFeedHighlightAdapter;
import id.dana.social.adapter.MyFeedHighlightListener;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.adapter.SocialFeedsAdapter;
import id.dana.social.contract.MyFeedsContract;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.MyFeedsModule;
import id.dana.social.mapper.FeedTrackerModelMapperKt;
import id.dana.social.model.FeedHighlightModel;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.MyFeedHighlightModel;
import id.dana.social.utils.Content;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b+\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u001f\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u0005R\u0012\u0010\u001b\u001a\u00020\u001aX\u0087\"¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0015\u001a\u00020 X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010!R\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0012\u0010%\u001a\u00020$X\u0087\"¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020'8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lid/dana/social/fragment/MyFeedsFragment;", "Lid/dana/social/fragment/BaseFeedTimelineFragment;", "Lid/dana/databinding/FragmentMeFeedBinding;", "", "NetworkUserEntityData$$ExternalSyntheticLambda5", "()V", "Lid/dana/social/adapter/SocialFeedClickListener;", "lookAheadTest", "()Lid/dana/social/adapter/SocialFeedClickListener;", IAPSyncCommand.COMMAND_INIT, "", "GetContactSyncConfig", "()Z", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "newProxyInstance", "onSelected", "Lid/dana/eventbus/models/TimerEvent;", "p0", "", "p1", "PlaceComponentResult", "(Lid/dana/eventbus/models/TimerEvent;J)V", "isLayoutRequested", "onUnSelected", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "moveToNextValue", "Z", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/MyFeedHighlightAdapter;", "Lkotlin/Lazy;", "DatabaseTableConfigUtil", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/contract/MyFeedsContract$Presenter;", "presenter", "Lid/dana/social/contract/MyFeedsContract$Presenter;", "Lid/dana/social/fragment/MyFeedsFragment$socialFeedListener$1;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/social/fragment/MyFeedsFragment$socialFeedListener$1;", "getAuthRequestContext", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyFeedsFragment extends BaseFeedTimelineFragment<FragmentMeFeedBinding> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    @Inject
    public MyFeedsContract.Presenter presenter;
    public Map<Integer, View> getErrorConfigVersion = new LinkedHashMap();

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<MyFeedHighlightAdapter>() { // from class: id.dana.social.fragment.MyFeedsFragment$myFeedHighlightAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MyFeedHighlightAdapter invoke() {
            final MyFeedsFragment myFeedsFragment = MyFeedsFragment.this;
            return new MyFeedHighlightAdapter(new MyFeedHighlightListener() { // from class: id.dana.social.fragment.MyFeedsFragment$myFeedHighlightAdapter$2.1
                @Override // id.dana.social.adapter.MyFeedHighlightListener
                public final void MyBillsEntityDataFactory(FeedHighlightModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    FriendshipAnalyticTracker friendshipAnalyticTracker = MyFeedsFragment.this.friendshipAnalyticTracker;
                    MyFeedsContract.Presenter presenter = null;
                    if (friendshipAnalyticTracker == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendshipAnalyticTracker = null;
                    }
                    friendshipAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(FeedTrackerModelMapperKt.PlaceComponentResult(p0));
                    MyFeedsContract.Presenter presenter2 = MyFeedsFragment.this.presenter;
                    if (presenter2 != null) {
                        presenter = presenter2;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    presenter.BuiltInFictitiousFunctionClassFactory(p0.MyBillsEntityDataFactory);
                }

                @Override // id.dana.social.adapter.MyFeedHighlightListener
                public final void MyBillsEntityDataFactory(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    MyFeedsContract.Presenter presenter = MyFeedsFragment.this.presenter;
                    if (presenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    presenter.MyBillsEntityDataFactory(p0);
                }
            });
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final MyFeedsFragment$socialFeedListener$1 getAuthRequestContext = new BaseSocialFeedInteraction() { // from class: id.dana.social.fragment.MyFeedsFragment$socialFeedListener$1
        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void getAuthRequestContext(Content p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            FriendshipAnalyticTracker friendshipAnalyticTracker = MyFeedsFragment.this.friendshipAnalyticTracker;
            MyFeedsContract.Presenter presenter = null;
            if (friendshipAnalyticTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                friendshipAnalyticTracker = null;
            }
            friendshipAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(FeedTrackerModelMapperKt.getAuthRequestContext(p0));
            MyFeedsContract.Presenter presenter2 = MyFeedsFragment.this.presenter;
            if (presenter2 != null) {
                presenter = presenter2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            String str = p0.MyBillsEntityDataFactory;
            presenter.KClassImpl$Data$declaredNonStaticMembers$2(str != null ? str : "");
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void MyBillsEntityDataFactory(int p0) {
            FeedViewHolderModel item = ((BaseFeedTimelineFragment) MyFeedsFragment.this).lookAheadTest.getItem(p0);
            if (item != null) {
                MyFeedsFragment myFeedsFragment = MyFeedsFragment.this;
                if (5 == item.getErrorConfigVersion) {
                    MyFeedsFragment.MyBillsEntityDataFactory(myFeedsFragment, item);
                }
                FeedModel feedModel = item.MyBillsEntityDataFactory;
                if (feedModel != null) {
                    FriendshipAnalyticTracker friendshipAnalyticTracker = myFeedsFragment.friendshipAnalyticTracker;
                    MyFeedsContract.Presenter presenter = null;
                    if (friendshipAnalyticTracker == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendshipAnalyticTracker = null;
                    }
                    friendshipAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(FeedTrackerModelMapperKt.getAuthRequestContext(feedModel));
                    HashMap<String, String> hashMap = feedModel.lookAheadTest;
                    if (hashMap != null) {
                        MyFeedsContract.Presenter presenter2 = myFeedsFragment.presenter;
                        if (presenter2 != null) {
                            presenter = presenter2;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        }
                        presenter.BuiltInFictitiousFunctionClassFactory(hashMap);
                    }
                }
            }
        }
    };

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment
    public final boolean GetContactSyncConfig() {
        return true;
    }

    @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker
    public final void PlaceComponentResult(TimerEvent p0, long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment, id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.getErrorConfigVersion.clear();
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment, id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.getErrorConfigVersion;
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

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment, id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentMeFeedBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentMeFeedBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment, id.dana.base.BaseFragment
    public final void init() {
        super.init();
        SocialCommonComponent socialCommonComponent = getBaseActivity().getDanaApplication().getSocialCommonComponent();
        byte b = 0;
        if (socialCommonComponent != null) {
            MyFeedsModule myFeedsModule = new MyFeedsModule(new MyFeedsContract.View() { // from class: id.dana.social.fragment.MyFeedsFragment$inject$1
                @Override // id.dana.social.contract.MyFeedsContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(FeedViewHolderModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    SocialFeedsAdapter socialFeedsAdapter = ((BaseFeedTimelineFragment) MyFeedsFragment.this).lookAheadTest;
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (socialFeedsAdapter.getItems() != null) {
                        FeedModel feedModel = p0.MyBillsEntityDataFactory;
                        if ((feedModel != null ? feedModel.NetworkUserEntityData$$ExternalSyntheticLambda1 : null) != null) {
                            int size = socialFeedsAdapter.getItems().size();
                            for (int i = 0; i < size; i++) {
                                FeedModel feedModel2 = socialFeedsAdapter.getItems().get(i).MyBillsEntityDataFactory;
                                String str = feedModel2 != null ? feedModel2.NetworkUserEntityData$$ExternalSyntheticLambda1 : null;
                                FeedModel feedModel3 = p0.MyBillsEntityDataFactory;
                                if (Intrinsics.areEqual(str, feedModel3 != null ? feedModel3.NetworkUserEntityData$$ExternalSyntheticLambda1 : null)) {
                                    socialFeedsAdapter.getItems().set(i, p0);
                                    socialFeedsAdapter.notifyItemChanged(i);
                                    return;
                                }
                            }
                        }
                    }
                }

                @Override // id.dana.social.contract.MyFeedsContract.View
                public final void PlaceComponentResult(MyFeedHighlightModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    MyFeedsFragment.getAuthRequestContext(MyFeedsFragment.this).setItems(CollectionsKt.listOf(p0));
                }

                @Override // id.dana.social.contract.MyFeedsContract.View
                public final void MyBillsEntityDataFactory(boolean p0) {
                    MyFeedsFragment.this.MyBillsEntityDataFactory = p0;
                    MyFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda5();
                }

                @Override // id.dana.social.contract.MyFeedsContract.View
                public final String BuiltInFictitiousFunctionClassFactory() {
                    String shownErrorMessage;
                    shownErrorMessage = MyFeedsFragment.this.getShownErrorMessage();
                    return shownErrorMessage == null ? "" : shownErrorMessage;
                }

                @Override // id.dana.social.contract.MyFeedsContract.View
                public final void PlaceComponentResult() {
                    LoadingLottieAnimationView loadingLottieAnimationView = MyFeedsFragment.this.getAuthRequestContext;
                    if (loadingLottieAnimationView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        loadingLottieAnimationView = null;
                    }
                    loadingLottieAnimationView.cancelAnimation();
                    MyFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7();
                    ((BaseFeedTimelineFragment) MyFeedsFragment.this).lookAheadTest.setItems(CollectionsKt.listOf(new FeedViewHolderModel(10, null, null, null, null, false, 62, null)));
                }

                @Override // id.dana.social.contract.MyFeedsContract.View
                public final void MyBillsEntityDataFactory(List<FeedViewHolderModel> p0) {
                    MyFeedsFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7();
                    List<FeedViewHolderModel> list = p0;
                    if (list == null || list.isEmpty()) {
                        ((BaseFeedTimelineFragment) MyFeedsFragment.this).lookAheadTest.setItems(CollectionsKt.listOf(new FeedViewHolderModel(10, null, null, null, null, false, 62, null)));
                    } else {
                        ((BaseFeedTimelineFragment) MyFeedsFragment.this).lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                    }
                    LoadingLottieAnimationView loadingLottieAnimationView = MyFeedsFragment.this.getAuthRequestContext;
                    if (loadingLottieAnimationView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        loadingLottieAnimationView = null;
                    }
                    loadingLottieAnimationView.cancelAnimation();
                }
            });
            DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = getBaseActivity();
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = FeedsSourceType.FRIENDSHIP_MY_FEED;
            DeepLinkModule deepLinkModule = new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b);
            Intrinsics.checkNotNullExpressionValue(deepLinkModule, "");
            ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
            authRequestContext.MyBillsEntityDataFactory = getBaseActivity();
            ScanQrModule scanQrModule = new ScanQrModule(authRequestContext, b);
            Intrinsics.checkNotNullExpressionValue(scanQrModule, "");
            RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = getBaseActivity();
            RestoreUrlModule restoreUrlModule = new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b);
            Intrinsics.checkNotNullExpressionValue(restoreUrlModule, "");
            FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
            FeatureModule featureModule = new FeatureModule(MyBillsEntityDataFactory, b);
            Intrinsics.checkNotNullExpressionValue(featureModule, "");
            OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
            OauthModule oauthModule = new OauthModule(BuiltInFictitiousFunctionClassFactory, b);
            Intrinsics.checkNotNullExpressionValue(oauthModule, "");
            socialCommonComponent.KClassImpl$Data$declaredNonStaticMembers$2(myFeedsModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, new ServicesModule(new ServicesContract.View() { // from class: id.dana.social.fragment.MyFeedsFragment$inject$2
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
            })).KClassImpl$Data$declaredNonStaticMembers$2(this);
        }
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        MyFeedsContract.Presenter presenter = this.presenter;
        MyFeedsContract.Presenter presenter2 = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        registerPresenter(abstractPresenterArr);
        KClassImpl$Data$declaredNonStaticMembers$2();
        ((BaseFeedTimelineFragment) this).lookAheadTest.setItems(NetworkUserEntityData$$ExternalSyntheticLambda0());
        MyFeedHighlightAdapter myFeedHighlightAdapter = (MyFeedHighlightAdapter) this.PlaceComponentResult.getValue();
        MyFeedHighlightModel.Companion companion = MyFeedHighlightModel.INSTANCE;
        myFeedHighlightAdapter.setItems(MyFeedHighlightModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2());
        MyFeedsContract.Presenter presenter3 = this.presenter;
        if (presenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter3 = null;
        }
        presenter3.getAuthRequestContext();
        MyFeedsContract.Presenter presenter4 = this.presenter;
        if (presenter4 != null) {
            presenter2 = presenter4;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter2.MyBillsEntityDataFactory();
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment
    public final void FragmentBottomSheetPaymentSettingBinding() {
        KClassImpl$Data$declaredNonStaticMembers$2(new FeedViewHolderModel(10, null, null, null, null, false, 60, null));
        PrepareContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void NetworkUserEntityData$$ExternalSyntheticLambda5() {
        if (this.MyBillsEntityDataFactory) {
            ((MyFeedHighlightAdapter) this.PlaceComponentResult.getValue()).BuiltInFictitiousFunctionClassFactory();
            MyFeedsContract.Presenter presenter = this.presenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.MyBillsEntityDataFactory("");
            return;
        }
        MyFeedHighlightAdapter myFeedHighlightAdapter = (MyFeedHighlightAdapter) this.PlaceComponentResult.getValue();
        MyFeedHighlightModel.Companion companion = MyFeedHighlightModel.INSTANCE;
        myFeedHighlightAdapter.setItems(MyFeedHighlightModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment
    public final void isLayoutRequested() {
        if (!MyBillsEntityDataFactory() || getKClassImpl$Data$declaredNonStaticMembers$2() || this.presenter == null) {
            return;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda4();
        getAuthRequestContext();
        MyFeedsContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.MyBillsEntityDataFactory();
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment
    public final SocialFeedClickListener lookAheadTest() {
        return this.getAuthRequestContext;
    }

    @Override // id.dana.base.BaseFragment
    public final void onSelected() {
        super.onSelected();
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        newProxyInstance();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
    }

    @Override // id.dana.base.BaseFragment
    public final void onUnSelected() {
        super.onUnSelected();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
    }

    public static final /* synthetic */ MyFeedHighlightAdapter getAuthRequestContext(MyFeedsFragment myFeedsFragment) {
        return (MyFeedHighlightAdapter) myFeedsFragment.PlaceComponentResult.getValue();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(MyFeedsFragment myFeedsFragment, FeedViewHolderModel feedViewHolderModel) {
        MyFeedsContract.Presenter presenter = myFeedsFragment.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.MyBillsEntityDataFactory(feedViewHolderModel);
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment
    public final /* synthetic */ RecyclerView.Adapter scheduleImpl() {
        super.scheduleImpl();
        return new ConcatAdapter((MyFeedHighlightAdapter) this.PlaceComponentResult.getValue(), ((BaseFeedTimelineFragment) this).lookAheadTest);
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment
    public final boolean initRecordTimeStamp() {
        MyFeedsContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        return presenter.getLookAheadTest();
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment
    public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        MyFeedsContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.KClassImpl$Data$declaredNonStaticMembers$2("https://link.dana.id/setting-more");
    }

    @Override // id.dana.social.fragment.BaseFeedTimelineFragment
    public final void newProxyInstance() {
        if (this.presenter != null) {
            ((BaseFeedTimelineFragment) this).lookAheadTest.setItems(NetworkUserEntityData$$ExternalSyntheticLambda0());
            NetworkUserEntityData$$ExternalSyntheticLambda5();
            MyFeedsContract.Presenter presenter = this.presenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }
}

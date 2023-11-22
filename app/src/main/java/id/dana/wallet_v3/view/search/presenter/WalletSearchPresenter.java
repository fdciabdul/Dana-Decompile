package id.dana.wallet_v3.view.search.presenter;

import dagger.Lazy;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.pocket.model.PocketQueryList;
import id.dana.domain.wallet_v3.interactor.CheckKtpIsSaved;
import id.dana.domain.wallet_v3.interactor.GetDefaultRecommendation;
import id.dana.domain.wallet_v3.interactor.GetDynamicRecommendation;
import id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal;
import id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAssetLocal;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAssetLocal;
import id.dana.domain.wallet_v3.interactor.GetWalletSearchCategory;
import id.dana.domain.wallet_v3.model.AssetRecommendation;
import id.dana.domain.wallet_v3.model.AssetType;
import id.dana.domain.wallet_v3.model.CardAssetType;
import id.dana.domain.wallet_v3.model.KtpInfo;
import id.dana.domain.wallet_v3.model.SearchCategory;
import id.dana.domain.wallet_v3.model.SearchGeneralResult;
import id.dana.domain.wallet_v3.model.UserAssetInfosModel;
import id.dana.domain.wallet_v3.model.UserAssetInfosModelKt;
import id.dana.domain.wallet_v3.model.UserPocketAssetListModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetModel;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.model.ThirdPartyService;
import id.dana.pocket.model.PocketQueryListModel;
import id.dana.utils.StringWrapper;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.wallet_v3.mapper.AssetSearchRecommendationMapperKt;
import id.dana.wallet_v3.mapper.UserIdentityAssetsMapperKt;
import id.dana.wallet_v3.mapper.UserPaymentAssetsMapperKt;
import id.dana.wallet_v3.mapper.UserPocketAssetsMapperKt;
import id.dana.wallet_v3.model.IdentityCardModel;
import id.dana.wallet_v3.model.InvestmentCardModel;
import id.dana.wallet_v3.model.LoyaltyCardModel;
import id.dana.wallet_v3.model.NewPocketQueryListModel;
import id.dana.wallet_v3.model.NoResult;
import id.dana.wallet_v3.model.PaymentCardModel;
import id.dana.wallet_v3.model.TitleModel;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.view.search.mapper.WalletSearchMapperKt;
import id.dana.wallet_v3.view.search.model.SearchCategoryModel;
import id.dana.wallet_v3.view.search.presenter.WalletSearchContract;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 D2\u00020\u0001:\u0001DB\u0087\u0001\b\u0007\u0012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\"\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u0002020\"\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\"\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u0002000\"\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\"\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020*0\"\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020+0\"\u0012\f\u00106\u001a\b\u0012\u0004\u0012\u0002050\"¢\u0006\u0004\bB\u0010CJ-\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\fJ/\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u001d\u0010\u0019\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J=\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00022\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\u0015R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010'R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020*0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010%R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020+0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010%R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010%R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010%R\u001a\u00101\u001a\b\u0012\u0004\u0012\u0002000\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010%R\u001a\u00103\u001a\b\u0012\u0004\u0012\u0002020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010%R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010'R\u001a\u00106\u001a\b\u0012\u0004\u0012\u0002050\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010%R\u001b\u0010<\u001a\u0002078AX\u0080\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010?\u001a\u0002078AX\u0081\u0084\u0002¢\u0006\f\n\u0004\b=\u00109\u001a\u0004\b>\u0010;R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\"8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bA\u0010%"}, d2 = {"Lid/dana/wallet_v3/view/search/presenter/WalletSearchPresenter;", "Lid/dana/wallet_v3/view/search/presenter/WalletSearchContract$Presenter;", "", "", "assetTypes", "cardTitle", "searchCategory", "", "getAllCardAssets", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "categoryKey", "getChipSearchCategory", "(Ljava/lang/String;)V", NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "getDefaultRecommendation", "", "getDividedAssetTypeBasedOnPaymentAndPocket", "(Ljava/util/List;)Ljava/util/Map;", "getDynamicRecommendation", "(Ljava/lang/String;Ljava/lang/String;)V", "getIdentityAssets", "()V", "getPaymentAssetsBasedOnAssetType", "(Ljava/util/List;)V", "getPaymentOrPocketAssetsBasedOnAssetType", "getPocketAssetsBasedOnAssetType", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "recommendations", "results", "", "hasQuery", "getSearchResult$app_productionRelease", "(Ljava/util/List;Ljava/util/List;Z)Ljava/util/List;", "onDestroy", "Ldagger/Lazy;", "Lid/dana/domain/wallet_v3/interactor/CheckKtpIsSaved;", "checkKtpIsSaved", "Ldagger/Lazy;", "defaultRecommendation", "Ljava/util/List;", "", "dynamicRecommendation", "Lid/dana/domain/wallet_v3/interactor/GetDefaultRecommendation;", "Lid/dana/domain/wallet_v3/interactor/GetDynamicRecommendation;", "Lid/dana/domain/wallet_v3/interactor/GetUserAllAssetLocal;", "getUserAllAssetLocal", "Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAssetLocal;", "getUserPaymentWalletAssetLocal", "Lid/dana/domain/wallet_v3/interactor/GetUserPocketWalletAssetLocal;", "getUserPocketWalletAssetLocal", "Lid/dana/domain/wallet_v3/interactor/GetWalletSearchCategory;", "getWalletSearchCategory", "resultSearch", "Lid/dana/mapper/ThirdPartyServicesMapper;", "thirdPartyServicesMapper", "Lid/dana/wallet_v3/model/TitleModel;", "titleRecommendationResult$delegate", "Lkotlin/Lazy;", "getTitleRecommendationResult$app_productionRelease", "()Lid/dana/wallet_v3/model/TitleModel;", "titleRecommendationResult", "titleResult$delegate", "getTitleResult$app_productionRelease", "titleResult", "Lid/dana/wallet_v3/view/search/presenter/WalletSearchContract$View;", "view", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WalletSearchPresenter implements WalletSearchContract.Presenter {
    public static final int MIN_QUERY = 2;
    public static final String PAYMENT_ASSET_TYPE_KEY = "PAYMENT_ASSET_TYPE_KEY";
    public static final String POCKET_ASSET_TYPE_KEY = "POCKET_ASSET_TYPE_KEY";
    private final Lazy<CheckKtpIsSaved> checkKtpIsSaved;
    private List<? extends WalletV3CardModel> defaultRecommendation;
    private final List<WalletV3CardModel> dynamicRecommendation;
    private final Lazy<GetDefaultRecommendation> getDefaultRecommendation;
    private final Lazy<GetDynamicRecommendation> getDynamicRecommendation;
    private final Lazy<GetUserAllAssetLocal> getUserAllAssetLocal;
    private final Lazy<GetUserPaymentWalletAssetLocal> getUserPaymentWalletAssetLocal;
    private final Lazy<GetUserPocketWalletAssetLocal> getUserPocketWalletAssetLocal;
    private final Lazy<GetWalletSearchCategory> getWalletSearchCategory;
    private List<? extends WalletV3CardModel> resultSearch;
    private final Lazy<ThirdPartyServicesMapper> thirdPartyServicesMapper;

    /* renamed from: titleRecommendationResult$delegate  reason: from kotlin metadata */
    private final kotlin.Lazy titleRecommendationResult;

    /* renamed from: titleResult$delegate  reason: from kotlin metadata */
    private final kotlin.Lazy titleResult;
    private final Lazy<WalletSearchContract.View> view;

    @Inject
    public WalletSearchPresenter(Lazy<WalletSearchContract.View> lazy, Lazy<GetWalletSearchCategory> lazy2, Lazy<GetUserPaymentWalletAssetLocal> lazy3, Lazy<GetUserPocketWalletAssetLocal> lazy4, Lazy<GetUserAllAssetLocal> lazy5, Lazy<CheckKtpIsSaved> lazy6, Lazy<GetDefaultRecommendation> lazy7, Lazy<GetDynamicRecommendation> lazy8, Lazy<ThirdPartyServicesMapper> lazy9) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        Intrinsics.checkNotNullParameter(lazy9, "");
        this.view = lazy;
        this.getWalletSearchCategory = lazy2;
        this.getUserPaymentWalletAssetLocal = lazy3;
        this.getUserPocketWalletAssetLocal = lazy4;
        this.getUserAllAssetLocal = lazy5;
        this.checkKtpIsSaved = lazy6;
        this.getDefaultRecommendation = lazy7;
        this.getDynamicRecommendation = lazy8;
        this.thirdPartyServicesMapper = lazy9;
        this.titleResult = LazyKt.lazy(new Function0<TitleModel>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$titleResult$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
            @Override // kotlin.jvm.functions.Function0
            public final TitleModel invoke() {
                ?? r2 = 0;
                return new TitleModel(new StringWrapper.ResValue(R.string.wallet_search_result_title, r2, 2, r2));
            }
        });
        this.titleRecommendationResult = LazyKt.lazy(new Function0<TitleModel>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$titleRecommendationResult$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
            @Override // kotlin.jvm.functions.Function0
            public final TitleModel invoke() {
                ?? r2 = 0;
                return new TitleModel(new StringWrapper.ResValue(R.string.wallet_search_recommendation_title, r2, 2, r2));
            }
        });
        this.resultSearch = CollectionsKt.emptyList();
        this.dynamicRecommendation = new ArrayList();
    }

    @JvmName(name = "getTitleResult$app_productionRelease")
    public final TitleModel getTitleResult$app_productionRelease() {
        return (TitleModel) this.titleResult.getValue();
    }

    @JvmName(name = "getTitleRecommendationResult$app_productionRelease")
    public final TitleModel getTitleRecommendationResult$app_productionRelease() {
        return (TitleModel) this.titleRecommendationResult.getValue();
    }

    @Override // id.dana.wallet_v3.view.search.presenter.WalletSearchContract.Presenter
    public final void getChipSearchCategory(String categoryKey) {
        Intrinsics.checkNotNullParameter(categoryKey, "");
        this.getWalletSearchCategory.get().execute(new GetWalletSearchCategory.Params(categoryKey), new Function1<List<? extends SearchCategory>, Unit>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getChipSearchCategory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends SearchCategory> list) {
                invoke2((List<SearchCategory>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<SearchCategory> list) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(list, "");
                List<SearchCategoryModel> listSearchCategoryModel = WalletSearchMapperKt.toListSearchCategoryModel(list);
                lazy = WalletSearchPresenter.this.view;
                ((WalletSearchContract.View) lazy.get()).onGetChipSearchCategory(listSearchCategoryModel);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getChipSearchCategory$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = WalletSearchPresenter.this.view;
                ((WalletSearchContract.View) lazy.get()).onErrorGetChipSearchCategory();
            }
        });
    }

    @Override // id.dana.wallet_v3.view.search.presenter.WalletSearchContract.Presenter
    public final void getDefaultRecommendation(String r4) {
        Intrinsics.checkNotNullParameter(r4, "");
        if (Intrinsics.areEqual(r4, "general")) {
            this.getDefaultRecommendation.get().execute(GetDefaultRecommendation.INSTANCE.forDefault(), new Function1<List<? extends AssetRecommendation>, Unit>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getDefaultRecommendation$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(List<? extends AssetRecommendation> list) {
                    invoke2((List<AssetRecommendation>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(List<AssetRecommendation> list) {
                    List list2;
                    Lazy lazy;
                    Lazy lazy2;
                    Lazy lazy3;
                    List list3;
                    Intrinsics.checkNotNullParameter(list, "");
                    final WalletSearchPresenter walletSearchPresenter = WalletSearchPresenter.this;
                    List<AssetRecommendation> list4 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                    Iterator<T> it = list4.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AssetSearchRecommendationMapperKt.toAssetSearchRecommendation((AssetRecommendation) it.next(), new Function1<ThirdPartyServiceResponse, ThirdPartyService>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getDefaultRecommendation$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final ThirdPartyService invoke(ThirdPartyServiceResponse thirdPartyServiceResponse) {
                                Lazy lazy4;
                                lazy4 = WalletSearchPresenter.this.thirdPartyServicesMapper;
                                ThirdPartyServicesMapper thirdPartyServicesMapper = (ThirdPartyServicesMapper) lazy4.get();
                                return ThirdPartyServicesMapper.MyBillsEntityDataFactory(thirdPartyServiceResponse);
                            }
                        }));
                    }
                    walletSearchPresenter.defaultRecommendation = arrayList;
                    WalletSearchPresenter.this.resultSearch = CollectionsKt.emptyList();
                    list2 = WalletSearchPresenter.this.defaultRecommendation;
                    boolean z = false;
                    if (list2 != null && (!list2.isEmpty()) == true) {
                        z = true;
                    }
                    if (z) {
                        lazy2 = WalletSearchPresenter.this.view;
                        ((WalletSearchContract.View) lazy2.get()).onInitialStateWithRecommendation();
                        lazy3 = WalletSearchPresenter.this.view;
                        WalletSearchContract.View view = (WalletSearchContract.View) lazy3.get();
                        WalletSearchPresenter walletSearchPresenter2 = WalletSearchPresenter.this;
                        list3 = walletSearchPresenter2.defaultRecommendation;
                        if (list3 == null) {
                            list3 = CollectionsKt.emptyList();
                        }
                        view.onSuccessGetAllAssets(WalletSearchPresenter.getSearchResult$app_productionRelease$default(walletSearchPresenter2, list3, null, false, 2, null));
                        return;
                    }
                    lazy = WalletSearchPresenter.this.view;
                    ((WalletSearchContract.View) lazy.get()).onInitialState();
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getDefaultRecommendation$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Lazy lazy;
                    Intrinsics.checkNotNullParameter(th, "");
                    lazy = WalletSearchPresenter.this.view;
                    ((WalletSearchContract.View) lazy.get()).onInitialState();
                }
            });
        } else {
            this.view.get().onInitialState();
        }
    }

    @Override // id.dana.wallet_v3.view.search.presenter.WalletSearchContract.Presenter
    public final void getDynamicRecommendation(String cardTitle, String r4) {
        Intrinsics.checkNotNullParameter(cardTitle, "");
        Intrinsics.checkNotNullParameter(r4, "");
        if (Intrinsics.areEqual(r4, "general")) {
            this.getDynamicRecommendation.get().execute(new GetDynamicRecommendation.Params(cardTitle), new Function1<List<? extends AssetRecommendation>, Unit>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getDynamicRecommendation$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(List<? extends AssetRecommendation> list) {
                    invoke2((List<AssetRecommendation>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(List<AssetRecommendation> list) {
                    List list2;
                    List list3;
                    Lazy lazy;
                    List list4;
                    Intrinsics.checkNotNullParameter(list, "");
                    list2 = WalletSearchPresenter.this.dynamicRecommendation;
                    list2.clear();
                    list3 = WalletSearchPresenter.this.dynamicRecommendation;
                    List<AssetRecommendation> list5 = list;
                    final WalletSearchPresenter walletSearchPresenter = WalletSearchPresenter.this;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                    Iterator<T> it = list5.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AssetSearchRecommendationMapperKt.toAssetSearchRecommendation((AssetRecommendation) it.next(), new Function1<ThirdPartyServiceResponse, ThirdPartyService>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getDynamicRecommendation$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final ThirdPartyService invoke(ThirdPartyServiceResponse thirdPartyServiceResponse) {
                                Lazy lazy2;
                                lazy2 = WalletSearchPresenter.this.thirdPartyServicesMapper;
                                ThirdPartyServicesMapper thirdPartyServicesMapper = (ThirdPartyServicesMapper) lazy2.get();
                                return ThirdPartyServicesMapper.MyBillsEntityDataFactory(thirdPartyServiceResponse);
                            }
                        }));
                    }
                    list3.addAll(arrayList);
                    lazy = WalletSearchPresenter.this.view;
                    WalletSearchContract.View view = (WalletSearchContract.View) lazy.get();
                    WalletSearchPresenter walletSearchPresenter2 = WalletSearchPresenter.this;
                    list4 = walletSearchPresenter2.dynamicRecommendation;
                    view.onSuccessGetAllAssets(WalletSearchPresenter.getSearchResult$app_productionRelease$default(walletSearchPresenter2, list4, null, true, 2, null));
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getDynamicRecommendation$2
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "");
                    DanaLog.BuiltInFictitiousFunctionClassFactory("WalletV3", th.getMessage(), th);
                }
            });
        } else {
            DanaLog.MyBillsEntityDataFactory("WalletV3", "Not support dynamic recommendation");
        }
    }

    @Override // id.dana.wallet_v3.view.search.presenter.WalletSearchContract.Presenter
    public final void getAllCardAssets(List<String> assetTypes, String cardTitle, String searchCategory) {
        Intrinsics.checkNotNullParameter(assetTypes, "");
        Intrinsics.checkNotNullParameter(cardTitle, "");
        Intrinsics.checkNotNullParameter(searchCategory, "");
        final boolean z = cardTitle.length() >= 2;
        this.getUserAllAssetLocal.get().execute(new GetUserAllAssetLocal.Param(assetTypes, cardTitle, searchCategory), new Function1<SearchGeneralResult, Unit>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getAllCardAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SearchGeneralResult searchGeneralResult) {
                invoke2(searchGeneralResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SearchGeneralResult searchGeneralResult) {
                ArrayList arrayList;
                ArrayList arrayList2;
                Lazy lazy;
                List<? extends WalletV3CardModel> list;
                Intrinsics.checkNotNullParameter(searchGeneralResult, "");
                List<UserAssetInfosModel> bankCards = searchGeneralResult.getBankCards();
                if (bankCards != null) {
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<T> it = bankCards.iterator();
                    while (it.hasNext()) {
                        PaymentCardModel paymentCardModel = UserPaymentAssetsMapperKt.toPaymentCardModel((UserAssetInfosModel) it.next());
                        if (paymentCardModel != null) {
                            arrayList3.add(paymentCardModel);
                        }
                    }
                    arrayList = arrayList3;
                } else {
                    arrayList = null;
                }
                List<UserAssetInfosModel> investmentCards = searchGeneralResult.getInvestmentCards();
                if (investmentCards != null) {
                    ArrayList arrayList4 = new ArrayList();
                    Iterator<T> it2 = investmentCards.iterator();
                    while (it2.hasNext()) {
                        InvestmentCardModel financialCardModel = UserPaymentAssetsMapperKt.toFinancialCardModel((UserAssetInfosModel) it2.next());
                        if (financialCardModel != null) {
                            arrayList4.add(financialCardModel);
                        }
                    }
                    arrayList2 = arrayList4;
                } else {
                    arrayList2 = null;
                }
                UserPocketAssetListModel<UserPocketAssetModel> voucherCards = searchGeneralResult.getVoucherCards();
                NewPocketQueryListModel newPocketQueryListModel = voucherCards != null ? UserPocketAssetsMapperKt.toNewPocketQueryListModel(voucherCards, new Function1<UserPocketAssetModel, VoucherAndTicketCardModel>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getAllCardAssets$1$voucherCards$1
                    @Override // kotlin.jvm.functions.Function1
                    public final VoucherAndTicketCardModel invoke(UserPocketAssetModel userPocketAssetModel) {
                        Intrinsics.checkNotNullParameter(userPocketAssetModel, "");
                        return UserPocketAssetsMapperKt.toVoucherAndTicketCardModel(userPocketAssetModel, false);
                    }
                }) : null;
                UserPocketAssetListModel<UserPocketAssetModel> ticketCards = searchGeneralResult.getTicketCards();
                NewPocketQueryListModel newPocketQueryListModel2 = ticketCards != null ? UserPocketAssetsMapperKt.toNewPocketQueryListModel(ticketCards, new Function1<UserPocketAssetModel, VoucherAndTicketCardModel>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getAllCardAssets$1$ticketCards$1
                    @Override // kotlin.jvm.functions.Function1
                    public final VoucherAndTicketCardModel invoke(UserPocketAssetModel userPocketAssetModel) {
                        Intrinsics.checkNotNullParameter(userPocketAssetModel, "");
                        return UserPocketAssetsMapperKt.toVoucherAndTicketCardModel(userPocketAssetModel, false);
                    }
                }) : null;
                UserPocketAssetListModel<UserPocketAssetModel> loyaltyCards = searchGeneralResult.getLoyaltyCards();
                NewPocketQueryListModel newPocketQueryListModel3 = loyaltyCards != null ? UserPocketAssetsMapperKt.toNewPocketQueryListModel(loyaltyCards, new Function1<UserPocketAssetModel, LoyaltyCardModel>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getAllCardAssets$1$loyaltyCards$1
                    @Override // kotlin.jvm.functions.Function1
                    public final LoyaltyCardModel invoke(UserPocketAssetModel userPocketAssetModel) {
                        Intrinsics.checkNotNullParameter(userPocketAssetModel, "");
                        return UserPocketAssetsMapperKt.toLoyaltyCardModel(userPocketAssetModel, false);
                    }
                }) : null;
                PocketQueryList<KtpInfo> identityCards = searchGeneralResult.getIdentityCards();
                PocketQueryListModel pocketQueryListModel = identityCards != null ? UserIdentityAssetsMapperKt.toPocketQueryListModel(identityCards, new Function1<KtpInfo, IdentityCardModel>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getAllCardAssets$1$identityCards$1
                    @Override // kotlin.jvm.functions.Function1
                    public final IdentityCardModel invoke(KtpInfo ktpInfo) {
                        Intrinsics.checkNotNullParameter(ktpInfo, "");
                        return UserIdentityAssetsMapperKt.toIdentityCardModel(ktpInfo);
                    }
                }) : null;
                if (arrayList == null) {
                    arrayList = CollectionsKt.emptyList();
                }
                Sequence asSequence = CollectionsKt.asSequence(arrayList);
                if (arrayList2 == null) {
                    arrayList2 = CollectionsKt.emptyList();
                }
                Sequence plus = SequencesKt.plus(asSequence, (Iterable) arrayList2);
                List pockets = newPocketQueryListModel != null ? newPocketQueryListModel.getPockets() : null;
                if (pockets == null) {
                    pockets = CollectionsKt.emptyList();
                }
                Sequence plus2 = SequencesKt.plus(plus, (Iterable) pockets);
                List pockets2 = newPocketQueryListModel2 != null ? newPocketQueryListModel2.getPockets() : null;
                if (pockets2 == null) {
                    pockets2 = CollectionsKt.emptyList();
                }
                Sequence plus3 = SequencesKt.plus(plus2, (Iterable) pockets2);
                List pockets3 = newPocketQueryListModel3 != null ? newPocketQueryListModel3.getPockets() : null;
                if (pockets3 == null) {
                    pockets3 = CollectionsKt.emptyList();
                }
                Sequence plus4 = SequencesKt.plus(plus3, (Iterable) pockets3);
                List list2 = pocketQueryListModel != null ? pocketQueryListModel.PlaceComponentResult : null;
                if (list2 == null) {
                    list2 = CollectionsKt.emptyList();
                }
                List<? extends WalletV3CardModel> list3 = SequencesKt.toList(SequencesKt.plus(plus4, (Iterable) list2));
                lazy = WalletSearchPresenter.this.view;
                WalletSearchContract.View view = (WalletSearchContract.View) lazy.get();
                if (z) {
                    list = WalletSearchPresenter.this.dynamicRecommendation;
                } else {
                    list = WalletSearchPresenter.this.defaultRecommendation;
                    if (list == null) {
                        list = CollectionsKt.emptyList();
                    }
                }
                view.onSuccessGetAllAssets(WalletSearchPresenter.this.getSearchResult$app_productionRelease(list, list3, z));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getAllCardAssets$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                List list;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = WalletSearchPresenter.this.view;
                WalletSearchContract.View view = (WalletSearchContract.View) lazy.get();
                List emptyList = CollectionsKt.emptyList();
                if (z) {
                    list = WalletSearchPresenter.this.dynamicRecommendation;
                } else {
                    list = WalletSearchPresenter.this.defaultRecommendation;
                    if (list == null) {
                        list = CollectionsKt.emptyList();
                    }
                }
                view.onSuccessGetAllAssets(WalletSearchPresenter.getSearchResult$app_productionRelease$default(WalletSearchPresenter.this, list, emptyList, false, 4, null));
            }
        });
    }

    @Override // id.dana.wallet_v3.view.search.presenter.WalletSearchContract.Presenter
    public final void getPaymentOrPocketAssetsBasedOnAssetType(List<String> assetTypes) {
        Intrinsics.checkNotNullParameter(assetTypes, "");
        Map<String, List<String>> dividedAssetTypeBasedOnPaymentAndPocket = getDividedAssetTypeBasedOnPaymentAndPocket(assetTypes);
        List<String> list = dividedAssetTypeBasedOnPaymentAndPocket.get(PAYMENT_ASSET_TYPE_KEY);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<String> list2 = dividedAssetTypeBasedOnPaymentAndPocket.get(POCKET_ASSET_TYPE_KEY);
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        if (assetTypes.contains(AssetType.ID_CARD.getAsset())) {
            getIdentityAssets();
        } else if ((!list.isEmpty()) == true) {
            getPaymentAssetsBasedOnAssetType(list);
        } else if ((!list2.isEmpty()) == true) {
            getPocketAssetsBasedOnAssetType(list2);
        } else {
            this.view.get().onSuccessGetPaymentOrPocketAssetsBasedOnAssetType(getSearchResult$app_productionRelease(this.dynamicRecommendation, CollectionsKt.emptyList(), true));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List getSearchResult$app_productionRelease$default(WalletSearchPresenter walletSearchPresenter, List list, List list2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            list2 = walletSearchPresenter.resultSearch;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return walletSearchPresenter.getSearchResult$app_productionRelease(list, list2, z);
    }

    public final List<WalletV3CardModel> getSearchResult$app_productionRelease(List<? extends WalletV3CardModel> recommendations, List<? extends WalletV3CardModel> results, boolean hasQuery) {
        Intrinsics.checkNotNullParameter(recommendations, "");
        Intrinsics.checkNotNullParameter(results, "");
        this.resultSearch = results;
        ArrayList arrayList = new ArrayList();
        if (!results.isEmpty()) {
            arrayList.add(getTitleResult$app_productionRelease());
            arrayList.addAll(results);
        } else if (hasQuery) {
            arrayList.add(getTitleResult$app_productionRelease());
            arrayList.add(NoResult.INSTANCE);
        }
        List<? extends WalletV3CardModel> list = recommendations;
        if ((!list.isEmpty()) != false) {
            arrayList.add(getTitleRecommendationResult$app_productionRelease());
            arrayList.addAll(list);
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    private final void getPaymentAssetsBasedOnAssetType(List<String> assetTypes) {
        ?? r2 = 0;
        this.getUserPaymentWalletAssetLocal.get().execute(new GetUserPaymentWalletAssetLocal.Param(assetTypes, r2, 2, r2), new Function1<List<? extends UserAssetInfosModel>, Unit>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getPaymentAssetsBasedOnAssetType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends UserAssetInfosModel> list) {
                invoke2((List<UserAssetInfosModel>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<UserAssetInfosModel> list) {
                Lazy lazy;
                List<? extends WalletV3CardModel> list2;
                Intrinsics.checkNotNullParameter(list, "");
                List sortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getPaymentAssetsBasedOnAssetType$1$invoke$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(UserAssetInfosModelKt.getTitleCard((UserAssetInfosModel) t), UserAssetInfosModelKt.getTitleCard((UserAssetInfosModel) t2));
                    }
                });
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
                Iterator it = sortedWith.iterator();
                while (it.hasNext()) {
                    arrayList.add(UserPaymentAssetsMapperKt.toPaymentOrFinancialModel((UserAssetInfosModel) it.next()));
                }
                lazy = WalletSearchPresenter.this.view;
                WalletSearchContract.View view = (WalletSearchContract.View) lazy.get();
                list2 = WalletSearchPresenter.this.dynamicRecommendation;
                view.onSuccessGetPaymentOrPocketAssetsBasedOnAssetType(WalletSearchPresenter.this.getSearchResult$app_productionRelease(list2, arrayList, true));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getPaymentAssetsBasedOnAssetType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                List<? extends WalletV3CardModel> list;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = WalletSearchPresenter.this.view;
                WalletSearchContract.View view = (WalletSearchContract.View) lazy.get();
                List<? extends WalletV3CardModel> emptyList = CollectionsKt.emptyList();
                list = WalletSearchPresenter.this.dynamicRecommendation;
                view.onSuccessGetPaymentOrPocketAssetsBasedOnAssetType(WalletSearchPresenter.this.getSearchResult$app_productionRelease(list, emptyList, true));
            }
        });
    }

    private final void getPocketAssetsBasedOnAssetType(List<String> assetTypes) {
        GetUserPocketWalletAssetLocal getUserPocketWalletAssetLocal = this.getUserPocketWalletAssetLocal.get();
        List listOf = CollectionsKt.listOf((Object[]) new AssetStatus[]{AssetStatus.INIT, AssetStatus.EXPIRING, AssetStatus.ACTIVE});
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = assetTypes.iterator();
        while (it.hasNext()) {
            String valueInString = AssetType.INSTANCE.getValueInString((String) it.next());
            if (valueInString != null) {
                arrayList.add(valueInString);
            }
        }
        getUserPocketWalletAssetLocal.execute(new GetUserPocketWalletAssetLocal.Param(1, 10, listOf, arrayList, null, 16, null), new Function1<UserPocketAssetListModel<UserPocketAssetModel>, Unit>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getPocketAssetsBasedOnAssetType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel) {
                invoke2(userPocketAssetListModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel) {
                Lazy lazy;
                List<? extends WalletV3CardModel> list;
                Intrinsics.checkNotNullParameter(userPocketAssetListModel, "");
                NewPocketQueryListModel newPocketQueryListModel = UserPocketAssetsMapperKt.toNewPocketQueryListModel(userPocketAssetListModel, new Function1<UserPocketAssetModel, WalletV3CardModel>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getPocketAssetsBasedOnAssetType$2$data$1
                    @Override // kotlin.jvm.functions.Function1
                    public final WalletV3CardModel invoke(UserPocketAssetModel userPocketAssetModel) {
                        Intrinsics.checkNotNullParameter(userPocketAssetModel, "");
                        return UserPocketAssetsMapperKt.toVoucherAndTicketOrLoyaltyCardModel(userPocketAssetModel, false);
                    }
                });
                lazy = WalletSearchPresenter.this.view;
                WalletSearchContract.View view = (WalletSearchContract.View) lazy.get();
                List<? extends WalletV3CardModel> pockets = newPocketQueryListModel.getPockets();
                list = WalletSearchPresenter.this.dynamicRecommendation;
                view.onSuccessGetPaymentOrPocketAssetsBasedOnAssetType(WalletSearchPresenter.this.getSearchResult$app_productionRelease(list, pockets, true));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getPocketAssetsBasedOnAssetType$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                List<? extends WalletV3CardModel> list;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = WalletSearchPresenter.this.view;
                WalletSearchContract.View view = (WalletSearchContract.View) lazy.get();
                List<? extends WalletV3CardModel> emptyList = CollectionsKt.emptyList();
                list = WalletSearchPresenter.this.dynamicRecommendation;
                view.onSuccessGetPaymentOrPocketAssetsBasedOnAssetType(WalletSearchPresenter.this.getSearchResult$app_productionRelease(list, emptyList, true));
            }
        });
    }

    private final Map<String, List<String>> getDividedAssetTypeBasedOnPaymentAndPocket(List<String> assetTypes) {
        List<String> list = assetTypes;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (CardAssetType.INSTANCE.getValue((String) next) != null) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list) {
            if (AssetType.INSTANCE.getValue((String) obj) != null) {
                arrayList3.add(obj);
            }
        }
        return MapsKt.mapOf(TuplesKt.to(PAYMENT_ASSET_TYPE_KEY, arrayList2), TuplesKt.to(POCKET_ASSET_TYPE_KEY, arrayList3));
    }

    private final void getIdentityAssets() {
        this.checkKtpIsSaved.get().execute(new CheckKtpIsSaved.Param(true), new Function1<Boolean, Unit>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getIdentityAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Lazy lazy;
                List<? extends WalletV3CardModel> list;
                Lazy lazy2;
                List<? extends WalletV3CardModel> list2;
                if (!z) {
                    lazy = WalletSearchPresenter.this.view;
                    WalletSearchContract.View view = (WalletSearchContract.View) lazy.get();
                    List<? extends WalletV3CardModel> emptyList = CollectionsKt.emptyList();
                    list = WalletSearchPresenter.this.dynamicRecommendation;
                    view.onSuccessGetPaymentOrPocketAssetsBasedOnAssetType(WalletSearchPresenter.this.getSearchResult$app_productionRelease(list, emptyList, true));
                    return;
                }
                List<? extends WalletV3CardModel> listOf = CollectionsKt.listOf(new IdentityCardModel.KtpCard(null, null, null, 14, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194295, null));
                lazy2 = WalletSearchPresenter.this.view;
                WalletSearchContract.View view2 = (WalletSearchContract.View) lazy2.get();
                list2 = WalletSearchPresenter.this.dynamicRecommendation;
                view2.onSuccessGetPaymentOrPocketAssetsBasedOnAssetType(WalletSearchPresenter.this.getSearchResult$app_productionRelease(list2, listOf, true));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter$getIdentityAssets$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                List<? extends WalletV3CardModel> list;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = WalletSearchPresenter.this.view;
                WalletSearchContract.View view = (WalletSearchContract.View) lazy.get();
                List<? extends WalletV3CardModel> emptyList = CollectionsKt.emptyList();
                list = WalletSearchPresenter.this.dynamicRecommendation;
                view.onSuccessGetPaymentOrPocketAssetsBasedOnAssetType(WalletSearchPresenter.this.getSearchResult$app_productionRelease(list, emptyList, true));
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.getWalletSearchCategory.get().dispose();
        this.getUserPaymentWalletAssetLocal.get().dispose();
        this.getUserPocketWalletAssetLocal.get().dispose();
        this.getUserAllAssetLocal.get().dispose();
        this.checkKtpIsSaved.get().dispose();
    }
}

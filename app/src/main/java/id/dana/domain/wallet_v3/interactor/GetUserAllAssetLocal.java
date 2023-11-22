package id.dana.domain.wallet_v3.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.UseCaseSchedulers;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.pocket.model.PocketQueryList;
import id.dana.domain.wallet_v3.constant.WalletAssetType;
import id.dana.domain.wallet_v3.model.SearchGeneralResult;
import id.dana.domain.wallet_v3.model.UserAssetInfosModel;
import id.dana.domain.wallet_v3.model.UserAssetInfosModelKt;
import id.dana.domain.wallet_v3.model.UserAssetsWrapperModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetListModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetModel;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function6;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0011\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007JE\u0010\r\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b0\u00050\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetUserAllAssetLocal;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/wallet_v3/model/SearchGeneralResult;", "Lid/dana/domain/wallet_v3/interactor/GetUserAllAssetLocal$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/wallet_v3/interactor/GetUserAllAssetLocal$Param;)Lio/reactivex/Observable;", "", "", "assetTypes", "cardTitle", "Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;", "getPaymentAssets", "(Ljava/util/List;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "getPocketAssets", "searchGeneral", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "walletV3Repository", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/WalletV3Repository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetUserAllAssetLocal extends BaseUseCase<SearchGeneralResult, Param> {
    private final WalletV3Repository walletV3Repository;

    @Inject
    public GetUserAllAssetLocal(WalletV3Repository walletV3Repository) {
        Intrinsics.checkNotNullParameter(walletV3Repository, "");
        this.walletV3Repository = walletV3Repository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<SearchGeneralResult> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        String searchCategory = params.getSearchCategory();
        switch (searchCategory.hashCode()) {
            case -786681338:
                if (searchCategory.equals("payment")) {
                    Observable map = getPaymentAssets(WalletAssetType.INSTANCE.getBankAssetTypes(), params.getCardTitle()).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal$$ExternalSyntheticLambda9
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj) {
                            SearchGeneralResult m2555buildUseCase$lambda0;
                            m2555buildUseCase$lambda0 = GetUserAllAssetLocal.m2555buildUseCase$lambda0((List) obj);
                            return m2555buildUseCase$lambda0;
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(map, "");
                    return map;
                }
                break;
            case -135761730:
                if (searchCategory.equals("identity")) {
                    Observable map2 = this.walletV3Repository.searchUserIdentityAssets(params.getCardTitle()).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal$$ExternalSyntheticLambda2
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj) {
                            SearchGeneralResult m2559buildUseCase$lambda4;
                            m2559buildUseCase$lambda4 = GetUserAllAssetLocal.m2559buildUseCase$lambda4((PocketQueryList) obj);
                            return m2559buildUseCase$lambda4;
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(map2, "");
                    return map2;
                }
                break;
            case 357555337:
                if (searchCategory.equals("financial")) {
                    Observable map3 = getPaymentAssets(WalletAssetType.INSTANCE.getInvestmentAssetTypes(), params.getCardTitle()).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal$$ExternalSyntheticLambda10
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj) {
                            SearchGeneralResult m2556buildUseCase$lambda1;
                            m2556buildUseCase$lambda1 = GetUserAllAssetLocal.m2556buildUseCase$lambda1((List) obj);
                            return m2556buildUseCase$lambda1;
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(map3, "");
                    return map3;
                }
                break;
            case 358728774:
                if (searchCategory.equals("loyalty")) {
                    Observable map4 = getPocketAssets(WalletAssetType.INSTANCE.getLoyaltyAssetTypes(), params.getCardTitle()).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal$$ExternalSyntheticLambda1
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj) {
                            SearchGeneralResult m2558buildUseCase$lambda3;
                            m2558buildUseCase$lambda3 = GetUserAllAssetLocal.m2558buildUseCase$lambda3((UserPocketAssetListModel) obj);
                            return m2558buildUseCase$lambda3;
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(map4, "");
                    return map4;
                }
                break;
            case 1018752165:
                if (searchCategory.equals("voucher_and_ticket")) {
                    Observable map5 = getPocketAssets(WalletAssetType.INSTANCE.getVoucherAssetTypes(), params.getCardTitle()).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal$$ExternalSyntheticLambda11
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj) {
                            SearchGeneralResult m2557buildUseCase$lambda2;
                            m2557buildUseCase$lambda2 = GetUserAllAssetLocal.m2557buildUseCase$lambda2((UserPocketAssetListModel) obj);
                            return m2557buildUseCase$lambda2;
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(map5, "");
                    return map5;
                }
                break;
        }
        return searchGeneral(params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final SearchGeneralResult m2555buildUseCase$lambda0(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return new SearchGeneralResult(list, null, null, null, null, null, 62, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final SearchGeneralResult m2556buildUseCase$lambda1(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return new SearchGeneralResult(null, list, null, null, null, null, 61, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final SearchGeneralResult m2557buildUseCase$lambda2(UserPocketAssetListModel userPocketAssetListModel) {
        Intrinsics.checkNotNullParameter(userPocketAssetListModel, "");
        return new SearchGeneralResult(null, null, userPocketAssetListModel, null, null, null, 59, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3  reason: not valid java name */
    public static final SearchGeneralResult m2558buildUseCase$lambda3(UserPocketAssetListModel userPocketAssetListModel) {
        Intrinsics.checkNotNullParameter(userPocketAssetListModel, "");
        return new SearchGeneralResult(null, null, null, null, userPocketAssetListModel, null, 47, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-4  reason: not valid java name */
    public static final SearchGeneralResult m2559buildUseCase$lambda4(PocketQueryList pocketQueryList) {
        Intrinsics.checkNotNullParameter(pocketQueryList, "");
        return new SearchGeneralResult(null, null, null, null, null, pocketQueryList, 31, null);
    }

    private final Observable<List<UserAssetInfosModel>> getPaymentAssets(List<String> assetTypes, String cardTitle) {
        return this.walletV3Repository.searchUserPaymentAssets(cardTitle, assetTypes).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2560getPaymentAssets$lambda6;
                m2560getPaymentAssets$lambda6 = GetUserAllAssetLocal.m2560getPaymentAssets$lambda6((UserAssetsWrapperModel) obj);
                return m2560getPaymentAssets$lambda6;
            }
        }).onErrorReturn(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2561getPaymentAssets$lambda7;
                m2561getPaymentAssets$lambda7 = GetUserAllAssetLocal.m2561getPaymentAssets$lambda7((Throwable) obj);
                return m2561getPaymentAssets$lambda7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPaymentAssets$lambda-6  reason: not valid java name */
    public static final List m2560getPaymentAssets$lambda6(UserAssetsWrapperModel userAssetsWrapperModel) {
        Intrinsics.checkNotNullParameter(userAssetsWrapperModel, "");
        List<UserAssetInfosModel> assetInfos = userAssetsWrapperModel.getAssetInfos();
        if (assetInfos != null) {
            return CollectionsKt.sortedWith(assetInfos, new Comparator() { // from class: id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal$getPaymentAssets$lambda-6$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(UserAssetInfosModelKt.getTitleCard((UserAssetInfosModel) t), UserAssetInfosModelKt.getTitleCard((UserAssetInfosModel) t2));
                }
            });
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPaymentAssets$lambda-7  reason: not valid java name */
    public static final List m2561getPaymentAssets$lambda7(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return CollectionsKt.emptyList();
    }

    private final Observable<UserPocketAssetListModel<UserPocketAssetModel>> getPocketAssets(List<String> assetTypes, String cardTitle) {
        return this.walletV3Repository.searchUserPocketAssets(cardTitle, assetTypes);
    }

    private final Observable<SearchGeneralResult> searchGeneral(Param params) {
        Observable<SearchGeneralResult> zip = Observable.zip(this.walletV3Repository.getUserPaymentAssetsFromLocal(WalletAssetType.INSTANCE.getBankAssetTypes(), params.getCardTitle()).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2566searchGeneral$lambda9;
                m2566searchGeneral$lambda9 = GetUserAllAssetLocal.m2566searchGeneral$lambda9((UserAssetsWrapperModel) obj);
                return m2566searchGeneral$lambda9;
            }
        }).onErrorReturn(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2562searchGeneral$lambda10;
                m2562searchGeneral$lambda10 = GetUserAllAssetLocal.m2562searchGeneral$lambda10((Throwable) obj);
                return m2562searchGeneral$lambda10;
            }
        }).subscribeOn(UseCaseSchedulers.getJobScheduler()), this.walletV3Repository.getUserPaymentAssetsFromLocal(WalletAssetType.INSTANCE.getInvestmentAssetTypes(), params.getCardTitle()).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2563searchGeneral$lambda12;
                m2563searchGeneral$lambda12 = GetUserAllAssetLocal.m2563searchGeneral$lambda12((UserAssetsWrapperModel) obj);
                return m2563searchGeneral$lambda12;
            }
        }).onErrorReturn(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2564searchGeneral$lambda13;
                m2564searchGeneral$lambda13 = GetUserAllAssetLocal.m2564searchGeneral$lambda13((Throwable) obj);
                return m2564searchGeneral$lambda13;
            }
        }).subscribeOn(UseCaseSchedulers.getJobScheduler()), this.walletV3Repository.getUserPocketAssetsFromLocal(1, 10, CollectionsKt.listOf((Object[]) new AssetStatus[]{AssetStatus.INIT, AssetStatus.EXPIRING}), WalletAssetType.INSTANCE.getVoucherAssetTypes(), params.getCardTitle()).subscribeOn(UseCaseSchedulers.getJobScheduler()), this.walletV3Repository.getUserPocketAssetsFromLocal(1, 10, CollectionsKt.listOf((Object[]) new AssetStatus[]{AssetStatus.INIT, AssetStatus.EXPIRING}), WalletAssetType.INSTANCE.getTicketAssetTypes(), params.getCardTitle()).subscribeOn(UseCaseSchedulers.getJobScheduler()), this.walletV3Repository.getUserPocketAssetsFromLocal(1, 10, CollectionsKt.listOf((Object[]) new AssetStatus[]{AssetStatus.INIT, AssetStatus.ACTIVE}), WalletAssetType.INSTANCE.getLoyaltyAssetTypes(), params.getCardTitle()).subscribeOn(UseCaseSchedulers.getJobScheduler()), this.walletV3Repository.searchUserIdentityAssets(params.getCardTitle()).subscribeOn(UseCaseSchedulers.getJobScheduler()), new Function6() { // from class: id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function6
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                SearchGeneralResult m2565searchGeneral$lambda14;
                m2565searchGeneral$lambda14 = GetUserAllAssetLocal.m2565searchGeneral$lambda14((List) obj, (List) obj2, (UserPocketAssetListModel) obj3, (UserPocketAssetListModel) obj4, (UserPocketAssetListModel) obj5, (PocketQueryList) obj6);
                return m2565searchGeneral$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchGeneral$lambda-9  reason: not valid java name */
    public static final List m2566searchGeneral$lambda9(UserAssetsWrapperModel userAssetsWrapperModel) {
        Intrinsics.checkNotNullParameter(userAssetsWrapperModel, "");
        List<UserAssetInfosModel> assetInfos = userAssetsWrapperModel.getAssetInfos();
        if (assetInfos != null) {
            return CollectionsKt.sortedWith(assetInfos, new Comparator() { // from class: id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal$searchGeneral$lambda-9$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(UserAssetInfosModelKt.getTitleCard((UserAssetInfosModel) t), UserAssetInfosModelKt.getTitleCard((UserAssetInfosModel) t2));
                }
            });
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchGeneral$lambda-10  reason: not valid java name */
    public static final List m2562searchGeneral$lambda10(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchGeneral$lambda-12  reason: not valid java name */
    public static final List m2563searchGeneral$lambda12(UserAssetsWrapperModel userAssetsWrapperModel) {
        Intrinsics.checkNotNullParameter(userAssetsWrapperModel, "");
        List<UserAssetInfosModel> assetInfos = userAssetsWrapperModel.getAssetInfos();
        if (assetInfos != null) {
            return CollectionsKt.sortedWith(assetInfos, new Comparator() { // from class: id.dana.domain.wallet_v3.interactor.GetUserAllAssetLocal$searchGeneral$lambda-12$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(UserAssetInfosModelKt.getTitleCard((UserAssetInfosModel) t), UserAssetInfosModelKt.getTitleCard((UserAssetInfosModel) t2));
                }
            });
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchGeneral$lambda-13  reason: not valid java name */
    public static final List m2564searchGeneral$lambda13(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchGeneral$lambda-14  reason: not valid java name */
    public static final SearchGeneralResult m2565searchGeneral$lambda14(List list, List list2, UserPocketAssetListModel userPocketAssetListModel, UserPocketAssetListModel userPocketAssetListModel2, UserPocketAssetListModel userPocketAssetListModel3, PocketQueryList pocketQueryList) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(userPocketAssetListModel, "");
        Intrinsics.checkNotNullParameter(userPocketAssetListModel2, "");
        Intrinsics.checkNotNullParameter(userPocketAssetListModel3, "");
        Intrinsics.checkNotNullParameter(pocketQueryList, "");
        return new SearchGeneralResult(list, list2, userPocketAssetListModel, userPocketAssetListModel2, userPocketAssetListModel3, pocketQueryList);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetUserAllAssetLocal$Param;", "", "", "", "assetTypes", "Ljava/util/List;", "getAssetTypes", "()Ljava/util/List;", "cardTitle", "Ljava/lang/String;", "getCardTitle", "()Ljava/lang/String;", "searchCategory", "getSearchCategory", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Param {
        private final List<String> assetTypes;
        private final String cardTitle;
        private final String searchCategory;

        public Param(List<String> list, String str, String str2) {
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.assetTypes = list;
            this.cardTitle = str;
            this.searchCategory = str2;
        }

        @JvmName(name = "getAssetTypes")
        public final List<String> getAssetTypes() {
            return this.assetTypes;
        }

        @JvmName(name = "getCardTitle")
        public final String getCardTitle() {
            return this.cardTitle;
        }

        @JvmName(name = "getSearchCategory")
        public final String getSearchCategory() {
            return this.searchCategory;
        }
    }
}

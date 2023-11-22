package id.dana.domain.wallet_v3.interactor;

import id.dana.domain.account.Account;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.wallet_v3.model.CardAssetType;
import id.dana.domain.wallet_v3.model.UserAssetInfosModel;
import id.dana.domain.wallet_v3.model.UserAssetInfosModelKt;
import id.dana.domain.wallet_v3.model.UserAssetsWrapperModel;
import id.dana.domain.wallet_v3.model.WalletErrorCodes;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002,\u0012\"\u0012 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0002\u0012\u0004\u0012\u00020\u00070\u0001:\u0001\u0014B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J;\u0010\n\u001a&\u0012\"\u0012 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAsset;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lkotlin/Pair;", "", "Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;", "", "", "Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAsset$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAsset$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/account/AccountRepository;", "accountRepository", "Lid/dana/domain/account/AccountRepository;", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "walletV3Repository", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/WalletV3Repository;Lid/dana/domain/account/AccountRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetUserPaymentWalletAsset extends BaseUseCase<Pair<? extends List<? extends UserAssetInfosModel>, ? extends Map<String, ? extends String>>, Param> {
    private final AccountRepository accountRepository;
    private final WalletV3Repository walletV3Repository;

    @Inject
    public GetUserPaymentWalletAsset(WalletV3Repository walletV3Repository, AccountRepository accountRepository) {
        Intrinsics.checkNotNullParameter(walletV3Repository, "");
        Intrinsics.checkNotNullParameter(accountRepository, "");
        this.walletV3Repository = walletV3Repository;
        this.accountRepository = accountRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Pair<List<UserAssetInfosModel>, Map<String, String>>> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = this.walletV3Repository.getUserPaymentAssets(params.getAssetType()).flatMap(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAsset$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2568buildUseCase$lambda5;
                m2568buildUseCase$lambda5 = GetUserPaymentWalletAsset.m2568buildUseCase$lambda5(GetUserPaymentWalletAsset.this, (UserAssetsWrapperModel) obj);
                return m2568buildUseCase$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-5  reason: not valid java name */
    public static final ObservableSource m2568buildUseCase$lambda5(GetUserPaymentWalletAsset getUserPaymentWalletAsset, final UserAssetsWrapperModel userAssetsWrapperModel) {
        final LinkedHashMap linkedHashMap;
        Observable just;
        boolean z;
        Intrinsics.checkNotNullParameter(getUserPaymentWalletAsset, "");
        Intrinsics.checkNotNullParameter(userAssetsWrapperModel, "");
        Map<String, String> errorActions = userAssetsWrapperModel.getErrorActions();
        boolean z2 = false;
        if (errorActions != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry<String, String> entry : errorActions.entrySet()) {
                String value = entry.getValue();
                if (Intrinsics.areEqual(value, WalletErrorCodes.WALLET_AE15013508004002) || Intrinsics.areEqual(value, WalletErrorCodes.WALLET_AE15013508004003)) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            linkedHashMap = linkedHashMap2;
        } else {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            linkedHashMap = MapsKt.emptyMap();
        }
        List<UserAssetInfosModel> assetInfos = userAssetsWrapperModel.getAssetInfos();
        if (assetInfos != null) {
            List<UserAssetInfosModel> list = assetInfos;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((UserAssetInfosModel) it.next()).getAssetType(), CardAssetType.BALANCE.getAsset())) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                z2 = true;
            }
        }
        if (z2) {
            just = getUserPaymentWalletAsset.accountRepository.getAccount().map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAsset$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Pair m2569buildUseCase$lambda5$lambda4;
                    m2569buildUseCase$lambda5$lambda4 = GetUserPaymentWalletAsset.m2569buildUseCase$lambda5$lambda4(UserAssetsWrapperModel.this, linkedHashMap, (Account) obj);
                    return m2569buildUseCase$lambda5$lambda4;
                }
            });
        } else {
            List<UserAssetInfosModel> assetInfos2 = userAssetsWrapperModel.getAssetInfos();
            if (assetInfos2 == null) {
                assetInfos2 = CollectionsKt.emptyList();
            }
            just = Observable.just(TuplesKt.to(assetInfos2, linkedHashMap));
        }
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-5$lambda-4  reason: not valid java name */
    public static final Pair m2569buildUseCase$lambda5$lambda4(UserAssetsWrapperModel userAssetsWrapperModel, Map map, Account account) {
        Intrinsics.checkNotNullParameter(userAssetsWrapperModel, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(account, "");
        List<UserAssetInfosModel> assetInfos = userAssetsWrapperModel.getAssetInfos();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(assetInfos, 10));
        Iterator<T> it = assetInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(UserAssetInfosModelKt.addAccountDataIntoDanaAsset((UserAssetInfosModel) it.next(), account.getPhoneNumber(), account.getNickname(), account.getKycLevel()));
        }
        return TuplesKt.to(arrayList, map);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\u00020\u00002\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAsset$Param;", "", "", "", "component1", "()Ljava/util/List;", "assetType", "copy", "(Ljava/util/List;)Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAsset$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getAssetType", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final List<String> assetType;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Param() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAsset.Param.<init>():void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Param copy$default(Param param, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = param.assetType;
            }
            return param.copy(list);
        }

        public final List<String> component1() {
            return this.assetType;
        }

        public final Param copy(List<String> assetType) {
            return new Param(assetType);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Param) && Intrinsics.areEqual(this.assetType, ((Param) other).assetType);
        }

        public final int hashCode() {
            List<String> list = this.assetType;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(assetType=");
            sb.append(this.assetType);
            sb.append(')');
            return sb.toString();
        }

        public Param(List<String> list) {
            this.assetType = list;
        }

        public /* synthetic */ Param(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list);
        }

        @JvmName(name = "getAssetType")
        public final List<String> getAssetType() {
            return this.assetType;
        }
    }
}

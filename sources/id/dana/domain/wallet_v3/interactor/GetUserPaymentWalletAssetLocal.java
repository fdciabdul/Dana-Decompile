package id.dana.domain.wallet_v3.interactor;

import id.dana.domain.account.Account;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.wallet_v3.model.CardAssetType;
import id.dana.domain.wallet_v3.model.UserAssetInfosModel;
import id.dana.domain.wallet_v3.model.UserAssetInfosModelKt;
import id.dana.domain.wallet_v3.model.UserAssetsWrapperModel;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0011B\u0019\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAssetLocal;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;", "Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAssetLocal$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAssetLocal$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/account/AccountRepository;", "accountRepository", "Lid/dana/domain/account/AccountRepository;", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "walletV3Repository", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/WalletV3Repository;Lid/dana/domain/account/AccountRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetUserPaymentWalletAssetLocal extends BaseUseCase<List<? extends UserAssetInfosModel>, Param> {
    private final AccountRepository accountRepository;
    private final WalletV3Repository walletV3Repository;

    @Inject
    public GetUserPaymentWalletAssetLocal(WalletV3Repository walletV3Repository, AccountRepository accountRepository) {
        Intrinsics.checkNotNullParameter(walletV3Repository, "");
        Intrinsics.checkNotNullParameter(accountRepository, "");
        this.walletV3Repository = walletV3Repository;
        this.accountRepository = accountRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<UserAssetInfosModel>> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = this.walletV3Repository.getUserPaymentAssetsFromLocal(params.getAssetType(), params.getCardTitle()).flatMap(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAssetLocal$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2570buildUseCase$lambda3;
                m2570buildUseCase$lambda3 = GetUserPaymentWalletAssetLocal.m2570buildUseCase$lambda3(GetUserPaymentWalletAssetLocal.this, (UserAssetsWrapperModel) obj);
                return m2570buildUseCase$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3  reason: not valid java name */
    public static final ObservableSource m2570buildUseCase$lambda3(GetUserPaymentWalletAssetLocal getUserPaymentWalletAssetLocal, final UserAssetsWrapperModel userAssetsWrapperModel) {
        Observable just;
        boolean z;
        Intrinsics.checkNotNullParameter(getUserPaymentWalletAssetLocal, "");
        Intrinsics.checkNotNullParameter(userAssetsWrapperModel, "");
        List<UserAssetInfosModel> assetInfos = userAssetsWrapperModel.getAssetInfos();
        boolean z2 = false;
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
            just = getUserPaymentWalletAssetLocal.accountRepository.getAccount().map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAssetLocal$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    List m2571buildUseCase$lambda3$lambda2;
                    m2571buildUseCase$lambda3$lambda2 = GetUserPaymentWalletAssetLocal.m2571buildUseCase$lambda3$lambda2(UserAssetsWrapperModel.this, (Account) obj);
                    return m2571buildUseCase$lambda3$lambda2;
                }
            });
        } else {
            List<UserAssetInfosModel> assetInfos2 = userAssetsWrapperModel.getAssetInfos();
            if (assetInfos2 == null) {
                assetInfos2 = CollectionsKt.emptyList();
            }
            just = Observable.just(assetInfos2);
        }
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3$lambda-2  reason: not valid java name */
    public static final List m2571buildUseCase$lambda3$lambda2(UserAssetsWrapperModel userAssetsWrapperModel, Account account) {
        Intrinsics.checkNotNullParameter(userAssetsWrapperModel, "");
        Intrinsics.checkNotNullParameter(account, "");
        List<UserAssetInfosModel> assetInfos = userAssetsWrapperModel.getAssetInfos();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(assetInfos, 10));
        Iterator<T> it = assetInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(UserAssetInfosModelKt.addAccountDataIntoDanaAsset((UserAssetInfosModel) it.next(), account.getPhoneNumber(), account.getNickname(), account.getKycLevel()));
        }
        return arrayList;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAssetLocal$Param;", "", "", "", "component1", "()Ljava/util/List;", "component2", "()Ljava/lang/String;", "assetType", "cardTitle", "copy", "(Ljava/util/List;Ljava/lang/String;)Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAssetLocal$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/List;", "getAssetType", "Ljava/lang/String;", "getCardTitle", "<init>", "(Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final List<String> assetType;
        private final String cardTitle;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Param() {
            /*
                r2 = this;
                r0 = 0
                r1 = 3
                r2.<init>(r0, r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAssetLocal.Param.<init>():void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Param copy$default(Param param, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = param.assetType;
            }
            if ((i & 2) != 0) {
                str = param.cardTitle;
            }
            return param.copy(list, str);
        }

        public final List<String> component1() {
            return this.assetType;
        }

        /* renamed from: component2  reason: from getter */
        public final String getCardTitle() {
            return this.cardTitle;
        }

        public final Param copy(List<String> assetType, String cardTitle) {
            return new Param(assetType, cardTitle);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Param) {
                Param param = (Param) other;
                return Intrinsics.areEqual(this.assetType, param.assetType) && Intrinsics.areEqual(this.cardTitle, param.cardTitle);
            }
            return false;
        }

        public final int hashCode() {
            List<String> list = this.assetType;
            int hashCode = list == null ? 0 : list.hashCode();
            String str = this.cardTitle;
            return (hashCode * 31) + (str != null ? str.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(assetType=");
            sb.append(this.assetType);
            sb.append(", cardTitle=");
            sb.append(this.cardTitle);
            sb.append(')');
            return sb.toString();
        }

        public Param(List<String> list, String str) {
            this.assetType = list;
            this.cardTitle = str;
        }

        public /* synthetic */ Param(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str);
        }

        @JvmName(name = "getAssetType")
        public final List<String> getAssetType() {
            return this.assetType;
        }

        @JvmName(name = "getCardTitle")
        public final String getCardTitle() {
            return this.cardTitle;
        }
    }
}

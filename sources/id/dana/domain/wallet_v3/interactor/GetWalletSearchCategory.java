package id.dana.domain.wallet_v3.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.UseCaseSchedulers;
import id.dana.domain.wallet_v3.model.SearchCategory;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0016B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ?\u0010\f\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000b0\u00020\u0002*\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000b0\u00020\u00020\u00060\u0006H\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetWalletSearchCategory;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/wallet_v3/model/SearchCategory;", "Lid/dana/domain/wallet_v3/interactor/GetWalletSearchCategory$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/wallet_v3/interactor/GetWalletSearchCategory$Params;)Lio/reactivex/Observable;", "compareAssetTypes", "getCategoryFromConfig", "", "getCategoryFromLocalDatabase", "()Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;", "walletConfigRepository", "Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "walletV3Repository", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;Lid/dana/domain/wallet_v3/repository/WalletV3Repository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetWalletSearchCategory extends BaseUseCase<List<? extends SearchCategory>, Params> {
    private final WalletConfigRepository walletConfigRepository;
    private final WalletV3Repository walletV3Repository;

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCategoryFromLocalDatabase$lambda-3  reason: not valid java name */
    public static final java.util.List m2574getCategoryFromLocalDatabase$lambda3(java.util.List r1) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.wallet_v3.interactor.GetWalletSearchCategory.m2574getCategoryFromLocalDatabase$lambda3(java.util.List):java.util.List");
    }

    @Inject
    public GetWalletSearchCategory(WalletConfigRepository walletConfigRepository, WalletV3Repository walletV3Repository) {
        Intrinsics.checkNotNullParameter(walletConfigRepository, "");
        Intrinsics.checkNotNullParameter(walletV3Repository, "");
        this.walletConfigRepository = walletConfigRepository;
        this.walletV3Repository = walletV3Repository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<SearchCategory>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return compareAssetTypes(params);
    }

    private final Observable<List<SearchCategory>> compareAssetTypes(Params params) {
        Observable<List<SearchCategory>> zip = Observable.zip(getCategoryFromConfig(params).subscribeOn(UseCaseSchedulers.getJobScheduler()), getCategoryFromLocalDatabase().subscribeOn(UseCaseSchedulers.getJobScheduler()), new BiFunction() { // from class: id.dana.domain.wallet_v3.interactor.GetWalletSearchCategory$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                List m2573compareAssetTypes$lambda2;
                m2573compareAssetTypes$lambda2 = GetWalletSearchCategory.m2573compareAssetTypes$lambda2((List) obj, (List) obj2);
                return m2573compareAssetTypes$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: compareAssetTypes$lambda-2  reason: not valid java name */
    public static final List m2573compareAssetTypes$lambda2(List list, List list2) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (((SearchCategory) obj).getAssetTypes().contains(str)) {
                    break;
                }
            }
            SearchCategory searchCategory = (SearchCategory) obj;
            if (searchCategory != null) {
                arrayList.add(searchCategory);
            }
        }
        return CollectionsKt.distinct(arrayList);
    }

    private final Observable<List<SearchCategory>> getCategoryFromConfig(Params params) {
        return this.walletConfigRepository.getWalletSearchCategory(params.getCategory());
    }

    private final Observable<List<String>> getCategoryFromLocalDatabase() {
        return this.walletV3Repository.getSavedAssetTypes().map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetWalletSearchCategory$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetWalletSearchCategory.m2574getCategoryFromLocalDatabase$lambda3((List) obj);
            }
        });
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetWalletSearchCategory$Params;", "", "", "component1", "()Ljava/lang/String;", "category", "copy", "(Ljava/lang/String;)Lid/dana/domain/wallet_v3/interactor/GetWalletSearchCategory$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCategory", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final String category;

        public static /* synthetic */ Params copy$default(Params params, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.category;
            }
            return params.copy(str);
        }

        /* renamed from: component1  reason: from getter */
        public final String getCategory() {
            return this.category;
        }

        public final Params copy(String category) {
            Intrinsics.checkNotNullParameter(category, "");
            return new Params(category);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.category, ((Params) other).category);
        }

        public final int hashCode() {
            return this.category.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(category=");
            sb.append(this.category);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.category = str;
        }

        @JvmName(name = "getCategory")
        public final String getCategory() {
            return this.category;
        }
    }
}

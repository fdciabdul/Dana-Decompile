package id.dana.domain.wallet_v3.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.wallet_v3.model.SortCategory;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetWalletSortCategory;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/wallet_v3/model/SortCategory;", "Lid/dana/domain/wallet_v3/interactor/GetWalletSortCategory$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/wallet_v3/interactor/GetWalletSortCategory$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;", "walletConfigRepository", "Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetWalletSortCategory extends BaseUseCase<List<? extends SortCategory>, Params> {
    private final WalletConfigRepository walletConfigRepository;

    @Inject
    public GetWalletSortCategory(WalletConfigRepository walletConfigRepository) {
        Intrinsics.checkNotNullParameter(walletConfigRepository, "");
        this.walletConfigRepository = walletConfigRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<SortCategory>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<List<SortCategory>> just = Observable.just(SortCategory.INSTANCE.getDefault());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetWalletSortCategory$Params;", "", "", "component1", "()Ljava/lang/String;", "category", "copy", "(Ljava/lang/String;)Lid/dana/domain/wallet_v3/interactor/GetWalletSortCategory$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCategory", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

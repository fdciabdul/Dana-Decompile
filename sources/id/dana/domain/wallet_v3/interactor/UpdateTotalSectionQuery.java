package id.dana.domain.wallet_v3.interactor;

import id.dana.animation.HomeTabActivity;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/UpdateTotalSectionQuery;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/wallet_v3/interactor/UpdateTotalSectionQuery$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/wallet_v3/interactor/UpdateTotalSectionQuery$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "walletV3Repository", "Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/WalletV3Repository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UpdateTotalSectionQuery extends BaseUseCase<Unit, Params> {
    private final WalletV3Repository walletV3Repository;

    @Inject
    public UpdateTotalSectionQuery(WalletV3Repository walletV3Repository) {
        Intrinsics.checkNotNullParameter(walletV3Repository, "");
        this.walletV3Repository = walletV3Repository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Unit> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        if (params.isReset()) {
            return this.walletV3Repository.resetWalletSectionOpen(params.getSection());
        }
        return this.walletV3Repository.saveIWalletSectionQuery(params.getSection());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/UpdateTotalSectionQuery$Params;", "", "", "component1", "()I", "", "component2", "()Z", HomeTabActivity.WALLET_SECTION, "isReset", "copy", "(IZ)Lid/dana/domain/wallet_v3/interactor/UpdateTotalSectionQuery$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Z", "I", "getSection", "<init>", "(IZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final boolean isReset;
        private final int section;

        public static /* synthetic */ Params copy$default(Params params, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = params.section;
            }
            if ((i2 & 2) != 0) {
                z = params.isReset;
            }
            return params.copy(i, z);
        }

        /* renamed from: component1  reason: from getter */
        public final int getSection() {
            return this.section;
        }

        /* renamed from: component2  reason: from getter */
        public final boolean getIsReset() {
            return this.isReset;
        }

        public final Params copy(int section, boolean isReset) {
            return new Params(section, isReset);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return this.section == params.section && this.isReset == params.isReset;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int i = this.section;
            boolean z = this.isReset;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return (i * 31) + i2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(section=");
            sb.append(this.section);
            sb.append(", isReset=");
            sb.append(this.isReset);
            sb.append(')');
            return sb.toString();
        }

        public Params(int i, boolean z) {
            this.section = i;
            this.isReset = z;
        }

        @JvmName(name = "getSection")
        public final int getSection() {
            return this.section;
        }

        @JvmName(name = "isReset")
        public final boolean isReset() {
            return this.isReset;
        }
    }
}

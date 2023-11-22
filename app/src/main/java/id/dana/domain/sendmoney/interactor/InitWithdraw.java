package id.dana.domain.sendmoney.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.sendmoney.model.WithdrawInit;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/sendmoney/interactor/InitWithdraw;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/sendmoney/model/WithdrawInit;", "Lid/dana/domain/sendmoney/interactor/InitWithdraw$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/sendmoney/interactor/InitWithdraw$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/sendmoney/repository/SendMoneyRepository;", "sendMoneyRepository", "Lid/dana/domain/sendmoney/repository/SendMoneyRepository;", "<init>", "(Lid/dana/domain/sendmoney/repository/SendMoneyRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InitWithdraw extends BaseUseCase<WithdrawInit, Param> {
    private final SendMoneyRepository sendMoneyRepository;

    @Inject
    public InitWithdraw(SendMoneyRepository sendMoneyRepository) {
        Intrinsics.checkNotNullParameter(sendMoneyRepository, "");
        this.sendMoneyRepository = sendMoneyRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<WithdrawInit> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<WithdrawInit> withdrawInit = this.sendMoneyRepository.withdrawInit(Boolean.valueOf(params.getNeedCertifiedUser()), params.getPayMethod());
        Intrinsics.checkNotNullExpressionValue(withdrawInit, "");
        return withdrawInit;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007"}, d2 = {"Lid/dana/domain/sendmoney/interactor/InitWithdraw$Param;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "needCertifiedUser", "payMethod", "copy", "(ZLjava/lang/String;)Lid/dana/domain/sendmoney/interactor/InitWithdraw$Param;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getNeedCertifiedUser", "Ljava/lang/String;", "getPayMethod", "<init>", "(ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final boolean needCertifiedUser;
        private final String payMethod;

        public static /* synthetic */ Param copy$default(Param param, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z = param.needCertifiedUser;
            }
            if ((i & 2) != 0) {
                str = param.payMethod;
            }
            return param.copy(z, str);
        }

        /* renamed from: component1  reason: from getter */
        public final boolean getNeedCertifiedUser() {
            return this.needCertifiedUser;
        }

        /* renamed from: component2  reason: from getter */
        public final String getPayMethod() {
            return this.payMethod;
        }

        public final Param copy(boolean needCertifiedUser, String payMethod) {
            Intrinsics.checkNotNullParameter(payMethod, "");
            return new Param(needCertifiedUser, payMethod);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Param) {
                Param param = (Param) other;
                return this.needCertifiedUser == param.needCertifiedUser && Intrinsics.areEqual(this.payMethod, param.payMethod);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public final int hashCode() {
            boolean z = this.needCertifiedUser;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return (r0 * 31) + this.payMethod.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(needCertifiedUser=");
            sb.append(this.needCertifiedUser);
            sb.append(", payMethod=");
            sb.append(this.payMethod);
            sb.append(')');
            return sb.toString();
        }

        public Param(boolean z, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.needCertifiedUser = z;
            this.payMethod = str;
        }

        @JvmName(name = "getNeedCertifiedUser")
        public final boolean getNeedCertifiedUser() {
            return this.needCertifiedUser;
        }

        @JvmName(name = "getPayMethod")
        public final String getPayMethod() {
            return this.payMethod;
        }
    }
}

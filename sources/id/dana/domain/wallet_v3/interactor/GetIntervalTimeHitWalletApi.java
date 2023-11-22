package id.dana.domain.wallet_v3.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.wallet_v3.interactor.GetIntervalTimeHitWalletApi;
import id.dana.domain.wallet_v3.model.WalletV3RestrictedErrorCodes;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetIntervalTimeHitWalletApi;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/wallet_v3/interactor/GetIntervalTimeHitWalletApi$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/wallet_v3/interactor/GetIntervalTimeHitWalletApi$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;", "walletConfigRepository", "Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;)V", "Companion", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetIntervalTimeHitWalletApi extends BaseUseCase<Integer, Param> {
    private static final int NO_INTERVAL_TIME = 0;
    private static final int SECOND_TO_MILLIS = 1000;
    private final WalletConfigRepository walletConfigRepository;

    @Inject
    public GetIntervalTimeHitWalletApi(WalletConfigRepository walletConfigRepository) {
        Intrinsics.checkNotNullParameter(walletConfigRepository, "");
        this.walletConfigRepository = walletConfigRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Integer> buildUseCase(final Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable map = this.walletConfigRepository.getWalletV3RestrictedErrorCodes().map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.GetIntervalTimeHitWalletApi$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Integer m2552buildUseCase$lambda0;
                m2552buildUseCase$lambda0 = GetIntervalTimeHitWalletApi.m2552buildUseCase$lambda0(GetIntervalTimeHitWalletApi.Param.this, (WalletV3RestrictedErrorCodes) obj);
                return m2552buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final Integer m2552buildUseCase$lambda0(Param param, WalletV3RestrictedErrorCodes walletV3RestrictedErrorCodes) {
        Intrinsics.checkNotNullParameter(param, "");
        Intrinsics.checkNotNullParameter(walletV3RestrictedErrorCodes, "");
        return Integer.valueOf((walletV3RestrictedErrorCodes.getIsEnable() && walletV3RestrictedErrorCodes.getErrorCodes().contains(param.getErrorCode())) ? walletV3RestrictedErrorCodes.getWaitingTime() * 1000 : 0);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/GetIntervalTimeHitWalletApi$Param;", "", "", "component1", "()Ljava/lang/String;", "errorCode", "copy", "(Ljava/lang/String;)Lid/dana/domain/wallet_v3/interactor/GetIntervalTimeHitWalletApi$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getErrorCode", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final String errorCode;

        public static /* synthetic */ Param copy$default(Param param, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = param.errorCode;
            }
            return param.copy(str);
        }

        /* renamed from: component1  reason: from getter */
        public final String getErrorCode() {
            return this.errorCode;
        }

        public final Param copy(String errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "");
            return new Param(errorCode);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Param) && Intrinsics.areEqual(this.errorCode, ((Param) other).errorCode);
        }

        public final int hashCode() {
            return this.errorCode.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(errorCode=");
            sb.append(this.errorCode);
            sb.append(')');
            return sb.toString();
        }

        public Param(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.errorCode = str;
        }

        @JvmName(name = "getErrorCode")
        public final String getErrorCode() {
            return this.errorCode;
        }
    }
}

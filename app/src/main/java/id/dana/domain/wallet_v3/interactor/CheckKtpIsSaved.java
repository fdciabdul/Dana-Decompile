package id.dana.domain.wallet_v3.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.wallet_v3.model.KycInfo;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import id.dana.sendmoney.summary.SummaryActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/CheckKtpIsSaved;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/wallet_v3/interactor/CheckKtpIsSaved$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/wallet_v3/interactor/CheckKtpIsSaved$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/repository/PersonalTabRepository;", "personalTabRepository", "Lid/dana/domain/wallet_v3/repository/PersonalTabRepository;", "<init>", "(Lid/dana/domain/wallet_v3/repository/PersonalTabRepository;)V", "Companion", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckKtpIsSaved extends BaseUseCase<Boolean, Param> {
    public static final String IS_KYC = "isKyc";
    private final PersonalTabRepository personalTabRepository;

    @Inject
    public CheckKtpIsSaved(PersonalTabRepository personalTabRepository) {
        Intrinsics.checkNotNullParameter(personalTabRepository, "");
        this.personalTabRepository = personalTabRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        if (params.isRefresh()) {
            Observable<Boolean> flatMap = Observable.zip(this.personalTabRepository.getUserKYCStatus(0, 1), this.personalTabRepository.isKtpSaved(), new BiFunction() { // from class: id.dana.domain.wallet_v3.interactor.CheckKtpIsSaved$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    Pair m2524buildUseCase$lambda0;
                    m2524buildUseCase$lambda0 = CheckKtpIsSaved.m2524buildUseCase$lambda0((KycInfo) obj, (Boolean) obj2);
                    return m2524buildUseCase$lambda0;
                }
            }).flatMap(new Function() { // from class: id.dana.domain.wallet_v3.interactor.CheckKtpIsSaved$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m2525buildUseCase$lambda2;
                    m2525buildUseCase$lambda2 = CheckKtpIsSaved.m2525buildUseCase$lambda2(CheckKtpIsSaved.this, (Pair) obj);
                    return m2525buildUseCase$lambda2;
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
            return flatMap;
        }
        return this.personalTabRepository.isKtpSaved();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final Pair m2524buildUseCase$lambda0(KycInfo kycInfo, Boolean bool) {
        Intrinsics.checkNotNullParameter(kycInfo, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return TuplesKt.to(bool, kycInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final ObservableSource m2525buildUseCase$lambda2(CheckKtpIsSaved checkKtpIsSaved, Pair pair) {
        Observable just;
        Intrinsics.checkNotNullParameter(checkKtpIsSaved, "");
        Intrinsics.checkNotNullParameter(pair, "");
        Boolean bool = (Boolean) pair.component1();
        String str = (String) MapsKt.getValue(((KycInfo) pair.component2()).getExtendInfo(), IS_KYC);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        if (bool.booleanValue() && !Intrinsics.areEqual(str, SummaryActivity.CHECKED)) {
            just = checkKtpIsSaved.personalTabRepository.storeKtpSaved(false).map(new Function() { // from class: id.dana.domain.wallet_v3.interactor.CheckKtpIsSaved$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Boolean m2526buildUseCase$lambda2$lambda1;
                    m2526buildUseCase$lambda2$lambda1 = CheckKtpIsSaved.m2526buildUseCase$lambda2$lambda1((Boolean) obj);
                    return m2526buildUseCase$lambda2$lambda1;
                }
            });
        } else {
            just = Observable.just(bool);
        }
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2$lambda-1  reason: not valid java name */
    public static final Boolean m2526buildUseCase$lambda2$lambda1(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "");
        return Boolean.FALSE;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/domain/wallet_v3/interactor/CheckKtpIsSaved$Param;", "", "", "component1", "()Z", "isRefresh", "copy", "(Z)Lid/dana/domain/wallet_v3/interactor/CheckKtpIsSaved$Param;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final boolean isRefresh;

        public static /* synthetic */ Param copy$default(Param param, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = param.isRefresh;
            }
            return param.copy(z);
        }

        /* renamed from: component1  reason: from getter */
        public final boolean getIsRefresh() {
            return this.isRefresh;
        }

        public final Param copy(boolean isRefresh) {
            return new Param(isRefresh);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Param) && this.isRefresh == ((Param) other).isRefresh;
        }

        public final int hashCode() {
            boolean z = this.isRefresh;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(isRefresh=");
            sb.append(this.isRefresh);
            sb.append(')');
            return sb.toString();
        }

        public Param(boolean z) {
            this.isRefresh = z;
        }

        @JvmName(name = "isRefresh")
        public final boolean isRefresh() {
            return this.isRefresh;
        }
    }
}

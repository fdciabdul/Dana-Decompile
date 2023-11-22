package id.dana.domain.investment.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.investment.InvestmentRepository;
import id.dana.domain.investment.model.UserInvestmentInfo;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/investment/interactor/GetUserInvestmentSummary;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/investment/model/UserInvestmentInfo;", "Lid/dana/domain/investment/interactor/GetUserInvestmentSummary$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/investment/interactor/GetUserInvestmentSummary$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/investment/InvestmentRepository;", "investmentRepository", "Lid/dana/domain/investment/InvestmentRepository;", "<init>", "(Lid/dana/domain/investment/InvestmentRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetUserInvestmentSummary extends BaseUseCase<UserInvestmentInfo, Params> {
    private final InvestmentRepository investmentRepository;

    @Inject
    public GetUserInvestmentSummary(InvestmentRepository investmentRepository) {
        Intrinsics.checkNotNullParameter(investmentRepository, "");
        this.investmentRepository = investmentRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<UserInvestmentInfo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.investmentRepository.getUserInvestment(params.getGoodsId());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/investment/interactor/GetUserInvestmentSummary$Params;", "", "", "goodsId", "Ljava/lang/String;", "getGoodsId$domain_productionRelease", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String GOODS_ID_DANA_EMAS = "dana_emas";
        private static final String GOODS_ID_DANA_PLUS = "dana_mutualfund_staram_danaplus";
        private static final String GOODS_ID_DANA_PLUS_STAR_AM = "dana_mutualfund_staram_danaplus";
        private final String goodsId;

        public /* synthetic */ Params(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        @JvmStatic
        public static final Params forDanaEmas() {
            return INSTANCE.forDanaEmas();
        }

        @JvmStatic
        public static final Params forDanaPlus() {
            return INSTANCE.forDanaPlus();
        }

        @JvmStatic
        public static final Params forDanaPlusStarAm() {
            return INSTANCE.forDanaPlusStarAm();
        }

        private Params(String str) {
            this.goodsId = str;
        }

        @JvmName(name = "getGoodsId$domain_productionRelease")
        /* renamed from: getGoodsId$domain_productionRelease  reason: from getter */
        public final String getGoodsId() {
            return this.goodsId;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\t"}, d2 = {"Lid/dana/domain/investment/interactor/GetUserInvestmentSummary$Params$Companion;", "", "Lid/dana/domain/investment/interactor/GetUserInvestmentSummary$Params;", "forDanaEmas", "()Lid/dana/domain/investment/interactor/GetUserInvestmentSummary$Params;", "forDanaPlus", "forDanaPlusStarAm", "", "GOODS_ID_DANA_EMAS", "Ljava/lang/String;", "GOODS_ID_DANA_PLUS", "GOODS_ID_DANA_PLUS_STAR_AM", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params forDanaPlus() {
                return new Params("dana_mutualfund_staram_danaplus", null);
            }

            @JvmStatic
            public final Params forDanaPlusStarAm() {
                return new Params("dana_mutualfund_staram_danaplus", null);
            }

            @JvmStatic
            public final Params forDanaEmas() {
                return new Params(Params.GOODS_ID_DANA_EMAS, null);
            }
        }
    }
}

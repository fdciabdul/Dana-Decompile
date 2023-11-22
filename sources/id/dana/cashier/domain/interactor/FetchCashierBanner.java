package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.model.FetchBannerInfo;
import id.dana.cashier.domain.model.FetchBannerRequest;
import id.dana.data.config.repository.FeatureConfigEntityRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/cashier/domain/interactor/FetchCashierBanner;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/cashier/domain/model/FetchBannerInfo;", "Lid/dana/cashier/domain/interactor/FetchCashierBanner$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/cashier/domain/interactor/FetchCashierBanner$Params;)Lio/reactivex/Observable;", "constructEMoneyBanner", "()Lid/dana/cashier/domain/model/FetchBannerInfo;", "", "transactionScenario", "", "isElectronicMoneyTransaction", "(Ljava/lang/String;)Z", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "Lid/dana/data/config/repository/FeatureConfigEntityRepository;", "featureConfigEntityRepository", "Lid/dana/data/config/repository/FeatureConfigEntityRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;Lid/dana/data/config/repository/FeatureConfigEntityRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FetchCashierBanner extends BaseUseCase<FetchBannerInfo, Params> {
    private final CashierRepository cashierRepository;
    private final FeatureConfigEntityRepository featureConfigEntityRepository;

    @Inject
    public FetchCashierBanner(CashierRepository cashierRepository, FeatureConfigEntityRepository featureConfigEntityRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        this.cashierRepository = cashierRepository;
        this.featureConfigEntityRepository = featureConfigEntityRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<FetchBannerInfo> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        if (isElectronicMoneyTransaction(params.getFetchBannerRequest().getTransactionScenario())) {
            Observable flatMap = this.featureConfigEntityRepository.isFeatureElectronicMoneyBannerEnable().flatMap(new Function() { // from class: id.dana.cashier.domain.interactor.FetchCashierBanner$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m568buildUseCase$lambda0;
                    m568buildUseCase$lambda0 = FetchCashierBanner.m568buildUseCase$lambda0(FetchCashierBanner.this, params, (Boolean) obj);
                    return m568buildUseCase$lambda0;
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
            return flatMap;
        }
        return this.cashierRepository.fetchBanner(params.getFetchBannerRequest());
    }

    /* renamed from: buildUseCase$lambda-0 */
    public static final ObservableSource m568buildUseCase$lambda0(FetchCashierBanner fetchCashierBanner, Params params, Boolean bool) {
        Observable<FetchBannerInfo> fetchBanner;
        Intrinsics.checkNotNullParameter(fetchCashierBanner, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (bool.booleanValue()) {
            fetchBanner = Observable.just(fetchCashierBanner.constructEMoneyBanner());
            Intrinsics.checkNotNullExpressionValue(fetchBanner, "");
        } else {
            fetchBanner = fetchCashierBanner.cashierRepository.fetchBanner(params.getFetchBannerRequest());
        }
        return fetchBanner;
    }

    private final FetchBannerInfo constructEMoneyBanner() {
        return new FetchBannerInfo("0", "ELECTRONIC_MONEY", "ELECTRONIC_MONEY_RULE", "", MapsKt.hashMapOf(TuplesKt.to(FetchBannerInfo.EXTEND_KEY_CTA_BUTTON_LABEL, "CEK SALDO")), "", Boolean.TRUE, null, "CDP", 128, null);
    }

    private final boolean isElectronicMoneyTransaction(String transactionScenario) {
        if (transactionScenario == null) {
            transactionScenario = "";
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String upperCase = transactionScenario.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        return Intrinsics.areEqual(upperCase, "ELECTRONIC_MONEY");
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/interactor/FetchCashierBanner$Params;", "", "Lid/dana/cashier/domain/model/FetchBannerRequest;", "fetchBannerRequest", "Lid/dana/cashier/domain/model/FetchBannerRequest;", "getFetchBannerRequest", "()Lid/dana/cashier/domain/model/FetchBannerRequest;", "<init>", "(Lid/dana/cashier/domain/model/FetchBannerRequest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final FetchBannerRequest fetchBannerRequest;

        public Params(FetchBannerRequest fetchBannerRequest) {
            Intrinsics.checkNotNullParameter(fetchBannerRequest, "");
            this.fetchBannerRequest = fetchBannerRequest;
        }

        @JvmName(name = "getFetchBannerRequest")
        public final FetchBannerRequest getFetchBannerRequest() {
            return this.fetchBannerRequest;
        }
    }
}

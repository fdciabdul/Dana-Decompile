package id.dana.data.investment.repository.source.network.response;

import id.dana.domain.investment.AccountInvestmentStatus;
import id.dana.domain.investment.model.InvestmentUnitInfo;
import id.dana.domain.investment.model.MultiCurrencyMoneyView;
import id.dana.domain.investment.model.UserInvestmentInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/investment/repository/source/network/response/AccountInvestmentResult;", "Lid/dana/domain/investment/model/UserInvestmentInfo;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/investment/repository/source/network/response/AccountInvestmentResult;)Lid/dana/domain/investment/model/UserInvestmentInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountInvestmentResultKt {
    public static final UserInvestmentInfo KClassImpl$Data$declaredNonStaticMembers$2(AccountInvestmentResult accountInvestmentResult) {
        Intrinsics.checkNotNullParameter(accountInvestmentResult, "");
        String accountId = accountInvestmentResult.getAccountId();
        AccountInvestmentStatus valueOf = AccountInvestmentStatus.valueOf(accountInvestmentResult.getAccountStatus());
        String aggregator = accountInvestmentResult.getAggregator();
        MultiCurrencyMoneyResult availableBalance = accountInvestmentResult.getAvailableBalance();
        MultiCurrencyMoneyView KClassImpl$Data$declaredNonStaticMembers$2 = availableBalance != null ? MultiCurrencyMoneyResultKt.KClassImpl$Data$declaredNonStaticMembers$2(availableBalance) : null;
        InvestmentUnitResult balanceUnit = accountInvestmentResult.getBalanceUnit();
        InvestmentUnitInfo PlaceComponentResult = balanceUnit != null ? InvestmentUnitResultKt.PlaceComponentResult(balanceUnit) : null;
        MultiCurrencyMoneyResult dailyGainLossAmount = accountInvestmentResult.getDailyGainLossAmount();
        MultiCurrencyMoneyView KClassImpl$Data$declaredNonStaticMembers$22 = dailyGainLossAmount != null ? MultiCurrencyMoneyResultKt.KClassImpl$Data$declaredNonStaticMembers$2(dailyGainLossAmount) : null;
        String dailyGainLossPercentage = accountInvestmentResult.getDailyGainLossPercentage();
        String goodsId = accountInvestmentResult.getGoodsId();
        Long lastUpdated = accountInvestmentResult.getLastUpdated();
        MultiCurrencyMoneyResult totalGainLossAmount = accountInvestmentResult.getTotalGainLossAmount();
        return new UserInvestmentInfo(accountId, valueOf, aggregator, KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$22, dailyGainLossPercentage, goodsId, lastUpdated, totalGainLossAmount != null ? MultiCurrencyMoneyResultKt.KClassImpl$Data$declaredNonStaticMembers$2(totalGainLossAmount) : null, accountInvestmentResult.getTotalGainLossPercentage(), accountInvestmentResult.getUserId());
    }
}

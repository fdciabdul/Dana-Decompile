package id.dana.investment.model;

import id.dana.domain.investment.AccountInvestmentStatus;
import id.dana.domain.investment.model.InvestmentUnitInfo;
import id.dana.domain.investment.model.MultiCurrencyMoneyView;
import id.dana.domain.investment.model.UserInvestmentInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/investment/model/UserInvestmentInfo;", "Lid/dana/investment/model/UserInvestmentModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/investment/model/UserInvestmentInfo;)Lid/dana/investment/model/UserInvestmentModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserInvestmentModelKt {
    public static final UserInvestmentModel KClassImpl$Data$declaredNonStaticMembers$2(UserInvestmentInfo userInvestmentInfo) {
        Intrinsics.checkNotNullParameter(userInvestmentInfo, "");
        String accountId = userInvestmentInfo.getAccountId();
        AccountInvestmentStatus accountStatus = userInvestmentInfo.getAccountStatus();
        String aggregator = userInvestmentInfo.getAggregator();
        MultiCurrencyMoneyView availableBalance = userInvestmentInfo.getAvailableBalance();
        MultiCurrencyMoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2 = availableBalance != null ? MultiCurrencyMoneyViewModelKt.KClassImpl$Data$declaredNonStaticMembers$2(availableBalance) : null;
        InvestmentUnitInfo balanceUnit = userInvestmentInfo.getBalanceUnit();
        InvestmentUnitModel BuiltInFictitiousFunctionClassFactory = balanceUnit != null ? InvestmentUnitModelKt.BuiltInFictitiousFunctionClassFactory(balanceUnit) : null;
        MultiCurrencyMoneyView dailyGainLossAmount = userInvestmentInfo.getDailyGainLossAmount();
        MultiCurrencyMoneyViewModel KClassImpl$Data$declaredNonStaticMembers$22 = dailyGainLossAmount != null ? MultiCurrencyMoneyViewModelKt.KClassImpl$Data$declaredNonStaticMembers$2(dailyGainLossAmount) : null;
        String dailyGainLossPercentage = userInvestmentInfo.getDailyGainLossPercentage();
        String goodsId = userInvestmentInfo.getGoodsId();
        Long lastUpdated = userInvestmentInfo.getLastUpdated();
        MultiCurrencyMoneyView totalGainLossAmount = userInvestmentInfo.getTotalGainLossAmount();
        return new UserInvestmentModel(accountId, accountStatus, aggregator, KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$22, dailyGainLossPercentage, goodsId, lastUpdated, totalGainLossAmount != null ? MultiCurrencyMoneyViewModelKt.KClassImpl$Data$declaredNonStaticMembers$2(totalGainLossAmount) : null, userInvestmentInfo.getTotalGainLossPercentage(), userInvestmentInfo.getUserId());
    }
}

package id.dana.data.investment.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.danah5.constant.BaseKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B}\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000fR\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006"}, d2 = {"Lid/dana/data/investment/repository/source/network/response/AccountInvestmentResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "accountId", "Ljava/lang/String;", "getAccountId", "()Ljava/lang/String;", "accountStatus", "getAccountStatus", "aggregator", "getAggregator", "Lid/dana/data/investment/repository/source/network/response/MultiCurrencyMoneyResult;", "availableBalance", "Lid/dana/data/investment/repository/source/network/response/MultiCurrencyMoneyResult;", "getAvailableBalance", "()Lid/dana/data/investment/repository/source/network/response/MultiCurrencyMoneyResult;", "Lid/dana/data/investment/repository/source/network/response/InvestmentUnitResult;", "balanceUnit", "Lid/dana/data/investment/repository/source/network/response/InvestmentUnitResult;", "getBalanceUnit", "()Lid/dana/data/investment/repository/source/network/response/InvestmentUnitResult;", "dailyGainLossAmount", "getDailyGainLossAmount", "dailyGainLossPercentage", "getDailyGainLossPercentage", "goodsId", "getGoodsId", "", BaseKey.LAST_UPDATED, "Ljava/lang/Long;", "getLastUpdated", "()Ljava/lang/Long;", "totalGainLossAmount", "getTotalGainLossAmount", "totalGainLossPercentage", "getTotalGainLossPercentage", "userId", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/investment/repository/source/network/response/MultiCurrencyMoneyResult;Lid/dana/data/investment/repository/source/network/response/InvestmentUnitResult;Lid/dana/data/investment/repository/source/network/response/MultiCurrencyMoneyResult;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lid/dana/data/investment/repository/source/network/response/MultiCurrencyMoneyResult;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountInvestmentResult extends BaseRpcResult {
    private final String accountId;
    private final String accountStatus;
    private final String aggregator;
    private final MultiCurrencyMoneyResult availableBalance;
    private final InvestmentUnitResult balanceUnit;
    private final MultiCurrencyMoneyResult dailyGainLossAmount;
    private final String dailyGainLossPercentage;
    private final String goodsId;
    private final Long lastUpdated;
    private final MultiCurrencyMoneyResult totalGainLossAmount;
    private final String totalGainLossPercentage;
    private final String userId;

    @JvmName(name = "getAccountId")
    public final String getAccountId() {
        return this.accountId;
    }

    @JvmName(name = "getAccountStatus")
    public final String getAccountStatus() {
        return this.accountStatus;
    }

    @JvmName(name = "getAggregator")
    public final String getAggregator() {
        return this.aggregator;
    }

    @JvmName(name = "getAvailableBalance")
    public final MultiCurrencyMoneyResult getAvailableBalance() {
        return this.availableBalance;
    }

    @JvmName(name = "getBalanceUnit")
    public final InvestmentUnitResult getBalanceUnit() {
        return this.balanceUnit;
    }

    @JvmName(name = "getDailyGainLossAmount")
    public final MultiCurrencyMoneyResult getDailyGainLossAmount() {
        return this.dailyGainLossAmount;
    }

    @JvmName(name = "getDailyGainLossPercentage")
    public final String getDailyGainLossPercentage() {
        return this.dailyGainLossPercentage;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getLastUpdated")
    public final Long getLastUpdated() {
        return this.lastUpdated;
    }

    @JvmName(name = "getTotalGainLossAmount")
    public final MultiCurrencyMoneyResult getTotalGainLossAmount() {
        return this.totalGainLossAmount;
    }

    @JvmName(name = "getTotalGainLossPercentage")
    public final String getTotalGainLossPercentage() {
        return this.totalGainLossPercentage;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    public AccountInvestmentResult(String str, String str2, String str3, MultiCurrencyMoneyResult multiCurrencyMoneyResult, InvestmentUnitResult investmentUnitResult, MultiCurrencyMoneyResult multiCurrencyMoneyResult2, String str4, String str5, Long l, MultiCurrencyMoneyResult multiCurrencyMoneyResult3, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str2, "");
        this.accountId = str;
        this.accountStatus = str2;
        this.aggregator = str3;
        this.availableBalance = multiCurrencyMoneyResult;
        this.balanceUnit = investmentUnitResult;
        this.dailyGainLossAmount = multiCurrencyMoneyResult2;
        this.dailyGainLossPercentage = str4;
        this.goodsId = str5;
        this.lastUpdated = l;
        this.totalGainLossAmount = multiCurrencyMoneyResult3;
        this.totalGainLossPercentage = str6;
        this.userId = str7;
    }
}

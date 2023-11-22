package id.dana.domain.investment.model;

import id.dana.danah5.constant.BaseKey;
import id.dana.domain.investment.AccountInvestmentStatus;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\n¢\u0006\u0004\bP\u00105B\u0093\u0001\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bP\u0010QJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u009e\u0001\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0019\u001a\u00020\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010+\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b-\u0010\u0004R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u00101R\"\u0010\u0019\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u00102\u001a\u0004\b3\u0010\f\"\u0004\b4\u00105R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010.\u001a\u0004\b6\u0010\u0004\"\u0004\b7\u00101R$\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00108\u001a\u0004\b9\u0010\u0007\"\u0004\b:\u0010;R$\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010<\u001a\u0004\b=\u0010\u0011\"\u0004\b>\u0010?R$\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u00108\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010;R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010.\u001a\u0004\bB\u0010\u0004\"\u0004\bC\u00101R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010.\u001a\u0004\bD\u0010\u0004\"\u0004\bE\u00101R$\u0010 \u001a\u0004\u0018\u00010\u00158\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010F\u001a\u0004\bG\u0010\u0017\"\u0004\bH\u0010IR$\u0010!\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u00108\u001a\u0004\bJ\u0010\u0007\"\u0004\bK\u0010;R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010.\u001a\u0004\bL\u0010\u0004\"\u0004\bM\u00101R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010.\u001a\u0004\bN\u0010\u0004\"\u0004\bO\u00101"}, d2 = {"Lid/dana/domain/investment/model/UserInvestmentInfo;", "", "", "component1", "()Ljava/lang/String;", "Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "component10", "()Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "component11", "component12", "Lid/dana/domain/investment/AccountInvestmentStatus;", "component2", "()Lid/dana/domain/investment/AccountInvestmentStatus;", "component3", "component4", "Lid/dana/domain/investment/model/InvestmentUnitInfo;", "component5", "()Lid/dana/domain/investment/model/InvestmentUnitInfo;", "component6", "component7", "component8", "", "component9", "()Ljava/lang/Long;", "accountId", "accountStatus", "aggregator", "availableBalance", "balanceUnit", "dailyGainLossAmount", "dailyGainLossPercentage", "goodsId", BaseKey.LAST_UPDATED, "totalGainLossAmount", "totalGainLossPercentage", "userId", "copy", "(Ljava/lang/String;Lid/dana/domain/investment/AccountInvestmentStatus;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Lid/dana/domain/investment/model/InvestmentUnitInfo;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/investment/model/UserInvestmentInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAccountId", "setAccountId", "(Ljava/lang/String;)V", "Lid/dana/domain/investment/AccountInvestmentStatus;", "getAccountStatus", "setAccountStatus", "(Lid/dana/domain/investment/AccountInvestmentStatus;)V", "getAggregator", "setAggregator", "Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "getAvailableBalance", "setAvailableBalance", "(Lid/dana/domain/investment/model/MultiCurrencyMoneyView;)V", "Lid/dana/domain/investment/model/InvestmentUnitInfo;", "getBalanceUnit", "setBalanceUnit", "(Lid/dana/domain/investment/model/InvestmentUnitInfo;)V", "getDailyGainLossAmount", "setDailyGainLossAmount", "getDailyGainLossPercentage", "setDailyGainLossPercentage", "getGoodsId", "setGoodsId", "Ljava/lang/Long;", "getLastUpdated", "setLastUpdated", "(Ljava/lang/Long;)V", "getTotalGainLossAmount", "setTotalGainLossAmount", "getTotalGainLossPercentage", "setTotalGainLossPercentage", "getUserId", "setUserId", "<init>", "(Ljava/lang/String;Lid/dana/domain/investment/AccountInvestmentStatus;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Lid/dana/domain/investment/model/InvestmentUnitInfo;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class UserInvestmentInfo {
    private String accountId;
    private AccountInvestmentStatus accountStatus;
    private String aggregator;
    private MultiCurrencyMoneyView availableBalance;
    private InvestmentUnitInfo balanceUnit;
    private MultiCurrencyMoneyView dailyGainLossAmount;
    private String dailyGainLossPercentage;
    private String goodsId;
    private Long lastUpdated;
    private MultiCurrencyMoneyView totalGainLossAmount;
    private String totalGainLossPercentage;
    private String userId;

    /* renamed from: component1  reason: from getter */
    public final String getAccountId() {
        return this.accountId;
    }

    /* renamed from: component10  reason: from getter */
    public final MultiCurrencyMoneyView getTotalGainLossAmount() {
        return this.totalGainLossAmount;
    }

    /* renamed from: component11  reason: from getter */
    public final String getTotalGainLossPercentage() {
        return this.totalGainLossPercentage;
    }

    /* renamed from: component12  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2  reason: from getter */
    public final AccountInvestmentStatus getAccountStatus() {
        return this.accountStatus;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAggregator() {
        return this.aggregator;
    }

    /* renamed from: component4  reason: from getter */
    public final MultiCurrencyMoneyView getAvailableBalance() {
        return this.availableBalance;
    }

    /* renamed from: component5  reason: from getter */
    public final InvestmentUnitInfo getBalanceUnit() {
        return this.balanceUnit;
    }

    /* renamed from: component6  reason: from getter */
    public final MultiCurrencyMoneyView getDailyGainLossAmount() {
        return this.dailyGainLossAmount;
    }

    /* renamed from: component7  reason: from getter */
    public final String getDailyGainLossPercentage() {
        return this.dailyGainLossPercentage;
    }

    /* renamed from: component8  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component9  reason: from getter */
    public final Long getLastUpdated() {
        return this.lastUpdated;
    }

    public final UserInvestmentInfo copy(String accountId, AccountInvestmentStatus accountStatus, String aggregator, MultiCurrencyMoneyView availableBalance, InvestmentUnitInfo balanceUnit, MultiCurrencyMoneyView dailyGainLossAmount, String dailyGainLossPercentage, String goodsId, Long lastUpdated, MultiCurrencyMoneyView totalGainLossAmount, String totalGainLossPercentage, String userId) {
        Intrinsics.checkNotNullParameter(accountStatus, "");
        return new UserInvestmentInfo(accountId, accountStatus, aggregator, availableBalance, balanceUnit, dailyGainLossAmount, dailyGainLossPercentage, goodsId, lastUpdated, totalGainLossAmount, totalGainLossPercentage, userId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserInvestmentInfo) {
            UserInvestmentInfo userInvestmentInfo = (UserInvestmentInfo) other;
            return Intrinsics.areEqual(this.accountId, userInvestmentInfo.accountId) && this.accountStatus == userInvestmentInfo.accountStatus && Intrinsics.areEqual(this.aggregator, userInvestmentInfo.aggregator) && Intrinsics.areEqual(this.availableBalance, userInvestmentInfo.availableBalance) && Intrinsics.areEqual(this.balanceUnit, userInvestmentInfo.balanceUnit) && Intrinsics.areEqual(this.dailyGainLossAmount, userInvestmentInfo.dailyGainLossAmount) && Intrinsics.areEqual(this.dailyGainLossPercentage, userInvestmentInfo.dailyGainLossPercentage) && Intrinsics.areEqual(this.goodsId, userInvestmentInfo.goodsId) && Intrinsics.areEqual(this.lastUpdated, userInvestmentInfo.lastUpdated) && Intrinsics.areEqual(this.totalGainLossAmount, userInvestmentInfo.totalGainLossAmount) && Intrinsics.areEqual(this.totalGainLossPercentage, userInvestmentInfo.totalGainLossPercentage) && Intrinsics.areEqual(this.userId, userInvestmentInfo.userId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.accountId;
        int hashCode = str == null ? 0 : str.hashCode();
        int hashCode2 = this.accountStatus.hashCode();
        String str2 = this.aggregator;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        MultiCurrencyMoneyView multiCurrencyMoneyView = this.availableBalance;
        int hashCode4 = multiCurrencyMoneyView == null ? 0 : multiCurrencyMoneyView.hashCode();
        InvestmentUnitInfo investmentUnitInfo = this.balanceUnit;
        int hashCode5 = investmentUnitInfo == null ? 0 : investmentUnitInfo.hashCode();
        MultiCurrencyMoneyView multiCurrencyMoneyView2 = this.dailyGainLossAmount;
        int hashCode6 = multiCurrencyMoneyView2 == null ? 0 : multiCurrencyMoneyView2.hashCode();
        String str3 = this.dailyGainLossPercentage;
        int hashCode7 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.goodsId;
        int hashCode8 = str4 == null ? 0 : str4.hashCode();
        Long l = this.lastUpdated;
        int hashCode9 = l == null ? 0 : l.hashCode();
        MultiCurrencyMoneyView multiCurrencyMoneyView3 = this.totalGainLossAmount;
        int hashCode10 = multiCurrencyMoneyView3 == null ? 0 : multiCurrencyMoneyView3.hashCode();
        String str5 = this.totalGainLossPercentage;
        int hashCode11 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.userId;
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserInvestmentInfo(accountId=");
        sb.append(this.accountId);
        sb.append(", accountStatus=");
        sb.append(this.accountStatus);
        sb.append(", aggregator=");
        sb.append(this.aggregator);
        sb.append(", availableBalance=");
        sb.append(this.availableBalance);
        sb.append(", balanceUnit=");
        sb.append(this.balanceUnit);
        sb.append(", dailyGainLossAmount=");
        sb.append(this.dailyGainLossAmount);
        sb.append(", dailyGainLossPercentage=");
        sb.append(this.dailyGainLossPercentage);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", lastUpdated=");
        sb.append(this.lastUpdated);
        sb.append(", totalGainLossAmount=");
        sb.append(this.totalGainLossAmount);
        sb.append(", totalGainLossPercentage=");
        sb.append(this.totalGainLossPercentage);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(')');
        return sb.toString();
    }

    public UserInvestmentInfo(String str, AccountInvestmentStatus accountInvestmentStatus, String str2, MultiCurrencyMoneyView multiCurrencyMoneyView, InvestmentUnitInfo investmentUnitInfo, MultiCurrencyMoneyView multiCurrencyMoneyView2, String str3, String str4, Long l, MultiCurrencyMoneyView multiCurrencyMoneyView3, String str5, String str6) {
        Intrinsics.checkNotNullParameter(accountInvestmentStatus, "");
        this.accountId = str;
        this.accountStatus = accountInvestmentStatus;
        this.aggregator = str2;
        this.availableBalance = multiCurrencyMoneyView;
        this.balanceUnit = investmentUnitInfo;
        this.dailyGainLossAmount = multiCurrencyMoneyView2;
        this.dailyGainLossPercentage = str3;
        this.goodsId = str4;
        this.lastUpdated = l;
        this.totalGainLossAmount = multiCurrencyMoneyView3;
        this.totalGainLossPercentage = str5;
        this.userId = str6;
    }

    @JvmName(name = "getAccountId")
    public final String getAccountId() {
        return this.accountId;
    }

    @JvmName(name = "setAccountId")
    public final void setAccountId(String str) {
        this.accountId = str;
    }

    @JvmName(name = "getAccountStatus")
    public final AccountInvestmentStatus getAccountStatus() {
        return this.accountStatus;
    }

    @JvmName(name = "setAccountStatus")
    public final void setAccountStatus(AccountInvestmentStatus accountInvestmentStatus) {
        Intrinsics.checkNotNullParameter(accountInvestmentStatus, "");
        this.accountStatus = accountInvestmentStatus;
    }

    @JvmName(name = "getAggregator")
    public final String getAggregator() {
        return this.aggregator;
    }

    @JvmName(name = "setAggregator")
    public final void setAggregator(String str) {
        this.aggregator = str;
    }

    @JvmName(name = "getAvailableBalance")
    public final MultiCurrencyMoneyView getAvailableBalance() {
        return this.availableBalance;
    }

    @JvmName(name = "setAvailableBalance")
    public final void setAvailableBalance(MultiCurrencyMoneyView multiCurrencyMoneyView) {
        this.availableBalance = multiCurrencyMoneyView;
    }

    @JvmName(name = "getBalanceUnit")
    public final InvestmentUnitInfo getBalanceUnit() {
        return this.balanceUnit;
    }

    @JvmName(name = "setBalanceUnit")
    public final void setBalanceUnit(InvestmentUnitInfo investmentUnitInfo) {
        this.balanceUnit = investmentUnitInfo;
    }

    @JvmName(name = "getDailyGainLossAmount")
    public final MultiCurrencyMoneyView getDailyGainLossAmount() {
        return this.dailyGainLossAmount;
    }

    @JvmName(name = "setDailyGainLossAmount")
    public final void setDailyGainLossAmount(MultiCurrencyMoneyView multiCurrencyMoneyView) {
        this.dailyGainLossAmount = multiCurrencyMoneyView;
    }

    @JvmName(name = "getDailyGainLossPercentage")
    public final String getDailyGainLossPercentage() {
        return this.dailyGainLossPercentage;
    }

    @JvmName(name = "setDailyGainLossPercentage")
    public final void setDailyGainLossPercentage(String str) {
        this.dailyGainLossPercentage = str;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "setGoodsId")
    public final void setGoodsId(String str) {
        this.goodsId = str;
    }

    public /* synthetic */ UserInvestmentInfo(String str, AccountInvestmentStatus accountInvestmentStatus, String str2, MultiCurrencyMoneyView multiCurrencyMoneyView, InvestmentUnitInfo investmentUnitInfo, MultiCurrencyMoneyView multiCurrencyMoneyView2, String str3, String str4, Long l, MultiCurrencyMoneyView multiCurrencyMoneyView3, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, accountInvestmentStatus, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? null : multiCurrencyMoneyView, (i & 16) != 0 ? null : investmentUnitInfo, (i & 32) != 0 ? null : multiCurrencyMoneyView2, (i & 64) != 0 ? "" : str3, (i & 128) != 0 ? "" : str4, (i & 256) != 0 ? 0L : l, (i & 512) != 0 ? null : multiCurrencyMoneyView3, (i & 1024) != 0 ? "" : str5, (i & 2048) != 0 ? "" : str6);
    }

    @JvmName(name = "getLastUpdated")
    public final Long getLastUpdated() {
        return this.lastUpdated;
    }

    @JvmName(name = "setLastUpdated")
    public final void setLastUpdated(Long l) {
        this.lastUpdated = l;
    }

    @JvmName(name = "getTotalGainLossAmount")
    public final MultiCurrencyMoneyView getTotalGainLossAmount() {
        return this.totalGainLossAmount;
    }

    @JvmName(name = "setTotalGainLossAmount")
    public final void setTotalGainLossAmount(MultiCurrencyMoneyView multiCurrencyMoneyView) {
        this.totalGainLossAmount = multiCurrencyMoneyView;
    }

    @JvmName(name = "getTotalGainLossPercentage")
    public final String getTotalGainLossPercentage() {
        return this.totalGainLossPercentage;
    }

    @JvmName(name = "setTotalGainLossPercentage")
    public final void setTotalGainLossPercentage(String str) {
        this.totalGainLossPercentage = str;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "setUserId")
    public final void setUserId(String str) {
        this.userId = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserInvestmentInfo(AccountInvestmentStatus accountInvestmentStatus) {
        this(null, accountInvestmentStatus, null, null, null, null, null, null, null, null, null, "", 2045, null);
        Intrinsics.checkNotNullParameter(accountInvestmentStatus, "");
    }
}

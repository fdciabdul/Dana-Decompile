package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import id.dana.requestmoney.BundleKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0011\u0012\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000e\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010&\u001a\u0004\u0018\u00010\t\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bE\u0010FJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0013J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0013J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0013J\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0010J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0007JÄ\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010-\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b1\u0010\u0007R\u0019\u0010(\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b(\u00102\u001a\u0004\b3\u0010\u0007R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\b5\u0010\u0004R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00106\u001a\u0004\b7\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00108\u001a\u0004\b9\u0010\u0013R\u001c\u0010#\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u00102\u001a\u0004\b:\u0010\u0007R\u001c\u0010$\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u00102\u001a\u0004\b;\u0010\u0007R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00108\u001a\u0004\b<\u0010\u0013R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b=\u0010\u0013R\u001c\u0010 \u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00108\u001a\u0004\b>\u0010\u0013R\u001c\u0010!\u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00108\u001a\u0004\b?\u0010\u0013R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00106\u001a\u0004\b@\u0010\u0010R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u00104\u001a\u0004\bA\u0010\u0004R\u001c\u0010&\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010B\u001a\u0004\bC\u0010\u000bR\u001c\u0010'\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u00102\u001a\u0004\bD\u0010\u0007"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/TopUpConsultResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/Boolean;", "", "component10", "()Ljava/lang/String;", "component11", "", "component12", "()Ljava/lang/Integer;", "component13", "component14", "", "component2", "()Ljava/util/List;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component3", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component4", "component5", "component6", "component7", "Lid/dana/cashier/data/repository/source/network/result/PayMethodViewDtoResult;", "component8", "component9", "canSaveCC", "cardSchemes", "currentMonthFundInAmount", BundleKey.MAXIMUM_AMOUNT, "maxBalanceAmount", "maxMonthFundInAmount", BundleKey.MINIMUM_AMOUNT, "payMethodViewDTOs", "expressPayAgreementToken", "maskedLoginId", "reachSaveCardLimit", "saveCardLimitNumber", "userAccountName", "assetAssignNo", "copy", "(Ljava/lang/Boolean;Ljava/util/List;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/result/TopUpConsultResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAssetAssignNo", "Ljava/lang/Boolean;", "getCanSaveCC", "Ljava/util/List;", "getCardSchemes", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getCurrentMonthFundInAmount", "getExpressPayAgreementToken", "getMaskedLoginId", "getMaxAmount", "getMaxBalanceAmount", "getMaxMonthFundInAmount", "getMinAmount", "getPayMethodViewDTOs", "getReachSaveCardLimit", "Ljava/lang/Integer;", "getSaveCardLimitNumber", "getUserAccountName", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TopUpConsultResult extends BaseRpcResultAphome {
    private final String assetAssignNo;
    @SerializedName("canSaveCC")
    private final Boolean canSaveCC;
    private final List<String> cardSchemes;
    private final MoneyViewEntity currentMonthFundInAmount;
    private final String expressPayAgreementToken;
    private final String maskedLoginId;
    private final MoneyViewEntity maxAmount;
    private final MoneyViewEntity maxBalanceAmount;
    private final MoneyViewEntity maxMonthFundInAmount;
    private final MoneyViewEntity minAmount;
    private final List<PayMethodViewDtoResult> payMethodViewDTOs;
    private final Boolean reachSaveCardLimit;
    private final Integer saveCardLimitNumber;
    private final String userAccountName;

    /* renamed from: component1  reason: from getter */
    public final Boolean getCanSaveCC() {
        return this.canSaveCC;
    }

    /* renamed from: component10  reason: from getter */
    public final String getMaskedLoginId() {
        return this.maskedLoginId;
    }

    /* renamed from: component11  reason: from getter */
    public final Boolean getReachSaveCardLimit() {
        return this.reachSaveCardLimit;
    }

    /* renamed from: component12  reason: from getter */
    public final Integer getSaveCardLimitNumber() {
        return this.saveCardLimitNumber;
    }

    /* renamed from: component13  reason: from getter */
    public final String getUserAccountName() {
        return this.userAccountName;
    }

    /* renamed from: component14  reason: from getter */
    public final String getAssetAssignNo() {
        return this.assetAssignNo;
    }

    public final List<String> component2() {
        return this.cardSchemes;
    }

    /* renamed from: component3  reason: from getter */
    public final MoneyViewEntity getCurrentMonthFundInAmount() {
        return this.currentMonthFundInAmount;
    }

    /* renamed from: component4  reason: from getter */
    public final MoneyViewEntity getMaxAmount() {
        return this.maxAmount;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyViewEntity getMaxBalanceAmount() {
        return this.maxBalanceAmount;
    }

    /* renamed from: component6  reason: from getter */
    public final MoneyViewEntity getMaxMonthFundInAmount() {
        return this.maxMonthFundInAmount;
    }

    /* renamed from: component7  reason: from getter */
    public final MoneyViewEntity getMinAmount() {
        return this.minAmount;
    }

    public final List<PayMethodViewDtoResult> component8() {
        return this.payMethodViewDTOs;
    }

    /* renamed from: component9  reason: from getter */
    public final String getExpressPayAgreementToken() {
        return this.expressPayAgreementToken;
    }

    public final TopUpConsultResult copy(Boolean canSaveCC, List<String> cardSchemes, MoneyViewEntity currentMonthFundInAmount, MoneyViewEntity maxAmount, MoneyViewEntity maxBalanceAmount, MoneyViewEntity maxMonthFundInAmount, MoneyViewEntity minAmount, List<PayMethodViewDtoResult> payMethodViewDTOs, String expressPayAgreementToken, String maskedLoginId, Boolean reachSaveCardLimit, Integer saveCardLimitNumber, String userAccountName, String assetAssignNo) {
        return new TopUpConsultResult(canSaveCC, cardSchemes, currentMonthFundInAmount, maxAmount, maxBalanceAmount, maxMonthFundInAmount, minAmount, payMethodViewDTOs, expressPayAgreementToken, maskedLoginId, reachSaveCardLimit, saveCardLimitNumber, userAccountName, assetAssignNo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TopUpConsultResult) {
            TopUpConsultResult topUpConsultResult = (TopUpConsultResult) other;
            return Intrinsics.areEqual(this.canSaveCC, topUpConsultResult.canSaveCC) && Intrinsics.areEqual(this.cardSchemes, topUpConsultResult.cardSchemes) && Intrinsics.areEqual(this.currentMonthFundInAmount, topUpConsultResult.currentMonthFundInAmount) && Intrinsics.areEqual(this.maxAmount, topUpConsultResult.maxAmount) && Intrinsics.areEqual(this.maxBalanceAmount, topUpConsultResult.maxBalanceAmount) && Intrinsics.areEqual(this.maxMonthFundInAmount, topUpConsultResult.maxMonthFundInAmount) && Intrinsics.areEqual(this.minAmount, topUpConsultResult.minAmount) && Intrinsics.areEqual(this.payMethodViewDTOs, topUpConsultResult.payMethodViewDTOs) && Intrinsics.areEqual(this.expressPayAgreementToken, topUpConsultResult.expressPayAgreementToken) && Intrinsics.areEqual(this.maskedLoginId, topUpConsultResult.maskedLoginId) && Intrinsics.areEqual(this.reachSaveCardLimit, topUpConsultResult.reachSaveCardLimit) && Intrinsics.areEqual(this.saveCardLimitNumber, topUpConsultResult.saveCardLimitNumber) && Intrinsics.areEqual(this.userAccountName, topUpConsultResult.userAccountName) && Intrinsics.areEqual(this.assetAssignNo, topUpConsultResult.assetAssignNo);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.canSaveCC;
        int hashCode = bool == null ? 0 : bool.hashCode();
        List<String> list = this.cardSchemes;
        int hashCode2 = list == null ? 0 : list.hashCode();
        MoneyViewEntity moneyViewEntity = this.currentMonthFundInAmount;
        int hashCode3 = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
        MoneyViewEntity moneyViewEntity2 = this.maxAmount;
        int hashCode4 = moneyViewEntity2 == null ? 0 : moneyViewEntity2.hashCode();
        MoneyViewEntity moneyViewEntity3 = this.maxBalanceAmount;
        int hashCode5 = moneyViewEntity3 == null ? 0 : moneyViewEntity3.hashCode();
        MoneyViewEntity moneyViewEntity4 = this.maxMonthFundInAmount;
        int hashCode6 = moneyViewEntity4 == null ? 0 : moneyViewEntity4.hashCode();
        MoneyViewEntity moneyViewEntity5 = this.minAmount;
        int hashCode7 = moneyViewEntity5 == null ? 0 : moneyViewEntity5.hashCode();
        List<PayMethodViewDtoResult> list2 = this.payMethodViewDTOs;
        int hashCode8 = list2 == null ? 0 : list2.hashCode();
        String str = this.expressPayAgreementToken;
        int hashCode9 = str == null ? 0 : str.hashCode();
        String str2 = this.maskedLoginId;
        int hashCode10 = str2 == null ? 0 : str2.hashCode();
        Boolean bool2 = this.reachSaveCardLimit;
        int hashCode11 = bool2 == null ? 0 : bool2.hashCode();
        Integer num = this.saveCardLimitNumber;
        int hashCode12 = num == null ? 0 : num.hashCode();
        String str3 = this.userAccountName;
        int hashCode13 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.assetAssignNo;
        return (((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpConsultResult(canSaveCC=");
        sb.append(this.canSaveCC);
        sb.append(", cardSchemes=");
        sb.append(this.cardSchemes);
        sb.append(", currentMonthFundInAmount=");
        sb.append(this.currentMonthFundInAmount);
        sb.append(", maxAmount=");
        sb.append(this.maxAmount);
        sb.append(", maxBalanceAmount=");
        sb.append(this.maxBalanceAmount);
        sb.append(", maxMonthFundInAmount=");
        sb.append(this.maxMonthFundInAmount);
        sb.append(", minAmount=");
        sb.append(this.minAmount);
        sb.append(", payMethodViewDTOs=");
        sb.append(this.payMethodViewDTOs);
        sb.append(", expressPayAgreementToken=");
        sb.append(this.expressPayAgreementToken);
        sb.append(", maskedLoginId=");
        sb.append(this.maskedLoginId);
        sb.append(", reachSaveCardLimit=");
        sb.append(this.reachSaveCardLimit);
        sb.append(", saveCardLimitNumber=");
        sb.append(this.saveCardLimitNumber);
        sb.append(", userAccountName=");
        sb.append(this.userAccountName);
        sb.append(", assetAssignNo=");
        sb.append(this.assetAssignNo);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getCanSaveCC")
    public final Boolean getCanSaveCC() {
        return this.canSaveCC;
    }

    @JvmName(name = "getCardSchemes")
    public final List<String> getCardSchemes() {
        return this.cardSchemes;
    }

    @JvmName(name = "getCurrentMonthFundInAmount")
    public final MoneyViewEntity getCurrentMonthFundInAmount() {
        return this.currentMonthFundInAmount;
    }

    @JvmName(name = "getMaxAmount")
    public final MoneyViewEntity getMaxAmount() {
        return this.maxAmount;
    }

    @JvmName(name = "getMaxBalanceAmount")
    public final MoneyViewEntity getMaxBalanceAmount() {
        return this.maxBalanceAmount;
    }

    @JvmName(name = "getMaxMonthFundInAmount")
    public final MoneyViewEntity getMaxMonthFundInAmount() {
        return this.maxMonthFundInAmount;
    }

    @JvmName(name = "getMinAmount")
    public final MoneyViewEntity getMinAmount() {
        return this.minAmount;
    }

    @JvmName(name = "getPayMethodViewDTOs")
    public final List<PayMethodViewDtoResult> getPayMethodViewDTOs() {
        return this.payMethodViewDTOs;
    }

    @JvmName(name = "getExpressPayAgreementToken")
    public final String getExpressPayAgreementToken() {
        return this.expressPayAgreementToken;
    }

    @JvmName(name = "getMaskedLoginId")
    public final String getMaskedLoginId() {
        return this.maskedLoginId;
    }

    @JvmName(name = "getReachSaveCardLimit")
    public final Boolean getReachSaveCardLimit() {
        return this.reachSaveCardLimit;
    }

    @JvmName(name = "getSaveCardLimitNumber")
    public final Integer getSaveCardLimitNumber() {
        return this.saveCardLimitNumber;
    }

    @JvmName(name = "getUserAccountName")
    public final String getUserAccountName() {
        return this.userAccountName;
    }

    @JvmName(name = "getAssetAssignNo")
    public final String getAssetAssignNo() {
        return this.assetAssignNo;
    }

    public TopUpConsultResult(Boolean bool, List<String> list, MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, MoneyViewEntity moneyViewEntity3, MoneyViewEntity moneyViewEntity4, MoneyViewEntity moneyViewEntity5, List<PayMethodViewDtoResult> list2, String str, String str2, Boolean bool2, Integer num, String str3, String str4) {
        this.canSaveCC = bool;
        this.cardSchemes = list;
        this.currentMonthFundInAmount = moneyViewEntity;
        this.maxAmount = moneyViewEntity2;
        this.maxBalanceAmount = moneyViewEntity3;
        this.maxMonthFundInAmount = moneyViewEntity4;
        this.minAmount = moneyViewEntity5;
        this.payMethodViewDTOs = list2;
        this.expressPayAgreementToken = str;
        this.maskedLoginId = str2;
        this.reachSaveCardLimit = bool2;
        this.saveCardLimitNumber = num;
        this.userAccountName = str3;
        this.assetAssignNo = str4;
    }
}

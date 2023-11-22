package id.dana.cashier.domain.model;

import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.requestmoney.BundleKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b5\b\u0086\b\u0018\u00002\u00020\u0001B½\u0001\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0014\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0014\u0012\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0011\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010)\u001a\u0004\u0018\u00010\t\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bO\u0010PJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0016J\u0018\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0013J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0007Jè\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00112\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b/\u00100J\u001a\u00102\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b6\u0010\u0007R\u0019\u0010+\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b+\u00107\u001a\u0004\b8\u0010\u0007R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00109\u001a\u0004\b:\u0010\u0004R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010;\u001a\u0004\b<\u0010\u0013R\u001c\u0010 \u001a\u0004\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010=\u001a\u0004\b>\u0010\u0016R\u001c\u0010-\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u00107\u001a\u0004\b?\u0010\u0007R\u001c\u0010.\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u00107\u001a\u0004\b@\u0010\u0007R\u001c\u0010&\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u00107\u001a\u0004\bA\u0010\u0007R\u001c\u0010'\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u00107\u001a\u0004\bB\u0010\u0007R\u001c\u0010!\u001a\u0004\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010=\u001a\u0004\bC\u0010\u0016R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010=\u001a\u0004\bD\u0010\u0016R\u001c\u0010#\u001a\u0004\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010=\u001a\u0004\bE\u0010\u0016R\u001c\u0010$\u001a\u0004\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010=\u001a\u0004\bF\u0010\u0016R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010;\u001a\u0004\bG\u0010\u0013R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u00109\u001a\u0004\bH\u0010\u0004R\u001c\u0010)\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010I\u001a\u0004\bJ\u0010\u000bR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u00109\u001a\u0004\bK\u0010\u0004\"\u0004\bL\u0010MR\u001c\u0010*\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u00107\u001a\u0004\bN\u0010\u0007"}, d2 = {"Lid/dana/cashier/domain/model/TopUpConsult;", "", "", "component1", "()Ljava/lang/Boolean;", "", "component10", "()Ljava/lang/String;", "component11", "", "component12", "()Ljava/lang/Integer;", "component13", "component14", "component15", "component16", "component17", "", "component2", "()Ljava/util/List;", "Lid/dana/domain/nearbyme/model/MoneyView;", "component3", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component4", "component5", "component6", "component7", "Lid/dana/cashier/domain/model/PayMethodViewDto;", "component8", "component9", "canSaveCC", "cardSchemes", "currentMonthFundInAmount", BundleKey.MAXIMUM_AMOUNT, "maxBalanceAmount", "maxMonthFundInAmount", BundleKey.MINIMUM_AMOUNT, "payMethodViewDTOs", "expressPayAgreementToken", "maskedLoginId", "reachSaveCardLimit", "saveCardLimitNumber", "userAccountName", "assetAssignNo", "success", "errorCode", "errorMessage", "copy", "(Ljava/lang/Boolean;Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/domain/model/TopUpConsult;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAssetAssignNo", "Ljava/lang/Boolean;", "getCanSaveCC", "Ljava/util/List;", "getCardSchemes", "Lid/dana/domain/nearbyme/model/MoneyView;", "getCurrentMonthFundInAmount", "getErrorCode", "getErrorMessage", "getExpressPayAgreementToken", "getMaskedLoginId", "getMaxAmount", "getMaxBalanceAmount", "getMaxMonthFundInAmount", "getMinAmount", "getPayMethodViewDTOs", "getReachSaveCardLimit", "Ljava/lang/Integer;", "getSaveCardLimitNumber", "getSuccess", "setSuccess", "(Ljava/lang/Boolean;)V", "getUserAccountName", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TopUpConsult {
    private final String assetAssignNo;
    private final Boolean canSaveCC;
    private final List<String> cardSchemes;
    private final MoneyView currentMonthFundInAmount;
    private final String errorCode;
    private final String errorMessage;
    private final String expressPayAgreementToken;
    private final String maskedLoginId;
    private final MoneyView maxAmount;
    private final MoneyView maxBalanceAmount;
    private final MoneyView maxMonthFundInAmount;
    private final MoneyView minAmount;
    private final List<PayMethodViewDto> payMethodViewDTOs;
    private final Boolean reachSaveCardLimit;
    private final Integer saveCardLimitNumber;
    private Boolean success;
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

    /* renamed from: component15  reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component16  reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component17  reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final List<String> component2() {
        return this.cardSchemes;
    }

    /* renamed from: component3  reason: from getter */
    public final MoneyView getCurrentMonthFundInAmount() {
        return this.currentMonthFundInAmount;
    }

    /* renamed from: component4  reason: from getter */
    public final MoneyView getMaxAmount() {
        return this.maxAmount;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyView getMaxBalanceAmount() {
        return this.maxBalanceAmount;
    }

    /* renamed from: component6  reason: from getter */
    public final MoneyView getMaxMonthFundInAmount() {
        return this.maxMonthFundInAmount;
    }

    /* renamed from: component7  reason: from getter */
    public final MoneyView getMinAmount() {
        return this.minAmount;
    }

    public final List<PayMethodViewDto> component8() {
        return this.payMethodViewDTOs;
    }

    /* renamed from: component9  reason: from getter */
    public final String getExpressPayAgreementToken() {
        return this.expressPayAgreementToken;
    }

    public final TopUpConsult copy(Boolean canSaveCC, List<String> cardSchemes, MoneyView currentMonthFundInAmount, MoneyView maxAmount, MoneyView maxBalanceAmount, MoneyView maxMonthFundInAmount, MoneyView minAmount, List<PayMethodViewDto> payMethodViewDTOs, String expressPayAgreementToken, String maskedLoginId, Boolean reachSaveCardLimit, Integer saveCardLimitNumber, String userAccountName, String assetAssignNo, Boolean success, String errorCode, String errorMessage) {
        return new TopUpConsult(canSaveCC, cardSchemes, currentMonthFundInAmount, maxAmount, maxBalanceAmount, maxMonthFundInAmount, minAmount, payMethodViewDTOs, expressPayAgreementToken, maskedLoginId, reachSaveCardLimit, saveCardLimitNumber, userAccountName, assetAssignNo, success, errorCode, errorMessage);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TopUpConsult) {
            TopUpConsult topUpConsult = (TopUpConsult) other;
            return Intrinsics.areEqual(this.canSaveCC, topUpConsult.canSaveCC) && Intrinsics.areEqual(this.cardSchemes, topUpConsult.cardSchemes) && Intrinsics.areEqual(this.currentMonthFundInAmount, topUpConsult.currentMonthFundInAmount) && Intrinsics.areEqual(this.maxAmount, topUpConsult.maxAmount) && Intrinsics.areEqual(this.maxBalanceAmount, topUpConsult.maxBalanceAmount) && Intrinsics.areEqual(this.maxMonthFundInAmount, topUpConsult.maxMonthFundInAmount) && Intrinsics.areEqual(this.minAmount, topUpConsult.minAmount) && Intrinsics.areEqual(this.payMethodViewDTOs, topUpConsult.payMethodViewDTOs) && Intrinsics.areEqual(this.expressPayAgreementToken, topUpConsult.expressPayAgreementToken) && Intrinsics.areEqual(this.maskedLoginId, topUpConsult.maskedLoginId) && Intrinsics.areEqual(this.reachSaveCardLimit, topUpConsult.reachSaveCardLimit) && Intrinsics.areEqual(this.saveCardLimitNumber, topUpConsult.saveCardLimitNumber) && Intrinsics.areEqual(this.userAccountName, topUpConsult.userAccountName) && Intrinsics.areEqual(this.assetAssignNo, topUpConsult.assetAssignNo) && Intrinsics.areEqual(this.success, topUpConsult.success) && Intrinsics.areEqual(this.errorCode, topUpConsult.errorCode) && Intrinsics.areEqual(this.errorMessage, topUpConsult.errorMessage);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.canSaveCC;
        int hashCode = bool == null ? 0 : bool.hashCode();
        List<String> list = this.cardSchemes;
        int hashCode2 = list == null ? 0 : list.hashCode();
        MoneyView moneyView = this.currentMonthFundInAmount;
        int hashCode3 = moneyView == null ? 0 : moneyView.hashCode();
        MoneyView moneyView2 = this.maxAmount;
        int hashCode4 = moneyView2 == null ? 0 : moneyView2.hashCode();
        MoneyView moneyView3 = this.maxBalanceAmount;
        int hashCode5 = moneyView3 == null ? 0 : moneyView3.hashCode();
        MoneyView moneyView4 = this.maxMonthFundInAmount;
        int hashCode6 = moneyView4 == null ? 0 : moneyView4.hashCode();
        MoneyView moneyView5 = this.minAmount;
        int hashCode7 = moneyView5 == null ? 0 : moneyView5.hashCode();
        List<PayMethodViewDto> list2 = this.payMethodViewDTOs;
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
        int hashCode14 = str4 == null ? 0 : str4.hashCode();
        Boolean bool3 = this.success;
        int hashCode15 = bool3 == null ? 0 : bool3.hashCode();
        String str5 = this.errorCode;
        int hashCode16 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.errorMessage;
        return (((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpConsult(canSaveCC=");
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
        sb.append(", success=");
        sb.append(this.success);
        sb.append(", errorCode=");
        sb.append(this.errorCode);
        sb.append(", errorMessage=");
        sb.append(this.errorMessage);
        sb.append(')');
        return sb.toString();
    }

    public TopUpConsult(Boolean bool, List<String> list, MoneyView moneyView, MoneyView moneyView2, MoneyView moneyView3, MoneyView moneyView4, MoneyView moneyView5, List<PayMethodViewDto> list2, String str, String str2, Boolean bool2, Integer num, String str3, String str4, Boolean bool3, String str5, String str6) {
        this.canSaveCC = bool;
        this.cardSchemes = list;
        this.currentMonthFundInAmount = moneyView;
        this.maxAmount = moneyView2;
        this.maxBalanceAmount = moneyView3;
        this.maxMonthFundInAmount = moneyView4;
        this.minAmount = moneyView5;
        this.payMethodViewDTOs = list2;
        this.expressPayAgreementToken = str;
        this.maskedLoginId = str2;
        this.reachSaveCardLimit = bool2;
        this.saveCardLimitNumber = num;
        this.userAccountName = str3;
        this.assetAssignNo = str4;
        this.success = bool3;
        this.errorCode = str5;
        this.errorMessage = str6;
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
    public final MoneyView getCurrentMonthFundInAmount() {
        return this.currentMonthFundInAmount;
    }

    @JvmName(name = "getMaxAmount")
    public final MoneyView getMaxAmount() {
        return this.maxAmount;
    }

    @JvmName(name = "getMaxBalanceAmount")
    public final MoneyView getMaxBalanceAmount() {
        return this.maxBalanceAmount;
    }

    @JvmName(name = "getMaxMonthFundInAmount")
    public final MoneyView getMaxMonthFundInAmount() {
        return this.maxMonthFundInAmount;
    }

    @JvmName(name = "getMinAmount")
    public final MoneyView getMinAmount() {
        return this.minAmount;
    }

    @JvmName(name = "getPayMethodViewDTOs")
    public final List<PayMethodViewDto> getPayMethodViewDTOs() {
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

    @JvmName(name = "getSuccess")
    public final Boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "setSuccess")
    public final void setSuccess(Boolean bool) {
        this.success = bool;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    @JvmName(name = "getErrorMessage")
    public final String getErrorMessage() {
        return this.errorMessage;
    }
}

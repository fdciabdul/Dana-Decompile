package id.dana.cashier.domain.model;

import id.dana.data.constant.UrlParam;
import id.dana.data.encryptcardno.CardCredInfo;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f¢\u0006\u0004\bR\u0010SJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u001e\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004Jè\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b,\u0010-J\u001a\u0010/\u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b/\u00100J\u0010\u00102\u001a\u000201HÖ\u0001¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b4\u0010\u0004R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u00105\u001a\u0004\b6\u0010\u0004\"\u0004\b7\u00108R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u00105\u001a\u0004\b9\u0010\u0004R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u00105\u001a\u0004\b:\u0010\u0004R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u00105\u001a\u0004\b;\u0010\u0004R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00105\u001a\u0004\b<\u0010\u0004R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u00105\u001a\u0004\b=\u0010\u0004R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u00105\u001a\u0004\b>\u0010\u0004R$\u0010)\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u00105\u001a\u0004\b?\u0010\u0004\"\u0004\b@\u00108R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u00105\u001a\u0004\bA\u0010\u0004\"\u0004\bB\u00108R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00105\u001a\u0004\bC\u0010\u0004\"\u0004\bD\u00108R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\bE\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00105\u001a\u0004\bF\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00105\u001a\u0004\bG\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010H\u001a\u0004\bI\u0010\u0012R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010J\u001a\u0004\bK\u0010\u0016R0\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010L\u001a\u0004\bM\u0010\u000e\"\u0004\bN\u0010OR$\u0010*\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u00105\u001a\u0004\bP\u0010\u0004\"\u0004\bQ\u00108"}, d2 = {"Lid/dana/cashier/domain/model/TopUpSubmitRequest;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "", "component17", "()Ljava/util/Map;", "component2", "", "component3", "()Ljava/lang/Boolean;", "component4", "Lid/dana/domain/nearbyme/model/MoneyView;", "component5", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component6", "component7", "component8", "component9", "method", "payMethod", "saveCard", "payOption", "topUpAmount", UrlParam.REQUEST_ID, "expressPayAgreementToken", WalletConstant.CARD_INDEX_NO, "bindingId", CardCredInfo.CARD_EXPIRE_MONTH, CardCredInfo.CARD_EXPIRE_YEAR, CardCredInfo.CARD_NO, "cvv2", "bankPhoneNo", "deviceId", "xcoId", "topupPayOrderInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lid/dana/cashier/domain/model/TopUpSubmitRequest;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBankPhoneNo", "setBankPhoneNo", "(Ljava/lang/String;)V", "getBindingId", "getCardExpireMonth", "getCardExpireYear", "getCardIndexNo", "getCardNo", "getCvv2", "getDeviceId", "setDeviceId", "getExpressPayAgreementToken", "setExpressPayAgreementToken", "getMethod", "setMethod", "getPayMethod", "getPayOption", "getRequestId", "Ljava/lang/Boolean;", "getSaveCard", "Lid/dana/domain/nearbyme/model/MoneyView;", "getTopUpAmount", "Ljava/util/Map;", "getTopupPayOrderInfo", "setTopupPayOrderInfo", "(Ljava/util/Map;)V", "getXcoId", "setXcoId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TopUpSubmitRequest {
    private String bankPhoneNo;
    private final String bindingId;
    private final String cardExpireMonth;
    private final String cardExpireYear;
    private final String cardIndexNo;
    private final String cardNo;
    private final String cvv2;
    private String deviceId;
    private String expressPayAgreementToken;
    private String method;
    private final String payMethod;
    private final String payOption;
    private final String requestId;
    private final Boolean saveCard;
    private final MoneyView topUpAmount;
    private Map<String, String> topupPayOrderInfo;
    private String xcoId;

    /* renamed from: component1  reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component10  reason: from getter */
    public final String getCardExpireMonth() {
        return this.cardExpireMonth;
    }

    /* renamed from: component11  reason: from getter */
    public final String getCardExpireYear() {
        return this.cardExpireYear;
    }

    /* renamed from: component12  reason: from getter */
    public final String getCardNo() {
        return this.cardNo;
    }

    /* renamed from: component13  reason: from getter */
    public final String getCvv2() {
        return this.cvv2;
    }

    /* renamed from: component14  reason: from getter */
    public final String getBankPhoneNo() {
        return this.bankPhoneNo;
    }

    /* renamed from: component15  reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component16  reason: from getter */
    public final String getXcoId() {
        return this.xcoId;
    }

    public final Map<String, String> component17() {
        return this.topupPayOrderInfo;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    /* renamed from: component3  reason: from getter */
    public final Boolean getSaveCard() {
        return this.saveCard;
    }

    /* renamed from: component4  reason: from getter */
    public final String getPayOption() {
        return this.payOption;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyView getTopUpAmount() {
        return this.topUpAmount;
    }

    /* renamed from: component6  reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component7  reason: from getter */
    public final String getExpressPayAgreementToken() {
        return this.expressPayAgreementToken;
    }

    /* renamed from: component8  reason: from getter */
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    /* renamed from: component9  reason: from getter */
    public final String getBindingId() {
        return this.bindingId;
    }

    public final TopUpSubmitRequest copy(String method, String payMethod, Boolean saveCard, String payOption, MoneyView topUpAmount, String requestId, String expressPayAgreementToken, String cardIndexNo, String bindingId, String cardExpireMonth, String cardExpireYear, String cardNo, String cvv2, String bankPhoneNo, String deviceId, String xcoId, Map<String, String> topupPayOrderInfo) {
        return new TopUpSubmitRequest(method, payMethod, saveCard, payOption, topUpAmount, requestId, expressPayAgreementToken, cardIndexNo, bindingId, cardExpireMonth, cardExpireYear, cardNo, cvv2, bankPhoneNo, deviceId, xcoId, topupPayOrderInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TopUpSubmitRequest) {
            TopUpSubmitRequest topUpSubmitRequest = (TopUpSubmitRequest) other;
            return Intrinsics.areEqual(this.method, topUpSubmitRequest.method) && Intrinsics.areEqual(this.payMethod, topUpSubmitRequest.payMethod) && Intrinsics.areEqual(this.saveCard, topUpSubmitRequest.saveCard) && Intrinsics.areEqual(this.payOption, topUpSubmitRequest.payOption) && Intrinsics.areEqual(this.topUpAmount, topUpSubmitRequest.topUpAmount) && Intrinsics.areEqual(this.requestId, topUpSubmitRequest.requestId) && Intrinsics.areEqual(this.expressPayAgreementToken, topUpSubmitRequest.expressPayAgreementToken) && Intrinsics.areEqual(this.cardIndexNo, topUpSubmitRequest.cardIndexNo) && Intrinsics.areEqual(this.bindingId, topUpSubmitRequest.bindingId) && Intrinsics.areEqual(this.cardExpireMonth, topUpSubmitRequest.cardExpireMonth) && Intrinsics.areEqual(this.cardExpireYear, topUpSubmitRequest.cardExpireYear) && Intrinsics.areEqual(this.cardNo, topUpSubmitRequest.cardNo) && Intrinsics.areEqual(this.cvv2, topUpSubmitRequest.cvv2) && Intrinsics.areEqual(this.bankPhoneNo, topUpSubmitRequest.bankPhoneNo) && Intrinsics.areEqual(this.deviceId, topUpSubmitRequest.deviceId) && Intrinsics.areEqual(this.xcoId, topUpSubmitRequest.xcoId) && Intrinsics.areEqual(this.topupPayOrderInfo, topUpSubmitRequest.topupPayOrderInfo);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.method;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.payMethod;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        Boolean bool = this.saveCard;
        int hashCode3 = bool == null ? 0 : bool.hashCode();
        String str3 = this.payOption;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        MoneyView moneyView = this.topUpAmount;
        int hashCode5 = moneyView == null ? 0 : moneyView.hashCode();
        String str4 = this.requestId;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.expressPayAgreementToken;
        int hashCode7 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.cardIndexNo;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.bindingId;
        int hashCode9 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.cardExpireMonth;
        int hashCode10 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.cardExpireYear;
        int hashCode11 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.cardNo;
        int hashCode12 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.cvv2;
        int hashCode13 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.bankPhoneNo;
        int hashCode14 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.deviceId;
        int hashCode15 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.xcoId;
        int hashCode16 = str14 == null ? 0 : str14.hashCode();
        Map<String, String> map = this.topupPayOrderInfo;
        return (((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpSubmitRequest(method=");
        sb.append(this.method);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(", saveCard=");
        sb.append(this.saveCard);
        sb.append(", payOption=");
        sb.append(this.payOption);
        sb.append(", topUpAmount=");
        sb.append(this.topUpAmount);
        sb.append(", requestId=");
        sb.append(this.requestId);
        sb.append(", expressPayAgreementToken=");
        sb.append(this.expressPayAgreementToken);
        sb.append(", cardIndexNo=");
        sb.append(this.cardIndexNo);
        sb.append(", bindingId=");
        sb.append(this.bindingId);
        sb.append(", cardExpireMonth=");
        sb.append(this.cardExpireMonth);
        sb.append(", cardExpireYear=");
        sb.append(this.cardExpireYear);
        sb.append(", cardNo=");
        sb.append(this.cardNo);
        sb.append(", cvv2=");
        sb.append(this.cvv2);
        sb.append(", bankPhoneNo=");
        sb.append(this.bankPhoneNo);
        sb.append(", deviceId=");
        sb.append(this.deviceId);
        sb.append(", xcoId=");
        sb.append(this.xcoId);
        sb.append(", topupPayOrderInfo=");
        sb.append(this.topupPayOrderInfo);
        sb.append(')');
        return sb.toString();
    }

    public TopUpSubmitRequest(String str, String str2, Boolean bool, String str3, MoneyView moneyView, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        this.method = str;
        this.payMethod = str2;
        this.saveCard = bool;
        this.payOption = str3;
        this.topUpAmount = moneyView;
        this.requestId = str4;
        this.expressPayAgreementToken = str5;
        this.cardIndexNo = str6;
        this.bindingId = str7;
        this.cardExpireMonth = str8;
        this.cardExpireYear = str9;
        this.cardNo = str10;
        this.cvv2 = str11;
        this.bankPhoneNo = str12;
        this.deviceId = str13;
        this.xcoId = str14;
        this.topupPayOrderInfo = map;
    }

    public /* synthetic */ TopUpSubmitRequest(String str, String str2, Boolean bool, String str3, MoneyView moneyView, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, str2, bool, str3, moneyView, str4, str5, str6, str7, str8, str9, str10, (i & 4096) != 0 ? "" : str11, (i & 8192) != 0 ? null : str12, (i & 16384) != 0 ? null : str13, (32768 & i) != 0 ? null : str14, (i & 65536) != 0 ? null : map);
    }

    @JvmName(name = "getMethod")
    public final String getMethod() {
        return this.method;
    }

    @JvmName(name = "setMethod")
    public final void setMethod(String str) {
        this.method = str;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getSaveCard")
    public final Boolean getSaveCard() {
        return this.saveCard;
    }

    @JvmName(name = "getPayOption")
    public final String getPayOption() {
        return this.payOption;
    }

    @JvmName(name = "getTopUpAmount")
    public final MoneyView getTopUpAmount() {
        return this.topUpAmount;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    @JvmName(name = "getExpressPayAgreementToken")
    public final String getExpressPayAgreementToken() {
        return this.expressPayAgreementToken;
    }

    @JvmName(name = "setExpressPayAgreementToken")
    public final void setExpressPayAgreementToken(String str) {
        this.expressPayAgreementToken = str;
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "getBindingId")
    public final String getBindingId() {
        return this.bindingId;
    }

    @JvmName(name = "getCardExpireMonth")
    public final String getCardExpireMonth() {
        return this.cardExpireMonth;
    }

    @JvmName(name = "getCardExpireYear")
    public final String getCardExpireYear() {
        return this.cardExpireYear;
    }

    @JvmName(name = "getCardNo")
    public final String getCardNo() {
        return this.cardNo;
    }

    @JvmName(name = "getCvv2")
    public final String getCvv2() {
        return this.cvv2;
    }

    @JvmName(name = "getBankPhoneNo")
    public final String getBankPhoneNo() {
        return this.bankPhoneNo;
    }

    @JvmName(name = "setBankPhoneNo")
    public final void setBankPhoneNo(String str) {
        this.bankPhoneNo = str;
    }

    @JvmName(name = "getDeviceId")
    public final String getDeviceId() {
        return this.deviceId;
    }

    @JvmName(name = "setDeviceId")
    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    @JvmName(name = "getXcoId")
    public final String getXcoId() {
        return this.xcoId;
    }

    @JvmName(name = "setXcoId")
    public final void setXcoId(String str) {
        this.xcoId = str;
    }

    @JvmName(name = "getTopupPayOrderInfo")
    public final Map<String, String> getTopupPayOrderInfo() {
        return this.topupPayOrderInfo;
    }

    @JvmName(name = "setTopupPayOrderInfo")
    public final void setTopupPayOrderInfo(Map<String, String> map) {
        this.topupPayOrderInfo = map;
    }
}

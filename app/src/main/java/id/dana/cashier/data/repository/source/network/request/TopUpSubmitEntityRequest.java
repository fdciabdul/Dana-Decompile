package id.dana.cashier.data.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.data.constant.UrlParam;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t¢\u0006\u0004\bH\u0010IJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004JÄ\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010-\u001a\u00020,HÖ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b/\u0010\u0004R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u00100\u001a\u0004\b1\u0010\u0004\"\u0004\b2\u00103R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00100\u001a\u0004\b4\u0010\u0004R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00100\u001a\u0004\b5\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00100\u001a\u0004\b6\u0010\u0004R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u00100\u001a\u0004\b7\u0010\u0004\"\u0004\b8\u00103R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00100\u001a\u0004\b9\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00100\u001a\u0004\b:\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b;\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00100\u001a\u0004\b<\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00100\u001a\u0004\b=\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010>\u001a\u0004\b?\u0010\u000fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010@\u001a\u0004\bA\u0010\u0013R0\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010B\u001a\u0004\bC\u0010\u000b\"\u0004\bD\u0010ER$\u0010$\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u00100\u001a\u0004\bF\u0010\u0004\"\u0004\bG\u00103"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/TopUpSubmitEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "", "component14", "()Ljava/util/Map;", "component2", "", "component3", "()Ljava/lang/Boolean;", "component4", "Lid/dana/cashier/data/repository/source/network/request/AmountRequest;", "component5", "()Lid/dana/cashier/data/repository/source/network/request/AmountRequest;", "component6", "component7", "component8", "component9", "method", "payMethod", "saveCard", "payOption", "topUpAmount", UrlParam.REQUEST_ID, "expressPayAgreementToken", WalletConstant.CARD_INDEX_NO, "bindingId", "cardCredential", "bankPhoneNo", "deviceId", "xcoId", "topupPayOrderInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lid/dana/cashier/data/repository/source/network/request/AmountRequest;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lid/dana/cashier/data/repository/source/network/request/TopUpSubmitEntityRequest;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBankPhoneNo", "setBankPhoneNo", "(Ljava/lang/String;)V", "getBindingId", "getCardCredential", "getCardIndexNo", "getDeviceId", "setDeviceId", "getExpressPayAgreementToken", "getMethod", "getPayMethod", "getPayOption", "getRequestId", "Ljava/lang/Boolean;", "getSaveCard", "Lid/dana/cashier/data/repository/source/network/request/AmountRequest;", "getTopUpAmount", "Ljava/util/Map;", "getTopupPayOrderInfo", "setTopupPayOrderInfo", "(Ljava/util/Map;)V", "getXcoId", "setXcoId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lid/dana/cashier/data/repository/source/network/request/AmountRequest;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TopUpSubmitEntityRequest extends BaseRpcRequest {
    private String bankPhoneNo;
    private final String bindingId;
    private final String cardCredential;
    private final String cardIndexNo;
    private String deviceId;
    private final String expressPayAgreementToken;
    @SerializedName("method")
    private final String method;
    private final String payMethod;
    private final String payOption;
    private final String requestId;
    private final Boolean saveCard;
    private final AmountRequest topUpAmount;
    private Map<String, String> topupPayOrderInfo;
    private String xcoId;

    /* renamed from: component1  reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component10  reason: from getter */
    public final String getCardCredential() {
        return this.cardCredential;
    }

    /* renamed from: component11  reason: from getter */
    public final String getBankPhoneNo() {
        return this.bankPhoneNo;
    }

    /* renamed from: component12  reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component13  reason: from getter */
    public final String getXcoId() {
        return this.xcoId;
    }

    public final Map<String, String> component14() {
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
    public final AmountRequest getTopUpAmount() {
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

    public final TopUpSubmitEntityRequest copy(String method, String payMethod, Boolean saveCard, String payOption, AmountRequest topUpAmount, String requestId, String expressPayAgreementToken, String cardIndexNo, String bindingId, String cardCredential, String bankPhoneNo, String deviceId, String xcoId, Map<String, String> topupPayOrderInfo) {
        return new TopUpSubmitEntityRequest(method, payMethod, saveCard, payOption, topUpAmount, requestId, expressPayAgreementToken, cardIndexNo, bindingId, cardCredential, bankPhoneNo, deviceId, xcoId, topupPayOrderInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TopUpSubmitEntityRequest) {
            TopUpSubmitEntityRequest topUpSubmitEntityRequest = (TopUpSubmitEntityRequest) other;
            return Intrinsics.areEqual(this.method, topUpSubmitEntityRequest.method) && Intrinsics.areEqual(this.payMethod, topUpSubmitEntityRequest.payMethod) && Intrinsics.areEqual(this.saveCard, topUpSubmitEntityRequest.saveCard) && Intrinsics.areEqual(this.payOption, topUpSubmitEntityRequest.payOption) && Intrinsics.areEqual(this.topUpAmount, topUpSubmitEntityRequest.topUpAmount) && Intrinsics.areEqual(this.requestId, topUpSubmitEntityRequest.requestId) && Intrinsics.areEqual(this.expressPayAgreementToken, topUpSubmitEntityRequest.expressPayAgreementToken) && Intrinsics.areEqual(this.cardIndexNo, topUpSubmitEntityRequest.cardIndexNo) && Intrinsics.areEqual(this.bindingId, topUpSubmitEntityRequest.bindingId) && Intrinsics.areEqual(this.cardCredential, topUpSubmitEntityRequest.cardCredential) && Intrinsics.areEqual(this.bankPhoneNo, topUpSubmitEntityRequest.bankPhoneNo) && Intrinsics.areEqual(this.deviceId, topUpSubmitEntityRequest.deviceId) && Intrinsics.areEqual(this.xcoId, topUpSubmitEntityRequest.xcoId) && Intrinsics.areEqual(this.topupPayOrderInfo, topUpSubmitEntityRequest.topupPayOrderInfo);
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
        AmountRequest amountRequest = this.topUpAmount;
        int hashCode5 = amountRequest == null ? 0 : amountRequest.hashCode();
        String str4 = this.requestId;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.expressPayAgreementToken;
        int hashCode7 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.cardIndexNo;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.bindingId;
        int hashCode9 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.cardCredential;
        int hashCode10 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.bankPhoneNo;
        int hashCode11 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.deviceId;
        int hashCode12 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.xcoId;
        int hashCode13 = str11 == null ? 0 : str11.hashCode();
        Map<String, String> map = this.topupPayOrderInfo;
        return (((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpSubmitEntityRequest(method=");
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
        sb.append(", cardCredential=");
        sb.append(this.cardCredential);
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

    public /* synthetic */ TopUpSubmitEntityRequest(String str, String str2, Boolean bool, String str3, AmountRequest amountRequest, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "topUpSubmit" : str, str2, bool, str3, amountRequest, str4, str5, str6, str7, str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : str11, (i & 8192) != 0 ? null : map);
    }

    @JvmName(name = "getMethod")
    public final String getMethod() {
        return this.method;
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
    public final AmountRequest getTopUpAmount() {
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

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "getBindingId")
    public final String getBindingId() {
        return this.bindingId;
    }

    @JvmName(name = "getCardCredential")
    public final String getCardCredential() {
        return this.cardCredential;
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

    public TopUpSubmitEntityRequest(String str, String str2, Boolean bool, String str3, AmountRequest amountRequest, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Map<String, String> map) {
        this.method = str;
        this.payMethod = str2;
        this.saveCard = bool;
        this.payOption = str3;
        this.topUpAmount = amountRequest;
        this.requestId = str4;
        this.expressPayAgreementToken = str5;
        this.cardIndexNo = str6;
        this.bindingId = str7;
        this.cardCredential = str8;
        this.bankPhoneNo = str9;
        this.deviceId = str10;
        this.xcoId = str11;
        this.topupPayOrderInfo = map;
    }
}

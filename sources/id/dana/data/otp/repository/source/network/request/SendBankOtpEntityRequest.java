package id.dana.data.otp.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.encryptcardno.CardCredInfo;
import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b?\u0010@J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004JÄ\u0001\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b,\u0010\u0004R\u0019\u0010!\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b!\u0010-\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010-\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b1\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b2\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b3\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b4\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010-\u001a\u0004\b5\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b6\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010-\u001a\u0004\b7\u0010\u0004R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010-\u001a\u0004\b8\u0010\u0004\"\u0004\b9\u0010:R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b;\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b<\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b=\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010-\u001a\u0004\b>\u0010\u0004"}, d2 = {"Lid/dana/data/otp/repository/source/network/request/SendBankOtpEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", WalletConstant.CARD_INDEX_NO, CashierKeyParams.CASHIER_ORDER_ID, "bindingId", "cardCredential", "bankPhoneNo", "ektp", CardCredInfo.CARD_NO, "cardType", "instId", CardCredInfo.CARD_EXPIRE_MONTH, CardCredInfo.CARD_EXPIRE_YEAR, "limitAmountDaily", "msisdn", "deviceId", "accountNo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/otp/repository/source/network/request/SendBankOtpEntityRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAccountNo", "getBankPhoneNo", "getBindingId", "getCardCredential", "getCardExpireMonth", "getCardExpireYear", "getCardIndexNo", "getCardNo", "getCardType", "getCashierOrderId", "getDeviceId", "setDeviceId", "(Ljava/lang/String;)V", "getEktp", "getInstId", "getLimitAmountDaily", "getMsisdn", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SendBankOtpEntityRequest extends BaseRpcRequest {
    private final String accountNo;
    private final String bankPhoneNo;
    private final String bindingId;
    private final String cardCredential;
    private final String cardExpireMonth;
    private final String cardExpireYear;
    @SerializedName(WalletConstant.CARD_INDEX_NO)
    private final String cardIndexNo;
    private final String cardNo;
    private final String cardType;
    private final String cashierOrderId;
    private String deviceId;
    private final String ektp;
    private final String instId;
    private final String limitAmountDaily;
    private final String msisdn;

    /* renamed from: component1  reason: from getter */
    public final String getCardIndexNo() {
        return this.cardIndexNo;
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
    public final String getLimitAmountDaily() {
        return this.limitAmountDaily;
    }

    /* renamed from: component13  reason: from getter */
    public final String getMsisdn() {
        return this.msisdn;
    }

    /* renamed from: component14  reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component15  reason: from getter */
    public final String getAccountNo() {
        return this.accountNo;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getBindingId() {
        return this.bindingId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCardCredential() {
        return this.cardCredential;
    }

    /* renamed from: component5  reason: from getter */
    public final String getBankPhoneNo() {
        return this.bankPhoneNo;
    }

    /* renamed from: component6  reason: from getter */
    public final String getEktp() {
        return this.ektp;
    }

    /* renamed from: component7  reason: from getter */
    public final String getCardNo() {
        return this.cardNo;
    }

    /* renamed from: component8  reason: from getter */
    public final String getCardType() {
        return this.cardType;
    }

    /* renamed from: component9  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    public final SendBankOtpEntityRequest copy(String cardIndexNo, String cashierOrderId, String bindingId, String cardCredential, String bankPhoneNo, String ektp, String cardNo, String cardType, String instId, String cardExpireMonth, String cardExpireYear, String limitAmountDaily, String msisdn, String deviceId, String accountNo) {
        return new SendBankOtpEntityRequest(cardIndexNo, cashierOrderId, bindingId, cardCredential, bankPhoneNo, ektp, cardNo, cardType, instId, cardExpireMonth, cardExpireYear, limitAmountDaily, msisdn, deviceId, accountNo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SendBankOtpEntityRequest) {
            SendBankOtpEntityRequest sendBankOtpEntityRequest = (SendBankOtpEntityRequest) other;
            return Intrinsics.areEqual(this.cardIndexNo, sendBankOtpEntityRequest.cardIndexNo) && Intrinsics.areEqual(this.cashierOrderId, sendBankOtpEntityRequest.cashierOrderId) && Intrinsics.areEqual(this.bindingId, sendBankOtpEntityRequest.bindingId) && Intrinsics.areEqual(this.cardCredential, sendBankOtpEntityRequest.cardCredential) && Intrinsics.areEqual(this.bankPhoneNo, sendBankOtpEntityRequest.bankPhoneNo) && Intrinsics.areEqual(this.ektp, sendBankOtpEntityRequest.ektp) && Intrinsics.areEqual(this.cardNo, sendBankOtpEntityRequest.cardNo) && Intrinsics.areEqual(this.cardType, sendBankOtpEntityRequest.cardType) && Intrinsics.areEqual(this.instId, sendBankOtpEntityRequest.instId) && Intrinsics.areEqual(this.cardExpireMonth, sendBankOtpEntityRequest.cardExpireMonth) && Intrinsics.areEqual(this.cardExpireYear, sendBankOtpEntityRequest.cardExpireYear) && Intrinsics.areEqual(this.limitAmountDaily, sendBankOtpEntityRequest.limitAmountDaily) && Intrinsics.areEqual(this.msisdn, sendBankOtpEntityRequest.msisdn) && Intrinsics.areEqual(this.deviceId, sendBankOtpEntityRequest.deviceId) && Intrinsics.areEqual(this.accountNo, sendBankOtpEntityRequest.accountNo);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.cardIndexNo;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.cashierOrderId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.bindingId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.cardCredential;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.bankPhoneNo;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.ektp;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.cardNo;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.cardType;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.instId;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.cardExpireMonth;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.cardExpireYear;
        int hashCode11 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.limitAmountDaily;
        int hashCode12 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.msisdn;
        int hashCode13 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.deviceId;
        int hashCode14 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.accountNo;
        return (((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + (str15 != null ? str15.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SendBankOtpEntityRequest(cardIndexNo=");
        sb.append(this.cardIndexNo);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", bindingId=");
        sb.append(this.bindingId);
        sb.append(", cardCredential=");
        sb.append(this.cardCredential);
        sb.append(", bankPhoneNo=");
        sb.append(this.bankPhoneNo);
        sb.append(", ektp=");
        sb.append(this.ektp);
        sb.append(", cardNo=");
        sb.append(this.cardNo);
        sb.append(", cardType=");
        sb.append(this.cardType);
        sb.append(", instId=");
        sb.append(this.instId);
        sb.append(", cardExpireMonth=");
        sb.append(this.cardExpireMonth);
        sb.append(", cardExpireYear=");
        sb.append(this.cardExpireYear);
        sb.append(", limitAmountDaily=");
        sb.append(this.limitAmountDaily);
        sb.append(", msisdn=");
        sb.append(this.msisdn);
        sb.append(", deviceId=");
        sb.append(this.deviceId);
        sb.append(", accountNo=");
        sb.append(this.accountNo);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ SendBankOtpEntityRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, str12, (i & 4096) != 0 ? null : str13, (i & 8192) != 0 ? "" : str14, str15);
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
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

    @JvmName(name = "getEktp")
    public final String getEktp() {
        return this.ektp;
    }

    @JvmName(name = "getCardNo")
    public final String getCardNo() {
        return this.cardNo;
    }

    @JvmName(name = "getCardType")
    public final String getCardType() {
        return this.cardType;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getCardExpireMonth")
    public final String getCardExpireMonth() {
        return this.cardExpireMonth;
    }

    @JvmName(name = "getCardExpireYear")
    public final String getCardExpireYear() {
        return this.cardExpireYear;
    }

    @JvmName(name = "getLimitAmountDaily")
    public final String getLimitAmountDaily() {
        return this.limitAmountDaily;
    }

    @JvmName(name = "getMsisdn")
    public final String getMsisdn() {
        return this.msisdn;
    }

    @JvmName(name = "getDeviceId")
    public final String getDeviceId() {
        return this.deviceId;
    }

    @JvmName(name = "setDeviceId")
    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    @JvmName(name = "getAccountNo")
    public final String getAccountNo() {
        return this.accountNo;
    }

    public SendBankOtpEntityRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        this.cardIndexNo = str;
        this.cashierOrderId = str2;
        this.bindingId = str3;
        this.cardCredential = str4;
        this.bankPhoneNo = str5;
        this.ektp = str6;
        this.cardNo = str7;
        this.cardType = str8;
        this.instId = str9;
        this.cardExpireMonth = str10;
        this.cardExpireYear = str11;
        this.limitAmountDaily = str12;
        this.msisdn = str13;
        this.deviceId = str14;
        this.accountNo = str15;
    }
}

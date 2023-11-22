package id.dana.domain.otp.model;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.encryptcardno.CardCredInfo;
import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0007J¾\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b,\u0010\u0007R\u0019\u0010#\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b#\u0010-\u001a\u0004\b.\u0010\u0007R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010-\u001a\u0004\b/\u0010\u0007R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b0\u0010\u0007R\u001a\u0010\u001e\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b1\u0010\u0007R\u001a\u0010\u001f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010-\u001a\u0004\b2\u0010\u0007R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b3\u0010\u0007R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b4\u0010\u0007R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b5\u0010\u0007R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b6\u0010\u0007R$\u0010\"\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010-\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u00109R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b:\u0010\u0007R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b;\u0010\u0007R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010<\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010-\u001a\u0004\b=\u0010\u0007R\u001c\u0010!\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010-\u001a\u0004\b>\u0010\u0007"}, d2 = {"Lid/dana/domain/otp/model/SendBankOtpRequest;", "", "", "component1", "()Z", "", "component10", "()Ljava/lang/String;", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "isForVerifyBankPhone", WalletConstant.CARD_INDEX_NO, CashierKeyParams.CASHIER_ORDER_ID, "bindingId", "bankPhoneNo", "ektp", CardCredInfo.CARD_NO, "cardType", "instId", CardCredInfo.CARD_EXPIRE_MONTH, CardCredInfo.CARD_EXPIRE_YEAR, "limitAmountDaily", "msisdn", "deviceId", "accountNo", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/otp/model/SendBankOtpRequest;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAccountNo", "getBankPhoneNo", "getBindingId", "getCardExpireMonth", "getCardExpireYear", "getCardIndexNo", "getCardNo", "getCardType", "getCashierOrderId", "getDeviceId", "setDeviceId", "(Ljava/lang/String;)V", "getEktp", "getInstId", "Z", "getLimitAmountDaily", "getMsisdn", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SendBankOtpRequest {
    private final String accountNo;
    private final String bankPhoneNo;
    private final String bindingId;
    private final String cardExpireMonth;
    private final String cardExpireYear;
    private final String cardIndexNo;
    private final String cardNo;
    private final String cardType;
    private final String cashierOrderId;
    private String deviceId;
    private final String ektp;
    private final String instId;
    private final boolean isForVerifyBankPhone;
    private final String limitAmountDaily;
    private final String msisdn;

    /* renamed from: component1  reason: from getter */
    public final boolean getIsForVerifyBankPhone() {
        return this.isForVerifyBankPhone;
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
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getBindingId() {
        return this.bindingId;
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

    public final SendBankOtpRequest copy(boolean isForVerifyBankPhone, String cardIndexNo, String cashierOrderId, String bindingId, String bankPhoneNo, String ektp, String cardNo, String cardType, String instId, String cardExpireMonth, String cardExpireYear, String limitAmountDaily, String msisdn, String deviceId, String accountNo) {
        Intrinsics.checkNotNullParameter(cardExpireMonth, "");
        Intrinsics.checkNotNullParameter(cardExpireYear, "");
        return new SendBankOtpRequest(isForVerifyBankPhone, cardIndexNo, cashierOrderId, bindingId, bankPhoneNo, ektp, cardNo, cardType, instId, cardExpireMonth, cardExpireYear, limitAmountDaily, msisdn, deviceId, accountNo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SendBankOtpRequest) {
            SendBankOtpRequest sendBankOtpRequest = (SendBankOtpRequest) other;
            return this.isForVerifyBankPhone == sendBankOtpRequest.isForVerifyBankPhone && Intrinsics.areEqual(this.cardIndexNo, sendBankOtpRequest.cardIndexNo) && Intrinsics.areEqual(this.cashierOrderId, sendBankOtpRequest.cashierOrderId) && Intrinsics.areEqual(this.bindingId, sendBankOtpRequest.bindingId) && Intrinsics.areEqual(this.bankPhoneNo, sendBankOtpRequest.bankPhoneNo) && Intrinsics.areEqual(this.ektp, sendBankOtpRequest.ektp) && Intrinsics.areEqual(this.cardNo, sendBankOtpRequest.cardNo) && Intrinsics.areEqual(this.cardType, sendBankOtpRequest.cardType) && Intrinsics.areEqual(this.instId, sendBankOtpRequest.instId) && Intrinsics.areEqual(this.cardExpireMonth, sendBankOtpRequest.cardExpireMonth) && Intrinsics.areEqual(this.cardExpireYear, sendBankOtpRequest.cardExpireYear) && Intrinsics.areEqual(this.limitAmountDaily, sendBankOtpRequest.limitAmountDaily) && Intrinsics.areEqual(this.msisdn, sendBankOtpRequest.msisdn) && Intrinsics.areEqual(this.deviceId, sendBankOtpRequest.deviceId) && Intrinsics.areEqual(this.accountNo, sendBankOtpRequest.accountNo);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    public final int hashCode() {
        boolean z = this.isForVerifyBankPhone;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        String str = this.cardIndexNo;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.cashierOrderId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.bindingId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.bankPhoneNo;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.ektp;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.cardNo;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.cardType;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.instId;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        int hashCode9 = this.cardExpireMonth.hashCode();
        int hashCode10 = this.cardExpireYear.hashCode();
        String str9 = this.limitAmountDaily;
        int hashCode11 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.msisdn;
        int hashCode12 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.deviceId;
        int hashCode13 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.accountNo;
        return (((((((((((((((((((((((((((r1 * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + (str12 != null ? str12.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SendBankOtpRequest(isForVerifyBankPhone=");
        sb.append(this.isForVerifyBankPhone);
        sb.append(", cardIndexNo=");
        sb.append(this.cardIndexNo);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", bindingId=");
        sb.append(this.bindingId);
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

    public SendBankOtpRequest(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        this.isForVerifyBankPhone = z;
        this.cardIndexNo = str;
        this.cashierOrderId = str2;
        this.bindingId = str3;
        this.bankPhoneNo = str4;
        this.ektp = str5;
        this.cardNo = str6;
        this.cardType = str7;
        this.instId = str8;
        this.cardExpireMonth = str9;
        this.cardExpireYear = str10;
        this.limitAmountDaily = str11;
        this.msisdn = str12;
        this.deviceId = str13;
        this.accountNo = str14;
    }

    public /* synthetic */ SendBankOtpRequest(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, (i & 4096) != 0 ? null : str12, (i & 8192) != 0 ? "" : str13, str14);
    }

    @JvmName(name = "isForVerifyBankPhone")
    public final boolean isForVerifyBankPhone() {
        return this.isForVerifyBankPhone;
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
}

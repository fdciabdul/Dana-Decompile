package id.dana.sendmoney.data.api.globalsend.validate.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.data.geocode.mapper.GeocoderResultMapperKt;
import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\t\n\u0002\b \u0018\u00002\u00020\u0001B\u0095\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u00106\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u00102\u001a\u0004\u0018\u00010\u0002\u0012\b\u00100\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u00104\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\b\u00108\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b>\u0010?R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u001f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u001f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b%\u0010#R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006R\u001c\u0010,\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006R\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006R\u001c\u00100\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006R\u001c\u00102\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006R\u001c\u00104\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006R\u001c\u00106\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006R\u001c\u00108\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006R\u001c\u0010:\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010\u0004\u001a\u0004\b;\u0010\u0006R\u001c\u0010<\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/validate/model/BeneficiaryInfoEntity;", "", "", "accountType", "Ljava/lang/String;", "getAccountType", "()Ljava/lang/String;", "address", "getAddress", "bankCode", "getBankCode", "bankName", "getBankName", "beneficiaryId", "getBeneficiaryId", WalletConstant.CARD_INDEX_NO, "getCardIndexNo", "city", "getCity", GeocoderResultMapperKt.COUNTRY, "getCountry", FirebaseAnalytics.Param.CURRENCY, "getCurrency", "emailAddress", "getEmailAddress", "externalSystemId", "getExternalSystemId", "firstName", "getFirstName", "formattedHolderName", "getFormattedHolderName", "", "gmtCreated", "Ljava/lang/Long;", "getGmtCreated", "()Ljava/lang/Long;", "gmtModified", "getGmtModified", "instLocalName", "getInstLocalName", "lastName", "getLastName", "maskedCardNo", "getMaskedCardNo", "payMethod", "getPayMethod", "payOption", "getPayOption", "phoneNumber", "getPhoneNumber", "postalCode", "getPostalCode", "routingNo", "getRoutingNo", "state", "getState", "subTransferMethod", "getSubTransferMethod", "transferMethod", "getTransferMethod", "withdrawInstId", "getWithdrawInstId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BeneficiaryInfoEntity {
    private final String accountType;
    private final String address;
    private final String bankCode;
    private final String bankName;
    private final String beneficiaryId;
    private final String cardIndexNo;
    private final String city;
    private final String country;
    private final String currency;
    private final String emailAddress;
    private final String externalSystemId;
    private final String firstName;
    private final String formattedHolderName;
    private final Long gmtCreated;
    private final Long gmtModified;
    private final String instLocalName;
    private final String lastName;
    private final String maskedCardNo;
    private final String payMethod;
    private final String payOption;
    private final String phoneNumber;
    private final String postalCode;
    private final String routingNo;
    private final String state;
    private final String subTransferMethod;
    private final String transferMethod;
    private final String withdrawInstId;

    public BeneficiaryInfoEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, Long l, Long l2, String str24, String str25) {
        this.beneficiaryId = str;
        this.firstName = str2;
        this.lastName = str3;
        this.emailAddress = str4;
        this.address = str5;
        this.country = str6;
        this.state = str7;
        this.city = str8;
        this.postalCode = str9;
        this.phoneNumber = str10;
        this.bankName = str11;
        this.bankCode = str12;
        this.cardIndexNo = str13;
        this.maskedCardNo = str14;
        this.formattedHolderName = str15;
        this.accountType = str16;
        this.routingNo = str17;
        this.externalSystemId = str18;
        this.payMethod = str19;
        this.payOption = str20;
        this.instLocalName = str21;
        this.withdrawInstId = str22;
        this.currency = str23;
        this.gmtCreated = l;
        this.gmtModified = l2;
        this.transferMethod = str24;
        this.subTransferMethod = str25;
    }

    @JvmName(name = "getBeneficiaryId")
    public final String getBeneficiaryId() {
        return this.beneficiaryId;
    }

    @JvmName(name = "getFirstName")
    public final String getFirstName() {
        return this.firstName;
    }

    @JvmName(name = "getLastName")
    public final String getLastName() {
        return this.lastName;
    }

    @JvmName(name = "getEmailAddress")
    public final String getEmailAddress() {
        return this.emailAddress;
    }

    @JvmName(name = "getAddress")
    public final String getAddress() {
        return this.address;
    }

    @JvmName(name = "getCountry")
    public final String getCountry() {
        return this.country;
    }

    @JvmName(name = "getState")
    public final String getState() {
        return this.state;
    }

    @JvmName(name = "getCity")
    public final String getCity() {
        return this.city;
    }

    @JvmName(name = "getPostalCode")
    public final String getPostalCode() {
        return this.postalCode;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "getBankName")
    public final String getBankName() {
        return this.bankName;
    }

    @JvmName(name = "getBankCode")
    public final String getBankCode() {
        return this.bankCode;
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "getMaskedCardNo")
    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    @JvmName(name = "getFormattedHolderName")
    public final String getFormattedHolderName() {
        return this.formattedHolderName;
    }

    @JvmName(name = "getAccountType")
    public final String getAccountType() {
        return this.accountType;
    }

    @JvmName(name = "getRoutingNo")
    public final String getRoutingNo() {
        return this.routingNo;
    }

    @JvmName(name = "getExternalSystemId")
    public final String getExternalSystemId() {
        return this.externalSystemId;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getPayOption")
    public final String getPayOption() {
        return this.payOption;
    }

    @JvmName(name = "getInstLocalName")
    public final String getInstLocalName() {
        return this.instLocalName;
    }

    @JvmName(name = "getWithdrawInstId")
    public final String getWithdrawInstId() {
        return this.withdrawInstId;
    }

    @JvmName(name = "getCurrency")
    public final String getCurrency() {
        return this.currency;
    }

    @JvmName(name = "getGmtCreated")
    public final Long getGmtCreated() {
        return this.gmtCreated;
    }

    @JvmName(name = "getGmtModified")
    public final Long getGmtModified() {
        return this.gmtModified;
    }

    @JvmName(name = "getTransferMethod")
    public final String getTransferMethod() {
        return this.transferMethod;
    }

    @JvmName(name = "getSubTransferMethod")
    public final String getSubTransferMethod() {
        return this.subTransferMethod;
    }
}

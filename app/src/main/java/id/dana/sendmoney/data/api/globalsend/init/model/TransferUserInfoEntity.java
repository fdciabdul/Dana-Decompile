package id.dana.sendmoney.data.api.globalsend.init.model;

import id.dana.data.model.CurrencyAmountResult;
import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b&\u0018\u00002\u00020\u0001BÅ\u0001\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010!\u001a\u0004\u0018\u00010\f\u0012\b\u0010%\u001a\u0004\u0018\u00010\f\u0012\b\u0010#\u001a\u0004\u0018\u00010\f\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b1\u00102R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001e\u0010\u000bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000bR\u001c\u0010!\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0010R\u001c\u0010#\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u000e\u001a\u0004\b$\u0010\u0010R\u001c\u0010%\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u000e\u001a\u0004\b&\u0010\u0010R\u001c\u0010'\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b(\u0010\u000bR\u001c\u0010)\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\t\u001a\u0004\b*\u0010\u000bR\u001c\u0010+\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\t\u001a\u0004\b,\u0010\u000bR\u001c\u0010-\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006R\u001c\u0010/\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\t\u001a\u0004\b0\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/init/model/TransferUserInfoEntity;", "", "", "accountFrozen", "Ljava/lang/Boolean;", "getAccountFrozen", "()Ljava/lang/Boolean;", "", "avatar", "Ljava/lang/String;", "getAvatar", "()Ljava/lang/String;", "Lid/dana/data/model/CurrencyAmountResult;", "balanceAmount", "Lid/dana/data/model/CurrencyAmountResult;", "getBalanceAmount", "()Lid/dana/data/model/CurrencyAmountResult;", "certified", "getCertified", "instId", "getInstId", "instName", "getInstName", "internalKycLevel", "getInternalKycLevel", WalletConstant.KYC_LEVEL, "getKycLevel", "maskedAccountNo", "getMaskedAccountNo", "maskedLoginId", "getMaskedLoginId", "maskedNickName", "getMaskedNickName", "maxBalanceAmount", "getMaxBalanceAmount", "maxMonthFundInAmount", "getMaxMonthFundInAmount", "monthFundInConsumedAmount", "getMonthFundInConsumedAmount", "name", "getName", "nickName", "getNickName", "phoneNumber", "getPhoneNumber", "userFrozen", "getUserFrozen", "userId", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/data/model/CurrencyAmountResult;Lid/dana/data/model/CurrencyAmountResult;Lid/dana/data/model/CurrencyAmountResult;Lid/dana/data/model/CurrencyAmountResult;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferUserInfoEntity {
    private final Boolean accountFrozen;
    private final String avatar;
    private final CurrencyAmountResult balanceAmount;
    private final Boolean certified;
    private final String instId;
    private final String instName;
    private final String internalKycLevel;
    private final String kycLevel;
    private final String maskedAccountNo;
    private final String maskedLoginId;
    private final String maskedNickName;
    private final CurrencyAmountResult maxBalanceAmount;
    private final CurrencyAmountResult maxMonthFundInAmount;
    private final CurrencyAmountResult monthFundInConsumedAmount;
    private final String name;
    private final String nickName;
    private final String phoneNumber;
    private final Boolean userFrozen;
    private final String userId;

    public TransferUserInfoEntity(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, CurrencyAmountResult currencyAmountResult, CurrencyAmountResult currencyAmountResult2, CurrencyAmountResult currencyAmountResult3, CurrencyAmountResult currencyAmountResult4, String str7, String str8, String str9, String str10, String str11, String str12, Boolean bool2, Boolean bool3) {
        this.userId = str;
        this.maskedLoginId = str2;
        this.maskedNickName = str3;
        this.nickName = str4;
        this.kycLevel = str5;
        this.internalKycLevel = str6;
        this.certified = bool;
        this.balanceAmount = currencyAmountResult;
        this.maxBalanceAmount = currencyAmountResult2;
        this.monthFundInConsumedAmount = currencyAmountResult3;
        this.maxMonthFundInAmount = currencyAmountResult4;
        this.avatar = str7;
        this.name = str8;
        this.phoneNumber = str9;
        this.instId = str10;
        this.instName = str11;
        this.maskedAccountNo = str12;
        this.userFrozen = bool2;
        this.accountFrozen = bool3;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getMaskedLoginId")
    public final String getMaskedLoginId() {
        return this.maskedLoginId;
    }

    @JvmName(name = "getMaskedNickName")
    public final String getMaskedNickName() {
        return this.maskedNickName;
    }

    @JvmName(name = "getNickName")
    public final String getNickName() {
        return this.nickName;
    }

    @JvmName(name = "getKycLevel")
    public final String getKycLevel() {
        return this.kycLevel;
    }

    @JvmName(name = "getInternalKycLevel")
    public final String getInternalKycLevel() {
        return this.internalKycLevel;
    }

    @JvmName(name = "getCertified")
    public final Boolean getCertified() {
        return this.certified;
    }

    @JvmName(name = "getBalanceAmount")
    public final CurrencyAmountResult getBalanceAmount() {
        return this.balanceAmount;
    }

    @JvmName(name = "getMaxBalanceAmount")
    public final CurrencyAmountResult getMaxBalanceAmount() {
        return this.maxBalanceAmount;
    }

    @JvmName(name = "getMonthFundInConsumedAmount")
    public final CurrencyAmountResult getMonthFundInConsumedAmount() {
        return this.monthFundInConsumedAmount;
    }

    @JvmName(name = "getMaxMonthFundInAmount")
    public final CurrencyAmountResult getMaxMonthFundInAmount() {
        return this.maxMonthFundInAmount;
    }

    @JvmName(name = "getAvatar")
    public final String getAvatar() {
        return this.avatar;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getInstName")
    public final String getInstName() {
        return this.instName;
    }

    @JvmName(name = "getMaskedAccountNo")
    public final String getMaskedAccountNo() {
        return this.maskedAccountNo;
    }

    @JvmName(name = "getUserFrozen")
    public final Boolean getUserFrozen() {
        return this.userFrozen;
    }

    @JvmName(name = "getAccountFrozen")
    public final Boolean getAccountFrozen() {
        return this.accountFrozen;
    }
}

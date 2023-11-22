package id.dana.data.sendmoney.model;

import id.dana.data.model.CurrencyAmountResult;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public class TransferUserInfoResult {
    private boolean accountFrozen;
    private String avatar;
    private CurrencyAmountResult balanceAmount;
    private boolean certified;
    private String kycLevel;
    private String maskedLoginId;
    private String maskedNickname;
    private CurrencyAmountResult maxTrxAmount;
    private boolean userFrozen;
    private String userId;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface KycLevel {
        public static final String KYC_0 = "00";
        public static final String KYC_1 = "01";
        public static final String KYC_2 = "02";
        public static final String OLD_KYC_0 = "KYC0";
        public static final String OLD_KYC_1 = "KYC1";
        public static final String OLD_KYC_2 = "KYC2";
    }

    public TransferUserInfoResult() {
    }

    public TransferUserInfoResult(CurrencyAmountResult currencyAmountResult, boolean z, String str, String str2, String str3, String str4, String str5, boolean z2, boolean z3) {
        this.balanceAmount = currencyAmountResult;
        this.certified = z;
        this.kycLevel = str;
        this.maskedLoginId = str2;
        this.maskedNickname = str3;
        this.userId = str4;
        this.avatar = str5;
        this.accountFrozen = z2;
        this.userFrozen = z3;
    }

    public CurrencyAmountResult getBalanceAmount() {
        return this.balanceAmount;
    }

    public void setBalanceAmount(CurrencyAmountResult currencyAmountResult) {
        this.balanceAmount = currencyAmountResult;
    }

    public boolean getCertified() {
        return this.certified;
    }

    public String getKycLevel() {
        return this.kycLevel;
    }

    public void setKycLevel(String str) {
        this.kycLevel = str;
    }

    public String getMaskedLoginId() {
        return this.maskedLoginId;
    }

    public void setMaskedLoginId(String str) {
        this.maskedLoginId = str;
    }

    public String getMaskedNickname() {
        return this.maskedNickname;
    }

    public void setMaskedNickname(String str) {
        this.maskedNickname = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public boolean isCertified() {
        return this.certified;
    }

    public void setCertified(boolean z) {
        this.certified = z;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public boolean isAccountFrozen() {
        return this.accountFrozen;
    }

    public void setAccountFrozen(boolean z) {
        this.accountFrozen = z;
    }

    public boolean isUserFrozen() {
        return this.userFrozen;
    }

    public void setUserFrozen(boolean z) {
        this.userFrozen = z;
    }

    public CurrencyAmountResult getMaxTrxAmount() {
        return this.maxTrxAmount;
    }

    public void setMaxTrxAmount(CurrencyAmountResult currencyAmountResult) {
        this.maxTrxAmount = currencyAmountResult;
    }
}

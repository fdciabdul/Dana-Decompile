package id.dana.data.account;

import id.dana.data.model.CurrencyAmountResult;

/* loaded from: classes.dex */
public class AccountEntity {
    public String amount;
    private String avatarUrl;
    public String currency;
    private String kybInfo;
    private String kycLevel;
    private String nickname;
    private String phoneMask;
    private String phoneNumber;
    private String sessionId;
    private String userId;
    private String userPan;
    private String username;
    private String uuid;

    public AccountEntity() {
    }

    public AccountEntity(String str, String str2, String str3, String str4, String str5, String str6) {
        this.phoneNumber = str;
        this.userId = str2;
        this.sessionId = str3;
        this.nickname = str4;
        this.avatarUrl = str5;
        this.uuid = str6;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void saveBalance(CurrencyAmountResult currencyAmountResult) {
        this.currency = currencyAmountResult.getCurrency();
        this.amount = currencyAmountResult.getAmount();
    }

    public CurrencyAmountResult getBalance() {
        CurrencyAmountResult currencyAmountResult = new CurrencyAmountResult();
        currencyAmountResult.setCurrency(this.currency);
        currencyAmountResult.setAmount(this.amount);
        return currencyAmountResult;
    }

    public String getPhoneMask() {
        return this.phoneMask;
    }

    public void setPhoneMask(String str) {
        this.phoneMask = str;
    }

    public String getUUID() {
        return this.uuid;
    }

    public void setUUID(String str) {
        this.uuid = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getUserPan() {
        String str = this.userPan;
        return str == null ? "" : str;
    }

    public void setUserPan(String str) {
        this.userPan = str;
    }

    public String getKycLevel() {
        return this.kycLevel;
    }

    public void setKycLevel(String str) {
        this.kycLevel = str;
    }

    public String getKybInfo() {
        return this.kybInfo;
    }

    public void setKybInfo(String str) {
        this.kybInfo = str;
    }

    public String getUsername() {
        String str = this.username;
        return str == null ? "" : str;
    }

    public void setUsername(String str) {
        this.username = str;
    }
}

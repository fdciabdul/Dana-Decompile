package id.dana.domain.sendmoney.model;

/* loaded from: classes4.dex */
public class TransferParticipant {
    private String bankAccountIndexNo;
    private String contactName;
    private String dateOfBirth;
    private String loginId;
    private String nickname;
    private String regId;
    private String userId;

    public String getBankAccountIndexNo() {
        return this.bankAccountIndexNo;
    }

    public void setBankAccountIndexNo(String str) {
        this.bankAccountIndexNo = str;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String str) {
        this.contactName = str;
    }

    public String getLoginId() {
        return this.loginId;
    }

    public void setLoginId(String str) {
        this.loginId = str;
    }

    public String getRegId() {
        return this.regId;
    }

    public void setRegId(String str) {
        this.regId = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String str) {
        this.dateOfBirth = str;
    }
}

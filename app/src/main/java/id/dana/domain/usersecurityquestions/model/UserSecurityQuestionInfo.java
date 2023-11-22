package id.dana.domain.usersecurityquestions.model;

/* loaded from: classes4.dex */
public class UserSecurityQuestionInfo {
    private SecuritySettingData data;
    private int expireTime;
    private boolean finish;
    private boolean verifySuccess;

    public SecuritySettingData getData() {
        return this.data;
    }

    public void setData(SecuritySettingData securitySettingData) {
        this.data = securitySettingData;
    }

    public int getExpireTime() {
        return this.expireTime;
    }

    public void setExpireTime(int i) {
        this.expireTime = i;
    }

    public boolean isFinish() {
        return this.finish;
    }

    public void setFinish(boolean z) {
        this.finish = z;
    }

    public boolean isVerifySuccess() {
        return this.verifySuccess;
    }

    public void setVerifySuccess(boolean z) {
        this.verifySuccess = z;
    }
}

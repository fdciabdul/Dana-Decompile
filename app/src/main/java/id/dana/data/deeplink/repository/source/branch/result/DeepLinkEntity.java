package id.dana.data.deeplink.repository.source.branch.result;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class DeepLinkEntity {
    private String link;
    private String referralCode;

    public DeepLinkEntity() {
    }

    public DeepLinkEntity(String str) {
        this.link = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public String getReferralCode() {
        return this.referralCode;
    }

    public void setReferralCode(String str) {
        this.referralCode = str;
    }

    public boolean isReferralCodeEmpty() {
        return TextUtils.isEmpty(this.referralCode);
    }
}

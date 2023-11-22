package id.dana.data.account.avatar.repository.source.network.result;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class AvatarEntityResult {
    @SerializedName("errorCode")
    private String errorCode;
    private boolean success;
    public String url;

    public AvatarEntityResult(String str) {
        this.url = str;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public boolean isSuccess() {
        return this.success;
    }
}

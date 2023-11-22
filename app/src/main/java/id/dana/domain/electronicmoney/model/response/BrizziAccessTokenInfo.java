package id.dana.domain.electronicmoney.model.response;

import id.dana.danah5.constant.BridgeName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b"}, d2 = {"Lid/dana/domain/electronicmoney/model/response/BrizziAccessTokenInfo;", "", "", "accessToken", "Ljava/lang/String;", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "consumerKey", "getConsumerKey", "setConsumerKey", "consumerSecret", "getConsumerSecret", "setConsumerSecret", "reffNumber", "getReffNumber", "setReffNumber", "username", BridgeName.GET_USERNAME, "setUsername", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class BrizziAccessTokenInfo {
    private String accessToken;
    private String consumerKey;
    private String consumerSecret;
    private String reffNumber;
    private String username;

    public BrizziAccessTokenInfo(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.accessToken = str;
        this.consumerSecret = str2;
        this.consumerKey = str3;
        this.username = str4;
        this.reffNumber = str5;
    }

    @JvmName(name = "getAccessToken")
    public final String getAccessToken() {
        return this.accessToken;
    }

    @JvmName(name = "setAccessToken")
    public final void setAccessToken(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.accessToken = str;
    }

    @JvmName(name = "getConsumerSecret")
    public final String getConsumerSecret() {
        return this.consumerSecret;
    }

    @JvmName(name = "setConsumerSecret")
    public final void setConsumerSecret(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.consumerSecret = str;
    }

    @JvmName(name = "getConsumerKey")
    public final String getConsumerKey() {
        return this.consumerKey;
    }

    @JvmName(name = "setConsumerKey")
    public final void setConsumerKey(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.consumerKey = str;
    }

    @JvmName(name = BridgeName.GET_USERNAME)
    public final String getUsername() {
        return this.username;
    }

    @JvmName(name = "setUsername")
    public final void setUsername(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.username = str;
    }

    @JvmName(name = "getReffNumber")
    public final String getReffNumber() {
        return this.reffNumber;
    }

    @JvmName(name = "setReffNumber")
    public final void setReffNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.reffNumber = str;
    }
}

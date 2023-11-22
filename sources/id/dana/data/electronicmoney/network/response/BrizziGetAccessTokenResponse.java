package id.dana.data.electronicmoney.network.response;

import com.alibaba.exthub.config.ExtHubMetaInfoParser;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.danah5.constant.BridgeName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JX\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b!\u0010\u0004R\"\u0010\"\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010%R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b&\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b(\u0010\u0004"}, d2 = {"Lid/dana/data/electronicmoney/network/response/BrizziGetAccessTokenResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "accessToken", "tokenType", "accessTokenExpireTime", ExtHubMetaInfoParser.KEY_EXTENSION_SCOPE_CLASS_NAME, "consumerSecret", "consumerKey", "username", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/electronicmoney/network/response/BrizziGetAccessTokenResponse;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAccessToken", "getAccessTokenExpireTime", "getConsumerKey", "getConsumerSecret", "reffNumber", "getReffNumber", "setReffNumber", "(Ljava/lang/String;)V", "getScope", "getTokenType", BridgeName.GET_USERNAME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class BrizziGetAccessTokenResponse extends BaseRpcResult {
    private final String accessToken;
    private final String accessTokenExpireTime;
    private final String consumerKey;
    private final String consumerSecret;
    private String reffNumber;
    private final String scope;
    private final String tokenType;
    private final String username;

    public static /* synthetic */ BrizziGetAccessTokenResponse copy$default(BrizziGetAccessTokenResponse brizziGetAccessTokenResponse, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = brizziGetAccessTokenResponse.accessToken;
        }
        if ((i & 2) != 0) {
            str2 = brizziGetAccessTokenResponse.tokenType;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = brizziGetAccessTokenResponse.accessTokenExpireTime;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = brizziGetAccessTokenResponse.scope;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = brizziGetAccessTokenResponse.consumerSecret;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = brizziGetAccessTokenResponse.consumerKey;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = brizziGetAccessTokenResponse.username;
        }
        return brizziGetAccessTokenResponse.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* renamed from: component2  reason: from getter */
    public final String getTokenType() {
        return this.tokenType;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAccessTokenExpireTime() {
        return this.accessTokenExpireTime;
    }

    /* renamed from: component4  reason: from getter */
    public final String getScope() {
        return this.scope;
    }

    /* renamed from: component5  reason: from getter */
    public final String getConsumerSecret() {
        return this.consumerSecret;
    }

    /* renamed from: component6  reason: from getter */
    public final String getConsumerKey() {
        return this.consumerKey;
    }

    /* renamed from: component7  reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    public final BrizziGetAccessTokenResponse copy(String accessToken, String tokenType, String accessTokenExpireTime, String scope, String consumerSecret, String consumerKey, String username) {
        Intrinsics.checkNotNullParameter(accessToken, "");
        Intrinsics.checkNotNullParameter(tokenType, "");
        Intrinsics.checkNotNullParameter(accessTokenExpireTime, "");
        Intrinsics.checkNotNullParameter(consumerSecret, "");
        Intrinsics.checkNotNullParameter(consumerKey, "");
        Intrinsics.checkNotNullParameter(username, "");
        return new BrizziGetAccessTokenResponse(accessToken, tokenType, accessTokenExpireTime, scope, consumerSecret, consumerKey, username);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BrizziGetAccessTokenResponse) {
            BrizziGetAccessTokenResponse brizziGetAccessTokenResponse = (BrizziGetAccessTokenResponse) other;
            return Intrinsics.areEqual(this.accessToken, brizziGetAccessTokenResponse.accessToken) && Intrinsics.areEqual(this.tokenType, brizziGetAccessTokenResponse.tokenType) && Intrinsics.areEqual(this.accessTokenExpireTime, brizziGetAccessTokenResponse.accessTokenExpireTime) && Intrinsics.areEqual(this.scope, brizziGetAccessTokenResponse.scope) && Intrinsics.areEqual(this.consumerSecret, brizziGetAccessTokenResponse.consumerSecret) && Intrinsics.areEqual(this.consumerKey, brizziGetAccessTokenResponse.consumerKey) && Intrinsics.areEqual(this.username, brizziGetAccessTokenResponse.username);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.accessToken.hashCode();
        int hashCode2 = this.tokenType.hashCode();
        int hashCode3 = this.accessTokenExpireTime.hashCode();
        String str = this.scope;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.consumerSecret.hashCode()) * 31) + this.consumerKey.hashCode()) * 31) + this.username.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BrizziGetAccessTokenResponse(accessToken=");
        sb.append(this.accessToken);
        sb.append(", tokenType=");
        sb.append(this.tokenType);
        sb.append(", accessTokenExpireTime=");
        sb.append(this.accessTokenExpireTime);
        sb.append(", scope=");
        sb.append(this.scope);
        sb.append(", consumerSecret=");
        sb.append(this.consumerSecret);
        sb.append(", consumerKey=");
        sb.append(this.consumerKey);
        sb.append(", username=");
        sb.append(this.username);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getAccessToken")
    public final String getAccessToken() {
        return this.accessToken;
    }

    @JvmName(name = "getTokenType")
    public final String getTokenType() {
        return this.tokenType;
    }

    @JvmName(name = "getAccessTokenExpireTime")
    public final String getAccessTokenExpireTime() {
        return this.accessTokenExpireTime;
    }

    @JvmName(name = "getScope")
    public final String getScope() {
        return this.scope;
    }

    @JvmName(name = "getConsumerSecret")
    public final String getConsumerSecret() {
        return this.consumerSecret;
    }

    @JvmName(name = "getConsumerKey")
    public final String getConsumerKey() {
        return this.consumerKey;
    }

    @JvmName(name = BridgeName.GET_USERNAME)
    public final String getUsername() {
        return this.username;
    }

    public BrizziGetAccessTokenResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.accessToken = str;
        this.tokenType = str2;
        this.accessTokenExpireTime = str3;
        this.scope = str4;
        this.consumerSecret = str5;
        this.consumerKey = str6;
        this.username = str7;
        this.reffNumber = "";
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

package id.dana.data.here.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004"}, d2 = {"Lid/dana/data/here/model/HereTokenResponse;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "access_token", "token_type", "expires_in", "copy", "(Ljava/lang/String;Ljava/lang/String;J)Lid/dana/data/here/model/HereTokenResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isValid", "()Z", "toString", "Ljava/lang/String;", "getAccess_token", "J", "getExpires_in", "getToken_type", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HereTokenResponse {
    @SerializedName("access_token")
    private final String access_token;
    private final long expires_in;
    private final String token_type;

    public static /* synthetic */ HereTokenResponse copy$default(HereTokenResponse hereTokenResponse, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hereTokenResponse.access_token;
        }
        if ((i & 2) != 0) {
            str2 = hereTokenResponse.token_type;
        }
        if ((i & 4) != 0) {
            j = hereTokenResponse.expires_in;
        }
        return hereTokenResponse.copy(str, str2, j);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAccess_token() {
        return this.access_token;
    }

    /* renamed from: component2  reason: from getter */
    public final String getToken_type() {
        return this.token_type;
    }

    /* renamed from: component3  reason: from getter */
    public final long getExpires_in() {
        return this.expires_in;
    }

    public final HereTokenResponse copy(String access_token, String token_type, long expires_in) {
        Intrinsics.checkNotNullParameter(access_token, "");
        Intrinsics.checkNotNullParameter(token_type, "");
        return new HereTokenResponse(access_token, token_type, expires_in);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof HereTokenResponse) {
            HereTokenResponse hereTokenResponse = (HereTokenResponse) other;
            return Intrinsics.areEqual(this.access_token, hereTokenResponse.access_token) && Intrinsics.areEqual(this.token_type, hereTokenResponse.token_type) && this.expires_in == hereTokenResponse.expires_in;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.access_token.hashCode() * 31) + this.token_type.hashCode()) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.expires_in);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HereTokenResponse(access_token=");
        sb.append(this.access_token);
        sb.append(", token_type=");
        sb.append(this.token_type);
        sb.append(", expires_in=");
        sb.append(this.expires_in);
        sb.append(')');
        return sb.toString();
    }

    public HereTokenResponse(String str, String str2, long j) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.access_token = str;
        this.token_type = str2;
        this.expires_in = j;
    }

    @JvmName(name = "getAccess_token")
    public final String getAccess_token() {
        return this.access_token;
    }

    @JvmName(name = "getToken_type")
    public final String getToken_type() {
        return this.token_type;
    }

    @JvmName(name = "getExpires_in")
    public final long getExpires_in() {
        return this.expires_in;
    }

    public final boolean isValid() {
        if (this.access_token.length() > 0) {
            return (this.token_type.length() > 0) && this.expires_in > 0;
        }
        return false;
    }
}

package id.dana.domain.pocket.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\"\u0010\u0007\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u0017R\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0017"}, d2 = {"Lid/dana/domain/pocket/model/LoyaltyToken;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "accessToken", "expiresIn", "refreshToken", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/pocket/model/LoyaltyToken;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAccessToken", "setAccessToken", "(Ljava/lang/String;)V", "getExpiresIn", "setExpiresIn", "getRefreshToken", "setRefreshToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LoyaltyToken {
    private String accessToken;
    private String expiresIn;
    private String refreshToken;

    public LoyaltyToken() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ LoyaltyToken copy$default(LoyaltyToken loyaltyToken, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loyaltyToken.accessToken;
        }
        if ((i & 2) != 0) {
            str2 = loyaltyToken.expiresIn;
        }
        if ((i & 4) != 0) {
            str3 = loyaltyToken.refreshToken;
        }
        return loyaltyToken.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* renamed from: component2  reason: from getter */
    public final String getExpiresIn() {
        return this.expiresIn;
    }

    /* renamed from: component3  reason: from getter */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final LoyaltyToken copy(String accessToken, String expiresIn, String refreshToken) {
        Intrinsics.checkNotNullParameter(accessToken, "");
        Intrinsics.checkNotNullParameter(expiresIn, "");
        Intrinsics.checkNotNullParameter(refreshToken, "");
        return new LoyaltyToken(accessToken, expiresIn, refreshToken);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LoyaltyToken) {
            LoyaltyToken loyaltyToken = (LoyaltyToken) other;
            return Intrinsics.areEqual(this.accessToken, loyaltyToken.accessToken) && Intrinsics.areEqual(this.expiresIn, loyaltyToken.expiresIn) && Intrinsics.areEqual(this.refreshToken, loyaltyToken.refreshToken);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.accessToken.hashCode() * 31) + this.expiresIn.hashCode()) * 31) + this.refreshToken.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoyaltyToken(accessToken=");
        sb.append(this.accessToken);
        sb.append(", expiresIn=");
        sb.append(this.expiresIn);
        sb.append(", refreshToken=");
        sb.append(this.refreshToken);
        sb.append(')');
        return sb.toString();
    }

    public LoyaltyToken(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.accessToken = str;
        this.expiresIn = str2;
        this.refreshToken = str3;
    }

    public /* synthetic */ LoyaltyToken(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
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

    @JvmName(name = "getExpiresIn")
    public final String getExpiresIn() {
        return this.expiresIn;
    }

    @JvmName(name = "setExpiresIn")
    public final void setExpiresIn(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.expiresIn = str;
    }

    @JvmName(name = "getRefreshToken")
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @JvmName(name = "setRefreshToken")
    public final void setRefreshToken(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.refreshToken = str;
    }
}

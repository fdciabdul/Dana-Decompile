package id.dana.mybills.data.model.response;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/mybills/data/model/response/ExtendInfoQuerySubscriptionResult;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "totalAmount", "nickname", "provider", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/mybills/data/model/response/ExtendInfoQuerySubscriptionResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getNickname", "getProvider", "getTotalAmount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ExtendInfoQuerySubscriptionResult {
    public String nickname;
    public String provider;
    public String totalAmount;

    public ExtendInfoQuerySubscriptionResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ExtendInfoQuerySubscriptionResult copy$default(ExtendInfoQuerySubscriptionResult extendInfoQuerySubscriptionResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = extendInfoQuerySubscriptionResult.totalAmount;
        }
        if ((i & 2) != 0) {
            str2 = extendInfoQuerySubscriptionResult.nickname;
        }
        if ((i & 4) != 0) {
            str3 = extendInfoQuerySubscriptionResult.provider;
        }
        return extendInfoQuerySubscriptionResult.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component2  reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component3  reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    public final ExtendInfoQuerySubscriptionResult copy(String totalAmount, String nickname, String provider) {
        Intrinsics.checkNotNullParameter(totalAmount, "");
        Intrinsics.checkNotNullParameter(nickname, "");
        Intrinsics.checkNotNullParameter(provider, "");
        return new ExtendInfoQuerySubscriptionResult(totalAmount, nickname, provider);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ExtendInfoQuerySubscriptionResult) {
            ExtendInfoQuerySubscriptionResult extendInfoQuerySubscriptionResult = (ExtendInfoQuerySubscriptionResult) other;
            return Intrinsics.areEqual(this.totalAmount, extendInfoQuerySubscriptionResult.totalAmount) && Intrinsics.areEqual(this.nickname, extendInfoQuerySubscriptionResult.nickname) && Intrinsics.areEqual(this.provider, extendInfoQuerySubscriptionResult.provider);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.totalAmount.hashCode() * 31) + this.nickname.hashCode()) * 31) + this.provider.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtendInfoQuerySubscriptionResult(totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", provider=");
        sb.append(this.provider);
        sb.append(')');
        return sb.toString();
    }

    public ExtendInfoQuerySubscriptionResult(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.totalAmount = str;
        this.nickname = str2;
        this.provider = str3;
    }

    public /* synthetic */ ExtendInfoQuerySubscriptionResult(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    @JvmName(name = "getTotalAmount")
    public final String getTotalAmount() {
        return this.totalAmount;
    }

    @JvmName(name = "getNickname")
    public final String getNickname() {
        return this.nickname;
    }

    @JvmName(name = "getProvider")
    public final String getProvider() {
        return this.provider;
    }
}

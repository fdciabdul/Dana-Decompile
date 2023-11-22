package id.dana.data.loyalty.repository.source.network.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\b\u001a\u00028\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\b\u001a\u00028\u00008\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/data/loyalty/repository/source/network/response/BaseLoyaltyResponse;", "T", "", "component1", "()Ljava/lang/Object;", "Lid/dana/data/loyalty/repository/source/network/response/LoyaltyResultInfo;", "component2", "()Lid/dana/data/loyalty/repository/source/network/response/LoyaltyResultInfo;", "body", "resultInfo", "copy", "(Ljava/lang/Object;Lid/dana/data/loyalty/repository/source/network/response/LoyaltyResultInfo;)Lid/dana/data/loyalty/repository/source/network/response/BaseLoyaltyResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getBody", "setBody", "(Ljava/lang/Object;)V", "Lid/dana/data/loyalty/repository/source/network/response/LoyaltyResultInfo;", "getResultInfo", "setResultInfo", "(Lid/dana/data/loyalty/repository/source/network/response/LoyaltyResultInfo;)V", "<init>", "(Ljava/lang/Object;Lid/dana/data/loyalty/repository/source/network/response/LoyaltyResultInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class BaseLoyaltyResponse<T> {
    @SerializedName("body")
    private T body;
    private LoyaltyResultInfo resultInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseLoyaltyResponse copy$default(BaseLoyaltyResponse baseLoyaltyResponse, Object obj, LoyaltyResultInfo loyaltyResultInfo, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = baseLoyaltyResponse.body;
        }
        if ((i & 2) != 0) {
            loyaltyResultInfo = baseLoyaltyResponse.resultInfo;
        }
        return baseLoyaltyResponse.copy(obj, loyaltyResultInfo);
    }

    public final T component1() {
        return this.body;
    }

    /* renamed from: component2  reason: from getter */
    public final LoyaltyResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public final BaseLoyaltyResponse<T> copy(T body, LoyaltyResultInfo resultInfo) {
        return new BaseLoyaltyResponse<>(body, resultInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BaseLoyaltyResponse) {
            BaseLoyaltyResponse baseLoyaltyResponse = (BaseLoyaltyResponse) other;
            return Intrinsics.areEqual(this.body, baseLoyaltyResponse.body) && Intrinsics.areEqual(this.resultInfo, baseLoyaltyResponse.resultInfo);
        }
        return false;
    }

    public final int hashCode() {
        T t = this.body;
        int hashCode = t == null ? 0 : t.hashCode();
        LoyaltyResultInfo loyaltyResultInfo = this.resultInfo;
        return (hashCode * 31) + (loyaltyResultInfo != null ? loyaltyResultInfo.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseLoyaltyResponse(body=");
        sb.append(this.body);
        sb.append(", resultInfo=");
        sb.append(this.resultInfo);
        sb.append(')');
        return sb.toString();
    }

    public BaseLoyaltyResponse(T t, LoyaltyResultInfo loyaltyResultInfo) {
        this.body = t;
        this.resultInfo = loyaltyResultInfo;
    }

    @JvmName(name = "getBody")
    public final T getBody() {
        return this.body;
    }

    @JvmName(name = "setBody")
    public final void setBody(T t) {
        this.body = t;
    }

    @JvmName(name = "getResultInfo")
    public final LoyaltyResultInfo getResultInfo() {
        return this.resultInfo;
    }

    @JvmName(name = "setResultInfo")
    public final void setResultInfo(LoyaltyResultInfo loyaltyResultInfo) {
        this.resultInfo = loyaltyResultInfo;
    }
}

package id.dana.data.loyalty.repository.source.network.request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0003\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0005\u001a\u00028\u00008\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/data/loyalty/repository/source/network/request/BaseLoyaltyRequest;", "T", "", "component1", "()Ljava/lang/Object;", "body", "copy", "(Ljava/lang/Object;)Lid/dana/data/loyalty/repository/source/network/request/BaseLoyaltyRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getBody", "setBody", "(Ljava/lang/Object;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class BaseLoyaltyRequest<T> {
    @SerializedName("body")
    private T body;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseLoyaltyRequest copy$default(BaseLoyaltyRequest baseLoyaltyRequest, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = baseLoyaltyRequest.body;
        }
        return baseLoyaltyRequest.copy(obj);
    }

    public final T component1() {
        return this.body;
    }

    public final BaseLoyaltyRequest<T> copy(T body) {
        return new BaseLoyaltyRequest<>(body);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BaseLoyaltyRequest) && Intrinsics.areEqual(this.body, ((BaseLoyaltyRequest) other).body);
    }

    public final int hashCode() {
        T t = this.body;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseLoyaltyRequest(body=");
        sb.append(this.body);
        sb.append(')');
        return sb.toString();
    }

    public BaseLoyaltyRequest(T t) {
        this.body = t;
    }

    @JvmName(name = "getBody")
    public final T getBody() {
        return this.body;
    }

    @JvmName(name = "setBody")
    public final void setBody(T t) {
        this.body = t;
    }
}

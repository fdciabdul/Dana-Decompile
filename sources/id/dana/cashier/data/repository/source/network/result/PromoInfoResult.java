package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/PromoInfoResult;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Boolean;", "description", "status", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/cashier/data/repository/source/network/result/PromoInfoResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDescription", "Ljava/lang/Boolean;", "getStatus", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PromoInfoResult {
    @SerializedName("description")
    private final String description;
    private final Boolean status;

    public static /* synthetic */ PromoInfoResult copy$default(PromoInfoResult promoInfoResult, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = promoInfoResult.description;
        }
        if ((i & 2) != 0) {
            bool = promoInfoResult.status;
        }
        return promoInfoResult.copy(str, bool);
    }

    /* renamed from: component1  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component2  reason: from getter */
    public final Boolean getStatus() {
        return this.status;
    }

    public final PromoInfoResult copy(String description, Boolean status) {
        return new PromoInfoResult(description, status);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PromoInfoResult) {
            PromoInfoResult promoInfoResult = (PromoInfoResult) other;
            return Intrinsics.areEqual(this.description, promoInfoResult.description) && Intrinsics.areEqual(this.status, promoInfoResult.status);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.description;
        int hashCode = str == null ? 0 : str.hashCode();
        Boolean bool = this.status;
        return (hashCode * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoInfoResult(description=");
        sb.append(this.description);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(')');
        return sb.toString();
    }

    public PromoInfoResult(String str, Boolean bool) {
        this.description = str;
        this.status = bool;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "getStatus")
    public final Boolean getStatus() {
        return this.status;
    }
}

package id.dana.data.carrieridentification.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0003\u0010\b\u001a\u00020\u0002\u0012\b\b\u0003\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0003\u0010\u0007\u001a\u00020\u00022\b\b\u0003\u0010\b\u001a\u00020\u00022\b\b\u0003\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/data/carrieridentification/model/VerifySecurityProductResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()I", "component2", "component3", "identFailedCount", "maxFailedLimit", "lockedExpireMins", "copy", "(III)Lid/dana/data/carrieridentification/model/VerifySecurityProductResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getIdentFailedCount", "getLockedExpireMins", "getMaxFailedLimit", "<init>", "(III)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class VerifySecurityProductResult extends BaseRpcResult {
    @SerializedName("identFailedCount")
    private final int identFailedCount;
    @SerializedName("lockedExpireMins")
    private final int lockedExpireMins;
    @SerializedName("maxFailedLimit")
    private final int maxFailedLimit;

    public VerifySecurityProductResult() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ VerifySecurityProductResult copy$default(VerifySecurityProductResult verifySecurityProductResult, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = verifySecurityProductResult.identFailedCount;
        }
        if ((i4 & 2) != 0) {
            i2 = verifySecurityProductResult.maxFailedLimit;
        }
        if ((i4 & 4) != 0) {
            i3 = verifySecurityProductResult.lockedExpireMins;
        }
        return verifySecurityProductResult.copy(i, i2, i3);
    }

    /* renamed from: component1  reason: from getter */
    public final int getIdentFailedCount() {
        return this.identFailedCount;
    }

    /* renamed from: component2  reason: from getter */
    public final int getMaxFailedLimit() {
        return this.maxFailedLimit;
    }

    /* renamed from: component3  reason: from getter */
    public final int getLockedExpireMins() {
        return this.lockedExpireMins;
    }

    public final VerifySecurityProductResult copy(@JSONField(name = "identFailedCount") int identFailedCount, @JSONField(name = "maxFailedLimit") int maxFailedLimit, @JSONField(name = "lockedExpireMins") int lockedExpireMins) {
        return new VerifySecurityProductResult(identFailedCount, maxFailedLimit, lockedExpireMins);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerifySecurityProductResult) {
            VerifySecurityProductResult verifySecurityProductResult = (VerifySecurityProductResult) other;
            return this.identFailedCount == verifySecurityProductResult.identFailedCount && this.maxFailedLimit == verifySecurityProductResult.maxFailedLimit && this.lockedExpireMins == verifySecurityProductResult.lockedExpireMins;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.identFailedCount * 31) + this.maxFailedLimit) * 31) + this.lockedExpireMins;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifySecurityProductResult(identFailedCount=");
        sb.append(this.identFailedCount);
        sb.append(", maxFailedLimit=");
        sb.append(this.maxFailedLimit);
        sb.append(", lockedExpireMins=");
        sb.append(this.lockedExpireMins);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ VerifySecurityProductResult(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    @JvmName(name = "getIdentFailedCount")
    public final int getIdentFailedCount() {
        return this.identFailedCount;
    }

    @JvmName(name = "getMaxFailedLimit")
    public final int getMaxFailedLimit() {
        return this.maxFailedLimit;
    }

    @JvmName(name = "getLockedExpireMins")
    public final int getLockedExpireMins() {
        return this.lockedExpireMins;
    }

    public VerifySecurityProductResult(@JSONField(name = "identFailedCount") int i, @JSONField(name = "maxFailedLimit") int i2, @JSONField(name = "lockedExpireMins") int i3) {
        this.identFailedCount = i;
        this.maxFailedLimit = i2;
        this.lockedExpireMins = i3;
    }
}

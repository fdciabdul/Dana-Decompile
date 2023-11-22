package id.dana.data.registration.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00052\b\b\u0003\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\r\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001b\u0010\u0007R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004"}, d2 = {"Lid/dana/data/registration/model/NumberOfRequestOtp;", "", "", "component1", "()I", "", "component2", "()J", "component3", "numberOfRequest", "createdAt", "freezeThresholdInMillis", "copy", "(IJJ)Lid/dana/data/registration/model/NumberOfRequestOtp;", "other", "", "equals", "(Ljava/lang/Object;)Z", "getExpiredAt", "hashCode", "isExpired", "()Z", "", "toString", "()Ljava/lang/String;", "J", "getCreatedAt", "getFreezeThresholdInMillis", "I", "getNumberOfRequest", "<init>", "(IJJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class NumberOfRequestOtp {
    @SerializedName("createdAt")
    private final long createdAt;
    @SerializedName("freezeThresholdInMillis")
    private final long freezeThresholdInMillis;
    @SerializedName("numberOfRequest")
    private final int numberOfRequest;

    public static /* synthetic */ NumberOfRequestOtp copy$default(NumberOfRequestOtp numberOfRequestOtp, int i, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = numberOfRequestOtp.numberOfRequest;
        }
        if ((i2 & 2) != 0) {
            j = numberOfRequestOtp.createdAt;
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            j2 = numberOfRequestOtp.freezeThresholdInMillis;
        }
        return numberOfRequestOtp.copy(i, j3, j2);
    }

    /* renamed from: component1  reason: from getter */
    public final int getNumberOfRequest() {
        return this.numberOfRequest;
    }

    /* renamed from: component2  reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component3  reason: from getter */
    public final long getFreezeThresholdInMillis() {
        return this.freezeThresholdInMillis;
    }

    public final NumberOfRequestOtp copy(@JSONField(name = "numberOfRequest") int numberOfRequest, @JSONField(name = "createdAt") long createdAt, @JSONField(name = "freezeThresholdInMillis") long freezeThresholdInMillis) {
        return new NumberOfRequestOtp(numberOfRequest, createdAt, freezeThresholdInMillis);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof NumberOfRequestOtp) {
            NumberOfRequestOtp numberOfRequestOtp = (NumberOfRequestOtp) other;
            return this.numberOfRequest == numberOfRequestOtp.numberOfRequest && this.createdAt == numberOfRequestOtp.createdAt && this.freezeThresholdInMillis == numberOfRequestOtp.freezeThresholdInMillis;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.numberOfRequest * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.createdAt)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.freezeThresholdInMillis);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NumberOfRequestOtp(numberOfRequest=");
        sb.append(this.numberOfRequest);
        sb.append(", createdAt=");
        sb.append(this.createdAt);
        sb.append(", freezeThresholdInMillis=");
        sb.append(this.freezeThresholdInMillis);
        sb.append(')');
        return sb.toString();
    }

    public NumberOfRequestOtp(@JSONField(name = "numberOfRequest") int i, @JSONField(name = "createdAt") long j, @JSONField(name = "freezeThresholdInMillis") long j2) {
        this.numberOfRequest = i;
        this.createdAt = j;
        this.freezeThresholdInMillis = j2;
    }

    @JvmName(name = "getNumberOfRequest")
    public final int getNumberOfRequest() {
        return this.numberOfRequest;
    }

    @JvmName(name = "getCreatedAt")
    public final long getCreatedAt() {
        return this.createdAt;
    }

    @JvmName(name = "getFreezeThresholdInMillis")
    public final long getFreezeThresholdInMillis() {
        return this.freezeThresholdInMillis;
    }

    public final long getExpiredAt() {
        return this.createdAt + this.freezeThresholdInMillis;
    }

    public final boolean isExpired() {
        return System.currentTimeMillis() > getExpiredAt();
    }
}

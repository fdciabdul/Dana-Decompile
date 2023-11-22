package id.dana.data.login.source.network.result;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0003\u0010\b\u001a\u00020\u0002\u0012\b\b\u0003\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u00022\b\b\u0003\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007"}, d2 = {"Lid/dana/data/login/source/network/result/RetryConfig;", "", "", "component1", "()I", "", "component2", "()J", "maxRetry", "retryDelay", "copy", "(IJ)Lid/dana/data/login/source/network/result/RetryConfig;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getMaxRetry", "J", "getRetryDelay", "<init>", "(IJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class RetryConfig {
    public int maxRetry;
    public long retryDelay;

    public RetryConfig() {
        this(0, 0L, 3, null);
    }

    public static /* synthetic */ RetryConfig copy$default(RetryConfig retryConfig, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = retryConfig.maxRetry;
        }
        if ((i2 & 2) != 0) {
            j = retryConfig.retryDelay;
        }
        return retryConfig.copy(i, j);
    }

    /* renamed from: component1  reason: from getter */
    public final int getMaxRetry() {
        return this.maxRetry;
    }

    /* renamed from: component2  reason: from getter */
    public final long getRetryDelay() {
        return this.retryDelay;
    }

    public final RetryConfig copy(@JSONField(name = "maxRetry") int maxRetry, @JSONField(name = "retryDelay") long retryDelay) {
        return new RetryConfig(maxRetry, retryDelay);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RetryConfig) {
            RetryConfig retryConfig = (RetryConfig) other;
            return this.maxRetry == retryConfig.maxRetry && this.retryDelay == retryConfig.retryDelay;
        }
        return false;
    }

    public final int hashCode() {
        return (this.maxRetry * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.retryDelay);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RetryConfig(maxRetry=");
        sb.append(this.maxRetry);
        sb.append(", retryDelay=");
        sb.append(this.retryDelay);
        sb.append(')');
        return sb.toString();
    }

    public RetryConfig(@JSONField(name = "maxRetry") int i, @JSONField(name = "retryDelay") long j) {
        this.maxRetry = i;
        this.retryDelay = j;
    }

    public /* synthetic */ RetryConfig(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j);
    }

    @JvmName(name = "getMaxRetry")
    public final int getMaxRetry() {
        return this.maxRetry;
    }

    @JvmName(name = "getRetryDelay")
    public final long getRetryDelay() {
        return this.retryDelay;
    }
}

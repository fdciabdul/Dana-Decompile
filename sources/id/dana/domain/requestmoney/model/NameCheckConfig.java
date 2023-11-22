package id.dana.domain.requestmoney.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/domain/requestmoney/model/NameCheckConfig;", "", "", "component1", "()I", "component2", "component3", "retryLimit", "freezeTime", "resetTime", "copy", "(III)Lid/dana/domain/requestmoney/model/NameCheckConfig;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getFreezeTime", "getResetTime", "getRetryLimit", "<init>", "(III)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NameCheckConfig {
    private final int freezeTime;
    private final int resetTime;
    private final int retryLimit;

    public static /* synthetic */ NameCheckConfig copy$default(NameCheckConfig nameCheckConfig, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = nameCheckConfig.retryLimit;
        }
        if ((i4 & 2) != 0) {
            i2 = nameCheckConfig.freezeTime;
        }
        if ((i4 & 4) != 0) {
            i3 = nameCheckConfig.resetTime;
        }
        return nameCheckConfig.copy(i, i2, i3);
    }

    /* renamed from: component1  reason: from getter */
    public final int getRetryLimit() {
        return this.retryLimit;
    }

    /* renamed from: component2  reason: from getter */
    public final int getFreezeTime() {
        return this.freezeTime;
    }

    /* renamed from: component3  reason: from getter */
    public final int getResetTime() {
        return this.resetTime;
    }

    public final NameCheckConfig copy(int retryLimit, int freezeTime, int resetTime) {
        return new NameCheckConfig(retryLimit, freezeTime, resetTime);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof NameCheckConfig) {
            NameCheckConfig nameCheckConfig = (NameCheckConfig) other;
            return this.retryLimit == nameCheckConfig.retryLimit && this.freezeTime == nameCheckConfig.freezeTime && this.resetTime == nameCheckConfig.resetTime;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.retryLimit * 31) + this.freezeTime) * 31) + this.resetTime;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NameCheckConfig(retryLimit=");
        sb.append(this.retryLimit);
        sb.append(", freezeTime=");
        sb.append(this.freezeTime);
        sb.append(", resetTime=");
        sb.append(this.resetTime);
        sb.append(')');
        return sb.toString();
    }

    public NameCheckConfig(int i, int i2, int i3) {
        this.retryLimit = i;
        this.freezeTime = i2;
        this.resetTime = i3;
    }

    @JvmName(name = "getRetryLimit")
    public final int getRetryLimit() {
        return this.retryLimit;
    }

    @JvmName(name = "getFreezeTime")
    public final int getFreezeTime() {
        return this.freezeTime;
    }

    @JvmName(name = "getResetTime")
    public final int getResetTime() {
        return this.resetTime;
    }
}

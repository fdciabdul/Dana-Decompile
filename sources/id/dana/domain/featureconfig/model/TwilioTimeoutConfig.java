package id.dana.domain.featureconfig.model;

import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/domain/featureconfig/model/TwilioTimeoutConfig;", "", "", "component1", "()I", "component2", "component3", TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, "counter", "delayTime", "copy", "(III)Lid/dana/domain/featureconfig/model/TwilioTimeoutConfig;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getCounter", "getDelayTime", "getTimeout", "<init>", "(III)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TwilioTimeoutConfig {
    private final int counter;
    private final int delayTime;
    private final int timeout;

    public static /* synthetic */ TwilioTimeoutConfig copy$default(TwilioTimeoutConfig twilioTimeoutConfig, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = twilioTimeoutConfig.timeout;
        }
        if ((i4 & 2) != 0) {
            i2 = twilioTimeoutConfig.counter;
        }
        if ((i4 & 4) != 0) {
            i3 = twilioTimeoutConfig.delayTime;
        }
        return twilioTimeoutConfig.copy(i, i2, i3);
    }

    /* renamed from: component1  reason: from getter */
    public final int getTimeout() {
        return this.timeout;
    }

    /* renamed from: component2  reason: from getter */
    public final int getCounter() {
        return this.counter;
    }

    /* renamed from: component3  reason: from getter */
    public final int getDelayTime() {
        return this.delayTime;
    }

    public final TwilioTimeoutConfig copy(int timeout, int counter, int delayTime) {
        return new TwilioTimeoutConfig(timeout, counter, delayTime);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TwilioTimeoutConfig) {
            TwilioTimeoutConfig twilioTimeoutConfig = (TwilioTimeoutConfig) other;
            return this.timeout == twilioTimeoutConfig.timeout && this.counter == twilioTimeoutConfig.counter && this.delayTime == twilioTimeoutConfig.delayTime;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.timeout * 31) + this.counter) * 31) + this.delayTime;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TwilioTimeoutConfig(timeout=");
        sb.append(this.timeout);
        sb.append(", counter=");
        sb.append(this.counter);
        sb.append(", delayTime=");
        sb.append(this.delayTime);
        sb.append(')');
        return sb.toString();
    }

    public TwilioTimeoutConfig(int i, int i2, int i3) {
        this.timeout = i;
        this.counter = i2;
        this.delayTime = i3;
    }

    @JvmName(name = "getTimeout")
    public final int getTimeout() {
        return this.timeout;
    }

    @JvmName(name = "getCounter")
    public final int getCounter() {
        return this.counter;
    }

    @JvmName(name = "getDelayTime")
    public final int getDelayTime() {
        return this.delayTime;
    }
}

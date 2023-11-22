package id.dana.domain.registration.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007"}, d2 = {"Lid/dana/domain/registration/model/OtpWhatsAppConfigModel;", "", "", "component1", "()J", "", "component2", "()I", "freezeThresholdInMillis", "maxAttemptBeforeFallback", "copy", "(JI)Lid/dana/domain/registration/model/OtpWhatsAppConfigModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "J", "getFreezeThresholdInMillis", "I", "getMaxAttemptBeforeFallback", "<init>", "(JI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class OtpWhatsAppConfigModel {
    private final long freezeThresholdInMillis;
    private final int maxAttemptBeforeFallback;

    public OtpWhatsAppConfigModel() {
        this(0L, 0, 3, null);
    }

    public static /* synthetic */ OtpWhatsAppConfigModel copy$default(OtpWhatsAppConfigModel otpWhatsAppConfigModel, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = otpWhatsAppConfigModel.freezeThresholdInMillis;
        }
        if ((i2 & 2) != 0) {
            i = otpWhatsAppConfigModel.maxAttemptBeforeFallback;
        }
        return otpWhatsAppConfigModel.copy(j, i);
    }

    /* renamed from: component1  reason: from getter */
    public final long getFreezeThresholdInMillis() {
        return this.freezeThresholdInMillis;
    }

    /* renamed from: component2  reason: from getter */
    public final int getMaxAttemptBeforeFallback() {
        return this.maxAttemptBeforeFallback;
    }

    public final OtpWhatsAppConfigModel copy(long freezeThresholdInMillis, int maxAttemptBeforeFallback) {
        return new OtpWhatsAppConfigModel(freezeThresholdInMillis, maxAttemptBeforeFallback);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof OtpWhatsAppConfigModel) {
            OtpWhatsAppConfigModel otpWhatsAppConfigModel = (OtpWhatsAppConfigModel) other;
            return this.freezeThresholdInMillis == otpWhatsAppConfigModel.freezeThresholdInMillis && this.maxAttemptBeforeFallback == otpWhatsAppConfigModel.maxAttemptBeforeFallback;
        }
        return false;
    }

    public final int hashCode() {
        return (Cbor$Arg$$ExternalSyntheticBackport0.m(this.freezeThresholdInMillis) * 31) + this.maxAttemptBeforeFallback;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OtpWhatsAppConfigModel(freezeThresholdInMillis=");
        sb.append(this.freezeThresholdInMillis);
        sb.append(", maxAttemptBeforeFallback=");
        sb.append(this.maxAttemptBeforeFallback);
        sb.append(')');
        return sb.toString();
    }

    public OtpWhatsAppConfigModel(long j, int i) {
        this.freezeThresholdInMillis = j;
        this.maxAttemptBeforeFallback = i;
    }

    public /* synthetic */ OtpWhatsAppConfigModel(long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 3600000L : j, (i2 & 2) != 0 ? 3 : i);
    }

    @JvmName(name = "getFreezeThresholdInMillis")
    public final long getFreezeThresholdInMillis() {
        return this.freezeThresholdInMillis;
    }

    @JvmName(name = "getMaxAttemptBeforeFallback")
    public final int getMaxAttemptBeforeFallback() {
        return this.maxAttemptBeforeFallback;
    }
}

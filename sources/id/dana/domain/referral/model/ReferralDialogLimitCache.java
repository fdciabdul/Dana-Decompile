package id.dana.domain.referral.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007"}, d2 = {"Lid/dana/domain/referral/model/ReferralDialogLimitCache;", "", "", "component1", "()J", "", "component2", "()I", "lastTimeShown", "numberOfDialogShowToday", "copy", "(JI)Lid/dana/domain/referral/model/ReferralDialogLimitCache;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "J", "getLastTimeShown", "I", "getNumberOfDialogShowToday", "<init>", "(JI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ReferralDialogLimitCache {
    private final long lastTimeShown;
    private final int numberOfDialogShowToday;

    public static /* synthetic */ ReferralDialogLimitCache copy$default(ReferralDialogLimitCache referralDialogLimitCache, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = referralDialogLimitCache.lastTimeShown;
        }
        if ((i2 & 2) != 0) {
            i = referralDialogLimitCache.numberOfDialogShowToday;
        }
        return referralDialogLimitCache.copy(j, i);
    }

    /* renamed from: component1  reason: from getter */
    public final long getLastTimeShown() {
        return this.lastTimeShown;
    }

    /* renamed from: component2  reason: from getter */
    public final int getNumberOfDialogShowToday() {
        return this.numberOfDialogShowToday;
    }

    public final ReferralDialogLimitCache copy(long lastTimeShown, int numberOfDialogShowToday) {
        return new ReferralDialogLimitCache(lastTimeShown, numberOfDialogShowToday);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ReferralDialogLimitCache) {
            ReferralDialogLimitCache referralDialogLimitCache = (ReferralDialogLimitCache) other;
            return this.lastTimeShown == referralDialogLimitCache.lastTimeShown && this.numberOfDialogShowToday == referralDialogLimitCache.numberOfDialogShowToday;
        }
        return false;
    }

    public final int hashCode() {
        return (Cbor$Arg$$ExternalSyntheticBackport0.m(this.lastTimeShown) * 31) + this.numberOfDialogShowToday;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReferralDialogLimitCache(lastTimeShown=");
        sb.append(this.lastTimeShown);
        sb.append(", numberOfDialogShowToday=");
        sb.append(this.numberOfDialogShowToday);
        sb.append(')');
        return sb.toString();
    }

    public ReferralDialogLimitCache(long j, int i) {
        this.lastTimeShown = j;
        this.numberOfDialogShowToday = i;
    }

    @JvmName(name = "getLastTimeShown")
    public final long getLastTimeShown() {
        return this.lastTimeShown;
    }

    @JvmName(name = "getNumberOfDialogShowToday")
    public final int getNumberOfDialogShowToday() {
        return this.numberOfDialogShowToday;
    }
}

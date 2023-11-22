package id.dana.domain.referral.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001a\u0010\r\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\n"}, d2 = {"Lid/dana/domain/referral/model/ReferralEngagementDialogCache;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "", "component3", "()J", "scenario", "showHomeReferralPopup", "showPopUpTimerSeed", "copy", "(Ljava/lang/String;ZJ)Lid/dana/domain/referral/model/ReferralEngagementDialogCache;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getScenario", "Z", "getShowHomeReferralPopup", "J", "getShowPopUpTimerSeed", "<init>", "(Ljava/lang/String;ZJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ReferralEngagementDialogCache {
    private final String scenario;
    private final boolean showHomeReferralPopup;
    private final long showPopUpTimerSeed;

    public static /* synthetic */ ReferralEngagementDialogCache copy$default(ReferralEngagementDialogCache referralEngagementDialogCache, String str, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = referralEngagementDialogCache.scenario;
        }
        if ((i & 2) != 0) {
            z = referralEngagementDialogCache.showHomeReferralPopup;
        }
        if ((i & 4) != 0) {
            j = referralEngagementDialogCache.showPopUpTimerSeed;
        }
        return referralEngagementDialogCache.copy(str, z, j);
    }

    /* renamed from: component1  reason: from getter */
    public final String getScenario() {
        return this.scenario;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getShowHomeReferralPopup() {
        return this.showHomeReferralPopup;
    }

    /* renamed from: component3  reason: from getter */
    public final long getShowPopUpTimerSeed() {
        return this.showPopUpTimerSeed;
    }

    public final ReferralEngagementDialogCache copy(String scenario, boolean showHomeReferralPopup, long showPopUpTimerSeed) {
        Intrinsics.checkNotNullParameter(scenario, "");
        return new ReferralEngagementDialogCache(scenario, showHomeReferralPopup, showPopUpTimerSeed);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ReferralEngagementDialogCache) {
            ReferralEngagementDialogCache referralEngagementDialogCache = (ReferralEngagementDialogCache) other;
            return Intrinsics.areEqual(this.scenario, referralEngagementDialogCache.scenario) && this.showHomeReferralPopup == referralEngagementDialogCache.showHomeReferralPopup && this.showPopUpTimerSeed == referralEngagementDialogCache.showPopUpTimerSeed;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.scenario.hashCode();
        boolean z = this.showHomeReferralPopup;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((hashCode * 31) + i) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.showPopUpTimerSeed);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReferralEngagementDialogCache(scenario=");
        sb.append(this.scenario);
        sb.append(", showHomeReferralPopup=");
        sb.append(this.showHomeReferralPopup);
        sb.append(", showPopUpTimerSeed=");
        sb.append(this.showPopUpTimerSeed);
        sb.append(')');
        return sb.toString();
    }

    public ReferralEngagementDialogCache(String str, boolean z, long j) {
        Intrinsics.checkNotNullParameter(str, "");
        this.scenario = str;
        this.showHomeReferralPopup = z;
        this.showPopUpTimerSeed = j;
    }

    @JvmName(name = "getScenario")
    public final String getScenario() {
        return this.scenario;
    }

    @JvmName(name = "getShowHomeReferralPopup")
    public final boolean getShowHomeReferralPopup() {
        return this.showHomeReferralPopup;
    }

    @JvmName(name = "getShowPopUpTimerSeed")
    public final long getShowPopUpTimerSeed() {
        return this.showPopUpTimerSeed;
    }
}

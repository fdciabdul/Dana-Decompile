package id.dana.domain.referral.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JV\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0010J\u0010\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0007R\u0017\u0010\u0017\u001a\u00020\u000e8\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u001f\u001a\u0004\b \u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b\"\u0010\u0007R\u001a\u0010\u0014\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b#\u0010\u0007R\u001a\u0010\u0013\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b$\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b%\u0010\u0007R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\r"}, d2 = {"Lid/dana/domain/referral/model/ReferralEngagementDialogConfig;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "", "component6", "()J", "", "component7", "()I", "enable", "dialogTitleId", "dialogTitleEn", "dialogDescriptionId", "dialogDescriptionEn", "timerDuration", "dailyLimit", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)Lid/dana/domain/referral/model/ReferralEngagementDialogConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getDailyLimit", "Ljava/lang/String;", "getDialogDescriptionEn", "getDialogDescriptionId", "getDialogTitleEn", "getDialogTitleId", "Z", "getEnable", "J", "getTimerDuration", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ReferralEngagementDialogConfig {
    private final int dailyLimit;
    private final String dialogDescriptionEn;
    private final String dialogDescriptionId;
    private final String dialogTitleEn;
    private final String dialogTitleId;
    private final boolean enable;
    private final long timerDuration;

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final String getDialogTitleId() {
        return this.dialogTitleId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getDialogTitleEn() {
        return this.dialogTitleEn;
    }

    /* renamed from: component4  reason: from getter */
    public final String getDialogDescriptionId() {
        return this.dialogDescriptionId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getDialogDescriptionEn() {
        return this.dialogDescriptionEn;
    }

    /* renamed from: component6  reason: from getter */
    public final long getTimerDuration() {
        return this.timerDuration;
    }

    /* renamed from: component7  reason: from getter */
    public final int getDailyLimit() {
        return this.dailyLimit;
    }

    public final ReferralEngagementDialogConfig copy(boolean enable, String dialogTitleId, String dialogTitleEn, String dialogDescriptionId, String dialogDescriptionEn, long timerDuration, int dailyLimit) {
        Intrinsics.checkNotNullParameter(dialogTitleId, "");
        Intrinsics.checkNotNullParameter(dialogTitleEn, "");
        Intrinsics.checkNotNullParameter(dialogDescriptionId, "");
        Intrinsics.checkNotNullParameter(dialogDescriptionEn, "");
        return new ReferralEngagementDialogConfig(enable, dialogTitleId, dialogTitleEn, dialogDescriptionId, dialogDescriptionEn, timerDuration, dailyLimit);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ReferralEngagementDialogConfig) {
            ReferralEngagementDialogConfig referralEngagementDialogConfig = (ReferralEngagementDialogConfig) other;
            return this.enable == referralEngagementDialogConfig.enable && Intrinsics.areEqual(this.dialogTitleId, referralEngagementDialogConfig.dialogTitleId) && Intrinsics.areEqual(this.dialogTitleEn, referralEngagementDialogConfig.dialogTitleEn) && Intrinsics.areEqual(this.dialogDescriptionId, referralEngagementDialogConfig.dialogDescriptionId) && Intrinsics.areEqual(this.dialogDescriptionEn, referralEngagementDialogConfig.dialogDescriptionEn) && this.timerDuration == referralEngagementDialogConfig.timerDuration && this.dailyLimit == referralEngagementDialogConfig.dailyLimit;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((((r0 * 31) + this.dialogTitleId.hashCode()) * 31) + this.dialogTitleEn.hashCode()) * 31) + this.dialogDescriptionId.hashCode()) * 31) + this.dialogDescriptionEn.hashCode()) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.timerDuration)) * 31) + this.dailyLimit;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReferralEngagementDialogConfig(enable=");
        sb.append(this.enable);
        sb.append(", dialogTitleId=");
        sb.append(this.dialogTitleId);
        sb.append(", dialogTitleEn=");
        sb.append(this.dialogTitleEn);
        sb.append(", dialogDescriptionId=");
        sb.append(this.dialogDescriptionId);
        sb.append(", dialogDescriptionEn=");
        sb.append(this.dialogDescriptionEn);
        sb.append(", timerDuration=");
        sb.append(this.timerDuration);
        sb.append(", dailyLimit=");
        sb.append(this.dailyLimit);
        sb.append(')');
        return sb.toString();
    }

    public ReferralEngagementDialogConfig(boolean z, String str, String str2, String str3, String str4, long j, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.enable = z;
        this.dialogTitleId = str;
        this.dialogTitleEn = str2;
        this.dialogDescriptionId = str3;
        this.dialogDescriptionEn = str4;
        this.timerDuration = j;
        this.dailyLimit = i;
    }

    @JvmName(name = "getDialogTitleId")
    public final String getDialogTitleId() {
        return this.dialogTitleId;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getDialogTitleEn")
    public final String getDialogTitleEn() {
        return this.dialogTitleEn;
    }

    @JvmName(name = "getDialogDescriptionId")
    public final String getDialogDescriptionId() {
        return this.dialogDescriptionId;
    }

    @JvmName(name = "getDialogDescriptionEn")
    public final String getDialogDescriptionEn() {
        return this.dialogDescriptionEn;
    }

    @JvmName(name = "getTimerDuration")
    public final long getTimerDuration() {
        return this.timerDuration;
    }

    @JvmName(name = "getDailyLimit")
    public final int getDailyLimit() {
        return this.dailyLimit;
    }
}

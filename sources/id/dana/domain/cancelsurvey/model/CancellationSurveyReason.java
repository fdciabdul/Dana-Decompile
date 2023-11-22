package id.dana.domain.cancelsurvey.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B3\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J>\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007R\u0017\u0010\u0010\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001e\u0010\u0007R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u000b"}, d2 = {"Lid/dana/domain/cancelsurvey/model/CancellationSurveyReason;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "", "Lid/dana/domain/cancelsurvey/model/CancelReason;", "component3", "()Ljava/util/List;", "component4", "enable", "headerLabel", "reasons", "ctaLabel", "copy", "(ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;)Lid/dana/domain/cancelsurvey/model/CancellationSurveyReason;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCtaLabel", "Z", "getEnable", "getHeaderLabel", "Ljava/util/List;", "getReasons", "<init>", "(ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CancellationSurveyReason {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String ctaLabel;
    private final boolean enable;
    private final String headerLabel;
    private final List<CancelReason> reasons;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CancellationSurveyReason copy$default(CancellationSurveyReason cancellationSurveyReason, boolean z, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = cancellationSurveyReason.enable;
        }
        if ((i & 2) != 0) {
            str = cancellationSurveyReason.headerLabel;
        }
        if ((i & 4) != 0) {
            list = cancellationSurveyReason.reasons;
        }
        if ((i & 8) != 0) {
            str2 = cancellationSurveyReason.ctaLabel;
        }
        return cancellationSurveyReason.copy(z, str, list, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final String getHeaderLabel() {
        return this.headerLabel;
    }

    public final List<CancelReason> component3() {
        return this.reasons;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCtaLabel() {
        return this.ctaLabel;
    }

    public final CancellationSurveyReason copy(boolean enable, String headerLabel, List<CancelReason> reasons, String ctaLabel) {
        Intrinsics.checkNotNullParameter(headerLabel, "");
        Intrinsics.checkNotNullParameter(reasons, "");
        Intrinsics.checkNotNullParameter(ctaLabel, "");
        return new CancellationSurveyReason(enable, headerLabel, reasons, ctaLabel);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CancellationSurveyReason) {
            CancellationSurveyReason cancellationSurveyReason = (CancellationSurveyReason) other;
            return this.enable == cancellationSurveyReason.enable && Intrinsics.areEqual(this.headerLabel, cancellationSurveyReason.headerLabel) && Intrinsics.areEqual(this.reasons, cancellationSurveyReason.reasons) && Intrinsics.areEqual(this.ctaLabel, cancellationSurveyReason.ctaLabel);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((r0 * 31) + this.headerLabel.hashCode()) * 31) + this.reasons.hashCode()) * 31) + this.ctaLabel.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CancellationSurveyReason(enable=");
        sb.append(this.enable);
        sb.append(", headerLabel=");
        sb.append(this.headerLabel);
        sb.append(", reasons=");
        sb.append(this.reasons);
        sb.append(", ctaLabel=");
        sb.append(this.ctaLabel);
        sb.append(')');
        return sb.toString();
    }

    public CancellationSurveyReason(boolean z, String str, List<CancelReason> list, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.enable = z;
        this.headerLabel = str;
        this.reasons = list;
        this.ctaLabel = str2;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getHeaderLabel")
    public final String getHeaderLabel() {
        return this.headerLabel;
    }

    public /* synthetic */ CancellationSurveyReason(boolean z, String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? "" : str2);
    }

    @JvmName(name = "getReasons")
    public final List<CancelReason> getReasons() {
        return this.reasons;
    }

    @JvmName(name = "getCtaLabel")
    public final String getCtaLabel() {
        return this.ctaLabel;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/domain/cancelsurvey/model/CancellationSurveyReason$Companion;", "", "Lid/dana/domain/cancelsurvey/model/CancellationSurveyReason;", "noSurvey", "()Lid/dana/domain/cancelsurvey/model/CancellationSurveyReason;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CancellationSurveyReason noSurvey() {
            return new CancellationSurveyReason(false, null, null, null, 14, null);
        }
    }
}

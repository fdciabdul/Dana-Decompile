package id.dana.domain.tracker;

import id.dana.analytics.tracker.TrackerKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R\"\u0010\u000e\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u001cR\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u001cR\"\u0010\r\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001f\u001a\u0004\b\r\u0010\b\"\u0004\b \u0010!R\"\u0010\u000b\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010\u001cR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b$\u0010\u0004\"\u0004\b%\u0010\u001c"}, d2 = {"Lid/dana/domain/tracker/HereMixPanelTrackerData;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "component5", "source", "usage", TrackerKey.Property.IS_SUCCESS, "errorCode", "failReason", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)Lid/dana/domain/tracker/HereMixPanelTrackerData;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getErrorCode", "setErrorCode", "(Ljava/lang/String;)V", "getFailReason", "setFailReason", "Z", "setSuccess", "(Z)V", "getSource", "setSource", "getUsage", "setUsage", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class HereMixPanelTrackerData {
    private String errorCode;
    private String failReason;
    private boolean isSuccess;
    private String source;
    private String usage;

    public HereMixPanelTrackerData() {
        this(null, null, false, null, null, 31, null);
    }

    public static /* synthetic */ HereMixPanelTrackerData copy$default(HereMixPanelTrackerData hereMixPanelTrackerData, String str, String str2, boolean z, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hereMixPanelTrackerData.source;
        }
        if ((i & 2) != 0) {
            str2 = hereMixPanelTrackerData.usage;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            z = hereMixPanelTrackerData.isSuccess;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str3 = hereMixPanelTrackerData.errorCode;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = hereMixPanelTrackerData.failReason;
        }
        return hereMixPanelTrackerData.copy(str, str5, z2, str6, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* renamed from: component2  reason: from getter */
    public final String getUsage() {
        return this.usage;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* renamed from: component4  reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component5  reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    public final HereMixPanelTrackerData copy(String source, String usage, boolean isSuccess, String errorCode, String failReason) {
        Intrinsics.checkNotNullParameter(source, "");
        Intrinsics.checkNotNullParameter(usage, "");
        Intrinsics.checkNotNullParameter(errorCode, "");
        Intrinsics.checkNotNullParameter(failReason, "");
        return new HereMixPanelTrackerData(source, usage, isSuccess, errorCode, failReason);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof HereMixPanelTrackerData) {
            HereMixPanelTrackerData hereMixPanelTrackerData = (HereMixPanelTrackerData) other;
            return Intrinsics.areEqual(this.source, hereMixPanelTrackerData.source) && Intrinsics.areEqual(this.usage, hereMixPanelTrackerData.usage) && this.isSuccess == hereMixPanelTrackerData.isSuccess && Intrinsics.areEqual(this.errorCode, hereMixPanelTrackerData.errorCode) && Intrinsics.areEqual(this.failReason, hereMixPanelTrackerData.failReason);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.source.hashCode();
        int hashCode2 = this.usage.hashCode();
        boolean z = this.isSuccess;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + this.errorCode.hashCode()) * 31) + this.failReason.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HereMixPanelTrackerData(source=");
        sb.append(this.source);
        sb.append(", usage=");
        sb.append(this.usage);
        sb.append(", isSuccess=");
        sb.append(this.isSuccess);
        sb.append(", errorCode=");
        sb.append(this.errorCode);
        sb.append(", failReason=");
        sb.append(this.failReason);
        sb.append(')');
        return sb.toString();
    }

    public HereMixPanelTrackerData(String str, String str2, boolean z, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.source = str;
        this.usage = str2;
        this.isSuccess = z;
        this.errorCode = str3;
        this.failReason = str4;
    }

    public /* synthetic */ HereMixPanelTrackerData(String str, String str2, boolean z, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4);
    }

    @JvmName(name = "getSource")
    public final String getSource() {
        return this.source;
    }

    @JvmName(name = "setSource")
    public final void setSource(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.source = str;
    }

    @JvmName(name = "getUsage")
    public final String getUsage() {
        return this.usage;
    }

    @JvmName(name = "setUsage")
    public final void setUsage(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.usage = str;
    }

    @JvmName(name = TrackerKey.Property.IS_SUCCESS)
    public final boolean isSuccess() {
        return this.isSuccess;
    }

    @JvmName(name = "setSuccess")
    public final void setSuccess(boolean z) {
        this.isSuccess = z;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    @JvmName(name = "setErrorCode")
    public final void setErrorCode(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.errorCode = str;
    }

    @JvmName(name = "getFailReason")
    public final String getFailReason() {
        return this.failReason;
    }

    @JvmName(name = "setFailReason")
    public final void setFailReason(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.failReason = str;
    }
}

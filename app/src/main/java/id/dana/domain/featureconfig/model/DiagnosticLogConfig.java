package id.dana.domain.featureconfig.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/domain/featureconfig/model/DiagnosticLogConfig;", "", "", "enabled", "Z", "getEnabled", "()Z", "firebase", "getFirebase", "", "lastUpdatedTime", "Ljava/lang/Long;", "getLastUpdatedTime", "()Ljava/lang/Long;", "setLastUpdatedTime", "(Ljava/lang/Long;)V", "Lid/dana/domain/featureconfig/model/SplunkConfig;", "splunkConfig", "Lid/dana/domain/featureconfig/model/SplunkConfig;", "getSplunkConfig", "()Lid/dana/domain/featureconfig/model/SplunkConfig;", "<init>", "(ZZLid/dana/domain/featureconfig/model/SplunkConfig;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DiagnosticLogConfig {
    public boolean enabled;
    public boolean firebase;
    public Long lastUpdatedTime;
    public SplunkConfig splunkConfig;

    public DiagnosticLogConfig() {
        this(false, false, null, null, 15, null);
    }

    public DiagnosticLogConfig(boolean z, boolean z2, SplunkConfig splunkConfig, Long l) {
        Intrinsics.checkNotNullParameter(splunkConfig, "");
        this.enabled = z;
        this.firebase = z2;
        this.splunkConfig = splunkConfig;
        this.lastUpdatedTime = l;
    }

    @JvmName(name = "getEnabled")
    public final boolean getEnabled() {
        return this.enabled;
    }

    @JvmName(name = "getFirebase")
    public final boolean getFirebase() {
        return this.firebase;
    }

    public /* synthetic */ DiagnosticLogConfig(boolean z, boolean z2, SplunkConfig splunkConfig, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? new SplunkConfig(false, false, false) : splunkConfig, (i & 8) != 0 ? null : l);
    }

    @JvmName(name = "getSplunkConfig")
    public final SplunkConfig getSplunkConfig() {
        return this.splunkConfig;
    }

    @JvmName(name = "getLastUpdatedTime")
    public final Long getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    @JvmName(name = "setLastUpdatedTime")
    public final void setLastUpdatedTime(Long l) {
        this.lastUpdatedTime = l;
    }
}

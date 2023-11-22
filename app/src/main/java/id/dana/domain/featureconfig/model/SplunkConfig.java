package id.dana.domain.featureconfig.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/domain/featureconfig/model/SplunkConfig;", "", "", "enabled", "Z", "getEnabled", "()Z", "h5NetworkInstrumentation", "getH5NetworkInstrumentation", "networkInstrumentation", "getNetworkInstrumentation", "<init>", "(ZZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SplunkConfig {
    public boolean enabled;
    public boolean h5NetworkInstrumentation;
    public boolean networkInstrumentation;

    public /* synthetic */ SplunkConfig() {
    }

    public SplunkConfig(boolean z, boolean z2, boolean z3) {
        this.enabled = z;
        this.networkInstrumentation = z2;
        this.h5NetworkInstrumentation = z3;
    }

    @JvmName(name = "getEnabled")
    public final boolean getEnabled() {
        return this.enabled;
    }

    @JvmName(name = "getNetworkInstrumentation")
    public final boolean getNetworkInstrumentation() {
        return this.networkInstrumentation;
    }

    @JvmName(name = "getH5NetworkInstrumentation")
    public final boolean getH5NetworkInstrumentation() {
        return this.h5NetworkInstrumentation;
    }
}
